package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * 条款公式配置表 Api操作对象
 */
public class PrpLConfigurationDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;


	private int pageNo;
	private int pageSize;
	/** 属性序号，唯一标识/序号，唯一标识 */
	private String id ;		
	/** 属性险种/险种 */
	private String classCode ;		
	/** 属性险类/险类 */
	private String riskCode ;		
	/** 属性条款编号/条款编号 */
	private String clauseNumber ;		
	/** 属性赔款公式文字描述/赔款公式文字描述 */
	private String formulaDescribing ;		
	/** 属性计算公式/计算公式 */
	private String formula ;		
	/** 属性备用字段1/备用字段1 */
	private String reserve1 ;		
	/** 属性备用字段2/备用字段2 */
	private String reserve2 ;
	/** 属性备用字段3/备用字段3 */
	private String reserve3 ;		
	/** 属性备用字段4/备用字段4 */
	private String reserve4 ;		
	/** 属性备用字段5/备用字段5 */
	private String reserve5 ;		
	/** 属性备用字段6/备用字段6 */
	private String reserve6 ;		
	/** 属性备用字段7/备用字段7 */
	private String reserve7 ;
	/** 险别代码/险别代码 */
	private String kindCode ;
	/** 标的代码 */
	private String itemCode ;
	/** 计算方式标识 */
	private String calculationMethod ;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int  getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 属性序号，唯一标识/序号，唯一标识的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性序号，唯一标识/序号，唯一标识的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性条款编号/条款编号的getter方法
	 */
	public String getClauseNumber() {
		return clauseNumber;
	}
	/**
	 * 属性条款编号/条款编号的setter方法
	 */
	public void setClauseNumber(String clauseNumber) {
		this.clauseNumber = clauseNumber;
	}	
	/**
	 * 属性赔款公式文字描述/赔款公式文字描述的getter方法
	 */
	public String getFormulaDescribing() {
		return formulaDescribing;
	}
	/**
	 * 属性赔款公式文字描述/赔款公式文字描述的setter方法
	 */
	public void setFormulaDescribing(String formulaDescribing) {
		this.formulaDescribing = formulaDescribing;
	}	
	/**
	 * 属性计算公式/计算公式的getter方法
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * 属性计算公式/计算公式的setter方法
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}	
	/**
	 * 属性备用字段1/备用字段1的getter方法
	 */
	public String getReserve1() {
		return reserve1;
	}
	/**
	 * 属性备用字段1/备用字段1的setter方法
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}	
	/**
	 * 属性备用字段3/备用字段3的getter方法
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * 属性备用字段3/备用字段3的setter方法
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}	
	/**
	 * 属性备用字段4/备用字段4的getter方法
	 */
	public String getReserve4() {
		return reserve4;
	}
	/**
	 * 属性备用字段4/备用字段4的setter方法
	 */
	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}	
	/**
	 * 属性备用字段5/备用字段5的getter方法
	 */
	public String getReserve5() {
		return reserve5;
	}
	/**
	 * 属性备用字段5/备用字段5的setter方法
	 */
	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	}	
	/**
	 * 属性备用字段6/备用字段6的getter方法
	 */
	public String getReserve6() {
		return reserve6;
	}
	/**
	 * 属性备用字段6/备用字段6的setter方法
	 */
	public void setReserve6(String reserve6) {
		this.reserve6 = reserve6;
	}	
	/**
	 * 属性备用字段7/备用字段7的getter方法
	 */
	public String getReserve7() {
		return reserve7;
	}
	/**
	 * 属性备用字段7/备用字段7的setter方法
	 */
	public void setReserve7(String reserve7) {
		this.reserve7 = reserve7;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCalculationMethod() {
		return calculationMethod;
	}

	public void setCalculationMethod(String calculationMethod) {
		this.calculationMethod = calculationMethod;
	}
}
