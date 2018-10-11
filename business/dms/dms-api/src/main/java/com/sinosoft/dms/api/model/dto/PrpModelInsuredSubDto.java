package com.sinosoft.dms.api.model.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板保险关系人表Api操作对象
 */
public class PrpModelInsuredSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板号码/模板号码 */
	private String modelCode ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	private String riskCode;
	/** 属性语种/语种 */
	private String language ;		
	/** 属性关系人类型/关系人类型 */
	private String insuredType ;		
	/** 属性关系人代码/关系人代码 */
	private String insuredCode ;		
	/** 属性关系人名称/关系人名称 */
	private String insuredName ;		
	/** 属性关系人地址/关系人地址 */
	private String insuredAddress ;		
	/** 属性关系人性质/关系人性质 */
	private String insuredNature ;		
	/** 属性关系人标志/关系人标志 */
	private String insuredFlag ;		
	/** 属性是被保险人的/是被保险人的 */
	private String insuredIdentity ;		
	/** 属性关联人序号/关联人序号 */
	private Integer relateserialNo ;
	/** 属性证件类型/证件类型 */
	private String identifyType ;		
	/** 属性个人身份证号码/个人身份证号码 */
	private String identifyNumber ;		
	/** 属性资信等级/资信等级 */
	private String creditLevel ;		
	/** 属性占用性质代码/占用性质代码 */
	private String possessNature ;		
	/** 属性行业代码/行业代码 */
	private String businessSource ;		
	/** 属性所有制代码/所有制代码 */
	private String businessSort ;		
	/** 属性个人职业代码/个人职业代码 */
	private String occupationCode ;		
	/** 属性个人学历代码/个人学历代码 */
	private String educationCode ;		
	/** 属性开户银行/开户银行 */
	private String bank ;		
	/** 属性帐户名/帐户名 */
	private String accountName ;		
	/** 属性 开户账号/ 开户账号 */
	private String account ;		
	/** 属性联系人名称/联系人名称 */
	private String linkerName ;		
	/** 属性通信地址/通信地址 */
	private String postAddress ;		
	/** 属性 邮政编码/ 邮政编码 */
	private String postCode ;		
	/** 属性 电话/ 电话 */
	private String phoneNumber ;		
	/** 属性移动电话/移动电话 */
	private String mobile ;		
	/** 属性电子邮件/电子邮件 */
	private String email ;		
	/** 属性受益份额/受益份额 */
	private Double benefitRate ;
	/** 属性受益人顺序/受益人顺序 */
	private String benefitFlag ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性occupationGrade/occupationGrade */
	private String occupationGrade ;		
	/** 属性风险等级/风险等级 */
	private String riskLevel ;		
	/** 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息 */
	private String iscareClaim ;		
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
	private String revenueregistValidPeriod ;		
	/** 属性其他证件号码/其他证件号码 */
	private String otherCodeNo ;		
	/** 属性其他证件有效期/其他证件有效期 */
	private String otherCodeValidPeriod ;		
	/** 属性sex/sex */
	private String sex ;		
	/** 属性微信号/微信号 */
	private String wechatNo ;		
	/** 属性VIP标识/VIP标识 */
	private String vipFlag ;		
	/** 属性证件名称/证件名称 */
	private String certificatEName ;		
	/** 属性国籍1/国籍1 */
	private String customerKind ;		
	/** 属性被保险人分类/被保险人分类 */
	private String insuredSort ;		
	/** 属性营业执照有效起始日期/营业执照有效起始日期 */
	private java.util.Date licenseStartDate ;		
	/** 属性境内外标识/境内外标识 */
	private String nationFlag ;		
	/** 属性受益人分类/受益人分类 */
	private String benefitType ;		
	/** 属性age/age */
	private String age ;
	/** 属性客户编码/客户编码 */
	private String customerseQuenceNo ;		
	/** 属性与投保人关系/与投保人关系 */
	private String applyRealation ;
	private String insuredIdentity1;
	private String sexuality;
	private String licenseenddate;
	/**
	 * 属性模板号码/模板号码的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * 属性模板号码/模板号码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
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
	 * 属性关系人类型/关系人类型的getter方法
	 */
	public String getInsuredType() {
		return insuredType;
	}
	/**
	 * 属性关系人类型/关系人类型的setter方法
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}	
	/**
	 * 属性关系人代码/关系人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性关系人代码/关系人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}	
	/**
	 * 属性关系人名称/关系人名称的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性关系人名称/关系人名称的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}	
	/**
	 * 属性关系人地址/关系人地址的getter方法
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}
	/**
	 * 属性关系人地址/关系人地址的setter方法
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}	
	/**
	 * 属性关系人性质/关系人性质的getter方法
	 */
	public String getInsuredNature() {
		return insuredNature;
	}
	/**
	 * 属性关系人性质/关系人性质的setter方法
	 */
	public void setInsuredNature(String insuredNature) {
		this.insuredNature = insuredNature;
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
	 * 属性是被保险人的/是被保险人的的getter方法
	 */
	public String getInsuredIdentity() {
		return insuredIdentity;
	}
	/**
	 * 属性是被保险人的/是被保险人的的setter方法
	 */
	public void setInsuredIdentity(String insuredIdentity) {
		this.insuredIdentity = insuredIdentity;
	}	
	/**
	 * 属性关联人序号/关联人序号的getter方法
	 */
	public Integer getRelateserialNo() {
		return relateserialNo;
	}
	/**
	 * 属性关联人序号/关联人序号的setter方法
	 */
	public void setRelateserialNo(Integer relateserialNo) {
		this.relateserialNo = relateserialNo;
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
	 * 属性个人身份证号码/个人身份证号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性个人身份证号码/个人身份证号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性资信等级/资信等级的getter方法
	 */
	public String getCreditLevel() {
		return creditLevel;
	}
	/**
	 * 属性资信等级/资信等级的setter方法
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}	
	/**
	 * 属性占用性质代码/占用性质代码的getter方法
	 */
	public String getPossessNature() {
		return possessNature;
	}
	/**
	 * 属性占用性质代码/占用性质代码的setter方法
	 */
	public void setPossessNature(String possessNature) {
		this.possessNature = possessNature;
	}	
	/**
	 * 属性行业代码/行业代码的getter方法
	 */
	public String getBusinessSource() {
		return businessSource;
	}
	/**
	 * 属性行业代码/行业代码的setter方法
	 */
	public void setBusinessSource(String businessSource) {
		this.businessSource = businessSource;
	}	
	/**
	 * 属性所有制代码/所有制代码的getter方法
	 */
	public String getBusinessSort() {
		return businessSort;
	}
	/**
	 * 属性所有制代码/所有制代码的setter方法
	 */
	public void setBusinessSort(String businessSort) {
		this.businessSort = businessSort;
	}	
	/**
	 * 属性个人职业代码/个人职业代码的getter方法
	 */
	public String getOccupationCode() {
		return occupationCode;
	}
	/**
	 * 属性个人职业代码/个人职业代码的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}	
	/**
	 * 属性个人学历代码/个人学历代码的getter方法
	 */
	public String getEducationCode() {
		return educationCode;
	}
	/**
	 * 属性个人学历代码/个人学历代码的setter方法
	 */
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}	
	/**
	 * 属性帐户名/帐户名的getter方法
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 属性帐户名/帐户名的setter方法
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	
	/**
	 * 属性 开户账号/ 开户账号的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性 开户账号/ 开户账号的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	}	
	/**
	 * 属性联系人名称/联系人名称的getter方法
	 */
	public String getLinkerName() {
		return linkerName;
	}
	/**
	 * 属性联系人名称/联系人名称的setter方法
	 */
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}	
	/**
	 * 属性通信地址/通信地址的getter方法
	 */
	public String getPostAddress() {
		return postAddress;
	}
	/**
	 * 属性通信地址/通信地址的setter方法
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}	
	/**
	 * 属性 邮政编码/ 邮政编码的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性 邮政编码/ 邮政编码的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性 电话/ 电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性 电话/ 电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	/**
	 * 属性移动电话/移动电话的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性移动电话/移动电话的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
	/**
	 * 属性电子邮件/电子邮件的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性电子邮件/电子邮件的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
	/**
	 * 属性受益份额/受益份额的getter方法
	 */
	public Double getBenefitRate() {
		return benefitRate;
	}
	/**
	 * 属性受益份额/受益份额的setter方法
	 */
	public void setBenefitRate(Double benefitRate) {
		this.benefitRate = benefitRate;
	}	
	/**
	 * 属性受益人顺序/受益人顺序的getter方法
	 */
	public String getBenefitFlag() {
		return benefitFlag;
	}
	/**
	 * 属性受益人顺序/受益人顺序的setter方法
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
	 * 属性occupationGrade/occupationGrade的getter方法
	 */
	public String getOccupationGrade() {
		return occupationGrade;
	}
	/**
	 * 属性occupationGrade/occupationGrade的setter方法
	 */
	public void setOccupationGrade(String occupationGrade) {
		this.occupationGrade = occupationGrade;
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
	 * 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息的getter方法
	 */
	public String getIscareClaim() {
		return iscareClaim;
	}
	/**
	 * 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息的setter方法
	 */
	public void setIscareClaim(String iscareClaim) {
		this.iscareClaim = iscareClaim;
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
	 * 属性证件有效期限/证件有效期限的getter方法
	 */
	public String getValidPeriod3() {
		return validPeriod3;
	}
	/**
	 * 属性证件有效期限/证件有效期限的setter方法
	 */
	public void setValidPeriod3(String validPeriod3) {
		this.validPeriod3 = validPeriod3;
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
	/**
	 * 属性税务登记号码/税务登记号码的getter方法
	 */
	public String getRevenueRegistNo() {
		return revenueRegistNo;
	}
	/**
	 * 属性税务登记号码/税务登记号码的setter方法
	 */
	public void setRevenueRegistNo(String revenueRegistNo) {
		this.revenueRegistNo = revenueRegistNo;
	}	
	/**
	 * 属性营业执照到期日/营业执照到期日的getter方法
	 */
	public java.util.Date getBusinessValidPeriod() {
		return businessValidPeriod;
	}
	/**
	 * 属性营业执照到期日/营业执照到期日的setter方法
	 */
	public void setBusinessValidPeriod(java.util.Date businessValidPeriod) {
		this.businessValidPeriod = businessValidPeriod;
	}	
	/**
	 * 属性税务登记有效期/税务登记有效期的getter方法
	 */
	public String getRevenueregistValidPeriod() {
		return revenueregistValidPeriod;
	}
	/**
	 * 属性税务登记有效期/税务登记有效期的setter方法
	 */
	public void setRevenueregistValidPeriod(String revenueregistValidPeriod) {
		this.revenueregistValidPeriod = revenueregistValidPeriod;
	}	
	/**
	 * 属性其他证件号码/其他证件号码的getter方法
	 */
	public String getOtherCodeNo() {
		return otherCodeNo;
	}
	/**
	 * 属性其他证件号码/其他证件号码的setter方法
	 */
	public void setOtherCodeNo(String otherCodeNo) {
		this.otherCodeNo = otherCodeNo;
	}	
	/**
	 * 属性其他证件有效期/其他证件有效期的getter方法
	 */
	public String getOtherCodeValidPeriod() {
		return otherCodeValidPeriod;
	}
	/**
	 * 属性其他证件有效期/其他证件有效期的setter方法
	 */
	public void setOtherCodeValidPeriod(String otherCodeValidPeriod) {
		this.otherCodeValidPeriod = otherCodeValidPeriod;
	}	
	/**
	 * 属性sex/sex的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性sex/sex的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}	
	/**
	 * 属性微信号/微信号的getter方法
	 */
	public String getWechatNo() {
		return wechatNo;
	}
	/**
	 * 属性微信号/微信号的setter方法
	 */
	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}	
	/**
	 * 属性VIP标识/VIP标识的getter方法
	 */
	public String getVipFlag() {
		return vipFlag;
	}
	/**
	 * 属性VIP标识/VIP标识的setter方法
	 */
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}	
	/**
	 * 属性证件名称/证件名称的getter方法
	 */
	public String getCertificatEName() {
		return certificatEName;
	}
	/**
	 * 属性证件名称/证件名称的setter方法
	 */
	public void setCertificatEName(String certificatEName) {
		this.certificatEName = certificatEName;
	}	
	/**
	 * 属性国籍1/国籍1的getter方法
	 */
	public String getCustomerKind() {
		return customerKind;
	}
	/**
	 * 属性国籍1/国籍1的setter方法
	 */
	public void setCustomerKind(String customerKind) {
		this.customerKind = customerKind;
	}	
	/**
	 * 属性被保险人分类/被保险人分类的getter方法
	 */
	public String getInsuredSort() {
		return insuredSort;
	}
	/**
	 * 属性被保险人分类/被保险人分类的setter方法
	 */
	public void setInsuredSort(String insuredSort) {
		this.insuredSort = insuredSort;
	}	
	/**
	 * 属性营业执照有效起始日期/营业执照有效起始日期的getter方法
	 */
	public java.util.Date getLicenseStartDate() {
		return licenseStartDate;
	}
	/**
	 * 属性营业执照有效起始日期/营业执照有效起始日期的setter方法
	 */
	public void setLicenseStartDate(java.util.Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}	
	/**
	 * 属性境内外标识/境内外标识的getter方法
	 */
	public String getNationFlag() {
		return nationFlag;
	}
	/**
	 * 属性境内外标识/境内外标识的setter方法
	 */
	public void setNationFlag(String nationFlag) {
		this.nationFlag = nationFlag;
	}	
	/**
	 * 属性受益人分类/受益人分类的getter方法
	 */
	public String getBenefitType() {
		return benefitType;
	}
	/**
	 * 属性受益人分类/受益人分类的setter方法
	 */
	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}	
	/**
	 * 属性age/age的getter方法
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 属性age/age的setter方法
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 属性客户编码/客户编码的getter方法
	 */
	public String getCustomerseQuenceNo() {
		return customerseQuenceNo;
	}
	/**
	 * 属性客户编码/客户编码的setter方法
	 */
	public void setCustomerseQuenceNo(String customerseQuenceNo) {
		this.customerseQuenceNo = customerseQuenceNo;
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

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getInsuredIdentity1() {
		return insuredIdentity1;
	}

	public void setInsuredIdentity1(String insuredIdentity1) {
		this.insuredIdentity1 = insuredIdentity1;
	}

	public String getSexuality() {
		return sexuality;
	}

	public void setSexuality(String sexuality) {
		this.sexuality = sexuality;
	}

	public String getLicenseenddate() {
		return licenseenddate;
	}

	public void setLicenseenddate(String licenseenddate) {
		this.licenseenddate = licenseenddate;
	}
}
