package com.example.tuosha.model;

import java.util.Date;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbLogEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String username;
	//操作
	private String operation;
	//执行方法
	private String method;
	//请求参数
	private String params;
	//ip
	private String ip;
	//操作时间
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：操作
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：执行方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：执行方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：请求参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：请求参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：操作时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	@Override
	public String toString() {
		return "TbLogEntity{" +
				"id=" + id +
				", username='" + username + '\'' +
				", operation='" + operation + '\'' +
				", method='" + method + '\'' +
				", params='" + params + '\'' +
				", ip='" + ip + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
