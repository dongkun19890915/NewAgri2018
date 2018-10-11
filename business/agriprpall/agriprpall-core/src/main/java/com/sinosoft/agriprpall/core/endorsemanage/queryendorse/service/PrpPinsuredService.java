package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

import java.util.List;

/**
 * PrpPinsured表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface PrpPinsuredService {
    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCinsuredDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public List<PrpCinsuredDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;
}
