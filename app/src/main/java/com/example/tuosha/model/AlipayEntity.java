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
public class AlipayEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String body;
	//
	private String subject;
	//
	private String productcode;
	//
	private String notifyurl;
	//
	private String price;

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
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 获取：
	 */
	public String getBody() {
		return body;
	}
	/**
	 * 设置：
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：
	 */
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	/**
	 * 获取：
	 */
	public String getProductcode() {
		return productcode;
	}
	/**
	 * 设置：
	 */
	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}
	/**
	 * 获取：
	 */
	public String getNotifyurl() {
		return notifyurl;
	}
	/**
	 * 设置：
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public String getPrice() {
		return price;
	}


    @Override
    public String toString() {
        return "AlipayEntity{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                ", productcode='" + productcode + '\'' +
                ", notifyurl='" + notifyurl + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
