package com.example.tuosha;
import android.graphics.drawable.Drawable;

public class BankBean {

    public String title;
    public String des;
    public Drawable icon;
    public String bank_url;
    public String banktime;
    public String clicknum;

    public BankBean() {
    }

    public BankBean(String title, String des, Drawable icon, String news_url, String newstime, String readnum) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.bank_url = news_url;
        this.banktime = newstime;
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

    public String getBank_url() {
        return bank_url;
    }

    public void setBank_url(String news_url) {
        this.bank_url = news_url;
    }

    public String getBanktime() {
        return banktime;
    }

    public void setBanktime(String newstime) {
        this.banktime = newstime;
    }

    public String getClicknum() {
        return clicknum;
    }

    public void setClicknum(String readnum) {
        this.clicknum = readnum;
    }
}

