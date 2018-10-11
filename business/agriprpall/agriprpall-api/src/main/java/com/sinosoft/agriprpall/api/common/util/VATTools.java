package com.sinosoft.agriprpall.api.common.util;

import java.math.BigDecimal;

/**
 *
 * @ClassName: VATTools
 * @Description: TODO 价税分离计算工具类
 * @author 紫金财险中科软项目组
 * @date 2016-3-26 下午03:37:47
 * @version V1.0
 *
 */
public class VATTools {

    /*
     * @Title: add
     * @Description:
     * TODO 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.add(b2).doubleValue(),2);
    }

    /*
     * @Title: add
     * @Description:
     * TODO 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static String add(String v1,String v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return String.valueOf(round(b1.add(b2).doubleValue(),2));
    }

    /*
     * @Title: sub
     * @Description:
     * TODO 提供精确的减法运算。  v1-v2
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.subtract(b2).doubleValue(),2);
    }

    /*
     * @Title: div
     * @Description:
     * TODO 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。  v1÷v2
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /*
     * @Title: mul
     * @Description:
     * TODO 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     * @return 返回保留小数点后2位的double
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(),2);
    }

    /*
     * @Title: mul
     * @Description:
     * TODO 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     * @return 返回保留小数点后2位的double
     */
    public static String mul(String v1,String v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return String.valueOf(round(b1.multiply(b2).doubleValue(),2));
    }

    /*
     * @Title: round
     * @Description:
     * TODO进行四舍五入 操作
     * TODO[功能详细描述]
     * @param d
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return
     */
    public static double round(double d, int scale) {
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        // 任何一个数字除以1都是原数字
        // ROUND_HALF_UP是BigDecimal的一个常量，表示进行四舍五入的操作
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double sumFee=1000;
        double taxRate=0.064001;
        double dutyRatio=0.1356;
        System.out.println("+-   ="+VATTools.mul(sumFee, (1+taxRate*(1-dutyRatio))));
        System.out.println("公式   ="+VATTools.mul(sumFee, VATTools.add(1, VATTools.mul(taxRate,(VATTools.sub(1, dutyRatio))))));
        System.out.println("公式   ="+VATTools.div(taxRate, dutyRatio,2));

    }

}
