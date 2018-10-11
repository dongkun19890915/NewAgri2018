package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseKindDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品条款责任表Core接口
 */
public interface PrpDriskClauseKindService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskClauseKindDto prpDriskClauseKindDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,java.lang.Integer riskKcSerialno,String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskClauseKindDto prpDriskClauseKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskClauseKindDto queryByPK(String riskCode,java.lang.Integer riskKcSerialno,String clauseCode);
}