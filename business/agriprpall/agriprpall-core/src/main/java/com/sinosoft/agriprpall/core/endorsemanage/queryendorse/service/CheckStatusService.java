package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

/**
 * (查询是否有效的批单的接口）
 * @author 王保良
 * @date 2017年11月10日
 */
public interface CheckStatusService {
    /**
     * 根据保单号查询是否有有效批单
     * @param policyNo 保单号
     * @return status 标示了查询结果,有或者无有效的批单 并封装进responseDto中
     * @author 王保良
     * @date 2017年10月28日
     */
    Integer checkStatus(String policyNo) throws Exception;
}
