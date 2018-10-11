package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxAgriDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表Core接口
 */
public interface PrpDriskKindTaxAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(Integer uuid);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDriskKindTaxAgriDto queryByPK(Integer uuid);

    /**
     *  递归方法，根据机构代码向上获取税率信息
     * @author: 田健
     * @date: 2017/12/25 10:16
     * @param prpDriskKindTaxDto Comcode  归属机构;Riskcode  险种; Kindcode  险别; TaxType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率;validDate 当前日期
     * @return  险种险别增值税基础税率配置表信息
     * @throws Exception
     */
    PrpDriskKindTaxAgriDto findTaxRateByLowerComcodeToUpper(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception;

}