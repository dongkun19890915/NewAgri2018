package com.sinosoft.framework.agri.core.utils;

import java.math.BigDecimal;
import java.util.Calendar;

/**
* @Description:String工具类，此类非新建，来源于 sinosoft-1.2.1
* @Author: 周家伟
* @Date: 2017/10/16 9:36
*/
public class Str {

    public static String newString(String iString, int iTimes)
    {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iTimes; i++) {
            buffer.append(iString);
        }
        return buffer.toString();
    }

    public static String space(int iLength)
    {
        return newString(" ", iLength);
    }

    public static int getLength(String iString)
    {
        return iString.getBytes().length;
    }


    public static int getPos(String strMain, String strSub, int intTimes)
    {
        return getPos(strMain, strSub, 0, intTimes);
    }

    public static int getPos(String strMain, String strSub, int intStartIndex, int intTimes)
    {
        int intCounter = 0;
        int intPosition = intStartIndex;
        int intLength = strSub.length();
        if (intTimes <= 0) {
            return -1;
        }
        if (strMain.length() - 1 < intStartIndex) {
            return -1;
        }
        if (strSub.equals("")) {
            return 0;
        }
        while (intCounter < intTimes)
        {
            intPosition = strMain.indexOf(strSub, intPosition);
            if (intPosition == -1) {
                return -1;
            }
            intCounter++;
            intPosition += intLength;
        }
        return intPosition - intLength;
    }


    public static String replace(String strMain, String strFind, String strReplaceWith)
    {
        String strReturn = "";
        int intStartIndex = 0;int intEndIndex = 0;
        if ((strMain == null) || (strMain.equals(""))) {
            return "";
        }
        while ((intEndIndex = strMain.indexOf(strFind, intStartIndex)) > -1)
        {
            strReturn = strReturn + strMain.substring(intStartIndex, intEndIndex) + strReplaceWith;
            intStartIndex = intEndIndex + strFind.length();
        }
        strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
        return strReturn;
    }

    public static String decodeStr(String strMain, String strDelimiters, int intSerialNo)
    {
        int posStart = 0;
        int posEnd = 0;
        String strReturn = "";
        if (strMain.length() < strDelimiters.length()) {
            return "";
        }
        posStart = getPos(strMain, strDelimiters, intSerialNo - 1);
        if (posStart == -1) {
            posStart = 0;
        } else {
            posStart += strDelimiters.length();
        }
        posEnd = getPos(strMain, strDelimiters, intSerialNo);
        if (posEnd == -1) {
            posEnd = 0;
        }
        strReturn = strMain.substring(posStart, posEnd);
        return strReturn;
    }


    public static String toHTMLFormat(String strInValue)
    {
        String strOutValue = "";
        for (int i = 0; i < strInValue.length(); i++)
        {
            char c = strInValue.charAt(i);
            switch (c)
            {
                case '<':
                    strOutValue = strOutValue + "&lt;";
                    break;
                case '>':
                    strOutValue = strOutValue + "&gt;";
                    break;
                case '\n':
                    strOutValue = strOutValue + "<br>";
                    break;
                case '\r':
                    break;
                case ' ':
                    strOutValue = strOutValue + "&nbsp;";
                    break;
                default:
                    strOutValue = strOutValue + c;
            }
        }
        return strOutValue;
    }

    public static String encode(String strInValue)
    {
        String strOutValue = "";
        for (int i = 0; i < strInValue.length(); i++)
        {
            char c = strInValue.charAt(i);
            switch (c)
            {
                case ':':
                    strOutValue = strOutValue + "：";
                    break;
                case '|':
                    strOutValue = strOutValue + "┃";
                    break;
                case '\n':
                    strOutValue = strOutValue + "\\n";
                    break;
                case '\r':
                    strOutValue = strOutValue + "\\r";
                    break;
                case '"':
                    strOutValue = strOutValue + "\\\"";
                    break;
                case '\'':
                    strOutValue = strOutValue + "\\'";
                    break;
                case '\b':
                    strOutValue = strOutValue + "\\b";
                    break;
                case '\t':
                    strOutValue = strOutValue + "\\t";
                    break;
                case '\f':
                    strOutValue = strOutValue + "\\f";
                    break;
                case '\\':
                    strOutValue = strOutValue + "\\\\";
                    break;
                case '<':
                    strOutValue = strOutValue + "\\<";
                    break;
                case '>':
                    strOutValue = strOutValue + "\\>";
                    break;
                default:
                    strOutValue = strOutValue + c;
            }
        }
        return strOutValue;
    }

    public static String convertString(String strName, String strValue, String strSign)
    {
        String strReturn = "";
        if ((strValue == null) || (strValue.equals(""))) {
            return "";
        }
        if (strSign.equals(":"))
        {
            String strValueStart = "";
            String strValueEnd = "";
            int index = strValue.indexOf(':');
            if (index > -1)
            {
                strValueStart = strValue.substring(0, index);
                strValueEnd = strValue.substring(index + 1);
                strReturn = " and " + strName + " between '" + strValueStart + "' and '" + strValueEnd + "' ";
            }
            else
            {
                return "";
            }
        }
        else if (strSign.equals("="))
        {
            strReturn = " and " + strName + "='" + strValue + "' ";
        }
        else
        {
            strValue = replace(strValue, "*", "%");
            strReturn = " and " + strName + " like '%" + strValue + "%' ";
        }
        return strReturn;
    }



    public static String convertNumber(String strName, String strValue, String strSign)
    {
        String strReturn = "";
        if ((strValue == null) || (strValue.equals(""))) {
            return "";
        }
        if (strSign.equals(":"))
        {
            String strValueStart = "";
            String strValueEnd = "";
            int index = strValue.indexOf(':');
            if (index > -1)
            {
                strValueStart = strValue.substring(0, index);
                strValueEnd = strValue.substring(index + 1);
                strReturn = " and " + strName + " between " + strValueStart + " and " + strValueEnd + " ";
            }
            else
            {
                return "";
            }
        }
        else
        {
            strReturn = " and " + strName + strSign + strValue + " ";
        }
        return strReturn;
    }

    public static String decode(String strInValue)
    {
        String strOutValue = strInValue;
        strOutValue = replace(strOutValue, "\\n", "\n");
        strOutValue = replace(strOutValue, "\\r", "\r");
        strOutValue = replace(strOutValue, "\\\\", "\\");
        strOutValue = replace(strOutValue, "\\b", "\b");
        strOutValue = replace(strOutValue, "\\t", "\t");
        strOutValue = replace(strOutValue, "\\\"", "\"");
        strOutValue = replace(strOutValue, "\\'", "'");
        strOutValue = replace(strOutValue, "\\f", "\f");
        strOutValue = replace(strOutValue, "\\<", "<");
        strOutValue = replace(strOutValue, "\\>", ">");
        return strOutValue;
    }

    public static Object split(String strMain, int intMaxLength)
    {
        if (strMain == null) {
            return new String[0];
        }
        if (strMain.trim().equals("")) {
            return new String[0];
        }
        byte[] arrByte = new byte[0];
        int intEndIndex = 0;
        int intStartIndex = 0;
        int intCount = 0;
        int j = 0;
        String[] arrReturn = new String[0];

        arrByte = strMain.getBytes();
        intCount = Math.round(arrByte.length / intMaxLength + 0.5F);
        arrReturn = new String[intCount];
        for (int i = 0; i < intCount; i++)
        {
            if (intEndIndex == 0) {
                intEndIndex = intMaxLength - 1;
            } else {
                intEndIndex += intMaxLength;
            }
            intEndIndex = Math.min(intEndIndex, arrByte.length - 1);
            if (arrByte[intEndIndex] < 0)
            {
                j = intEndIndex - 1;
                while (arrByte[j] < 0)
                {
                    j--;
                    if (j < intStartIndex) {
                        break;
                    }
                }
                if ((intEndIndex - j) % 2 != 0) {
                    intEndIndex--;
                }
            }
            arrReturn[i] = new String(arrByte, intStartIndex, intEndIndex - intStartIndex + 1);
            if (intEndIndex == arrByte.length - 1) {
                break;
            }
            intStartIndex = intEndIndex + 1;
        }
        return arrReturn;
    }

    public static String chgStrZero(String iValue)
    {
        String value = null;
        if (iValue == null) {
            value = "0";
        } else if (iValue.trim().length() == 0) {
            value = "0";
        } else {
            value = iValue;
        }
        return value.trim();
    }

    public static String getYear()
    {
        String strReturn = "";
        int intYear = Calendar.getInstance().get(1);
        strReturn = "" + intYear;
        return strReturn;
    }

    public static String getMonth()
    {
        String strReturn = "";
        int intMonth = Calendar.getInstance().get(2) + 1;
        if (intMonth < 10) {
            strReturn = "0" + intMonth;
        } else {
            strReturn = "" + intMonth;
        }
        return strReturn;
    }

    public static String getDay()
    {
        String strReturn = "";
        int intDate = Calendar.getInstance().get(5);
        if (intDate < 10) {
            strReturn = "0" + intDate;
        } else {
            strReturn = "" + intDate;
        }
        return strReturn;
    }

    public static String getHour()
    {
        String strReturn = "";
        int intHour = Calendar.getInstance().get(10) + 12 * Calendar.getInstance().get(9);
        if (intHour < 10) {
            strReturn = "0" + intHour;
        } else {
            strReturn = "" + intHour;
        }
        return strReturn;
    }

    public static String getMinute()
    {
        String strReturn = "";
        int intMinute = Calendar.getInstance().get(12);
        if (intMinute < 10) {
            strReturn = "0" + intMinute;
        } else {
            strReturn = "" + intMinute;
        }
        return strReturn;
    }

    public static String getSecond()
    {
        String strReturn = "";
        int intSecond = Calendar.getInstance().get(13);
        if (intSecond < 10) {
            strReturn = "0" + intSecond;
        } else {
            strReturn = "" + intSecond;
        }
        return strReturn;
    }

    public static String[] split(String strIn, String strDelimiters)
            throws Exception
    {
        int theIndex = 0;
        String[] arrReturn = null;
        String strErrorMessage = "";
        int intCount = 0;
        if ((strIn.equals("")) || (strIn == null) || (strDelimiters.equals("")) || (strDelimiters == null))
        {
            strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): 待拆分字符串和分隔符串都不能为空";

            throw new Exception(strErrorMessage);
        }
        if (strIn.length() < strDelimiters.length())
        {
            strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): 待拆分字符串比分隔符串还要短";
            throw new Exception(strErrorMessage);
        }
        String strTemp = strIn;
        while ((strTemp != "") && (strTemp != null))
        {
            theIndex = strTemp.indexOf(strDelimiters);
            if (theIndex == -1) {
                break;
            }
            intCount++;
            strTemp = strTemp.substring(theIndex + strDelimiters.length());
        }
        intCount++;arrReturn = new String[intCount];
        for (int i = 0; i < intCount - 1; i++)
        {
            theIndex = strIn.indexOf(strDelimiters);
            arrReturn[i] = strIn.substring(0, theIndex);
            strIn = strIn.substring(theIndex + strDelimiters.length());
        }
        arrReturn[(intCount - 1)] = strIn;

        return arrReturn;
    }

    public static String rightTrim(String strIn)
    {
        String strReturn = "";
        int intLength = 0;
        if ((strIn == null) || (strIn.equals("")) || (strIn.equals("null"))) {
            return "";
        }
        intLength = strIn.length();
        while ((intLength > 0) && (strIn.substring(intLength - 1, intLength).equals(" ")))
        {
            strIn = strIn.substring(0, intLength - 1);
            intLength = strIn.length();
        }
        strReturn = strIn;
        return strReturn;
    }

    public static double round(double v, int scale)
    {
        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, 4).doubleValue();
    }

    public static String convertInt(String strName, String strValue, String strSign)
    {
        String strReturn = "";
        if ((strValue == null) || (strValue.equals(""))) {
            return "";
        }
        if (strSign.equals(":"))
        {
            String strValueStart = "";
            String strValueEnd = "";
            int index = strValue.indexOf(':');
            if (index > -1)
            {
                strValueStart = strValue.substring(0, index);
                strValueEnd = strValue.substring(index + 1);
                strReturn = " and " + strName + " between '" + strValueStart + "' and '" + strValueEnd + "' ";
            }
            else
            {
                return "";
            }
        }
        else
        {
            strReturn = " and " + strName + strSign + strValue;
        }
        return strReturn;
    }
}
