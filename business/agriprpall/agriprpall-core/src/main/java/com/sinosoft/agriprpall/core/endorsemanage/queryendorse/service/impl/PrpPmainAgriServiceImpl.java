package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPmainAgriService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainAgriService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpPmainAgri表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPmainAgriServiceImpl extends BaseServiceImpl implements PrpPmainAgriService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPmainAgriServiceImpl.class);

    @Autowired
    private PrpCmainAgriService prpCmainAgriService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return PrpCmainAgriDto
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCmainAgriDto backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPmainAgriDto prpPmainAgriDto=new PrpPmainAgriDto();
        PrpCmainAgriDto prpCmainAgriDto=new PrpCmainAgriDto();
        if (blEndorseDto.getPrpPmainAgriDto()!=null){
            prpPmainAgriDto=blEndorseDto.getPrpPmainAgriDto();
            prpCmainAgriDto=prpCmainAgriService.PEvaluateC(prpPmainAgriDto);
            responseQueryPolicyInfoDto.setPrpCmainAgriDto(null);
            responseQueryPolicyInfoDto.setPrpCmainAgriDto(prpCmainAgriDto);
        }
        return prpCmainAgriDto;
    }
}
