package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class ImsXuanMixloanCreditcardEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer uid;
	//
	private String realname;
	//
	private String certno;
	//
	private String banknum;
	//
	private String bankname;
	//
	private String phone;
	//
	private Integer createtime;

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
	public void setBanknum(String banknum) {
		this.banknum = banknum;
	}
	/**
	 * 获取：
	 */
	public String getBanknum() {
		return banknum;
	}
	/**
	 * 设置：
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * 获取：
	 */
	public String getBankname() {
		return bankname;
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
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreatetime() {
		return createtime;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanCreditcardEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", uid=" + uid +
				", realname='" + realname + '\'' +
				", certno='" + certno + '\'' +
				", banknum='" + banknum + '\'' +
				", bankname='" + bankname + '\'' +
				", phone='" + phone + '\'' +
				", createtime=" + createtime +
				'}';
	}
}
