package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:45:22.527 报案信息表Api操作对象
 */
public class PrpLRegistDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo;
	/** 属性理赔类型/理赔类型 */
	private String lFlag;
	/** 属性险类代码/险类代码 */
	private String classCode;
	/** 属性险种代码/险种代码 */
	private String riskCode;
	/** 属性保单号码/保单号码 */
	private String policyNo;
	/** 属性语种/语种 */
	private String language;
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode;
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName;
	/** 属性被保险人通讯地址/被保险人通讯地址 */
	private String insuredAddress;
	/** 属性条款类别/条款类别 */
	private String clauseType;
	/** 属性车牌号码/车牌号码 */
	private String licenseNo;
	/** 属性车牌底色代码/车牌底色代码 */
	private String licenseColorCode;
	/** 属性车辆种类代码/车辆种类代码 */
	private String carKindCode;
	/** 属性车型代码(车系+车型)/车型代码(车系+车型) */
	private String modelCode;
	/** 属性厂牌型号/厂牌型号 */
	private String brandName;
	/** 属性发动机号/发动机号 */
	private String engineNo;
	/** 属性车架号/车架号 */
	private String frameNo;
	/** 属性车辆已行驶公里数/车辆已行驶公里数 */
	private Double runDistance;
	/** 属性车辆实际使用年限/车辆实际使用年限 */
	private Integer useYears;
	/** 属性报案日期/报案日期 */
	private java.util.Date reportDate;
	/** 属性报案小时/报案小时 */
	private String reportHour;
	/** 属性报案地点/报案地点 */
	private String reportAddress;
	/** 属性报案人/报案人 */
	private String reportorName;
	/** 属性报案形式/报案形式 */
	private String reportType;
	/** 属性报案人联系电话/报案人联系电话 */
	private String phoneNumber;
	/** 属性联系人/联系人 */
	private String linkerName;
	/** 属性出险日期起/出险日期起 */
	private java.util.Date damageStartDate;
	/** 属性出险开始小时/出险开始小时 */
	private String damageStartHour;
	/** 属性出险日期止/出险日期止 */
	private java.util.Date damageEndDate;
	/** 属性出险终止小时/出险终止小时 */
	private String damageEndHour;
	/** 属性出险原因代码/出险原因代码 */
	private String damageCode;
	/** 属性出险原因说明/出险原因说明 */
	private String damageName;
	/** 属性事故类型代码(车险)/事故类型代码(车险) */
	private String damageTypeCode;
	/** 属性事故类型说明/事故类型说明 */
	private String damageTypeName;
	/** 属性是否第一现场/是否第一现场 */
	private String firstSiteFlag;
	/** 属性出险区域代码/出险区域代码 */
	private String damageAreaCode;
	/** 属性出险区域名称/出险区域名称 */
	private String damageAreaName;
	/** 属性出险地点分类/出险地点分类 */
	private String damageAddressType;
	/** 属性出险地代码/出险地代码 */
	private String addressCode;
	/** 属性出险地点/出险地点 */
	private String damageAddress;
	/** 属性出险地点邮政编码/出险地点邮政编码 */
	private String damageAreapostCode;
	/** 属性事故处理部门/事故处理部门 */
	private String handleUnit;
	/** 属性受损标的/受损标的 */
	private String lossName;
	/** 属性受损标的数量/受损标的数量 */
	private Double lossQuantity;
	/** 属性数量单位/数量单位 */
	private String unit;
	/** 属性估损币别/估损币别 */
	private String esticurrency;
	/** 属性估损金额/估损金额 */
	private Double estimateLoss;
	/** 属性接案员姓名/接案员姓名 */
	private String receiverName;
	/** 属性经办人代码/经办人代码 */
	private String handlerCode;
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code;
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode;
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputDate;
	/** 属性受理标志(Y/N)/受理标志(Y/N) */
	private String acceptFlag;
	/** 属性是否向别的保险公司投保(Y/N)/是否向别的保险公司投保(Y/N) */
	private String repeatInsureFlag;
	/** 属性赔案类别/赔案类别 */
	private String claimType;
	/** 属性注销/拒赔日期/注销/拒赔日期 */
	private java.util.Date cancelDate;
	/** 属性注销/拒赔人代码/注销/拒赔人代码 */
	private String dealerCode;
	/** 属性备注/备注 */
	private String remark;
	/** 属性操作员代码/操作员代码 */
	private String operatorCode;
	/** 属性理赔登记机构/理赔登记机构 */
	private String makeCom;
	/** 属性标志字段/标志字段 */
	private String flag;
	/** 属性报案人电话/报案人电话 */
	private String reportorPhoneNumber;
	/** 属性联系人邮编/联系人邮编 */
	private String linkerpostCode;
	/** 属性联系人通讯地址/联系人通讯地址 */
	private String linkerAddress;
	/** 属性未决赔款准备金/未决赔款准备金 */
	private Double estimateFee;
	/** 属性巨灾一级代码/巨灾一级代码 */
	private String catastropheCode1;
	/** 属性巨灾一级名称/巨灾一级名称 */
	private String catastropheName1;
	/** 属性巨灾二级代码/巨灾二级代码 */
	private String catastropheCode2;
	/** 属性巨灾二级名称/巨灾二级名称 */
	private String catastropheName2;
	/** 属性报案标志/报案标志 */
	private String reportFlag;
	/** 属性事故责任类型/事故责任类型 */
	private String indemnityDuty;
	/** 属性赔付数量/赔付数量 */
	private Double lossesNumber;
	/** 属性赔付数量计量单位/赔付数量计量单位 */
	private String lossesUnitCode;
	/** 属性农业/涉农/非农/农业/涉农/非农 */
	private String businessType;
	/** 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性 */
	private String businessType1;
	/** 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务 */
	private String businessFlag;
	/** 属性其他标志（对应prpcmain表中的otherFlag）/其他标志（对应prpcmain表中的otherFlag） */
	private String otherFlag;
	/** 属性报案状态标志 0:临时报案 1：正式报案/报案状态标志 0:临时报案 1：正式报案 */
	private String registFlag;
	/** 属性提交小时/提交小时 */
	private String submitHour;
	/** 属性提交日期/提交日期 */
	private java.util.Date submitDate;
	/** 属性输入小时/输入小时 */
	private String inputHour;
	/** 属性现场标志/现场标志 */
	private String siteFlag;
	/** 属性伤害描述/伤害描述 */
	private String damageDescribe;
	/** 属性范围描述/范围描述 */
	private String woundDescribe;
	/** 属性损失类型/损失类型 */
	private String lossType;
	/** 属性损失等级/损失等级 */
	private String lossLevel;
	/** 属性确认手机号码/确认手机号码 */
	private String insuredMobilePhone;
	/** 属性确认固话/确认固话 */
	private String insuredPhone;
	/** 属性驾驶联系方式/驾驶联系方式 */
	private String driverPhone;
	/** 属性确认标志/确认标志 */
	private String isinsureFlag;
	/** 属性驾驶员姓名/驾驶员姓名 */
	private String driverName;
	/** 属性驾驶类型/驾驶类型 */
	private String driverFlag;
	/** 属性注销类型/注销类型 */
	private String logOutType;
	/** 属性注销标志/注销标志 */
	private String logOutFlag;
	/** 属性注销申请人/注销申请人 */
	private String logOutApplicant;
	/** 属性注销申请时间/注销申请时间 */
	private java.util.Date logOutDateTime;
	/** 属性调查类型/调查类型 */
	private String typeofinquiry;
	/** 属性通融案件/通融案件 */
	private String accommodationClaim;
	/** 属性通融金额/通融金额 */
	private Double accommodationAmount;
	/** 属性调查减损/调查减损 */
	private Double surveyDilute;
	/** 属性复堪减损/复堪减损 */
	private Double backcdilute;
	/** 属性人伤减损/人伤减损 */
	private Double personDilute;
	/** 属性追偿案件/追偿案件 */
	private String recoveryClaim;
	/** 属性追偿类型/追偿类型 */
	private String recoveryType;
	/** 属性追偿金额/追偿金额 */
	private Double recoveryAmount;
	/** 属性立等案件/立等案件 */
	private String instantClaim;
	/** 属性诉讼案件/诉讼案件 */
	private String actionClaim;
	/** 属性录音流水号/录音流水号 */
	private String recordingNo;
	/** 属性代位求偿标志/代位求偿标志 */
	private String subrogateFlag;
	/** 属性责任认定书类型/责任认定书类型 */
	private String subcertiType;
	/** 属性subClaimFlag/subClaimFlag */
	private String subclaimFlag;
	/** 属性迟报案标志，1为迟报案（超48小时） 0非迟报案/迟报案标志，1为迟报案（超48小时） 0非迟报案 */
	private String lateregistFlag;
	/** 属性迟报案原因/迟报案原因 */
	private String lateregistReason;
	/** 属性出险辖区/出险辖区 */
	private String damageArea;
	/** 属性修改人/修改人 */
	private String updateBy;
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate;
	/** 属性出险地点经度/出险地点经度 */
	private String longitude;
	/** 属性出险地点纬度/出险地点纬度 */
	private String latitude;
	/** 属性属性此报案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
	private String status;
	/** 属性排列记录的编号 */
	private int serialNo;
	/** 属性出险次数 */
	private int perilCount;
	/** 属性最近N天出险次数 */
	private int recentCount;
