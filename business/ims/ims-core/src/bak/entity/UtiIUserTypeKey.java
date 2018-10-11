package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 用户分类与用户关系表-UtiIUserType 主键操作类
 */
public class UtiIUserTypeKey extends BasePKImpl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性用户分类/ */
	@Id
	@Column(name = "usertype")
	private String userType ;
	/** 属性用户代码/ */
	@Id
	@Column(name = "userCode")
	private String userCode ;
	/**
	 * 属性用户分类/的getter方法
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 属性用户分类/的setter方法
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	} 
	/**
	 * 属性用户代码/的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性用户代码/的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
}