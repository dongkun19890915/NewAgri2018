package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpDitemSortAgriDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private String itemCode;
    private String itemName;
    private String itemLongName;
    private String endClassFlag;
    private String upperItemCode;

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

    public String getItemLongName() {
        return itemLongName;
    }

    public void setItemLongName(String itemLongName) {
        this.itemLongName = itemLongName;
    }

    public String getEndClassFlag() {
        return endClassFlag;
    }

    public void setEndClassFlag(String endClassFlag) {
        this.endClassFlag = endClassFlag;
    }

    public String getUpperItemCode() {
        return upperItemCode;
    }

    public void setUpperItemCode(String upperItemCode) {
        this.upperItemCode = upperItemCode;
    }

}
