package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;
/**
 * 返回dto
 * @Author: 祁小龙
 * @Date: 2018/3/13 14:51
 */
public class ReturnXmlDto implements Serializable {

    private String code;

    private String message;

    private String registNo;

    private String policyNo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
