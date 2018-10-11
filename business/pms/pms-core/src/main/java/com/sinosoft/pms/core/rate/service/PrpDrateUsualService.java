package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDrateUsualDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 费率代码表Core接口
 */
public interface PrpDrateUsualService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDrateUsualDto prpDrateUsualDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String kindCode,java.lang.Integer ratePeriod,String rateCode,String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDrateUsualDto prpDrateUsualDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDrateUsualDto queryByPK(String riskCode,String kindCode,java.lang.Integer ratePeriod,String rateCode,String currency);

    List<PrpDrateUsualDto> queryList(PrpDrateUsualDto prpDrateUsualDto);
}