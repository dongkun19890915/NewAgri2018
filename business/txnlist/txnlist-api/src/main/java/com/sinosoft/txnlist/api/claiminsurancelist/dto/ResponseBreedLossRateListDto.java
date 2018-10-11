package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ResponseBreedLossRateListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性序号/序号
     */
    @ExportConfig(value = "序号", width = 37)
    private String serialNo;
    @ExportConfig(value="清单号",width = 37)
    private String lossListCode;
    /**
     * 属性保单号/保单号
     */
    @ExportConfig(value = "保单号", width = 47)
    private String policyNo;
    /**
     * 属性报案号/报案号
     */
    @ExportConfig(value = "报案号", width = 52)
    private String bizNo;
    /**
     * 属性农户代码/农户代码
     */
    @ExportConfig(value = "农户代码", width = 67)
    private String fcode;
    /**
     * 属性农户姓名/农户姓名
     */
    @ExportConfig(value = "农户姓名", width = 67)
    private String fname;
    /**
     * 属性耳标号/耳标号
     */
    @ExportConfig(value="证件号码",width = 67)
    private String fIdCard;
    @ExportConfig(value="标的",width = 67)
    private String itemCode;
    @ExportConfig(value = "耳标号")
    private String earLabel;
    /**
     * 属性赔款金额/赔款金额
     */
    @ExportConfig(value = "损失金额", width = 116)
    private java.lang.Double lossMoney;
    /**
     * 属性备注/备注
     */
    @ExportConfig(value = "清单备注", width = 116)
    private String remark;
    /** 数据来源*/
    private String origin;
    private String nodeOrigin;
    @ExportConfig(value="客户签字")
    private String customer;
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
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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