package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanInviterEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//邀请者
	private Integer uid;
	//被邀请者
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
	 * 设置：邀请者
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：邀请者
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：被邀请者
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：被邀请者
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
		return "ImsXuanMixloanInviterEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", uid=" + uid +
				", phone='" + phone + '\'' +
				", createtime=" + createtime +
				'}';
	}
}
