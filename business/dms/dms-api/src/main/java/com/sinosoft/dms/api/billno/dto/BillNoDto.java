package com.sinosoft.dms.api.billno.dto;

import java.io.Serializable;

/**
 * 单号生成对象
 * tableName 表单
 * riskCode 险种
 * iComCode 机构代码
 * iYear 年份
 * policyNo 保单号
 * @author: 钱浩
 * @date: 2017/12/1 上午 11:30
 */
public class BillNoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tableName;
    private String riskCode;
    private String iComCode;
    private String iYear;
    private String userCode;
    private String policyNo;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getiComCode() {
        return iComCode;
    }

    public void setiComCode(String iComCode) {
        this.iComCode = iComCode;
    }

    public String getiYear() {
        return iYear;
    }

    public void setiYear(String iYear) {
        this.iYear = iYear;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
