package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelItemKindDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-16 01:04:20.471 
 * @description 标的子险信息Core接口
 */
public interface PrpModelItemKindService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelItemKindDto prpModelItemKindDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode, Integer itemKindNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelItemKindDto prpModelItemKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelItemKindDto queryByPK(String modelCode, Integer itemKindNo);
}