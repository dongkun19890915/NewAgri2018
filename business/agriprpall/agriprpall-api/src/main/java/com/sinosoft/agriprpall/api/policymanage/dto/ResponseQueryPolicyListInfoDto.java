package com.sinosoft.agriprpall.api.policymanage.dto;

public class ResponseQueryPolicyListInfoDto {

    private static final long serialVersionUID = 1L;
    /** 属性投保单号/投保单号 */
    private String policyNo ;
    /** 属性合同号/合同号 */
    private String contractNo ;
    /** 属性被保险人名称/被保险人名称 */
    private String insuredName ;
    /** 属性投保人名称/投保人名称 */
    private String appliName ;
    /** 属性保险起期/保险起期 */
    private String startDate ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode ;
    /** 属性操作员名称/操作员名称 */
    private String operatorName ;
    /** 属性输入日期/输入日期 */
    private String inputDate ;
    /** 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保 */
    private String underWriteFlag ;
    /** 属性其它标志字段/其它标志字段 */
    private String othFlag ;
    /** 属性流水号*/
    private String printNo;
    /**保险止期*/
    private String endDate;

    /*险种名称*/
    private String riskName;

    /*险种代码*/
    private String riskCode;

    /*制单日期*/
    private String operateDate;

/*投保单号*/
private String proposalNo;
    /*归属机构*/
    private String comCode;
    /**商业、政策性*/
    private String businessType1;

    /**见费出单标志，0-非见费，1-见费出单*/
    private String isSeeFeeFlag;
    private String shortRateFlag;

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    public String getIsSeeFeeFlag() {
        return isSeeFeeFlag;
    }

    public void setIsSeeFeeFlag(String isSeeFeeFlag) {
        this.isSeeFeeFlag = isSeeFeeFlag;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
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

    /**
     * 属性流水号的getter方法
     */
    public String getPrintNo() {
        return printNo;
    }

    /**
     * 属性流水号的getter方法
     */
    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    /**
     * 属性保单号的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性投保单号/投保单号的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性合同号/合同号的getter方法
     */
    public String getContractNo() {
        return contractNo;
    }
    /**
     * 属性合同号/合同号的setter方法
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
    /**
     * 属性被保险人名称/被保险人名称的getter方法
     */
    public String getInsuredName() {
        return insuredName;
    }
    /**
     * 属性被保险人名称/被保险人名称的setter方法
     */
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    /**
     * 属性投保人名称/投保人名称的getter方法
     */
    public String getAppliName() {
        return appliName;
    }
    /**
     * 属性投保人名称/投保人名称的setter方法
     */
    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }
    /**
     * 属性保险起期/保险起期的getter方法
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * 属性保险起期/保险起期的setter方法
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * 属性操作员代码/操作员代码的getter方法
     */
    public String getOperatorCode() {
        return operatorCode;
    }
    /**
     * 属性操作员代码/操作员代码的setter方法
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }
    /**
     * 属性操作员名称/操作员名称的getter方法
     */
    public String getOperatorName() {
        return operatorName;
    }
    /**
     * 属性操作员名称/操作员名称的setter方法
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    /**
     * 属性输入日期/输入日期的getter方法
     */
    public String getInputDate() {
        return inputDate;
    }
    /**
     * 属性输入日期/输入日期的setter方法
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
    /**
     * 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保的getter方法
     */
    public String getUnderWriteFlag() {
        return underWriteFlag;
    }
    /**
     * 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保的setter方法
     */
    public void setUnderWriteFlag(String underWriteFlag) {
        this.underWriteFlag = underWriteFlag;
    }
    /**
     * 属性其它标志字段/其它标志字段的getter方法
     */
    public String getOthFlag() {
        return othFlag;
    }
    /**
     * 属性其它标志字段/其它标志字段的setter方法
     */
    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
