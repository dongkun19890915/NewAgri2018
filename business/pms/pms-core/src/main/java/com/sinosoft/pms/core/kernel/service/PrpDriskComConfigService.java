package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDriskComConfigDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDriskComConfigCore接口
 */
public interface PrpDriskComConfigService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskComConfigDto prpDriskComConfigDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.util.Date id);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskComConfigDto prpDriskComConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskComConfigDto queryByPK(java.util.Date id);
}