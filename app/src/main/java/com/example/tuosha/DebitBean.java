package com.example.tuosha;

public class DebitBean {

    public String title;
    public String des;
    public String icon;
    public String debit_url;
    public String debittime;
    public Integer clicknum;

    public DebitBean() {
    }

    public DebitBean(String title, String des, String icon, String news_url, String newstime, Integer readnum) {
        this.title = title;
        this.des = des;
        this.icon = icon;
        this.debit_url = news_url;
        this.debittime = newstime;
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

    public String getDebit_url() {
        return debit_url;
    }

    public void setDebit_url(String news_url) {
        this.debit_url = news_url;
    }

    public String getDebittime() {
        return debittime;
    }

    public void setDebittime(String newstime) {
        this.debittime = newstime;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer readnum) {
        this.clicknum = readnum;
    }
}

