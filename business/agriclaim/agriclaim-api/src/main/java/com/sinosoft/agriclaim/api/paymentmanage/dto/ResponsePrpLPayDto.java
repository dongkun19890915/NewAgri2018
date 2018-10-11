package com.sinosoft.agriclaim.api.paymentmanage.dto;

import java.io.Serializable;

public class ResponsePrpLPayDto implements Serializable{
    private Integer checkFlag;

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }
}
