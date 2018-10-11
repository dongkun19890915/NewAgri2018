package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;

/**
 * 业务清单查询结果数据，将数据导出到Excel中时需要添加@ExportConfig注解
 * @Author: 何伟东
 * @Date: 2017/11/28 14:41
 */
public class ResponseBusinessListDto {

    /**序号*/
    @ExportConfig(value = "序号",width = 70)
    private int id;
    /** 保单号*/
    @ExportConfig(value = "保单号码",width = 200)
    private String policyNo;
    /** 险种名称*/
    @ExportConfig(value = "险种", width = 150)
    private String riskName;
    /** 被保险人名称*/
    @ExportConfig(value = "被保险人")
    private String insuredName;
    /** 操作时间*/
    @ExportConfig(value = "操作时间",width = 150)
    private String date;
    /** 操作员名称*/
    @ExportConfig(value = "操作人",width = 150)
    private String operatorName;
    /** 保险金额*/
    @ExportConfig(value = "保险金额")
    private String sumAmount;
    /** 保险费*/
    @ExportConfig(value = "保险费")
    private String sumPremium;
    /** 拖欠金额*/
    @ExportConfig(value = "未缴保险费")
    private String delinQuentFee;
    /** 应交保费*/
    @ExportConfig(value = "已缴保险费",enabled = false)
    private String planFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanFee() {
        return planFee;
    }

    public void setPlanFee(String planFee) {
        this.planFee = planFee;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getDelinQuentFee() {
        return delinQuentFee;
    }

    public void setDelinQuentFee(String delinQuentFee) {
        this.delinQuentFee = delinQuentFee;
    }
}
