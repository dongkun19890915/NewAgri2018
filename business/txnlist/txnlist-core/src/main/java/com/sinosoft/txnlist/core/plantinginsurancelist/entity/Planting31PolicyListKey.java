package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * 投保明细表主键操作对象
 */
public class Planting31PolicyListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public Planting31PolicyListKey() {
    }

    /**
     * 属性投保清单编号/投保清单编号
     */
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性农户代码/农户代码
     */
    @Column(name = "itemCode")
    private String itemCode;
    /**
     * 属性险别序号/险别序号
     */
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性农户身份证/农户身份证
     */
    @Column(name = "fIdCard")
    private String fIdCard;

    public Planting31PolicyListKey(String inusreListCode, String itemCode, String kindCode, String fIdCard) {
        this.inusreListCode = inusreListCode;
        this.itemCode = itemCode;
        this.kindCode = kindCode;
        this.fIdCard = fIdCard;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }
}