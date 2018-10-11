package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BaseDto;

public class SaaUserPermitCompanyDto extends BaseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性Id/Id */
	private String id ;
	/** 属性PowerId/数据权限Id */
	private String powerId ;
	/** 属性ComCode/允许机构 */
	private String comCode ;
	/** 属性IncludeSubCom/是否包含下属机构 */
	private String includeSubCom ;
	/** 属性Flag/标志字段 */
	private String flag ;
	/**
	 * 类SaaUserPermitCompany的默认构造方法
	 */
	public SaaUserPermitCompanyDto() {
	}
	/**
	 * 属性Id/Id的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性Id/Id的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	} 
	/**
	 * 属性PowerId/数据权限Id的getter方法
	 */
	public String getPowerId() {
		return powerId;
	}
	/**
	 * 属性PowerId/数据权限Id的setter方法
	 */
	public void setPowerId(String powerId) {
		this.powerId = powerId;
	} 
	/**
	 * 属性ComCode/允许机构的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性ComCode/允许机构的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性IncludeSubCom/是否包含下属机构的getter方法
	 */
	public String getIncludeSubCom() {
		return includeSubCom;
	}
	/**
	 * 属性IncludeSubCom/是否包含下属机构的setter方法
	 */
	public void setIncludeSubCom(String includeSubCom) {
		this.includeSubCom = includeSubCom;
	} 
	/**
	 * 属性Flag/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性Flag/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
}
