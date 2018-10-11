package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-16 01:04:20.471 
 * 模板农险标的附加表主键操作对象
 */
public class PrpModelItemKindAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpModelItemKindAgriKey(){}
	public PrpModelItemKindAgriKey(String modelCode,Integer itemKindNo,String kindCode,Integer times){
		this.modelCode = modelCode;
		this.itemKindNo = itemKindNo;
		this.kindCode=kindCode;
		this.times=times;
	}
	/** 属性模板代码/模板代码 */
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性标的序号/标的序号 */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
	/** 属性险别/险别 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性茬次/茬次 */
	@Column(name = "times")
	private Integer times=0 ;

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

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
	 * 属性标的序号/标的序号的getter方法
	 */
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
}