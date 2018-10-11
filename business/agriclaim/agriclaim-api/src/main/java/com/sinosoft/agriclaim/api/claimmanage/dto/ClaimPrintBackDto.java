package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**@description 理赔打印查询返回参数Dto
* @Author: 王志文
* @Date: 2017/11/6 14:09
*/
public class ClaimPrintBackDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 理算书号 */
    private String compensateNo;
    /** 保单号 */
    private String policyNo;
    /** 报案号 */
    private String registNo;
    /** 业务号 */
    private String businessNo;
    /** 被保险人名称 */
    private String insuredName;
    /** 报案日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDate;
    /** 险种名称  */
    private String riskCName;
    /** 出险标的 */
    private List<String> itemCName;
    /** 案件类型 */
    private String caseType;
    /** 允许的打印类型 */
    private List<String> allowedPrintType;

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public List<String> getItemCName() {
        return itemCName;
    }

    public void setItemCName(List<String> itemCName) {
        this.itemCName = itemCName;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public List<String> getAllowedPrintType() {
        return allowedPrintType;
    }

    public void setAllowedPrintType(List<String> allowedPrintType) {
        this.allowedPrintType = allowedPrintType;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }
}
