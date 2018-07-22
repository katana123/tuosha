package com.example.tuosha.netty;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuosha.KouziActivity;
import com.example.tuosha.KouziAdapter;
import com.example.tuosha.MainActivity;
import com.example.tuosha.Utils.NetWorkImpl;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.INFOCOLT;
import com.example.tuosha.model.KouziBean;

import java.util.ArrayList;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by Helen on 2014/10/24.
 */
public class NettyClientHandler implements NetListener, ChannelFutureListener {

    private final String CLIENT_CONNCET_SUCCESS = "客户端连接服务器成功";
    private final String CLIENT_CONNCET_FAIL = "客户端连接服务器失败";
    private final String HANDLER_CHANNELACTIVE = "客户端处理器channelActive被调用";
    private final String HANDLER_CHANNELINACTIVE = "客户端处理器channelInactive被调用";
    private final String HANDLER_CHANNELREAD = "客户端处理器channelRead被调用";
    private final String HANDLER_CHANNELREAD_ERROR = "客户端处理器channelRead发生错误";
    private final String HANDLER_EXCEPTION_CAUGHT = "客户端处理器exceptionCaught被调用";

    //    private InfoColCient infoColCient;
    private NettyClient nettyClient;
    private volatile boolean shouldReconncet = false;
    private volatile boolean shouldRelogin = false;
    private CustomApplication customapplication;

    public NettyClientHandler(CustomApplication c) {
        // TODO Auto-generated constructor stub
        customapplication = c;
    }

