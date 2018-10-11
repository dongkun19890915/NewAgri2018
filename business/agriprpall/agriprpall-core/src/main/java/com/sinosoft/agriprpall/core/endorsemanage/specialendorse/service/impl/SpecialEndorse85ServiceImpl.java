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
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorse85Service;
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
public class SpecialEndorse85ServiceImpl extends BaseServiceImpl implements SpecialEndorse85Service{
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
    private Planting31EndorChgDetailService planting31EndorChgDetailService;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private GenerateTxnListService generateTxnListService;
    /**
     * 业务员批改
     * @param blEndorseDto 批单大对象
     * @param endorseConditionDto 批改条件
     * @return PolicyEndorseDto 新旧保单、批单大对象
     * @throws Exception
     * @author 王保良
     * @time 2017-12-20
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto specialEndorse85(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto) throws Exception {

        //创建返回值对象
        PolicyEndorseDto policyEndorseDto = null;
        //创建批单数据对象，用于遍历传入集合
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        policyEndorseDto = new PolicyEndorseDto();
        String strMakeCom = blEndorseDto.getPrpPheadDto().getMakeCom();
        String strUserCode = blEndorseDto.getPrpPheadDto().getOperatorCode();
        String strPolicyNo = blEndorseDto.getPrpPheadDto().getPolicyNo(); //保单号
        Date strEndorDate = blEndorseDto.getPrpPheadDto().getEndorDate(); //批改日期
        Date strValidDate = blEndorseDto.getPrpPheadDto().getValidDate(); //批改生效日期
        int strValidHour = blEndorseDto.getPrpPheadDto().getValidHour(); //批改生效小时
        String strEndorType = endorseConditionDto.getEndorType(); //批改类型
        String strIrate = endorseConditionDto.getiRate(); //退保手续费比例
        String strPrpPheadAppliName = blEndorseDto.getPrpPheadDto().getAppliName();
        String strEndorseType1 = blEndorseDto.getPrpPheadDto().getEndorseType();//批改方式
        String strEndorseMessage = blEndorseDto.getPrpPheadDto().getEndorseMessage();//批改方式原因
        String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_BREEDING_FARMER_LIST_FLAG);//中央政策险养殖险标志
        String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_PLNATING_FARMER_LIST_FLAG);//中央政策险种植险标志
        String nyxSingleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_SINGLE_FARMER_LIST_FLAG);
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty(AgriPrpallConstant.AGRI_PRPALL_SERVICE_NYX_MULTIPLE_FARMER_LIST_FLAG);

        //todo 创建返回参数
        ResponseQueryPolicyInfoDto blPolicy;
        ResponseQueryPolicyInfoDto blPolicyOld;

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
        String strRiskCode = "";
        String strEndorseNo = "";
        String strCurrency2 = "";
        String strCurrency1 = "";
        String strFlag1 = "";
        String strFlag = "";
        String handler1Code = "";

        double dblAmount = 0;
        double dblAmount2 = 0;
        double dblAmount1 = 0;
        double dblPremium = 0;
        double dblPremium2 = 0;
        double dblPremium1 = 0;
        double dblExchangeRate2 = 0;
        double dblExchangeRate1 = 0;
        double dblSumPremium = 0;
        //分户信息
        int intEndorseTimes = 0;
        int index = 0;
        int indexOld = 0;
        boolean isChangedFee = true; //货运险批改起运日期时，没有保费变化

        //业务员批改（85）
        handler1Code = endorseConditionDto.getHandler1Code(); //归属业务员

        /**
         * 获取保单数据
         */
        /**blPolicy.getData(strPolicyNo);*/
        blPolicy=policyQueryService.queryPolicyInfoByPolicyNo(strPolicyNo);

        //todo blpolicy中没有insureMainListDtoList这个东西 现在已经加上了
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
        blPolicy.setInsureMainListDtoList(insureMainListDtoList);

        InsureMainListDto insureMainListDto;
        PrpCmainDto prpCmainDto=blPolicy.getPrpCmainDto();
        PrpCexpenseDto prpCexpenseDto=blPolicy.getPrpCexpenseDto();
        List<PrpCsubsidyDto> prpCsubsidyDtoList=blPolicy.getPrpCsubsidyDtoList();
        List<PrpCitemKindDto> prpCitemKindDtoList=blPolicy.getPrpCitemKindDtoList();
        List<PrpCfeeDto> prpCfeeDtoList=blPolicy.getPrpCfeeDtoList();
        List<PrpCcoinsDto> prpCcoinsDtoList=blPolicy.getPrpCcoinsDtoList();
        List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList=blPolicy.getPrpCcoinsDetailDtoList();

        List<Planting31PolicyListDto> planting31PolicyListDtoList = new ArrayList<>();
        List<PlantingPolicyListDto> plantingPolicyListDtoList = new ArrayList<>();
        List<HerdPolicyListDto> herdPolicyListDtoList     = new ArrayList<>();
        List<NyxPolicyListDto> nyxPolicyListDtoList       = new ArrayList<>();

        strRiskCode = prpCmainDto.getRiskCode();

