package com.example.tuosha.Utils;

import android.app.Application;

public class MyApplication extends Application {
    private String name;

    @Override
    public void onCreate() {
        super.onCreate();
        setName(NAME); //初始化全局变量
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final String NAME = "MyApplication";
}
