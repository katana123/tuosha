package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public class ImsXuanMixloanHelpEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uniacid;
	//
	private String title;
	//
	private String extInfo;
	//
	private Integer createtime;
	//1帮助2公告
	private Integer type;

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
	 * 设置：1帮助2公告
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1帮助2公告
	 */
	public Integer getType() {
		return type;
	}


	@Override
	public String toString() {
		return "ImsXuanMixloanHelpEntity{" +
				"id=" + id +
				", uniacid=" + uniacid +
				", title='" + title + '\'' +
				", extInfo='" + extInfo + '\'' +
				", createtime=" + createtime +
				", type=" + type +
				'}';
	}
}
