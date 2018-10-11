package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPfeeDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCfeeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCfee表服务接口实现类
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
@Service
public class PrpCfeeServiceImpl extends BaseServiceImpl implements PrpCfeeService {

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPfeeDto
     * @return PrpCfeeDto
     * @throws Exception
     */
    @Override
    public PrpCfeeDto PEvaluateC(PrpPfeeDto prpPfeeDto) throws Exception {
        PrpCfeeDto prpCfeeDto=new PrpCfeeDto();
        prpCfeeDto.setPolicyNo(prpPfeeDto.getPolicyNo());
        prpCfeeDto.setRiskCode(prpPfeeDto.getRiskCode());
        prpCfeeDto.setCurrency(prpPfeeDto.getCurrency());
        prpCfeeDto.setAmount(prpPfeeDto.getAmount());
        prpCfeeDto.setPremium(prpPfeeDto.getPremium());
        prpCfeeDto.setFlag(prpPfeeDto.getFlag());
        prpCfeeDto.setCurrency1(prpPfeeDto.getCurrency1());
        prpCfeeDto.setExchangeRate1(prpPfeeDto.getExchangeRate1());
        prpCfeeDto.setAmount1(prpPfeeDto.getAmount1());
        prpCfeeDto.setPremium1(prpPfeeDto.getPremium1());
        prpCfeeDto.setCurrency2(prpPfeeDto.getCurrency2());
        prpCfeeDto.setExchangeRate2(prpPfeeDto.getExchangeRate2());
        prpCfeeDto.setAmount2(prpPfeeDto.getAmount2());
        prpCfeeDto.setPremium2(prpPfeeDto.getPremium2());
        prpCfeeDto.setNoTaxPremium(prpPfeeDto.getNoTaxPremium());
        prpCfeeDto.setNoTaxPremium1(prpPfeeDto.getNoTaxPremium1());
        prpCfeeDto.setNoTaxPremium2(prpPfeeDto.getNoTaxPremium2());
        prpCfeeDto.setTaxFee(prpPfeeDto.getTaxFee());
        prpCfeeDto.setTaxFee1(prpPfeeDto.getTaxFee1());
        prpCfeeDto.setTaxFee2(prpPfeeDto.getTaxFee2());
        return prpCfeeDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPfeeDto
     * @return PrpCfeeDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCfeeDto generatePrpCfee(PrpCPfeeDto prpCPfeeDto) throws Exception {
        PrpCfeeDto prpCfeeDto=new PrpCfeeDto();
        prpCfeeDto.setPolicyNo(prpCPfeeDto.getPolicyNo());
        prpCfeeDto.setRiskCode(prpCPfeeDto.getRiskCode());
        prpCfeeDto.setCurrency(prpCPfeeDto.getCurrency());
        prpCfeeDto.setAmount(prpCPfeeDto.getAmount());
        prpCfeeDto.setPremium(prpCPfeeDto.getPremium());
        prpCfeeDto.setFlag(prpCPfeeDto.getFlag());
        prpCfeeDto.setCurrency1(prpCPfeeDto.getCurrency1());
        prpCfeeDto.setExchangeRate1(prpCPfeeDto.getExchangeRate1());
        prpCfeeDto.setAmount1(prpCPfeeDto.getAmount1());
        prpCfeeDto.setPremium1(prpCPfeeDto.getPremium1());
        prpCfeeDto.setCurrency2(prpCPfeeDto.getCurrency2());
        prpCfeeDto.setExchangeRate2(prpCPfeeDto.getExchangeRate2());
        prpCfeeDto.setAmount2(prpCPfeeDto.getAmount2());
        prpCfeeDto.setPremium2(prpCPfeeDto.getPremium2());
        prpCfeeDto.setNoTaxPremium(prpCPfeeDto.getNoTaxPremium());
        prpCfeeDto.setNoTaxPremium1(prpCPfeeDto.getNoTaxPremium1());
        prpCfeeDto.setNoTaxPremium2(prpCPfeeDto.getNoTaxPremium2());
        prpCfeeDto.setTaxFee(prpCPfeeDto.getTaxFee());
        prpCfeeDto.setTaxFee1(prpCPfeeDto.getTaxFee1());
        prpCfeeDto.setTaxFee2(prpCPfeeDto.getTaxFee2());

        prpCfeeDto.setFeeCurrencyName(prpCPfeeDto.getFeeCurrencyName());
        prpCfeeDto.setFeeCurrencyName1(prpCPfeeDto.getFeeCurrencyName1());
        prpCfeeDto.setFeeCurrencyName2(prpCPfeeDto.getFeeCurrencyName2());
        return prpCfeeDto;
    }
}
