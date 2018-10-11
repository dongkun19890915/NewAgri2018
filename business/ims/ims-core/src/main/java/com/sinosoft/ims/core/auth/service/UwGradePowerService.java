package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.dto.UwGradePowerDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UwGradePowerCore接口
 */
public interface UwGradePowerService {

    /**
     *@description 新增
     *@param
     */
    void save(UwGradePowerDto uwGradePowerDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String userCode, String marketType, String policyType, String uwType, Integer verifyLevel, String comCode, String classCode, String riskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UwGradePowerDto uwGradePowerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UwGradePowerDto queryByPK(String userCode, String marketType, String policyType, String uwType, Integer verifyLevel, String comCode, String classCode, String riskCode);
}