package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

public class PlantingPolicyList_OldKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PlantingPolicyList_OldKey() {
    }



    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性排序序号/排序序号
     */
    @Column(name = "indexCode")
    private String indexCode;

    public PlantingPolicyList_OldKey(String inusreListCode, String fCode, String kindCode, String indexCode) {
        this.inusreListCode = inusreListCode;
        this.fCode = fCode;
        this.kindCode = kindCode;
        this.indexCode = indexCode;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }
}
