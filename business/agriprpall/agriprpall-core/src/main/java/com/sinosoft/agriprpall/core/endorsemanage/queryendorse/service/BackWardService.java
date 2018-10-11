package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * 批单回倒方法
 * @author 王保良
 * @date 2017年11月10日
 */
public interface BackWardService {
    /**
     * 批单回倒a
     * @param endorseNo 批单号
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public void backWard(String endorseNo, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;
}
