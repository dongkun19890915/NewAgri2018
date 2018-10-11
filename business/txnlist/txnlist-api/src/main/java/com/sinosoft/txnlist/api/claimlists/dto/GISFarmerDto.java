package com.sinosoft.txnlist.api.claimlists.dto;

import java.util.List;

public class GISFarmerDto {
    private static final long serialVersionUID = 1L;
    String farmerCode       ;//农户代码
    String farmerName       ;//农户姓名
    String farmerIdType     ;//农户证件类型
    String farmerIdCode     ;//农户证件号码
    //理赔损失清单农户标的信息
    List<GISFarmerLossItemDto> farmerLossItemList;

    public String getFarmerCode() {
        return farmerCode;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerIdType() {
        return farmerIdType;
    }

    public void setFarmerIdType(String farmerIdType) {
        this.farmerIdType = farmerIdType;
    }

    public String getFarmerIdCode() {
        return farmerIdCode;
    }

    public void setFarmerIdCode(String farmerIdCode) {
        this.farmerIdCode = farmerIdCode;
    }

    public List<GISFarmerLossItemDto> getFarmerLossItemList() {
        return farmerLossItemList;
    }

    public void setFarmerLossItemList(List<GISFarmerLossItemDto> farmerLossItemList) {
        this.farmerLossItemList = farmerLossItemList;
    }
}
