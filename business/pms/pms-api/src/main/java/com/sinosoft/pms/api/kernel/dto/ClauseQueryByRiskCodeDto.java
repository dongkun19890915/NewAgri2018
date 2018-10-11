package com.sinosoft.pms.api.kernel.dto;

/**
 * @Description:
 * @Author:SHY
 * @Since:2017年09月30日 11:31
 */
public class ClauseQueryByRiskCodeDto {
    private String clauseCode;
    private String codeType;
    private String RiskCode;

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getRiskCode() {
        return RiskCode;
    }

    public void setRiskCode(String riskCode) {
        RiskCode = riskCode;
    }
}
