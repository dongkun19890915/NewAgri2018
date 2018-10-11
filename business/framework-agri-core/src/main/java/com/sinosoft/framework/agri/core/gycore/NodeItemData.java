package com.sinosoft.framework.agri.core.gycore;

import java.util.Date;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-13 14:19
 */
public class NodeItemData {
    //环节id
    private String stepId;

    //环节代码
    private String stepCode;

    //状态代码
    private String stateCode;

    //处理结果代码
    private String resultCode;

    //操作员代码
    private String opCode;

    // 操作员名称
    private String opName;

    //业务号
    private String bizCode;

    //流入时间
    private Date inflowTime;

    //流出时间
    private Date outflowTime;

    //处理时间
    private Date opTime;

    //缴费类型代码
    private String paymentTypeCode;

    //缴费金额
    private String amount;

    //上级环节id
    private String laststepId;

    public NodeItemData() {
    }

    public NodeItemData(String stepId, String stepCode, String stateCode, String resultCode, String opCode, String opName, String bizCode, Date inflowTime, Date outflowTime, Date opTime, String paymentTypeCode, String amount, String laststepId) {
        this.stepId = stepId;
        this.stepCode = stepCode;
        this.stateCode = stateCode;
        this.resultCode = resultCode;
        this.opCode = opCode;
        this.opName = opName;
        this.bizCode = bizCode;
        this.inflowTime = inflowTime;
        this.outflowTime = outflowTime;
        this.opTime = opTime;
        this.paymentTypeCode = paymentTypeCode;
        this.amount = amount;
        this.laststepId = laststepId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Date getInflowTime() {
        return inflowTime;
    }

    public void setInflowTime(Date inflowTime) {
        this.inflowTime = inflowTime;
    }

    public Date getOutflowTime() {
        return outflowTime;
    }

    public void setOutflowTime(Date outflowTime) {
        this.outflowTime = outflowTime;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLaststepId() {
        return laststepId;
    }

    public void setLaststepId(String laststepId) {
        this.laststepId = laststepId;
    }
}
