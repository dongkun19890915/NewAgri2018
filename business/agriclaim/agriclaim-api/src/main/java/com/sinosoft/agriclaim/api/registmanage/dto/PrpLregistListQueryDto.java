package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;

public class PrpLregistListQueryDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 交费情况 */
    private String payFlag ;
    /** 报案分钟 */
    private String reportMinute;
    /**出险开始分钟*/
    private String damageStartMinute;
    /**被保险人显示名称*/
    private String insuredNameShow;
    /**代理人代码*/
    private String agentCode;
    /**此报案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5 已撤消 */
    private String status;
    /**单号*/
    private String certiNo;
    /**单号类型*/
    private String certiType;
    /**代理人名称*/
    private String agentName;
    /**币别名称*/
    private String estiCurrencyName;
    /**被保险人类型*/
    private String customerType;
    /**操作员名称*/
    private String operatorName;
    /**排列记录的编号*/
    private int serialNo;
    /**出险次数*/
    private int perilCount;
    /**最近N天出险次数*/
    private int recentCount;
    /**经办人名称*/
    private String handler1Name;
    /**部门名称*/
    private String comName;
    /**理赔登记机构?*/
    private String makeComName;
    /**条款名称*/
    private String clauseName;
    /**处理单位名称*/
    private String handleUnitName;
    /**启保日期*/
    private String startDate;
    /**终保日期*/
    private String endDate;
    /**保险金额*/
    private double sumAmount;
    /**签单日期*/
    private Date signDate;
    public String getPayFlag() {
        return payFlag;
    }
    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }
    public String getReportMinute() {
        return reportMinute;
    }
    public void setReportMinute(String reportMinute) {
        this.reportMinute = reportMinute;
    }
    public String getDamageStartMinute() {
        return damageStartMinute;
    }
    public void setDamageStartMinute(String damageStartMinute) {
        this.damageStartMinute = damageStartMinute;
    }
    public String getInsuredNameShow() {
        return insuredNameShow;
    }
    public void setInsuredNameShow(String insuredNameShow) {
        this.insuredNameShow = insuredNameShow;
    }
    public String getAgentCode() {
        return agentCode;
    }
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCertiNo() {
        return certiNo;
    }
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }
    public String getCertiType() {
        return certiType;
    }
    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }
    public String getAgentName() {
        return agentName;
    }
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    public String getEstiCurrencyName() {
        return estiCurrencyName;
    }
    public void setEstiCurrencyName(String estiCurrencyName) {
        this.estiCurrencyName = estiCurrencyName;
    }
    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public int getSerialNo() {
        return serialNo;
    }
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
    public int getPerilCount() {
        return perilCount;
    }
    public void setPerilCount(int perilCount) {
        this.perilCount = perilCount;
    }
    public int getRecentCount() {
        return recentCount;
    }
    public void setRecentCount(int recentCount) {
        this.recentCount = recentCount;
    }
    public String getHandler1Name() {
        return handler1Name;
    }
    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
    }
    public String getMakeComName() {
        return makeComName;
    }
    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }
    public String getClauseName() {
        return clauseName;
    }
    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }
    public String getHandleUnitName() {
        return handleUnitName;
    }
    public void setHandleUnitName(String handleUnitName) {
        this.handleUnitName = handleUnitName;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public double getSumAmount() {
        return sumAmount;
    }
    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }
    public Date getSignDate() {
        return signDate;
    }
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
    
    
}
