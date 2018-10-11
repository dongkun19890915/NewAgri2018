package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="BreedLossRateListInfo")
public class BreedLossRateListInfo {
    @Id
    private String rowNum;
    /** 序号*/
    private Integer serialNo;
    /** 清单号*/
    private String lossListCode;
    /** 保单号*/
    private String policyNo;
    /** 业务号*/
    private String bizNo;
    /** 农户代码*/
    private String fcode;
    /** 农户姓名*/
    private String fname;
    /** 耳标号*/
    private String earLabel;
    /** 损失金额*/
    private Double lossMoney;
    /** 备注*/
    private String remark;
    /** 数据来源*/
    private String origin;
    /** 节点来源*/
    private String nodeOrigin;
    /** 证件号码*/
    private String fIdCard;
    /** 定损时间*/
    private Date listAffirmTime;
    /** 死亡数量*/
    private Double deathQuantity;
    /** 捕杀数量*/
    private Double killQuantity;
    /** 损失金额*/
    private Double lossAmount;
    /** 查勘报告*/
    private String checkContext;
    /*标的*/
    private String itemCode;
    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public Double getLossMoney() {
        return lossMoney;
    }

    public void setLossMoney(Double lossMoney) {
        this.lossMoney = lossMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNodeOrigin() {
        return nodeOrigin;
    }

    public void setNodeOrigin(String nodeOrigin) {
        this.nodeOrigin = nodeOrigin;
    }

    public String getLossListCode() {
        return lossListCode;
    }

    public void setLossListCode(String lossListCode) {
        this.lossListCode = lossListCode;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public Date getListAffirmTime() {
        return listAffirmTime;
    }

    public void setListAffirmTime(Date listAffirmTime) {
        this.listAffirmTime = listAffirmTime;
    }

    public Double getDeathQuantity() {
        return deathQuantity;
    }

    public void setDeathQuantity(Double deathQuantity) {
        this.deathQuantity = deathQuantity;
    }

    public Double getKillQuantity() {
        return killQuantity;
    }

    public void setKillQuantity(Double killQuantity) {
        this.killQuantity = killQuantity;
    }

    public Double getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(Double lossAmount) {
        this.lossAmount = lossAmount;
    }

    public String getCheckContext() {
        return checkContext;
    }

    public void setCheckContext(String checkContext) {
        this.checkContext = checkContext;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
