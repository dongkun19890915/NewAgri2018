package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 岗位功能权限表主键操作对象
 */
public class UtiGradeTaskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiGradeTaskKey(){}
	public UtiGradeTaskKey(String gradeCode,String taskCode){
		this.gradeCode = gradeCode;
		this.taskCode = taskCode;
	}
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;
	/** 属性功能代码/功能代码 */
	private String taskCode ;
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
	/**
	 * 属性功能代码/功能代码的getter方法
	 */
	public String getTaskCode() {
    		return taskCode;
	}
	/**
	 * 属性功能代码/功能代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	} 
}