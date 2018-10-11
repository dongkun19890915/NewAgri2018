package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 账户表-UtiIAccount 主键操作类
 */
public class UtiIAccountKey extends BasePKImpl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性账号代码/ */
	@Id
	@Column(name = "accCode")
	private String accCode ;
	/**
	 * 属性账号代码/的getter方法
	 */
	public String getAccCode() {
		return accCode;
	}
	/**
	 * 属性账号代码/的setter方法
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	} 
}