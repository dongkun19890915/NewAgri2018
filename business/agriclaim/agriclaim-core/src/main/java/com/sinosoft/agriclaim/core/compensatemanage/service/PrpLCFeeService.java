package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCFeeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算金额表Core接口
 */
public interface PrpLCFeeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCFeeDto prpLCFeeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo,String policyNo,String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCFeeDto prpLCFeeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCFeeDto queryByPK(String compensateNo,String policyNo,String currency);
}