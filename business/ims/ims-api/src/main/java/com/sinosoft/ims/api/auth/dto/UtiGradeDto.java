package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 岗位定义表Api操作对象
 */
public class UtiGradeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;		
	/** 属性岗位名称/岗位名称 */
	private String gradeName ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性岗位级别/岗位级别 */
	private String gradeLevel ;		
			
			
			
			
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
	 * 属性岗位名称/岗位名称的getter方法
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * 属性岗位名称/岗位名称的setter方法
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
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
	/**
	 * 属性岗位级别/岗位级别的getter方法
	 */
	public String getGradeLevel() {
		return gradeLevel;
	}
	/**
	 * 属性岗位级别/岗位级别的setter方法
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}	
		
		
		
		
}
