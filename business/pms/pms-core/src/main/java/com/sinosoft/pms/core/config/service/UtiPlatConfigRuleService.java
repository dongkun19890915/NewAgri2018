package com.sinosoft.pms.core.config.service;


import com.sinosoft.pms.api.config.dto.UtiPlatConfigRuleDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 平台配置规则表Core接口
 */
public interface UtiPlatConfigRuleService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiPlatConfigRuleDto utiPlatConfigRuleDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String systemCode,String paramCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiPlatConfigRuleDto utiPlatConfigRuleDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiPlatConfigRuleDto queryByPK(String systemCode,String paramCode,java.lang.Integer serialNo);
    
    /**
     * 根据入参查询列表
     * @param paramCode
     * @param systemCode
     * @return
     * @throws Exception
     */
    List<UtiPlatConfigRuleDto> query(String paramCode,String systemCode) throws Exception;
}