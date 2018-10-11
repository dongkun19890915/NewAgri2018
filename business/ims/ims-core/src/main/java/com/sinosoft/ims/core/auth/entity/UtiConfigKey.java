package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiConfig主键操作对象
 */
public class UtiConfigKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiConfigKey(){}
	public UtiConfigKey(String configCode){
		this.configCode = configCode;
	}
	/** 属性configCode/configCode */
	@Column(name = "configCode")
	private String configCode ;
	/**
	 * 属性configCode/configCode的getter方法
	 */
	public String getConfigCode() {
    		return configCode;
	}
	/**
	 * 属性configCode/configCode的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	} 
}