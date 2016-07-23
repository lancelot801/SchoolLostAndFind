package com.myproject.vo;

import java.io.Serializable;

public class FindingRecords implements Serializable {

	private int findRecordsId;
	private Account account;
	private Items items;
	private String getTime;
	
	public FindingRecords(){
		this.account = new Account();
		this.items = new Items();
	}
	
	public int getFindRecordsId() {
		return findRecordsId;
	}
	public void setFindRecordsId(int findRecordsId) {
		this.findRecordsId = findRecordsId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}	
}
