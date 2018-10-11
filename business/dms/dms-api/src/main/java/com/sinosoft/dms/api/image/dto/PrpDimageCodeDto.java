package com.sinosoft.dms.api.image.dto;

import java.io.Serializable;

public class PrpDimageCodeDto implements Serializable {

    private String riskCode;

    private String comCode;

    private String prpallCode;

    private String prpallRole;

    private String prpallName;

    private String claimCode;

    private String claimRole;

    private String claimName;

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

    public String getPrpallCode() {
        return prpallCode;
    }

    public void setPrpallCode(String prpallCode) {
        this.prpallCode = prpallCode;
    }

    public String getPrpallRole() {
        return prpallRole;
    }

    public void setPrpallRole(String prpallRole) {
        this.prpallRole = prpallRole;
    }

    public String getPrpallName() {
        return prpallName;
    }

    public void setPrpallName(String prpallName) {
        this.prpallName = prpallName;
    }

    public String getClaimCode() {
        return claimCode;
    }

    public void setClaimCode(String claimCode) {
        this.claimCode = claimCode;
    }

    public String getClaimRole() {
        return claimRole;
    }

    public void setClaimRole(String claimRole) {
        this.claimRole = claimRole;
    }

    public String getClaimName() {
        return claimName;
    }

    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }
}
