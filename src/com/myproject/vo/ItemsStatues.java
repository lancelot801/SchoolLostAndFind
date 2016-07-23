package com.myproject.vo;

import java.io.Serializable;

public class ItemsStatues implements Serializable {

	private int statuesId;
	private String statues;
	
	public int getStatuesId() {
		return statuesId;
	}
	public void setStatuesId(int statuesId) {
		this.statuesId = statuesId;
	}
	public String getStatues() {
		return statues;
	}
	public void setStatues(String statues) {
		this.statues = statues;
	}	
}
