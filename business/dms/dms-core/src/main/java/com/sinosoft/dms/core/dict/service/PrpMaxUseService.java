package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpMaxUseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxUseCore接口
 */
public interface PrpMaxUseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpMaxUseDto prpMaxUseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String groupNo, String tableName, String maxNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpMaxUseDto prpMaxUseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpMaxUseDto queryByPK(String groupNo, String tableName, String maxNo);
}