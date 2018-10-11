package com.sinosoft.uap.utils;

import java.math.BigDecimal;

public class DataUtils
{
  private static final BigDecimal ONE = new BigDecimal("1");

  public static String zeroToEmpty(int i)
  {
    return i == 0 ? "" : String.valueOf(i);
  }

  public static String zeroToEmpty(double d)
  {
    return d == 0.0D ? "" : String.valueOf(d);
  }

  public static String nullToEmpty(String str)
  {
    return str == null ? "" : str;
  }

  public static String emptyToNull(String str)
  {
    if (str == null) {
      return null;
    }
    if (str.trim().length() == 0) {
      return null;
    }
    return str;
  }

  public static String dbNullToEmpty(String str)
  {
    if ((str == null) || (str.equalsIgnoreCase("null"))) {
      return "";
    }
    return str;
  }

  public static String nullToZero(String str)
  {
    if ((str == null) || (str.trim().length() == 0)) {
      return "0";
    }
    return str;
  }

  public static String getBooleanDescribe(String str)
  {
    if (str == null) {
      throw new IllegalArgumentException("argument is null");
    }
    if ((str.equalsIgnoreCase("y")) || (str.equalsIgnoreCase("yes")) || (str.equalsIgnoreCase("true")) || (str.equalsIgnoreCase("t")) || (str.equalsIgnoreCase("是")) || (str.equalsIgnoreCase("1")))
    {
      return "是";
    }if ((str.equalsIgnoreCase("n")) || (str.equalsIgnoreCase("no")) || (str.equalsIgnoreCase("false")) || (str.equalsIgnoreCase("f")) || (str.equalsIgnoreCase("否")) || (str.equalsIgnoreCase("0")))
    {
      return "否";
    }if (str.trim().equals("")) {
      return "";
    }
    throw new IllegalArgumentException("argument not in ('y','n','yes','no','true','false','t','f','是','否','1','0','')");
  }

  public static boolean getBoolean(String str)
  {
    if (str == null) {
      throw new IllegalArgumentException("argument is null");
    }
    if ((str.equalsIgnoreCase("y")) || (str.equalsIgnoreCase("yes")) || (str.equalsIgnoreCase("true")) || (str.equalsIgnoreCase("t")) || (str.equalsIgnoreCase("是")) || (str.equalsIgnoreCase("1")))
    {
      return true;
    }if ((str.equalsIgnoreCase("n")) || (str.equalsIgnoreCase("no")) || (str.equalsIgnoreCase("false")) || (str.equalsIgnoreCase("f")) || (str.equalsIgnoreCase("否")) || (str.equalsIgnoreCase("0")))
    {
      return false;
    }if (str.trim().equals("")) {
      return false;
    }
    throw new IllegalArgumentException("argument not in ('y','n','yes','no','true','false','t','f','是','否','1','0','')");
  }

  public static String getBooleanDescribe(boolean bln)
  {
    if (bln) {
      return getBooleanDescribe("true");
    }
    return getBooleanDescribe("false");
  }

  public static int compareByValue(String str1, String str2)
  {
    BigDecimal big1 = new BigDecimal(str1);
    BigDecimal big2 = new BigDecimal(str2);
    return big1.compareTo(big2);
  }

  public static double round(double value, int scale)
  {
    BigDecimal b = new BigDecimal(Double.toString(value));
    return b.divide(ONE, scale, 4).doubleValue();
  }
}
