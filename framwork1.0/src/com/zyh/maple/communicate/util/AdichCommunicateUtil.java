/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.util;

import java.util.Map;

import com.zyh.maple.communicate.realtime.GeneralRealTimeServicePrx;
import com.zyh.maple.communicate.realtime.PlanStatisticInfo;
import com.zyh.maple.framework.commons.SysParams;

public class AdichCommunicateUtil {
	public static Map<String, PlanStatisticInfo> getStatictisInfoFromRealTimeService(String orderID, String planID) {
		GeneralRealTimeServicePrx grsp = (GeneralRealTimeServicePrx) IceClientUtil
				.getServicePrx(GeneralRealTimeServicePrx.class, SysParams.sysProps.getProperty("ice.realtime.locator"));
		return grsp.getDataFromRealTimeService(orderID, planID);
	}
}
