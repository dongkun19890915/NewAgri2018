package com.sinosoft.dms.api.model.dto;

import com.sinosoft.framework.dto.BaseRequest;

public class PrpModelSubsidyDto extends BaseRequest {

    private String modelCode;
    private String contractNo;
    private String riskCode;
    private String classCode;
    private String comCode;
    private String currency;
    private Double benchmarkPremium;
    private String subsidyCode;
    private String subsidyName;
    private String subsidyType;
    private String subsidyTypeName;
    private String subsidyDepartment;
    private Double subsidyRate;
    private Double subsidyPremium;

    public PrpModelSubsidyDto() {
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBenchmarkPremium() {
        return benchmarkPremium;
    }

    public void setBenchmarkPremium(Double benchmarkPremium) {
        this.benchmarkPremium = benchmarkPremium;
    }

    public String getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String subsidyCode) {
        this.subsidyCode = subsidyCode;
    }

    public String getSubsidyName() {
        return subsidyName;
    }

    public void setSubsidyName(String subsidyName) {
        this.subsidyName = subsidyName;
    }

    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
    }

    public String getSubsidyTypeName() {
        return subsidyTypeName;
    }

    public void setSubsidyTypeName(String subsidyTypeName) {
        this.subsidyTypeName = subsidyTypeName;
    }

    public String getSubsidyDepartment() {
        return subsidyDepartment;
    }

    public void setSubsidyDepartment(String subsidyDepartment) {
        this.subsidyDepartment = subsidyDepartment;
    }

    public Double getSubsidyRate() {
        return subsidyRate;
    }

    public void setSubsidyRate(Double subsidyRate) {
        this.subsidyRate = subsidyRate;
    }

    public Double getSubsidyPremium() {
        return subsidyPremium;
    }

    public void setSubsidyPremium(Double subsidyPremium) {
        this.subsidyPremium = subsidyPremium;
    }
}