    public boolean start() {
        boolean sok = false;
        if (nettyClient != null) {
            nettyClient.dispose();
        }
        try {
            nettyClient = new NettyClient();
            nettyClient.addChannelFutureListener(this);
            nettyClient.addNetClientListener(this);
            nettyClient.connect();
            sok = true;
        } catch (Exception e) {
            sok = false;
            System.out.println(CLIENT_CONNCET_FAIL + ":" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return sok;
    }

    public void disposeInfoColClient() {
        if (nettyClient != null) {
            nettyClient.dispose();
            nettyClient = null;
        }
    }

    public boolean sendMsg(Object o) throws Exception {
        boolean sok = false;
        if (o == null) {
            sok = false;
        } else {
            byte[] netClientSerializableObjectBytes = new NetWorkImpl().getByteData(o);
            ByteBuf byteBuf = Unpooled.buffer(4 + netClientSerializableObjectBytes.length);
            byteBuf.writeInt(netClientSerializableObjectBytes.length);
            byteBuf.writeBytes(netClientSerializableObjectBytes);
            nettyClient.sendMessage(byteBuf);
            sok = true;
        }
        return sok;
    }

    /**
     * 实现 ChannelFutureListener 接口的方法
     *
     * @param channelFuture
     * @throws Exception
     */
    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (channelFuture.isSuccess()) {
            // NetMailMobileTCPClient connect 成功
            System.out.println(CLIENT_CONNCET_SUCCESS);
        } else {
            // NetMailMobileTCPClient connect 失败
            System.out.println(CLIENT_CONNCET_FAIL);
//            Channel channel = channelFuture.channel();
//            if (channel != null) {
//                channel.close();
//            }
            Thread.sleep(500);

            nettyClient.connect();
        }
    }

    /**
     * 实现 NetListener 接口的方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(HANDLER_CHANNELACTIVE);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println(HANDLER_CHANNELINACTIVE);
        if (shouldReconncet) {
//            if (infoColCient == null) {
//                boolean sok = start();
//            }
//            new Thread() {
//                public void run() {
//                    try {
//                        infoColCient.connect();
//                    } catch (Exception e) {
//                        // do nothing
//                    }
//                }
//            }.start();
            if (nettyClient != null) {
                nettyClient.dispose();
            }
            new Thread() {
                @Override
                public void run() {
                    try {
                        nettyClient = new NettyClient();
                        nettyClient.addChannelFutureListener(NettyClientHandler.this);
                        nettyClient.addNetClientListener(NettyClientHandler.this);
                        nettyClient.connect();
//                        sok = true;
                    } catch (Exception e) {
//                        sok = false;
                        System.out.println(CLIENT_CONNCET_FAIL + ":" + e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
            }.start();
        }
//        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(HANDLER_CHANNELREAD);
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            int infocolLength = byteBuf.readInt();
            byte[] infocolBytes = new byte[infocolLength];
            byteBuf.readBytes(infocolBytes);
            final INFOCOLT imcg = (INFOCOLT) new NetWorkImpl().getObj(infocolBytes);
            INFOCOLT resposeimcg = new INFOCOLT();
//            String clientIPAddress = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
            // 首先获取指令
            byte netCommand = imcg.getRecommand();
            switch (netCommand) {
                case Protocols.LOGIN:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            //服务端返回值：0表示用户不存在，1表示登录成功，2表示密码错误
                            if (imcg.getResult() == (byte) 1) {
                                Toast.makeText(customapplication.getLoginActivity(), "登陆成功！",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.setClass(customapplication.getLoginActivity(), MainActivity.class);
                                customapplication.getLoginActivity().startActivity(intent);
                                customapplication.getLoginActivity().finish();
                                System.out.println("INFOCOL_LINKING_SUC");
                            } else if (imcg.getResult() == (byte) 0) {
                                System.out.println("INFOCOL_LINKING_FAIL");
                                Toast.makeText(customapplication.getLoginActivity(), "用户名不存在！",
                                        Toast.LENGTH_SHORT).show();
                            } else if (imcg.getResult() == (byte) 2) {
                                System.out.println("INFOCOL_LINKING_FAIL");
                                Toast.makeText(customapplication.getLoginActivity(), "密码错误！",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
                case Protocols.KOUZILIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<KouziBean> KouziList = imcg.getKouziBean();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setList(KouziList);
                        }
                    });
                    break;
                case Protocols.KOUZISECONDLIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<KouziBean> KouziList = imcg.getKouziBean();
                            System.out.println(imcg.toString());
                            CustomApplication application = CustomApplication.getInstance();
                            application.setSecondlist(KouziList);
                        }
                    });
                    break;
                case Protocols.CONTENTLIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<ContentBean> ContentList = imcg.getContentBean();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setContentList(ContentList);
                        }
                    });
                    break;
                case Protocols.CONTENTLISTBYID:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<ContentBean> ContentList = imcg.getContentBean();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setContentSecondList(ContentList);
                        }
                    });
                    break;
/*//                case Constants.INFOCOL_LINKING_SUC:
//                    System.out.println("INFOCOL_LINKING_SUC");
//                    break;
//                case Constants.INFOCOL_LINKING_FAIL:
//                    System.out.println("INFOCOL_LINKING_FAIL");
//                    break;
                case Protocols.IMCG_HEARTBEAT:
//                    心跳检测
                    System.out.println("INFOCOL_HEARTBEAT");
                    if (imcg.getRcommand() == Constants.IMCG_HEARTBEAT_SUC){
                        System.out.println("INFOCOL_HEARTBEAT_SUC");
                        responseinfoCol.setCommand(Constants.INFOCOL_HEARTBEAT);
                        byte[] resbytes = new NetWorkImpl().getByteData(responseinfoCol);
                        ByteBuf byteBuf1 =  ctx.alloc().buffer(4 + resbytes.length);
                        byteBuf1.writeInt(resbytes.length);
                        byteBuf1.writeBytes(resbytes);
                        ctx.writeAndFlush(byteBuf1);
                    } else if(imcg.getRcommand() == Constants.IMCG_HEARTBEAT_FAIL){
                        System.out.println("INFOCOL_HEARTBEAT_FAIL");
                    }
                    break;*/
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(HANDLER_CHANNELREAD_ERROR + ":" + e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            if (byteBuf != null) byteBuf.release();
        }
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        shouldReconncet = true;
        System.out.println(HANDLER_EXCEPTION_CAUGHT + ":" + cause.getLocalizedMessage());
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                shouldReconncet = true;
                System.out.println("Net file tcp client handler => userEventTriggered: heartbeat timeout, client removed," + ctx.channel());
                ctx.close();
            } else if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                INFOCOLT responseimcg = new INFOCOLT();
                responseimcg.setCommand(Protocols.HEART_BEAT);
//                responseInfoCol.setRcommand(Constants.INFOCOL_HEARTBEAT_SUC);
                byte[] resbytes = new NetWorkImpl().getByteData(responseimcg);
                ByteBuf byteBuf1 = ctx.alloc().buffer(4 + resbytes.length);
                byteBuf1.writeInt(resbytes.length);
                byteBuf1.writeBytes(resbytes);
                ctx.writeAndFlush(byteBuf1);
            }
        }
    }
}
