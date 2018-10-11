package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiPlatConfigCore接口
 */
public interface UtiPlatConfigService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiPlatConfigDto utiPlatConfigDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String systemCode, String paramCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiPlatConfigDto utiPlatConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiPlatConfigDto queryByPK(String systemCode, String paramCode);
}