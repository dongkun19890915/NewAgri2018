package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 中介机构代码表Api操作对象
 */
public class PrpDagentDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代理人代码/代理人代码 */
	private String agentCode ;		
	/** 属性代理人名称/代理人名称 */
	private String agentName ;		
	/** 属性代理人地址/代理人地址 */
	private String addressName ;		
	/** 属性邮政编码/邮政编码 */
	private String postCode ;		
	/** 属性代理人类型 兼业/专业/个人代理/代理人类型 兼业/专业/个人代理 */
	private String agentType ;		
	/** 属性个人代理:资格证书编号/机构代理经纪公司:经营许可证编号/个人代理:资格证书编号/机构代理经纪公司:经营许可证编号 */
	private String permitNo ;		
	/** 属性联系人/联系人 */
	private String linkerName ;		
	/** 属性合同期/合同期 */
	private java.util.Date bargainDate ;		
	/** 属性电话/电话 */
	private String phoneNumber ;		
	/** 属性传真/传真 */
	private String faxNumber ;		
	/** 属性归属机构代码/归属机构代码 */
	private String comCode ;		
	/** 属性归属业务员/归属业务员 */
	private String handlerCode ;		
	/** 属性上级代理人代码/上级代理人代码 */
	private String upperAgentCode ;		
	/** 属性新的代理人代码/新的代理人代码 */
	private String newAgentCode ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	private String articleCode ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性agenteName/agenteName */
	private String agentEName ;		
	/** 属性permitFlag/permitFlag */
	private String permitFlag ;		
	/** 属性principalName/principalName */
	private String principalName ;		
	/** 属性mobile/mobile */
	private String mobile ;		
	/** 属性email/email */
	private String email ;		
	/** 属性netAddress/netAddress */
	private String netAddress ;		
	/** 属性bank/bank */
	private String bank ;		
	/** 属性account/account */
	private String account ;		
	/** 属性lowerViewFlag/lowerViewFlag */
	private String lowerViewFlag ;		
	/** 属性agentShortName/agentShortName */
	private String agentShortName ;		
	/** 属性createrCode/createrCode */
	private String createrCode ;		
	/** 属性createTime/createTime */
	private String createTime ;		
	/** 属性updaterCode/updaterCode */
	private String updaterCode ;		
	/** 属性updateDate/updateDate */
	private String updateDate ;		
	/** 属性1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他/1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他 */
	private String agentKindCode ;		
	/** 属性代理机构或人员的资格证号码/代理机构或人员的资格证号码 */
	private String credentials ;		
	/** 属性prpdagent.permitno起始时间/prpdagent.permitno起始时间 */
	private java.util.Date creStartDate ;		
	/** 属性prpdagent.permitno终止时间/prpdagent.permitno终止时间 */
	private java.util.Date creEndDate ;		
	/** 属性acqStartDate/acqStartDate */
	private java.util.Date acqStartDate ;		
	/** 属性acqEndDate/acqEndDate */
	private java.util.Date acqEndDate ;		
	/** 属性acqNo/acqNo */
	private String acqNo ;		
	/** 属性银行开户省/银行开户省 */
	private String province ;		
	/** 属性银行开户市/银行开户市 */
	private String city ;		
	/** 属性银行代码/银行代码 */
	private String bankCode ;		
	/** 属性账号属性 1-个人账号 2-单位账号/账号属性 1-个人账号 2-单位账号 */
	private String accountType ;		
	/** 属性收款人/收款人 */
	private String payee ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性账号类型 00银行卡 01存折 02信用卡 03对公账户/账号类型 00银行卡 01存折 02信用卡 03对公账户 */
	private String accountFlag ;		
	/** 属性支付行号/支付行号 */
	private String routeNum ;		
	/** 属性是否允许归属机构的下级机构使用/是否允许归属机构的下级机构使用 */
	private String agentNature ;		
	/** 属性通路/通路 */
	private String channelType ;		
	/** 属性登录日期/登录日期 */
	private java.util.Date loginDate ;		
	/** 属性登录到期日/登录到期日 */
	private java.util.Date loginEndDate ;		
	/** 属性停止招揽期间始期/停止招揽期间始期 */
	private java.util.Date startJoinDate ;		
	/** 属性停止招揽終止期/停止招揽終止期 */
	private java.util.Date endJoinDate ;		
	/** 属性登录代码(1,产险2,产险+健康险3,车险)/登录代码(1,产险2,产险+健康险3,车险) */
	private String loginCode ;		
	/** 属性是否限制出单(1,是 0,否)/是否限制出单(1,是 0,否) */
	private String distanceFlag ;		
	/** 属性代理人、经纪人終止日期/代理人、经纪人終止日期 */
	private java.util.Date validEndDate ;		
	/** 属性单位代码/单位代码 */
	private String unitCode ;		
	/** 属性单位名称/单位名称 */
	private String unitName ;		
	/** 属性用户代码/用户代码 */
	private String userCode ;		
	/** 属性开户行/开户行 */
	private String bankAccount ;		
	/** 属性开户名称/开户名称 */
	private String accountName ;		
	/** 属性开户账号/开户账号 */
	private String accountNo ;		
	/** 属性效力状态/效力状态 */
	private String clockStatus ;		
	/** 属性销售人员电话/销售人员电话 */
	private String salePersonPhone ;		
	/** 属性销售人员姓名/销售人员姓名 */
	private String salePersonName ;		
	/** 属性中介机构销售人员执业证号/中介机构销售人员执业证号 */
	private String salePersonId ;		
	/** 属性归属代理人展业证号/归属代理人展业证号 */
	private String salePersonPermitNo ;		
	/** 属性客户服务专员/客户服务专员 */
	private String handler1Code ;		
	/** 属性总对总协议标识/总对总协议标识 */
	private String agreementFlag ;		
	/** 属性identifyNumber/identifyNumber */
	private String identifyNumber ;		
	/** 属性残疾人标志/残疾人标志 */
	private String disabler ;		
	/** 属性减免税起期/减免税起期 */
	private String dutyFreeStartTime ;		
	/** 属性减免税止期/减免税止期 */
	private String dutyFreeEndTime ;		
	/** 属性代理初次录入时间/代理初次录入时间 */
	private java.util.Date enteringDate ;		
	/** 属性businessType/businessType */
	private String businessType ;		
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
	 * 属性代理人名称/代理人名称的getter方法
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * 属性代理人名称/代理人名称的setter方法
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}	
	/**
	 * 属性代理人地址/代理人地址的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性代理人地址/代理人地址的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性代理人类型 兼业/专业/个人代理/代理人类型 兼业/专业/个人代理的getter方法
	 */
	public String getAgentType() {
		return agentType;
	}
	/**
	 * 属性代理人类型 兼业/专业/个人代理/代理人类型 兼业/专业/个人代理的setter方法
	 */
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}	
	/**
	 * 属性个人代理:资格证书编号/机构代理经纪公司:经营许可证编号/个人代理:资格证书编号/机构代理经纪公司:经营许可证编号的getter方法
	 */
	public String getPermitNo() {
		return permitNo;
	}
	/**
	 * 属性个人代理:资格证书编号/机构代理经纪公司:经营许可证编号/个人代理:资格证书编号/机构代理经纪公司:经营许可证编号的setter方法
	 */
	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
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
	 * 属性合同期/合同期的getter方法
	 */
	public java.util.Date getBargainDate() {
		return bargainDate;
	}
	/**
	 * 属性合同期/合同期的setter方法
	 */
	public void setBargainDate(java.util.Date bargainDate) {
		this.bargainDate = bargainDate;
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
	 * 属性归属业务员/归属业务员的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性归属业务员/归属业务员的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性上级代理人代码/上级代理人代码的getter方法
	 */
	public String getUpperAgentCode() {
		return upperAgentCode;
	}
	/**
	 * 属性上级代理人代码/上级代理人代码的setter方法
	 */
	public void setUpperAgentCode(String upperAgentCode) {
		this.upperAgentCode = upperAgentCode;
	}	
	/**
	 * 属性新的代理人代码/新的代理人代码的getter方法
	 */
	public String getNewAgentCode() {
		return newAgentCode;
	}
	/**
	 * 属性新的代理人代码/新的代理人代码的setter方法
	 */
	public void setNewAgentCode(String newAgentCode) {
		this.newAgentCode = newAgentCode;
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
	 * 属性agenteName/agenteName的getter方法
	 */
	public String getAgentEName() {
		return agentEName;
	}
	/**
	 * 属性agenteName/agenteName的setter方法
	 */
	public void setAgentEName(String agentEName) {
		this.agentEName = agentEName;
	}	
	/**
	 * 属性permitFlag/permitFlag的getter方法
	 */
	public String getPermitFlag() {
		return permitFlag;
	}
	/**
	 * 属性permitFlag/permitFlag的setter方法
	 */
	public void setPermitFlag(String permitFlag) {
		this.permitFlag = permitFlag;
	}	
	/**
	 * 属性principalName/principalName的getter方法
	 */
	public String getPrincipalName() {
		return principalName;
	}
	/**
	 * 属性principalName/principalName的setter方法
	 */
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
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
	 * 属性netAddress/netAddress的getter方法
	 */
	public String getNetAddress() {
		return netAddress;
	}
	/**
	 * 属性netAddress/netAddress的setter方法
	 */
	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
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
	 * 属性lowerViewFlag/lowerViewFlag的getter方法
	 */
	public String getLowerViewFlag() {
		return lowerViewFlag;
	}
	/**
	 * 属性lowerViewFlag/lowerViewFlag的setter方法
	 */
	public void setLowerViewFlag(String lowerViewFlag) {
		this.lowerViewFlag = lowerViewFlag;
	}	
	/**
	 * 属性agentShortName/agentShortName的getter方法
	 */
	public String getAgentShortName() {
		return agentShortName;
	}
	/**
	 * 属性agentShortName/agentShortName的setter方法
	 */
	public void setAgentShortName(String agentShortName) {
		this.agentShortName = agentShortName;
	}	
	/**
	 * 属性createrCode/createrCode的getter方法
	 */
	public String getCreaterCode() {
		return createrCode;
	}
	/**
	 * 属性createrCode/createrCode的setter方法
	 */
	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}	
	/**
	 * 属性createTime/createTime的getter方法
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 属性createTime/createTime的setter方法
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}	
	/**
	 * 属性updaterCode/updaterCode的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性updaterCode/updaterCode的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}	
	/**
	 * 属性updateDate/updateDate的getter方法
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他/1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他的getter方法
	 */
	public String getAgentKindCode() {
		return agentKindCode;
	}
	/**
	 * 属性1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他/1-银行,2-邮政,3-铁路,4-航空,5-车商,6-保险公司,7-其他的setter方法
	 */
	public void setAgentKindCode(String agentKindCode) {
		this.agentKindCode = agentKindCode;
	}	
	/**
	 * 属性代理机构或人员的资格证号码/代理机构或人员的资格证号码的getter方法
	 */
	public String getCredentials() {
		return credentials;
	}
	/**
	 * 属性代理机构或人员的资格证号码/代理机构或人员的资格证号码的setter方法
	 */
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}	
	/**
	 * 属性prpdagent.permitno起始时间/prpdagent.permitno起始时间的getter方法
	 */
	public java.util.Date getCreStartDate() {
		return creStartDate;
	}
	/**
	 * 属性prpdagent.permitno起始时间/prpdagent.permitno起始时间的setter方法
	 */
	public void setCreStartDate(java.util.Date creStartDate) {
		this.creStartDate = creStartDate;
	}	
	/**
	 * 属性prpdagent.permitno终止时间/prpdagent.permitno终止时间的getter方法
	 */
	public java.util.Date getCreEndDate() {
		return creEndDate;
	}
	/**
	 * 属性prpdagent.permitno终止时间/prpdagent.permitno终止时间的setter方法
	 */
	public void setCreEndDate(java.util.Date creEndDate) {
		this.creEndDate = creEndDate;
	}	
	/**
	 * 属性acqStartDate/acqStartDate的getter方法
	 */
	public java.util.Date getAcqStartDate() {
		return acqStartDate;
	}
	/**
	 * 属性acqStartDate/acqStartDate的setter方法
	 */
	public void setAcqStartDate(java.util.Date acqStartDate) {
		this.acqStartDate = acqStartDate;
	}	
	/**
	 * 属性acqEndDate/acqEndDate的getter方法
	 */
	public java.util.Date getAcqEndDate() {
		return acqEndDate;
	}
	/**
	 * 属性acqEndDate/acqEndDate的setter方法
	 */
	public void setAcqEndDate(java.util.Date acqEndDate) {
		this.acqEndDate = acqEndDate;
	}	
	/**
	 * 属性acqNo/acqNo的getter方法
	 */
	public String getAcqNo() {
		return acqNo;
	}
	/**
	 * 属性acqNo/acqNo的setter方法
	 */
	public void setAcqNo(String acqNo) {
		this.acqNo = acqNo;
	}	
	/**
	 * 属性银行开户省/银行开户省的getter方法
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 属性银行开户省/银行开户省的setter方法
	 */
	public void setProvince(String province) {
		this.province = province;
	}	
	/**
	 * 属性银行开户市/银行开户市的getter方法
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 属性银行开户市/银行开户市的setter方法
	 */
	public void setCity(String city) {
		this.city = city;
	}	
	/**
	 * 属性银行代码/银行代码的getter方法
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * 属性银行代码/银行代码的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}	
	/**
	 * 属性账号属性 1-个人账号 2-单位账号/账号属性 1-个人账号 2-单位账号的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性账号属性 1-个人账号 2-单位账号/账号属性 1-个人账号 2-单位账号的setter方法
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
	/**
	 * 属性收款人/收款人的getter方法
	 */
	public String getPayee() {
		return payee;
	}
	/**
	 * 属性收款人/收款人的setter方法
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性账号类型 00银行卡 01存折 02信用卡 03对公账户/账号类型 00银行卡 01存折 02信用卡 03对公账户的getter方法
	 */
	public String getAccountFlag() {
		return accountFlag;
	}
	/**
	 * 属性账号类型 00银行卡 01存折 02信用卡 03对公账户/账号类型 00银行卡 01存折 02信用卡 03对公账户的setter方法
	 */
	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}	
	/**
	 * 属性支付行号/支付行号的getter方法
	 */
	public String getRouteNum() {
		return routeNum;
	}
	/**
	 * 属性支付行号/支付行号的setter方法
	 */
	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}	
	/**
	 * 属性是否允许归属机构的下级机构使用/是否允许归属机构的下级机构使用的getter方法
	 */
	public String getAgentNature() {
		return agentNature;
	}
	/**
	 * 属性是否允许归属机构的下级机构使用/是否允许归属机构的下级机构使用的setter方法
	 */
	public void setAgentNature(String agentNature) {
		this.agentNature = agentNature;
	}	
	/**
	 * 属性通路/通路的getter方法
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * 属性通路/通路的setter方法
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}	
	/**
	 * 属性登录日期/登录日期的getter方法
	 */
	public java.util.Date getLoginDate() {
		return loginDate;
	}
	/**
	 * 属性登录日期/登录日期的setter方法
	 */
	public void setLoginDate(java.util.Date loginDate) {
		this.loginDate = loginDate;
	}	
	/**
	 * 属性登录到期日/登录到期日的getter方法
	 */
	public java.util.Date getLoginEndDate() {
		return loginEndDate;
	}
	/**
	 * 属性登录到期日/登录到期日的setter方法
	 */
	public void setLoginEndDate(java.util.Date loginEndDate) {
		this.loginEndDate = loginEndDate;
	}	
	/**
	 * 属性停止招揽期间始期/停止招揽期间始期的getter方法
	 */
	public java.util.Date getStartJoinDate() {
		return startJoinDate;
	}
	/**
	 * 属性停止招揽期间始期/停止招揽期间始期的setter方法
	 */
	public void setStartJoinDate(java.util.Date startJoinDate) {
		this.startJoinDate = startJoinDate;
	}	
	/**
	 * 属性停止招揽終止期/停止招揽終止期的getter方法
	 */
	public java.util.Date getEndJoinDate() {
		return endJoinDate;
	}
	/**
	 * 属性停止招揽終止期/停止招揽終止期的setter方法
	 */
	public void setEndJoinDate(java.util.Date endJoinDate) {
		this.endJoinDate = endJoinDate;
	}	
	/**
	 * 属性登录代码(1,产险2,产险+健康险3,车险)/登录代码(1,产险2,产险+健康险3,车险)的getter方法
	 */
	public String getLoginCode() {
		return loginCode;
	}
	/**
	 * 属性登录代码(1,产险2,产险+健康险3,车险)/登录代码(1,产险2,产险+健康险3,车险)的setter方法
	 */
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}	
	/**
	 * 属性是否限制出单(1,是 0,否)/是否限制出单(1,是 0,否)的getter方法
	 */
	public String getDistanceFlag() {
		return distanceFlag;
	}
	/**
	 * 属性是否限制出单(1,是 0,否)/是否限制出单(1,是 0,否)的setter方法
	 */
	public void setDistanceFlag(String distanceFlag) {
		this.distanceFlag = distanceFlag;
	}	
	/**
	 * 属性代理人、经纪人終止日期/代理人、经纪人終止日期的getter方法
	 */
	public java.util.Date getValidEndDate() {
		return validEndDate;
	}
	/**
	 * 属性代理人、经纪人終止日期/代理人、经纪人終止日期的setter方法
	 */
	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	}	
	/**
	 * 属性单位代码/单位代码的getter方法
	 */
	public String getUnitCode() {
		return unitCode;
	}
	/**
	 * 属性单位代码/单位代码的setter方法
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}	
	/**
	 * 属性单位名称/单位名称的getter方法
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * 属性单位名称/单位名称的setter方法
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}	
	/**
	 * 属性用户代码/用户代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性用户代码/用户代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性开户行/开户行的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性开户行/开户行的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}	
	/**
	 * 属性开户名称/开户名称的getter方法
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 属性开户名称/开户名称的setter方法
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	
	/**
	 * 属性开户账号/开户账号的getter方法
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 属性开户账号/开户账号的setter方法
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}	
	/**
	 * 属性效力状态/效力状态的getter方法
	 */
	public String getClockStatus() {
		return clockStatus;
	}
	/**
	 * 属性效力状态/效力状态的setter方法
	 */
	public void setClockStatus(String clockStatus) {
		this.clockStatus = clockStatus;
	}	
	/**
	 * 属性销售人员电话/销售人员电话的getter方法
	 */
	public String getSalePersonPhone() {
		return salePersonPhone;
	}
	/**
	 * 属性销售人员电话/销售人员电话的setter方法
	 */
	public void setSalePersonPhone(String salePersonPhone) {
		this.salePersonPhone = salePersonPhone;
	}	
	/**
	 * 属性销售人员姓名/销售人员姓名的getter方法
	 */
	public String getSalePersonName() {
		return salePersonName;
	}
	/**
	 * 属性销售人员姓名/销售人员姓名的setter方法
	 */
	public void setSalePersonName(String salePersonName) {
		this.salePersonName = salePersonName;
	}	
	/**
	 * 属性中介机构销售人员执业证号/中介机构销售人员执业证号的getter方法
	 */
	public String getSalePersonId() {
		return salePersonId;
	}
	/**
	 * 属性中介机构销售人员执业证号/中介机构销售人员执业证号的setter方法
	 */
	public void setSalePersonId(String salePersonId) {
		this.salePersonId = salePersonId;
	}	
	/**
	 * 属性归属代理人展业证号/归属代理人展业证号的getter方法
	 */
	public String getSalePersonPermitNo() {
		return salePersonPermitNo;
	}
	/**
	 * 属性归属代理人展业证号/归属代理人展业证号的setter方法
	 */
	public void setSalePersonPermitNo(String salePersonPermitNo) {
		this.salePersonPermitNo = salePersonPermitNo;
	}	
	/**
	 * 属性客户服务专员/客户服务专员的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性客户服务专员/客户服务专员的setter方法
	 */
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}	
	/**
	 * 属性总对总协议标识/总对总协议标识的getter方法
	 */
	public String getAgreementFlag() {
		return agreementFlag;
	}
	/**
	 * 属性总对总协议标识/总对总协议标识的setter方法
	 */
	public void setAgreementFlag(String agreementFlag) {
		this.agreementFlag = agreementFlag;
	}	
	/**
	 * 属性identifyNumber/identifyNumber的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性identifyNumber/identifyNumber的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}	
	/**
	 * 属性残疾人标志/残疾人标志的getter方法
	 */
	public String getDisabler() {
		return disabler;
	}
	/**
	 * 属性残疾人标志/残疾人标志的setter方法
	 */
	public void setDisabler(String disabler) {
		this.disabler = disabler;
	}	
	/**
	 * 属性减免税起期/减免税起期的getter方法
	 */
	public String getDutyFreeStartTime() {
		return dutyFreeStartTime;
	}
	/**
	 * 属性减免税起期/减免税起期的setter方法
	 */
	public void setDutyFreeStartTime(String dutyFreeStartTime) {
		this.dutyFreeStartTime = dutyFreeStartTime;
	}	
	/**
	 * 属性减免税止期/减免税止期的getter方法
	 */
	public String getDutyFreeEndTime() {
		return dutyFreeEndTime;
	}
	/**
	 * 属性减免税止期/减免税止期的setter方法
	 */
	public void setDutyFreeEndTime(String dutyFreeEndTime) {
		this.dutyFreeEndTime = dutyFreeEndTime;
	}	
	/**
	 * 属性代理初次录入时间/代理初次录入时间的getter方法
	 */
	public java.util.Date getEnteringDate() {
		return enteringDate;
	}
	/**
	 * 属性代理初次录入时间/代理初次录入时间的setter方法
	 */
	public void setEnteringDate(java.util.Date enteringDate) {
		this.enteringDate = enteringDate;
	}	
	/**
	 * 属性businessType/businessType的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性businessType/businessType的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
}
