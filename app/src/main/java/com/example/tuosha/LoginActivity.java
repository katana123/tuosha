package com.example.tuosha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.client.IMCGClientHandler;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private Button register;
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = username.getText().toString();//账号
                String pass = password.getText().toString();//密码
                if (!TextUtils.isEmpty(nickname) && !TextUtils.isEmpty(pass)) {
                    SWbean swbean = new SWbean();
                    swbean.setCommand(Protocols.LOGIN);
                    ImsXuanMixloanMemberEntity memberEntity = new ImsXuanMixloanMemberEntity();
                    memberEntity.setNickname(nickname);
                    memberEntity.setPass(pass);
                    swbean.setMemberEntity(memberEntity);
                    CustomApplication customApplication = new CustomApplication();
                    IMCGClientHandler clientHandler = new IMCGClientHandler(customApplication);
                    boolean aaa =true; //clientHandler.sendMsg(swbean);
                    if(aaa){
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this,SubscribeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "账号或者密码有误", Toast.LENGTH_SHORT).show();
                }


            }
        });

        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
