package com.example.tuosha.model;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class KouziBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public String title;
    public String des;
    public String icon;
    public String kouzi_url;
    public String kouzitime;
    public String clicknum;
    public String extInfo;

    public KouziBean() {
    }

    public KouziBean(String title, String des, String icon, String kouzi_url, String kouzitime, String clicknum, String extInfo) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.kouzi_url = kouzi_url;
        this.kouzitime = kouzitime;
        this.clicknum = clicknum;
        this.extInfo = extInfo;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
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

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return "KouziBean{" +
                "title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", icon='" + icon + '\'' +
                ", kouzi_url='" + kouzi_url + '\'' +
                ", kouzitime='" + kouzitime + '\'' +
                ", clicknum='" + clicknum + '\'' +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }
}

