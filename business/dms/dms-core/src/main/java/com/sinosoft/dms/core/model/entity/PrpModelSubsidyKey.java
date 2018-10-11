package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PrpModelSubsidyKey extends BasePKImpl {

    @Column(name = "modelCode")
    private String modelCode;

    @Column(name = "subsidyCode")
    private String subsidyCode;

    @Column(name = "subsidyType")
    private String subsidyType;

    public PrpModelSubsidyKey() {
    }

    public PrpModelSubsidyKey(String modelCode, String subsidyCode, String subsidyType) {
        this.modelCode = modelCode;
        this.subsidyCode = subsidyCode;
        this.subsidyType = subsidyType;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String subsidyCode) {
        this.subsidyCode = subsidyCode;
    }

    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
    }
}
