package com.example.tuosha.netty;

import com.example.tuosha.Utils.NetWorkImpl;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.netty.module.BaseMsg;
import com.example.tuosha.netty.module.PingMsg;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

/**
 * @author zkq
 * @version 2017/12/11 14:11
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
    //设置心跳时间  开始
    public static final int MIN_CLICK_DELAY_TIME = 1000 * 30;
    private long lastClickTime = 0;
    //设置心跳时间   结束

    //利用写空闲发送心跳检测消息
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                        lastClickTime = System.currentTimeMillis();
                        PingMsg pingMsg = new PingMsg();
                        ctx.writeAndFlush(pingMsg);
                        System.out.println("send ping to server----------");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    //这里是断线要进行的操作
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("重连了。---------");
        NettyClientBootstrap bootstrap = PushClient.getBootstrap();
        bootstrap.startNetty();
    }

    //这里是出现异常的话要进行的操作
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("出现异常了。。。。。。。。。。。。。");
        cause.printStackTrace();
    }

    //这里是接受服务端发送过来的消息
//    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object baseMsg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) baseMsg;
//        System.out.println("channelRead");

        try {
            // 改写成bean
            int infocolLength = byteBuf.readInt();
            byte[] infocolBytes = new byte[infocolLength];
            byteBuf.readBytes(infocolBytes);

            SWbean infocolt = (SWbean) NetWorkImpl.getObj(infocolBytes);
            if (infocolt.getCommand() == Protocols.HEART_BEAT || infocolt.getCommand() == Protocols.BANK) {
                if (infocolt.getCommand() == Protocols.BANK) {
                    System.out.println("result----:" + infocolt.getImsXuanMixloanBankEntity().get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SWbean resposeInfocolt = new SWbean();
        int netCommand = resposeInfocolt.getCommand();
        switch (netCommand){
            case Protocols.BANK:
                if(true){
                    resposeInfocolt.setCommand(Protocols.BANK);
                    channelHandlerContext.writeAndFlush(resposeInfocolt);
                }
                break;
        }

//        switch (baseMsg.getType()) {
//                case LOGIN:
//                    //向服务器发起登录
//                    LoginMsg loginMsg = new LoginMsg();
//                    loginMsg.setPassword("yao");
//                    loginMsg.setUserName("robin");
//                    channelHandlerContext.writeAndFlush(loginMsg);
//                    break;
//                case PING:
//                    System.out.println("receive ping from server----------");
//                    break;
//                case PUSH:
//                    PushMsg pushMsg = (PushMsg) baseMsg;
//                *//*Intent intent = new Intent(MainApplication.getAppContext(), MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("hi", pushMsg.getContent());
//                MainApplication.getAppContext().startActivity(intent);*//*
//                    System.out.println(pushMsg.getTitle() + " , " +pushMsg.getContent());
//                    break;
//            default:
//                System.out.println("default..");
//                break;
//        }
        ReferenceCountUtil.release(baseMsg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg) throws Exception {

    }
}
