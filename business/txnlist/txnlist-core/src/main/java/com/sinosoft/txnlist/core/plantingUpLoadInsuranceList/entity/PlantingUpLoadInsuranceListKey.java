package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * plantingUpLoadInsuranceList主键操作对象
 */
public class PlantingUpLoadInsuranceListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingUpLoadInsuranceListKey(){}
	public PlantingUpLoadInsuranceListKey(String inusreListCode){
		this.inusreListCode = inusreListCode;
	}
	public PlantingUpLoadInsuranceListKey(String inusreListCode,String fCode){
		this.inusreListCode = inusreListCode;
		this.fCode = fCode;
	}
	/** 属性临时标识/临时标识 */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/**
	 * 属性临时标识/临时标识的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性临时标识/临时标识的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
}