package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-06 02:22:27.335
 * 投保预确认农户田块清单表（种植险）主键操作对象
 */
public class GisFeildKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public GisFeildKey() {
    }

    public GisFeildKey(String insureListCode, Integer serialNo, String fCode, String fieldNo) {
        this.insureListCode = insureListCode;
        this.serialNo = serialNo;
        this.fCode = fCode;
        this.fieldNo = fieldNo;
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
     * 属性田块编码/田块编码
     */
    @Column(name = "fieldNo")
    private String fieldNo;

    /**
     * 属性清单编号/清单编号的getter方法
     */
    public String getInsureListCode() {
        return insureListCode;
    }

    /**
     * 属性清单编号/清单编号的setter方法
     */
    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    /**
     * 属性序列号/序列号的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }

    /**
     * 属性序列号/序列号的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
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
     * 属性田块编码/田块编码的getter方法
     */
    public String getFieldNo() {
        return fieldNo;
    }

    /**
     * 属性田块编码/田块编码的setter方法
     */
    public void setFieldNo(String fieldNo) {
        this.fieldNo = fieldNo;
    }
}