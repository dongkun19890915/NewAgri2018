package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiSysParamDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiSysParamCore接口
 */
public interface UtiSysParamService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiSysParamDto utiSysParamDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String systemCode, String paramCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiSysParamDto utiSysParamDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiSysParamDto queryByPK(String systemCode, String paramCode);
}