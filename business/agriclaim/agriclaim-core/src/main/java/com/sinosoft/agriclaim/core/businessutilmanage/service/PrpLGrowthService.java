package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLGrowthDto;

import java.util.List;
import java.util.Map;

/**
 * 生长期表接口
 * @Author: 孙朋飞
 * @Date: 2018/3/21 14:24
 */
public interface PrpLGrowthService {

    /**
     * 查询生长期
     * @author: 孙朋飞
     * @date: 2018/3/21 14:47
     * @param prpLGrowthDto 险种-riskCode,条款-clauseCode,标的-itemCode,险别-kindCode
     * @return 生长期集合
     * @throws Exception
     */
    List<PrpLGrowthDto> queryPrpLGrowthByConditions(PrpLGrowthDto prpLGrowthDto) throws Exception;
    /**
     * 查询条款和标的
     * @author: 孙朋飞
     * @date: 2018/3/23 17:06
     * @param  policyNo 保单号
     * @param  registNo 报案号
     * @return 条款和标的
     * @throws Exception
     */
    public Map<String,String> queryPrpLRegistAndPrpCmainByConditions(String policyNo, String registNo) throws Exception;
}