package com.myproject.vo;

import java.io.Serializable;

public class User implements Serializable {

	private int userInfoId;
	private Account userId;
	private String userName;
	private String gender; 
	private String email;
	private String phoneNumber;
	private String DetailAddress;

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Account getUserId() {
		return userId;
	}

	public void setUserId(Account userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {		 
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDetailAddress() {
		return DetailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		DetailAddress = detailAddress;
	}
}
