package com.example.tuosha.model;

import java.io.Serializable;

public class ContentBean implements Serializable {

    private static final long serialVersionUID = 1L;
    public int id;
    public String title;
    public String des;
    public String icon;
    public String news_url;
    public String newstime;
    public String readnum;
    public String extInfo;

    public ContentBean() {
    }

    public ContentBean(int id, String title, String des, String icon, String news_url, String newstime, String readnum, String extInfo) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.news_url = news_url;
        this.newstime = newstime;
        this.readnum = readnum;
        this.extInfo = extInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getReadnum() {
        return readnum;
    }

    public void setReadnum(String readnum) {
        this.readnum = readnum;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return "ContentBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", icon=" + icon +
                ", news_url='" + news_url + '\'' +
                ", newstime='" + newstime + '\'' +
                ", readnum='" + readnum + '\'' +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }
}

