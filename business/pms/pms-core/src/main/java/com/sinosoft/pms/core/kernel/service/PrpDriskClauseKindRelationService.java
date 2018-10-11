package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseKindRelationDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品条款/责任关系表Core接口
 */
public interface PrpDriskClauseKindRelationService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskClauseKindRelationDto prpDriskClauseKindRelationDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseCode,String relationCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskClauseKindRelationDto prpDriskClauseKindRelationDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskClauseKindRelationDto queryByPK(String riskCode,String clauseCode,String relationCode,java.lang.Integer serialNo);
}