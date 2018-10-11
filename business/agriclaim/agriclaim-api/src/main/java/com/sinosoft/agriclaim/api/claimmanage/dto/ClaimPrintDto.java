package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

/**@description 理赔打印传入参数Dto
* @Author: 王志文
* @Date: 2017/11/6 14:08
*/
public class ClaimPrintDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 保单号 */
    private String policyNo;
    /** 立案号 */
    private String claimNo;
    /** 报案号 */
    private String registNo;
    /** 结案号 */
    private String caseNo;
    /** 赔款计算书号 */
    private String compensateNo;
    /** 被保险人姓名 */
    private String insuredName;
    /** 险种大类 */
    private String riskClaimType;  //种植  养殖   全部
    /** 操作时间起期 */
    private String handleTimeStart;
    /** 操作时间止期 */
    private String handleTimeEnd;
    /** 案件状态 */
    private String caseType;//caseType '案件性质:0 已注销，1 已拒赔，2 已结案 空值表示未结案';prpLCompensate
    /** 打印类型 */
    private List<String> printType;

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
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

    public String getRiskClaimType() {
        return riskClaimType;
    }

    public void setRiskClaimType(String riskClaimType) {
        this.riskClaimType = riskClaimType;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getHandleTimeStart() {
        return handleTimeStart;
    }

    public void setHandleTimeStart(String handleTimeStart) {
        this.handleTimeStart = handleTimeStart;
    }

    public String getHandleTimeEnd() {
        return handleTimeEnd;
    }

    public void setHandleTimeEnd(String handleTimeEnd) {
        this.handleTimeEnd = handleTimeEnd;
    }

    public List<String> getPrintType() {
        return printType;
    }

    public void setPrintType(List<String> printType) {
        this.printType = printType;
    }
}
