package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDitemClassDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 标的险种分类子表Core接口
 */
public interface PrpDitemClassService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDitemClassDto prpDitemClassDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String itemCode   );
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDitemClassDto prpDitemClassDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDitemClassDto queryByPK(String itemCode   );
}