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
public class PostsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	public Integer id;
	//文章名称
	public String name;
	//浏览量
	public Integer views;
	//
	public String image;
	//详情介绍
	public String intro;
	//
	public Integer userId;
	//
	public Integer categoryId;
	//
	public Date createdAt;
	//
	public Date updatedAt;
	//
	public Date deletedAt;

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
	 * 设置：文章名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：文章名称
	 */
	public String getName() {
		return name;
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
	 * 设置：详情介绍
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：详情介绍
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：
	 */
	public Integer getCategoryId() {
		return categoryId;
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
		return "PostsEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", views=" + views +
				", image='" + image + '\'' +
				", intro='" + intro + '\'' +
				", userId=" + userId +
				", categoryId=" + categoryId +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
