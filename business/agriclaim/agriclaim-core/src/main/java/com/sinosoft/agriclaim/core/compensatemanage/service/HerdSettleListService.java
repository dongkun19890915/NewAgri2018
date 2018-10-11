package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.HerdSettleListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 养殖险理赔明细表Core接口
 */
public interface HerdSettleListService {

    /**
     *@description 新增
     *@param
     */
    void save(HerdSettleListDto herdSettleListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(HerdSettleListDto herdSettleListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    HerdSettleListDto queryByPK(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo);
}