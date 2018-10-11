package com.sinosoft.agriclaim.core.paymentmanage.service;


import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayExtDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-11 08:55:21.509 
 * @description 支付处理意见表Core接口
 */
public interface PrpLPayExtService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPayExtDto prpLPayExtDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String paymentNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPayExtDto prpLPayExtDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPayExtDto queryByPK(String paymentNo, Integer serialNo);
}