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
public class MoneyRecordsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//金额
	private Double money;
	//状态  已完成 处理中 取消 拒绝
	private String status;
	//类型 收入 提现
	private String type;
	//说明信息
	private String info;
	//备注
	private String remark;
	//银行名称
	private String name;
	//
	private String payNo;
	//支行
	private String bankName;
	//用户名
	private String userName;
	//手机号
	private String mobile;
	//账号
	private String count;
	//
	private Integer userId;
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
	 * 设置：金额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：状态  已完成 处理中 取消 拒绝
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态  已完成 处理中 取消 拒绝
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型 收入 提现
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型 收入 提现
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：说明信息
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：说明信息
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：银行名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：银行名称
	 */
	public String getName() {
		return name;
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
	 * 设置：支行
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：支行
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：账号
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * 获取：账号
	 */
	public String getCount() {
		return count;
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
		return "MoneyRecordsEntity{" +
				"id=" + id +
				", money=" + money +
				", status='" + status + '\'' +
				", type='" + type + '\'' +
				", info='" + info + '\'' +
				", remark='" + remark + '\'' +
				", name='" + name + '\'' +
				", payNo='" + payNo + '\'' +
				", bankName='" + bankName + '\'' +
				", userName='" + userName + '\'' +
				", mobile='" + mobile + '\'' +
				", count='" + count + '\'' +
				", userId=" + userId +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
