package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author WZW
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-30
 * 重开赔案申请提交数据传输类
 */
public class ReCaseCommitDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 险种名称 */
    private String riskCName;
    /** 立案号 */
    private String claimNo;
    /** 保单号 */
    private String policyNo;
    /** 报案号 */
    private String registNo;
    /** 赔款计算书号 */
    private String compensateNo;
    /** 重开赔案原因 */
    private String reCaseReason;
    /** 部门名称 */
    private String deptName;
    /** 用户代码 */
    private String userCode;

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getReCaseReason() {
        return reCaseReason;
    }

    public void setReCaseReason(String reCaseReason) {
        this.reCaseReason = reCaseReason;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
