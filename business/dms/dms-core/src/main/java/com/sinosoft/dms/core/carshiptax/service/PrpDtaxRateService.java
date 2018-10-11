package com.sinosoft.dms.core.carshiptax.service;


import com.sinosoft.dms.api.carshiptax.dto.PrpDtaxRateDto;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * @description 税率表Core接口
 */
public interface PrpDtaxRateService {


    /**
     *@description 新增
     *@param
     */
    void save(PrpDtaxRateDto prpDtaxRateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String comCode,java.lang.Integer taxPeriod,java.lang.Integer serialNo,String taxItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDtaxRateDto prpDtaxRateDto);
    /**
     *@description 按主键查询实体
     * @param
     */
    PrpDtaxRateDto queryByPK(String comCode,java.lang.Integer taxPeriod,java.lang.Integer serialNo,String taxItemCode);

    PrpDtaxRateDto getTaxRate(String comCode, int taxPeriod, String taxItemCode, String taxItemDetailCode,
                                String validDate) throws Exception;
}