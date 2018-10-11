package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 集体客户代码表实体操作对象
 */
@Entity
@Table(name = "PrpDcustomerUnit")
@IdClass(PrpDcustomerUnitKey.class)
public class PrpDcustomerUnit extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码 */
	@Id
	@Column(name = "customerCode")
	private String customerCode ;	

	/** 属性客户密码/客户密码 */
	@Column(name = "password")
	private String password ;
	/** 属性速查索引码/速查索引码 */
	@Column(name = "shorthandCode")
	private String shorthandCode ;
	/** 属性客户中文名称/客户中文名称 */
	@Column(name = "customerCName")
	private String customerCName ;
	/** 属性客户英文名称/客户英文名称 */
	@Column(name = "customerEName")
	private String customerEName ;
	/** 属性地址中文名称/地址中文名称 */
	@Column(name = "addressCName")
	private String addressCName ;
	/** 属性地址英文名称/地址英文名称 */
	@Column(name = "addressEName")
	private String addressEName ;
	/** 属性占用性质代码/占用性质代码 */
	@Column(name = "possessNature")
	private String possessNature ;
	/** 属性行业代码/行业代码 */
	@Column(name = "businessSource")
	private String businessSource ;
	/** 属性所有制代码（单位性质）/所有制代码（单位性质） */
	@Column(name = "businessSort")
	private String businessSort ;
	/** 属性客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I)/客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I) */
	@Column(name = "customerKind")
	private String customerKind ;
	/** 属性客户标志(0:临时/1:正式)/客户标志(0:临时/1:正式) */
	@Column(name = "customerFlag")
	private String customerFlag ;
	/** 属性法人组织机构代码/法人组织机构代码 */
	@Column(name = "organizeCode")
	private String organizeCode ;
	/** 属性资信等级 A/B/C/D/资信等级 A/B/C/D */
	@Column(name = "creditLevel")
	private String creditLevel ;
	/** 属性法人代表/法人代表 */
	@Column(name = "leaderName")
	private String leaderName ;
	/** 属性电话/电话 */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性传真/传真 */
	@Column(name = "faxNumber")
	private String faxNumber ;
	/** 属性手机/手机 */
	@Column(name = "mobile")
	private String mobile ;
	/** 属性网址/网址 */
	@Column(name = "netAddress")
	private String netAddress ;
	/** 属性电子信箱/电子信箱 */
	@Column(name = "emailAddress")
	private String emailAddress ;
	/** 属性通信地址/通信地址 */
	@Column(name = "postAddress")
	private String postAddress ;
	/** 属性邮编/邮编 */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性联系人/联系人 */
	@Column(name = "linkerName")
	private String linkerName ;
	/** 属性开户银行/开户银行 */
	@Column(name = "bank")
	private String bank ;
	/** 属性开户帐号/开户帐号 */
	@Column(name = "account")
	private String account ;
	/** 属性工商局码/工商局码 */
	@Column(name = "industryCode")
	private String industryCode ;
	/** 属性经贸委码/经贸委码 */
	@Column(name = "economyCode")
	private String economyCode ;
	/** 属性标准计量码/标准计量码 */
	@Column(name = "measureCode")
	private String measureCode ;
	/** 属性上级代码/上级代码 */
	@Column(name = "fatherCode")
	private String fatherCode ;
	/** 属性主管人名称/主管人名称 */
	@Column(name = "sponsorName")
	private String sponsorName ;
	/** 属性经营范围/经营范围 */
	@Column(name = "businessRange")
	private String businessRange ;
	/** 属性注册资金/注册资金 */
	@Column(name = "registFund")
	private java.lang.Double registFund ;
	/** 属性行政区划编码/行政区划编码 */
	@Column(name = "regionCode")
	private String regionCode ;
	/** 属性黑名单标志[1]:0:正常 1：黑名单/黑名单标志[1]:0:正常 1：黑名单 */
	@Column(name = "blackState")
	private String blackState ;
	/** 属性新的客户代码/新的客户代码 */
	@Column(name = "newCustomerCode")
	private String newCustomerCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	@Column(name = "articleCode")
	private String articleCode ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性客户简称/客户简称 */
	@Column(name = "customerShortName")
	private String customerShortName ;
	/** 属性在册员工人数/在册员工人数 */
	@Column(name = "employSum")
	private String employSum ;
	/** 属性是否股东 1/是 0/否/是否股东 1/是 0/否 */
	@Column(name = "shareholderFlag")
	private String shareholderFlag ;
	/** 属性企业税务代码/企业税务代码 */
	@Column(name = "revenueCode")
	private String revenueCode ;
	/** 属性职业风险等级/职业风险等级 */
	@Column(name = "wordRiskRank")
	private String wordRiskRank ;
	/** 属性下级机构是否允许查看 1/是 0/否/下级机构是否允许查看 1/是 0/否 */
	@Column(name = "lowerViewFlag")
	private String lowerViewFlag ;
	/** 属性归属业务员代码/归属业务员代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性输入日期/输入日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性最后一次修改人/最后一次修改人 */
	@Column(name = "updaterCode")
	private String updaterCode ;
	/** 属性修改日期/修改日期 */
	@Column(name = "updateDate")
	private java.util.Date updateDate ;
	/** 属性归属机构代码/归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性toplevelflag/toplevelflag */
	@Column(name = "toplevelFlag")
	private String toplevelFlag ;
	/** 属性careerriskgrade/careerriskgrade */
	@Column(name = "careerRiskGrade")
	private String careerRiskGrade ;
	/** 属性单位证件类型 61/组织机构代码证 62/税务登记证 99/其他/单位证件类型 61/组织机构代码证 62/税务登记证 99/其他 */
	@Column(name = "identifyType")
	private String identifyType ;
	/** 属性风险等级/风险等级 */
	@Column(name = "riskLevel")
	private String riskLevel ;
	/** 属性是否关注理赔审计退保等信息/是否关注理赔审计退保等信息 */
	@Column(name = "isCareClaim")
	private String isCareClaim ;
	/** 属性行业现金密集程度/行业现金密集程度 */
	@Column(name = "cashFocus")
	private String cashFocus ;
	/** 属性证件有效期限/证件有效期限 */
	@Column(name = "identifyValidPeriod")
	private String identifyValidPeriod ;
	/** 属性工商营业执照登记号/工商营业执照登记号 */
	@Column(name = "businessLicenceNo")
	private String businessLicenceNo ;
	/** 属性工商营业执照登记号有效期/工商营业执照登记号有效期 */
	@Column(name = "businessLicenceValidPeriod")
	private java.util.Date businessLicenceValidPeriod ;
	/** 属性其他证件号码/其他证件号码 */
	@Column(name = "otherCodeNo")
	private String otherCodeNo ;
	/** 属性其他证件有效期/其他证件有效期 */
	@Column(name = "otherCodeValidPeriod")
	private String otherCodeValidPeriod ;
	/** 属性公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他/公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他 */
	@Column(name = "comType")
	private String comType ;
	/** 属性税务登记有效期/税务登记有效期 */
	@Column(name = "revenuePeriod")
	private String revenuePeriod ;
	/** 属性1:组织机构代码 2:统一社会信用代码/1:组织机构代码 2:统一社会信用代码 */
	@Column(name = "socialCode")
	private String socialCode ;
	/** 属性属性备注2/属性备注2 */
	@Column(name = "taxIdentifyCode")
	private String taxIdentifyCode ;
	/** 属性vip标识/vip标识 */
	@Column(name = "vipFlag")
	private String vipFlag ;
	/** 属性微信号/微信号 */
	@Column(name = "wechatNo")
	private String wechatNo ;
	/** 属性licenseenddate/licenseenddate */
	@Column(name = "licenseEndDate")
	private java.util.Date licenseEndDate ;
	/** 属性licensestartdate/licensestartdate */
	@Column(name = "licenseStartDate")
	private java.util.Date licenseStartDate ;
	/** 属性busilicense/busilicense */
	@Column(name = "busiLicense")
	private String busiLicense ;
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
	 * 属性所有制代码（单位性质）/所有制代码（单位性质）的getter方法
	 */
	public String getBusinessSort() {
		return businessSort;
	}
	/**
	 * 属性所有制代码（单位性质）/所有制代码（单位性质）的setter方法
	 */
	public void setBusinessSort(String businessSort) {
		this.businessSort = businessSort;
	} 	
	/**
	 * 属性客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I)/客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I)的getter方法
	 */
	public String getCustomerKind() {
		return customerKind;
	}
	/**
	 * 属性客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I)/客户类型[1]: D:代理人/J:经纪人G:工贸/W:外贸[2]: B:银行S:销售商 (I)的setter方法
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
	 * 属性法人组织机构代码/法人组织机构代码的getter方法
	 */
	public String getOrganizeCode() {
		return organizeCode;
	}
	/**
	 * 属性法人组织机构代码/法人组织机构代码的setter方法
	 */
	public void setOrganizeCode(String organizeCode) {
		this.organizeCode = organizeCode;
	} 	
	/**
	 * 属性资信等级 A/B/C/D/资信等级 A/B/C/D的getter方法
	 */
	public String getCreditLevel() {
		return creditLevel;
	}
	/**
	 * 属性资信等级 A/B/C/D/资信等级 A/B/C/D的setter方法
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	} 	
	/**
	 * 属性法人代表/法人代表的getter方法
	 */
	public String getLeaderName() {
		return leaderName;
	}
	/**
	 * 属性法人代表/法人代表的setter方法
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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
	 * 属性电子信箱/电子信箱的getter方法
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * 属性电子信箱/电子信箱的setter方法
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	 * 属性开户帐号/开户帐号的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性开户帐号/开户帐号的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	} 	
	/**
	 * 属性工商局码/工商局码的getter方法
	 */
	public String getIndustryCode() {
		return industryCode;
	}
	/**
	 * 属性工商局码/工商局码的setter方法
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	} 	
	/**
	 * 属性经贸委码/经贸委码的getter方法
	 */
	public String getEconomyCode() {
		return economyCode;
	}
	/**
	 * 属性经贸委码/经贸委码的setter方法
	 */
	public void setEconomyCode(String economyCode) {
		this.economyCode = economyCode;
	} 	
	/**
	 * 属性标准计量码/标准计量码的getter方法
	 */
	public String getMeasureCode() {
		return measureCode;
	}
	/**
	 * 属性标准计量码/标准计量码的setter方法
	 */
	public void setMeasureCode(String measureCode) {
		this.measureCode = measureCode;
	} 	
	/**
	 * 属性上级代码/上级代码的getter方法
	 */
	public String getFatherCode() {
		return fatherCode;
	}
	/**
	 * 属性上级代码/上级代码的setter方法
	 */
	public void setFatherCode(String fatherCode) {
		this.fatherCode = fatherCode;
	} 	
	/**
	 * 属性主管人名称/主管人名称的getter方法
	 */
	public String getSponsorName() {
		return sponsorName;
	}
	/**
	 * 属性主管人名称/主管人名称的setter方法
	 */
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	} 	
	/**
	 * 属性经营范围/经营范围的getter方法
	 */
	public String getBusinessRange() {
		return businessRange;
	}
	/**
	 * 属性经营范围/经营范围的setter方法
	 */
	public void setBusinessRange(String businessRange) {
		this.businessRange = businessRange;
	} 	
	/**
	 * 属性注册资金/注册资金的getter方法
	 */
	public java.lang.Double getRegistFund() {
		return registFund;
	}
	/**
	 * 属性注册资金/注册资金的setter方法
	 */
	public void setRegistFund(java.lang.Double registFund) {
		this.registFund = registFund;
	} 	
	/**
	 * 属性行政区划编码/行政区划编码的getter方法
	 */
	public String getRegionCode() {
		return regionCode;
	}
	/**
	 * 属性行政区划编码/行政区划编码的setter方法
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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
	 * 属性客户简称/客户简称的getter方法
	 */
	public String getCustomerShortName() {
		return customerShortName;
	}
	/**
	 * 属性客户简称/客户简称的setter方法
	 */
	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	} 	
	/**
	 * 属性在册员工人数/在册员工人数的getter方法
	 */
	public String getEmploySum() {
		return employSum;
	}
	/**
	 * 属性在册员工人数/在册员工人数的setter方法
	 */
	public void setEmploySum(String employSum) {
		this.employSum = employSum;
	} 	
	/**
	 * 属性是否股东 1/是 0/否/是否股东 1/是 0/否的getter方法
	 */
	public String getShareholderFlag() {
		return shareholderFlag;
	}
	/**
	 * 属性是否股东 1/是 0/否/是否股东 1/是 0/否的setter方法
	 */
	public void setShareholderFlag(String shareholderFlag) {
		this.shareholderFlag = shareholderFlag;
	} 	
	/**
	 * 属性企业税务代码/企业税务代码的getter方法
	 */
	public String getRevenueCode() {
		return revenueCode;
	}
	/**
	 * 属性企业税务代码/企业税务代码的setter方法
	 */
	public void setRevenueCode(String revenueCode) {
		this.revenueCode = revenueCode;
	} 	
	/**
	 * 属性职业风险等级/职业风险等级的getter方法
	 */
	public String getWordRiskRank() {
		return wordRiskRank;
	}
	/**
	 * 属性职业风险等级/职业风险等级的setter方法
	 */
	public void setWordRiskRank(String wordRiskRank) {
		this.wordRiskRank = wordRiskRank;
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
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
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
	 * 属性修改日期/修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改日期/修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
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
	 * 属性toplevelflag/toplevelflag的getter方法
	 */
	public String getToplevelFlag() {
		return toplevelFlag;
	}
	/**
	 * 属性toplevelflag/toplevelflag的setter方法
	 */
	public void setToplevelFlag(String toplevelFlag) {
		this.toplevelFlag = toplevelFlag;
	} 	
	/**
	 * 属性careerriskgrade/careerriskgrade的getter方法
	 */
	public String getCareerRiskGrade() {
		return careerRiskGrade;
	}
	/**
	 * 属性careerriskgrade/careerriskgrade的setter方法
	 */
	public void setCareerRiskGrade(String careerRiskGrade) {
		this.careerRiskGrade = careerRiskGrade;
	} 	
	/**
	 * 属性单位证件类型 61/组织机构代码证 62/税务登记证 99/其他/单位证件类型 61/组织机构代码证 62/税务登记证 99/其他的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性单位证件类型 61/组织机构代码证 62/税务登记证 99/其他/单位证件类型 61/组织机构代码证 62/税务登记证 99/其他的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
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
	public String getIdentifyValidPeriod() {
		return identifyValidPeriod;
	}
	/**
	 * 属性证件有效期限/证件有效期限的setter方法
	 */
	public void setIdentifyValidPeriod(String identifyValidPeriod) {
		this.identifyValidPeriod = identifyValidPeriod;
	} 	
	/**
	 * 属性工商营业执照登记号/工商营业执照登记号的getter方法
	 */
	public String getBusinessLicenceNo() {
		return businessLicenceNo;
	}
	/**
	 * 属性工商营业执照登记号/工商营业执照登记号的setter方法
	 */
	public void setBusinessLicenceNo(String businessLicenceNo) {
		this.businessLicenceNo = businessLicenceNo;
	} 	
	/**
	 * 属性工商营业执照登记号有效期/工商营业执照登记号有效期的getter方法
	 */
	public java.util.Date getBusinessLicenceValidPeriod() {
		return businessLicenceValidPeriod;
	}
	/**
	 * 属性工商营业执照登记号有效期/工商营业执照登记号有效期的setter方法
	 */
	public void setBusinessLicenceValidPeriod(java.util.Date businessLicenceValidPeriod) {
		this.businessLicenceValidPeriod = businessLicenceValidPeriod;
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
	 * 属性公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他/公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他的getter方法
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * 属性公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他/公司性质 0001机关 0002事业单位 0003社会团体 0004国有企业 0005集体企业 0006三资企业 0007私营企业 9999其他的setter方法
	 */
	public void setComType(String comType) {
		this.comType = comType;
	} 	
	/**
	 * 属性税务登记有效期/税务登记有效期的getter方法
	 */
	public String getRevenuePeriod() {
		return revenuePeriod;
	}
	/**
	 * 属性税务登记有效期/税务登记有效期的setter方法
	 */
	public void setRevenuePeriod(String revenuePeriod) {
		this.revenuePeriod = revenuePeriod;
	} 	
	/**
	 * 属性1:组织机构代码 2:统一社会信用代码/1:组织机构代码 2:统一社会信用代码的getter方法
	 */
	public String getSocialCode() {
		return socialCode;
	}
	/**
	 * 属性1:组织机构代码 2:统一社会信用代码/1:组织机构代码 2:统一社会信用代码的setter方法
	 */
	public void setSocialCode(String socialCode) {
		this.socialCode = socialCode;
	} 	
	/**
	 * 属性属性备注2/属性备注2的getter方法
	 */
	public String getTaxIdentifyCode() {
		return taxIdentifyCode;
	}
	/**
	 * 属性属性备注2/属性备注2的setter方法
	 */
	public void setTaxIdentifyCode(String taxIdentifyCode) {
		this.taxIdentifyCode = taxIdentifyCode;
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
	 * 属性licenseenddate/licenseenddate的getter方法
	 */
	public java.util.Date getLicenseEndDate() {
		return licenseEndDate;
	}
	/**
	 * 属性licenseenddate/licenseenddate的setter方法
	 */
	public void setLicenseEndDate(java.util.Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	} 	
	/**
	 * 属性licensestartdate/licensestartdate的getter方法
	 */
	public java.util.Date getLicenseStartDate() {
		return licenseStartDate;
	}
	/**
	 * 属性licensestartdate/licensestartdate的setter方法
	 */
	public void setLicenseStartDate(java.util.Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	} 	
	/**
	 * 属性busilicense/busilicense的getter方法
	 */
	public String getBusiLicense() {
		return busiLicense;
	}
	/**
	 * 属性busilicense/busilicense的setter方法
	 */
	public void setBusiLicense(String busiLicense) {
		this.busiLicense = busiLicense;
	} 	
}