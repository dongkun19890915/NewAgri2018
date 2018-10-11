package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率分组表实体操作对象
 */
@Entity
@Table(name = "PrpDrateGroup")
@IdClass(PrpDrateGroupKey.class)
public class PrpDrateGroup extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性公司代码/公司代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性系数分组类型/系数分组类型 */
        @Id
        @Column(name = "rateType")
	private String rateType ;/** 属性险种代码/险种代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性险别代码/险别代码 */
        @Id
        @Column(name = "kindCode")
	private String kindCode ;/** 属性系数分组代码/系数分组代码 */
        @Id
        @Column(name = "rateGroupCode")
	private String rateGroupCode ;/** 属性费率期数/费率期数 */
        @Id
        @Column(name = "ratePeriod")
	private java.lang.Integer ratePeriod ;	





	/** 属性系数分组值/系数分组值 */
	private String rateTypeValue ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;

	/** 属性是否有效/是否有效 */
	private String validStatus ;




	/**
	 * 属性公司代码/公司代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性公司代码/公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性系数分组类型/系数分组类型的getter方法
	 */
	public String getRateType() {
		return rateType;
	}
	/**
	 * 属性系数分组类型/系数分组类型的setter方法
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
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
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性系数分组代码/系数分组代码的getter方法
	 */
	public String getRateGroupCode() {
		return rateGroupCode;
	}
	/**
	 * 属性系数分组代码/系数分组代码的setter方法
	 */
	public void setRateGroupCode(String rateGroupCode) {
		this.rateGroupCode = rateGroupCode;
	} 	
	/**
	 * 属性系数分组值/系数分组值的getter方法
	 */
	public String getRateTypeValue() {
		return rateTypeValue;
	}
	/**
	 * 属性系数分组值/系数分组值的setter方法
	 */
	public void setRateTypeValue(String rateTypeValue) {
		this.rateTypeValue = rateTypeValue;
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
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 	
	/**
	 * 属性费率期数/费率期数的getter方法
	 */
	public java.lang.Integer getRatePeriod() {
		return ratePeriod;
	}
	/**
	 * 属性费率期数/费率期数的setter方法
	 */
	public void setRatePeriod(java.lang.Integer ratePeriod) {
		this.ratePeriod = ratePeriod;
	} 	
	/**
	 * 属性是否有效/是否有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效/是否有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
		
		
		
		
}