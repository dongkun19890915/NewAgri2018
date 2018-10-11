package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "PrpDvoucherConfig")
@IdClass(PrpDvoucherConfigKey.class)
public class PrpDvoucherConfig extends BaseEntityImpl{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "comCode")
    private String comCode;

    @Id
    @Column(name = "riskCode")
    private String riskCode;

    @Column(name = "comCName")
    private String comCName;

    @Column(name = "riskName")
    private String riskName;

    @Column(name = "bisinessType1")
    private String bisinessType1;

    @Column(name = "flag")
    private String flag;

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

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getBisinessType1() {
        return bisinessType1;
    }

    public void setBisinessType1(String bisinessType1) {
        this.bisinessType1 = bisinessType1;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
