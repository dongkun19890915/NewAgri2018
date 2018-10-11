package com.sinosoft.dms.core.image.entity;

import javax.persistence.*;

@Entity
@Table(name = "PrpDimageCode")
@IdClass(PrpDimageCodeKey.class)
public class PrpDimageCode {

    @Id
    @Column(name = "riskCode")
    private String riskCode;

    @Id
    @Column(name = "comCode")
    private String comCode;

    @Column(name = "prpallCode")
    private String prpallCode;

    @Column(name = "prpallRole")
    private String prpallRole;

    @Column(name = "prpallName")
    private String prpallName;

    @Column(name = "claimCode")
    private String claimCode;

    @Column(name = "claimRole")
    private String claimRole;

    @Column(name = "claimName")
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
