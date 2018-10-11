package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiGroupRuleDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupRuleCore接口
 */
public interface UtiGroupRuleService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiGroupRuleDto utiGroupRuleDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String groupCode, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiGroupRuleDto utiGroupRuleDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiGroupRuleDto queryByPK(String groupCode, Integer serialNo);
}