package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流条件描述表Api操作对象
 */
public class SwfConditionDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模版号/模版号 */
	private java.lang.Integer modelNo ;		
	/** 属性路径号/路径号 */
	private java.lang.Integer pathNo ;		
	/** 属性条件编号/条件编号 */
	private java.lang.Integer conditionNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性归属部门/归属部门 */
	private String comCode ;		
	/** 属性条件是否有效标志 0:无效 1:有效/条件是否有效标志 0:无效 1:有效 */
	private String validStatus ;		
	/** 属性配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述/配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述 */
	private String configType ;		
	/** 属性配置描述/配置描述 */
	private String configText ;		
	/** 属性业务键值/业务键值 */
	private String businessKey ;		
	/** 属性数据库名称（校验合法性）/数据库名称（校验合法性） */
	private String dbName ;		
	/** 属性表名/表名 */
	private String tableName ;		
	/** 属性字段数据类型（与系统表中相同即可）/字段数据类型（与系统表中相同即可） */
	private String dataType ;		
	/** 属性字段名/字段名 */
	private String columnName ;		
	/** 属性字段描述/字段描述 */
	private String columnDesc ;		
	/** 属性运算符（=、!=、>、>= 、IN、MATCHES等）/运算符（=、!=、>、>= 、IN、MATCHES等） */
	private String operator ;		
	/** 属性比较值/比较值 */
	private String value ;		
	/** 属性预留字段/预留字段 */
	private String flag ;		
			
			
			
			
	/**
	 * 属性模版号/模版号的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模版号/模版号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	}	
	/**
	 * 属性路径号/路径号的getter方法
	 */
	public java.lang.Integer getPathNo() {
		return pathNo;
	}
	/**
	 * 属性路径号/路径号的setter方法
	 */
	public void setPathNo(java.lang.Integer pathNo) {
		this.pathNo = pathNo;
	}	
	/**
	 * 属性条件编号/条件编号的getter方法
	 */
	public java.lang.Integer getConditionNo() {
		return conditionNo;
	}
	/**
	 * 属性条件编号/条件编号的setter方法
	 */
	public void setConditionNo(java.lang.Integer conditionNo) {
		this.conditionNo = conditionNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性归属部门/归属部门的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属部门/归属部门的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性条件是否有效标志 0:无效 1:有效/条件是否有效标志 0:无效 1:有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性条件是否有效标志 0:无效 1:有效/条件是否有效标志 0:无效 1:有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述/配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述的getter方法
	 */
	public String getConfigType() {
		return configType;
	}
	/**
	 * 属性配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述/配置类型标志 0:简单描述 1:SQL语句描述 2:高级描述的setter方法
	 */
	public void setConfigType(String configType) {
		this.configType = configType;
	}	
	/**
	 * 属性配置描述/配置描述的getter方法
	 */
	public String getConfigText() {
		return configText;
	}
	/**
	 * 属性配置描述/配置描述的setter方法
	 */
	public void setConfigText(String configText) {
		this.configText = configText;
	}	
	/**
	 * 属性业务键值/业务键值的getter方法
	 */
	public String getBusinessKey() {
		return businessKey;
	}
	/**
	 * 属性业务键值/业务键值的setter方法
	 */
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}	
	/**
	 * 属性数据库名称（校验合法性）/数据库名称（校验合法性）的getter方法
	 */
	public String getDbName() {
		return dbName;
	}
	/**
	 * 属性数据库名称（校验合法性）/数据库名称（校验合法性）的setter方法
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}	
	/**
	 * 属性表名/表名的getter方法
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 属性表名/表名的setter方法
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}	
	/**
	 * 属性字段数据类型（与系统表中相同即可）/字段数据类型（与系统表中相同即可）的getter方法
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * 属性字段数据类型（与系统表中相同即可）/字段数据类型（与系统表中相同即可）的setter方法
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}	
	/**
	 * 属性字段名/字段名的getter方法
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * 属性字段名/字段名的setter方法
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}	
	/**
	 * 属性字段描述/字段描述的getter方法
	 */
	public String getColumnDesc() {
		return columnDesc;
	}
	/**
	 * 属性字段描述/字段描述的setter方法
	 */
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}	
	/**
	 * 属性运算符（=、!=、>、>= 、IN、MATCHES等）/运算符（=、!=、>、>= 、IN、MATCHES等）的getter方法
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 属性运算符（=、!=、>、>= 、IN、MATCHES等）/运算符（=、!=、>、>= 、IN、MATCHES等）的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}	
	/**
	 * 属性比较值/比较值的getter方法
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 属性比较值/比较值的setter方法
	 */
	public void setValue(String value) {
		this.value = value;
	}	
	/**
	 * 属性预留字段/预留字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性预留字段/预留字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
		
		
		
		
}
