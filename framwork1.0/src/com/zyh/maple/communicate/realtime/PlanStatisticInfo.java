/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import java.io.Serializable;
import java.util.List;

import IceInternal.BasicStream;
import IceInternal.HashUtil;

public class PlanStatisticInfo implements Cloneable, Serializable {
	public String planID;
	public long exposNum;
	public long winNum;
	public long clickNum;
	public double price;
	public List<String> siteNameList;
	private static final PlanStatisticInfo __nullMarshalValue = new PlanStatisticInfo();
	public static final long serialVersionUID = 718780699;

	public PlanStatisticInfo() {
		this.planID = "";
	}

	public PlanStatisticInfo(String planID, long exposNum, long winNum, long clickNum, double price,
			List<String> siteNameList) {
		this.planID = planID;
		this.exposNum = exposNum;
		this.winNum = winNum;
		this.clickNum = clickNum;
		this.price = price;
		this.siteNameList = siteNameList;
	}

	public boolean equals(Object rhs) {
		if (this == rhs) {
			return true;
		}
		PlanStatisticInfo _r = null;
		if (rhs instanceof PlanStatisticInfo) {
			_r = (PlanStatisticInfo) rhs;
		}
		if (_r != null) {
			if (!(this.planID == _r.planID
					|| this.planID != null && _r.planID != null && this.planID.equals(_r.planID))) {
				return false;
			}
			if (this.exposNum != _r.exposNum) {
				return false;
			}
			if (this.winNum != _r.winNum) {
				return false;
			}
			if (this.clickNum != _r.clickNum) {
				return false;
			}
			if (this.price != _r.price) {
				return false;
			}
			if (!(this.siteNameList == _r.siteNameList || this.siteNameList != null && _r.siteNameList != null
					&& this.siteNameList.equals(_r.siteNameList))) {
				return false;
			}
			return true;
		}
		return false;
	}

	public int hashCode() {
		int __h = 5381;
		__h = HashUtil.hashAdd(__h, "::com::dm::adrich::communicate::realtime::PlanStatisticInfo");
		__h = HashUtil.hashAdd(__h, this.planID);
		__h = HashUtil.hashAdd(__h, this.exposNum);
		__h = HashUtil.hashAdd(__h, this.winNum);
		__h = HashUtil.hashAdd(__h, this.clickNum);
		__h = HashUtil.hashAdd(__h, this.price);
		__h = HashUtil.hashAdd(__h, this.siteNameList);
		return __h;
	}

	public PlanStatisticInfo clone() {
		PlanStatisticInfo c = null;
		try {
			c = (PlanStatisticInfo) super.clone();
		} catch (CloneNotSupportedException ex) {
			assert false;
		}
		return c;
	}

	public void __write(BasicStream __os) {
		__os.writeString(this.planID);
		__os.writeLong(this.exposNum);
		__os.writeLong(this.winNum);
		__os.writeLong(this.clickNum);
		__os.writeDouble(this.price);
		SiteNameListHelper.write(__os, this.siteNameList);
	}

	public void __read(BasicStream __is) {
		this.planID = __is.readString();
		this.exposNum = __is.readLong();
		this.winNum = __is.readLong();
		this.clickNum = __is.readLong();
		this.price = __is.readDouble();
		this.siteNameList = SiteNameListHelper.read(__is);
	}

	public static void __write(BasicStream __os, PlanStatisticInfo __v) {
		if (__v == null) {
			__nullMarshalValue.__write(__os);
		} else {
			__v.__write(__os);
		}
	}

	public static PlanStatisticInfo __read(BasicStream __is, PlanStatisticInfo __v) {
		if (__v == null) {
			__v = new PlanStatisticInfo();
		}
		__v.__read(__is);
		return __v;
	}
}
