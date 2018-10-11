package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPmainDto;
import com.sinosoft.agriprpall.api.policymanage.ProposalToPolicyApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BLEndorseCheckService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.util.ProposalCheck;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
/**
 * 普通批改保存前校验实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
public class BLEndorseCheckServiceImpl extends BaseServiceImpl implements BLEndorseCheckService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BLEndorseCheckServiceImpl.class);
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Override
    public void checkCPData(BLEndorseDto blEndorseDto) throws Exception {
        String strPolicyNo = blEndorseDto.getPrpCPmainDto().getPolicyNo();
        try {
            if (checkCPPremium(blEndorseDto.getPrpCPmainDto(), blEndorseDto.getPrpCPitemKindDtoList())) {
                LOGGER.error("保单批改时总保费与各险别保费之和一致性校验通过", strPolicyNo);
            } else {
                throw new DataVerifyException("保单" + strPolicyNo + "批改时总保费与各险别保费之和不一致！");
            }
        } catch (Exception e) {
            new ProposalCheck().insertErrorData("Endor", "批单保存校验", e.getMessage());
            throw e;
        }
    }
    /**
     * @param prpCPmainDto
     * @param prpCPitemKindDtoList
     * @return
     * @description: 校验CP表保费的总分一致性
     * @author: 李东东
     * @date: 2017/10/27 10:42
     */
    private boolean checkCPPremium(PrpCPmainDto prpCPmainDto, List<PrpCPitemKindDto> prpCPitemKindDtoList) {
        double mainPremium = 0.00;
        double itemkindPremium = 0.00;
        if (prpCPmainDto != null) {
            //main表保费
            mainPremium = prpCPmainDto.getSumPremium();
        }
        if (prpCPitemKindDtoList.size() > 0) {
            //itemkind表保费
            for (int i = 0; i < prpCPitemKindDtoList.size(); i++) {
                itemkindPremium += prpCPitemKindDtoList.get(i).getPremium();
            }
        }
        LOGGER.error("批单保费的总分一致性校验", "main表保费：" + mainPremium + "，itemkind表保费：" + itemkindPremium);
        if (Math.abs(mainPremium - itemkindPremium) > 0.01) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 保存前的校验
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 9:21 2017/11/7
     */
    @Override
    public void checkBeforeSave(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew= policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto= policyEndorseDto.getBlEndorseDto();
        String strPolicyNO = blEndorseDto.getPrpPheadDto().getPolicyNo();
        List<PrpPhead> prpPheadList = prpPheadDao.queryAllByCondition(strPolicyNO);
        if (prpPheadList.size() > 0 || prpPheadList.size() > 1) {
            throw new DataVerifyException( "校验失败！");
        }
        PrpPhead prpPhead = prpPheadDao.queryByEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
        if (prpPhead != null) {
            throw new DataVerifyException("该批单号已经存在，无法录入批单保存！");
        }
        Date cStartDate = blPolicyDtoNew.getPrpCmainDto().getStartDate();
        Date pStartDate = blEndorseDto.getPrpPmainDto().getStartDate();
        if (cStartDate.getTime()!=pStartDate.getTime()) {
            throw new DataVerifyException("该批单的起保日期和保单的起保日期不一致！");
        }

        String strRiskCode=blEndorseDto.getPrpPheadDto().getRiskCode();
        String strEndorType =blEndorseDto.getPrpPheadDto().getEndorType();
        String nyxSingleFarmerListFlag = utiPlatConfigRuleApi.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");
        if (!"".equals(strEndorType) && "29".equals(strEndorType) && !"3224".equals(strRiskCode)
                && !nyxMultipleFarmerListFlag.contains(strRiskCode)
                && !nyxSingleFarmerListFlag.contains(strRiskCode)
                ) {  // 农险二期新加入分户清单的险种,不走herd表,剔除掉它们
            //批单保存
            if (blEndorseDto.getHerdEndorChgDetailListDtoList().size() <= 0) {
                throw new DataVerifyException("分户信息没有变动，不能保存！");

            }
        }
        if (!"".equals(strEndorType) && "93".equals(strEndorType)
                && !nyxMultipleFarmerListFlag.contains(strRiskCode)
                && !nyxSingleFarmerListFlag.contains(strRiskCode)&&!"3141".equals(strRiskCode)
                ) {  // 农险二期新加入分户清单的险种,不走herd表,剔除掉它们
            //批单保存
            if (blEndorseDto.getPlantingEndorChgDetailDtoList().size() <= 0) {
                throw new DataVerifyException("分户信息没有变动，不能保存！");
            }
        }
    }
}
