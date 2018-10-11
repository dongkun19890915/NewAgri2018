package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-06 02:22:27.335
 * 投保预确认农户田块清单表（种植险）实体操作对象
 */
@Entity
@Table(name = "GisFeild")
@IdClass(GisFeildKey.class)
public class GisFeild extends BaseEntityImpl {

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
     * 属性田块编码/田块编码
     */
    @Id
    @Column(name = "fieldNo")
    private String fieldNo;


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
    /**
     * 属性备用字段1/备用字段1
     */
    @Column(name = "remark1")
    private String remark1;
    /**
     * 属性备用字段2/备用字段2
     */
    @Column(name = "remark2")
    private String remark2;
    /**
     * 属性备用字段3/备用字段3
     */
    @Column(name = "remark3")
    private String remark3;
    /**
     * 属性备用字段4/备用字段4
     */
    @Column(name = "remark4")
    private String remark4;

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

    /**
     * 属性田块面积/田块面积的getter方法
     */
    public Double getFieldArea() {
        return fieldArea;
    }

    /**
     * 属性田块面积/田块面积的setter方法
     */
    public void setFieldArea(Double fieldArea) {
        this.fieldArea = fieldArea;
    }

    /**
     * 属性调整后田块面积/调整后田块面积的getter方法
     */
    public Double getAdjustArea() {
        return adjustArea;
    }

    /**
     * 属性调整后田块面积/调整后田块面积的setter方法
     */
    public void setAdjustArea(Double adjustArea) {
        this.adjustArea = adjustArea;
    }

    /**
     * 属性调整原因/调整原因的getter方法
     */
    public String getAdjustReason() {
        return adjustReason;
    }

    /**
     * 属性调整原因/调整原因的setter方法
     */
    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    /**
     * 属性有效面积（有效数量) /有效面积（有效数量) 的getter方法
     */
    public Double getValidArea() {
        return validArea;
    }

    /**
     * 属性有效面积（有效数量) /有效面积（有效数量) 的setter方法
     */
    public void setValidArea(Double validArea) {
        this.validArea = validArea;
    }

    /**
     * 属性备注/备注的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性备注/备注的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性备用字段1/备用字段1的getter方法
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 属性备用字段1/备用字段1的setter方法
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 属性备用字段2/备用字段2的getter方法
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 属性备用字段2/备用字段2的setter方法
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * 属性备用字段3/备用字段3的getter方法
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 属性备用字段3/备用字段3的setter方法
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    /**
     * 属性备用字段4/备用字段4的getter方法
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 属性备用字段4/备用字段4的setter方法
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
}