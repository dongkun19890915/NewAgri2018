package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PrpDitemSortAgriKey extends BasePKImpl{

    @Column(name = "itemCode")
    private String itemCode ;

    public PrpDitemSortAgriKey() {
    }

    public PrpDitemSortAgriKey(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
