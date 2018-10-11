package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板配置主表主键操作对象
 */
public class PrpMmodelMainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpMmodelMainKey(){}
	public PrpMmodelMainKey(String modelCode){
		this.modelCode = modelCode;
	}
	/** 属性模板代码/模板代码 */
	@Column(name = "modelCode")
	private String modelCode ;
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
}