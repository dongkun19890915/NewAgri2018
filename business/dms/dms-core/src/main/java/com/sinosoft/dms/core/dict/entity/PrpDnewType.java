package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码类表实体操作对象
 */
@Entity
@Table(name = "PrpDnewType")
@IdClass(PrpDnewTypeKey.class)
public class PrpDnewType extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;
	/** 属性代码类型/代码类型 */
        @Id
        @Column(name = "codeType")
	private String codeType ;	

	/** 属性代码类型描述/代码类型描述 */
	private String codeTypeDesc ;
	/** 属性新的代码类型/新的代码类型 */
	private String newCodeType ;
	/** 属性是否有效/是否有效 */
	private String validStatus ;
	/** 属性标志/标志 */
	private String flag ;

	/**
	 * 属性代码类型/代码类型的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型/代码类型的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 
	/**
	 * 属性代码类型描述/代码类型描述的getter方法
	 */
	public String getCodeTypeDesc() {
		return codeTypeDesc;
	}
	/**
	 * 属性代码类型描述/代码类型描述的setter方法
	 */
	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
	} 
	/**
	 * 属性新的代码类型/新的代码类型的getter方法
	 */
	public String getNewCodeType() {
		return newCodeType;
	}
	/**
	 * 属性新的代码类型/新的代码类型的setter方法
	 */
	public void setNewCodeType(String newCodeType) {
		this.newCodeType = newCodeType;
	} 
	/**
	 * 属性是否有效/是否有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性是否有效/是否有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 

}