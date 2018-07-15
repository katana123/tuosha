package com.example.tuosha.model;

import java.util.Date;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbUsersEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long uid;
	//
	private String eMail;
	//昵称：唯一
	private String nickname;
	//
	private String password;
	//0:女，1:男，2：保密
	private String sex;
	//
	private Date birthday;
	//
	private String address;
	//
	private String phone;
	//
	private String eCode;
	//0:未激活，1，正常，2，禁用
	private String status;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Long getUid() {
		return uid;
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
	 * 设置：昵称：唯一
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称：唯一
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：0:女，1:男，2：保密
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0:女，1:男，2：保密
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
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setECode(String eCode) {
		this.eCode = eCode;
	}
	/**
	 * 获取：
	 */
	public String getECode() {
		return eCode;
	}
	/**
	 * 设置：0:未激活，1，正常，2，禁用
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0:未激活，1，正常，2，禁用
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}


	@Override
	public String toString() {
		return "TbUsersEntity{" +
				"uid=" + uid +
				", eMail='" + eMail + '\'' +
				", nickname='" + nickname + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", birthday=" + birthday +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", eCode='" + eCode + '\'' +
				", status='" + status + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
