package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorHeadDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description nyxendorheadCore接口
 */
public interface NyxEndorHeadService {

    /**
     *@description 新增
     *@param
     */
    public void save(NyxEndorHeadDto nyxEndorHeadDto)throws Exception;

    /**
     *@description 删除
     *@param
     */
    public void remove(String endorseNo)throws Exception;
    /**
     *@description 修改
     *@param
     */
    void modify(NyxEndorHeadDto nyxEndorHeadDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    NyxEndorHeadDto queryByPK(String endorseNo);
}