package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.Planting31EndorChgDetailService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class Planting31EndorChgDetailServiceImpl extends BaseServiceImpl implements Planting31EndorChgDetailService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setPlanting31EndorChgDetail(Planting31EndorChgDetailDto planting31EndorChgDetailSchema, Planting31PolicyListDto planting31PolicyListOldSchema, Planting31PolicyListDto planting31PolicyListNewSchema) throws Exception {

        planting31EndorChgDetailSchema.setInusreListCode(planting31PolicyListOldSchema.getInusreListCode());
        planting31EndorChgDetailSchema.setfCode(planting31PolicyListOldSchema.getfCode());
        planting31EndorChgDetailSchema.setKindCode(planting31PolicyListOldSchema.getKindCode());
        planting31EndorChgDetailSchema.setItemCode(planting31PolicyListOldSchema.getItemCode());
        planting31EndorChgDetailSchema.setIndexCode(planting31PolicyListOldSchema.getIndexCode());
        planting31EndorChgDetailSchema.setPhone(planting31PolicyListOldSchema.getPhone());
        planting31EndorChgDetailSchema.setBank(planting31PolicyListOldSchema.getBank());
        planting31EndorChgDetailSchema.setZhiBuKa(planting31PolicyListOldSchema.getZhiBuKa());
        planting31EndorChgDetailSchema.setfName(planting31PolicyListOldSchema.getfName());
        planting31EndorChgDetailSchema.setfIdCard(planting31PolicyListOldSchema.getfIdCard());
        planting31EndorChgDetailSchema.setClassCode(planting31PolicyListOldSchema.getClassCode());
        planting31EndorChgDetailSchema.setRiskCode(planting31PolicyListOldSchema.getRiskCode());
        planting31EndorChgDetailSchema.setFareaCode(planting31PolicyListOldSchema.getfAreaCode());
        planting31EndorChgDetailSchema.setTaxArea(planting31PolicyListOldSchema.getTaxArea());
        planting31EndorChgDetailSchema.setInsureArea(planting31PolicyListOldSchema.getInsureArea());
        planting31EndorChgDetailSchema.setAmount(planting31PolicyListOldSchema.getAmount());
        planting31EndorChgDetailSchema.setRate(planting31PolicyListOldSchema.getRate());
        planting31EndorChgDetailSchema.setShortRateFlag(planting31PolicyListOldSchema.getShortRateFlag());
        planting31EndorChgDetailSchema.setShortRate(planting31PolicyListOldSchema.getShortRate());
        planting31EndorChgDetailSchema.setSumAmount(planting31PolicyListOldSchema.getSumAmount());
        planting31EndorChgDetailSchema.setSumPremium(planting31PolicyListOldSchema.getSumPremium());
        planting31EndorChgDetailSchema.setStartDate(planting31PolicyListOldSchema.getStartDate());
        planting31EndorChgDetailSchema.setEndDate(planting31PolicyListOldSchema.getEndDate());
        planting31EndorChgDetailSchema.setCalculateFlag(planting31PolicyListOldSchema.getCalculateFlag());
        planting31EndorChgDetailSchema.setOpCode(planting31PolicyListOldSchema.getOpCode());
        //planting31EndorChgDetailSchema.setOpTime(planting31PolicyListOldSchema.getOpTime());
        planting31EndorChgDetailSchema.setValidity(planting31PolicyListOldSchema.getValidity());
        planting31EndorChgDetailSchema.setRemark(planting31PolicyListOldSchema.getRemark());
        planting31EndorChgDetailSchema.setfPremium(planting31PolicyListOldSchema.getfPremium());
        planting31EndorChgDetailSchema.setTeamName(planting31PolicyListOldSchema.getTeamName());
        planting31EndorChgDetailSchema.setFieldSource(planting31PolicyListOldSchema.getFieldSource());
        planting31EndorChgDetailSchema.setCentralPremium(planting31PolicyListOldSchema.getCentralPremium());
        planting31EndorChgDetailSchema.setProvincePremium(planting31PolicyListOldSchema.getProvincePremium());
        planting31EndorChgDetailSchema.setCityPremium(planting31PolicyListOldSchema.getCityPremium());
        planting31EndorChgDetailSchema.setTownPremium(planting31PolicyListOldSchema.getTownPremium());
        planting31EndorChgDetailSchema.setOtherPremium(planting31PolicyListOldSchema.getOtherPremium());
        planting31EndorChgDetailSchema.setFlag(planting31PolicyListNewSchema.getFlag()); //标志用新的

//                planting31EndorChgDetailSchema.setChgInsureArea(planting31PolicyListOldSchema.getInsureArea());
//                planting31EndorChgDetailSchema.setChgSumAmount(planting31PolicyListOldSchema.getSumAmount());
//                planting31EndorChgDetailSchema.setChgSumPremium(planting31PolicyListOldSchema.getSumPremium());
        //变化量
        if (planting31PolicyListNewSchema.getFlag().length() > 0) {
            if (planting31EndorChgDetailSchema.getFlag().charAt(0) == 'I') {
                planting31EndorChgDetailSchema.setChgInsureArea(planting31EndorChgDetailSchema.getInsureArea());
                planting31EndorChgDetailSchema.setChgSumAmount(planting31EndorChgDetailSchema.getSumAmount());
                planting31EndorChgDetailSchema.setChgSumPremium(planting31EndorChgDetailSchema.getSumPremium());
            } else {
                BigDecimal InsureAreaNew = new BigDecimal(planting31PolicyListNewSchema.getInsureArea());
                BigDecimal InsureAreaOld = new BigDecimal(planting31PolicyListOldSchema.getInsureArea());
                BigDecimal dbInsureArea = InsureAreaNew.subtract(InsureAreaOld);
                dbInsureArea.setScale(3, BigDecimal.ROUND_HALF_UP);
                planting31EndorChgDetailSchema.setChgInsureArea(dbInsureArea.doubleValue());
                BigDecimal SumAmountNew = new BigDecimal(planting31PolicyListNewSchema.getSumAmount());
                System.err.println("new" + SumAmountNew);
                BigDecimal SumAmountOld = new BigDecimal(planting31PolicyListOldSchema.getSumAmount());
                System.err.println("old" + SumAmountOld);
                BigDecimal dbSumAmount = SumAmountNew.subtract(SumAmountOld);
                dbSumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                planting31EndorChgDetailSchema.setChgSumAmount(dbSumAmount.doubleValue());
                BigDecimal SumPremiumNew = new BigDecimal(planting31PolicyListNewSchema.getSumPremium());
                BigDecimal SumPremiumOld = new BigDecimal(planting31PolicyListOldSchema.getSumPremium());
                BigDecimal dbSumPremium = SumPremiumNew.subtract(SumPremiumOld);
                dbSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                planting31EndorChgDetailSchema.setChgSumPremium(dbSumPremium.doubleValue());
            }
        }

    }
}
