package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDclauseShortRateDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款短期费率表Core接口
 */
public interface PrpDclauseShortRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseShortRateDto prpDclauseShortRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String shortRateId,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseShortRateDto prpDclauseShortRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseShortRateDto queryByPK(String clauseCode,String shortRateId,java.lang.Integer serialNo);
}