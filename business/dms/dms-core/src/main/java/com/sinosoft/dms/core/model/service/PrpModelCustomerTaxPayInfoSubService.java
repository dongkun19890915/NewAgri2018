package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpModelCustomerTaxPayInfoSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板客户纳税人信息表Core接口
 */
public interface PrpModelCustomerTaxPayInfoSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpModelCustomerTaxPayInfoSubDto queryByPK(String modelCode);
}