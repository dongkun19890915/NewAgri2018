package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * 系统定义表实体操作对象
 */
@Entity
@Table(name = "UtiSystem")
@IdClass(UtiSystemKey.class)
public class UtiSystem extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性系统代码/系统代码 */
        @Id
        @Column(name = "systemCode")
	private String systemCode ;	

	/** 属性系统名称/系统名称 */
	@Column(name = "systemName")
	private String systemName ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性系统代码/系统代码的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性系统代码/系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	} 
	/**
	 * 属性系统名称/系统名称的getter方法
	 */
	public String getSystemName() {
		return systemName;
	}
	/**
	 * 属性系统名称/系统名称的setter方法
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
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