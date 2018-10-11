package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userCodeSign;
    private String userCode;
    private String userNameSign;
    private String userName;
    private String prpDCustomerIdvIdentifyNumberSign;
    private String prpDCustomerIdvIdentifyNumber;
    private String customerType;
    private String riskLevel;
    private String comCode;
    private String pageNum;
    private String classCode;
    private String prpDCustomerUnitOrganizeCode;
    private String prpDCustomerUnitOrganizeCodeSign;

    public String getUserCodeSign() {
        return userCodeSign;
    }

    public void setUserCodeSign(String userCodeSign) {
        this.userCodeSign = userCodeSign;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserNameSign() {
        return userNameSign;
    }

    public void setUserNameSign(String userNameSign) {
        this.userNameSign = userNameSign;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrpDCustomerIdvIdentifyNumberSign() {
        return prpDCustomerIdvIdentifyNumberSign;
    }

    public void setPrpDCustomerIdvIdentifyNumberSign(String prpDCustomerIdvIdentifyNumberSign) {
        this.prpDCustomerIdvIdentifyNumberSign = prpDCustomerIdvIdentifyNumberSign;
    }

    public String getPrpDCustomerIdvIdentifyNumber() {
        return prpDCustomerIdvIdentifyNumber;
    }

    public void setPrpDCustomerIdvIdentifyNumber(String prpDCustomerIdvIdentifyNumber) {
        this.prpDCustomerIdvIdentifyNumber = prpDCustomerIdvIdentifyNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getPrpDCustomerUnitOrganizeCode() {
        return prpDCustomerUnitOrganizeCode;
    }

    public void setPrpDCustomerUnitOrganizeCode(String prpDCustomerUnitOrganizeCode) {
        this.prpDCustomerUnitOrganizeCode = prpDCustomerUnitOrganizeCode;
    }

    public String getPrpDCustomerUnitOrganizeCodeSign() {
        return prpDCustomerUnitOrganizeCodeSign;
    }

    public void setPrpDCustomerUnitOrganizeCodeSign(String prpDCustomerUnitOrganizeCodeSign) {
        this.prpDCustomerUnitOrganizeCodeSign = prpDCustomerUnitOrganizeCodeSign;
    }
}
