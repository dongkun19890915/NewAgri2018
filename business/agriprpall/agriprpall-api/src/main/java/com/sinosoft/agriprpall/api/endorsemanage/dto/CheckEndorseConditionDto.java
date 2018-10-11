package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class CheckEndorseConditionDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /*保单号*/
    private String policyNo;
//    /*用户代码*/
//    private String userCode;
//    /*用户登录岗位代码*/
//    private String loginGradeCodes;
    /*用户登录机构代码*/
    private String loginComCode;
    /*批改生效日期*/
    private Date strValidDate;
    /*险种代码*/
    private String riskCode;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

//    public String getUserCode() {
//        return userCode;
//    }
//
//    public void setUserCode(String userCode) {
//        this.userCode = userCode;
//    }

//    public String getLoginGradeCodes() {
//        return loginGradeCodes;
//    }
//
//    public void setLoginGradeCodes(String loginGradeCodes) {
//        this.loginGradeCodes = loginGradeCodes;
//    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public Date getStrValidDate() {
        return strValidDate;
    }

    public void setStrValidDate(Date strValidDate) {
        this.strValidDate = strValidDate;
    }
}
