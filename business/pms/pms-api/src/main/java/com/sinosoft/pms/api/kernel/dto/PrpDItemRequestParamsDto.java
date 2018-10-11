package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpDItemRequestParamsDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 属性险种代码/险种代码 */
    private String riskCode ;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

}
