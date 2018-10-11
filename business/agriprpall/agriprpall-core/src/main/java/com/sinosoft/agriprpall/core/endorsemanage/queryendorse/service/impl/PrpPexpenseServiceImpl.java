package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPexpenseService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCexpenseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpPexpense表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPexpenseServiceImpl extends BaseServiceImpl implements PrpPexpenseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPexpenseServiceImpl.class);


    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCexpenseService prpCexpenseService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCexpenseDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCexpenseDto backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpCexpenseDto prpCexpenseDto = new PrpCexpenseDto();
        PrpPexpenseDto prpPexpenseDto = new PrpPexpenseDto();
        int intCurr = 0;
        int intFindFlag = 0;

        if (blEndorseDto.getPrpPexpenseDto()!=null) {
                prpPexpenseDto = blEndorseDto.getPrpPexpenseDto();
                if (prpPexpenseDto.getFlag().substring(0, 1).equals("U")) {
                    intCurr= settleService.PrpCexpenseSearch(prpPexpenseDto.getPolicyNo(),responseQueryPolicyInfoDto.getPrpCexpenseDto());
                    if (intCurr >= 0) {
                        prpCexpenseDto = prpCexpenseService.PEvaluateC(prpPexpenseDto);
                        responseQueryPolicyInfoDto.setPrpCexpenseDto(prpCexpenseDto);
                    }
                }
                if (prpPexpenseDto.getFlag().substring(0, 1).equals("I")) {
                    intCurr= settleService.PrpCexpenseSearch(prpPexpenseDto.getPolicyNo(),responseQueryPolicyInfoDto.getPrpCexpenseDto());
                    if (intCurr >= 0) {
                        responseQueryPolicyInfoDto.setPrpCexpenseDto(null);
                    }
                }
                if (prpPexpenseDto.getFlag().substring(0, 1).equals("D")) {
                    prpCexpenseDto = prpCexpenseService.PEvaluateC(prpPexpenseDto);
                    responseQueryPolicyInfoDto.setPrpCexpenseDto(prpCexpenseDto);

                }
            }
        return responseQueryPolicyInfoDto.getPrpCexpenseDto();
    }
}
