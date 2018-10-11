package com.sinosoft.pms.api.arealimit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.pms.api.common.dto.PmsRequestDto;

/**
 * @author yinqingzhu
 * @description 查询区域销售限额返回时使用
 * @date 2016年9月28日下午9:25:45
 */
public class PrpdAreaLimitDto extends PmsRequestDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    String areaCode;
    String riskCode;
    String versionNo;
    /**
     * 属性RiskName/产品名称
     */
    private String riskName;
    /**
     * 属性AreaCName/地区名称
     */
    private String areaCName;
    /**
     * 属性SalesLimit/销售限额
     */
    private Double salesLimit;
    /**
     * 属性EffectDate/生效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date effectDate;
    /**
     * 属性InvalidDate/失效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.util.Date invalidDate;
    /**
     * 属性Flag/标志
     */
    private String flag;
    /**
     * 属性Remark/备注
     */
    private String remark;
    /**
     * 属性CreateTime/创建时间
     */
    private java.util.Date createTime;
    /**
     * 属性CreateBy/创建人
     */
    private String createBy;
    /**
     * 属性UpdateTime/更新时间
     */
    private java.util.Date updateTime;
    /**
     * 属性UpdateBy/更新人
     */
    private String updateBy;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getAreaCName() {
        return areaCName;
    }

    public void setAreaCName(String areaCName) {
        this.areaCName = areaCName;
    }

    public Double getSalesLimit() {
        return salesLimit;
    }

    public void setSalesLimit(Double salesLimit) {
        this.salesLimit = salesLimit;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public java.util.Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(java.util.Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

}
