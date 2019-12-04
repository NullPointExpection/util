package com.util.safe.util;

import java.security.MessageDigest;

/**
 * MD5
 *
 */
public class MD5Util {

	/**
	 * MD5加密
	 * @param value
	 * @return
	 */
	public static String md5(String value) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(value.getBytes());
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (Exception e) {
			return "";
		}
	}


}
