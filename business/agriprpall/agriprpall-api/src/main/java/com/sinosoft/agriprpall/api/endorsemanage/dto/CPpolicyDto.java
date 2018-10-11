package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRiskLevelSubDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;

import java.io.Serializable;
import java.util.List;

public class CPpolicyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
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
    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;

    private GisInsureListDto gisInsureListDto;

    private List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList;

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

    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoDto() {
        return prpDcustomerTaxPayInfoDto;
    }

    public void setPrpDcustomerTaxPayInfoDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        this.prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoDto;
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

    public List<PrpCPfeeDto> getPrpCPfeeDtoList() {
        return prpCPfeeDtoList;
    }

    public void setPrpCPfeeDtoList(List<PrpCPfeeDto> prpCPfeeDtoList) {
        this.prpCPfeeDtoList = prpCPfeeDtoList;
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

    public List<PrpCPitemAgriDto> getPrpCPitemAgriDtoList() {
        return prpCPitemAgriDtoList;
    }

    public void setPrpCPitemAgriDtoList(List<PrpCPitemAgriDto> prpCPitemAgriDtoList) {
        this.prpCPitemAgriDtoList = prpCPitemAgriDtoList;
    }

    public PrpCPmainAgriDto getPrpCPmainAgriDto() {
        return prpCPmainAgriDto;
    }

    public void setPrpCPmainAgriDto(PrpCPmainAgriDto prpCPmainAgriDto) {
        this.prpCPmainAgriDto = prpCPmainAgriDto;
    }

    public List<PrpCPplanCoinsDto> getPrpCPplanCoinsDtoList() {
        return prpCPplanCoinsDtoList;
    }

    public void setPrpCPplanCoinsDtoList(List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList) {
        this.prpCPplanCoinsDtoList = prpCPplanCoinsDtoList;
    }

    public List<PrpCPfeildDto> getPrpCPfeildDtoList() {
        return prpCPfeildDtoList;
    }

    public void setPrpCPfeildDtoList(List<PrpCPfeildDto> prpCPfeildDtoList) {
        this.prpCPfeildDtoList = prpCPfeildDtoList;
    }
}
