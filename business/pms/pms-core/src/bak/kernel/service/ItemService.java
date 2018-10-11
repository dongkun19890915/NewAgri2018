package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.ItemTypeQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDItemTypeDto;

public interface ItemService{
    
    /**
     * @description 根据标的代码，标的分类标准，标的分类代码 获取标的相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    public PrpDItemTypeDto getItemType(ItemTypeQueryConditionDto conditionDto);
}
