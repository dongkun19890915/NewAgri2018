package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiMenuTaskApi操作对象
 */
public class UtiMenuTaskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性menuId/menuId */
	private String menuId ;		
	/** 属性taskCode/taskCode */
	private String taskCode ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性menuId/menuId的getter方法
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 属性menuId/menuId的setter方法
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}	
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
