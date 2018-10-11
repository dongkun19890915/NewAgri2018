package com.sinosoft.agriprpall.api.policymanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询保单业务详细信息Dto
 * @Author: 刘曼曼
 * @Date: 2017/11/14 14:31
 */
public class ResponseMyJobDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /*业务号*/
    private String businessNo;
    /*险种代码*/
    private String riskCode;
    /*险种名称*/
    private String riskName;
    /*业务类型*/
    private String businessType;
    /*保险起期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    /*被保人*/
    private String insuredName;
    /*操作员代码*/
    private String operatorCode;
    /*操作员名称*/
    private  String operatorName;
    /*更新日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date operateDate;
    /*状态*/
    private String status;
    /** 投保人名称 */
    private String appliName ;
    /** 终保日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date endDate ;
    /** 投保人名称 */
    private String businessType1 ;

    /** 打印状态 */
    private String printNo ;

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
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



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
