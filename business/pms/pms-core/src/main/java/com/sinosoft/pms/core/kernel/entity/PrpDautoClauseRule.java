package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:37.662 
 * 自动生成特约校验规则表实体操作对象
 */
@Entity
@Table(name = "PrpDautoClause_Rule")
@IdClass(PrpDautoClauseRuleKey.class)
public class PrpDautoClauseRule extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性机构代码/机构代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性险种代码/险种代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性特约代码/特约代码 */
        @Id
        @Column(name = "clauseCode")
	private String clauseCode ;/** 属性分组号/分组号 */
        @Id
        @Column(name = "groupNo")
	private String groupNo ;/** 属性顺序号/顺序号 */
        @Id
        @Column(name = "serialNo")
	private String serialNo ;	





	/** 属性校验模块/校验模块 */
	private String module ;
	/** 属性校验属性/校验属性 */
	private String property ;
	/** 属性属性类型/属性类型 */
	private String propertyType ;
	/** 属性校验类型/校验类型 */
	private String checkType ;
	/** 属性校验值/校验值 */
	private String checkValue ;
	/** 属性另一校验模块/另一校验模块 */
	private String checkModule ;
	/** 属性另一校验属性/另一校验属性 */
	private String checkProperty ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性有效标识/有效标识 */
	private String validStatus ;
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	 * 属性特约代码/特约代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性特约代码/特约代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
	/**
	 * 属性分组号/分组号的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性分组号/分组号的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	} 
	/**
	 * 属性顺序号/顺序号的getter方法
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性顺序号/顺序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性校验模块/校验模块的getter方法
	 */
	public String getModule() {
		return module;
	}
	/**
	 * 属性校验模块/校验模块的setter方法
	 */
	public void setModule(String module) {
		this.module = module;
	} 
	/**
	 * 属性校验属性/校验属性的getter方法
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * 属性校验属性/校验属性的setter方法
	 */
	public void setProperty(String property) {
		this.property = property;
	} 
	/**
	 * 属性属性类型/属性类型的getter方法
	 */
	public String getPropertyType() {
		return propertyType;
	}
	/**
	 * 属性属性类型/属性类型的setter方法
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	} 
	/**
	 * 属性校验类型/校验类型的getter方法
	 */
	public String getCheckType() {
		return checkType;
	}
	/**
	 * 属性校验类型/校验类型的setter方法
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	} 
	/**
	 * 属性校验值/校验值的getter方法
	 */
	public String getCheckValue() {
		return checkValue;
	}
	/**
	 * 属性校验值/校验值的setter方法
	 */
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	} 
	/**
	 * 属性另一校验模块/另一校验模块的getter方法
	 */
	public String getCheckModule() {
		return checkModule;
	}
	/**
	 * 属性另一校验模块/另一校验模块的setter方法
	 */
	public void setCheckModule(String checkModule) {
		this.checkModule = checkModule;
	} 
	/**
	 * 属性另一校验属性/另一校验属性的getter方法
	 */
	public String getCheckProperty() {
		return checkProperty;
	}
	/**
	 * 属性另一校验属性/另一校验属性的setter方法
	 */
	public void setCheckProperty(String checkProperty) {
		this.checkProperty = checkProperty;
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
	 * 属性有效标识/有效标识的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效标识/有效标识的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
}