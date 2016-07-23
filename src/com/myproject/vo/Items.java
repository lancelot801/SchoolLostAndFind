package com.myproject.vo;

import java.io.Serializable;

public class Items implements Serializable {

	private int itemsId;
	private String itemsName;
	private String itemsDescribtion;
	private ItemsStatues itemsStatues;
	private ItemsCategory itemsCategory;

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}

	public ItemsCategory getItemsCategory() {
		return itemsCategory;
	}

	public void setItemsCategory(ItemsCategory itemsCategory) {
		this.itemsCategory = itemsCategory;
	}

	public Items() {
		this.itemsStatues = new ItemsStatues();
		this.itemsCategory = new ItemsCategory();
	}

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public String getItemsDescribtion() {
		return itemsDescribtion;
	}

	public void setItemsDescribtion(String itemsDescribtion) {
		this.itemsDescribtion = itemsDescribtion;
	}

	public ItemsStatues getItemsStatues() {
		return itemsStatues;
	}

	public void setItemsStatues(ItemsStatues itemsStatues) {
		this.itemsStatues = itemsStatues;
	}

}
