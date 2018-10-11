package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class ItemKingAgriccDto extends BaseRequest implements Serializable {
    //茬次信息
    private String items;
    private String itemsDate;
    private String distributingrate;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getItemsDate() {
        return itemsDate;
    }

    public void setItemsDate(String itemsDate) {
        this.itemsDate = itemsDate;
    }

    public String getDistributingrate() {
        return distributingrate;
    }

    public void setDistributingrate(String distributingrate) {
        this.distributingrate = distributingrate;
    }
}
