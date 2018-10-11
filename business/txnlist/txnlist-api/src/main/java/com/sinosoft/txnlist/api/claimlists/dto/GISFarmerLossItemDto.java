package com.sinosoft.txnlist.api.claimlists.dto;

import java.util.List;

/**
 * 理赔损失清单农户标的主信息
 * @author 王心洋
 * @time 2018-01-18
 */
public class GISFarmerLossItemDto {
    private static final long serialVersionUID = 1L;
    String itemCode;//标的代码
    String itemName;//标的名称
    String itemFullName;//标的全称
    String itemType;//标的类别
    //理赔损失清单农户标的损失信息
    List<GISItemLossRateDto>itemLossRateList;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemFullName() {
        return itemFullName;
    }

    public void setItemFullName(String itemFullName) {
        this.itemFullName = itemFullName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public List<GISItemLossRateDto> getItemLossRateList() {
        return itemLossRateList;
    }

    public void setItemLossRateList(List<GISItemLossRateDto> itemLossRateList) {
        this.itemLossRateList = itemLossRateList;
    }
}
