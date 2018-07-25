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
public class ProductsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//名称
	private String name;
	//图片
	private String image;
	//销售价格
	private Double price;
	//小字描述
	private String des;
	//销售数量
	private Integer sales;
	//说明信息
	private String intro;
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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
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
	 * 设置：销售价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：销售价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：小字描述
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * 获取：小字描述
	 */
	public String getDes() {
		return des;
	}
	/**
	 * 设置：销售数量
	 */
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	/**
	 * 获取：销售数量
	 */
	public Integer getSales() {
		return sales;
	}
	/**
	 * 设置：说明信息
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：说明信息
	 */
	public String getIntro() {
		return intro;
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
		return "ProductsEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", price=" + price +
				", des='" + des + '\'' +
				", sales=" + sales +
				", intro='" + intro + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
