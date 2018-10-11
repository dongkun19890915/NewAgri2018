package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/***
 * @description: （拒赔注销通知书返回数据Dto）
 * @Author: 王志文
 * @Date: 2017/11/14 10:43
 */
public class RefuseCancelBackPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 报案号 */
    private String registNo;
    /** 归档号 */
    private String caseNo;
    /** 被保险人 */
    private String insuredName;
    /** 保险金额 */
    private double sumAmount;
    /** 保险险别 */
    private String riskCName;
    /** 保险标的名称 */
    private String itemCName;
    /** 保单号码 */
    private String policyNo;
    /** 保险期间起 */
    private String startDate;
    /** 保险期间止 */
    private String endDate;
    /** 出险时间 */
    private String damageStartDate;
    /** 出险地点 */
    private String damageAddress;
    /** 出险原因 */
    private String damageName;
    /** 拒赔/注销理由 */
    private String cancelReason;
    /** 本公司地址 */
    private String addressCName;
    /** 邮政编码 */
    private String postCode;
    /** 联系电话 */
    private String phoneNumber;
    /** 打印时间 */
    private String printTime;

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getItemCName() {
        return itemCName;
    }

    public void setItemCName(String itemCName) {
        this.itemCName = itemCName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public String getDamageAddress() {
        return damageAddress;
    }

    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public String getAddressCName() {
        return addressCName;
    }

    public void setAddressCName(String addressCName) {
        this.addressCName = addressCName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