//	/** 调度所需拓展字段 */
//	private PrpLregistListQueryDto prpLregistListQueryDto;

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
	 * 属性被保险人通讯地址/被保险人通讯地址的getter方法
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}

	/**
	 * 属性被保险人通讯地址/被保险人通讯地址的setter方法
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	/**
	 * 属性条款类别/条款类别的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}

	/**
	 * 属性条款类别/条款类别的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	/**
	 * 属性车牌号码/车牌号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * 属性车牌号码/车牌号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * 属性车牌底色代码/车牌底色代码的getter方法
	 */
	public String getLicenseColorCode() {
		return licenseColorCode;
	}

	/**
	 * 属性车牌底色代码/车牌底色代码的setter方法
	 */
	public void setLicenseColorCode(String licenseColorCode) {
		this.licenseColorCode = licenseColorCode;
	}

	/**
	 * 属性车辆种类代码/车辆种类代码的getter方法
	 */
	public String getCarKindCode() {
		return carKindCode;
	}

	/**
	 * 属性车辆种类代码/车辆种类代码的setter方法
	 */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	}

	/**
	 * 属性车型代码(车系+车型)/车型代码(车系+车型)的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}

	/**
	 * 属性车型代码(车系+车型)/车型代码(车系+车型)的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
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
	 * 属性车辆已行驶公里数/车辆已行驶公里数的getter方法
	 */
	public Double getRunDistance() {
		return runDistance;
	}

	/**
	 * 属性车辆已行驶公里数/车辆已行驶公里数的setter方法
	 */
	public void setRunDistance(Double runDistance) {
		this.runDistance = runDistance;
	}

	/**
	 * 属性车辆实际使用年限/车辆实际使用年限的getter方法
	 */
	public Integer getUseYears() {
		return useYears;
	}

	/**
	 * 属性车辆实际使用年限/车辆实际使用年限的setter方法
	 */
	public void setUseYears(Integer useYears) {
		this.useYears = useYears;
	}

	/**
	 * 属性报案日期/报案日期的getter方法
	 */
	public java.util.Date getReportDate() {
		return reportDate;
	}

	/**
	 * 属性报案日期/报案日期的setter方法
	 */
	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * 属性报案小时/报案小时的getter方法
	 */
	public String getReportHour() {
		return reportHour;
	}

	/**
	 * 属性报案小时/报案小时的setter方法
	 */
	public void setReportHour(String reportHour) {
		this.reportHour = reportHour;
	}

	/**
	 * 属性报案地点/报案地点的getter方法
	 */
	public String getReportAddress() {
		return reportAddress;
	}

	/**
	 * 属性报案地点/报案地点的setter方法
	 */
	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}

	/**
	 * 属性报案人/报案人的getter方法
	 */
	public String getReportorName() {
		return reportorName;
	}

	/**
	 * 属性报案人/报案人的setter方法
	 */
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	/**
	 * 属性报案形式/报案形式的getter方法
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * 属性报案形式/报案形式的setter方法
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	/**
	 * 属性报案人联系电话/报案人联系电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 属性报案人联系电话/报案人联系电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 属性联系人/联系人的getter方法
	 */
	public String getLinkerName() {
		return linkerName;
	}

	/**
	 * 属性联系人/联系人的setter方法
	 */
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
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
	 * 属性事故类型代码(车险)/事故类型代码(车险)的getter方法
	 */
	public String getDamageTypeCode() {
		return damageTypeCode;
	}

	/**
	 * 属性事故类型代码(车险)/事故类型代码(车险)的setter方法
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
	 * 属性出险地点邮政编码/出险地点邮政编码的getter方法
	 */
	public String getDamageAreapostCode() {
		return damageAreapostCode;
	}

	/**
	 * 属性出险地点邮政编码/出险地点邮政编码的setter方法
	 */
	public void setDamageAreapostCode(String damageAreapostCode) {
		this.damageAreapostCode = damageAreapostCode;
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
	 * 属性受损标的数量/受损标的数量的getter方法
	 */
	public Double getLossQuantity() {
		return lossQuantity;
	}

	/**
	 * 属性受损标的数量/受损标的数量的setter方法
	 */
	public void setLossQuantity(Double lossQuantity) {
		this.lossQuantity = lossQuantity;
	}

	/**
	 * 属性数量单位/数量单位的getter方法
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 属性数量单位/数量单位的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 属性估损币别/估损币别的getter方法
	 */
	public String getEsticurrency() {
		return esticurrency;
	}

	/**
	 * 属性估损币别/估损币别的setter方法
	 */
	public void setEsticurrency(String esticurrency) {
		this.esticurrency = esticurrency;
	}

	/**
	 * 属性估损金额/估损金额的getter方法
	 */
	public Double getEstimateLoss() {
		return estimateLoss;
	}

	/**
	 * 属性估损金额/估损金额的setter方法
	 */
	public void setEstimateLoss(Double estimateLoss) {
		this.estimateLoss = estimateLoss;
	}

	/**
	 * 属性接案员姓名/接案员姓名的getter方法
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * 属性接案员姓名/接案员姓名的setter方法
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
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
	 * 属性受理标志(Y/N)/受理标志(Y/N)的getter方法
	 */
	public String getAcceptFlag() {
		return acceptFlag;
	}

	/**
	 * 属性受理标志(Y/N)/受理标志(Y/N)的setter方法
	 */
	public void setAcceptFlag(String acceptFlag) {
		this.acceptFlag = acceptFlag;
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
	 * 属性赔案类别/赔案类别的getter方法
	 */
	public String getClaimType() {
		return claimType;
	}

	/**
	 * 属性赔案类别/赔案类别的setter方法
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
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
	 * 属性理赔登记机构/理赔登记机构的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}

	/**
	 * 属性理赔登记机构/理赔登记机构的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
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
	 * 属性报案人电话/报案人电话的getter方法
	 */
	public String getReportorPhoneNumber() {
		return reportorPhoneNumber;
	}

	/**
	 * 属性报案人电话/报案人电话的setter方法
	 */
	public void setReportorPhoneNumber(String reportorPhoneNumber) {
		this.reportorPhoneNumber = reportorPhoneNumber;
	}

	/**
	 * 属性联系人邮编/联系人邮编的getter方法
	 */
	public String getLinkerpostCode() {
		return linkerpostCode;
	}

	/**
	 * 属性联系人邮编/联系人邮编的setter方法
	 */
	public void setLinkerpostCode(String linkerpostCode) {
		this.linkerpostCode = linkerpostCode;
	}

	/**
	 * 属性联系人通讯地址/联系人通讯地址的getter方法
	 */
	public String getLinkerAddress() {
		return linkerAddress;
	}

	/**
	 * 属性联系人通讯地址/联系人通讯地址的setter方法
	 */
	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = linkerAddress;
	}

	/**
	 * 属性未决赔款准备金/未决赔款准备金的getter方法
	 */
	public Double getEstimateFee() {
		return estimateFee;
	}

	/**
	 * 属性未决赔款准备金/未决赔款准备金的setter方法
	 */
	public void setEstimateFee(Double estimateFee) {
		this.estimateFee = estimateFee;
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
	 * 属性报案标志/报案标志的getter方法
	 */
	public String getReportFlag() {
		return reportFlag;
	}

	/**
	 * 属性报案标志/报案标志的setter方法
	 */
	public void setReportFlag(String reportFlag) {
		this.reportFlag = reportFlag;
	}

	/**
	 * 属性事故责任类型/事故责任类型的getter方法
	 */
	public String getIndemnityDuty() {
		return indemnityDuty;
	}

	/**
	 * 属性事故责任类型/事故责任类型的setter方法
	 */
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}

	/**
	 * 属性赔付数量/赔付数量的getter方法
	 */
	public Double getLossesNumber() {
		return lossesNumber;
	}

	/**
	 * 属性赔付数量/赔付数量的setter方法
	 */
	public void setLossesNumber(Double lossesNumber) {
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
	 * 属性报案状态标志 0:临时报案 1：正式报案/报案状态标志 0:临时报案 1：正式报案的getter方法
	 */
	public String getRegistFlag() {
		return registFlag;
	}

	/**
	 * 属性报案状态标志 0:临时报案 1：正式报案/报案状态标志 0:临时报案 1：正式报案的setter方法
	 */
	public void setRegistFlag(String registFlag) {
		this.registFlag = registFlag;
	}

	/**
	 * 属性提交小时/提交小时的getter方法
	 */
	public String getSubmitHour() {
		return submitHour;
	}

	/**
	 * 属性提交小时/提交小时的setter方法
	 */
	public void setSubmitHour(String submitHour) {
		this.submitHour = submitHour;
	}

	/**
	 * 属性提交日期/提交日期的getter方法
	 */
	public java.util.Date getSubmitDate() {
		return submitDate;
	}

	/**
	 * 属性提交日期/提交日期的setter方法
	 */
	public void setSubmitDate(java.util.Date submitDate) {
		this.submitDate = submitDate;
	}

	/**
	 * 属性输入小时/输入小时的getter方法
	 */
	public String getInputHour() {
		return inputHour;
	}

	/**
	 * 属性输入小时/输入小时的setter方法
	 */
	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	}

	/**
	 * 属性现场标志/现场标志的getter方法
	 */
	public String getSiteFlag() {
		return siteFlag;
	}

	/**
	 * 属性现场标志/现场标志的setter方法
	 */
	public void setSiteFlag(String siteFlag) {
		this.siteFlag = siteFlag;
	}

	/**
	 * 属性伤害描述/伤害描述的getter方法
	 */
	public String getDamageDescribe() {
		return damageDescribe;
	}

	/**
	 * 属性伤害描述/伤害描述的setter方法
	 */
	public void setDamageDescribe(String damageDescribe) {
		this.damageDescribe = damageDescribe;
	}

	/**
	 * 属性范围描述/范围描述的getter方法
	 */
	public String getWoundDescribe() {
		return woundDescribe;
	}

	/**
	 * 属性范围描述/范围描述的setter方法
	 */
	public void setWoundDescribe(String woundDescribe) {
		this.woundDescribe = woundDescribe;
	}

	/**
	 * 属性损失类型/损失类型的getter方法
	 */
	public String getLossType() {
		return lossType;
	}

	/**
	 * 属性损失类型/损失类型的setter方法
	 */
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	/**
	 * 属性损失等级/损失等级的getter方法
	 */
	public String getLossLevel() {
		return lossLevel;
	}

	/**
	 * 属性损失等级/损失等级的setter方法
	 */
	public void setLossLevel(String lossLevel) {
		this.lossLevel = lossLevel;
	}

	/**
	 * 属性确认手机号码/确认手机号码的getter方法
	 */
	public String getInsuredMobilePhone() {
		return insuredMobilePhone;
	}

	/**
	 * 属性确认手机号码/确认手机号码的setter方法
	 */
	public void setInsuredMobilePhone(String insuredMobilePhone) {
		this.insuredMobilePhone = insuredMobilePhone;
	}

	/**
	 * 属性确认固话/确认固话的getter方法
	 */
	public String getInsuredPhone() {
		return insuredPhone;
	}

	/**
	 * 属性确认固话/确认固话的setter方法
	 */
	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}

	/**
	 * 属性驾驶联系方式/驾驶联系方式的getter方法
	 */
	public String getDriverPhone() {
		return driverPhone;
	}

	/**
	 * 属性驾驶联系方式/驾驶联系方式的setter方法
	 */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	/**
	 * 属性确认标志/确认标志的getter方法
	 */
	public String getIsinsureFlag() {
		return isinsureFlag;
	}

	/**
	 * 属性确认标志/确认标志的setter方法
	 */
	public void setIsinsureFlag(String isinsureFlag) {
		this.isinsureFlag = isinsureFlag;
	}

	/**
	 * 属性驾驶员姓名/驾驶员姓名的getter方法
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * 属性驾驶员姓名/驾驶员姓名的setter方法
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * 属性驾驶类型/驾驶类型的getter方法
	 */
	public String getDriverFlag() {
		return driverFlag;
	}

	/**
	 * 属性驾驶类型/驾驶类型的setter方法
	 */
	public void setDriverFlag(String driverFlag) {
		this.driverFlag = driverFlag;
	}

	/**
	 * 属性注销类型/注销类型的getter方法
	 */
	public String getLogOutType() {
		return logOutType;
	}

	/**
	 * 属性注销类型/注销类型的setter方法
	 */
	public void setLogOutType(String logOutType) {
		this.logOutType = logOutType;
	}

	/**
	 * 属性注销标志/注销标志的getter方法
	 */
	public String getLogOutFlag() {
		return logOutFlag;
	}

	/**
	 * 属性注销标志/注销标志的setter方法
	 */
	public void setLogOutFlag(String logOutFlag) {
		this.logOutFlag = logOutFlag;
	}

	/**
	 * 属性注销申请人/注销申请人的getter方法
	 */
	public String getLogOutApplicant() {
		return logOutApplicant;
	}

	/**
	 * 属性注销申请人/注销申请人的setter方法
	 */
	public void setLogOutApplicant(String logOutApplicant) {
		this.logOutApplicant = logOutApplicant;
	}

	/**
	 * 属性注销申请时间/注销申请时间的getter方法
	 */
	public java.util.Date getLogOutDateTime() {
		return logOutDateTime;
	}

	/**
	 * 属性注销申请时间/注销申请时间的setter方法
	 */
	public void setLogOutDateTime(java.util.Date logOutDateTime) {
		this.logOutDateTime = logOutDateTime;
	}

	/**
	 * 属性调查类型/调查类型的getter方法
	 */
	public String getTypeofinquiry() {
		return typeofinquiry;
	}

	/**
	 * 属性调查类型/调查类型的setter方法
	 */
	public void setTypeofinquiry(String typeofinquiry) {
		this.typeofinquiry = typeofinquiry;
	}

	/**
	 * 属性通融案件/通融案件的getter方法
	 */
	public String getAccommodationClaim() {
		return accommodationClaim;
	}

	/**
	 * 属性通融案件/通融案件的setter方法
	 */
	public void setAccommodationClaim(String accommodationClaim) {
		this.accommodationClaim = accommodationClaim;
	}

	/**
	 * 属性通融金额/通融金额的getter方法
	 */
	public Double getAccommodationAmount() {
		return accommodationAmount;
	}

	/**
	 * 属性通融金额/通融金额的setter方法
	 */
	public void setAccommodationAmount(Double accommodationAmount) {
		this.accommodationAmount = accommodationAmount;
	}

	/**
	 * 属性调查减损/调查减损的getter方法
	 */
	public Double getSurveyDilute() {
		return surveyDilute;
	}

	/**
	 * 属性调查减损/调查减损的setter方法
	 */
	public void setSurveyDilute(Double surveyDilute) {
		this.surveyDilute = surveyDilute;
	}

	/**
	 * 属性复堪减损/复堪减损的getter方法
	 */
	public Double getBackcdilute() {
		return backcdilute;
	}

	/**
	 * 属性复堪减损/复堪减损的setter方法
	 */
	public void setBackcdilute(Double backcdilute) {
		this.backcdilute = backcdilute;
	}

	/**
	 * 属性人伤减损/人伤减损的getter方法
	 */
	public Double getPersonDilute() {
		return personDilute;
	}

	/**
	 * 属性人伤减损/人伤减损的setter方法
	 */
	public void setPersonDilute(Double personDilute) {
		this.personDilute = personDilute;
	}

	/**
	 * 属性追偿案件/追偿案件的getter方法
	 */
	public String getRecoveryClaim() {
		return recoveryClaim;
	}

	/**
	 * 属性追偿案件/追偿案件的setter方法
	 */
	public void setRecoveryClaim(String recoveryClaim) {
		this.recoveryClaim = recoveryClaim;
	}

	/**
	 * 属性追偿类型/追偿类型的getter方法
	 */
	public String getRecoveryType() {
		return recoveryType;
	}

	/**
	 * 属性追偿类型/追偿类型的setter方法
	 */
	public void setRecoveryType(String recoveryType) {
		this.recoveryType = recoveryType;
	}

	/**
	 * 属性追偿金额/追偿金额的getter方法
	 */
	public Double getRecoveryAmount() {
		return recoveryAmount;
	}

	/**
	 * 属性追偿金额/追偿金额的setter方法
	 */
	public void setRecoveryAmount(Double recoveryAmount) {
		this.recoveryAmount = recoveryAmount;
	}

	/**
	 * 属性立等案件/立等案件的getter方法
	 */
	public String getInstantClaim() {
		return instantClaim;
	}

	/**
	 * 属性立等案件/立等案件的setter方法
	 */
	public void setInstantClaim(String instantClaim) {
		this.instantClaim = instantClaim;
	}

	/**
	 * 属性诉讼案件/诉讼案件的getter方法
	 */
	public String getActionClaim() {
		return actionClaim;
	}

	/**
	 * 属性诉讼案件/诉讼案件的setter方法
	 */
	public void setActionClaim(String actionClaim) {
		this.actionClaim = actionClaim;
	}

	/**
	 * 属性录音流水号/录音流水号的getter方法
	 */
	public String getRecordingNo() {
		return recordingNo;
	}

	/**
	 * 属性录音流水号/录音流水号的setter方法
	 */
	public void setRecordingNo(String recordingNo) {
		this.recordingNo = recordingNo;
	}

	/**
	 * 属性代位求偿标志/代位求偿标志的getter方法
	 */
	public String getSubrogateFlag() {
		return subrogateFlag;
	}

	/**
	 * 属性代位求偿标志/代位求偿标志的setter方法
	 */
	public void setSubrogateFlag(String subrogateFlag) {
		this.subrogateFlag = subrogateFlag;
	}

	/**
	 * 属性责任认定书类型/责任认定书类型的getter方法
	 */
	public String getSubcertiType() {
		return subcertiType;
	}

	/**
	 * 属性责任认定书类型/责任认定书类型的setter方法
	 */
	public void setSubcertiType(String subcertiType) {
		this.subcertiType = subcertiType;
	}

	/**
	 * 属性subClaimFlag/subClaimFlag的getter方法
	 */
	public String getSubclaimFlag() {
		return subclaimFlag;
	}

	/**
	 * 属性subClaimFlag/subClaimFlag的setter方法
	 */
	public void setSubclaimFlag(String subclaimFlag) {
		this.subclaimFlag = subclaimFlag;
	}

	/**
	 * 属性迟报案标志，1为迟报案（超48小时） 0非迟报案/迟报案标志，1为迟报案（超48小时） 0非迟报案的getter方法
	 */
	public String getLateregistFlag() {
		return lateregistFlag;
	}

	/**
	 * 属性迟报案标志，1为迟报案（超48小时） 0非迟报案/迟报案标志，1为迟报案（超48小时） 0非迟报案的setter方法
	 */
	public void setLateregistFlag(String lateregistFlag) {
		this.lateregistFlag = lateregistFlag;
	}

	/**
	 * 属性迟报案原因/迟报案原因的getter方法
	 */
	public String getLateregistReason() {
		return lateregistReason;
	}

	/**
	 * 属性迟报案原因/迟报案原因的setter方法
	 */
	public void setLateregistReason(String lateregistReason) {
		this.lateregistReason = lateregistReason;
	}

	/**
	 * 属性出险辖区/出险辖区的getter方法
	 */
	public String getDamageArea() {
		return damageArea;
	}

	/**
	 * 属性出险辖区/出险辖区的setter方法
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

	/**
	 * 属性出险地点经度/出险地点经度的getter方法
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * 属性出险地点经度/出险地点经度的setter方法
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 属性出险地点纬度/出险地点纬度的getter方法
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * 属性出险地点纬度/出险地点纬度的setter方法
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getlFlag() {
		return lFlag;
	}

	public void setlFlag(String lFlag) {
		this.lFlag = lFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getPerilCount() {
		return perilCount;
	}

	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}

	public int getRecentCount() {
		return recentCount;
	}

	public void setRecentCount(int recentCount) {
		this.recentCount = recentCount;
	}

//	public PrpLregistListQueryDto getPrpLregistListQueryDto() {
//		return prpLregistListQueryDto;
//	}
//
//	public void setPrpLregistListQueryDto(PrpLregistListQueryDto prpLregistListQueryDto) {
//		this.prpLregistListQueryDto = prpLregistListQueryDto;
//	}

}
