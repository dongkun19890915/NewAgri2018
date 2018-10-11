package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.util.List;

/**
 * 国元定损清单保存接口入参Dto
 * @author 王心洋
 * @time 2018-01-03
 */
public class RequestGYLossRateAllListDto {
    private static final long serialVersionUID = 1L;

    private LossRateMainListDto lossRateMainListDto;
    private List<LossRateItemListDto> lossRateItemListDtoList;
    private List<LossRateLossListDto> lossRateLossListDtoList;
    private List<LossRateHerdListDto> lossRateHerdListDtoList;
    private List<LossRatePersListDto> lossRatePersListDtoList;

    public LossRateMainListDto getLossRateMainListDto() {
        return lossRateMainListDto;
    }

    public void setLossRateMainListDto(LossRateMainListDto lossRateMainListDto) {
        this.lossRateMainListDto = lossRateMainListDto;
    }

    public List<LossRateItemListDto> getLossRateItemListDtoList() {
        return lossRateItemListDtoList;
    }

    public void setLossRateItemListDtoList(List<LossRateItemListDto> lossRateItemListDtoList) {
        this.lossRateItemListDtoList = lossRateItemListDtoList;
    }

    public List<LossRateLossListDto> getLossRateLossListDtoList() {
        return lossRateLossListDtoList;
    }

    public void setLossRateLossListDtoList(List<LossRateLossListDto> lossRateLossListDtoList) {
        this.lossRateLossListDtoList = lossRateLossListDtoList;
    }

    public List<LossRateHerdListDto> getLossRateHerdListDtoList() {
        return lossRateHerdListDtoList;
    }

    public void setLossRateHerdListDtoList(List<LossRateHerdListDto> lossRateHerdListDtoList) {
        this.lossRateHerdListDtoList = lossRateHerdListDtoList;
    }

    public List<LossRatePersListDto> getLossRatePersListDtoList() {
        return lossRatePersListDtoList;
    }

    public void setLossRatePersListDtoList(List<LossRatePersListDto> lossRatePersListDtoList) {
        this.lossRatePersListDtoList = lossRatePersListDtoList;
    }
}
