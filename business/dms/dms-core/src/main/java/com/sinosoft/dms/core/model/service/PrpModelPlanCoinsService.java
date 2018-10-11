package com.sinosoft.dms.core.model.service;

import com.sinosoft.dms.api.model.dto.PrpModelPlanCoinsDto;

public interface PrpModelPlanCoinsService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelPlanCoinsDto prpModelPlanCoinsDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,Integer serialNo,String coinsCode,String payReason);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelPlanCoinsDto prpModelPlanCoinsDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpModelPlanCoinsDto queryByPK(String modelCode,Integer serialNo,String coinsCode,String payReason);

}
