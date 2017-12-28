/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.communicate.realtime;

import java.util.Arrays;
import java.util.Map;

import Ice.Current;
import Ice.DispatchStatus;
import Ice.FormatType;
import Ice.Object;
import Ice.ObjectImpl;
import Ice.OperationMode;
import Ice.OperationNotExistException;
import IceInternal.BasicStream;
import IceInternal.Incoming;

public abstract class _GeneralRealTimeServiceDisp extends ObjectImpl implements GeneralRealTimeService {
	public static final String[] __ids = new String[] { "::Ice::Object",
			"::com::zyh::maple::communicate::realtime::GeneralRealTimeService" };
	private static final String[] __all = new String[] { "getDataFromRealTimeService", "ice_id", "ice_ids", "ice_isA",
			"ice_ping" };
	public static final long serialVersionUID = 0;

	protected void ice_copyStateFrom(Object __obj) throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public boolean ice_isA(String s) {
		if (Arrays.binarySearch(__ids, s) >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean ice_isA(String s, Current __current) {
		if (Arrays.binarySearch(__ids, s) >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public String[] ice_ids() {
		return __ids;
	}

	@Override
	public String[] ice_ids(Current __current) {
		return __ids;
	}

	@Override
	public String ice_id() {
		return __ids[1];
	}

	@Override
	public String ice_id(Current __current) {
		return __ids[1];
	}

	public static String ice_staticId() {
		return __ids[1];
	}

	@Override
	public final Map<String, PlanStatisticInfo> getDataFromRealTimeService(String orderID, String planID) {
		return this.getDataFromRealTimeService(orderID, planID, null);
	}

	public static DispatchStatus ___getDataFromRealTimeService(GeneralRealTimeService __obj, Incoming __inS,
			Current __current) {
		_GeneralRealTimeServiceDisp.__checkMode(OperationMode.Normal, __current.mode);
		BasicStream __is = __inS.startReadParams();
		String orderID = __is.readString();
		String planID = __is.readString();
		__inS.endReadParams();
		Map<String, PlanStatisticInfo> __ret = __obj.getDataFromRealTimeService(orderID, planID, __current);
		BasicStream __os = __inS.__startWriteParams(FormatType.DefaultFormat);
		orderMapHelper.write(__os, __ret);
		__inS.__endWriteParams(true);
		return DispatchStatus.DispatchOK;
	}

	@Override
	public DispatchStatus __dispatch(Incoming in, Current __current) {
		int pos = Arrays.binarySearch(__all, __current.operation);
		if (pos < 0) {
			throw new OperationNotExistException(__current.id, __current.facet, __current.operation);
		}
		switch (pos) {
		case 0: {
			return _GeneralRealTimeServiceDisp.___getDataFromRealTimeService(this, in, __current);
		}
		case 1: {
			return _GeneralRealTimeServiceDisp.___ice_id(this, in, __current);
		}
		case 2: {
			return _GeneralRealTimeServiceDisp.___ice_ids(this, in, __current);
		}
		case 3: {
			return _GeneralRealTimeServiceDisp.___ice_isA(this, in, __current);
		}
		case 4: {
			return _GeneralRealTimeServiceDisp.___ice_ping(this, in, __current);
		}
		}
		assert (false);
		throw new OperationNotExistException(__current.id, __current.facet, __current.operation);
	}

	@Override
	protected void __writeImpl(BasicStream __os) {
		__os.startWriteSlice(_GeneralRealTimeServiceDisp.ice_staticId(), -1, true);
		__os.endWriteSlice();
	}

	@Override
	protected void __readImpl(BasicStream __is) {
		__is.startReadSlice();
		__is.endReadSlice();
	}
}
