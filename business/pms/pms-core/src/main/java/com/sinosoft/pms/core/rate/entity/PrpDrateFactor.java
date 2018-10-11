package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 费率因子表实体操作对象
 */
@Entity
@Table(name = "PrpDrateFactor")
@IdClass(PrpDrateFactorKey.class)
public class PrpDrateFactor extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性因子类型/因子类型 */
        @Id
        @Column(name = "factorType")
	private String factorType ;/** 属性费率因子代码/费率因子代码 */
        @Id
        @Column(name = "factorCode")
	private String factorCode ;/** 属性费率因子所在表名/费率因子所在表名 */
        @Id
        @Column(name = "factorTable")
	private String factorTable ;/** 属性系数分组类型/系数分组类型 */
        @Id
        @Column(name = "rateType")
	private String rateType ;/** 属性费率期数/费率期数 */
        @Id
        @Column(name = "ratePeriod")
	private java.lang.Integer ratePeriod ;	



	/** 属性费率因子名称/费率因子名称 */
	private String factorName ;

	/** 属性费率因子所在字段名/费率因子所在字段名 */
	private String factorColumn ;
	/** 属性费率因子取值类型/费率因子取值类型 */
	private String factorFlag ;
	/** 属性代码表名称/代码表名称 */
	private String valueTable ;
	/** 属性代码表主键名称1/代码表主键名称1 */
	private String valueField1 ;
	/** 属性代码表代码类名称1/代码表代码类名称1 */
	private String valueValue1 ;
	/** 属性代码表主键名称2/代码表主键名称2 */
	private String valueField2 ;
	/** 属性代码表代码类名称2/代码表代码类名称2 */
	private String valueValue2 ;
	/** 属性因子值/因子值 */
	private String factorValue ;

	/** 属性费率分组段位/费率分组段位 */
	private java.lang.Integer rateGroupSegment ;
	/** 属性费率段位/费率段位 */
	private java.lang.Integer rateUsualSegment ;
	/** 属性关联因子/关联因子 */
	private String relationFactor ;
	/** 属性是否有效/是否有效 */
	private String validStatus ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;





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
	 * 属性因子类型/因子类型的getter方法
	 */
	public String getFactorType() {
		return factorType;
	}
	/**
	 * 属性因子类型/因子类型的setter方法
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
	} 	
	/**
	 * 属性费率因子代码/费率因子代码的getter方法
	 */
	public String getFactorCode() {
		return factorCode;
	}
	/**
	 * 属性费率因子代码/费率因子代码的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 	
	/**
	 * 属性费率因子名称/费率因子名称的getter方法
	 */
	public String getFactorName() {
		return factorName;
	}
	/**
	 * 属性费率因子名称/费率因子名称的setter方法
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	} 	
	/**
	 * 属性费率因子所在表名/费率因子所在表名的getter方法
	 */
	public String getFactorTable() {
		return factorTable;
	}
	/**
	 * 属性费率因子所在表名/费率因子所在表名的setter方法
	 */
	public void setFactorTable(String factorTable) {
		this.factorTable = factorTable;
	} 	
	/**
	 * 属性费率因子所在字段名/费率因子所在字段名的getter方法
	 */
	public String getFactorColumn() {
		return factorColumn;
	}
	/**
	 * 属性费率因子所在字段名/费率因子所在字段名的setter方法
	 */
	public void setFactorColumn(String factorColumn) {
		this.factorColumn = factorColumn;
	} 	
	/**
	 * 属性费率因子取值类型/费率因子取值类型的getter方法
	 */
	public String getFactorFlag() {
		return factorFlag;
	}
	/**
	 * 属性费率因子取值类型/费率因子取值类型的setter方法
	 */
	public void setFactorFlag(String factorFlag) {
		this.factorFlag = factorFlag;
	} 	
	/**
	 * 属性代码表名称/代码表名称的getter方法
	 */
	public String getValueTable() {
		return valueTable;
	}
	/**
	 * 属性代码表名称/代码表名称的setter方法
	 */
	public void setValueTable(String valueTable) {
		this.valueTable = valueTable;
	} 	
	/**
	 * 属性代码表主键名称1/代码表主键名称1的getter方法
	 */
	public String getValueField1() {
		return valueField1;
	}
	/**
	 * 属性代码表主键名称1/代码表主键名称1的setter方法
	 */
	public void setValueField1(String valueField1) {
		this.valueField1 = valueField1;
	} 	
	/**
	 * 属性代码表代码类名称1/代码表代码类名称1的getter方法
	 */
	public String getValueValue1() {
		return valueValue1;
	}
	/**
	 * 属性代码表代码类名称1/代码表代码类名称1的setter方法
	 */
	public void setValueValue1(String valueValue1) {
		this.valueValue1 = valueValue1;
	} 	
	/**
	 * 属性代码表主键名称2/代码表主键名称2的getter方法
	 */
	public String getValueField2() {
		return valueField2;
	}
	/**
	 * 属性代码表主键名称2/代码表主键名称2的setter方法
	 */
	public void setValueField2(String valueField2) {
		this.valueField2 = valueField2;
	} 	
	/**
	 * 属性代码表代码类名称2/代码表代码类名称2的getter方法
	 */
	public String getValueValue2() {
		return valueValue2;
	}
	/**
	 * 属性代码表代码类名称2/代码表代码类名称2的setter方法
	 */
	public void setValueValue2(String valueValue2) {
		this.valueValue2 = valueValue2;
	} 	
	/**
	 * 属性因子值/因子值的getter方法
	 */
	public String getFactorValue() {
		return factorValue;
	}
	/**
	 * 属性因子值/因子值的setter方法
	 */
	public void setFactorValue(String factorValue) {
		this.factorValue = factorValue;
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
	 * 属性费率分组段位/费率分组段位的getter方法
	 */
	public java.lang.Integer getRateGroupSegment() {
		return rateGroupSegment;
	}
	/**
	 * 属性费率分组段位/费率分组段位的setter方法
	 */
	public void setRateGroupSegment(java.lang.Integer rateGroupSegment) {
		this.rateGroupSegment = rateGroupSegment;
	} 	
	/**
	 * 属性费率段位/费率段位的getter方法
	 */
	public java.lang.Integer getRateUsualSegment() {
		return rateUsualSegment;
	}
	/**
	 * 属性费率段位/费率段位的setter方法
	 */
	public void setRateUsualSegment(java.lang.Integer rateUsualSegment) {
		this.rateUsualSegment = rateUsualSegment;
	} 	
	/**
	 * 属性关联因子/关联因子的getter方法
	 */
	public String getRelationFactor() {
		return relationFactor;
	}
	/**
	 * 属性关联因子/关联因子的setter方法
	 */
	public void setRelationFactor(String relationFactor) {
		this.relationFactor = relationFactor;
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
		
		
		
		
}