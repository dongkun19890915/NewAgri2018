package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "NyxEffectiveAmount")
@IdClass(NyxEffectiveAmountKey.class)
public class NyxEffectiveAmount  extends BaseEntityImpl {
    private static final long serialVersionUID = 1L;

    /*业务号*/
    @Id
    @Column(name = "businessNo")
    private String businessNo;

    /*保单号*/
    @Column(name = "policyNo")
    private String policyNo;

    /*险种代码*/
    @Id
    @Column(name = "riskCode")
    private String riskCode;

    /*险别代码*/
    @Id
    @Column(name = "kindCode")
    private String kindCode;

    /*标的代码*/
    @Id
    @Column(name = "itemCode")
    private String itemCode;

    /*农户代码*/
    @Id
    @Column(name = "fCode")
    private String fCode;

    /*其他（茬次）*/
    @Id
    @Column(name = "flag")
    private Integer flag=0;

    /*有效起期*/
    @Column(name = "startDate")
    private Date startDate;

    /*有效止期*/
    @Column(name = "endDate")
    private Date endDate;

    /*有效保额*/
    @Column(name = "amount")
    private Double amount;

    /*序号*/
    @Column(name = "serialNo")
    private Integer serialNo=0;

    /*变化量*/
    @Column(name = "chgAmount")
    private Double chgAmount=0.0;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Double getChgAmount() {
        return chgAmount;
    }

    public void setChgAmount(Double chgAmount) {
        this.chgAmount = chgAmount;
    }
}
