package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLFormulaConfigDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * @description 条款公式配置项配置表Core接口
 */
public interface PrpLFormulaConfigService {

    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLFormulaConfigDto queryByPK(String id);

    /**
     * @description 按条件查询条款公式配置
     * @param prpLFormulaConfigDto 条款公式配置入参封装对象
     * @return List<prpLFormulaConfigDto> 条款公式配置信息列表
     * @throws Exception
     * @author 李磊
     * @date 2017-12-26 8:42
     */
    public List<PrpLFormulaConfigDto> queryPrpLFormulaConfigDtoListByCondition(PrpLFormulaConfigDto  prpLFormulaConfigDto) throws Exception ;

    }