package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class ImsXuanMixloanBankCardEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer iconType;
	//
	private Integer recommendType;
	//
	private Integer sort;
	//
	private Integer yearFee;
	//
	private String cardType;
	//
	private Integer bankId;
	//
	private Integer applyNums;
	//
	private Integer createtime;
	//
	private String extInfo;
	//
	private String name;

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
	public void setIconType(Integer iconType) {
		this.iconType = iconType;
	}
	/**
	 * 获取：
	 */
	public Integer getIconType() {
		return iconType;
	}
	/**
	 * 设置：
	 */
	public void setRecommendType(Integer recommendType) {
		this.recommendType = recommendType;
	}
	/**
	 * 获取：
	 */
	public Integer getRecommendType() {
		return recommendType;
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
	public void setYearFee(Integer yearFee) {
		this.yearFee = yearFee;
	}
	/**
	 * 获取：
	 */
	public Integer getYearFee() {
		return yearFee;
	}
	/**
	 * 设置：
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置：
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	/**
	 * 获取：
	 */
	public Integer getBankId() {
		return bankId;
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

	 

	@Override
	public String toString() {
		return "ImsXuanMixloanBankCardEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", iconType=" + iconType +
				", recommendType=" + recommendType +
				", sort=" + sort +
				", yearFee=" + yearFee +
				", cardType='" + cardType + '\'' +
				", bankId=" + bankId +
				", applyNums=" + applyNums +
				", createtime=" + createtime +
				", extInfo='" + extInfo + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
