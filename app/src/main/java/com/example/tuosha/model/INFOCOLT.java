package com.example.tuosha.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by LC on 2015/2/27.
 */
public class INFOCOLT implements Serializable {
    private static final long serialVersionUID = 1L;
    private byte command;
    private byte recommand;
    private int result;
    private ArrayList<ImsXuanMixloanBankEntity> bankEntities;
    private TbUsersEntity tbUsersEntity;
    private ArrayList<KouziBean> KouziBean;
    private int KouziType;
    private int JisuType;
    private ArrayList<ContentBean> ContentBean;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte getCommand() {
        return command;
    }

    public void setCommand(byte command) {
        this.command = command;
    }

    public byte getRecommand() {
        return recommand;
    }

    public void setRecommand(byte recommand) {
        this.recommand = recommand;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public ArrayList<ImsXuanMixloanBankEntity> getBankEntities() {
        return bankEntities;
    }

    public void setBankEntities(ArrayList<ImsXuanMixloanBankEntity> bankEntities) {
        this.bankEntities = bankEntities;
    }

    public TbUsersEntity getTbUsersEntity() {
        return tbUsersEntity;
    }

    public void setTbUsersEntity(TbUsersEntity tbUsersEntity) {
        this.tbUsersEntity = tbUsersEntity;
    }

    public ArrayList<com.example.tuosha.model.KouziBean> getKouziBean() {
        return KouziBean;
    }

    public void setKouziBean(ArrayList<com.example.tuosha.model.KouziBean> kouziBean) {
        KouziBean = kouziBean;
    }

    public int getKouziType() {
        return KouziType;
    }

    public void setKouziType(int kouziType) {
        KouziType = kouziType;
    }

    public ArrayList<com.example.tuosha.model.ContentBean> getContentBean() {
        return ContentBean;
    }

    public void setContentBean(ArrayList<com.example.tuosha.model.ContentBean> contentBean) {
        ContentBean = contentBean;
    }

    public int getJisuType() {
        return JisuType;
    }

    public void setJisuType(int jisuType) {
        JisuType = jisuType;
    }

    @Override
    public String toString() {
        return "INFOCOLT{" +
                "command=" + command +
                ", recommand=" + recommand +
                ", result=" + result +
                ", bankEntities=" + bankEntities +
                ", tbUsersEntity=" + tbUsersEntity +
                ", KouziBean=" + KouziBean +
                ", KouziType=" + KouziType +
                ", JisuType=" + JisuType +
                ", ContentBean=" + ContentBean +
                '}';
    }
}
