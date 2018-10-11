package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDrateFactorDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 费率因子表Core接口
 */
public interface PrpDrateFactorService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDrateFactorDto prpDrateFactorDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String factorType,String factorCode,String factorTable,String rateType,java.lang.Integer ratePeriod);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDrateFactorDto prpDrateFactorDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDrateFactorDto queryByPK(String riskCode,String factorType,String factorCode,String factorTable,String rateType,java.lang.Integer ratePeriod);

    List<PrpDrateFactorDto> queryList(PrpDrateFactorDto rateFactorCondition);
}