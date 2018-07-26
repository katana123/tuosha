package com.example.tuosha.client;

import android.app.AlertDialog;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Gravity;
import android.widget.Toast;


import com.example.tuosha.LoginActivity;
import com.example.tuosha.MainActivity;
import com.example.tuosha.RegisterActivity;
import com.example.tuosha.SubscribeActivity;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.Utils.UserManage;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.model.KouziBean;
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.Utils.NetWorkImpl;


import java.util.ArrayList;

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
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
       System.out.println(HANDLER_CHANNELREAD);


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
            customApplication=(CustomApplication) getMyApplication();
            switch (netCommand) {
                //快速提额
                case Constants.BANKLIST:
                    System.out.println("BANKLIST");

                  new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                        	if (imcg.getRecommand() == Constants.BANKLIST){
                                System.out.println("BANKLIST数据请求成功");
                                System.out.println(imcg.getProductsEntities());

                                customApplication.setTiEsEntities(imcg.getTiEsEntities());

                        	} else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("BANKLIST数据请求失败");
//
                            }

                        }
                    });

                    break;
                    //信用卡
                case Constants.BANKCARDLIST:
                    System.out.println("BANKCARDLIST");

                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.BANKCARDLIST){
                                System.out.println("BANKCARDLIST数据请求成功");
                                System.out.println(imcg.getXinYongKasEntities());

                                customApplication.setXinYongKasEntities(imcg.getXinYongKasEntities());

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("BANKLIST数据请求失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
                    //银行贷款
                case Constants.DAIKUANLIST:
                    System.out.println("DAIKUANLIST");

                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.DAIKUANLIST){
                                System.out.println("DAIKUANLIST数据请求成功");
                                System.out.println(imcg.getDaikuansEntities());

                                customApplication.setDaikuansEntities(imcg.getDaikuansEntities());

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("DAIKUANLIST数据请求失败");
//
                            }

                        }
                    });
                    //贷款进度
                case Constants.PROGRESSLIST:
                    System.out.println("PROGRESSLIST");

                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.DAIKUANLIST){
                                System.out.println("PROGRESSLIST数据请求成功");
                                System.out.println(imcg.getProcessesEntities());

                                customApplication.setProcessesEntities(imcg.getProcessesEntities());

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("PROGRESSLIST数据请求失败");
//
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
                case Constants.HEART_BEAT:
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
                case Constants.WELCOME:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {
                            if(imcg.getResult()==1){
                                System.out.println("连接成功");
                                String username=imcg.getTbUsersEntity().getNickname();
                                String password=imcg.getTbUsersEntity().getPassword();
                                String phone=imcg.getTbUsersEntity().getPhone();
                                String status=imcg.getTbUsersEntity().getStatus();
                                UserManage.getInstance().saveUserInfo(getMyApplication(), username, password,phone,status);
                                 Intent intent = new Intent();
                                customApplication=(CustomApplication) getMyApplication();
                                intent.setClass(customApplication.getWelcomeActivity(), MainActivity.class);
                                customApplication.getWelcomeActivity().startActivity(intent);
                                customApplication.getWelcomeActivity().finish();

                            }else if(imcg.getResult()==2){
                                System.out.println("没有权限，该账号被禁用！");
                            }else if(imcg.getResult()==0){
                                AlertDialog.Builder builder = new Builder(customApplication.getWelcomeActivity());
                                builder.setTitle("没有权限！！！请注册加入会员！");
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
                            }else if(imcg.getResult()==3){
                                AlertDialog.Builder builder = new Builder(customApplication.getWelcomeActivity());
                                builder.setTitle("请注册加入会员！");
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
                            }
                        }
                    });
                    break;
                case Constants.LOGIN:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {
                            System.out.println(imcg.toString());
                            //customApplication = (CustomApplication) getMyApplication();
                            if (imcg.getResult() == 1) {
                                System.out.println("登录成功");
                                String userName= imcg.getTbUsersEntity().getNickname();
                                String userPwd = imcg.getTbUsersEntity().getPassword();
                                String userPhone = imcg.getTbUsersEntity().getPhone();
                                String status = imcg.getTbUsersEntity().getStatus();
                                UserManage.getInstance().saveUserInfo(getMyApplication(), userName, userPwd,userPhone,status);
                               //如果有登陆过，直接进入主页，否则进入登录页面
                                Intent intent = new Intent();
                                intent.setClass(customApplication.getLoginActivity(), MainActivity.class);
                                customApplication.getLoginActivity().startActivity(intent);
                                customApplication.getLoginActivity().finish();

                            } else if (imcg.getResult() == 2) {
                                System.out.println("没有权限，该账号被禁用！");
                            } else if (imcg.getResult() == 0) {
                                String userName= imcg.getTbUsersEntity().getNickname();
                                String userPwd = imcg.getTbUsersEntity().getPassword();
                                String userPhone = imcg.getTbUsersEntity().getPhone();
                                String status = imcg.getTbUsersEntity().getStatus();
                                UserManage.getInstance().saveUserInfo(getMyApplication(), userName, userPwd,userPhone,status);

                                AlertDialog.Builder builder = new Builder(customApplication.getLoginActivity());
                                builder.setTitle("没有权限！！！请注册加入会员！");
                                builder.setPositiveButton("确定",
                                        new android.content.DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                // TODO Auto-generated method stub
                                                arg0.dismiss();
                                                Intent intent = new Intent();
                                               intent.setClass(customApplication.getLoginActivity(), SubscribeActivity.class);
                                                intent.setAction(Intent.ACTION_VIEW);
                                                String phone = imcg.getTbUsersEntity().getPhone();
                                                intent.putExtra("phone",phone);
                                               customApplication.getLoginActivity().startActivity(intent);
                                                customApplication.getLoginActivity().finish();
                                            }
                                        });
                                builder.create().show();
                            } else if (imcg.getResult() == 3) {//无效，预留
                                System.out.println("没有该用户信息，请注册");
                                AlertDialog.Builder builder = new Builder(customApplication.getLoginActivity());
                                builder.setTitle("没有该用户信息，请修改登录信息或注册");
                                builder.setPositiveButton("确定",
                                        new android.content.DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                // TODO Auto-generated method stub
                                                arg0.dismiss();

                                            }
                                        });
                                builder.create().show();
                            }
                        }
                    });
                    break;

                case Constants.CHECKNAME:
                    System.out.println("CHECKNAME");
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.CHECKNAME){
                                System.out.println("CHECKNAME数据请求成功");
                               if (imcg.getResult() == 1){
                                   Toast toast =Toast.makeText(customApplication.getRegisterActivity(), "用户名可用！",
                              	      Toast.LENGTH_SHORT);
                                   toast.setGravity(Gravity.CENTER, 0, 0);
                                   toast.show();
//                                 AlertDialog.Builder builder = new Builder(customApplication.getRegisterActivity());
//                                builder.setTitle("用户可用");
//                                builder.setPositiveButton("确定",
//                                        new android.content.DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface arg0, int arg1) {
//                                                // TODO Auto-generated method stub
//                                                arg0.dismiss();
//
//                                            }
//                                        });
//                                builder.create().show();
                               }else{
                                   AlertDialog.Builder builder = new Builder(customApplication.getRegisterActivity());
                                   builder.setTitle("存在同名用户");
                                   builder.setPositiveButton("确定",
                                           new android.content.DialogInterface.OnClickListener() {
                                               public void onClick(DialogInterface arg0, int arg1) {
                                                   // TODO Auto-generated method stub
                                                   arg0.dismiss();

                                               }
                                           });
                                   builder.create().show();
                               }

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("BANKLIST数据请求失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
                case Constants.REGISTER:
                    System.out.println("REGISTER");
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue( new Runnable() {
                        public void run() {

                            if (imcg.getRecommand() == Constants.REGISTER){
                                System.out.println("REGISTER数据成功");
                                if (imcg.getResult() == 1){
                                    Toast.makeText(customApplication.getRegisterActivity(), "注册成功！",
                                            Toast.LENGTH_SHORT).show();
                                    //把返回的值，用户名、密码放入缓存中
                                    String userName= imcg.getTbUsersEntity().getNickname();
                                    String userPwd = imcg.getTbUsersEntity().getPassword();
                                    String phone = imcg.getTbUsersEntity().getPhone();
                                    String status = imcg.getTbUsersEntity().getStatus();
                                    UserManage.getInstance().saveUserInfo(getMyApplication(), userName, userPwd,phone,status);
                                    //打开主页面
                                    Intent intent = new Intent();
                                    intent.setClass(customApplication.getRegisterActivity(), SubscribeActivity.class);
                                    customApplication.getRegisterActivity().startActivity(intent);
                                    customApplication.getRegisterActivity().finish();
                                }else{
                                    System.out.println("REGISTER数据失败");
                                }

                            } else if(imcg.getRecommand() == Constants.DEFAULT){
                                System.out.println("REGISTER数据失败");
//                                Toast.makeText(customapplication.getLoginActivity(), "登陆失败！",
//                              	      Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    break;
                case Protocols.KOUZILIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<JieQiansEntity> JieQianList = imcg.getJieQiansEntities();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setJieQiansEntities(JieQianList);
                        }
                    });
                    break;
                case Protocols.KOUZISECONDLIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<JieQiansEntity> JieQianList = imcg.getJieQiansEntities();

                            CustomApplication application = CustomApplication.getInstance();
                            application.setJieQiansEntities(JieQianList);
                        }
                    });
                    break;
                case Protocols.CONTENTLIST:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<PostsEntity> postsEntities = imcg.getPostsEntities();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setPostsEntities(postsEntities);
                        }
                    });
                    break;
                case Protocols.CONTENTLISTBYID:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            ArrayList<PostsEntity> postsEntities = imcg.getPostsEntities();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setPostsEntities(postsEntities);
                        }
                    });
                    break;
                case Protocols.SENDVEVIFYCODE:
                    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            String phone = imcg.getPhone();
                            String vcode = imcg.getVcode();
                            CustomApplication application = CustomApplication.getInstance();
                            application.setPhone(phone);
                            application.setVcode(vcode);
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
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
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

    //public ChannelHandlerContext getChannelHandlerContext() {
    //    return rebackctx;
    //}

    //public Object getMsg() {
     //   return rebackmsg;
    //}

    public CustomApplication getCustomApplication() {
        return customApplication;
    }
}
