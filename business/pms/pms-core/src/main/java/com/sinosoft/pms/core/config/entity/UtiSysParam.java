package com.sinosoft.pms.core.config.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:26:56.234 
 * 系统参数关联表实体操作对象
 */
@Entity
@Table(name = "UtiSysParam")
@IdClass(UtiSysParamKey.class)
public class UtiSysParam extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性系统编码/系统编码 */
        @Id
        @Column(name = "systemCode")
	private String systemCode ;/** 属性系统参数值/系统参数值 */
        @Id
        @Column(name = "paramCode")
	private String paramCode ;	


	/** 属性摘要/摘要 */
	private String remark ;
	/** 属性标志/标志 */
	private String flag ;
	/**
	 * 属性系统编码/系统编码的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统编码/系统编码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 	
	/**
	 * 属性系统参数值/系统参数值的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性系统参数值/系统参数值的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	} 	
	/**
	 * 属性摘要/摘要的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性摘要/摘要的setter方法
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