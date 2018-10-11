package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 预投保清单农户标的清单明细表（人）主键操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:35
 */
public class GisManFieldListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public GisManFieldListKey() {
    }

    public GisManFieldListKey(String insureListCode, Integer serialNo, String fCode, String itemCode, String idCard) {
        this.insureListCode = insureListCode;
        this.serialNo = serialNo;
        this.fCode = fCode;
        this.itemCode = itemCode;
        this.idCard = idCard;
    }

    /**
     * 属性清单编号/清单编号
     */
    @Column(name = "insureListCode")
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    @Column(name = "serialNo")
    private Integer serialNo;
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
     * 属性证件号码/证件号码
     */
    @Column(name = "idCard")
    private String idCard;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}