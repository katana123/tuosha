package com.example.tuosha.model;


/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public class TbRolesEntity {
	private static final long serialVersionUID = 1L;
	
	//角色编号
	private Long roleId;
	//角色名
	private String roleName;
	//
	private String roleRemark;

	/**
	 * 设置：角色编号
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色编号
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：角色名
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：角色名
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 设置：
	 */
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	/**
	 * 获取：
	 */
	public String getRoleRemark() {
		return roleRemark;
	}


	@Override
	public String toString() {
		return "TbRolesEntity{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", roleRemark='" + roleRemark + '\'' +
				'}';
	}
}
