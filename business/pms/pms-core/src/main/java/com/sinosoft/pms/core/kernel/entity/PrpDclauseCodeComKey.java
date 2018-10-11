package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款机构配置表主键操作对象
 */
public class  PrpDclauseCodeComKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public  PrpDclauseCodeComKey(){}
	public  PrpDclauseCodeComKey(String clauseCode,String comCode,String comName){
		this.clauseCode = clauseCode;
		this.comCode = comCode;
//		this.comName = comName;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "ClauseCode")
	private String clauseCode ;
	/** 属性机构代码/机构代码 */
	@Column(name = "ComCode")
	private String comCode ;
	/** 属性机构名称/机构名称 */
//	@Column(name = "ComName")
//	private String comName ;
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
//	/**
//	 * 属性机构名称/机构名称的getter方法
//	 */
//	public String getComName() {
//    		return comName;
//	}
//	/**
//	 * 属性机构名称/机构名称的setter方法
//	 */
//	public void setComName(String comName) {
//		this.comName = comName;
//	}
}