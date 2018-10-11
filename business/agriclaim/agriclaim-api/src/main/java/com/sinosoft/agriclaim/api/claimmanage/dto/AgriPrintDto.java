package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *@description 农险赔案卷宗打印 Dto类
 * @Author: 王志文
 * @Date: 2017/11/6 14:08
 */
public class AgriPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 赔案编号/立案号 */
    private String claimNo;
    /** 保单号码 */
    private String policyNo;
    /** 被保险人名称 */
    private String insuredName;
    /** 承保险种名称  */
    private String riskCName;
    /** 出险原因 */
    private String damageName;
    /** 出险时间 */
    private String damageStartDate;
    /** 理赔金额 */
    private double sumPaid;
    /** 机构名称 */
    private String comCName;

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
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

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public String getComCName() {
        return comCName;
    }

    public void setComCName(String comCName) {
        this.comCName = comCName;
    }
}
