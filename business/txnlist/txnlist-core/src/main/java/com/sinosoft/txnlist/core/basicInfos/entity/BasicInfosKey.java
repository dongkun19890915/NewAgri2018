package com.sinosoft.txnlist.core.basicInfos.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 12:58:53.230 
 * basicInfos主键操作对象
 */
public class BasicInfosKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public BasicInfosKey(){}
	public BasicInfosKey(String code){
		this.code = code;
	}
	/** 属性农户代码/农户代码 */
	@Column(name = "code")
	private String code ;
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getCode() {
    		return code;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setCode(String code) {
		this.code = code;
	} 
}