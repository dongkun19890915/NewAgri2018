package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.util.Date;
/**
 * 允许特殊批改校验入参DTO
 * @Author: 李冬松
 * @Date: 2018/1/9 18:50
 */
public class SpecialEndorseCheckDto {
    private static final long serialVersionUID = 1L;
    private String policyNo; //保单号
    private Date endorDate; //批改日期
    private Date validDate; //批改生效日期
    private String riskCode;//险种
    private String loginComCode;
    private String userCode;
    private String loginGradeCode;
    private String strEndorType;

    public String getStrEndorType() {
        return strEndorType;
    }

    public void setStrEndorType(String strEndorType) {
        this.strEndorType = strEndorType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginGradeCode() {
        return loginGradeCode;
    }

    public void setLoginGradeCode(String loginGradeCode) {
        this.loginGradeCode = loginGradeCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(Date endorDate) {
        this.endorDate = endorDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

}
