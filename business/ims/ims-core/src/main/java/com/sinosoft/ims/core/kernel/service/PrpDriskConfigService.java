package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDriskConfigCore接口
 */
public interface PrpDriskConfigService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskConfigDto prpDriskConfigDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String riskCode, String configCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskConfigDto prpDriskConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskConfigDto queryByPK(String comCode, String riskCode, String configCode);
    /**
     *@description 按条件查询
     *@param
     */
    List<PrpDriskConfigDto> query(PrpDriskConfigDto prpDriskConfigDto) throws Exception ;
}