package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPplanCoinsService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanCoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PrpPplanCoins表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPplanCoinsServiceImpl extends BaseServiceImpl implements PrpPplanCoinsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPplanCoinsServiceImpl.class);


    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCplanCoinsService prpCplanCoinsService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCplanCoinsDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCplanCoinsDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {

        PrpPplanCoinsDto prpPplanCoinsDto = new PrpPplanCoinsDto();
        PrpCplanCoinsDto prpCplanCoinsDto = new PrpCplanCoinsDto();
        List<PrpCplanCoinsDto> prpCplanCoinsDtoList=new ArrayList<>();
        if (blEndorseDto.getPrpPplanCoinsDtoList().size() > 0) {
            for (int i = 0; i < blEndorseDto.getPrpPplanCoinsDtoList().size(); i++) {
                prpPplanCoinsDto = blEndorseDto.getPrpPplanCoinsDtoList().get(i);
                prpCplanCoinsDto = prpCplanCoinsService.PEvaluateC(prpPplanCoinsDto);
                prpCplanCoinsDtoList.add(prpCplanCoinsDto);
            }
        }
        return prpCplanCoinsDtoList;
    }
}
