package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;

import java.io.Serializable;
import java.util.List;

public class BLEndorseDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;


    /**P表的*/
    /**特约信息表   */
    private List<PrpPengageDto> prpPengageDtoList;
    private List<PrpPengageCopyDto> prpPengageCopyDtoList;
    /**地址信息表*/
    private List<PrpPaddressDto> prpPaddressDtoList;
    private List<PrpPaddressCopyDto> prpPaddressCopyDtoList;
    /**共保信息表*/
    private List<PrpPcoinsDto> prpPcoinsDtoList;
    private List<PrpPcoinsCopyDto> prpPcoinsCopyDtoList;
    /**保单费用信息表*/
    private PrpPexpenseDto prpPexpenseDto;
    private PrpPexpenseCopyDto prpPexpenseCopyDto;
    /**保额保费信息表*/
    private List<PrpPfeeDto> prpPfeeDtoList;
    private List<PrpPfeeCopyDto> prpPfeeCopyDtoList;
    /**批单表头信息表*/
    private PrpPheadDto prpPheadDto;
    /**保险人信息表*/
    private List<PrpPinsuredDto> prpPinsuredDtoList;
    private List<PrpPinsuredCopyDto> prpPinsuredCopyDtoList;
    /**农业险附加信息表*/
    private List<PrpPitemKindAgriDto> prpPitemKindAgriDtoList;
    private List<PrpPitemKindAgriCopyDto> prpPitemKindAgriCopyDtoList;
    /**标的信息表*/
    private List<PrpPitemKindDto> prpPitemKindDtoList;
    private List<PrpPitemKindCopyDto> prpPitemKindCopyDtoList;
    /**主表*/
    private PrpPmainDto prpPmainDto;
    private PrpPmainCopyDto prpPmainCopyDto;
    /**缴费计划信息表*/
    private List<PrpPplanDto> prpPplanDtoList;
    private List<PrpPplanCopyDto> prpPplanCopyDtoList;
    /**政策补贴信息表*/
    private List<PrpPsubsidyDto> prpPsubsidyDtoList;
    private List<PrpPsubsidyCopyDto> prpPsubsidyCopyDtoList;
    /**共保详细信息表*/
    private List<PrpPcoinsDetailDto> prpPcoinsDetailDtoList;
    private List<PrpPcoinsDetailCopyDto> prpPcoinsDetailCopyDtoList;
    /**农业险保单信息*/
    private PrpPmainAgriDto prpPmainAgriDto;
    private PrpPmainAgriCopyDto prpPmainAgriCopyDto;
    /**收费计划表*/
    private List<PrpPplanCoinsDto> prpPplanCoinsDtoList;
    private List<PrpPplanCoinsCopyDto> prpPplanCoinsCopyDtoList;

    private List<PrpPfeildDto> prpPfeildDtoList;
    private List<PrpPfeildCopyDto> prpPfeildCopyDtoList;
    /**CP表的*/
    /**保单特别约定信息表*/
    private List<PrpCPengageDto> prpCPengageDtoList;
    /**地址信息表*/
    private List<PrpCPaddressDto> prpCPaddressDtoList;
    /**共保信息表*/
    private List<PrpCPcoinsDto> prpCPcoinsDtoList;
    /**保单费用信息表*/
    private PrpCPexpenseDto prpCPexpenseDto;
    /**保单保额保费信息表*/
    private List<PrpCPfeeDto> prpCPfeeDtoList;
    /**农业险附加信息表*/
    private List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList;
    /**标的信息表*/
    private List<PrpCPitemKindDto> prpCPitemKindDtoList;
    /**主表*/
    private PrpCPmainDto prpCPmainDto;
    /**保单缴费计划信息表*/
    private List<PrpCPplanDto> prpCPplanDtoList;
    /**保单政府补贴信息表*/
    private List<PrpCPsubsidyDto> prpCPsubsidyDtoList;
    /**保单客户资料信息表*/
    private List<PrpCPinsuredDto> prpCPinsuredDtoList;
    /**共保详细信息表*/
    private List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList;
    /**客户风险等级字表*/
    private List<PrpDcustomerRiskLevelSubDto> prpDcustomerRiskLevelSubAgriDtoList;
    private List<PrpCPitemAgriDto> prpCPitemAgriDtoList;
    /**农业险保单信息*/
    private PrpCPmainAgriDto prpCPmainAgriDto;
    /**收费计划表*/
    private List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList;

    private List<PrpCPfeildDto>    prpCPfeildDtoList;

    private List<HerdEndorChgDetailDto> herdEndorChgDetailListDtoList;

    private List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList;

    private List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList;

    private List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList;

    private HerdEndorHeadDto herdEndorHeadDto;

    private PlantingEndorHeadDto plantingEndorHeadDto;

    private List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList;

    private List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList;

    private NyxEndorHeadDto nyxEndorHeadDto;

    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;
    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoCopyDto;

    private PrpDcustomerDto prpDcustomerDto;

    private PrpDcustomerIdvDto prpDcustomerIdvDto;

    private PrpDcustomerUnitDto prpDcustomerUnitDto;

    private GisInsureListDto gisInsureListDto;

    private List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList;
    private List<QueryProposalPrpTengageDto> queryProposalPrpTengageCopyDtoList;
    /**批单表头信息表*/
    private PrpPheadCopyDto PrpPheadCopyDto;

    public List<NyxCpEndorChgDetailDto> getNyxCpEndorChgDetailDtoList() {
        return nyxCpEndorChgDetailDtoList;
    }

    public void setNyxCpEndorChgDetailDtoList(List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList) {
        this.nyxCpEndorChgDetailDtoList = nyxCpEndorChgDetailDtoList;
    }

    public List<HerdcEndorChgDetailDto> getHerdcEndorChgDetailDtoList() {
        return herdcEndorChgDetailDtoList;
    }

    public void setHerdcEndorChgDetailDtoList(List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList) {
        this.herdcEndorChgDetailDtoList = herdcEndorChgDetailDtoList;
    }

    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoCopyDto() {
        return prpDcustomerTaxPayInfoCopyDto;
    }

    public void setPrpDcustomerTaxPayInfoCopyDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoCopyDto) {
        this.prpDcustomerTaxPayInfoCopyDto = prpDcustomerTaxPayInfoCopyDto;
    }

    public List<QueryProposalPrpTengageDto> getQueryProposalPrpTengageCopyDtoList() {
        return queryProposalPrpTengageCopyDtoList;
    }

    public void setQueryProposalPrpTengageCopyDtoList(List<QueryProposalPrpTengageDto> queryProposalPrpTengageCopyDtoList) {
        this.queryProposalPrpTengageCopyDtoList = queryProposalPrpTengageCopyDtoList;
    }

    public List<PrpPengageCopyDto> getPrpPengageCopyDtoList() {
        return prpPengageCopyDtoList;
    }

    public void setPrpPengageCopyDtoList(List<PrpPengageCopyDto> prpPengageCopyDtoList) {
        this.prpPengageCopyDtoList = prpPengageCopyDtoList;
    }

    public List<PrpPcoinsCopyDto> getPrpPcoinsCopyDtoList() {
        return prpPcoinsCopyDtoList;
    }

    public void setPrpPcoinsCopyDtoList(List<PrpPcoinsCopyDto> prpPcoinsCopyDtoList) {
        this.prpPcoinsCopyDtoList = prpPcoinsCopyDtoList;
    }

    public PrpPexpenseCopyDto getPrpPexpenseCopyDto() {
        return prpPexpenseCopyDto;
    }

    public void setPrpPexpenseCopyDto(PrpPexpenseCopyDto prpPexpenseCopyDto) {
        this.prpPexpenseCopyDto = prpPexpenseCopyDto;
    }

    public List<PrpPfeeCopyDto> getPrpPfeeCopyDtoList() {
        return prpPfeeCopyDtoList;
    }

    public void setPrpPfeeCopyDtoList(List<PrpPfeeCopyDto> prpPfeeCopyDtoList) {
        this.prpPfeeCopyDtoList = prpPfeeCopyDtoList;
    }

    public List<PrpPinsuredCopyDto> getPrpPinsuredCopyDtoList() {
        return prpPinsuredCopyDtoList;
    }

    public void setPrpPinsuredCopyDtoList(List<PrpPinsuredCopyDto> prpPinsuredCopyDtoList) {
        this.prpPinsuredCopyDtoList = prpPinsuredCopyDtoList;
    }

    public List<PrpPitemKindAgriCopyDto> getPrpPitemKindAgriCopyDtoList() {
        return prpPitemKindAgriCopyDtoList;
    }

    public void setPrpPitemKindAgriCopyDtoList(List<PrpPitemKindAgriCopyDto> prpPitemKindAgriCopyDtoList) {
        this.prpPitemKindAgriCopyDtoList = prpPitemKindAgriCopyDtoList;
    }

    public List<PrpPitemKindCopyDto> getPrpPitemKindCopyDtoList() {
        return prpPitemKindCopyDtoList;
    }

    public void setPrpPitemKindCopyDtoList(List<PrpPitemKindCopyDto> prpPitemKindCopyDtoList) {
        this.prpPitemKindCopyDtoList = prpPitemKindCopyDtoList;
    }

    public PrpPmainCopyDto getPrpPmainCopyDto() {
        return prpPmainCopyDto;
    }

    public void setPrpPmainCopyDto(PrpPmainCopyDto prpPmainCopyDto) {
        this.prpPmainCopyDto = prpPmainCopyDto;
    }

    public List<PrpPplanCopyDto> getPrpPplanCopyDtoList() {
        return prpPplanCopyDtoList;
    }

    public void setPrpPplanCopyDtoList(List<PrpPplanCopyDto> prpPplanCopyDtoList) {
        this.prpPplanCopyDtoList = prpPplanCopyDtoList;
    }

    public List<PrpPsubsidyCopyDto> getPrpPsubsidyCopyDtoList() {
        return prpPsubsidyCopyDtoList;
    }

    public void setPrpPsubsidyCopyDtoList(List<PrpPsubsidyCopyDto> prpPsubsidyCopyDtoList) {
        this.prpPsubsidyCopyDtoList = prpPsubsidyCopyDtoList;
    }

    public List<PrpPcoinsDetailCopyDto> getPrpPcoinsDetailCopyDtoList() {
        return prpPcoinsDetailCopyDtoList;
    }

    public void setPrpPcoinsDetailCopyDtoList(List<PrpPcoinsDetailCopyDto> prpPcoinsDetailCopyDtoList) {
        this.prpPcoinsDetailCopyDtoList = prpPcoinsDetailCopyDtoList;
    }

    public PrpPmainAgriCopyDto getPrpPmainAgriCopyDto() {
        return prpPmainAgriCopyDto;
    }

    public void setPrpPmainAgriCopyDto(PrpPmainAgriCopyDto prpPmainAgriCopyDto) {
        this.prpPmainAgriCopyDto = prpPmainAgriCopyDto;
    }

    public List<PrpPplanCoinsCopyDto> getPrpPplanCoinsCopyDtoList() {
        return prpPplanCoinsCopyDtoList;
    }

    public void setPrpPplanCoinsCopyDtoList(List<PrpPplanCoinsCopyDto> prpPplanCoinsCopyDtoList) {
        this.prpPplanCoinsCopyDtoList = prpPplanCoinsCopyDtoList;
    }

    public List<PrpPfeildCopyDto> getPrpPfeildCopyDtoList() {
        return prpPfeildCopyDtoList;
    }

    public void setPrpPfeildCopyDtoList(List<PrpPfeildCopyDto> prpPfeildCopyDtoList) {
        this.prpPfeildCopyDtoList = prpPfeildCopyDtoList;
    }

    public List<PrpPaddressCopyDto> getPrpPaddressCopyDtoList() {
        return prpPaddressCopyDtoList;
    }

    public void setPrpPaddressCopyDtoList(List<PrpPaddressCopyDto> prpPaddressCopyDtoList) {
        this.prpPaddressCopyDtoList = prpPaddressCopyDtoList;
    }

    public com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadCopyDto getPrpPheadCopyDto() {
        return PrpPheadCopyDto;
    }

    public void setPrpPheadCopyDto(com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadCopyDto prpPheadCopyDto) {
        PrpPheadCopyDto = prpPheadCopyDto;
    }

    public List<QueryProposalPrpTengageDto> getQueryProposalPrpTengageDtoList() {
        return queryProposalPrpTengageDtoList;
    }

    public void setQueryProposalPrpTengageDtoList(List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList) {
        this.queryProposalPrpTengageDtoList = queryProposalPrpTengageDtoList;
    }

    public GisInsureListDto getGisInsureListDto() {
        return gisInsureListDto;
    }

    public void setGisInsureListDto(GisInsureListDto gisInsureListDto) {
        this.gisInsureListDto = gisInsureListDto;
    }


    //
