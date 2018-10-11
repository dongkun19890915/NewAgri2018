package com.sinosoft.ims.api.auth.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class AddCodePowerConditionDto extends BaseRequest implements Serializable{

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
    /*表别名*/
    private String tableName1;

    private boolean flag;


    public AddCodePowerConditionDto(String userCode,
                                    String loginComCode,
                                    String loginGradeCodes,
                                    String tableName,
                                    String userCodeFields,
                                    String comCodeFields,
                                    String riskCode,
                                    String tableName1,
                                    boolean flag) {
        this.userCode = userCode;
        this.loginComCode = loginComCode;
        this.loginGradeCodes = loginGradeCodes;
        this.tableName = tableName;
        this.userCodeFields = userCodeFields;
        this.comCodeFields = comCodeFields;
        this.riskCode = riskCode;
        this.tableName1=tableName1;
        this.flag=flag;
    }
    public AddCodePowerConditionDto(){

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public String getTableName1() {
        return tableName1;
    }

    public void setTableName1(String tableName1) {
        this.tableName1 = tableName1;
    }
}
