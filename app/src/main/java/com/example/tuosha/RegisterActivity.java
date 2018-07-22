package com.example.tuosha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuosha.Utils.Constants;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.model.TbUsersEntity;

import java.util.regex.Pattern;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.register_main);
        final CustomApplication customApplication = (CustomApplication) getApplication();

        EditText nickName = (EditText) findViewById(R.id.username);
        nickName.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    final String userName = ((EditText) findViewById(R.id.username)).getText().toString();

                    Thread thread = new Thread() {
                        public void run() {
                              System.out.println("开始检测用户名");
                              try {
                                    IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                                    imcgClientHandler.start();
                                    SWbean sWbean = new SWbean();
                                    TbUsersEntity user = new TbUsersEntity();
                                    user.setNickname(userName);

                                    sWbean.setTbUsersEntity(user);
                                    sWbean.setCommand(Constants.CHECKNAME);
                                    Thread.sleep(1000 * 3);
                                    imcgClientHandler.sendMsg(sWbean);
                                    System.out.println("检测用户名");
                                    Thread.sleep(1000);
                                    imcgClientHandler.disposeInfoColClient();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                }
            }
        });


        EditText password_confirm = (EditText) findViewById(R.id.password_confirm);
        password_confirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    EditText password = (EditText) findViewById(R.id.password);
                    EditText password_confirm = (EditText) findViewById(R.id.password_confirm);
                    final String pass = password.getText().toString();
                    final String passconfirm = password_confirm.getText().toString();

                    Thread thread = new Thread() {
                        public void run() {
                            System.out.println("开始检测用户名");
                            try {
                                if(TextUtils.equals(pass, passconfirm)==false){
                                    Toast.makeText(RegisterActivity.this,"两次输入密码不同", Toast.LENGTH_SHORT).show();
                                      return;
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                }
            }
        });


        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                onDestory();
                finish();
            }
        });


    }

    public void RegisterButtonOnClick(View view) {
        final CustomApplication customApplication = (CustomApplication) getApplication();

        final String userName = ((EditText) findViewById(R.id.username))
                .getText().toString();
        final String password = ((EditText) findViewById(R.id.password))
                .getText().toString();
        final String ensurepassword = ((EditText) findViewById(R.id.password_confirm))
                .getText().toString();
        final String phone = ((EditText) findViewById(R.id.phone))
                .getText().toString();



        if(userName.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("tuosha");
            builder.setMessage("用户名不能为空！！！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }

        else if(password.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("tuosha");
            builder.setMessage("密码不能为空！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(ensurepassword.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("武钢INFOCLOUD");
            builder.setMessage("确认密码不能为空！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(phone.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("武钢INFOCLOUD");
            builder.setMessage("用户电话不能为空！！�?");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(!(password.equals(ensurepassword))){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("武钢INFOCLOUD");
            builder.setMessage("密码和确认密码不同！！！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(!(checkMobile(phone))){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("武钢INFOCLOUD");
            builder.setMessage("手机号有误！！！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else{
            try {

                IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                imcgClientHandler.start();
                SWbean swbean = new SWbean();
                TbUsersEntity user = new TbUsersEntity();
                user.setNickname(userName);
                user.setPassword(password);
                user.setPhone(phone);

                swbean.setTbUsersEntity(user);
                swbean.setCommand(Constants.REGISTER);
                Thread.sleep(1000 * 3);
                imcgClientHandler.sendMsg(swbean);
//	            Thread.sleep(1000 * 10);
//	            imcg.getUser().setUserid(2);
//	            imcgClientHandler.sendMsg(imcg);
                Thread.sleep(1000);
                imcgClientHandler.disposeInfoColClient();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        return Pattern.matches(regex,mobile);
    }
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex,idCard);
    }

    public void onDestory(){
        removeActivity(this);
    }
}
