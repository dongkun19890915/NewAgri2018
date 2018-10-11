package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案信息表主键操作对象
 */
public class PrpLRegistKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRegistKey(){}
	public PrpLRegistKey(String registNo){
		this.registNo = registNo;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
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