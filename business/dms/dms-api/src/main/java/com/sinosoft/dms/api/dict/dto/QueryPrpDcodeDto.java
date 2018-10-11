package com.sinosoft.dms.api.dict.dto;

public class QueryPrpDcodeDto {
    /**英文代码 */
    private String codeCode;
    /**中文名称 */
    private String codeName;

    public String getCodeCode() {
        return codeCode;
    }

    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
