package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 个人用户信息表-UtiIUserIdv   基础数据对象
 */
@Entity
@Table(name = "UtiIUserIdv")
@IdClass(UtiIUserIdvKey.class)
public class UtiIUserIdv implements BaseEntity,java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 属性登录名称/ */
	private String userName ;
	/** 属性业务员代码/ */
	private String salesManCode ;
	/**属性录单员代码*/
	private String recordManCode;
	/** 属性业务员姓名/ */
	private String salesManName ;
	/** 属性归属机构/ */
	private String comCode ;
	/** 属性归属保险公司(保险公司总级)/ */
	private String headComCode ;
	/** 属性所属保险公司省级代码/ */
	private String proviceComCode ;
	/** 属性所属保险公司分支机构代码/ */
	private String cityComCode ;
	/** 属性所属保险公司分支机构名称/ */
	private String cityComName ;
	/** 属性证件类型/ */
	private String identityType ;
	/** 属性是否允许修改初始密码标识0不允许1允许/ */
	private String modifyPasswdFlag ;
	/**属性是否是总公司0不是1是*/
	private String shareFlag;
	/** 属性接收初始密码邮箱/ */
	private String receivePwEMail ;
	/** 属性最新用户代码/ */
	private String newUserCode ;
	/** 属性家里电话号码/ */
	private String homePhone ;
	/** 属性办公电话号码/ */
	private String officePhone ;
	/** 属性传真号码/ */
	private String faxNumber ;
	/** 属性手机号码/ */
	private String mobile ;
	/** 属性邮件地址/ */
	private String email ;
	/** 属性邮寄地址/ */
	private String postAddress ;
	/** 属性邮政编码/ */
	private String postCode ;
	/** 属性地址中文名称/ */
	private String addressCName ;
	/** 属性地址英文名称/ */
	private String addressEName ;
	/** 属性个人身份证件号码/ */
	private String identifyNumber ;
	/** 属性资信等级/ */
	private String creditLevel ;
	/** 属性性别/ */
	private String sex ;
	/** 属性出生日期/ */
	private java.util.Date birthDate ;
	/** 属性年龄/ */
	private String age ;
	/** 属性健康状况/ */
	private String health ;
	/** 属性职业代码/ */
	private String occupationCode ;
	/** 属性学历代码/ */
	private String educationCode ;
	/** 属性工作单位/ */
	private String unit ;
	/** 属性单位地址/ */
	private String unitAddress ;
	/** 属性客户标志/ */
	private String customerFlag ;
	/** 属性开户银行/ */
	private String bank ;
	/** 属性帐号/ */
	private String account ;
	/** 属性IP/ */
	private String iP ;
	/** 属性终端代码/ */
	private String terminalCode ;
	/** 属性建立机构/ */
	private String markCode ;
	/** 属性用户来源/ */
	private String source ;
	/** 属性印章/ */
	private String seal ;
	/** 属性备注/ */
	private String remark ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性登录账号/ */
	@Id
	@Column(name = "userCode")
	private String userCode ;
	/**
	 * 属性登录账号/的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性登录账号/的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 类UtiIUserIdv的默认构造方法
	 */
	public UtiIUserIdv() {
	}

	/**
	 * 属性登录名称/的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性登录名称/的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	} 
	/**
	 * 属性业务员代码/的getter方法
	 */
	public String getSalesManCode() {
		return salesManCode;
	}
	public String getRecordManCode() {
		return recordManCode;
	}

	public void setRecordManCode(String recordManCode) {
		this.recordManCode = recordManCode;
	}

	public String getShareFlag() {
		return shareFlag;
	}

	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
	}
	/**
	 * 属性业务员代码/的setter方法
	 */
	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	} 
	/**
	 * 属性业务员姓名/的getter方法
	 */
	public String getSalesManName() {
		return salesManName;
	}
	/**
	 * 属性业务员姓名/的setter方法
	 */
	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	} 
	/**
	 * 属性归属机构/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性归属保险公司(保险公司总级)/的getter方法
	 */
	public String getHeadComCode() {
		return headComCode;
	}
	/**
	 * 属性归属保险公司(保险公司总级)/的setter方法
	 */
	public void setHeadComCode(String headComCode) {
		this.headComCode = headComCode;
	} 
	/**
	 * 属性所属保险公司省级代码/的getter方法
	 */
	public String getProviceComCode() {
		return proviceComCode;
	}
	/**
	 * 属性所属保险公司省级代码/的setter方法
	 */
	public void setProviceComCode(String proviceComCode) {
		this.proviceComCode = proviceComCode;
	} 
	/**
	 * 属性所属保险公司分支机构代码/的getter方法
	 */
	public String getCityComCode() {
		return cityComCode;
	}
	/**
	 * 属性所属保险公司分支机构代码/的setter方法
	 */
	public void setCityComCode(String cityComCode) {
		this.cityComCode = cityComCode;
	} 
	/**
	 * 属性所属保险公司分支机构名称/的getter方法
	 */
	public String getCityComName() {
		return cityComName;
	}
	/**
	 * 属性所属保险公司分支机构名称/的setter方法
	 */
	public void setCityComName(String cityComName) {
		this.cityComName = cityComName;
	} 
	/**
	 * 属性证件类型/的getter方法
	 */
	public String getIdentityType() {
		return identityType;
	}
	/**
	 * 属性证件类型/的setter方法
	 */
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	} 
	/**
	 * 属性是否允许修改初始密码标识0不允许1允许/的getter方法
	 */
	public String getModifyPasswdFlag() {
		return modifyPasswdFlag;
	}
	/**
	 * 属性是否允许修改初始密码标识0不允许1允许/的setter方法
	 */
	public void setModifyPasswdFlag(String modifyPasswdFlag) {
		this.modifyPasswdFlag = modifyPasswdFlag;
	} 
	/**
	 * 属性接收初始密码邮箱/的getter方法
	 */
	public String getReceivePwEMail() {
		return receivePwEMail;
	}
	/**
	 * 属性接收初始密码邮箱/的setter方法
	 */
	public void setReceivePwEMail(String receivePwEMail) {
		this.receivePwEMail = receivePwEMail;
	} 
	/**
	 * 属性最新用户代码/的getter方法
	 */
	public String getNewUserCode() {
		return newUserCode;
	}
	/**
	 * 属性最新用户代码/的setter方法
	 */
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	} 
	/**
	 * 属性家里电话号码/的getter方法
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * 属性家里电话号码/的setter方法
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	} 
	/**
	 * 属性办公电话号码/的getter方法
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * 属性办公电话号码/的setter方法
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	} 
	/**
	 * 属性传真号码/的getter方法
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * 属性传真号码/的setter方法
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	} 
	/**
	 * 属性手机号码/的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性手机号码/的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 
	/**
	 * 属性邮件地址/的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性邮件地址/的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	} 
	/**
	 * 属性邮寄地址/的getter方法
	 */
	public String getPostAddress() {
		return postAddress;
	}
	/**
	 * 属性邮寄地址/的setter方法
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	} 
	/**
	 * 属性邮政编码/的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮政编码/的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	} 
	/**
	 * 属性地址中文名称/的getter方法
	 */
	public String getAddressCName() {
		return addressCName;
	}
	/**
	 * 属性地址中文名称/的setter方法
	 */
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	} 
	/**
	 * 属性地址英文名称/的getter方法
	 */
	public String getAddressEName() {
		return addressEName;
	}
	/**
	 * 属性地址英文名称/的setter方法
	 */
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	} 
	/**
	 * 属性个人身份证件号码/的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性个人身份证件号码/的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	} 
	/**
	 * 属性资信等级/的getter方法
	 */
	public String getCreditLevel() {
		return creditLevel;
	}
	/**
	 * 属性资信等级/的setter方法
	 */
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	} 
	/**
	 * 属性性别/的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别/的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	} 
	/**
	 * 属性出生日期/的getter方法
	 */
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	/**
	 * 属性出生日期/的setter方法
	 */
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	} 
	/**
	 * 属性年龄/的getter方法
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 属性年龄/的setter方法
	 */
	public void setAge(String age) {
		this.age = age;
	} 
	/**
	 * 属性健康状况/的getter方法
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * 属性健康状况/的setter方法
	 */
	public void setHealth(String health) {
		this.health = health;
	} 
	/**
	 * 属性职业代码/的getter方法
	 */
	public String getOccupationCode() {
		return occupationCode;
	}
	/**
	 * 属性职业代码/的setter方法
	 */
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	} 
	/**
	 * 属性学历代码/的getter方法
	 */
	public String getEducationCode() {
		return educationCode;
	}
	/**
	 * 属性学历代码/的setter方法
	 */
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	} 
	/**
	 * 属性工作单位/的getter方法
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 属性工作单位/的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	} 
	/**
	 * 属性单位地址/的getter方法
	 */
	public String getUnitAddress() {
		return unitAddress;
	}
	/**
	 * 属性单位地址/的setter方法
	 */
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	} 
	/**
	 * 属性客户标志/的getter方法
	 */
	public String getCustomerFlag() {
		return customerFlag;
	}
	/**
	 * 属性客户标志/的setter方法
	 */
	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	} 
	/**
	 * 属性开户银行/的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 
	/**
	 * 属性帐号/的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性帐号/的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
	} 
	/**
	 * 属性IP/的getter方法
	 */
	public String getiP() {
		return iP;
	}
	/**
	 * 属性IP/的setter方法
	 */
	public void setiP(String iP) {
		this.iP = iP;
	} 
	/**
	 * 属性终端代码/的getter方法
	 */
	public String getTerminalCode() {
		return terminalCode;
	}
	/**
	 * 属性终端代码/的setter方法
	 */
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	} 
	/**
	 * 属性建立机构/的getter方法
	 */
	public String getMarkCode() {
		return markCode;
	}
	/**
	 * 属性建立机构/的setter方法
	 */
	public void setMarkCode(String markCode) {
		this.markCode = markCode;
	} 
	/**
	 * 属性用户来源/的getter方法
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 属性用户来源/的setter方法
	 */
	public void setSource(String source) {
		this.source = source;
	} 
	/**
	 * 属性印章/的getter方法
	 */
	public String getSeal() {
		return seal;
	}
	/**
	 * 属性印章/的setter方法
	 */
	public void setSeal(String seal) {
		this.seal = seal;
	} 
	/**
	 * 属性备注/的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性标志字段/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
	/**
	 * 属性信息创建日期/的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性信息创建日期/的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	} 
	/**
	 * 属性信息创建人员/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性信息创建人员/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性最新更新操作日期/的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新更新操作日期/的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 
	/**
	 * 属性最新更新操作人员/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最新更新操作人员/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 
}