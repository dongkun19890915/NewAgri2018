package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;

import java.io.Serializable;
import java.util.List;

public class BLPolicyDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**主表 */
    private PrpCmainDto prpCmainDto;
    /**农业险保单信息*/
    private PrpCmainAgriDto prpCmainAgriDto;
    /**续保*/
    private PrpCrenewalDto prpCrenewalDto;
    /**保单费用信息表*/
    private PrpCexpenseDto prpCexpenseDto;
    /**保险人信息表*/
    private List<PrpCinsuredDto> prpCinsuredDtoList;
    /**农业险附加信息表*/
    private List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList;
    /**地址信息表*/
    private List<PrpCaddressDto> prpCaddressDtoList;
    /**政策补贴信息表*/
    private List<PrpCsubsidyDto> prpCsubsidyDtoList;
    /**标的信息表*/
    private List<PrpCitemKindDto> prpCitemKindDtoList;
    /**保单特别约定信息表*/
    private List<PrpCengageDto> prpCengageDtoList;
    /**田块信息表*/
    private List<PrpCfeildDto> prpCfeildDtoList;
    /**保单保额保费信息表*/
    private List<PrpCfeeDto> prpCfeeDtoList;
    /**保单缴费计划信息表*/
    private List<PrpCplanDto> prpCplanDtoList;
    /**共保信息表*/
    private List<PrpCcoinsDto> prpCcoinsDtoList;
    /**共保详细信息表*/
    private List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList;
    /**共保缴费计划*/
    private List<PrpCplanCoinsDto> prpCplanCoinsDtoList;

    private List<HerdPolicyDto> herdPolicyDtoList;

    /**
     * add by 王心洋 2017-11-07
     * 添加缺少的标的信息表数据
     */
    private List<NyxPolicyListDto> nyxPolicyListDtoList;
    private List<PlantingPolicyListDto> plantingPolicyListDtoList;
    private List<Planting31PolicyListDto> planting31PolicyListDtoList;
    private List<HerdPolicyListDto> herdPolicyListDtoList;

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

    public List<PlantingPolicyListDto> getPlantingPolicyListDtoList() {
        return plantingPolicyListDtoList;
    }

    public void setPlantingPolicyListDtoList(List<PlantingPolicyListDto> plantingPolicyListDtoList) {
        this.plantingPolicyListDtoList = plantingPolicyListDtoList;
    }

    public List<Planting31PolicyListDto> getPlanting31PolicyListDtoList() {
        return planting31PolicyListDtoList;
    }

    public void setPlanting31PolicyListDtoList(List<Planting31PolicyListDto> planting31PolicyListDtoList) {
        this.planting31PolicyListDtoList = planting31PolicyListDtoList;
    }

    public List<HerdPolicyDto> getHerdPolicyDtoList() {
        return herdPolicyDtoList;
    }

    public void setHerdPolicyDtoList(List<HerdPolicyDto> herdPolicyDtoList) {
        this.herdPolicyDtoList = herdPolicyDtoList;
    }

    public PrpCmainDto getPrpCmainDto() {
        return prpCmainDto;
    }

    public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
        this.prpCmainDto = prpCmainDto;
    }

    public PrpCmainAgriDto getPrpCmainAgriDto() {
        return prpCmainAgriDto;
    }

    public void setPrpCmainAgriDto(PrpCmainAgriDto prpCmainAgriDto) {
        this.prpCmainAgriDto = prpCmainAgriDto;
    }

    public PrpCrenewalDto getPrpCrenewalDto() {
        return prpCrenewalDto;
    }

    public void setPrpCrenewalDto(PrpCrenewalDto prpCrenewalDto) {
        this.prpCrenewalDto = prpCrenewalDto;
    }

    public PrpCexpenseDto getPrpCexpenseDto() {
        return prpCexpenseDto;
    }

    public void setPrpCexpenseDto(PrpCexpenseDto prpCexpenseDto) {
        this.prpCexpenseDto = prpCexpenseDto;
    }

    public List<PrpCinsuredDto> getPrpCinsuredDtoList() {
        return prpCinsuredDtoList;
    }

    public void setPrpCinsuredDtoList(List<PrpCinsuredDto> prpCinsuredDtoList) {
        this.prpCinsuredDtoList = prpCinsuredDtoList;
    }

    public List<PrpCitemKindAgriDto> getPrpCitemKindAgriDtoList() {
        return prpCitemKindAgriDtoList;
    }

    public void setPrpCitemKindAgriDtoList(List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList) {
        this.prpCitemKindAgriDtoList = prpCitemKindAgriDtoList;
    }

    public List<PrpCaddressDto> getPrpCaddressDtoList() {
        return prpCaddressDtoList;
    }

    public void setPrpCaddressDtoList(List<PrpCaddressDto> prpCaddressDtoList) {
        this.prpCaddressDtoList = prpCaddressDtoList;
    }

    public List<PrpCsubsidyDto> getPrpCsubsidyDtoList() {
        return prpCsubsidyDtoList;
    }

    public void setPrpCsubsidyDtoList(List<PrpCsubsidyDto> prpCsubsidyDtoList) {
        this.prpCsubsidyDtoList = prpCsubsidyDtoList;
    }

    public List<PrpCitemKindDto> getPrpCitemKindDtoList() {
        return prpCitemKindDtoList;
    }

    public void setPrpCitemKindDtoList(List<PrpCitemKindDto> prpCitemKindDtoList) {
        this.prpCitemKindDtoList = prpCitemKindDtoList;
    }

    public List<PrpCengageDto> getPrpCengageDtoList() {
        return prpCengageDtoList;
    }

    public void setPrpCengageDtoList(List<PrpCengageDto> prpCengageDtoList) {
        this.prpCengageDtoList = prpCengageDtoList;
    }

    public List<PrpCfeildDto> getPrpCfeildDtoList() {
        return prpCfeildDtoList;
    }

    public void setPrpCfeildDtoList(List<PrpCfeildDto> prpCfeildDtoList) {
        this.prpCfeildDtoList = prpCfeildDtoList;
    }

    public List<PrpCfeeDto> getPrpCfeeDtoList() {
        return prpCfeeDtoList;
    }

    public void setPrpCfeeDtoList(List<PrpCfeeDto> prpCfeeDtoList) {
        this.prpCfeeDtoList = prpCfeeDtoList;
    }

    public List<PrpCplanDto> getPrpCplanDtoList() {
        return prpCplanDtoList;
    }

    public void setPrpCplanDtoList(List<PrpCplanDto> prpCplanDtoList) {
        this.prpCplanDtoList = prpCplanDtoList;
    }

    public List<PrpCcoinsDto> getPrpCcoinsDtoList() {
        return prpCcoinsDtoList;
    }

    public void setPrpCcoinsDtoList(List<PrpCcoinsDto> prpCcoinsDtoList) {
        this.prpCcoinsDtoList = prpCcoinsDtoList;
    }

    public List<PrpCcoinsDetailDto> getPrpCcoinsDetailDtoList() {
        return prpCcoinsDetailDtoList;
    }

    public void setPrpCcoinsDetailDtoList(List<PrpCcoinsDetailDto> prpCcoinsDetailDtoList) {
        this.prpCcoinsDetailDtoList = prpCcoinsDetailDtoList;
    }

    public List<PrpCplanCoinsDto> getPrpCplanCoinsDtoList() {
        return prpCplanCoinsDtoList;
    }

    public void setPrpCplanCoinsDtoList(List<PrpCplanCoinsDto> prpCplanCoinsDtoList) {
        this.prpCplanCoinsDtoList = prpCplanCoinsDtoList;
    }
}
