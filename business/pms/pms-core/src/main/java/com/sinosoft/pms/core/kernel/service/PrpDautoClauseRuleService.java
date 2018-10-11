package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseRuleDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:37.662 
 * @description 自动生成特约校验规则表Core接口
 */
public interface PrpDautoClauseRuleService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseRuleDto prpDautoClauseRuleDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, String riskCode, String clauseCode, String groupNo, String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseRuleDto prpDautoClauseRuleDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseRuleDto queryByPK(String comCode, String riskCode, String clauseCode, String groupNo, String serialNo);

    /**
     *@description 按条件查询实体
     *@param
     */
    List<PrpDautoClauseRuleDto> queryByCondition(String clauseCode, String comCode, String riskCode) throws Exception;
}