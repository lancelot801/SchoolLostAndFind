package com.myproject.vo;

import java.io.Serializable;

public class Account implements Serializable {

	private String userId;
	private String password;
	private Role role;

	public Account(){
		this.role = new Role();//ʵ����һ������
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
