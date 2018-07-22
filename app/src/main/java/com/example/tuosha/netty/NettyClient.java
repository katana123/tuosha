package com.example.tuosha.netty;

import com.example.tuosha.Utils.Protocols;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * Created by Helen on 2014/10/24.
 */
public class NettyClient {

    private final String CLIENT_CREATED = "客户端创建成功";
    private final String CLIENT_CONNCET = "客户端连接服务器地址为";
    private final String CLIENT_DISPOSED = "客户端处理完成";
    private final String DECODER = "decoder";
    private final String ENCODER = "encoder";
    private final String CLIENTHANDLER = "clientHandler";
    private final String IDLESTATEHANDLER = "idleStateHandler";

    private class ClientHandler extends ChannelDuplexHandler {

        public void channelActive(final ChannelHandlerContext ctx) throws Exception {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                netListenerArrayList.get(i).channelActive(ctx);
            }
        }

        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                netListenerArrayList.get(i).channelInactive(ctx);
            }
        }

        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                netListenerArrayList.get(i).channelRead(ctx, msg);
            }
        }

        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                netListenerArrayList.get(i).exceptionCaught(ctx, cause);
            }
        }

        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                netListenerArrayList.get(i).userEventTriggered(ctx, evt);
            }
        }
    }

    private ArrayList<NetListener> netListenerArrayList;
    private ArrayList<ChannelFutureListener> channelFutureListenerArrayList;
    private EventLoopGroup workerGroup;
    private Bootstrap bootstrap;
    private Channel channel;

    public NettyClient() {
        netListenerArrayList = new ArrayList<NetListener>();
        channelFutureListenerArrayList = new ArrayList<ChannelFutureListener>();
        workerGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        bootstrap.option(ChannelOption.SO_RCVBUF, Protocols.NET_TCP_BUFFER);
        bootstrap.option(ChannelOption.SO_SNDBUF, Protocols.NET_TCP_BUFFER);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) {
                channel.pipeline().addLast(DECODER, new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                channel.pipeline().addLast(ENCODER, new LengthFieldPrepender(4));
                channel.pipeline().addLast(IDLESTATEHANDLER,
                        new IdleStateHandler(Protocols.IMCG_HEARTBEAT_READ_PERIOD_SECONDS,
                                Protocols.IMCG_HEARTBEAT_WRITE_PERIOD_SECONDS,
                                0, TimeUnit.SECONDS));
                channel.pipeline().addLast(CLIENTHANDLER, new ClientHandler());
            }
        });

        System.out.println(CLIENT_CREATED);
    }

    public void connect() {
        System.out.println(CLIENT_CONNCET + ":" + Protocols.TCP_SERVER_ADDRESS + ":" + Protocols.TCP_SERVER_PORT);
        ChannelFuture channelFuture =
                bootstrap.connect(Protocols.TCP_SERVER_ADDRESS,
                        Protocols.TCP_SERVER_PORT);
        System.out.println("yhf test...");
//        channel = channelFuture.sync().channel();
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                channel = future.channel();
                for (int i = 0; i < channelFutureListenerArrayList.size(); i++) {
                    channelFutureListenerArrayList.get(i).operationComplete(future);
                }
            }
        });
    }

    public void close() {
        if (channel != null) {
            channel.close();
            channel = null;
        }
    }

    public void dispose() {
        netListenerArrayList.clear();
        workerGroup.shutdownGracefully();
        System.out.println(CLIENT_DISPOSED);
    }

    public void addNetClientListener(NetListener netListener) {
        if (netListener != null) {
            netListenerArrayList.add(netListener);
        }
    }

    public void removeNetclientLlistener(NetListener netListener) {
        if (netListener != null) {
            for (int i = 0; i < netListenerArrayList.size(); i++) {
                NetListener netListener1 = netListenerArrayList.get(i);
                if (netListener1 != null && netListener1.equals(netListener)) {
                    netListenerArrayList.remove(netListener);
                    break;
                }
            }
        }
    }

    public void addChannelFutureListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            channelFutureListenerArrayList.add(channelFutureListener);
        }
    }

    public void removeChannelFutureListener(ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            for (int i = 0; i < channelFutureListenerArrayList.size(); i++) {
                ChannelFutureListener channelFutureListener1 = channelFutureListenerArrayList.get(i);
                if (channelFutureListener1 != null && channelFutureListener1.equals(channelFutureListener)) {
                    channelFutureListenerArrayList.remove(channelFutureListener);
                    break;
                }
            }
        }
    }

    public void sendMessage(ByteBuf byteBuf) {
        channel.writeAndFlush(byteBuf);
    }
}
