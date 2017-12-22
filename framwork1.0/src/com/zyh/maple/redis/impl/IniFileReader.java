/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.redis.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class IniFileReader {
	private Hashtable paramTable;

	public IniFileReader(String conf_filename) throws FileNotFoundException, IOException {
		this.loadFromFile(conf_filename);
	}

	public String getStrValue(String name) {
		Object obj = this.paramTable.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return (String) ((ArrayList) obj).get(0);
	}

	public int getIntValue(String name, int default_value) {
		String szValue = this.getStrValue(name);
		if (szValue == null) {
			return default_value;
		}
		return Integer.parseInt(szValue);
	}

	public boolean getBoolValue(String name, boolean default_value) {
		String szValue = this.getStrValue(name);
		if (szValue == null) {
			return default_value;
		}
		if (!(szValue.equalsIgnoreCase("yes") || szValue.equalsIgnoreCase("on") || szValue.equalsIgnoreCase("true")
				|| szValue.equals("1"))) {
			return false;
		}
		return true;
	}

	public long getLongValue(String name, long default_value) {
		String szValue = this.getStrValue(name);
		if (szValue == null) {
			return default_value;
		}
		return Long.parseLong(szValue);
	}

	public String[] getValues(String name) {
		Object obj = this.paramTable.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof String) {
			String[] values = new String[] { (String) obj };
			return values;
		}
		Object[] objs = ((ArrayList) obj).toArray();
		String[] values = new String[objs.length];
		System.arraycopy(objs, 0, values, 0, objs.length);
		return values;
	}

	private void loadFromFile(String conf_filename) throws FileNotFoundException, IOException {
		FileReader fReader = new FileReader(conf_filename);
		BufferedReader buffReader = new BufferedReader(fReader);
		this.paramTable = new Hashtable();
		try {
			String line;
			while ((line = buffReader.readLine()) != null) {
				ArrayList<Object> valueList;
				String[] parts;
				if ((line = line.trim()).length() == 0 || line.charAt(0) == '#'
						|| (parts = line.split("=", 2)).length != 2)
					continue;
				String name = parts[0].trim();
				String value = parts[1].trim();
				Object obj = this.paramTable.get(name);
				if (obj == null) {
					this.paramTable.put(name, value);
					continue;
				}
				if (obj instanceof String) {
					valueList = new ArrayList<Object>();
					valueList.add(obj);
					valueList.add(value);
					this.paramTable.put(name, valueList);
					continue;
				}
				valueList = (ArrayList<Object>) obj;
				valueList.add(value);
			}
		} finally {
			fReader.close();
		}
	}
}
