package com.sinosoft.agriclaim.core.paymentmanage.service;


import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLClaimBillManagerDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-11 08:55:21.509 
 * @description 理赔清单数据管理表Core接口
 */
public interface PrpLClaimBillManagerService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimBillManagerDto prpLClaimBillManagerDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo, String compensateNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimBillManagerDto prpLClaimBillManagerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimBillManagerDto queryByPK(String registNo, String compensateNo, Integer serialNo);
}