package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 短期费率表Core接口
 */
public interface PrpDshortRateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDshortRateDto prpDshortRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String shortRateId, Integer serialno);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDshortRateDto prpDshortRateDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDshortRateDto queryByPK(String shortRateId, Integer serialno);

    PrpDshortRateDto queryPrpDshortRateDto(String riskCode, Integer months) throws Exception;

    /**
     * 根据险种和标的代码查询短期费率
     * @author: 刘曼曼
     * @date: 11:28 11:28
     * @param riskCode 险种
     * @param itemCode 标的
     * @return List<PrpDshortRateDto> 短期费率集合
     * @throws Exception
     */
    List<PrpDshortRateDto> queryByRiskCodeAndItemCode(String riskCode,String itemCode)throws Exception;
}