package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiConfig实体操作对象
 */
@Entity
@Table(name = "UtiConfig")
@IdClass(UtiConfigKey.class)
public class UtiConfig extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性configCode/configCode */
	@Id
	@Column(name = "configCode")
	private String configCode ;	

	/** 属性configCname/configCname */
	@Column(name = "configCName")
	private String configCName ;
	/** 属性configEname/configEname */
	@Column(name = "configEName")
	private String configEName ;
	/** 属性configType/configType */
	@Column(name = "configType")
	private String configType ;
	/** 属性valueType/valueType */
	@Column(name = "valueType")
	private String valueType ;
	/** 属性configValue/configValue */
	@Column(name = "configValue")
	private String configValue ;
	/** 属性configTable/configTable */
	@Column(name = "configTable")
	private String configTable ;
	/** 属性configSelectColomn1/configSelectColomn1 */
	@Column(name = "configSelectColomn1")
	private String configSelectColomn1 ;
	/** 属性configSelectColomn2/configSelectColomn2 */
	@Column(name = "configSelectColomn2")
	private String configSelectColomn2 ;
	/** 属性configSelectColomn3/configSelectColomn3 */
	@Column(name = "configSelectColomn3")
	private String configSelectColomn3 ;
	/** 属性configWhereColomn/configWhereColomn */
	@Column(name = "configWhereColomn")
	private String configWhereColomn ;
	/** 属性configWhereValue/configWhereValue */
	@Column(name = "configWhereValue")
	private String configWhereValue ;
	/** 属性messageType/messageType */
	@Column(name = "messageType")
	private String messageType ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性configCode/configCode的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性configCode/configCode的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	} 	
	/**
	 * 属性configCname/configCname的getter方法
	 */
	public String getConfigCName() {
		return configCName;
	}
	/**
	 * 属性configCname/configCname的setter方法
	 */
	public void setConfigCName(String configCName) {
		this.configCName = configCName;
	} 	
	/**
	 * 属性configEname/configEname的getter方法
	 */
	public String getConfigEName() {
		return configEName;
	}
	/**
	 * 属性configEname/configEname的setter方法
	 */
	public void setConfigEName(String configEName) {
		this.configEName = configEName;
	} 	
	/**
	 * 属性configType/configType的getter方法
	 */
	public String getConfigType() {
		return configType;
	}
	/**
	 * 属性configType/configType的setter方法
	 */
	public void setConfigType(String configType) {
		this.configType = configType;
	} 	
	/**
	 * 属性valueType/valueType的getter方法
	 */
	public String getValueType() {
		return valueType;
	}
	/**
	 * 属性valueType/valueType的setter方法
	 */
	public void setValueType(String valueType) {
		this.valueType = valueType;
	} 	
	/**
	 * 属性configValue/configValue的getter方法
	 */
	public String getConfigValue() {
		return configValue;
	}
	/**
	 * 属性configValue/configValue的setter方法
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	} 	
	/**
	 * 属性configTable/configTable的getter方法
	 */
	public String getConfigTable() {
		return configTable;
	}
	/**
	 * 属性configTable/configTable的setter方法
	 */
	public void setConfigTable(String configTable) {
		this.configTable = configTable;
	} 	
	/**
	 * 属性configSelectColomn1/configSelectColomn1的getter方法
	 */
	public String getConfigSelectColomn1() {
		return configSelectColomn1;
	}
	/**
	 * 属性configSelectColomn1/configSelectColomn1的setter方法
	 */
	public void setConfigSelectColomn1(String configSelectColomn1) {
		this.configSelectColomn1 = configSelectColomn1;
	} 	
	/**
	 * 属性configSelectColomn2/configSelectColomn2的getter方法
	 */
	public String getConfigSelectColomn2() {
		return configSelectColomn2;
	}
	/**
	 * 属性configSelectColomn2/configSelectColomn2的setter方法
	 */
	public void setConfigSelectColomn2(String configSelectColomn2) {
		this.configSelectColomn2 = configSelectColomn2;
	} 	
	/**
	 * 属性configSelectColomn3/configSelectColomn3的getter方法
	 */
	public String getConfigSelectColomn3() {
		return configSelectColomn3;
	}
	/**
	 * 属性configSelectColomn3/configSelectColomn3的setter方法
	 */
	public void setConfigSelectColomn3(String configSelectColomn3) {
		this.configSelectColomn3 = configSelectColomn3;
	} 	
	/**
	 * 属性configWhereColomn/configWhereColomn的getter方法
	 */
	public String getConfigWhereColomn() {
		return configWhereColomn;
	}
	/**
	 * 属性configWhereColomn/configWhereColomn的setter方法
	 */
	public void setConfigWhereColomn(String configWhereColomn) {
		this.configWhereColomn = configWhereColomn;
	} 	
	/**
	 * 属性configWhereValue/configWhereValue的getter方法
	 */
	public String getConfigWhereValue() {
		return configWhereValue;
	}
	/**
	 * 属性configWhereValue/configWhereValue的setter方法
	 */
	public void setConfigWhereValue(String configWhereValue) {
		this.configWhereValue = configWhereValue;
	} 	
	/**
	 * 属性messageType/messageType的getter方法
	 */
	public String getMessageType() {
		return messageType;
	}
	/**
	 * 属性messageType/messageType的setter方法
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}