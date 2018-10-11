package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDriskShortRateDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品短期费率表Core接口
 */
public interface PrpDriskShortRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskShortRateDto prpDriskShortRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String shortRateId,String clauseCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskShortRateDto prpDriskShortRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskShortRateDto queryByPK(String riskCode,String shortRateId,String clauseCode,java.lang.Integer serialNo);
}