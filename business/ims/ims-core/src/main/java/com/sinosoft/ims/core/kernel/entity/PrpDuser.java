package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 员工代码表实体操作对象
 */
@Entity
@Table(name = "PrpDuser")
@IdClass(PrpDuserKey.class)
public class PrpDuser extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性员工代码/员工代码 */
	@Id
	@Column(name = "userCode")
	private String userCode ;	

	/** 属性员工名称/员工名称 */
	@Column(name = "userName")
	private String userName ;
	/** 属性userEname/userEname */
	@Column(name = "userEName")
	private String userEName ;
	/** 属性密码/密码 */
	@Column(name = "password")
	private String password ;
	/** 属性印鉴/印鉴 */
	@Column(name = "seal")
	private String seal ;
	/** 属性passwordSetDate/passwordSetDate */
	@Column(name = "passwordSetDate")
	private Date passwordSetDate ;
	/** 属性passwordExpireDate/passwordExpireDate */
	@Column(name = "passwordExpireDate")
	private Date passwordExpireDate ;
	/** 属性归属机构代码/归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性出单机构代码/出单机构代码 */
	@Column(name = "makeCom")
	private String makeCom ;
	/** 属性accountCode/accountCode */
	@Column(name = "accountCode")
	private String accountCode ;
	/** 属性电话号码/电话号码 */
	@Column(name = "phone")
	private String phone ;
	/** 属性手机号码/手机号码 */
	@Column(name = "mobile")
	private String mobile ;
	/** 属性通信地址/通信地址 */
	@Column(name = "address")
	private String address ;
	/** 属性邮政编码/邮政编码 */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性邮箱/邮箱 */
	@Column(name = "email")
	private String email ;
	/** 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员 */
	@Column(name = "userFlag")
	private String userFlag ;
	/** 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统 */
	@Column(name = "loginSystem")
	private String loginSystem ;
	/** 属性最新员工代码/最新员工代码 */
	@Column(name = "newUserCode")
	private String newUserCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	@Column(name = "articleCode")
	private String articleCode ;
	/** 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注) */
	@Column(name = "flag")
	private String flag ;
	/** 属性underwritingAuthority/underwritingAuthority */
	@Column(name = "underwritingAuthority")
	private String underwritingAuthority ;
	/** 属性终端号/终端号 */
	@Column(name = "posTerminalNo")
	private String posTerminalNo ;
	/** 属性salesFlag/salesFlag */
	@Column(name = "salesFlag")
	private String salesFlag ;
	/** 属性clockStatus/clockStatus */
	@Column(name = "clockStatus")
	private String clockStatus ;
	/** 属性isSales/isSales */
	@Column(name = "isSales")
	private String isSales ;
	/** 属性locked/locked */
	@Column(name = "locked")
	private Integer locked ;
	/** 属性maxOverDueCount/maxOverDueCount */
	@Column(name = "maxOverDueCount")
	private Integer maxOverDueCount ;
	/** 属性maxOverDueFee/maxOverDueFee */
	@Column(name = "maxOverDueFee")
	private Double maxOverDueFee ;
	/** 属性userLevel/userLevel */
	@Column(name = "userLevel")
	private String userLevel ;
	/** 属性userNature/userNature */
	@Column(name = "userNature")
	private String userNature ;
	/** 属性userType/userType */
	@Column(name = "userType")
	private String userType ;
	/** 属性属性业务来源/属性业务来源 */
	@Column(name = "businessNature")
	private String businessNature ;
	/** 属性信息采集机器编号/信息采集机器编号 */
	@Column(name = "idCardMachineCode")
	private String idCardMachineCode ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
	/** 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔） */
	@Column(name = "macAddress")
	private String macAddress ;
	/** 属性员工身份证/员工身份证 */
	@Column(name = "identifyNumber")
	private String identifyNumber ;
	/** 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动 */
	@Column(name = "macFlag")
	private String macFlag ;
	/** 属性updateDate/updateDate */
	@Column(name = "updateDate")
	private Date updateDate ;
	/** 属性updateBy/updateBy */
	@Column(name = "updateBy")
	private String updateBy ;
	/** 属性性别：1-男，2-女*/
	@Column(name = "sex")
	private String sex ;
	/** 属性生日*/
	@Column(name = "Birthday")
	private Date Birthday ;
	/** 属性QQ号*/
	@Column(name = "QQ")
	private String QQ ;
	/** 属性微信号*/
	@Column(name = "WeChat")
	private String WeChat ;
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
	/**
	 * 属性员工名称/员工名称的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性员工名称/员工名称的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	} 	
	/**
	 * 属性userEname/userEname的getter方法
	 */
	public String getUserEName() {
		return userEName;
	}
	/**
	 * 属性userEname/userEname的setter方法
	 */
	public void setUserEName(String userEName) {
		this.userEName = userEName;
	} 	
	/**
	 * 属性密码/密码的getter方法
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 属性密码/密码的setter方法
	 */
	public void setPassword(String password) {
		this.password = password;
	} 	
	/**
	 * 属性印鉴/印鉴的getter方法
	 */
	public String getSeal() {
		return seal;
	}
	/**
	 * 属性印鉴/印鉴的setter方法
	 */
	public void setSeal(String seal) {
		this.seal = seal;
	} 	
	/**
	 * 属性passwordSetDate/passwordSetDate的getter方法
	 */
	public Date getPasswordSetDate() {
		return passwordSetDate;
	}
	/**
	 * 属性passwordSetDate/passwordSetDate的setter方法
	 */
	public void setPasswordSetDate(Date passwordSetDate) {
		this.passwordSetDate = passwordSetDate;
	} 	
	/**
	 * 属性passwordExpireDate/passwordExpireDate的getter方法
	 */
	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}
	/**
	 * 属性passwordExpireDate/passwordExpireDate的setter方法
	 */
	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
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
	 * 属性出单机构代码/出单机构代码的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性出单机构代码/出单机构代码的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	} 	
	/**
	 * 属性accountCode/accountCode的getter方法
	 */
	public String getAccountCode() {
		return accountCode;
	}
	/**
	 * 属性accountCode/accountCode的setter方法
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	} 	
	/**
	 * 属性电话号码/电话号码的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性电话号码/电话号码的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	} 	
	/**
	 * 属性手机号码/手机号码的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性手机号码/手机号码的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 	
	/**
	 * 属性通信地址/通信地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性通信地址/通信地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * 属性邮箱/邮箱的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性邮箱/邮箱的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	} 	
	/**
	 * 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员的getter方法
	 */
	public String getUserFlag() {
		return userFlag;
	}
	/**
	 * 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员的setter方法
	 */
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	} 	
	/**
	 * 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统的getter方法
	 */
	public String getLoginSystem() {
		return loginSystem;
	}
	/**
	 * 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统的setter方法
	 */
	public void setLoginSystem(String loginSystem) {
		this.loginSystem = loginSystem;
	} 	
	/**
	 * 属性最新员工代码/最新员工代码的getter方法
	 */
	public String getNewUserCode() {
		return newUserCode;
	}
	/**
	 * 属性最新员工代码/最新员工代码的setter方法
	 */
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
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
	 * 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注)的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注)的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性underwritingAuthority/underwritingAuthority的getter方法
	 */
	public String getUnderwritingAuthority() {
		return underwritingAuthority;
	}
	/**
	 * 属性underwritingAuthority/underwritingAuthority的setter方法
	 */
	public void setUnderwritingAuthority(String underwritingAuthority) {
		this.underwritingAuthority = underwritingAuthority;
	} 	
	/**
	 * 属性终端号/终端号的getter方法
	 */
	public String getPosTerminalNo() {
		return posTerminalNo;
	}
	/**
	 * 属性终端号/终端号的setter方法
	 */
	public void setPosTerminalNo(String posTerminalNo) {
		this.posTerminalNo = posTerminalNo;
	} 	
	/**
	 * 属性salesFlag/salesFlag的getter方法
	 */
	public String getSalesFlag() {
		return salesFlag;
	}
	/**
	 * 属性salesFlag/salesFlag的setter方法
	 */
	public void setSalesFlag(String salesFlag) {
		this.salesFlag = salesFlag;
	} 	
	/**
	 * 属性clockStatus/clockStatus的getter方法
	 */
	public String getClockStatus() {
		return clockStatus;
	}
	/**
	 * 属性clockStatus/clockStatus的setter方法
	 */
	public void setClockStatus(String clockStatus) {
		this.clockStatus = clockStatus;
	} 	
	/**
	 * 属性isSales/isSales的getter方法
	 */
	public String getIsSales() {
		return isSales;
	}
	/**
	 * 属性isSales/isSales的setter方法
	 */
	public void setIsSales(String isSales) {
		this.isSales = isSales;
	} 	
	/**
	 * 属性locked/locked的getter方法
	 */
	public Integer getLocked() {
		return locked;
	}
	/**
	 * 属性locked/locked的setter方法
	 */
	public void setLocked(Integer locked) {
		this.locked = locked;
	} 	
	/**
	 * 属性maxOverDueCount/maxOverDueCount的getter方法
	 */
	public Integer getMaxOverDueCount() {
		return maxOverDueCount;
	}
	/**
	 * 属性maxOverDueCount/maxOverDueCount的setter方法
	 */
	public void setMaxOverDueCount(Integer maxOverDueCount) {
		this.maxOverDueCount = maxOverDueCount;
	} 	
	/**
	 * 属性maxOverDueFee/maxOverDueFee的getter方法
	 */
	public Double getMaxOverDueFee() {
		return maxOverDueFee;
	}
	/**
	 * 属性maxOverDueFee/maxOverDueFee的setter方法
	 */
	public void setMaxOverDueFee(Double maxOverDueFee) {
		this.maxOverDueFee = maxOverDueFee;
	} 	
	/**
	 * 属性userLevel/userLevel的getter方法
	 */
	public String getUserLevel() {
		return userLevel;
	}
	/**
	 * 属性userLevel/userLevel的setter方法
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	} 	
	/**
	 * 属性userNature/userNature的getter方法
	 */
	public String getUserNature() {
		return userNature;
	}
	/**
	 * 属性userNature/userNature的setter方法
	 */
	public void setUserNature(String userNature) {
		this.userNature = userNature;
	} 	
	/**
	 * 属性userType/userType的getter方法
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 属性userType/userType的setter方法
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	} 	
	/**
	 * 属性属性业务来源/属性业务来源的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性属性业务来源/属性业务来源的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	} 	
	/**
	 * 属性信息采集机器编号/信息采集机器编号的getter方法
	 */
	public String getIdCardMachineCode() {
		return idCardMachineCode;
	}
	/**
	 * 属性信息采集机器编号/信息采集机器编号的setter方法
	 */
	public void setIdCardMachineCode(String idCardMachineCode) {
		this.idCardMachineCode = idCardMachineCode;
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
	 * 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔）的getter方法
	 */
	public String getMacAddress() {
		return macAddress;
	}
	/**
	 * 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔）的setter方法
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	} 	
	/**
	 * 属性员工身份证/员工身份证的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性员工身份证/员工身份证的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	} 	
	/**
	 * 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动的getter方法
	 */
	public String getMacFlag() {
		return macFlag;
	}
	/**
	 * 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动的setter方法
	 */
	public void setMacFlag(String macFlag) {
		this.macFlag = macFlag;
	}
	/**
	 * 属性updateDate/updateDate的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 属性updateBy/updateBy的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性updateBy/updateBy的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getWeChat() {
		return WeChat;
	}

	public void setWeChat(String weChat) {
		WeChat = weChat;
	}
}