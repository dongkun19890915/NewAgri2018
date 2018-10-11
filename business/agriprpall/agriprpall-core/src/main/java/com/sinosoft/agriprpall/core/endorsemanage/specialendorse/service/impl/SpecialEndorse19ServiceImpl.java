package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.GeneratePtextApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePEndorseService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateTxnListService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.PlantingEndorChgDetailService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorse19Service;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCfeeDao;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.QueryPolicySpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfee;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.utility.string.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SpecialEndorse19ServiceImpl extends BaseServiceImpl implements SpecialEndorse19Service {
    @Autowired
    private PrpCfeeDao prpCfeeDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpDkindApi prpDkindApi;
    @Autowired
    private GeneratePtextApi generatePtextApi;
    @Autowired
    private GeneratePEndorseService generatePEndorse;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private PlantingEndorChgDetailService plantingEndorChgDetailService;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    GeneratePEndorseService generatePEndorseService;
    @Autowired
    GenerateTxnListService generateTxnListService;

    /**
     * 保单注销
     * @param blEndorseDto 批单大对象
     * @param endorseConditionDto 批改条件
     * @return PolicyEndorseDto 新旧保单、批单大对象
     * @throws Exception
     * @author 王保良
     * @time 2017-12-22
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto specialEndorse19(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto) throws Exception {
        //创建返回值对象
        PolicyEndorseDto policyEndorseDto = null;
        //创建批单数据对象，用于遍历传入集合
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PubTools pubTools = new PubTools();
        policyEndorseDto = new PolicyEndorseDto();
        String strMakeCom = blEndorseDto.getPrpPheadDto().getMakeCom();
        String strUserCode = blEndorseDto.getPrpPheadDto().getOperatorCode();
        String strPolicyNo = blEndorseDto.getPrpPheadDto().getPolicyNo(); //保单号
        Date strEndorDate = blEndorseDto.getPrpPheadDto().getEndorDate(); //批改日期
        Date strValidDate = blEndorseDto.getPrpPheadDto().getValidDate(); //批改生效日期
        int strValidHour = blEndorseDto.getPrpPheadDto().getValidHour(); //批改生效小时
        String strShortRateFlag = endorseConditionDto.getShortRateFlag();
        String strEndorType = endorseConditionDto.getEndorType(); //批改类型
        String strIrate = endorseConditionDto.getiRate(); //退保手续费比例
        String strPrpPheadAppliName = blEndorseDto.getPrpPheadDto().getAppliName();
        String strEndorseType1 = blEndorseDto.getPrpPheadDto().getEndorseType();//批改方式
        String strEndorseMessage = blEndorseDto.getPrpPheadDto().getEndorseMessage();//批改方式原因
        String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty("BREEDING_FARMER_LIST_FLAG");
        String planting31FarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_31_FARMER_LIST_FLAG");
//        String plantingFarmerListFlag = AgriPrpallConstant.PLNATING_FARMER_LIST_FLAG;//中央政策险种植险标志
//        String nyxSingleFarmerListFlag = AgriPrpallConstant.NYX_SINGLE_FARMER_LIST_FLAG;
//        String nyxMultipleFarmerListFlag = AgriPrpallConstant.NYX_MULTIPLE_FARMER_LIST_FLAG;
        String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_PLNATING_FARMER_LIST_FLAG);//中央政策险种植险标志
        String nyxSingleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_SINGLE_FARMER_LIST_FLAG);
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_MULTIPLE_FARMER_LIST_FLAG);
        //两个保单对象
        ResponseQueryPolicyInfoDto blPolicy;
        ResponseQueryPolicyInfoDto blPolicyOld;
        //批单对象
        BLEndorseDto blEndorse = new BLEndorseDto();

        HerdEndorHeadDto herdEndorHeadDto = new HerdEndorHeadDto();
        NyxEndorHeadDto nyxEndorHeadDto = new NyxEndorHeadDto();
        PlantingEndorHeadDto plantingEndorHeadDto = new PlantingEndorHeadDto();
        PrpCitemKindDto prpCitemKindDto = null;
        PrpCfeeDto prpCfeeDto = null;
        PrpCfeeDto prpCfeeDtoOld = null;
        PrpPheadDto prpPheadDto = new PrpPheadDto();
        PrpDkindDto prpDkindDto = new PrpDkindDto();
        ChgDate chgDate = new ChgDate();
        Hashtable feeHashtable = new Hashtable();
        String strCompensateNo = "";
        String strOthFlag = "";
        String strRiskCode = "";
        String strEndorseNo = "";
        String strKindCode = "";
        String strCurrency2 = "";
        String strCurrency1 = "";
        String strFlag1 = "";
        String strFlag = "";
        double dblAmount = 0;
        double dblAmount2 = 0;
        double dblAmount1 = 0;
        double dblPremium = 0;
        double dblPremium2 = 0;
        double dblPremium1 = 0;
        double dblExchangeRate2 = 0;
        double dblExchangeRate1 = 0;
        double dblSumPremium = 0;
        int index = 0;
        int intEndorseTimes = 0;
        int indexOld = 0;
        boolean isChangedFee = true; //货运险批改起运日期时，没有保费变化

        /**
         * 获取保单数据
         */
        /**blPolicy.getData(strPolicyNo);*/
        blPolicy = policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);
        blPolicyOld=policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);


        //获取清单主表对象 并放入保单大对象中
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
        blPolicy.setInsureMainListDtoList(insureMainListDtoList);
        //创建一个清单主表对象
        InsureMainListDto insureMainListDto;
        //获取保单号查询出来的保单大对象中的各个小表对象
        PrpCmainDto prpCmainDto = blPolicy.getPrpCmainDto();
        List<PrpCitemKindDto> prpCitemKindDtoList = blPolicy.getPrpCitemKindDtoList();
        List<PrpCfeeDto> prpCfeeDtoList;
        List<PrpCcoinsDto> prpCcoinsDtoList = blPolicy.getPrpCcoinsDtoList();
        List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList = blPolicy.getPrpCcoinsDetailDtoList();
        List<PlantingPolicyListDto> plantingPolicyListDtoList = new ArrayList<>();

        //31种植险清单表
        List<Planting31PolicyListDto> planting31PolicyListDtoList=null;
        //单险别单标的养殖险清单表
        List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
        //多险别多标的兼容种植险养殖险
        List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>();

        //获取险种用于判断走不同的逻辑
        strRiskCode = prpCmainDto.getRiskCode();

        if (insureMainListDtoList.size() > 0) {
            //养殖险保单清单最新数据表
            herdPolicyListDtoList = plantingPolicyListApi.queryHerdByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
            plantingPolicyListDtoList = plantingPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
            blPolicy.setPlantingPolicyListDtoList(plantingPolicyListDtoList);
            blPolicy.setHerdPolicyListDtoList(herdPolicyListDtoList);
        }
        if (("3141".equals(strRiskCode)) || ("3147".equals(strRiskCode))) {
            if (insureMainListDtoList.size() > 0) {
                Map<String,String> map=new HashMap<>();
                map.put("inusreListCode",insureMainListDtoList.get(0).getInusreListCode());
                planting31PolicyListDtoList = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
                blPolicy.setPlanting31PolicyListDtoList(planting31PolicyListDtoList);
            }
        }
        // 二期平台改造新加清单的险种,取nyxpolicy数据
        if (("3224".equals(strRiskCode)||"3134".equals(strRiskCode)) || nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)) {
            if (insureMainListDtoList.size() > 0) {
                nyxPolicyListDtoList = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
                blPolicy.setNyxPolicyListDtoList(nyxPolicyListDtoList);
            }
        }

        //获取批改次数
        intEndorseTimes = prpCmainDto.getEndorseTimes();

        /** 1、置Prp*main.OthFlag*/
