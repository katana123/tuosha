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
public class MobileversionEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer version;
	//
	private String url;
	//
	private String title;
	//
	private String content;

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
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
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
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}


	@Override
	public String toString() {
		return "MobileversionEntity{" +
				"id=" + id +
				", version=" + version +
				", url='" + url + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
