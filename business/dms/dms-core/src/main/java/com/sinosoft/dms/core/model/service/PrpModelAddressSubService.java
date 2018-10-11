package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelAddressSubDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板保险地址表Core接口
 */
public interface PrpModelAddressSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelAddressSubDto prpModelAddressSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode,Integer addressNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelAddressSubDto prpModelAddressSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelAddressSubDto queryByPK(String modelCode,Integer addressNo);
}