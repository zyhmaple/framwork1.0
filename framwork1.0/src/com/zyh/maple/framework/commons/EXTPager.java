/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EXTPager {
	private int totalRows;
	private int limit = 2;
	private int totalPages;
	private int start;
	private List action = new ArrayList();
	private String currentLoginUserid = "";
	private Collection listData;

	public EXTPager() {
	}

	public EXTPager(int _totalRows) {
		this.totalRows = _totalRows;
		this.totalPages = this.totalRows / this.limit;
		int mod = this.totalRows % this.limit;
		if (mod > 0) {
			++this.totalPages;
		}
	}

	public int getTotalRows() {
		return this.totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Collection getListData() {
		return this.listData;
	}

	public void setListData(Collection listData) {
		this.listData = listData;
	}

	public int getEnd() {
		return this.start + this.limit;
	}

	public List getAction() {
		return this.action;
	}

	public void addAction(String[] as) {
		this.action.add(as);
	}

	public String getCurrentLoginUserid() {
		return this.currentLoginUserid;
	}

	public void setCurrentLoginUserid(String currentLoginUserid) {
		this.currentLoginUserid = currentLoginUserid;
	}
}