//        -- prp*main othFlag其它标志字段：
//        --** [1] (0/1)新/续保标志
//                --** [2] (0/1)被续保标志(1:被续保)
//        --** [3] 退保标志--**    1:全单退保--**    2:满期退保--**    3:部分退保
//                --** [4] 注销(1:已注销)
//        --** [5] 遗失标志（1：已遗失）
//        --** [6] 有效标志--**1:终止合同--**2:中止保险合同 （车险）
//        --** [7] 是否转入收付费（N:不转）
//        --** [8] 是否统计（N:不统计）
//        --** [9] 询价单是否确认（0:未确认，1：确认）

        //保单注销（19）：OthFlag[4]=1
        if (strEndorType.equals(AgriPrpallConstant.EDITTYPE_WRITEOFF.trim())) {
            strOthFlag = prpCmainDto.getOthFlag();
            if (strOthFlag.length() >= 4) {
                strOthFlag = strOthFlag.substring(0, 3) + "1" + strOthFlag.substring(4);
            } else {
                strOthFlag = strOthFlag + Str.space(3 - strOthFlag.length()) + "1";
            }
            blPolicy.getPrpCmainDto().setOthFlag(strOthFlag);
        }

        /** 2.置prp*itemKind 的Flag*/
//        还没有置 只是放在了strFlag中,等第5步再放入flag中
//        --** [2] 位为主险/附加险标志--** 1:主险 2:附加险 3:其他
//                --** [3]-[4]位等于费率类型--**（RateTypeFlag）

        strFlag1 = "D";

        /**3、获取批单号：根据保单号生成批单号**/
        // 调用批单号生成接口
        strEndorseNo = billNoApi.getNos(AgriPrpallConstant.ENDORSRE_TABLE.trim(), strPolicyNo);

        /**4、批单头的赋值**/
        //其他信息在BLEndorse.generatePrpPhead()生成
        prpPheadDto.setEndorseNo(strEndorseNo);//批单号
        prpPheadDto.setPolicyNo(strPolicyNo);//保单号
        prpPheadDto.setMakeCom(strMakeCom);
        prpPheadDto.setCompensateNo(strCompensateNo);
        prpPheadDto.setEndorType(strEndorType); //批改类型
        prpPheadDto.setEndorDate(strEndorDate); //批改日期
        prpPheadDto.setValidDate(strValidDate); //生效日期
        prpPheadDto.setAppliName(strPrpPheadAppliName);
        prpPheadDto.setValidHour(strValidHour); //生效小时
        prpPheadDto.setOperatorCode(strUserCode);
        prpPheadDto.setInputDate(new SimpleDateFormat("yyyy-MM-dd").parse(chgDate.getCurrentTime("yyyy-MM-dd")));
        prpPheadDto.setInputHour(Integer.parseInt(chgDate.getCurrentTime("HH")));
        prpPheadDto.setEndorseType(strEndorseType1); //批改方式: 客户申请或是录入错误
        prpPheadDto.setValidCountDate(new SimpleDateFormat("yyyy-MM-dd").parse(("9999-12-31")));
        prpPheadDto.setEndorseMessage(strEndorseMessage); //批改信息
        if(intEndorseTimes==0){
            prpPheadDto.setEndorseTimes(intEndorseTimes);
        }else {
            prpPheadDto.setEndorseTimes(intEndorseTimes+1);
        }
        //将已经赋值的批单头信息放入批单大对象中
        blEndorse.setPrpPheadDto(prpPheadDto);

        /** 整单批改对分户信息的处理 */
        if (StringUtils.isNotEmpty(breedingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode) && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && !"3224".equals(strRiskCode)) {
            //如果有清单主表
            if (insureMainListDtoList.size() > 0) {

                List<HerdEndorHeadDto> herdEndorHeadDtoList = new ArrayList<>();

                //循环养殖险清单并初始化
                for (int i = 0; i < herdPolicyListDtoList.size(); i++) {
                    blPolicy.getHerdPolicyListDtoList().get(i).setSumAmount(0.00);
                    blPolicy.getHerdPolicyListDtoList().get(i).setSumPremium(0.00);
                    blPolicy.getHerdPolicyListDtoList().get(i).setInsureNumber(0);
                    blPolicy.getHerdPolicyListDtoList().get(i).setInsurePremium(0.00);
                    blPolicy.getHerdPolicyListDtoList().get(i).setEndDate(strValidDate);
                    //blPolicy.getBLherdPolicyListDtoList.get(i).setEndTime(strValidHour);
                    blPolicy.getHerdPolicyListDtoList().get(i).setValidity("0");
                    blPolicy.getHerdPolicyListDtoList().get(i).setFlag("D");
                }

                //养殖险（整单批改）批改头表 的赋值
                herdEndorHeadDtoList.add(herdEndorHeadDto);
                herdEndorHeadDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                herdEndorHeadDto.setEndorseNo(strEndorseNo);
                herdEndorHeadDto.setRiskCode(strRiskCode);
                herdEndorHeadDto.setPolicyNo(strPolicyNo);
                herdEndorHeadDto.setListFlag("0");
                herdEndorHeadDto.setEndorFlag(strEndorType);
                blEndorse.setHerdEndorHeadDto(herdEndorHeadDto);
            }
        }
