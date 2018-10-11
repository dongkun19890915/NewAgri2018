package com.sinosoft.dms.core.image.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PrpDimageCodeKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PrpDimageCodeKey(String riskCode, String comCode) {
        this.riskCode = riskCode;
        this.comCode = comCode;
    }

    public PrpDimageCodeKey() {
    }

    @Column(name = "riskCode")
    private String riskCode;

    @Column(name = "comCode")
    private String comCode;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
}
