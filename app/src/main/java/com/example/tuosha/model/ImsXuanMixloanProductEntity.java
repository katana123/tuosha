package com.example.tuosha.model;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//关联id
	private Integer relateId;
	//1信用卡，2贷款
	private Integer type;
	//是否上架
	private Integer isShow;
	//是否热门
	private Integer isHot;
	//是否新品
	private Integer isNew;
	//结算时间
	private Integer countTime;
	//结束奖励方式，0不奖励，1奖励现金，2奖励点数
	private Integer doneRewardType;
	//结束奖励多少元
	private Integer doneRewardMoney;
	//结束奖励多少点
	private BigDecimal doneRewardPer;
	//填写资料奖励方式，0不奖励，1奖励现金，2奖励点数
	private Integer reRewardType;
	//填写资料奖励多少元
	private Integer reRewardMoney;
	//填写资料奖励多少点
	private BigDecimal reRewardPer;
	//
	private Integer createtime;
	//
	private String name;
	//
	private String extInfo;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}
	/**
	 * 获取：
	 */
	public Integer getUniacid() {
		return uniacid;
	}
	/**
	 * 设置：关联id
	 */
	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}
	/**
	 * 获取：关联id
	 */
	public Integer getRelateId() {
		return relateId;
	}
	/**
	 * 设置：1信用卡，2贷款
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1信用卡，2贷款
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：是否上架
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否上架
	 */
	public Integer getIsShow() {
		return isShow;
	}
	/**
	 * 设置：是否热门
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否热门
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：是否新品
	 */
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	/**
	 * 获取：是否新品
	 */
	public Integer getIsNew() {
		return isNew;
	}
	/**
	 * 设置：结算时间
	 */
	public void setCountTime(Integer countTime) {
		this.countTime = countTime;
	}
	/**
	 * 获取：结算时间
	 */
	public Integer getCountTime() {
		return countTime;
	}
	/**
	 * 设置：结束奖励方式，0不奖励，1奖励现金，2奖励点数
	 */
	public void setDoneRewardType(Integer doneRewardType) {
		this.doneRewardType = doneRewardType;
	}
	/**
	 * 获取：结束奖励方式，0不奖励，1奖励现金，2奖励点数
	 */
	public Integer getDoneRewardType() {
		return doneRewardType;
	}
	/**
	 * 设置：结束奖励多少元
	 */
	public void setDoneRewardMoney(Integer doneRewardMoney) {
		this.doneRewardMoney = doneRewardMoney;
	}
	/**
	 * 获取：结束奖励多少元
	 */
	public Integer getDoneRewardMoney() {
		return doneRewardMoney;
	}
	/**
	 * 设置：结束奖励多少点
	 */
	public void setDoneRewardPer(BigDecimal doneRewardPer) {
		this.doneRewardPer = doneRewardPer;
	}
	/**
	 * 获取：结束奖励多少点
	 */
	public BigDecimal getDoneRewardPer() {
		return doneRewardPer;
	}
	/**
	 * 设置：填写资料奖励方式，0不奖励，1奖励现金，2奖励点数
	 */
	public void setReRewardType(Integer reRewardType) {
		this.reRewardType = reRewardType;
	}
	/**
	 * 获取：填写资料奖励方式，0不奖励，1奖励现金，2奖励点数
	 */
	public Integer getReRewardType() {
		return reRewardType;
	}
	/**
	 * 设置：填写资料奖励多少元
	 */
	public void setReRewardMoney(Integer reRewardMoney) {
		this.reRewardMoney = reRewardMoney;
	}
	/**
	 * 获取：填写资料奖励多少元
	 */
	public Integer getReRewardMoney() {
		return reRewardMoney;
	}
	/**
	 * 设置：填写资料奖励多少点
	 */
	public void setReRewardPer(BigDecimal reRewardPer) {
		this.reRewardPer = reRewardPer;
	}
	/**
	 * 获取：填写资料奖励多少点
	 */
	public BigDecimal getReRewardPer() {
		return reRewardPer;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	/**
	 * 获取：
	 */
	public String getExtInfo() {
		return extInfo;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanProductEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", relateId=" + relateId +
				", type=" + type +
				", isShow=" + isShow +
				", isHot=" + isHot +
				", isNew=" + isNew +
				", countTime=" + countTime +
				", doneRewardType=" + doneRewardType +
				", doneRewardMoney=" + doneRewardMoney +
				", doneRewardPer=" + doneRewardPer +
				", reRewardType=" + reRewardType +
				", reRewardMoney=" + reRewardMoney +
				", reRewardPer=" + reRewardPer +
				", createtime=" + createtime +
				", name='" + name + '\'' +
				", extInfo='" + extInfo + '\'' +
				'}';
	}
}
