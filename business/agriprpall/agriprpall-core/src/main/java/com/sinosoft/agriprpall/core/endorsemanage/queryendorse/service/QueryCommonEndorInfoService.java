package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;

public interface QueryCommonEndorInfoService {
    /**
     *  普通批改保费计算
     * @param policyNo 保单号
     * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto 批单保单大对象
     * @throws Exception
     * @author 李冬松
     * @date 16:39 2017/12/22
     */
    public PolicyEndorseDto queryCommonEndorInfo(String policyNo,String validDate)throws Exception;
}
