package com.sinosoft.dms.core.customer.service;


import com.sinosoft.dms.api.customer.dto.PrpDcustomerRiskLevelSubDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 记录客户风险等级详细表Core接口
 */
public interface PrpDcustomerRiskLevelSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String customerRiskLevelId);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcustomerRiskLevelSubDto queryByPK(String customerRiskLevelId);
    /**
     * （查询被保险人和投保人风险等级）
     * @author: 王志文
     * @date: 2018/3/31 17:55
     * @param policyNo 保单号
     * @return
     * @throws Exception
     */
    List<PrpDcustomerRiskLevelSubDto> queryRiskLevel(String policyNo)throws Exception;
}