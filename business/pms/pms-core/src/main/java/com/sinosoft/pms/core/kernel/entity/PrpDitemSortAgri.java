package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "PrpDitemSortAgri")
@IdClass(PrpDitemSortAgriKey.class)
public class PrpDitemSortAgri extends BaseEntityImpl {

    @Id
    @Column(name = "itemCode")
    private String itemCode;

    @Column(name = "itemName")
    private String itemName;
    @Column(name = "itemLongName")
    private String itemLongName;
    @Column(name = "endClassFlag")
    private String endClassFlag;
    @Column(name = "upperItemCode")
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
