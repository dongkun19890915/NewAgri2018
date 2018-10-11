package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UtiUwConditionDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwConditionCore接口
 */
public interface UtiUwConditionService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiUwConditionDto utiUwConditionDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String classCode, String uwType, String factorCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiUwConditionDto utiUwConditionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiUwConditionDto queryByPK(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String classCode, String uwType, String factorCode);
}