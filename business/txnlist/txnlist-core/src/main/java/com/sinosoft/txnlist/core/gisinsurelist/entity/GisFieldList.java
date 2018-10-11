package com.sinosoft.txnlist.core.gisinsurelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * 投保预确认农户田块清单表实体操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:44
 */
@Entity
@Table(name = "GisFieldList")
@IdClass(GisFieldListKey.class)
public class GisFieldList extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    @Id
    @Column(name = "insureListCode")
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    @Id
    @Column(name = "serialNo")
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性田块代码/田块代码
     */
    @Id
    @Column(name = "fieldCode")
    private String fieldCode;
    /**
     * 属性田块面积/田块面积
     */
    @Column(name = "fieldArea")
    private Double fieldArea;
    /**
     * 属性调整后田块面积/调整后田块面积
     */
    @Column(name = "adjustArea")
    private Double adjustArea;
    /**
     * 属性调整原因/调整原因
     */
    @Column(name = "adjustReason")
    private String adjustReason;
    /**
     * 属性有效面积（有效数量) /有效面积（有效数量)
     */
    @Column(name = "validArea")
    private Double validArea;
    /**
     * 属性备注/备注
     */
    @Column(name = "remark")
    private String remark;

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

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public Double getFieldArea() {
        return fieldArea;
    }

    public void setFieldArea(Double fieldArea) {
        this.fieldArea = fieldArea;
    }

    public Double getAdjustArea() {
        return adjustArea;
    }

    public void setAdjustArea(Double adjustArea) {
        this.adjustArea = adjustArea;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    public Double getValidArea() {
        return validArea;
    }

    public void setValidArea(Double validArea) {
        this.validArea = validArea;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}