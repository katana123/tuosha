package com.example.tuosha;
import android.graphics.drawable.Drawable;

public class KouziBean {

    public String title;
    public String des;
    public Drawable icon;
    public String kouzi_url;
    public String kouzitime;
    public String clicknum;

    public KouziBean() {
    }

    public KouziBean(String title, String des, Drawable icon, String news_url, String newstime, String readnum) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.kouzi_url = news_url;
        this.kouzitime = newstime;
        this.clicknum = readnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getKouzi_url() {
        return kouzi_url;
    }

    public void setKouzi_url(String news_url) {
        this.kouzi_url = news_url;
    }

    public String getKouzitime() {
        return kouzitime;
    }

    public void setKouzitime(String newstime) {
        this.kouzitime = newstime;
    }

    public String getClicknum() {
        return clicknum;
    }

    public void setClicknum(String readnum) {
        this.clicknum = readnum;
    }
}

