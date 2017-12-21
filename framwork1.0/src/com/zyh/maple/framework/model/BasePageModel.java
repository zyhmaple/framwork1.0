/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.io.Serializable;

public class BasePageModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String currentPage;
	private String pageSize;
	private int startRowNo;
	private int endRow;

	public String getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
		if (currentPage == null) {
			return;
		}
		if (this.getPageSize() != null) {
			int cp = Integer.parseInt(currentPage);
			int ps = Integer.parseInt(this.getPageSize());
			this.setStartRowNo((cp - 1) * ps);
		}
	}

	public String getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(String pageSize) {
		if (pageSize == null) {
			this.pageSize = null;
			return;
		}
		this.pageSize = pageSize;
		this.endRow = Integer.valueOf(pageSize);
		if (this.getCurrentPage() != null) {
			int cp = Integer.parseInt(this.getCurrentPage());
			int ps = Integer.parseInt(this.getPageSize());
			this.setStartRowNo((cp - 1) * ps);
		}
	}

	public int getEndRow() {
		return this.endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRowNo() {
		return this.startRowNo;
	}

	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
}
