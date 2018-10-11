package com.sinosoft.agriclaim.core.jobmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 班表管理主表实体操作对象
 */
@Entity
@Table(name = "PrpLJobManager")
@IdClass(PrpLJobManagerKey.class)
public class PrpLJobManager extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	@Id
	@Column(name = "id  ")
	private String id   ;	

	/** 属性工作角色，1-车物查勘，2-人伤查勘/工作角色，1-车物查勘，2-人伤查勘 */
	@Column(name = "jobRole ")
	private String jobRole  ;
	/** 属性值班人员/值班人员 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性值班姓名/值班姓名 */
	@Column(name = "handlerName")
	private String handlerName ;
	/** 属性所在机构（id）/所在机构（id） */
	@Column(name = "handleDept ")
	private String handleDept  ;
	/** 属性所在机构（名称）/所在机构（名称） */
	@Column(name = "deptName  ")
	private String deptName   ;
	/** 属性录入时间/录入时间 */
	@Column(name = "flowInTime")
	private String flowInTime ;
	/** 属性修改时间/修改时间 */
	@Column(name = "modifyTime")
	private String modifyTime ;
	/** 属性值班月份/值班月份 */
	@Column(name = "month")
	private String month ;
	/** 属性默认录入人(维护人)/默认录入人(维护人) */
	@Column(name = "operator")
	private String operator ;
	/** 属性默认录入人id/默认录入人id */
	@Column(name = "operatorId")
	private String operatorId ;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性系统代码/系统代码 */
	@Column(name = "systemCode")
	private String systemCode ;
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