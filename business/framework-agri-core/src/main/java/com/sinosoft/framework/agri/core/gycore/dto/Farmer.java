package com.sinosoft.framework.agri.core.gycore.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-26 15:41
 */
public class Farmer {
    private String fcode;
    private List<FarmerItem> farmerItemList;

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public List<FarmerItem> getFarmerItemList() {
        return farmerItemList;
    }

    public void setFarmerItemList(List<FarmerItem> farmerItemList) {
        this.farmerItemList = farmerItemList;
    }
}
