package com.sinosoft.agriclaim.api.jobmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 班表管理主表Api操作对象
 */
public class PrpLJobManagerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;



	/*判断按机构查询,个人查询 ,还是复制查询 机构查询为institution个人查询为personal 复制查询copy*/
	private String queryType ;
	/** 属性主键/主键 */
	private String id   ;		
	/** 属性工作角色，1-车物查勘，2-人伤查勘/工作角色，1-车物查勘，2-人伤查勘 */
	private String jobRole  ;
	/** 属性值班人员/值班人员 */
	private String handlerCode ;		
	/** 属性值班姓名/值班姓名 */
	private String handlerName ;		
	/** 属性所在机构（id）/所在机构（id） */
	private String handleDept  ;		
	/** 属性所在机构（名称）/所在机构（名称） */
	private String deptName   ;		
	/** 属性录入时间/录入时间 */
	private String flowInTime ;		
	/** 属性修改时间/修改时间 */
	private String modifyTime ;		
	/** 属性值班月份/值班月份 */
	private String month ;		
	/** 属性默认录入人(维护人)/默认录入人(维护人) */
	private String operator ;		
	/** 属性默认录入人id/默认录入人id */
	private String operatorId ;
	/** 属性险类/险类 */
	private String classCode ;		
	/** 属性系统代码/系统代码 */
	private String systemCode ;
	/*时间表的List*/
	private List<PrpLJobManagerTimeDto> prpLJobManagerTimeDtoList;
	private List<PrpLJobManagerTimeDto> amList;
	private List<PrpLJobManagerTimeDto> pmList;
	public List<PrpLJobManagerTimeDto> getAmList() {
		return amList;
	}

	public void setAmList(List<PrpLJobManagerTimeDto> amList) {
		this.amList = amList;
	}

	public List<PrpLJobManagerTimeDto> getPmList() {
		return pmList;
	}

	public void setPmList(List<PrpLJobManagerTimeDto> pmList) {
		this.pmList = pmList;
	}
	public List<PrpLJobManagerTimeDto> getPrpLJobManagerTimeDtoList() {
	return prpLJobManagerTimeDtoList;
	}

	public void setPrpLJobManagerTimeDtoList(List<PrpLJobManagerTimeDto> prpLJobManagerTimeDtoList) {
	this.prpLJobManagerTimeDtoList = prpLJobManagerTimeDtoList;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/**
	 * 属性主键/主键的getter方法
	 */
	public String getId  () {
		return id  ;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId  (String id  ) {
		this.id   = id  ;
	}	
	/**
	 * 属性工作角色，1-车物查勘，2-人伤查勘/工作角色，1-车物查勘，2-人伤查勘的getter方法
	 */
	public String getJobRole () {
		return jobRole ;
	}
	/**
	 * 属性工作角色，1-车物查勘，2-人伤查勘/工作角色，1-车物查勘，2-人伤查勘的setter方法
	 */
	public void setJobRole (String jobRole ) {
		this.jobRole  = jobRole ;
	}	
	/**
	 * 属性值班人员/值班人员的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性值班人员/值班人员的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性值班姓名/值班姓名的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性值班姓名/值班姓名的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性所在机构（id）/所在机构（id）的getter方法
	 */
	public String getHandleDept () {
		return handleDept ;
	}
	/**
	 * 属性所在机构（id）/所在机构（id）的setter方法
	 */
	public void setHandleDept (String handleDept ) {
		this.handleDept  = handleDept ;
	}	
	/**
	 * 属性所在机构（名称）/所在机构（名称）的getter方法
	 */
	public String getDeptName  () {
		return deptName  ;
	}
	/**
	 * 属性所在机构（名称）/所在机构（名称）的setter方法
	 */
	public void setDeptName  (String deptName  ) {
		this.deptName   = deptName  ;
	}	
	/**
	 * 属性录入时间/录入时间的getter方法
	 */
	public String getflowInTime() {
		return flowInTime;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setflowInTime(String flowInTime) {
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
	 * 属性值班月份/值班月份的getter方法
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 属性值班月份/值班月份的setter方法
	 */
	public void setMonth(String month) {
		this.month = month;
	}	
	/**
	 * 属性默认录入人(维护人)/默认录入人(维护人)的getter方法
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 属性默认录入人(维护人)/默认录入人(维护人)的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}	
	/**
	 * 属性默认录入人id/默认录入人id的getter方法
	 */
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * 属性默认录入人id/默认录入人id的setter方法
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}	
}
