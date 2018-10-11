package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskLimitDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品限额/免赔表Core接口
 */
public interface PrpDriskLimitService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskLimitDto prpDriskLimitDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseCode,java.lang.Integer serialNo,String limitCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskLimitDto prpDriskLimitDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskLimitDto queryByPK(String riskCode,String clauseCode,java.lang.Integer serialNo,String limitCode);
}