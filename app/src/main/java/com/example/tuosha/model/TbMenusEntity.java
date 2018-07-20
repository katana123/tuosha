package com.example.tuosha.model;


import java.io.Serializable;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbMenusEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long menuId;
	//菜单名
	private String title;
	//图标
	private String icon;
	//资源地址
	private String href;
	//权限
	private String perms;
	//true：展开，false：不展开
	private String spread;
	//父节点
	private Long parentId;

	/**
	 * 设置：
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：
	 */
	public Long getMenuId() {
		return menuId;
	}
	/**
	 * 设置：菜单名
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：菜单名
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：资源地址
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * 获取：资源地址
	 */
	public String getHref() {
		return href;
	}
	/**
	 * 设置：权限
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}
	/**
	 * 获取：权限
	 */
	public String getPerms() {
		return perms;
	}
	/**
	 * 设置：true：展开，false：不展开
	 */
	public void setSpread(String spread) {
		this.spread = spread;
	}
	/**
	 * 获取：true：展开，false：不展开
	 */
	public String getSpread() {
		return spread;
	}
	/**
	 * 设置：父节点
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父节点
	 */
	public Long getParentId() {
		return parentId;
	}


	@Override
	public String toString() {
		return "TbMenusEntity{" +
				"menuId=" + menuId +
				", title='" + title + '\'' +
				", icon='" + icon + '\'' +
				", href='" + href + '\'' +
				", perms='" + perms + '\'' +
				", spread='" + spread + '\'' +
				", parentId=" + parentId +
				'}';
	}
}
