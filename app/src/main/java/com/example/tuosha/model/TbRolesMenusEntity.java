package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbRolesMenusEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long menuId;
	//
	private Long roleId;

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
	 * 设置：
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Long getRoleId() {
		return roleId;
	}


	@Override
	public String toString() {
		return "TbRolesMenusEntity{" +
				"menuId=" + menuId +
				", roleId=" + roleId +
				'}';
	}
}
