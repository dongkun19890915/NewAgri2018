package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/***
* @description: （保单抄件打印返回数据Dto）
* @Author: 王志文
* @Date: 2017/11/15 15:36
*/
public class CopyPrintBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 险种名称 */
    private String riskCName;
    /** 报案号 */
    private String registNo;
    /** 保险单号 */
    private String policyNo;
    /** 被保险人名称 */
    private String insuredName;
    /** 被保险人地址 */
    private String insuredAddress;
    /** 保险项目 */
    private String itemDetailName;
    /** 单位保额 */
    private double unitAmount;
    /** 数量 */
    private double amount;
    /** 保险金额 */
    private double sumAmount;
    /** 总保险金额 */     //CNY2527000.00
    private String sumAmount1;
    /** 每次事故绝对免赔 */
    private String deductible;
    /** 投保日期 */
    private String operateDate;
    /** 录入日期 */
    private String inputDate;
    /** 签单日期 */
    private String signDate;
    /** 出单日期 */
    private String outputDate;
    /** 保险期间起 */
    private String startDate;
    /** 保险期间止 */
    private String endDate;
    /** 是否涉及再保临分、联保、共保 */  //CoinsFlag
    private String coinsFlag; //========================
    /** 特别约定 */  //prpcengage
    private String clauses;

    /** 数据循环体 */
    private List<CopyPrintListDto> copyPrintListDtoList;

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress;
    }

    public String getItemDetailName() {
        return itemDetailName;
    }

    public void setItemDetailName(String itemDetailName) {
        this.itemDetailName = itemDetailName;
    }

    public double getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(double unitAmount) {
        this.unitAmount = unitAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumAmount1() {
        return sumAmount1;
    }

    public void setSumAmount1(String sumAmount1) {
        this.sumAmount1 = sumAmount1;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
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

    public String getCoinsFlag() {
        return coinsFlag;
    }

    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

    public List<CopyPrintListDto> getCopyPrintListDtoList() {
        return copyPrintListDtoList;
    }

    public void setCopyPrintListDtoList(List<CopyPrintListDto> copyPrintListDtoList) {
        this.copyPrintListDtoList = copyPrintListDtoList;
    }
    public String getClauses() {
        return clauses;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }
}
