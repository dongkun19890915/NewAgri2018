package com.sinosoft.agriclaim.core.jobmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981
 * 区域设置表实体操作对象
 */
@Entity
@Table(name = "PrplAreaSetting")
@IdClass(PrplAreaSettingKey.class)
public class PrplAreaSetting extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="areasettingsequence")
	@SequenceGenerator(name="areasettingsequence",allocationSize=1,initialValue=1,sequenceName="areasettingsequence")
	private Long id;

	/** 属性员工编号/员工编号 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性班表机构/班表机构 */
	@Column(name = "handleDept")
	private String handleDept ;
	/** 属性查勘员/查勘员 */
	@Column(name = "handlerName")
	private String handlerName ;
	/** 属性作业区域/作业区域 */
	@Column(name = "area")
	private String area ;
	/** 属性手机号码/手机号码 */
	@Column(name = "tel")
	private String tel ;
	/** 属性维护人/维护人 */
	@Column(name = "operator")
	private String operator ;
	/** 属性维护人id/维护人id */
	@Column(name = "operatorId")
	private String operatorId ;
	/** 属性录入时间/录入时间 */
	@Column(name = "flowinTime")
	private String flowinTime ;
	/** 属性修改时间/修改时间 */
	@Column(name = "modifyTime")
	private String modifyTime ;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/**
	 * 属性主键/主键的getter方法
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 属性主键/主键的setter方法
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 属性员工编号/员工编号的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性员工编号/员工编号的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * 属性班表机构/班表机构的getter方法
	 */
	public String getHandleDept() {
		return handleDept;
	}
	/**
	 * 属性班表机构/班表机构的setter方法
	 */
	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept;
	}
	/**
	 * 属性查勘员/查勘员的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性查勘员/查勘员的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * 属性作业区域/作业区域的getter方法
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 属性作业区域/作业区域的setter方法
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 属性手机号码/手机号码的getter方法
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 属性手机号码/手机号码的setter方法
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 属性维护人/维护人的getter方法
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 属性维护人/维护人的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 属性维护人id/维护人id的getter方法
	 */
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * 属性维护人id/维护人id的setter方法
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 属性录入时间/录入时间的getter方法
	 */
	public String getFlowinTime() {
		return flowinTime;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setFlowinTime(String flowinTime) {
		this.flowinTime = flowinTime;
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
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}