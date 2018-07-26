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
public class JqCatsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	public Integer id;
	//借钱分类
	public String name;
	//
	public String image;
	//
	public Integer sort;
	//
	public Date createdAt;
	//
	public Date updatedAt;
	//
	public Date deletedAt;

	public JqCatsEntity() {
	}

	public JqCatsEntity(Integer id, String name, String image, Integer sort, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.sort = sort;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

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
	 * 设置：借钱分类
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：借钱分类
	 */
	public String getName() {
		return name;
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
		return "JqCatsEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", sort=" + sort +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
