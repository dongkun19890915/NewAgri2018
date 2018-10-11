package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案基本信息表实体操作对象
 */
@Entity
@Table(name = "PrpLClaim")
@IdClass(PrpLClaimKey.class)
public class PrpLClaim extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性立案号码/立案号码 */
	@Id
	@Column(name = "claimNo")
	private String claimNo ;	

	/** 属性理赔类型/理赔类型 */
	@Column(name = "lFlag")
	private String lFlag ;
	/** 属性赔案号/赔案号 */
	@Column(name = "caseNo")
	private String caseNo ;
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性业务性质/业务性质 */
	@Column(name = "businessNature")
	private String businessNature ;
	/** 属性语种/语种 */
	@Column(name = "language")
	private String language ;
	/** 属性保单类型/保单类型 */
	@Column(name = "policyType")
	private String policyType ;
	/** 属性被保险人代码/被保险人代码 */
	@Column(name = "insuredCode")
	private String insuredCode ;
	/** 属性被保险人名称/被保险人名称 */
	@Column(name = "insuredName")
	private String insuredName ;
	/** 属性起保日期/起保日期 */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性起保小时/起保小时 */
	@Column(name = "startHour")
	private java.lang.Integer startHour ;
	/** 属性终保日期/终保日期 */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性终保小时/终保小时 */
	@Column(name = "endHour")
	private java.lang.Integer endHour ;
	/** 属性币别代码/币别代码 */
	@Column(name = "currency")
	private String currency ;
	/** 属性总保额/总保额 */
	@Column(name = "sumAmount")
	private java.lang.Double sumAmount ;
	/** 属性总数量/总数量 */
	@Column(name = "sumPremium")
	private java.lang.Integer sumPremium ;
	/** 属性出险日期起/出险日期起 */
	@Column(name = "damageStartDate")
	private java.util.Date damageStartDate ;
	/** 属性出险开始小时/出险开始小时 */
	@Column(name = "damageStartHour")
	private String damageStartHour ;
	/** 属性出险日期止/出险日期止 */
	@Column(name = "damageEndDate")
	private java.util.Date damageEndDate ;
	/** 属性出险终止小时/出险终止小时 */
	@Column(name = "damageEndHour")
	private String damageEndHour ;
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
	/** 属性出险区域代码/出险区域代码 */
	@Column(name = "damageAreaCode")
	private String damageAreaCode ;
	/** 属性出险区域名称/出险区域名称 */
	@Column(name = "damageAreaName")
	private String damageAreaName ;
	/** 属性出险地点分类代码/出险地点分类代码 */
	@Column(name = "damageAddressType")
	private String damageAddressType ;
	/** 属性出险地代码/出险地代码 */
	@Column(name = "addressCode")
	private String addressCode ;
	/** 属性出险地点/出险地点 */
	@Column(name = "damageAddress")
	private String damageAddress ;
	/** 属性受损标的/受损标的 */
	@Column(name = "lossName")
	private String lossName ;
	/** 属性受损标的数量/出险分户数/受损标的数量/出险分户数 */
	@Column(name = "lossQuantity")
	private java.lang.Integer lossQuantity ;
	/** 属性出险险别/出险险别 */
	@Column(name = "damageKind")
	private String damageKind ;
	/** 属性立案日期/立案日期 */
	@Column(name = "claimDate")
	private java.util.Date claimDate ;
	/** 属性赔偿责任代码/赔偿责任代码 */
	@Column(name = "indemnityDuty")
	private String indemnityDuty ;
	/** 属性责任比例/责任比例 */
	@Column(name = "indemnityDutyRate")
	private java.lang.Double indemnityDutyRate ;
	/** 属性免赔率/免赔率 */
	@Column(name = "deductibleRate")
	private java.lang.Double deductibleRate ;
	/** 属性保险损失金额(同保单币别)/保险损失金额(同保单币别) */
	@Column(name = "sumClaim")
	private java.lang.Double sumClaim ;
	/** 属性总核定损金额(同保单币别)/总核定损金额(同保单币别) */
	@Column(name = "sumDefLoss")
	private java.lang.Double sumDefLoss ;
	/** 属性总赔付金额(同保单币别)/总赔付金额(同保单币别) */
	@Column(name = "sumPaid")
	private java.lang.Double sumPaid ;
	/** 属性总追偿金额(同保单币别)/总追偿金额(同保单币别) */
	@Column(name = "sumReplevy")
	private java.lang.Double sumReplevy ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性案件性质/案件性质 */
	@Column(name = "caseType")
	private String caseType ;
	/** 属性理赔登记机构代码/理赔登记机构代码 */
	@Column(name = "makeCom")
	private String makeCom ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性代理人代码/代理人代码 */
	@Column(name = "agentCode")
	private String agentCode ;
	/** 属性经办人代码/经办人代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性归属业务员代码/归属业务员代码 */
	@Column(name = "handler1Code")
	private String handler1Code ;
	/** 属性统计年月/统计年月 */
	@Column(name = "statisticsYM")
	private java.util.Date statisticsYM ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性计算机输单日期/计算机输单日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性结案日期/结案日期 */
	@Column(name = "endCaseDate")
	private java.util.Date endCaseDate ;
	/** 属性结案员代码/结案员代码 */
	@Column(name = "endCaserCode")
	private String endCaserCode ;
	/** 属性注销/拒赔日期/注销/拒赔日期 */
	@Column(name = "cancelDate")
	private java.util.Date cancelDate ;
	/** 属性注销/拒赔原因1/注销/拒赔原因1 */
	@Column(name = "cancelReason")
	private String cancelReason ;
	/** 属性注销/拒赔人代码/注销/拒赔人代码 */
	@Column(name = "dealerCode")
	private String dealerCode ;
	/** 属性是否为逃逸案/是否为逃逸案 */
	@Column(name = "escapeFlag")
	private String escapeFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性暂无/暂无 */
	@Column(name = "replevyFlag")
	private String replevyFlag ;
	/** 属性第三方公司标志/第三方公司标志 */
	@Column(name = "thirdComFlag")
	private String thirdComFlag ;
	/** 属性是否自动结案 [0]不是[1]是/是否自动结案 [0]不是[1]是 */
	@Column(name = "endCaseFlag")
	private String endCaseFlag ;
	/** 属性计算书责任比例/计算书责任比例 */
	@Column(name = "cIndemnityDutyRate")
	private java.lang.Double cIndemnityDutyRate ;
	/** 属性出险地点邮政编码/出险地点邮政编码 */
	@Column(name = "damageAreaPostCode")
	private String damageAreaPostCode ;
	/** 属性巨灾一级代码/巨灾一级代码 */
	@Column(name = "catastropheCode1")
	private String catastropheCode1 ;
	/** 属性巨灾一级名称/巨灾一级名称 */
	@Column(name = "catastropheName1")
	private String catastropheName1 ;
	/** 属性巨灾二级代码/巨灾二级代码 */
	@Column(name = "catastropheCode2")
	private String catastropheCode2 ;
	/** 属性巨灾二级名称/巨灾二级名称 */
	@Column(name = "catastropheName2")
	private String catastropheName2 ;
	/** 属性立案类型/立案类型 */
	@Column(name = "claimType")
	private String claimType ;
	/** 属性赔付数量/赔付数量 */
	@Column(name = "lossesNumber")
	private java.lang.Double lossesNumber ;
	/** 属性赔付数量计量单位/赔付数量计量单位 */
	@Column(name = "lossesUnitCode")
	private String lossesUnitCode ;
	/** 属性出险户次/出险户次 */
	@Column(name = "damageInsured")
	private java.lang.Double damageInsured ;
	/** 属性受灾面积/受灾面积 */
	@Column(name = "disasterArea")
	private java.lang.Double disasterArea ;
	/** 属性受灾面积计量单位/受灾面积计量单位 */
	@Column(name = "disasterUnit")
	private String disasterUnit ;
	/** 属性成灾面积/成灾面积 */
	@Column(name = "affectedArea")
	private java.lang.Double affectedArea ;
	/** 属性成灾面积计量单位/成灾面积计量单位 */
	@Column(name = "affectedUnit")
	private String affectedUnit ;
	/** 属性绝产面积/绝产面积 */
	@Column(name = "noProductionArea")
	private java.lang.Double noProductionArea ;
	/** 属性绝产面积计量单位/绝产面积计量单位 */
	@Column(name = "noProductionUnit")
	private String noProductionUnit ;
	/** 属性死亡数量/死亡数量 */
	@Column(name = "deathQuantity")
	private java.lang.Double deathQuantity ;
	/** 属性死亡数量计量单位/死亡数量计量单位 */
	@Column(name = "deathUnit")
	private String deathUnit ;
	/** 属性扑杀数量/扑杀数量 */
	@Column(name = "killQuantity")
	private java.lang.Double killQuantity ;
	/** 属性扑杀数量计量单位/扑杀数量计量单位 */
	@Column(name = "killUnit")
	private String killUnit ;
	/** 属性农业/涉农/非农/农业/涉农/非农 */
	@Column(name = "businessType")
	private String businessType ;
	/** 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性 */
	@Column(name = "businessType1")
	private String businessType1 ;
	/** 属性医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用/医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用 */
	@Column(name = "medicalType")
	private String medicalType ;
	/** 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务 */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性其他标志（对应prpcmain表中的otherFlag）/其他标志（对应prpcmain表中的otherFlag） */
	@Column(name = "otherFlag")
	private String otherFlag ;
	/** 属性核损估损通过标志/核损估损通过标志 */
	@Column(name = "claimLossFlag")
	private String claimLossFlag ;
	/** 属性案均估损/案均估损 */
	@Column(name = "avgFlag")
	private String avgFlag ;
	/** 属性15天延迟估损/15天延迟估损 */
	@Column(name = "fifteenFlag")
	private String fifteenFlag ;
	/** 属性30天延迟估损/30天延迟估损 */
	@Column(name = "thirtyFlag")
	private String thirtyFlag ;
	/** 属性注销/拒赔原因/注销/拒赔原因 */
	@Column(name = "cancelReasonExplan")
	private String cancelReasonExplan ;
	/** 属性自动立案标示/自动立案标示 */
	@Column(name = "autoFlag")
	private String autoFlag ;
	/** 属性立案时间(精确)/立案时间(精确) */
	@Column(name = "claimTime")
	private java.util.Date claimTime ;
	/** 属性修改人/修改人 */
	@Column(name = "upDate_By")
	private String upDateBy ;
	/** 属性修改日期/修改日期 */
	@Column(name = "upDate_Date")
	private java.util.Date upDateDate ;
	/** 生长期 */
	@Column(name = "growthPeriod")
	private String growthPeriod;
	/** 出险方式*/
	@Column(name="damageWay")
	private String damageWay;
	/** 溃塘程度/漫塘时间*/
	@Column(name="damageDegree")
	private String damageDegree;
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
	 * 属性理赔类型/理赔类型的getter方法
	 */
	public String getLFlag() {
		return lFlag;
	}
	/**
	 * 属性理赔类型/理赔类型的setter方法
	 */
	public void setLFlag(String lFlag) {
		this.lFlag = lFlag;
	} 	
	/**
	 * 属性赔案号/赔案号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性赔案号/赔案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	} 	
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
	 * 属性业务性质/业务性质的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务性质/业务性质的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	} 	
	/**
	 * 属性语种/语种的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性语种/语种的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	} 	
	/**
	 * 属性保单类型/保单类型的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单类型/保单类型的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	} 	
	/**
	 * 属性被保险人代码/被保险人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性被保险人代码/被保险人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
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
	 * 属性起保日期/起保日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期/起保日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性起保小时/起保小时的getter方法
	 */
	public java.lang.Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(java.lang.Integer startHour) {
		this.startHour = startHour;
	} 	
	/**
	 * 属性终保日期/终保日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期/终保日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性终保小时/终保小时的getter方法
	 */
	public java.lang.Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终保小时/终保小时的setter方法
	 */
	public void setEndHour(java.lang.Integer endHour) {
		this.endHour = endHour;
	} 	
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性总保额/总保额的getter方法
	 */
	public java.lang.Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保额/总保额的setter方法
	 */
	public void setSumAmount(java.lang.Double sumAmount) {
		this.sumAmount = sumAmount;
	} 	
	/**
	 * 属性总数量/总数量的getter方法
	 */
	public java.lang.Integer getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总数量/总数量的setter方法
	 */
	public void setSumPremium(java.lang.Integer sumPremium) {
		this.sumPremium = sumPremium;
	} 	
	/**
	 * 属性出险日期起/出险日期起的getter方法
	 */
	public java.util.Date getDamageStartDate() {
		return damageStartDate;
	}
	/**
	 * 属性出险日期起/出险日期起的setter方法
	 */
	public void setDamageStartDate(java.util.Date damageStartDate) {
		this.damageStartDate = damageStartDate;
	} 	
	/**
	 * 属性出险开始小时/出险开始小时的getter方法
	 */
	public String getDamageStartHour() {
		return damageStartHour;
	}
	/**
	 * 属性出险开始小时/出险开始小时的setter方法
	 */
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	} 	
	/**
	 * 属性出险日期止/出险日期止的getter方法
	 */
	public java.util.Date getDamageEndDate() {
		return damageEndDate;
	}
	/**
	 * 属性出险日期止/出险日期止的setter方法
	 */
	public void setDamageEndDate(java.util.Date damageEndDate) {
		this.damageEndDate = damageEndDate;
	} 	
	/**
	 * 属性出险终止小时/出险终止小时的getter方法
	 */
	public String getDamageEndHour() {
		return damageEndHour;
	}
	/**
	 * 属性出险终止小时/出险终止小时的setter方法
	 */
	public void setDamageEndHour(String damageEndHour) {
		this.damageEndHour = damageEndHour;
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
	 * 属性出险区域名称/出险区域名称的getter方法
	 */
	public String getDamageAreaName() {
		return damageAreaName;
	}
	/**
	 * 属性出险区域名称/出险区域名称的setter方法
	 */
	public void setDamageAreaName(String damageAreaName) {
		this.damageAreaName = damageAreaName;
	} 	
	/**
	 * 属性出险地点分类代码/出险地点分类代码的getter方法
	 */
	public String getDamageAddressType() {
		return damageAddressType;
	}
	/**
	 * 属性出险地点分类代码/出险地点分类代码的setter方法
	 */
	public void setDamageAddressType(String damageAddressType) {
		this.damageAddressType = damageAddressType;
	} 	
	/**
	 * 属性出险地代码/出险地代码的getter方法
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 属性出险地代码/出险地代码的setter方法
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
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
	 * 属性受损标的/受损标的的getter方法
	 */
	public String getLossName() {
		return lossName;
	}
	/**
	 * 属性受损标的/受损标的的setter方法
	 */
	public void setLossName(String lossName) {
		this.lossName = lossName;
	} 	
	/**
	 * 属性受损标的数量/出险分户数/受损标的数量/出险分户数的getter方法
	 */
	public java.lang.Integer getLossQuantity() {
		return lossQuantity;
	}
	/**
	 * 属性受损标的数量/出险分户数/受损标的数量/出险分户数的setter方法
	 */
	public void setLossQuantity(java.lang.Integer lossQuantity) {
		this.lossQuantity = lossQuantity;
	} 	
	/**
	 * 属性出险险别/出险险别的getter方法
	 */
	public String getDamageKind() {
		return damageKind;
	}
	/**
	 * 属性出险险别/出险险别的setter方法
	 */
	public void setDamageKind(String damageKind) {
		this.damageKind = damageKind;
	} 	
	/**
	 * 属性立案日期/立案日期的getter方法
	 */
	public java.util.Date getClaimDate() {
		return claimDate;
	}
	/**
	 * 属性立案日期/立案日期的setter方法
	 */
	public void setClaimDate(java.util.Date claimDate) {
		this.claimDate = claimDate;
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
	 * 属性责任比例/责任比例的getter方法
	 */
	public java.lang.Double getIndemnityDutyRate() {
		return indemnityDutyRate;
	}
	/**
	 * 属性责任比例/责任比例的setter方法
	 */
	public void setIndemnityDutyRate(java.lang.Double indemnityDutyRate) {
		this.indemnityDutyRate = indemnityDutyRate;
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
	 * 属性保险损失金额(同保单币别)/保险损失金额(同保单币别)的getter方法
	 */
	public java.lang.Double getSumClaim() {
		return sumClaim;
	}
	/**
	 * 属性保险损失金额(同保单币别)/保险损失金额(同保单币别)的setter方法
	 */
	public void setSumClaim(java.lang.Double sumClaim) {
		this.sumClaim = sumClaim;
	} 	
	/**
	 * 属性总核定损金额(同保单币别)/总核定损金额(同保单币别)的getter方法
	 */
	public java.lang.Double getSumDefLoss() {
		return sumDefLoss;
	}
	/**
	 * 属性总核定损金额(同保单币别)/总核定损金额(同保单币别)的setter方法
	 */
	public void setSumDefLoss(java.lang.Double sumDefLoss) {
		this.sumDefLoss = sumDefLoss;
	} 	
	/**
	 * 属性总赔付金额(同保单币别)/总赔付金额(同保单币别)的getter方法
	 */
	public java.lang.Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性总赔付金额(同保单币别)/总赔付金额(同保单币别)的setter方法
	 */
	public void setSumPaid(java.lang.Double sumPaid) {
		this.sumPaid = sumPaid;
	} 	
	/**
	 * 属性总追偿金额(同保单币别)/总追偿金额(同保单币别)的getter方法
	 */
	public java.lang.Double getSumReplevy() {
		return sumReplevy;
	}
	/**
	 * 属性总追偿金额(同保单币别)/总追偿金额(同保单币别)的setter方法
	 */
	public void setSumReplevy(java.lang.Double sumReplevy) {
		this.sumReplevy = sumReplevy;
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
	 * 属性案件性质/案件性质的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性案件性质/案件性质的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	} 	
	/**
	 * 属性理赔登记机构代码/理赔登记机构代码的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性理赔登记机构代码/理赔登记机构代码的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	} 	
	/**
	 * 属性业务归属机构代码/业务归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性代理人代码/代理人代码的getter方法
	 */
	public String getAgentCode() {
		return agentCode;
	}
	/**
	 * 属性代理人代码/代理人代码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	} 	
	/**
	 * 属性经办人代码/经办人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性经办人代码/经办人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	} 	
	/**
	 * 属性归属业务员代码/归属业务员代码的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的setter方法
	 */
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	} 	
	/**
	 * 属性统计年月/统计年月的getter方法
	 */
	public java.util.Date getStatisticsYM() {
		return statisticsYM;
	}
	/**
	 * 属性统计年月/统计年月的setter方法
	 */
	public void setStatisticsYM(java.util.Date statisticsYM) {
		this.statisticsYM = statisticsYM;
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
	 * 属性计算机输单日期/计算机输单日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性结案日期/结案日期的getter方法
	 */
	public java.util.Date getEndCaseDate() {
		return endCaseDate;
	}
	/**
	 * 属性结案日期/结案日期的setter方法
	 */
	public void setEndCaseDate(java.util.Date endCaseDate) {
		this.endCaseDate = endCaseDate;
	} 	
	/**
	 * 属性结案员代码/结案员代码的getter方法
	 */
	public String getEndCaserCode() {
		return endCaserCode;
	}
	/**
	 * 属性结案员代码/结案员代码的setter方法
	 */
	public void setEndCaserCode(String endCaserCode) {
		this.endCaserCode = endCaserCode;
	} 	
	/**
	 * 属性注销/拒赔日期/注销/拒赔日期的getter方法
	 */
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	/**
	 * 属性注销/拒赔日期/注销/拒赔日期的setter方法
	 */
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	} 	
	/**
	 * 属性注销/拒赔原因1/注销/拒赔原因1的getter方法
	 */
	public String getCancelReason() {
		return cancelReason;
	}
	/**
	 * 属性注销/拒赔原因1/注销/拒赔原因1的setter方法
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	} 	
	/**
	 * 属性注销/拒赔人代码/注销/拒赔人代码的getter方法
	 */
	public String getDealerCode() {
		return dealerCode;
	}
	/**
	 * 属性注销/拒赔人代码/注销/拒赔人代码的setter方法
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	} 	
	/**
	 * 属性是否为逃逸案/是否为逃逸案的getter方法
	 */
	public String getEscapeFlag() {
		return escapeFlag;
	}
	/**
	 * 属性是否为逃逸案/是否为逃逸案的setter方法
	 */
	public void setEscapeFlag(String escapeFlag) {
		this.escapeFlag = escapeFlag;
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
	 * 属性暂无/暂无的getter方法
	 */
	public String getReplevyFlag() {
		return replevyFlag;
	}
	/**
	 * 属性暂无/暂无的setter方法
	 */
	public void setReplevyFlag(String replevyFlag) {
		this.replevyFlag = replevyFlag;
	} 	
	/**
	 * 属性第三方公司标志/第三方公司标志的getter方法
	 */
	public String getThirdComFlag() {
		return thirdComFlag;
	}
	/**
	 * 属性第三方公司标志/第三方公司标志的setter方法
	 */
	public void setThirdComFlag(String thirdComFlag) {
		this.thirdComFlag = thirdComFlag;
	} 	
	/**
	 * 属性是否自动结案 [0]不是[1]是/是否自动结案 [0]不是[1]是的getter方法
	 */
	public String getEndCaseFlag() {
		return endCaseFlag;
	}
	/**
	 * 属性是否自动结案 [0]不是[1]是/是否自动结案 [0]不是[1]是的setter方法
	 */
	public void setEndCaseFlag(String endCaseFlag) {
		this.endCaseFlag = endCaseFlag;
	} 	
	/**
	 * 属性计算书责任比例/计算书责任比例的getter方法
	 */
	public java.lang.Double getCIndemnityDutyRate() {
		return cIndemnityDutyRate;
	}
	/**
	 * 属性计算书责任比例/计算书责任比例的setter方法
	 */
	public void setCIndemnityDutyRate(java.lang.Double cIndemnityDutyRate) {
		this.cIndemnityDutyRate = cIndemnityDutyRate;
	} 	
	/**
	 * 属性出险地点邮政编码/出险地点邮政编码的getter方法
	 */
	public String getDamageAreaPostCode() {
		return damageAreaPostCode;
	}
	/**
	 * 属性出险地点邮政编码/出险地点邮政编码的setter方法
	 */
	public void setDamageAreaPostCode(String damageAreaPostCode) {
		this.damageAreaPostCode = damageAreaPostCode;
	} 	
	/**
	 * 属性巨灾一级代码/巨灾一级代码的getter方法
	 */
	public String getCatastropheCode1() {
		return catastropheCode1;
	}
	/**
	 * 属性巨灾一级代码/巨灾一级代码的setter方法
	 */
	public void setCatastropheCode1(String catastropheCode1) {
		this.catastropheCode1 = catastropheCode1;
	} 	
	/**
	 * 属性巨灾一级名称/巨灾一级名称的getter方法
	 */
	public String getCatastropheName1() {
		return catastropheName1;
	}
	/**
	 * 属性巨灾一级名称/巨灾一级名称的setter方法
	 */
	public void setCatastropheName1(String catastropheName1) {
		this.catastropheName1 = catastropheName1;
	} 	
	/**
	 * 属性巨灾二级代码/巨灾二级代码的getter方法
	 */
	public String getCatastropheCode2() {
		return catastropheCode2;
	}
	/**
	 * 属性巨灾二级代码/巨灾二级代码的setter方法
	 */
	public void setCatastropheCode2(String catastropheCode2) {
		this.catastropheCode2 = catastropheCode2;
	} 	
	/**
	 * 属性巨灾二级名称/巨灾二级名称的getter方法
	 */
	public String getCatastropheName2() {
		return catastropheName2;
	}
	/**
	 * 属性巨灾二级名称/巨灾二级名称的setter方法
	 */
	public void setCatastropheName2(String catastropheName2) {
		this.catastropheName2 = catastropheName2;
	} 	
	/**
	 * 属性立案类型/立案类型的getter方法
	 */
	public String getClaimType() {
		return claimType;
	}
	/**
	 * 属性立案类型/立案类型的setter方法
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	} 	
	/**
	 * 属性赔付数量/赔付数量的getter方法
	 */
	public java.lang.Double getLossesNumber() {
		return lossesNumber;
	}
	/**
	 * 属性赔付数量/赔付数量的setter方法
	 */
	public void setLossesNumber(java.lang.Double lossesNumber) {
		this.lossesNumber = lossesNumber;
	} 	
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的getter方法
	 */
	public String getLossesUnitCode() {
		return lossesUnitCode;
	}
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的setter方法
	 */
	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	} 	
	/**
	 * 属性出险户次/出险户次的getter方法
	 */
	public java.lang.Double getDamageInsured() {
		return damageInsured;
	}
	/**
	 * 属性出险户次/出险户次的setter方法
	 */
	public void setDamageInsured(java.lang.Double damageInsured) {
		this.damageInsured = damageInsured;
	} 	
	/**
	 * 属性受灾面积/受灾面积的getter方法
	 */
	public java.lang.Double getDisasterArea() {
		return disasterArea;
	}
	/**
	 * 属性受灾面积/受灾面积的setter方法
	 */
	public void setDisasterArea(java.lang.Double disasterArea) {
		this.disasterArea = disasterArea;
	} 	
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的getter方法
	 */
	public String getDisasterUnit() {
		return disasterUnit;
	}
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的setter方法
	 */
	public void setDisasterUnit(String disasterUnit) {
		this.disasterUnit = disasterUnit;
	} 	
	/**
	 * 属性成灾面积/成灾面积的getter方法
	 */
	public java.lang.Double getAffectedArea() {
		return affectedArea;
	}
	/**
	 * 属性成灾面积/成灾面积的setter方法
	 */
	public void setAffectedArea(java.lang.Double affectedArea) {
		this.affectedArea = affectedArea;
	} 	
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的getter方法
	 */
	public String getAffectedUnit() {
		return affectedUnit;
	}
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的setter方法
	 */
	public void setAffectedUnit(String affectedUnit) {
		this.affectedUnit = affectedUnit;
	} 	
	/**
	 * 属性绝产面积/绝产面积的getter方法
	 */
	public java.lang.Double getNoProductionArea() {
		return noProductionArea;
	}
	/**
	 * 属性绝产面积/绝产面积的setter方法
	 */
	public void setNoProductionArea(java.lang.Double noProductionArea) {
		this.noProductionArea = noProductionArea;
	} 	
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的getter方法
	 */
	public String getNoProductionUnit() {
		return noProductionUnit;
	}
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的setter方法
	 */
	public void setNoProductionUnit(String noProductionUnit) {
		this.noProductionUnit = noProductionUnit;
	} 	
	/**
	 * 属性死亡数量/死亡数量的getter方法
	 */
	public java.lang.Double getDeathQuantity() {
		return deathQuantity;
	}
	/**
	 * 属性死亡数量/死亡数量的setter方法
	 */
	public void setDeathQuantity(java.lang.Double deathQuantity) {
		this.deathQuantity = deathQuantity;
	} 	
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的getter方法
	 */
	public String getDeathUnit() {
		return deathUnit;
	}
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的setter方法
	 */
	public void setDeathUnit(String deathUnit) {
		this.deathUnit = deathUnit;
	} 	
	/**
	 * 属性扑杀数量/扑杀数量的getter方法
	 */
	public java.lang.Double getKillQuantity() {
		return killQuantity;
	}
	/**
	 * 属性扑杀数量/扑杀数量的setter方法
	 */
	public void setKillQuantity(java.lang.Double killQuantity) {
		this.killQuantity = killQuantity;
	} 	
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的getter方法
	 */
	public String getKillUnit() {
		return killUnit;
	}
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的setter方法
	 */
	public void setKillUnit(String killUnit) {
		this.killUnit = killUnit;
	} 	
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	} 	
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	} 	
	/**
	 * 属性医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用/医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用的getter方法
	 */
	public String getMedicalType() {
		return medicalType;
	}
	/**
	 * 属性医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用/医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用的setter方法
	 */
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	} 	
	/**
	 * 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务的setter方法
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	} 	
	/**
	 * 属性其他标志（对应prpcmain表中的otherFlag）/其他标志（对应prpcmain表中的otherFlag）的getter方法
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * 属性其他标志（对应prpcmain表中的otherFlag）/其他标志（对应prpcmain表中的otherFlag）的setter方法
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	} 	
	/**
	 * 属性核损估损通过标志/核损估损通过标志的getter方法
	 */
	public String getClaimLossFlag() {
		return claimLossFlag;
	}
	/**
	 * 属性核损估损通过标志/核损估损通过标志的setter方法
	 */
	public void setClaimLossFlag(String claimLossFlag) {
		this.claimLossFlag = claimLossFlag;
	} 	
	/**
	 * 属性案均估损/案均估损的getter方法
	 */
	public String getAvgFlag() {
		return avgFlag;
	}
	/**
	 * 属性案均估损/案均估损的setter方法
	 */
	public void setAvgFlag(String avgFlag) {
		this.avgFlag = avgFlag;
	} 	
	/**
	 * 属性15天延迟估损/15天延迟估损的getter方法
	 */
	public String getFifteenFlag() {
		return fifteenFlag;
	}
	/**
	 * 属性15天延迟估损/15天延迟估损的setter方法
	 */
	public void setFifteenFlag(String fifteenFlag) {
		this.fifteenFlag = fifteenFlag;
	} 	
	/**
	 * 属性30天延迟估损/30天延迟估损的getter方法
	 */
	public String getThirtyFlag() {
		return thirtyFlag;
	}
	/**
	 * 属性30天延迟估损/30天延迟估损的setter方法
	 */
	public void setThirtyFlag(String thirtyFlag) {
		this.thirtyFlag = thirtyFlag;
	} 	
	/**
	 * 属性注销/拒赔原因/注销/拒赔原因的getter方法
	 */
	public String getCancelReasonExplan() {
		return cancelReasonExplan;
	}
	/**
	 * 属性注销/拒赔原因/注销/拒赔原因的setter方法
	 */
	public void setCancelReasonExplan(String cancelReasonExplan) {
		this.cancelReasonExplan = cancelReasonExplan;
	} 	
	/**
	 * 属性自动立案标示/自动立案标示的getter方法
	 */
	public String getAutoFlag() {
		return autoFlag;
	}
	/**
	 * 属性自动立案标示/自动立案标示的setter方法
	 */
	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	} 	
	/**
	 * 属性立案时间(精确)/立案时间(精确)的getter方法
	 */
	public java.util.Date getClaimTime() {
		return claimTime;
	}
	/**
	 * 属性立案时间(精确)/立案时间(精确)的setter方法
	 */
	public void setClaimTime(java.util.Date claimTime) {
		this.claimTime = claimTime;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpDateBy() {
		return upDateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpDateBy(String upDateBy) {
		this.upDateBy = upDateBy;
	} 	
	/**
	 * 属性修改日期/修改日期的getter方法
	 */
	public java.util.Date getUpDateDate() {
		return upDateDate;
	}
	/**
	 * 属性修改日期/修改日期的setter方法
	 */
	public void setUpDateDate(java.util.Date upDateDate) {
		this.upDateDate = upDateDate;
	}

	public String getGrowthPeriod() {
		return growthPeriod;
	}

	public void setGrowthPeriod(String growthPeriod) {
		this.growthPeriod = growthPeriod;
	}

	public String getDamageWay() {
		return damageWay;
	}

	public void setDamageWay(String damageWay) {
		this.damageWay = damageWay;
	}

	public String getDamageDegree() {
		return damageDegree;
	}

	public void setDamageDegree(String damageDegree) {
		this.damageDegree = damageDegree;
	}
}