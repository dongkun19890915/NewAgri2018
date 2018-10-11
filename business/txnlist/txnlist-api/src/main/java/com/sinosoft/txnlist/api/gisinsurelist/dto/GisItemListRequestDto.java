package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-30 15:57
 */
public class GisItemListRequestDto extends  GisInsureMainListDto{

    //清单标的信息
    private List<GisItemListDto>  itemList;
//
    private List<FarmerRequestDto> farmerList;

    public List<GisItemListDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<GisItemListDto> itemList) {
        this.itemList = itemList;
    }

    public List<FarmerRequestDto> getFarmerList() {
        return farmerList;
    }

    public void setFarmerList(List<FarmerRequestDto> farmerList) {
        this.farmerList = farmerList;
    }
}
