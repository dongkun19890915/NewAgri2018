package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface BLEndroseService {

    /**
     * 保单还原到任意的时间点
     * @param policyNo     保单号
     * @param backWardDate 出险日期
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     * @author: 刘曼曼
     * @date: 2017/11/27 17:32
     */
    public ResponseQueryPolicyInfoDto getBackWardPolicy(String policyNo, String backWardDate) throws Exception;

    /**
     * 获取原始保单信息
     * @author: 刘曼曼
     * @date: 2017/11/28 10:48
     * @param policyNo 保单号
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    public ResponseQueryPolicyInfoDto getOriginalPolicy(String policyNo) throws Exception;
}
