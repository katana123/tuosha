package com.example.tuosha.client;

import android.app.AlertDialog;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import com.example.tuosha.RegisterActivity;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.Utils.NetWorkImpl;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import static com.example.tuosha.client.CustomApplication.getMyApplication;

/**
 * Created by Helen on 2014/10/24.
 */
public class IMCGClientHandler implements  NetListener, ChannelFutureListener {

    private final String CLIENT_CONNCET_SUCCESS = "客户端连接服务器成功";
    private final String CLIENT_CONNCET_FAIL = "客户端连接服务器失败";
    private final String HANDLER_CHANNELACTIVE = "客户端处理器channelActive被调用";
    private final String HANDLER_CHANNELINACTIVE = "客户端处理器channelInactive被调用";
    private final String HANDLER_CHANNELREAD = "客户端处理器channelRead被调用";
    private final String HANDLER_CHANNELREAD_ERROR = "客户端处理器channelRead发生错误";
    private final String HANDLER_EXCEPTION_CAUGHT = "客户端处理器exceptionCaught被调用";

    //    private InfoColCient infoColCient;
    private IMCGClient imcgClient;
    private volatile boolean shouldReconncet = false;
    private volatile boolean shouldRelogin = false;
    private CustomApplication customApplication;
    private ChannelHandlerContext rebackctx;
    private Object rebackmsg;
    public IMCGClientHandler(CustomApplication c) {

        customApplication = c;
    }

    public IMCGClientHandler() {
    }

