package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class QueryComCodeInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*用户输入机构代码*/
    private String comCode;
    /*用户输入机构中文名*/
    private String comCName;
    /*当前险种*/
    private String riskCode;
    /*用户登录的岗位代码*/
    private String gradeCodes;
    /*用户代码*/
    private String userCode;
    /*用户登录机构代码*/
    private String loginComCode;
    private List<String> selectList;

    public List<String> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<String> selectList) {
        this.selectList = selectList;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }


    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getGradeCodes() {
        return gradeCodes;
    }

    public void setGradeCodes(String gradeCodes) {
        this.gradeCodes = gradeCodes;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
