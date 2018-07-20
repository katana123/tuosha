package com.example.tuosha.model;


import java.io.Serializable;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanPosterEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer uid;
	//
	private Integer type;
	//
	private Integer pid;
	//
	private Integer createtime;
	//
	private String poster;

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
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
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
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * 获取：
	 */
	public String getPoster() {
		return poster;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanPosterEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", uid=" + uid +
				", type=" + type +
				", pid=" + pid +
				", createtime=" + createtime +
				", poster='" + poster + '\'' +
				'}';
	}
}
