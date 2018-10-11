package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
 *（接受流程查询的请求参数）
 * @Author: 孙朋飞
 * @Date: 2017/12/16 10:36
 */
public class RequestWorkProcessDto extends BasePageableRequest implements Serializable{
    private String policyNo;//保单号
    private String registNo;//报案号
    private String claimNo;//立案号
    private String caseNo;//赔案号
    private String compensateNo;//赔款计算书号
    private String classCode;//险种大类
    private String flowInTime;//流入时间
    private String inTime;//流入时间开始
    private String outTime;//流入时间结束
    private String caseType;//案件状态
    private String flowId;//流程号
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

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
}
