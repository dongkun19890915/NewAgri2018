package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="PlantingLossRateListInfos")
public class PlantingLossRateListInfos {
    @Id
    private String rowNum;
    /** 序号*/
    private Integer serialNo;
    /**清单号*/
    private String lossListCode;
    /** 保单号*/
    private String policyNo;
    /** 业务号*/
    private String bizNo;
    /** 农户代码*/
    private String fcode;
    /** 农户姓名*/
    private String fname;
    /** 标的代码*/
    private String itemCode;
    /** 损失数量*/
    private Double lossAmount;
    /** 损失金额*/
    private Double lossMoney;
    /** 损失率*/
    private Double lossRate;
    /** 备注*/
    private String remark;
    /** 数据来源*/
    private String origin;
    /** 节点来源*/
    private String nodeOrigin;
    /** 证件号码*/
    private String fidCard;
    /** 定损时间*/
    private Date listAffirmTime;
    /** 受灾面积*/
    private Double disasterArea;
    /** 成灾面积*/
    private Double affectedArea;
    /** 绝产面积*/
    private Double noProductionArea;
    /** 查勘报告*/
    private String checkContext;
    /** 贷款合同编号*/
    private String versionNo;
    /** 连带被保险人姓名*/
    private String name;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(Double lossAmount) {
        this.lossAmount = lossAmount;
    }

    public Double getLossRate() {
        return lossRate;
    }

    public void setLossRate(Double lossRate) {
        this.lossRate = lossRate;
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

    public String getFidCard() {
        return fidCard;
    }

    public void setFidCard(String fidCard) {
        this.fidCard = fidCard;
    }

    public String getLossListCode() {
        return lossListCode;
    }

    public void setLossListCode(String lossListCode) {
        this.lossListCode = lossListCode;
    }

    public Double getLossMoney() {
        return lossMoney;
    }

    public void setLossMoney(Double lossMoney) {
        this.lossMoney = lossMoney;
    }

    public Date getListAffirmTime() {
        return listAffirmTime;
    }

    public void setListAffirmTime(Date listAffirmTime) {
        this.listAffirmTime = listAffirmTime;
    }

    public Double getDisasterArea() {
        return disasterArea;
    }

    public void setDisasterArea(Double disasterArea) {
        this.disasterArea = disasterArea;
    }

    public Double getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(Double affectedArea) {
        this.affectedArea = affectedArea;
    }

    public Double getNoProductionArea() {
        return noProductionArea;
    }

    public void setNoProductionArea(Double noProductionArea) {
        this.noProductionArea = noProductionArea;
    }

    public String getCheckContext() {
        return checkContext;
    }

    public void setCheckContext(String checkContext) {
        this.checkContext = checkContext;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
