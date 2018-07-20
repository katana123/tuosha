package com.example.tuosha.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbAdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//管理员id
	private Long id;
	//用户名
	private String username;
	//密码
	private String password;
	//
	private String salt;
	//全名
	private String fullname;
	//
	private String eMail;
	//性别：0女，1男,2保密
	private String sex;
	//
	private Date birthday;
	//地址
	private String address;
	//手机号
	private String phone;
	//角色编号
	private Long roleId;

	/**
	 * 设置：管理员id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：管理员id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：全名
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * 获取：全名
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * 设置：
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 * 获取：
	 */
	public String getEMail() {
		return eMail;
	}
	/**
	 * 设置：性别：0女，1男,2保密
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别：0女，1男,2保密
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：角色编号
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色编号
	 */
	public Long getRoleId() {
		return roleId;
	}


	@Override
	public String toString() {
		return "TbAdminEntity{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", fullname='" + fullname + '\'' +
				", eMail='" + eMail + '\'' +
				", sex='" + sex + '\'' +
				", birthday=" + birthday +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", roleId=" + roleId +
				'}';
	}
}
