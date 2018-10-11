package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

public class AutoClauseQueryConditionDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    //特约代码
    private String clauseCode ;
    //归属机构代码
    private String comCode ;
    //险种代码
    private String riskCode ;

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

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
}