    public boolean start(){
        boolean sok = false;
        if (imcgClient != null){
            imcgClient.dispose();
        }
        try {
            imcgClient = new IMCGClient();
            imcgClient.addChannelFutureListener(this);
            imcgClient.addNetClientListener(this);
            imcgClient.connect();
            sok = true;
        } catch (Exception e) {
            sok = false;
            System.out.println(CLIENT_CONNCET_FAIL+":"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return sok;
    }

    public void disposeInfoColClient(){
        if (imcgClient != null){
            imcgClient.dispose();
            imcgClient = null;
        }
    }

    public boolean sendMsg(Object o) throws Exception {
        boolean sok = false;
        if (o == null){
            sok = false;
        } else {System.out.println("写入信息"+":"+o);
            byte[] netClientSerializableObjectBytes = new NetWorkImpl().getByteData(o);
            ByteBuf byteBuf = Unpooled.buffer(4 + netClientSerializableObjectBytes.length);
            byteBuf.writeInt(netClientSerializableObjectBytes.length);
            byteBuf.writeBytes(netClientSerializableObjectBytes);
            System.out.println("写入信息"+":"+netClientSerializableObjectBytes);
            imcgClient.sendMessage(byteBuf);
            sok = true;
        }
        return sok;
    }

    /**
     * 实现 ChannelFutureListener 接口的方法
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

            imcgClient.connect();
        }
    }

    /**
     * 实现 NetListener 接口的方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(HANDLER_CHANNELACTIVE);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
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
            if (imcgClient != null) {
                imcgClient.dispose();
            }
            new Thread(){
                @Override
                public void run() {
                    try {
                        imcgClient = new IMCGClient();
                        imcgClient.addChannelFutureListener(IMCGClientHandler.this);
                        imcgClient.addNetClientListener(IMCGClientHandler.this);
                        imcgClient.connect();
//                        sok = true;
                    } catch (Exception e) {
//                        sok = false;
                        System.out.println(CLIENT_CONNCET_FAIL+":"+e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                }
            }.start();
        }
//        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       System.out.println(HANDLER_CHANNELREAD);
         rebackctx = ctx;
        rebackmsg = msg;

        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            int infocolLength = byteBuf.readInt();
            byte[] infocolBytes = new byte[infocolLength];
            byteBuf.readBytes(infocolBytes);
            final SWbean imcg = (SWbean) new NetWorkImpl().getObj(infocolBytes);
            //SWbean resposeswbean = new SWbean();
//            String clientIPAddress = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
            // 首先获取指令

            int netCommand = imcg.getCommand();
            System.out.println(imcg.getCommand()+"----"+imcg.getRecommand());
            switch (netCommand) {
                case Constants.BANKLIST:
                    System.out.println("BANKLIST");
                    rebackctx = ctx;
                    rebackmsg = msg;
                  new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                        	if (imcg.getRecommand() == Constants.BANKLIST){
                                System.out.println("BANKLIST数据请求成功");
                                System.out.println(imcg.getProductList());
                                customApplication=(CustomApplication) getMyApplication();
                                customApplication.setProductEntityArrayList(imcg.getProductList());

                        	} else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("BANKLIST数据请求失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
                case Constants.BANKCARDLIST:
                    System.out.println("BANKCARDLIST");
                    rebackctx = ctx;
                    rebackmsg = msg;
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.BANKCARDLIST){
                                System.out.println("BANKCARDLIST数据请求成功");
                                System.out.println(imcg.getBankCardList());
                                customApplication=(CustomApplication) getMyApplication();
                                customApplication.setCardEntityArrayList(imcg.getBankCardList());

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("BANKLIST数据请求失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
                case Constants.PRODUCTEBITLIST:
                    System.out.println("PRODUCTEBITLIST");
                    rebackctx = ctx;
                    rebackmsg = msg;
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.PRODUCTEBITLIST){
                                System.out.println("PRODUCTEBITLISTT数据请求成功");
                                System.out.println(imcg.getProductList());
                                customApplication=(CustomApplication) getMyApplication();
                                customApplication.setProductEntityArrayList(imcg.getProductList());

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("PRODUCTEBITLIST数据请求失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
//                case Constants.INFOCOL_LINKING_SUC:
//                    System.out.println("INFOCOL_LINKING_SUC");
//                    break;
//                case Constants.INFOCOL_LINKING_FAIL:
//                    System.out.println("INFOCOL_LINKING_FAIL");
//                    break;
                case Constants.IMCG_HEARTBEAT:
//                    心跳检测
//                    System.out.println("INFOCOL_HEARTBEAT");
                    if (imcg.getRecommand() == Constants.IMCG_HEARTBEAT_SUC){
                        System.out.println("INFOCOL_HEARTBEAT_SUC");
//                        responseinfoCol.setCommand(Constants.INFOCOL_HEARTBEAT);
//                        byte[] resbytes = new NetWorkImpl().getByteData(responseinfoCol);
//                        ByteBuf byteBuf1 =  ctx.alloc().buffer(4 + resbytes.length);
//                        byteBuf1.writeInt(resbytes.length);
//                        byteBuf1.writeBytes(resbytes);
//                        ctx.writeAndFlush(byteBuf1);
                    } else if(imcg.getRecommand() == Constants.IMCG_HEARTBEAT_FAIL){
                        System.out.println("INFOCOL_HEARTBEAT_FAIL");
                    }
                    break;
                case Constants.IMCG_LINKING:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {
                            if(imcg.getRecommand()==Constants.IMCG_LINKING_SUC){
                                System.out.println("连接成功");
                            }else if(imcg.getRecommand()==Constants.IMCG_LINKING_FAIL){
                                System.out.println("没有权限，请注册使用");
                                AlertDialog.Builder builder = new Builder(customApplication.getWelcomeActivity());
                                builder.setTitle("没有权限！！！");
                                builder.setPositiveButton("确定",
                                        new android.content.DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                // TODO Auto-generated method stub
                                                arg0.dismiss();
                                                Intent intent = new Intent();
                                                intent.setClass(customApplication.getWelcomeActivity(), RegisterActivity.class);
                                                customApplication.getWelcomeActivity().startActivity(intent);
                                                customApplication.getWelcomeActivity().finish();
                                            }
                                        });
                                builder.create().show();
                            }else if(imcg.getRecommand()==Constants.IMCG_NO_PERMISSION){
                                System.out.println("正在授权，请稍后。。。");
                            }
                        }
                    });
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            System.out.println(HANDLER_CHANNELREAD_ERROR+":"+e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            if (byteBuf != null) byteBuf.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        shouldReconncet = true;
        System.out.println(HANDLER_EXCEPTION_CAUGHT+":"+cause.getLocalizedMessage());
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE){
                shouldReconncet = true;
                System.out.println("Net file tcp client handler => userEventTriggered: heartbeat timeout, client removed,"+ctx.channel());
                ctx.close();
            } else if (idleStateEvent.state() == IdleState.WRITER_IDLE){
                SWbean responseimcg = new SWbean();
                responseimcg.setCommand(Constants.HEART_BEAT);
//                responseInfoCol.setRcommand(Constants.INFOCOL_HEARTBEAT_SUC);
                byte[] resbytes = new NetWorkImpl().getByteData(responseimcg);
                ByteBuf byteBuf1 =  ctx.alloc().buffer(4 + resbytes.length);
                byteBuf1.writeInt(resbytes.length);
                byteBuf1.writeBytes(resbytes);
                ctx.writeAndFlush(byteBuf1);
            }
        }
    }

    public  ChannelHandlerContext getChannelHandlerContext() throws Exception {
        return rebackctx;
    }
    public  Object getMsg() throws Exception {
        return rebackmsg;
    }
    public  CustomApplication getCustomApplication() throws Exception {
        return customApplication;
    }
}
