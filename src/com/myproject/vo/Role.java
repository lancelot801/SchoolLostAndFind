package com.myproject.vo;

import java.io.Serializable;

/**
 * �û��Ľ�ɫ
 * 
 * @author dntch
 * 
 */
public class Role implements Serializable {

	private int roleId;
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
