package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.QueryCommonEndorseDto;

import java.util.Date;

/**
 * @description （普通批单查询服务层接口）
 * @author 王保良
 * @date 2017年11月1日
 */
public interface QueryCommonEndorseService {
    /**
     * 根据保单号查询出其批改申请人(一般就是投保人)以及批改申请日期(用起保日期startDate和批改生效日期validDate对比返回的结果）
     * @param policyNo 保单号
     * @return 返回投保人以及批改生效日期和起保日期比较的结果
     * @author 王保良
     * @date 2017年10月28日
     */
    public QueryCommonEndorseDto queryCommonEndorse(String policyNo, String validDate) throws Exception;
}
