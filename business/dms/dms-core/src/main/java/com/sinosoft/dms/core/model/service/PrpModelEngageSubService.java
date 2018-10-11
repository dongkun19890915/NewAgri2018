package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelEngageSubDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板特别约定表Core接口
 */
public interface PrpModelEngageSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelEngageSubDto prpModelEngageSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,Integer serialNo,Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelEngageSubDto prpModelEngageSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelEngageSubDto queryByPK(String modelCode,Integer serialNo,Integer lineNo);
}