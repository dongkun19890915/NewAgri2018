package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * PrpPmainService表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
public interface PrpPmainService {
    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return PrpCmainDto
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    public PrpCmainDto backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto blPolicyDto) throws Exception;

    /**
    * 通过批单号查询PrpPmain表
    * @param endorseNo 批单号
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto
    * @throws Exception
    * @author 李冬松
    * @date 14:14 2017/12/15
    */
    public PrpPmainDto queryPrpPmainDtoByEndorseNo(String endorseNo)throws Exception;
}
