package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class UserIdvDto extends BaseDto implements java.io.Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String userCode;
	/** 属性登录账号*/
	/** 属性登录名称/ */
	private String userName ;
	/** 属性业务员代码/ */
	private String salesManCode ;
	/**属性录单员代码*/
	private String recordManCode;
	/** 属性姓名/ */
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
	public String getSalesManCode() {
		return salesManCode;
	}
	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	}
	public String getSalesManName() {
		return salesManName;
	}
	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}
	public String getHeadComCode() {
		return headComCode;
	}
	public void setHeadComCode(String headComCode) {
		this.headComCode = headComCode;
	}
	public String getModifyPasswdFlag() {
		return modifyPasswdFlag;
	}
	public void setModifyPasswdFlag(String modifyPasswdFlag) {
		this.modifyPasswdFlag = modifyPasswdFlag;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getUserCode()
    {
        return userCode;
    }
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    public void setAge(String age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getProviceComCode() {
		return proviceComCode;
	}
	public void setProviceComCode(String proviceComCode) {
		this.proviceComCode = proviceComCode;
	}
	public String getCityComCode() {
		return cityComCode;
	}
	public void setCityComCode(String cityComCode) {
		this.cityComCode = cityComCode;
	}
	public String getCityComName() {
		return cityComName;
	}
	public void setCityComName(String cityComName) {
		this.cityComName = cityComName;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getReceivePwEMail() {
		return receivePwEMail;
	}
	public void setReceivePwEMail(String receivePwEMail) {
		this.receivePwEMail = receivePwEMail;
	}
	public String getNewUserCode() {
		return newUserCode;
	}
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getAddressCName() {
		return addressCName;
	}
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}
	public String getAddressEName() {
		return addressEName;
	}
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getAge() {
		return age;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getEducationCode() {
		return educationCode;
	}
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getCustomerFlag() {
		return customerFlag;
	}
	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTerminalCode() {
		return terminalCode;
	}
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}
	public String getiP() {
		return iP;
	}
	public void setiP(String iP) {
		this.iP = iP;
	}
	public String getMarkCode() {
		return markCode;
	}
	public void setMarkCode(String markCode) {
		this.markCode = markCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSeal() {
		return seal;
	}
	public void setSeal(String seal) {
		this.seal = seal;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatorCode() {
		return creatorCode;
	}
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdaterCode() {
		return updaterCode;
	}
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
