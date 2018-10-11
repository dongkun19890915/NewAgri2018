package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class AutoClauseModuleResponseDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos;

    public List<PrpDautoClauseRuleDto> getPrpDautoClauseRuleDtos() {
        return prpDautoClauseRuleDtos;
    }

    public void setPrpDautoClauseRuleDtos(List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos) {
        this.prpDautoClauseRuleDtos = prpDautoClauseRuleDtos;
    }
}
