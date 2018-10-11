package com.sinosoft.agriclaim.core.prepaymanage.service;


import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * @description 预支付理赔表Core接口
 */
public interface PrpLPrepayService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPrepayDto prpLPrepayDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String preCompensateNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPrepayDto prpLPrepayDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPrepayDto queryByPK(String preCompensateNo);
}