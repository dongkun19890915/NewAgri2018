package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiParam主键操作对象
 */
public class UtiParamKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiParamKey(){}
	public UtiParamKey(String paramCode){
		this.paramCode = paramCode;
	}
	/** 属性paramCode/paramCode */
	@Column(name = "paramCode")
	private String paramCode ;
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
}