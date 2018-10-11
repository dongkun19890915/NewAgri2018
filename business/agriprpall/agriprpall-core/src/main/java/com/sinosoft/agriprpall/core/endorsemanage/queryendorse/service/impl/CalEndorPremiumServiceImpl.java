package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumResponseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePEndorseService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl.GenerateCEndorseServiceImpl;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CalEndorPremiumService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCManFieldListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsurePreliminaryConfirmApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.utility.string.Str;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 批单保费计算相关服务
 * @Author: ldd
 * @Date: 2017/12/7 14:26
 */
@Service
public class CalEndorPremiumServiceImpl implements CalEndorPremiumService {

    @Autowired
    InsureMainListApi insureMainListApi;
    @Autowired
    private InsurePreliminaryConfirmApi insurePreliminaryConfirmApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private GeneratePEndorseService generatePEndorseService;

    /**
     * 清单存储在planting的险种
     */
    //  @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRisk;
    /**
     * 清单存储在planting31的险种
     */
    //   @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Risk;
    /**
     * 清单存储在nyx的险种
     */
    // @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRisk;
    /**
     * 清单存储在herd的险种
     */
    //  @Value("${sysconfig.insureListRsk.herd}")
    private String herdRisk;
    /**
     * 草莓组合险种
     */
    private String riskCode3129 = "3129";

