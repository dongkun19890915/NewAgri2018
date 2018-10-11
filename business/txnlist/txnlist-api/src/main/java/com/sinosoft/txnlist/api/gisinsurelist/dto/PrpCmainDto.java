package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-25 00:11:08.712
 * 保单信息主表Api操作对象
 */
public class PrpCmainDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String proposalNo;

    private String policyNo;

    private String riskCode;

    private String riskName;

    private String appliName;

    private String insuredName;

    private String currency;

    private Double sumAmount;

    private Double sumPremium;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    private String comCode;

    private String comName;

    private String makeCom;

    private String makeComName;

    private String operatorName;

    private String underwriteName;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date underwriteEndDate;

    private List<PrpCitemKindDto> itemKindInfoList;

    public List<PrpCitemKindDto> getItemKindInfoList() {
        return itemKindInfoList;
    }

    public void setItemKindInfoList(List<PrpCitemKindDto> itemKindInfoList) {
        this.itemKindInfoList = itemKindInfoList;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
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

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(double sumPremium) {
        this.sumPremium = sumPremium;
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

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getMakeComName() {
        return makeComName;
    }

    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUnderwriteName() {
        return underwriteName;
    }

    public void setUnderwriteName(String underwriteName) {
        this.underwriteName = underwriteName;
    }

    public Date getUnderwriteEndDate() {
        return underwriteEndDate;
    }

    public void setUnderwriteEndDate(Date underwriteEndDate) {
        this.underwriteEndDate = underwriteEndDate;
    }
}