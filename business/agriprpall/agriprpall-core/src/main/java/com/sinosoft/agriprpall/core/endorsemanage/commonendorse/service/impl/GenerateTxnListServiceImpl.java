package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateTxnListService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainAgriDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCvirturlItemDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgri;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgriKey;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItem;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.insuremainlist.CMCPManFieldListApi;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.utility.string.ChgData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/**
 * 普通批改清单表处理实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
public class GenerateTxnListServiceImpl extends BaseServiceImpl implements GenerateTxnListService {
    @Autowired
    private PrpCvirturlItemDao prpCvirturlItemDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private HerdPolicyListApi herdPolicyListApi;
    @Autowired
    private Planting31PolicyListApi planting31PolicyListApi;
    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;
    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;
    @Autowired
    private PlantingEndorChgDetailApi plantingEndorChgDetailApi;
    @Autowired
    private PlantingEndorHeadApi plantingEndorHeadApi;
    @Autowired
    private PlantingCpEndorChgDetailApi plantingCpEndorChgDetailApi;
    @Autowired
    private Planting31EndorChgDetailApi planting31EndorChgDetailApi;
    @Autowired
    private Planting31CpEndorChgDetailApi planting31CpEndorChgDetailApi;
    @Autowired
    private HerdEndorChgDetailApi herdEndorChgDetailApi;
    @Autowired
    private HerdEndorHeadApi herdEndorHeadApi;
    @Autowired
    private NyxEndorChgDetailApi nyxEndorChgDetailApi;
    @Autowired
    private NyxEndorHeadApi nyxEndorHeadApi;
    @Autowired
    private HerdcEndorChgDetailApi herdcEndorChgDetailApi;
    @Autowired
    private NyxCpEndorChgDetailApi nyxCpEndorChgDetailApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CMCPManFieldListApi cmcpManFieldListApi;
    /**
    * 清单表处理
    * @param policyEndorseDto 保单批单封装对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:39 2017/12/5
    */
    @Override
    public void dealTxnList(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew = policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto = policyEndorseDto.getBlEndorseDto();
        String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty("BREEDING_FARMER_LIST_FLAG");
        String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_FARMER_LIST_FLAG");//中央政策性种植险标志
        String planting31FarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_31_FARMER_LIST_FLAG");
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");
        String nyxSingleFarmerListFlag=utiPlatConfigRuleApi.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");
        String cPolicyNo = blPolicyDtoNew.getPrpCmainDto().getPolicyNo();
        String cRiskCode = blPolicyDtoNew.getPrpCmainDto().getRiskCode();
        List<PlantingPolicyListDto> plantingPolicyListDtoList=null;
        List<InsureMainListDto> insureMainListList = insureMainListApi.queryByPolicyNo(cPolicyNo);
        if (insureMainListList.size() > 0) {
            String inusreListCode = insureMainListList.get(0).getInusreListCode();
            if (inusreListCode != null && !"".equals(inusreListCode)) {

                if (null != breedingFarmerListFlag && null != cRiskCode && breedingFarmerListFlag.indexOf(cRiskCode) > -1 && !"3224".equals(cRiskCode)) {
                    List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
                    herdPolicyListDtoList = herdPolicyListApi.queryByInusreListCode(inusreListCode);
                    evaluateBreedFromPolicyToEndor(herdPolicyListDtoList, blPolicyDtoNew, blEndorseDto);
                }
                if (null != planting31FarmerListFlag && null != cRiskCode && planting31FarmerListFlag.indexOf(cRiskCode) > -1) {
                    List<Planting31PolicyListDto> planting31PolicyListDtoList = planting31PolicyListApi.queryByInusreListCode(inusreListCode);
                    evaluatePlanting31FromPolicyToEndor(planting31PolicyListDtoList, blPolicyDtoNew, blEndorseDto);
                }

                if (null != nyxMultipleFarmerListFlag &&null != nyxSingleFarmerListFlag && null != cRiskCode &&( nyxSingleFarmerListFlag.indexOf(cRiskCode) > -1||nyxMultipleFarmerListFlag.indexOf(cRiskCode) > -1)) {
                    List<NyxPolicyListDto> nyxPolicyListDtoList = nyxPolicyListApi.queryByInusreListCode(inusreListCode);
                    evaluateNyxFromPolicyToEndor(nyxPolicyListDtoList, blPolicyDtoNew, blEndorseDto);
                	plantingPolicyListDtoList = plantingPolicyListApi.queryPlantingPolicyListByInsureListCode(inusreListCode);
                }
                if ("3224".equals(cRiskCode)) {
                    List<NyxPolicyListDto> nyxPolicyListDtoList = nyxPolicyListApi.queryByInusreListCode(inusreListCode);
                    evaluateNyxFromPolicyToEndor(nyxPolicyListDtoList, blPolicyDtoNew, blEndorseDto);
                    plantingPolicyListDtoList = plantingPolicyListApi.queryPlantingPolicyListByInsureListCode(inusreListCode);
                }
            }
        }
        PrpCmainAgri prpCmainAgri = convert(blPolicyDtoNew.getPrpCmainAgriDto(),PrpCmainAgri.class);
        if (blPolicyDtoNew.getPrpCmainAgriDto() == null) {
            PrpCmainAgriKey prpCmainAgriKey = new PrpCmainAgriKey(cPolicyNo);
            prpCmainAgri = prpCmainAgriDao.findOne(prpCmainAgriKey);
            blPolicyDtoNew.setPrpCmainAgriDto(convert(prpCmainAgri, PrpCmainAgriDto.class));
        }
        if (blPolicyDtoNew.getPrpCmainAgriDto() != null) {
            String insureListCode = prpCmainAgri.getRelationListNo();
            if (null != insureListCode && !"".equals(insureListCode)) {
                List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByInsureListCode(insureListCode);
                if (insureMainListDtoList.size() > 0 && insureMainListDtoList.size() == 1) {
                    plantingPolicyListDtoList = plantingPolicyListApi.queryPlantingPolicyListByInsureListCode(insureListCode);
//                    blPolicyDtoNew.setPlantingPolicyListDtoList(plantingPolicyListDtoList);
                } else {
                    throw new DataVerifyException("保单关联清主单查询错误！");
                }
            }
        }
        evaluatePlantingFromPolicyToEndor(plantingPolicyListDtoList, blPolicyDtoNew, blEndorseDto);

        /**对虚拟分户的校验，批减时的数量和保额不能大于虚拟分户的数量和保额*/
        String pRiskCode = blEndorseDto.getPrpPheadDto().getRiskCode();
        String pPolicyNo = blPolicyDtoNew.getPrpCmainDto().getPolicyNo();
        String iItemKindno = "";
        String strRiskCode = utiPlatConfigRuleApi.getProperty("CREATE_VIRTUALITEM_RISK");
        if (strRiskCode.indexOf(pRiskCode) > -1) {
            PrpPitemKindDto prpPitemKindDto = null;
            List<PrpCvirturlItem> prpCvirturlItemList = prpCvirturlItemDao.queryAllByPolicyNo(pPolicyNo);
            List<PrpPitemKindDto> prpPitemKindDtoList = blEndorseDto.getPrpPitemKindDtoList();
            for (int i = 0; i < prpCvirturlItemList.size(); i++) {
                PrpCvirturlItem prpCvirturlItem = prpCvirturlItemList.get(i);
                iItemKindno = prpCvirturlItem.getItemKindNo().toString();
                for (int j = 0; j < prpPitemKindDtoList.size(); j++) {
                    prpPitemKindDto = prpPitemKindDtoList.get(j);
                    if (iItemKindno.equals(prpPitemKindDto.getItemKindNo())) {
                        break;
                    }
                }
                if (prpPitemKindDto.getChgAmount() + prpCvirturlItem.getAmount() < 0) {
                    throw new DataVerifyException("保额变化量数字传递异常！");
                }
                if (prpPitemKindDto.getChgQuantity() + prpCvirturlItem.getQuantity() < 0) {
                    throw new DataVerifyException("数量变化量数字传递异常！");
                }

            }
        }
    }
    /**
    * herdEndorChgDetail表处理
    * @param herdPolicyListDtoList 表对象集合
    * @param blPolicyDtoNew  页面传入保单大对象
    * @param blEndorseDto   批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:42 2017/12/5
    */
    public void evaluateBreedFromPolicyToEndor(List<HerdPolicyListDto> herdPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        int i = 0;
        HerdEndorChgDetailDto herdEndorChgDetailDto = null;
        HerdPolicyListDto herdPolicyListOldDto = null;
        HerdPolicyListDto herdPolicyListNewDto = null;
        HerdPolicyListDto herdPolicyListNewDtoTmp = null;
        Hashtable hashItemKind = new Hashtable();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getHerdPolicyListDtoList().size() < herdPolicyListDtoList.size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        //将indexNo与其Dto建立映射关系
        for (i = 0; i < herdPolicyListDtoList.size(); i++) {
            herdPolicyListNewDtoTmp = blPolicyDtoNew.getHerdPolicyListDtoList().get(i);
            hashItemKind.put("" + herdPolicyListNewDtoTmp.getIndexCode(), herdPolicyListNewDtoTmp);
        }
        //建立映射关系完毕
        List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList=new ArrayList<>();
        blEndorseDto.setHerdEndorChgDetailListDtoList(herdEndorChgDetailDtoList);
        blEndorseDto.setHerdEndorHeadDto(new HerdEndorHeadDto());
        for (i = 0; i < blPolicyDtoNew.getHerdPolicyListDtoList().size(); i++) {
            herdPolicyListNewDto = blPolicyDtoNew.getHerdPolicyListDtoList().get(i);
                herdPolicyListOldDto = (HerdPolicyListDto) hashItemKind.get(""
                        + herdPolicyListNewDto.getIndexCode());
                if (herdPolicyListOldDto == null) {
                    continue;
                }
            herdEndorChgDetailDto = new HerdEndorChgDetailDto();
            herdEndorChgDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            herdEndorChgDetailDto.setfCode(herdPolicyListOldDto.getfCode());
            herdEndorChgDetailDto.setfName(herdPolicyListOldDto.getfName());
            herdEndorChgDetailDto.setfIdCard(herdPolicyListOldDto.getfIdCard());
            herdEndorChgDetailDto.setBank(herdPolicyListOldDto.getBank());
            herdEndorChgDetailDto.setBankCard(herdPolicyListOldDto.getBankCard());
            if(herdPolicyListNewDto.getFlag()==null){
                herdEndorChgDetailDto.setFlag(" "); //标志用新的
            }else {
                herdEndorChgDetailDto.setFlag(herdPolicyListNewDto.getFlag()); //标志用新的
            }
            herdEndorChgDetailDto.setBreedingAreaCode(herdPolicyListOldDto.getBreedingAreaCode());
            herdEndorChgDetailDto.setBreedingAreaName(herdPolicyListOldDto.getBreedingAreaName());
            herdEndorChgDetailDto.setBreedingKind(herdPolicyListOldDto.getBreedingKind());
            herdEndorChgDetailDto.setEarLabel(herdPolicyListOldDto.getEarlAbel());
            herdEndorChgDetailDto.setInsureNumber(herdPolicyListOldDto.getInsureNumber());
            herdEndorChgDetailDto.setSumPremium(herdPolicyListOldDto.getSumPremium());
            herdEndorChgDetailDto.setInsurePremium(herdPolicyListOldDto.getInsurePremium());
            herdEndorChgDetailDto.setInusreListCode(herdPolicyListOldDto.getInusreListCode());
            herdEndorChgDetailDto.setKindCode(herdPolicyListOldDto.getKindCode());
            herdEndorChgDetailDto.setAmount(herdPolicyListOldDto.getAmount());
            herdEndorChgDetailDto.setEndDate(herdPolicyListOldDto.getEndDate());
            herdEndorChgDetailDto.setStartDate(herdPolicyListOldDto.getStartDate());
            herdEndorChgDetailDto.setIndexCode(herdPolicyListOldDto.getIndexCode());
            herdEndorChgDetailDto.setShortRateFlag(herdPolicyListOldDto.getShortRateFlag());
            herdEndorChgDetailDto.setShortRate(herdPolicyListOldDto.getShortRate());
            herdEndorChgDetailDto.setValidity(herdPolicyListOldDto.getValidity());
            herdEndorChgDetailDto.setSumAmount(herdPolicyListOldDto.getSumAmount());
            herdEndorChgDetailDto.setSumPremium(herdPolicyListOldDto.getSumPremium());
            herdEndorChgDetailDto.setSpecies(herdPolicyListOldDto.getSpecies());
            herdEndorChgDetailDto.setRate(herdPolicyListOldDto.getRate());
            herdEndorChgDetailDto.setInsurePremium(herdPolicyListOldDto.getInsurePremium());
            herdEndorChgDetailDto.setOpCode(herdPolicyListOldDto.getOpCode());
            herdEndorChgDetailDto.setOpTime(herdPolicyListOldDto.getOpTime());
            herdEndorChgDetailDto.setCalculateFlag(herdPolicyListOldDto.getCalculateFlag());
            herdEndorChgDetailDto.setPhone(herdPolicyListOldDto.getPhone());
            herdEndorChgDetailDto.setAreaNumber(Double.parseDouble(herdPolicyListOldDto.getAreaNumber().toString()));
            herdEndorChgDetailDto.setLitterArea(herdPolicyListOldDto.getLitterArea());
            herdEndorChgDetailDto.setAnimalAge(herdPolicyListOldDto.getAniMalage());
            herdEndorChgDetailDto.setCentralPremium(herdPolicyListOldDto.getCentralPremium());
            herdEndorChgDetailDto.setProvincePremium(herdPolicyListOldDto.getProvincePremium());
            herdEndorChgDetailDto.setTownPremium(herdPolicyListOldDto.getTownPremium());
            herdEndorChgDetailDto.setOtherPremium(herdPolicyListOldDto.getOtherPremium());
            herdEndorChgDetailDto.setCityPremium(herdPolicyListOldDto.getCityPremium());
            herdEndorChgDetailDto.setItemCode(herdPolicyListOldDto.getItemCode());
            if(blEndorseDto!= null && blEndorseDto.getEndorseConditionDto() != null
                    && blEndorseDto.getEndorseConditionDto().getEndorType() != null
                    && "85".equals(blEndorseDto.getEndorseConditionDto().getEndorType())){
                herdEndorChgDetailDto.setChgInsureNumber(0);
                herdEndorChgDetailDto.setChgSumAmount(0.0);
                herdEndorChgDetailDto.setChgSumPremium(0.0);
                herdEndorChgDetailDto.setChgAreaNumber(0.0);
                herdEndorChgDetailDto.setChgFPremium(0.0);
                herdEndorChgDetailDto.setChgCentralPremium(0.0);
                herdEndorChgDetailDto.setChgProvincePremium(0.0);
                herdEndorChgDetailDto.setChgCityPremium(0.0);
                herdEndorChgDetailDto.setChgTownPremium(0.0);
                herdEndorChgDetailDto.setChgOtherPremium(0.0);
            }
            //变化量
//            if(herdPolicyListNewDto.getFlag()==null){
//                herdPolicyListNewDto.setFlag("");
//            }
                if (StringUtils.isNotEmpty(herdPolicyListNewDto.getFlag()) && herdEndorChgDetailDto.getFlag().charAt(0) == 'I') {
                    herdEndorChgDetailDto.setChgInsureNumber(1);
                    herdEndorChgDetailDto.setChgSumAmount(herdPolicyListNewDto.getSumAmount());
                    herdEndorChgDetailDto.setChgSumPremium(herdPolicyListNewDto.getSumPremium());
                    herdEndorChgDetailDto.setChgAreaNumber(Double.parseDouble(herdPolicyListNewDto.getAreaNumber().toString()));
                } else {
                    double dblQuantityNew = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListNewDto.getInsureNumber())), 2);
                    double dblQuantityOld = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListOldDto.getInsureNumber())), 2);
                    double dblQuantity = Str.round(dblQuantityNew - dblQuantityOld, 2);
                    herdEndorChgDetailDto.setChgInsureNumber(Integer.parseInt(ChgData.chgZero(dblQuantity) + ""));
                    double dblAmountNew = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListNewDto.getSumAmount())), 2);
                    double dblAmountOld = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListOldDto.getSumAmount())), 2);
                    double dblAmount = Str.round(dblAmountNew - dblAmountOld, 2);
                    herdEndorChgDetailDto.setChgSumAmount(dblAmount);
                    double dblPremiumNew = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListNewDto.getSumPremium())), 2);
                    double dblPremiumOld = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListOldDto.getSumPremium())), 2);
                    double dblPremium = Str.round(dblPremiumNew - dblPremiumOld, 2);
                    herdEndorChgDetailDto.setChgSumPremium(dblPremium);
                    double dblAreaNumberNew = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListNewDto.getAreaNumber())), 2);
                    double dblAreaNumberOld = Str.round(Double.parseDouble(ChgData.chgZero(herdPolicyListOldDto.getAreaNumber())), 2);
                    double dblAreaNumber = Str.round(dblAreaNumberNew - dblAreaNumberOld, 2);
                    herdEndorChgDetailDto.setChgAreaNumber(dblAreaNumber);
                    BigDecimal fPremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getInsurePremium());
                    BigDecimal fPremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getInsurePremium());
                    BigDecimal dbfPremium = fPremiumNew.subtract(fPremiumOld);
                    dbfPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgFPremium(dbfPremium.doubleValue());
                    BigDecimal centralPremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getCentralPremium());
                    BigDecimal centralPremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getCentralPremium());
                    BigDecimal dbCentralPremium = centralPremiumNew.subtract(centralPremiumOld);
                    dbCentralPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgCentralPremium(dbCentralPremium.doubleValue());
                    BigDecimal provincePremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getProvincePremium());
                    BigDecimal provincePremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getProvincePremium());
                    BigDecimal dbProvincePremium = provincePremiumNew.subtract(provincePremiumOld);
                    dbProvincePremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgProvincePremium(dbProvincePremium.doubleValue());
                    BigDecimal cityPremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getCityPremium());
                    BigDecimal cityPremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getCityPremium());
                    BigDecimal dbCityPremium = cityPremiumNew.subtract(cityPremiumOld);
                    dbCityPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgCityPremium(dbCityPremium.doubleValue());
                    BigDecimal townPremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getTownPremium());
                    BigDecimal townPremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getTownPremium());
                    BigDecimal dbTownPremium = townPremiumNew.subtract(townPremiumOld);
                    dbTownPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgTownPremium(dbTownPremium.doubleValue());
                    BigDecimal otherPremiumNew = BigDecimal.valueOf(herdPolicyListNewDto.getOtherPremium());
                    BigDecimal otherPremiumOld = BigDecimal.valueOf(herdPolicyListOldDto.getOtherPremium());
                    BigDecimal dbOtherPremium = otherPremiumNew.subtract(otherPremiumOld);
                    dbOtherPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    herdEndorChgDetailDto.setChgOtherPremium(dbOtherPremium.doubleValue());
                }

            blEndorseDto.getHerdEndorChgDetailListDtoList().add(herdEndorChgDetailDto);
        }
        HerdEndorHeadDto herdEndorHeadDto=new HerdEndorHeadDto();
        herdEndorHeadDto.setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
        herdEndorHeadDto.setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        blEndorseDto.setHerdEndorHeadDto(herdEndorHeadDto);
