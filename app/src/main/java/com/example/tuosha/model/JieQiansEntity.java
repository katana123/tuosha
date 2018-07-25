package com.example.tuosha.model;

import java.io.Serializable;
import java.util.Date;




/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public class JieQiansEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//借钱平台名称
	private String name;
	//特点
	private String advantage;
	//LOGO
	private String image;
	//浏览量
	private Integer view;
	//文章状态 0 不热门 1 热门
	private Integer hot;
	//通过率%
	private Double pass;
	//最低借款
	private Integer min;
	//最高借款
	private Integer max;
	//借款期限单位
	private String timeUnit;
	//最低借款期限
	private Integer minTime;
	//最高借款
	private Integer maxTime;
	//利率%
	private Double rate;
	//放款时间
	private String fangkuanTime;
	//放款流程
	private String liucheng;
	//放款条件
	private String tiaojian;
	//放款材料
	private String cailiao;
	//跳转链接
	private String link;
	//
	private Date createdAt;
	//
	private Date updatedAt;
	//
	private Date deletedAt;

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
	 * 设置：借钱平台名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：借钱平台名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：特点
	 */
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	/**
	 * 获取：特点
	 */
	public String getAdvantage() {
		return advantage;
	}
	/**
	 * 设置：LOGO
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：LOGO
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：浏览量
	 */
	public void setView(Integer view) {
		this.view = view;
	}
	/**
	 * 获取：浏览量
	 */
	public Integer getView() {
		return view;
	}
	/**
	 * 设置：文章状态 0 不热门 1 热门
	 */
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	/**
	 * 获取：文章状态 0 不热门 1 热门
	 */
	public Integer getHot() {
		return hot;
	}
	/**
	 * 设置：通过率%
	 */
	public void setPass(Double pass) {
		this.pass = pass;
	}
	/**
	 * 获取：通过率%
	 */
	public Double getPass() {
		return pass;
	}
	/**
	 * 设置：最低借款
	 */
	public void setMin(Integer min) {
		this.min = min;
	}
	/**
	 * 获取：最低借款
	 */
	public Integer getMin() {
		return min;
	}
	/**
	 * 设置：最高借款
	 */
	public void setMax(Integer max) {
		this.max = max;
	}
	/**
	 * 获取：最高借款
	 */
	public Integer getMax() {
		return max;
	}
	/**
	 * 设置：借款期限单位
	 */
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	/**
	 * 获取：借款期限单位
	 */
	public String getTimeUnit() {
		return timeUnit;
	}
	/**
	 * 设置：最低借款期限
	 */
	public void setMinTime(Integer minTime) {
		this.minTime = minTime;
	}
	/**
	 * 获取：最低借款期限
	 */
	public Integer getMinTime() {
		return minTime;
	}
	/**
	 * 设置：最高借款
	 */
	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}
	/**
	 * 获取：最高借款
	 */
	public Integer getMaxTime() {
		return maxTime;
	}
	/**
	 * 设置：利率%
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/**
	 * 获取：利率%
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * 设置：放款时间
	 */
	public void setFangkuanTime(String fangkuanTime) {
		this.fangkuanTime = fangkuanTime;
	}
	/**
	 * 获取：放款时间
	 */
	public String getFangkuanTime() {
		return fangkuanTime;
	}
	/**
	 * 设置：放款流程
	 */
	public void setLiucheng(String liucheng) {
		this.liucheng = liucheng;
	}
	/**
	 * 获取：放款流程
	 */
	public String getLiucheng() {
		return liucheng;
	}
	/**
	 * 设置：放款条件
	 */
	public void setTiaojian(String tiaojian) {
		this.tiaojian = tiaojian;
	}
	/**
	 * 获取：放款条件
	 */
	public String getTiaojian() {
		return tiaojian;
	}
	/**
	 * 设置：放款材料
	 */
	public void setCailiao(String cailiao) {
		this.cailiao = cailiao;
	}
	/**
	 * 获取：放款材料
	 */
	public String getCailiao() {
		return cailiao;
	}
	/**
	 * 设置：跳转链接
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * 获取：跳转链接
	 */
	public String getLink() {
		return link;
	}
	/**
	 * 设置：
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * 设置：
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	/**
	 * 获取：
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}


	@Override
	public String toString() {
		return "JieQiansEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", advantage='" + advantage + '\'' +
				", image='" + image + '\'' +
				", view=" + view +
				", hot=" + hot +
				", pass=" + pass +
				", min=" + min +
				", max=" + max +
				", timeUnit='" + timeUnit + '\'' +
				", minTime=" + minTime +
				", maxTime=" + maxTime +
				", rate=" + rate +
				", fangkuanTime='" + fangkuanTime + '\'' +
				", liucheng='" + liucheng + '\'' +
				", tiaojian='" + tiaojian + '\'' +
				", cailiao='" + cailiao + '\'' +
				", link='" + link + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
