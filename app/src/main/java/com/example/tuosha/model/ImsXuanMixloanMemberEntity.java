package com.example.tuosha.model;


import java.io.Serializable;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanMemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uid;
	//
	private Integer uniacid;
	//
	private String certno;
	//是否开启
	private Integer status;
	//
	private String nickname;
	//
	private String openid;
	//
	private String realname;
	//
	private String wechat;
	//
	private String city;
	//
	private String province;
	//
	private String country;
	//
	private String avatar;
	//
	private Integer sex;
	//
	private Integer createtime;
	//
	private String inviter;
	//
	private String phone;
	//
	private String pass;
	//
	private Integer level;
	//
	private String qrcode;
	//
	private String area;

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
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：
	 */
	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}
	/**
	 * 获取：
	 */
	public Integer getUniacid() {
		return uniacid;
	}
	/**
	 * 设置：
	 */
	public void setCertno(String certno) {
		this.certno = certno;
	}
	/**
	 * 获取：
	 */
	public String getCertno() {
		return certno;
	}
	/**
	 * 设置：是否开启
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否开启
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	/**
	 * 获取：
	 */
	public String getInviter() {
		return inviter;
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
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * 获取：
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * 设置：
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 获取：
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * 设置：
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：
	 */
	public String getArea() {
		return area;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanMemberEntity{" +
				"id=" + id +
				", uid=" + uid +
				", uniacid=" + uniacid +
				", certno='" + certno + '\'' +
				", status=" + status +
				", nickname='" + nickname + '\'' +
				", openid='" + openid + '\'' +
				", realname='" + realname + '\'' +
				", wechat='" + wechat + '\'' +
				", city='" + city + '\'' +
				", province='" + province + '\'' +
				", country='" + country + '\'' +
				", avatar='" + avatar + '\'' +
				", sex=" + sex +
				", createtime=" + createtime +
				", inviter='" + inviter + '\'' +
				", phone='" + phone + '\'' +
				", pass='" + pass + '\'' +
				", level=" + level +
				", qrcode='" + qrcode + '\'' +
				", area='" + area + '\'' +
				'}';
	}
}
