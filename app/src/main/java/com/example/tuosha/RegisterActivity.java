package com.example.tuosha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
    public void onDestory(){
        removeActivity(this);
    }
}
