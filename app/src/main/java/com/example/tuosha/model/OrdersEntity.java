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
public class OrdersEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer userId;
	//
	private Double money;
	//
	private String payNo;
	//
	private String payStatus;
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
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：
	 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	/**
	 * 获取：
	 */
	public String getPayNo() {
		return payNo;
	}
	/**
	 * 设置：
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：
	 */
	public String getPayStatus() {
		return payStatus;
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
		return "OrdersEntity{" +
				"id=" + id +
				", userId=" + userId +
				", money=" + money +
				", payNo='" + payNo + '\'' +
				", payStatus='" + payStatus + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
