package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListTempDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description plantingsettlelisttempCore接口
 */
public interface PlantingSettleListTempService {

    /**
     *@description 新增
     *@param
     */
    void save(PlantingSettleListTempDto plantingSettleListTempDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle);
    /**
     *@description 修改
     *@param
     */
    void modify(PlantingSettleListTempDto plantingSettleListTempDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PlantingSettleListTempDto queryByPK(String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle);
}