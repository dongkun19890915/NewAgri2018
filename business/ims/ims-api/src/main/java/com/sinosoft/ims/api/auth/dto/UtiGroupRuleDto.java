package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiGroupRuleApi操作对象
 */
public class UtiGroupRuleDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性groupCode/groupCode */
	private String groupCode ;		
	/** 属性serialNo/serialNo */
	private Integer serialNo ;
	/** 属性rule/rule */
	private String rule ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性groupCode/groupCode的getter方法
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * 属性groupCode/groupCode的setter方法
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}	
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性rule/rule的getter方法
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 属性rule/rule的setter方法
	 */
	public void setRule(String rule) {
		this.rule = rule;
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
