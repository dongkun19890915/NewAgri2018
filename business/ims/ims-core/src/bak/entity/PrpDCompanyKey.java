package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 机构代码-PrpDCompany 主键操作类
 */
public class PrpDCompanyKey extends BasePKImpl implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性机构代码/ */
	@Id
	@Column(name = "comCode")
	private String comCode ;
	/**
	 * 属性机构代码/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
}