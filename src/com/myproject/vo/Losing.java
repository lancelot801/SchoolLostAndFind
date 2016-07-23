package com.myproject.vo;

import java.io.Serializable;

public class Losing implements Serializable {

	private int losingId;
	private Items items;
	private Account finder;
	private String losingTime;
	
	public Losing() {
		this.items = new Items();
		this.finder = new Account();
	}

	public int getLosingId() {
		return losingId;
	}

	public void setLosingId(int losingId) {
		this.losingId = losingId;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Account getFinder() {
		return finder;
	}

	public void setFinder(Account finder) {
		this.finder = finder;
	}

	public String getLosingTime() {
		return losingTime;
	}

	public void setLosingTime(String losingTime) {
		this.losingTime = losingTime;
	}
	 	
}
