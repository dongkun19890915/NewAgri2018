package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwUserConditionDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwUserConditionCore接口
 */
public interface UtiUwUserConditionService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUwUserConditionDto utiUwUserConditionDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String uwType, String factorCode, Integer factorValueNo, String userCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUwUserConditionDto utiUwUserConditionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUwUserConditionDto queryByPK(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String uwType, String factorCode, Integer factorValueNo, String userCode);
}