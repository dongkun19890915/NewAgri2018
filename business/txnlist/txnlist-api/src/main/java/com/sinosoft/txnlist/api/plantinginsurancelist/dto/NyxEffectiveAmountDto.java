package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class NyxEffectiveAmountDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /*业务号*/
    private String businessNo;

    /*保单号*/
    private String policyNo;

    /*险种代码*/
    private String riskCode;

    /*险别代码*/
    private String kindCode;

    /*标的代码*/
    private String itemCode;

    /*农户代码*/
    private String fCode;

    /*其他（茬次）*/
    private Integer flag=0;

    /*有效起期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    /*有效止期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    /*有效保额*/
    private Double amount;

    /*序号*/
    private Integer serialNo=0;

    /*变化量*/
    private Double chgAmount=0.0;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Double getChgAmount() {
        return chgAmount;
    }

    public void setChgAmount(Double chgAmount) {
        this.chgAmount = chgAmount;
    }
}
