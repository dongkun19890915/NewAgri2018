package com.sinosoft.agriprpall.api.process.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ProcessDto extends BaseRequest implements Serializable {

    /**
     * 环节代码
     */
    private String stepCode;
    /**
     * 状态代码
     */
    private String stateCode;
    /**
     * 处理结果代码
     */
    private String resultCode;
    /**
     * 操作员代码
     */
    private String opCode;
    /**
     * 操作员名称
     */
    private String opName;
    /**
     * 业务号
     */
    private String bizCode;
    /**
     * 流入时间
     */
    private Date inflowTime;
    /**
     * 流出时间
     */
    private Date outflowTime;
    /**
     * 处理时间
     */
    private Date opTime;
    /**
     * 缴费类型代码
     */
    private String paymentTypeCode;
    /**
     * 缴费金额
     */
    private String amount;

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

    public ProcessDto() {
    }

    @Override
    public String toString() {
        return "ProcessDto{" +
                "stepCode='" + stepCode + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", opCode='" + opCode + '\'' +
                ", opName='" + opName + '\'' +
                ", bizCode='" + bizCode + '\'' +
                ", inflowTime=" + inflowTime +
                ", outflowTime=" + outflowTime +
                ", opTime=" + opTime +
                ", paymentTypeCode='" + paymentTypeCode + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    private ProcessDto(Builder builder) {
        stepCode = builder.stepCode;
        stateCode = builder.stateCode;
        resultCode = builder.resultCode;
        opCode = builder.opCode;
        opName = builder.opName;
        bizCode = builder.bizCode;
        inflowTime = builder.inflowTime;
        outflowTime = builder.outflowTime;
        opTime = builder.opTime;
        paymentTypeCode = builder.paymentTypeCode;
        amount = builder.amount;
    }

    public static final class Builder {
        private String stepCode;
        private String stateCode;
        private String resultCode;
        private String opCode;
        private String opName;
        private String bizCode;
        private Date inflowTime;
        private Date outflowTime;
        private Date opTime;
        private String paymentTypeCode;
        private String amount;

        public Builder() {
        }

        public Builder stepCode(String val) {
            stepCode = val;
            return this;
        }

        public Builder stateCode(String val) {
            stateCode = val;
            return this;
        }

        public Builder resultCode(String val) {
            resultCode = val;
            return this;
        }

        public Builder opCode(String val) {
            opCode = val;
            return this;
        }

        public Builder opName(String val) {
            opName = val;
            return this;
        }

        public Builder bizCode(String val) {
            bizCode = val;
            return this;
        }

        public Builder inflowTime(Date val) {
            inflowTime = val;
            return this;
        }

        public Builder outflowTime(Date val) {
            outflowTime = val;
            return this;
        }

        public Builder opTime(Date val) {
            opTime = val;
            return this;
        }

        public Builder paymentTypeCode(String val) {
            paymentTypeCode = val;
            return this;
        }

        public Builder amount(String val) {
            amount = val;
            return this;
        }

        public ProcessDto build() {
            return new ProcessDto(this);
        }
    }
}
