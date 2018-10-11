package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 参数定义表实体操作对象
 */
@Entity
@Table(name = "UtiParam")
@IdClass(UtiParamKey.class)
public class UtiParam extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性参数名/参数名 */
        @Id
        @Column(name = "paramCode")
	private String paramCode ;	

	/** 属性参数描述/参数描述 */
	private String paramDesc ;
	/** 属性参数类型/参数类型 */
	private String paramType ;
	/** 属性是否允许修改/是否允许修改 */
	private String modifyFlag ;
	/** 属性是否有效/是否有效 */
	private String validStatus ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性标志/标志 */
	private String flag ;




	/**
	 * 属性参数名/参数名的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性参数名/参数名的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 	
	/**
	 * 属性参数描述/参数描述的getter方法
	 */
	public String getParamDesc() {
		return paramDesc;
	}
	/**
	 * 属性参数描述/参数描述的setter方法
	 */
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	} 	
	/**
	 * 属性参数类型/参数类型的getter方法
	 */
	public String getParamType() {
		return paramType;
	}
	/**
	 * 属性参数类型/参数类型的setter方法
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	} 	
	/**
	 * 属性是否允许修改/是否允许修改的getter方法
	 */
	public String getModifyFlag() {
		return modifyFlag;
	}
	/**
	 * 属性是否允许修改/是否允许修改的setter方法
	 */
	public void setModifyFlag(String modifyFlag) {
		this.modifyFlag = modifyFlag;
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
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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