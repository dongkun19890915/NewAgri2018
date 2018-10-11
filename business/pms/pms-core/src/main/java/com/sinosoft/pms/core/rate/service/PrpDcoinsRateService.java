package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDcoinsRateDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 共同体成员比例配置表Core接口
 */
public interface PrpDcoinsRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcoinsRateDto prpDcoinsRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String comCode,String versionNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcoinsRateDto prpDcoinsRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcoinsRateDto queryByPK(String riskCode,String comCode,String versionNo);
}