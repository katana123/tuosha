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
public class ToolsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//金融工具名称
	private String name;
	//
	private String image;
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
	 * 设置：金融工具名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：金融工具名称
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
		return "ToolsEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", link='" + link + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
