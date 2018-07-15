package com.example.tuosha.model;

import java.math.BigDecimal;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanLoanEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private String name;
	//
	private String type;
	//
	private Integer sort;
	//
	private Integer moneyHigh;
	//
	private BigDecimal rate;
	//1是天息，30是月息
	private Integer rateType;
	//
	private Integer timeBlow;
	//
	private Integer timeHigh;
	//
	private Integer applyNums;
	//
	private Integer createtime;
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
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setMoneyHigh(Integer moneyHigh) {
		this.moneyHigh = moneyHigh;
	}
	/**
	 * 获取：
	 */
	public Integer getMoneyHigh() {
		return moneyHigh;
	}
	/**
	 * 设置：
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getRate() {
		return rate;
	}
	/**
	 * 设置：1是天息，30是月息
	 */
	public void setRateType(Integer rateType) {
		this.rateType = rateType;
	}
	/**
	 * 获取：1是天息，30是月息
	 */
	public Integer getRateType() {
		return rateType;
	}
	/**
	 * 设置：
	 */
	public void setTimeBlow(Integer timeBlow) {
		this.timeBlow = timeBlow;
	}
	/**
	 * 获取：
	 */
	public Integer getTimeBlow() {
		return timeBlow;
	}
	/**
	 * 设置：
	 */
	public void setTimeHigh(Integer timeHigh) {
		this.timeHigh = timeHigh;
	}
	/**
	 * 获取：
	 */
	public Integer getTimeHigh() {
		return timeHigh;
	}
	/**
	 * 设置：
	 */
	public void setApplyNums(Integer applyNums) {
		this.applyNums = applyNums;
	}
	/**
	 * 获取：
	 */
	public Integer getApplyNums() {
		return applyNums;
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
		return "ImsXuanMixloanLoanEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", sort=" + sort +
				", moneyHigh=" + moneyHigh +
				", rate=" + rate +
				", rateType=" + rateType +
				", timeBlow=" + timeBlow +
				", timeHigh=" + timeHigh +
				", applyNums=" + applyNums +
				", createtime=" + createtime +
				", extInfo='" + extInfo + '\'' +
				'}';
	}
}
