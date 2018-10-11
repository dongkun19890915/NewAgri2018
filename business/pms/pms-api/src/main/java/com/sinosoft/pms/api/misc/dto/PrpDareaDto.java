package com.sinosoft.pms.api.misc.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 区域表Api操作对象
 */
public class PrpDareaDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务代码/业务代码 */
	private String codeCode ;		
	/** 属性区域代码类型/区域代码类型 */
	private String codeType ;		
	/** 属性区域代码/区域代码 */
	private String areaCode ;		
	/** 属性区域名称/区域名称 */
	private String areaCName ;		
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;		
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;		
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;		
			
			
	/** 属性更新人/更新人 */
	private String upDatedBy ;		
	/** 属性更新时间/更新时间 */
	private java.util.Date upDatedTime ;		
	/**
	 * 属性业务代码/业务代码的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性业务代码/业务代码的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}	
	/**
	 * 属性区域代码类型/区域代码类型的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性区域代码类型/区域代码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}	
	/**
	 * 属性区域代码/区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性区域代码/区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性区域名称/区域名称的getter方法
	 */
	public String getAreaCName() {
		return areaCName;
	}
	/**
	 * 属性区域名称/区域名称的setter方法
	 */
	public void setAreaCName(String areaCName) {
		this.areaCName = areaCName;
	}	
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	}	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	}	
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
	}	
		
		
	/**
	 * 属性更新人/更新人的getter方法
	 */
	public String getUpDatedBy() {
		return upDatedBy;
	}
	/**
	 * 属性更新人/更新人的setter方法
	 */
	public void setUpDatedBy(String upDatedBy) {
		this.upDatedBy = upDatedBy;
	}	
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpDatedTime() {
		return upDatedTime;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpDatedTime(java.util.Date upDatedTime) {
		this.upDatedTime = upDatedTime;
	}	
}
