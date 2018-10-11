package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

public class EarNoCheckDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String policyNo;
    private String earNo;
    private String kindCode;
    private String damageStartDate;
    private String damageStartHour;
    public String getPolicyNo() {
        return policyNo;
    }
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    public String getEarNo() {
        return earNo;
    }
    public void setEarNo(String earNo) {
        this.earNo = earNo;
    }
    public String getKindCode() {
        return kindCode;
    }
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }
    public String getDamageStartDate() {
        return damageStartDate;
    }
    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }
    public String getDamageStartHour() {
        return damageStartHour;
    }
    public void setDamageStartHour(String damageStartHour) {
        this.damageStartHour = damageStartHour;
    }
    

}
