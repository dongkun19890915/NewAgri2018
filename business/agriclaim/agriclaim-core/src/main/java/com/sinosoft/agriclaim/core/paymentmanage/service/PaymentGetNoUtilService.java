package com.sinosoft.agriclaim.core.paymentmanage.service;

public interface PaymentGetNoUtilService {

    /**
     * （获取一个新的编号）
     * @author: 王志文
     * @date: 2017/12/27 11:45
     * @param iTableName 表名
     * @param iRiskCode 险种代码
     * @param iComCode 机构代码
     * @param iYear 当前年份
     * @return 新的编号
     */
    public String getNo(String iTableName,String iRiskCode,String iComCode,int iYear);
}
