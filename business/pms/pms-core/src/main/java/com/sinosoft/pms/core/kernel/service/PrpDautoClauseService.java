package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:27:57.599 
 * @description 自动生成特约主表Core接口
 */
public interface PrpDautoClauseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseDto prpDautoClauseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String riskCode, String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseDto prpDautoClauseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseDto queryByPK(String comCode, String riskCode, String clauseCode);
}