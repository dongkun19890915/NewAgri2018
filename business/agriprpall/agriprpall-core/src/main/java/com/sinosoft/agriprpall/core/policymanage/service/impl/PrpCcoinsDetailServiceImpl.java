package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPcoinsDetailDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDetailDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCcoinsDetailService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpCcoinsDetailServiceImpl extends BaseServiceImpl implements PrpCcoinsDetailService{

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCcoinsDetailDto generatePrpCcoinsDetail(PrpCPcoinsDetailDto prpCPcoinsDetailDto) throws Exception {
        PrpCcoinsDetailDto prpCcoinsDetailDto=new PrpCcoinsDetailDto();

        prpCcoinsDetailDto.setPolicyNo(prpCPcoinsDetailDto.getPolicyNo());
        prpCcoinsDetailDto.setSerialNo(prpCPcoinsDetailDto.getSerialNo());
        prpCcoinsDetailDto.setCoinsCode(prpCPcoinsDetailDto.getCoinsCode());
        prpCcoinsDetailDto.setCoinsName(prpCPcoinsDetailDto.getCoinsName());
        prpCcoinsDetailDto.setCurrency(prpCPcoinsDetailDto.getCurrency());
        prpCcoinsDetailDto.setCoinsAmount(prpCPcoinsDetailDto.getCoinsAmount());
        prpCcoinsDetailDto.setCoinsPremium(prpCPcoinsDetailDto.getCoinsPremium());
        prpCcoinsDetailDto.setAgentFee(prpCPcoinsDetailDto.getAgentFee());
        // modify by yangkun begin 20051216 联共保处理新增加字段
        prpCcoinsDetailDto.setMiddleCostFee(prpCPcoinsDetailDto.getMiddleCostFee()); // 特殊因子费
        // modify by yangkun end 20051216
        prpCcoinsDetailDto.setOperateFee(prpCPcoinsDetailDto.getOperateFee());
        prpCcoinsDetailDto.setFlag(prpCPcoinsDetailDto.getFlag());
        prpCcoinsDetailDto.setCoinsNoTaxPremium(prpCPcoinsDetailDto.getCoinsNoTaxPremium());
        prpCcoinsDetailDto.setCoinsTaxFee(prpCPcoinsDetailDto.getCoinsTaxFee());
        prpCcoinsDetailDto.setOperateNoTaxPremium(prpCPcoinsDetailDto.getOperateNoTaxPremium());
        prpCcoinsDetailDto.setOperateTaxRate(prpCPcoinsDetailDto.getOperateTaxRate());
        prpCcoinsDetailDto.setOperateTaxFee(prpCPcoinsDetailDto.getOperateTaxFee());
        prpCcoinsDetailDto.setAgentNoTaxPremium(prpCPcoinsDetailDto.getAgentNoTaxPremium());
        prpCcoinsDetailDto.setAgentTaxFee(prpCPcoinsDetailDto.getAgentTaxFee());
        return prpCcoinsDetailDto;
    }
}
