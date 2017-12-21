/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  backtype.storm.utils.DRPCClient
 */
package com.zyh.maple.framework.util;

import com.zyh.maple.framework.commons.SysParams;

import backtype.storm.utils.DRPCClient;

public class StormUtil {
	public static String getDataFromStorm(String orderID, String planID) throws Exception {
		if ((planID == null) || ("".equals(planID))) {
			planID = "all";
		}
		String port = SysParams.sysProps.getProperty("storm.port");
		int portInt = 3772;
		if ((port != null) && (!"".equals(port))) {
			portInt = Integer.parseInt(port);
		}
		DRPCClient client = new DRPCClient(SysParams.sysProps.getProperty("storm.ip"), portInt,
				Integer.valueOf(100000));
		String result = client.execute("adrichCountRealTime", orderID + "#" + planID);
		if ((result != null) && (result.length() > 5)) {
			result = result.substring(2, result.length() - 2);
		}
		return result;
	}
}
