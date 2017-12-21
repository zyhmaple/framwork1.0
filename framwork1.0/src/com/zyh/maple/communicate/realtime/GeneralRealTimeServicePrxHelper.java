/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import java.util.Map;

import Ice.AsyncResult;
import Ice.Callback;
import Ice.Exception;
import Ice.FormatType;
import Ice.LocalException;
import Ice.ObjectPrx;
import Ice.ObjectPrxHelperBase;
import Ice.OperationMode;
import Ice.SystemException;
import Ice.TwowayCallbackArg1;
import Ice.UnknownUserException;
import Ice.UserException;
import IceInternal.BasicStream;
import IceInternal.CallbackBase;
import IceInternal.Functional_BoolCallback;
import IceInternal.Functional_GenericCallback1;
import IceInternal.Functional_TwowayCallbackArg1;
import IceInternal.OutgoingAsync;

public final class GeneralRealTimeServicePrxHelper extends ObjectPrxHelperBase implements GeneralRealTimeServicePrx {
	private static final String __getDataFromRealTimeService_name = "getDataFromRealTimeService";
	public static final String[] __ids = new String[] { "::Ice::Object",
			"::com::zyh::maple::communicate::realtime::GeneralRealTimeService" };
	public static final long serialVersionUID = 0;

	@Override
	public Map<String, PlanStatisticInfo> getDataFromRealTimeService(String orderID, String planID) {
		return this.getDataFromRealTimeService(orderID, planID, null, false);
	}

	@Override
	public Map<String, PlanStatisticInfo> getDataFromRealTimeService(String orderID, String planID,
			Map<String, String> __ctx) {
		return this.getDataFromRealTimeService(orderID, planID, __ctx, true);
	}

