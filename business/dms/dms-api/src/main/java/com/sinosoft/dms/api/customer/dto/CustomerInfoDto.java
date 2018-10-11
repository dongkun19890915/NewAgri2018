package com.sinosoft.dms.api.customer.dto;

public class CustomerInfoDto {
    private String customerCode;//客户号
    private String customerCname; //客户名
    private String customerType; //客户类型
    private String customerNumber; //证件。机构号
    private Integer pageNo; //页码
    private Integer pageSize; //每页条数

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCname() {
        return customerCname;
    }

    public void setCustomerCname(String customerCname) {
        this.customerCname = customerCname;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
