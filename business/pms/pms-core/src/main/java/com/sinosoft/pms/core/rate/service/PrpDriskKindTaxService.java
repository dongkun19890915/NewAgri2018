package com.sinosoft.pms.core.rate.service;


import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表Core接口
 */
public interface PrpDriskKindTaxService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDriskKindTaxDto prpDriskKindTaxDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer uuid);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDriskKindTaxDto prpDriskKindTaxDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDriskKindTaxDto queryByPK(java.lang.Integer uuid);

    /**
     *  递归方法，根据机构代码向上获取税率信息
     * @author: 田健
     * @date: 2017/12/25 10:16
     * @param prpDriskKindTaxDto Comcode  归属机构;Riskcode  险种; Kindcode  险别; TaxType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率;validDate 当前日期
     * @return  险种险别增值税基础税率配置表信息
     * @throws Exception
     */
    PrpDriskKindTaxDto findTaxRateByLowerComcodeToUpper(PrpDriskKindTaxDto prpDriskKindTaxDto) throws Exception;
}