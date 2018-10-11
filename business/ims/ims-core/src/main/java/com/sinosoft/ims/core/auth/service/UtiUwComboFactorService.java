package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwComboFactorDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwComboFactorCore接口
 */
public interface UtiUwComboFactorService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUwComboFactorDto utiUwComboFactorDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String uwType, String classCode, String factorCode, String codeType);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUwComboFactorDto utiUwComboFactorDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUwComboFactorDto queryByPK(String uwType, String classCode, String factorCode, String codeType);
}