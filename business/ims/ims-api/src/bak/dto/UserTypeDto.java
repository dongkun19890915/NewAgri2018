package com.sinosoft.ims.api.kernel.dto;
public class UserTypeDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性UserType/用户类型 */
	private String userType ;
	private String userCode;
	
	/** 属性UserName/用户名称 */
	private String userName ;
	/** 属性CreateDate/信息创建日期 */
	private java.util.Date createDate ;
	/** 属性UpdateDate/最新更新操作日期 */
	private java.util.Date updateDate ;
	/** 属性CreatorCode/信息创建人员 */
	private String creatorCode ;
	/** 属性UpdaterCode/最新更新操作人员 */
	private String updaterCode ;
	/** 属性Flag/标志字段 */
	private String flag ;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
