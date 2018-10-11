package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class CopyPrintBackAddDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 名称 */
    private String kindName;
    /** 保额/限额  */
    private double dbAmount;
    /** 每次赔偿限额 */
    private String dbDeductible;

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public double getDbAmount() {
        return dbAmount;
    }

    public void setDbAmount(double dbAmount) {
        this.dbAmount = dbAmount;
    }

    public String getDbDeductible() {
        return dbDeductible;
    }

    public void setDbDeductible(String dbDeductible) {
        this.dbDeductible = dbDeductible;
    }
}
