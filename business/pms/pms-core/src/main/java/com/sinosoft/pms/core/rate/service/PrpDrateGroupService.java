package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDrateGroupDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 费率分组表Core接口
 */
public interface PrpDrateGroupService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDrateGroupDto prpDrateGroupDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode,String rateType,String riskCode,String kindCode,String rateGroupCode,java.lang.Integer ratePeriod);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDrateGroupDto prpDrateGroupDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDrateGroupDto queryByPK(String comCode,String rateType,String riskCode,String kindCode,String rateGroupCode,java.lang.Integer ratePeriod);

    List<PrpDrateGroupDto> queryList(PrpDrateGroupDto prpDrateGroupDto);
}