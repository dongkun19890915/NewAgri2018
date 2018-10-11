package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ResponsePlantingLossRateListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性序号/序号
     */
    @ExportConfig(value = "序号", width = 37)
    private String serialNo;
    /**清单号*/
    @ExportConfig(value="清单号",width = 47)
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
    /** 证件号码*/
    @ExportConfig(value = "证件号码",width = 67)
    private String fidCard;
    /**
     * 属性农户田块代码/农户田块代码
     */
    //@ExportConfig(value = "农户田块代码")
    private String fAreaCode;
    @ExportConfig(value="标的")
    private String itemCode;
    /*@ExportConfig(value="险别")*/
    private String kindCode;
    /**
     * 属性承保面积(亩)/承保面积(亩)
     */
    @ExportConfig(value = "承保面积(亩)", width = 116)
    private Double insureArea;
    /** 属性损失面积/损失面积 */
    @ExportConfig(value = "损失面积(亩)",width = 116)
    private java.lang.Double lossAmount ;
    /** 属性损失率/损失率 */
    @ExportConfig(value = "损失率(%)",width = 116)
    private java.lang.Double lossRate ;
    @ExportConfig(value="连带被保险人姓名")
    private String name;
    @ExportConfig(value="贷款合同编号")
    private String versionNo;
    @ExportConfig(value="赔偿金额")
    private Double lossMoney;
    /**
     * 属性备注/备注
     */
    @ExportConfig(value = "清单备注", width = 116)
    private String remark;
    @ExportConfig(value="客户签字",width = 100)
    private String customer;
    /** 数据来源*/
    private String origin;
    /** 节点来源*/
    private String nodeOrigin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Double getLossMoney() {
        return lossMoney;
    }

    public void setLossMoney(Double lossMoney) {
        this.lossMoney = lossMoney;
    }

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
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

    public String getLossListCode() {
        return lossListCode;
    }

    public void setLossListCode(String lossListCode) {
        this.lossListCode = lossListCode;
    }

    public String getFidCard() {
        return fidCard;
    }

    public void setFidCard(String fidCard) {
        this.fidCard = fidCard;
    }

    public String getfAreaCode() {
        return fAreaCode;
    }

    public void setfAreaCode(String fAreaCode) {
        this.fAreaCode = fAreaCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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
}