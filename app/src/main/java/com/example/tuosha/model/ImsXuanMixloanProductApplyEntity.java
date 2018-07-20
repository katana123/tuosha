package com.example.tuosha.model;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanProductApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer uid;
	//
	private Integer pid;
	//
	private String phone;
	//
	private String certno;
	//
	private String realname;
	//
	private Integer relateMoney;
	//
	private Integer inviter;
	//
	private BigDecimal reBonus;
	//
	private BigDecimal doneBonus;
	//
	private BigDecimal extraBonus;
	//-2邀请用户已注册 -1失败 0已邀请 1已注册 2已下款/发卡
	private Integer status;
	//
	private Integer createtime;
	//
	private Integer degree;

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
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
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
	public void setRelateMoney(Integer relateMoney) {
		this.relateMoney = relateMoney;
	}
	/**
	 * 获取：
	 */
	public Integer getRelateMoney() {
		return relateMoney;
	}
	/**
	 * 设置：
	 */
	public void setInviter(Integer inviter) {
		this.inviter = inviter;
	}
	/**
	 * 获取：
	 */
	public Integer getInviter() {
		return inviter;
	}
	/**
	 * 设置：
	 */
	public void setReBonus(BigDecimal reBonus) {
		this.reBonus = reBonus;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getReBonus() {
		return reBonus;
	}
	/**
	 * 设置：
	 */
	public void setDoneBonus(BigDecimal doneBonus) {
		this.doneBonus = doneBonus;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getDoneBonus() {
		return doneBonus;
	}
	/**
	 * 设置：
	 */
	public void setExtraBonus(BigDecimal extraBonus) {
		this.extraBonus = extraBonus;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getExtraBonus() {
		return extraBonus;
	}
	/**
	 * 设置：-2邀请用户已注册 -1失败 0已邀请 1已注册 2已下款/发卡
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：-2邀请用户已注册 -1失败 0已邀请 1已注册 2已下款/发卡
	 */
	public Integer getStatus() {
		return status;
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
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	/**
	 * 获取：
	 */
	public Integer getDegree() {
		return degree;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanProductApplyEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", uid=" + uid +
				", pid=" + pid +
				", phone='" + phone + '\'' +
				", certno='" + certno + '\'' +
				", realname='" + realname + '\'' +
				", relateMoney=" + relateMoney +
				", inviter=" + inviter +
				", reBonus=" + reBonus +
				", doneBonus=" + doneBonus +
				", extraBonus=" + extraBonus +
				", status=" + status +
				", createtime=" + createtime +
				", degree=" + degree +
				'}';
	}
}
