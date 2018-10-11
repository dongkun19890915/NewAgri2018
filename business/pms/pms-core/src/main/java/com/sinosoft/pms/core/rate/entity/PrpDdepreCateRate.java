package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 折旧率表实体操作对象
 */
@Entity
@Table(name = "PrpDdepreCateRate")
@IdClass(PrpDdepreCateRateKey.class)
public class PrpDdepreCateRate extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性条款类别/条款类别 */
        @Id
        @Column(name = "clauseType")
	private String clauseType ;/** 属性车辆种类代码/车辆种类代码 */
        @Id
        @Column(name = "carKindCode")
	private String carKindCode ;	



	/** 属性车辆种类名称/车辆种类名称 */
	private String carKindName ;
	/** 属性每年折旧率/每年折旧率 */
	private java.lang.Double perYearRate ;
	/** 属性标志位/标志位 */
	private String flag ;
	/** 属性每月折旧率/每月折旧率 */
	private java.lang.Double perMonthRate ;




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
	 * 属性条款类别/条款类别的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性条款类别/条款类别的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	} 	
	/**
	 * 属性车辆种类代码/车辆种类代码的getter方法
	 */
	public String getCarKindCode() {
		return carKindCode;
	}
	/**
	 * 属性车辆种类代码/车辆种类代码的setter方法
	 */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	} 	
	/**
	 * 属性车辆种类名称/车辆种类名称的getter方法
	 */
	public String getCarKindName() {
		return carKindName;
	}
	/**
	 * 属性车辆种类名称/车辆种类名称的setter方法
	 */
	public void setCarKindName(String carKindName) {
		this.carKindName = carKindName;
	} 	
	/**
	 * 属性每年折旧率/每年折旧率的getter方法
	 */
	public java.lang.Double getPerYearRate() {
		return perYearRate;
	}
	/**
	 * 属性每年折旧率/每年折旧率的setter方法
	 */
	public void setPerYearRate(java.lang.Double perYearRate) {
		this.perYearRate = perYearRate;
	} 	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性每月折旧率/每月折旧率的getter方法
	 */
	public java.lang.Double getPerMonthRate() {
		return perMonthRate;
	}
	/**
	 * 属性每月折旧率/每月折旧率的setter方法
	 */
	public void setPerMonthRate(java.lang.Double perMonthRate) {
		this.perMonthRate = perMonthRate;
	} 	
		
		
		
		
}