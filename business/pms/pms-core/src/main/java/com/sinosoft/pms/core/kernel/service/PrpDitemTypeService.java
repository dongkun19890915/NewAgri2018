package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDitemTypeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 标的分类表Core接口
 */
public interface PrpDitemTypeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDitemTypeDto prpDitemTypeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String itemCode,String itemTypeBase,String itemTypeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDitemTypeDto prpDitemTypeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDitemTypeDto queryByPK(String itemCode,String itemTypeBase,String itemTypeCode);
}