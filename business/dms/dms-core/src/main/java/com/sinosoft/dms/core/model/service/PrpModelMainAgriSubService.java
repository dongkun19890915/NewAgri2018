package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelMainAgriSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板农业险保单信息Core接口
 */
public interface PrpModelMainAgriSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelMainAgriSubDto prpModelMainAgriSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelMainAgriSubDto prpModelMainAgriSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelMainAgriSubDto queryByPK(String modelCode);
}