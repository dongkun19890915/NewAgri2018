package com.sinosoft.agriclaim.core.registmanage.service;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 赔案保单关联表Core接口
 */
public interface PrpLRegistRPolicyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRegistRPolicyDto prpLRegistRPolicyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String policyNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRegistRPolicyDto prpLRegistRPolicyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRegistRPolicyDto queryByPK(String registNo,String policyNo);
}