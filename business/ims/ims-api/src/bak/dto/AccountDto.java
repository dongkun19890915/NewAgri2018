package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class AccountDto extends BaseDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**账号代码*/
	private String accCode ;
	/** 属性服务代码/ */
	private String svrCode ;
	/** 属性账号名称/ */
	private String accName ;
	/** 属性账号密码/ */
	private String passWord ;
	/** 属性用户代码/ */
	private String userCode ;
	/** 属性机构代码/ */
	private String comCode ;
	/** 属性用户名称/ */
	private String userName ;
	/** 属性原系统账号代码/ */
	private String fAccCode ;
	/** 属性服务名称/ */
	private String svrName ;
	/** 属性有效标志/ */
	private String validStatus ;
	/** 属性有效截止时间/ */
	private java.util.Date validEndDate ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性允许登录标志/ */
	private String loginPowerFlag ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性密码设定日期/ */
	private java.util.Date passwdSetDate ;
	/** 属性密码过期日期/ */
	private java.util.Date passwdExpireDate ;
	
	private SvrDto svrDto;
	
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public SvrDto getSvrDto() {
		return svrDto;
	}
	public void setSvrDto(SvrDto svrDto) {
		this.svrDto = svrDto;
	}
	public String getSvrCode() {
		return svrCode;
	}
	public void setSvrCode(String svrCode) {
		this.svrCode = svrCode;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getfAccCode() {
		return fAccCode;
	}
	public void setfAccCode(String fAccCode) {
		this.fAccCode = fAccCode;
	}
	public String getSvrName() {
		return svrName;
	}
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	}
	public String getValidStatus() {
		return validStatus;
	}
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	public java.util.Date getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreatorCode() {
		return creatorCode;
	}
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}
	public String getUpdaterCode() {
		return updaterCode;
	}
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}
	public String getLoginPowerFlag() {
		return loginPowerFlag;
	}
	public void setLoginPowerFlag(String loginPowerFlag) {
		this.loginPowerFlag = loginPowerFlag;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public java.util.Date getPasswdSetDate() {
		return passwdSetDate;
	}
	public void setPasswdSetDate(java.util.Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	}
	public java.util.Date getPasswdExpireDate() {
		return passwdExpireDate;
	}
	public void setPasswdExpireDate(java.util.Date passwdExpireDate) {
		this.passwdExpireDate = passwdExpireDate;
	}
	

}
