package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 岗位功能权限表Api操作对象
 */
public class UtiGradeTaskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;		
	/** 属性功能代码/功能代码 */
	private String taskCode ;		
	/** 属性权限值/权限值 */
	private String value ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
			
			
			
			
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
	/**
	 * 属性权限值/权限值的getter方法
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 属性权限值/权限值的setter方法
	 */
	public void setValue(String value) {
		this.value = value;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
		
		
		
		
}
