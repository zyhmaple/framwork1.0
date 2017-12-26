/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.util;

import java.security.MessageDigest;

public class MD5Digest {
	private static String MD5(String password) {
		char[] hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
				'f' };
		try {
			byte[] strTemp = password.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			int i = 0;
			while (i < j) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
				++i;
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getMD5(String password) {
		return MD5Digest.MD5(password);
	}
}
