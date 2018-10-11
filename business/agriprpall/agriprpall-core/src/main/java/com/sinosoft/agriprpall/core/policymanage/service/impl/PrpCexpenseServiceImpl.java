package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPexpenseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPexpenseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCexpenseDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCexpenseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCexpense表服务接口实现类
 * @Author: 王保良
 * @Date: 9:00 2017/11/28
 */
@Service
public class PrpCexpenseServiceImpl extends BaseServiceImpl implements PrpCexpenseService {

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPexpenseDto
     * @return prpCexpenseDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCexpenseDto PEvaluateC(PrpPexpenseDto prpPexpenseDto) throws Exception {
        PrpCexpenseDto prpCexpenseDto=new PrpCexpenseDto();
        prpCexpenseDto.setPolicyNo(prpPexpenseDto.getPolicyNo());
        prpCexpenseDto.setRiskCode(prpPexpenseDto.getRiskCode());
        prpCexpenseDto.setManageFeeRate(prpPexpenseDto.getManageFeeRate());
        prpCexpenseDto.setMaxManageFeeRate(prpPexpenseDto.getMaxManageFeeRate());
        prpCexpenseDto.setFlag(prpPexpenseDto.getFlag());
        prpCexpenseDto.setBasePerformanceRate(prpPexpenseDto.getBasePerformanceRate());
        prpCexpenseDto.setBasePerformance(prpPexpenseDto.getBasePerformance());
        prpCexpenseDto.setEncouragePerformanceRate(prpPexpenseDto.getEncouragePerformanceRate());
        prpCexpenseDto.setEncouragePerformance(prpPexpenseDto.getEncouragePerformance());
        prpCexpenseDto.setNoTaxFee(prpPexpenseDto.getNoTaxFee());
        prpCexpenseDto.setTaxRate(prpPexpenseDto.getTaxRate());
        prpCexpenseDto.setTaxFee(prpPexpenseDto.getTaxFee());
        return prpCexpenseDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPexpenseDto
     * @return PrpCexpenseDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCexpenseDto generatePrpCexpense(PrpCPexpenseDto prpCPexpenseDto) throws Exception {
        PrpCexpenseDto prpCexpenseDto=new PrpCexpenseDto();
        prpCexpenseDto.setPolicyNo(prpCPexpenseDto.getPolicyNo());
        prpCexpenseDto.setRiskCode(prpCPexpenseDto.getRiskCode());
        prpCexpenseDto.setManageFeeRate(prpCPexpenseDto.getManageFeeRate());
        prpCexpenseDto.setMaxManageFeeRate(prpCPexpenseDto.getMaxManageFeeRate());
        // add by luyang 救助基金比例 20060616
        prpCexpenseDto.setSalvationFee(prpCPexpenseDto.getSalvationFee());
        prpCexpenseDto.setSalvationRate(prpCPexpenseDto.getSalvationRate());
        prpCexpenseDto.setCurrency(prpCPexpenseDto.getCurrency());
        prpCexpenseDto.setFlag(prpCPexpenseDto.getFlag());
        prpCexpenseDto.setBasePerformanceRate(prpCPexpenseDto.getBasePerformanceRate());
        prpCexpenseDto.setBasePerformance(prpCPexpenseDto.getBasePerformance());
        prpCexpenseDto.setEncouragePerformanceRate(prpCPexpenseDto.getEncouragePerformanceRate());
        prpCexpenseDto.setEncouragePerformance(prpCPexpenseDto.getEncouragePerformance());
        prpCexpenseDto.setNoTaxFee(prpCPexpenseDto.getNoTaxFee());
        prpCexpenseDto.setTaxRate(prpCPexpenseDto.getTaxRate());
        prpCexpenseDto.setTaxFee(prpCPexpenseDto.getTaxFee());
        return prpCexpenseDto;
    }
}
