package com.example.tuosha;
import android.graphics.drawable.Drawable;

public class CardBean {

    public String title;
    public String des;
    public String icon;
    public String card_url;
    public String cardtime;
    public Integer clicknum;

    public CardBean() {
    }

    public CardBean(String title, String des, String icon, String news_url, String newstime, Integer readnum) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.card_url = news_url;
        this.cardtime = newstime;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCard_url() {
        return card_url;
    }

    public void setCard_url(String news_url) {
        this.card_url = news_url;
    }

    public String getCardtime() {
        return cardtime;
    }

    public void setCardtime(String newstime) {
        this.cardtime = newstime;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer readnum) {
        this.clicknum = readnum;
    }
}

