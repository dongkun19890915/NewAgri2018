package com.sinosoft.txnlist.core.insuremainlist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * 草莓组合险连带被保险人表2主键操作对象
 */
public class CMCPManFieldListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public CMCPManFieldListKey() {
    }

    public CMCPManFieldListKey(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        this.insureListCode = insureListCode;
        this.fCode = fCode;
        this.itemCode = itemCode;
        this.idCard = idCard;
        this.kindCode = kindCode;
    }

    /**
     * 属性清单号/清单号
     */
    @Column(name = "insureListCode")
    private String insureListCode;
    /**
     * 属性农户代码/农户代码
     */
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性标的代码/标的代码
     */
    @Column(name = "itemCode")
    private String itemCode;
    /**
     * 属性连带被保险人证件号码/连带被保险人证件号码
     */
    @Column(name = "idCard")
    private String idCard;
    /**
     * 属性险别代码/险别代码
     */
    @Column(name = "kindCode")
    private String kindCode;

    /**
     * 属性清单号/清单号的getter方法
     */
    public String getInsureListCode() {
        return insureListCode;
    }

    /**
     * 属性清单号/清单号的setter方法
     */
    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    /**
     * 属性农户代码/农户代码的getter方法
     */
    public String getFCode() {
        return fCode;
    }

    /**
     * 属性农户代码/农户代码的setter方法
     */
    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    /**
     * 属性标的代码/标的代码的getter方法
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 属性标的代码/标的代码的setter方法
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 属性连带被保险人证件号码/连带被保险人证件号码的getter方法
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 属性连带被保险人证件号码/连带被保险人证件号码的setter方法
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 属性险别代码/险别代码的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别代码/险别代码的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }
}