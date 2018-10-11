package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板机构配置表实体操作对象
 */
@Entity
@Table(name = "PrpMmodelCom")
@IdClass(PrpMmodelComKey.class)
public class PrpMmodelCom extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性模板代码/模板代码 */
	@Id
	@Column(name = "modelCode")
	private String modelCode ;/** 属性机构代码/机构代码 */
	@Id
	@Column(name = "comCode")
	private String comCode ;	


	/** 属性有效标识位0-无效；1-有效/有效标识位0-无效；1-有效 */
	@Column(name = "flag")
	private String flag ;
	/** 属性机构名称/机构名称 */
	@Column(name = "comName")
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