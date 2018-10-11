package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PrpDrenewalTraceKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PrpDrenewalTraceKey() {
    }

    public PrpDrenewalTraceKey(String policyNo) {
        this.policyNo = policyNo;
    }

    @Column(name = "policyNo")
    private String policyNo;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
