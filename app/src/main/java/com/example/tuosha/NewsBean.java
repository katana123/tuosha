package com.example.tuosha;
import android.graphics.drawable.Drawable;

public class NewsBean {

    public String title;
    public String des;
    public Drawable icon;
    public String news_url;
    public String newstime;
    public String readnum;

    public NewsBean() {
    }

    public NewsBean(String title, String des, Drawable icon, String news_url, String newstime, String readnum) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.news_url = news_url;
        this.newstime = newstime;
        this.readnum = readnum;
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
}

