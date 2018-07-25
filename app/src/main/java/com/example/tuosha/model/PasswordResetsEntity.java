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
public class PasswordResetsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private String email;
	//
	private String token;
	//
	private Date createdAt;

	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：
	 */
	public String getToken() {
		return token;
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


	@Override
	public String toString() {
		return "PasswordResetsEntity{" +
				"email='" + email + '\'' +
				", token='" + token + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}
