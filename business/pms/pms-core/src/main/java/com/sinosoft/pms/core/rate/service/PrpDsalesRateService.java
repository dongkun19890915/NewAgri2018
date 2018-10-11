package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDsalesRateDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 销售费用率配置表Core接口
 */
public interface PrpDsalesRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDsalesRateDto prpDsalesRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String businessNature,String versionNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDsalesRateDto prpDsalesRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDsalesRateDto queryByPK(String riskCode,String businessNature,String versionNo);
}