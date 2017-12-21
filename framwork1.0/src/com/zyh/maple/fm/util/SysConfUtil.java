/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.fm.util;

import java.io.IOException;
import java.util.Properties;

public class SysConfUtil {
	private static SysConfUtil instance;
	private Properties p;

	private SysConfUtil() {
		this.reloadPropertiesFile();
	}

	public static SysConfUtil getInstance() {
		if (instance == null) {
			instance = new SysConfUtil();
		}
		return instance;
	}

	private void reloadPropertiesFile() {
		this.p = new Properties();
		try {
			this.p.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("./conf/properties/sys.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValueByKey(String key) {
		String value = null;
		value = this.p.getProperty(key);
		return value;
	}
}
