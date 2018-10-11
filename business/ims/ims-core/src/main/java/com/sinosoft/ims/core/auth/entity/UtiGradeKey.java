package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 岗位定义表主键操作对象
 */
public class UtiGradeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiGradeKey(){}
	public UtiGradeKey(String gradeCode){
		this.gradeCode = gradeCode;
	}
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;
	/**
	 * 属性岗位代码/岗位代码的getter方法
	 */
	public String getGradeCode() {
    		return gradeCode;
	}
	/**
	 * 属性岗位代码/岗位代码的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	} 
}