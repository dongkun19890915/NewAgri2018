package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelMainSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 保单基本信息表Core接口
 */
public interface PrpModelMainSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelMainSubDto prpModelMainSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelMainSubDto prpModelMainSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelMainSubDto queryByPK(String modelCode);
}