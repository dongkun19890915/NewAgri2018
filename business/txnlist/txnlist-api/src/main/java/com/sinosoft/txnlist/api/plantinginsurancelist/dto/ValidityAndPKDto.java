package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

public class ValidityAndPKDto {
    private String settleListCode;
    private String validity;

    public ValidityAndPKDto() {
    }

    public ValidityAndPKDto(String settleListCode, String validity){
        this.settleListCode=settleListCode;
        this.validity=validity;
    }
    public String getSettleListCode() {
        return settleListCode;
    }
    public void setSettleListCode(String settleListCode) {
        this.settleListCode = settleListCode;
    }
    public String getValidity() {
        return validity;
    }
    public void setValidity(String validity) {
        this.validity = validity;
    }
    

}
