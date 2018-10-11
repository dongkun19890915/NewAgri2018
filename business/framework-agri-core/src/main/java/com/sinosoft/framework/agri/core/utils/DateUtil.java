package com.sinosoft.framework.agri.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 日期时间常用方法
 * @Author: 汪强
 * @Date: 2017/11/13 15:06
 */
public class DateUtil {
    //测试验证
    public static void main(String[] args){
        Date date=new Date();
        Date date1=dateAddMonth(date,10);

        System.out.println("date："+formatDate(date));
        System.out.println("date1："+formatDate(date1));

//        System.out.println("日期格式化:"+formatDate(date,"yyyy-MM-dd"));
//        System.out.println("当月第一天:"+getMonthFirstDay());
//        System.out.println("当月最后一天:"+getMonthLastDay());
//        System.out.println("当前日期:"+formatDate(date));
//        System.out.println("日加减："+formatDate(dateAddDay(date,-2)));
//        System.out.println("月加减："+formatDate(dateAddMonth(date,-2)));
//        System.out.println("年加减："+formatDate(dateAddYear(date,-2)));

        System.out.println(differentDays(date,date1));
        System.out.println(differentMonths(date,date1));
    }

    /**
     * 日期格式化
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        return formatDate(date,null);
    }


    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format){
        if(format==null||format.isEmpty()){
            format="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simform=new SimpleDateFormat(format);
        return simform.format(date);
    }


    /**
     * 日期 计算日差 天数
     * @param date
     * @param day
     * @return
     */
    public static Date dateAddDay(Date date,int day){
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_YEAR, day);
        return cl.getTime();
    }

    /**
     * 日期 计算月差 月数
     * @param date
     * @param month
     * @return
     */
    public static Date dateAddMonth(Date date,int month){
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.MONTH, month);
        return cl.getTime();
    }

    /**
     * 日期 计算月差 年数
     * @param date
     * @param year
     * @return
     */
    public static Date dateAddYear(Date date,int year){
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.YEAR, year);
        return cl.getTime();
    }

    /**
     * 计算日期差 天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static int differentDays(Date startDate,Date endDate){
        long start = startDate.getTime();
        long end = endDate.getTime();
        int days = (int) ((end - start)/(1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * 计算日期差 月数
     * @param startDate
     * @param endDate
     * @return
     */
    public static int differentMonths(Date startDate,Date endDate){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(endDate);
        c2.setTime(startDate);

        int result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result;
    }


    //TODO 增加获取指定日期的当前第一天和最后一天
    /**
     * 获取当前月第一天
     * @author: 汪强
     * @date: 2017/11/13 15:05
     * @param
     * @return String
     */
    public static String getMonthFirstDay() {
        return getMonthFirstDay(null);
    }

    /**
     * 获取当前月第一天
     * @author: 汪强
     * @date: 2017/11/13 15:05
     * @param format 日期格式化
     * @return String
     */
    public static String getMonthFirstDay(String format){
        if(format==null||format.isEmpty()){
            format="yyyy-MM-dd";
        }
        // 获取当前年份、月份、日期
        Calendar cale =  Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = sformat.format(cale.getTime());
        return firstday;
    }


    /**
     * 获取当前月最后一天
     * @author: 汪强
     * @date: 2017/11/13 15:05
     * @param
     * @return String
     */
    public static String getMonthLastDay() {
        return getMonthLastDay(null);
    }

    /**
     * 获取当前月最后一天
     * @author: 汪强
     * @date: 2017/11/13 15:05
     * @param format 日期格式化
     * @return String
     */
    public static String getMonthLastDay(String format) {
        if(format==null||format.isEmpty()){
            format="yyyy-MM-dd";
        }
        // 获取当前年份、月份、日期
        Calendar cale =  Calendar.getInstance();
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastday = sformat.format(cale.getTime());
        return lastday;
    }
}
