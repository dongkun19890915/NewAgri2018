package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 机构员工岗位差异功能权限表主键操作对象
 */
public class UtiUserGradeTaskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiUserGradeTaskKey(){}
	public UtiUserGradeTaskKey(String comCode,String userCode,String gradeCode,String taskCode){
		this.comCode = comCode;
		this.userCode = userCode;
		this.gradeCode = gradeCode;
		this.taskCode = taskCode;
	}
	/** 属性归属机构代码/归属机构代码 */
	private String comCode ;
	/** 属性员工代码/员工代码 */
	private String userCode ;
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;
	/** 属性功能代码/功能代码 */
	private String taskCode ;
	/**
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
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