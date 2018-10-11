package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimFeeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 估损金额表Core接口
 */
public interface PrpLClaimFeeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimFeeDto prpLClaimFeeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimFeeDto prpLClaimFeeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimFeeDto queryByPK(String claimNo,String currency);
}