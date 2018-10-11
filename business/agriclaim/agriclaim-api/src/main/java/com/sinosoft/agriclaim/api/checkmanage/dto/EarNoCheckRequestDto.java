package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

public class EarNoCheckRequestDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性保单号
     */
    private String policyNo;
    /**
     * 属性耳标号
     */
    private String earNo;
    /**
     * 属性险别序号/险别序号
     */
    private String kindCode;
    /**
     * 属性出险日期
     */
    private String damageStartDate;
    /**
     * 属性出险小时
     */
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
