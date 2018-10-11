package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 任务定义表主键操作对象
 */
public class UtiTaskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiTaskKey(){}
	public UtiTaskKey(String taskCode){
		this.taskCode = taskCode;
	}
	/** 属性功能代码/功能代码 */
	private String taskCode ;
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