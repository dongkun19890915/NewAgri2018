package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiPlatConfigApi操作对象
 */
public class UtiPlatConfigDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性systemCode/systemCode */
	private String systemCode ;		
	/** 属性paramCode/paramCode */
	private String paramCode ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性systemCode/systemCode的getter方法
	 */
	public String getSystemCode() {
		return systemCode;
	}
	/**
	 * 属性systemCode/systemCode的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}	
	/**
	 * 属性paramCode/paramCode的getter方法
	 */
	public String getParamCode() {
		return paramCode;
	}
	/**
	 * 属性paramCode/paramCode的setter方法
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
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
