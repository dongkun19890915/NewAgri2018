package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 产品条款定义表Core接口
 */
public interface PrpDriskClauseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskClauseDto prpDriskClauseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskClauseDto prpDriskClauseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskClauseDto queryByPK(String riskCode,String clauseCode);
}