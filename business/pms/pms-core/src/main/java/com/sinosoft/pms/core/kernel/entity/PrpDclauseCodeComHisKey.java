package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款机构配置轨迹表主键操作对象
 */
public class  PrpDclauseCodeComHisKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public  PrpDclauseCodeComHisKey(){}
	public  PrpDclauseCodeComHisKey(String clauseCode,String comCode,java.lang.Double indexNo){
		this.clauseCode = clauseCode;
		this.comCode = comCode;
		this.indexNo = indexNo;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "ClauseCode")
	private String clauseCode ;
	/** 属性机构代码/机构代码 */
	@Column(name = "ComCode")
	private String comCode ;
	/** 属性修改序号/修改序号 */
	@Column(name = "IndexNo")
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
	 * 属性修改序号/修改序号的getter方法
	 */
	public java.lang.Double getIndexNo() {
    		return indexNo;
	}
	/**
	 * 属性修改序号/修改序号的setter方法
	 */
	public void setIndexNo(java.lang.Double indexNo) {
		this.indexNo = indexNo;
	} 
}