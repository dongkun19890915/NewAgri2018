package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPitemKindAgriService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindAgriService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPitemKindAgri表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPitemKindAgriServiceImpl extends BaseServiceImpl implements PrpPitemKindAgriService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPitemKindAgriServiceImpl.class);

    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCitemKindAgriService prpCitemKindAgriService;
    @Autowired
    private PrpPitemKindAgriService prpPitemKindAgriService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCitemKindAgriDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCitemKindAgriDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPitemKindAgriDto prpPitemKindAgriDto = new PrpPitemKindAgriDto();
        PrpCitemKindAgriDto prpCitemKindAgriDto = new PrpCitemKindAgriDto();
        if (blEndorseDto.getPrpPitemKindAgriDtoList().size() > 0) {
            prpPitemKindAgriDto = blEndorseDto.getPrpPitemKindAgriDtoList().get(0);
            prpCitemKindAgriDto = prpCitemKindAgriService.PEvaluateC(prpPitemKindAgriDto);
            responseQueryPolicyInfoDto.getPrpCitemKindAgriDtoList().remove(0);
            responseQueryPolicyInfoDto.getPrpCitemKindAgriDtoList().add(prpCitemKindAgriDto);
        }

        return responseQueryPolicyInfoDto.getPrpCitemKindAgriDtoList();
    }
}