        //blPolicy.getHerdPolicyData(strPolicyNo);
        if(insureMainListDtoList.size()>0) {
            herdPolicyListDtoList = plantingPolicyListApi.queryHerdByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
            plantingPolicyListDtoList = plantingPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
            blPolicy.setHerdPolicyListDtoList(herdPolicyListDtoList);
            blPolicy.setPlantingPolicyListDtoList(plantingPolicyListDtoList);
        }
        if (("3141".equals(strRiskCode)) || ("3147".equals(strRiskCode))) {
            if(insureMainListDtoList.size()>0){
                Map<String,String> map=new HashMap<>();
                map.put("inusreListCode",insureMainListDtoList.get(0).getInusreListCode());
                planting31PolicyListDtoList = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
                blPolicy.setPlanting31PolicyListDtoList(planting31PolicyListDtoList);
            }
        }
        // 二期平台改造新加清单的险种,取nyxpolicy数据
        if (("3224".equals(strRiskCode)||"3134".equals(strRiskCode))|| nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode)){
            if(insureMainListDtoList.size()>0) {
                nyxPolicyListDtoList = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoList.get(0).getInusreListCode());
                blPolicy.setNyxPolicyListDtoList(nyxPolicyListDtoList);
            }
        }
        intEndorseTimes = prpCmainDto.getEndorseTimes();

        /**1、置Prp*main.OthFlag**/

        /**2、置Prp*itemKind.Flag[1]**/

        //未知
        strFlag1 = " ";

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
        prpPheadDto.setEndorDate(strEndorDate);
        prpPheadDto.setValidDate(strValidDate);
        prpPheadDto.setAppliName(strPrpPheadAppliName);
        prpPheadDto.setValidHour(strValidHour);
        prpPheadDto.setOperatorCode(strUserCode);
        prpPheadDto.setBatchNo(endorseConditionDto.getBatchNo());/** 获取批次号 */
        prpPheadDto.setInputDate(new SimpleDateFormat("yyyy-MM-dd").parse(chgDate.getCurrentTime("yyyy-MM-dd")));
        prpPheadDto.setInputHour(Integer.parseInt(chgDate.getCurrentTime("HH")));
        prpPheadDto.setEndorseType(strEndorseType1);
        prpPheadDto.setValidCountDate(new SimpleDateFormat("yyyy-MM-dd").parse(("9999-12-31")));
        prpPheadDto.setEndorseMessage(strEndorseMessage);
        //生成批单对象
        blEndorse.setPrpPheadDto(prpPheadDto);
        if(intEndorseTimes==0){
            prpPheadDto.setEndorseTimes(intEndorseTimes);
        }else {
            prpPheadDto.setEndorseTimes(intEndorseTimes+1);
        }

        //整单批改对分户信息的处理
        if (StringUtils.isNotEmpty(breedingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode) && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && !"3224".equals(strRiskCode)) {
            if (insureMainListDtoList.size() > 0) {
                List<HerdEndorHeadDto> herdEndorHeadDtoList = new ArrayList<>();
                //计算农户自交保费比例 = (100 - 比例补贴的比例总和)/ 100。
                double subSidyRate = 0;
                double selfRate = 1;
                for (int k = 0; k < prpCsubsidyDtoList.size(); k++) {
                    subSidyRate += prpCsubsidyDtoList.get(k).getSubsidyRate();
                }
                selfRate = (100 - subSidyRate) / 100;
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
        //整单批改对分户信息的处理

        //reason:中央政策性种植险整单批改对分户信息的处理
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
        //reason:中央政策性种植险整单批改对分户信息的处理

        if (("3141".equals(strRiskCode)) || (("3147".equals(strRiskCode)))) {
            if (insureMainListDtoList.size() > 0) {
                List<PlantingEndorHeadDto> bLPlantingEndorHead = new ArrayList<>();
                //种殖险批改头表
                bLPlantingEndorHead.add(plantingEndorHeadDto);
                plantingEndorHeadDto.setInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
                plantingEndorHeadDto.setEndorseNo(strEndorseNo);
                plantingEndorHeadDto.setRiskCode(strRiskCode);
                plantingEndorHeadDto.setPolicyNo(strPolicyNo);
                //plantingEndorHeadSchema.setListFlag("0");
                plantingEndorHeadDto.setEndorFlag(strEndorType);
                blEndorse.setPlantingEndorHeadDto(plantingEndorHeadDto);
            }
        }

        if (("3224".equals(strRiskCode)||"3134".equals(strRiskCode))) {
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
        for (index = 0; index < prpCitemKindDtoList.size(); index++) {
            strFlag = prpCitemKindDtoList.get(index).getFlag();
            if (strFlag.length() > 0)
                strFlag = strFlag1 + strFlag.substring(1);
            else
                strFlag = strFlag1;
            /* reason：将批改保险期限做为特殊批改处理（即做为单独的菜单），与普通批改分离 */
            /* reason：标的中关联了赔偿限额，如果退保了标的，相应的退保赔偿限额 */
        }

        /**6、生成Fee表的数据**/
        prpCfeeDto = new PrpCfeeDto();
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
            //xiaojian_leave：目前险判断以下两种类型，待以后补充
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

        /**7、对Prp*main的处理**/
        /* reason：将批改保险期限做为特殊批改处理（即做为单独的菜单），与普通批改分离 */
        //业务员批改
            prpCmainDto.setHandlerCode(handler1Code);
            prpCmainDto.setHandler1Code(handler1Code);

        //批改次数赋值
        prpCmainDto.setEndorseTimes(intEndorseTimes + 1);

        /**8、生成绩效比例批改（绩效比例批改（77））**/
        //8、业务员批改（85），业务（76）来源批改修改绩效相关标识
        if (strEndorType.equals(AgriPrpallConstant.EDITTYPE_BUSINESSNATURE.trim()) || strEndorType.equals(AgriPrpallConstant.EDITTYPE_HANDLERCODE.trim())) {
            if (prpCexpenseDto != null) {
                prpCexpenseDto.setFlag("U5");
            }
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
        blEndorse.setEndorseConditionDto(endorseConditionDto);
        //todo 将evaluateFeomPolicyToEndor中的参数由BlpolicyDto改为ResponseQueryInfoDto
        generatePEndorse.evaluateFromPolicyToEndor(blPolicyOld,blPolicy,blEndorse);

        //中央政策行种植险整单批改批改
        if (StringUtils.isNotEmpty(plantingFarmerListFlag) && StringUtils.isNotEmpty(strRiskCode)
                && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
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
                generateTxnListService.evaluatePlantingFromPolicyToEndor(PPolicyOld.getPlantingPolicyListDtoList(), blPolicy,blEndorse);
            }
        }


        if ("3141".equals(strRiskCode)||"3147".equals(strRiskCode)) {
            //获取原始保单分户信息
            BLPolicyDto PPolicyOld = null;
            if (planting31PolicyListDtoList.size() > 0) {
                PPolicyOld = new BLPolicyDto(); //原始保单
                //PPolicyOld.getPlanting31PolicyData(strPolicyNo);
                List<Planting31PolicyListDto> planting31PolicyListDto = new ArrayList<>();
                Map<String,String> map=new HashMap<>();
                map.put("inusreListCode",insureMainListDtoList.get(0).getInusreListCode());
                planting31PolicyListDto = plantingPolicyListApi.queryPlanting31ByInsuereListCode(map);
                PPolicyOld.setPlanting31PolicyListDtoList(planting31PolicyListDto);
            }
            if (null != PPolicyOld) {
                generateTxnListService.evaluatePlanting31FromPolicyToEndor(PPolicyOld.getPlanting31PolicyListDtoList(), blPolicy,blEndorse);
            }
        }
        BLPolicyDto blPolicyOld2=null;
        if(null!=blPolicy.getNyxPolicyListDtoList()&&blPolicy.getNyxPolicyListDtoList().size()>0){
            blPolicyOld2 = new BLPolicyDto(); //原始保单
            List<NyxPolicyListDto> nyxPolicyListDtoListOld = new ArrayList<NyxPolicyListDto>();
            if(insureMainListDtoListOld.size()>0) {
                nyxPolicyListDtoListOld = plantingPolicyListApi.queryNyxByInsureListCode(insureMainListDtoListOld.get(0).getInusreListCode());
                blPolicyOld2.setNyxPolicyListDtoList(nyxPolicyListDtoListOld);
            }
            generateTxnListService.evaluateNyxFromPolicyToEndor(blPolicyOld2.getNyxPolicyListDtoList(),blPolicy,blEndorse);
        }
        if(null!=blPolicy.getHerdPolicyListDtoList()&&blPolicy.getHerdPolicyListDtoList().size()>0){
            blPolicyOld2 = new BLPolicyDto(); //原始保单
            blPolicyOld2.setHerdPolicyListDtoList(herdPolicyListDtoListOld);
            generateTxnListService.evaluateBreedFromPolicyToEndor(blPolicyOld2.getHerdPolicyListDtoList(),blPolicy,blEndorse);
        }

        //进行prppitemkind和prppmain的调差，处理精确度问题
        //blEndorse.adjustChgPremium(blPolicy);
        int i = 0;
        PrpPitemKindDto prpPitemKindSchema;
        PrpCitemKindDto prpCitemKindSchema;
        double chgPremiumItemkind = 0d;
        double chgPremium = 0d;
        double AllPremium=0;
        double EveryPremium=0;
        double LastPremium=0;
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
            //prpPitemKindSchema.setFlag("U1");
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

        /**12、放入对象**/
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicy);
        policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyOld);
        policyEndorseDto.setBlEndorseDto(blEndorse);
        policyEndorseDto.getBlEndorseDto().setEndorseConditionDto(endorseConditionDto);

        /**13、生成批文**/
        generatePtextApi.generateUsual(policyEndorseDto);
        for(int l=0;l<policyEndorseDto.getBlEndorseDto().getPrpPtextDtoList().size();l++) {
            System.err.println(policyEndorseDto.getBlEndorseDto().getPrpPtextDtoList().get(l).getEndorseText());
        }
        return policyEndorseDto;
    }
}