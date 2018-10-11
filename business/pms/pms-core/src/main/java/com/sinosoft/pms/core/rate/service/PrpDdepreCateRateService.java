package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 折旧率表Core接口
 */
public interface PrpDdepreCateRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDdepreCateRateDto prpDdepreCateRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseType,String carKindCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDdepreCateRateDto prpDdepreCateRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDdepreCateRateDto queryByPK(String riskCode,String clauseType,String carKindCode);
}