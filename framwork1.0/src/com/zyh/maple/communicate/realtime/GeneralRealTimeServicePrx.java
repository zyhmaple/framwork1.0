/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import java.util.Map;

import Ice.AsyncResult;
import Ice.Callback;
import Ice.Exception;
import Ice.ObjectPrx;
import IceInternal.Functional_BoolCallback;
import IceInternal.Functional_GenericCallback1;

public interface GeneralRealTimeServicePrx extends ObjectPrx {
	public Map<String, PlanStatisticInfo> getDataFromRealTimeService(String var1, String var2);

	public Map<String, PlanStatisticInfo> getDataFromRealTimeService(String var1, String var2,
			Map<String, String> var3);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Map<String, String> var3);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Callback var3);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Map<String, String> var3,
			Callback var4);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2,
			Callback_GeneralRealTimeService_getDataFromRealTimeService var3);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Map<String, String> var3,
			Callback_GeneralRealTimeService_getDataFromRealTimeService var4);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> var3,
			Functional_GenericCallback1<Exception> var4);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> var3,
			Functional_GenericCallback1<Exception> var4, Functional_BoolCallback var5);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Map<String, String> var3,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> var4,
			Functional_GenericCallback1<Exception> var5);

	public AsyncResult begin_getDataFromRealTimeService(String var1, String var2, Map<String, String> var3,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> var4,
			Functional_GenericCallback1<Exception> var5, Functional_BoolCallback var6);

	public Map<String, PlanStatisticInfo> end_getDataFromRealTimeService(AsyncResult var1);
}
