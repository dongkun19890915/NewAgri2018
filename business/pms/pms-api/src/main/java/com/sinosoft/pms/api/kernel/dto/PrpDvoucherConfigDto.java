package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpDvoucherConfigDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private String comCode;

    private String riskCode;

    private String comCName;

    private String riskName;

    private String bisinessType1;

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
