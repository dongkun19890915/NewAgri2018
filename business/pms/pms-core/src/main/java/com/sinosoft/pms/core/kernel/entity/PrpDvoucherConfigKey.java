package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PrpDvoucherConfigKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;



    @Column(name = "comCode")
    private String comCode;

    @Column(name = "riskCode")
    private String riskCode;

    public PrpDvoucherConfigKey() {
    }

    public PrpDvoucherConfigKey(String comCode, String riskCode) {

        this.comCode = comCode;
        this.riskCode = riskCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
}
