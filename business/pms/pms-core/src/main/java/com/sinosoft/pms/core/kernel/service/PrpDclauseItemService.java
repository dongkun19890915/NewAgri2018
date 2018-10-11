package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseItemDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款标的表Core接口
 */
public interface PrpDclauseItemService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseItemDto prpDclauseItemDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseItemDto prpDclauseItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseItemDto queryByPK(String clauseCode,String itemCode);
}