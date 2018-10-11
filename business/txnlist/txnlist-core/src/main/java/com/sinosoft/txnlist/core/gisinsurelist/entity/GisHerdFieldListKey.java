package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 预投保清单农户标的清单明细表（物）主键操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:41
 */
public class GisHerdFieldListKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public GisHerdFieldListKey() {
    }

    public GisHerdFieldListKey(String insureListCode, Integer serialNo, String fCode, String earLabel) {
        this.insureListCode = insureListCode;
        this.serialNo = serialNo;
        this.fCode = fCode;
        this.earLabel = earLabel;
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
     * 属性耳标号/脚环号/耳标号/脚环号
     */
    @Column(name = "earLabel")
    private String earLabel;

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

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }
}