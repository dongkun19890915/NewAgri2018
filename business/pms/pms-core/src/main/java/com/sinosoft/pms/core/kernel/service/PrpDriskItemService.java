package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskItemDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品标的表Core接口
 */
public interface PrpDriskItemService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskItemDto prpDriskItemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseCode,String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskItemDto prpDriskItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskItemDto queryByPK(String riskCode,String clauseCode,String itemCode);
}