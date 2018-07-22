package com.example.tuosha;

import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.Utils.Constants;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


public class WelcomeActivity extends Activity {
    private CustomApplication customApplication;

    @SuppressLint("NewApi")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置为全屏幕显示
        setContentView(R.layout.welcome);

       // customApplication = (CustomApplication)getApplication();
        customApplication = new CustomApplication();
        customApplication.setWelcomeActivity(this);
//        customApplication.setActivity(this);

//        TelephonyManager telephonyManager=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//        final String  imei=telephonyManager.getDeviceId();
//        System.out.println("imei"+imei);
//
//        TelephonyManager telManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
//        final String imsi = telManager.getSubscriberId();
//        System.out.println("imsi"+imsi);
        //获取手机号码
        TelephonyManager tm = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        //String deviceid = tm.getDeviceId();//获取智能设备唯一编号
        final String te1 = "";//tm.getLine1Number();//获取本机号码

        final String SerialNumber = android.os.Build.SERIAL;
        System.out.println("SerialNumber"+SerialNumber);

//        final String IP=rightIp;
//        customApplication.setIp(rightIp);

        Thread thread = new Thread() {
            public void run() {
            	try {
            		
		            IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
		            imcgClientHandler.start();
		            SWbean imcg = new SWbean();
                    ImsXuanMixloanMemberEntity user = new ImsXuanMixloanMemberEntity();
//		            if(imei!=null){
//		            	user.setIimei(imei);
//		            }else{
//		            	user.setIimsi(SerialNumber);
//		            }
                    if(te1!=null){
                        user.setPhone("13960590250");
                    }else{
                        user.setPhone("18186404165");
                    }
		            imcg.setMemberEntity(user);
		            imcg.setCommand(Constants.DEFAULT);
		            Thread.sleep(1000 * 3);
		            imcgClientHandler.sendMsg(imcg);
		            Thread.sleep(1000 * 10);
		            //imcg.getUser().setUserid(2);
		            //imcgClientHandler.sendMsg(imcg);
		            Thread.sleep(1000);
		            imcgClientHandler.disposeInfoColClient();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
            }
        };
        thread.start();
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent1=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent1);
                WelcomeActivity.this.finish();
            }
        };
        timer.schedule(timerTask,1000*3);

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
    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
            }
        }
    };
}