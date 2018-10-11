package com.sinosoft.dms.api.model.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板机构配置表Api操作对象
 */
public class PrpMmodelComDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板代码/模板代码 */
	private String modelCode ;		
	/** 属性机构代码/机构代码 */
	private String comCode ;		
	/** 属性有效标识位0-无效；1-有效/有效标识位0-无效；1-有效 */
	private String flag ;		
	/** 属性机构名称/机构名称 */
	private String comName ;		
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
	 * 属性有效标识位0-无效；1-有效/有效标识位0-无效；1-有效的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性有效标识位0-无效；1-有效/有效标识位0-无效；1-有效的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性机构名称/机构名称的getter方法
	 */
	public String getComName() {
		return comName;
	}
	/**
	 * 属性机构名称/机构名称的setter方法
	 */
	public void setComName(String comName) {
		this.comName = comName;
	}	
}
