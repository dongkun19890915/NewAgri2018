package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 案情调查信息表Api操作对象
 */
public class PrpLInvestigateDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private java.lang.Double serialNo ;		
	/** 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论 */
	private String objectType ;		
	/** 属性被调查人姓名/被调查人姓名 */
	private String informantName ;		
	/** 属性被调查人身份/被调查人身份 */
	private String informantStatus ;		
	/** 属性调查对象名称/调查对象名称 */
	private String objectName ;		
	/** 属性调查对象单位/调查对象单位 */
	private String objectUnit ;		
	/** 属性调查对象地址/调查对象地址 */
	private String objectAddress ;		
	/** 属性调查对象电话/调查对象电话 */
	private String objectPhone ;		
	/** 属性调查对象年收入/调查对象年收入 */
	private java.lang.Double yearIncome ;		
	/** 属性调查对象身份证号码/调查对象身份证号码 */
	private String identifyNumber ;		
	/** 属性调查对象营业执照号码/调查对象营业执照号码 */
	private String businessCode ;		
	/** 属性贷款金额/贷款金额 */
	private java.lang.Double loanAmount ;		
	/** 属性还款金额/还款金额 */
	private java.lang.Double sumRepaid ;		
	/** 属性尚欠金额/尚欠金额 */
	private java.lang.Double arrearageCorpus ;		
	/** 属性最后还款日期/最后还款日期 */
	private java.util.Date lastRepaidDate ;		
	/** 属性欠款时间/欠款时间 */
	private java.util.Date arrearageDate ;		
	/** 属性牌照号码/牌照号码 */
	private String licenseNo ;		
	/** 属性厂牌型号/厂牌型号 */
	private String brandName ;		
	/** 属性车辆价格/车辆价格 */
	private java.lang.Double purchasePrice ;		
	/** 属性发动机号/发动机号 */
	private String engineNo ;		
	/** 属性车架号/车架号 */
	private String frameNo ;		
	/** 属性车辆用途/车辆用途 */
	private String useNature ;		
	/** 属性购车日期/购车日期 */
	private java.util.Date purchaseDate ;		
	/** 属性初次登记日期/初次登记日期 */
	private java.util.Date enrollDate ;		
	/** 属性抵押登记单位/抵押登记单位 */
	private String inpawnEnrollDept ;		
	/** 属性抵押登记日期/抵押登记日期 */
	private java.util.Date inpawnEnrollDate ;		
	/** 属性抵押物名称/抵押物名称 */
	private String guarantyName ;		
	/** 属性抵押物是否收回(y/n)/抵押物是否收回(y/n) */
	private String guarantyRetractFlg ;		
	/** 属性抵押物估价/抵押物估价 */
	private java.lang.Double guarantyAssessment ;		
	/** 属性售车款收取方式 1.一次性收取 2.银行代收/售车款收取方式 1.一次性收取 2.银行代收 */
	private String gatheringWay ;		
	/** 属性欠款原因代码/欠款原因代码 */
	private String arrearReasonCode ;		
	/** 属性欠款原因/欠款原因 */
	private String arrearReasonName ;		
	/** 属性调查情况/调查情况 */
	private String remark ;		
	/** 属性调查结论/调查结论 */
	private String conclution ;		
	/** 属性调查者/调查者 */
	private String investigator ;		
	/** 属性调查时间/调查时间 */
	private java.util.Date investigateDate ;		
	/** 属性标记/标记 */
	private String flag ;		
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论的getter方法
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * 属性调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论/调查对象类型 1.被保人 2.购车人 3.贷款车辆 4.担保人 5.售车商 6.其他方 7.调查结论的setter方法
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}	
	/**
	 * 属性被调查人姓名/被调查人姓名的getter方法
	 */
	public String getInformantName() {
		return informantName;
	}
	/**
	 * 属性被调查人姓名/被调查人姓名的setter方法
	 */
	public void setInformantName(String informantName) {
		this.informantName = informantName;
	}	
	/**
	 * 属性被调查人身份/被调查人身份的getter方法
	 */
	public String getInformantStatus() {
		return informantStatus;
	}
	/**
	 * 属性被调查人身份/被调查人身份的setter方法
	 */
	public void setInformantStatus(String informantStatus) {
		this.informantStatus = informantStatus;
	}	
	/**
	 * 属性调查对象名称/调查对象名称的getter方法
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * 属性调查对象名称/调查对象名称的setter方法
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}	
	/**
	 * 属性调查对象单位/调查对象单位的getter方法
	 */
	public String getObjectUnit() {
		return objectUnit;
	}
	/**
	 * 属性调查对象单位/调查对象单位的setter方法
	 */
	public void setObjectUnit(String objectUnit) {
		this.objectUnit = objectUnit;
	}	
	/**
	 * 属性调查对象地址/调查对象地址的getter方法
	 */
	public String getObjectAddress() {
		return objectAddress;
	}
	/**
	 * 属性调查对象地址/调查对象地址的setter方法
	 */
	public void setObjectAddress(String objectAddress) {
		this.objectAddress = objectAddress;
	}	
	/**
	 * 属性调查对象电话/调查对象电话的getter方法
	 */
	public String getObjectPhone() {
		return objectPhone;
	}
	/**
	 * 属性调查对象电话/调查对象电话的setter方法
	 */
	public void setObjectPhone(String objectPhone) {
		this.objectPhone = objectPhone;
	}	
	/**
	 * 属性调查对象年收入/调查对象年收入的getter方法
	 */
	public java.lang.Double getYearIncome() {
		return yearIncome;
	}
	/**
	 * 属性调查对象年收入/调查对象年收入的setter方法
	 */
	public void setYearIncome(java.lang.Double yearIncome) {
		this.yearIncome = yearIncome;
	}	
	/**
	 * 属性调查对象身份证号码/调查对象身份证号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性调查对象身份证号码/调查对象身份证号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性调查对象营业执照号码/调查对象营业执照号码的getter方法
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 属性调查对象营业执照号码/调查对象营业执照号码的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}	
	/**
	 * 属性贷款金额/贷款金额的getter方法
	 */
	public java.lang.Double getLoanAmount() {
		return loanAmount;
	}
	/**
	 * 属性贷款金额/贷款金额的setter方法
	 */
	public void setLoanAmount(java.lang.Double loanAmount) {
		this.loanAmount = loanAmount;
	}	
	/**
	 * 属性还款金额/还款金额的getter方法
	 */
	public java.lang.Double getSumRepaid() {
		return sumRepaid;
	}
	/**
	 * 属性还款金额/还款金额的setter方法
	 */
	public void setSumRepaid(java.lang.Double sumRepaid) {
		this.sumRepaid = sumRepaid;
	}	
	/**
	 * 属性尚欠金额/尚欠金额的getter方法
	 */
	public java.lang.Double getArrearageCorpus() {
		return arrearageCorpus;
	}
	/**
	 * 属性尚欠金额/尚欠金额的setter方法
	 */
	public void setArrearageCorpus(java.lang.Double arrearageCorpus) {
		this.arrearageCorpus = arrearageCorpus;
	}	
	/**
	 * 属性最后还款日期/最后还款日期的getter方法
	 */
	public java.util.Date getLastRepaidDate() {
		return lastRepaidDate;
	}
	/**
	 * 属性最后还款日期/最后还款日期的setter方法
	 */
	public void setLastRepaidDate(java.util.Date lastRepaidDate) {
		this.lastRepaidDate = lastRepaidDate;
	}	
	/**
	 * 属性欠款时间/欠款时间的getter方法
	 */
	public java.util.Date getArrearageDate() {
		return arrearageDate;
	}
	/**
	 * 属性欠款时间/欠款时间的setter方法
	 */
	public void setArrearageDate(java.util.Date arrearageDate) {
		this.arrearageDate = arrearageDate;
	}	
	/**
	 * 属性牌照号码/牌照号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性牌照号码/牌照号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}	
	/**
	 * 属性厂牌型号/厂牌型号的getter方法
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 属性厂牌型号/厂牌型号的setter方法
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}	
	/**
	 * 属性车辆价格/车辆价格的getter方法
	 */
	public java.lang.Double getPurchasePrice() {
		return purchasePrice;
	}
	/**
	 * 属性车辆价格/车辆价格的setter方法
	 */
	public void setPurchasePrice(java.lang.Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}	
	/**
	 * 属性发动机号/发动机号的getter方法
	 */
	public String getEngineNo() {
		return engineNo;
	}
	/**
	 * 属性发动机号/发动机号的setter方法
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}	
	/**
	 * 属性车架号/车架号的getter方法
	 */
	public String getFrameNo() {
		return frameNo;
	}
	/**
	 * 属性车架号/车架号的setter方法
	 */
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}	
	/**
	 * 属性车辆用途/车辆用途的getter方法
	 */
	public String getUseNature() {
		return useNature;
	}
	/**
	 * 属性车辆用途/车辆用途的setter方法
	 */
	public void setUseNature(String useNature) {
		this.useNature = useNature;
	}	
	/**
	 * 属性购车日期/购车日期的getter方法
	 */
	public java.util.Date getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * 属性购车日期/购车日期的setter方法
	 */
	public void setPurchaseDate(java.util.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}	
	/**
	 * 属性初次登记日期/初次登记日期的getter方法
	 */
	public java.util.Date getEnrollDate() {
		return enrollDate;
	}
	/**
	 * 属性初次登记日期/初次登记日期的setter方法
	 */
	public void setEnrollDate(java.util.Date enrollDate) {
		this.enrollDate = enrollDate;
	}	
	/**
	 * 属性抵押登记单位/抵押登记单位的getter方法
	 */
	public String getInpawnEnrollDept() {
		return inpawnEnrollDept;
	}
	/**
	 * 属性抵押登记单位/抵押登记单位的setter方法
	 */
	public void setInpawnEnrollDept(String inpawnEnrollDept) {
		this.inpawnEnrollDept = inpawnEnrollDept;
	}	
	/**
	 * 属性抵押登记日期/抵押登记日期的getter方法
	 */
	public java.util.Date getInpawnEnrollDate() {
		return inpawnEnrollDate;
	}
	/**
	 * 属性抵押登记日期/抵押登记日期的setter方法
	 */
	public void setInpawnEnrollDate(java.util.Date inpawnEnrollDate) {
		this.inpawnEnrollDate = inpawnEnrollDate;
	}	
	/**
	 * 属性抵押物名称/抵押物名称的getter方法
	 */
	public String getGuarantyName() {
		return guarantyName;
	}
	/**
	 * 属性抵押物名称/抵押物名称的setter方法
	 */
	public void setGuarantyName(String guarantyName) {
		this.guarantyName = guarantyName;
	}	
	/**
	 * 属性抵押物是否收回(y/n)/抵押物是否收回(y/n)的getter方法
	 */
	public String getGuarantyRetractFlg() {
		return guarantyRetractFlg;
	}
	/**
	 * 属性抵押物是否收回(y/n)/抵押物是否收回(y/n)的setter方法
	 */
	public void setGuarantyRetractFlg(String guarantyRetractFlg) {
		this.guarantyRetractFlg = guarantyRetractFlg;
	}	
	/**
	 * 属性抵押物估价/抵押物估价的getter方法
	 */
	public java.lang.Double getGuarantyAssessment() {
		return guarantyAssessment;
	}
	/**
	 * 属性抵押物估价/抵押物估价的setter方法
	 */
	public void setGuarantyAssessment(java.lang.Double guarantyAssessment) {
		this.guarantyAssessment = guarantyAssessment;
	}	
	/**
	 * 属性售车款收取方式 1.一次性收取 2.银行代收/售车款收取方式 1.一次性收取 2.银行代收的getter方法
	 */
	public String getGatheringWay() {
		return gatheringWay;
	}
	/**
	 * 属性售车款收取方式 1.一次性收取 2.银行代收/售车款收取方式 1.一次性收取 2.银行代收的setter方法
	 */
	public void setGatheringWay(String gatheringWay) {
		this.gatheringWay = gatheringWay;
	}	
	/**
	 * 属性欠款原因代码/欠款原因代码的getter方法
	 */
	public String getArrearReasonCode() {
		return arrearReasonCode;
	}
	/**
	 * 属性欠款原因代码/欠款原因代码的setter方法
	 */
	public void setArrearReasonCode(String arrearReasonCode) {
		this.arrearReasonCode = arrearReasonCode;
	}	
	/**
	 * 属性欠款原因/欠款原因的getter方法
	 */
	public String getArrearReasonName() {
		return arrearReasonName;
	}
	/**
	 * 属性欠款原因/欠款原因的setter方法
	 */
	public void setArrearReasonName(String arrearReasonName) {
		this.arrearReasonName = arrearReasonName;
	}	
	/**
	 * 属性调查情况/调查情况的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性调查情况/调查情况的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性调查结论/调查结论的getter方法
	 */
	public String getConclution() {
		return conclution;
	}
	/**
	 * 属性调查结论/调查结论的setter方法
	 */
	public void setConclution(String conclution) {
		this.conclution = conclution;
	}	
	/**
	 * 属性调查者/调查者的getter方法
	 */
	public String getInvestigator() {
		return investigator;
	}
	/**
	 * 属性调查者/调查者的setter方法
	 */
	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}	
	/**
	 * 属性调查时间/调查时间的getter方法
	 */
	public java.util.Date getInvestigateDate() {
		return investigateDate;
	}
	/**
	 * 属性调查时间/调查时间的setter方法
	 */
	public void setInvestigateDate(java.util.Date investigateDate) {
		this.investigateDate = investigateDate;
	}	
	/**
	 * 属性标记/标记的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标记/标记的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
