/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.io.Serializable;

public class MemberInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String memberID = null;
	private String enabled = null;
	private String password = null;
	private String memberName = null;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberID() {
		return this.memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
