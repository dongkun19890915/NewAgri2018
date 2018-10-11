package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class CompensatePrintBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 清单显示标志 */
    private String listFlag;
    /** 险种名称 */
    private String riskCName;
    /** 赔款计算书号 */
    private String compensateNo;
    /** 赔案编号 */
    private String claimNo; //立案号
    /** 被保险人 */
    private String insuredName;
    /** 保单号码 */
    private String policyNo;
    /** 出险时间日期与小时 */
    private String damageStartDate;
    /** 保险金额 */
    private String amount;//prpcitemkind
    /** 出险地点 */
    private String damageAddress;
    /** 有效保额 */
    private String validAmount;
    /** 出险原因 */
    private String damageName;
    /** 保险期限起 */
    private String startDate;
    /** 保险期限止 */
    private String endDate;
    /** 保险标的 */
    private String itemCName;
    /** 被保险人开户银行 */
    private String bank;
    /** 支付账号 */
    private String account;
    /** 收款人全称 */
    private String receiverName;
    /** 计算公式及结果 */
    private String tempContext;
    /** 计算公式及结果多于6条时 */
    private String tempContext1;
    /** 保险标的损失 */
    private double sumClaim;
    /** 合计金额 */
    private double sumDutyPaid;
    /** 实赔金额 */
    private double sumPaid;
    /** 赔讫日期 */
    private String underWriteEndDate;
    /** 缮制 */
    private String userName;
    /** 审核 */
    private String underWriteName;

    private String payRefName;

    private String payRefDate;

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDamageAddress() {
        return damageAddress;
    }

    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress;
    }

    public String getValidAmount() {
        return validAmount;
    }

    public void setValidAmount(String validAmount) {
        this.validAmount = validAmount;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public String getItemCName() {
        return itemCName;
    }

    public void setItemCName(String itemCName) {
        this.itemCName = itemCName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getTempContext() {
        return tempContext;
    }

    public void setTempContext(String tempContext) {
        this.tempContext = tempContext;
    }

    public String getTempContext1() {
        return tempContext1;
    }

    public void setTempContext1(String tempContext1) {
        this.tempContext1 = tempContext1;
    }

    public double getSumClaim() {
        return sumClaim;
    }

    public void setSumClaim(double sumClaim) {
        this.sumClaim = sumClaim;
    }

    public double getSumDutyPaid() {
        return sumDutyPaid;
    }

    public void setSumDutyPaid(double sumDutyPaid) {
        this.sumDutyPaid = sumDutyPaid;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public String getUnderWriteEndDate() {
        return underWriteEndDate;
    }

    public void setUnderWriteEndDate(String underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
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

    public String getListFlag() {
        return listFlag;
    }

    public void setListFlag(String listFlag) {
        this.listFlag = listFlag;
    }

    public String getPayRefName() {
        return payRefName;
    }

    public void setPayRefName(String payRefName) {
        this.payRefName = payRefName;
    }

    public String getPayRefDate() {
        return payRefDate;
    }

    public void setPayRefDate(String payRefDate) {
        this.payRefDate = payRefDate;
    }
}