//        blEndorseDto.getHerdEndorHeadDto().setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
//        blEndorseDto.getHerdEndorHeadDto().setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());

    }
    /**
     * planting31EndorChgDetail表处理
     * @param planting31PolicyListDtoList 表对象集合
     * @param blPolicyDtoNew  页面传入保单大对象
     * @param blEndorseDto   批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:42 2017/12/5
     */
    @Override
    public void evaluatePlanting31FromPolicyToEndor(List<Planting31PolicyListDto> planting31PolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception {
        int i = 0;
        Planting31EndorChgDetailDto planting31EndorChgDetailDto = null;
        Planting31PolicyListDto planting31PolicyListOldDto = null;
        Planting31PolicyListDto planting31PolicyListNewDto = null;
        Planting31PolicyListDto planting31PolicyListNewDtoTmp = null;
        Hashtable hashItemKind = new Hashtable();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPlanting31PolicyListDtoList() == null || (blPolicyDtoNew.getPlanting31PolicyListDtoList().size() < planting31PolicyListDtoList.size())) {
//            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！Planting31PolicyList");
            return;

        }
        //将indexCode与其Dto建立映射关系
        for (i = 0; i < planting31PolicyListDtoList.size(); i++) {
            planting31PolicyListNewDtoTmp = new Planting31PolicyListDto();
            planting31PolicyListNewDtoTmp = planting31PolicyListDtoList.get(i);
            hashItemKind.put("" + planting31PolicyListNewDtoTmp.getfIdCard() + planting31PolicyListNewDtoTmp.getKindCode() + planting31PolicyListNewDtoTmp.getItemCode(), planting31PolicyListNewDtoTmp);
        }
        //建立映射关系完毕
        if(blEndorseDto.getPlanting31EndorChgDetailDtoList()==null){
            List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList=new ArrayList<>();
            blEndorseDto.setPlanting31EndorChgDetailDtoList(planting31EndorChgDetailDtoList);
        }
        if(blEndorseDto.getPlantingEndorHeadDto()==null){
            blEndorseDto.setPlantingEndorHeadDto(new PlantingEndorHeadDto());
        }

        for (i = 0; i < blPolicyDtoNew.getPlanting31PolicyListDtoList().size(); i++) {
            planting31PolicyListNewDto = blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i);
            planting31PolicyListOldDto = new Planting31PolicyListDto();
                    planting31PolicyListOldDto = (Planting31PolicyListDto) hashItemKind.get(""
                            + planting31PolicyListNewDto.getfIdCard() + planting31PolicyListNewDto.getKindCode() + planting31PolicyListNewDto.getItemCode());
                    if (planting31PolicyListOldDto == null) {
                        continue;
                    }

                planting31EndorChgDetailDto = new Planting31EndorChgDetailDto();
                planting31EndorChgDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                planting31EndorChgDetailDto.setInusreListCode(planting31PolicyListOldDto.getInusreListCode());
                planting31EndorChgDetailDto.setfCode(planting31PolicyListOldDto.getfCode());
                planting31EndorChgDetailDto.setKindCode(planting31PolicyListOldDto.getKindCode());
                planting31EndorChgDetailDto.setItemCode(planting31PolicyListOldDto.getItemCode());
                planting31EndorChgDetailDto.setIndexCode(planting31PolicyListOldDto.getIndexCode());
                planting31EndorChgDetailDto.setPhone(planting31PolicyListOldDto.getPhone());
                planting31EndorChgDetailDto.setBank(planting31PolicyListOldDto.getBank());
                planting31EndorChgDetailDto.setZhiBuKa(planting31PolicyListOldDto.getZhiBuKa());
                planting31EndorChgDetailDto.setfName(planting31PolicyListOldDto.getfName());
                planting31EndorChgDetailDto.setfIdCard(planting31PolicyListOldDto.getfIdCard());
                planting31EndorChgDetailDto.setClassCode(planting31PolicyListOldDto.getClassCode());
                planting31EndorChgDetailDto.setRiskCode(planting31PolicyListOldDto.getRiskCode());
                planting31EndorChgDetailDto.setFareaCode(planting31PolicyListOldDto.getfAreaCode());
                planting31EndorChgDetailDto.setTaxArea(planting31PolicyListOldDto.getTaxArea());
                planting31EndorChgDetailDto.setInsureArea(planting31PolicyListOldDto.getInsureArea());
                planting31EndorChgDetailDto.setAmount(planting31PolicyListOldDto.getAmount());
                planting31EndorChgDetailDto.setRate(planting31PolicyListOldDto.getRate());
                planting31EndorChgDetailDto.setShortRateFlag(planting31PolicyListOldDto.getShortRateFlag());
                planting31EndorChgDetailDto.setShortRate(planting31PolicyListOldDto.getShortRate());
                planting31EndorChgDetailDto.setSumAmount(planting31PolicyListOldDto.getSumAmount());
                planting31EndorChgDetailDto.setSumPremium(planting31PolicyListOldDto.getSumPremium());
                planting31EndorChgDetailDto.setStartDate(planting31PolicyListOldDto.getStartDate());
                planting31EndorChgDetailDto.setEndDate(planting31PolicyListOldDto.getEndDate());
                planting31EndorChgDetailDto.setCalculateFlag(planting31PolicyListOldDto.getCalculateFlag());
                planting31EndorChgDetailDto.setOpCode(planting31PolicyListOldDto.getOpCode());
                planting31EndorChgDetailDto.setValidity(planting31PolicyListOldDto.getValidity());
                planting31EndorChgDetailDto.setRemark(planting31PolicyListOldDto.getRemark());
                planting31EndorChgDetailDto.setfPremium(planting31PolicyListOldDto.getfPremium());
                planting31EndorChgDetailDto.setTeamName(planting31PolicyListOldDto.getTeamName());
                planting31EndorChgDetailDto.setFieldSource(planting31PolicyListOldDto.getFieldSource());
                planting31EndorChgDetailDto.setCentralPremium(planting31PolicyListOldDto.getCentralPremium());
                planting31EndorChgDetailDto.setProvincePremium(planting31PolicyListOldDto.getProvincePremium());
                planting31EndorChgDetailDto.setCityPremium(planting31PolicyListOldDto.getCityPremium());
                planting31EndorChgDetailDto.setTownPremium(planting31PolicyListOldDto.getTownPremium());
                planting31EndorChgDetailDto.setOtherPremium(planting31PolicyListOldDto.getOtherPremium());
            if(planting31PolicyListNewDto.getFlag()==null){
                planting31EndorChgDetailDto.setFlag(" "); //标志用新的
            }else {
                planting31EndorChgDetailDto.setFlag(planting31PolicyListNewDto.getFlag()); //标志用新的
            }

            if(blEndorseDto!= null && blEndorseDto.getEndorseConditionDto() != null
                    && blEndorseDto.getEndorseConditionDto().getEndorType() != null
                    && "85".equals(blEndorseDto.getEndorseConditionDto().getEndorType())){
                    planting31EndorChgDetailDto.setChgInsureArea(0.0);
                    planting31EndorChgDetailDto.setChgSumAmount(0.0);
                    planting31EndorChgDetailDto.setChgSumPremium(0.0);
                    planting31EndorChgDetailDto.setChgFPremium(0.0);
                    planting31EndorChgDetailDto.setChgCentralPremium(0.0);
                    planting31EndorChgDetailDto.setChgProvincePremium(0.0);
                    planting31EndorChgDetailDto.setChgCityPremium(0.0);
                    planting31EndorChgDetailDto.setChgTownPremium(0.0);
                    planting31EndorChgDetailDto.setChgOtherPremium(0.0);
                }
                //变化量
//                if(planting31PolicyListNewDto.getFlag()==null){
//                    planting31PolicyListNewDto.setFlag("");
//                }
                    if (StringUtils.isNotEmpty(planting31PolicyListNewDto.getFlag())&&planting31EndorChgDetailDto.getFlag().charAt(0) == 'I') {
                        planting31EndorChgDetailDto.setChgInsureArea(planting31EndorChgDetailDto.getInsureArea());
                        planting31EndorChgDetailDto.setChgSumAmount(planting31EndorChgDetailDto.getSumAmount());
                        planting31EndorChgDetailDto.setChgSumPremium(planting31EndorChgDetailDto.getSumPremium());
                    } else {
                        BigDecimal InsureAreaNew = BigDecimal.valueOf(planting31PolicyListNewDto.getInsureArea());
                        BigDecimal InsureAreaOld = BigDecimal.valueOf(planting31PolicyListOldDto.getInsureArea());
                        BigDecimal dbInsureArea = InsureAreaNew.subtract(InsureAreaOld);
                        dbInsureArea.setScale(3, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgInsureArea(dbInsureArea.doubleValue());
                        BigDecimal SumAmountNew = BigDecimal.valueOf(planting31PolicyListNewDto.getSumAmount());
                        System.err.println("new" + SumAmountNew);
                        BigDecimal SumAmountOld = BigDecimal.valueOf(planting31PolicyListOldDto.getSumAmount());
                        System.err.println("old" + SumAmountOld);
                        BigDecimal dbSumAmount = SumAmountNew.subtract(SumAmountOld);
                        dbSumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgSumAmount(dbSumAmount.doubleValue());
                        BigDecimal SumPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getSumPremium());
                        BigDecimal SumPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getSumPremium());
                        BigDecimal dbSumPremium = SumPremiumNew.subtract(SumPremiumOld);
                        dbSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgSumPremium(dbSumPremium.doubleValue());
                        BigDecimal fPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getfPremium());
                        BigDecimal fPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getfPremium());
                        BigDecimal dbfPremium = fPremiumNew.subtract(fPremiumOld);
                        dbfPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgFPremium(dbfPremium.doubleValue());
                        BigDecimal centralPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getCentralPremium());
                        BigDecimal centralPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getCentralPremium());
                        BigDecimal dbCentralPremium = centralPremiumNew.subtract(centralPremiumOld);
                        dbCentralPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgCentralPremium(dbCentralPremium.doubleValue());
                        BigDecimal provincePremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getProvincePremium());
                        BigDecimal provincePremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getProvincePremium());
                        BigDecimal dbProvincePremium = provincePremiumNew.subtract(provincePremiumOld);
                        dbProvincePremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgProvincePremium(dbProvincePremium.doubleValue());
                        BigDecimal cityPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getCityPremium());
                        BigDecimal cityPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getCityPremium());
                        BigDecimal dbCityPremium = cityPremiumNew.subtract(cityPremiumOld);
                        dbCityPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgCityPremium(dbCityPremium.doubleValue());
                        BigDecimal townPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getTownPremium());
                        BigDecimal townPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getTownPremium());
                        BigDecimal dbTownPremium = townPremiumNew.subtract(townPremiumOld);
                        dbTownPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgTownPremium(dbTownPremium.doubleValue());
                        BigDecimal otherPremiumNew = BigDecimal.valueOf(planting31PolicyListNewDto.getOtherPremium());
                        BigDecimal otherPremiumOld = BigDecimal.valueOf(planting31PolicyListOldDto.getOtherPremium());
                        BigDecimal dbOtherPremium = otherPremiumNew.subtract(otherPremiumOld);
                        dbOtherPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                        planting31EndorChgDetailDto.setChgOtherPremium(dbOtherPremium.doubleValue());
                    }

                blEndorseDto.getPlanting31EndorChgDetailDtoList().add(planting31EndorChgDetailDto);
            }
            PlantingEndorHeadDto plantingEndorHeadDto=new PlantingEndorHeadDto();
        plantingEndorHeadDto.setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
        plantingEndorHeadDto.setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        blEndorseDto.setPlantingEndorHeadDto(plantingEndorHeadDto);
