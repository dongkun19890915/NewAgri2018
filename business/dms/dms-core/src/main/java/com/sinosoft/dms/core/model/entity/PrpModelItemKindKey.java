package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-16 01:04:20.471 
 * 标的子险信息主键操作对象
 */
public class PrpModelItemKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelItemKindKey(){}
	public PrpModelItemKindKey(String modelCode,Integer itemKindNo){
		this.modelCode = modelCode;
		this.itemKindNo = itemKindNo;
	}
	/** 属性模板代码/模板代码 */
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性标的序号1/标的序号1 */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
	/**
	 * 属性模板代码/模板代码的getter方法
	 */
	public String getModelCode() {
    		return modelCode;
	}
	/**
	 * 属性模板代码/模板代码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	} 
	/**
	 * 属性标的序号1/标的序号1的getter方法
	 */
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性标的序号1/标的序号1的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
}