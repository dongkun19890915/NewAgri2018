package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 个人客户代码表Api操作对象
 */
public class PrpDcustomerIdvDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码  */
	private String customerCode ;		
	/** 属性客户密码/客户密码 */
	private String password ;		
	/** 属性速查索引码/速查索引码 */
	private String shorthandCode ;		
	/** 属性客户中文名称/客户中文名称 */
	private String customerCName ;		
	/** 属性客户英文名称/客户英文名称 */
	private String customerEName ;		
	/** 属性地址中文名称/地址中文名称 */
	private String addressCName ;		
	/** 属性地址英文名称/地址英文名称 */
	private String addressEName ;		
	/** 属性证件类型/证件类型 */
	private String identifyType ;		
	/** 属性证件号码 (U)/证件号码 (U) */
	private String identifyNumber ;		
	/** 属性资信等级 (I)  A/B/C/D/资信等级 (I)  A/B/C/D */
	private String creditLevel ;		
	/** 属性性别 /性别  */
	private String sex ;		
	/** 属性年龄/年龄 */
	private Integer age ;
	/** 属性健康状况/健康状况 */
	private String health ;		
	/** 属性职业代码/职业代码 */
	private String occupationCode ;		
	/** 属性学历代码/学历代码 */
	private String educationCode ;		
	/** 属性工作单位/工作单位 */
	private String unit ;		
	/** 属性单位地址/单位地址 */
	private String unitAddress ;		
	/** 属性客户类型/客户类型 */
	private String customerKind ;		
	/** 属性客户标志(0:临时/1:正式)/客户标志(0:临时/1:正式) */
	private String customerFlag ;		
	/** 属性电话/电话 */
	private String phoneNumber ;		
	/** 属性传真/传真 */
	private String faxNumber ;		
	/** 属性手机/手机 */
	private String mobile ;		
	/** 属性通信地址/通信地址 */
	private String linkAddress ;		
	/** 属性邮编/邮编 */
	private String postCode ;		
	/** 属性呼机/呼机 */
	private String pager ;		
	/** 属性E_mail信箱/E_mail信箱 */
	private String email ;		
	/** 属性开户银行/开户银行 */
	private String bank ;		
	/** 属性帐号/帐号 */
	private String account ;		
	/** 属性死亡时间/死亡时间 */
	private Date deathDate ;
	/** 属性黑名单标志[1]:0:正常 1：黑名单/黑名单标志[1]:0:正常 1：黑名单 */
	private String blackState ;		
	/** 属性新的客户代码/新的客户代码 */
	private String newCustomerCode ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	private String articleCode ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性网址/网址 */
	private String netAddress ;		
	/** 属性下级机构是否允许查看 1/是 0/否/下级机构是否允许查看 1/是 0/否 */
	private String lowerViewFlag ;		
	/** 属性归属业务员代码/归属业务员代码 */
	private String handlerCode ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性输入日期/输入日期 */
	private Date inputDate ;
	/** 属性最后一次修改人/最后一次修改人 */
	private String updaterCode ;		
	/** 属性修改日期/修改日期 */
	private Date updateDate ;
	/** 属性归属机构代码/归属机构代码 */
	private String comCode ;		
	/** 属性toplevelFlag/toplevelFlag */
	private String topLevelFlag ;		
	/** 属性出生日期/出生日期 */
	private Date birthDate ;
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
	/** 属性vip标识/vip标识 */
	private String vipFlag ;		
	/** 属性属性证型有效起期/属性证型有效起期 */
	private Date certificadeStartDate ;
	/** 属性属性微信号/属性微信号 */
	private String wechatNo ;		
	/** 属性属性证件有效止期/属性证件有效止期 */
	private Date certificadeEndDate ;
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private Date update_Date ;
	/**
	 * 属性客户代码/客户代码的getter方法
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * 属性客户代码/客户代码的setter方法
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}	
	/**
	 * 属性客户密码/客户密码的getter方法
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 属性客户密码/客户密码的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
	/**
	 * 属性速查索引码/速查索引码的getter方法
	 */
	public String getShorthandCode() {
		return shorthandCode;
	}
	/**
	 * 属性速查索引码/速查索引码的setter方法
	 */
	public void setShorthandCode(String shorthandCode) {
		this.shorthandCode = shorthandCode;
	}	
	/**
	 * 属性客户中文名称/客户中文名称的getter方法
	 */
	public String getCustomerCName() {
		return customerCName;
	}
	/**
	 * 属性客户中文名称/客户中文名称的setter方法
	 */
	public void setCustomerCName(String customerCName) {
		this.customerCName = customerCName;
	}	
	/**
	 * 属性客户英文名称/客户英文名称的getter方法
	 */
	public String getCustomerEName() {
		return customerEName;
	}
	/**
	 * 属性客户英文名称/客户英文名称的setter方法
	 */
	public void setCustomerEName(String customerEName) {
		this.customerEName = customerEName;
	}	
	/**
	 * 属性地址中文名称/地址中文名称的getter方法
	 */
	public String getAddressCName() {
		return addressCName;
	}
	/**
	 * 属性地址中文名称/地址中文名称的setter方法
	 */
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}	
	/**
	 * 属性地址英文名称/地址英文名称的getter方法
	 */
	public String getAddressEName() {
		return addressEName;
	}
	/**
	 * 属性地址英文名称/地址英文名称的setter方法
	 */
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
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
	 * 属性证件号码 (U)/证件号码 (U)的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性证件号码 (U)/证件号码 (U)的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性资信等级 (I)  A/B/C/D/资信等级 (I)  A/B/C/D的getter方法
	 */
	public String getCreditLevel() {
		return creditLevel;
	}
	/**
	 * 属性资信等级 (I)  A/B/C/D/资信等级 (I)  A/B/C/D的setter方法
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}	
	/**
	 * 属性性别 /性别 的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别 /性别 的setter方法
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
	 * 属性健康状况/健康状况的getter方法
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * 属性健康状况/健康状况的setter方法
	 */
	public void setHealth(String health) {
		this.health = health;
	}	
	/**
	 * 属性职业代码/职业代码的getter方法
	 */
	public String getOccupationCode() {
		return occupationCode;
	}
	/**
	 * 属性职业代码/职业代码的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}	
	/**
	 * 属性学历代码/学历代码的getter方法
	 */
	public String getEducationCode() {
		return educationCode;
	}
	/**
	 * 属性学历代码/学历代码的setter方法
	 */
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}	
	/**
	 * 属性工作单位/工作单位的getter方法
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 属性工作单位/工作单位的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * 属性客户类型/客户类型的getter方法
	 */
	public String getCustomerKind() {
		return customerKind;
	}
	/**
	 * 属性客户类型/客户类型的setter方法
	 */
	public void setCustomerKind(String customerKind) {
		this.customerKind = customerKind;
	}	
	/**
	 * 属性客户标志(0:临时/1:正式)/客户标志(0:临时/1:正式)的getter方法
	 */
	public String getCustomerFlag() {
		return customerFlag;
	}
	/**
	 * 属性客户标志(0:临时/1:正式)/客户标志(0:临时/1:正式)的setter方法
	 */
	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}	
	/**
	 * 属性电话/电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性电话/电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	/**
	 * 属性传真/传真的getter方法
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * 属性传真/传真的setter方法
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}	
	/**
	 * 属性手机/手机的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性手机/手机的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
	/**
	 * 属性通信地址/通信地址的getter方法
	 */
	public String getLinkAddress() {
		return linkAddress;
	}
	/**
	 * 属性通信地址/通信地址的setter方法
	 */
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}	
	/**
	 * 属性邮编/邮编的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮编/邮编的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性呼机/呼机的getter方法
	 */
	public String getPager() {
		return pager;
	}
	/**
	 * 属性呼机/呼机的setter方法
	 */
	public void setPager(String pager) {
		this.pager = pager;
	}	
	/**
	 * 属性E_mail信箱/E_mail信箱的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性E_mail信箱/E_mail信箱的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * 属性帐号/帐号的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性帐号/帐号的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	}	
	/**
	 * 属性死亡时间/死亡时间的getter方法
	 */
	public Date getDeathDate() {
		return deathDate;
	}
	/**
	 * 属性死亡时间/死亡时间的setter方法
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}	
	/**
	 * 属性黑名单标志[1]:0:正常 1：黑名单/黑名单标志[1]:0:正常 1：黑名单的getter方法
	 */
	public String getBlackState() {
		return blackState;
	}
	/**
	 * 属性黑名单标志[1]:0:正常 1：黑名单/黑名单标志[1]:0:正常 1：黑名单的setter方法
	 */
	public void setBlackState(String blackState) {
		this.blackState = blackState;
	}	
	/**
	 * 属性新的客户代码/新的客户代码的getter方法
	 */
	public String getNewCustomerCode() {
		return newCustomerCode;
	}
	/**
	 * 属性新的客户代码/新的客户代码的setter方法
	 */
	public void setNewCustomerCode(String newCustomerCode) {
		this.newCustomerCode = newCustomerCode;
	}	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的getter方法
	 */
	public String getArticleCode() {
		return articleCode;
	}
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
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
	 * 属性网址/网址的getter方法
	 */
	public String getNetAddress() {
		return netAddress;
	}
	/**
	 * 属性网址/网址的setter方法
	 */
	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}	
	/**
	 * 属性下级机构是否允许查看 1/是 0/否/下级机构是否允许查看 1/是 0/否的getter方法
	 */
	public String getLowerViewFlag() {
		return lowerViewFlag;
	}
	/**
	 * 属性下级机构是否允许查看 1/是 0/否/下级机构是否允许查看 1/是 0/否的setter方法
	 */
	public void setLowerViewFlag(String lowerViewFlag) {
		this.lowerViewFlag = lowerViewFlag;
	}	
	/**
	 * 属性归属业务员代码/归属业务员代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
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
	 * 属性输入日期/输入日期的getter方法
	 */
	public Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性最后一次修改人/最后一次修改人的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最后一次修改人/最后一次修改人的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}	

	/**
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性toplevelFlag/toplevelFlag的getter方法
	 */
	public String getTopLevelFlag() {
		return topLevelFlag;
	}
	/**
	 * 属性toplevelFlag/toplevelFlag的setter方法
	 */
	public void setTopLevelFlag(String topLevelFlag) {
		this.topLevelFlag = topLevelFlag;
	}	
	/**
	 * 属性出生日期/出生日期的getter方法
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * 属性出生日期/出生日期的setter方法
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	public String getIsCareClaim() {
		return isCareClaim;
	}
	/**
	 * 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息的setter方法
	 */
	public void setIsCareClaim(String isCareClaim) {
		this.isCareClaim = isCareClaim;
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
	 * 属性vip标识/vip标识的getter方法
	 */
	public String getVipFlag() {
		return vipFlag;
	}
	/**
	 * 属性vip标识/vip标识的setter方法
	 */
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}	
	/**
	 * 属性属性证型有效起期/属性证型有效起期的getter方法
	 */
	public Date getCertificadeStartDate() {
		return certificadeStartDate;
	}
	/**
	 * 属性属性证型有效起期/属性证型有效起期的setter方法
	 */
	public void setCertificadeStartDate(Date certificadeStartDate) {
		this.certificadeStartDate = certificadeStartDate;
	}	
	/**
	 * 属性属性微信号/属性微信号的getter方法
	 */
	public String getWechatNo() {
		return wechatNo;
	}
	/**
	 * 属性属性微信号/属性微信号的setter方法
	 */
	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}	
	/**
	 * 属性属性证件有效止期/属性证件有效止期的getter方法
	 */
	public Date getCertificadeEndDate() {
		return certificadeEndDate;
	}
	/**
	 * 属性属性证件有效止期/属性证件有效止期的setter方法
	 */
	public void setCertificadeEndDate(Date certificadeEndDate) {
		this.certificadeEndDate = certificadeEndDate;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}	
}
