package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ResponseEndorseListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 批单号码 */
    private String endorseNo ;
    /** 批次号*/
    private String batchNo;
    /** 保单号码 */
    private String policyNo ;
    /** 投保人名称 */
    private String appliName ;
    /** 被保险人名称 */
    private String insuredName ;
    /** 操作员代码 */
    private String operatorCode ;
    /** 操作员名称*/
    private String operatorName;
    /** 操作时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date operateDate;
    /** 核批标志 */
    private String underwriteFlag ;
    /*其它标志字段*/
    private String othFlag;
    private double sumPremium;
    private double chgPremium;
    private double sumAmount;
    private double chgAmount;
    private String printNo;

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    public String getOthFlag() {
        return othFlag;
    }

    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }

    public ResponseEndorseListDto(String endorseNo, String batchNo, String policyNo, String appliName  , String insuredName , String operatorCode, Date operateDate  ,
                                  String underwriteFlag , String othFlag,double sumPremium,double chgPremium,double sumAmount,double chgAmount,String printNo){

        this.endorseNo=endorseNo;
        this.batchNo=batchNo;
        this.policyNo  =policyNo  ;
        this.appliName  =appliName  ;
        this.insuredName =insuredName ;
        this.operatorCode=operatorCode;
        this.operateDate  =operateDate  ;
        this.underwriteFlag=underwriteFlag;
        this.othFlag=othFlag;
        this.sumPremium=sumPremium;
        this.chgPremium=chgPremium;
        this.sumAmount=sumAmount;
        this.chgAmount=chgAmount;
        this.printNo=printNo;
    }

    public double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public double getChgPremium() {
        return chgPremium;
    }

    public void setChgPremium(double chgPremium) {
        this.chgPremium = chgPremium;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public double getChgAmount() {
        return chgAmount;
    }

    public void setChgAmount(double chgAmount) {
        this.chgAmount = chgAmount;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUnderwriteFlag() {
        return underwriteFlag;
    }

    public void setUnderwriteFlag(String underwriteFlag) {
        this.underwriteFlag = underwriteFlag;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }
}
