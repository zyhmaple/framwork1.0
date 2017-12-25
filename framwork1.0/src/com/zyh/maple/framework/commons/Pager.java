/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.commons;

import java.util.Collection;

public class Pager {
	private int totalRows;
	private int pageSize = 2;
	private int currentPage;
	private int totalPages;
	private int startRow;
	private int endRow;
	private Collection listData;

	public Pager() {
	}

	public Pager(int _totalRows) {
		this.totalRows = _totalRows;
		this.totalPages = this.totalRows / this.pageSize;
		int mod = this.totalRows % this.pageSize;
		if (mod > 0) {
			++this.totalPages;
		}
		this.currentPage = 1;
		this.startRow = 0;
	}

	public Pager(int _totalRows, int _pageSize) {
		this.totalRows = _totalRows;
		this.pageSize = _pageSize;
		this.totalPages = this.totalRows / this.pageSize;
		int mod = this.totalRows % this.pageSize;
		if (mod > 0) {
			++this.totalPages;
		}
		this.currentPage = 1;
		this.startRow = 0;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return this.totalRows;
	}

	public void first() {
		this.currentPage = 1;
		this.startRow = 0;
	}

	public void previous() {
		if (this.currentPage == 1) {
			return;
		}
		--this.currentPage;
		this.startRow = (this.currentPage - 1) * this.pageSize;
	}

	public void next() {
		if (this.currentPage < this.totalPages) {
			++this.currentPage;
		}
		this.startRow = (this.currentPage - 1) * this.pageSize;
	}

	public void last() {
		this.currentPage = this.totalPages;
		this.startRow = (this.currentPage - 1) * this.pageSize;
	}

	public void refresh(int _currentPage) {
		this.currentPage = _currentPage;
		if (this.currentPage > this.totalPages) {
			this.last();
		}
	}

	public int getEndRow() {
		return this.startRow + this.pageSize;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public Collection getListData() {
		return this.listData;
	}

	public void setListData(Collection listData) {
		this.listData = listData;
	}
}
