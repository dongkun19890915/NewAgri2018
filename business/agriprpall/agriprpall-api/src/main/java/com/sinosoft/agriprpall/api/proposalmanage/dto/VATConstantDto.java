package com.sinosoft.agriprpall.api.proposalmanage.dto;

/**
 *
 * @ClassName: VATConstant
 * @Description: TODO价税分离常量类
 * @author 紫金财险中科软项目组
 * @date 2016-3-21 下午02:35:48
 * @version V1.0
 *
 */
public class VATConstantDto {
    //VATFEETYPE 计算价税分离的费用类型-匹配到税率
    public static String VATFEETYPE_BAOFEI="1";//保费（投保单、批单）
    public static String VATFEETYPE_TUIBAOSHOUXUFEI="2";//退保手续费
    public static String VATFEETYPE_GONGBAO="3";//联共保出单费
    public static String VATFEETYPE_TOUZIJINSHOUXUFEI="4";//投资金退保手续费
    public static String VATFEETYPE_FENRU="5";//分入业务
    public static String VATFEETYPE_SHOUXUFEI="9";//手续费（保单、批单）

    //FORMULA 计算公式
    public static String FORMULA_1 ="1";//公式1：税额=含税保费-不含税保费
    public static String FORMULA_2 ="2";//公式2：税额=不含税保费*税率

    //应税、免税标识
    public static String TAKFLAG_1 ="1";//应税
    public static String TAKFLAG_2 ="2";//免税

    //共保标识
    public static String COINSFLAG_1 ="1";//主共保
    public static String COINSFLAG_2 ="2";//从共保

    //手续费价税分离保费基数类型）
    /**
     * 1-按含税保费计算手续费
     */
    public static String EXPENSECALTYPE_1 ="1";
    /**
     *2-不含税保费计算手续费
     */
    public static String EXPENSECALTYPE_2 ="2";

    //是否本公司标识
    public static String COMFLAG_1 = "1";//是
    public static String COMFLAG_2 = "2";//不是 默认

}