package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * 条款与保险责任关联表实体操作对象
 */
@Entity
@Table(name = "PrpDrelationClauseCode")
@IdClass(PrpDrelationClauseCodeKey.class)
public class PrpDrelationClauseCode extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;/** 属性保险责任代码/保险责任代码 */
	@Id
	@Column(name = "insuranceCode")
	private String insuranceCode ;	


	/** 属性备用标识/备用标识 */
	@Column(name = "flag")
	private String flag ;
	/** 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效 */
	@Column(name = "validStatus")
	private String validStatus ;
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 	
	/**
	 * 属性保险责任代码/保险责任代码的getter方法
	 */
	public String getInsuranceCode() {
		return insuranceCode;
	}
	/**
	 * 属性保险责任代码/保险责任代码的setter方法
	 */
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	} 	
	/**
	 * 属性备用标识/备用标识的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用标识/备用标识的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
}