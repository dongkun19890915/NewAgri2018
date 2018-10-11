package com.sinosoft.pms.core.misc.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 区域表实体操作对象
 */
@Entity
@Table(name = "PrpDarea")
@IdClass(PrpDareaKey.class)
public class PrpDarea extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务代码/业务代码 */
        @Id
        @Column(name = "codeCode")
	private String codeCode ;/** 属性区域代码类型/区域代码类型 */
        @Id
        @Column(name = "codeType")
	private String codeType ;/** 属性区域代码/区域代码 */
        @Id
        @Column(name = "areaCode")
	private String areaCode ;	



	/** 属性区域名称/区域名称 */
	private String areaCName ;
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;


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

}