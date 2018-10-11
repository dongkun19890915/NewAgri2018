package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPmainAgriDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainAgriDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainAgriService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpCmainAgri表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpCmainAgriServiceImpl extends BaseServiceImpl implements PrpCmainAgriService {
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPmainAgriDto
     * @return PrpCmainAgriDto
     * @throws Exception
     */
    @Override
    public PrpCmainAgriDto PEvaluateC(PrpPmainAgriDto prpPmainAgriDto) throws Exception {
        PrpCmainAgriDto prpCmainAgriDto=new PrpCmainAgriDto();
        prpCmainAgriDto.setPolicyNo       (prpPmainAgriDto.getPolicyNo()      );

        prpCmainAgriDto.setRiskCode     (prpPmainAgriDto.getRiskCode()    );
        prpCmainAgriDto.setRaiseDate    (prpPmainAgriDto.getRaiseDate()   );
        prpCmainAgriDto.setRaiseSite    (prpPmainAgriDto.getRaiseSite()   );
        prpCmainAgriDto.setInsureArea   (prpPmainAgriDto.getInsureArea()  );
        prpCmainAgriDto.setRemark       (prpPmainAgriDto.getRemark()      );
        prpCmainAgriDto.setFlag         (prpPmainAgriDto.getFlag()        );
//add by guolei
        prpCmainAgriDto.setObserveEndDate(prpPmainAgriDto.getObserveEndDate());
        prpCmainAgriDto.setObserveEndHour(prpPmainAgriDto.getObserveEndHour());
        prpCmainAgriDto.setDeptName(prpPmainAgriDto.getDeptName());
        prpCmainAgriDto.setDeptAddress(prpPmainAgriDto.getDeptAddress());
        prpCmainAgriDto.setAreaFlag(prpPmainAgriDto.getAreaFlag());
        prpCmainAgriDto.setObservePeriod(prpPmainAgriDto.getObservePeriod());
        prpCmainAgriDto.setObserveStartDate(prpPmainAgriDto.getObserveStartDate());
        prpCmainAgriDto.setObserveStartHour(prpPmainAgriDto.getObserveStartHour());
        prpCmainAgriDto.setValueRate(prpPmainAgriDto.getValueRate());
        prpCmainAgriDto.setSelfPremium(prpPmainAgriDto.getSelfPremium());
        prpCmainAgriDto.setRaiseType(prpPmainAgriDto.getRaiseType());
        prpCmainAgriDto.setRelationListNo(prpPmainAgriDto.getRelationListNo());
        prpCmainAgriDto.setRelationListNoRemark(prpPmainAgriDto.getRelationListNoRemark());

        return prpCmainAgriDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPmainAgriDto
     * @return PrpCmainAgriDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCmainAgriDto generatePrpCmainAgri(PrpCPmainAgriDto prpCPmainAgriDto) throws Exception {
        PrpCmainAgriDto prpCmainAgriDto=new PrpCmainAgriDto();
        prpCmainAgriDto.setPolicyNo(prpCPmainAgriDto.getPolicyNo());
        prpCmainAgriDto.setRiskCode(prpCPmainAgriDto.getRiskCode());
        prpCmainAgriDto.setRaiseDate(prpCPmainAgriDto.getRaiseDate());
        prpCmainAgriDto.setRaiseSite(prpCPmainAgriDto.getRaiseSite());
        prpCmainAgriDto.setInsureArea(prpCPmainAgriDto.getInsureArea());
        prpCmainAgriDto.setRemark(prpCPmainAgriDto.getRemark());
        prpCmainAgriDto.setFlag(prpCPmainAgriDto.getFlag());

        // add by guolei
        prpCmainAgriDto.setObserveEndDate(prpCPmainAgriDto.getObserveEndDate());
        prpCmainAgriDto.setObserveEndHour(prpCPmainAgriDto.getObserveEndHour());
        prpCmainAgriDto.setDeptName(prpCPmainAgriDto.getDeptName());
        prpCmainAgriDto.setDeptAddress(prpCPmainAgriDto.getDeptAddress());
        prpCmainAgriDto.setAreaFlag(prpCPmainAgriDto.getAreaFlag());
        prpCmainAgriDto.setObservePeriod(prpCPmainAgriDto.getObservePeriod());
        prpCmainAgriDto.setObserveStartDate(prpCPmainAgriDto.getObserveStartDate());
        prpCmainAgriDto.setObserveStartHour(prpCPmainAgriDto.getObserveStartHour());
        prpCmainAgriDto.setValueRate(prpCPmainAgriDto.getValueRate());
        prpCmainAgriDto.setSelfPremium(prpCPmainAgriDto.getSelfPremium());
        prpCmainAgriDto.setRaiseType(prpCPmainAgriDto.getRaiseType());
        prpCmainAgriDto.setRelationListNo(prpCPmainAgriDto.getRelationListNo());
        prpCmainAgriDto.setRelationListNoRemark(prpCPmainAgriDto.getRelationListNoRemark());
        return prpCmainAgriDto;
    }
}
