package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPplanService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PrpPplan表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPplanServiceImpl extends BaseServiceImpl implements PrpPplanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPplanServiceImpl.class);


    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpPplanService prpPplanService;
    @Autowired
    private PrpCplanService prpCplanService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCplanDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCplanDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {

        PrpPplanDto prpPplanDto = new PrpPplanDto();
        PrpCplanDto prpCplanDto = new PrpCplanDto();
        List<PrpCplanDto> prpCplanDtoList=new ArrayList<>();
        if (blEndorseDto.getPrpPplanDtoList().size() > 0) {
            for (int i = 0; i < blEndorseDto.getPrpPplanDtoList().size(); i++) {
                prpPplanDto = blEndorseDto.getPrpPplanDtoList().get(i);
                prpCplanDto = prpCplanService.PEvaluateC(prpPplanDto);
                prpCplanDtoList.add(prpCplanDto);
            }
        }
        return prpCplanDtoList;
    }
}
