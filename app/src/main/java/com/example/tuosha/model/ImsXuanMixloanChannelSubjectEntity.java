package com.example.tuosha.model;


import java.io.Serializable;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class ImsXuanMixloanChannelSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer type;
	//
	private Integer createtime;
	//
	private String extInfo;
	//
	private String name;

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
	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}
	/**
	 * 获取：
	 */
	public String getExtInfo() {
		return extInfo;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanChannelSubjectEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", type=" + type +
				", createtime=" + createtime +
				", extInfo='" + extInfo + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
