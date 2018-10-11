package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimPolicyDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案保单清单表Core接口
 */
public interface PrpLClaimPolicyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimPolicyDto prpLClaimPolicyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimPolicyDto prpLClaimPolicyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimPolicyDto queryByPK(String claimNo);
}