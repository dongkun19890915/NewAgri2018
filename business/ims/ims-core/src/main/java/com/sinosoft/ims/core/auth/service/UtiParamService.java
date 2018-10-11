package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiParamDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiParamCore接口
 */
public interface UtiParamService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiParamDto utiParamDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String paramCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiParamDto utiParamDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiParamDto queryByPK(String paramCode);
}