package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiTaskApi操作对象
 */
public class UtiTaskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性taskCode/taskCode */
	private String taskCode ;		
	/** 属性parentCode/parentCode */
	private String parentCode ;		
	/** 属性taskName/taskName */
	private String taskName ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性taskCode/taskCode的getter方法
	 */
	public String getTaskCode() {
		return taskCode;
	}
	/**
	 * 属性taskCode/taskCode的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}	
	/**
	 * 属性parentCode/parentCode的getter方法
	 */
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * 属性parentCode/parentCode的setter方法
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}	
	/**
	 * 属性taskName/taskName的getter方法
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * 属性taskName/taskName的setter方法
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
