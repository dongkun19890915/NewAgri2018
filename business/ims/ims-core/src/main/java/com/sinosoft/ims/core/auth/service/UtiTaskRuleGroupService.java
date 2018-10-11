package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiTaskRuleGroupDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiTaskRuleGroupCore接口
 */
public interface UtiTaskRuleGroupService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiTaskRuleGroupDto utiTaskRuleGroupDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String ruleGroupCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiTaskRuleGroupDto utiTaskRuleGroupDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiTaskRuleGroupDto queryByPK(String ruleGroupCode);
}