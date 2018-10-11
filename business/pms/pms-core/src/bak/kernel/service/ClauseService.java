package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDClauseDto;

public interface ClauseService{
    /**
     * @description 根据条款代码获取条款相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    public PrpDClauseDto getClause(ClauseQueryConditionDto conditionDto);
}
