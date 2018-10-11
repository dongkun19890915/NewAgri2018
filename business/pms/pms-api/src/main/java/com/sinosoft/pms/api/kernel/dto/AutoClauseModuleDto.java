package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrx
 * @time  2017-09-13
 * 车险自动生成特约规则操作对象
 */
public class AutoClauseModuleDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ClauseModuleDto> clauseModuleDtos;

    public List<ClauseModuleDto> getClauseModuleDtos() {
        return clauseModuleDtos;
    }

    public void setClauseModuleDtos(List<ClauseModuleDto> clauseModuleDtos) {
        this.clauseModuleDtos = clauseModuleDtos;
    }
}
