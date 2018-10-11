package com.sinosoft.agriprpall.api.common.dto;

import java.io.Serializable;

public class SelectTagCodeDto implements Serializable {
    /**英文代码 */
    private String codeCode;
    /**中文名称 */
    private String codeName;
    /**内容*/
    private  String ClausesContext;

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

    public String getClausesContext() {
        return ClausesContext;
    }

    public void setClausesContext(String clausesContext) {
        ClausesContext = clausesContext;
    }
}
