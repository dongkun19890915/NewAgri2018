package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:21:28.682
 * 险种大类表实体操作对象
 */
public class UtiCodeTransferDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String configCode;

    private String outerCode;

    private String innerCode;

    private String codeType;

    private String validStatus;

    private String riskType;

    private String createdBy;

    /** 属性创建时间/创建时间 */
    private Date createdTime;

    /** 属性更新人/更新人 */
    private String updatedBy;

    /** 属性更新时间/更新时间 */
    private Date updatedTime;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getOuterCode() {
        return outerCode;
    }

    public void setOuterCode(String outerCode) {
        this.outerCode = outerCode;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
