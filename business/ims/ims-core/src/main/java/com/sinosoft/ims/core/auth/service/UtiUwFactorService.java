package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwFactorDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwFactorCore接口
 */
public interface UtiUwFactorService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUwFactorDto utiUwFactorDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String uwType, String factorCode, String classCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUwFactorDto utiUwFactorDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUwFactorDto queryByPK(String uwType, String factorCode, String classCode);
}