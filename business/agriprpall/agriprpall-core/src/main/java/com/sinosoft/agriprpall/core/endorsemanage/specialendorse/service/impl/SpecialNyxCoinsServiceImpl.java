package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateTxnListService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialNyxCoinsService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCfeeDao;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.QueryPolicySpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfee;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class SpecialNyxCoinsServiceImpl extends BaseServiceImpl implements SpecialNyxCoinsService {
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private GenerateTxnListService generateTxnListService;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    private PrpCfeeDao prpCfeeDao;

    @Override
    public void dealNyxCoins(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto, List<PrpCsubsidyDto> prpCsubsidyDtos, List<PrpCitemKindDto> prpCitemKindDtos) throws Exception {
        String strPolicyNo = blEndorseDto.getPrpPheadDto().getPolicyNo(); //保单号
        ResponseQueryPolicyInfoDto blPolicy = new ResponseQueryPolicyInfoDto();
        blPolicy = policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);
        List<PrpCcoinsDto> prpCcoinsDtoList = null;
        List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList = null;
        PrpCcoinsDto prpCcoinsDto = null;
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        String strCoinsFlag = "";
        String strProportionFlag1 = ""; //手续费计入方式
        String strProportionFlag2 = ""; //特殊因子计入方式
        String strCoinsType = "";


        String strStartHour = "";
        String strEndDate = "";
        String strEndHour = "";
        //获取按不含税保费计算手续费开关

        String reCordType = "";
        // = new VatCommonService().getRecordTypeFormPrpdconfigcode(strPolicyNo);
        double dbDisRate1Coins = 0;
        double dbDisRateCoins = 0;
        double dbCoinsRate = 0;
        double dbSumAmount1 = 0;
        double dbSumPremium1 = 0;
        double dbSumNoTaxPremium1 = 0;//总不含税保费
        double dbMiddleCostFeeBase = 0;
        double dbAgentFeeBase = 0;
        int index;
        String strEndorType = endorseConditionDto.getEndorType(); //批改类型
        String strFlag1;
        int indexOld = 0;
        String strCurrency2 = "";
        String strCurrency1 = "";
        double dblExchangeRate2 = 0;
        double dblExchangeRate1 = 0;
        double dblSumPremium = 0;
        double dblSumAmount = 0;
        double dblAmount = 0;
        double dblAmount2 = 0;
        double dblAmount1 = 0;
        double dblPremium = 0;
        double dblPremium2 = 0;
        double dblPremium1 = 0;
        PrpCfeeDto prpCfeeDtoOld = null;
        PrpCmainDto prpCmainDto = blPolicy.getPrpCmainDto();

        int intEndorseTimes = prpCmainDto.getEndorseTimes();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Hashtable feeHashtable = new Hashtable();
        PrpPheadDto prpPheadDto = blEndorseDto.getPrpPheadDto();

        List<PrpCitemKindDto> prpCitemKindDtoList = blPolicy.getPrpCitemKindDtoList();

        PrpCfeeDto prpCfeeDto = new PrpCfeeDto();
        List<PrpCfeeDto> prpCfeeDtoList = new ArrayList<>();
        List<PrpCfee> prpCfeeList = prpCfeeDao.findAll(QueryPolicySpecBuilder.findPrpCfeeByPolicyNo(strPolicyNo));
        this.convertCollection(prpCfeeList, prpCfeeDtoList, PrpCfeeDto.class);
        PrpCitemKindDto prpCitemKindDto;
        //有保费变化的特殊批改：01、19、21、62，保单币别没有变化（原币、保单汇总币别、支付保费币别）
        //犹豫期退保是否可以如此处理
        for (index = 0; index < prpCitemKindDtoList.size(); index++) {
            //此时PrpCitemKind已经是上面处理后的
            prpCitemKindDto = prpCitemKindDtoList.get(index);
            if(prpCitemKindDto.getFlag()==null){
                prpCitemKindDto.setFlag("");
            }
            if (prpCitemKindDto.getFlag().length() > 0) {
                strFlag1 = prpCitemKindDto.getFlag().substring(0, 1);
            } else {
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
                    dblAmount = Str.round(prpCfeeDto.getAmount() == null ? 0.00 : prpCfeeDto.getAmount(), 2)
                            + Str.round(prpCitemKindDto.getAmount() == null ? 0.00 : prpCitemKindDto.getAmount(), 2);
                    prpCfeeDto.setAmount(Str.round(dblAmount, 2));
                } else {
                    dblAmount = Str.round(prpCfeeDto.getAmount() == null ? 0.00 : prpCfeeDto.getAmount(), 2);
                    prpCfeeDto.setAmount(dblAmount);
                }

                dblPremium = Str.round(prpCfeeDto.getPremium() == null ? 0.00 : prpCfeeDto.getPremium(), 4)
                        + Str.round(prpCitemKindDto.getPremium() == null ? 0.00 : prpCitemKindDto.getPremium(), 4);

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
                if (prpCfeeDto.getFlag() != null && prpCfeeDto.getFlag().length() == 0) {
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
            dblSumAmount += ((PrpCfeeDto) arrObject[index]).getAmount2();
        }

        /**7、对Prp*main的处理**/
        /* reason：将批改保险期限做为特殊批改处理（即做为单独的菜单），与普通批改分离 */
        //变更保险期限（01）
        //起保日期
        if ("01".equals(strEndorType)) {
            prpCmainDto.setStartDate(blPolicy.getPrpCmainDto().getStartDate());
            prpCmainDto.setStartHour(Integer.parseInt(ChgData.chgStrZero(strStartHour)));
            if ("11".equals(strEndorType) || "91".equals(strEndorType)) {
                //总保费（保单汇总币别）
                // main表数据回写总保额总保费两条
                prpCmainDto.setSumPremium(dblSumPremium);
                prpCmainDto.setSumAmount(dblSumAmount);
            }
            //批改次数赋值
            prpCmainDto.setEndorseTimes(intEndorseTimes + 1);
            blPolicy.setPrpCmainDto(prpCmainDto);

            //保单注销、全单退保、特殊因子批改
            if (strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WRITEOFF").trim()) ||
                    strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WITHDRAW").trim()) ||
                    strEndorType.indexOf(utiPlatConfigRuleApi.getProperty("EDITTYPE_COMMISSION").trim()) > -1 ||
                    strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_MIDDLECOST").trim()))

            {
                prpCcoinsDtoList = blPolicy.getPrpCcoinsDtoList();
                prpCcoinsDetailDtoList = blPolicy.getPrpCcoinsDetailDtoList();

                strCoinsFlag = blPolicy.getPrpCmainDto().getCoinsFlag();
                dbDisRate1Coins = blPolicy.getPrpCmainDto().getDisRate1();
                dbDisRateCoins = blPolicy.getPrpCmainDto().getDisRate();
                if ((strCoinsFlag.equals("1") || strCoinsFlag.equals("2")) && !"".equals(blPolicy.getPrpCmainDto().getCoinsPremiumType())) {
                    for (index = 0; index < blPolicy.getPrpCfeeDtoList().size(); index++) {
                        prpCfeeDto = blPolicy.getPrpCfeeDtoList().get(0);
                        dbSumAmount1 = dbSumPremium1 + prpCfeeDto.getAmount1();
                        dbSumPremium1 = dbSumPremium1 + prpCfeeDto.getPremium1();
                        if (!"".equals(reCordType) && "1".equals(reCordType)) {
                            dbSumNoTaxPremium1 = dbSumNoTaxPremium1 + prpCfeeDtoOld.getNoTaxPremium1();
                        }
                    }
                    if (strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WRITEOFF").trim()) ||
                            strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WITHDRAW").trim())) {
                        if (dbSumPremium1 != 0) {

                            for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                                prpCcoinsDto = prpCcoinsDtoList.get(i);
                                if (prpCcoinsDto.getCoinsType().equals("1")) {
                                    dbCoinsRate = prpCcoinsDto.getCoinsRate();
                                    break;
                                }
                            }
                            dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                            dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
                            dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
                            dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                            if (!"".equals(reCordType) && "1".equals(reCordType)) {
                                dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                                dbSumNoTaxPremium1 = dbSumNoTaxPremium1 / dbCoinsRate * 100;
                                dbMiddleCostFeeBase = dbSumNoTaxPremium1 * dbDisRate1Coins / 100;
                                dbAgentFeeBase = (dbSumNoTaxPremium1 - dbSumNoTaxPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                            }
                            for (index = 0; index < prpCcoinsDetailDtoList.size(); index++) {
                                prpCcoinsDetailDto = prpCcoinsDetailDtoList.get(index);
                                for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                                    prpCcoinsDto = prpCcoinsDtoList.get(i);
                                    if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode()))
                                        continue;
                                    dbCoinsRate = prpCcoinsDto.getCoinsRate();
                                    break;
                                }
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsAmount(dbSumAmount1 * dbCoinsRate / 100);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsPremium(dbSumPremium1 * dbCoinsRate / 100);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate / 100);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate / 100);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setOperateFee(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setFlag("U");
                            }

                        } else {
                            for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                                blPolicy.getPrpCcoinsDtoList().get(i).setCoinsRate(prpCcoinsDtoList.get(i).getCoinsRate());
                                blPolicy.getPrpCcoinsDtoList().get(i).setFlag("B");
                            }
                            for (index = 0; index < prpCcoinsDetailDtoList.size(); index++) {
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsAmount(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsPremium(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setOperateFee(0.00);
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setFlag("B");
                            }
                        }

                    } else {
                        for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                            prpCcoinsDto = prpCcoinsDtoList.get(i);
                            if (prpCcoinsDto.getCoinsType().equals("1")) {
                                dbCoinsRate = prpCcoinsDto.getCoinsRate();
                                break;
                            }
                        }
                        dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
                        dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
                        dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                        if (!"".equals(reCordType) && "1".equals(reCordType)) {
                            dbSumNoTaxPremium1 = dbSumNoTaxPremium1 / dbCoinsRate * 100;
                            dbMiddleCostFeeBase = dbSumNoTaxPremium1 * dbDisRate1Coins / 100;
                            dbAgentFeeBase = (dbSumNoTaxPremium1 - dbSumNoTaxPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins / 100;
                        }
                        for (index = 0; index < prpCcoinsDetailDtoList.size(); index++) {
                            prpCcoinsDetailDto = prpCcoinsDetailDtoList.get(index);
                            for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                                prpCcoinsDto = prpCcoinsDtoList.get(i);
                                if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode()))
                                    continue;
                                strCoinsType = prpCcoinsDto.getCoinsType();
                                dbCoinsRate = prpCcoinsDto.getCoinsRate();
                                break;
                            }
                            blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate / 100);
                            blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate / 100);
                            blPolicy.getPrpCcoinsDetailDtoList().get(index).setOperateFee(0.00);
                            blPolicy.getPrpCcoinsDetailDtoList().get(index).setFlag("U");
                        }
                    }

                } else {
                    for (index = 0; index < blPolicy.getPrpCfeeDtoList().size(); index++) {
                        prpCfeeDto = blPolicy.getPrpCfeeDtoList().get(0);
                        dbSumAmount1 = dbSumPremium1 + prpCfeeDto.getAmount1();
                        dbSumPremium1 = dbSumPremium1 + prpCfeeDto.getPremium1();
                    }
                    if (strCoinsFlag.equals("2") || strCoinsFlag.equals("4")) {
                        for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                            prpCcoinsDto = prpCcoinsDtoList.get(i);
                            if (prpCcoinsDto.getCoinsType().equals("1")) {
                                dbCoinsRate = prpCcoinsDto.getCoinsRate();
                                if (prpCcoinsDto.getProportionFlag().length() > 1)
                                    strProportionFlag2 = prpCcoinsDto.getProportionFlag().substring(1, 2);
                                break;
                            }
                        }
                        dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                        dbSumPremium1 = dbSumPremium1 / dbCoinsRate * 100;
                        if (!"".equals(reCordType) && "1".equals(reCordType)) {
                            dbSumAmount1 = dbSumAmount1 / dbCoinsRate * 100;
                            dbSumNoTaxPremium1 = dbSumNoTaxPremium1 / dbCoinsRate * 100;
                        }
                    }
                    dbMiddleCostFeeBase = dbSumPremium1 * dbDisRate1Coins / 100;
                    dbAgentFeeBase = (dbSumPremium1 - dbSumPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins;
                    if (!"".equals(reCordType) && "1".equals(reCordType)) {
                        dbMiddleCostFeeBase = dbSumNoTaxPremium1 * dbDisRate1Coins / 100;
                        dbAgentFeeBase = (dbSumNoTaxPremium1 - dbSumNoTaxPremium1 * dbDisRate1Coins / 100) * dbDisRateCoins;
                    }
                    for (index = 0; index < prpCcoinsDetailDtoList.size(); index++) {
                        prpCcoinsDetailDto = prpCcoinsDetailDtoList.get(index);

                        for (int i = 0; i < prpCcoinsDtoList.size(); i++) {
                            prpCcoinsDto = prpCcoinsDtoList.get(i);

                            if (!prpCcoinsDto.getCoinsCode().equals(prpCcoinsDetailDto.getCoinsCode()))
                                continue;

                            strCoinsType = prpCcoinsDto.getCoinsType();
                            dbCoinsRate = prpCcoinsDto.getCoinsRate();
                            break;
                        }

                        blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsAmount(dbSumAmount1 * dbCoinsRate);
                        blPolicy.getPrpCcoinsDetailDtoList().get(index).setCoinsPremium(dbSumPremium1 * dbCoinsRate);

                        if (strCoinsType.equals("1")) //我方
                        {
                            blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate);
                            if (strProportionFlag2.equals("2"))
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(dbAgentFeeBase);
                            else
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate);
                        } else //非我方
                        {
                            if (strProportionFlag2.equals("1"))
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(dbMiddleCostFeeBase * dbCoinsRate);
                            else
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setMiddleCostFee(0.00);
                            if (strProportionFlag1.equals("1"))
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(dbAgentFeeBase * dbCoinsRate);
                            else
                                blPolicy.getPrpCcoinsDetailDtoList().get(index).setAgentFee(0.00);
                        }
                        blPolicy.getPrpCcoinsDetailDtoList().get(index).setOperateFee(0.00);
                        blPolicy.getPrpCcoinsDetailDtoList().get(index).setFlag("U");
                    }
                }


                //--从PrpCcoinsDetail表里取出数据放入prpCplanCoinsDto对象后再插入PrpcplanCoins表中
                double ohrPlafeeOld = 0.0;        //起初应缴金额
                double ohrPlfeeRate = 0.0;        //应缴比例
                double ohrPlanfeeNew = 0.0;        //变化应缴金额
                double ohrChangePlanfee = 0.0;    //保费最终变化量
                //BlPrpCplanCoins
                PrpCplanCoinsDto prpCplanCoinsDto = new PrpCplanCoinsDto();    //初始化实体类,存放新值
                int prpCplanCoinsSize = blPolicy.getPrpCplanCoinsDtoList().size();
                String payReaon = "";
                for (index = 0; index < prpCplanCoinsSize; index++) {
                    String strCoinsCode = blPolicy.getPrpCplanCoinsDtoList().get(index).getCoinsCode();    //从PrpCplanCoins取CoinsCode字段
                    for (int i = 0; i < blPolicy.getPrpCcoinsDetailDtoList().size(); i++) {
                        String strCoinsCode1 = blPolicy.getPrpCcoinsDetailDtoList().get(i).getCoinsCode(); //从PrpCcoinsDetail取CoinsCode字段
                        if (strCoinsCode.equals(strCoinsCode1)) {
                            ohrPlanfeeNew = blPolicy.getPrpCcoinsDetailDtoList().get(i).getCoinsPremium();
                            break;
                        }
                    }
                    ohrPlafeeOld = blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanFee();
                    ohrPlfeeRate = blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanRate() / 100;
                    ohrChangePlanfee = ohrPlfeeRate * ohrPlanfeeNew - ohrPlafeeOld;    //保费最终变化量计算方式

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
                    prpCplanCoinsDto.setPlanFee(ohrChangePlanfee);    //planfee修改后的数据插入prpCplanCoinsDto对象
                    prpCplanCoinsDto.setDelinquentFee(ohrChangePlanfee);
                    prpCplanCoinsDto.setFlag("I");
                    //System.out.println("date == "+blPrpPhead.getArr(0).getValidDate());
                    prpCplanCoinsDto.setPlanStartDate(prpPheadDto.getValidDate());
                    prpCplanCoinsDto.setPlanRate(blPolicy.getPrpCplanCoinsDtoList().get(index).getPlanRate());

                    blPolicy.getPrpCplanCoinsDtoList().add(prpCplanCoinsDto);        //将对象插入BlPrpCplanCoins表
                }


            }

            if (null != blPolicy.getHerdPolicyListDtoList() && blPolicy.getHerdPolicyListDtoList().size() > 0) {
                List<HerdPolicyListDto> herdPolicyListDtos = new ArrayList<>();
                List<InsureMainListDto> insureMainListList = insureMainListApi.queryByPolicyNo(blPolicy.getPrpCmainDto().getPolicyNo());
                if (insureMainListList.size() > 0) {
                    String inusreListCode = insureMainListList.get(0).getInusreListCode();
                    if (inusreListCode != null && !"".equals(inusreListCode)) {
                        herdPolicyListDtos = herdPolicyListApi.queryByInusreListCode(inusreListCode);
                    }
                }
                generateTxnListService.evaluateBreedFromPolicyToEndor(herdPolicyListDtos, blPolicy, blEndorseDto);
            }

            if (null != blPolicy.getNyxPolicyListDtoList() && blPolicy.getNyxPolicyListDtoList().size() > 0) {
                List<NyxPolicyListDto> nyxPolicyListDtos = new ArrayList<>();
                List<InsureMainListDto> insureMainListList = insureMainListApi.queryByPolicyNo(blPolicy.getPrpCmainDto().getPolicyNo());
                if (insureMainListList.size() > 0) {
                    String inusreListCode = insureMainListList.get(0).getInusreListCode();
                    if (inusreListCode != null && !"".equals(inusreListCode)) {
                        nyxPolicyListDtos = nyxPolicyListApi.queryByInusreListCode(inusreListCode);
                    }
                }

                generateTxnListService.evaluateNyxFromPolicyToEndor(nyxPolicyListDtos, blPolicy, blEndorseDto);
            }

        }
    }
}
