package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class AutoClauseDeleteConditionDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AutoClauseQueryConditionDto> autoClauseQueryConditionDtos;
    //操作员
    private String operatorCode;

    public List<AutoClauseQueryConditionDto> getAutoClauseQueryConditionDtos() {
        return autoClauseQueryConditionDtos;
    }

    public void setAutoClauseQueryConditionDtos(List<AutoClauseQueryConditionDto> autoClauseQueryConditionDtos) {
        this.autoClauseQueryConditionDtos = autoClauseQueryConditionDtos;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }
}
