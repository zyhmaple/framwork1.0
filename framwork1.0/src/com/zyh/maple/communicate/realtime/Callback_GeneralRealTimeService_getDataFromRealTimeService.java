/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import java.util.Map;

import Ice.AsyncResult;
import Ice.TwowayCallbackArg1;
import IceInternal.TwowayCallback;

public abstract class Callback_GeneralRealTimeService_getDataFromRealTimeService extends TwowayCallback
		implements TwowayCallbackArg1<Map<String, PlanStatisticInfo>> {
	@Override
	public final void __completed(AsyncResult __result) {
		GeneralRealTimeServicePrxHelper.__getDataFromRealTimeService_completed(this, __result);
	}
}
