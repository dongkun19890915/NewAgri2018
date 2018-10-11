package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;

import java.util.List;

/**
* 关联查询返回的单号Dto
* @Author: 宋振振
* @Date: 14:19 2017/11/10
*/
public class QueryRelationResponseDto {
    private String proposalNo;
    private String policyNo;
    private String endorseNo;
    private String endorType;
    private String receiptNoPay;//收费
    private String receiptNoRef;//付费
    private String claimNo;//立案
    private String preCompensateNo;//预赔
    private String compensateNo;//实赔
    private String riskCode;
    private String repolicyNo;//再保
    private String unitCertiNo;//风险累积
    private String oldPolicyNo;//被续保保单
    private String versionNo;
    private String versionType;
    private String classCode;
    private String riskClass;
    private String registNo;

    private List<PrpPheadDto> prpPheadDtoList;//批单
    private List<PrpLClaimDto> prpLclaimDtoList;//报案
    private List<PrpLRegistDto> prpLRegistDtoList;//立案
    private List<PrpLPrepayDto> prpLPrepayDtoList;//预赔
    private List<PrpLCompensateDto> prpLCompensateDtoList;//实赔

    public List<PrpLClaimDto> getPrpLclaimDtoList() {
        return prpLclaimDtoList;
    }

    public void setPrpLclaimDtoList(List<PrpLClaimDto> prpLclaimDtoList) {
        this.prpLclaimDtoList = prpLclaimDtoList;
    }

    public List<PrpLRegistDto> getPrpLRegistDtoList() {
        return prpLRegistDtoList;
    }

    public void setPrpLRegistDtoList(List<PrpLRegistDto> prpLRegistDtoList) {
        this.prpLRegistDtoList = prpLRegistDtoList;
    }

    public List<PrpLPrepayDto> getPrpLPrepayDtoList() {
        return prpLPrepayDtoList;
    }

    public void setPrpLPrepayDtoList(List<PrpLPrepayDto> prpLPrepayDtoList) {
        this.prpLPrepayDtoList = prpLPrepayDtoList;
    }

    public List<PrpLCompensateDto> getPrpLCompensateDtoList() {
        return prpLCompensateDtoList;
    }

    public void setPrpLCompensateDtoList(List<PrpLCompensateDto> prpLCompensateDtoList) {
        this.prpLCompensateDtoList = prpLCompensateDtoList;
    }

    public List<PrpPheadDto> getPrpPheadDtoList() {
        return prpPheadDtoList;
    }

    public void setPrpPheadDtoList(List<PrpPheadDto> prpPheadDtoList) {
        this.prpPheadDtoList = prpPheadDtoList;
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

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
    }

    public String getReceiptNoPay() {
        return receiptNoPay;
    }

    public void setReceiptNoPay(String receiptNoPay) {
        this.receiptNoPay = receiptNoPay;
    }

    public String getReceiptNoRef() {
        return receiptNoRef;
    }

    public void setReceiptNoRef(String receiptNoRef) {
        this.receiptNoRef = receiptNoRef;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getPreCompensateNo() {
        return preCompensateNo;
    }

    public void setPreCompensateNo(String preCompensateNo) {
        this.preCompensateNo = preCompensateNo;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRepolicyNo() {
        return repolicyNo;
    }

    public void setRepolicyNo(String repolicyNo) {
        this.repolicyNo = repolicyNo;
    }

    public String getUnitCertiNo() {
        return unitCertiNo;
    }

    public void setUnitCertiNo(String unitCertiNo) {
        this.unitCertiNo = unitCertiNo;
    }

    public String getOldPolicyNo() {
        return oldPolicyNo;
    }

    public void setOldPolicyNo(String oldPolicyNo) {
        this.oldPolicyNo = oldPolicyNo;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskClass() {
        return riskClass;
    }

    public void setRiskClass(String riskClass) {
        this.riskClass = riskClass;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }
}
