package com.myproject.vo;

import java.io.Serializable;

public class Picking implements Serializable {

	private int pickingId;
	private Items items;
	private String picker;
	private String pickTime;
	private String pickPhone;
	private String PickLocation;

	public Picking(){
		this.items = new Items();
	}
	
	public int getPickingId() {
		return pickingId;
	}

	public String getPickPhone() {
		return pickPhone;
	}

	public void setPickPhone(String pickPhone) {
		this.pickPhone = pickPhone;
	}

	public void setPickingId(int pickingId) {
		this.pickingId = pickingId;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public String getPicker() {
		return picker;
	}

	public void setPicker(String picker) {
		this.picker = picker;
	}

	public String getPickTime() {
		return pickTime;
	}

	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}

	public String getPickLocation() {
		return PickLocation;
	}

	public void setPickLocation(String pickLocation) {
		PickLocation = pickLocation;
	}

}
