package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:37:08.306 
 * 用户表附表主键操作对象
 */
public class PrpDuserSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDuserSubKey(){}
	public PrpDuserSubKey(String userCode){
		this.userCode = userCode;
	}
	/** 属性用户代码/用户代码 */
	private String userCode ;
	/**
	 * 属性用户代码/用户代码的getter方法
	 */
	public String getUserCode() {
    		return userCode;
	}
	/**
	 * 属性用户代码/用户代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
}