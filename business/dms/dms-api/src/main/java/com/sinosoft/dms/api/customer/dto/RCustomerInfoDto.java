package com.sinosoft.dms.api.customer.dto;


public class RCustomerInfoDto {

    private String CustomerType;  //客户类型
    private String CustomerCode;  //客户代码
    private String CustomerCName; //客户名
    private String DcustomerIdv; //证件类型
    private String CustomerNumber; //证件号

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String customerType) {
        CustomerType = customerType;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getCustomerCName() {
        return CustomerCName;
    }

    public void setCustomerCName(String customerCName) {
        CustomerCName = customerCName;
    }

    public String getDcustomerIdv() {
        return DcustomerIdv;
    }

    public void setDcustomerIdv(String dcustomerIdv) {
        DcustomerIdv = dcustomerIdv;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }
}
