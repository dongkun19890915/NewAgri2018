package com.sinosoft.txnlist.api.gisinsurelist.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-26 11:02
 */
public class AddListAdditionalDataDtoList {
    private List<AddListAdditionalDataDto> farmerItemList;

    public List<AddListAdditionalDataDto> getFarmerItemList() {
        return farmerItemList;
    }

    public void setFarmerItemList(List<AddListAdditionalDataDto> farmerItemList) {
        this.farmerItemList = farmerItemList;
    }
}
