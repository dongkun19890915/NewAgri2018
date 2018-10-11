package com.sinosoft.agriclaim.api.jobmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 联系人Api操作对象
 */
public class PrpLJobLinkerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	private String staffId ;		
	/** 属性联系人岗位：1-转接报案人，2-对接人/联系人岗位：1-转接报案人，2-对接人 */
	private String staffPosition ;		
	/** 属性人员代码/人员代码 */
	private String staffUserCode ;		
	/** 属性人员姓名/人员姓名 */
	private String staffName ;		
	/** 属性电话号码/电话号码 */
	private String staffPhone  ;		
	/** 属性人员类型：0-公司内部人员，1-公司外部人员/人员类型：0-公司内部人员，1-公司外部人员 */
	private String staffType ;		
	/** 属性归属机构/归属机构 */
	private String handleDept  ;		
	/** 属性月份/月份 */
	private String month  ;		
	/** 属性录入时间/录入时间 */
	private String flowInTime ;		
	/** 属性修改时间/修改时间 */
	private String modifyTime ;		
	/** 属性险类：31种植险，32养殖险，99非农非车险，05非车险/险类：31种植险，32养殖险，99非农非车险，05非车险 */
	private String classCode  ;		
	/**
	 * 属性主键/主键的getter方法
	 */
	public String getStaffId() {
		return staffId;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}	
	/**
	 * 属性联系人岗位：1-转接报案人，2-对接人/联系人岗位：1-转接报案人，2-对接人的getter方法
	 */
	public String getStaffPosition() {
		return staffPosition;
	}
	/**
	 * 属性联系人岗位：1-转接报案人，2-对接人/联系人岗位：1-转接报案人，2-对接人的setter方法
	 */
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}	
	/**
	 * 属性人员代码/人员代码的getter方法
	 */
	public String getStaffUserCode() {
		return staffUserCode;
	}
	/**
	 * 属性人员代码/人员代码的setter方法
	 */
	public void setStaffUserCode(String staffUserCode) {
		this.staffUserCode = staffUserCode;
	}	
	/**
	 * 属性人员姓名/人员姓名的getter方法
	 */
	public String getStaffName() {
		return staffName;
	}
	/**
	 * 属性人员姓名/人员姓名的setter方法
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}	
	/**
	 * 属性电话号码/电话号码的getter方法
	 */
	public String getStaffPhone () {
		return staffPhone ;
	}
	/**
	 * 属性电话号码/电话号码的setter方法
	 */
	public void setStaffPhone (String staffPhone ) {
		this.staffPhone  = staffPhone ;
	}	
	/**
	 * 属性人员类型：0-公司内部人员，1-公司外部人员/人员类型：0-公司内部人员，1-公司外部人员的getter方法
	 */
	public String getStaffType() {
		return staffType;
	}
	/**
	 * 属性人员类型：0-公司内部人员，1-公司外部人员/人员类型：0-公司内部人员，1-公司外部人员的setter方法
	 */
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}	
	/**
	 * 属性归属机构/归属机构的getter方法
	 */
	public String getHandleDept () {
		return handleDept ;
	}
	/**
	 * 属性归属机构/归属机构的setter方法
	 */
	public void setHandleDept (String handleDept ) {
		this.handleDept  = handleDept ;
	}	
	/**
	 * 属性月份/月份的getter方法
	 */
	public String getMonth () {
		return month ;
	}
	/**
	 * 属性月份/月份的setter方法
	 */
	public void setMonth (String month ) {
		this.month  = month ;
	}	
	/**
	 * 属性录入时间/录入时间的getter方法
	 */
	public String getFlowInTime() {
		return flowInTime;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public String getModifyTime() {
		return modifyTime;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}	
	/**
	 * 属性险类：31种植险，32养殖险，99非农非车险，05非车险/险类：31种植险，32养殖险，99非农非车险，05非车险的getter方法
	 */
	public String getClassCode () {
		return classCode ;
	}
	/**
	 * 属性险类：31种植险，32养殖险，99非农非车险，05非车险/险类：31种植险，32养殖险，99非农非车险，05非车险的setter方法
	 */
	public void setClassCode (String classCode ) {
		this.classCode  = classCode ;
	}	
}
