package com.myproject.vo;

import java.io.Serializable;

public class Publishing implements Serializable {

	private int publishingId;
	private Account account;
	private String title;
	private String content;
	private String publishingTime;
	private int statues;

	public int getPublishingId() {
		return publishingId;
	}

	public void setPublishingId(int publishingId) {
		this.publishingId = publishingId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishingTime() {
		return publishingTime;
	}

	public void setPublishingTime(String publishingTime) {
		this.publishingTime = publishingTime;
	}

	public int getStatues() {
		return statues;
	}

	public void setStatues(int statues) {
		this.statues = statues;
	}
}
