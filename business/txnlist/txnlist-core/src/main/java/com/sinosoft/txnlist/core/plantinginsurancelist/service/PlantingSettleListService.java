package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.ValidityAndPKDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description plantingsettlelistCore接口
 */
public interface PlantingSettleListService {

    /**
     *@description 新增
     *@param
     */
    void save(PlantingSettleListDto plantingSettleListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String settleListCode,String fCode,String kindCode,String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PlantingSettleListDto plantingSettleListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PlantingSettleListDto queryByPK(String settleListCode,String fCode,String kindCode,String classCode);
    /**
     *@description 查询实体
     *@param
     *@author 马俊玲
     */
    List<PlantingSettleListDto> findBySettlelistCodeAndValidity(ValidityAndPKDto validityAndPKDto);
}