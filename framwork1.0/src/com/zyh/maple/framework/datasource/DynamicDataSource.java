/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
 */
package com.zyh.maple.framework.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}
}
