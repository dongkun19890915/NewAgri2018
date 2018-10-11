package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.GeneratePtextApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePEndorseService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateTxnListService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.Planting31EndorChgDetailService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.PlantingEndorChgDetailService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndor71Service;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorItemKindService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCfeeDao;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.pms.api.kernel.PrpDshortRateApi;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.utility.string.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SpecialEndorseItemKindServiceImpl extends BaseServiceImpl implements SpecialEndorItemKindService {

    @Autowired
    private PrpCfeeDao prpCfeeDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private GeneratePtextApi generatePtextApi;
    @Autowired
    GeneratePEndorseService generatePEndorseService;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private PlantingEndorChgDetailService plantingEndorChgDetailService;
    @Autowired
    private Planting31EndorChgDetailService planting31EndorChgDetailService;
    @Autowired
    private SpecialEndor71Service specialEndor71Service;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private GenerateTxnListService generateTxnListService;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    private PrpDshortRateApi prpDshortRateApi;
    @Autowired
    private PubTools pubTools;
    @Autowired
    private PrpCmainService prpCmainService;
    @Autowired
    private PrpCitemKindService prpCitemKindService;

    /**
     * 01变更保险日期、
     * 11调整费率、
     * 71调整补贴比例、
     * 91调整单位保额
     * 四种批改类型处理方法
     * @param blEndorseDto 批单大对象集合
     * @param endorseConditionDto 批单条件
     * @return PolicyEndorseDto 新旧保单、批单大对象
     * @author 王心洋
     * @time 2017-12-22
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto specialEndorse01(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto,
                                             List<PrpCsubsidyDto> prpCsubsidyDtos,List<PrpCitemKindDto> prpCitemKindDtos) throws Exception {

        //创建返回值对象
        PolicyEndorseDto policyEndorseDto = null;
        //创建批单数据对象，用于遍历传入集合
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        policyEndorseDto = new PolicyEndorseDto();
        String strMakeCom = blEndorseDto.getPrpPheadDto().getMakeCom();
        String strUserCode = blEndorseDto.getPrpPheadDto().getOperatorCode();
        String strPolicyNo = blEndorseDto.getPrpPheadDto().getPolicyNo(); //保单号
        Date strEndorDate = blEndorseDto.getPrpPheadDto().getEndorDate(); //批改日期
        Date strValidDate = blEndorseDto.getPrpPheadDto().getValidDate(); //批改生效日期
        int intValidHour = blEndorseDto.getPrpPheadDto().getValidHour(); //批改生效小时
        String strShortRateFlag = endorseConditionDto.getShortRateFlag(); //短期费率方式
        String strEndorType = endorseConditionDto.getEndorType(); //批改类型
        String strIrate = endorseConditionDto.getiRate(); //退保手续费比例
        String strPrpPheadAppliName = blEndorseDto.getPrpPheadDto().getAppliName();
        String strEndorseType1 = blEndorseDto.getPrpPheadDto().getEndorseType();//批改方式
        String strEndorseMessage = endorseConditionDto.getEndorseReason();//批改方式原因
        String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_BREEDING_FARMER_LIST_FLAG);//中央政策险养殖险标志
        String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_PLNATING_FARMER_LIST_FLAG);//中央政策险种植险标志
        String nyxSingleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_SINGLE_FARMER_LIST_FLAG);
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_MULTIPLE_FARMER_LIST_FLAG);
        DecimalFormat format = new DecimalFormat("0.00");

        // 创建返回参数
        ResponseQueryPolicyInfoDto blPolicy = new ResponseQueryPolicyInfoDto();
        ResponseQueryPolicyInfoDto blPolicyOld;
        BLEndorseDto blEndorse = new BLEndorseDto();
        //创建清单对象
        HerdEndorHeadDto herdEndorHeadDto = new HerdEndorHeadDto();
        NyxEndorHeadDto nyxEndorHeadDto = new NyxEndorHeadDto();
        PlantingEndorHeadDto plantingEndorHeadDto = new PlantingEndorHeadDto();
        PrpCitemKindDto prpCitemKindDto = null;
        PrpPheadDto prpPheadDto = new PrpPheadDto();
        ChgDate chgDate = new ChgDate();
        Hashtable feeHashtable = new Hashtable();
        Date startDate;//起始日期
        Date startDateOld = null;
        Date endDate = null;//终止日期
        Date endDateOld = null;
        String strStartDate = "";
        String strStartHour = "";
        String strEndDate = "";
        String strEndHour = "";
        String strCompensateNo = "";
        String strRiskCode = "";
        String strEndorseNo = "";
        String strKindCode = "";
        String strCurrency2 = "";
        String strCurrency1 = "";
        String strFlag1 = "";
        String strFlag = "";

        double dblShortRate = 0;
        double dblShortRateOld = 0;
        double dblPremiumOld = 0;
        Double dblPremiumNew = 0.0;
        double dblAmount = 0;
        double dblAmount2 = 0;
        double dblAmount1 = 0;
        double dblPremium = 0;
        double dblPremium2 = 0;
        double dblPremium1 = 0;
        double dblExchangeRate2 = 0;
        double dblExchangeRate1 = 0;
        double dblSumPremium = 0;
        double dblSumAmount = 0;
        //分户信息
        int intStartHour = 0;//起始小时
        int intStartHourOld = 0;
        int intEndHour = 0;//终止小时
        int intEndHourOld = 0;
        int intEndorseTimes = 0;//批改次数
        int index = 0;
        int indexOld = 0;
        boolean isChangedFee = true; //货运险批改起运日期时，没有保费变化


        /** 获取保单数据 */
        blPolicyOld = policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);
        blPolicy = policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);


        if ("01".equals(strEndorType)) {
            strStartDate = endorseConditionDto.getAgriStartDate();//起保日期
            strStartHour = endorseConditionDto.getValidHour();
            strEndDate = endorseConditionDto.getEndDate();//终保日期
            strEndHour = endorseConditionDto.getEndHour();
        } else {
            strStartDate = sdf.format(endorseConditionDto.getValidDate());//起保日期
            strStartHour = blPolicyOld.getPrpCmainDto().getStartHour() + "";
            strEndDate = blPolicyOld.getPrpCmainDto().getEndDate().toString();//终保日期
            strEndHour = blPolicyOld.getPrpCmainDto().getEndHour() + "";
        }
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
        blPolicy.setInsureMainListDtoList(insureMainListDtoList);

        InsureMainListDto insureMainListDto;
        List<PrpCitemKindDto> prpCitemKindDtoList = blPolicy.getPrpCitemKindDtoList();
        PrpCmainDto prpCmainDto = blPolicy.getPrpCmainDto();
        List<Planting31PolicyListDto> planting31PolicyListDtoList = new ArrayList<>();
        List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
        List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>();

        strRiskCode = prpCmainDto.getRiskCode();

        if (insureMainListDtoList.size() > 0) {
            herdPolicyListDtoList = plantingPolicyListApi.queryHerdByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
            blPolicy.setHerdPolicyListDtoList(herdPolicyListDtoList);
            if (("3141".equals(strRiskCode)) || ("3147".equals(strRiskCode))) {
                Map<String,String> map=new HashMap<>();
                map.put("inusreListCode",insureMainListDtoList.get(0).getInusreListCode());
                planting31PolicyListDtoList = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
                blPolicy.setPlanting31PolicyListDtoList(planting31PolicyListDtoList);
            }
            // 二期平台改造新加清单的险种,取nyxpolicy数据
            else if (("3224".equals(strRiskCode)||"3134".equals(strRiskCode)) || nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)) {
                nyxPolicyListDtoList = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
                blPolicy.setNyxPolicyListDtoList(nyxPolicyListDtoList);
            } else {
                List<PlantingPolicyListDto> plantingPolicyListDtoList = plantingPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                blPolicy.setPlantingPolicyListDtoList(plantingPolicyListDtoList);
            }

        }
        intEndorseTimes = prpCmainDto.getEndorseTimes();

        /**2、置Prp*itemKind.Flag[1]**/

        /**3、获取批单号：根据保单号生成批单号**/
        // 调用批单号生成接口
        strEndorseNo = billNoApi.getNos(AgriPrpallConstant.ENDORSRE_TABLE.trim(), strPolicyNo);

        /**4、批单头的赋值**/
        //其他信息在BLEndorse.generatePrpPhead()生成
        prpPheadDto.setEndorseNo(strEndorseNo);
        prpPheadDto.setPolicyNo(strPolicyNo);
        prpPheadDto.setMakeCom(strMakeCom);
        prpPheadDto.setCompensateNo(strCompensateNo);
        prpPheadDto.setEndorType(strEndorType);
        String endorseDate=sdf.format(strEndorDate);
        strEndorDate=sdf.parse(endorseDate);
        String validDate=sdf.format(strValidDate);
        strValidDate=sdf.parse(validDate);
        prpPheadDto.setEndorDate(strEndorDate);
        prpPheadDto.setValidDate(strValidDate);
        prpPheadDto.setAppliName(strPrpPheadAppliName);
        prpPheadDto.setValidHour(intValidHour);
        prpPheadDto.setOperatorCode(strUserCode);
        prpPheadDto.setBatchNo(endorseConditionDto.getBatchNo());/** 获取批次号 */
        prpPheadDto.setInputDate(new SimpleDateFormat("yyyy-MM-dd").parse(chgDate.getCurrentTime("yyyy-MM-dd")));
        prpPheadDto.setInputHour(Integer.parseInt(chgDate.getCurrentTime("HH")));
        prpPheadDto.setEndorseType(strEndorseType1);
        prpPheadDto.setValidCountDate(new SimpleDateFormat("yyyy-MM-dd").parse(("9999-12-31")));
        prpPheadDto.setEndorseMessage(strEndorseMessage);
        if(intEndorseTimes==0){
            prpPheadDto.setEndorseTimes(intEndorseTimes);
        }else {
            prpPheadDto.setEndorseTimes(intEndorseTimes+1);
        }
        //生成批单对象
        blEndorse.setPrpPheadDto(prpPheadDto);

        //整单批改对分户信息的处理
        /** 调用补贴比例信息表修改接口 */
        if ("71".equals(strEndorType)) {
            if (prpCsubsidyDtos != null && prpCsubsidyDtos.size() > 0) {

                policyEndorseDto.setBlPolicyInfoDtoNew(blPolicy);
                policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyOld);
                blPolicy = specialEndor71Service.specialEndorse71(policyEndorseDto, prpCsubsidyDtos).getBlPolicyInfoDtoNew();
            } else {
                throw new DataVerifyException("补贴信息不能为空！");
            }
        }
        List<PrpCsubsidyDto> prpCsubsidyDtoList = blPolicy.getPrpCsubsidyDtoList();
        //reason:中央政策性种植险整单批改对分户信息的处理
        if (("3224".equals(strRiskCode)||"3134".equals(strRiskCode)) || nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)) {
            if (insureMainListDtoList.size() > 0) {
                nyxEndorHeadDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                nyxEndorHeadDto.setEndorseNo(strEndorseNo);
                nyxEndorHeadDto.setRiskCode(strRiskCode);
                nyxEndorHeadDto.setPolicyNo(strPolicyNo);
                nyxEndorHeadDto.setListFlag("0");
                nyxEndorHeadDto.setEndorFlag(strEndorType);
                blEndorse.setNyxEndorHeadDto(nyxEndorHeadDto);
            }
        }
        double amountNew=0.0;
        if("11".equals(strEndorType)||"91".equals(strEndorType)||"01".equals(strEndorType)||"71".equals(strEndorType)){

        //将入参险别信息放入map
        String strKey = "";
        HashMap<String, PrpCitemKindDto> itemkindMap = new HashMap<>();

        if("3147".equals(strRiskCode)&&prpCitemKindDtos==null){
            List<PrpCitemKindDto> prpCitemKindDtoList1=prpCitemKindService.findItemByPolicyNo(strPolicyNo);
            prpCitemKindDtos=prpCitemKindDtoList1;
        }
        if(prpCitemKindDtos!=null&&prpCitemKindDtos.size()>0){
            for (int j = 0; j < prpCitemKindDtos.size(); j++) {
                strKey = prpCitemKindDtoList.get(j).getKindCode() + "-"
                        + prpCitemKindDtoList.get(j).getItemCode();
                itemkindMap.put(strKey, prpCitemKindDtos.get(j));
            }
        }

        /***********************************************************************5、对Prp*itemKind的处理************************************************************/
        for (index = 0; index < prpCitemKindDtoList.size(); index++) {

            dblShortRateOld = prpCitemKindDtoList.get(index).getShortRate();
            //变更保险期限（01）
            intStartHourOld = blPolicy.getPrpCitemKindDtoList().get(index).getStartHour();
            intStartHour = Integer.parseInt(ChgData.chgStrZero(strStartHour));
            //终保日期
            endDateOld = blPolicy.getPrpCitemKindDtoList().get(index).getEndDate();
            intEndHourOld = blPolicy.getPrpCitemKindDtoList().get(index).getEndHour();
            intEndHour = Integer.parseInt(ChgData.chgStrZero(strEndHour));
            startDate = sdf.parse(strStartDate);
            endDate = sdf.parse(strEndDate);
            startDateOld=blPolicy.getPrpCitemKindDtoList().get(index).getStartDate();
            //清单表的保费
            double pAmountNew=0.00;
            double pPremiumNew=0.00;

            //prpcitemkind表的保费
            dblPremiumOld = prpCitemKindDtoList.get(index).getPremium();
            dblPremiumNew = prpCitemKindDtoList.get(index).getPremium();
            //prpcitemkind表的保额
            double amountOld = prpCitemKindDtoList.get(index).getAmount();
            amountNew = prpCitemKindDtoList.get(index).getAmount();
            //费率
            double rateOld=prpCitemKindDtoList.get(index).getRate();
            double rateNew=prpCitemKindDtoList.get(index).getRate();

            if ("01".equals(strEndorType)) {
                dblShortRate = pubTools.calPeriodShortRate(
                        new com.sinosoft.utility.string.Date(sdf.format(startDate)), intStartHour,
                        new com.sinosoft.utility.string.Date(sdf.format(endDate)), intEndHour,
                        new com.sinosoft.utility.string.Date(sdf.format(startDateOld)), intStartHourOld,
                        new com.sinosoft.utility.string.Date(sdf.format(endDateOld)), intEndHourOld,
                        strShortRateFlag, dblShortRateOld,
                        strRiskCode);
                dblPremiumNew = pubTools.calculateByPeriod(strRiskCode, dblPremiumOld, dblShortRateOld, dblShortRate);
                //起保日期
                blPolicy.getPrpCitemKindDtoList().get(index).setStartDate(sdf.parse(strStartDate));
                blPolicy.getPrpCitemKindDtoList().get(index).setStartHour(Integer.parseInt(strStartHour));
                //终保日期
                blPolicy.getPrpCitemKindDtoList().get(index).setEndDate(sdf.parse(strEndDate));
                blPolicy.getPrpCitemKindDtoList().get(index).setEndHour(Integer.parseInt(strEndHour));
                blPolicy.getPrpCitemKindDtoList().get(index).setShortRate(dblShortRate);
                blPolicy.getPrpCitemKindDtoList().get(index).setShortRateFlag(strShortRateFlag);

                strFlag1 = "U";
            } else if ("11".equals(strEndorType)) {//调整费率保额不变
                strKey = prpCitemKindDtoList.get(index).getKindCode() + "-"
                        + prpCitemKindDtoList.get(index).getItemCode();
                if (itemkindMap.containsKey(strKey)) {

                    PrpCitemKindDto prpCitemKindDtoInput = itemkindMap.get(strKey);

                    PrpCitemKindDto prpCitemKindDtoNew = blPolicy.getPrpCitemKindDtoList().get(index);

                    if (prpCitemKindDtoInput.getRate() != null && prpCitemKindDtoInput.getRate() != prpCitemKindDtoNew.getRate()) {

                        strFlag1 = "U";
                        //strShortRateFlag=prpCitemKindDtoInput.getShortRateFlag();
                        prpCitemKindDto = prpCitemKindDtoList.get(index);
                        //新短期系数=原短期系数
                        //       +新保险期限、新短期费率方式计算的短期系数
                        //       -原保险期限、新短期费率方式计算的短期系数

                        dblShortRate = pubTools.calPeriodShortRate(
                                new com.sinosoft.utility.string.Date(sdf.format(startDate)), intStartHour,
                                new com.sinosoft.utility.string.Date(sdf.format(endDate)), intEndHour,
                                new com.sinosoft.utility.string.Date(sdf.format(startDateOld)), intStartHourOld,
                                new com.sinosoft.utility.string.Date(sdf.format(endDateOld)), intEndHourOld,
                                strShortRateFlag, dblShortRateOld,
                                strRiskCode);
                        dblPremiumNew = pubTools.formulizePremium(prpCitemKindDto, prpCitemKindDto.getAmount(),
                                prpCitemKindDtos.get(index).getRate(),
                                dblShortRate, prpCitemKindDto.getAdjustRate());
                        prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                        prpCitemKindDtoList.get(index).setShortRateFlag(strShortRateFlag);
                        if("3".equals(strShortRateFlag)){
                            prpCitemKindDtoList.get(index).setShortRate(100.0000);
                        }else {
                            prpCitemKindDtoList.get(index).setShortRate(dblShortRate);
                        }

                        rateNew=prpCitemKindDtoInput.getRate();
                        prpCitemKindDtoNew.setRate(rateNew);
                    }
                }
            } else if ("91".equals(strEndorType)) {

                strKey = prpCitemKindDtoList.get(index).getKindCode() + "-"
                        + prpCitemKindDtoList.get(index).getItemCode();
                String prpCitemKindAgriKey=prpCitemKindDtoList.get(index).getItemKindNo()+"-"+prpCitemKindDtoList.get(index).getKindCode();
                for(int i=0;i<blPolicy.getPrpCitemKindAgriDtoList().size();i++){
                    if (prpCitemKindAgriKey.equals(blPolicy.getPrpCitemKindAgriDtoList().get(i).getItemKindNo()+"-"+blPolicy.getPrpCitemKindAgriDtoList().get(i).getKindCode())) {
                        blPolicy.getPrpCitemKindAgriDtoList().get(i).setUnitAmount(prpCitemKindDtos.get(index).getUnitAmount());
                    }
                }
                if (itemkindMap.containsKey(prpCitemKindDtoList.get(index).getKindCode() + "-"
                        + prpCitemKindDtoList.get(index).getItemCode())) {
                    PrpCitemKindDto prpCitemKindDtoInput = itemkindMap.get(strKey);
                    PrpCitemKindDto prpCitemKindDtoNew = blPolicy.getPrpCitemKindDtoList().get(index);
                    if (prpCitemKindDtoInput.getUnitAmount() != null && prpCitemKindDtoInput.getUnitAmount() != prpCitemKindDtoNew.getUnitAmount()) {
                        prpCitemKindDtoNew.setUnitAmount(prpCitemKindDtoInput.getUnitAmount());
                        strFlag1 = "U";
                        amountNew = prpCitemKindDtoList.get(index).getQuantity() * prpCitemKindDtos.get(index).getUnitAmount();
                        prpCitemKindDto = prpCitemKindDtoList.get(index);
                        //先计算变动后各险别保额
                        dblShortRate = pubTools.calPeriodShortRate(
                                new com.sinosoft.utility.string.Date(sdf.format(startDate)), intStartHour,
                                new com.sinosoft.utility.string.Date(sdf.format(endDate)), intEndHour,
                                new com.sinosoft.utility.string.Date(sdf.format(startDateOld)), intStartHourOld,
                                new com.sinosoft.utility.string.Date(sdf.format(endDateOld)), intEndHourOld,
                                strShortRateFlag, dblShortRateOld,
                                strRiskCode);
                        dblPremiumNew = pubTools.formulizePremium(prpCitemKindDto, amountNew,
                                prpCitemKindDto.getRate(), dblShortRate,
                                prpCitemKindDto.getAdjustRate());

                        blPolicy.getPrpCitemKindDtoList().get(index).setAmount(amountNew);
                        //prpCmainService.findEffectiveAmountByPolicyNo(strPolicyNo);
                        prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                        strShortRateFlag=prpCitemKindDtoInput.getShortRateFlag();
                        if("3".equals(strShortRateFlag)){
                            prpCitemKindDtoList.get(index).setShortRate(100.0000);
                        }else {
                            prpCitemKindDtoList.get(index).setShortRate(dblShortRate);
                        }
                        prpCitemKindDtoList.get(index).setShortRateFlag(strShortRateFlag);
                    }
                }
            }else if("71".equals(strEndorType)){
                blPolicy.getPrpCitemKindDtoList().get(index).setFlag(" 1");
            }
            //新短期系数=原短期系数
            //       +新保险期限、新短期费率方式计算的短期系数
            //       -原保险期限、新短期费率方式计算的短期系数


            /****************养殖险**************/
            if (StringUtils.isNotEmpty(breedingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode)
                    && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && !"3224".equals(strRiskCode)) {
                if (insureMainListDtoList.size() > 0) {
                    List<HerdEndorHeadDto> herdEndorHeadDtoList = new ArrayList<>();
                    //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                    double subSidyRate = 0;
                    double selfRate = 1;
                    dblPremiumNew=0.0;
                    for (int k = 0; k < prpCsubsidyDtoList.size(); k++) {
                        subSidyRate += prpCsubsidyDtoList.get(k).getSubsidyRate();
                    }
                    selfRate = (100 - subSidyRate) / 100;
                    for (int i = 0; i < herdPolicyListDtoList.size(); i++) {
                        if ("1".equals(herdPolicyListDtoList.get(i).getValidity())) {

                            //获得短期系数
                            dblShortRateOld = herdPolicyListDtoList.get(i).getShortRate();
                            //新短期系数+新保险期限、新短期费率方式计算的短期系数-原保险期限、新短期费率方式计算的短期系数
                            if ("71".equals(strEndorType)) {
                                dblShortRate = dblShortRateOld;
                                amountNew = blPolicy.getHerdPolicyListDtoList().get(i).getSumAmount();
                                pPremiumNew = blPolicy.getHerdPolicyListDtoList().get(i).getSumPremium();
                            }
                            //批改前保费
                            dblPremiumOld = blPolicy.getHerdPolicyListDtoList().get(i).getSumPremium();
                            //批改后保费

                            if ("01".equals(strEndorType)) {
                                pPremiumNew = pubTools.calculateByPeriod(strRiskCode, herdPolicyListDtoList.get(i).getSumPremium(), dblShortRateOld, dblShortRate);
                                blPolicy.getHerdPolicyListDtoList().get(i).setEndDate(sdf.parse(strEndDate));
                                amountNew = blPolicy.getHerdPolicyListDtoList().get(i).getSumAmount();
                            } else if ("11".equals(strEndorType)) {//调整费率保额
                                amountNew = blPolicy.getHerdPolicyListDtoList().get(i).getSumAmount();
                                //变动后保额不变，计算保费
                                pPremiumNew = pubTools.calculatePremium(herdPolicyListDtoList.get(i).getSumAmount(), amountNew
                                        , rateOld / 100, rateNew / 100,
                                        1.0, 1.0, dblShortRate/ 100,
                                        herdPolicyListDtoList.get(i).getSumPremium());
                            } else if ("91".equals(strEndorType)) {
                                //先计算变动后别保额
                                amountNew = blPolicy.getHerdPolicyListDtoList().get(i).getInsureNumber() * prpCitemKindDtoList.get(index).getUnitAmount();
                                //变动后保额不变，计算保费
                                prpCitemKindDto = prpCitemKindDtoList.get(index);
                                pPremiumNew = pubTools.formulizePremium(prpCitemKindDto, amountNew,
                                        prpCitemKindDto.getRate(), dblShortRate,
                                        prpCitemKindDto.getAdjustRate());
                            }
                            //短期费率方式
                            blPolicy.getHerdPolicyListDtoList().get(i).setShortRateFlag(strShortRateFlag);
                            //短期系数
                            blPolicy.getHerdPolicyListDtoList().get(i).setShortRate(dblShortRate);
                            //保费
                            blPolicy.getHerdPolicyListDtoList().get(i).setSumPremium(pPremiumNew);
                            blPolicy.getHerdPolicyListDtoList().get(i).setSumAmount(amountNew);
                            //农户自缴保费
                            blPolicy.getHerdPolicyListDtoList().get(i).setInsurePremium(Str.round(pPremiumNew * selfRate, 2));
                            blPolicy.getHerdPolicyListDtoList().get(i).setFlag("U");
                            blPolicy.getHerdPolicyListDtoList().get(i).setSumPremium(amountNew);
                            blPolicy.getHerdPolicyListDtoList().get(i).setAmount(prpCitemKindDtoList.get(index).getUnitAmount());
                            dblPremiumNew = dblPremiumNew + pPremiumNew;
                        }
                    }
                    if(!"71".equals(strEndorType)) {
                        blPolicy.getPrpCitemKindDtoList().get(index).setPremium(dblPremiumNew);
                        blPolicy.getPrpCitemKindDtoList().get(index).setBenchmarkPremium(dblPremiumNew);
                        blPolicy.getPrpCitemKindDtoList().get(index).setBasePremium(dblPremiumNew);
                    }
                    if (insureMainListDtoList.size() <= 0) {
                        throw new Exception("清单主表缺少数据！");
                    }
                    //养殖险（整单批改）批改头表
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

            strFlag = prpCitemKindDtoList.get(index).getFlag();
            if (strFlag != null && strFlag.length() > 0) {
                strFlag = strFlag1 + strFlag.substring(1);
            } else {
                strFlag = strFlag1;
            }
            /* reason：将批改保险期限做为特殊批改处理（即做为单独的菜单），与普通批改分离 */
            /** 特殊批改:变更保险期限:险种为3147的情况下 */
            if (("3147").equals(strRiskCode)||("3141").equals(strRiskCode)) {
                //短期费率方式
                prpCitemKindDtoList.get(index).setShortRateFlag(strShortRateFlag);
                //保费
                if (null != breedingFarmerListFlag && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && insureMainListDtoList.size() > 0) {
                } else {
                    prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                }
                prpCitemKindDtoList.get(index).setFlag(strFlag);

                //中央政策性种植险变更终保日期
                if (StringUtils.isNotEmpty(strRiskCode)) {
                    strKindCode = prpCitemKindDtoList.get(index).getKindCode()+"-"+prpCitemKindDtoList.get(index).getItemCode();
                    if (insureMainListDtoList.size() > 0) {
                        String pSubsidyCode = "";
                        String pSubsidyRate = "";
                        BigDecimal pFPremium = null;
                        BigDecimal perPremium = null;
                        double pSumPremiumOld=0.0;
                        double pShortRateOld=0.0;
                        List<PrpCsubsidyDto> bLPrpCsubsidy = prpCsubsidyDtoList;
                        //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                        double subSidyRateTemp = 0;
                        double selfRateTemp = 1;
                        dblPremiumNew=0.0;
                        for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                            subSidyRateTemp += Double.parseDouble(pubTools.chgZero(prpCsubsidyDtoList.get(k).getSubsidyRate()));
                        }
                        selfRateTemp = (100 - subSidyRateTemp) / 100;
                        PrpCsubsidyDto prpCsubsidyDto;

                        for (int j = 0; j < planting31PolicyListDtoList.size(); j++) {
                            pSumPremiumOld=planting31PolicyListDtoList.get(j).getSumPremium();
                            pShortRateOld=planting31PolicyListDtoList.get(j).getShortRate();
                            if ("1".equals(planting31PolicyListDtoList.get(j).getValidity())) {
                                if (strKindCode.equals(planting31PolicyListDtoList.get(j).getKindCode() + "-" + planting31PolicyListDtoList.get(j).getItemCode())) {
                                    if ("01".equals(strEndorType)) {
                                        planting31PolicyListDtoList.get(j).setEndDate(sdf.parse(strEndDate));
                                        pAmountNew = blPolicy.getPlanting31PolicyListDtoList().get(j).getSumAmount();
                                        pPremiumNew = pubTools.calculateByPeriod(strRiskCode, pSumPremiumOld, pShortRateOld, dblShortRate);
                                    } else if ("71".equals(strEndorType)) {
                                        dblShortRate = dblShortRateOld;
                                        pAmountNew = blPolicy.getPlanting31PolicyListDtoList().get(j).getSumAmount();
                                        pPremiumNew = blPolicy.getPlanting31PolicyListDtoList().get(j).getSumPremium();
                                    }else if("11".equals(strEndorType)){
                                        //保费计算
                                        pPremiumNew = pubTools.calculatePremium(planting31PolicyListDtoList.get(j).getSumAmount(), planting31PolicyListDtoList.get(j).getSumAmount()
                                                , planting31PolicyListDtoList.get(j).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, dblShortRate / 100,
                                                pSumPremiumOld);
                                    }else if("91".equals(strEndorType)){
                                        pAmountNew = blPolicy.getPlanting31PolicyListDtoList().get(j).getInsureArea() * prpCitemKindDtoList.get(index).getUnitAmount();
                                        pPremiumNew = pubTools.calculatePremium(planting31PolicyListDtoList.get(j).getSumAmount(), amountNew
                                                , planting31PolicyListDtoList.get(j).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, planting31PolicyListDtoList.get(j).getShortRate() / 100,
                                                pSumPremiumOld);
                                    }
                                    planting31PolicyListDtoList.get(j).setSumPremium(pPremiumNew);
                                    planting31PolicyListDtoList.get(j).setFlag("U");
                                    planting31PolicyListDtoList.get(j).setAmount(prpCitemKindDtoList.get(index).getUnitAmount());
                                    planting31PolicyListDtoList.get(j).setSumAmount(pAmountNew);
                                    planting31PolicyListDtoList.get(j).setShortRateFlag(strShortRateFlag);
                                    planting31PolicyListDtoList.get(j).setShortRate(dblShortRate);
                                    // 71 补贴比例已在前面回写，此处自缴保费直接按照前面计算的自缴比例计算即可
                                    pFPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(selfRateTemp)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    planting31PolicyListDtoList.get(j).setfPremium(pFPremium.doubleValue());
                                    BigDecimal govPremium = new BigDecimal(0);
                                    for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                                        prpCsubsidyDto = bLPrpCsubsidy.get(k);
                                        pSubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                        pSubsidyRate = pubTools.chgZero(prpCsubsidyDto.getSubsidyRate());
                                        if (k == bLPrpCsubsidy.size() - 1) {//尾差调整
                                            perPremium = (new BigDecimal(pPremiumNew)).subtract(pFPremium).subtract(govPremium);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        } else {
                                            perPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(pSubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            govPremium = govPremium.add(perPremium);
                                            govPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        }
                                        if ("03".equals(pSubsidyCode)) {//中央财政
                                            planting31PolicyListDtoList.get(k).setCentralPremium(perPremium.doubleValue());
                                        } else if ("04".equals(pSubsidyCode)) {//省级财政
                                            planting31PolicyListDtoList.get(k).setProvincePremium(perPremium.doubleValue());
                                        } else if ("05".equals(pSubsidyCode)) {//地市县财政
                                            planting31PolicyListDtoList.get(k).setCityPremium(perPremium.doubleValue());
                                        } else if ("07".equals(pSubsidyCode)) {//县(区)财政
                                            planting31PolicyListDtoList.get(k).setTownPremium(perPremium.doubleValue());
                                        } else if ("06".equals(pSubsidyCode)) {//其他来源
                                            planting31PolicyListDtoList.get(k).setOtherPremium(perPremium.doubleValue());
                                        }
                                    }
                                    dblPremiumNew = dblPremiumNew + Double.parseDouble(format.format(pPremiumNew));
                                }
                            }
                        }
                        if(!"71".equals(strEndorType)) {
                            prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBenchmarkPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBasePremium(dblPremiumNew);
                        }
                    }
                }
                //add by Pao 20111127 end reason:中央政策性种植险变更终保日期
                /** 特殊批改:变更保险期限:险种为3224的情况下 */
            } else if (("3224").equals(strRiskCode) || ("3134").equals(strRiskCode)) {
                //Flag
                prpCitemKindDtoList.get(index).setFlag(strFlag);

                // reason:中央政策性种植险变更终保日期
                if (StringUtils.isNotEmpty(strRiskCode)) {
                    strKindCode = prpCitemKindDtoList.get(index).getKindCode();
                    if (insureMainListDtoList.size() > 0) {
                        String pSubsidyCode = "";
                        String pSubsidyRate = "";
                        BigDecimal pFPremium = null;
                        BigDecimal perPremium = null;
                        dblPremiumNew=0.0;
                        double pSumPremiumOld=0.0;
                        double pShortRateOld=0.0;
                        List<PrpCsubsidyDto> bLPrpCsubsidy = prpCsubsidyDtoList;
                        //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                        double subSidyRateTemp = 0;
                        double selfRateTemp = 1;
                        for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                            subSidyRateTemp += prpCsubsidyDtoList.get(k).getSubsidyRate();
                        }
                        selfRateTemp = (100 - subSidyRateTemp) / 100;
                        PrpCsubsidyDto prpCsubsidyDto = new PrpCsubsidyDto();

                        for (int j = 0; j < nyxPolicyListDtoList.size(); j++) {
                            pSumPremiumOld=nyxPolicyListDtoList.get(j).getSumPremium();
                            pShortRateOld=nyxPolicyListDtoList.get(j).getShortRate();
                            if ("1".equals(nyxPolicyListDtoList.get(j).getValidity())) {
                                if (strKindCode.equals(nyxPolicyListDtoList.get(j).getKindCode())) {
                                    if ("01".equals(strEndorType)) {
                                        nyxPolicyListDtoList.get(j).setEndDate(sdf.parse(strEndDate));
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(j).getSumAmount();
                                        pPremiumNew = pubTools.calculateByPeriod(strRiskCode, pSumPremiumOld, pShortRateOld, dblShortRate);
                                    } else if ("71".equals(strEndorType)) {
                                        dblShortRate = dblShortRateOld;
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(j).getSumAmount();
                                        pPremiumNew = blPolicy.getNyxPolicyListDtoList().get(j).getSumPremium();
                                    }else if("11".equals(strEndorType)){
                                        //保费计算
                                        pPremiumNew = pubTools.calculatePremium(nyxPolicyListDtoList.get(j).getSumAmount(), nyxPolicyListDtoList.get(j).getSumAmount()
                                                , nyxPolicyListDtoList.get(j).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, dblShortRate / 100,
                                                pSumPremiumOld);
                                    }else if("91".equals(strEndorType)){
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(j).getInsureArea() * prpCitemKindDtoList.get(index).getUnitAmount();
                                        pPremiumNew = pubTools.calculatePremium(nyxPolicyListDtoList.get(j).getSumAmount(), amountNew
                                                , nyxPolicyListDtoList.get(j).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, nyxPolicyListDtoList.get(j).getShortRate() / 100,
                                                pSumPremiumOld);
                                    }
                                    nyxPolicyListDtoList.get(j).setSumPremium(pPremiumNew);
                                    nyxPolicyListDtoList.get(j).setEndDate(sdf.parse(strEndDate));
                                    nyxPolicyListDtoList.get(j).setFlag("U");
                                    nyxPolicyListDtoList.get(j).setAmount(prpCitemKindDtoList.get(index).getUnitAmount());
                                    nyxPolicyListDtoList.get(j).setSumAmount(pAmountNew);
                                    nyxPolicyListDtoList.get(j).setShortRate(dblShortRate);
                                    nyxPolicyListDtoList.get(j).setShortRateFlag(strShortRateFlag);
                                    pFPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(selfRateTemp)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    nyxPolicyListDtoList.get(j).setfPremium(pFPremium.doubleValue());

                                    BigDecimal govPremium = new BigDecimal(0);
                                    for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                                        prpCsubsidyDto = bLPrpCsubsidy.get(k);
                                        pSubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                        pSubsidyRate = pubTools.chgZero(prpCsubsidyDto.getSubsidyRate());
                                        if (k == bLPrpCsubsidy.size() - 1) {
                                            perPremium = (new BigDecimal(pPremiumNew)).subtract(pFPremium).subtract(govPremium);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        } else {
                                            perPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(pSubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            govPremium = govPremium.add(perPremium);
                                            govPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        }
                                        if ("03".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(k).setCentralPremium(perPremium.doubleValue());
                                        } else if ("04".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(k).setProvincePremium(perPremium.doubleValue());
                                        } else if ("05".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(k).setCityPremium(perPremium.doubleValue());
                                        } else if ("07".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(k).setTownPremium(perPremium.doubleValue());
                                        } else if ("06".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(k).setOtherPremium(perPremium.doubleValue());
                                        }
                                    }
                                    dblPremiumNew = dblPremiumNew + Double.parseDouble(format.format(pPremiumNew));
                                }
                            }
                        }
                        if(!"71".equals(strEndorType)) {
                            prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBenchmarkPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBasePremium(dblPremiumNew);
                        }
                    }
                }
                //reason:中央政策性种植险变更终保日期
            }
            /** 农险平台二期改造 新加清单的险种做处理 */
            else if (nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)) {
                //Flag
                prpCitemKindDtoList.get(index).setFlag(strFlag);

                // reason:中央政策性种植险变更终保日期
                if (StringUtils.isNotEmpty(strRiskCode)) {
                    strKindCode = prpCitemKindDtoList.get(index).getKindCode();
                    if (insureMainListDtoList.size() > 0) {
                        String pSubsidyCode = "";
                        String pSubsidyRate = "";
                        BigDecimal pFPremium = null;
                        BigDecimal perPremium = null;
                        dblPremiumNew=0.0;
                        double pSumPremiumOld=0.0;
                        double pShortRateOld=0.0;
                        List<PrpCsubsidyDto> bLPrpCsubsidy = prpCsubsidyDtoList;
                        //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                        double subSidyRateTemp = 0;
                        double selfRateTemp = 1;
                        for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                            subSidyRateTemp += prpCsubsidyDtoList.get(k).getSubsidyRate();
                        }
                        selfRateTemp = (100 - subSidyRateTemp) / 100;
                        PrpCsubsidyDto prpCsubsidyDto;

                        for (int i = 0; i < nyxPolicyListDtoList.size(); i++) {
                            pSumPremiumOld=nyxPolicyListDtoList.get(i).getSumPremium();
                            pShortRateOld=nyxPolicyListDtoList.get(i).getShortRate();
                            if ("1".equals(nyxPolicyListDtoList.get(i).getValidity())) {
                                if (strKindCode.equals(nyxPolicyListDtoList.get(i).getKindCode())) {
                                    if ("71".equals(strEndorType)) {
                                        dblShortRate = dblShortRateOld;
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(i).getSumAmount();
                                        pPremiumNew = blPolicy.getNyxPolicyListDtoList().get(i).getSumPremium();
                                    }
                                    if ("01".equals(strEndorType)) {
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(i).getSumAmount();
                                        pPremiumNew = pubTools.calculateByPeriod(strRiskCode, pSumPremiumOld, pShortRateOld, dblShortRate);
                                    } else if ("11".equals(strEndorType)) {
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(i).getSumAmount();
                                        pPremiumNew = pubTools.calculatePremium(nyxPolicyListDtoList.get(i).getSumAmount(), nyxPolicyListDtoList.get(i).getSumAmount()
                                                , nyxPolicyListDtoList.get(i).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, dblShortRate / 100,
                                                pSumPremiumOld);
                                    }else if("91".equals(strEndorType)){
                                        pAmountNew = blPolicy.getNyxPolicyListDtoList().get(i).getInsureArea() * prpCitemKindDtoList.get(index).getUnitAmount();
                                        pPremiumNew = pubTools.calculatePremium(nyxPolicyListDtoList.get(i).getSumAmount(), amountNew
                                                , nyxPolicyListDtoList.get(i).getRate() / 100, rateNew / 100,
                                                1.0, 1.0, nyxPolicyListDtoList.get(i).getShortRate() / 100,
                                                pSumPremiumOld);
                                    }
                                    nyxPolicyListDtoList.get(i).setSumPremium(pPremiumNew);
                                    nyxPolicyListDtoList.get(i).setEndDate(sdf.parse(strEndDate));
                                    nyxPolicyListDtoList.get(i).setSumAmount(pAmountNew);
                                    nyxPolicyListDtoList.get(i).setAmount(prpCitemKindDtoList.get(index).getUnitAmount());
                                    nyxPolicyListDtoList.get(i).setFlag("U");
                                    nyxPolicyListDtoList.get(i).setShortRateFlag(strShortRateFlag);
                                    nyxPolicyListDtoList.get(i).setShortRate(dblShortRate);
                                    pFPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(selfRateTemp)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    nyxPolicyListDtoList.get(i).setfPremium(pFPremium.doubleValue());

                                    BigDecimal govPremium = new BigDecimal(0);
                                    for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                        prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                        pSubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                        pSubsidyRate = pubTools.chgZero(prpCsubsidyDto.getSubsidyRate());
                                        if (j == bLPrpCsubsidy.size() - 1) {
                                            perPremium = (new BigDecimal(pPremiumNew)).subtract(pFPremium).subtract(govPremium);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        } else {
                                            perPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(pSubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                            perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            govPremium = govPremium.add(perPremium);
                                            govPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        }
                                        if ("03".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(i).setCentralPremium(perPremium.doubleValue());
                                        } else if ("04".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(i).setProvincePremium(perPremium.doubleValue());
                                        } else if ("05".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(i).setCityPremium(perPremium.doubleValue());
                                        } else if ("07".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(i).setTownPremium(perPremium.doubleValue());
                                        } else if ("06".equals(pSubsidyCode)) {
                                            nyxPolicyListDtoList.get(i).setOtherPremium(perPremium.doubleValue());
                                        }
                                    }
                                    dblPremiumNew = dblPremiumNew + Double.parseDouble(format.format(pPremiumNew));
                                }
                            }
                        }
                        if(!"71".equals(strEndorType)) {
                            prpCitemKindDtoList.get(index).setPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBenchmarkPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBasePremium(dblPremiumNew);
                        }
                    }
                }
                //System.err.println("农险平台二期改造 新加清单的险种做处理  变更保险期限");
                //add by Pao 20111127 end reason:中央政策性种植险变更终保日期
            }
            /**变更终保日期（现在系统只支持变更终保日期、但以下程序处理包含了同时变更起保日期、终保日期的类型）*/
            else {
                //保费
                if (null != breedingFarmerListFlag && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && insureMainListDtoList.size() > 0) {
                } else {
                    blPolicy.getPrpCitemKindDtoList().get(index).setPremium(dblPremiumNew);
                }
                //Flag
                blPolicy.getPrpCitemKindDtoList().get(index).setFlag(strFlag);
                //中央政策性种植险变更终保日期
                if (StringUtils.isNotEmpty(plantingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode)
                        && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
                    strKindCode = prpCitemKindDtoList.get(index).getKindCode();
                    if (insureMainListDtoList.size() > 0) {
                        String pSubsidyCode = "";
                        String pSubsidyRate = "";
                        double pShortRateOld = 0;
                        double pSumPremiumOld = 0;
                        BigDecimal pFPremium = null;
                        BigDecimal perPremium = null;
                        List<PrpCsubsidyDto> bLPrpCsubsidy = prpCsubsidyDtoList;
                        //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                        double subSidyRateTemp = 0;
                        double selfRateTemp = 1;
                        dblPremiumNew=0.0;
                        for (int k = 0; k < bLPrpCsubsidy.size(); k++) {
                            subSidyRateTemp += prpCsubsidyDtoList.get(k).getSubsidyRate();
                        }
                        selfRateTemp = (100 - subSidyRateTemp) / 100;
                        PrpCsubsidyDto prpCsubsidyDto;


                            for (int i = 0; i < blPolicy.getPlantingPolicyListDtoList().size(); i++) {
                                pSumPremiumOld=blPolicy.getPlantingPolicyListDtoList().get(i).getSumPremium();
                                pShortRateOld=blPolicy.getPlantingPolicyListDtoList().get(i).getShortRate();
                                if ("1".equals(blPolicy.getPlantingPolicyListDtoList().get(i).getValidity())) {
                                    if (strKindCode.equals(blPolicy.getPlantingPolicyListDtoList().get(i).getKindCode())) {
                                        pShortRateOld = blPolicy.getPlantingPolicyListDtoList().get(i).getShortRate().doubleValue();
                                        pSumPremiumOld = blPolicy.getPlantingPolicyListDtoList().get(i).getSumPremium().doubleValue();
                                        if ("71".equals(strEndorType)) {
                                            dblShortRate = dblShortRateOld;
                                            pAmountNew = blPolicy.getPlantingPolicyListDtoList().get(i).getSumAmount();
                                            pPremiumNew = blPolicy.getPlantingPolicyListDtoList().get(i).getSumPremium();
                                        }
                                        if ("01".equals(strEndorType)) {
                                            pAmountNew = blPolicy.getPlantingPolicyListDtoList().get(i).getSumAmount();
                                            pPremiumNew = pubTools.calculateByPeriod(strRiskCode, pSumPremiumOld, pShortRateOld, dblShortRate);
                                        } else if ("11".equals(strEndorType)) {
                                            pAmountNew = blPolicy.getPlantingPolicyListDtoList().get(i).getSumAmount();
                                            pPremiumNew = pubTools.calculatePremium(blPolicy.getPlantingPolicyListDtoList().get(i).getSumAmount(), pAmountNew
                                                    , rateOld / 100, rateNew / 100,
                                                    1.0, 1.0, dblShortRate / 100,
                                                    pSumPremiumOld);
                                        }else if("91".equals(strEndorType)){
                                            pAmountNew = blPolicy.getPlantingPolicyListDtoList().get(i).getInsureArea() * prpCitemKindDtoList.get(index).getUnitAmount();
                                            pPremiumNew = pubTools.calculatePremium(blPolicy.getPlantingPolicyListDtoList().get(i).getSumAmount(), amountNew
                                                    , blPolicy.getPlantingPolicyListDtoList().get(i).getRate() / 100, rateNew / 100,
                                                    1.0, 1.0, blPolicy.getPlantingPolicyListDtoList().get(i).getShortRate() / 100,
                                                    pSumPremiumOld);
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setAmount(blPolicy.getPrpCitemKindDtoList().get(index).getUnitAmount());
                                    }
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setSumAmount(amountNew);
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setSumPremium(pPremiumNew);
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setEndDate(sdf.parse(strEndDate));
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setFlag("U");
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setShortRateFlag(strShortRateFlag);
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setShortRate(dblShortRate);

                                        pFPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(selfRateTemp)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                        blPolicy.getPlantingPolicyListDtoList().get(i).setfPremium(pFPremium.doubleValue());

                                        BigDecimal govPremium = new BigDecimal(0);
                                        for (int j = 0; j < bLPrpCsubsidy.size(); j++) {
                                            prpCsubsidyDto = bLPrpCsubsidy.get(j);
                                            pSubsidyCode = prpCsubsidyDto.getSubsidyCode();
                                            pSubsidyRate = pubTools.chgZero(prpCsubsidyDto.getSubsidyRate());
                                            if (j == bLPrpCsubsidy.size() - 1) {
                                                perPremium = (new BigDecimal(pPremiumNew)).subtract(pFPremium).subtract(govPremium);
                                                perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            } else {
                                                perPremium = (new BigDecimal(pPremiumNew)).multiply(new BigDecimal(pSubsidyRate)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                                                perPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                                govPremium = govPremium.add(perPremium);
                                                govPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            }
                                            if ("03".equals(pSubsidyCode)) {
                                                blPolicy.getPlantingPolicyListDtoList().get(i).setCentralPremium(perPremium.doubleValue());
                                            } else if ("04".equals(pSubsidyCode)) {
                                                blPolicy.getPlantingPolicyListDtoList().get(i).setProvincePremium(perPremium.doubleValue());
                                            } else if ("05".equals(pSubsidyCode)) {
                                                blPolicy.getPlantingPolicyListDtoList().get(i).setCityPremium(perPremium.doubleValue());
                                            } else if ("07".equals(pSubsidyCode)) {
                                                blPolicy.getPlantingPolicyListDtoList().get(i).setTownPremium(perPremium.doubleValue());
                                            } else if ("06".equals(pSubsidyCode)) {
                                                blPolicy.getPlantingPolicyListDtoList().get(i).setOtherPremium(perPremium.doubleValue());
                                            }
                                        }
                                        dblPremiumNew = dblPremiumNew + Double.parseDouble(format.format(pPremiumNew));
                                    }
                                }
                            }
                        if(!"71".equals(strEndorType)) {
                            blPolicy.getPrpCitemKindDtoList().get(index).setPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBenchmarkPremium(dblPremiumNew);
                            blPolicy.getPrpCitemKindDtoList().get(index).setBasePremium(dblPremiumNew);
                        }

                    }
                }
            }

            // Reason:给itemKindAgri的Flag赋值
            if (blPolicy.getPrpCitemKindAgriDtoList().size() > 0 && !"71".equals(strEndorType)) {
                blPolicy.getPrpCitemKindAgriDtoList().get(index).setFlag(strFlag);
            }
        }

    }
        /***************************************************citemkind end ************************************/
        //存储农险特有信息变化prpcitemkindagri
        if(blPolicy.getPrpCitemKindAgriDtoList().get(0).getFlag()==null){
            blPolicy.getPrpCitemKindAgriDtoList().get(0).setFlag("");
        }
        if(!"71".equals(strEndorType)){
            int flagLength1=blPolicy.getPrpCitemKindAgriDtoList().get(0).getFlag().length();
            //blPolicy.getBlPrpCitemKindAgri().getArr(0).setGrossQuantity(String.valueOf(sumQuantity));
            if(flagLength1>1){
                blPolicy.getPrpCitemKindAgriDtoList().get(0).setFlag("U"+blPolicy.getPrpCitemKindAgriDtoList().get(0).getFlag().substring(1,flagLength1));
            }else{
                blPolicy.getPrpCitemKindAgriDtoList().get(0).setFlag("U");
            }
        }
        //存储农险特有信息变化prpcmainagri
        //blPolicy.getBLPrpCmainAgri().getArr(0).setSelfPremium(String.valueOf(SelfPremium));
        blPolicy.getPrpCmainAgriDto().setFlag("U");

        //6、生成Fee表的数据
        List<PrpCfeeDto> prpCfeeDtoList = blPolicyOld.getPrpCfeeDtoList();
        PrpCitemKindDto prpCitemkindDto;
        PrpCfeeDto prpCfeeDto;
        PrpCfeeDto prpCfeeOldDto;
        //有保费变化的特殊批改：01、19、21、保单币别没有变化（原币、保单汇总币别、支付保费币别）
        //xiaojian_leave：犹豫期退保是否可以如此处理
        for(index=0;index<blPolicy.getPrpCitemKindDtoList().size();index++)
        {
            //此时PrpCitemKind已经是上面处理后的
            prpCitemkindDto = blPolicy.getPrpCitemKindDtoList().get(index);
            if(prpCitemkindDto.getFlag().length()>0)
                strFlag1 = prpCitemkindDto.getFlag().substring(0,1);
            else
                strFlag1 = "";
            //xiaojian_leave：目前险判断以下两种类型，待以后补充
            if(strFlag1.equals("B")||strFlag1.equals("D"))
                strFlag1 = "U";

            for(indexOld=0;indexOld<prpCfeeDtoList.size();indexOld++)
            {
                prpCfeeOldDto = prpCfeeDtoList.get(indexOld);

                //6.1、如果原币不相同不进行处理
                if(!prpCfeeOldDto.getCurrency().equals(prpCitemkindDto.getCurrency()))
                    continue;
                //6.2、从哈希表中获得已经有的Fee的数据，进行累加
                prpCfeeDto = (PrpCfeeDto) feeHashtable.get(prpCitemkindDto.getCurrency());
                if(prpCfeeDto==null)
                {
                    prpCfeeDto = new PrpCfeeDto();
                }
                //6.3、获得原保单币别信息
                strCurrency2 = prpCfeeOldDto.getCurrency2();
                strCurrency1 = prpCfeeOldDto.getCurrency1();
                dblExchangeRate2 = prpCfeeOldDto.getExchangeRate2();
                dblExchangeRate1 = prpCfeeOldDto.getExchangeRate1();
                //6.4、赋值
                prpCfeeDto.setPolicyNo(prpCitemkindDto.getPolicyNo());
                prpCfeeDto.setRiskCode(prpCitemkindDto.getRiskCode());
                //原币
                prpCfeeDto.setCurrency(prpCitemkindDto.getCurrency());
                if(prpCitemkindDto.getCalculateFlag().trim().equals("Y"))
                {
                    dblAmount = Str.round(pubTools.nullToDouble(prpCfeeDto.getAmount()),2)
                            + Str.round(pubTools.nullToDouble(prpCitemkindDto.getAmount()),2);
                    prpCfeeDto.setAmount(Str.round(dblAmount,2));
                }
                else
                {
                    dblAmount = Str.round(pubTools.nullToDouble(prpCfeeDto.getAmount()),2);
                    prpCfeeDto.setAmount(dblAmount);
                }

                dblPremium = Str.round(pubTools.nullToDouble(prpCfeeDto.getPremium()),4)
                        + Str.round(pubTools.nullToDouble(prpCitemkindDto.getPremium()),4);

                prpCfeeDto.setPremium(Str.round(dblPremium,4));
                //保单汇总币别
                dblAmount2 = dblAmount*dblExchangeRate2;
                dblPremium2 = dblPremium*dblExchangeRate2;
                prpCfeeDto.setCurrency2(strCurrency2);
                prpCfeeDto.setExchangeRate2(dblExchangeRate2);
                prpCfeeDto.setAmount2(Str.round(dblAmount2,2));
                prpCfeeDto.setPremium2(Str.round(dblPremium2,4));
                //支付保费币别
                dblAmount1 = dblAmount*dblExchangeRate1;
                dblPremium1 = dblPremium*dblExchangeRate1;
                prpCfeeDto.setCurrency1(strCurrency1);
                prpCfeeDto.setExchangeRate1(dblExchangeRate1);
                prpCfeeDto.setAmount1(Str.round(dblAmount1,2));
                prpCfeeDto.setPremium1(Str.round(dblPremium1,4));
                if(prpCfeeDto.getFlag().length()==0)
                    prpCfeeDto.setFlag(strFlag1);
                feeHashtable.put(prpCitemkindDto.getCurrency(),prpCfeeDto);
                break;
            }
        }

        Object[] arrObject = feeHashtable.values().toArray();

        for(index=0;index<arrObject.length;index++)
        {
            blPolicy.getPrpCfeeDtoList().add((PrpCfeeDto)arrObject[index]);
            dblSumPremium += ((PrpCfeeDto)arrObject[index]).getPremium2(); //Prp*main.SumPremium
        }

        blPolicy.getPrpCfeeDtoList().remove(0);
        double sumAmount=0.0;
        for(PrpCitemKindDto prpCitemKindDto1: blPolicy.getPrpCitemKindDtoList()){
            sumAmount+=prpCitemKindDto1.getAmount();
        }
        if(strEndorType.equals("01"))
        {
            //起保日期
            blPolicy.getPrpCmainDto().setStartDate(sdf.parse(strStartDate));
            blPolicy.getPrpCmainDto().setStartHour(Integer.parseInt(strStartHour));
            //终保日期
            blPolicy.getPrpCmainDto().setEndDate(endDate);
            blPolicy.getPrpCmainDto().setEndHour(Integer.parseInt(strEndHour));
            //总保费（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumPremium(dblSumPremium);

        }
        //保单注销（19）
        else if(strEndorType.equals("19"))
        {
            //总保额（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumAmount(0.00);
            //总保费（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumPremium(0.00);
        }
        //全单退保（21）
        else if(strEndorType.equals("21"))
        {
            //终保日期
            blPolicy.getPrpCmainDto().setEndDate(strValidDate);
            blPolicy.getPrpCmainDto().setEndHour(24);
            //总保额（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumAmount(0.00);
            //总保费（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumPremium(dblSumPremium);
        }else if(strEndorType.equals("11")){
            //总保费（保单汇总币别）
            blPolicy.getPrpCmainDto().setSumPremium(dblSumPremium);
        }else if(strEndorType.equals("91")){
            blPolicy.getPrpCmainDto().setSumPremium(dblSumPremium);
            blPolicy.getPrpCmainDto().setSumAmount(sumAmount);
        }
