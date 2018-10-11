package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTinsuredDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保险关系人表Api操作对象
 */
public class PrpCinsuredDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性投保人信息/投保人信息 */
	private Integer serialNo ;
	/** 属性language/language */
	private String language ;		
	/** 属性保险人类型/保险人类型 */
	private String insuredType ;		
	/** 属性保险人代码/保险人代码 */
	private String insuredCode ;		
	/** 属性保险人/保险人 */
	private String insuredName ;		
	/** 属性保险地址/保险地址 */
	private String insuredAddress ;		
	/** 属性insuredNature/insuredNature */
	private String insuredNature ;		
	/** 属性保险人标志/保险人标志 */
	private String insuredFlag ;		
	/** 属性保险人类型1/保险人类型1 */
	private String insuredIdentity ;		
	/** 属性relateserialNo/relateserialNo */
	private Integer relateSerialNo ;
	/** 属性证件类型/证件类型 */
	private String identifyType ;		
	/** 属性证件号码/证件号码 */
	private String identifyNumber ;		
	/** 属性creditLevel/creditlevel */
	private String creditLevel ;
	/** 属性possessNature/possessNature */
	private String possessNature ;		
	/** 属性businessSource/businessSource */
	private String businessSource ;
	/** 属性businessSourceName/businessSourceName */
	private String businessSourceName ;
	/** 属性businessSort/businessSort */
	private String businessSort ;		
	/** 属性occupationCode/occupationCode */
	private String occupationCode ;		
	/** 属性educationCode/educationCode */
	private String educationCode ;		
	/** 属性bank/bank */
	private String bank ;		
	/** 属性accountName/accountName */
	private String accountName ;		
	/** 属性account/account */
	private String account ;		
	/** 属性linkerName/linkerName */
	private String linkerName ;		
	/** 属性postAddress/postAddress */
	private String postAddress ;		
	/** 属性postCode/postCode */
	private String postCode ;		
	/** 属性phoneNumber/phoneNumber */
	private String phoneNumber ;		
	/** 属性mobile/mobile */
	private String mobile ;		
	/** 属性email/email */
	private String email ;		
	/** 属性benefitRate/benefitRate */
	private Double benefitRate ;
	/** 属性benefitFlag/benefitFlag */
	private String benefitFlag ;		
	/** 属性flag/flag */
	private String flag ="";
	/** 属性occupationgRade/occupationgrade */
	private String occupationGrade ;
	/** 属性风险等级/风险等级 */
	private String riskLevel ;		
	/** 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息 */
	private String isCareClaim ;
	/** 属性行业现金密集程度/行业现金密集程度 */
	private String cashFocus ;		
	/** 属性证件有效期限/证件有效期限 */
	private String validPeriod3 ;
	/** 属性职称/职称 */
	private String jobTitle ;
	/** 属性国籍/国籍 */
	private String nationality ;		
	/** 属性营业执照/营业执照 */
	private String businessCode ;		
	/** 属性税务登记号码/税务登记号码 */
	private String revenueRegistNo ;
	/** 属性营业执照到期日/营业执照到期日 */
	private java.util.Date businessValidPeriod ;
	/** 属性税务登记有效期/税务登记有效期 */
	private String revenueRegistValidPeriod ;
	/** 属性其他证件号码/其他证件号码 */
	private String otherCodeNo ;
	/** 属性其他证件有效期/其他证件有效期 */
	private String otherCodeValidPeriod ;
	/** 属性性别/性别 */
	private String sex ;		
	/** 属性wechatNo/wechatNo */
	private String wechatNo ;		
	/** 属性vipFlag/vipFlag */
	private String vipFlag ;		
	/** 属性certificatEname/certificateName */
	private String certificateName ;		
	/** 属性customerKind/customerKind */
	private String customerKind ;		
	/** 属性insuredSort/insuredSort */
	private String insuredSort ;		
	/** 属性licensestartDate/licenseStartDate */
	private java.util.Date licenseStartDate ;		
	/** 属性nationFlag/nationFlag */
	private String nationFlag ;		
	/** 属性benefitType/benefitType */
	private String benefitType ;		
	/** 属性年龄/年龄 */
	private String age ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/** 属性与投保人关系/与投保人关系 */
	private String applyRealation ;
	/** 属性客户编码/客户编码 */
	private String customerSequenceNo ;

	/** add by 王心洋 20171030 begin*/
	/** 属性职称/职称名称*/
	private String jobtitleName ;
	/** 属性businessSort/businessSortName */
	private String businessSortName;
	/** 属性保险人类型1/保险人类型名称1 */
	private String insuredIdentityName;
	/**投保人风险等级*/
	private String riskLevelName;
	private String insuredTypeName;
	private String insuredFlagName;
	private String insuredNatureName;
	private String insuredLanguageName;

	public String getBusinessSourceName() {
		return businessSourceName;
	}

	public void setBusinessSourceName(String businessSourceName) {
		this.businessSourceName = businessSourceName;
	}

	/** add by 王心洋 20171030 end*/



	public String getJobtitleName() {
		return jobtitleName;
	}

	public String getInsuredIdentityName() {
		return insuredIdentityName;
	}

	public String getBusinessSortName() {
		return businessSortName;
	}

	public String getRiskLevelName() {
		return riskLevelName;
	}

	public String getInsuredTypeName() {
		return insuredTypeName;
	}

	public void setInsuredTypeName(String insuredTypeName) {
		this.insuredTypeName = insuredTypeName;
	}

	public String getInsuredFlagName() {
		return insuredFlagName;
	}

	public void setInsuredFlagName(String insuredFlagName) {
		this.insuredFlagName = insuredFlagName;
	}

	public String getInsuredNatureName() {
		return insuredNatureName;
	}

	public void setInsuredNatureName(String insuredNatureName) {
		this.insuredNatureName = insuredNatureName;
	}

	public String getInsuredLanguageName() {
		return insuredLanguageName;
	}

	public void setInsuredLanguageName(String insuredLanguageName) {
		this.insuredLanguageName = insuredLanguageName;
	}

	public void setJobtitleName(String jobtitleName) {
		this.jobtitleName = jobtitleName;
	}

	public void setBusinessSortName(String businessSortName) {
		this.businessSortName = businessSortName;
	}

	public void setInsuredIdentityName(String insuredIdentityName) {
		this.insuredIdentityName = insuredIdentityName;
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
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
	 * 属性投保人信息/投保人信息的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性投保人信息/投保人信息的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性language/language的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性language/language的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	}	
	/**
	 * 属性保险人类型/保险人类型的getter方法
	 */
	public String getInsuredType() {
		return insuredType;
	}
	/**
	 * 属性保险人类型/保险人类型的setter方法
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}	
	/**
	 * 属性保险人代码/保险人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性保险人代码/保险人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}	
	/**
	 * 属性保险人/保险人的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性保险人/保险人的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}	
	/**
	 * 属性保险地址/保险地址的getter方法
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}
	/**
	 * 属性保险地址/保险地址的setter方法
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}	
	/**
	 * 属性insuredNature/insuredNature的getter方法
	 */
	public String getInsuredNature() {
		return insuredNature;
	}
	/**
	 * 属性insuredNature/insuredNature的setter方法
	 */
	public void setInsuredNature(String insuredNature) {
		this.insuredNature = insuredNature;
	}	
	/**
	 * 属性保险人标志/保险人标志的getter方法
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}
	/**
	 * 属性保险人标志/保险人标志的setter方法
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}	
	/**
	 * 属性保险人类型1/保险人类型1的getter方法
	 */
	public String getInsuredIdentity() {
		return insuredIdentity;
	}
	/**
	 * 属性保险人类型1/保险人类型1的setter方法
	 */
	public void setInsuredIdentity(String insuredIdentity) {
		this.insuredIdentity = insuredIdentity;
	}	

	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	

	/**
	 * 属性possessNature/possessNature的getter方法
	 */
	public String getPossessNature() {
		return possessNature;
	}
	/**
	 * 属性possessNature/possessNature的setter方法
	 */
	public void setPossessNature(String possessNature) {
		this.possessNature = possessNature;
	}	
	/**
	 * 属性businessSource/businessSource的getter方法
	 */
	public String getBusinessSource() {
		return businessSource;
	}
	/**
	 * 属性businessSource/businessSource的setter方法
	 */
	public void setBusinessSource(String businessSource) {
		this.businessSource = businessSource;
	}	
	/**
	 * 属性businessSort/businessSort的getter方法
	 */
	public String getBusinessSort() {
		return businessSort;
	}
	/**
	 * 属性businessSort/businessSort的setter方法
	 */
	public void setBusinessSort(String businessSort) {
		this.businessSort = businessSort;
	}	
	/**
	 * 属性occupationCode/occupationCode的getter方法
	 */
	public String getOccupationCode() {
		return occupationCode;
	}
	/**
	 * 属性occupationCode/occupationCode的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}	
	/**
	 * 属性educationCode/educationCode的getter方法
	 */
	public String getEducationCode() {
		return educationCode;
	}
	/**
	 * 属性educationCode/educationCode的setter方法
	 */
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}	
	/**
	 * 属性bank/bank的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性bank/bank的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}	
	/**
	 * 属性accountName/accountName的getter方法
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 属性accountName/accountName的setter方法
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	
	/**
	 * 属性account/account的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性account/account的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	}	
	/**
	 * 属性linkerName/linkerName的getter方法
	 */
	public String getLinkerName() {
		return linkerName;
	}
	/**
	 * 属性linkerName/linkerName的setter方法
	 */
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}	
	/**
	 * 属性postAddress/postAddress的getter方法
	 */
	public String getPostAddress() {
		return postAddress;
	}
	/**
	 * 属性postAddress/postAddress的setter方法
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}	
	/**
	 * 属性postCode/postCode的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性postCode/postCode的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性phoneNumber/phoneNumber的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性phoneNumber/phoneNumber的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	/**
	 * 属性mobile/mobile的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性mobile/mobile的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
	/**
	 * 属性email/email的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性email/email的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
	/**
	 * 属性benefitRate/benefitRate的getter方法
	 */
	public Double getBenefitRate() {
		return benefitRate;
	}
	/**
	 * 属性benefitRate/benefitRate的setter方法
	 */
	public void setBenefitRate(Double benefitRate) {
		this.benefitRate = benefitRate;
	}	
	/**
	 * 属性benefitFlag/benefitFlag的getter方法
	 */
	public String getBenefitFlag() {
		return benefitFlag;
	}
	/**
	 * 属性benefitFlag/benefitFlag的setter方法
	 */
	public void setBenefitFlag(String benefitFlag) {
		this.benefitFlag = benefitFlag;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	

	/**
	 * 属性风险等级/风险等级的getter方法
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 属性风险等级/风险等级的setter方法
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	

	/**
	 * 属性行业现金密集程度/行业现金密集程度的getter方法
	 */
	public String getCashFocus() {
		return cashFocus;
	}
	/**
	 * 属性行业现金密集程度/行业现金密集程度的setter方法
	 */
	public void setCashFocus(String cashFocus) {
		this.cashFocus = cashFocus;
	}	

	/**
	 * 属性国籍/国籍的getter方法
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * 属性国籍/国籍的setter方法
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}	
	/**
	 * 属性营业执照/营业执照的getter方法
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 属性营业执照/营业执照的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}


	public Integer getRelateSerialNo() {
		return relateSerialNo;
	}

	public void setRelateSerialNo(Integer relateSerialNo) {
		this.relateSerialNo = relateSerialNo;
	}

	public String getCreditLevel() {
		return creditLevel;
	}

	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

	public String getOccupationGrade() {
		return occupationGrade;
	}

	public void setOccupationGrade(String occupationGrade) {
		this.occupationGrade = occupationGrade;
	}

	public String getIsCareClaim() {
		return isCareClaim;
	}

	public void setIsCareClaim(String isCareClaim) {
		this.isCareClaim = isCareClaim;
	}

	public String getValidPeriod3() {
		return validPeriod3;
	}

	public void setValidPeriod3(String validPeriod3) {
		this.validPeriod3 = validPeriod3;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getRevenueRegistNo() {
		return revenueRegistNo;
	}

	public void setRevenueRegistNo(String revenueRegistNo) {
		this.revenueRegistNo = revenueRegistNo;
	}

	public Date getBusinessValidPeriod() {
		return businessValidPeriod;
	}

	public void setBusinessValidPeriod(Date businessValidPeriod) {
		this.businessValidPeriod = businessValidPeriod;
	}

	public String getRevenueRegistValidPeriod() {
		return revenueRegistValidPeriod;
	}

	public void setRevenueRegistValidPeriod(String revenueRegistValidPeriod) {
		this.revenueRegistValidPeriod = revenueRegistValidPeriod;
	}

	public String getOtherCodeNo() {
		return otherCodeNo;
	}

	public void setOtherCodeNo(String otherCodeNo) {
		this.otherCodeNo = otherCodeNo;
	}

	public String getOtherCodeValidPeriod() {
		return otherCodeValidPeriod;
	}

	public void setOtherCodeValidPeriod(String otherCodeValidPeriod) {
		this.otherCodeValidPeriod = otherCodeValidPeriod;
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
	 * 属性wechatNo/wechatNo的getter方法
	 */
	public String getWechatNo() {
		return wechatNo;
	}
	/**
	 * 属性wechatNo/wechatNo的setter方法
	 */
	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}	
	/**
	 * 属性vipFlag/vipFlag的getter方法
	 */
	public String getVipFlag() {
		return vipFlag;
	}
	/**
	 * 属性vipFlag/vipFlag的setter方法
	 */
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}	
	/**
	 * 属性certificatEname/certificatEname的getter方法
	 */
	public String getCertificateName() {
		return certificateName;
	}
	/**
	 * 属性certificatEname/certificatEname的setter方法
	 */
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}	
	/**
	 * 属性customerKind/customerKind的getter方法
	 */
	public String getCustomerKind() {
		return customerKind;
	}
	/**
	 * 属性customerKind/customerKind的setter方法
	 */
	public void setCustomerKind(String customerKind) {
		this.customerKind = customerKind;
	}	
	/**
	 * 属性insuredSort/insuredSort的getter方法
	 */
	public String getInsuredSort() {
		return insuredSort;
	}
	/**
	 * 属性insuredSort/insuredSort的setter方法
	 */
	public void setInsuredSort(String insuredSort) {
		this.insuredSort = insuredSort;
	}	
	/**
	 * 属性licensestartDate/licensestartDate的getter方法
	 */
	public java.util.Date getLicenseStartDate() {
		return licenseStartDate;
	}
	/**
	 * 属性licensestartDate/licensestartDate的setter方法
	 */
	public void setLicenseStartDate(java.util.Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}	
	/**
	 * 属性nationFlag/nationFlag的getter方法
	 */
	public String getNationFlag() {
		return nationFlag;
	}
	/**
	 * 属性nationFlag/nationFlag的setter方法
	 */
	public void setNationFlag(String nationFlag) {
		this.nationFlag = nationFlag;
	}	
	/**
	 * 属性benefitType/benefitType的getter方法
	 */
	public String getBenefitType() {
		return benefitType;
	}
	/**
	 * 属性benefitType/benefitType的setter方法
	 */
	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}	
	/**
	 * 属性年龄/年龄的getter方法
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 属性年龄/年龄的setter方法
	 */
	public void setAge(String age) {
		this.age = age;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
	}	
	/**
	 * 属性与投保人关系/与投保人关系的getter方法
	 */
	public String getApplyRealation() {
		return applyRealation;
	}
	/**
	 * 属性与投保人关系/与投保人关系的setter方法
	 */
	public void setApplyRealation(String applyRealation) {
		this.applyRealation = applyRealation;
	}	
	/**
	 * 属性客户编码/客户编码的getter方法
	 */
	public String getCustomerSequenceNo() {
		return customerSequenceNo;
	}
	/**
	 * 属性客户编码/客户编码的setter方法
	 */
	public void setCustomerSequenceNo(String customerSequenceNo) {
		this.customerSequenceNo = customerSequenceNo;
	}
}
