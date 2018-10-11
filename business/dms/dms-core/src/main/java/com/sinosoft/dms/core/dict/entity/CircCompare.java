package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 批改类型实体操作对象
 */
@Entity
@Table(name = "CircCompare")
@IdClass(CircCompareKey.class)
public class CircCompare extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批改类型代码/批改类型代码 */
	@Id
	@Column(name = "codeType")
	private String codeType ;/** 属性业务操作代码/业务操作代码 */
	@Id
	@Column(name = "businessCode")
	private String businessCode ;/** 属性circCode/circCode */
	@Id
	@Column(name = "circCode")
	private String circCode ;	


	/** 属性业务名称/业务名称 */
	@Column(name = "businessName")
	private String businessName ;

	/** 属性circName/circName */
	@Column(name = "circName")
	private String circName ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性批改类型代码/批改类型代码的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性批改类型代码/批改类型代码的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 	
	/**
	 * 属性业务操作代码/业务操作代码的getter方法
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 属性业务操作代码/业务操作代码的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	} 	
	/**
	 * 属性业务名称/业务名称的getter方法
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * 属性业务名称/业务名称的setter方法
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	} 	
	/**
	 * 属性circCode/circCode的getter方法
	 */
	public String getCircCode() {
		return circCode;
	}
	/**
	 * 属性circCode/circCode的setter方法
	 */
	public void setCircCode(String circCode) {
		this.circCode = circCode;
	} 	
	/**
	 * 属性circName/circName的getter方法
	 */
	public String getCircName() {
		return circName;
	}
	/**
	 * 属性circName/circName的setter方法
	 */
	public void setCircName(String circName) {
		this.circName = circName;
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