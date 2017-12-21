/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.communicate.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.zyh.maple.framework.commons.SysParams;

import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;

public class IceClientUtil {
	private static volatile Communicator ic = null;
	private static Map<Class, ObjectPrx> cls2PrxMap = new HashMap<Class, ObjectPrx>();
	private static volatile long lastAccessTimestamp;
	private static volatile MonitorThread monitorThread;
	private static long idleTimeOutSeconds;

	static {
		idleTimeOutSeconds = -1;
	}

	/*
	 * WARNING - Removed try catching itself - possible behaviour change.
	 * Enabled aggressive block sorting Enabled unnecessary exception pruning
	 * Enabled aggressive exception aggregation Converted monitor instructions
	 * to comments Lifted jumps to return sites
	 */
	public static Communicator getIceCommunicator() {
		if (ic == null) {
			Class<IceClientUtil> class_ = IceClientUtil.class;
			// MONITORENTER : com.dm.adrich.communicate.util.IceClientUtil.class
			if (ic == null) {
				if (idleTimeOutSeconds == -1) {
					String timeOut = SysParams.sysProps.getProperty("ice.idleTimeOutSeconds");
					idleTimeOutSeconds = timeOut != null && !"".equals(timeOut.trim())
							? (long) Integer.parseInt(timeOut) : 0;
				}
				ic = Util.initialize();
				IceClientUtil.createMonitorThread();
			}
			// MONITOREXIT : class_
		}
		lastAccessTimestamp = System.currentTimeMillis();
		return ic;
	}

	private static void createMonitorThread() {
		monitorThread = new MonitorThread();
		monitorThread.setDaemon(true);
		monitorThread.start();
	}

	/*
	 * WARNING - Removed try catching itself - possible behaviour change.
	 */
	public static void closeCommunicator(boolean removeServiceCache) {
		Class<IceClientUtil> class_ = IceClientUtil.class;
		synchronized (IceClientUtil.class) {
			if (ic != null) {
				IceClientUtil.safeShutdown();
				monitorThread.interrupt();
				if (removeServiceCache && !cls2PrxMap.isEmpty()) {
					try {
						cls2PrxMap.clear();
					} catch (Exception exception) {
						// empty catch block
					}
				}
			}
			// ** MonitorExit[var1_1] (shouldn't be in output)
			return;
		}
	}

	private static void safeShutdown() {
		try {
			try {
				ic.shutdown();
			} catch (Exception e) {
				e.printStackTrace();
				ic.destroy();
				ic = null;
			}
		} finally {
			ic.destroy();
			ic = null;
		}
	}

	private static ObjectPrx createIceProxy(Communicator communicator, Class serviceCls, String serverIP) {
		ObjectPrx proxy = null;
		String clsName = serviceCls.getName();
		System.out.println("clsName:" + clsName);
		String serviceName = serviceCls.getSimpleName();
		int pos = serviceName.lastIndexOf("Prx");
		if (pos <= 0) {
			throw new IllegalArgumentException("Invalid ObjectPrx class ,class name must end with Prx");
		}
		String realSvName = serviceName.substring(0, pos);
		try {
			ObjectPrx base = communicator.stringToProxy(serverIP).ice_twoway();
			proxy = (ObjectPrx) Class.forName(String.valueOf(clsName) + "Helper").newInstance();
			Method m1 = proxy.getClass().getDeclaredMethod("checkedCast", ObjectPrx.class);
			proxy = (ObjectPrx) m1.invoke(proxy, base);
			return proxy;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static ObjectPrx getServicePrx(Class serviceCls, String serverIP) {
		ObjectPrx proxy = cls2PrxMap.get(serviceCls);
		if (proxy != null) {
			lastAccessTimestamp = System.currentTimeMillis();
			return proxy;
		}
		proxy = IceClientUtil.createIceProxy(IceClientUtil.getIceCommunicator(), serviceCls, serverIP);
		cls2PrxMap.put(serviceCls, proxy);
		lastAccessTimestamp = System.currentTimeMillis();
		return proxy;
	}

	static class MonitorThread extends Thread {
		MonitorThread() {
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(5000);
					if (lastAccessTimestamp + idleTimeOutSeconds * 1000 >= System.currentTimeMillis())
						continue;
					IceClientUtil.closeCommunicator(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
