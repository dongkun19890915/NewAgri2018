package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;


import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.PlantingEndorChgDetailService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PlantingEndorChgDetailServiceImpl extends BaseServiceImpl implements PlantingEndorChgDetailService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setPlantingEndorChgDetail(PlantingEndorChgDetailDto plantingEndorChgDetailSchema, PlantingPolicyListDto plantingPolicyListOldSchema, PlantingPolicyListDto plantingPolicyListNewSchema) throws Exception {

        plantingEndorChgDetailSchema.setInusreListCode(plantingPolicyListOldSchema.getInusreListCode());
        plantingEndorChgDetailSchema.setfCode(plantingPolicyListOldSchema.getfCode());
        plantingEndorChgDetailSchema.setKindCode(plantingPolicyListOldSchema.getKindCode());
        plantingEndorChgDetailSchema.setIndexCode(plantingPolicyListOldSchema.getIndexCode());
        plantingEndorChgDetailSchema.setPhone(plantingPolicyListOldSchema.getPhone());
        plantingEndorChgDetailSchema.setBank(plantingPolicyListOldSchema.getBank());
        plantingEndorChgDetailSchema.setZhiBuKa(plantingPolicyListOldSchema.getZhiBuKa());
        plantingEndorChgDetailSchema.setfName(plantingPolicyListOldSchema.getfName());
        plantingEndorChgDetailSchema.setfIdCard(plantingPolicyListOldSchema.getfIdCard());
        plantingEndorChgDetailSchema.setClassCode(plantingPolicyListOldSchema.getClassCode());
        plantingEndorChgDetailSchema.setRiskCode(plantingPolicyListOldSchema.getRiskCode());
        plantingEndorChgDetailSchema.setfAreaCode(plantingPolicyListOldSchema.getfAreaCode());
        plantingEndorChgDetailSchema.setTaxArea(plantingPolicyListOldSchema.getTaxArea());
        plantingEndorChgDetailSchema.setInsureArea(plantingPolicyListOldSchema.getInsureArea());
        plantingEndorChgDetailSchema.setAmount(plantingPolicyListOldSchema.getAmount());
        plantingEndorChgDetailSchema.setRate(plantingPolicyListOldSchema.getRate());
        plantingEndorChgDetailSchema.setShortRateFlag(plantingPolicyListOldSchema.getShortRateFlag());
        plantingEndorChgDetailSchema.setShortRate(plantingPolicyListOldSchema.getShortRate());
        plantingEndorChgDetailSchema.setSumAmount(plantingPolicyListOldSchema.getSumAmount());
        plantingEndorChgDetailSchema.setSumPremium(plantingPolicyListOldSchema.getSumPremium());
        plantingEndorChgDetailSchema.setStartDate(plantingPolicyListOldSchema.getStartDate());
        plantingEndorChgDetailSchema.setEndDate(plantingPolicyListOldSchema.getEndDate());
        plantingEndorChgDetailSchema.setCalculateFlag(plantingPolicyListOldSchema.getCalculateFlag());
        plantingEndorChgDetailSchema.setOpCode(plantingPolicyListOldSchema.getOpCode());
        plantingEndorChgDetailSchema.setOpTime(plantingPolicyListOldSchema.getOpTime());
        plantingEndorChgDetailSchema.setValidity(plantingPolicyListOldSchema.getValidity());
        plantingEndorChgDetailSchema.setRemark(plantingPolicyListOldSchema.getRemark());
        plantingEndorChgDetailSchema.setfPremium(plantingPolicyListOldSchema.getfPremium());
        plantingEndorChgDetailSchema.setTeamName(plantingPolicyListOldSchema.getTeamName());
        plantingEndorChgDetailSchema.setFieldSource(plantingPolicyListOldSchema.getFieldSource());
        plantingEndorChgDetailSchema.setCentralPremium(plantingPolicyListOldSchema.getCentralPremium());
        plantingEndorChgDetailSchema.setProvincePremium(plantingPolicyListOldSchema.getProvincePremium());
        plantingEndorChgDetailSchema.setCityPremium(plantingPolicyListOldSchema.getCityPremium());
        plantingEndorChgDetailSchema.setTownPremium(plantingPolicyListOldSchema.getTownPremium());
        plantingEndorChgDetailSchema.setOtherPremium(plantingPolicyListOldSchema.getOtherPremium());
        plantingEndorChgDetailSchema.setAtArea(plantingPolicyListOldSchema.getAtArea());
        plantingEndorChgDetailSchema.setLittleAreaName(plantingPolicyListOldSchema.getLittleAreaName());
        plantingEndorChgDetailSchema.setFlag(plantingPolicyListNewSchema.getFlag()); //标志用新的
        plantingEndorChgDetailSchema.setWarrant(plantingPolicyListNewSchema.getWarrant());
        if (plantingPolicyListNewSchema.getWoodlandArea() != null && !plantingPolicyListNewSchema.getWoodlandArea().equals("")) {
            plantingEndorChgDetailSchema.setWoodLandArea(plantingPolicyListNewSchema.getWoodlandArea());
        }

        //变化量
        if (plantingPolicyListNewSchema.getFlag().length() > 0) {
            if (plantingEndorChgDetailSchema.getFlag().charAt(0) == 'I') {
                plantingEndorChgDetailSchema.setChgInsureArea(plantingEndorChgDetailSchema.getInsureArea());
                plantingEndorChgDetailSchema.setChgSumAmount(plantingPolicyListNewSchema.getSumAmount());
                plantingEndorChgDetailSchema.setChgSumPremium(plantingPolicyListNewSchema.getSumPremium());
            } else {
                BigDecimal InsureAreaNew = new BigDecimal(plantingPolicyListNewSchema.getInsureArea());
                BigDecimal InsureAreaOld = new BigDecimal(plantingPolicyListOldSchema.getInsureArea());
                BigDecimal dbInsureArea = InsureAreaNew.subtract(InsureAreaOld);
                dbInsureArea.setScale(3, BigDecimal.ROUND_HALF_UP);
                plantingEndorChgDetailSchema.setChgInsureArea(dbInsureArea.doubleValue());

                BigDecimal SumAmountNew = new BigDecimal(plantingPolicyListNewSchema.getSumAmount());
                BigDecimal SumAmountOld = new BigDecimal(plantingPolicyListOldSchema.getSumAmount());
                BigDecimal dbSumAmount = SumAmountNew.subtract(SumAmountOld);
                dbSumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                plantingEndorChgDetailSchema.setChgSumAmount(dbSumAmount.doubleValue());

                BigDecimal SumPremiumNew = new BigDecimal(plantingPolicyListNewSchema.getSumPremium());
                BigDecimal SumPremiumOld = new BigDecimal(plantingPolicyListOldSchema.getSumPremium());
                BigDecimal dbSumPremium = SumPremiumNew.subtract(SumPremiumOld);
                dbSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                plantingEndorChgDetailSchema.setChgSumPremium(dbSumPremium.doubleValue());
            }
        }
    }
}
