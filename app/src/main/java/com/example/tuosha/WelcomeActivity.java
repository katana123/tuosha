package com.example.tuosha;

import com.example.tuosha.Utils.UserManage;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.Utils.Constants;

import com.example.tuosha.model.UsersEntity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;
import static com.example.tuosha.client.CustomApplication.getMyApplication;


public class WelcomeActivity extends Activity {
    private CustomApplication customApplication;

    @SuppressLint("NewApi")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置为全屏幕显示
        setContentView(R.layout.welcome);

        customApplication = (CustomApplication)getApplication();
        customApplication.setWelcomeActivity(this);
        setData();
    }
         Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 2000://去主页
                        Timer timer=new Timer();
                        TimerTask timerTask=new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent1=new Intent(WelcomeActivity.this,MainActivity.class);
                                startActivity(intent1);
                                WelcomeActivity.this.finish();
                            }
                        };
                        timer.schedule(timerTask,1000*3);
                        break;
                    case 1000://去登录页
                        Timer timer2=new Timer();
                        TimerTask timerTask2=new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent2 = new Intent(WelcomeActivity.this, LoginActivity.class);
                                startActivity(intent2);
                                finish();
                            }
                        };
                        timer2.schedule(timerTask2,1000*3);
                        break;
                }
            }
        };

    public void setData(){
        if (UserManage.getInstance().hasUserInfo(this))//自动登录判断，SharePrefences中有数据，则跳转到主页，没数据则跳转到登录页
        {
            if (UserManage.getInstance().getUserInfo(getMyApplication()).getStatus()=="1") {
                Message message = new Message();
                message.what = 2000; //200代码获取数据正常
                mHandler.sendMessage(message);
                // }else if(UserManage.getInstance().getUserInfo(this).getStatus()=="0"){
            }else{  System.out.println("状态不为1：到数据库查找");
                Thread thread = new Thread() {
                    public void run() {
                        try {

                            IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                            imcgClientHandler.start();
                            SWbean imcg = new SWbean();
                            //TbUsersEntity user = new TbUsersEntity();
                            UsersEntity user = new UsersEntity();
                            //把内存的nickname和password去找用户
                            user.setNickname(UserManage.getInstance().getUserInfo(getMyApplication()).getNickname());
                            user.setMobile(UserManage.getInstance().getUserInfo(getMyApplication()).getPhone());
                            user.setPassword(UserManage.getInstance().getUserInfo(getMyApplication()).getPassword());

                            imcg.setUsersEntity(user);
                            imcg.setCommand(Constants.WELCOME);


                            Thread.sleep(1000 * 5);
                            imcgClientHandler.sendMsg(imcg);
                            Thread.sleep(1000 * 10);
                            imcgClientHandler.disposeInfoColClient();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        } else {//没数据，需要登录
            Message message=new Message();
            message.what=1000; //
            mHandler.sendMessage(message);
        }
    }




    public void onBackPressed() {
        AlertDialog.Builder alterDialogBuilder = new AlertDialog.Builder(this);
        alterDialogBuilder.setTitle(R.string.app_name);
        alterDialogBuilder
                .setMessage(R.string.login_activity_dialog_confirm_exit_message);
        alterDialogBuilder.setPositiveButton(
                R.string.login_activity_dialog_ok_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        onDestory();

                        WelcomeActivity.this.finish();
                        System.exit(0);

                    }
                });
        alterDialogBuilder.setNegativeButton(
                R.string.login_activity_dialog_cancel_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.dismiss();
                    }
                });
        alterDialogBuilder.show();
    }
    public void onDestory(){
        removeActivity(this);
    }



}