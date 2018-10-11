package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 预投保清单标的表主键操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:37
 */
public class GisItemListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public GisItemListKey() {
    }

    public GisItemListKey(String insureListCode, Integer serialNo, String itemCode) {
        this.insureListCode = insureListCode;
        this.serialNo = serialNo;
        this.itemCode = itemCode;
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
     * 属性标的代码/标的代码
     */
    @Column(name = "itemCode")
    private String itemCode;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}