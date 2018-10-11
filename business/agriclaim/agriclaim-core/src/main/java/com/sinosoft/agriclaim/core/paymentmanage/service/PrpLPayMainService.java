package com.sinosoft.agriclaim.core.paymentmanage.service;


import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayMainDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-14 09:04:11.816 
 * @description 支付信息主表Core接口
 */
public interface PrpLPayMainService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPayMainDto prpLPayMainDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String paymentNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPayMainDto prpLPayMainDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPayMainDto queryByPK(String paymentNo);
}