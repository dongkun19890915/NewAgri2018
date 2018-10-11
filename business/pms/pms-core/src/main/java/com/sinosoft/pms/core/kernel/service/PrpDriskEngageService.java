package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskEngageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品特别约定表Core接口
 */
public interface PrpDriskEngageService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskEngageDto prpDriskEngageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseCode,String engageCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskEngageDto prpDriskEngageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskEngageDto queryByPK(String riskCode,String clauseCode,String engageCode);
}