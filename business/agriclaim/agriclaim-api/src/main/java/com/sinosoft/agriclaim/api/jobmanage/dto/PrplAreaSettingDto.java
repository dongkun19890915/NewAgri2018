package com.sinosoft.agriclaim.api.jobmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981
 * 区域设置表Api操作对象
 */
public class PrplAreaSettingDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性主键/主键 */
	private Long id ;
	/** 属性员工编号/员工编号 */
	private String handlerCode ;
	/** 属性班表机构/班表机构 */
	private String handleDept ;
	/** 属性查勘员/查勘员 */
	private String handlerName ;
	/** 属性作业区域/作业区域 */
	private String area ;
	/** 属性手机号码/手机号码 */
	private String tel ;
	/** 属性维护人/维护人 */
	private String operator ;
	/** 属性维护人id/维护人id */
	private String operatorId ;
	/** 属性录入时间/录入时间 */
	private String flowinTime ;
	/** 属性修改时间/修改时间 */
	private String modifyTime ;
	/** 属性险类/险类 */
	private String classCode ;
	/** 属性备注/备注 */
	private String remark ;
	/** 作业区域中文名称*/
	private String areaName;
	/** 班表机构中文名称*/
	private String comCName;
	/** 工号*/
	private String prplAreaSettingDtoHandlercode;
	/** 班表机构*/
	private String prplAreaSettingDtoHandleDept;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	public String getPrplAreaSettingDtoHandlercode() {
		return prplAreaSettingDtoHandlercode;
	}

	public void setPrplAreaSettingDtoHandlercode(String prplAreaSettingDtoHandlercode) {
		this.prplAreaSettingDtoHandlercode = prplAreaSettingDtoHandlercode;
	}

	public String getPrplAreaSettingDtoHandleDept() {
		return prplAreaSettingDtoHandleDept;
	}

	public void setPrplAreaSettingDtoHandleDept(String prplAreaSettingDtoHandleDept) {
		this.prplAreaSettingDtoHandleDept = prplAreaSettingDtoHandleDept;
	}
}
