package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 投保预确认农户田块清单表Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:22
 */
public class GisFieldListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性田块代码/田块代码
     */
    private String fieldCode;
    /**
     * 属性田块面积/田块面积
     */
    private Double fieldArea;
    /**
     * 属性调整后田块面积/调整后田块面积
     */
    private Double adjustArea;
    /**
     * 属性调整原因/调整原因
     */
    private String adjustReason;
    /**
     * 属性有效面积（有效数量) /有效面积（有效数量)
     */
    private Double validArea;
    /**
     * 属性备注/备注
     */
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
