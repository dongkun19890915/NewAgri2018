package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseRuleLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-13 02:29:04.419 
 * @description 自动生成特约校验规则表日志表Core接口
 */
public interface PrpDautoClauseRuleLogService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String uUID);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDautoClauseRuleLogDto queryByPK(String uUID);
}