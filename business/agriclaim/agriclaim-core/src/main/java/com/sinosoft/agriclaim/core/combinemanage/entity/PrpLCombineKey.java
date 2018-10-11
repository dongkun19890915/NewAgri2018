package com.sinosoft.agriclaim.core.combinemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 并案关联表主键操作对象
 */
public class PrpLCombineKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCombineKey(){}
	public PrpLCombineKey(String registNo){
		this.registNo = registNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "RegistNo")
	private String registNo ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
}