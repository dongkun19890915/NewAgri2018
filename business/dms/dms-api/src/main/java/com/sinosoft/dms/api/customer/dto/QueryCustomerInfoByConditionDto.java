package com.sinosoft.dms.api.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.Date;

public class QueryCustomerInfoByConditionDto extends BasePageableRequest implements Serializable {
    //证件类型
    private String identifyType;
    //客户类型
    private String customerType;
    //证件号码
    private String identifyNumber ;
    //1:组织机构代码 2:统一社会信用代码'
    private String socialCode;
    //客户中文名称
    private String customerCName ;
    //客户代码
    private String customerCode ;
    //维护日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startUpDateDate;
    //维护日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endUpDateDate;
    //维护人名称(最后一次修改人)
    private String userName;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getCustomerCName() {
        return customerCName;
    }

    public void setCustomerCName(String customerCName) {
        this.customerCName = customerCName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public Date getStartUpDateDate() {
        return startUpDateDate;
    }

    public void setStartUpDateDate(Date startUpDateDate) {
        this.startUpDateDate = startUpDateDate;
    }

    public Date getEndUpDateDate() {
        return endUpDateDate;
    }

    public void setEndUpDateDate(Date endUpDateDate) {
        this.endUpDateDate = endUpDateDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }
}
