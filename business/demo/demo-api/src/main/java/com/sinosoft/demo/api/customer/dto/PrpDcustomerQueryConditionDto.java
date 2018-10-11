package com.sinosoft.demo.api.customer.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

public class PrpDcustomerQueryConditionDto extends BasePageableRequest {


    /** 属性客户中文名称/客户中文名称 */
    private String customerCName;

    private String customerCode ;

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
}
