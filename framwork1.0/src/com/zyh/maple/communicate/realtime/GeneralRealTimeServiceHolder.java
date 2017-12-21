/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.realtime;

import Ice.Object;
import Ice.ObjectHolderBase;
import IceInternal.Ex;

public final class GeneralRealTimeServiceHolder extends ObjectHolderBase<GeneralRealTimeService> {
	public GeneralRealTimeServiceHolder() {
	}

	public GeneralRealTimeServiceHolder(GeneralRealTimeService value) {
		this.value = value;
	}

	@Override
	public void patch(Object v) {
		if (v == null || v instanceof GeneralRealTimeService) {
			this.value = (GeneralRealTimeService) v;
		} else {
			Ex.throwUOE(this.type(), v);
		}
	}

	@Override
	public String type() {
		return _GeneralRealTimeServiceDisp.ice_staticId();
	}
}
