package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdSettleListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
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
    void remove(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(HerdSettleListDto herdSettleListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    HerdSettleListDto queryByPK(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo);


    /**
     *  根据GIS清单号查询承保清单 养殖险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    public List<HerdSettleListDto> queryByGisInsureListCode(String gisInsureListCode)throws Exception;
}