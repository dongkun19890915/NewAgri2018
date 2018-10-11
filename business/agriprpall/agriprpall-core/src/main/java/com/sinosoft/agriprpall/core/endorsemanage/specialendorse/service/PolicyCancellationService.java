package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface PolicyCancellationService {

    public void cancellation(ResponseQueryPolicyInfoDto blPolicy, String policyNo) throws Exception;
}
