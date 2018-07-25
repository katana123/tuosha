package com.example.tuosha.model;

import java.io.Serializable;
import java.util.Date;




/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public class XinYongKasEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//信用卡名称
	private String name;
	//优势
	private String advantage;
	//
	private String image;
	//浏览量
	private Integer views;
	//通过率%
	private Double pass;
	//申请流程
	private String liucheng;
	//申请条件
	private String tiaojian;
	//申请材料
	private String cailiao;
	//
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
	 * 设置：信用卡名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：信用卡名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：优势
	 */
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	/**
	 * 获取：优势
	 */
	public String getAdvantage() {
		return advantage;
	}
	/**
	 * 设置：
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：浏览量
	 */
	public void setViews(Integer views) {
		this.views = views;
	}
	/**
	 * 获取：浏览量
	 */
	public Integer getViews() {
		return views;
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
	 * 设置：申请流程
	 */
	public void setLiucheng(String liucheng) {
		this.liucheng = liucheng;
	}
	/**
	 * 获取：申请流程
	 */
	public String getLiucheng() {
		return liucheng;
	}
	/**
	 * 设置：申请条件
	 */
	public void setTiaojian(String tiaojian) {
		this.tiaojian = tiaojian;
	}
	/**
	 * 获取：申请条件
	 */
	public String getTiaojian() {
		return tiaojian;
	}
	/**
	 * 设置：申请材料
	 */
	public void setCailiao(String cailiao) {
		this.cailiao = cailiao;
	}
	/**
	 * 获取：申请材料
	 */
	public String getCailiao() {
		return cailiao;
	}
	/**
	 * 设置：
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * 获取：
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
		return "XinYongKasEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", advantage='" + advantage + '\'' +
				", image='" + image + '\'' +
				", views=" + views +
				", pass=" + pass +
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
