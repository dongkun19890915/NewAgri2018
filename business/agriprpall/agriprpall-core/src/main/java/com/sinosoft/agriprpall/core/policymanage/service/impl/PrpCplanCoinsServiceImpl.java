package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPplanCoinsDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanCoinsDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanCoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCplanCoins表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpCplanCoinsServiceImpl extends BaseServiceImpl implements PrpCplanCoinsService {

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPplanCoinsDto
     * @return PrpCplanCoinsDto
     * @throws Exception
     */
    @Override
    public PrpCplanCoinsDto PEvaluateC(PrpPplanCoinsDto prpPplanCoinsDto) throws Exception {
        PrpCplanCoinsDto prpCplanCoinsDto=new PrpCplanCoinsDto();
        prpCplanCoinsDto.setPolicyNo(prpPplanCoinsDto.getPolicyNo());
        prpCplanCoinsDto.setEndorseNo(prpPplanCoinsDto.getEndorseNo1());
        prpCplanCoinsDto.setCoinsCode(prpPplanCoinsDto.getCoinsCode());
        prpCplanCoinsDto.setSerialNo(prpPplanCoinsDto.getSerialNo());
        prpCplanCoinsDto.setPayNo(prpPplanCoinsDto.getPayNo());
        prpCplanCoinsDto.setPayReason(prpPplanCoinsDto.getPayReason());
        prpCplanCoinsDto.setCurrency(prpPplanCoinsDto.getCurrency());
        prpCplanCoinsDto.setPlanDate(prpPplanCoinsDto.getPlanDate());
        prpCplanCoinsDto.setPlanFee(prpPplanCoinsDto.getPlanFee());
        prpCplanCoinsDto.setDelinquentFee(prpPplanCoinsDto.getDelinquentFee());
        prpCplanCoinsDto.setPlanStartDate(prpPplanCoinsDto.getPlanStartDate());
        prpCplanCoinsDto.setFlag(prpPplanCoinsDto.getFlag());
        prpCplanCoinsDto.setPlanRate(prpPplanCoinsDto.getPlanRate());
        prpCplanCoinsDto.setNoTaxPremium(prpPplanCoinsDto.getNoTaxPremium());
        prpCplanCoinsDto.setTaxFee(prpPplanCoinsDto.getTaxFee());
        return prpCplanCoinsDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPplanCoinsDto
     * @return PrpCplanCoinsDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCplanCoinsDto generatePrpCplanCoins(PrpCPplanCoinsDto prpCPplanCoinsDto) throws Exception {
        PrpCplanCoinsDto prpCplanCoinsDto=new PrpCplanCoinsDto();
        prpCplanCoinsDto.setPolicyNo(prpCPplanCoinsDto.getPolicyNo());
        prpCplanCoinsDto.setEndorseNo(prpCPplanCoinsDto.getEndorseNo());
        prpCplanCoinsDto.setCoinsCode(prpCPplanCoinsDto.getCoinsCode());
        prpCplanCoinsDto.setSerialNo(prpCPplanCoinsDto.getSerialNo());
        prpCplanCoinsDto.setPayNo(prpCPplanCoinsDto.getPayNo());
        prpCplanCoinsDto.setPayReason(prpCPplanCoinsDto.getPayReason());
        prpCplanCoinsDto.setPlanDate(prpCPplanCoinsDto.getPlanDate());
        prpCplanCoinsDto.setCurrency(prpCPplanCoinsDto.getCurrency());
        prpCplanCoinsDto.setPlanFee(prpCPplanCoinsDto.getPlanFee());
        prpCplanCoinsDto.setPlanRate(prpCPplanCoinsDto.getPlanRate());
        prpCplanCoinsDto.setDelinquentFee(prpCPplanCoinsDto.getDelinquentFee());
        prpCplanCoinsDto.setFlag(prpCPplanCoinsDto.getFlag());
        prpCplanCoinsDto.setPlanStartDate(prpCPplanCoinsDto.getPlanStartDate());
        prpCplanCoinsDto.setNoTaxPremium(prpCPplanCoinsDto.getNoTaxPremium());
        prpCplanCoinsDto.setTaxFee(prpCPplanCoinsDto.getTaxFee());
        return prpCplanCoinsDto;
    }
}
