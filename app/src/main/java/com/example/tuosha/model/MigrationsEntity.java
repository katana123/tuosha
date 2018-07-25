package com.example.tuosha.model;

import java.io.Serializable;
import java.util.Date;




/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public class MigrationsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String migration;
	//
	private Integer batch;

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
	public void setMigration(String migration) {
		this.migration = migration;
	}
	/**
	 * 获取：
	 */
	public String getMigration() {
		return migration;
	}
	/**
	 * 设置：
	 */
	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	/**
	 * 获取：
	 */
	public Integer getBatch() {
		return batch;
	}


	@Override
	public String toString() {
		return "MigrationsEntity{" +
				"id=" + id +
				", migration='" + migration + '\'' +
				", batch=" + batch +
				'}';
	}
}
