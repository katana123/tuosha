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
public class HkjsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//黑科技名称
	private String name;
	//介绍
	private String intro;
	//
	private Integer view;
	//图片
	private String image;
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
	 * 设置：黑科技名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：黑科技名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：
	 */
	public void setView(Integer view) {
		this.view = view;
	}
	/**
	 * 获取：
	 */
	public Integer getView() {
		return view;
	}
	/**
	 * 设置：图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：图片
	 */
	public String getImage() {
		return image;
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
		return "HkjsEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", intro='" + intro + '\'' +
				", view=" + view +
				", image='" + image + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
