package com.sinosoft.agriclaim.core.common.utils;

import java.util.StringTokenizer;

public class StringConvert {
	/**
	 * 字符串型条件的拼串函数
	 * 
	 * @param strName
	 *            字段名
	 * @param strValue
	 *            匹配值
	 * @param strSign
	 *            匹配方式
	 * @return 条件字串
	 */
	public static String convertString(String strName, String strValue, String strSign) {
		String strReturn = "";
		if (strSign == null) {
			strSign = "=";
		}
		if (strValue == null || strValue.equals("")) {
			return "";
		} else {
			if (strSign.equals("=")) {
				strReturn = " and " + strName + "='" + strValue.trim() + "' ";
			} else if (strSign.equals("!=") || strSign.equals("<>")) {
				strReturn = " and " + strName + "!='" + strValue.trim() + "' ";
			} else {
				strValue = replace(strValue, "*", "%");
				strReturn = " and " + strName + " like '%" + strValue.trim() + "%' ";
			}
			return strReturn;
		}
	}

	/**
	 * 字符串替换函数
	 * 
	 * @param strMain：原串，strFind：查找字符串，strReplaceWith：替换字符串
	 * @return 替换后的字符串，如果原串为空或者为""，则返回""
	 */
	public static String replace(String strMain, String strFind, String strReplaceWith) {
		String strReturn = "";
		int intStartIndex = 0, intEndIndex = 0;

		if (strMain == null || strMain.equals(""))
			return "";

		while ((intEndIndex = strMain.indexOf(strFind, intStartIndex)) > -1) {
			strReturn = strReturn + strMain.substring(intStartIndex, intEndIndex) + strReplaceWith;
			intStartIndex = intEndIndex + strFind.length();
		}
		strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
		return strReturn;
	}
	
	
	
	/**
	 * 规范正确的日期格式
	 * @param strTime
	 * @return 替换后的字符串，"00:00:00"
	 */
	public static String toStandardTime(String strTime) {
		String strReturn = "";
		if (strTime != null) {
			java.util.StringTokenizer t = new StringTokenizer(strTime, ":");
			while (t.hasMoreTokens()) {
				String strTemp = t.nextToken();
				if (strTemp.trim().length() == 1) {
					strTemp = "0" + strTemp.trim();
				} else if (strTemp.trim().length() >= 2) {
					strTemp = strTemp.trim().substring(0, 2);
				} else if (strTemp.trim().length() == 0) {
					strTemp = "00";
				}
				strReturn = strReturn + strTemp + ":";
			}
			if (strReturn.length() == 3) {
				strReturn = strReturn + "00:00";
			} else if (strReturn.length() == 6) {
				strReturn = strReturn + "00";
			} else if (strReturn.length() == 9) {
				strReturn = strReturn.substring(0, 8);
			} else if (strReturn.length() == 0) {
				strReturn = "00:00:00";
			}
		} else {
			strReturn = "00:00:00";
		}
		//int intColon = strReturn.length()
		return strReturn;
	}
}