    public void inint() {
        this.plantingRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Risk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        ;
        this.nyxRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        ;
        this.herdRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
        ;
    }
    /**
     * 普通批改初始界面点击下一步时分户批改保单计算
     * @param policyEndorseDto 前台收集到的保批单dto信息
     * @return
     * @throws Exception
     */
    @Override
    public void CalEndor93PremByNext(PolicyEndorseDto policyEndorseDto,Date validDate) throws Exception{
        //分户清单是否变化
        boolean endor93Type = false;
        //保单号
        String policyNo = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().getPolicyNo();
        String strRiskCode=policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().getRiskCode();
        //批改后的citemkind
        List<PrpCitemKindDto> prpCitemKindDtoListNew = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCitemKindDtoList();
        List<PrpCsubsidyDto> prpCsubsidyDtoListNew = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCsubsidyDtoList();
        Double centralRate = 0.00;//中央补贴比例
        Double provinceRate = 0.00;//升级补贴比例
        Double cityRate = 0.00;//地市补贴比例
        Double townRate = 0.00;//县级补贴比例
        Double otherRate = 0.00;//其他补贴比例
        for(PrpCsubsidyDto prpCsubsidyDtoNew : prpCsubsidyDtoListNew){
            if("03".equals(prpCsubsidyDtoNew.getSubsidyCode())){
                centralRate = prpCsubsidyDtoNew.getSubsidyRate();
            }else if("04".equals(prpCsubsidyDtoNew.getSubsidyCode())){
                provinceRate = prpCsubsidyDtoNew.getSubsidyRate();
            }else if("05".equals(prpCsubsidyDtoNew.getSubsidyCode())){
                cityRate = prpCsubsidyDtoNew.getSubsidyRate();
            }else if("07".equals(prpCsubsidyDtoNew.getSubsidyCode())){
                townRate = prpCsubsidyDtoNew.getSubsidyRate();
            }else{
                otherRate = otherRate+prpCsubsidyDtoNew.getSubsidyRate();
            }
        }
        Double fRate = 100 - centralRate-provinceRate-cityRate-townRate-otherRate;//自缴比例


        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();

        //获取批改后核心清单信息
        List<PlantingPolicyListDto> plantingPolicyListDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPlantingPolicyListDtoList();
        List<NyxPolicyListDto> nyxPolicyListDtos=policyEndorseDto.getBlPolicyInfoDtoNew().getNyxPolicyListDtoList();
        List<HerdPolicyListDto> herdPolicyListDtos=policyEndorseDto.getBlPolicyInfoDtoNew().getHerdPolicyListDtoList();
        List<Planting31PolicyListDto> planting31PolicyListDtoList=policyEndorseDto.getBlPolicyInfoDtoNew().getPlanting31PolicyListDtoList();
        List<CMCManFieldListDto> cmcManFieldListDtos=policyEndorseDto.getBlPolicyInfoDtoNew().getCmcManFieldListDtoList();
        HashMap plantingPolicyMap = new HashMap();
        for(int i=0;i<plantingPolicyListDtoList.size();i++) {
            if(!plantingPolicyMap.containsKey(plantingPolicyListDtoList.get(i).getfCode())) {
                plantingPolicyMap.put(plantingPolicyListDtoList.get(i).getfCode(), plantingPolicyListDtoList.get(i));
            }
        }
        Map<String,NyxPolicyListDto> nyxPolicyListDtoMap=new HashMap<>();
        if(nyxPolicyListDtos!=null){
            for(NyxPolicyListDto nyxPolicyListDto:nyxPolicyListDtos){
                if(!nyxPolicyListDtoMap.containsKey(nyxPolicyListDto.getfCode())){
                    nyxPolicyListDtoMap.put(nyxPolicyListDto.getfCode(),nyxPolicyListDto);
                }
            }
        }
        Map<String,Planting31PolicyListDto> planting31PolicyListDtoMap=new HashMap<>();
        if(planting31PolicyListDtoList!=null){
            for(Planting31PolicyListDto planting31PolicyListDto:planting31PolicyListDtoList){
                if(!planting31PolicyListDtoMap.containsKey(planting31PolicyListDto.getfCode())){
                    planting31PolicyListDtoMap.put(planting31PolicyListDto.getfCode(),planting31PolicyListDto);
                }
            }
        }
        Map<String,HerdPolicyListDto> herdPolicyListDtoMap=new HashMap<>();
        if(herdPolicyListDtos!=null){
            for(HerdPolicyListDto herdPolicyListDto:herdPolicyListDtos){
                if(!herdPolicyListDtoMap.containsKey(herdPolicyListDto.getfCode()+herdPolicyListDto.getEarlAbel())){
                    herdPolicyListDtoMap.put(herdPolicyListDto.getfCode()+herdPolicyListDto.getEarlAbel(),herdPolicyListDto);
                }
            }
        }
        Map<String,CMCManFieldListDto> cmcManFieldListDtoMap=new HashMap<>();
        if(cmcManFieldListDtos!=null){
            for(CMCManFieldListDto cmcManFieldListDto:cmcManFieldListDtos){
                if(!cmcManFieldListDtoMap.containsKey(cmcManFieldListDto.getfCode())){
                    cmcManFieldListDtoMap.put(cmcManFieldListDto.getfCode(),cmcManFieldListDto);
                }
            }
        }

        //获取金禾清单表最新信息
        //通过保单号查询清单主表
        InsureMainListDto insureMainListDto = insureMainListApi.queryByPolicyNo(policyNo).get(0);

        Map<String,String> map=new HashMap<>();
        map.put("insureListCode",insureMainListDto.getGisInsureListCode());
        //查询GIS清单最新信息
        InsurePreliminaryConfirmDto insurePreliminaryConfirmDto = insurePreliminaryConfirmApi.queryInsurePreliminarydConfirm(map);

        //根据核心清单记录的SERIALNO与金禾清单SERIALNO比对，判断清单是否有变化
        endor93Type = insureMainListDto.getSerialNo().equals(insurePreliminaryConfirmDto.getGisInsureMainListDto().getSerialNo());

        List<GisFarmerListDto> gisFarmerListDtoNewList = insurePreliminaryConfirmDto.getGisFarmerListDtos();
        List<GisFarmerItemDto> gisFarmerItemDtoList=insurePreliminaryConfirmDto.getGisFarmerItemDtoList();
        List<GisHerdFieldListDto> gisHerdFieldListDtos=insurePreliminaryConfirmDto.getGisHerdFieldListDtos();
        GisInsureMainListDto gisInsureMainListDto=insurePreliminaryConfirmDto.getGisInsureMainListDto();
        Map<String,GisFarmerListDto> gisFarmerListDtoMap=new HashMap<>();
        if(gisFarmerListDtoNewList!=null){
            for(GisFarmerListDto gisFarmerListDto:gisFarmerListDtoNewList){
                if(!gisFarmerListDtoMap.containsKey(gisFarmerListDto.getfCode())){
                    gisFarmerListDtoMap.put(gisFarmerListDto.getfCode(),gisFarmerListDto);
                }
            }
        }
        Map<String ,GisHerdFieldListDto> gisHerdFieldListDtoMap=new HashMap<>();
        if(gisHerdFieldListDtos!=null){
            for(GisHerdFieldListDto gisHerdFieldListDto:gisHerdFieldListDtos){
                if(!gisHerdFieldListDtoMap.containsKey(gisHerdFieldListDto.getfCode()+gisHerdFieldListDto.getEarLabel())){
                    gisHerdFieldListDtoMap.put(gisHerdFieldListDto.getfCode()+gisHerdFieldListDto.getEarLabel(),gisHerdFieldListDto);
                }
            }
        }
        Map<String,GisFarmerItemDto> gisFarmerItemDtoMap=new HashMap<>();
        if(gisFarmerItemDtoList!=null){
            for(GisFarmerItemDto gisFarmerItemDto:gisFarmerItemDtoList){
                if(!gisFarmerItemDtoMap.containsKey(gisFarmerItemDto.getfCode())){
                    gisFarmerItemDtoMap.put(gisFarmerItemDto.getfCode(),gisFarmerItemDto);
                }
            }
        }
        List<GisManFieldListDto> gisManFieldListDtos = null;
        if ("3129".equals(strRiskCode)) {
            gisManFieldListDtos = insurePreliminaryConfirmDto.getGisManFieldListDtoList();
        }
        Map<String,GisManFieldListDto> gisManFieldListDtoMap=new HashMap<>();
        if(gisManFieldListDtos!=null){
            for(GisManFieldListDto gisManFieldListDto:gisManFieldListDtos){
                if(!gisManFieldListDtoMap.containsKey(gisManFieldListDto.getfCode())){
                    gisManFieldListDtoMap.put(gisManFieldListDto.getfCode(),gisManFieldListDto);
                }
            }
        }
        HashMap gisNyxNewMap = new HashMap();
        //PlantingPolicyList表的排序序号
        Integer indexCode = 1;
        String plantingFarmerListFlag = utiPlatConfigRuleApi.queryByPK("prpall", "PLNATING_FARMER_LIST_FLAG", 1).getRule();

        if(!endor93Type) {
            if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
                for (int i = 0; i < gisFarmerItemDtoList.size(); i++) {
                    GisFarmerItemDto gisFarmerItemDto = gisFarmerItemDtoList.get(i);
                    if(!gisFarmerItemDtoMap.containsKey(gisFarmerItemDto.getfCode())){
                        gisFarmerItemDtoMap.put(gisFarmerItemDto.getfCode(),gisFarmerItemDto);
                    }
                    GisFarmerListDto gisFarmerListDto = gisFarmerListDtoMap.get(gisFarmerItemDto.getfCode());
                    //新增的农户信息
                    if (!plantingPolicyMap.containsKey(gisFarmerItemDto.getfCode())&&gisFarmerListDto!=null) {
                        endor93Type = true;
                        //将新增的农户信息加入plantingPolicyListDtoList &处理citemkindDto里承保面积信息
                        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtoListNew) {
                            PlantingPolicyListDto plantingPolicyList1 = new PlantingPolicyListDto();
                            plantingPolicyList1.setInusreListCode(plantingPolicyListDtoList.get(0).getInusreListCode());
                            plantingPolicyList1.setfCode(gisFarmerItemDto.getfCode());//GIS
                            plantingPolicyList1.setKindCode(prpCitemKindDto.getKindCode());
                            plantingPolicyList1.setPhone(gisFarmerListDto.getfPhone());//GIS
                            plantingPolicyList1.setBank(gisFarmerListDto.getBankName());//GIS
                            plantingPolicyList1.setZhiBuKa(gisFarmerListDto.getBankCode());//GIS
                            plantingPolicyList1.setfName(gisFarmerItemDto.getfName());//GIS
                            plantingPolicyList1.setfIdCard(gisFarmerItemDto.getfIdCard());//GIS
                            plantingPolicyList1.setClassCode(plantingPolicyListDtoList.get(0).getClassCode());
                            plantingPolicyList1.setRiskCode(plantingPolicyListDtoList.get(0).getRiskCode());
                            plantingPolicyList1.setfAreaCode(plantingPolicyListDtoList.get(0).getfAreaCode());
                            plantingPolicyList1.setTaxArea(plantingPolicyListDtoList.get(0).getTaxArea());
                            plantingPolicyList1.setInsureArea(gisFarmerItemDto.getInsureCount());//GIS
                            plantingPolicyList1.setAmount(plantingPolicyListDtoList.get(0).getAmount());
                            plantingPolicyList1.setRate(plantingPolicyListDtoList.get(0).getRate());
                            plantingPolicyList1.setShortRateFlag(plantingPolicyListDtoList.get(0).getShortRateFlag());
                            plantingPolicyList1.setShortRate(plantingPolicyListDtoList.get(0).getShortRate());
                            plantingPolicyList1.setStartDate(plantingPolicyListDtoList.get(0).getStartDate());
                            plantingPolicyList1.setEndDate(plantingPolicyListDtoList.get(0).getEndDate());
                            plantingPolicyList1.setCalculateFlag(plantingPolicyListDtoList.get(0).getCalculateFlag());
                            plantingPolicyList1.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            plantingPolicyList1.setOpTime(plantingPolicyListDtoList.get(0).getOpTime());
                            plantingPolicyList1.setValidity("1");
                            plantingPolicyList1.setFlag("I");
                            plantingPolicyList1.setTeamName(gisFarmerListDto.getTeamName());//GIS
                            plantingPolicyList1.setFieldSource(plantingPolicyListDtoList.get(0).getFieldSource());
                            plantingPolicyList1.setWarrant(plantingPolicyListDtoList.get(0).getWarrant());
                            plantingPolicyList1.setAtArea(plantingPolicyListDtoList.get(0).getAtArea());
                            plantingPolicyList1.setLittleAreaName(plantingPolicyListDtoList.get(0).getLittleAreaName());
                            plantingPolicyList1.setWoodlandArea(plantingPolicyListDtoList.get(0).getWoodlandArea());
                            plantingPolicyList1.setItemCode(gisFarmerItemDto.getItemCode());
                            //总保额，获取页面的从单位保额乘以投保面积
                            plantingPolicyList1.setSumAmount((new BigDecimal(plantingPolicyList1.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            plantingPolicyList1.setSumPremium(((new BigDecimal(plantingPolicyList1.getSumAmount()).multiply(new BigDecimal(plantingPolicyList1.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            plantingPolicyList1.setfPremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyList1.setCentralPremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyList1.setProvincePremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyList1.setCityPremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyList1.setTownPremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyList1.setOtherPremium(((new BigDecimal(plantingPolicyList1.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                plantingPolicyList1.setOtherPremium((new BigDecimal(plantingPolicyList1.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyList1.getfPremium()).add(new BigDecimal(plantingPolicyList1.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyList1.getProvincePremium())).add(new BigDecimal(plantingPolicyList1.getCityPremium()))
                                                .add(new BigDecimal(plantingPolicyList1.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                plantingPolicyList1.setTownPremium((new BigDecimal(plantingPolicyList1.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyList1.getfPremium()).add(new BigDecimal(plantingPolicyList1.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyList1.getProvincePremium())).add(new BigDecimal(plantingPolicyList1.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                plantingPolicyList1.setCityPremium((new BigDecimal(plantingPolicyList1.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyList1.getfPremium()).add(new BigDecimal(plantingPolicyList1.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyList1.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                plantingPolicyList1.setProvincePremium((new BigDecimal(plantingPolicyList1.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyList1.getfPremium()).add(new BigDecimal(plantingPolicyList1.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                plantingPolicyList1.setCentralPremium((new BigDecimal(plantingPolicyList1.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyList1.getfPremium()))).doubleValue());
                            }

                            plantingPolicyList1.setIndexCode(indexCode.toString());
                            indexCode++;

                            plantingPolicyListDtoList.add(plantingPolicyList1);
                        }

                    }
                }

                for (int i = 0; i < plantingPolicyListDtoList.size(); i++) {
                    PlantingPolicyListDto plantingPolicyListDto = plantingPolicyListDtoList.get(i);
                    if (plantingPolicyListDto.getBank() == null) {
                        plantingPolicyListDto.setBank("");
                    }
                    //判断清单是否有变化
                    if (gisFarmerItemDtoMap.containsKey(plantingPolicyListDto.getfCode())) {
                        GisFarmerListDto gisFarmerListDto = (GisFarmerListDto) gisFarmerListDtoMap.get(plantingPolicyListDto.getfCode());
                        GisFarmerItemDto gisFarmerItemDto=(GisFarmerItemDto) gisFarmerItemDtoMap.get(plantingPolicyListDto.getfCode());
                        //挨个比对字段的值
                        String plantingPolicyListInfoKey = plantingPolicyListDto.getfName() + "-" + plantingPolicyListDto.getfIdCard() + "-"
                                + plantingPolicyListDto.getPhone() + "-" + plantingPolicyListDto.getTeamName() + "-"
                                + plantingPolicyListDto.getBank() + "-" + plantingPolicyListDto.getZhiBuKa() + "-"
                                + plantingPolicyListDto.getInsureArea() + "-";

                        String gisNyxInsuranceListInfoKey = gisFarmerListDto.getfName() + "-" + gisFarmerListDto.getfIdCard() + "-"
                                + gisFarmerListDto.getfPhone() + "-" + gisFarmerListDto.getTeamName() + "-"
                                + gisFarmerListDto.getBankName() + "-" + gisFarmerListDto.getBankCode() + "-"
                                + gisFarmerItemDto.getInsureCount() + "-";

                        if (!plantingPolicyListInfoKey.equals(gisNyxInsuranceListInfoKey)&&gisFarmerItemDto!=null) {
                            endor93Type = true;
                            plantingPolicyListDto.setfName(gisFarmerItemDto.getfName());
                            plantingPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());
                            plantingPolicyListDto.setPhone(gisFarmerListDto.getfPhone());
                            plantingPolicyListDto.setTeamName(gisFarmerListDto.getTeamName());
                            plantingPolicyListDto.setBank(gisFarmerListDto.getBankName());
                            plantingPolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());
                            plantingPolicyListDto.setInsureArea(gisFarmerItemDto.getInsureCount());
                            plantingPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            //plantingPolicyListDto.setRemark(gisFarmerListDto.getRemark());
                            plantingPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            plantingPolicyListDto.setFlag("U");
                            //总保额，获取页面的从单位保额乘以投保面积
                            plantingPolicyListDto.setSumAmount((new BigDecimal(plantingPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            plantingPolicyListDto.setSumPremium(((new BigDecimal(plantingPolicyListDto.getSumAmount()).multiply(new BigDecimal(plantingPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            plantingPolicyListDto.setfPremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyListDto.setCentralPremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyListDto.setProvincePremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyListDto.setCityPremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyListDto.setTownPremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            plantingPolicyListDto.setOtherPremium(((new BigDecimal(plantingPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                plantingPolicyListDto.setOtherPremium((new BigDecimal(plantingPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyListDto.getfPremium()).add(new BigDecimal(plantingPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyListDto.getProvincePremium())).add(new BigDecimal(plantingPolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(plantingPolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                plantingPolicyListDto.setTownPremium((new BigDecimal(plantingPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyListDto.getfPremium()).add(new BigDecimal(plantingPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyListDto.getProvincePremium())).add(new BigDecimal(plantingPolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                plantingPolicyListDto.setCityPremium((new BigDecimal(plantingPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyListDto.getfPremium()).add(new BigDecimal(plantingPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(plantingPolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                plantingPolicyListDto.setProvincePremium((new BigDecimal(plantingPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyListDto.getfPremium()).add(new BigDecimal(plantingPolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                plantingPolicyListDto.setCentralPremium((new BigDecimal(plantingPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(plantingPolicyListDto.getfPremium()))).doubleValue());
                            }

                            plantingPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                        }

                    }
                }

                for (int i = 0; i < plantingPolicyListDtoList.size(); i++) {
                    PlantingPolicyListDto plantingPolicyListDto = plantingPolicyListDtoList.get(i);
                    //新的清单信息中不包含老清单农户
                    if (!gisFarmerItemDtoMap.containsKey(plantingPolicyListDto.getfCode())) {
                        endor93Type = true;
                        plantingPolicyListDto.setFlag("D");//删除
                        plantingPolicyListDto.setValidity("0");
                        plantingPolicyListDto.setEndDate(validDate);
                        plantingPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                        plantingPolicyListDto.setInsureArea(0.00);
                        plantingPolicyListDto.setIndexCode(indexCode.toString());
                        indexCode++;
                    }
                }
            }

            String nyxSingleFarmerListFlag = utiPlatConfigRuleApi.queryByPK("prpall", "NYX_SINGLE_FARMER_LIST_FLAG", 1).getRule();
            String nyxMultipleFarmerListFlag = utiPlatConfigRuleApi.queryByPK("prpall", "NYX_MULTIPLE_FARMER_LIST_FLAG", 1).getRule();
            if (nyxSingleFarmerListFlag.contains(strRiskCode) || nyxMultipleFarmerListFlag.contains(strRiskCode) || "3224".equals(strRiskCode)) {
                List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>();
                for (int i = 0; i < gisFarmerItemDtoList.size(); i++) {
                    GisFarmerItemDto gisFarmerItemDto = gisFarmerItemDtoList.get(i);
                    if(!gisFarmerItemDtoMap.containsKey(gisFarmerItemDto.getfCode())){
                        gisFarmerItemDtoMap.put(gisFarmerItemDto.getfCode(),gisFarmerItemDto);
                    }
                    GisFarmerListDto gisFarmerListDto = gisFarmerListDtoMap.get(gisFarmerItemDto.getfCode());
                    //新增的农户信息
                    if (!plantingPolicyMap.containsKey(gisFarmerItemDto.getfCode())&&gisFarmerListDto!=null) {
                        endor93Type = true;
                        //将新增的农户信息加入plantingPolicyListDtoList &处理citemkindDto里承保面积信息
                        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtoListNew) {
                            NyxPolicyListDto nyxPolicyListDto = new NyxPolicyListDto();
                            nyxPolicyListDto.setInusreListCode(nyxPolicyListDtos.get(0).getInusreListCode());
                            nyxPolicyListDto.setfCode(gisFarmerItemDto.getfCode());//GIS
                            nyxPolicyListDto.setKindCode(prpCitemKindDto.getKindCode());
                            nyxPolicyListDto.setPhone(gisFarmerListDto.getfPhone());//GIS
                            nyxPolicyListDto.setBank(gisFarmerListDto.getBankName());//GIS
                            nyxPolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());//GIS
                            nyxPolicyListDto.setfName(gisFarmerItemDto.getfName());//GIS
                            nyxPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());//GIS
                            nyxPolicyListDto.setClassCode(nyxPolicyListDtos.get(0).getClassCode());
                            nyxPolicyListDto.setRiskCode(nyxPolicyListDtos.get(0).getRiskCode());
                            nyxPolicyListDto.setfAreaCode(nyxPolicyListDtos.get(0).getfAreaCode());
                            nyxPolicyListDto.setTaxArea(nyxPolicyListDtos.get(0).getTaxArea());
                            nyxPolicyListDto.setInsureArea(gisFarmerItemDto.getInsureCount());//GIS
                            nyxPolicyListDto.setAmount(nyxPolicyListDtos.get(0).getAmount());
                            nyxPolicyListDto.setRate(nyxPolicyListDtos.get(0).getRate());
                            nyxPolicyListDto.setShortRateFlag(nyxPolicyListDtos.get(0).getShortRateFlag());
                            nyxPolicyListDto.setShortRate(nyxPolicyListDtos.get(0).getShortRate());
                            nyxPolicyListDto.setStartDate(nyxPolicyListDtos.get(0).getStartDate());
                            nyxPolicyListDto.setEndDate(nyxPolicyListDtos.get(0).getEndDate());
                            nyxPolicyListDto.setCalculateFlag(nyxPolicyListDtos.get(0).getCalculateFlag());
                            nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            nyxPolicyListDto.setOpTime(nyxPolicyListDtos.get(0).getOpTime());
                            nyxPolicyListDto.setValidity("1");
                            nyxPolicyListDto.setFlag("I");
                            //nyxPolicyListDto.setRemark(gisFarmerListDto.getRemark());//GIS
                            nyxPolicyListDto.setTeamName(gisFarmerListDto.getTeamName());//GIS
                            nyxPolicyListDto.setFieldSource(nyxPolicyListDtos.get(0).getFieldSource());
                            nyxPolicyListDto.setWarrant(nyxPolicyListDtos.get(0).getWarrant());
                            nyxPolicyListDto.setAtArea(nyxPolicyListDtos.get(0).getAtArea());
                            nyxPolicyListDto.setLitterArea(nyxPolicyListDtos.get(0).getLitterArea());
                            nyxPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            //总保额，获取页面的从单位保额乘以投保面积
                            nyxPolicyListDto.setSumAmount((new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                            }

                            nyxPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;

                            nyxPolicyListDtoList.add(nyxPolicyListDto);
                        }

                    }

                }

                for (int i = 0; i < nyxPolicyListDtos.size(); i++) {
                    NyxPolicyListDto nyxPolicyListDto = nyxPolicyListDtos.get(i);
                    if (nyxPolicyListDto.getBank() == null) {
                        nyxPolicyListDto.setBank("");
                    }
                    //判断清单是否有变化
                    if (gisFarmerItemDtoMap.containsKey(nyxPolicyListDto.getfCode())) {
                        GisFarmerListDto gisFarmerListDto =gisFarmerListDtoMap.get(nyxPolicyListDto.getfCode());
                        GisFarmerItemDto gisFarmerItemDto=gisFarmerItemDtoMap.get(nyxPolicyListDto.getfCode());
                        //挨个比对字段的值
                        String plantingPolicyListInfoKey = nyxPolicyListDto.getfName() + "-" + nyxPolicyListDto.getfIdCard() + "-"
                                + nyxPolicyListDto.getPhone() + "-" + nyxPolicyListDto.getTeamName() + "-"
                                + nyxPolicyListDto.getBank() + "-" + nyxPolicyListDto.getZhiBuKa() + "-"
                                + nyxPolicyListDto.getInsureArea() + "-";

                        String gisNyxInsuranceListInfoKey = gisFarmerListDto.getfName() + "-" + gisFarmerListDto.getfIdCard() + "-"
                                + gisFarmerListDto.getfPhone() + "-" + gisFarmerListDto.getTeamName() + "-"
                                + gisFarmerListDto.getBankName() + "-" + gisFarmerListDto.getBankCode() + "-"
                                + gisFarmerItemDto.getInsureCount() + "-";

                        if (!plantingPolicyListInfoKey.equals(gisNyxInsuranceListInfoKey)&&gisFarmerItemDto!=null) {
                            endor93Type = true;
                            nyxPolicyListDto.setfName(gisFarmerItemDto.getfName());
                            nyxPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());
                            nyxPolicyListDto.setPhone(gisFarmerListDto.getfPhone());
                            nyxPolicyListDto.setTeamName(gisFarmerListDto.getTeamName());
                            nyxPolicyListDto.setBank(gisFarmerListDto.getBankName());
                            nyxPolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());
                            nyxPolicyListDto.setInsureArea(gisFarmerItemDto.getInsureCount());
                            nyxPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            //nyxPolicyListDto.setRemark(gisFarmerListDto.getRemark());
                            nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            nyxPolicyListDto.setFlag("U");
                            //总保额，获取页面的从单位保额乘以投保面积
                            nyxPolicyListDto.setSumAmount((new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                            }

                            nyxPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                        }

                    }
                }

                for (int i = 0; i < nyxPolicyListDtos.size(); i++) {
                    NyxPolicyListDto nyxPolicyListDto = nyxPolicyListDtos.get(i);
                    //新的清单信息中不包含老清单农户
                    if (!gisFarmerItemDtoMap.containsKey(nyxPolicyListDto.getfCode())) {
                        endor93Type = true;
                        nyxPolicyListDto.setFlag("D");//删除
                        nyxPolicyListDto.setValidity("0");
                        nyxPolicyListDto.setEndDate(validDate);
                        nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                        nyxPolicyListDto.setInsureArea(0.00);
                        nyxPolicyListDto.setIndexCode(indexCode.toString());
                        indexCode++;
                    }
                }

            }
            String breedingFarmerListFlag = utiPlatConfigRuleApi.getProperty("BREEDING_FARMER_LIST_FLAG");
            if (strRiskCode!=null&&breedingFarmerListFlag!=null&&breedingFarmerListFlag.contains(strRiskCode)) {
                List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
                for (int i = 0; i < gisHerdFieldListDtos.size(); i++) {
                    GisHerdFieldListDto gisHerdFieldListDto=gisHerdFieldListDtos.get(i);
                    GisFarmerItemDto gisFarmerItemDto = gisFarmerItemDtoMap.get(gisHerdFieldListDto.getfCode());
                    GisFarmerListDto gisFarmerListDto = gisFarmerListDtoMap.get(gisFarmerItemDto.getfCode());
                    HerdPolicyListDto herdPolicyListDto1=herdPolicyListDtoMap.get(gisHerdFieldListDto.getfCode()+gisHerdFieldListDto.getEarLabel());
                    //新增的农户或者新增耳标号信息
                    if (!herdPolicyListDtoMap.containsKey(gisFarmerItemDto.getfCode()+gisHerdFieldListDto.getEarLabel())) {
                        endor93Type = true;
                        //将新增的农户信息加入plantingPolicyListDtoList &处理citemkindDto里承保面积信息
                        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtoListNew) {
                            HerdPolicyListDto herdPolicyListDto = new HerdPolicyListDto();
                            herdPolicyListDto.setInusreListCode(herdPolicyListDtos.get(0).getInusreListCode());
                            herdPolicyListDto.setfCode(gisFarmerItemDto.getfCode());//GIS
                            herdPolicyListDto.setKindCode(prpCitemKindDto.getKindCode());
                            herdPolicyListDto.setPhone(gisFarmerListDto.getfPhone());//GIS
                            herdPolicyListDto.setBank(gisFarmerListDto.getBankName());//GIS
                            herdPolicyListDto.setBankCard(gisFarmerListDto.getBankCode());//GIS
                            herdPolicyListDto.setfName(gisFarmerItemDto.getfName());//GIS
                            herdPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());//GIS
                            herdPolicyListDto.setBreedingAreaCode(gisHerdFieldListDto.getBreedingAreaCode());
                            herdPolicyListDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(gisFarmerItemDto.getInsureCount())));//GIS
                            herdPolicyListDto.setAmount(herdPolicyListDtos.get(0).getAmount());
                            herdPolicyListDto.setRate(herdPolicyListDtos.get(0).getRate());
                            herdPolicyListDto.setShortRateFlag(herdPolicyListDtos.get(0).getShortRateFlag());
                            herdPolicyListDto.setShortRate(herdPolicyListDtos.get(0).getShortRate());
                            herdPolicyListDto.setStartDate(herdPolicyListDtos.get(0).getStartDate());
                            herdPolicyListDto.setEndDate(herdPolicyListDtos.get(0).getEndDate());
                            herdPolicyListDto.setCalculateFlag(herdPolicyListDtos.get(0).getCalculateFlag());
                            herdPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            herdPolicyListDto.setOpTime(herdPolicyListDtos.get(0).getOpTime());
                            herdPolicyListDto.setValidity("1");
                            herdPolicyListDto.setFlag("I");
                            herdPolicyListDto.setRemark(gisInsureMainListDto.getRemark());//GIS
                            herdPolicyListDto.setSpecies(gisHerdFieldListDto.getSpecies());
                            herdPolicyListDto.setBreedingKind(herdPolicyListDto1.getBreedingKind());
                            herdPolicyListDto.setBreedingNumber(herdPolicyListDto1.getBreedingNumber());
                            herdPolicyListDto.setBreedingAreaName(gisHerdFieldListDto.getBreedingAreaName());
                            herdPolicyListDto.setStartTime(herdPolicyListDto1.getStartTime());
                            herdPolicyListDto.setEndTime(herdPolicyListDto1.getEndTime());
                            herdPolicyListDto.setSettleNumber(herdPolicyListDto1.getSettleNumber());
                            herdPolicyListDto.setAreaNumber(herdPolicyListDto1.getAreaNumber());
                            herdPolicyListDto.setAniMalage(gisHerdFieldListDto.getAnimalAge());
                            herdPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            herdPolicyListDto.setLitterArea(herdPolicyListDtos.get(0).getLitterArea());

                            //总保额，获取页面的从单位保额乘以投保面积
                            herdPolicyListDto.setSumAmount((new BigDecimal(herdPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            herdPolicyListDto.setSumPremium(((new BigDecimal(herdPolicyListDto.getSumAmount()).multiply(new BigDecimal(herdPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            herdPolicyListDto.setInsurePremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setCentralPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setProvincePremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setCityPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setTownPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setOtherPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                herdPolicyListDto.setOtherPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())).add(new BigDecimal(herdPolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                herdPolicyListDto.setTownPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())).add(new BigDecimal(herdPolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                herdPolicyListDto.setCityPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                herdPolicyListDto.setProvincePremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                herdPolicyListDto.setCentralPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()))).doubleValue());
                            }

                            herdPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;

                            herdPolicyListDtoList.add(herdPolicyListDto);
                        }

                    }

                }

                for (int i = 0; i < herdPolicyListDtoList.size(); i++) {
                    HerdPolicyListDto herdPolicyListDto = herdPolicyListDtoList.get(i);
                    if (herdPolicyListDto.getBank() == null) {
                        herdPolicyListDto.setBank("");
                    }
                    //判断清单是否有变化
                    if (gisFarmerItemDtoMap.containsKey(herdPolicyListDto.getfCode())) {
                        GisFarmerListDto gisFarmerListDto =gisFarmerListDtoMap.get(herdPolicyListDto.getfCode());
                        GisFarmerItemDto gisFarmerItemDto=gisFarmerItemDtoMap.get(herdPolicyListDto.getfCode());
                        GisHerdFieldListDto gisHerdFieldListDto=gisHerdFieldListDtoMap.get(herdPolicyListDto.getfCode()+herdPolicyListDto.getEarlAbel());
                        HerdPolicyListDto herdPolicyListDto1=herdPolicyListDtoMap.get(gisHerdFieldListDto.getfCode()+gisHerdFieldListDto.getEarLabel());
                        //挨个比对字段的值
                        String herdPolicyListInfoKey = herdPolicyListDto.getfName() + "-" + herdPolicyListDto.getfIdCard() + "-"
                                + herdPolicyListDto.getPhone() + "-" +herdPolicyListDto.getEarlAbel()+"-"
                                + herdPolicyListDto.getBank() + "-" + herdPolicyListDto.getBankCard() + "-"
                                + herdPolicyListDto.getInsureNumber() + "-";

                        String gisNyxInsuranceListInfoKey = gisFarmerListDto.getfName() + "-" + gisFarmerListDto.getfIdCard() + "-"
                                + gisFarmerListDto.getfPhone() + "-" +gisHerdFieldListDto.getEarLabel()+"-"
                                + gisFarmerListDto.getBankName() + "-" + gisFarmerListDto.getBankCode() + "-"
                                + gisFarmerItemDto.getInsureCount() + "-";

                        if (!herdPolicyListInfoKey.equals(gisNyxInsuranceListInfoKey)&&gisFarmerItemDto!=null) {
                            endor93Type = true;
                            herdPolicyListDto.setInusreListCode(herdPolicyListDtos.get(0).getInusreListCode());
                            herdPolicyListDto.setfCode(gisFarmerItemDto.getfCode());//GIS
                            herdPolicyListDto.setPhone(gisFarmerListDto.getfPhone());//GIS
                            herdPolicyListDto.setBank(gisFarmerListDto.getBankName());//GIS
                            herdPolicyListDto.setBankCard(gisFarmerListDto.getBankCode());//GIS
                            herdPolicyListDto.setfName(gisFarmerItemDto.getfName());//GIS
                            herdPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());//GIS
                            herdPolicyListDto.setBreedingAreaCode(gisHerdFieldListDto.getBreedingAreaCode());
                            herdPolicyListDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(gisFarmerItemDto.getInsureCount())));//GIS
                            herdPolicyListDto.setAmount(herdPolicyListDtos.get(0).getAmount());
                            herdPolicyListDto.setRate(herdPolicyListDtos.get(0).getRate());
                            herdPolicyListDto.setShortRateFlag(herdPolicyListDtos.get(0).getShortRateFlag());
                            herdPolicyListDto.setShortRate(herdPolicyListDtos.get(0).getShortRate());
                            herdPolicyListDto.setStartDate(herdPolicyListDtos.get(0).getStartDate());
                            herdPolicyListDto.setEndDate(herdPolicyListDtos.get(0).getEndDate());
                            herdPolicyListDto.setCalculateFlag(herdPolicyListDtos.get(0).getCalculateFlag());
                            herdPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            herdPolicyListDto.setOpTime(herdPolicyListDtos.get(0).getOpTime());
                            herdPolicyListDto.setValidity("1");
                            herdPolicyListDto.setFlag("U");
                            herdPolicyListDto.setRemark(gisInsureMainListDto.getRemark());//GIS
                            herdPolicyListDto.setSpecies(gisHerdFieldListDto.getSpecies());
                            herdPolicyListDto.setBreedingKind(herdPolicyListDto1.getBreedingKind());
                            herdPolicyListDto.setBreedingNumber(herdPolicyListDto1.getBreedingNumber());
                            herdPolicyListDto.setBreedingAreaName(gisHerdFieldListDto.getBreedingAreaName());
                            herdPolicyListDto.setStartTime(herdPolicyListDto1.getStartTime());
                            herdPolicyListDto.setEndTime(herdPolicyListDto1.getEndTime());
                            herdPolicyListDto.setSettleNumber(herdPolicyListDto1.getSettleNumber());
                            herdPolicyListDto.setAreaNumber(herdPolicyListDto1.getAreaNumber());
                            herdPolicyListDto.setAniMalage(gisHerdFieldListDto.getAnimalAge());
                            herdPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            herdPolicyListDto.setLitterArea(herdPolicyListDtos.get(0).getLitterArea());

                            //总保额，获取页面的从单位保额乘以投保面积
                            herdPolicyListDto.setSumAmount((new BigDecimal(herdPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            herdPolicyListDto.setSumPremium(((new BigDecimal(herdPolicyListDto.getSumAmount()).multiply(new BigDecimal(herdPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            herdPolicyListDto.setInsurePremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setCentralPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setProvincePremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setCityPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setTownPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            herdPolicyListDto.setOtherPremium(((new BigDecimal(herdPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                herdPolicyListDto.setOtherPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())).add(new BigDecimal(herdPolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                herdPolicyListDto.setTownPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())).add(new BigDecimal(herdPolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                herdPolicyListDto.setCityPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(herdPolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                herdPolicyListDto.setProvincePremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()).add(new BigDecimal(herdPolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                herdPolicyListDto.setCentralPremium((new BigDecimal(herdPolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(herdPolicyListDto.getInsurePremium()))).doubleValue());
                            }

                            herdPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                        }

                    }
                }

                for (int i = 0; i < herdPolicyListDtoList.size(); i++) {
                    HerdPolicyListDto herdPolicyListDto = herdPolicyListDtoList.get(i);
                    //新的清单信息中不包含老清单农户
                    if (!gisFarmerItemDtoMap.containsKey(herdPolicyListDto.getfCode())) {
                        endor93Type = true;
                        herdPolicyListDto.setFlag("D");//删除
                        herdPolicyListDto.setValidity("0");
                        herdPolicyListDto.setEndDate(validDate);
                        herdPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                        herdPolicyListDto.setInsureNumber(0);
                        herdPolicyListDto.setIndexCode(indexCode.toString());
                        indexCode++;
                    }
                }

            }
            String planting31FarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_31_FARMER_LIST_FLAG");
            if (null != planting31FarmerListFlag && null != strRiskCode && planting31FarmerListFlag.indexOf(strRiskCode) > -1) {
                for (int i = 0; i < gisFarmerItemDtoList.size(); i++) {
                    GisFarmerItemDto gisFarmerItemDto = gisFarmerItemDtoList.get(i);
                    GisFarmerListDto gisFarmerListDto = gisFarmerListDtoMap.get(gisFarmerItemDto.getfCode());

                    //新增的农户信息
                    if (!planting31PolicyListDtoMap.containsKey(gisFarmerItemDto.getfCode())&&gisFarmerListDto!=null) {
                        endor93Type = true;
                        //将新增的农户信息加入plantingPolicyListDtoList &处理citemkindDto里承保面积信息
                        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtoListNew) {
                            Planting31PolicyListDto planting31PolicyListDto = new Planting31PolicyListDto();
                            planting31PolicyListDto.setInusreListCode(planting31PolicyListDtoList.get(0).getInusreListCode());
                            planting31PolicyListDto.setfCode(gisFarmerItemDto.getfCode());//GIS
                            planting31PolicyListDto.setKindCode(prpCitemKindDto.getKindCode());
                            planting31PolicyListDto.setPhone(gisFarmerListDto.getfPhone());//GIS
                            planting31PolicyListDto.setBank(gisFarmerListDto.getBankName());//GIS
                            planting31PolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());//GIS
                            planting31PolicyListDto.setfName(gisFarmerItemDto.getfName());//GIS
                            planting31PolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());//GIS
                            planting31PolicyListDto.setClassCode(planting31PolicyListDtoList.get(0).getClassCode());
                            planting31PolicyListDto.setRiskCode(planting31PolicyListDtoList.get(0).getRiskCode());
                            planting31PolicyListDto.setfAreaCode(planting31PolicyListDtoList.get(0).getfAreaCode());
                            planting31PolicyListDto.setTaxArea(planting31PolicyListDtoList.get(0).getTaxArea());
                            planting31PolicyListDto.setInsureArea(Double.parseDouble(new java.text.DecimalFormat("0").format(gisFarmerItemDto.getInsureCount())));//GIS
                            planting31PolicyListDto.setAmount(planting31PolicyListDtoList.get(0).getAmount());
                            planting31PolicyListDto.setRate(planting31PolicyListDtoList.get(0).getRate());
                            planting31PolicyListDto.setShortRateFlag(planting31PolicyListDtoList.get(0).getShortRateFlag());
                            planting31PolicyListDto.setShortRate(planting31PolicyListDtoList.get(0).getShortRate());
                            planting31PolicyListDto.setStartDate(planting31PolicyListDtoList.get(0).getStartDate());
                            planting31PolicyListDto.setEndDate(planting31PolicyListDtoList.get(0).getEndDate());
                            planting31PolicyListDto.setCalculateFlag(planting31PolicyListDtoList.get(0).getCalculateFlag());
                            planting31PolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            planting31PolicyListDto.setOpTime(planting31PolicyListDtoList.get(0).getOpTime());
                            planting31PolicyListDto.setValidity("1");
                            planting31PolicyListDto.setFlag("I");
                            planting31PolicyListDto.setTeamName(gisFarmerListDto.getTeamName());//GIS
                            planting31PolicyListDto.setFieldSource(planting31PolicyListDtoList.get(0).getFieldSource());
                            planting31PolicyListDto.setMulchDate(planting31PolicyListDtoList.get(0).getMulchDate());
                            planting31PolicyListDto.setMulchType(planting31PolicyListDtoList.get(0).getMulchType());
                            planting31PolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            //总保额，获取页面的从单位保额乘以投保面积
                            planting31PolicyListDto.setSumAmount((new BigDecimal(planting31PolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            planting31PolicyListDto.setSumPremium(((new BigDecimal(planting31PolicyListDto.getSumAmount()).multiply(new BigDecimal(planting31PolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            planting31PolicyListDto.setfPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setCentralPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setProvincePremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setCityPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setTownPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setOtherPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                planting31PolicyListDto.setOtherPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())).add(new BigDecimal(planting31PolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                planting31PolicyListDto.setTownPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())).add(new BigDecimal(planting31PolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                planting31PolicyListDto.setCityPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                planting31PolicyListDto.setProvincePremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                planting31PolicyListDto.setCentralPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()))).doubleValue());
                            }

                            planting31PolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;

                            planting31PolicyListDtoList.add(planting31PolicyListDto);
                        }

                    }
                }

                for (int i = 0; i < planting31PolicyListDtoList.size(); i++) {
                    Planting31PolicyListDto planting31PolicyListDto = planting31PolicyListDtoList.get(i);
                    if (planting31PolicyListDto.getBank() == null) {
                        planting31PolicyListDto.setBank("");
                    }
                    //判断清单是否有变化
                    if (gisFarmerItemDtoMap.containsKey(planting31PolicyListDto.getfCode())) {
                        GisFarmerListDto gisFarmerListDto = (GisFarmerListDto) gisFarmerListDtoMap.get(planting31PolicyListDto.getfCode());
                        GisFarmerItemDto gisFarmerItemDto=(GisFarmerItemDto) gisFarmerItemDtoMap.get(planting31PolicyListDto.getfCode());
                        //挨个比对字段的值
                        String plantingPolicyListInfoKey = planting31PolicyListDto.getfName() + "-" + planting31PolicyListDto.getfIdCard() + "-"
                                + planting31PolicyListDto.getPhone() + "-" + planting31PolicyListDto.getTeamName() + "-"
                                + planting31PolicyListDto.getBank() + "-" + planting31PolicyListDto.getZhiBuKa() + "-"
                                + planting31PolicyListDto.getInsureArea() + "-";

                        String gisNyxInsuranceListInfoKey = gisFarmerListDto.getfName() + "-" + gisFarmerListDto.getfIdCard() + "-"
                                + gisFarmerListDto.getfPhone() + "-" + gisFarmerListDto.getTeamName() + "-"
                                + gisFarmerListDto.getBankName() + "-" + gisFarmerListDto.getBankCode() + "-"
                                + gisFarmerItemDto.getInsureCount() + "-";

                        if (!plantingPolicyListInfoKey.equals(gisNyxInsuranceListInfoKey)&&gisFarmerItemDto!=null) {
                            endor93Type = true;
                            planting31PolicyListDto.setfName(gisFarmerItemDto.getfName());
                            planting31PolicyListDto.setfIdCard(gisFarmerListDto.getfIdCard());
                            planting31PolicyListDto.setPhone(gisFarmerListDto.getfPhone());
                            planting31PolicyListDto.setTeamName(gisFarmerListDto.getTeamName());
                            planting31PolicyListDto.setBank(gisFarmerListDto.getBankName());
                            planting31PolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());
                            planting31PolicyListDto.setInsureArea(Double.parseDouble(new java.text.DecimalFormat("0").format(gisFarmerItemDto.getInsureCount())));
                            //planting31PolicyListDto.setRemark(gisFarmerListDto.getRemark());
                            planting31PolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            planting31PolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            planting31PolicyListDto.setFlag("U");
                            //总保额，获取页面的从单位保额乘以投保面积
                            planting31PolicyListDto.setSumAmount((new BigDecimal(planting31PolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                            //总保费
                            planting31PolicyListDto.setSumPremium(((new BigDecimal(planting31PolicyListDto.getSumAmount()).multiply(new BigDecimal(planting31PolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                            //补贴金额、农户自缴
                            planting31PolicyListDto.setfPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setCentralPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setProvincePremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setCityPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setTownPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            planting31PolicyListDto.setOtherPremium(((new BigDecimal(planting31PolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                            //  尾差处理
                            if (!"0".equals(otherRate)) {
                                planting31PolicyListDto.setOtherPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())).add(new BigDecimal(planting31PolicyListDto.getCityPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getTownPremium())))).doubleValue());
                            } else if (!"0".equals(townRate)) {
                                planting31PolicyListDto.setTownPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())).add(new BigDecimal(planting31PolicyListDto.getCityPremium())))).doubleValue());
                            } else if (!"0".equals(cityRate)) {
                                planting31PolicyListDto.setCityPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium()))
                                                .add(new BigDecimal(planting31PolicyListDto.getProvincePremium())))).doubleValue());
                            } else if (!"0".equals(provinceRate)) {
                                planting31PolicyListDto.setProvincePremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()).add(new BigDecimal(planting31PolicyListDto.getCentralPremium())))).doubleValue());
                            } else if (!"0".equals(centralRate)) {
                                planting31PolicyListDto.setCentralPremium((new BigDecimal(planting31PolicyListDto.getSumPremium()).subtract(
                                        new BigDecimal(planting31PolicyListDto.getfPremium()))).doubleValue());
                            }

                            planting31PolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                        }

                    }
                }

                for (int i = 0; i < planting31PolicyListDtoList.size(); i++) {
                    Planting31PolicyListDto planting31PolicyListDto = planting31PolicyListDtoList.get(i);
                    //新的清单信息中不包含老清单农户
                    if (!gisFarmerItemDtoMap.containsKey(planting31PolicyListDto.getfCode())) {
                        endor93Type = true;
                        planting31PolicyListDto.setFlag("D");//删除
                        planting31PolicyListDto.setValidity("0");
                        planting31PolicyListDto.setEndDate(validDate);
                        planting31PolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                        planting31PolicyListDto.setInsureArea(0.00);
                        planting31PolicyListDto.setIndexCode(indexCode.toString());
                        indexCode++;
                    }
                }
            }
            if(strRiskCode!=null&&"3129".equals(strRiskCode)){
                List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>();
                for(int i=0;i<gisFarmerItemDtoList.size();i++){
                    GisFarmerItemDto gisFarmerItemDto=gisFarmerItemDtoList.get(i);
                    GisManFieldListDto gisManFieldListDto=gisManFieldListDtoMap.get(gisFarmerItemDto.getfCode());
                    GisFarmerListDto gisFarmerListDto=gisFarmerListDtoMap.get(gisFarmerItemDto.getfCode());
                    if(!nyxPolicyListDtoMap.containsKey(gisFarmerItemDto.getfCode())){
                        endor93Type = true;
                        for(PrpCitemKindDto prpCitemKindDto: prpCitemKindDtoListNew){
                            NyxPolicyListDto nyxPolicyListDto=new NyxPolicyListDto();
                            CMCManFieldListDto cmcManFieldListDto=new CMCManFieldListDto();
                            nyxPolicyListDto.setInusreListCode(nyxPolicyListDtos.get(0).getInusreListCode());
                            nyxPolicyListDto.setfCode(gisFarmerItemDto.getfCode());
                            nyxPolicyListDto.setKindCode(prpCitemKindDto.getKindCode());
                            nyxPolicyListDto.setPhone(gisFarmerListDto.getfPhone());
                            nyxPolicyListDto.setBank(gisFarmerListDto.getBankName());
                            nyxPolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());
                            nyxPolicyListDto.setfName(gisFarmerItemDto.getfName());
                            nyxPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());
                            nyxPolicyListDto.setClassCode(nyxPolicyListDtos.get(0).getClassCode());
                            nyxPolicyListDto.setRiskCode(nyxPolicyListDtos.get(0).getRiskCode());
                            nyxPolicyListDto.setfAreaCode(nyxPolicyListDtos.get(0).getfAreaCode());
                            nyxPolicyListDto.setTaxArea(nyxPolicyListDtos.get(0).getTaxArea());
                            nyxPolicyListDto.setInsureArea(gisFarmerItemDto.getInsureCount());//GIS
                            nyxPolicyListDto.setAmount(nyxPolicyListDtos.get(0).getAmount());
                            nyxPolicyListDto.setRate(nyxPolicyListDtos.get(0).getRate());
                            nyxPolicyListDto.setShortRateFlag(nyxPolicyListDtos.get(0).getShortRateFlag());
                            nyxPolicyListDto.setShortRate(nyxPolicyListDtos.get(0).getShortRate());
                            nyxPolicyListDto.setStartDate(nyxPolicyListDtos.get(0).getStartDate());
                            nyxPolicyListDto.setEndDate(nyxPolicyListDtos.get(0).getEndDate());
                            nyxPolicyListDto.setCalculateFlag(nyxPolicyListDtos.get(0).getCalculateFlag());
                            nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            nyxPolicyListDto.setOpTime(nyxPolicyListDtos.get(0).getOpTime());
                            nyxPolicyListDto.setValidity("1");
                            nyxPolicyListDto.setFlag("I");
                            //nyxPolicyListDto.setRemark(gisFarmerListDto.getRemark());//GIS
                            nyxPolicyListDto.setTeamName(gisFarmerListDto.getTeamName());//GIS
                            nyxPolicyListDto.setFieldSource(nyxPolicyListDtos.get(0).getFieldSource());
                            nyxPolicyListDto.setWarrant(nyxPolicyListDtos.get(0).getWarrant());
                            nyxPolicyListDto.setAtArea(nyxPolicyListDtos.get(0).getAtArea());
                            nyxPolicyListDto.setLitterArea(nyxPolicyListDtos.get(0).getLitterArea());
                            nyxPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            if("ZZ100".equals(prpCitemKindDto.getItemCode())||"ZZ200".equals(prpCitemKindDto.getItemCode())){
                                String industryCategory="";
                                Double rate = 0.0000;
                                if ("ZZ100".equals(prpCitemKindDto.getItemCode())){
                                    industryCategory=gisManFieldListDto.getIndustryCategory();
                                }else {
                                    industryCategory=gisFarmerListDto.getIndustryCategory();
                                }
                                if ("1".equals(industryCategory)) {
                                    rate += 0.14;
                                } else if ("2".equals(industryCategory)) {
                                    rate += 0.18;
                                } else if ("3".equals(industryCategory)) {
                                    rate += 0.23;
                                } else if ("4".equals(industryCategory)) {
                                    rate += 0.35;
                                } else if ("5".equals(industryCategory)) {
                                    rate += 0.53;
                                } else if ("6".equals(industryCategory)) {
                                    rate += 0.68;
                                }
                                nyxPolicyListDto.setRate(new BigDecimal(rate).divide(new BigDecimal(gisManFieldListDtoMap.size()), 4, BigDecimal.ROUND_HALF_UP).doubleValue());//费率
                                nyxPolicyListDto.setSumAmount(new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisManFieldListDtoMap.size())).doubleValue());
                                nyxPolicyListDto.setSumPremium((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply((new BigDecimal(nyxPolicyListDto.getRate()).divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP))).doubleValue()));
                                // ---------------------------------------农户自缴---------------------------------------------
                                nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                // ---------------------------------------补贴金额---------------------------------------------
                                //中央财政补贴
                                nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //省级财政补贴，看
                                nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //地市财政补贴
                                nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //县(区)财政补贴
                                nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //其他来源补贴
                                nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //  尾差处理
                                if (!"0".equals(otherRate)) {
                                    nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                                } else if (!"0".equals(townRate)) {
                                    nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                                } else if (!"0".equals(cityRate)) {
                                    nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                                } else if (!"0".equals(provinceRate)) {
                                    nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                                } else if (!"0".equals(centralRate)) {
                                    nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                                }

                            }else if("YY100".equals(prpCitemKindDto.getItemCode())){
                                nyxPolicyListDto.setSumAmount(Double.parseDouble(gisFarmerListDto.getLoadAmount()));
                                if (Double.parseDouble(gisFarmerListDto.getLoadAmount()) >= 100000.0) {//小额贷款大于10w按10w算
                                    nyxPolicyListDto.setSumPremium(new BigDecimal(Double.toString(100000.00)).multiply(new BigDecimal(Double.toString(nyxPolicyListDto.getRate()))).doubleValue());
                                } else {
                                    nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate()))).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                                }
                            }else {
                                //总保额，获取页面的从单位保额乘以投保面积
                                nyxPolicyListDto.setSumAmount((new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                                //总保费
                                nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                                //补贴金额、农户自缴
                                nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //  尾差处理
                                if (!"0".equals(otherRate)) {
                                    nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                                } else if (!"0".equals(townRate)) {
                                    nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                                } else if (!"0".equals(cityRate)) {
                                    nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                                } else if (!"0".equals(provinceRate)) {
                                    nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                                } else if (!"0".equals(centralRate)) {
                                    nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                                }
                            }
                            nyxPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                            nyxPolicyListDtoList.add(nyxPolicyListDto);
                        }
                    }

                }
                for (int i = 0; i < nyxPolicyListDtos.size(); i++) {
                    NyxPolicyListDto nyxPolicyListDto = nyxPolicyListDtos.get(i);
                    if (nyxPolicyListDto.getBank() == null) {
                        nyxPolicyListDto.setBank("");
                    }
                    //判断清单是否有变化
                    if (gisFarmerItemDtoMap.containsKey(nyxPolicyListDto.getfCode())) {
                        GisFarmerListDto gisFarmerListDto =gisFarmerListDtoMap.get(nyxPolicyListDto.getfCode());
                        GisFarmerItemDto gisFarmerItemDto=gisFarmerItemDtoMap.get(nyxPolicyListDto.getfCode());
                        GisManFieldListDto gisManFieldListDto=gisManFieldListDtoMap.get(nyxPolicyListDto.getfCode());
                        CMCManFieldListDto cmcManFieldListDto=cmcManFieldListDtoMap.get(nyxPolicyListDto.getfCode());
                        //挨个比对字段的值
                        String nyxPolicyListInfoKey = nyxPolicyListDto.getfName() + "-" + nyxPolicyListDto.getfIdCard() + "-"
                                + nyxPolicyListDto.getPhone() + "-" + nyxPolicyListDto.getTeamName() + "-"
                                + nyxPolicyListDto.getBank() + "-" + nyxPolicyListDto.getZhiBuKa() + "-"
                                + nyxPolicyListDto.getInsureArea() + "-" +cmcManFieldListDto.getIndustryCategory()+"-";

                        String gisNyxInsuranceListInfoKey = gisFarmerListDto.getfName() + "-" + gisFarmerListDto.getfIdCard() + "-"
                                + gisFarmerListDto.getfPhone() + "-" + gisFarmerListDto.getTeamName() + "-"
                                + gisFarmerListDto.getBankName() + "-" + gisFarmerListDto.getBankCode() + "-"
                                + gisFarmerItemDto.getInsureCount() + "-" +gisManFieldListDto.getIndustryCategory()+"-";

                        if (!nyxPolicyListInfoKey.equals(gisNyxInsuranceListInfoKey)&&gisFarmerItemDto!=null) {
                            endor93Type = true;
                            nyxPolicyListDto.setfName(gisFarmerItemDto.getfName());
                            nyxPolicyListDto.setfIdCard(gisFarmerItemDto.getfIdCard());
                            nyxPolicyListDto.setPhone(gisFarmerListDto.getfPhone());
                            nyxPolicyListDto.setTeamName(gisFarmerListDto.getTeamName());
                            nyxPolicyListDto.setBank(gisFarmerListDto.getBankName());
                            nyxPolicyListDto.setZhiBuKa(gisFarmerListDto.getBankCode());
                            nyxPolicyListDto.setInsureArea(gisFarmerItemDto.getInsureCount());
                            //nyxPolicyListDto.setRemark(gisFarmerListDto.getRemark());
                            nyxPolicyListDto.setItemCode(gisFarmerItemDto.getItemCode());
                            nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                            nyxPolicyListDto.setFlag("U");
                            //总保额，获取页面的从单位保额乘以投保面积
                            if("ZZ100".equals(nyxPolicyListDto.getItemCode())||"ZZ200".equals(nyxPolicyListDto.getItemCode())){
                                String industryCategory="";
                                Double rate = 0.0000;
                                if ("ZZ100".equals(nyxPolicyListDto.getItemCode())){
                                    industryCategory=gisManFieldListDto.getIndustryCategory();
                                }else {
                                    industryCategory=gisFarmerListDto.getIndustryCategory();
                                }
                                if ("1".equals(industryCategory)) {
                                    rate += 0.14;
                                } else if ("2".equals(industryCategory)) {
                                    rate += 0.18;
                                } else if ("3".equals(industryCategory)) {
                                    rate += 0.23;
                                } else if ("4".equals(industryCategory)) {
                                    rate += 0.35;
                                } else if ("5".equals(industryCategory)) {
                                    rate += 0.53;
                                } else if ("6".equals(industryCategory)) {
                                    rate += 0.68;
                                }
                                nyxPolicyListDto.setRate(new BigDecimal(rate).divide(new BigDecimal(gisManFieldListDtoMap.size()), 4, BigDecimal.ROUND_HALF_UP).doubleValue());//费率
                                nyxPolicyListDto.setSumAmount(new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisManFieldListDtoMap.size())).doubleValue());
                                nyxPolicyListDto.setSumPremium((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply((new BigDecimal(nyxPolicyListDto.getRate()).divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP))).doubleValue()));
                                // ---------------------------------------农户自缴---------------------------------------------
                                nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                // ---------------------------------------补贴金额---------------------------------------------
                                //中央财政补贴
                                nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //省级财政补贴，看
                                nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //地市财政补贴
                                nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //县(区)财政补贴
                                nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //其他来源补贴
                                nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //  尾差处理
                                if (!"0".equals(otherRate)) {
                                    nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                                } else if (!"0".equals(townRate)) {
                                    nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                                } else if (!"0".equals(cityRate)) {
                                    nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                                } else if (!"0".equals(provinceRate)) {
                                    nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                                } else if (!"0".equals(centralRate)) {
                                    nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                                }

                            }else if("YY100".equals(nyxPolicyListDto.getItemCode())){
                                nyxPolicyListDto.setSumAmount(Double.parseDouble(gisFarmerListDto.getLoadAmount()));
                                if (Double.parseDouble(gisFarmerListDto.getLoadAmount()) >= 100000.0) {//小额贷款大于10w按10w算
                                    nyxPolicyListDto.setSumPremium(new BigDecimal(Double.toString(100000.00)).multiply(new BigDecimal(Double.toString(nyxPolicyListDto.getRate()))).doubleValue());
                                } else {
                                    nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate()))).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                                }
                            }else {
                                //总保额，获取页面的从单位保额乘以投保面积
                                nyxPolicyListDto.setSumAmount((new BigDecimal(nyxPolicyListDto.getAmount()).multiply(new BigDecimal(gisFarmerItemDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                                //总保费
                                nyxPolicyListDto.setSumPremium(((new BigDecimal(nyxPolicyListDto.getSumAmount()).multiply(new BigDecimal(nyxPolicyListDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                                //补贴金额、农户自缴
                                nyxPolicyListDto.setfPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(fRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setCentralPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setProvincePremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setCityPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setTownPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                nyxPolicyListDto.setOtherPremium(((new BigDecimal(nyxPolicyListDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                                //  尾差处理
                                if (!"0".equals(otherRate)) {
                                    nyxPolicyListDto.setOtherPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getTownPremium())))).doubleValue());
                                } else if (!"0".equals(townRate)) {
                                    nyxPolicyListDto.setTownPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())).add(new BigDecimal(nyxPolicyListDto.getCityPremium())))).doubleValue());
                                } else if (!"0".equals(cityRate)) {
                                    nyxPolicyListDto.setCityPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium()))
                                                    .add(new BigDecimal(nyxPolicyListDto.getProvincePremium())))).doubleValue());
                                } else if (!"0".equals(provinceRate)) {
                                    nyxPolicyListDto.setProvincePremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()).add(new BigDecimal(nyxPolicyListDto.getCentralPremium())))).doubleValue());
                                } else if (!"0".equals(centralRate)) {
                                    nyxPolicyListDto.setCentralPremium((new BigDecimal(nyxPolicyListDto.getSumPremium()).subtract(
                                            new BigDecimal(nyxPolicyListDto.getfPremium()))).doubleValue());
                                }
                            }

                            nyxPolicyListDto.setIndexCode(indexCode.toString());
                            indexCode++;
                        }

                    }
                }
                for (int i = 0; i < nyxPolicyListDtos.size(); i++) {
                    NyxPolicyListDto nyxPolicyListDto = nyxPolicyListDtos.get(i);
                    CMCManFieldListDto cmcManFieldListDto=cmcManFieldListDtoMap.get(nyxPolicyListDto.getfCode());
                    //新的清单信息中不包含老清单农户
                    if (!gisFarmerItemDtoMap.containsKey(nyxPolicyListDto.getfCode())) {
                        endor93Type = true;
                        nyxPolicyListDto.setFlag("D");//删除
                        nyxPolicyListDto.setValidity("0");
                        nyxPolicyListDto.setEndDate(validDate);
                        nyxPolicyListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
                        nyxPolicyListDto.setInsureArea(0.00);
                        nyxPolicyListDto.setIndexCode(indexCode.toString());
                        indexCode++;
                    }
                }
            }
        }else {
            endor93Type=false;//非分户批改
        }

        BLEndorseDto blEndorseDto = new BLEndorseDto();
        PrpPheadDto prpPheadDto = new PrpPheadDto();

        policyEndorseDto.getBlPolicyInfoDtoNew().setPlantingPolicyListDtoList(plantingPolicyListDtoList);
        policyEndorseDto.getBlPolicyInfoDtoNew().setNyxPolicyListDtoList(nyxPolicyListDtos);
        policyEndorseDto.getBlPolicyInfoDtoNew().setHerdPolicyListDtoList(herdPolicyListDtos);
        policyEndorseDto.getBlPolicyInfoDtoNew().setPlanting31PolicyListDtoList(planting31PolicyListDtoList);
        prpPheadDto.setPolicyNo(policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().getPolicyNo());
        blEndorseDto.setPrpPheadDto(prpPheadDto);
        policyEndorseDto.setBlEndorseDto(blEndorseDto);
        if(endor93Type){
            //设置批改类型
            prpPheadDto.setEndorType("93");//分户批改
            //处理附带的信息流转
            updatePremium(policyEndorseDto);
            policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumInsured(Double.parseDouble(String.valueOf(gisFarmerListDtoMap.size())));
        }else {
            double quantity=0.0;
            for(PrpCitemKindDto prpCitemKindDto:policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCitemKindDtoList()){
                quantity+=prpCitemKindDto.getQuantity();
            }
            policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setStatQuantity(quantity);
            policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumInsured(policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCmainDto().getSumInsured());
        }
        blEndorseDto.setPrpPheadDto(prpPheadDto);

        policyEndorseDto.setBlEndorseDto(blEndorseDto);
    }

    /**
     * 处理险别表、缴费计划表、费表、补贴表信息流转
     * @author: ldd
     * @date: 2017/12/15 11:26
     * @param policyEndorseDto
     */
    public void updatePremium(PolicyEndorseDto policyEndorseDto)throws Exception{
        //生效日期(默认当前日期的第二天)
        List<PlantingPolicyListDto> plantingPolicyListDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPlantingPolicyListDtoList();
        List<PrpCitemKindDto> prpCitemKindDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCitemKindDtoList();
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCitemKindAgriDtoList();
        List<PrpCplanDto> prpCplanDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCplanDtoList();
        List<PrpCsubsidyDto> prpCsubsidyDtoList = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCsubsidyDtoList();
        double SelfPremium=0.00;//保单自缴保费
        double PFPremium=0.00;//保单自缴保费
        double PCentralPremium=0.00;//中央财政补贴
        double PProvincePremium=0.00;//省级财政补贴
        double PCityPremium=0.00;//地市财政补贴
        double PTownPremium=0.00;//县(区)财政补贴
        double POtherPremium=0.00;//其他来源补贴
        double SumPremiumNew=0.00;//保单总保费
        double SumAmountNew=0.00;//保单总保额
        double SelfPremiumNew=0.00;//保单总自缴保费
        double PQuantity=0.00;//承包亩数
        double KoldRate =0.00;//3151费率
        BigDecimal CentralRate = new BigDecimal(0);
        BigDecimal ProvinceRate = new BigDecimal(0);
        BigDecimal CityRate = new BigDecimal(0);
        BigDecimal TownRate = new BigDecimal(0);
        BigDecimal OtherRate = new BigDecimal(0);
        BigDecimal FRate = new BigDecimal(0);
        int SumInsured = 0;//投保总面积
        String strKindCode = "";
        for(int kindIndex=0; kindIndex<prpCitemKindDtoList.size(); kindIndex++){
            double KAmount=0.00;//每个险别的保额
            double KAmountSub = 0.00;//3151附加单人保额
            double KPremium=0.00;//每个险别的保费
            double KPremiumSub=0.00;//每个3151附加险别的保费
            double KQuantity = 0.00;//每个险别的承包亩数
            int KSumInsured = 0;
            for(int i=0; i<plantingPolicyListDtoList.size(); i++){
                strKindCode = prpCitemKindDtoList.get(kindIndex).getKindCode();
                if(strKindCode.equals(plantingPolicyListDtoList.get(i).getKindCode())&&!"D".equals(plantingPolicyListDtoList.get(i).getFlag())){
                    KAmount+=plantingPolicyListDtoList.get(i).getSumAmount();
                    KPremium+=plantingPolicyListDtoList.get(i).getSumPremium();
                    SelfPremium +=plantingPolicyListDtoList.get(i).getfPremium();
                    PCentralPremium+=plantingPolicyListDtoList.get(i).getCentralPremium();
                    PProvincePremium+=plantingPolicyListDtoList.get(i).getProvincePremium();
                    PCityPremium+=plantingPolicyListDtoList.get(i).getCityPremium();
                    PTownPremium+=plantingPolicyListDtoList.get(i).getTownPremium();
                    POtherPremium+=plantingPolicyListDtoList.get(i).getOtherPremium();
                    KQuantity+=plantingPolicyListDtoList.get(i).getInsureArea();

                    if((!"D".equals(plantingPolicyListDtoList.get(i).getFlag()))&&("1".equals(plantingPolicyListDtoList.get(i).getValidity()))){
                        KSumInsured++;}
                }
            }
            SumInsured = KSumInsured;
            PQuantity = KQuantity;
            prpCitemKindDtoList.get(kindIndex).setAmount(KAmount);
            prpCitemKindDtoList.get(kindIndex).setPremium(KPremium);
            prpCitemKindDtoList.get(kindIndex).setQuantity(KQuantity);
            prpCitemKindDtoList.get(kindIndex).setBasePremium(KPremium);
            prpCitemKindDtoList.get(kindIndex).setBenchmarkPremium(KPremium);
            SumPremiumNew =SumPremiumNew+KPremium;
            if("Y".equals(prpCitemKindDtoList.get(kindIndex).getCalculateFlag())){
                SumAmountNew = SumAmountNew +KAmount;
            }
            if(prpCitemKindDtoList.get(kindIndex).getFlag()==null){
                prpCitemKindDtoList.get(kindIndex).setFlag("");
            }
            int flagLength=prpCitemKindDtoList.get(kindIndex).getFlag().length();
            int flagLength1=0;
            if(prpCitemKindAgriDtoList.get(kindIndex).getFlag()!=null){
                flagLength1 = prpCitemKindAgriDtoList.get(kindIndex).getFlag().length();
            }
            if(flagLength>1){
                prpCitemKindDtoList.get(kindIndex).setFlag("U"+prpCitemKindDtoList.get(kindIndex).getFlag().substring(1,flagLength));
            }else{
                prpCitemKindDtoList.get(kindIndex).setFlag("U");
            }
            if(flagLength1>1){
                prpCitemKindAgriDtoList.get(kindIndex).setFlag("U"+prpCitemKindAgriDtoList.get(kindIndex).getFlag().substring(1,flagLength1));
            }else{
                prpCitemKindAgriDtoList.get(kindIndex).setFlag("U");
            }
            prpCitemKindAgriDtoList.get(kindIndex).setGrossQuantity(KQuantity);
        }
        double quantity=0.0;
        double sumPremium=0.0;
        double sumAmount=0.0;
        for(PrpCitemKindDto prpCitemKindDto:prpCitemKindDtoList){
            quantity+=prpCitemKindDto.getQuantity();
            sumPremium+=prpCitemKindDto.getPremium();
            sumAmount+=prpCitemKindDto.getAmount();
        }
        policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumPremium(sumPremium);
        policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumAmount(sumAmount);
        policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setStatQuantity(quantity);
        policyEndorseDto.getBlPolicyInfoDtoNew().setPrpCitemKindAgriDtoList(prpCitemKindAgriDtoList);
        policyEndorseDto.getBlPolicyInfoDtoNew().setPrpCitemKindDtoList(prpCitemKindDtoList);
        //更新缴费计划
        //TODO commonship/pg/UIPlantEndorseSpecialGenerateObject.jsp 797-899

        PrpCmainDto prpCmainDto = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto();
        PrpCfeeDto prpCfeeDto = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCfeeDtoList().get(0);
        List<PrpCsubsidyDto> prpCsubsidyDtoListNew = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCsubsidyDtoList();
        //补贴信息
        double dbSubsidyPremium=0.00;
        double subsidyPremium =0.00;
        PrpCplanDto prpCplanDto = new PrpCplanDto();
        for(int i=0; i<prpCsubsidyDtoListNew.size(); i++) {
            String PSubsidyCode = prpCsubsidyDtoListNew.get(i).getSubsidyCode();
            Double PSubsidyRate = prpCsubsidyDtoListNew.get(i).getSubsidyRate();
            if ("03".equals(PSubsidyCode)) {
                prpCsubsidyDtoListNew.get(i).setBenchmarkPremium(SumPremiumNew);
                prpCsubsidyDtoListNew.get(i).setSubsidyPremium(PCentralPremium);
                prpCplanDto.setPayReason("PS3");
            } else if ("04".equals(PSubsidyCode)) {
                prpCsubsidyDtoListNew.get(i).setBenchmarkPremium(SumPremiumNew);
                prpCsubsidyDtoListNew.get(i).setSubsidyPremium(PProvincePremium);
                prpCplanDto.setPayReason("PS4");
            } else if ("05".equals(PSubsidyCode)) {
                prpCsubsidyDtoListNew.get(i).setBenchmarkPremium(SumPremiumNew);
                prpCsubsidyDtoListNew.get(i).setSubsidyPremium(PCityPremium);
            } else if ("07".equals(PSubsidyCode)) {
                prpCsubsidyDtoList.get(i).setBenchmarkPremium(SumPremiumNew);
                prpCsubsidyDtoList.get(i).setSubsidyPremium(PTownPremium);
                prpCplanDto.setPayReason("PS7");
            } else if ("06".equals(PSubsidyCode)) {
                prpCsubsidyDtoListNew.get(i).setBenchmarkPremium(SumPremiumNew);
                prpCsubsidyDtoListNew.get(i).setSubsidyPremium(POtherPremium);
                prpCplanDto.setPayReason("PS6");
            }
        }
        policyEndorseDto.getBlPolicyInfoDtoNew().setPrpCsubsidyDtoList(prpCsubsidyDtoListNew);
        calPrpCfee(policyEndorseDto);

    }

    public PolicyEndorseDto calPrpCfee(PolicyEndorseDto policyEndorseDto) throws Exception {
        PrpCitemKindDto prpCitemkindDto;
        ResponseQueryPolicyInfoDto blPolicyDtoNew = policyEndorseDto.getBlPolicyInfoDtoNew();
        ResponseQueryPolicyInfoDto blPolicyDtoOld = policyEndorseDto.getBlPolicyInfoDtoOld();
        BLEndorseDto blEndorseDto = policyEndorseDto.getBlEndorseDto();
        List<PrpCfeeDto> prpCfeeDtoList = new ArrayList<>();
        prpCfeeDtoList.addAll(blPolicyDtoOld.getPrpCfeeDtoList());
        PrpCfeeDto prpCfeeDto;
        PrpCfeeDto prpCfeeOldDto;
        int index;
        String strFlag1;
        int indexOld;
        String gisInsureListCode=policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCmainAgriDto().getRelationListNo();
        List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByInsureListCode(gisInsureListCode);
        String insureListCode=insureMainListDtoList.get(0).getGisInsureListCode();
        Map<String,String> map1=new HashedMap();
        map1.put("insureListCode",insureListCode);
        GisInsureMainListDto gisInsureMainListDto=gisInsureListApi.querySerialNo(map1);
        int serialNo=gisInsureMainListDto.getSerialNo();
        String strCurrency2 = "";
        String strCurrency1 = "";
        double dblExchangeRate2 = 0;
        double dblExchangeRate1 = 0;
        double dblAmount = 0;
        double dblAmount2 = 0;
        double dblAmount1 = 0;
        double dblPremium = 0;
        double dblPremium2 = 0;
        double dblPremium1 = 0;
        PubTools pubTools = new PubTools();
        double dblSumPremium = 0;
        double premiumOld=0.0;
        premiumOld=blPolicyDtoNew.getPrpCfeeDtoList().get(0).getPremium();
        Hashtable feeHashtable = new Hashtable();
        List<GisFarmerItemDto> gisFarmerItemDtoList=null;
        Map<String,String> map=new HashedMap();
        Double insureCount;
        //有保费变化的特殊批改：01、19、21、保单币别没有变化（原币、保单汇总币别、支付保费币别）
        //xiaojian_leave：犹豫期退保是否可以如此处理
        for (index = 0; index < blPolicyDtoNew.getPrpCitemKindDtoList().size(); index++) {
            //此时PrpCitemKind已经是上面处理后的
            insureCount=0.0;
            prpCitemkindDto = blPolicyDtoNew.getPrpCitemKindDtoList().get(index);
            map.put("gisInsureListCode",insureListCode);
            map.put("serialNo",String.valueOf(serialNo));
            map.put("itemCode",prpCitemkindDto.getItemCode());
            //map.put("itemCodeList",prpCitemkindDto.getReplyNo());
            gisFarmerItemDtoList=gisInsureListApi.queryInsureCount(map);
            for(GisFarmerItemDto gisFarmerItemDto:gisFarmerItemDtoList){
                insureCount+=gisFarmerItemDto.getInsureCount();
            }
            prpCitemkindDto.setQuantity(insureCount);
            prpCitemkindDto.setPremium(prpCitemkindDto.getRate()*prpCitemkindDto.getUnitAmount()*insureCount/100);
            prpCitemkindDto.setAmount(insureCount*prpCitemkindDto.getUnitAmount());
            if (prpCitemkindDto.getFlag().length() > 0)
                strFlag1 = prpCitemkindDto.getFlag().substring(0, 1);
            else
                strFlag1 = "";
            //xiaojian_leave：目前险判断以下两种类型，待以后补充
            if (strFlag1.equals("B") || strFlag1.equals("D"))
                continue;

            for (indexOld = 0; indexOld < prpCfeeDtoList.size(); indexOld++) {
                prpCfeeOldDto = prpCfeeDtoList.get(indexOld);

                //6.1、如果原币不相同不进行处理
                if (!prpCfeeOldDto.getCurrency().equals(prpCitemkindDto.getCurrency()))
                    continue;
                //6.2、从哈希表中获得已经有的Fee的数据，进行累加
                prpCfeeDto = (PrpCfeeDto) feeHashtable.get(prpCitemkindDto.getCurrency());
                if (prpCfeeDto == null) {
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
                if (prpCitemkindDto.getCalculateFlag().trim().equals("Y")) {
                    dblAmount = Str.round(pubTools.nullToDouble(prpCfeeDto.getAmount()), 2)
                            + Str.round(pubTools.nullToDouble(prpCitemkindDto.getAmount()), 2);
                    prpCfeeDto.setAmount(Str.round(dblAmount, 2));
                } else {
                    dblAmount = Str.round(pubTools.nullToDouble(prpCfeeDto.getAmount()), 2);
                    prpCfeeDto.setAmount(dblAmount);
                }

                dblPremium = Str.round(pubTools.nullToDouble(prpCfeeDto.getPremium()), 4)
                        + Str.round(pubTools.nullToDouble(prpCitemkindDto.getPremium()), 4);

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
//                prpCfeeDto.setNoTaxPremium(Str.round(dblPremium1,4));
//                prpCfeeDto.setNoTaxPremium1(Str.round(dblPremium1,4));
//                prpCfeeDto.setNoTaxPremium2(Str.round(dblPremium1,4));
                prpCfeeDto.setTaxFee(0.0);
                prpCfeeDto.setTaxFee1(0.0);
                prpCfeeDto.setTaxFee2(0.0);
                if (StringUtils.isEmpty(prpCfeeDto.getFlag()))
                    prpCfeeDto.setFlag(strFlag1);
                feeHashtable.put(prpCitemkindDto.getCurrency(), prpCfeeDto);
                break;
            }
        }

        Object[] arrObject = feeHashtable.values().toArray();

        for (index = 0; index < arrObject.length; index++) {
            prpCfeeDtoList.add((PrpCfeeDto) arrObject[index]);
            dblSumPremium += ((PrpCfeeDto) arrObject[index]).getPremium2(); //Prp*main.SumPremium
        }
        prpCfeeDtoList.remove(0);
        blPolicyDtoNew.setPrpCfeeDtoList(prpCfeeDtoList);
        if(blPolicyDtoOld.getPrpCfeeDtoList().get(0).getPremium()!=blPolicyDtoNew.getPrpCfeeDtoList().get(0).getPremium()){
            blPolicyDtoNew.getPrpCfeeDtoList().get(0).setFlag("U");
        }

        generatePEndorseService.generatePrpPfee(blPolicyDtoOld, blPolicyDtoNew, blEndorseDto);
        /*农险的不含税保费就是总保费*/
        blPolicyDtoNew.getPrpCfeeDtoList().get(0).setNoTaxPremium(Str.round(dblPremium1, 4));
        blPolicyDtoNew.getPrpCfeeDtoList().get(0).setNoTaxPremium1(Str.round(dblPremium1, 4));
        blPolicyDtoNew.getPrpCfeeDtoList().get(0).setNoTaxPremium2(Str.round(dblPremium1, 4));
//        double premium = 0.0;
//        for (PrpCitemKindDto prpCitemKindDto : blPolicyDtoNew.getPrpCitemKindDtoList()) {
//            if(!"D".equals(prpCitemKindDto.getFlag())) {
//                premium += prpCitemKindDto.getPremium();
//            }
//        }
        if (dblSumPremium - premiumOld != 0) {
            blPolicyDtoNew.setPrpCplanDtoList(blPolicyDtoOld.getPrpCplanDtoList());//多次点击计算只在最原始的缴费计划之上添加
            for(PrpCsubsidyDto prpCsubsidyDto:blPolicyDtoOld.getPrpCsubsidyDtoList()){
                for(PrpCsubsidyDto prpCsubsidyDto1:blPolicyDtoNew.getPrpCsubsidyDtoList()){
                    if (prpCsubsidyDto.getSubsidyCode().equals(prpCsubsidyDto1.getSubsidyCode())&&prpCsubsidyDto.getSubsidyType().equals(prpCsubsidyDto1.getSubsidyType())) {
                        prpCsubsidyDto1.setSubsidyPremium(prpCsubsidyDto.getSubsidyPremium());
                    }
                }
            }
            //blPolicyDtoNew.setPrpCsubsidyDtoList(blPolicyDtoOld.getPrpCsubsidyDtoList());
            if (blPolicyDtoNew.getPrpCsubsidyDtoList() == null || blPolicyDtoNew.getPrpCsubsidyDtoList().size() == 0) {
                new GenerateCEndorseServiceImpl().append(blPolicyDtoNew, blEndorseDto);
            } else {
                new GenerateCEndorseServiceImpl().appendAgriPlan(blPolicyDtoOld, blPolicyDtoNew, blEndorseDto);
            }
        }
        for(int i=0;i<blPolicyDtoNew.getPrpCplanDtoList().size();i++){
            if(blPolicyDtoNew.getPrpCplanDtoList().get(i).getPlanFee()==0){//去掉应缴金额为0的条目
                blPolicyDtoNew.getPrpCplanDtoList().remove(i);
                i--;
            }
        }
        policyEndorseDto.setBlEndorseDto(blEndorseDto);
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDtoNew);
        policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyDtoOld);
        double sumAmount=0.0;
        double sumPremium=0.0;
        for(PrpCitemKindDto prpCitemKindDto:policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCitemKindDtoList()){
            if(prpCitemKindDto.getFlag().indexOf("D")==-1&&"Y".equals(prpCitemKindDto.getCalculateFlag())){
                sumAmount+=prpCitemKindDto.getAmount();
            }
            if(prpCitemKindDto.getFlag().indexOf("D")==-1) {
                sumPremium += prpCitemKindDto.getPremium();
            }
        }
        policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumAmount(sumAmount);
        policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto().setSumPremium(sumPremium);
        return policyEndorseDto;
    }

}
