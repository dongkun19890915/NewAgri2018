package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 员工代码表主键操作对象
 */
public class PrpDuserKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDuserKey(){}
	public PrpDuserKey(String userCode){
		this.userCode = userCode;
	}
	/** 属性员工代码/员工代码 */
	@Column(name = "userCode")
	private String userCode ;
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode() {
    		return userCode;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
}