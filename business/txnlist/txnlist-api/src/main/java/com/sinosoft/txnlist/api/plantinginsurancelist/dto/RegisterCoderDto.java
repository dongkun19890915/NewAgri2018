package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

public class RegisterCoderDto extends BaseRequest implements Serializable {

    private String registeCode;
    private String validity;

    public RegisterCoderDto() {
    }

    public RegisterCoderDto(String registeCode){
        this.registeCode=registeCode;
    }
    public RegisterCoderDto(String registeCode,String validity){
        this.registeCode=registeCode;
        this.validity=validity;
    }
    public String getRegisteCode() {
        return registeCode;
    }

    public void setRegisteCode(String registeCode) {
        this.registeCode = registeCode;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    
}
