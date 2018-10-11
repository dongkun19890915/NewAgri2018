package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-31 10:05
 */
public class FarmerRequestDto extends GisFarmerListDto{
    private List<GisFieldListDto> plantingFieldList;
    private List<FarmerItemRequestDto> farmerItemList;


    public List<GisFieldListDto> getPlantingFieldList() {
        return plantingFieldList;
    }

    public void setPlantingFieldList(List<GisFieldListDto> plantingFieldList) {
        this.plantingFieldList = plantingFieldList;
    }

    public List<FarmerItemRequestDto> getFarmerItemList() {
        return farmerItemList;
    }

    public void setFarmerItemList(List<FarmerItemRequestDto> farmerItemList) {
        this.farmerItemList = farmerItemList;
    }
}
