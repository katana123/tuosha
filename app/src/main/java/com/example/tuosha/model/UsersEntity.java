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
public class UsersEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//登录名
	private String name;
	//
	private String email;
	//
	private String password;
	//
	private String mobile;
	//用户头像
	private String header;
	//
	private String shareImage;
	//
	private Integer scale;
	//昵称
	private String nickname;
	//openid
	private String openid;
	//用户角色
	private String level;
	//账户状态
	private String status;
	//上级ID
	private Integer parentId;
	//文章状态 0 非会员 1 会员
	private Integer member;
	//
	private Date memberBuyTime;
	//剩余佣金
	private Double money;
	//总佣金
	private Double moneyAll;
	//
	private String rememberToken;
	//
	private Date createdAt;
	//
	private Date updatedAt;

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
	 * 设置：登录名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：登录名
	 */
	public String getName() {
		return name;
	}
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
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：用户头像
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * 获取：用户头像
	 */
	public String getHeader() {
		return header;
	}
	/**
	 * 设置：
	 */
	public void setShareImage(String shareImage) {
		this.shareImage = shareImage;
	}
	/**
	 * 获取：
	 */
	public String getShareImage() {
		return shareImage;
	}
	/**
	 * 设置：
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	/**
	 * 获取：
	 */
	public Integer getScale() {
		return scale;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：用户角色
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：用户角色
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：账户状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：账户状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：上级ID
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级ID
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：文章状态 0 非会员 1 会员
	 */
	public void setMember(Integer member) {
		this.member = member;
	}
	/**
	 * 获取：文章状态 0 非会员 1 会员
	 */
	public Integer getMember() {
		return member;
	}
	/**
	 * 设置：
	 */
	public void setMemberBuyTime(Date memberBuyTime) {
		this.memberBuyTime = memberBuyTime;
	}
	/**
	 * 获取：
	 */
	public Date getMemberBuyTime() {
		return memberBuyTime;
	}
	/**
	 * 设置：剩余佣金
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：剩余佣金
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：总佣金
	 */
	public void setMoneyAll(Double moneyAll) {
		this.moneyAll = moneyAll;
	}
	/**
	 * 获取：总佣金
	 */
	public Double getMoneyAll() {
		return moneyAll;
	}
	/**
	 * 设置：
	 */
	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}
	/**
	 * 获取：
	 */
	public String getRememberToken() {
		return rememberToken;
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


	@Override
	public String toString() {
		return "UsersEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", mobile='" + mobile + '\'' +
				", header='" + header + '\'' +
				", shareImage='" + shareImage + '\'' +
				", scale=" + scale +
				", nickname='" + nickname + '\'' +
				", openid='" + openid + '\'' +
				", level='" + level + '\'' +
				", status='" + status + '\'' +
				", parentId=" + parentId +
				", member=" + member +
				", memberBuyTime=" + memberBuyTime +
				", money=" + money +
				", moneyAll=" + moneyAll +
				", rememberToken='" + rememberToken + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
