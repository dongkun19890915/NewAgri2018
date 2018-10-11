package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘/代查勘信息表实体操作对象
 */
@Entity
@Table(name = "PrpLCheck")
@IdClass(PrpLCheckKey.class)
public class PrpLCheck extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性关联理赔车辆序号/关联理赔车辆序号 */
	@Id
	@Column(name = "referSerialNo")
	private java.lang.Integer referSerialNo ;	

	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性查勘类型/查勘类型 */
	@Column(name = "checkType")
	private String checkType ;
	/** 属性查勘/代查勘性质/查勘/代查勘性质 */
	@Column(name = "checkNature")
	private String checkNature ;
	/** 属性查勘/代查勘日期/查勘/代查勘日期 */
	@Column(name = "checkDate")
	private java.util.Date checkDate ;
	/** 属性查勘/代查勘地点/查勘/代查勘地点 */
	@Column(name = "checkSite")
	private String checkSite ;
	/** 属性是否第一现场/是否第一现场 */
	@Column(name = "firstSiteFlag")
	private String firstSiteFlag ;
	/** 属性案件类型/案件类型 */
	@Column(name = "claimType")
	private String claimType ;
	/** 属性出险原因代码/出险原因代码 */
	@Column(name = "damageCode")
	private String damageCode ;
	/** 属性出险原因说明/出险原因说明 */
	@Column(name = "damageName")
	private String damageName ;
	/** 属性事故类型代码/事故类型代码 */
	@Column(name = "damageTypeCode")
	private String damageTypeCode ;
	/** 属性事故类型说明/事故类型说明 */
	@Column(name = "damageTypeName")
	private String damageTypeName ;
	/** 属性事故所涉及险种/事故所涉及险种 */
	@Column(name = "referKind")
	private String referKind ;
	/** 属性出险区域代码/出险区域代码 */
	@Column(name = "damageAreaCode")
	private String damageAreaCode ;
	/** 属性出险地点分类/出险地点分类 */
	@Column(name = "damageAddressType")
	private String damageAddressType ;
	/** 属性赔偿责任代码/赔偿责任代码 */
	@Column(name = "indemnityDuty")
	private String indemnityDuty ;
	/** 属性是否属于保险责任/是否属于保险责任 */
	@Column(name = "claimFlag")
	private String claimFlag ;
	/** 属性查勘/代查勘人1/查勘/代查勘人1 */
	@Column(name = "checker1")
	private String checker1 ;
	/** 属性查勘/代查勘人2/查勘/代查勘人2 */
	@Column(name = "checker2")
	private String checker2 ;
	/** 属性查勘/代查勘单位名称/查勘/代查勘单位名称 */
	@Column(name = "checkUnitName")
	private String checkUnitName ;
	/** 属性事故处理部门/事故处理部门 */
	@Column(name = "handleUnit")
	private String handleUnit ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;

	/** 属性是否为本保单车辆/是否为本保单车辆 */
	@Column(name = "insureCarFlag")
	private String insureCarFlag ;
	/** 属性是否向别的保险公司投保(Y/N)/是否向别的保险公司投保(Y/N) */
	@Column(name = "repeatInsureFlag")
	private String repeatInsureFlag ;
	/** 属性事故处理部门代码/事故处理部门代码 */
	@Column(name = "handleUnitCode")
	private String handleUnitCode ;
	/** 属性单位类型/单位类型 */
	@Column(name = "unitType")
	private String unitType ;
	/** 属性未决赔款准备金/未决赔款准备金 */
	@Column(name = "estimateFee")
	private java.lang.Double estimateFee ;
	/** 属性估损金额/估损金额 */
	@Column(name = "estimateLoss")
	private java.lang.Double estimateLoss ;
	/** 属性出险日期/出险日期 */
	@Column(name = "damageStartDate")
	private java.util.Date damageStartDate ;
	/** 属性出险小时/出险小时 */
	@Column(name = "damageStartHour")
	private String damageStartHour ;
	/** 属性出险地点/出险地点 */
	@Column(name = "damageAddress")
	private String damageAddress ;
	/** 属性查勘参与人/查勘参与人 */
	@Column(name = "checkLinker")
	private String checkLinker ;
	/** 属性是否延迟报案/是否延迟报案 */
	@Column(name = "isDelay")
	private String isDelay ;
	/** 属性延迟报案原因/延迟报案原因 */
	@Column(name = "reportDelayReason")
	private String reportDelayReason ;
	/** 属性是否通赔/是否通赔 */
	@Column(name = "isAllClaim")
	private String isAllClaim ;
	/** 属性委托类型/委托类型 */
	@Column(name = "trustType")
	private String trustType ;
	/** 属性客户类型/客户类型 */
	@Column(name = "customType")
	private String customType ;
	/** 属性快赔类型/快赔类型 */
	@Column(name = "quickClaimType")
	private String quickClaimType ;
	/** 属性伤害区域地址/伤害区域地址 */
	@Column(name = "damageareaAddress")
	private String damageareaAddress ;
	/** 属性伤害区域/伤害区域 */
	@Column(name = "damageArea")
	private String damageArea ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性查勘类型/查勘类型的getter方法
	 */
	public String getCheckType() {
		return checkType;
	}
	/**
	 * 属性查勘类型/查勘类型的setter方法
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	} 	
	/**
	 * 属性查勘/代查勘性质/查勘/代查勘性质的getter方法
	 */
	public String getCheckNature() {
		return checkNature;
	}
	/**
	 * 属性查勘/代查勘性质/查勘/代查勘性质的setter方法
	 */
	public void setCheckNature(String checkNature) {
		this.checkNature = checkNature;
	} 	
	/**
	 * 属性查勘/代查勘日期/查勘/代查勘日期的getter方法
	 */
	public java.util.Date getCheckDate() {
		return checkDate;
	}
	/**
	 * 属性查勘/代查勘日期/查勘/代查勘日期的setter方法
	 */
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	} 	
	/**
	 * 属性查勘/代查勘地点/查勘/代查勘地点的getter方法
	 */
	public String getCheckSite() {
		return checkSite;
	}
	/**
	 * 属性查勘/代查勘地点/查勘/代查勘地点的setter方法
	 */
	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	} 	
	/**
	 * 属性是否第一现场/是否第一现场的getter方法
	 */
	public String getFirstSiteFlag() {
		return firstSiteFlag;
	}
	/**
	 * 属性是否第一现场/是否第一现场的setter方法
	 */
	public void setFirstSiteFlag(String firstSiteFlag) {
		this.firstSiteFlag = firstSiteFlag;
	} 	
	/**
	 * 属性案件类型/案件类型的getter方法
	 */
	public String getClaimType() {
		return claimType;
	}
	/**
	 * 属性案件类型/案件类型的setter方法
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
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
	 * 属性事故类型代码/事故类型代码的getter方法
	 */
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	/**
	 * 属性事故类型代码/事故类型代码的setter方法
	 */
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	} 	
	/**
	 * 属性事故类型说明/事故类型说明的getter方法
	 */
	public String getDamageTypeName() {
		return damageTypeName;
	}
	/**
	 * 属性事故类型说明/事故类型说明的setter方法
	 */
	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = damageTypeName;
	} 	
	/**
	 * 属性事故所涉及险种/事故所涉及险种的getter方法
	 */
	public String getReferKind() {
		return referKind;
	}
	/**
	 * 属性事故所涉及险种/事故所涉及险种的setter方法
	 */
	public void setReferKind(String referKind) {
		this.referKind = referKind;
	} 	
	/**
	 * 属性出险区域代码/出险区域代码的getter方法
	 */
	public String getDamageAreaCode() {
		return damageAreaCode;
	}
	/**
	 * 属性出险区域代码/出险区域代码的setter方法
	 */
	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	} 	
	/**
	 * 属性出险地点分类/出险地点分类的getter方法
	 */
	public String getDamageAddressType() {
		return damageAddressType;
	}
	/**
	 * 属性出险地点分类/出险地点分类的setter方法
	 */
	public void setDamageAddressType(String damageAddressType) {
		this.damageAddressType = damageAddressType;
	} 	
	/**
	 * 属性赔偿责任代码/赔偿责任代码的getter方法
	 */
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	/**
	 * 属性赔偿责任代码/赔偿责任代码的setter方法
	 */
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	} 	
	/**
	 * 属性是否属于保险责任/是否属于保险责任的getter方法
	 */
	public String getClaimFlag() {
		return claimFlag;
	}
	/**
	 * 属性是否属于保险责任/是否属于保险责任的setter方法
	 */
	public void setClaimFlag(String claimFlag) {
		this.claimFlag = claimFlag;
	} 	
	/**
	 * 属性查勘/代查勘人1/查勘/代查勘人1的getter方法
	 */
	public String getChecker1() {
		return checker1;
	}
	/**
	 * 属性查勘/代查勘人1/查勘/代查勘人1的setter方法
	 */
	public void setChecker1(String checker1) {
		this.checker1 = checker1;
	} 	
	/**
	 * 属性查勘/代查勘人2/查勘/代查勘人2的getter方法
	 */
	public String getChecker2() {
		return checker2;
	}
	/**
	 * 属性查勘/代查勘人2/查勘/代查勘人2的setter方法
	 */
	public void setChecker2(String checker2) {
		this.checker2 = checker2;
	} 	
	/**
	 * 属性查勘/代查勘单位名称/查勘/代查勘单位名称的getter方法
	 */
	public String getCheckUnitName() {
		return checkUnitName;
	}
	/**
	 * 属性查勘/代查勘单位名称/查勘/代查勘单位名称的setter方法
	 */
	public void setCheckUnitName(String checkUnitName) {
		this.checkUnitName = checkUnitName;
	} 	
	/**
	 * 属性事故处理部门/事故处理部门的getter方法
	 */
	public String getHandleUnit() {
		return handleUnit;
	}
	/**
	 * 属性事故处理部门/事故处理部门的setter方法
	 */
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	} 	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的getter方法
	 */
	public java.lang.Integer getReferSerialNo() {
		return referSerialNo;
	}
	/**
	 * 属性关联理赔车辆序号/关联理赔车辆序号的setter方法
	 */
	public void setReferSerialNo(java.lang.Integer referSerialNo) {
		this.referSerialNo = referSerialNo;
	} 	
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的getter方法
	 */
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的setter方法
	 */
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	} 	
	/**
	 * 属性是否向别的保险公司投保(Y/N)/是否向别的保险公司投保(Y/N)的getter方法
	 */
	public String getRepeatInsureFlag() {
		return repeatInsureFlag;
	}
	/**
	 * 属性是否向别的保险公司投保(Y/N)/是否向别的保险公司投保(Y/N)的setter方法
	 */
	public void setRepeatInsureFlag(String repeatInsureFlag) {
		this.repeatInsureFlag = repeatInsureFlag;
	} 	
	/**
	 * 属性事故处理部门代码/事故处理部门代码的getter方法
	 */
	public String getHandleUnitCode() {
		return handleUnitCode;
	}
	/**
	 * 属性事故处理部门代码/事故处理部门代码的setter方法
	 */
	public void setHandleUnitCode(String handleUnitCode) {
		this.handleUnitCode = handleUnitCode;
	} 	
	/**
	 * 属性单位类型/单位类型的getter方法
	 */
	public String getUnitType() {
		return unitType;
	}
	/**
	 * 属性单位类型/单位类型的setter方法
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	} 	
	/**
	 * 属性未决赔款准备金/未决赔款准备金的getter方法
	 */
	public java.lang.Double getEstimateFee() {
		return estimateFee;
	}
	/**
	 * 属性未决赔款准备金/未决赔款准备金的setter方法
	 */
	public void setEstimateFee(java.lang.Double estimateFee) {
		this.estimateFee = estimateFee;
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
	 * 属性出险小时/出险小时的getter方法
	 */
	public String getDamageStartHour() {
		return damageStartHour;
	}
	/**
	 * 属性出险小时/出险小时的setter方法
	 */
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	} 	
	/**
	 * 属性出险地点/出险地点的getter方法
	 */
	public String getDamageAddress() {
		return damageAddress;
	}
	/**
	 * 属性出险地点/出险地点的setter方法
	 */
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	} 	
	/**
	 * 属性查勘参与人/查勘参与人的getter方法
	 */
	public String getCheckLinker() {
		return checkLinker;
	}
	/**
	 * 属性查勘参与人/查勘参与人的setter方法
	 */
	public void setCheckLinker(String checkLinker) {
		this.checkLinker = checkLinker;
	} 	
	/**
	 * 属性是否延迟报案/是否延迟报案的getter方法
	 */
	public String getIsDelay() {
		return isDelay;
	}
	/**
	 * 属性是否延迟报案/是否延迟报案的setter方法
	 */
	public void setIsDelay(String isDelay) {
		this.isDelay = isDelay;
	} 	
	/**
	 * 属性延迟报案原因/延迟报案原因的getter方法
	 */
	public String getReportDelayReason() {
		return reportDelayReason;
	}
	/**
	 * 属性延迟报案原因/延迟报案原因的setter方法
	 */
	public void setReportDelayReason(String reportDelayReason) {
		this.reportDelayReason = reportDelayReason;
	} 	
	/**
	 * 属性是否通赔/是否通赔的getter方法
	 */
	public String getIsAllClaim() {
		return isAllClaim;
	}
	/**
	 * 属性是否通赔/是否通赔的setter方法
	 */
	public void setIsAllClaim(String isAllClaim) {
		this.isAllClaim = isAllClaim;
	} 	
	/**
	 * 属性委托类型/委托类型的getter方法
	 */
	public String getTrustType() {
		return trustType;
	}
	/**
	 * 属性委托类型/委托类型的setter方法
	 */
	public void setTrustType(String trustType) {
		this.trustType = trustType;
	} 	
	/**
	 * 属性客户类型/客户类型的getter方法
	 */
	public String getCustomType() {
		return customType;
	}
	/**
	 * 属性客户类型/客户类型的setter方法
	 */
	public void setCustomType(String customType) {
		this.customType = customType;
	} 	
	/**
	 * 属性快赔类型/快赔类型的getter方法
	 */
	public String getQuickClaimType() {
		return quickClaimType;
	}
	/**
	 * 属性快赔类型/快赔类型的setter方法
	 */
	public void setQuickClaimType(String quickClaimType) {
		this.quickClaimType = quickClaimType;
	} 	
	/**
	 * 属性伤害区域地址/伤害区域地址的getter方法
	 */
	public String getDamageareaAddress() {
		return damageareaAddress;
	}
	/**
	 * 属性伤害区域地址/伤害区域地址的setter方法
	 */
	public void setDamageareaAddress(String damageareaAddress) {
		this.damageareaAddress = damageareaAddress;
	} 	
	/**
	 * 属性伤害区域/伤害区域的getter方法
	 */
	public String getDamageArea() {
		return damageArea;
	}
	/**
	 * 属性伤害区域/伤害区域的setter方法
	 */
	public void setDamageArea(String damageArea) {
		this.damageArea = damageArea;
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
}