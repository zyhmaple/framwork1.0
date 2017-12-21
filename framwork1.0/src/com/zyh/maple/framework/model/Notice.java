/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer noticeId;
	private String author;
	private Timestamp addTime;
	private String content;
	private String title;

	public Notice() {
	}

	public Notice(String author, Timestamp addTime, String content) {
		this.author = author;
		this.addTime = addTime;
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
