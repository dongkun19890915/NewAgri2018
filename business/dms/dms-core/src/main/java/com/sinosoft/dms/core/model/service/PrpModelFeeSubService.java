package com.sinosoft.dms.core.model.service;

import com.sinosoft.dms.api.model.dto.PrpModelFeeSubDto;

public interface PrpModelFeeSubService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpModelFeeSubDto prpModelFeeSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelFeeSubDto prpModelFeeSubDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpModelFeeSubDto  queryByPK(String modelCode,String currency);
}
