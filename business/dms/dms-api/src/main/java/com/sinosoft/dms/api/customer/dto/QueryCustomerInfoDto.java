package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

public class QueryCustomerInfoDto extends BasePageableRequest implements Serializable {
    //客户中文名称
    private String customerCName;
    //客户类型
    private String customerType;

    public String getCustomerCName() {
        return customerCName;
    }

    public void setCustomerCName(String customerCName) {
        this.customerCName = customerCName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
