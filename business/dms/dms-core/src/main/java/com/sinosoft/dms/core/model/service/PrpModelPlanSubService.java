package com.sinosoft.dms.core.model.service;

import com.sinosoft.dms.api.model.dto.PrpModelPlanSubDto;

public interface PrpModelPlanSubService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpModelPlanSubDto prpModelPlanSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelPlanSubDto prpModelPlanSubDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpModelPlanSubDto queryByPK(String modelCode,Integer serialNo);
}
