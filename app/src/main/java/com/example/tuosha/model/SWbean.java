package com.example.tuosha.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SWbean implements Serializable {
    private static final long serialVersionUID = 1L;

    private byte command;
    private byte recommand;
    private int result;
    private String Ex_Data;
    public String getEx_Data() {
        return Ex_Data;
    }

    public void setEx_Data(String ex_Data) {
        Ex_Data = ex_Data;
    }



    private TbAdminEntity tbAdminEntity;
    private TbLogEntity tbLogEntity; //
    private TbUsersEntity tbUsersEntity;
    private ImsXuanMixloanBankCardEntity bankCardEntity;
    private ImsXuanMixloanBankEntity bankEntity;
    private ImsXuanMixloanChannelEntity channelEntity;
    private ImsXuanMixloanChannelSubjectEntity channelSubjectEntity;
    private ImsXuanMixloanCreditcardEntity creditcardEntity;
    private ImsXuanMixloanHelpEntity helpEntity;
    private ImsXuanMixloanLoanEntity loanEntity;
    private ImsXuanMixloanInviterEntity inviterEntity;
    private ImsXuanMixloanMemberEntity memberEntity;
    private ImsXuanMixloanPaymentEntity paymentEntity;
    private ImsXuanMixloanPosterEntity posterEntity;
    private ImsXuanMixloanProductApplyEntity productApplyEntity;
    private ImsXuanMixloanProductEntity productEntity;

    private  ArrayList<TbAdminEntity> tbAdminList;
    private  ArrayList<TbLogEntity> tbLogList; //
    private  ArrayList<TbUsersEntity> tbUsersList;
    private  ArrayList<ImsXuanMixloanBankCardEntity> bankCardList;
    private  ArrayList<ImsXuanMixloanBankEntity> bankList;

    private ArrayList<ImsXuanMixloanBankEntity> ImsXuanMixloanBankEntity;

    private ArrayList<ImsXuanMixloanChannelEntity> channelList;
    private ArrayList<ImsXuanMixloanChannelSubjectEntity> channelSubjectList;
    private ArrayList<ImsXuanMixloanCreditcardEntity> creditcardList;
    private ArrayList<ImsXuanMixloanHelpEntity> helpList;
    private ArrayList<ImsXuanMixloanLoanEntity> loanList;
    private ArrayList<ImsXuanMixloanInviterEntity> inviterList;
    private ArrayList<ImsXuanMixloanMemberEntity> memberList;
    private ArrayList<ImsXuanMixloanPaymentEntity> paymentList;
    private ArrayList<ImsXuanMixloanPosterEntity> posterList;
    private ArrayList<ImsXuanMixloanProductApplyEntity> productApplyList;
    private ArrayList<ImsXuanMixloanProductEntity> productList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(byte command) {
        this.command = command;
    }

    public int getRecommand() {
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

    public TbAdminEntity getTbAdminEntity() {
        return tbAdminEntity;
    }

    public void setTbAdminEntity(TbAdminEntity tbAdminEntity) {
        this.tbAdminEntity = tbAdminEntity;
    }

    public TbLogEntity getTbLogEntity() {
        return tbLogEntity;
    }

    public void setTbLogEntity(TbLogEntity tbLogEntity) {
        this.tbLogEntity = tbLogEntity;
    }

    public TbUsersEntity getTbUsersEntity() {
        return tbUsersEntity;
    }

    public void setTbUsersEntity(TbUsersEntity tbUsersEntity) {
        this.tbUsersEntity = tbUsersEntity;
    }

    public ImsXuanMixloanBankCardEntity getBankCardEntity() {
        return bankCardEntity;
    }

    public void setBankCardEntity(ImsXuanMixloanBankCardEntity bankCardEntity) {
        this.bankCardEntity = bankCardEntity;
    }

    public com.example.tuosha.model.ImsXuanMixloanBankEntity getBankEntity() {
        return bankEntity;
    }

    public void setBankEntity(com.example.tuosha.model.ImsXuanMixloanBankEntity bankEntity) {
        this.bankEntity = bankEntity;
    }

    public ImsXuanMixloanChannelEntity getChannelEntity() {
        return channelEntity;
    }

    public void setChannelEntity(ImsXuanMixloanChannelEntity channelEntity) {
        this.channelEntity = channelEntity;
    }

    public ImsXuanMixloanChannelSubjectEntity getChannelSubjectEntity() {
        return channelSubjectEntity;
    }

    public void setChannelSubjectEntity(ImsXuanMixloanChannelSubjectEntity channelSubjectEntity) {
        this.channelSubjectEntity = channelSubjectEntity;
    }

    public ImsXuanMixloanCreditcardEntity getCreditcardEntity() {
        return creditcardEntity;
    }

    public void setCreditcardEntity(ImsXuanMixloanCreditcardEntity creditcardEntity) {
        this.creditcardEntity = creditcardEntity;
    }

    public ImsXuanMixloanHelpEntity getHelpEntity() {
        return helpEntity;
    }

    public void setHelpEntity(ImsXuanMixloanHelpEntity helpEntity) {
        this.helpEntity = helpEntity;
    }

    public ImsXuanMixloanLoanEntity getLoanEntity() {
        return loanEntity;
    }

    public void setLoanEntity(ImsXuanMixloanLoanEntity loanEntity) {
        this.loanEntity = loanEntity;
    }

    public ImsXuanMixloanInviterEntity getInviterEntity() {
        return inviterEntity;
    }

    public void setInviterEntity(ImsXuanMixloanInviterEntity inviterEntity) {
        this.inviterEntity = inviterEntity;
    }

    public ImsXuanMixloanMemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(ImsXuanMixloanMemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public ImsXuanMixloanPaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(ImsXuanMixloanPaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public ImsXuanMixloanPosterEntity getPosterEntity() {
        return posterEntity;
    }

    public void setPosterEntity(ImsXuanMixloanPosterEntity posterEntity) {
        this.posterEntity = posterEntity;
    }

    public ImsXuanMixloanProductApplyEntity getProductApplyEntity() {
        return productApplyEntity;
    }

    public void setProductApplyEntity(ImsXuanMixloanProductApplyEntity productApplyEntity) {
        this.productApplyEntity = productApplyEntity;
    }

    public ImsXuanMixloanProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ImsXuanMixloanProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ArrayList<TbAdminEntity> getTbAdminList() {
        return tbAdminList;
    }

    public void setTbAdminList(ArrayList<TbAdminEntity> tbAdminList) {
        this.tbAdminList = tbAdminList;
    }

    public ArrayList<TbLogEntity> getTbLogList() {
        return tbLogList;
    }

    public void setTbLogList(ArrayList<TbLogEntity> tbLogList) {
        this.tbLogList = tbLogList;
    }

    public ArrayList<TbUsersEntity> getTbUsersList() {
        return tbUsersList;
    }

    public void setTbUsersList(ArrayList<TbUsersEntity> tbUsersList) {
        this.tbUsersList = tbUsersList;
    }

    public ArrayList<ImsXuanMixloanBankCardEntity> getBankCardList() {
        return bankCardList;
    }

    public void setBankCardList(ArrayList<ImsXuanMixloanBankCardEntity> bankCardList) {
        this.bankCardList = bankCardList;
    }

    public ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> getBankList() {
        return bankList;
    }

    public void setBankList(ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> bankList) {
        this.bankList = bankList;
    }

    public ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> getImsXuanMixloanBankEntity() {
        return ImsXuanMixloanBankEntity;
    }

    public void setImsXuanMixloanBankEntity(ArrayList<com.example.tuosha.model.ImsXuanMixloanBankEntity> imsXuanMixloanBankEntity) {
        ImsXuanMixloanBankEntity = imsXuanMixloanBankEntity;
    }

    public ArrayList<ImsXuanMixloanChannelEntity> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<ImsXuanMixloanChannelEntity> channelList) {
        this.channelList = channelList;
    }

    public ArrayList<ImsXuanMixloanChannelSubjectEntity> getChannelSubjectList() {
        return channelSubjectList;
    }

    public void setChannelSubjectList(ArrayList<ImsXuanMixloanChannelSubjectEntity> channelSubjectList) {
        this.channelSubjectList = channelSubjectList;
    }

    public ArrayList<ImsXuanMixloanCreditcardEntity> getCreditcardList() {
        return creditcardList;
    }

    public void setCreditcardList(ArrayList<ImsXuanMixloanCreditcardEntity> creditcardList) {
        this.creditcardList = creditcardList;
    }

    public ArrayList<ImsXuanMixloanHelpEntity> getHelpList() {
        return helpList;
    }

    public void setHelpList(ArrayList<ImsXuanMixloanHelpEntity> helpList) {
        this.helpList = helpList;
    }

    public ArrayList<ImsXuanMixloanLoanEntity> getLoanList() {
        return loanList;
    }

    public void setLoanList(ArrayList<ImsXuanMixloanLoanEntity> loanList) {
        this.loanList = loanList;
    }

    public ArrayList<ImsXuanMixloanInviterEntity> getInviterList() {
        return inviterList;
    }

    public void setInviterList(ArrayList<ImsXuanMixloanInviterEntity> inviterList) {
        this.inviterList = inviterList;
    }

    public ArrayList<ImsXuanMixloanMemberEntity> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<ImsXuanMixloanMemberEntity> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<ImsXuanMixloanPaymentEntity> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(ArrayList<ImsXuanMixloanPaymentEntity> paymentList) {
        this.paymentList = paymentList;
    }

    public ArrayList<ImsXuanMixloanPosterEntity> getPosterList() {
        return posterList;
    }

    public void setPosterList(ArrayList<ImsXuanMixloanPosterEntity> posterList) {
        this.posterList = posterList;
    }

    public ArrayList<ImsXuanMixloanProductApplyEntity> getProductApplyList() {
        return productApplyList;
    }

    public void setProductApplyList(ArrayList<ImsXuanMixloanProductApplyEntity> productApplyList) {
        this.productApplyList = productApplyList;
    }

    public ArrayList<ImsXuanMixloanProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<ImsXuanMixloanProductEntity> productList) {
        this.productList = productList;
    }
}
