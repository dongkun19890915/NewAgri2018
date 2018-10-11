package com.sinosoft.agriprpall.api.endorsemanage.dto;

public class PrpPsubsidyDto {
    private static final long serialVersionUID = 1L;
    /** 属性批单号/批单号 */
    private String endorseNo ;
    /** 属性保单号/保单号 */
    private String policyNo ;
    /** 属性合同号/合同号 */
    private String contractNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性险类代码/险类代码 */
    private String classCode ;
    /** 属性机构代码/机构代码 */
    private String comCode ;
    /** 属性币别信息/币别信息 */
    private String currency ;
    /** 属性benchMarkPremium/benchMarkPremium */
    private Double benchmarkPremium ;
    /** 属性subsidyCode/subsidyCode */
    private String subsidyCode ;
    /** 属性subsidyName/subsidyName */
    private String subsidyName ;
    /** 属性subsidyType/subsidyType */
    private String subsidyType ;
    /** 属性subsidyTypeName/subsidyTypeName */
    private String subsidyTypeName ;
    /** 属性subsidyDepartment/subsidyDepartment */
    private String subsidyDepartment ;
    /** 属性subsidyRate/subsidyRate */
    private Double subsidyRate ;
    /** 属性subsidyPremium/subsidyPremium */
    private Double subsidyPremium ;
    /** 属性chgBenchMarkPremium/chgBenchMarkPremium */
    private Integer chgBenchmarkPremium ;
    /** 属性chgSubsidyRate/chgSubsidyRate */
    private Integer chgSubsidyRate ;
    /** 属性chgSubsidyPremium/chgSubsidyPremium */
    private Integer chgSubsidyPremium ;
    /** 属性operationFlag/operationFlag */
    private String operationFlag ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBenchmarkPremium() {
        return benchmarkPremium;
    }

    public void setBenchmarkPremium(Double benchmarkPremium) {
        this.benchmarkPremium = benchmarkPremium;
    }

    public String getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String subsidyCode) {
        this.subsidyCode = subsidyCode;
    }

    public String getSubsidyName() {
        return subsidyName;
    }

    public void setSubsidyName(String subsidyName) {
        this.subsidyName = subsidyName;
    }

    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
    }

    public String getSubsidyTypeName() {
        return subsidyTypeName;
    }

    public void setSubsidyTypeName(String subsidyTypeName) {
        this.subsidyTypeName = subsidyTypeName;
    }

    public String getSubsidyDepartment() {
        return subsidyDepartment;
    }

    public void setSubsidyDepartment(String subsidyDepartment) {
        this.subsidyDepartment = subsidyDepartment;
    }

    public Double getSubsidyRate() {
        return subsidyRate;
    }

    public void setSubsidyRate(Double subsidyRate) {
        this.subsidyRate = subsidyRate;
    }

    public Double getSubsidyPremium() {
        return subsidyPremium;
    }

    public void setSubsidyPremium(Double subsidyPremium) {
        this.subsidyPremium = subsidyPremium;
    }

    public Integer getChgBenchmarkPremium() {
        return chgBenchmarkPremium;
    }

    public void setChgBenchmarkPremium(Integer chgBenchmarkPremium) {
        this.chgBenchmarkPremium = chgBenchmarkPremium;
    }

    public Integer getChgSubsidyRate() {
        return chgSubsidyRate;
    }

    public void setChgSubsidyRate(Integer chgSubsidyRate) {
        this.chgSubsidyRate = chgSubsidyRate;
    }

    public Integer getChgSubsidyPremium() {
        return chgSubsidyPremium;
    }

    public void setChgSubsidyPremium(Integer chgSubsidyPremium) {
        this.chgSubsidyPremium = chgSubsidyPremium;
    }

    public String getOperationFlag() {
        return operationFlag;
    }

    public void setOperationFlag(String operationFlag) {
        this.operationFlag = operationFlag;
    }
}
