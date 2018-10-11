package com.sinosoft.agriclaim.api;
/**
 * Created by Zhoujiawei on 2017/09/25.
 */
public class AgriClaimConstant {
    public static final String AGRI_CLAIM_SERVICE_NAME = "agriclaim";
    //流程查询当前状态，nodestatus,（0待处理 /2正在处理/3回退处理4已提交5不通过退回）
    public static final String AGRI_CLAIM_DONE = "已处理";
    public static final String AGRI_CLAIM_BEING_DONE = "正在处理";
    public static final String AGRI_CLAIM_TO_BE_DONE = "未处理";
    //流程状态“0”-流转结束；“1”-正常流转；“9”-流转异常
    public static final String AGRI_CLAIM_FLOWEND = "流转结束";
    public static final String AGRI_CLAIM_FLOWNOMAL = "正常流转";
    public static final String AGRI_CLAIM_FLOWEXCEPTION = "流转异常";
    //关闭和创建
    public static final String AGRI_CLAIM_CLOSE = "关闭";
    public static final String AGRI_CLAIM_CREATE = "创建";
    //是否特殊赔案
    public static final String AGRI_CLAIM_NOTSPECIALCASE ="非特殊赔案";
    public static final String AGRI_CLAIM_SPECIALCASE = "特殊赔案";
    //非车险查勘区域险类
    public static final String AGRI_CLAIM_CLASSCODE="99";
    //查勘的节点类型
    public static final String AGRI_CLAIM_CHECK="check";
    //理赔系统代码
    public static final String AGRI_CLAIM_SYSTEMCODE="claim";
    //上午8点
    public static final String AGRI_CLAIM_FORENOON=" 08:00:00";
    //上午8点对应的当前小时
    public static final Integer AGRI_CLAIM_FOREHOUR=8;
    //下午18点
    public static final String AGRI_CLAIM_AFTERNOON=" 18:00:00";
    //下午18点对应的当前小时
    public static final Integer AGRI_CLAIM_AFTERHOUR=18;
    public static final String AGRI_CLAIM_BACKPAY = "BackOldVeriPay"; //审核不通过的支付信息
    public static final String AGRI_CLAIM_PASSPAY = "PassOldVeriPay"; //审核通过的支付信息
    public static final String AGRI_CLAIM_GIVEUPPAY = "GiveUpOldVeriPay"; //支付信息审核放弃
    public static final String AGRI_CLAIM_SERVICE_JOBCOMCODE = "JobComCode";//归属机构
    public static final String AGRI_CLAIM_SERVICE_CERTAJOBCODE = "CertaJobCode";//查询被维护人
    public static final String AGRI_CLAIM_SERVICE_AREACODE = "AreaCode";//查询作业区域
    public static final String AGRI_CLAIM_SERVICE_STAFFNAMECODE = "StaffNameCode";//查询人员姓名
}
