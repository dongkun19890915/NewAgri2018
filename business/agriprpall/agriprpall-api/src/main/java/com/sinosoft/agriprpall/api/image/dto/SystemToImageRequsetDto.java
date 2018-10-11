package com.sinosoft.agriprpall.api.image.dto;

public class SystemToImageRequsetDto {

    /**
     * 登录员工代码
     */
    private String loginUserCode;
    /**
     * 登录员工姓名
     */
    private String loginUserName;
    /**
     * 登录机构代码
     */
    private String loginComCode;
    /**
     * 登录机构代码
     */
    private String loginComName;
    /**
     * 业务号
     */
    private String businessNo;

    public String getLoginUserCode() {
        return loginUserCode;
    }

    public void setLoginUserCode(String loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginComName() {
        return loginComName;
    }

    public void setLoginComName(String loginComName) {
        this.loginComName = loginComName;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
}
