package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 自然人信息表实体操作对象
 */
@Entity
@Table(name = "PrpPinsuredNature")
@IdClass(PrpPinsuredNatureKey.class)
public class PrpPinsuredNature extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;

	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性关系人标志/关系人标志 */
	@Column(name = "insuredFlag")
	private String insuredFlag ;
	/** 属性性别/性别 */
	@Column(name = "sex")
	private String sex ;
	/** 属性年龄/年龄 */
	@Column(name = "age")
	private Integer age ;
	/** 属性出生日/出生日 */
	@Column(name = "birthday")
	private Date birthday ;
	/** 属性健康状态/健康状态 */
	@Column(name = "health")
	private String health ;
	/** 属性职称/职称 */
	@Column(name = "jobTitle")
	private String jobTitle ;
	/** 属性在本地工作年限/在本地工作年限 */
	@Column(name = "loacalWorkYears")
	private Integer loacalWorkYears ;
	/** 属性学历/学历 */
	@Column(name = "education")
	private String education ;
	/** 属性总工龄/总工龄 */
	@Column(name = "totalWorkYears")
	private Integer totalWorkYears ;
	/** 属性单位名称/单位名称 */
	@Column(name = "unit")
	private String unit ;
	/** 属性单位电话/单位电话 */
	@Column(name = "unitPhoneNumber")
	private String unitPhoneNumber ;
	/** 属性单位地址/单位地址 */
	@Column(name = "unitAddress")
	private String unitAddress ;
	/** 属性单位邮编/单位邮编 */
	@Column(name = "unitPostCode")
	private String unitPostCode ;
	/** 属性单位类型/单位类型 */
	@Column(name = "unitType")
	private String unitType ;
	/** 属性职务内容/职务内容 */
	@Column(name = "dutyLevel")
	private String dutyLevel ;
	/** 属性职位/职位 */
	@Column(name = "dutyType")
	private String dutyType ;
	/** 属性兼职职业/工种代码/兼职职业/工种代码 */
	@Column(name = "occupationCode")
	private String occupationCode ;
	/** 属性房产状况/房产状况 */
	@Column(name = "houseProperty")
	private String houseProperty ;
	/** 属性户口所在地派出所名称/户口所在地派出所名称 */
	@Column(name = "localPoliceStation")
	private String localPoliceStation ;
	/** 属性经常住房地/经常住房地 */
	@Column(name = "roomAddress")
	private String roomAddress ;
	/** 属性邮政编码/邮政编码 */
	@Column(name = "roomPostCode")
	private String roomPostCode ;
	/** 属性本人月收入/本人月收入 */
	@Column(name = "selfMonthIncome")
	private Double selfMonthIncome ;
	/** 属性家庭月收入/家庭月收入 */
	@Column(name = "familyMonthIncome")
	private Double familyMonthIncome ;
	/** 属性收入来源/收入来源 */
	@Column(name = "incomeSource")
	private String incomeSource ;
	/** 属性常住房电话/常住房电话 */
	@Column(name = "roomPhone")
	private String roomPhone ;
	/** 属性手提电话/手提电话 */
	@Column(name = "mobile")
	private String mobile ;
	/** 属性家庭人口/家庭人口 */
	@Column(name = "familySumQuantity")
	private Integer familySumQuantity ;
	/** 属性婚姻状况/婚姻状况 */
	@Column(name = "marriage")
	private String marriage ;
	/** 属性配偶姓名/配偶姓名 */
	@Column(name = "spouseName")
	private String spouseName ;
	/** 属性配偶出生年月/配偶出生年月 */
	@Column(name = "spouseBornDate")
	private Date spouseBornDate ;
	/** 属性配偶身份证号码/配偶身份证号码 */
	@Column(name = "spouseId")
	private String spouseId ;
	/** 属性配偶单位/配偶单位 */
	@Column(name = "spouseUnit")
	private String spouseUnit ;
	/** 属性配偶职务/配偶职务 */
	@Column(name = "spouseJobTitle")
	private String spouseJobTitle ;
	/** 属性配偶单位电话/配偶单位电话 */
	@Column(name = "spouseUnitPhone")
	private String spouseUnitPhone ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性weight/weight */
	@Column(name = "weight")
	private Double weight ;
	/** 属性stature/stature */
	@Column(name = "stature")
	private Integer stature ;
	/** 属性子女情况/子女情况 */
	@Column(name = "childrenCondition")
	private String childrenCondition ;
	/** 属性vehicle/vehicle */
	@Column(name = "vehicle")
	private String vehicle ;
	/** 属性民族/民族 */
	@Column(name = "nation")
	private String nation ;
	/** 属性签发机关/签发机关 */
	@Column(name = "issuedAt")
	private String issuedAt ;
	/** 属性模块号码/模块号码 */
	@Column(name = "samId")
	private String samId ;
	/** 属性身份证有效起始日期/身份证有效起始日期 */
	@Column(name = "certificadeStartDate")
	private Date certificadeStartDate ;
	/** 属性身份证有效终止日期/身份证有效终止日期 */
	@Column(name = "certificadeEndDate")
	private Date certificadeEndDate ;
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
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
	public Integer getAge() {
		return age;
	}
	/**
	 * 属性年龄/年龄的setter方法
	 */
	public void setAge(Integer age) {
		this.age = age;
	} 	
	/**
	 * 属性出生日/出生日的getter方法
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 属性出生日/出生日的setter方法
	 */
	public void setBirthday(Date birthday) {
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
	public Integer getLoacalWorkYears() {
		return loacalWorkYears;
	}
	/**
	 * 属性在本地工作年限/在本地工作年限的setter方法
	 */
	public void setLoacalWorkYears(Integer loacalWorkYears) {
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
	 * 属性总工龄/总工龄的getter方法
	 */
	public Integer getTotalWorkYears() {
		return totalWorkYears;
	}
	/**
	 * 属性总工龄/总工龄的setter方法
	 */
	public void setTotalWorkYears(Integer totalWorkYears) {
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
	 * 属性本人月收入/本人月收入的getter方法
	 */
	public Double getSelfMonthIncome() {
		return selfMonthIncome;
	}
	/**
	 * 属性本人月收入/本人月收入的setter方法
	 */
	public void setSelfMonthIncome(Double selfMonthIncome) {
		this.selfMonthIncome = selfMonthIncome;
	} 	
	/**
	 * 属性家庭月收入/家庭月收入的getter方法
	 */
	public Double getFamilyMonthIncome() {
		return familyMonthIncome;
	}
	/**
	 * 属性家庭月收入/家庭月收入的setter方法
	 */
	public void setFamilyMonthIncome(Double familyMonthIncome) {
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
	public Integer getFamilySumQuantity() {
		return familySumQuantity;
	}
	/**
	 * 属性家庭人口/家庭人口的setter方法
	 */
	public void setFamilySumQuantity(Integer familySumQuantity) {
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
	public Date getSpouseBornDate() {
		return spouseBornDate;
	}
	/**
	 * 属性配偶出生年月/配偶出生年月的setter方法
	 */
	public void setSpouseBornDate(Date spouseBornDate) {
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
	public Double getWeight() {
		return weight;
	}
	/**
	 * 属性weight/weight的setter方法
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	} 	
	/**
	 * 属性stature/stature的getter方法
	 */
	public Integer getStature() {
		return stature;
	}
	/**
	 * 属性stature/stature的setter方法
	 */
	public void setStature(Integer stature) {
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
	public Date getCertificadeStartDate() {
		return certificadeStartDate;
	}
	/**
	 * 属性身份证有效起始日期/身份证有效起始日期的setter方法
	 */
	public void setCertificadeStartDate(Date certificadeStartDate) {
		this.certificadeStartDate = certificadeStartDate;
	} 	
	/**
	 * 属性身份证有效终止日期/身份证有效终止日期的getter方法
	 */
	public Date getCertificadeEndDate() {
		return certificadeEndDate;
	}
	/**
	 * 属性身份证有效终止日期/身份证有效终止日期的setter方法
	 */
	public void setCertificadeEndDate(Date certificadeEndDate) {
		this.certificadeEndDate = certificadeEndDate;
	} 	
}