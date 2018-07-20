package com.example.tuosha.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.example.tuosha.Utils.Constants;


/**
 * Created by Helen on 2014/10/24.
 */
public class IMCGClient {

    private final String CLIENT_CREATED = "客户端创建成功";
    private final String CLIENT_CONNCET = "客户端连接服务器地址为";
    private final String CLIENT_DISPOSED = "客户端处理完成";
    private final String DECODER = "decoder";
    private final String ENCODER = "encoder";
    private final String CLIENTHANDLER = "clientHandler";
    private final String IDLESTATEHANDLER = "idleStateHandler";

    /**
     * 内部类 - 服务端网络事件处理器
     */
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

    public IMCGClient() throws Exception {
        netListenerArrayList = new ArrayList<NetListener>();
        channelFutureListenerArrayList = new ArrayList<ChannelFutureListener>();
        workerGroup = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class); // 指定 channel 类型为 tcp 协议 nio channel
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        bootstrap.option(ChannelOption.SO_RCVBUF, Constants.NET_TCP_BUFFER);
        bootstrap.option(ChannelOption.SO_SNDBUF, Constants.NET_TCP_BUFFER);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline().addLast(DECODER, new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                channel.pipeline().addLast(ENCODER, new LengthFieldPrepender(4));
                channel.pipeline().addLast(IDLESTATEHANDLER,
                        new IdleStateHandler(Constants.IMCG_HEARTBEAT_READ_PERIOD_SECONDS,
                                Constants.IMCG_HEARTBEAT_WRITE_PERIOD_SECONDS,
                                0, TimeUnit.SECONDS));
                channel.pipeline().addLast(CLIENTHANDLER, new ClientHandler());
            }
        });

        System.out.println(CLIENT_CREATED);
    }

    /* 特别说明，如何实现异步的 connect 以及失败自动重连？
     * 不要用 await 之类的方法进行阻塞模式等待。可以直接使用
     * ChannelFuture 的 addListener 增加 ChannelFuture 监听
     * 器，利用监听器来判断是否 success，如果是则表示连接成功，
     * 否则表示连接失败。经过实际测试，如果连接失败，监听器事件
     * 会被立即调用并返回失败。
     */
    public void connect() throws Exception {
        System.out.println(CLIENT_CONNCET+":"+Constants.TCP_SERVER_ADDRESS+":"+Constants.TCP_SERVER_PORT);
        ChannelFuture channelFuture =
                bootstrap.connect(Constants.TCP_SERVER_ADDRESS,
                        Constants.TCP_SERVER_PORT);
        System.out.println("yhf test...");
//        channel = channelFuture.sync().channel();
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                channel = future.channel(); // 在自己的监听处理中获得 channel
                // 调用其他的监听处理器
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

    public void sendMessage(ByteBuf byteBuf) throws Exception {
        channel.writeAndFlush(byteBuf);
    }
}
