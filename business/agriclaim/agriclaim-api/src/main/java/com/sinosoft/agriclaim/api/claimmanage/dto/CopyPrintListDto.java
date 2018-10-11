package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class CopyPrintListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /* 是否显示标志 */
    /** 附加险标志 */
    private String addFlag;
    /** 附加险头部标志 */
    private String addHeadFlag;
    /** 附加险数据标志 */
    private String addBodyFlag;
    /** 批改情况标志 */
    private String correctFlag;
    /** 批改情况头部 */
    private String correctHeadFlag;
    /** 批改情况数据 */
    private String correctBodyFlag;
    /** 保费到账情况标志 */
    private String endorseFlag;
    /** 保费到账情况头部标志 */
    private String endorseHeadFlag;
    /** 保费到账情况数据标志 */
    private String endorseBodyFlag;
    /** 历史赔付记录标志 */
    private String historyFlag;
    /** 历史赔付头部标志 */
    private String historyHeadFlag;
    /** 历史赔付数据标志 */
    private String historyBodyFlag;
    /** 结尾标志 */
    private String endFlag;



    /* 附加险 */
    /** 名称 */
    private String kindName;
    /** 保额/限额  */
    private double dbAmount;
    /** 每次赔偿限额 */
    private Double dbDeductible;

    /* 批改情况 */
    /** 批改情况中批单号 */
    private String endorseNo1;
    /** 批改原因 */
    private String endorseReason;
    /** 批改时间 */
    private String endorDate;
    /** 核保人 */
    private String underWriteName1;

    /* 保费到账情况 */
    /** 付款期数 */
    private int payNo;
    /** 批单号 */
    private String endorseNo;
    /** 应收 */
    private String planFee;
    /** 实收 */
    private String realFee;//planFee - delinQuentFee
    /** 到账日期 */
    private String payDate;

    /* 历史赔付记录 */
    /** 立案号 */
    private String claimNo;
    /** 出险时间 */
    private String damageStartDate;
    /** 未决金额 */
    private double undeterminedAmount;
    /** 赔付金额 */
    private double sumPaid;
    /** 结案日期 */
    private String endCaseDate;
    /** 理算人 */
    private String userName1;
    /** 核赔人*/
    private String underWriteName;
    /** 赔付次数 */
    private int claimTimes;

    /** 抄单人 */  //当前userName
    private String userName;
    /** 抄单日期 */ //当前日期
    private String printDate;
    public String getAddHeadFlag() {
        return addHeadFlag;
    }

    public void setAddHeadFlag(String addHeadFlag) {
        this.addHeadFlag = addHeadFlag;
    }

    public String getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(String correctFlag) {
        this.correctFlag = correctFlag;
    }

    public String getEndorseFlag() {
        return endorseFlag;
    }

    public void setEndorseFlag(String endorseFlag) {
        this.endorseFlag = endorseFlag;
    }

    public String getHistoryFlag() {
        return historyFlag;
    }

    public void setHistoryFlag(String historyFlag) {
        this.historyFlag = historyFlag;
    }

    public String getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(String addFlag) {
        this.addFlag = addFlag;
    }

    public String getAddBodyFlag() {
        return addBodyFlag;
    }

    public void setAddBodyFlag(String addBodyFlag) {
        this.addBodyFlag = addBodyFlag;
    }

    public String getCorrectHeadFlag() {
        return correctHeadFlag;
    }

    public void setCorrectHeadFlag(String correctHeadFlag) {
        this.correctHeadFlag = correctHeadFlag;
    }

    public String getCorrectBodyFlag() {
        return correctBodyFlag;
    }

    public void setCorrectBodyFlag(String correctBodyFlag) {
        this.correctBodyFlag = correctBodyFlag;
    }

    public String getEndorseHeadFlag() {
        return endorseHeadFlag;
    }

    public void setEndorseHeadFlag(String endorseHeadFlag) {
        this.endorseHeadFlag = endorseHeadFlag;
    }

    public String getEndorseBodyFlag() {
        return endorseBodyFlag;
    }

    public void setEndorseBodyFlag(String endorseBodyFlag) {
        this.endorseBodyFlag = endorseBodyFlag;
    }

    public String getHistoryHeadFlag() {
        return historyHeadFlag;
    }

    public void setHistoryHeadFlag(String historyHeadFlag) {
        this.historyHeadFlag = historyHeadFlag;
    }

    public String getHistoryBodyFlag() {
        return historyBodyFlag;
    }

    public void setHistoryBodyFlag(String historyBodyFlag) {
        this.historyBodyFlag = historyBodyFlag;
    }

    public String getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public double getDbAmount() {
        return dbAmount;
    }

    public void setDbAmount(double dbAmount) {
        this.dbAmount = dbAmount;
    }

    public Double getDbDeductible() {
        return dbDeductible;
    }

    public void setDbDeductible(Double dbDeductible) {
        this.dbDeductible = dbDeductible;
    }

    public String getEndorseNo1() {
        return endorseNo1;
    }

    public void setEndorseNo1(String endorseNo1) {
        this.endorseNo1 = endorseNo1;
    }

    public String getEndorseReason() {
        return endorseReason;
    }

    public void setEndorseReason(String endorseReason) {
        this.endorseReason = endorseReason;
    }

    public String getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(String endorDate) {
        this.endorDate = endorDate;
    }

    public String getUnderWriteName1() {
        return underWriteName1;
    }

    public void setUnderWriteName1(String underWriteName1) {
        this.underWriteName1 = underWriteName1;
    }

    public int getPayNo() {
        return payNo;
    }

    public void setPayNo(int payNo) {
        this.payNo = payNo;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPlanFee() {
        return planFee;
    }

    public void setPlanFee(String planFee) {
        this.planFee = planFee;
    }

    public String getRealFee() {
        return realFee;
    }

    public void setRealFee(String realFee) {
        this.realFee = realFee;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public double getUndeterminedAmount() {
        return undeterminedAmount;
    }

    public void setUndeterminedAmount(double undeterminedAmount) {
        this.undeterminedAmount = undeterminedAmount;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public String getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(String endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getUnderWriteName() {
        return underWriteName;
    }

    public void setUnderWriteName(String underWriteName) {
        this.underWriteName = underWriteName;
    }

    public int getClaimTimes() {
        return claimTimes;
    }

    public void setClaimTimes(int claimTimes) {
        this.claimTimes = claimTimes;
    }
}