//        blEndorseDto.getPlantingEndorHeadDto().setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
//        blEndorseDto.getPlantingEndorHeadDto().setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        }
    /**
     * nyxEndorChgDetail表处理
     * @param nyxPolicyListDtoList 表对象集合
     * @param blPolicyDtoNew  页面传入保单大对象
     * @param blEndorseDto   批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:42 2017/12/5
     */
    @Override
    public void evaluateNyxFromPolicyToEndor(List<NyxPolicyListDto> nyxPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        int i = 0;
        NyxEndorChgDetailDto nyxEndorChgDetailDto = null;
        NyxPolicyListDto nyxPolicyListOldDto = null;
        NyxPolicyListDto nyxPolicyListNewDto = null;
        NyxPolicyListDto nyxPolicyListNewDtoTmp = null;
        Hashtable hashItemKind = new Hashtable();
        if(blPolicyDtoNew.getNyxPolicyListDtoList() == null){
        	return;
        }
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getNyxPolicyListDtoList().size() < nyxPolicyListDtoList.size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！NyxPolicyList");
        }
        //将indexNo与其Dto建立映射关系
        for (i = 0; i < nyxPolicyListDtoList.size(); i++) {
            nyxPolicyListNewDtoTmp = nyxPolicyListDtoList.get(i);
            hashItemKind.put("" + nyxPolicyListNewDtoTmp.getBusinessNo() + nyxPolicyListNewDtoTmp.getKindCode() + nyxPolicyListNewDtoTmp.getItemCode(), nyxPolicyListNewDtoTmp);
        }
        if(blEndorseDto.getNyxEndorChgDetailDtoList()==null){
            List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList=new ArrayList<>();
            blEndorseDto.setNyxEndorChgDetailDtoList(nyxEndorChgDetailDtoList);
        }
        //建立映射关系完毕
        for (i = 0; i < blPolicyDtoNew.getNyxPolicyListDtoList().size(); i++) {
            nyxPolicyListNewDto = blPolicyDtoNew.getNyxPolicyListDtoList().get(i);
                nyxPolicyListOldDto = (NyxPolicyListDto) hashItemKind.get(""
                        + nyxPolicyListNewDto.getBusinessNo() + nyxPolicyListNewDto.getKindCode() + nyxPolicyListNewDto.getItemCode());
                if (nyxPolicyListOldDto == null) {
                    continue;
                }

            nyxEndorChgDetailDto = new NyxEndorChgDetailDto();
            nyxEndorChgDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            nyxEndorChgDetailDto.setfCode(nyxPolicyListOldDto.getfCode());
            nyxEndorChgDetailDto.setfName(nyxPolicyListOldDto.getfName());
            nyxEndorChgDetailDto.setfIdCard(nyxPolicyListOldDto.getfIdCard());
            nyxEndorChgDetailDto.setBank(nyxPolicyListOldDto.getBank());
            nyxEndorChgDetailDto.setBankCard(nyxPolicyListOldDto.getBankCard());
            if(nyxPolicyListNewDto.getFlag()==null){
                nyxEndorChgDetailDto.setFlag(""); //标志用新的
            }else {
                nyxEndorChgDetailDto.setFlag(nyxPolicyListNewDto.getFlag()); //标志用新的
            }
            nyxEndorChgDetailDto.setBreedingAreaCode(nyxPolicyListOldDto.getBreedingAreaCode());
            nyxEndorChgDetailDto.setBreedingAreaName(nyxPolicyListOldDto.getBreedingAreaName());
            nyxEndorChgDetailDto.setBreedingKind(nyxPolicyListOldDto.getBreedingKind());
            nyxEndorChgDetailDto.setBusinessNo(nyxPolicyListOldDto.getBusinessNo());
            nyxEndorChgDetailDto.setInsureNumber(nyxPolicyListOldDto.getInsureNumber());
            nyxEndorChgDetailDto.setSumPremium(nyxPolicyListOldDto.getSumPremium());
            nyxEndorChgDetailDto.setfPremium(nyxPolicyListOldDto.getfPremium());
            nyxEndorChgDetailDto.setInusreListCode(nyxPolicyListOldDto.getInusreListCode());
            nyxEndorChgDetailDto.setKindCode(nyxPolicyListOldDto.getKindCode());
            nyxEndorChgDetailDto.setAmount(nyxPolicyListOldDto.getAmount());
            nyxEndorChgDetailDto.setEndDate(nyxPolicyListOldDto.getEndDate());
            nyxEndorChgDetailDto.setStartDate(nyxPolicyListOldDto.getStartDate());
            nyxEndorChgDetailDto.setIndexCode(nyxPolicyListOldDto.getIndexCode());
            nyxEndorChgDetailDto.setShortRateFlag(nyxPolicyListOldDto.getShortRateFlag());
            nyxEndorChgDetailDto.setShortRate(nyxPolicyListOldDto.getShortRate());
            nyxEndorChgDetailDto.setValidity(nyxPolicyListOldDto.getValidity());
            nyxEndorChgDetailDto.setSumAmount(nyxPolicyListOldDto.getSumAmount());
            nyxEndorChgDetailDto.setSumPremium(nyxPolicyListOldDto.getSumPremium());
            nyxEndorChgDetailDto.setSpecies(nyxPolicyListOldDto.getSpecies());
            nyxEndorChgDetailDto.setRate(nyxPolicyListOldDto.getRate());
            nyxEndorChgDetailDto.setOpCode(nyxPolicyListOldDto.getOpCode());
            nyxEndorChgDetailDto.setOpTime(nyxPolicyListOldDto.getOpTime());
            nyxEndorChgDetailDto.setCalculateFlag(nyxPolicyListOldDto.getCalculateFlag());
            nyxEndorChgDetailDto.setPhone(nyxPolicyListOldDto.getPhone());
            nyxEndorChgDetailDto.setAreaNumber(nyxPolicyListOldDto.getAreaNumber());
            nyxEndorChgDetailDto.setLitterArea(nyxPolicyListOldDto.getLitterArea());
            nyxEndorChgDetailDto.setItemCode(nyxPolicyListOldDto.getItemCode());
            nyxEndorChgDetailDto.setZhiBuKa(nyxPolicyListOldDto.getZhiBuKa());
            nyxEndorChgDetailDto.setBreedingNumber(nyxPolicyListOldDto.getBreedingNumber());
            nyxEndorChgDetailDto.setSettleNumber(nyxPolicyListOldDto.getSettleNumber());
            nyxEndorChgDetailDto.setClassCode(nyxPolicyListOldDto.getClassCode());
            nyxEndorChgDetailDto.setRiskCode(nyxPolicyListOldDto.getRiskCode());
            nyxEndorChgDetailDto.setFareaCode(nyxPolicyListOldDto.getfAreaCode());
            nyxEndorChgDetailDto.setTaxArea(nyxPolicyListOldDto.getTaxArea());
            nyxEndorChgDetailDto.setInsureArea(nyxPolicyListOldDto.getInsureArea());
            nyxEndorChgDetailDto.setRemark(nyxPolicyListOldDto.getRemark());
            nyxEndorChgDetailDto.setTeamName(nyxPolicyListOldDto.getTeamName());
            nyxEndorChgDetailDto.setCentralPremium(nyxPolicyListOldDto.getCentralPremium());
            nyxEndorChgDetailDto.setProvincePremium(nyxPolicyListOldDto.getProvincePremium());
            nyxEndorChgDetailDto.setCityPremium(nyxPolicyListOldDto.getCityPremium());
            nyxEndorChgDetailDto.setTownPremium(nyxPolicyListOldDto.getTownPremium());
            nyxEndorChgDetailDto.setOtherPremium(nyxPolicyListOldDto.getOtherPremium());
            nyxEndorChgDetailDto.setFieldSource(nyxPolicyListOldDto.getFieldSource());
            nyxEndorChgDetailDto.setAtArea(nyxPolicyListOldDto.getAtArea());
            nyxEndorChgDetailDto.setMulchDate(nyxPolicyListOldDto.getMulchDate());
            nyxEndorChgDetailDto.setMulchType(nyxPolicyListOldDto.getMulchType());
            nyxEndorChgDetailDto.setTemp1(nyxPolicyListOldDto.getTemp1());
             nyxEndorChgDetailDto.setTemp2(nyxPolicyListOldDto.getTemp2());
             //todo 恶心问题，搞一宿 田健
            if(blEndorseDto!= null && blEndorseDto.getEndorseConditionDto() != null
                    && blEndorseDto.getEndorseConditionDto().getEndorType() != null
                        && "85".equals(blEndorseDto.getEndorseConditionDto().getEndorType())){
                nyxEndorChgDetailDto.setChgInsureArea(0.0);
                nyxEndorChgDetailDto.setChgSumAmount(0.0);
                nyxEndorChgDetailDto.setChgSumPremium(0.0);
                nyxEndorChgDetailDto.setChgFPremium(0.0);
                nyxEndorChgDetailDto.setChgCentralPremium(0.0);
                nyxEndorChgDetailDto.setChgProvincePremium(0.0);
                nyxEndorChgDetailDto.setChgCityPremium(0.0);
                nyxEndorChgDetailDto.setChgTownPremium(0.0);
                nyxEndorChgDetailDto.setChgOtherPremium(0.0);
                nyxEndorChgDetailDto.setChgAreaNumber(0.0);
                nyxEndorChgDetailDto.setChgInsureNumber(0);
            }
            //变化量
                if (StringUtils.isNotEmpty(nyxPolicyListNewDto.getFlag())&&nyxEndorChgDetailDto.getFlag().charAt(0) == 'I') {
                    nyxEndorChgDetailDto.setChgInsureNumber(1);
                    nyxEndorChgDetailDto.setChgSumAmount(nyxPolicyListNewDto.getSumAmount());
                    nyxEndorChgDetailDto.setChgSumPremium(nyxPolicyListNewDto.getSumPremium());
                    nyxEndorChgDetailDto.setChgAreaNumber(nyxPolicyListNewDto.getAreaNumber());
                } else {
                    BigDecimal dblQuantityNew = BigDecimal.valueOf(nyxPolicyListNewDto.getInsureNumber());
                    BigDecimal dblQuantityOld = BigDecimal.valueOf(nyxPolicyListOldDto.getInsureNumber());
                    BigDecimal dblQuantity = dblQuantityNew.subtract(dblQuantityOld);
                    dblQuantity.setScale(0, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgInsureNumber(Integer.parseInt(dblQuantity.toString()));
                    BigDecimal dblAmountNew = BigDecimal.valueOf(nyxPolicyListNewDto.getSumAmount());
                    BigDecimal dblAmountOld = BigDecimal.valueOf(nyxPolicyListOldDto.getSumAmount());
                    BigDecimal dblAmount = dblAmountNew.subtract(dblAmountOld);
                    dblAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgSumAmount(dblAmount.doubleValue());
                    BigDecimal dblPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getSumPremium());
                    BigDecimal dblPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getSumPremium());
                    BigDecimal dblPremium = dblPremiumNew.subtract(dblPremiumOld);
                    dblPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgSumPremium(dblPremium.doubleValue());

                    BigDecimal dblAreaNumberNew = BigDecimal.valueOf(nyxPolicyListNewDto.getAreaNumber());
                    BigDecimal dblAreaNumberOld = BigDecimal.valueOf(nyxPolicyListOldDto.getAreaNumber());
                    BigDecimal dblAreaNumber = dblAreaNumberNew.subtract(dblAreaNumberOld);
                    dblAreaNumber.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgAreaNumber(dblAreaNumber.doubleValue());
                    BigDecimal fPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getfPremium());
                    BigDecimal fPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getfPremium());
                    BigDecimal dbfPremium = fPremiumNew.subtract(fPremiumOld);
                    dbfPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgFPremium(dbfPremium.doubleValue());
                    BigDecimal centralPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getCentralPremium());
                    BigDecimal centralPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getCentralPremium());
                    BigDecimal dbCentralPremium = centralPremiumNew.subtract(centralPremiumOld);
                    dbCentralPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgCentralPremium(dbCentralPremium.doubleValue());
                    BigDecimal provincePremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getProvincePremium());
                    BigDecimal provincePremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getProvincePremium());
                    BigDecimal dbProvincePremium = provincePremiumNew.subtract(provincePremiumOld);
                    dbProvincePremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgProvincePremium(dbProvincePremium.doubleValue());
                    BigDecimal cityPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getCityPremium());
                    BigDecimal cityPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getCityPremium());
                    BigDecimal dbCityPremium = cityPremiumNew.subtract(cityPremiumOld);
                    dbCityPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgCityPremium(dbCityPremium.doubleValue());
                    BigDecimal townPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getTownPremium());
                    BigDecimal townPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getTownPremium());
                    BigDecimal dbTownPremium = townPremiumNew.subtract(townPremiumOld);
                    dbTownPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgTownPremium(dbTownPremium.doubleValue());
                    BigDecimal otherPremiumNew = BigDecimal.valueOf(nyxPolicyListNewDto.getOtherPremium());
                    BigDecimal otherPremiumOld = BigDecimal.valueOf(nyxPolicyListOldDto.getOtherPremium());
                    BigDecimal dbOtherPremium = otherPremiumNew.subtract(otherPremiumOld);
                    dbOtherPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    nyxEndorChgDetailDto.setChgOtherPremium(dbOtherPremium.doubleValue());
                }

            blEndorseDto.getNyxEndorChgDetailDtoList().add(nyxEndorChgDetailDto);
        }
        NyxEndorHeadDto nyxEndorHeadDto=new NyxEndorHeadDto();
        nyxEndorHeadDto.setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
        nyxEndorHeadDto.setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        blEndorseDto.setNyxEndorHeadDto(nyxEndorHeadDto);
    }
    /**
     * plantingEndorChgDetail表处理
     * @param plantingPolicyListDtoList 表对象集合
     * @param blPolicyDtoNew  页面传入保单大对象
     * @param blEndorseDto   批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:42 2017/12/5
     */
    @Override
    public void evaluatePlantingFromPolicyToEndor(List<PlantingPolicyListDto> plantingPolicyListDtoList, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception {
        int i = 0;
        PlantingEndorChgDetailDto plantingEndorChgDetailDto = null;
        PlantingPolicyListDto plantingPolicyListOldDto = null;
        PlantingPolicyListDto plantingPolicyListNewDto = null;
        PlantingPolicyListDto plantingPolicyListNewDtoTmp = null;
        Hashtable hashItemKind = new Hashtable();
        if(blPolicyDtoNew.getPlantingPolicyListDtoList() == null){
        	return;
        }
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPlantingPolicyListDtoList().size() < plantingPolicyListDtoList.size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数!plantingPolicyListDto");
        }
        
        List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList = new ArrayList<PlantingEndorChgDetailDto>();
        List<PlantingEndorHeadDto> plantingEndorHeadDtoList = new ArrayList<PlantingEndorHeadDto>();
        //将indexCode与其Dto建立映射关系
        for (i = 0; i < plantingPolicyListDtoList.size(); i++) {
            plantingPolicyListNewDtoTmp = plantingPolicyListDtoList.get(i);
            hashItemKind.put("" + plantingPolicyListNewDtoTmp.getIndexCode(), plantingPolicyListNewDtoTmp);
        }
        //建立映射关系完毕
        for (i = 0; i < blPolicyDtoNew.getPlantingPolicyListDtoList().size(); i++) {
            plantingPolicyListNewDto = blPolicyDtoNew.getPlantingPolicyListDtoList().get(i);
                plantingPolicyListOldDto = (PlantingPolicyListDto) hashItemKind.get(""
                        + plantingPolicyListNewDto.getIndexCode());
                if (plantingPolicyListOldDto == null) {
                    continue;
                }

            plantingEndorChgDetailDto = new PlantingEndorChgDetailDto();
            plantingEndorChgDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            plantingEndorChgDetailDto.setInusreListCode(plantingPolicyListOldDto.getInusreListCode());
            plantingEndorChgDetailDto.setfCode(plantingPolicyListOldDto.getfCode());
            plantingEndorChgDetailDto.setKindCode(plantingPolicyListOldDto.getKindCode());
            plantingEndorChgDetailDto.setIndexCode(plantingPolicyListOldDto.getIndexCode());
            plantingEndorChgDetailDto.setPhone(plantingPolicyListOldDto.getPhone());
            plantingEndorChgDetailDto.setBank(plantingPolicyListOldDto.getBank());
            plantingEndorChgDetailDto.setZhiBuKa(plantingPolicyListOldDto.getZhiBuKa());
            plantingEndorChgDetailDto.setfName(plantingPolicyListOldDto.getfName());
            plantingEndorChgDetailDto.setfIdCard(plantingPolicyListOldDto.getfIdCard());
            plantingEndorChgDetailDto.setClassCode(plantingPolicyListOldDto.getClassCode());
            plantingEndorChgDetailDto.setRiskCode(plantingPolicyListOldDto.getRiskCode());
            plantingEndorChgDetailDto.setfAreaCode(plantingPolicyListOldDto.getfAreaCode());
            plantingEndorChgDetailDto.setTaxArea(plantingPolicyListOldDto.getTaxArea());
            plantingEndorChgDetailDto.setInsureArea(plantingPolicyListOldDto.getInsureArea());
            plantingEndorChgDetailDto.setAmount(plantingPolicyListOldDto.getAmount());
            plantingEndorChgDetailDto.setRate(plantingPolicyListOldDto.getRate());
            plantingEndorChgDetailDto.setShortRateFlag(plantingPolicyListOldDto.getShortRateFlag());
            plantingEndorChgDetailDto.setShortRate(plantingPolicyListOldDto.getShortRate());
            plantingEndorChgDetailDto.setSumAmount(plantingPolicyListOldDto.getSumAmount());
            plantingEndorChgDetailDto.setSumPremium(plantingPolicyListOldDto.getSumPremium());
            plantingEndorChgDetailDto.setStartDate(plantingPolicyListOldDto.getStartDate());
            plantingEndorChgDetailDto.setEndDate(plantingPolicyListOldDto.getEndDate());
            plantingEndorChgDetailDto.setCalculateFlag(plantingPolicyListOldDto.getCalculateFlag());
            plantingEndorChgDetailDto.setOpCode(plantingPolicyListOldDto.getOpCode());
            plantingEndorChgDetailDto.setOpTime(plantingPolicyListOldDto.getOpTime());
            plantingEndorChgDetailDto.setValidity(plantingPolicyListOldDto.getValidity());
            plantingEndorChgDetailDto.setRemark(plantingPolicyListOldDto.getRemark());
            plantingEndorChgDetailDto.setfPremium(plantingPolicyListOldDto.getfPremium());
            plantingEndorChgDetailDto.setTeamName(plantingPolicyListOldDto.getTeamName());
            plantingEndorChgDetailDto.setFieldSource(plantingPolicyListOldDto.getFieldSource());
            plantingEndorChgDetailDto.setCentralPremium(plantingPolicyListOldDto.getCentralPremium());
            plantingEndorChgDetailDto.setProvincePremium(plantingPolicyListOldDto.getProvincePremium());
            plantingEndorChgDetailDto.setCityPremium(plantingPolicyListOldDto.getCityPremium());
            plantingEndorChgDetailDto.setTownPremium(plantingPolicyListOldDto.getTownPremium());
            plantingEndorChgDetailDto.setOtherPremium(plantingPolicyListOldDto.getOtherPremium());
            plantingEndorChgDetailDto.setAtArea(plantingPolicyListOldDto.getAtArea());
            plantingEndorChgDetailDto.setLittleAreaName(plantingPolicyListOldDto.getLittleAreaName());
            plantingEndorChgDetailDto.setItemCode(plantingPolicyListOldDto.getItemCode());
            if(plantingPolicyListNewDto.getFlag()==null){
                plantingEndorChgDetailDto.setFlag(" "); //标志用新的
            }else {
                plantingEndorChgDetailDto.setFlag(plantingPolicyListNewDto.getFlag()); //标志用新的
            }
            plantingEndorChgDetailDto.setWarrant(plantingPolicyListNewDto.getWarrant());
            if(blEndorseDto!= null && blEndorseDto.getEndorseConditionDto() != null
                    && blEndorseDto.getEndorseConditionDto().getEndorType() != null
                    && "85".equals(blEndorseDto.getEndorseConditionDto().getEndorType())){
                plantingEndorChgDetailDto.setChgInsureArea(0.0);
                plantingEndorChgDetailDto.setChgSumAmount(0.0);
                plantingEndorChgDetailDto.setChgSumPremium(0.0);
                plantingEndorChgDetailDto.setChgFPremium(0.0);
                plantingEndorChgDetailDto.setChgCentralPremium(0.0);
                plantingEndorChgDetailDto.setChgProvincePremium(0.0);
                plantingEndorChgDetailDto.setChgCityPremium(0.0);
                plantingEndorChgDetailDto.setChgTownPremium(0.0);
                plantingEndorChgDetailDto.setChgOtherPremium(0.0);
            }
            if (plantingPolicyListNewDto.getWoodlandArea() != null && !plantingPolicyListNewDto.getWoodlandArea().equals("")) {
                plantingEndorChgDetailDto.setWoodLandArea(plantingPolicyListNewDto.getWoodlandArea());
            }

            //变化量
                if (StringUtils.isNotEmpty(plantingPolicyListNewDto.getFlag()) &&plantingEndorChgDetailDto.getFlag().charAt(0) == 'I') {
                    plantingEndorChgDetailDto.setChgInsureArea(plantingEndorChgDetailDto.getInsureArea());
                    plantingEndorChgDetailDto.setChgSumAmount(plantingPolicyListNewDto.getSumAmount());
                    plantingEndorChgDetailDto.setChgSumPremium(plantingPolicyListNewDto.getSumPremium());
                } else {
                    BigDecimal InsureAreaNew = BigDecimal.valueOf(plantingPolicyListNewDto.getInsureArea());
                    BigDecimal InsureAreaOld = BigDecimal.valueOf(plantingPolicyListOldDto.getInsureArea());
                    BigDecimal dbInsureArea = InsureAreaNew.subtract(InsureAreaOld);
                    dbInsureArea.setScale(3, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgInsureArea(dbInsureArea.doubleValue());
                    BigDecimal SumAmountNew = BigDecimal.valueOf(plantingPolicyListNewDto.getSumAmount());
                    BigDecimal SumAmountOld = BigDecimal.valueOf(plantingPolicyListOldDto.getSumAmount());
                    BigDecimal dbSumAmount = SumAmountNew.subtract(SumAmountOld);
                    dbSumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgSumAmount(dbSumAmount.doubleValue());
                    BigDecimal SumPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getSumPremium());
                    BigDecimal SumPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getSumPremium());
                    BigDecimal dbSumPremium = SumPremiumNew.subtract(SumPremiumOld);
                    dbSumPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgSumPremium(dbSumPremium.doubleValue());
                    BigDecimal fPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getfPremium());
                    BigDecimal fPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getfPremium());
                    BigDecimal dbfPremium = fPremiumNew.subtract(fPremiumOld);
                    dbfPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgFPremium(dbfPremium.doubleValue());
                    BigDecimal centralPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getCentralPremium());
                    BigDecimal centralPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getCentralPremium());
                    BigDecimal dbCentralPremium = centralPremiumNew.subtract(centralPremiumOld);
                    dbCentralPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgCentralPremium(dbCentralPremium.doubleValue());
                    BigDecimal provincePremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getProvincePremium());
                    BigDecimal provincePremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getProvincePremium());
                    BigDecimal dbProvincePremium = provincePremiumNew.subtract(provincePremiumOld);
                    dbProvincePremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgProvincePremium(dbProvincePremium.doubleValue());
                    BigDecimal cityPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getCityPremium());
                    BigDecimal cityPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getCityPremium());
                    BigDecimal dbCityPremium = cityPremiumNew.subtract(cityPremiumOld);
                    dbCityPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgCityPremium(dbCityPremium.doubleValue());
                    BigDecimal townPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getTownPremium());
                    BigDecimal townPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getTownPremium());
                    BigDecimal dbTownPremium = townPremiumNew.subtract(townPremiumOld);
                    dbTownPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgTownPremium(dbTownPremium.doubleValue());
                    BigDecimal otherPremiumNew = BigDecimal.valueOf(plantingPolicyListNewDto.getOtherPremium());
                    BigDecimal otherPremiumOld = BigDecimal.valueOf(plantingPolicyListOldDto.getOtherPremium());
                    BigDecimal dbOtherPremium = otherPremiumNew.subtract(otherPremiumOld);
                    dbOtherPremium.setScale(2, BigDecimal.ROUND_HALF_UP);
                    plantingEndorChgDetailDto.setChgOtherPremium(dbOtherPremium.doubleValue());
                }

            if(blEndorseDto.getPlantingEndorChgDetailDtoList() == null) {
            	
            	plantingEndorChgDetailDtoList.add(plantingEndorChgDetailDto);
            	blEndorseDto.setPlantingEndorChgDetailDtoList(plantingEndorChgDetailDtoList);
            }else {
            	blEndorseDto.getPlantingEndorChgDetailDtoList().add(plantingEndorChgDetailDto);
            }
            
            PlantingEndorHeadDto plantingEndorHeadDto = new PlantingEndorHeadDto();
            plantingEndorHeadDto.setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
            plantingEndorHeadDto.setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
            plantingEndorHeadDto.setInusreListCode(plantingPolicyListOldDto.getInusreListCode());
            if(blEndorseDto.getPlantingEndorHeadDtoList() == null) {
            	plantingEndorHeadDtoList.add(plantingEndorHeadDto);
            	blEndorseDto.setPlantingEndorHeadDtoList(plantingEndorHeadDtoList);
            }else {
            	blEndorseDto.getPlantingEndorHeadDtoList().add(plantingEndorHeadDto);
            }
        }
        
    }
    /**
    * 清单表保存处理
    * @param policyEndorseDto 保单批单封装dto
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:45 2017/12/5
    */
    @Override
    public void saveNYXList(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew = policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto = policyEndorseDto.getBlEndorseDto();
        String strRiskCode=blEndorseDto.getPrpPheadDto().getRiskCode();
        String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty("BREEDING_FARMER_LIST_FLAG");
        String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_FARMER_LIST_FLAG");//中央政策性种植险标志
        String nyxSingleFarmerListFlag =utiPlatConfigRuleApi.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");
        String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");

        if (null != breedingFarmerListFlag && null != strRiskCode
                && breedingFarmerListFlag.indexOf(strRiskCode) > -1 && !("3224".equals(strRiskCode))
                && !nyxMultipleFarmerListFlag.contains(strRiskCode)
                && !nyxSingleFarmerListFlag.contains(strRiskCode)) {
            if (blPolicyDtoNew.getHerdPolicyListDtoList().size() > 0) {
                saveHerdPolicy(blPolicyDtoNew,blEndorseDto);
            }
        }
        if("3224".equals(strRiskCode))
        {
            if (blPolicyDtoNew.getNyxPolicyListDtoList().size() > 0) {
                saveNyxInsureList(blPolicyDtoNew,blEndorseDto);
            }
        }
        if ("3129".equals(strRiskCode)) {
            Boolean aBoolean = cmcpManFieldListApi.insertCMcTOcp(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
//            if(!aBoolean){
//                throw new Exception("3129连带被保险人清单转存失败!");
//            }
        }
        // 农险二期新加入分户清单的险种
        if(nyxMultipleFarmerListFlag.contains(strRiskCode) || nyxSingleFarmerListFlag.contains(strRiskCode)) {
            if (blPolicyDtoNew.getNyxPolicyListDtoList().size() > 0) {
                saveNyxInsureList(blPolicyDtoNew,blEndorseDto);
            }
        }

        if (null != plantingFarmerListFlag && null != strRiskCode && (plantingFarmerListFlag.indexOf(strRiskCode) > -1||"3141".equals(strRiskCode))) {
            if (blPolicyDtoNew.getPlantingPolicyListDtoList()!=null&&blPolicyDtoNew.getPlantingPolicyListDtoList().size()>0) {
                savePlantInsureList(blPolicyDtoNew,blEndorseDto);
            }
            if("3141".equals(strRiskCode))
            {
                if (blPolicyDtoNew.getPlanting31PolicyListDtoList().size() > 0) {
                    savePlant31InsureList(blPolicyDtoNew,blEndorseDto);
                }
            }
        }
        if (("3147".equals(strRiskCode))) {
            if (blPolicyDtoNew.getPlanting31PolicyListDtoList().size() > 0) {
                savePlant31InsureList(blPolicyDtoNew,blEndorseDto);
            }
        }

//        if (blPolicyDtoNew.getPlantingPolicyListDtoList()!=null&&blPolicyDtoNew.getPlantingPolicyListDtoList().size() > 0) {
//            savePlantInsureList(blPolicyDtoNew, blEndorseDto);
//        }
//        if ("3141".equals(blEndorseDto.getPrpPheadDto().getRiskCode())) {
//            if (blPolicyDtoNew.getPlanting31PolicyListDtoList().size() > 0) {
//                savePlant31InsureList(blPolicyDtoNew, blEndorseDto);
//            }
//        }
//        if (("3147".equals(blEndorseDto.getPrpPheadDto().getRiskCode()))) {
//            if (blPolicyDtoNew.getPlanting31PolicyListDtoList() == null) {
//                return;
//            } else if (blPolicyDtoNew.getPlanting31PolicyListDtoList().size() > 0) {
//                savePlant31InsureList(blPolicyDtoNew, blEndorseDto);
//            }
//        }

    }

    /**
     * ±£´æ±£µ¥·Ö»§ÐÅÏ¢
     *
     * @param blPolicyDtoNew ±£µ¥´ó¶ÔÏó
     * @param blEndorseDto   Åúµ¥´ó¶ÔÏó
     * @throws Exception
     */

    public void savePlantInsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        String endorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();

        //É¾³ýÅúµ¥
        plantingEndorChgDetailApi.removeInsureList(endorseNo);
        plantingEndorHeadApi.removePlantingEndorHead(endorseNo);

        //¸øCP±í¸³Öµ
        this.generatePrpCPPlantInsureList(blPolicyDtoNew, blEndorseDto);
        if (blEndorseDto.getPlantingCpEndorChgDetailDtoList().size() > 0) {
            plantingCpEndorChgDetailApi.removePlantingCpEndorChgDetail(blPolicyDtoNew.getPlantingPolicyListDtoList().get(0).getInusreListCode());
        }
        if (blEndorseDto.getPlantingCpEndorChgDetailDtoList().size() > 0) {
            plantingCpEndorChgDetailApi.savePlantingCpEndorChgDetail(blEndorseDto.getPlantingCpEndorChgDetailDtoList());
        }
        //Åúµ¥·Ö»§ÐÅÏ¢±£´æ
        String strEndorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();
        for(PlantingEndorChgDetailDto PlantingEndorChgDetailDto : blEndorseDto.getPlantingEndorChgDetailDtoList()) {
        	PlantingEndorChgDetailDto.setEndorseNo(strEndorseNo);
        }
        for(PlantingEndorHeadDto plantingEndorHeadDto : blEndorseDto.getPlantingEndorHeadDtoList()) {
        	plantingEndorHeadDto.setEndorseNo(strEndorseNo);
        }
        plantingEndorChgDetailApi.savePlantingEndorChgDetail(blEndorseDto.getPlantingEndorChgDetailDtoList());
        PlantingEndorHeadDto plantingEndorHeadDto=new PlantingEndorHeadDto();
        plantingEndorHeadDto.setInusreListCode(blPolicyDtoNew.getPlantingPolicyListDtoList().get(0).getInusreListCode());
        plantingEndorHeadDto.setEndorseNo(endorseNo);
        plantingEndorHeadDto.setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
        plantingEndorHeadDto.setIsDeleteFlag("1");
        plantingEndorHeadDto.setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        blEndorseDto.setPlantingEndorHeadDto(plantingEndorHeadDto);
        plantingEndorHeadApi.savePlantingEndorHead(blEndorseDto.getPlantingEndorHeadDto());

    }

    /**
     * ±£´æ±£µ¥·Ö»§ÐÅÏ¢
     *
     * @param blPolicyDtoNew ±£µ¥´ó¶ÔÏó
     * @param blEndorseDto   Åúµ¥´ó¶ÔÏó
     * @throws Exception
     */
    public void savePlant31InsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        String endorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();

        //É¾³ýÅúµ¥
        planting31EndorChgDetailApi.removePlanting31EndorChgDetail(endorseNo);
        plantingEndorHeadApi.removePlantingEndorHead(endorseNo);
        //¸øCP±í¸³Öµ
        generatePrpCPPlant31InsureList(blPolicyDtoNew,blEndorseDto);
        if (blEndorseDto.getPlanting31EndorChgDetailDtoList() != null) {
            planting31EndorChgDetailApi.savePlanting31EndorChgDetail(blEndorseDto.getPlanting31EndorChgDetailDtoList());
        }
        if (blEndorseDto.getPlanting31CpEndorChgDetailDtoList() != null && blEndorseDto.getPlanting31CpEndorChgDetailDtoList().size() > 0) {
            planting31CpEndorChgDetailApi.removePlanting31CpEndorChgDetail(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(0).getInusreListCode());
        }
        if (blEndorseDto.getPlanting31CpEndorChgDetailDtoList() == null) {
            return;
        } else if (blEndorseDto.getPlanting31CpEndorChgDetailDtoList().size() > 0) {
            planting31CpEndorChgDetailApi.savePlanting31CpEndorChgDetail(blEndorseDto.getPlanting31CpEndorChgDetailDtoList());
        }
        //Åúµ¥·Ö»§ÐÅÏ¢±£´æ
        for(Planting31EndorChgDetailDto planting31EndorChgDetailDto:blEndorseDto.getPlanting31EndorChgDetailDtoList()){
            planting31EndorChgDetailDto.setEndorseNo(endorseNo);
        }
        planting31EndorChgDetailApi.savePlanting31EndorChgDetail(blEndorseDto.getPlanting31EndorChgDetailDtoList());
        blEndorseDto.getPlantingEndorHeadDto().setEndorseNo(endorseNo);
        blEndorseDto.getPlantingEndorHeadDto().setInusreListCode(blPolicyDtoNew.getPlanting31PolicyListDtoList().get(0).getInusreListCode());
        plantingEndorHeadApi.savePlantingEndorHead(blEndorseDto.getPlantingEndorHeadDto());

    }

    public void saveHerdPolicy(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        String endorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();
        herdEndorChgDetailApi.removeByEndorseNo(endorseNo);
        generatePrpCPInsureList(blPolicyDtoNew,blEndorseDto);
        if(blEndorseDto.getHerdcEndorChgDetailDtoList()!=null&&blEndorseDto.getHerdcEndorChgDetailDtoList().size()>0){
            herdcEndorChgDetailApi.removeByInsureListCode(blPolicyDtoNew.getHerdPolicyListDtoList().get(0).getInusreListCode());
            herdcEndorChgDetailApi.save(blEndorseDto.getHerdcEndorChgDetailDtoList());
        }
        for(HerdEndorChgDetailDto herdEndorChgDetailDto:blEndorseDto.getHerdEndorChgDetailListDtoList()){
            herdEndorChgDetailDto.setEndorseNo(endorseNo);
        }
        herdEndorChgDetailApi.saveList(blEndorseDto.getHerdEndorChgDetailListDtoList());
        blEndorseDto.getHerdEndorHeadDto().setEndorseNo(endorseNo);
        blEndorseDto.getHerdEndorHeadDto().setInusreListCode(blPolicyDtoNew.getHerdPolicyListDtoList().get(0).getInusreListCode());
        herdEndorHeadApi.save(blEndorseDto.getHerdEndorHeadDto());
    }
    public void saveNyxInsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        String endorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();
        nyxEndorChgDetailApi.removeByEnodrseNo(endorseNo);
        nyxEndorHeadApi.remove(endorseNo);
        generatePrpCPNyxInsureList(blPolicyDtoNew,blEndorseDto);
        if(blEndorseDto.getNyxCpEndorChgDetailDtoList().size()>0){
            nyxCpEndorChgDetailApi.remove(endorseNo);
            nyxCpEndorChgDetailApi.saveList(blEndorseDto.getNyxCpEndorChgDetailDtoList());
        }
        for(NyxEndorChgDetailDto nyxEndorChgDetailDto:blEndorseDto.getNyxEndorChgDetailDtoList()){
            nyxEndorChgDetailDto.setEndorseNo(endorseNo);
        }
        nyxEndorChgDetailApi.saveList(blEndorseDto.getNyxEndorChgDetailDtoList());
        blEndorseDto.getNyxEndorHeadDto().setInusreListCode(blPolicyDtoNew.getNyxPolicyListDtoList().get(0).getInusreListCode());
        blEndorseDto.getNyxEndorHeadDto().setEndorseNo(endorseNo);
        nyxEndorHeadApi.save(blEndorseDto.getNyxEndorHeadDto());
    }
    /**
     * Éú³ÉÅúµ¥»º´æPlantingCpEndorChgDetailDto¶ÔÏó
     *
     * @param blPolicyDtoNew ±£µ¥´ó¶ÓÏó
     * @param blEndorseDto   Åúµ¥´ó¶ÔÏó
     * @throws Exception
     */
    private void generatePrpCPPlantInsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        PlantingCpEndorChgDetailDto plantingCpEndorChgDetailDto = null;
        PlantingPolicyListDto plantingPolicyListDto = null;
        for (int i = 0; i < blPolicyDtoNew.getPlantingPolicyListDtoList().size(); i++) {
            plantingPolicyListDto = blPolicyDtoNew.getPlantingPolicyListDtoList().get(i);
            plantingCpEndorChgDetailDto = new PlantingCpEndorChgDetailDto();
            plantingCpEndorChgDetailDto.setInusreListCode(plantingPolicyListDto.getInusreListCode());
            plantingCpEndorChgDetailDto.setFCode(plantingPolicyListDto.getfCode());
            plantingCpEndorChgDetailDto.setKindCode(plantingPolicyListDto.getKindCode());
            plantingCpEndorChgDetailDto.setIndexCode(plantingPolicyListDto.getIndexCode());
            plantingCpEndorChgDetailDto.setPhone(plantingPolicyListDto.getPhone());
            plantingCpEndorChgDetailDto.setBank(plantingPolicyListDto.getBank());
            plantingCpEndorChgDetailDto.setZhiBuKa(plantingPolicyListDto.getZhiBuKa());
            plantingCpEndorChgDetailDto.setFName(plantingPolicyListDto.getfName());
            plantingCpEndorChgDetailDto.setFIdCcard(plantingPolicyListDto.getfIdCard());
            plantingCpEndorChgDetailDto.setClassCode(plantingPolicyListDto.getClassCode());
            plantingCpEndorChgDetailDto.setRiskCode(plantingPolicyListDto.getRiskCode());
            plantingCpEndorChgDetailDto.setFAreaCode(plantingPolicyListDto.getfAreaCode());
            plantingCpEndorChgDetailDto.setTaxArea(plantingPolicyListDto.getTaxArea());
            plantingCpEndorChgDetailDto.setInsureArea(plantingPolicyListDto.getInsureArea());
            plantingCpEndorChgDetailDto.setAmount(plantingPolicyListDto.getAmount());
            plantingCpEndorChgDetailDto.setRate(plantingPolicyListDto.getRate());
            plantingCpEndorChgDetailDto.setShortRateFlag(plantingPolicyListDto.getShortRateFlag());
            plantingCpEndorChgDetailDto.setShortRate(plantingPolicyListDto.getShortRate());
            plantingCpEndorChgDetailDto.setSumAmount(plantingPolicyListDto.getSumAmount());
            plantingCpEndorChgDetailDto.setSumPremium(plantingPolicyListDto.getSumPremium());
            plantingCpEndorChgDetailDto.setStartDate(plantingPolicyListDto.getStartDate());
            plantingCpEndorChgDetailDto.setEndDate(plantingPolicyListDto.getEndDate());
            plantingCpEndorChgDetailDto.setCalculateFlag(plantingPolicyListDto.getCalculateFlag());
            plantingCpEndorChgDetailDto.setOpCode(plantingPolicyListDto.getOpCode());
            plantingCpEndorChgDetailDto.setOpTime(plantingPolicyListDto.getOpTime());
            plantingCpEndorChgDetailDto.setValidity(plantingPolicyListDto.getValidity());
            plantingCpEndorChgDetailDto.setRemark(plantingPolicyListDto.getRemark());
            plantingCpEndorChgDetailDto.setFPremium(plantingPolicyListDto.getfPremium());
            plantingCpEndorChgDetailDto.setTeamName(plantingPolicyListDto.getTeamName());
            plantingCpEndorChgDetailDto.setCentralPremium(plantingPolicyListDto.getCentralPremium());
            plantingCpEndorChgDetailDto.setProvincePremium(plantingPolicyListDto.getProvincePremium());
            plantingCpEndorChgDetailDto.setCityPremium(plantingPolicyListDto.getCityPremium());
            plantingCpEndorChgDetailDto.setTownPremium(plantingPolicyListDto.getTownPremium());
            plantingCpEndorChgDetailDto.setOtherPremium(plantingPolicyListDto.getOtherPremium());
            if("null".equals(plantingPolicyListDto.getFieldSource())){
                plantingCpEndorChgDetailDto.setFieldSource("");
            }else {
                plantingCpEndorChgDetailDto.setFieldSource(plantingPolicyListDto.getFieldSource());
            }
            plantingCpEndorChgDetailDto.setAtArea(plantingPolicyListDto.getAtArea());
            plantingCpEndorChgDetailDto.setLittleAreaName(plantingPolicyListDto.getLittleAreaName());
            plantingCpEndorChgDetailDto.setWarrant(plantingPolicyListDto.getWarrant());
            plantingCpEndorChgDetailDto.setWoodLandArea(plantingPolicyListDto.getWoodlandArea());
            plantingCpEndorChgDetailDto.setItemCode(plantingPolicyListDto.getItemCode());
            List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList = new ArrayList<PlantingCpEndorChgDetailDto>();
            plantingCpEndorChgDetailDtoList.add(plantingCpEndorChgDetailDto);
            blEndorseDto.setPlantingCpEndorChgDetailDtoList(plantingCpEndorChgDetailDtoList);
        }
    }

    /**
     * Éú³ÉÅúµ¥»º´æPlantingCpEndorChgDetailDto¶ÔÏó
     *
     * @param blPolicyDtoNew ±£µ¥´ó¶ÔÏó
     * @param blEndorseDto   Åúµ¥´ó¶ÔÏó
     * @throws Exception
     */
    private void generatePrpCPPlant31InsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto = null;
        Planting31PolicyListDto planting31PolicyListDto = null;
        if(blEndorseDto.getPlanting31CpEndorChgDetailDtoList()==null){
            List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList=new ArrayList<>();
            blEndorseDto.setPlanting31CpEndorChgDetailDtoList(planting31CpEndorChgDetailDtoList);
        }
        for (int i = 0; i < blPolicyDtoNew.getPlanting31PolicyListDtoList().size(); i++) {
            planting31PolicyListDto = blPolicyDtoNew.getPlanting31PolicyListDtoList().get(i);
            planting31CpEndorChgDetailDto = new Planting31CpEndorChgDetailDto();
            planting31CpEndorChgDetailDto.setInusreListCode(planting31PolicyListDto.getInusreListCode());
            planting31CpEndorChgDetailDto.setFCode(planting31PolicyListDto.getfCode());
            planting31CpEndorChgDetailDto.setKindCode(planting31PolicyListDto.getKindCode());
            planting31CpEndorChgDetailDto.setItemCode(planting31PolicyListDto.getItemCode());
            planting31CpEndorChgDetailDto.setIndexCode(planting31PolicyListDto.getIndexCode());
            planting31CpEndorChgDetailDto.setPhone(planting31PolicyListDto.getPhone());
            planting31CpEndorChgDetailDto.setBank(planting31PolicyListDto.getBank());
            planting31CpEndorChgDetailDto.setZhiBuKa(planting31PolicyListDto.getZhiBuKa());
            planting31CpEndorChgDetailDto.setFName(planting31PolicyListDto.getfName());
            planting31CpEndorChgDetailDto.setFIdCard(planting31PolicyListDto.getfIdCard());
            planting31CpEndorChgDetailDto.setClassCode(planting31PolicyListDto.getClassCode());
            planting31CpEndorChgDetailDto.setRiskCode(planting31PolicyListDto.getRiskCode());
            planting31CpEndorChgDetailDto.setFareaCode(planting31PolicyListDto.getfAreaCode());
            planting31CpEndorChgDetailDto.setTaxArea(planting31PolicyListDto.getTaxArea());
            planting31CpEndorChgDetailDto.setInsureArea(planting31PolicyListDto.getInsureArea());
            planting31CpEndorChgDetailDto.setAmount(planting31PolicyListDto.getAmount());
            planting31CpEndorChgDetailDto.setRate(planting31PolicyListDto.getRate());
            planting31CpEndorChgDetailDto.setShortRateFlag(planting31PolicyListDto.getShortRateFlag());
            planting31CpEndorChgDetailDto.setShortRate(planting31PolicyListDto.getShortRate());
            planting31CpEndorChgDetailDto.setSumAmount(planting31PolicyListDto.getSumAmount());
            planting31CpEndorChgDetailDto.setSumPremium(planting31PolicyListDto.getSumPremium());
            planting31CpEndorChgDetailDto.setStartDate(planting31PolicyListDto.getStartDate());
            planting31CpEndorChgDetailDto.setEndDate(planting31PolicyListDto.getEndDate());
            planting31CpEndorChgDetailDto.setCalculateFlag(planting31PolicyListDto.getCalculateFlag());
            planting31CpEndorChgDetailDto.setOpCode(planting31PolicyListDto.getOpCode());
            planting31CpEndorChgDetailDto.setValidity(planting31PolicyListDto.getValidity());
            planting31CpEndorChgDetailDto.setRemark(planting31PolicyListDto.getRemark());
            planting31CpEndorChgDetailDto.setFPremium(planting31PolicyListDto.getfPremium());
            planting31CpEndorChgDetailDto.setTeamName(planting31PolicyListDto.getTeamName());
            planting31CpEndorChgDetailDto.setCentralPremium(planting31PolicyListDto.getCentralPremium());
            planting31CpEndorChgDetailDto.setProvincePremium(planting31PolicyListDto.getProvincePremium());
            planting31CpEndorChgDetailDto.setCityPremium(planting31PolicyListDto.getCityPremium());
            planting31CpEndorChgDetailDto.setTownPremium(planting31PolicyListDto.getTownPremium());
            planting31CpEndorChgDetailDto.setOtherPremium(planting31PolicyListDto.getOtherPremium());
            planting31CpEndorChgDetailDto.setFieldSource(planting31PolicyListDto.getFieldSource());
            blEndorseDto.getPlanting31CpEndorChgDetailDtoList().add(planting31CpEndorChgDetailDto);
        }

    }
    private void generatePrpCPInsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception
    {
        int i = 0;
        HerdcEndorChgDetailDto herdcEndorChgDetailDto =null;
        HerdPolicyListDto herdPolicyListDto = null;
        if(blEndorseDto.getHerdcEndorChgDetailDtoList()==null){
            List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList=new ArrayList<>();
            blEndorseDto.setHerdcEndorChgDetailDtoList(herdcEndorChgDetailDtoList);
        }
        for(i=0;i<blPolicyDtoNew.getHerdPolicyListDtoList().size();i++)
        {
            herdPolicyListDto = blPolicyDtoNew.getHerdPolicyListDtoList().get(i);
            herdcEndorChgDetailDto = new HerdcEndorChgDetailDto();
            herdcEndorChgDetailDto.setFCode(herdPolicyListDto.getfCode());
            herdcEndorChgDetailDto.setFName(herdPolicyListDto.getfName());
            herdcEndorChgDetailDto.setFIdCard(herdPolicyListDto.getfIdCard());
            herdcEndorChgDetailDto.setBank(herdPolicyListDto.getBank());
            herdcEndorChgDetailDto.setBankCard(herdPolicyListDto.getBankCard());
            herdcEndorChgDetailDto.setBreedingAreaCode(herdPolicyListDto.getBreedingAreaCode());
            herdcEndorChgDetailDto.setBreedingAreaName(herdPolicyListDto.getBreedingAreaName());
            herdcEndorChgDetailDto.setBreedingKind(herdPolicyListDto.getBreedingKind());
            herdcEndorChgDetailDto.setEarLabel(herdPolicyListDto.getEarlAbel());
            herdcEndorChgDetailDto.setInsureNumber(herdPolicyListDto.getInsureNumber());
            herdcEndorChgDetailDto.setSumPremium(herdPolicyListDto.getSumPremium());
            herdcEndorChgDetailDto.setInsureNumber(herdPolicyListDto.getInsureNumber());
            herdcEndorChgDetailDto.setInusreListCode(herdPolicyListDto.getInusreListCode());
            herdcEndorChgDetailDto.setKindCode(herdPolicyListDto.getKindCode());
            herdcEndorChgDetailDto.setAmount(herdPolicyListDto.getAmount());
            herdcEndorChgDetailDto.setEndDate(herdPolicyListDto.getEndDate());
            herdcEndorChgDetailDto.setStartDate(herdPolicyListDto.getStartDate());
            herdcEndorChgDetailDto.setIndexCode(herdPolicyListDto.getIndexCode());
            herdcEndorChgDetailDto.setShortRateFlag(herdPolicyListDto.getShortRateFlag());
            herdcEndorChgDetailDto.setShortRate(herdPolicyListDto.getShortRate());
            herdcEndorChgDetailDto.setValidity(herdPolicyListDto.getValidity());
            herdcEndorChgDetailDto.setSumAmount(herdPolicyListDto.getSumAmount());
            herdcEndorChgDetailDto.setSumPremium(herdPolicyListDto.getSumPremium());
            herdcEndorChgDetailDto.setSpecies(herdPolicyListDto.getSpecies());
            herdcEndorChgDetailDto.setRate(herdPolicyListDto.getRate());
            herdcEndorChgDetailDto.setInsurePremium(herdPolicyListDto.getInsurePremium());
            herdcEndorChgDetailDto.setCalculateFlag(herdPolicyListDto.getCalculateFlag());
            herdcEndorChgDetailDto.setOpCode(herdPolicyListDto.getOpCode());
            herdcEndorChgDetailDto.setOpTime(herdPolicyListDto.getOpTime());
            //herdcEndorChgDetailDto.setFlag(herdPolicyListDto.getFlag());
            herdcEndorChgDetailDto.setPhone(herdPolicyListDto.getPhone());
            herdcEndorChgDetailDto.setCentralPremium(herdPolicyListDto.getCentralPremium());
            herdcEndorChgDetailDto.setProvincePremium(herdPolicyListDto.getProvincePremium());
            herdcEndorChgDetailDto.setCityPremium(herdPolicyListDto.getCityPremium());
            herdcEndorChgDetailDto.setTownPremium(herdPolicyListDto.getTownPremium());
            herdcEndorChgDetailDto.setOtherPremium(herdPolicyListDto.getOtherPremium());
            herdcEndorChgDetailDto.setAreaNumber(herdPolicyListDto.getAreaNumber());
            herdcEndorChgDetailDto.setLitterArea(herdPolicyListDto.getLitterArea());
            herdcEndorChgDetailDto.setAnimalAge(herdPolicyListDto.getAniMalage());
            herdcEndorChgDetailDto.setItemCode(herdPolicyListDto.getItemCode());
            blEndorseDto.getHerdcEndorChgDetailDtoList().add(herdcEndorChgDetailDto);
        }
    }
    private void generatePrpCPNyxInsureList(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception
    {
        int i = 0;
        NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto =null;
        NyxPolicyListDto nyxPolicyListDto = null;
        if(blEndorseDto.getNyxCpEndorChgDetailDtoList()==null){
            List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList=new ArrayList<>();
            blEndorseDto.setNyxCpEndorChgDetailDtoList(nyxCpEndorChgDetailDtoList);
        }
        for(i=0;i<blPolicyDtoNew.getNyxPolicyListDtoList().size();i++)
        {
            nyxPolicyListDto = blPolicyDtoNew.getNyxPolicyListDtoList().get(i);
            nyxCpEndorChgDetailDto = new NyxCpEndorChgDetailDto();
            nyxCpEndorChgDetailDto.setInusreListCode(nyxPolicyListDto.getInusreListCode());
            nyxCpEndorChgDetailDto.setBusinessNo(nyxPolicyListDto.getBusinessNo());
            nyxCpEndorChgDetailDto.setKindCode(nyxPolicyListDto.getKindCode());
            nyxCpEndorChgDetailDto.setItemCode(nyxPolicyListDto.getItemCode());
            nyxCpEndorChgDetailDto.setIndexcode(nyxPolicyListDto.getIndexCode());
            nyxCpEndorChgDetailDto.setfCode(nyxPolicyListDto.getfCode());
            nyxCpEndorChgDetailDto.setfName(nyxPolicyListDto.getfName());
            nyxCpEndorChgDetailDto.setZhiBuKa(nyxPolicyListDto.getZhiBuKa());
            nyxCpEndorChgDetailDto.setPhone(nyxPolicyListDto.getPhone());
            nyxCpEndorChgDetailDto.setBank(nyxPolicyListDto.getBank());
            nyxCpEndorChgDetailDto.setBankCard(nyxPolicyListDto.getBankCard());
            nyxCpEndorChgDetailDto.setInsureNumber(nyxPolicyListDto.getInsureNumber());
            nyxCpEndorChgDetailDto.setBreedingAreaCode(nyxPolicyListDto.getBreedingAreaCode());
            nyxCpEndorChgDetailDto.setSpecies(nyxPolicyListDto.getSpecies());
            nyxCpEndorChgDetailDto.setBreedingKind(nyxPolicyListDto.getBreedingKind());
            nyxCpEndorChgDetailDto.setBreedingNumber(nyxPolicyListDto.getBreedingNumber());
            nyxCpEndorChgDetailDto.setBreedingAreaName(nyxPolicyListDto.getBreedingAreaName());
            nyxCpEndorChgDetailDto.setSettleNumber(nyxPolicyListDto.getSettleNumber());

            nyxCpEndorChgDetailDto.setClassCode(nyxPolicyListDto.getClassCode());
            nyxCpEndorChgDetailDto.setRiskCode(nyxPolicyListDto.getRiskCode());
            nyxCpEndorChgDetailDto.setFareaCode(nyxPolicyListDto.getfAreaCode());
            nyxCpEndorChgDetailDto.setTaxArea(nyxPolicyListDto.getTaxArea());
            nyxCpEndorChgDetailDto.setInsureArea(nyxPolicyListDto.getInsureArea());
            nyxCpEndorChgDetailDto.setAmount(nyxPolicyListDto.getAmount());

            nyxCpEndorChgDetailDto.setRate(nyxPolicyListDto.getRate());
            nyxCpEndorChgDetailDto.setShortRateFlag(nyxPolicyListDto.getShortRateFlag());
            nyxCpEndorChgDetailDto.setShortRate(nyxPolicyListDto.getShortRate());
            nyxCpEndorChgDetailDto.setSumAmount(nyxPolicyListDto.getSumAmount());
            nyxCpEndorChgDetailDto.setSumPremium(nyxPolicyListDto.getSumPremium());
            //iPlanting31PolicyListDto.setOpTime(iPlanting31InsuranceListDto.getOpTime());
            nyxCpEndorChgDetailDto.setStartDate(nyxPolicyListDto.getStartDate());
            nyxCpEndorChgDetailDto.setEndDate(nyxPolicyListDto.getEndDate());

            nyxCpEndorChgDetailDto.setStartTime(nyxPolicyListDto.getStartTime());
            nyxCpEndorChgDetailDto.setEndTime(nyxPolicyListDto.getEndTime());
            nyxCpEndorChgDetailDto.setCalculateFlag(nyxPolicyListDto.getCalculateFlag());
            nyxCpEndorChgDetailDto.setOpCode(nyxPolicyListDto.getOpCode());
            nyxCpEndorChgDetailDto.setValidity(nyxPolicyListDto.getValidity());
            nyxCpEndorChgDetailDto.setRemark(nyxPolicyListDto.getRemark());

            nyxCpEndorChgDetailDto.setfPremium(nyxPolicyListDto.getfPremium());
            nyxCpEndorChgDetailDto.setTeamName(nyxPolicyListDto.getTeamName());
            nyxCpEndorChgDetailDto.setCentralPremium(nyxPolicyListDto.getCentralPremium());
            nyxCpEndorChgDetailDto.setProvincePremium(nyxPolicyListDto.getProvincePremium());
            nyxCpEndorChgDetailDto.setCityPremium(nyxPolicyListDto.getCityPremium());
            nyxCpEndorChgDetailDto.setTownPremium(nyxPolicyListDto.getTownPremium());
            nyxCpEndorChgDetailDto.setOtherPremium(nyxPolicyListDto.getOtherPremium());
            nyxCpEndorChgDetailDto.setAreaNumber(nyxPolicyListDto.getAreaNumber());
            nyxCpEndorChgDetailDto.setFieldSource(nyxPolicyListDto.getFieldSource());
            nyxCpEndorChgDetailDto.setLitterArea(nyxPolicyListDto.getLitterArea());
            nyxCpEndorChgDetailDto.setAtArea(nyxPolicyListDto.getAtArea());
            nyxCpEndorChgDetailDto.setMulchDate(nyxPolicyListDto.getMulchDate());
            nyxCpEndorChgDetailDto.setMulchType(nyxPolicyListDto.getMulchType());
            nyxCpEndorChgDetailDto.setWarrant(nyxPolicyListDto.getWarrant());
            nyxCpEndorChgDetailDto.setTemp1(nyxPolicyListDto.getTemp1());
            nyxCpEndorChgDetailDto.setTemp2(nyxPolicyListDto.getTemp2());
            nyxCpEndorChgDetailDto.setTemp3(nyxPolicyListDto.getTemp3());
            nyxCpEndorChgDetailDto.setTemp4(nyxPolicyListDto.getTemp4());
            nyxCpEndorChgDetailDto.setTemp5(nyxPolicyListDto.getTemp5());
            nyxCpEndorChgDetailDto.setfIdCard(nyxPolicyListDto.getfIdCard());
            blEndorseDto.getNyxCpEndorChgDetailDtoList().add(nyxCpEndorChgDetailDto);
        }
    }
}
