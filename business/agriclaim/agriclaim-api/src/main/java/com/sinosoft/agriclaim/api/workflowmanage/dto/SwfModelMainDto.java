package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BasePageableRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 模板主表Api操作对象
 */
public class SwfModelMainDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板编号/模板编号 */
	private java.lang.Integer modelNo ;		
	/** 属性模板名称/模板名称 */
	private String modelName ;		
	/** 属性创建人代码/创建人代码 */
	private String authorCode ;		
	/** 属性使用范围/使用范围 */
	private String rightId ;		
	/** 属性创建日期/创建日期 */
	private java.util.Date createDate ;		
	/** 属性最近一次修改日期/最近一次修改日期 */
	private java.util.Date modifyDate ;		
	/** 属性模板类型/模板类型 */
	private String modelType ;		
	/** 属性模板业务属性/模板业务属性 */
	private String modelAttr ;		
	/** 属性模板状态/模板状态 */
	private String modelStatus ;		
	/** 属性定义如果整个流程都结束所需要调用的服务 /定义如果整个流程都结束所需要调用的服务  */
	private String closeService ;		
	/** 属性定义如果流程原本是结束的，重新流转所需要调用的业务服务/定义如果流程原本是结束的，重新流转所需要调用的业务服务 */
	private String activeService ;		
	/** 属性标志/标志 */
	private String flag ;
	/** 创建人名称 add by wxy 2018/4/8 */
	private String authorName;
			
	/**
	 * 属性模板编号/模板编号的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性模板编号/模板编号的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	}	
	/**
	 * 属性模板名称/模板名称的getter方法
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 属性模板名称/模板名称的setter方法
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}	
	/**
	 * 属性创建人代码/创建人代码的getter方法
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * 属性创建人代码/创建人代码的setter方法
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}	
	/**
	 * 属性使用范围/使用范围的getter方法
	 */
	public String getRightId() {
		return rightId;
	}
	/**
	 * 属性使用范围/使用范围的setter方法
	 */
	public void setRightId(String rightId) {
		this.rightId = rightId;
	}	
	/**
	 * 属性创建日期/创建日期的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性创建日期/创建日期的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}	
	/**
	 * 属性最近一次修改日期/最近一次修改日期的getter方法
	 */
	public java.util.Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * 属性最近一次修改日期/最近一次修改日期的setter方法
	 */
	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}	
	/**
	 * 属性模板类型/模板类型的getter方法
	 */
	public String getModelType() {
		return modelType;
	}
	/**
	 * 属性模板类型/模板类型的setter方法
	 */
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}	
	/**
	 * 属性模板业务属性/模板业务属性的getter方法
	 */
	public String getModelAttr() {
		return modelAttr;
	}
	/**
	 * 属性模板业务属性/模板业务属性的setter方法
	 */
	public void setModelAttr(String modelAttr) {
		this.modelAttr = modelAttr;
	}	
	/**
	 * 属性模板状态/模板状态的getter方法
	 */
	public String getModelStatus() {
		return modelStatus;
	}
	/**
	 * 属性模板状态/模板状态的setter方法
	 */
	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	}	
	/**
	 * 属性定义如果整个流程都结束所需要调用的服务 /定义如果整个流程都结束所需要调用的服务 的getter方法
	 */
	public String getCloseService() {
		return closeService;
	}
	/**
	 * 属性定义如果整个流程都结束所需要调用的服务 /定义如果整个流程都结束所需要调用的服务 的setter方法
	 */
	public void setCloseService(String closeService) {
		this.closeService = closeService;
	}	
	/**
	 * 属性定义如果流程原本是结束的，重新流转所需要调用的业务服务/定义如果流程原本是结束的，重新流转所需要调用的业务服务的getter方法
	 */
	public String getActiveService() {
		return activeService;
	}
	/**
	 * 属性定义如果流程原本是结束的，重新流转所需要调用的业务服务/定义如果流程原本是结束的，重新流转所需要调用的业务服务的setter方法
	 */
	public void setActiveService(String activeService) {
		this.activeService = activeService;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
