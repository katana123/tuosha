package com.example.tuosha.model;

import java.math.BigDecimal;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanPaymentEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer uid;
	//
	private Integer msg;
	//
	private Integer createtime;
	//
	private Integer effecttime;
	//
	private Integer days;
	//
	private String tid;
	//
	private BigDecimal fee;

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
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	/**
	 * 获取：
	 */
	public Integer getMsg() {
		return msg;
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
	public void setEffecttime(Integer effecttime) {
		this.effecttime = effecttime;
	}
	/**
	 * 获取：
	 */
	public Integer getEffecttime() {
		return effecttime;
	}
	/**
	 * 设置：
	 */
	public void setDays(Integer days) {
		this.days = days;
	}
	/**
	 * 获取：
	 */
	public Integer getDays() {
		return days;
	}
	/**
	 * 设置：
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
	/**
	 * 获取：
	 */
	public String getTid() {
		return tid;
	}
	/**
	 * 设置：
	 */
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getFee() {
		return fee;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanPaymentEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", uid=" + uid +
				", msg=" + msg +
				", createtime=" + createtime +
				", effecttime=" + effecttime +
				", days=" + days +
				", tid='" + tid + '\'' +
				", fee=" + fee +
				'}';
	}
}
