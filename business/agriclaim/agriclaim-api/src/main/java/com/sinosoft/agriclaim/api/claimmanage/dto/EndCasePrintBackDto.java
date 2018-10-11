package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description: （结案报告打印返回数据Dto）
 * @Author: 王志文
 * @Date: 2017/11/14 14:56
 */
public class EndCasePrintBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 险种名称 */
    private String riskCName;
    /** 被保险人名称 */
    private String insuredName;
    /** 保单号 */
    private String policyNo;
    /** 保险金额 */
    private String sumAmount;
    /** 保费 */
    private String sumPremium;
    /** 出险日期 */
    private String damageStartDate;
    /** 出险地点 */
    private String damageAddress;
    /** 结案报告 */
    private String tempContext;

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public String getDamageAddress() {
        return damageAddress;
    }

    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress;
    }

    public String getTempContext() {
        return tempContext;
    }

    public void setTempContext(String tempContext) {
        this.tempContext = tempContext;
    }
}
