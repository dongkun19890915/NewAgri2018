package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款配置轨迹表主表主键操作对象
 */
public class  PrpDclauseCodeHisKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public  PrpDclauseCodeHisKey(){}
	public  PrpDclauseCodeHisKey(String clauseCode,java.lang.Double indexNo){
		this.clauseCode = clauseCode;
		this.indexNo = indexNo;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "ClauseCode")
	private String clauseCode ;
	/** 属性修改次数/修改次数 */
	@Column(name = "indexNo")
	private java.lang.Double indexNo ;
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
	 * 属性修改次数/修改次数的getter方法
	 */
	public java.lang.Double getIndexNo() {
    		return indexNo;
	}
	/**
	 * 属性修改次数/修改次数的setter方法
	 */
	public void setIndexNo(java.lang.Double indexNo) {
		this.indexNo = indexNo;
	} 
}