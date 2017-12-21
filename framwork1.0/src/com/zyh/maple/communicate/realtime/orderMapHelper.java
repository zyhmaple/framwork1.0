/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import java.util.HashMap;
import java.util.Map;

import IceInternal.BasicStream;

public final class orderMapHelper {
	public static void write(BasicStream __os, Map<String, PlanStatisticInfo> __v) {
		if (__v == null) {
			__os.writeSize(0);
		} else {
			__os.writeSize(__v.size());
			for (Map.Entry<String, PlanStatisticInfo> __e : __v.entrySet()) {
				__os.writeString(__e.getKey());
				PlanStatisticInfo.__write(__os, __e.getValue());
			}
		}
	}

	public static Map<String, PlanStatisticInfo> read(BasicStream __is) {
		HashMap<String, PlanStatisticInfo> __v = new HashMap<String, PlanStatisticInfo>();
		int __sz0 = __is.readSize();
		int __i0 = 0;
		while (__i0 < __sz0) {
			String __key = __is.readString();
			PlanStatisticInfo __value = null;
			__value = PlanStatisticInfo.__read(__is, __value);
			__v.put(__key, __value);
			++__i0;
		}
		return __v;
	}
}
