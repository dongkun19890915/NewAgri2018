package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * 自然人信息表Api操作对象
 */
public class PrpTinsuredNatureDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	private String proposalNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性关系人标志/关系人标志 */
	private String insuredFlag ;		
	/** 属性性别/性别 */
	private String sex ;		
	/** 属性年龄/年龄 */
	private java.lang.Integer age ;		
	/** 属性出生日期/出生日期 */
	private java.util.Date birthday ;		
	/** 属性健康状态/健康状态 */
	private String health ;		
	/** 属性职称/职称 */
	private String jobTitle ;		
	/** 属性在本地工作年限/在本地工作年限 */
	private java.lang.Integer loacalWorkYears ;		
	/** 属性学历/学历 */
	private String education ;		
	/** 属性总工龄-人身意外险2706借用此字段来表示驾龄/总工龄-人身意外险2706借用此字段来表示驾龄 */
	private java.lang.Integer totalWorkYears ;		
	/** 属性单位名称/单位名称 */
	private String unit ;		
	/** 属性单位电话/单位电话 */
	private String unitPhoneNumber ;		
	/** 属性单位地址/单位地址 */
	private String unitAddress ;		
	/** 属性单位邮编/单位邮编 */
	private String unitPostCode ;		
	/** 属性单位类型/单位类型 */
	private String unitType ;		
	/** 属性职务内容/职务内容 */
	private String dutyLevel ;		
	/** 属性职位/职位 */
	private String dutyType ;		
	/** 属性兼职职业/工种代码/兼职职业/工种代码 */
	private String occupationCode ;		
	/** 属性房产状况/房产状况 */
	private String houseProperty ;		
	/** 属性户口所在地派出所名称/户口所在地派出所名称 */
	private String localPoliceStation ;		
	/** 属性经常住房地/经常住房地 */
	private String roomAddress ;		
	/** 属性邮政编码/邮政编码 */
	private String roomPostCode ;		
	/** 属性本人月收入-人身意外险2706借用此字段来表示年薪/本人月收入-人身意外险2706借用此字段来表示年薪 */
	private java.lang.Double selfMonthIncome ;		
	/** 属性家庭月收入/家庭月收入 */
	private java.lang.Double familyMonthIncome ;		
	/** 属性收入来源/收入来源 */
	private String incomeSource ;		
	/** 属性常住房电话/常住房电话 */
	private String roomPhone ;		
	/** 属性手提电话/手提电话 */
	private String mobile ;		
	/** 属性家庭人口/家庭人口 */
	private java.lang.Integer familySumQuantity ;		
	/** 属性婚姻状况/婚姻状况 */
	private String marriage ;		
	/** 属性配偶姓名/配偶姓名 */
	private String spouseName ;		
	/** 属性配偶出生年月/配偶出生年月 */
	private java.util.Date spouseBornDate ;		
	/** 属性配偶身份证号码/配偶身份证号码 */
	private String spouseId ;		
	/** 属性配偶单位/配偶单位 */
	private String spouseUnit ;		
	/** 属性配偶职务/配偶职务 */
	private String spouseJobTitle ;		
	/** 属性配偶单位电话/配偶单位电话 */
	private String spouseUnitPhone ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性weight/weight */
	private java.lang.Double weight ;		
	/** 属性stature/stature */
	private java.lang.Integer stature ;		
	/** 属性子女情况/子女情况 */
	private String childrenCondition ;		
	/** 属性vehicle/vehicle */
	private String vehicle ;		
	/** 属性民族/民族 */
	private String nation ;		
	/** 属性签发机关/签发机关 */
	private String issuedAt ;		
	/** 属性模块号码/模块号码 */
	private String samId ;		
	/** 属性身份证有效起始日期/身份证有效起始日期 */
	private java.util.Date certificadeStartDate ;		
	/** 属性身份证有效终止日期/身份证有效终止日期 */
	private java.util.Date certificadeEndDate ;		
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性关系人标志/关系人标志的getter方法
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}
	/**
	 * 属性关系人标志/关系人标志的setter方法
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}	
	/**
	 * 属性性别/性别的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别/性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}	
	/**
	 * 属性年龄/年龄的getter方法
	 */
	public java.lang.Integer getAge() {
		return age;
	}
	/**
	 * 属性年龄/年龄的setter方法
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}	
	/**
	 * 属性出生日期/出生日期的getter方法
	 */
	public java.util.Date getBirthday() {
		return birthday;
	}
	/**
	 * 属性出生日期/出生日期的setter方法
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}	
	/**
	 * 属性健康状态/健康状态的getter方法
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * 属性健康状态/健康状态的setter方法
	 */
	public void setHealth(String health) {
		this.health = health;
	}	
	/**
	 * 属性职称/职称的getter方法
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * 属性职称/职称的setter方法
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
	/**
	 * 属性在本地工作年限/在本地工作年限的getter方法
	 */
	public java.lang.Integer getLoacalWorkYears() {
		return loacalWorkYears;
	}
	/**
	 * 属性在本地工作年限/在本地工作年限的setter方法
	 */
	public void setLoacalWorkYears(java.lang.Integer loacalWorkYears) {
		this.loacalWorkYears = loacalWorkYears;
	}	
	/**
	 * 属性学历/学历的getter方法
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 属性学历/学历的setter方法
	 */
	public void setEducation(String education) {
		this.education = education;
	}	
	/**
	 * 属性总工龄-人身意外险2706借用此字段来表示驾龄/总工龄-人身意外险2706借用此字段来表示驾龄的getter方法
	 */
	public java.lang.Integer getTotalWorkYears() {
		return totalWorkYears;
	}
	/**
	 * 属性总工龄-人身意外险2706借用此字段来表示驾龄/总工龄-人身意外险2706借用此字段来表示驾龄的setter方法
	 */
	public void setTotalWorkYears(java.lang.Integer totalWorkYears) {
		this.totalWorkYears = totalWorkYears;
	}	
	/**
	 * 属性单位名称/单位名称的getter方法
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 属性单位名称/单位名称的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}	
	/**
	 * 属性单位电话/单位电话的getter方法
	 */
	public String getUnitPhoneNumber() {
		return unitPhoneNumber;
	}
	/**
	 * 属性单位电话/单位电话的setter方法
	 */
	public void setUnitPhoneNumber(String unitPhoneNumber) {
		this.unitPhoneNumber = unitPhoneNumber;
	}	
	/**
	 * 属性单位地址/单位地址的getter方法
	 */
	public String getUnitAddress() {
		return unitAddress;
	}
	/**
	 * 属性单位地址/单位地址的setter方法
	 */
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}	
	/**
	 * 属性单位邮编/单位邮编的getter方法
	 */
	public String getUnitPostCode() {
		return unitPostCode;
	}
	/**
	 * 属性单位邮编/单位邮编的setter方法
	 */
	public void setUnitPostCode(String unitPostCode) {
		this.unitPostCode = unitPostCode;
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
	 * 属性职务内容/职务内容的getter方法
	 */
	public String getDutyLevel() {
		return dutyLevel;
	}
	/**
	 * 属性职务内容/职务内容的setter方法
	 */
	public void setDutyLevel(String dutyLevel) {
		this.dutyLevel = dutyLevel;
	}	
	/**
	 * 属性职位/职位的getter方法
	 */
	public String getDutyType() {
		return dutyType;
	}
	/**
	 * 属性职位/职位的setter方法
	 */
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}	
	/**
	 * 属性兼职职业/工种代码/兼职职业/工种代码的getter方法
	 */
	public String getOccupationCode() {
		return occupationCode;
	}
	/**
	 * 属性兼职职业/工种代码/兼职职业/工种代码的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}	
	/**
	 * 属性房产状况/房产状况的getter方法
	 */
	public String getHouseProperty() {
		return houseProperty;
	}
	/**
	 * 属性房产状况/房产状况的setter方法
	 */
	public void setHouseProperty(String houseProperty) {
		this.houseProperty = houseProperty;
	}	
	/**
	 * 属性户口所在地派出所名称/户口所在地派出所名称的getter方法
	 */
	public String getLocalPoliceStation() {
		return localPoliceStation;
	}
	/**
	 * 属性户口所在地派出所名称/户口所在地派出所名称的setter方法
	 */
	public void setLocalPoliceStation(String localPoliceStation) {
		this.localPoliceStation = localPoliceStation;
	}	
	/**
	 * 属性经常住房地/经常住房地的getter方法
	 */
	public String getRoomAddress() {
		return roomAddress;
	}
	/**
	 * 属性经常住房地/经常住房地的setter方法
	 */
	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getRoomPostCode() {
		return roomPostCode;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setRoomPostCode(String roomPostCode) {
		this.roomPostCode = roomPostCode;
	}	
	/**
	 * 属性本人月收入-人身意外险2706借用此字段来表示年薪/本人月收入-人身意外险2706借用此字段来表示年薪的getter方法
	 */
	public java.lang.Double getSelfMonthIncome() {
		return selfMonthIncome;
	}
	/**
	 * 属性本人月收入-人身意外险2706借用此字段来表示年薪/本人月收入-人身意外险2706借用此字段来表示年薪的setter方法
	 */
	public void setSelfMonthIncome(java.lang.Double selfMonthIncome) {
		this.selfMonthIncome = selfMonthIncome;
	}	
	/**
	 * 属性家庭月收入/家庭月收入的getter方法
	 */
	public java.lang.Double getFamilyMonthIncome() {
		return familyMonthIncome;
	}
	/**
	 * 属性家庭月收入/家庭月收入的setter方法
	 */
	public void setFamilyMonthIncome(java.lang.Double familyMonthIncome) {
		this.familyMonthIncome = familyMonthIncome;
	}	
	/**
	 * 属性收入来源/收入来源的getter方法
	 */
	public String getIncomeSource() {
		return incomeSource;
	}
	/**
	 * 属性收入来源/收入来源的setter方法
	 */
	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}	
	/**
	 * 属性常住房电话/常住房电话的getter方法
	 */
	public String getRoomPhone() {
		return roomPhone;
	}
	/**
	 * 属性常住房电话/常住房电话的setter方法
	 */
	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}	
	/**
	 * 属性手提电话/手提电话的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性手提电话/手提电话的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
	/**
	 * 属性家庭人口/家庭人口的getter方法
	 */
	public java.lang.Integer getFamilySumQuantity() {
		return familySumQuantity;
	}
	/**
	 * 属性家庭人口/家庭人口的setter方法
	 */
	public void setFamilySumQuantity(java.lang.Integer familySumQuantity) {
		this.familySumQuantity = familySumQuantity;
	}	
	/**
	 * 属性婚姻状况/婚姻状况的getter方法
	 */
	public String getMarriage() {
		return marriage;
	}
	/**
	 * 属性婚姻状况/婚姻状况的setter方法
	 */
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}	
	/**
	 * 属性配偶姓名/配偶姓名的getter方法
	 */
	public String getSpouseName() {
		return spouseName;
	}
	/**
	 * 属性配偶姓名/配偶姓名的setter方法
	 */
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}	
	/**
	 * 属性配偶出生年月/配偶出生年月的getter方法
	 */
	public java.util.Date getSpouseBornDate() {
		return spouseBornDate;
	}
	/**
	 * 属性配偶出生年月/配偶出生年月的setter方法
	 */
	public void setSpouseBornDate(java.util.Date spouseBornDate) {
		this.spouseBornDate = spouseBornDate;
	}	
	/**
	 * 属性配偶身份证号码/配偶身份证号码的getter方法
	 */
	public String getSpouseId() {
		return spouseId;
	}
	/**
	 * 属性配偶身份证号码/配偶身份证号码的setter方法
	 */
	public void setSpouseId(String spouseId) {
		this.spouseId = spouseId;
	}	
	/**
	 * 属性配偶单位/配偶单位的getter方法
	 */
	public String getSpouseUnit() {
		return spouseUnit;
	}
	/**
	 * 属性配偶单位/配偶单位的setter方法
	 */
	public void setSpouseUnit(String spouseUnit) {
		this.spouseUnit = spouseUnit;
	}	
	/**
	 * 属性配偶职务/配偶职务的getter方法
	 */
	public String getSpouseJobTitle() {
		return spouseJobTitle;
	}
	/**
	 * 属性配偶职务/配偶职务的setter方法
	 */
	public void setSpouseJobTitle(String spouseJobTitle) {
		this.spouseJobTitle = spouseJobTitle;
	}	
	/**
	 * 属性配偶单位电话/配偶单位电话的getter方法
	 */
	public String getSpouseUnitPhone() {
		return spouseUnitPhone;
	}
	/**
	 * 属性配偶单位电话/配偶单位电话的setter方法
	 */
	public void setSpouseUnitPhone(String spouseUnitPhone) {
		this.spouseUnitPhone = spouseUnitPhone;
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
	 * 属性weight/weight的getter方法
	 */
	public java.lang.Double getWeight() {
		return weight;
	}
	/**
	 * 属性weight/weight的setter方法
	 */
	public void setWeight(java.lang.Double weight) {
		this.weight = weight;
	}	
	/**
	 * 属性stature/stature的getter方法
	 */
	public java.lang.Integer getStature() {
		return stature;
	}
	/**
	 * 属性stature/stature的setter方法
	 */
	public void setStature(java.lang.Integer stature) {
		this.stature = stature;
	}	
	/**
	 * 属性子女情况/子女情况的getter方法
	 */
	public String getChildrenCondition() {
		return childrenCondition;
	}
	/**
	 * 属性子女情况/子女情况的setter方法
	 */
	public void setChildrenCondition(String childrenCondition) {
		this.childrenCondition = childrenCondition;
	}	
	/**
	 * 属性vehicle/vehicle的getter方法
	 */
	public String getVehicle() {
		return vehicle;
	}
	/**
	 * 属性vehicle/vehicle的setter方法
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}	
	/**
	 * 属性民族/民族的getter方法
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 属性民族/民族的setter方法
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}	
	/**
	 * 属性签发机关/签发机关的getter方法
	 */
	public String getIssuedAt() {
		return issuedAt;
	}
	/**
	 * 属性签发机关/签发机关的setter方法
	 */
	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}	
	/**
	 * 属性模块号码/模块号码的getter方法
	 */
	public String getSamId() {
		return samId;
	}
	/**
	 * 属性模块号码/模块号码的setter方法
	 */
	public void setSamId(String samId) {
		this.samId = samId;
	}	
	/**
	 * 属性身份证有效起始日期/身份证有效起始日期的getter方法
	 */
	public java.util.Date getCertificadeStartDate() {
		return certificadeStartDate;
	}
	/**
	 * 属性身份证有效起始日期/身份证有效起始日期的setter方法
	 */
	public void setCertificadeStartDate(java.util.Date certificadeStartDate) {
		this.certificadeStartDate = certificadeStartDate;
	}	
	/**
	 * 属性身份证有效终止日期/身份证有效终止日期的getter方法
	 */
	public java.util.Date getCertificadeEndDate() {
		return certificadeEndDate;
	}
	/**
	 * 属性身份证有效终止日期/身份证有效终止日期的setter方法
	 */
	public void setCertificadeEndDate(java.util.Date certificadeEndDate) {
		this.certificadeEndDate = certificadeEndDate;
	}	
}
