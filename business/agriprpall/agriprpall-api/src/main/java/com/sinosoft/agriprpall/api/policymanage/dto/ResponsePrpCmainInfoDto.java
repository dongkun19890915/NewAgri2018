package com.sinosoft.agriprpall.api.policymanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ResponsePrpCmainInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性保单号码/保单号码
     */
    private String policyNo;
    /**
     * 属性投保人代码/投保人代码
     */
    private String appliCode;
    /**
     * 属性投保人名称/投保人名称
     */
    private String appliName;
    /**
     * 属性起保日期 /起保日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    /**
     * 属性终保日期/终保日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    /**
     * 属性操作员代码 /操作员代码
     */
    private String operatorCode;
    /**操作人*/
    private String operatorName;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getAppliCode() {
        return appliCode;
    }

    public void setAppliCode(String appliCode) {
        this.appliCode = appliCode;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
