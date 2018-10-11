package com.sinosoft.agriprpall.core.paymanage.entity;

import javax.persistence.*;

/**
 * 费用类型对应收付原因的临时表
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
@Entity
@Table(name = "Temp")
@IdClass(ResTempCostTypeKey.class)
public class ResTempCostType {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "endorseNo")
    private String endorseNo;

    @Column(name = "costType")
    private String costType;

    @Column(name = "policyNo")
    private String policyNo;

    @Column(name = "insuredName")
    private String insuredName;

    @Column(name = "payReason")
    private String payReason;

    @Column(name = "delinquentFee")
    private Double delinquentFee;

    @Column(name = "chgPremium")
    private Double chgPremium;

    @Column(name = "sumChgPremium")
    private Double sumChgPremium;

    @Column(name = "makeCom")
    private String makeCom;

    public ResTempCostType() {
    }

    public ResTempCostType(String endorseNo, String costType, String policyNo, String insuredName, String payReason, Double delinquentFee, Double chgPremium, Double sumChgPremium, String makeCom) {
        this.endorseNo = endorseNo;
        this.costType = costType;
        this.policyNo = policyNo;
        this.insuredName = insuredName;
        this.payReason = payReason;
        this.delinquentFee = delinquentFee;
        this.chgPremium = chgPremium;
        this.sumChgPremium = sumChgPremium;
        this.makeCom = makeCom;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

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

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }

    public Double getDelinquentFee() {
        return delinquentFee;
    }

    public void setDelinquentFee(Double delinquentFee) {
        this.delinquentFee = delinquentFee;
    }

    public Double getChgPremium() {
        return chgPremium;
    }

    public void setChgPremium(Double chgPremium) {
        this.chgPremium = chgPremium;
    }

    public Double getSumChgPremium() {
        return sumChgPremium;
    }

    public void setSumChgPremium(Double sumChgPremium) {
        this.sumChgPremium = sumChgPremium;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }
}