/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.datasource;

public class DataSourceContextHolder {
	public static final ThreadLocal contextHolder = new ThreadLocal();

	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
