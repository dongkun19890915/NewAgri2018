package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.util.List;

/**
 * 金禾调用定损清单保存接口入参Dto
 * @author 王心洋
 * @time 2018-01-03
 */
public class RequestSaveLossRateListDto {

    private static final long serialVersionUID = 1L;

    private LossRateListDto lossRateListDto;
    private List<PlantingLossRateListDto> plantingLossRateListDtoList;
    private List<BreedLossRateListDto> breedLossRateListDtoList;

    public LossRateListDto getLossRateListDto() {
        return lossRateListDto;
    }

    public void setLossRateListDto(LossRateListDto lossRateListDto) {
        this.lossRateListDto = lossRateListDto;
    }

    public List<PlantingLossRateListDto> getPlantingLossRateListDtoList() {
        return plantingLossRateListDtoList;
    }

    public void setPlantingLossRateListDtoList(List<PlantingLossRateListDto> plantingLossRateListDtoList) {
        this.plantingLossRateListDtoList = plantingLossRateListDtoList;
    }

    public List<BreedLossRateListDto> getBreedLossRateListDtoList() {
        return breedLossRateListDtoList;
    }

    public void setBreedLossRateListDtoList(List<BreedLossRateListDto> breedLossRateListDtoList) {
        this.breedLossRateListDtoList = breedLossRateListDtoList;
    }
}
