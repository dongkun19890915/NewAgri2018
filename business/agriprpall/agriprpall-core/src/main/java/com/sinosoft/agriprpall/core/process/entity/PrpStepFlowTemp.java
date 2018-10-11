package com.sinosoft.agriprpall.core.process.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-03 09:46:55.365
 * 承保流程节点数据临时表实体操作对象
 */
@Entity
@Table(name = "PrpStepFlowTemp")
@IdClass(PrpStepFlowTempKey.class)
public class PrpStepFlowTemp extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性UUID/UUID
     */
    @Id
    @Column(name = "UUID")
    private String UUID;
    /**
     * 属性投保单号/投保单号
     */
    @Id
    @Column(name = "proposalNo")
    private String proposalNo;


    /**
     * 属性保单号/保单号
     */
    @Column(name = "policyNo")
    private String policyNo;
    /**
     * 属性批单号/批单号
     */
    @Column(name = "endorseNo")
    private String endorseNo;
    /**
     * 属性当前环节id/当前环节id
     */
    @Column(name = "stepId")
    private String stepId;
    /**
     * 属性当前环节代码/当前环节代码
     */
    @Column(name = "nowStepCode")
    private String nowStepCode;
    /**
     * 属性当前环节状态/当前环节状态
     */
    @Column(name = "nowStateCode")
    private String nowStateCode;

    /**
     * 属性UUID/UUID的getter方法
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * 属性UUID/UUID的setter方法
     */
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    /**
     * 属性投保单号/投保单号的getter方法
     */
    public String getProposalNo() {
        return proposalNo;
    }

    /**
     * 属性投保单号/投保单号的setter方法
     */
    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    /**
     * 属性保单号/保单号的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 属性保单号/保单号的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 属性批单号/批单号的getter方法
     */
    public String getEndorseNo() {
        return endorseNo;
    }

    /**
     * 属性批单号/批单号的setter方法
     */
    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    /**
     * 属性当前环节id/当前环节id的getter方法
     */
    public String getStepId() {
        return stepId;
    }

    /**
     * 属性当前环节id/当前环节id的setter方法
     */
    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    /**
     * 属性当前环节代码/当前环节代码的getter方法
     */
    public String getNowStepCode() {
        return nowStepCode;
    }

    /**
     * 属性当前环节代码/当前环节代码的setter方法
     */
    public void setNowStepCode(String nowStepCode) {
        this.nowStepCode = nowStepCode;
    }

    /**
     * 属性当前环节状态/当前环节状态的getter方法
     */
    public String getNowStateCode() {
        return nowStateCode;
    }

    /**
     * 属性当前环节状态/当前环节状态的setter方法
     */
    public void setNowStateCode(String nowStateCode) {
        this.nowStateCode = nowStateCode;
    }
}