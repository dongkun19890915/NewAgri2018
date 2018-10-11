package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 投保预确认数据主表主键操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:38
 */
public class GisInsureMainListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public GisInsureMainListKey() {
    }

    public GisInsureMainListKey(String insureListCode, Integer serialNo) {
        this.insureListCode = insureListCode;
        this.serialNo = serialNo;
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
}