package com.sinosoft.dms.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PrpMmodelMainRequestDto extends BasePageableRequest implements Serializable {
    //模板代码
    private String modelCode;
    //模板名称
    private String modelName;
    //投保人名称
    private String appledName;
    //被保险人名称
    private String insuredName;
    //模板创建有效起期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    //模板创建有效止期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    //机构代码
    private String comCode;
    //机构名称
    private String comName;
    //险种
    private String riskCode;
    //标的中文名称
    private String itemCName;
    //创建人名称
    private String userName;
    //政策/商业标志
    private String businessType1;
    //有效标志字段
    private String validStatus1;
    //停用启用
    private String validStatus;
    private PrpMmodelMainDto prpMmodelMainDto;

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAppledName() {
        return appledName;
    }

    public void setAppledName(String appledName) {
        this.appledName = appledName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getItemCName() {
        return itemCName;
    }

    public void setItemCName(String itemCName) {
        this.itemCName = itemCName;
    }

    public PrpMmodelMainDto getPrpMmodelMainDto() {
        return prpMmodelMainDto;
    }

    public void setPrpMmodelMainDto(PrpMmodelMainDto prpMmodelMainDto) {
        this.prpMmodelMainDto = prpMmodelMainDto;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getValidStatus1() {
        return validStatus1;
    }

    public void setValidStatus1(String validStatus1) {
        this.validStatus1 = validStatus1;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
