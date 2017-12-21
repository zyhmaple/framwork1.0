/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.io.Serializable;

public class Resources implements Serializable {

	private static final long serialVersionUID = 1L;
	private String resourceID;
	private String resourceURL;
	private Integer resourcePriority;
	private Integer resourceType;
	private String resourceName;
	private String memo;

	public String getResourceID() {
		return this.resourceID;
	}

	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceURL() {
		return this.resourceURL;
	}

	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

	public Integer getResourcePriority() {
		return this.resourcePriority;
	}

	public void setResourcePriority(Integer resourcePriority) {
		this.resourcePriority = resourcePriority;
	}

	public Integer getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
