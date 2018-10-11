package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPsubsidyDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCsubsidy;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCsubsidyService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCsubsidy表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpCsubsidyServiceImpl extends BaseServiceImpl implements PrpCsubsidyService{


    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPsubsidyDto
     * @return PrpCsubsidyDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCsubsidyDto PEvaluateC(PrpPsubsidyDto prpPsubsidyDto) throws Exception {
        PrpCsubsidyDto prpCsubsidyDto=new PrpCsubsidyDto();
        prpCsubsidyDto.setBenchmarkPremium(prpPsubsidyDto.getBenchmarkPremium());
        prpCsubsidyDto.setClassCode(prpPsubsidyDto.getClassCode());
        prpCsubsidyDto.setComCode(prpPsubsidyDto.getComCode());
        prpCsubsidyDto.setContractNo(prpPsubsidyDto.getComCode());
        prpCsubsidyDto.setCurrency(prpPsubsidyDto.getCurrency());
        prpCsubsidyDto.setOperationFlag(prpPsubsidyDto.getOperationFlag());
        prpCsubsidyDto.setPolicyNo(prpCsubsidyDto.getPolicyNo());
        prpCsubsidyDto.setProposalNo(prpCsubsidyDto.getProposalNo());
        prpCsubsidyDto.setRiskCode(prpCsubsidyDto.getRiskCode());
        prpCsubsidyDto.setSubsidyCode(prpCsubsidyDto.getSubsidyCode());
        prpCsubsidyDto.setSubsidyDepartment(prpCsubsidyDto.getSubsidyDepartment());
        prpCsubsidyDto.setSubsidyName(prpCsubsidyDto.getSubsidyName());
        prpCsubsidyDto.setSubsidyRate(prpCsubsidyDto.getSubsidyRate());
        prpCsubsidyDto.setSubsidyPremium(prpCsubsidyDto.getSubsidyPremium());
        prpCsubsidyDto.setSubsidyType(prpCsubsidyDto.getSubsidyType());
        prpCsubsidyDto.setSubsidyTypeName(prpCsubsidyDto.getSubsidyTypeName());
        return prpCsubsidyDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPsubsidyDto
     * @return PrpCsubsidyDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCsubsidyDto generatePrpCsubsidy(PrpCPsubsidyDto prpCPsubsidyDto) throws Exception {
        PrpCsubsidyDto prpCsubsidyDto=new PrpCsubsidyDto();
        prpCsubsidyDto.setPolicyNo(prpCPsubsidyDto.getPolicyNo());
        prpCsubsidyDto.setProposalNo(prpCPsubsidyDto.getProposalNo());
        prpCsubsidyDto.setContractNo(prpCPsubsidyDto.getContractNo());

        prpCsubsidyDto.setRiskCode(prpCPsubsidyDto.getRiskCode());
        prpCsubsidyDto.setClassCode(prpCPsubsidyDto.getClassCode());
        prpCsubsidyDto.setComCode(prpCPsubsidyDto.getComCode());
        prpCsubsidyDto.setCurrency(prpCPsubsidyDto.getCurrency());
        prpCsubsidyDto.setBenchmarkPremium(prpCPsubsidyDto.getBenchmarkPremium());
        prpCsubsidyDto.setSubsidyCode(prpCPsubsidyDto.getSubsidyCode());
        prpCsubsidyDto.setSubsidyName(prpCPsubsidyDto.getSubsidyName());
        prpCsubsidyDto.setSubsidyType(prpCPsubsidyDto.getSubsidyType());
        prpCsubsidyDto.setSubsidyTypeName(prpCPsubsidyDto.getSubsidyTypeName());
        prpCsubsidyDto.setSubsidyDepartment(prpCPsubsidyDto.getSubsidyDepartment());
        prpCsubsidyDto.setSubsidyRate(prpCPsubsidyDto.getSubsidyRate());
        prpCsubsidyDto.setSubsidyPremium(prpCPsubsidyDto.getSubsidyPremium());
        prpCsubsidyDto.setOperationFlag(prpCPsubsidyDto.getOperationFlag());
        return prpCsubsidyDto;
    }
}
