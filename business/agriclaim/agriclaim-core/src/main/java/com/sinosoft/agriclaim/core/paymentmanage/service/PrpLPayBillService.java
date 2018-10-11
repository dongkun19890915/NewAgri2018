package com.sinosoft.agriclaim.core.paymentmanage.service;


import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayBillDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * @description 支付信息对应清单主键表Core接口
 */
public interface PrpLPayBillService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPayBillDto prpLPayBillDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String paymentNo, String registNo, String compensateNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPayBillDto prpLPayBillDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPayBillDto queryByPK(String paymentNo, String registNo, String compensateNo, Integer serialNo);
}