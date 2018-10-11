package com.sinosoft.uap.dto;

public class BodyRequestDto {
	
	/** 属性投保单号码/投保单号码 */
	private String proposalNo ;		
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性交费次数序号/交费次数序号 、 属性重开赔案次数/重开赔案次数 */
	private String serialNo ;
	/** 属性保单号码 /保单号码  */
	private String policyNo ;
	/** 属性关系人标识 /关系人标识  */
	private String insuredFlag;
	/** 属性立案号码/立案号码 */
	private String claimNo ;
	/** 属性赔款计算书号码/赔款计算书号码 */
	private String compensateNo ;
	/** 属性预赔号/预赔号 */
	private String preCompensateNo ;
	/** 属性报案号码/报案号码 */
	private String registNo ;
	/** 属性业务号码/业务号码 */
	private String businessNo ;
	/** 属性业务类型/业务类型 */
	private String businessType ;
	/** 属性单证号/单证号 */
	private String certiNo ;
	/** 属性单证类型/单证类型 */
	private String certiType ;
	/** 属性结案号/结案号 */
	private String caseNo ;	
	/** 属性险种/险种 */
	private String riskCode ;
	/** 属性机构代码或协议代码/机构代码或协议代码 */
	private String comCode ;
	/** 属性渠道类型0直销 1渠道/渠道类型0直销 1渠道 */
	private String agentType ;
	/** 属性业务分类(A-鼓励类;B-谨慎类;C-限制类;D-其他;E-特定险)/业务分类(A-鼓励类;B-谨慎类;C-限制类;D-其他;E-特定险) */
	private String businessCategory ;
	/** 属性预赔号/预赔号 */
	private String preparNo;
	/** 属性异常标记/异常标记*/
	private String exceptionFlag;
	/** 属性异常开始标记/异常开始标记*/
	private String exceptionStartFlag;
	
	
	
	public String getPreparNo() {
		return preparNo;
	}
	public void setPreparNo(String preparNo) {
		this.preparNo = preparNo;
	}
	
	public String getExceptionFlag() {
		return exceptionFlag;
	}
	public void setExceptionFlag(String exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}
	public String getExceptionStartFlag() {
		return exceptionStartFlag;
	}
	public void setExceptionStartFlag(String exceptionStartFlag) {
		this.exceptionStartFlag = exceptionStartFlag;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getCertiNo() {
		return certiNo;
	}
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getLossItemCode() {
		return lossItemCode;
	}
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}
	/** 属性标的代码/标的代码 */
	private String lossItemCode ;	
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	public String getEndorseNo() {
		return endorseNo;
	}
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	public String getInsuredFlag() {
		return insuredFlag;
	}
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
}
