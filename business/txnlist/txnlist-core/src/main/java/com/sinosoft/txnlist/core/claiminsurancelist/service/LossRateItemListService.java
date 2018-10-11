package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateItemListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单标的表Core接口
 */
public interface LossRateItemListService {

    /**
     *@description 新增
     *@param
     */
    void save(LossRateItemListDto lossRateItemListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(LossRateItemListDto lossRateItemListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    LossRateItemListDto queryByPK(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode);

    /**
     * 根据清单号和序列号查询清单信息集合
     * @param lossListCode 清单号
     * @param serialNo 序列号
     * @return List<LossRateItemListDto>
     * @author 王心洋
     * @time 2018-01-19
     */
    List<LossRateItemListDto> queryBylossListCodeAndSerialNo(String lossListCode,Integer serialNo);
}