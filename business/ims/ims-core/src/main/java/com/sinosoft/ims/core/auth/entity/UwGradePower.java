package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UwGradePower实体操作对象
 */
@Entity
@Table(name = "UwGradePower")
@IdClass(UwGradePowerKey.class)
public class UwGradePower extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性员工代码/员工代码 */
	@Id
	@Column(name = "userCode")
	private String userCode ;/** 属性事业部类型 YL 医疗事业部 BX 保险事业部/事业部类型 YL 医疗事业部 BX 保险事业部 */
	@Id
	@Column(name = "marketType")
	private String marketType ;/** 属性政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性/政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性 */
	@Id
	@Column(name = "policyType")
	private String policyType ;/** 属性业务类型 HB 核保 HP 核赔/业务类型 HB 核保 HP 核赔 */
	@Id
	@Column(name = "uwType")
	private String uwType ;/** 属性审核层级 取值范围1-15/审核层级 取值范围1-15 */
	@Id
	@Column(name = "verifyLevel")
	private java.lang.Integer verifyLevel ;/** 属性审核机构范围/审核机构范围 */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性可审核险类代码串/可审核险类代码串 */
	@Id
	@Column(name = "classCode")
	private String classCode ;/** 属性可审核险种代码串/可审核险种代码串 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;	








	/** 属性除外险种串/除外险种串 */
	@Column(name = "exceptRiskCode")
	private String exceptRiskCode ;
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
	/**
	 * 属性事业部类型 YL 医疗事业部 BX 保险事业部/事业部类型 YL 医疗事业部 BX 保险事业部的getter方法
	 */
	public String getMarketType() {
		return marketType;
	}
	/**
	 * 属性事业部类型 YL 医疗事业部 BX 保险事业部/事业部类型 YL 医疗事业部 BX 保险事业部的setter方法
	 */
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	} 	
	/**
	 * 属性政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性/政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性/政策类型 ZC00 商业性 ZC01 中央政策性 ZC02 地方政策性的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	} 	
	/**
	 * 属性业务类型 HB 核保 HP 核赔/业务类型 HB 核保 HP 核赔的getter方法
	 */
	public String getUwType() {
		return uwType;
	}
	/**
	 * 属性业务类型 HB 核保 HP 核赔/业务类型 HB 核保 HP 核赔的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	} 	
	/**
	 * 属性审核层级 取值范围1-15/审核层级 取值范围1-15的getter方法
	 */
	public java.lang.Integer getVerifyLevel() {
		return verifyLevel;
	}
	/**
	 * 属性审核层级 取值范围1-15/审核层级 取值范围1-15的setter方法
	 */
	public void setVerifyLevel(java.lang.Integer verifyLevel) {
		this.verifyLevel = verifyLevel;
	} 	
	/**
	 * 属性审核机构范围/审核机构范围的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性审核机构范围/审核机构范围的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性可审核险类代码串/可审核险类代码串的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性可审核险类代码串/可审核险类代码串的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性可审核险种代码串/可审核险种代码串的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性可审核险种代码串/可审核险种代码串的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性除外险种串/除外险种串的getter方法
	 */
	public String getExceptRiskCode() {
		return exceptRiskCode;
	}
	/**
	 * 属性除外险种串/除外险种串的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	} 	
}