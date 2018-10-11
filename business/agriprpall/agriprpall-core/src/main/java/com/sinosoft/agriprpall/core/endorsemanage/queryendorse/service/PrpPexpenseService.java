package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * PrpPexpense表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface PrpPexpenseService {
    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCexpenseDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public PrpCexpenseDto backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;
}
