package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorHeadDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description 批改头表Core接口
 */
public interface HerdEndorHeadService {

    /**
     *@description 新增
     *@param
     */
    public void save(HerdEndorHeadDto herdEndorHeadDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String endorseNo);
    /**
     *@description 修改
     *@param
     */
    void modify(HerdEndorHeadDto herdEndorHeadDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    HerdEndorHeadDto queryByPK(String endorseNo);
}