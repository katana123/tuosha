package com.example.tuosha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuosha.Utils.Constants;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.model.TbUsersEntity;
import com.mob.MobSDK;

import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button login;
    String APPKEY = "26fedf0a15306";
    String APPSECRETE = "c0d6325b9bde8387236566a53895981b";
    private Button msg_button;
    int i = 30;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.register_main);
        init();
        final CustomApplication customApplication = (CustomApplication) getApplication();
        customApplication.setRegisterActivity(this);
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

    public void MsgButtonOnClick (View view) {
        msg_button = (Button) findViewById(R.id.msg_button);
        String phone = ((EditText) findViewById(R.id.phone))
                .getText().toString();
        // 1. 通过规则判断手机号
        if (!judgePhoneNums(phone)) {
            return;
        } // 2. 通过sdk发送短信验证
        SMSSDK.getVerificationCode("86", phone);
        msg_button.setClickable(false);
        msg_button.setText("重新发送(" + i + ")");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; i > 0; i--) {
                    handler.sendEmptyMessage(-9);
                    if (i <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(-8);
            }
        }).start();
    }
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                msg_button.setText("重新发送(" + i + ")");
            } else if (msg.what == -8) {
                msg_button.setText("获取验证码");
                msg_button.setClickable(true);
                i = 60;
            } else {
                int event = msg.arg1;
                int result = msg.arg2;
                Object data = msg.obj;
                Log.e("event", "event=" + event);
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 短信注册成功后，返回MainActivity,然后提示
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
                        Toast.makeText(getApplicationContext(), "提交验证码成功",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Toast.makeText(getApplicationContext(), "正在获取验证码",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        ((Throwable) data).printStackTrace();
                        Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else{
                    ((Throwable) data).printStackTrace();
				    Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    };
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
        final String icode = ((EditText) findViewById(R.id.identifying_code))
                .getText().toString();

        SMSSDK.submitVerificationCode("86", phone, icode);

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
            builder.setTitle("tuosha");
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
            builder.setTitle("tuosha");
            builder.setMessage("用户电话不能为空！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(icode.length()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("tuosha");
            builder.setMessage("验证码不能为空！");
            builder.setPositiveButton("确定",
                    new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                            arg0.dismiss();
                        }
                    });
            builder.create().show();
        }
        else if(icode.length() !=4){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("tuosha");
            builder.setMessage("验证码不同！");
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
            builder.setTitle("tuosha");
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
            builder.setTitle("tuosha");
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
                swbean.setEx_Data(icode);

                swbean.setTbUsersEntity(user);
                swbean.setCommand(Constants.REGISTER);
                Thread.sleep(1000 * 3);
                imcgClientHandler.sendMsg(swbean);
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
        SMSSDK.unregisterAllEventHandler();
        super.onDestroy();
    }
    private void init() {
        // 启动短信验证sdk
        //SMSSDK.initSDK(this, APPKEY, APPSECRETE);
        MobSDK.init(this);
        EventHandler eventHandler = new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }
        };
        //注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
    }

    /**
     * 判断手机号码是否合理
     *
     * @param phoneNums
     */
    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11)
                && isMobileNO(phoneNums)) {
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！",Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 判断一个字符串的位数
     * @param str
     * @param length
     * @return
     */
    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobileNums) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }

}
