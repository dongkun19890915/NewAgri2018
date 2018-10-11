package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiConfigDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description UtiConfigCore接口
 */
public interface UtiConfigService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiConfigDto utiConfigDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String configCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiConfigDto utiConfigDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiConfigDto queryByPK(String configCode);
}