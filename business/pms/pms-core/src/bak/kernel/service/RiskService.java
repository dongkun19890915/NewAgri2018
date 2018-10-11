package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDRiskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;

import java.util.List;

public interface RiskService {
    /**
     * @description 根据险种代码获取险种相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    public PrpDRiskDto getRisk(RiskQueryConditionDto conditionDto);
    
    
    /**
    * @description 获取所有险种相关信息
    * @return List<PrpDRiskDto> 
    * @author chengzhuo
    * @date 2016年10月24日上午9:34:15
    */
    public List<PrpDRiskDto> getRiskList(RiskQueryConditionDto conditionDto);
    
}
