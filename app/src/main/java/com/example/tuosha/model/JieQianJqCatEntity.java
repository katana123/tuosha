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
public class JieQianJqCatEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer jieQianId;
	//
	private Integer jqCatId;
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
	 * 设置：
	 */
	public void setJieQianId(Integer jieQianId) {
		this.jieQianId = jieQianId;
	}
	/**
	 * 获取：
	 */
	public Integer getJieQianId() {
		return jieQianId;
	}
	/**
	 * 设置：
	 */
	public void setJqCatId(Integer jqCatId) {
		this.jqCatId = jqCatId;
	}
	/**
	 * 获取：
	 */
	public Integer getJqCatId() {
		return jqCatId;
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
		return "JieQianJqCatEntity{" +
				"id=" + id +
				", jieQianId=" + jieQianId +
				", jqCatId=" + jqCatId +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
