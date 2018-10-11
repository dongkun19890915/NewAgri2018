package com.sinosoft.dms.core.customer.service;


import com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto;
import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTrace;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * @description 客户风险等级轨迹表Core接口
 */
public interface PrpDcustomLevelTraceService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String customerCode,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcustomLevelTraceDto queryByPK(String customerCode,java.lang.Integer lineNo);
    /**
     * @description 按照insuredCode查询最后一条客户风险等级
     * @autor 王心洋
     * @param insuredCode
     */
    String findRiskLevelByCode(String insuredCode);
    /**
     *  根据客户代码查询最新的客户风险等级信息
     * @author: 田健
     * @date: 2018/4/4 16:57
     * @param customerCode 客户代码
     * @return 客户风险等级信息
     */
    PrpDcustomLevelTraceDto findRiskLevelByCustomerCode(String customerCode);


}