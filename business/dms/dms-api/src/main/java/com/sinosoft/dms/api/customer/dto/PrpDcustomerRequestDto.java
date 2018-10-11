package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpDcustomerRequestDto extends BaseRequest implements Serializable {
    /**客户类型*/
    private String customerType;
    /**标识符*/
    private String flag;
    /**个体中文名称*/
    private String prpDcustomerIdvCustomerCName;
    /**团体中文名称*/
    private String prpDcustomerUnitCustomerCName;
    /**客户代码*/
    private String customerCode;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPrpDcustomerIdvCustomerCName() {
        return prpDcustomerIdvCustomerCName;
    }

    public void setPrpDcustomerIdvCustomerCName(String prpDcustomerIdvCustomerCName) {
        this.prpDcustomerIdvCustomerCName = prpDcustomerIdvCustomerCName;
    }

    public String getPrpDcustomerUnitCustomerCName() {
        return prpDcustomerUnitCustomerCName;
    }

    public void setPrpDcustomerUnitCustomerCName(String prpDcustomerUnitCustomerCName) {
        this.prpDcustomerUnitCustomerCName = prpDcustomerUnitCustomerCName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
