package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiParam实体操作对象
 */
@Entity
@Table(name = "UtiParam")
@IdClass(UtiParamKey.class)
public class UtiParam extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性paramCode/paramCode */
	@Id
	@Column(name = "paramCode")
	private String paramCode ;	

	/** 属性paramDesc/paramDesc */
	@Column(name = "paramDesc")
	private String paramDesc ;
	/** 属性paramType/paramType */
	@Column(name = "paramType")
	private String paramType ;
	/** 属性modifyFlag/modifyFlag */
	@Column(name = "modifyFlag")
	private String modifyFlag ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 	
	/**
	 * 属性paramDesc/paramDesc的getter方法
	 */
	public String getParamDesc() {
		return paramDesc;
	}
	/**
	 * 属性paramDesc/paramDesc的setter方法
	 */
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	} 	
	/**
	 * 属性paramType/paramType的getter方法
	 */
	public String getParamType() {
		return paramType;
	}
	/**
	 * 属性paramType/paramType的setter方法
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	} 	
	/**
	 * 属性modifyFlag/modifyFlag的getter方法
	 */
	public String getModifyFlag() {
		return modifyFlag;
	}
	/**
	 * 属性modifyFlag/modifyFlag的setter方法
	 */
	public void setModifyFlag(String modifyFlag) {
		this.modifyFlag = modifyFlag;
	} 	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}