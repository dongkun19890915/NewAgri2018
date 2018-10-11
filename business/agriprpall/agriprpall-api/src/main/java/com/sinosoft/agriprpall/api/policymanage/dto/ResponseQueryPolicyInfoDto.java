package com.sinosoft.agriprpall.api.policymanage.dto;


import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCManFieldListDto;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;

import java.util.List;

/**
 *  保单查询详细信息responseDtoApi操作对象
 * @Author: 王心洋
 * @Date: 2017/10/26 19:12
 */
public class ResponseQueryPolicyInfoDto {

    private static final long serialVersionUID = 1L;
    //特约及附加信息组装对象
    private List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList;

    public List<QueryProposalPrpTengageDto> getQueryProposalPrpTengageDtoList() {
        return queryProposalPrpTengageDtoList;
    }

    public void setQueryProposalPrpTengageDtoList(List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList) {
        this.queryProposalPrpTengageDtoList = queryProposalPrpTengageDtoList;
    }

    /**保单基本信息表*/
    private PrpCmainDto               prpCmainDto           ;
    /**农业险保单信息*/
    private PrpCmainAgriDto           prpCmainAgriDto       ;
    /**续保信息表*/
    private PrpCrenewalDto            prpCrenewalDto        ;
    /***/
    private List<PrpCinsuredDto     > prpCinsuredDtoList    ;
    /***/
    private List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList;
    /**保单费用信息表*/
    private PrpCexpenseDto            prpCexpenseDto        ;
    /**保险地址表*/
    private List<PrpCaddressDto     > prpCaddressDtoList    ;
    /***/
    private List<PrpCsubsidyDto     > prpCsubsidyDtoList    ;
    /**保单标的子险信息表*/
    private List<PrpCitemKindDto    > prpCitemKindDtoList   ;
    /**特别约定表*/
    private List<PrpCengageDto      > prpCengageDtoList     ;
    /**大户田块信息*/
    private List<PrpCfeildDto       > prpCfeildDtoList      ;
    /**保单保额保费*/
    private List<PrpCfeeDto         > prpCfeeDtoList        ;
    /**收费计划表*/
    private List<PrpCplanDto        > prpCplanDtoList       ;
    /**共保信息表*/
    private List<PrpCcoinsDto       > prpCcoinsDtoList      ;
    /***/
    private List<PrpCcoinsDetailDto > prpCcoinsDetailDtoList;
    /**共保方收费计划表*/
    private List<PrpCplanCoinsDto   > prpCplanCoinsDtoList  ;

    private List<PlantingPolicyListDto> plantingPolicyListDtoList;

    private List<NyxPolicyListDto> nyxPolicyListDtoList;

    private List<Planting31PolicyListDto> planting31PolicyListDtoList;

    private List<HerdPolicyListDto> herdPolicyListDtoList;

    private List<InsureMainListDto> insureMainListDtoList;
    private List<CMCManFieldListDto> cmcManFieldListDtoList;

    private String insureListCode;
    private String listTypeFlag;

    public List<CMCManFieldListDto> getCmcManFieldListDtoList() {
        return cmcManFieldListDtoList;
    }

    public void setCmcManFieldListDtoList(List<CMCManFieldListDto> cmcManFieldListDtoList) {
        this.cmcManFieldListDtoList = cmcManFieldListDtoList;
    }

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getListTypeFlag() {
        return listTypeFlag;
    }

    public void setListTypeFlag(String listTypeFlag) {
        this.listTypeFlag = listTypeFlag;
    }

    private Double comissionRate;
    /** 添加金禾清单大对象 add by 王心洋 20180104 */
    private InsurePreliminaryConfirmDto insurePreliminaryConfirmDto;
    //发票信息
    PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;
    
    /** GIS清单主表*/
    private GisInsureMainListDto gisInsureMainListDto;

    private GisInsureListDto gisInsureListDto;

    /**下拉选集合列表*/
    private List<PrpDcodeDto> riskCodeNameList;
    private List<PrpDcodeDto> languageNameList;
    private List<PrpDcodeDto> businessNatureNameList;
    private List<PrpDcodeDto> policySortNameList;
    private List<PrpDcodeDto> businessTypeNameList;
    private List<PrpDcodeDto> businessTypeNameList1;
    private List<PrpDcodeDto> statUnitCodeNameList;
    private List<PrpDcodeDto> articleTypeNameList;
    private List<PrpDcodeDto> cattleTypeNameList;
    private List<PrpDcodeDto> raiseTypeNameList;

    public InsurePreliminaryConfirmDto getInsurePreliminaryConfirmDto() {
        return insurePreliminaryConfirmDto;
    }

    public void setInsurePreliminaryConfirmDto(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) {
        this.insurePreliminaryConfirmDto = insurePreliminaryConfirmDto;
    }

