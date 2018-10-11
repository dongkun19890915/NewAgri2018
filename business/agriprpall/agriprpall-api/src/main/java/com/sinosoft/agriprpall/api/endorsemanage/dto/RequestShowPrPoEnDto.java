package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.util.Date;

public class RequestShowPrPoEnDto extends BaseRequest{
    private static final long serialVersionUID = 1L;
    //业务类型
    private String bizType;
    //保单号
    private String bizNo;
    //出险日期
    private String damageDate;
    //分户号
    private String[] familyNos;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }

    public String[] getFamilyNos() {
        return familyNos;
    }

    public void setFamilyNos(String[] familyNos) {
        this.familyNos = familyNos;
    }
}
