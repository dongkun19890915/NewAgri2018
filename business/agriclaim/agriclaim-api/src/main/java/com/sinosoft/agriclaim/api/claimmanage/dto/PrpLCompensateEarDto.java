package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 理赔分户清单表Api操作对象
 */
public class PrpLCompensateEarDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性农户代码/农户代码 */
	private String code;
	/** 属性耳标号/耳标号 */
	private String earNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性理算书号/理算书号 */
	private String compensateNo ;		
	/** 属性事故号/事故号 */
	private String combineNo ;		
	/** 属性案件归档号/案件归档号 */
	private String caseNo ;		
	/** 属性出险日期/出险日期 */
	private java.util.Date damageStartDate ;		
	/** 属性备用字段/备用字段 */
	private String damageStartHour ;		
	/** 属性备用字段2/备用字段2 */
	private java.util.Date damageendDate ;		
	/** 属性出险原因代码/出险原因代码 */
	private String damageCode ;		
	/** 属性出险原因说明/出险原因说明 */
	private String damageName ;		
	/** 属性农户姓名/农户姓名 */
	private String name ;		
	/** 属性农户身份证号/农户身份证号 */
	private String idCard ;		
	/** 属性开户行名称/开户行名称 */
	private String bank ;		
	/** 属性银行账号/银行账号 */
	private String account ;		
	/** 属性单位保险金额/单位保险金额 */
	private java.lang.Double unitAmount ;		
	/** 属性估损金额/估损金额 */
	private java.lang.Double estimateLoss ;		
	/** 属性残值/残值 */
	private java.lang.Double restFee ;		
	/** 属性赔付比例/赔付比例 */
	private java.lang.Double claimRate ;		
	/** 属性免赔率/免赔率 */
	private java.lang.Double deductibleRate ;		
	/** 属性免陪额/免陪额 */
	private java.lang.Double deductible ;		
	/** 属性赔偿金额/赔偿金额 */
	private java.lang.Double sumRealpay ;		
	/** 属性节点/节点 */
	private java.lang.Integer nodeNo ;		
	/** 属性节点名称/节点名称 */
	private String nodeType ;		
	/** 属性扑杀数量/扑杀数量 */
	private java.lang.Integer cullNumber ;		
	/** 属性死亡数量/死亡数量 */
	private java.lang.Integer deadNumber ;		
	/** 属性死亡原因/死亡原因 */
	private String deadReason ;		
	/** 属性原称养殖地点名称/原称养殖地点名称 */
	private String breedingAreaName ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性养殖地点代码/养殖地点代码 */
	private String breedingAreaCode ;		
	/** 属性险别序号/险别序号 */
	private String kindCode ;		
	/** 属性投保清单编号/投保清单编号 */
	private String inusreListCode ;		
	/** 属性报案时间/报案时间 */
	private String reportTime ;		
	/** 属性业务号/业务号 */
	private String businessNo ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarNo() {
		return earNo;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarNo(String earNo) {
		this.earNo = earNo;
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
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}	
	/**
	 * 属性理算书号/理算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性理算书号/理算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}	
	/**
	 * 属性事故号/事故号的getter方法
	 */
	public String getCombineNo() {
		return combineNo;
	}
	/**
	 * 属性事故号/事故号的setter方法
	 */
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}	
	/**
	 * 属性案件归档号/案件归档号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性案件归档号/案件归档号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}	
	/**
	 * 属性出险日期/出险日期的getter方法
	 */
	public java.util.Date getDamageStartDate() {
		return damageStartDate;
	}
	/**
	 * 属性出险日期/出险日期的setter方法
	 */
	public void setDamageStartDate(java.util.Date damageStartDate) {
		this.damageStartDate = damageStartDate;
	}	
	/**
	 * 属性备用字段/备用字段的getter方法
	 */
	public String getDamageStartHour() {
		return damageStartHour;
	}
	/**
	 * 属性备用字段/备用字段的setter方法
	 */
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	}	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public java.util.Date getDamageendDate() {
		return damageendDate;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setDamageendDate(java.util.Date damageendDate) {
		this.damageendDate = damageendDate;
	}	
	/**
	 * 属性出险原因代码/出险原因代码的getter方法
	 */
	public String getDamageCode() {
		return damageCode;
	}
	/**
	 * 属性出险原因代码/出险原因代码的setter方法
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}	
	/**
	 * 属性出险原因说明/出险原因说明的getter方法
	 */
	public String getDamageName() {
		return damageName;
	}
	/**
	 * 属性出险原因说明/出险原因说明的setter方法
	 */
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getName() {
		return name;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	}	
	/**
	 * 属性农户身份证号/农户身份证号的getter方法
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 属性农户身份证号/农户身份证号的setter方法
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}	
	/**
	 * 属性开户行名称/开户行名称的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户行名称/开户行名称的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}	
	/**
	 * 属性银行账号/银行账号的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性银行账号/银行账号的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	}	
	/**
	 * 属性单位保险金额/单位保险金额的getter方法
	 */
	public java.lang.Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性单位保险金额/单位保险金额的setter方法
	 */
	public void setUnitAmount(java.lang.Double unitAmount) {
		this.unitAmount = unitAmount;
	}	
	/**
	 * 属性估损金额/估损金额的getter方法
	 */
	public java.lang.Double getEstimateLoss() {
		return estimateLoss;
	}
	/**
	 * 属性估损金额/估损金额的setter方法
	 */
	public void setEstimateLoss(java.lang.Double estimateLoss) {
		this.estimateLoss = estimateLoss;
	}	
	/**
	 * 属性残值/残值的getter方法
	 */
	public java.lang.Double getRestFee() {
		return restFee;
	}
	/**
	 * 属性残值/残值的setter方法
	 */
	public void setRestFee(java.lang.Double restFee) {
		this.restFee = restFee;
	}	
	/**
	 * 属性赔付比例/赔付比例的getter方法
	 */
	public java.lang.Double getClaimRate() {
		return claimRate;
	}
	/**
	 * 属性赔付比例/赔付比例的setter方法
	 */
	public void setClaimRate(java.lang.Double claimRate) {
		this.claimRate = claimRate;
	}	
	/**
	 * 属性免赔率/免赔率的getter方法
	 */
	public java.lang.Double getDeductibleRate() {
		return deductibleRate;
	}
	/**
	 * 属性免赔率/免赔率的setter方法
	 */
	public void setDeductibleRate(java.lang.Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	}	
	/**
	 * 属性免陪额/免陪额的getter方法
	 */
	public java.lang.Double getDeductible() {
		return deductible;
	}
	/**
	 * 属性免陪额/免陪额的setter方法
	 */
	public void setDeductible(java.lang.Double deductible) {
		this.deductible = deductible;
	}	
	/**
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Double getSumRealpay() {
		return sumRealpay;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSumRealpay(java.lang.Double sumRealpay) {
		this.sumRealpay = sumRealpay;
	}	
	/**
	 * 属性节点/节点的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性节点/节点的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	}	
	/**
	 * 属性节点名称/节点名称的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点名称/节点名称的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}	
	/**
	 * 属性扑杀数量/扑杀数量的getter方法
	 */
	public java.lang.Integer getCullNumber() {
		return cullNumber;
	}
	/**
	 * 属性扑杀数量/扑杀数量的setter方法
	 */
	public void setCullNumber(java.lang.Integer cullNumber) {
		this.cullNumber = cullNumber;
	}	
	/**
	 * 属性死亡数量/死亡数量的getter方法
	 */
	public java.lang.Integer getDeadNumber() {
		return deadNumber;
	}
	/**
	 * 属性死亡数量/死亡数量的setter方法
	 */
	public void setDeadNumber(java.lang.Integer deadNumber) {
		this.deadNumber = deadNumber;
	}	
	/**
	 * 属性死亡原因/死亡原因的getter方法
	 */
	public String getDeadReason() {
		return deadReason;
	}
	/**
	 * 属性死亡原因/死亡原因的setter方法
	 */
	public void setDeadReason(String deadReason) {
		this.deadReason = deadReason;
	}	
	/**
	 * 属性原称养殖地点名称/原称养殖地点名称的getter方法
	 */
	public String getBreedingAreaName() {
		return breedingAreaName;
	}
	/**
	 * 属性原称养殖地点名称/原称养殖地点名称的setter方法
	 */
	public void setBreedingAreaName(String breedingAreaName) {
		this.breedingAreaName = breedingAreaName;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	}	
	/**
	 * 属性养殖地点代码/养殖地点代码的getter方法
	 */
	public String getBreedingAreaCode() {
		return breedingAreaCode;
	}
	/**
	 * 属性养殖地点代码/养殖地点代码的setter方法
	 */
	public void setBreedingAreaCode(String breedingAreaCode) {
		this.breedingAreaCode = breedingAreaCode;
	}	
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性投保清单编号/投保清单编号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单编号/投保清单编号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	}	
	/**
	 * 属性报案时间/报案时间的getter方法
	 */
	public String getReportTime() {
		return reportTime;
	}
	/**
	 * 属性报案时间/报案时间的setter方法
	 */
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}	
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
}