	private Map<String, PlanStatisticInfo> getDataFromRealTimeService(String orderID, String planID,
			Map<String, String> __ctx, boolean __explicitCtx) {
		this.__checkTwowayOnly("getDataFromRealTimeService");
		return this.end_getDataFromRealTimeService(
				this.begin_getDataFromRealTimeService(orderID, planID, __ctx, __explicitCtx, true, null));
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID) {
		return this.begin_getDataFromRealTimeService(orderID, planID, null, false, false, null);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, true, false, null);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Callback __cb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, null, false, false, __cb);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			Callback __cb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, true, false, __cb);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID,
			Callback_GeneralRealTimeService_getDataFromRealTimeService __cb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, null, false, false, __cb);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			Callback_GeneralRealTimeService_getDataFromRealTimeService __cb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, true, false, __cb);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> __responseCb,
			Functional_GenericCallback1<Exception> __exceptionCb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, null, false, false, __responseCb, __exceptionCb,
				null);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> __responseCb,
			Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, null, false, false, __responseCb, __exceptionCb,
				__sentCb);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> __responseCb,
			Functional_GenericCallback1<Exception> __exceptionCb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, true, false, __responseCb, __exceptionCb,
				null);
	}

	@Override
	public AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> __responseCb,
			Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, true, false, __responseCb, __exceptionCb,
				__sentCb);
	}

	private AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			boolean __explicitCtx, boolean __synchronous,
			Functional_GenericCallback1<Map<String, PlanStatisticInfo>> __responseCb,
			Functional_GenericCallback1<Exception> __exceptionCb, Functional_BoolCallback __sentCb) {
		return this.begin_getDataFromRealTimeService(orderID, planID, __ctx, __explicitCtx, __synchronous,
				new Functional_TwowayCallbackArg1<Map<String, PlanStatisticInfo>>(__responseCb, __exceptionCb,
						__sentCb) {

					@Override
					public final void __completed(AsyncResult __result) {
						GeneralRealTimeServicePrxHelper.__getDataFromRealTimeService_completed(this, __result);
					}
				});
	}

	private AsyncResult begin_getDataFromRealTimeService(String orderID, String planID, Map<String, String> __ctx,
			boolean __explicitCtx, boolean __synchronous, CallbackBase __cb) {
		this.__checkAsyncTwowayOnly("getDataFromRealTimeService");
		OutgoingAsync __result = this.getOutgoingAsync("getDataFromRealTimeService", __cb);
		try {
			__result.prepare("getDataFromRealTimeService", OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
			BasicStream __os = __result.startWriteParams(FormatType.DefaultFormat);
			__os.writeString(orderID);
			__os.writeString(planID);
			__result.endWriteParams();
			__result.invoke();
		} catch (Exception __ex) {
			__result.abort(__ex);
		}
		return __result;
	}

	@Override
	public Map<String, PlanStatisticInfo> end_getDataFromRealTimeService(AsyncResult __iresult) {
		OutgoingAsync __result = OutgoingAsync.check(__iresult, this, "getDataFromRealTimeService");
		try {
			if (!__result.__wait()) {
				try {
					__result.throwUserException();
				} catch (UserException __ex) {
					throw new UnknownUserException(__ex.ice_name(), __ex);
				}
			}
			BasicStream __is = __result.startReadParams();
			Map<String, PlanStatisticInfo> __ret = orderMapHelper.read(__is);
			__result.endReadParams();
			Map<String, PlanStatisticInfo> map = __ret;
			return map;
		} finally {
			if (__result != null) {
				__result.cacheMessageBuffers();
			}
		}
	}

	public static void __getDataFromRealTimeService_completed(TwowayCallbackArg1<Map<String, PlanStatisticInfo>> __cb,
			AsyncResult __result) {
		GeneralRealTimeServicePrx __proxy = (GeneralRealTimeServicePrx) __result.getProxy();
		Map<String, PlanStatisticInfo> __ret = null;
		try {
			__ret = __proxy.end_getDataFromRealTimeService(__result);
		} catch (LocalException __ex) {
			__cb.exception(__ex);
			return;
		} catch (SystemException __ex) {
			__cb.exception(__ex);
			return;
		}
		__cb.response(__ret);
	}

	public static GeneralRealTimeServicePrx checkedCast(ObjectPrx __obj) {
		return GeneralRealTimeServicePrxHelper.checkedCastImpl(__obj, GeneralRealTimeServicePrxHelper.ice_staticId(),
				GeneralRealTimeServicePrx.class, GeneralRealTimeServicePrxHelper.class);
	}

	public static GeneralRealTimeServicePrx checkedCast(ObjectPrx __obj, Map<String, String> __ctx) {
		return GeneralRealTimeServicePrxHelper.checkedCastImpl(__obj, __ctx,
				GeneralRealTimeServicePrxHelper.ice_staticId(), GeneralRealTimeServicePrx.class,
				GeneralRealTimeServicePrxHelper.class);
	}

	public static GeneralRealTimeServicePrx checkedCast(ObjectPrx __obj, String __facet) {
		return GeneralRealTimeServicePrxHelper.checkedCastImpl(__obj, __facet,
				GeneralRealTimeServicePrxHelper.ice_staticId(), GeneralRealTimeServicePrx.class,
				GeneralRealTimeServicePrxHelper.class);
	}

	public static GeneralRealTimeServicePrx checkedCast(ObjectPrx __obj, String __facet, Map<String, String> __ctx) {
		return GeneralRealTimeServicePrxHelper.checkedCastImpl(__obj, __facet, __ctx,
				GeneralRealTimeServicePrxHelper.ice_staticId(), GeneralRealTimeServicePrx.class,
				GeneralRealTimeServicePrxHelper.class);
	}

	public static GeneralRealTimeServicePrx uncheckedCast(ObjectPrx __obj) {
		return GeneralRealTimeServicePrxHelper.uncheckedCastImpl(__obj, GeneralRealTimeServicePrx.class,
				GeneralRealTimeServicePrxHelper.class);
	}

	public static GeneralRealTimeServicePrx uncheckedCast(ObjectPrx __obj, String __facet) {
		return GeneralRealTimeServicePrxHelper.uncheckedCastImpl(__obj, __facet, GeneralRealTimeServicePrx.class,
				GeneralRealTimeServicePrxHelper.class);
	}

	public static String ice_staticId() {
		return __ids[1];
	}

	public static void __write(BasicStream __os, GeneralRealTimeServicePrx v) {
		__os.writeProxy(v);
	}

	public static GeneralRealTimeServicePrx __read(BasicStream __is) {
		ObjectPrx proxy = __is.readProxy();
		if (proxy != null) {
			GeneralRealTimeServicePrxHelper result = new GeneralRealTimeServicePrxHelper();
			result.__copyFrom(proxy);
			return result;
		}
		return null;
	}

}
