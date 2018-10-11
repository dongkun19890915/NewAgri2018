package com.sinosoft.agriclaim.api.businessutilmanage.dto;
/**
 * @description 额外查询条件属性类
 * @author 安齐崇
 * @date 2017年11月13日
 */
public class ConditionVo {
	/** 查询条件名称*/
	private String name;
	/** 查询条件对应的值*/
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
