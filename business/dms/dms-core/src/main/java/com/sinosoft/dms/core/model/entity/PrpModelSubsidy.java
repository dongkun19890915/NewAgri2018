package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "PrpModelSubsidy")
@IdClass(PrpModelSubsidyKey.class)
public class PrpModelSubsidy extends BaseEntityImpl{


    @Id
    @Column(name = "modelCode")
    private String modelCode;

    @Id
    @Column(name = "subsidyCode")
    private String subsidyCode;

    @Id
    @Column(name = "subsidyType")
    private String subsidyType;



    @Column(name = "contractNo")
    private String contractNo;

    @Column(name = "riskCode")
    private String riskCode;

    @Column(name = "classCode")
    private String classCode;

    @Column(name = "comCode")
    private String comCode;

    @Column(name = "currency")
    private String currency;

    @Column(name = "benchmarkPremium")
    private Double benchmarkPremium;

    @Column(name = "subsidyName")
    private String subsidyName;

    @Column(name = "subsidyTypeName")
    private String subsidyTypeName;

    @Column(name = "subsidyDepartment")
    private String subsidyDepartment;

    @Column(name = "subsidyRate")
    private Double subsidyRate;

    @Column(name = "subsidyPremium")
    private Double subsidyPremium;

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
