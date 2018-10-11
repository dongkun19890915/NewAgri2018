package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class SvrDto extends BaseDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	/** 属性SvrCode/服务代码 */
	private String svrCode ;
	public String getSvrCode() {
		return svrCode;
	}
	public void setSvrCode(String svrCode) {
		this.svrCode = svrCode;
	}
	/** 属性SvrName/服务名称 */
	private String svrName ;
	/** 属性WebName/Web应用名称 */
	private String webName ;
	/** 属性CompanyCode/省集中代码 */
	private String companyCode ;
	/** 属性SvrCodeInCompany/省集中服务代码 */
	private String svrCodeInCompany ;
	/** 属性SvrIP/服务IP */
	private String svrIP ;
	/** 属性SvrPort/服务端口号 */
	private String svrPort ;
	/** 属性SvrType/服务分类 */
	private String svrType ;
	/** 属性SvrPriority/服务优先级别 */
	private String svrPriority ;
	/** 属性SvrLoginMethod/服务认证方式 */
	private String svrLoginMethod ;
	/** 属性ManageRightStatus/管理权限状态 */
	private String manageRightStatus ;
	/** 属性ManageMenuStatus/管理菜单状态 */
	private String manageMenuStatus ;
	/** 属性ManageLoginStatus/使用平台管理状态 */
	private String manageLoginStatus ;
	/** 属性ManageAccStatus/账户受管状态 */
	private String manageAccStatus ;
	/** 属性AccSyncStatus/账户信息同步状态 */
	private String accSyncStatus ;
	/** 属性AccMsgSyncStatus/ 账户信息同步状态 */
	private String accMsgSyncStatus ;
	/** 属性AccLoginStatus/使用账户登录状态 */
	private String accLoginStatus ;
	/** 属性ValidStatus/有效状态 */
	private String validStatus ;
	/** 属性ValidEndDate/有效终止时间 */
	private java.util.Date validEndDate ;
	/** 属性CreateDate/信息创建日期 */
	private java.util.Date createDate ;
	/** 属性CreatorCode/信息创建人员 */
	private String creatorCode ;
	/** 属性UpdateDate/最新更新操作日期 */
	private java.util.Date updateDate ;
	/** 属性UpdaterCode/最新更新操作人员 */
	private String updaterCode ;
	/** 属性UtilitySvrCode/系统对应工具库 */
	private String utilitySvrCode ;
	/** 属性Flag/标志字段 */
	private String flag ;
	public String getSvrName() {
		return svrName;
	}
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSvrCodeInCompany() {
		return svrCodeInCompany;
	}
	public void setSvrCodeInCompany(String svrCodeInCompany) {
		this.svrCodeInCompany = svrCodeInCompany;
	}
	public String getSvrIP() {
		return svrIP;
	}
	public void setSvrIP(String svrIP) {
		this.svrIP = svrIP;
	}
	public String getSvrPort() {
		return svrPort;
	}
	public void setSvrPort(String svrPort) {
		this.svrPort = svrPort;
	}
	public String getSvrType() {
		return svrType;
	}
	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}
	public String getSvrPriority() {
		return svrPriority;
	}
	public void setSvrPriority(String svrPriority) {
		this.svrPriority = svrPriority;
	}
	public String getSvrLoginMethod() {
		return svrLoginMethod;
	}
	public void setSvrLoginMethod(String svrLoginMethod) {
		this.svrLoginMethod = svrLoginMethod;
	}
	public String getManageRightStatus() {
		return manageRightStatus;
	}
	public void setManageRightStatus(String manageRightStatus) {
		this.manageRightStatus = manageRightStatus;
	}
	public String getManageMenuStatus() {
		return manageMenuStatus;
	}
	public void setManageMenuStatus(String manageMenuStatus) {
		this.manageMenuStatus = manageMenuStatus;
	}
	public String getManageLoginStatus() {
		return manageLoginStatus;
	}
	public void setManageLoginStatus(String manageLoginStatus) {
		this.manageLoginStatus = manageLoginStatus;
	}
	public String getManageAccStatus() {
		return manageAccStatus;
	}
	public void setManageAccStatus(String manageAccStatus) {
		this.manageAccStatus = manageAccStatus;
	}
	public String getAccSyncStatus() {
		return accSyncStatus;
	}
	public void setAccSyncStatus(String accSyncStatus) {
		this.accSyncStatus = accSyncStatus;
	}
	public String getAccMsgSyncStatus() {
		return accMsgSyncStatus;
	}
	public void setAccMsgSyncStatus(String accMsgSyncStatus) {
		this.accMsgSyncStatus = accMsgSyncStatus;
	}
	public String getAccLoginStatus() {
		return accLoginStatus;
	}
	public void setAccLoginStatus(String accLoginStatus) {
		this.accLoginStatus = accLoginStatus;
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
	public String getUtilitySvrCode() {
		return utilitySvrCode;
	}
	public void setUtilitySvrCode(String utilitySvrCode) {
		this.utilitySvrCode = utilitySvrCode;
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
