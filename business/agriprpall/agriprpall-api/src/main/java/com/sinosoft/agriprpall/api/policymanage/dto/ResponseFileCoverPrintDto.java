package com.sinosoft.agriprpall.api.policymanage.dto;


import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @Description: 缴费计划打印
 * @Author: 潘峰
 * @Date: 2017/10/18 16:19
 */
public class ResponseFileCoverPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 属性保单代码
     */
    private String policyNo;

    /**
     * 属性被保险人名称/被保险人名称
     */
    private String insuredName;

    /**
     * 属性险种代码 /险种代码
     */
    private String riskName;
    /**
     * 属性业务归属机构代码 /业务归属机构代码
     */
    private String comName;

    /**
     * 属性统计口径的承保数量/统计口径的承保数量
     */
    private Double statQuantity;

    /**
     * 属性总保险费/总保险费
     */
    private Double sumPremium;

    /**
     * 属性总保险金额(折算为人民币总保额)--**对于预约货运，记录预收保额 /总保险金额(折算为人民币总保额)--**对于预约货运，记录预收保额
     */
    private Double sumAmount;

    //币别
    private String currency;

    private String codeCName;

    public String getCodeCName() {
        return codeCName;
    }

    public void setCodeCName(String codeCName) {
        this.codeCName = codeCName;
    }

    public ResponseFileCoverPrintDto() {
    }

    public ResponseFileCoverPrintDto(String policyNo, String insuredName, String riskName, String comName, Double statQuantity, Double sumPremium, Double sumAmount, String currency) {
        this.policyNo = policyNo;
        this.insuredName = insuredName;
        this.riskName = riskName;
        this.comName = comName;
        this.statQuantity = statQuantity;
        this.sumPremium = sumPremium;
        this.sumAmount = sumAmount;
        this.currency = currency;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }


    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Double getStatQuantity() {
        return statQuantity;
    }

    public void setStatQuantity(Double statQuantity) {
        this.statQuantity = statQuantity;
    }

    public Double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
}
