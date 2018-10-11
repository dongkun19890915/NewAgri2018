package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseKindRelationDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 条款/条款责任间关系表Core接口
 */
public interface PrpDclauseKindRelationService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseKindRelationDto prpDclauseKindRelationDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,String relationCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseKindRelationDto prpDclauseKindRelationDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseKindRelationDto queryByPK(String clauseCode,String relationCode,java.lang.Integer serialNo);
}