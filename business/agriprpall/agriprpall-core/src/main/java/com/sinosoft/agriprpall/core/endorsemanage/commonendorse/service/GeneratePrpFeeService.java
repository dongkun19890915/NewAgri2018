package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface GeneratePrpFeeService {
    /**
     * @description
     * @param blPolicyDto, currency
     * @return int
     * @throws
     * @author 李冬松
     * @date 12:07 2017/11/10
     */
    public  int search(ResponseQueryPolicyInfoDto blPolicyDto, String currency) throws Exception;
}