    public Double getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(Double comissionRate) {
        this.comissionRate = comissionRate;
    }

    public List<InsureMainListDto> getInsureMainListDtoList() {
        return insureMainListDtoList;
    }

    public void setInsureMainListDtoList(List<InsureMainListDto> insureMainListDtoList) {
        this.insureMainListDtoList = insureMainListDtoList;
    }

    public List<PlantingPolicyListDto> getPlantingPolicyListDtoList() {
        return plantingPolicyListDtoList;
    }

    public void setPlantingPolicyListDtoList(List<PlantingPolicyListDto> plantingPolicyListDtoList) {
        this.plantingPolicyListDtoList = plantingPolicyListDtoList;
    }

    public List<HerdPolicyListDto> getHerdPolicyListDtoList() {
        return herdPolicyListDtoList;
    }

    public void setHerdPolicyListDtoList(List<HerdPolicyListDto> herdPolicyListDtoList) {
        this.herdPolicyListDtoList = herdPolicyListDtoList;
    }

    public List<NyxPolicyListDto> getNyxPolicyListDtoList() {
        return nyxPolicyListDtoList;
    }

    public void setNyxPolicyListDtoList(List<NyxPolicyListDto> nyxPolicyListDtoList) {
        this.nyxPolicyListDtoList = nyxPolicyListDtoList;
    }

    public List<Planting31PolicyListDto> getPlanting31PolicyListDtoList() {
        return planting31PolicyListDtoList;
    }

    public void setPlanting31PolicyListDtoList(List<Planting31PolicyListDto> planting31PolicyListDtoList) {
        this.planting31PolicyListDtoList = planting31PolicyListDtoList;
    }

    public PrpCmainDto getPrpCmainDto() {
        return prpCmainDto;
    }

    public PrpCmainAgriDto getPrpCmainAgriDto() {
        return prpCmainAgriDto;
    }

    public PrpCrenewalDto getPrpCrenewalDto() {
        return prpCrenewalDto;
    }

    public List<PrpCinsuredDto> getPrpCinsuredDtoList() {
        return prpCinsuredDtoList;
    }

    public List<PrpCitemKindAgriDto> getPrpCitemKindAgriDtoList() {
        return prpCitemKindAgriDtoList;
    }

    public PrpCexpenseDto getPrpCexpenseDto() {
        return prpCexpenseDto;
    }

    public List<PrpCaddressDto> getPrpCaddressDtoList() {
        return prpCaddressDtoList;
    }

    public List<PrpCsubsidyDto> getPrpCsubsidyDtoList() {
        return prpCsubsidyDtoList;
    }

    public List<PrpCitemKindDto> getPrpCitemKindDtoList() {
        return prpCitemKindDtoList;
    }

    public List<PrpCengageDto> getPrpCengageDtoList() {
        return prpCengageDtoList;
    }

    public List<PrpCfeildDto> getPrpCfeildDtoList() {
        return prpCfeildDtoList;
    }

    public List<PrpCfeeDto> getPrpCfeeDtoList() {
        return prpCfeeDtoList;
    }

    public List<PrpCplanDto> getPrpCplanDtoList() {
        return prpCplanDtoList;
    }

    public List<PrpCcoinsDto> getPrpCcoinsDtoList() {
        return prpCcoinsDtoList;
    }

    public List<PrpCcoinsDetailDto> getPrpCcoinsDetailDtoList() {
        return prpCcoinsDetailDtoList;
    }

    public List<PrpCplanCoinsDto> getPrpCplanCoinsDtoList() {
        return prpCplanCoinsDtoList;
    }

