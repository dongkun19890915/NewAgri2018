package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

import java.util.List;

/**
 * PrpPengage表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface PrpPEngageService {
    public boolean savePrpPEgage(BLEndorseDto endorseDto)throws Exception;
    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCengageDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public List<PrpCengageDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception;
}