//    /**农险库*/
//    /**农险批单头信息*/
//    private HerdEndorHeadDto herdEndorHeadDto;
//    /**农险批单头信息*/
//    private HouseEndorHeadDto houseEndorHeadDto;
//    private NyxEndorHeadDto nyxEndorHeadDto;
//    private PlantingEndorHeadDto plantingEndorHeadDto;


    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoDto() {
        return prpDcustomerTaxPayInfoDto;
    }

    public void setPrpDcustomerTaxPayInfoDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        this.prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoDto;
    }

    public PrpDcustomerDto getPrpDcustomerDto() {
        return prpDcustomerDto;
    }

    public void setPrpDcustomerDto(PrpDcustomerDto prpDcustomerDto) {
        this.prpDcustomerDto = prpDcustomerDto;
    }

    public PrpDcustomerIdvDto getPrpDcustomerIdvDto() {
        return prpDcustomerIdvDto;
    }

    public void setPrpDcustomerIdvDto(PrpDcustomerIdvDto prpDcustomerIdvDto) {
        this.prpDcustomerIdvDto = prpDcustomerIdvDto;
    }

    public PrpDcustomerUnitDto getPrpDcustomerUnitDto() {
        return prpDcustomerUnitDto;
    }

    public void setPrpDcustomerUnitDto(PrpDcustomerUnitDto prpDcustomerUnitDto) {
        this.prpDcustomerUnitDto = prpDcustomerUnitDto;
    }

    private List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList;

    private List<PlantingEndorHeadDto> plantingEndorHeadDtoList;

    private List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList;

    public List<PlantingCpEndorChgDetailDto> getPlantingCpEndorChgDetailDtoList() {
        return plantingCpEndorChgDetailDtoList;
    }

    public void setPlantingCpEndorChgDetailDtoList(List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList) {
        this.plantingCpEndorChgDetailDtoList = plantingCpEndorChgDetailDtoList;
    }

    public List<PlantingEndorHeadDto> getPlantingEndorHeadDtoList() {
        return plantingEndorHeadDtoList;
    }

    public void setPlantingEndorHeadDtoList(List<PlantingEndorHeadDto> plantingEndorHeadDtoList) {
        this.plantingEndorHeadDtoList = plantingEndorHeadDtoList;
    }

    public List<Planting31CpEndorChgDetailDto> getPlanting31CpEndorChgDetailDtoList() {
        return planting31CpEndorChgDetailDtoList;
    }

    public void setPlanting31CpEndorChgDetailDtoList(List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList) {
        this.planting31CpEndorChgDetailDtoList = planting31CpEndorChgDetailDtoList;
    }

    public NyxEndorHeadDto getNyxEndorHeadDto() {
        return nyxEndorHeadDto;
    }

    public void setNyxEndorHeadDto(NyxEndorHeadDto nyxEndorHeadDto) {
        this.nyxEndorHeadDto = nyxEndorHeadDto;
    }

    private EndorseConditionDto endorseConditionDto;
    private List<PrpPtextDto> prpPtextDtoList;

    public List<NyxEndorChgDetailDto> getNyxEndorChgDetailDtoList() {
        return nyxEndorChgDetailDtoList;
    }

    public void setNyxEndorChgDetailDtoList(List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList) {
        this.nyxEndorChgDetailDtoList = nyxEndorChgDetailDtoList;
    }

    public List<Planting31EndorChgDetailDto> getPlanting31EndorChgDetailDtoList() {
        return planting31EndorChgDetailDtoList;
    }

    public void setPlanting31EndorChgDetailDtoList(List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList) {
        this.planting31EndorChgDetailDtoList = planting31EndorChgDetailDtoList;
    }

    public HerdEndorHeadDto getHerdEndorHeadDto() {
        return herdEndorHeadDto;
    }

    public void setHerdEndorHeadDto(HerdEndorHeadDto herdEndorHeadDto) {
        this.herdEndorHeadDto = herdEndorHeadDto;
    }

    public PlantingEndorHeadDto getPlantingEndorHeadDto() {
        return plantingEndorHeadDto;
    }

    public void setPlantingEndorHeadDto(PlantingEndorHeadDto plantingEndorHeadDto) {
        this.plantingEndorHeadDto = plantingEndorHeadDto;
    }

    public List<HerdEndorChgDetailDto> getHerdEndorChgDetailListDtoList() {
        return herdEndorChgDetailListDtoList;
    }

    public void setHerdEndorChgDetailListDtoList(List<HerdEndorChgDetailDto> herdEndorChgDetailListDtoList) {
        this.herdEndorChgDetailListDtoList = herdEndorChgDetailListDtoList;
    }

    public List<PlantingEndorChgDetailDto> getPlantingEndorChgDetailDtoList() {
        return plantingEndorChgDetailDtoList;
    }

    public void setPlantingEndorChgDetailDtoList(List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList) {
        this.plantingEndorChgDetailDtoList = plantingEndorChgDetailDtoList;
    }

    public List<PrpPtextDto> getPrpPtextDtoList() {
        return prpPtextDtoList;
    }

    public void setPrpPtextDtoList(List<PrpPtextDto> prpPtextDtoList) {
        this.prpPtextDtoList = prpPtextDtoList;
    }

    public List<PrpPfeildDto> getPrpPfeildDtoList() {
        return prpPfeildDtoList;
    }

    public void setPrpPfeildDtoList(List<PrpPfeildDto> prpPfeildDtoList) {
        this.prpPfeildDtoList = prpPfeildDtoList;
    }

    public List<PrpCPfeildDto> getPrpCPfeildDtoList() {
        return prpCPfeildDtoList;
    }

    public void setPrpCPfeildDtoList(List<PrpCPfeildDto> prpCPfeildDtoList) {
        this.prpCPfeildDtoList = prpCPfeildDtoList;
    }

    public List<PrpCPplanCoinsDto> getPrpCPplanCoinsDtoList() {
        return prpCPplanCoinsDtoList;
    }

    public void setPrpCPplanCoinsDtoList(List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList) {
        this.prpCPplanCoinsDtoList = prpCPplanCoinsDtoList;
    }

    public List<PrpPplanCoinsDto> getPrpPplanCoinsDtoList() {
        return prpPplanCoinsDtoList;
    }

    public void setPrpPplanCoinsDtoList(List<PrpPplanCoinsDto> prpPplanCoinsDtoList) {
        this.prpPplanCoinsDtoList = prpPplanCoinsDtoList;
    }

    public List<PrpCPfeeDto> getPrpCPfeeDtoList() {
        return prpCPfeeDtoList;
    }

    public void setPrpCPfeeDtoList(List<PrpCPfeeDto> prpCPfeeDtoList) {
        this.prpCPfeeDtoList = prpCPfeeDtoList;
    }

    public List<PrpPfeeDto> getPrpPfeeDtoList() {
        return prpPfeeDtoList;
    }

    public void setPrpPfeeDtoList(List<PrpPfeeDto> prpPfeeDtoList) {
        this.prpPfeeDtoList = prpPfeeDtoList;
    }

    public void setPrpPcoinsDetailDtoList(List<PrpPcoinsDetailDto> prpPcoinsDetailDtoList) {
        this.prpPcoinsDetailDtoList = prpPcoinsDetailDtoList;
    }

    public EndorseConditionDto getEndorseConditionDto() {
        return endorseConditionDto;
    }

    public void setEndorseConditionDto(EndorseConditionDto endorseConditionDto) {
        this.endorseConditionDto = endorseConditionDto;
    }

    public PrpPmainAgriDto getPrpPmainAgriDto() {
        return prpPmainAgriDto;
    }

    public void setPrpPmainAgriDto(PrpPmainAgriDto prpPmainAgriDto) {
        this.prpPmainAgriDto = prpPmainAgriDto;
    }

    public PrpCPmainAgriDto getPrpCPmainAgriDto() {
        return prpCPmainAgriDto;
    }

    public void setPrpCPmainAgriDto(PrpCPmainAgriDto prpCPmainAgriDto) {
        this.prpCPmainAgriDto = prpCPmainAgriDto;
    }

    public List<PrpCPitemAgriDto> getPrpCPitemAgriDtoList() {
        return prpCPitemAgriDtoList;
    }

    public void setPrpCPitemAgriDtoList(List<PrpCPitemAgriDto> prpCPitemAgriDtoList) {
        this.prpCPitemAgriDtoList = prpCPitemAgriDtoList;
    }

    public List<PrpPengageDto> getPrpPengageDtoList() {
        return prpPengageDtoList;
    }

    public void setPrpPengageDtoList(List<PrpPengageDto> prpPengageDtoList) {
        this.prpPengageDtoList = prpPengageDtoList;
    }

    public List<PrpPaddressDto> getPrpPaddressDtoList() {
        return prpPaddressDtoList;
    }

    public void setPrpPaddressDtoList(List<PrpPaddressDto> prpPaddressDtoList) {
        this.prpPaddressDtoList = prpPaddressDtoList;
    }

    public List<PrpPcoinsDto> getPrpPcoinsDtoList() {
        return prpPcoinsDtoList;
    }

    public void setPrpPcoinsDtoList(List<PrpPcoinsDto> prpPcoinsDtoList) {
        this.prpPcoinsDtoList = prpPcoinsDtoList;
    }

    public PrpPexpenseDto getPrpPexpenseDto() {
        return prpPexpenseDto;
    }

    public void setPrpPexpenseDto(PrpPexpenseDto prpPexpenseDto) {
        this.prpPexpenseDto = prpPexpenseDto;
    }

    public PrpPheadDto getPrpPheadDto() {
        return prpPheadDto;
    }

    public void setPrpPheadDto(PrpPheadDto prpPheadDto) {
        this.prpPheadDto = prpPheadDto;
    }

    public List<PrpPinsuredDto> getPrpPinsuredDtoList() {
        return prpPinsuredDtoList;
    }

    public void setPrpPinsuredDtoList(List<PrpPinsuredDto> prpPinsuredDtoList) {
        this.prpPinsuredDtoList = prpPinsuredDtoList;
    }

    public List<PrpPitemKindAgriDto> getPrpPitemKindAgriDtoList() {
        return prpPitemKindAgriDtoList;
    }

    public void setPrpPitemKindAgriDtoList(List<PrpPitemKindAgriDto> prpPitemKindAgriDtoList) {
        this.prpPitemKindAgriDtoList = prpPitemKindAgriDtoList;
    }

    public List<PrpPitemKindDto> getPrpPitemKindDtoList() {
        return prpPitemKindDtoList;
    }

    public void setPrpPitemKindDtoList(List<PrpPitemKindDto> prpPitemKindDtoList) {
        this.prpPitemKindDtoList = prpPitemKindDtoList;
    }

    public PrpPmainDto getPrpPmainDto() {
        return prpPmainDto;
    }

    public void setPrpPmainDto(PrpPmainDto prpPmainDto) {
        this.prpPmainDto = prpPmainDto;
    }

    public List<PrpPplanDto> getPrpPplanDtoList() {
        return prpPplanDtoList;
    }

    public void setPrpPplanDtoList(List<PrpPplanDto> prpPplanDtoList) {
        this.prpPplanDtoList = prpPplanDtoList;
    }

    public List<PrpPsubsidyDto> getPrpPsubsidyDtoList() {
        return prpPsubsidyDtoList;
    }

    public void setPrpPsubsidyDtoList(List<PrpPsubsidyDto> prpPsubsidyDtoList) {
        this.prpPsubsidyDtoList = prpPsubsidyDtoList;
    }

    public List<PrpPcoinsDetailDto> getPrpPcoinsDetailDtoList() {
        return prpPcoinsDetailDtoList;
    }

    public void setPrpPCoinsDetailDtoList(List<PrpPcoinsDetailDto> prpPcoinsDetailDtoList) {
        this.prpPcoinsDetailDtoList = prpPcoinsDetailDtoList;
    }

    public List<PrpCPengageDto> getPrpCPengageDtoList() {
        return prpCPengageDtoList;
    }

    public void setPrpCPengageDtoList(List<PrpCPengageDto> prpCPengageDtoList) {
        this.prpCPengageDtoList = prpCPengageDtoList;
    }

    public List<PrpCPaddressDto> getPrpCPaddressDtoList() {
        return prpCPaddressDtoList;
    }

    public void setPrpCPaddressDtoList(List<PrpCPaddressDto> prpCPaddressDtoList) {
        this.prpCPaddressDtoList = prpCPaddressDtoList;
    }

    public List<PrpCPcoinsDto> getPrpCPcoinsDtoList() {
        return prpCPcoinsDtoList;
    }

    public void setPrpCPcoinsDtoList(List<PrpCPcoinsDto> prpCPcoinsDtoList) {
        this.prpCPcoinsDtoList = prpCPcoinsDtoList;
    }

    public PrpCPexpenseDto getPrpCPexpenseDto() {
        return prpCPexpenseDto;
    }

    public void setPrpCPexpenseDto(PrpCPexpenseDto prpCPexpenseDto) {
        this.prpCPexpenseDto = prpCPexpenseDto;
    }

    public List<PrpCPitemKindAgriDto> getPrpCPitemKindAgriDtoList() {
        return prpCPitemKindAgriDtoList;
    }

    public void setPrpCPitemKindAgriDtoList(List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList) {
        this.prpCPitemKindAgriDtoList = prpCPitemKindAgriDtoList;
    }

    public List<PrpCPitemKindDto> getPrpCPitemKindDtoList() {
        return prpCPitemKindDtoList;
    }

    public void setPrpCPitemKindDtoList(List<PrpCPitemKindDto> prpCPitemKindDtoList) {
        this.prpCPitemKindDtoList = prpCPitemKindDtoList;
    }

    public PrpCPmainDto getPrpCPmainDto() {
        return prpCPmainDto;
    }

    public void setPrpCPmainDto(PrpCPmainDto prpCPmainDto) {
        this.prpCPmainDto = prpCPmainDto;
    }

    public List<PrpCPplanDto> getPrpCPplanDtoList() {
        return prpCPplanDtoList;
    }

    public void setPrpCPplanDtoList(List<PrpCPplanDto> prpCPplanDtoList) {
        this.prpCPplanDtoList = prpCPplanDtoList;
    }

    public List<PrpCPsubsidyDto> getPrpCPsubsidyDtoList() {
        return prpCPsubsidyDtoList;
    }

    public void setPrpCPsubsidyDtoList(List<PrpCPsubsidyDto> prpCPsubsidyDtoList) {
        this.prpCPsubsidyDtoList = prpCPsubsidyDtoList;
    }

    public List<PrpCPinsuredDto> getPrpCPinsuredDtoList() {
        return prpCPinsuredDtoList;
    }

    public void setPrpCPinsuredDtoList(List<PrpCPinsuredDto> prpCPinsuredDtoList) {
        this.prpCPinsuredDtoList = prpCPinsuredDtoList;
    }

    public List<PrpCPcoinsDetailDto> getPrpCPcoinsDetailDtoList() {
        return prpCPcoinsDetailDtoList;
    }

    public void setPrpCPcoinsDetailDtoList(List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList) {
        this.prpCPcoinsDetailDtoList = prpCPcoinsDetailDtoList;
    }

    public List<PrpDcustomerRiskLevelSubDto> getPrpDcustomerRiskLevelSubAgriDtoList() {
        return prpDcustomerRiskLevelSubAgriDtoList;
    }

    public void setPrpDcustomerRiskLevelSubAgriDtoList(List<PrpDcustomerRiskLevelSubDto> prpDcustomerRiskLevelSubAgriDtoList) {
        this.prpDcustomerRiskLevelSubAgriDtoList = prpDcustomerRiskLevelSubAgriDtoList;
    }
//
//    public HerdEndorHeadDto getHerdEndorHeadDto() {
//        return herdEndorHeadDto;
//    }
//
//    public void setHerdEndorHeadDto(HerdEndorHeadDto herdEndorHeadDto) {
//        this.herdEndorHeadDto = herdEndorHeadDto;
//    }
//
//    public HouseEndorHeadDto getHouseEndorHeadDto() {
//        return houseEndorHeadDto;
//    }
//
//    public void setHouseEndorHeadDto(HouseEndorHeadDto houseEndorHeadDto) {
//        this.houseEndorHeadDto = houseEndorHeadDto;
//    }
//
//    public NyxEndorHeadDto getNyxEndorHeadDto() {
//        return nyxEndorHeadDto;
//    }
//
//    public void setNyxEndorHeadDto(NyxEndorHeadDto nyxEndorHeadDto) {
//        this.nyxEndorHeadDto = nyxEndorHeadDto;
//    }
//
//    public PlantingEndorHeadDto getPlantingEndorHeadDto() {
//        return plantingEndorHeadDto;
//    }
//
//    public void setPlantingEndorHeadDto(PlantingEndorHeadDto plantingEndorHeadDto) {
//        this.plantingEndorHeadDto = plantingEndorHeadDto;
//    }
}