//        for(PrpCplanDto prpCplanDto:blPolicy.getPrpCplanDtoList()){
//            prpCplanDto.setFlag("I");
//        }
//        if(dblPremiumNew!=blPolicy.getPrpCmainDto().getSumPremium()) {
//            int SerialNo=blPolicy.getPrpCplanDtoList().size();
//            double planFeeSum=0;
//            for (int planIndex = 0; planIndex < blPolicy.getPrpCplanDtoList().size(); planIndex++) {
//                if (null != blPolicy.getPrpCplanDtoList().get(planIndex).getEndorseNo() && !"".equals(blPolicy.getPrpCplanDtoList().get(planIndex).getEndorseNo())) {
//                    //不做处理
//                } else {
//                    SerialNo++;
//                    PrpCplanDto prpCplanDto = new PrpCplanDto();
//                    PrpCplanDto prpCplanOldDto = new PrpCplanDto();
//                    prpCplanOldDto = blPolicy.getPrpCplanDtoList().get(planIndex);
//                    blPolicy.getPrpCplanDtoList().add(prpCplanDto);
//                    if ("R10".equals(prpCplanOldDto.getPayReason())) {
//                        prpCplanDto.setPayReason("P10");
//                        prpCplanDto.setPlanDate(strValidDate);
//                        prpCplanDto.setPlanStartDate(strValidDate);
//                    } else {
//                        prpCplanDto.setPayReason(prpCplanOldDto.getPayReason());
//                        prpCplanDto.setPlanDate(prpCplanOldDto.getPlanDate());
//                        prpCplanDto.setPlanStartDate(prpCplanOldDto.getPlanStartDate());
//                    }
//                    prpCplanDto.setPolicyNo(prpCplanOldDto.getPolicyNo());
//                    prpCplanDto.setEndorseNo(strEndorseNo);
//                    prpCplanDto.setFlag("I");
//                    prpCplanDto.setCurrency(prpCplanOldDto.getCurrency());
//                    if (!"RS5".equals(prpCplanOldDto.getPayReason())) {
//                        prpCplanDto.setDelinquentFee(Str.round(Str.round((Str.round(dblPremiumNew, 2) - (blPolicy.getPrpCmainDto().getSumPremium())), 2) * prpCplanOldDto.getPlanRate() / 100, 2));
//                        prpCplanDto.setPlanFee(Str.round(Str.round((Str.round(dblPremiumNew, 2) - (blPolicy.getPrpCmainDto().getSumPremium())), 2) * prpCplanOldDto.getPlanRate() / 100, 2));
//                    } else {
//                        for (int i = 0; i < blPolicy.getPrpCplanDtoList().size(); i++) {
//                            if (null != blPolicy.getPrpCplanDtoList().get(i).getEndorseNo() && !"".equals(blPolicy.getPrpCplanDtoList().get(i).getEndorseNo())) {
//                                //不做处理
//                            } else {
//                                if (!"RS5".equals(blPolicy.getPrpCplanDtoList().get(i).getPayReason())) {
//                                    planFeeSum += Str.round(Str.round((Str.round(dblPremiumNew, 2) - (blPolicy.getPrpCmainDto().getSumPremium())), 2) * blPolicy.getPrpCplanDtoList().get(i).getPlanRate() / 100, 2);
//                                }
//                            }
//                        }
//                        prpCplanDto.setDelinquentFee(Str.round(Str.round(dblPremiumNew, 2) - (blPolicy.getPrpCmainDto().getSumPremium()), 2) - planFeeSum);
//                        prpCplanDto.setPlanFee(Str.round(Str.round(dblPremiumNew, 2) - (blPolicy.getPrpCmainDto().getSumPremium()), 2) - planFeeSum);
//                    }
//                    prpCplanDto.setPayNo(0);
//                    prpCplanDto.setPlanRate(prpCplanOldDto.getPlanRate());
//
//                    prpCplanDto.setSerialNo(SerialNo);
//                }
//            }
//        }

        /*****************************11、生成批单对象********************************************/
        /** 保单数据转入批单 */
        List<InsureMainListDto> insureMainListDtoListOld = insureMainListApi.queryByPolicyNo(strPolicyNo);
        List<HerdPolicyListDto> herdPolicyListDtoListOld = new ArrayList<>();
        if(insureMainListDtoListOld.size()>0) {
            herdPolicyListDtoListOld = plantingPolicyListApi.queryHerdByInsureListCode(insureMainListDtoListOld.get(0).getInusreListCode());
        }

        blPolicyOld.setInsureMainListDtoList(insureMainListDtoListOld);
        blPolicyOld.setHerdPolicyListDtoList(herdPolicyListDtoListOld);
        generatePEndorseService.evaluateFromPolicyToEndor(blPolicyOld,blPolicy,blEndorse);
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

        //中央政策行种植险整单批改
        if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            //获取原始保单分户信息
            BLPolicyDto PPolicyOld = null;
            if (prpCitemKindDtoList.size() > 0) {
                PPolicyOld = new BLPolicyDto(); //原始保单
                if(insureMainListDtoList.size()<=0){
                    throw new Exception("清单主表缺少数据！");
                }
                PPolicyOld.setPlantingPolicyListDtoList(plantingPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode()));
                if(blPolicy.getPrpCmainAgriDto()!=null){
                    String inusreListCode1 = blPolicy.getPrpCmainAgriDto().getRelationListNo();
                    insureMainListDto = insureMainListApi.queryByPK(inusreListCode1);
                    if(insureMainListDto == null){
                        throw new Exception("保单关联清单查询错误！");
                    }
                }
            }
            if (null != PPolicyOld) {
                generateTxnListService.evaluatePlantingFromPolicyToEndor(PPolicyOld.getPlantingPolicyListDtoList(), blPolicy,blEndorse);

            }
        }

        if ("3141".equals(strRiskCode)||"3147".equals(strRiskCode) || ("3149".equals(strRiskCode))) {
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
        //在"赔款后恢复保额"操作中需要做判断处理

        //批改次数赋值
        if(intEndorseTimes==0){
            blPolicy.getPrpCmainDto().setEndorseTimes(intEndorseTimes);
        }else {
            blPolicy.getPrpCmainDto().setEndorseTimes(intEndorseTimes+1);
        }

        //进行prppitemkind和prppmain的调差，处理精确度问题
        //blEndorse.adjustChgPremium(blPolicy);
        if(!strEndorType.equals("71")) {
            int i = 0;
            PrpPitemKindDto prpPitemKindDto;
            double chgPremiumItemkind = 0d;
            double chgPremium = 0d;
            double AllPremium = 0;
            double EveryPremium = 0;
            double LastPremium = 0;
            if (blEndorse.getPrpPmainDto() != null) {
                blEndorse.getPrpPmainDto().setChgPremium(Str.round(blPolicy.getPrpCmainDto().getSumPremium() - blEndorse.getPrpPmainDto().getSumPremium(), 2));
            }
            chgPremium = Str.round(blEndorse.getPrpPmainDto().getChgPremium(), 2);
            for (i = 0; i < blEndorse.getPrpPfeeDtoList().size(); i++) {
                blEndorse.getPrpPfeeDtoList().get(i).setChgPremium(Str.round(blPolicy.getPrpCmainDto().getSumPremium() - blEndorse.getPrpPmainDto().getSumPremium(), 2));
                blEndorse.getPrpPfeeDtoList().get(i).setChgPremium1(Str.round(blPolicy.getPrpCmainDto().getSumPremium() - blEndorse.getPrpPmainDto().getSumPremium(), 2));
                blEndorse.getPrpPfeeDtoList().get(i).setChgPremium2(Str.round(blPolicy.getPrpCmainDto().getSumPremium() - blEndorse.getPrpPmainDto().getSumPremium(), 2));
                blEndorse.getPrpPfeeDtoList().get(i).setFlag("U");
            }
            if (blPolicy.getPrpCmainDto() != null) {
                blPolicy.getPrpCmainDto().setSumPremium(Str.round(dblPremiumNew, 2));
                AllPremium = Str.round(blPolicy.getPrpCmainDto().getSumPremium(), 2);
            }
            for (i = 0; i < blPolicy.getPrpCfeeDtoList().size(); i++) {
                blPolicy.getPrpCfeeDtoList().get(i).setPremium(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium(), 2));
                blPolicy.getPrpCfeeDtoList().get(i).setPremium1(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium1(), 2));
                blPolicy.getPrpCfeeDtoList().get(i).setPremium2(Str.round(blPolicy.getPrpCfeeDtoList().get(i).getPremium2(), 2));
            }
            for (i = 0; i < blEndorse.getPrpPitemKindDtoList().size(); i++) {
                prpPitemKindDto = blEndorse.getPrpPitemKindDtoList().get(i);
                prpPitemKindDto.setChgPremium(Str.round(prpPitemKindDto.getChgPremium(), 2));
                chgPremiumItemkind += prpPitemKindDto.getChgPremium();
                if (i == blEndorse.getPrpPitemKindDtoList().size() - 1) {// 最后一个险别进行调差
                    if (Str.round(Math.abs(chgPremium - chgPremiumItemkind), 4) >= 0.01) {
                        prpPitemKindDto.setChgPremium(Str.round(prpPitemKindDto.getChgPremium() + chgPremium - chgPremiumItemkind, 2));
                    }
                    LastPremium = Str.round(AllPremium - EveryPremium, 2);
                }
                for (int j = 0; j < blPolicy.getPrpCitemKindDtoList().size(); j++) {
                    prpCitemKindDto = blPolicy.getPrpCitemKindDtoList().get(j);
                    if (prpPitemKindDto.getItemKindNo().equals(prpCitemKindDto.getItemKindNo())) {
                        prpCitemKindDto.setPremium(Str.round(prpPitemKindDto.getPremium() + prpPitemKindDto.getChgPremium(), 2));
                        EveryPremium = EveryPremium + Str.round(prpPitemKindDto.getPremium() + prpPitemKindDto.getChgPremium(), 2);
                    }
                    if (j == (blPolicy.getPrpCitemKindDtoList().size() - 1) && prpPitemKindDto.getItemKindNo().equals(prpCitemKindDto.getItemKindNo())) {// 最后一个险别进行调差
                        prpCitemKindDto.setPremium(LastPremium);
                    }
                }
            }
        }

        generatePEndorseService.webAfterCal(blPolicyOld,blPolicy,blEndorse);//plan表等调差


        blPolicy.getPrpCmainDto().setMakeCom(strMakeCom);

        /**12、放入对象**/
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicy);
        policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyOld);
        policyEndorseDto.setBlEndorseDto(blEndorse);

        /**13、生成批文**/
        blEndorse.setEndorseConditionDto(endorseConditionDto);
        policyEndorseDto.setBlEndorseDto(blEndorse);
        generatePtextApi.generateUsual(policyEndorseDto);

        return policyEndorseDto;
    }

    public PrpDshortRateDto queryPrpDshortRateDto(String strRiskCode, Integer intMonth) throws Exception{
        PrpDshortRateDto prpDshortRateDto = prpDshortRateApi.queryPrpDshortRateDto(strRiskCode, intMonth);
        return prpDshortRateDto;
    }

}
