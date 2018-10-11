package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestPrpDuserDto extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    /*用户代码*/
    private String userCode;
    /*用户登录机构代码*/
    private String loginComCode;
    /*用户登录岗位代码*/
    private String loginGradeCodes;
    /*表名*/
    private String tableName;
    /*userCode字段*/
    private String userCodeFields;
    /*comCode字段*/
    private String comCodeFields;
    /*险种*/
    private String riskCode;
    /*业务员名称*/
    private String userName;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginGradeCodes() {
        return loginGradeCodes;
    }

    public void setLoginGradeCodes(String loginGradeCodes) {
        this.loginGradeCodes = loginGradeCodes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserCodeFields() {
        return userCodeFields;
    }

    public void setUserCodeFields(String userCodeFields) {
        this.userCodeFields = userCodeFields;
    }

    public String getComCodeFields() {
        return comCodeFields;
    }

    public void setComCodeFields(String comCodeFields) {
        this.comCodeFields = comCodeFields;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
}
