package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUserLogin主键操作对象
 */
public class UtiUserLoginKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUserLoginKey(){}
	public UtiUserLoginKey(String userCode){
		this.userCode = userCode;
	}
	/** 属性userCode/userCode */
	@Column(name = "userCode")
	private String userCode ;
	/**
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
    		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
}