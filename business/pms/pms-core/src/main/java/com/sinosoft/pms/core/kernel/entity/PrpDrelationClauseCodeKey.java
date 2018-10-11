package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * 条款与保险责任关联表主键操作对象
 */
public class PrpDrelationClauseCodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDrelationClauseCodeKey(){}
	public PrpDrelationClauseCodeKey(String clauseCode,String insuranceCode){
		this.clauseCode = clauseCode;
		this.insuranceCode = insuranceCode;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/** 属性保险责任代码/保险责任代码 */
	@Column(name = "insuranceCode")
	private String insuranceCode ;
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
}