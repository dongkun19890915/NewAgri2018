package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpItemKindService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 普通批改itemkind表处理service实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
public class GeneratePrpItemKindServiceImpl extends BaseServiceImpl implements GeneratePrpItemKindService {

    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    /**
     * 批单itemKind表数据处理
     *
     * @param policyEndorseDto 批单大对象
     * @throws Exception
     * @author 王心洋
     * @time 2017-11-10
     */
    @Override
    public void updatePrpCitemKindNew(PolicyEndorseDto policyEndorseDto) throws Exception {

        ResponseQueryPolicyInfoDto blPolicyInfoDtoOld = policyEndorseDto.getBlPolicyInfoDtoNew();
        ResponseQueryPolicyInfoDto blPolicyDtoNew = policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto = policyEndorseDto.getBlEndorseDto();
        UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
        //定义变量
        
        //String plantingFarmerListFlag = blEndorseDto.getEndorseConditionDto().getPlantingFarmerListFlag();//中央政策险种植险标志
        //String nyxSingleFarmerListFlag = blEndorseDto.getEndorseConditionDto().getNyxSingleFarmerListFlag();
        //String nyxMultipleFarmerListFlag = blEndorseDto.getEndorseConditionDto().getNyxMultipleFarmerListFlag();
        utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK(AgriPrpallConstant.AGRI_PRPALL_SERVICE_SYSTEM_CODE_PRPALL, "PLNATING_FARMER_LIST_FLAG", 1);
        String plantingFarmerListFlag = utiPlatConfigRuleDto.getRule();
        //是否是单险别单标的险种
        utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK(AgriPrpallConstant.AGRI_PRPALL_SERVICE_SYSTEM_CODE_PRPALL, "NYX_SINGLE_FARMER_LIST_FLAG", 1);
        String nyxSingleFarmerListFlag = utiPlatConfigRuleDto.getRule();
        //险种是否是多险别/多标的险种
        utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK(AgriPrpallConstant.AGRI_PRPALL_SERVICE_SYSTEM_CODE_PRPALL, "NYX_MULTIPLE_FARMER_LIST_FLAG", 1);
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleDto.getRule();
        String inusreListCode = blEndorseDto.getEndorseConditionDto().getInusreListCode();
        utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK(AgriPrpallConstant.AGRI_PRPALL_SERVICE_SYSTEM_CODE_PRPALL, "BREEDING_FARMER_LIST_FLAG", 1);
        String breedingFarmerFlag = utiPlatConfigRuleDto.getRule();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        int index = 0;
        //标志位
        String ItemKindFlag1Flag = " ";
        String ItemKindFlag2Flag = "";   //Flag 标志第二位,记录1：主险2：附加险
        PrpCengageDto prpEngageDto = null;
        PrpCengageDto prpEngageDto_Name = null;

        String strClauseCode = "";
        String strFlag1 = "";

        //接收标的信息
        String strPolicyNo = blPolicyDtoNew.getPrpCmainDto().getPolicyNo();
        String strRiskCode = blPolicyDtoNew.getPrpCmainDto().getRiskCode();
        int StartHour = Integer.parseInt(ChgData.chgStrZero(blPolicyDtoNew.getPrpCmainDto().getStartHour() + ""));
        int EndHour;
        if(blPolicyDtoNew.getPrpCmainDto().getEndHour() == null ||"null".equals(blPolicyDtoNew.getPrpCmainDto().getEndHour()) || StringUtils.isBlank(blPolicyDtoNew.getPrpCmainDto().getEndHour()+"")){
        	EndHour = 0;
        }else{
        	EndHour = Integer.parseInt(ChgData.chgStrZero(blPolicyDtoNew.getPrpCmainDto().getEndHour() + ""));
        }
        String StartDate = blPolicyDtoNew.getPrpCmainDto().getStartDate().toString();
        String EndDate = blPolicyDtoNew.getPrpCmainDto().getEndDate().toString();
        DateTime dateTime = new DateTime(blEndorseDto.getPrpPheadDto().getValidDate());
        String ValidDate = dateTime.toString();//批改生效日期
        int ValidHour = blEndorseDto.getPrpPheadDto().getValidHour();//批改生效日期
        //主险信息
        /*String[] arrItemKindNoMain = blEndorseDto.getEndorseConditionDto().getItemKindNoMain();
        String[] arrFamilyNoMain = blEndorseDto.getEndorseConditionDto().getFamilyNoMain();
        // 分户名称取被保险人：农险被保险人只有一个
        String[] arrFamilyNameMain = blEndorseDto.getEndorseConditionDto().getInsuredInsuredName();
        String[] arrKindCodeMain = blEndorseDto.getEndorseConditionDto().getKindCodeMain();
        String[] arrKindNameMain = blEndorseDto.getEndorseConditionDto().getKindNameMain();
        String[] arrStartDateMain = blEndorseDto.getEndorseConditionDto().getStartDateMain();
        String[] arrEndDateMain = blEndorseDto.getEndorseConditionDto().getEndDateMain();
        String[] arrCurrencyMain = blEndorseDto.getEndorseConditionDto().getCurrencyMain();
        String[] arrShortRateFlagMain = blEndorseDto.getEndorseConditionDto().getShortRateFlagMain();
        String[] arrPremiumCalMethodMain = blEndorseDto.getEndorseConditionDto().getPremiumCalMethodMain();
        String[] arrForestUseMain = null;
        if (strRiskCode.equals("3149") || strRiskCode.equals("3176") || strRiskCode.equals("3105") || strRiskCode.equals("3191")
                || strRiskCode.equals("3177")) {
            arrForestUseMain = blEndorseDto.getEndorseConditionDto().getForestUseMain();
        }
        String[] arrShortRateMain = blEndorseDto.getEndorseConditionDto().getShortRateMain();
        String[] arrItemCodeMain = blEndorseDto.getEndorseConditionDto().getItemCodeMain();
        String[] arrItemDetailNameMain = blEndorseDto.getEndorseConditionDto().getItemDetailNameMain();
        String[] arrAddressNoMain = blEndorseDto.getEndorseConditionDto().getPrpItemKindAddressNoMain();
        String[] arrModeCodeMain = blEndorseDto.getEndorseConditionDto().getModeCodeMain();
        String[] arrModeNameMain = blEndorseDto.getEndorseConditionDto().getModeNameMain();
        String[] arrModelMain = blEndorseDto.getEndorseConditionDto().getModelMain();
        String[] arrCalculateFlagMain = blEndorseDto.getEndorseConditionDto().getCalculateFlagMain();//记入总保额标志
        String[] arrUnitAmountMain = blEndorseDto.getEndorseConditionDto().getUnitAmountMain();
        String[] arrQuantityMain = blEndorseDto.getEndorseConditionDto().getQuantityMain();
        String[] arrUnitMain = blEndorseDto.getEndorseConditionDto().getUnitMain();
        String[] arrAmountMain = blEndorseDto.getEndorseConditionDto().getAmountMain();
        String[] arrRateMain = blEndorseDto.getEndorseConditionDto().getRateMain();
        String[] arrAdjustRate = blEndorseDto.getEndorseConditionDto().getAdjustRateMain();    //农业险用于无赔款优待处理
        String[] arrPremiumMain = blEndorseDto.getEndorseConditionDto().getPremiumMain();
        String[] arrItemKindMain_Flag = blEndorseDto.getEndorseConditionDto().getItemKindMain_Flag();
        String[] arrBenMarkPremiumMain = blEndorseDto.getEndorseConditionDto().getBenMarkPremiumMain();//标准保费
        String[] arrDiscountMain = blEndorseDto.getEndorseConditionDto().getDisCountMain();//投保比例
        String[] arrCattleType = blEndorseDto.getEndorseConditionDto().getCattleType();//3221肉牛类型
        String[] arrDeductibleRateMain = blEndorseDto.getEndorseConditionDto().getDeductibleRateMain();//中央政策性农险的每次事故免赔率
        String[] arrTriggerPoint = blEndorseDto.getEndorseConditionDto().getTriggerPoint();//中央政策性农险的起赔点
        String[] arrTotalLossRatio = blEndorseDto.getEndorseConditionDto().getTotalLossRatio();//中央政策性农险的全损损失率
        String[] EqualFlagMain = blEndorseDto.getEndorseConditionDto().getEqualFlagMain();//中央政策性农险分户计算短期费率标志
        String[] medicalRateMain = blEndorseDto.getEndorseConditionDto().getMedicalRateMain();//风险调整系数3229用

        //附加险信息
        String[] arrItemKindNoSub = blEndorseDto.getEndorseConditionDto().getItemKindNoSub();
        String[] arrStartDateSub = blEndorseDto.getEndorseConditionDto().getStartDateSub();
        String[] arrEndDateSub = blEndorseDto.getEndorseConditionDto().getEndDateSub();
        String[] arrCurrencySub = blEndorseDto.getEndorseConditionDto().getCurrencySub();
        String[] arrShortRateFlagSub = blEndorseDto.getEndorseConditionDto().getShortRateFlagSub();
        String[] arrPremiumCalMethodSub = blEndorseDto.getEndorseConditionDto().getPremiumCalMethodSub();
        String[] arrForestUseSub = null;
        if (strRiskCode.equals("3176") || strRiskCode.equals("3105") || strRiskCode.equals("3191")) {
            arrForestUseSub = blEndorseDto.getEndorseConditionDto().getForestUseSub();
        }
        String[] arrDeductibleRateSub = null;
        String[] arrTriggerPointSub = null;
        String[] arrTotalLossRatioSub = null;
        if ((strRiskCode.equals("3141") || strRiskCode.equals("3173")) && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("42")) {
            arrDeductibleRateSub = blEndorseDto.getEndorseConditionDto().getDeductibleRateSub();
            arrTriggerPointSub = blEndorseDto.getEndorseConditionDto().getTriggerPointSub();
            arrTotalLossRatioSub = blEndorseDto.getEndorseConditionDto().getTotalLossRatioSub();
        }
        if (strRiskCode.equals("3232")) {
            arrDeductibleRateSub = blEndorseDto.getEndorseConditionDto().getDeductibleRateSub();
            arrTriggerPointSub = blEndorseDto.getEndorseConditionDto().getTriggerPointSub();
            arrTotalLossRatioSub = blEndorseDto.getEndorseConditionDto().getTotalLossRatioSub();
        }
        String[] arrShortRateSub = blEndorseDto.getEndorseConditionDto().getShortRateSub();
        String[] arrModeCodeSub = blEndorseDto.getEndorseConditionDto().getModeCodeSub();
        String[] arrModeNameSub = blEndorseDto.getEndorseConditionDto().getModeNameSub();
        String[] arrModelSub = blEndorseDto.getEndorseConditionDto().getModelSub();
        String[] arrCalculateFlagSub = blEndorseDto.getEndorseConditionDto().getCalculateFlagSub();//记入总保额标志
        String[] arrKindCodeSub = blEndorseDto.getEndorseConditionDto().getKindCodeSub();
        String[] arrKindNameSub = blEndorseDto.getEndorseConditionDto().getKindNameSub();
        String[] arrItemCodeSub = blEndorseDto.getEndorseConditionDto().getItemCodeSub();
        //需要把附加险的标的项目保存
        String[] arrUnitAmountSub = blEndorseDto.getEndorseConditionDto().getUnitAmountSub();
        String[] arrQuantitySub = blEndorseDto.getEndorseConditionDto().getQuantitySub();
        String[] arrItemDetailNameSub = blEndorseDto.getEndorseConditionDto().getItemDetailNameSub();
        String[] arrAddressNoSub = blEndorseDto.getEndorseConditionDto().getPrpItemKindAddressNoSub();
        String[] arrAmountSub = blEndorseDto.getEndorseConditionDto().getAmountSub();
        String[] arrRateSub = blEndorseDto.getEndorseConditionDto().getRateSub();
        String[] arrPremiumSub = blEndorseDto.getEndorseConditionDto().getPremiumSub();
        String[] arrItemKindSub_Flag = blEndorseDto.getEndorseConditionDto().getItemKindSub_Flag();
        String[] arrBenMarkPremiumSub = blEndorseDto.getEndorseConditionDto().getBenMarkPremiumSub();//标准保费
        String[] arrDiscountSub = blEndorseDto.getEndorseConditionDto().getDisCountSub();//投保比例
        //增加附加险 分户号的保存
        String[] arrFamilyNoSub = blEndorseDto.getEndorseConditionDto().getFamilyNoSub();
        //分户名称取被保险人：农险被保险人只有一个
        String[] arrFamilyNameSub = blEndorseDto.getEndorseConditionDto().getInsuredInsuredName();
        String[] EqualFlagSub = blEndorseDto.getEndorseConditionDto().getEqualFlagSub();//中央政策性农险分户计算短期费率标志


        String[] arrSerialNoSubEngage = blEndorseDto.getEndorseConditionDto().getSerialNoSubEngage();
        String[] arrItemKindSub_Context = blEndorseDto.getEndorseConditionDto().getItemKindSub_Context();
        String[] arrItemKindSubEngage_Flag = blEndorseDto.getEndorseConditionDto().getItemKindSubEngage_Flag();
*/

        //农业附加险信息
        PrpCitemKindAgriDto prpitemKindAgriDto = null;
        String agriStartDateMain = blEndorseDto.getEndorseConditionDto().getAgriStartDate();//草莓种植时间
        String agriEndDateMain = blEndorseDto.getEndorseConditionDto().getAgriEndDate();

        /*String UnitOutputMain[] = blEndorseDto.getEndorseConditionDto().getAgriUnitOutputMain();//单位产量
        String UnitCostMain[] = blEndorseDto.getEndorseConditionDto().getAgriUnitCostMain();   //单位成本
        String ProportionMain[] = blEndorseDto.getEndorseConditionDto().getAgriProportionMain();//
        String DiscountTypeMain[] = blEndorseDto.getEndorseConditionDto().getDisCountMainType();//折扣
        String DepreciationRateMain[] = blEndorseDto.getEndorseConditionDto().getAgriDepreciationRateMain();//折旧率
        String UnitAmountMain[] = blEndorseDto.getEndorseConditionDto().getAgriUnitAmountMain();//单位保险金额
        String GrossQuantityMain[] = blEndorseDto.getEndorseConditionDto().getAgriGrossQuantityMain();//种养总量
        String InsureAreaMain[] = blEndorseDto.getEndorseConditionDto().getAgriInsureAreaMain();//每株烟草有效叶片基数
        String agriStyleMain[] = blEndorseDto.getEndorseConditionDto().getAgriStyleMain();//桑蚕张种规格
        String agriTimesAmountMain[] = blEndorseDto.getEndorseConditionDto().getAgriTimesAmountMain();//中央政策性种植险借助本字段存放约定单价

        //农业附加险信息
        String UnitOutputSub[] = blEndorseDto.getEndorseConditionDto().getAgriUnitOutputSub();//单位产量
        String UnitCostSub[] = blEndorseDto.getEndorseConditionDto().getAgriUnitCostSub();   //单位成本
        String ProportionSub[] = blEndorseDto.getEndorseConditionDto().getAgriProportionSub();//折扣
        String DepreciationRateSub[] = blEndorseDto.getEndorseConditionDto().getAgriDepreciationRateSub();//折旧率
        String DiscountTypeSub[] = blEndorseDto.getEndorseConditionDto().getDisCountSubType();//
        String UnitAmountSub[] = blEndorseDto.getEndorseConditionDto().getAgriUnitAmountSub();//单位保险金额
        String GrossQuantitySub[] = blEndorseDto.getEndorseConditionDto().getAgriGrossQuantitySub();//种养总量
        String InsureAreaSub[] = blEndorseDto.getEndorseConditionDto().getAgriInsureAreaSub();//每株烟草有效叶片基数
        String[] arrSubsidyRate = blEndorseDto.getEndorseConditionDto().getSubsidyRate();*/

        List<PrpCsubsidyDto> prpCsubsidyDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCsubsidyDtoList();
        List<PrpCitemKindDto> prpCitemKindDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCitemKindDtoList();

        PubTools pubTools = new PubTools();
        //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
        double subSidyRateTemp = 0;
        double selfRate = 1;
        for (int i = 1; i < prpCsubsidyDtoList.size(); i++) {
            subSidyRateTemp += prpCsubsidyDtoList.get(i).getSubsidyRate();//补贴比例之和
        }
        selfRate = (100 - subSidyRateTemp) / 100;
        //中央政策性种植险普通批单录入
        Date PValidDate = null;
        Date ValidDatenext = null;
        Double PShortRate = 0.00;
        BigDecimal PInsureArea = null;//分户投保面积
        BigDecimal PSumAmount = null;
        BigDecimal PSumPremium = null;
        BigDecimal PSumAmountOld = null;
        BigDecimal PSumPremiumOld = null;
        BigDecimal ChgPSumPremium = null;
        BigDecimal PRateNew = null;
        BigDecimal PRateOld = null;
        BigDecimal PFPremium = null;
        BigDecimal perPremium = null;
        Date PStartDate = null;//分户起始日期
        Date PEndDate = null;//分户终止日期
        PrpCsubsidyDto prpCsubsidyDto = new PrpCsubsidyDto();
        String SubsidyCode = "";
        String SubsidyRate = "";
        List<PrpCsubsidyDto> bLPrpCsubsidy = new ArrayList<>();
        DateTime validDateTime = new DateTime(blEndorseDto.getPrpPheadDto().getValidDate());
        PValidDate = new Date(dateTime.YEAR_TO_DAY,dateTime.MONTH_TO_DAY,dateTime.DAY_TO_DAY);//生效时间
        Date dd = new Date();
        bLPrpCsubsidy = blPolicyDtoNew.getPrpCsubsidyDtoList();
        if (null != plantingFarmerListFlag && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            //((BLPolicyDto) request.getAttribute("Policy")).getPlantingPolicyData(strPolicyNo);
//            InsureMainListDto insureMainListDto = insureMainListApi.queryByPK(blPolicyDtoNew.getPrpCmainAgriDto().getRelationListNo());
//            if (insureMainListDto != null) {
//                if(blPolicyDtoNew.getPlantingPolicyListDtoList() == null) {
//                    List<PlantingPolicyListDto> plantingPolicyListDtoList = plantingPolicyListApi.queryByInusreListCode(blPolicyDtoNew.getPrpCmainAgriDto().getRelationListNo());
//                if (plantingPolicyListDtoList == null || plantingPolicyListDtoList.size() == 0) {
//                	inusreListCode = blPolicyDtoNew.getPrpCmainAgriDto().getRelationListNo();
//                    plantingPolicyListDtoList = plantingPolicyListApi.queryPlantingPolicyListByInsureListCode(inusreListCode);
//                }
//                blPolicyDtoNew.setPlantingPolicyListDtoList(plantingPolicyListDtoList);
//                }
//            }
            ValidDatenext = new Date(pubTools.getNextDateFullDate(ValidDate, -1));
        }
        // 农险二期改造,有清单,取nyx表的值
        if ("3224".equals(strRiskCode) || (nyxSingleFarmerListFlag != null && nyxSingleFarmerListFlag.contains(strRiskCode))
                || (nyxMultipleFarmerListFlag != null && nyxMultipleFarmerListFlag.contains(strRiskCode))) {
            //((BLPolicyDto) request.getAttribute("Policy")).getNyxPolicyData(strPolicyNo);
//            List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
//            if (insureMainListDtoList != null && insureMainListDtoList.size() > 0
//                    && StringUtils.isNotEmpty(insureMainListDtoList.get(0).getInusreListCode())) {
//                List<NyxPolicyListDto> nyxPolicyListDtoList = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
//                blPolicyDtoNew.setNyxPolicyListDtoList(nyxPolicyListDtoList);
//            }
        }
        if ("3141".equals(strRiskCode)) {
//            //((BLPolicyDto) request.getAttribute("Policy")).getPlanting31PolicyData(strPolicyNo);
//            List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
//            if (insureMainListDtoList != null && insureMainListDtoList.size() > 0
//                    && StringUtils.isNotEmpty(insureMainListDtoList.get(0).getInusreListCode())) {
//                Map<String, String> map = new HashMap<>();
//                map.put("inusreListCode", insureMainListDtoList.get(0).getInusreListCode());
//                List<Planting31PolicyListDto> planting31PolicyListDto = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
//                blPolicyDtoNew.setPlanting31PolicyListDtoList(planting31PolicyListDto);
//            }
        }

        //中央政策性种植险普通批单录入
        //主险部分开始
        for (index = 1; index < prpCitemKindDtoList.size(); index++) {
            PrpCitemKindDto prpCitemKindDto = prpCitemKindDtoList.get(index);

            String amountmain3224 = prpCitemKindDto.getAmount().toString();
            /*prpCitemKindDto = new PrpCitemKindDto();
            blPolicyDtoNew.getPrpCitemKindDtoList().add(prpCitemKindDto);
            prpCitemKindDto.setPolicyNo(strPolicyNo);
            //农业附加险信息
            prpitemKindAgriDto = new PrpCitemKindAgriDto();
            blPolicyDtoNew.getPrpCitemKindAgriDtoList().add(prpitemKindAgriDto);
            prpitemKindAgriDto.setPolicyNo(strPolicyNo);

            ItemKindFlag2Flag = "1";
            if (arrItemKindMain_Flag[index].length() == 0) {
                ItemKindFlag1Flag = " ";
            } else {
                ItemKindFlag1Flag = arrItemKindMain_Flag[index].charAt(0) + "";
                if (ItemKindFlag1Flag.equals("D")) ItemKindFlag1Flag = "B"; //退保,置B
            }
            prpCitemKindDto.setRiskCode(strRiskCode);
            prpCitemKindDto.setItemKindNo(index);*/

            /*prpCitemKindDto.setFamilyNo(Integer.parseInt(arrFamilyNoMain[index]));
            prpCitemKindDto.setFamilyName(arrFamilyNameMain[0]);
            prpCitemKindDto.setKindCode(prpCitemKindDto.getKindCode());
            prpCitemKindDto.setKindName(arrKindNameMain[index]);
            prpCitemKindDto.setStartDate(new java.util.Date(arrStartDateMain[index]));
            prpCitemKindDto.setEndDate(new java.util.Date(arrEndDateMain[index]));
            prpCitemKindDto.setCurrency(arrCurrencyMain[index]);
            prpCitemKindDto.setShortRateFlag(prpCitemKindDto.getShortRateFlag());
            prpCitemKindDto.setPremiumCalMethod(arrPremiumCalMethodMain[index]);
            if (strRiskCode.equals("3149") || strRiskCode.equals("3176") || strRiskCode.equals("3105") || strRiskCode.equals("3191") || strRiskCode.equals("3177")) {
                prpCitemKindDto.setForestUse(arrForestUseMain[index]);
            }
            prpCitemKindDto.setShortRate(Double.parseDouble(ChgData.chgStrZero(arrShortRateMain[index])));
            prpCitemKindDto.setItemCode(prpCitemKindDto.getItemCode());
            prpCitemKindDto.setItemDetailName(arrItemDetailNameMain[index]);
            prpCitemKindDto.setAddressNo(Integer.parseInt(ChgData.chgStrZero(arrAddressNoMain[index])));
            prpCitemKindDto.setModeCode(arrModeCodeMain[index]);
            prpCitemKindDto.setModeName(arrModeNameMain[index]);
            if (arrModelMain != null) {
                prpCitemKindDto.setModel(arrModelMain[index]);
            }
            prpCitemKindDto.setUnitAmount(Double.parseDouble(ChgData.chgStrZero(arrUnitAmountMain[index])));
            prpCitemKindDto.setQuantity(Double.parseDouble(ChgData.chgStrZero(arrQuantityMain[index])));
            prpCitemKindDto.setUnit(arrUnitMain[index]);
            prpCitemKindDto.setAmount(Double.parseDouble(ChgData.chgStrZero(arrAmountMain[index])));*/
            prpCitemKindDto.setDiscount(0.00);
            // 湖北3229生猪价格保险,页面没有录入费率,这里用保费保额计算出费率存入数据库
            if (strRiskCode.equals("3229") && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("42")) {
                Double rate = prpCitemKindDto.getPremium() / prpCitemKindDto.getAmount() * 100;
                prpCitemKindDto.setRate(rate);
            }/* else {
                prpCitemKindDto.setRate(Double.parseDouble(prpCitemKindDto.getRate()));
            }*/
            /*prpCitemKindDto.setAdjustRate(Double.parseDouble(ChgData.chgStrZero(arrAdjustRate[index])));   //农险用来存储无赔款优待金额
            prpCitemKindDto.setPremium(Double.parseDouble(ChgData.chgStrZero(arrPremiumMain[index])));
            prpCitemKindDto.setBasePremium(Double.parseDouble(ChgData.chgStrZero(arrPremiumMain[index])));//BasePremium与Premium相同
            prpCitemKindDto.setBenchmarkPremium(Double.parseDouble(ChgData.chgStrZero(arrBenMarkPremiumMain[index])));
            ;
            prpCitemKindDto.setDiscount(Double.parseDouble(ChgData.chgStrZero(arrDiscountMain[index])));
            prpCitemKindDto.setFlag(ItemKindFlag1Flag + ItemKindFlag2Flag + "        "); //不能去掉空格

            prpCitemKindDto.setCalculateFlag(arrCalculateFlagMain[index]); //主险记入保额
            prpCitemKindDto.setStartHour(StartHour);  //起保小时为0 hardcode
            prpCitemKindDto.setEndHour(EndHour); //终保小时为24 hardcode
            if (arrCattleType != null) {
                prpCitemKindDto.setCattleType(arrCattleType[index]);
            }
            if (arrDeductibleRateMain != null) {
                prpCitemKindDto.setDeductibleRate(Double.parseDouble(ChgData.chgStrZero(arrDeductibleRateMain[index])));
            }
            if (arrTriggerPoint != null) {
                prpCitemKindDto.setTriggerPoint(Double.parseDouble(ChgData.chgStrZero(arrTriggerPoint[index])));
            }
            if (arrTotalLossRatio != null) {
                prpCitemKindDto.setTotalLossRatio(Double.parseDouble(ChgData.chgStrZero(arrTotalLossRatio[index])));
            }
            if (medicalRateMain != null) {
                prpCitemKindDto.setMedicalRate(Double.parseDouble(ChgData.chgStrZero(medicalRateMain[index])));
            }*/
//农业附加险信息
            /*prpitemKindAgriDto.setProportion(Double.parseDouble(ProportionMain[index]));
            prpitemKindAgriDto.setRiskCode(strRiskCode);
            prpitemKindAgriDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
            prpitemKindAgriDto.setDepreciationRate(Double.parseDouble(DepreciationRateMain[index]));
            prpitemKindAgriDto.setGrossQuantity(Double.parseDouble(GrossQuantityMain[index]));
            if (InsureAreaMain != null) {
                prpitemKindAgriDto.setInsureArea(Double.parseDouble(InsureAreaMain[index]));
            }
            if (agriStyleMain != null) {
                prpitemKindAgriDto.setRemark(agriStyleMain[index]);
            }
            prpitemKindAgriDto.setUnitAmount(Double.parseDouble(UnitAmountMain[index]));
            prpitemKindAgriDto.setUnitCost(Double.parseDouble(UnitCostMain[index]));
            prpitemKindAgriDto.setUnitOutput(Double.parseDouble(UnitOutputMain[index]));
            prpitemKindAgriDto.setKindCode(prpCitemKindDto.getKindCode());
            prpitemKindAgriDto.setDiscountType(DiscountTypeMain[index]);
            //因为农业附加险信息和itemKind信息是一一对应的关系。flag用itemkind的flag
            prpitemKindAgriDto.setFlag(prpCitemKindDto.getFlag());
            prpitemKindAgriDto.setStratDate(new java.util.Date(agriStartDateMain));
            prpitemKindAgriDto.setEndDate(new java.util.Date(agriEndDateMain));
            if (agriTimesAmountMain != null) {
                prpitemKindAgriDto.setTimesAmount(Double.parseDouble(agriTimesAmountMain[index]));
            }*/

            //种植险普通批单录入
            if (null != plantingFarmerListFlag && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
                if (StringUtils.isNotEmpty(inusreListCode)
                        && StringUtils.isNotEmpty(prpCitemKindDto.getEqualFlag())) {
                    for (int i = 0; i < blPolicyDtoNew.getPlantingPolicyListDtoList().size(); i++) {
                        if (prpCitemKindDto.getKindCode().equals(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getKindCode())) {
                            if ("1".equals(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getValidity())) {
                                PStartDate = new Date(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getStartDate().toString());
                                PEndDate = new Date(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getEndDate().toString());
                                PRateOld = new BigDecimal(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getRate());
                                PInsureArea = new BigDecimal(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getInsureArea());
                                PSumPremiumOld = new BigDecimal(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getSumPremium());
                                PSumAmountOld = new BigDecimal(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getSumAmount());
                                PSumAmount = PInsureArea.multiply(new BigDecimal(prpCitemKindDto.getUnitAmount())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                PRateNew = new BigDecimal(prpCitemKindDto.getRate());

                                if ("3".equals(prpCitemKindDto.getShortRateFlag())) {
                                    PShortRate = 100.0000;
                                } else {
                                    if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                        PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                    } else {
                                        if ("large".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag())
                                                    - pubTools.getShortRate(strRiskCode, PStartDate, StartHour, ValidDatenext, EndHour, prpCitemKindDto.getShortRateFlag());
                                        } else if ("small".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PValidDate, ValidHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                        }
                                    }
                                }
                                }
                                if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                    PSumPremium = new BigDecimal(blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).getSumPremium());
                                } else {
                                    // 3149/3177是费率千分制,特殊处理
                                    if ("3149".equals(strRiskCode) || "3177".equals(strRiskCode)) {
                                        ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(100000));
                                    } else {
                                        ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(10000));
                                    }
                                    ChgPSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    PSumPremium = PSumPremiumOld.add(ChgPSumPremium).setScale(2, BigDecimal.ROUND_HALF_UP);
                                }
                                PFPremium = PSumPremium.multiply(new BigDecimal(selfRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setRate(PRateNew.doubleValue());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setFlag(prpCitemKindDto.getFlag());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setAmount(prpCitemKindDto.getUnitAmount());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setShortRate(PShortRate);
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setShortRateFlag(prpCitemKindDto.getShortRateFlag());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setSumAmount(PSumAmount.doubleValue());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setSumPremium(PSumPremium.doubleValue());
                                blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setfPremium(PFPremium.doubleValue());
                                BigDecimal govPremiumMain = new BigDecimal(0);
                                for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                    prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                    SubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                    SubsidyRate = prpCsubsidyDto.getSubsidyRate() + "";
                                    if (j == bLPrpCsubsidy.size() - 1) {
                                        perPremium = PSumPremium.subtract(PFPremium).subtract(govPremiumMain);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    } else {
                                        perPremium = PSumPremium.multiply(new BigDecimal(SubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        govPremiumMain = govPremiumMain.add(perPremium);
                                        govPremiumMain.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    }
                                    if ("03".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setCentralPremium(perPremium.doubleValue());
                                    } else if ("04".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setProvincePremium(perPremium.doubleValue());
                                    } else if ("05".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setCityPremium(perPremium.doubleValue());
                                    } else if ("07".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setTownPremium(perPremium.doubleValue());
                                    } else if ("06".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlantingPolicyListDtoList().get(i).setOtherPremium(perPremium.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                }
            if ("3141".equals(strRiskCode) ||"3140".equals(strRiskCode)) {
                if (null != inusreListCode && !"".equals(inusreListCode)
                        && null != prpCitemKindDto.getEqualFlag() && !"".equals(prpCitemKindDto.getEqualFlag())) {
                    for (int i = 0; i < blPolicyDtoNew.getPlanting31PolicyListDtoList().size(); i++) {
                        if (prpCitemKindDto.getKindCode().equals(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getKindCode())
                                && prpCitemKindDto.getItemCode().equals(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getItemCode())) {
                            if ("1".equals(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getValidity())) {
                                PStartDate = new Date(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getStartDate().toString());
                                PEndDate = new Date(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getEndDate().toString());
                                PRateOld = new BigDecimal(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getRate());
                                PInsureArea = new BigDecimal(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getInsureArea());
                                PSumPremiumOld = new BigDecimal(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getSumPremium());
                                PSumAmountOld = new BigDecimal(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getSumAmount());
                                PSumAmount = PInsureArea.multiply(new BigDecimal(prpCitemKindDto.getUnitAmount())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                PRateNew = new BigDecimal(prpCitemKindDto.getRate());
                                try {
                                    if ("3".equals(prpCitemKindDto.getShortRateFlag())) {
                                        PShortRate = 100.0000;
                                    } else {
                                        if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                        } else {
                                            if ("large".equals(prpCitemKindDto.getEqualFlag())) {
                                                PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag())
                                                        - pubTools.getShortRate(strRiskCode, PStartDate, StartHour, ValidDatenext, EndHour, prpCitemKindDto.getShortRateFlag());
                                            } else if ("small".equals(prpCitemKindDto.getEqualFlag())) {
                                                PShortRate = pubTools.getShortRate(strRiskCode, PValidDate, ValidHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                    PSumPremium = new BigDecimal(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).getSumPremium());
                                } else {
                                    // 3149/3177是费率千分制,特殊处理
                                    ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(10000));
                                    ChgPSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    PSumPremium = PSumPremiumOld.add(ChgPSumPremium).setScale(2, BigDecimal.ROUND_HALF_UP);
                                }
                                System.err.println("selfRate3141:" + selfRate);
                                System.err.println("PSumPremium:" + PSumPremium);
                                PFPremium = PSumPremium.multiply(new BigDecimal(selfRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setRate(PRateNew.doubleValue());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setFlag(prpCitemKindDto.getFlag());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setAmount(prpCitemKindDto.getUnitAmount());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setShortRate(PShortRate);
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setShortRateFlag(prpCitemKindDto.getShortRateFlag());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setSumAmount(PSumAmount.doubleValue());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setSumPremium(PSumPremium.doubleValue());
                                blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setfPremium(PFPremium.doubleValue());
                                BigDecimal govPremiumMain = new BigDecimal(0);
                                for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                    prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                    SubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                    SubsidyRate = prpCsubsidyDto.getSubsidyRate() + "";
                                    if (j == bLPrpCsubsidy.size() - 1) {
                                        perPremium = PSumPremium.subtract(PFPremium).subtract(govPremiumMain);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    } else {
                                        perPremium = PSumPremium.multiply(new BigDecimal(SubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        govPremiumMain = govPremiumMain.add(perPremium);
                                        govPremiumMain.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    }
                                    if ("03".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setCentralPremium(perPremium.doubleValue());
                                    } else if ("04".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setProvincePremium(perPremium.doubleValue());
                                    } else if ("05".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setCityPremium(perPremium.doubleValue());
                                    } else if ("07".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setTownPremium(perPremium.doubleValue());
                                    } else if ("06".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i).setOtherPremium(perPremium.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ("3224".equals(strRiskCode)) {
                if (null != inusreListCode && !"".equals(inusreListCode)
                        && null != prpCitemKindDto.getEqualFlag() && !"".equals(prpCitemKindDto.getEqualFlag())) {
                    for (int i = 0; i < blPolicyDtoNew.getNyxPolicyListDtoList().size(); i++) {
                        if (prpCitemKindDto.getKindCode().equals(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getKindCode())) {
                            if ("1".equals(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getValidity())) {
                                PStartDate = new Date(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getStartDate().toString());
                                PEndDate = new Date(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getEndDate().toString());
                                PRateOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getRate());
                                PInsureArea = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getAreaNumber());
                                PSumPremiumOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumPremium());
                                PSumAmountOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumAmount());
                                PSumAmount = PInsureArea.multiply(new BigDecimal(ChgData.chgStrZero(amountmain3224))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                PRateNew = new BigDecimal(prpCitemKindDto.getRate());
                                try {
                                    if ("3".equals(prpCitemKindDto.getShortRateFlag())) {
                                        PShortRate = 100.0000;
                                    } else {
                                        if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                        } else {
                                            if ("large".equals(prpCitemKindDto.getEqualFlag())) {
                                                PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag())
                                                        - pubTools.getShortRate(strRiskCode, PStartDate, StartHour, ValidDatenext, EndHour, prpCitemKindDto.getShortRateFlag());
                                            } else if ("small".equals(prpCitemKindDto.getEqualFlag())) {
                                                PShortRate = pubTools.getShortRate(strRiskCode, PValidDate, ValidHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                    PSumPremium = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumPremium());
                                } else {
                                    //TODO
                                    System.err.println("PShortRate:" + PShortRate);
                                    System.err.println("PRateNew:" + PRateNew);
                                    System.err.println("PSumAmount:" + PSumAmount);
                                    System.err.println("PSumAmountOld:" + PSumAmountOld);
                                    System.err.println("PRateOld:" + PRateOld);
                                    ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(10000));
                                    System.err.println("ChgPSumPremium:" + ChgPSumPremium);
                                    ChgPSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    PSumPremium = PSumPremiumOld.add(ChgPSumPremium).setScale(2, BigDecimal.ROUND_HALF_UP);
                                }
                                PFPremium = PSumPremium.multiply(new BigDecimal(selfRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setRate(PRateNew.doubleValue());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setFlag(prpCitemKindDto.getFlag());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setAmount(Double.parseDouble(ChgData.chgStrZero(amountmain3224)));
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setShortRate(PShortRate);
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setShortRateFlag(prpCitemKindDto.getShortRateFlag());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setSumAmount(PSumAmount.doubleValue());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setSumPremium(PSumPremium.doubleValue());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setfPremium(PFPremium.doubleValue());
                                System.err.println("PSumAmount:" + PSumAmount);
                                System.err.println("PSumPremium:" + PSumPremium);
                                System.err.println("PFPremium:" + PFPremium);
                                BigDecimal govPremiumMain = new BigDecimal(0);
                                for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                    prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                    SubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                    SubsidyRate = prpCsubsidyDto.getSubsidyRate() + "";
                                    if (j == bLPrpCsubsidy.size() - 1) {
                                        perPremium = PSumPremium.subtract(PFPremium).subtract(govPremiumMain);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    } else {
                                        perPremium = PSumPremium.multiply(new BigDecimal(SubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        govPremiumMain = govPremiumMain.add(perPremium);
                                        govPremiumMain.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    }
                                    //TODO 注释
                                    /**
                                     *
                                     */
                                    if ("03".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setCentralPremium(perPremium.doubleValue());
                                    } else if ("04".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setProvincePremium(perPremium.doubleValue());
                                    } else if ("05".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setCityPremium(perPremium.doubleValue());
                                    } else if ("07".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setTownPremium(perPremium.doubleValue());
                                    } else if ("06".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setOtherPremium(perPremium.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // 农险二期改造加
            if ((nyxSingleFarmerListFlag != null && nyxSingleFarmerListFlag.contains(strRiskCode))
                    || (nyxMultipleFarmerListFlag != null && nyxMultipleFarmerListFlag.contains(strRiskCode))) {
                inusreListCode = blEndorseDto.getEndorseConditionDto().getInsuranceCode();
                if (StringUtils.isNotEmpty(inusreListCode)
                        && StringUtils.isNotEmpty(prpCitemKindDto.getEqualFlag())) {
                    for (int i = 0; i < blPolicyDtoNew.getNyxPolicyListDtoList().size(); i++) {
                        if (prpCitemKindDto.getKindCode().equals(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getKindCode())
                                && prpCitemKindDto.getItemCode().equals(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getItemCode())) {
                            if ("1".equals(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getValidity())) {
                                PStartDate = new Date(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getStartDate().toString());
                                PEndDate = new Date(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getEndDate().toString());
                                PRateOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getRate());
                                PInsureArea = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getAreaNumber());
                                PSumPremiumOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumPremium());
                                PSumAmountOld = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumAmount());
                                PRateNew = new BigDecimal(prpCitemKindDto.getRate());
                                if (strRiskCode.equals("3229") && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("34")) {
                                    String rate1 = blEndorseDto.getEndorseConditionDto().getAgriInsureAreaMain()[index];
                                    String rate2 = blEndorseDto.getEndorseConditionDto().getAgriTimesAmountMain()[index];
                                    String[] itemCodeMain = blEndorseDto.getEndorseConditionDto().getItemCodeMain();
                                    BigDecimal bg = new BigDecimal("0");
                                    if (itemCodeMain[index].equals("b140"))
                                        bg = new BigDecimal("6.0");
                                    else if (itemCodeMain[index].equals("b150"))
                                        bg = new BigDecimal("7.2");
                                    PSumAmount = bg.multiply(PInsureArea).multiply(new BigDecimal(ChgData.chgStrZero(rate1)))
                                            .multiply(new BigDecimal(ChgData.chgStrZero(rate2))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                } else if (strRiskCode.equals("3229") && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("42")) {
                                    String unitAmount = blEndorseDto.getEndorseConditionDto().getAgriUnitAmountMain()[index];
                                    PSumAmount = new BigDecimal(ChgData.chgStrZero(unitAmount)).multiply(PInsureArea);
                                } else {
                                    PSumAmount = PInsureArea.multiply(new BigDecimal(ChgData.chgStrZero(amountmain3224))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                }
                                if ("3".equals(prpCitemKindDto.getShortRateFlag())) {
                                    PShortRate = 100.0000;
                                } else {
                                    if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                        PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                    } else {
                                        if ("large".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PStartDate, StartHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag())
                                                    - pubTools.getShortRate(strRiskCode, PStartDate, StartHour, ValidDatenext, EndHour, prpCitemKindDto.getShortRateFlag());
                                        } else if ("small".equals(prpCitemKindDto.getEqualFlag())) {
                                            PShortRate = pubTools.getShortRate(strRiskCode, PValidDate, ValidHour, PEndDate, EndHour, prpCitemKindDto.getShortRateFlag());
                                        }
                                    }
                                }
                                if ("same".equals(prpCitemKindDto.getEqualFlag())) {
                                    PSumPremium = new BigDecimal(blPolicyDtoNew.getNyxPolicyListDtoList().get(i).getSumPremium());
                                } else {
                                    System.err.println("PShortRate:" + PShortRate);
                                    System.err.println("PRateNew:" + PRateNew);
                                    System.err.println("PSumAmount:" + PSumAmount);
                                    System.err.println("PSumAmountOld:" + PSumAmountOld);
                                    System.err.println("PRateOld:" + PRateOld);
                                    if (strRiskCode.equals("3229") && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("42")) {
                                        String adjustRate = blEndorseDto.getEndorseConditionDto().getMedicalRateMain()[index];
                                        String unitPremium = blEndorseDto.getEndorseConditionDto().getAgriUnitCostMain()[index];
                                        ChgPSumPremium = new BigDecimal(ChgData.chgStrZero(adjustRate)).multiply(PInsureArea).multiply(new BigDecimal(ChgData.chgStrZero(unitPremium))).subtract(PSumPremiumOld);
                                    } else if (strRiskCode.equals("3196") || strRiskCode.equals("3192")) {
                                        String unitPremium = blEndorseDto.getEndorseConditionDto().getUnitPremiumMain()[index];
                                        System.err.println("unitPremium31963192--------" + unitPremium);
                                        ChgPSumPremium = new BigDecimal(ChgData.chgStrZero(unitPremium)).multiply(PInsureArea).subtract(PSumPremiumOld);
                                    } else if (strRiskCode.equals("3105")) {
                                        ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(100000));
                                    } else {
                                        ChgPSumPremium = ((PSumAmount.multiply(PRateNew)).subtract(PSumAmountOld.multiply(PRateOld))).multiply(new BigDecimal(PShortRate)).divide(new BigDecimal(10000));
                                    }
                                    System.err.println("ChgPSumPremium:" + ChgPSumPremium);
                                    ChgPSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    PSumPremium = PSumPremiumOld.add(ChgPSumPremium).setScale(2, BigDecimal.ROUND_HALF_UP);
                                }
                                PFPremium = PSumPremium.multiply(new BigDecimal(selfRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setRate(PRateNew.doubleValue());
                                // 3229湖北:费率是由保额和保费倒推的
                                if (strRiskCode.equals("3229") && blPolicyDtoNew.getPrpCmainDto().getComCode().startsWith("42")) {
                                    double tmpRate = PSumPremium.doubleValue() / PSumAmount.doubleValue() * 100.00;
                                    blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setRate(tmpRate);
                                }
                                if (strRiskCode.equals("3196") || strRiskCode.equals("3192")) {
                                    double tmpRate = PSumPremium.doubleValue() / PSumAmount.doubleValue() * 100.00;
                                    blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setRate(tmpRate);
                                }
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setFlag(prpCitemKindDto.getFlag());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setAmount(Double.parseDouble(ChgData.chgStrZero(amountmain3224)));
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setShortRate(PShortRate);
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setShortRateFlag(prpCitemKindDto.getShortRateFlag());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setSumAmount(PSumAmount.doubleValue());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setSumPremium(PSumPremium.doubleValue());
                                blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setfPremium(PFPremium.doubleValue());
                                System.err.println("PSumAmount:" + PSumAmount);
                                System.err.println("PSumPremium:" + PSumPremium);
                                System.err.println("PFPremium:" + PFPremium);
                                BigDecimal govPremiumMain = new BigDecimal(0);
                                for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                    prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                    SubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                    SubsidyRate = prpCsubsidyDto.getSubsidyRate() + "";
                                    if (j == bLPrpCsubsidy.size() - 1) {
                                        perPremium = PSumPremium.subtract(PFPremium).subtract(govPremiumMain);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    } else {
                                        perPremium = PSumPremium.multiply(new BigDecimal(SubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                        perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        govPremiumMain = govPremiumMain.add(perPremium);
                                        govPremiumMain.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    }
                                    if ("03".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setCentralPremium(perPremium.doubleValue());
                                    } else if ("04".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setProvincePremium(perPremium.doubleValue());
                                    } else if ("05".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setCityPremium(perPremium.doubleValue());
                                    } else if ("07".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setTownPremium(perPremium.doubleValue());
                                    } else if ("06".equals(SubsidyCode)) {
                                        blPolicyDtoNew.getNyxPolicyListDtoList().get(i).setOtherPremium(perPremium.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //分户信息的修改
        //当页面的中央政策养殖险标志为true时，此时需要更新养殖险的保单清单的分户信息
        if(null != breedingFarmerFlag&&breedingFarmerFlag.indexOf(strRiskCode)>-1){
            breedingFarmerFlag="true";
        }
        DecimalFormat format = new DecimalFormat("0.00");
        String BenMarkPremiumMainEqualFlag = blEndorseDto.getEndorseConditionDto().getBenMarkPremiumMainEqualFlag();
        String ChgUnitPremium = blEndorseDto.getEndorseConditionDto().getvChgUnitPremium();
        Double ShortRate = 0.00;
        Date DstartDate = null;//起始日期
        Date DendDate = null;//终止日期
        Date DvalidDate = null;//生效时间
        double singlePremiumOld = 0.00;//旧分户保费
        double singlePremiumNew = 0.00;//新分户保费
        double singleInsurePremium = 0.00;//农户自交保费。
        double vChgUnitPremium = 0.00;//保费变化量
        if (StringUtils.isNotEmpty(inusreListCode)
                && null != breedingFarmerFlag&&"true".equals(breedingFarmerFlag)
                && StringUtils.isNotEmpty(BenMarkPremiumMainEqualFlag) && !"3224".equals(strRiskCode)) {
            //((BLPolicyDto)request.getAttribute("Policy")).getHerdPolicyData(strPolicyNo);
            List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
            if (insureMainListDtoList != null && insureMainListDtoList.size() > 0
                    && StringUtils.isNotEmpty(insureMainListDtoList.get(0).getInusreListCode())) {
                List<HerdPolicyListDto> herdPolicyListDtoList = herdPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                blPolicyDtoNew.setHerdPolicyListDtoList(herdPolicyListDtoList);
            }
            DvalidDate = new Date(ValidDate);
            for (int i = 0; i < blPolicyDtoNew.getHerdPolicyListDtoList().size(); i++) {
                if ("1".equals(blPolicyDtoNew.getHerdPolicyListDtoList().get(i).getValidity())) {
                    DstartDate = new Date(sdf.format(blPolicyDtoNew.getHerdPolicyListDtoList().get(i).getStartDate()));
                    DendDate = new Date(sdf.format(blPolicyDtoNew.getHerdPolicyListDtoList().get(i).getEndDate()));
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setAmount(prpCitemKindDtoList.get(0).getUnitAmount());
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setRate(prpCitemKindDtoList.get(0).getRate());
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setShortRateFlag(prpCitemKindDtoList.get(0).getShortRateFlag());
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setSumAmount(prpCitemKindDtoList.get(0).getUnitAmount());
                    singlePremiumOld = blPolicyDtoNew.getHerdPolicyListDtoList().get(i).getSumPremium();
                    if ("Y".equals(BenMarkPremiumMainEqualFlag)) {
                        ShortRate = pubTools.getShortRate(strRiskCode, DstartDate, StartHour, DendDate, EndHour, prpCitemKindDtoList.get(0).getShortRateFlag());
                        singleInsurePremium = singlePremiumOld * selfRate;
                    } else {
                        ShortRate = pubTools.getShortRate(strRiskCode, DvalidDate, StartHour, DendDate, EndHour, prpCitemKindDtoList.get(0).getShortRateFlag());
                        //整单批改内计算保费变化量chgPremium逻辑如下 会给oldShortRate设置为1（ oldShortRate = 1 ;
                        // 旧短期费率系数不参加计算了,已经体现在了旧保额里），同时newDiscount，oldDiscount都为1，因此可以将此公式进行整理
                        //chgPremium = ( (newAmount - oldAmount) * newRate * newDiscount * newShortRate +
                        //     oldAmount * (newRate * newDiscount - oldRate * oldDiscount) * newShortRate ) *oldShortRate;
                        //变为 chgPremium = (newAmount  * newRate   -  oldAmount *oldRate) * newShortRate ;
                        //vChgUnitPremium = Double.parseDouble(ChgUnitPremium);
                        //singlePremiumNew = singlePremiumOld + vChgUnitPremium;
                        //singleInsurePremium = singlePremiumNew * selfRate;
                        //blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setSumPremium(singlePremiumNew);
                    }
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setShortRate(ShortRate);
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setInsurePremium(singleInsurePremium);
                    blPolicyDtoNew.getHerdPolicyListDtoList().get(i).setFlag("U");
                }
            }
        }
        //分户信息的修改

        //附加险/险附加条款的条款内容
        /*for (index = 1; index < arrSerialNoSubEngage.length; index++) {
            prpEngageDto_Name = new PrpCengageDto();
            blPolicyDtoNew.getPrpCengageDtoList().add(prpEngageDto_Name);
            prpEngageDto_Name.setPolicyNo(strPolicyNo);
            prpEngageDto = new PrpCengageDto();
            blPolicyDtoNew.getPrpCengageDtoList().add(prpEngageDto);
            prpEngageDto.setPolicyNo(strPolicyNo);
            //对Flag的处理
            if (arrItemKindSubEngage_Flag[index].trim().length() == 0)
                strFlag1 = "";
            else
                strFlag1 = arrItemKindSubEngage_Flag[index].substring(0, 1);

            if (arrItemKindNoSub[index].trim().length() == 1)
                strClauseCode = "F" + strRiskCode + arrKindCodeSub[index] + "0" + arrItemKindNoSub[index];
            else if (arrItemKindNoSub[index].trim().length() == 2)
                strClauseCode = "F" + strRiskCode + arrKindCodeSub[index] + arrItemKindNoSub[index];

            //名称
            prpEngageDto_Name.setRiskCode(strRiskCode);
            prpEngageDto_Name.setSerialNo(Integer.parseInt(ChgData.chgStrZero(arrSerialNoSubEngage[index])));
            prpEngageDto_Name.setLineNo(1);
            prpEngageDto_Name.setClauseCode(strClauseCode);
            prpEngageDto_Name.setClauses(arrKindNameSub[index]);
            prpEngageDto_Name.setTitleFlag("0");
            prpEngageDto_Name.setFlag(strFlag1);
            //内容
            prpEngageDto.setRiskCode(strRiskCode);
            prpEngageDto.setSerialNo(Integer.parseInt(ChgData.chgStrZero(arrSerialNoSubEngage[index])));
            prpEngageDto.setLineNo(2);
            prpEngageDto.setClauseCode(strClauseCode);
            prpEngageDto.setClauses(arrItemKindSub_Context[index]);
            prpEngageDto.setTitleFlag("1");
            prpEngageDto.setFlag(strFlag1);
        }*/
        //附加险部分结束
        //支持大客户修改
        String messType = (blEndorseDto.getEndorseConditionDto().getMessType() == null?"":blEndorseDto.getEndorseConditionDto().getMessType());
        Hashtable familyNoHash = new Hashtable();
        if (messType != null && messType.trim().length() > 0) {
            String familyNos = blEndorseDto.getEndorseConditionDto().getFamilyNos();
            if (familyNos == null) {
                familyNos = "";
            }
            String[] arrFamilyNo = StringGyUtils.split(familyNos, ",");
            for (int i = 0; i < arrFamilyNo.length; i++) {
                familyNoHash.put(arrFamilyNo[i], arrFamilyNo[i]);
            }
            List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = blPolicyDtoNew.getPrpCitemKindAgriDtoList();
            List<PrpCitemKindDto> prpCitemKindListTemp = new ArrayList<>();
            List<PrpCitemKindAgriDto> prpCitemKindAgriListTmp = new ArrayList<>();
            prpCitemKindListTemp = blPolicyInfoDtoOld.getPrpCitemKindDtoList();
            for (int i = 0; i < prpCitemKindListTemp.size(); i++) {
                PrpCitemKindDto prpCitemKindDto = prpCitemKindListTemp.get(i);
                if (StringUtils.isNotEmpty(prpCitemKindDto.getFamilyNo()+"") && familyNoHash !=null && familyNoHash.containsKey(prpCitemKindDto.getFamilyNo()+"") == false) {
                    prpCitemKindDtoList.add(prpCitemKindDto);
                    prpCitemKindAgriListTmp = blPolicyInfoDtoOld.getPrpCitemKindAgriDtoList();
                    for (int j = 0; j < prpCitemKindAgriListTmp.size(); j++) {
                        prpitemKindAgriDto = prpCitemKindAgriListTmp.get(j);
                        //险别、序号匹配
                        if (prpCitemKindDto.getKindCode() == prpitemKindAgriDto.getKindCode() && prpCitemKindDto.getItemKindNo() == prpitemKindAgriDto.getItemKindNo()) {
                            prpCitemKindAgriDtoList.add(prpitemKindAgriDto);
                        }
                    }
                }
            }
        }
    }
}