package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCaddress;

import java.util.List;

/**
 * PrpPaddress表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface PrpPaddressService {
    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCaddressDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public List<PrpCaddressDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;
}
