package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class ResponsePrpDclauseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /*条款代码*/
    private String clauseCode;
    /*条款名称*/
    private String clauseName;

    public ResponsePrpDclauseDto(String clauseCode, String clauseName) {
        this.clauseCode = clauseCode;
        this.clauseName = clauseName;
    }

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getClauseName() {
        return clauseName;
    }

    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }
}