    public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
        this.prpCmainDto = prpCmainDto;
    }

    public void setPrpCmainAgriDto(PrpCmainAgriDto prpCmainAgriDto) {
        this.prpCmainAgriDto = prpCmainAgriDto;
    }

    public void setPrpCrenewalDto(PrpCrenewalDto prpCrenewalDto) {
        this.prpCrenewalDto = prpCrenewalDto;
    }

    public void setPrpCinsuredDtoList(List<PrpCinsuredDto> prpCinsuredDtoList) {
        this.prpCinsuredDtoList = prpCinsuredDtoList;
    }

    public void setPrpCitemKindAgriDtoList(List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList) {
        this.prpCitemKindAgriDtoList = prpCitemKindAgriDtoList;
    }

    public void setPrpCexpenseDto(PrpCexpenseDto prpCexpenseDto) {
        this.prpCexpenseDto = prpCexpenseDto;
    }

    public void setPrpCaddressDtoList(List<PrpCaddressDto> prpCaddressDtoList) {
        this.prpCaddressDtoList = prpCaddressDtoList;
    }

    public void setPrpCsubsidyDtoList(List<PrpCsubsidyDto> prpCsubsidyDtoList) {
        this.prpCsubsidyDtoList = prpCsubsidyDtoList;
    }

    public void setPrpCitemKindDtoList(List<PrpCitemKindDto> prpCitemKindDtoList) {
        this.prpCitemKindDtoList = prpCitemKindDtoList;
    }

    public void setPrpCengageDtoList(List<PrpCengageDto> prpCengageDtoList) {
        this.prpCengageDtoList = prpCengageDtoList;
    }

    public void setPrpCfeildDtoList(List<PrpCfeildDto> prpCfeildDtoList) {
        this.prpCfeildDtoList = prpCfeildDtoList;
    }

    public void setPrpCfeeDtoList(List<PrpCfeeDto> prpCfeeDtoList) {
        this.prpCfeeDtoList = prpCfeeDtoList;
    }

    public void setPrpCplanDtoList(List<PrpCplanDto> prpCplanDtoList) {
        this.prpCplanDtoList = prpCplanDtoList;
    }

    public void setPrpCcoinsDtoList(List<PrpCcoinsDto> prpCcoinsDtoList) {
        this.prpCcoinsDtoList = prpCcoinsDtoList;
    }

    public void setPrpCcoinsDetailDtoList(List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList) {
        this.prpCcoinsDetailDtoList = prpCcoinsDetailDtoList;
    }

    public void setPrpCplanCoinsDtoList(List<PrpCplanCoinsDto> prpCplanCoinsDtoList) {
        this.prpCplanCoinsDtoList = prpCplanCoinsDtoList;
    }

    public List<PrpDcodeDto> getRiskCodeNameList() {
        return riskCodeNameList;
    }

    public void setRiskCodeNameList(List<PrpDcodeDto> riskCodeNameList) {
        this.riskCodeNameList = riskCodeNameList;
    }

    public List<PrpDcodeDto> getLanguageNameList() {
        return languageNameList;
    }

    public void setLanguageNameList(List<PrpDcodeDto> languageNameList) {
        this.languageNameList = languageNameList;
    }

    public List<PrpDcodeDto> getBusinessNatureNameList() {
        return businessNatureNameList;
    }

    public void setBusinessNatureNameList(List<PrpDcodeDto> businessNatureNameList) {
        this.businessNatureNameList = businessNatureNameList;
    }

    public List<PrpDcodeDto> getPolicySortNameList() {
        return policySortNameList;
    }

    public void setPolicySortNameList(List<PrpDcodeDto> policySortNameList) {
        this.policySortNameList = policySortNameList;
    }

    public List<PrpDcodeDto> getBusinessTypeNameList() {
        return businessTypeNameList;
    }

    public void setBusinessTypeNameList(List<PrpDcodeDto> businessTypeNameList) {
        this.businessTypeNameList = businessTypeNameList;
    }

    public List<PrpDcodeDto> getBusinessTypeNameList1() {
        return businessTypeNameList1;
    }

    public void setBusinessTypeNameList1(List<PrpDcodeDto> businessTypeNameList1) {
        this.businessTypeNameList1 = businessTypeNameList1;
    }

    public List<PrpDcodeDto> getStatUnitCodeNameList() {
        return statUnitCodeNameList;
    }

    public void setStatUnitCodeNameList(List<PrpDcodeDto> statUnitCodeNameList) {
        this.statUnitCodeNameList = statUnitCodeNameList;
    }

    public List<PrpDcodeDto> getArticleTypeNameList() {
        return articleTypeNameList;
    }

    public void setArticleTypeNameList(List<PrpDcodeDto> articleTypeNameList) {
        this.articleTypeNameList = articleTypeNameList;
    }

    public List<PrpDcodeDto> getCattleTypeNameList() {
        return cattleTypeNameList;
    }

    public void setCattleTypeNameList(List<PrpDcodeDto> cattleTypeNameList) {
        this.cattleTypeNameList = cattleTypeNameList;
    }

    public List<PrpDcodeDto> getRaiseTypeNameList() {
        return raiseTypeNameList;
    }

    public void setRaiseTypeNameList(List<PrpDcodeDto> raiseTypeNameList) {
        this.raiseTypeNameList = raiseTypeNameList;
    }

    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoDto() {
        return prpDcustomerTaxPayInfoDto;
    }

    public void setPrpDcustomerTaxPayInfoDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        this.prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoDto;
    }

	public GisInsureMainListDto getGisInsureMainListDto() {
		return gisInsureMainListDto;
	}

	public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
		this.gisInsureMainListDto = gisInsureMainListDto;
	}

    public GisInsureListDto getGisInsureListDto() {
        return gisInsureListDto;
    }

    public void setGisInsureListDto(GisInsureListDto gisInsureListDto) {
        this.gisInsureListDto = gisInsureListDto;
    }
}
