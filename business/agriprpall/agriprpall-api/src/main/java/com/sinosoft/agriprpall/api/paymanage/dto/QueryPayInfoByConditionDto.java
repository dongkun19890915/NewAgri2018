package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 * 支付信息录入和修改列表信息查询入参Dto
 *
 * @author: 何伟东
 * @date: 2017/12/20 17:45
 */
public class QueryPayInfoByConditionDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 批单号码
     */
    private String endorseNo;
    /**
     * 保单号码
     */
    private String policyNo;
    /**
     * 被保险人名称
     */
    private String insuredName;
    /**
     * 投保人名称
     */
    private String appliName;
    /**
     * 费用类型
     */
    private String costType;

    // 新怎权限校验条件
    /**
     * 用户登录机构代码
     */
    private String loginComCode;
    /**
     * 用户登录岗位代码
     */
    private String loginGradeCodes;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
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

}
