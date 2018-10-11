package com.sinosoft.agriclaim.api.individuation.dto;

import java.util.Collection;

/**
 * 
 * @description 理赔信雅达上传/查看DTO
 * @author 周柯宇
 * @date 2018年1月18日 上午10:43:22
 */
public class ImageDto {
	/** 属性：登录业务系统的员工工号*/
	private String userCode;
	/** 属性：登录业务系统的员工名称*/
	private String userName;			
	/** 属性：机构代码*/
	private String comCode;				
	/** 属性：机构名称*/
	private String comName;	
	/** 属性：操作员角色	对应影像系统的角色 如：1001-承保报价岗  默认admin*/
	private String roleCode="admin";	
	/** 属性：业务类型代码  如：CLAIM_险种	PRPALL_TB/CB/PG_险种*/
	private String appCode;				
	/** 属性：业务类型名称	理赔/核心*/
	private String appName;				
	/** 属性：业务主索引		报案号/投保单号/保单号/批单号*/
	private String businessNo;			
	/** 属性：ONLY_SELF_ALERT  是否只允许本人修改：1是，0否*/
	private String onlySelfAlert="1";	
	/** 属性：0:无控制，1:弱控制，2:强控制*/
	private String classifyLimit="2";	
	/** 属性：图片类型*/
	private Collection imageTypes ;	
	/** 属性：类代码*/
	private String classCode;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getOnlySelfAlert() {
		return onlySelfAlert;
	}
	public void setOnlySelfAlert(String onlySelfAlert) {
		this.onlySelfAlert = onlySelfAlert;
	}
	public String getClassifyLimit() {
		return classifyLimit;
	}
	public void setClassifyLimit(String classifyLimit) {
		this.classifyLimit = classifyLimit;
	}
	public Collection getImageTypes() {
		return imageTypes;
	}
	public void setImageTypes(Collection imageTypes) {
		this.imageTypes = imageTypes;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	
}
