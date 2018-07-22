package com.example.tuosha.netty;

import android.app.Application;

import com.example.tuosha.ContentActivity;
import com.example.tuosha.KouziActivity;
import com.example.tuosha.LoginActivity;
import com.example.tuosha.SecondActivity;
import com.example.tuosha.WelcomeActivity;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.KouziBean;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class CustomApplication extends Application implements UncaughtExceptionHandler {

    private static CustomApplication instance;

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static CustomApplication getInstance() {
        return instance;
    }

    private LoginActivity LoginActivity;
    private WelcomeActivity WelcomeActivity;
    private KouziActivity KouziActivity;
    private SecondActivity SecondActivity;
    private ArrayList<KouziBean> list;
    private ArrayList<KouziBean> secondlist;
    private String userName;
    private String passWord;
    private ContentActivity ContentActivity;
    private ArrayList<ContentBean> ContentList;
    private ArrayList<ContentBean> ContentSecondList;

    public LoginActivity getLoginActivity() {
        return LoginActivity;
    }

    public void setLoginActivity(LoginActivity loginActivity) {
        LoginActivity = loginActivity;
    }

    public com.example.tuosha.SecondActivity getSecondActivity() {
        return SecondActivity;
    }

    public void setSecondActivity(com.example.tuosha.SecondActivity secondActivity) {
        SecondActivity = secondActivity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public com.example.tuosha.WelcomeActivity getWelcomeActivity() {
        return WelcomeActivity;
    }

    public void setWelcomeActivity(WelcomeActivity welcomeActivity) {
        WelcomeActivity = welcomeActivity;
    }

    public com.example.tuosha.KouziActivity getKouziActivity() {
        return KouziActivity;
    }

    public void setKouziActivity(KouziActivity kouziActivity) {
        KouziActivity = kouziActivity;
    }

    public ArrayList<KouziBean> getList() {
        return list;
    }

    public void setList(ArrayList<KouziBean> list) {
        this.list = list;
    }

    public ArrayList<KouziBean> getSecondlist() {
        return secondlist;
    }

    public void setSecondlist(ArrayList<KouziBean> secondlist) {
        this.secondlist = secondlist;
    }

    public static void setInstance(CustomApplication instance) {
        CustomApplication.instance = instance;
    }

    public com.example.tuosha.ContentActivity getContentActivity() {
        return ContentActivity;
    }

    public void setContentActivity(com.example.tuosha.ContentActivity contentActivity) {
        ContentActivity = contentActivity;
    }

    public ArrayList<ContentBean> getContentList() {
        return ContentList;
    }

    public void setContentList(ArrayList<ContentBean> contentList) {
        ContentList = contentList;
    }

    public ArrayList<ContentBean> getContentSecondList() {
        return ContentSecondList;
    }

    public void setContentSecondList(ArrayList<ContentBean> contentSecondList) {
        ContentSecondList = contentSecondList;
    }
}
