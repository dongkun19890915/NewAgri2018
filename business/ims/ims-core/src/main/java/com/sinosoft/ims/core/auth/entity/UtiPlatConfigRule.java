package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiPlatConfigRule实体操作对象
 */
@Entity
@Table(name = "UtiPlatConfigRule")
@IdClass(UtiPlatConfigRuleKey.class)
public class UtiPlatConfigRule extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性systemCode/systemCode */
	@Id
	@Column(name = "systemCode")
	private String systemCode ;/** 属性paramCode/paramCode */
	@Id
	@Column(name = "paramCode")
	private String paramCode ;/** 属性serialNo/serialNo */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	



	/** 属性rule/rule */
	@Column(name = "rule")
	private String rule ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性systemCode/systemCode的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性systemCode/systemCode的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 	
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 	
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性rule/rule的getter方法
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 属性rule/rule的setter方法
	 */
	public void setRule(String rule) {
		this.rule = rule;
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