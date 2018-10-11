package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 险类代码表主键操作对象
 */
public class PrpDclassKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclassKey(){}
	public PrpDclassKey(String classCode){
		this.classCode = classCode;
	}
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
    		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 
}