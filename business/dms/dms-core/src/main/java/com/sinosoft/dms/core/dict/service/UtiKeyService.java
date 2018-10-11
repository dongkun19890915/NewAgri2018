package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.UtiKeyDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description UtiKeyCore接口
 */
public interface UtiKeyService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiKeyDto utiKeyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String tablEName);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiKeyDto utiKeyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiKeyDto queryByPK(String tablEName);
}