package com.example.tuosha.model;


import java.io.Serializable;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class ImsXuanMixloanChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private Integer subjectId;
	//
	private Integer type;
	//
	private Integer isHot;
	//
	private String title;
	//
	private Integer sort;
	//
	private Integer applyNums;
	//
	private Integer createtime;
	//
	private String extInfo;

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
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：
	 */
	public Integer getSubjectId() {
		return subjectId;
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
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setApplyNums(Integer applyNums) {
		this.applyNums = applyNums;
	}
	/**
	 * 获取：
	 */
	public Integer getApplyNums() {
		return applyNums;
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


	@Override
	public String toString() {
		return "ImsXuanMixloanChannelEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", subjectId=" + subjectId +
				", type=" + type +
				", isHot=" + isHot +
				", title='" + title + '\'' +
				", sort=" + sort +
				", applyNums=" + applyNums +
				", createtime=" + createtime +
				", extInfo='" + extInfo + '\'' +
				'}';
	}
}
