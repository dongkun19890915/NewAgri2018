package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔节点状态表主键操作对象
 */
public class PrpLclaimStatusKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLclaimStatusKey(){}
	public PrpLclaimStatusKey(String businessno,String nodetype,java.lang.Integer serialno){
		this.businessno = businessno;
		this.nodetype = nodetype;
		this.serialno = serialno;
	}
	/** 属性业务号/业务号 */
	@Column(name = "businessno")
	private String businessno ;
	/** 属性节点种类/节点种类 */
	@Column(name = "nodetype")
	private String nodetype ;
	/** 属性序列号码/序列号码 */
	@Column(name = "serialno")
	private java.lang.Integer serialno ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessno() {
    		return businessno;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	} 
	/**
	 * 属性节点种类/节点种类的getter方法
	 */
	public String getNodetype() {
    		return nodetype;
	}
	/**
	 * 属性节点种类/节点种类的setter方法
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	} 
	/**
	 * 属性序列号码/序列号码的getter方法
	 */
	public java.lang.Integer getSerialno() {
    		return serialno;
	}
	/**
	 * 属性序列号码/序列号码的setter方法
	 */
	public void setSerialno(java.lang.Integer serialno) {
		this.serialno = serialno;
	} 
}