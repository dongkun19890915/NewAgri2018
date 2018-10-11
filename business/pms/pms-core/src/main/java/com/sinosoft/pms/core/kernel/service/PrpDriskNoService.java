package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskNoDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品临时代码表Core接口
 */
public interface PrpDriskNoService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskNoDto prpDriskNoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskNoDto prpDriskNoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskNoDto queryByPK(String id);
}