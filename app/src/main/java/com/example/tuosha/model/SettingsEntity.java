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
public class SettingsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//关于我们
	private String intro;
	//代理介绍
	private String daili;
	//分享的页面内容
	private String shareContent;
	//网站名称
	private String name;
	//提成比例
	private Integer scale;
	//
	private Integer shoufeiXinyongka;
	//
	private Integer shoufeiJieqian;
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
	 * 设置：关于我们
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：关于我们
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：代理介绍
	 */
	public void setDaili(String daili) {
		this.daili = daili;
	}
	/**
	 * 获取：代理介绍
	 */
	public String getDaili() {
		return daili;
	}
	/**
	 * 设置：分享的页面内容
	 */
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	/**
	 * 获取：分享的页面内容
	 */
	public String getShareContent() {
		return shareContent;
	}
	/**
	 * 设置：网站名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：网站名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：提成比例
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	/**
	 * 获取：提成比例
	 */
	public Integer getScale() {
		return scale;
	}
	/**
	 * 设置：
	 */
	public void setShoufeiXinyongka(Integer shoufeiXinyongka) {
		this.shoufeiXinyongka = shoufeiXinyongka;
	}
	/**
	 * 获取：
	 */
	public Integer getShoufeiXinyongka() {
		return shoufeiXinyongka;
	}
	/**
	 * 设置：
	 */
	public void setShoufeiJieqian(Integer shoufeiJieqian) {
		this.shoufeiJieqian = shoufeiJieqian;
	}
	/**
	 * 获取：
	 */
	public Integer getShoufeiJieqian() {
		return shoufeiJieqian;
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
		return "SettingsEntity{" +
				"id=" + id +
				", intro='" + intro + '\'' +
				", daili='" + daili + '\'' +
				", shareContent='" + shareContent + '\'' +
				", name='" + name + '\'' +
				", scale=" + scale +
				", shoufeiXinyongka=" + shoufeiXinyongka +
				", shoufeiJieqian=" + shoufeiJieqian +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
