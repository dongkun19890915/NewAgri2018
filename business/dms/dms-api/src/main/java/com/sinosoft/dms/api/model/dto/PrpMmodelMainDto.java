package com.sinosoft.dms.api.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板配置主表Api操作对象
 */
public class PrpMmodelMainDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板代码/模板代码 */
	private String modelCode ;		
	/** 属性模板名称/模板名称 */
	private String modelName ;		
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性模板类型/模板类型 */
	private String modelType ;		
	/** 属性模板状态/模板状态 */
	private String validStatus ;		
	/** 属性有效起期/有效起期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date startDate ;		
	/** 属性有效止期/有效止期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date endDate ;		
	/** 属性创建日期/创建日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date createDate ;		
	/** 属性最新修改日期/最新修改日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date updateDate ;		
	/** 属性操作人/操作人 */
	private String operatorCode ;		
	/** 属性最新修改人/最新修改人 */
	private String updateOpCode ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性备用标识/备用标识 flag为1是初始状态，flag为0是删除状态 */
	private String flag="1";
	/** 属性备用标识/ 逻辑删除，0是已删除，默认为1*/
	private String logicdelete="1";
	/**
	 * 属性模板代码/模板代码的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * 属性模板代码/模板代码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}	
	/**
	 * 属性模板名称/模板名称的getter方法
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 属性模板名称/模板名称的setter方法
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}	
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性模板类型/模板类型的getter方法
	 */
	public String getModelType() {
		return modelType;
	}
	/**
	 * 属性模板类型/模板类型的setter方法
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}	
	/**
	 * 属性模板状态/模板状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性模板状态/模板状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性有效起期/有效起期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性有效起期/有效起期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性有效止期/有效止期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性有效止期/有效止期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性创建日期/创建日期的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性创建日期/创建日期的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}	
	/**
	 * 属性最新修改日期/最新修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新修改日期/最新修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性操作人/操作人的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作人/操作人的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性最新修改人/最新修改人的getter方法
	 */
	public String getUpdateOpCode() {
		return updateOpCode;
	}
	/**
	 * 属性最新修改人/最新修改人的setter方法
	 */
	public void setUpdateOpCode(String updateOpCode) {
		this.updateOpCode = updateOpCode;
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
	/**
	 * 属性备用标识/备用标识的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用标识/备用标识的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLogicdelete() {
		return logicdelete;
	}

	public void setLogicdelete(String logicdelete) {
		this.logicdelete = logicdelete;
	}
}
