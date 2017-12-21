/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.fm.util;

import com.zyh.maple.framework.util.UuidUtils;

public class FmUuidUtils {
	private static final String UUID_PREFIX_KEY = "fm.uuid.prefix";
	private static final String UUID_PREFIX_VALUE = SysConfUtil.getInstance().getValueByKey("fm.uuid.prefix");

	public static String getFmUuid() {
		String uuid = String.valueOf(UUID_PREFIX_VALUE) + UuidUtils.base58Uuid();
		return uuid;
	}
}
