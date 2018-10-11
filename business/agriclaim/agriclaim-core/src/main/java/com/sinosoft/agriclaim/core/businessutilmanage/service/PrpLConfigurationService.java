package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * @description 条款公式配置表 Core接口
 */
public interface PrpLConfigurationService {

    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLConfigurationDto queryByPK(String id);

    /**
     * @description 按条件查询条款公式配置
     * @param prpLConfigurationDto 条款公式配置入参封装对象
     * @return List<PrpLConfigurationDto> 条款公式配置信息列表
     * @throws Exception
     * @author 李磊
     * @date 2017-12-26 8:42
     */
    public List<PrpLConfigurationDto> queryPrpLConfigurationDtoListByCondition( PrpLConfigurationDto  prpLConfigurationDto) throws Exception;
}