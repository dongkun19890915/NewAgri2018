package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 平台配置规则表实体操作对象
 */
@Entity
@Table(name = "UtiPlatConfigRule")
@IdClass(UtiPlatConfigRuleKey.class)
public class UtiPlatConfigRule extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性系统代码/系统代码 */
        @Id
        @Column(name = "systemCode")
	private String systemCode ;/** 属性参数名/参数名 */
        @Id
        @Column(name = "paramCode")
	private String paramCode ;/** 属性序号/序号 */
        @Id
        @Column(name = "serialNo")
	private java.lang.Integer serialNo ;	



	/** 属性规则/规则 */
	private String rule ;
	/** 属性标志/标志 */
	private String flag ;




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
	/**
	 * 属性参数名/参数名的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性参数名/参数名的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
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
	 * 属性规则/规则的getter方法
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 属性规则/规则的setter方法
	 */
	public void setRule(String rule) {
		this.rule = rule;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
		
		
		
		
}