package com.example.tuosha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuosha.Utils.Constants;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.Utils.UserManage;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.client.IMCGClientHandler;

import com.example.tuosha.model.UsersEntity;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;
import static com.example.tuosha.client.CustomApplication.getMyApplication;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private CustomApplication customApplication;

    // @Override
    public Context getContext() {
        return this.getContext();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.login_main);
        //电话号码
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        customApplication = (CustomApplication) getApplication();
        customApplication.setLoginActivity(this);

        LoadUserDate();

        Button login = findViewById(R.id.sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // String nickname = username.getText().toString();//账号
                String phone = username.getText().toString();//电话号码
                String pass = password.getText().toString();//密码

                if (phone == null || phone.equals("")) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle(R.string.app_name)
                            .setMessage("请输入用户电话号码!")
                            .setPositiveButton("确定", null)
                            .show();
                } else if (pass == null || pass.equals("")) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle(R.string.app_name)
                            .setMessage("请输入密码!")
                            .setPositiveButton("确定", null)
                            .show();
                } else {

                    try {
                        IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                        imcgClientHandler.start();
                        SWbean sWbean = new SWbean();
                        UsersEntity user = new UsersEntity();
                        //user.setNickname(nickname);
                        user.setMobile(phone);
                        user.setPassword(pass);
                        sWbean.setUsersEntity(user);
                        sWbean.setCommand(Constants.LOGIN);
                        Thread.sleep(1000 * 3);
                        imcgClientHandler.sendMsg(sWbean);
                        System.out.println("发起登录");
                        Thread.sleep(1000);
                        imcgClientHandler.disposeInfoColClient();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Button register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    public void onDestory() {
        removeActivity(this);
    }

    private void LoadUserDate() {
        if (UserManage.getInstance().hasUserInfo(this)) {
            String uname = UserManage.getInstance().getUserInfo(getMyApplication()).getPhone();
            if (!("".equals(username))) {
                username.setText(uname);
            }
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

                        LoginActivity.this.finish();
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
}