//        for (index = 0; index < prpCitemKindDtoList.size(); index++) {
//            if(null!=plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode)>-1){
//                strKindCode = blPolicy.getPrpCitemKindDtoList().get(index).getKindCode();
//                if(insureMainListDtoList.size() > 0){
//                    for(int i = 0; i < blPolicy.getPlantingPolicyListDtoList().size(); i++){
//                        if("1".equals(blPolicy.getPlantingPolicyListDtoList().get(i).getValidity())){
//                            if(strKindCode.equals(blPolicy.getPlantingPolicyListDtoList().get(i).getKindCode())){
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setSumAmount(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setSumPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setCentralPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setProvincePremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setCityPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setTownPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setOtherPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setFPremium(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setInsureArea(0.0);
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setValidity("0");
//                                blPolicy.getPlantingPolicyListDtoList().get(i).setFlag("D");
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for(int i = 0; i < blPolicy.getHerdPolicyListDtoList().size(); i++){
//            blPolicy.getHerdPolicyListDtoList().get(i).setSumAmount(0.0);
//            blPolicy.getHerdPolicyListDtoList().get(i).setSumPremium(0.0);
//            blPolicy.getHerdPolicyListDtoList().get(i).setInsureNumber(0);
//            blPolicy.getHerdPolicyListDtoList().get(i).setInsurePremium(0.0);
//            blPolicy.getHerdPolicyListDtoList().get(i).setEndDate(strValidDate);
//            //blPolicy.getBLHerdPolicyList().getArr(i).setEndTime(ChgData.chgStrZero(strValidHour));
//            blPolicy.getHerdPolicyListDtoList().get(i).setValidity("0");
//            blPolicy.getHerdPolicyListDtoList().get(i).setFlag("D");
//        }
////        //计算短期系数
////        String strStartDate = blPolicyOld.getPrpCmainDto().getStartDate().toString();//起保日期
////        String strStartHour = blPolicyOld.getPrpCmainDto().getStartHour() + "";
////        String strEndDate = blPolicyOld.getPrpCmainDto().getEndDate().toString();//终保日期
////        String strEndHour = blPolicyOld.getPrpCmainDto().getEndHour() + "";
//        String strStartHour=endorseConditionDto.getStartHour();
//        String strEndHour=endorseConditionDto.getEndHour();
//        double dblShortRate;
//        double dblShortRateOld = prpCitemKindDtoList.get(0).getShortRate();
//        //变更保险期限（01）
//        int intStartHourOld = blPolicy.getPrpCitemKindDtoList().get(0).getStartHour();
//        int intStartHour = Integer.parseInt(strStartHour);
//        //终保日期
//        Date endDateOld = blPolicy.getPrpCitemKindDtoList().get(0).getEndDate();
//        int intEndHourOld = blPolicy.getPrpCitemKindDtoList().get(0).getEndHour();
//        int intEndHour = Integer.parseInt(ChgData.chgStrZero(strEndHour));
//        String strStartDate = blPolicyOld.getPrpCmainDto().getStartDate().toString();//起保日期
//        String strEndDate = blPolicyOld.getPrpCmainDto().getEndDate().toString();//终保日期
//        Date startDate = sdf.parse(strStartDate);
//        Date endDate = sdf.parse(strEndDate);
//        double PolicySumPremium=0.0;
//        double dblPremiumOld=0.0;
//        double dblAmountOld=0.0;
//        double dblPremiumNew=0.0;
//        double subSidyRate = 0;
//        double selfRate = 1;
//        for(int k = 0;k < blPolicy.getPrpCsubsidyDtoList().size(); k++){
//            subSidyRate += blPolicy.getPrpCsubsidyDtoList().get(k).getSubsidyRate();
//        }
//        selfRate = (100-subSidyRate)/100;
//        Date startDateOld=blPolicy.getPrpCitemKindDtoList().get(0).getStartDate();
//        for(int i = 0; i < blPolicy.getHerdPolicyListDtoList().size(); i++){
//            if("1".equals(blPolicy.getHerdPolicyListDtoList().get(i).getValidity())){
//                startDate = blPolicy.getHerdPolicyListDtoList().get(i).getStartDate();
//                //直接计算已了责任区间对应的短期系数（短期系数的目的：退费要少、收费要多）
//                //国元需求，统一公式计算
//                dblShortRate = pubTools.calPeriodShortRate(
//                        new com.sinosoft.utility.string.Date(sdf.format(startDate)), intStartHour,
//                        new com.sinosoft.utility.string.Date(sdf.format(endDate)), intEndHour,
//                        new com.sinosoft.utility.string.Date(sdf.format(startDateOld)), intStartHourOld,
//                        new com.sinosoft.utility.string.Date(sdf.format(endDateOld)), intEndHourOld,
//                        strShortRateFlag, dblShortRateOld,
//                        strRiskCode);
//                //计算保费
//                //批改后保费=原保费*新短期系数/原短期系数
//                dblShortRateOld = blPolicy.getHerdPolicyListDtoList().get(i).getShortRate();
//                dblPremiumOld = Str.round(blPolicy.getHerdPolicyListDtoList().get(i).getSumPremium(),2);
//                dblAmountOld = blPolicy.getHerdPolicyListDtoList().get(i).getSumAmount();
//
//                dblPremiumNew = Str.round(dblPremiumOld*dblShortRate/dblShortRateOld,2);
//                PolicySumPremium = PolicySumPremium + dblPremiumNew;//总保费
//                //终保日期
//                blPolicy.getHerdPolicyListDtoList().get(i).setEndDate(strValidDate);
//                //短期费率方式
//                blPolicy.getHerdPolicyListDtoList().get(i).setShortRateFlag(strShortRateFlag);
//                //短期系数
//                blPolicy.getHerdPolicyListDtoList().get(i).setShortRate(dblShortRate);
//                //保费
//                blPolicy.getHerdPolicyListDtoList().get(i).setSumPremium(dblPremiumNew);
//                //农户自缴保费
//                blPolicy.getHerdPolicyListDtoList().get(i).setInsurePremium(Str.round(dblPremiumNew*selfRate,2));
//                //保额置为0
//                blPolicy.getHerdPolicyListDtoList().get(i).setSumAmount(0.0);
//                blPolicy.getHerdPolicyListDtoList().get(i).setValidity("0");
//                blPolicy.getHerdPolicyListDtoList().get(i).setFlag("B");
//            }
//        }
//        blPolicy.getPrpCitemKindDtoList().get(0).setPremium(PolicySumPremium);

        //reason:中央政策性 种植险 整单批改对分户信息的处理
        if (StringUtils.isNotEmpty(plantingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode) && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            if (insureMainListDtoList.size() > 0) {
                List<PlantingEndorHeadDto> bLPlantingEndorHead = new ArrayList<>();
                //种殖险批改头表
                bLPlantingEndorHead.add(plantingEndorHeadDto);
                plantingEndorHeadDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                plantingEndorHeadDto.setEndorseNo(strEndorseNo);
                plantingEndorHeadDto.setRiskCode(strRiskCode);
                plantingEndorHeadDto.setPolicyNo(strPolicyNo);
                //plantingEndorHeadDto.setListFlag("0");
                plantingEndorHeadDto.setEndorFlag(strEndorType);
                blEndorse.setPlantingEndorHeadDto(plantingEndorHeadDto);
            }
        }


        // 二期改造 新加清单的险种 更新清单head表
        if (nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)) {
            if (insureMainListDtoList.size() > 0) {
                System.err.println("二期改造 新加清单的险种 更新清单head表---" + strRiskCode);
                nyxEndorHeadDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                nyxEndorHeadDto.setEndorseNo(strEndorseNo);
                nyxEndorHeadDto.setRiskCode(strRiskCode);
                nyxEndorHeadDto.setPolicyNo(strPolicyNo);
                nyxEndorHeadDto.setListFlag("0");
                nyxEndorHeadDto.setEndorFlag(strEndorType);
                blEndorse.setNyxEndorHeadDto(nyxEndorHeadDto);
            }
        }

        /**5、对Prp*itemKind的处理**/
        //循环险别表
        for (index = 0; index < prpCitemKindDtoList.size(); index++) {
//        -- prp*main othFlag其它标志字段：
//        --** [1] (0/1)新/续保标志
//                --** [2] (0/1)被续保标志(1:被续保)
//        --** [3] 退保标志--**    1:全单退保--**    2:满期退保--**    3:部分退保
//                --** [4] 注销(1:已注销)
//        --** [5] 遗失标志（1：已遗失）
//        --** [6] 有效标志--**1:终止合同--**2:中止保险合同 （车险）
//        --** [7] 是否转入收付费（N:不转）
//        --** [8] 是否统计（N:不统计）
//        --** [9] 询价单是否确认（0:未确认，1：确认）
            strFlag = prpCitemKindDtoList.get(index).getFlag();
            if (strFlag.length() > 0) {
                strFlag = strFlag1 + strFlag.substring(1);
            } else {
                strFlag = strFlag1;
            }
            strKindCode=prpCitemKindDtoList.get(index).getKindCode();
            //保额置为0
            prpCitemKindDtoList.get(index).setAmount(0.00);
            //保费置为0
            prpCitemKindDtoList.get(index).setPremium(0.00);
            //给Flag赋值 标志置为带修改符的U I B D等等
            prpCitemKindDtoList.get(index).setFlag(strFlag);
            //给itemKindAgri的Flag赋值
            if (blPolicy.getPrpCitemKindAgriDtoList().size() > 0) {
                blPolicy.getPrpCitemKindAgriDtoList().get(index).setFlag(strFlag);
            }
            //add by Pao 20111127 begin reason :中央政策性种植险保单注销
            if (StringUtils.isNotEmpty(plantingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode) && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
                strKindCode = prpCitemKindDtoList.get(index).getKindCode();
                //如果有清单主表的话
                if (insureMainListDtoList.size() > 0) {
                    for (int i = 0; i < prpCitemKindDtoList.size(); i++) {
                        if ("1".equals(prpCitemKindDtoList.get(i).getValidity())) {
                            if (strKindCode.equals(prpCitemKindDtoList.get(i).getKindCode())) {
                                prpCitemKindDtoList.get(i).setSumAmount(0.00);
                                prpCitemKindDtoList.get(i).setSumPremium(0.00);
                                prpCitemKindDtoList.get(i).setCentralPremium(0.00);
                                prpCitemKindDtoList.get(i).setProvincePremium(0.00);
                                prpCitemKindDtoList.get(i).setCityPremium(0.00);
                                prpCitemKindDtoList.get(i).setTownPremium(0.00);
                                prpCitemKindDtoList.get(i).setOtherPremium(0.00);
                                prpCitemKindDtoList.get(i).setfPremium(0.00);
                                prpCitemKindDtoList.get(i).setInsureArea(0.00);
                                prpCitemKindDtoList.get(i).setValidity("0");
                                prpCitemKindDtoList.get(i).setFlag("D");
                            }
                        }
                    }
                }
            }
            if(("3141".equals(strRiskCode)) || ("3147".equals(strRiskCode))){
                strKindCode=prpCitemKindDtoList.get(index).getKindCode()+"-"+prpCitemKindDtoList.get(index).getItemCode();
                if(insureMainListDtoList.size() > 0){
                    for(int i = 0; i < blPolicy.getPlanting31PolicyListDtoList().size(); i++){
                        if("1".equals(blPolicy.getPlanting31PolicyListDtoList().get(i).getValidity())){
                            if(strKindCode.equals(blPolicy.getPlanting31PolicyListDtoList().get(i).getKindCode()+"-"+blPolicy.getPlanting31PolicyListDtoList().get(i).getItemCode())){
                                //保额置为0
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setSumAmount(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setSumPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setCentralPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setProvincePremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setCityPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setTownPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setOtherPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setfPremium(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setInsureArea(0.0);
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setValidity("0");
                                blPolicy.getPlanting31PolicyListDtoList().get(i).setFlag("B");
                            }
                        }
                    }
                }
            }
            // 农险二期平台改造 保单注销时 同时更新清单表
            if (nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)||"3224".equals(strRiskCode)) {
                strKindCode = prpCitemKindDtoList.get(index).getKindCode();
                if (insureMainListDtoList.size() > 0) {
                    for (int i = 0; i < nyxPolicyListDtoList.size(); i++) {
                        if ("1".equals(nyxPolicyListDtoList.get(i).getValidity())) {
                            if (strKindCode.equals(nyxPolicyListDtoList.get(i).getKindCode())) {
                                //保额置为0
                                nyxPolicyListDtoList.get(i).setSumAmount(0.00);
                                nyxPolicyListDtoList.get(i).setSumPremium(0.00);
                                nyxPolicyListDtoList.get(i).setCentralPremium(0.00);
                                nyxPolicyListDtoList.get(i).setProvincePremium(0.00);
                                nyxPolicyListDtoList.get(i).setCityPremium(0.00);
                                nyxPolicyListDtoList.get(i).setTownPremium(0.00);
                                nyxPolicyListDtoList.get(i).setOtherPremium(0.00);
                                nyxPolicyListDtoList.get(i).setfPremium(0.00);
                                nyxPolicyListDtoList.get(i).setInsureArea(0.00);
                                nyxPolicyListDtoList.get(i).setValidity("0");
                                nyxPolicyListDtoList.get(i).setFlag("D");
                                //planting31PolicyListDtoList.get(i).setFlag("B");
                            }
                        }
                    }
                    System.err.println("农险二期平台改造 注销时 同时更新清单表");
                }
            }

            //1、需要维护PrpDkind.CalculateFlag[2]：1 保额/2 限额/3 虚拟标的
            //2、标的中涉及赔偿限额的，在退保的时候将赔偿限额/免赔额（率）全部删除，置为0，这个需要和客户确认
            //3、相应的在普通批改的处理时是否也需要如此，需要和客户确认
            //是否需要进行赔偿限额/免赔额(率)的处理
            strKindCode = prpCitemKindDtoList.get(index).getKindCode();
            prpDkindDto = prpDkindApi.queryByPK(strRiskCode, strKindCode);
            if (prpDkindDto.getCalculateFlag().length() > 1 &&
                    (prpDkindDto.getCalculateFlag().substring(1, 2).equals("2") ||
                            prpDkindDto.getCalculateFlag().substring(1, 2).equals("3"))) {
            }
            /* 险统计中用到批单的承保数量和参保农户户次两个字段，因此全单退保要对这两个字段清零 */
            prpCmainDto.setSumInsured(0.00);
            prpCmainDto.setStatQuantity(0.00);//reason :中央政策性种植险保单注销
        }


        /**6、生成Fee表的数据**/
        prpCfeeDto = new PrpCfeeDto();
            /*blPolicyOld.getData(strPolicyNo);
            prpCfeeDtoList = blPolicyOld.getPrpCfeeDtoList();*/
        prpCfeeDtoList          = new ArrayList<>();
        List<PrpCfee> prpCfeeList = prpCfeeDao.findAll(QueryPolicySpecBuilder.findPrpCfeeByPolicyNo(strPolicyNo));
        this.convertCollection(prpCfeeList,prpCfeeDtoList,PrpCfeeDto.class);

        //有保费变化的特殊批改：01、19、21、62，保单币别没有变化（原币、保单汇总币别、支付保费币别）
        //xiaojian_leave：犹豫期退保是否可以如此处理
        for (index = 0; isChangedFee && index < prpCitemKindDtoList.size(); index++) {
            //此时PrpCitemKind已经是上面处理后的
            prpCitemKindDto = prpCitemKindDtoList.get(index);
            if (prpCitemKindDto.getFlag().length() > 0) {
                strFlag1 = prpCitemKindDto.getFlag().substring(0, 1);
            }
            else {
                strFlag1 = "";
            }
            //目前险判断以下两种类型，待以后补充
            if (strFlag1.equals("B") || strFlag1.equals("D")) {
                strFlag1 = "U";
            }
            for (indexOld = 0; indexOld < prpCfeeDtoList.size(); indexOld++) {
                prpCfeeDtoOld = prpCfeeDtoList.get(indexOld);

                //6.1、如果原币不相同不进行处理
                if (!prpCfeeDtoOld.getCurrency().equals(prpCitemKindDto.getCurrency())) {
                    continue;
                }
                //6.2、从哈希表中获得已经有的Fee的数据，进行累加
                prpCfeeDto = (PrpCfeeDto) feeHashtable.get(prpCitemKindDto.getCurrency());
                if (prpCfeeDto == null) {
                    prpCfeeDto = new PrpCfeeDto();
                }
                //6.3、获得原保单币别信息
                strCurrency2 = prpCfeeDtoOld.getCurrency2();
                strCurrency1 = prpCfeeDtoOld.getCurrency1();
                dblExchangeRate2 = prpCfeeDtoOld.getExchangeRate2();
                dblExchangeRate1 = prpCfeeDtoOld.getExchangeRate1();
                //6.4、赋值
                prpCfeeDto.setPolicyNo(prpCitemKindDto.getPolicyNo());
                prpCfeeDto.setRiskCode(prpCitemKindDto.getRiskCode());
                //原币
                prpCfeeDto.setCurrency(prpCitemKindDto.getCurrency());
                if (prpCitemKindDto.getCalculateFlag().trim().equals("Y")) {
                    dblAmount = Str.round(prpCfeeDto.getAmount()==null?0.00:prpCfeeDto.getAmount(), 2)
                            + Str.round(prpCitemKindDto.getAmount()==null?0.00:prpCitemKindDto.getAmount(), 2);
                    prpCfeeDto.setAmount(Str.round(dblAmount, 2));
                } else {
                    dblAmount = Str.round(prpCfeeDto.getAmount()==null?0.00:prpCfeeDto.getAmount(), 2);
                    prpCfeeDto.setAmount(dblAmount);
                }

                dblPremium = Str.round(prpCfeeDto.getPremium()==null?0.00:prpCfeeDto.getPremium(), 4)
                        + Str.round(prpCitemKindDto.getPremium()==null?0.00:prpCitemKindDto.getPremium(), 4);

                prpCfeeDto.setPremium(Str.round(dblPremium, 4));
                //保单汇总币别
                dblAmount2 = dblAmount * dblExchangeRate2;
                dblPremium2 = dblPremium * dblExchangeRate2;
                prpCfeeDto.setCurrency2(strCurrency2);
                prpCfeeDto.setExchangeRate2(dblExchangeRate2);
                prpCfeeDto.setAmount2(Str.round(dblAmount2, 2));
                prpCfeeDto.setPremium2(Str.round(dblPremium2, 4));
                //支付保费币别
                dblAmount1 = dblAmount * dblExchangeRate1;
                dblPremium1 = dblPremium * dblExchangeRate1;
                prpCfeeDto.setCurrency1(strCurrency1);
                prpCfeeDto.setExchangeRate1(dblExchangeRate1);
                prpCfeeDto.setAmount1(Str.round(dblAmount1, 2));
                prpCfeeDto.setPremium1(Str.round(dblPremium1, 4));
                if (prpCfeeDto.getFlag()!=null && prpCfeeDto.getFlag().length()==0) {
                    prpCfeeDto.setFlag(strFlag1);
                }
                feeHashtable.put(prpCitemKindDto.getCurrency(), prpCfeeDto);
                break;
            }
        }

        Object[] arrObject = feeHashtable.values().toArray();

        for (index = 0; index < arrObject.length; index++) {
            prpCfeeDtoList.add((PrpCfeeDto) arrObject[index]);
            dblSumPremium += ((PrpCfeeDto) arrObject[index]).getPremium2(); //Prp*main.SumPremium
        }
        prpCfeeDtoList.remove(0);
        blPolicy.setPrpCfeeDtoList(prpCfeeDtoList);

        /**7、对Prp*main的处理**/
        //总保额（保单汇总币别）
        prpCmainDto.setSumAmount(0.00);
        //总保费（保单汇总币别）
        prpCmainDto.setSumPremium(0.00);


        /** 10、联共保被动批改处理*/
            /* reason：增加联共保批改处理 */
        List<PrpCcoinsDto> blPrpCcoins = null;
        List<PrpCcoinsDetailDto> blPrpCcoinsDetail = null;
        PrpCcoinsDto prpCcoinsDto = null;
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        //获取按不含税保费计算手续费开关


        //String reCordType = new VatCommonService().getRecordTypeFormPrpdconfigcode(strPolicyNo);
        String strCoinsFlag = "";
        String strProportionFlag1 = ""; //手续费计入方式
        String strProportionFlag2 = ""; //特殊因子计入方式
        String strCoinsType = "";
        double dbDisRate1Coins = 0;
        double dbDisRateCoins = 0;
        double dbCoinsRate = 0;
        double dbSumAmount1 = 0;
        double dbSumPremium1 = 0;
        double dbMiddleCostFeeBase = 0;
        double dbAgentFeeBase = 0;


        blPrpCcoins = prpCcoinsDtoList;
        blPrpCcoinsDetail = prpCcoinsDetailDtoList;
        strCoinsFlag = prpCmainDto.getCoinsFlag();
        dbDisRate1Coins = prpCmainDto.getDisRate1();
        dbDisRateCoins = prpCmainDto.getDisRate();
        if ((strCoinsFlag.equals("1") || strCoinsFlag.equals("2")) && !"".equals(prpCmainDto.getCoinsPremiumType())) {
            for (index = 0; index < prpCfeeDtoList.size(); index++) {
                prpCfeeDto = prpCfeeDtoList.get(0);
                dbSumAmount1 = dbSumPremium1 + prpCfeeDto.getAmount1();
                dbSumPremium1 = dbSumPremium1 + prpCfeeDto.getPremium1();
            }
            if (strEndorType.equals(AgriPrpallConstant.EDITTYPE_WRITEOFF.trim()) ||
                    strEndorType.equals(AgriPrpallConstant.EDITTYPE_WITHDRAW.trim())) {
                if (dbSumPremium1 != 0) {
                    for (int i = 0; i < blPrpCcoins.size(); i++) {
                        prpCcoinsDto = blPrpCcoins.get(i);
                        if (prpCcoinsDto.getCoinsType().equals("1")) {
                            dbCoinsRate = prpCcoinsDto.getCoinsRate();
                            break;
                        }
                    }
                    dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                    dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
                    dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
                    dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                    for (index = 0; index < blPrpCcoinsDetail.size(); index++) {
                        prpCcoinsDetailDto = blPrpCcoinsDetail.get(index);
                        for (int j = 0; j < blPrpCcoins.size(); j++) {
                            prpCcoinsDto = blPrpCcoins.get(j);
                            if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode())) {
                                continue;
                            }
                            strCoinsType = prpCcoinsDto.getCoinsType();
                            dbCoinsRate = prpCcoinsDto.getCoinsRate();
                            break;
                        }
                        prpCcoinsDetailDtoList.get(index).setCoinsAmount(dbSumAmount1 * dbCoinsRate / 100);
                        prpCcoinsDetailDtoList.get(index).setCoinsPremium(dbSumPremium1 * dbCoinsRate / 100);
                        prpCcoinsDetailDtoList.get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate / 100);
                        prpCcoinsDetailDtoList.get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate / 100);
                        prpCcoinsDetailDtoList.get(index).setOperateFee(0.00);
                        prpCcoinsDetailDtoList.get(index).setFlag("U");
                    }
                } else {
                    for (int j = 0; j < blPrpCcoins.size(); j++) {
                        blPolicy.getPrpCcoinsDtoList().get(j).setCoinsRate(0.00);
                        blPolicy.getPrpCcoinsDtoList().get(j).setFlag("B");
                    }
                    for (index = 0; index < blPrpCcoinsDetail.size(); index++) {
                        prpCcoinsDetailDtoList.get(index).setCoinsAmount(0.00);
                        prpCcoinsDetailDtoList.get(index).setCoinsPremium(0.00);
                        prpCcoinsDetailDtoList.get(index).setMiddleCostFee(0.00);
                        prpCcoinsDetailDtoList.get(index).setAgentFee(0.00);
                        prpCcoinsDetailDtoList.get(index).setOperateFee(0.00);
                        prpCcoinsDetailDtoList.get(index).setFlag("B");
                    }
                }
            } else {
                for (int j = 0; j < blPrpCcoins.size(); j++) {
                    prpCcoinsDto = blPrpCcoins.get(j);
                    if (prpCcoinsDto.getCoinsType().equals("1")) {
                        dbCoinsRate = prpCcoinsDto.getCoinsRate();
                        break;
                    }
                }
                dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
                dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
                dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                for (index = 0; index < blPrpCcoinsDetail.size(); index++) {
                    prpCcoinsDetailDto = blPrpCcoinsDetail.get(index);
                    for (int j = 0; j < blPrpCcoins.size(); j++) {
                        prpCcoinsDto = blPrpCcoins.get(j);
                        if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode())) {
                            continue;
                        }
                        strCoinsType = prpCcoinsDto.getCoinsType();
                        dbCoinsRate = prpCcoinsDto.getCoinsRate();
                        break;
                    }
                    prpCcoinsDetailDtoList.get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate / 100);
                    prpCcoinsDetailDtoList.get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate / 100);
                    prpCcoinsDetailDtoList.get(index).setOperateFee(0.00);
                    prpCcoinsDetailDtoList.get(index).setFlag("U");
                }
            }
        } else {
            for (index = 0; index < blPolicy.getPrpCfeeDtoList().size(); index++) {
                prpCfeeDto = blPolicy.getPrpCfeeDtoList().get(0);
                dbSumAmount1 = dbSumPremium1 + prpCfeeDto.getAmount1();
                dbSumPremium1 = dbSumPremium1 + prpCfeeDto.getPremium1();
            }
            if (strCoinsFlag.equals("2") || strCoinsFlag.equals("4")) {
                for (int j = 0; j < blPrpCcoins.size(); j++) {
                    prpCcoinsDto = blPrpCcoins.get(j);
                    if (prpCcoinsDto.getCoinsType().equals("1")) {
                        dbCoinsRate = prpCcoinsDto.getCoinsRate();
                        if (prpCcoinsDto.getProportionFlag().length() > 0) {
                            strProportionFlag1 = prpCcoinsDto.getProportionFlag().substring(0, 1);
                        }
                        if (prpCcoinsDto.getProportionFlag().length() > 1) {
                            strProportionFlag2 = prpCcoinsDto.getProportionFlag().substring(1, 2);
                        }
                        break;
                    }
                }
                dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
            }
            dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
            dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins;
            for (index = 0; index < blPrpCcoinsDetail.size(); index++) {
                prpCcoinsDetailDto = blPrpCcoinsDetail.get(index);
                for (int i = 0; i < blPrpCcoins.size(); i++) {
                    prpCcoinsDto = blPrpCcoins.get(i);
                    if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode())) {
                        continue;
                    }
                    strCoinsType = prpCcoinsDto.getCoinsType();
                    dbCoinsRate = prpCcoinsDto.getCoinsRate();
                    break;
                }
                prpCcoinsDetailDtoList.get(index).setCoinsAmount(dbSumAmount1 * dbCoinsRate);
                prpCcoinsDetailDtoList.get(index).setCoinsPremium(dbSumPremium1 * dbCoinsRate);
                if (strCoinsType.equals("1")) { //我方
                    prpCcoinsDetailDtoList.get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate);
                    if (strProportionFlag2.equals("2")) {
                        prpCcoinsDetailDtoList.get(index).setAgentFee(dbAgentFeeBase);
                    }
                    else {
                        prpCcoinsDetailDtoList.get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate);
                    }
                } else { //非我方
                    if (strProportionFlag2.equals("1")) {
                        prpCcoinsDetailDtoList.get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate);
                    }
                    else {
                        prpCcoinsDetailDtoList.get(index).setMiddleCostFee(0.00);
                    }
                    if (strProportionFlag1.equals("1")) {
                        prpCcoinsDetailDtoList.get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate);
                    }
                    else {
                        prpCcoinsDetailDtoList.get(index).setAgentFee(0.00);
                    }
                }
                prpCcoinsDetailDtoList.get(index).setOperateFee(0.00);
                prpCcoinsDetailDtoList.get(index).setFlag("U");
            }
        }
        //--从PrpCcoinsDetail表里取出数据放入prpCplanCoinsSchema对象后再插入PrpcplanCoins表中
        double ohrPlafeeOld = 0.0;        //起初应缴金额
        double ohrPlfeeRate = 0.0;        //应缴比例
        double ohrPlanfeeNew = 0.0;        //变化应缴金额
        double ohrChangePlanfee = 0.0;    //保费最终变化量
        PrpCplanCoinsDto prpCplanCoinsDto = new PrpCplanCoinsDto();    //初始化实体类,存放新值
        int prpCplanCoinsSize = blPolicy.getPrpCplanCoinsDtoList().size();
        String payReaon = "";
        for (index = 0; index < prpCplanCoinsSize; index++) {
            String strCoinsCode = blPolicy.getPrpCplanCoinsDtoList().get(index).getCoinsCode();    //从PrpCplanCoins取CoinsCode字段
            for (int j = 0; j < prpCcoinsDetailDtoList.size(); j++) {
                String strCoinsCode1 = prpCcoinsDetailDtoList.get(j).getCoinsCode(); //从PrpCcoinsDetail取CoinsCode字段
                if (strCoinsCode.equals(strCoinsCode1)) {
                    ohrPlanfeeNew = prpCcoinsDetailDtoList.get(j).getCoinsPremium();
                    break;
                }
            }
            ohrPlafeeOld = blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanFee();
            ohrPlfeeRate = blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanRate() / 100;
            //保费最终变化量计算方式
            ohrChangePlanfee = ohrPlfeeRate * ohrPlanfeeNew - ohrPlafeeOld;
            prpCplanCoinsDto = new PrpCplanCoinsDto();
            prpCplanCoinsDto.setPolicyNo(blPolicy.getPrpCplanCoinsDtoList().get(index).getPolicyNo());
            prpCplanCoinsDto.setEndorseNo("");
            prpCplanCoinsDto.setCoinsCode(blPolicy.getPrpCplanCoinsDtoList().get(index).getCoinsCode());
            //SerialNo字段存在主键约束,添加序号
            prpCplanCoinsDto.setSerialNo(prpCplanCoinsSize + index);
            prpCplanCoinsDto.setPayNo(blPolicy.getPrpCplanCoinsDtoList().get(index).getPayNo());
            String str_payReason = blPolicy.getPrpCplanCoinsDtoList().get(index).getPayReason();
            if (str_payReason.equals("GP81")) {
                payReaon = str_payReason.replace("GP81", "GE81");
            } else {
                payReaon = str_payReason;
            }
            prpCplanCoinsDto.setPayReason(payReaon);
            prpCplanCoinsDto.setPlanDate(blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanDate());
            prpCplanCoinsDto.setCurrency(blPolicy.getPrpCplanCoinsDtoList().get(index).getCurrency());
            prpCplanCoinsDto.setPlanFee(ohrChangePlanfee);    //planfee修改后的数据插入prpCplanCoinsSchema对象
            prpCplanCoinsDto.setDelinquentFee(ohrChangePlanfee);
            prpCplanCoinsDto.setFlag("I");
            prpCplanCoinsDto.setPlanStartDate(prpPheadDto.getValidDate());
            prpCplanCoinsDto.setPlanRate(blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanRate());
            blPolicy.getPrpCplanCoinsDtoList().add(prpCplanCoinsDto);        //将对象插入BlPrpCplanCoins表
        }


        /**11、生成批单对象**/
        /** 保单数据转入批单 */
        List<InsureMainListDto> insureMainListDtoListOld = insureMainListApi.queryByPolicyNo(strPolicyNo);
        List<HerdPolicyListDto> herdPolicyListDtoListOld = new ArrayList<>();
        if(insureMainListDtoListOld.size()>0) {
            herdPolicyListDtoListOld = plantingPolicyListApi.queryHerdByInsureListCode(insureMainListDtoListOld.get(0).getInusreListCode());
        }

        blPolicyOld=policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);

        blPolicyOld.setInsureMainListDtoList(insureMainListDtoListOld);
        blPolicyOld.setHerdPolicyListDtoList(herdPolicyListDtoListOld);

        generatePEndorse.evaluateFromPolicyToEndor(blPolicyOld,blPolicy,blEndorse);

        //中央政策行种植险整单批改批改
        BLPolicyDto blPolicyOld2=null;
        if(null!=blPolicy.getHerdPolicyListDtoList()&&blPolicy.getHerdPolicyListDtoList().size()>0){
            blPolicyOld2 = new BLPolicyDto(); //原始保单
            blPolicyOld2.setHerdPolicyListDtoList(herdPolicyListDtoListOld);
            generateTxnListService.evaluateBreedFromPolicyToEndor(blPolicyOld2.getHerdPolicyListDtoList(),blPolicy,blEndorse);
        }
        if(null!=blPolicy.getNyxPolicyListDtoList()&&blPolicy.getNyxPolicyListDtoList().size()>0){
            blPolicyOld2 = new BLPolicyDto(); //原始保单
            List<NyxPolicyListDto> nyxPolicyListDtoListOld = new ArrayList<NyxPolicyListDto>();
            if(insureMainListDtoListOld.size()>0) {
                nyxPolicyListDtoListOld = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoListOld.get(0).getInusreListCode());
                blPolicyOld2.setNyxPolicyListDtoList(nyxPolicyListDtoListOld);
            }
            generateTxnListService.evaluateNyxFromPolicyToEndor(blPolicyOld2.getNyxPolicyListDtoList(),blPolicy,blEndorse);
        }

        if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            //获取原始保单分户信息
            BLPolicyDto PPolicyOld = null;
            if (prpCitemKindDtoList.size() > 0) {
                PPolicyOld = new BLPolicyDto(); //原始保单
                PPolicyOld.setPlantingPolicyListDtoList(plantingPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode()));
                if(blPolicy.getPrpCmainAgriDto()!=null){
                    String inusreListCode1 = blPolicy.getPrpCmainAgriDto().getRelationListNo();
                    insureMainListDto = insureMainListApi.queryByPK(inusreListCode1);
                    if(insureMainListDto == null){
                        throw new Exception("保单关联清主单查询错误！");
                    }
                }
            }
            if (null != PPolicyOld) {
                generateTxnListService.evaluatePlantingFromPolicyToEndor(PPolicyOld.getPlantingPolicyListDtoList(),blPolicy,blEndorse);
//                int i = 0;
//                PlantingEndorChgDetailDto plantingEndorChgDetailSchema = null;
//                PlantingPolicyListDto plantingPolicyListOldSchema = null;
//                PlantingPolicyListDto plantingPolicyListNewSchema = null;
//                PlantingPolicyListDto plantingPolicyListNewSchemaTmp = null;
//                Hashtable hashItemKind = new Hashtable();
//                List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList = new ArrayList<>();
//                //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
//                if (blPolicy.getPlantingPolicyListDtoList().size() < PPolicyOld.getPlantingPolicyListDtoList().size()) {
//                }else {
//                    //将indexCode与其Schema建立映射关系
//                    for (i = 0; i < PPolicyOld.getPlantingPolicyListDtoList().size(); i++) {
//                        plantingPolicyListNewSchemaTmp = PPolicyOld.getPlantingPolicyListDtoList().get(i);
//                        hashItemKind.put("" + plantingPolicyListNewSchemaTmp.getIndexCode(), plantingPolicyListNewSchemaTmp);
//                    }
//                    //建立映射关系完毕
//                    for (i = 0; i < blPolicy.getPlantingPolicyListDtoList().size(); i++) {
//                        plantingPolicyListNewSchema = blPolicy.getPlantingPolicyListDtoList().get(i);
//                        if (plantingPolicyListNewSchema.getFlag().length() > 0) {
//                            if (plantingPolicyListNewSchema.getFlag().charAt(0) == 'I') {
//                                plantingPolicyListOldSchema = plantingPolicyListNewSchema;
//                            } else {
//                                plantingPolicyListOldSchema = (PlantingPolicyListDto) hashItemKind.get("" + plantingPolicyListNewSchema.getIndexCode());
//                                if (plantingPolicyListOldSchema == null) {
//                                    continue;
//                                }
//                            }
//                        } else {
//                            plantingPolicyListOldSchema = (PlantingPolicyListDto) hashItemKind.get(""
//                                    + plantingPolicyListNewSchema.getIndexCode());
//                            if (plantingPolicyListOldSchema == null) {
//                                continue;
//                            }
//                        }
//                        plantingEndorChgDetailSchema = new PlantingEndorChgDetailDto();
//                        plantingEndorChgDetailSchema.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
//                        plantingEndorChgDetailService.setPlantingEndorChgDetail(plantingEndorChgDetailSchema,plantingPolicyListOldSchema,plantingPolicyListNewSchema);
//                        plantingEndorChgDetailDtoList.add(plantingEndorChgDetailSchema);
//                    }
//                }
//                blEndorseDto.setPlantingEndorChgDetailDtoList(plantingEndorChgDetailDtoList);
            }
        }
            if ("3141".equals(strRiskCode)||"3147".equals(strRiskCode)) {
                //获取原始保单分户信息
                BLPolicyDto PPolicyOld = null;
                if (planting31PolicyListDtoList.size() > 0) {

                    PPolicyOld = new BLPolicyDto(); //原始保单
                    List<Planting31PolicyListDto> planting31PolicyListDto;
                    if(insureMainListDtoList.size()<=0){
                        throw new Exception("清单主表缺少数据！");
                    }
                    Map<String,String> map=new HashMap<>();
                    map.put("inusreListCode",insureMainListDtoList.get(0).getInusreListCode());
                    planting31PolicyListDto = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
                    PPolicyOld.setPlanting31PolicyListDtoList(planting31PolicyListDto);
                }
                if (null != PPolicyOld) {
                    generateTxnListService.evaluatePlanting31FromPolicyToEndor(PPolicyOld.getPlanting31PolicyListDtoList(), blPolicy,blEndorse);
                }
            }

        //退保手续费比例
        blPolicy.setComissionRate(Double.parseDouble(ChgData.chgStrZero(strIrate)));

        //进行prppitemkind和prppmain的调差，处理精确度问题
        //blEndorse.adjustChgPremium(blPolicy);
        int i = 0;
        PrpPitemKindDto prpPitemKindSchema = new PrpPitemKindDto();
        PrpCitemKindDto prpCitemKindSchema = new PrpCitemKindDto();
        double chgPremiumItemkind = 0d;
        double chgPremium = 0d;
        double AllPremium=0;
        double EveryPremium=0;
        double LastPremium=0;
        //blEndorse.getPrpPmainDto().getChgPremium();
        if (blEndorse.getPrpPmainDto()!=null) {
            blEndorse.getPrpPmainDto().setChgPremium(Str.round(blPolicy.getPrpCmainDto().getSumPremium()-blEndorse.getPrpPmainDto().getSumPremium(),2));
        }
        chgPremium = Str.round(blEndorse.getPrpPmainDto().getChgPremium(),2);
        for (i = 0; i < blEndorse.getPrpPfeeDtoList().size(); i++) {
            blEndorse.getPrpPfeeDtoList().get(i).setChgPremium(Str.round(blPolicy.getPrpCmainDto().getSumPremium()-blEndorse.getPrpPmainDto().getSumPremium(),2));
            blEndorse.getPrpPfeeDtoList().get(i).setChgPremium1(Str.round(blPolicy.getPrpCmainDto().getSumPremium()-blEndorse.getPrpPmainDto().getSumPremium(),2));
            blEndorse.getPrpPfeeDtoList().get(i).setChgPremium2(Str.round(blPolicy.getPrpCmainDto().getSumPremium()-blEndorse.getPrpPmainDto().getSumPremium(),2));
            blEndorse.getPrpPfeeDtoList().get(i).setFlag("U");
        }
        if (blPolicy.getPrpCmainDto()!=null) {
            blPolicy.getPrpCmainDto().setSumPremium(Str.round(blPolicy.getPrpCmainDto().getSumPremium(),2));
            AllPremium=Str.round(blPolicy.getPrpCmainDto().getSumPremium(),2);

        }
        for (i = 0; i < blPolicy.getPrpCfeeDtoList().size(); i++) {
            blPolicy.getPrpCfeeDtoList().get(i).setPremium(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium(),2));
            blPolicy.getPrpCfeeDtoList().get(i).setPremium1(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium1(),2));
            blPolicy.getPrpCfeeDtoList().get(i).setPremium2(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium2(),2));
        }

        for (i = 0; i < blEndorse.getPrpPitemKindDtoList().size(); i++) {
            prpPitemKindSchema = blEndorse.getPrpPitemKindDtoList().get(i);
            prpPitemKindSchema.setChgPremium(Str.round(prpPitemKindSchema.getChgPremium(),2));
            chgPremiumItemkind += prpPitemKindSchema.getChgPremium();
            if(i==blEndorse.getPrpPitemKindDtoList().size()-1){// 最后一个险别进行调差
                if(Str.round(Math.abs(chgPremium-chgPremiumItemkind),4)>=0.01){
                    prpPitemKindSchema.setChgPremium(Str.round(prpPitemKindSchema.getChgPremium()+chgPremium-chgPremiumItemkind,2));
                }
                LastPremium=Str.round(AllPremium-EveryPremium,2);
            }
            for(int j=0; j< blPolicy.getPrpCitemKindDtoList().size(); j++){
                prpCitemKindSchema = blPolicy.getPrpCitemKindDtoList().get(j);
                if(prpPitemKindSchema.getItemKindNo().equals(prpCitemKindSchema.getItemKindNo())){
                    prpCitemKindSchema.setPremium(Str.round(prpPitemKindSchema.getPremium() + prpPitemKindSchema.getChgPremium(),2));
                    EveryPremium=EveryPremium+Str.round(prpPitemKindSchema.getPremium()+prpPitemKindSchema.getChgPremium(),2);
                }
                if(j==(blPolicy.getPrpCitemKindDtoList().size()-1)&&prpPitemKindSchema.getItemKindNo().equals(prpCitemKindSchema.getItemKindNo())){// 最后一个险别进行调差
                    prpCitemKindSchema.setPremium(LastPremium);
                }
            }
        }
        generatePEndorseService.webAfterCal(blPolicyOld,blPolicy,blEndorse);//plan表等调差
        /**12、放入对象**/
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicy);
        policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyOld);
        policyEndorseDto.setBlEndorseDto(blEndorse);
        policyEndorseDto.getBlEndorseDto().setEndorseConditionDto(endorseConditionDto);

        /**13、生成批文**/
        generatePtextApi.generateUsual(policyEndorseDto);

        return policyEndorseDto;
    }
}
