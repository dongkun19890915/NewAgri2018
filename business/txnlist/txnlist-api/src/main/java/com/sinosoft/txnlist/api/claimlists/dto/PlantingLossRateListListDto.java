package com.sinosoft.txnlist.api.claimlists.dto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 06:59:30.161
 * 种植险损失率清单表Api操作对象
 */
public class PlantingLossRateListListDto {
    private List<com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto> plantingLossRateListDto;

    public List<com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto> getPlantingLossRateListDto() {
        return plantingLossRateListDto;
    }

    public void setPlantingLossRateListDto(List<com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto> plantingLossRateListDto) {
        this.plantingLossRateListDto = plantingLossRateListDto;
    }
}
