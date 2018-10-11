package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:59.683 
 * 自动生成特约主表日志表主键操作对象
 */
public class PrpDautoClauseLogKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDautoClauseLogKey(){}
	public PrpDautoClauseLogKey(String uUID){
		this.uUID = uUID;
	}
	/** 属性UUID/ */
	private String uUID ;
	/**
	 * 属性UUID/的getter方法
	 */
	public String getUUID() {
    		return uUID;
	}
	/**
	 * 属性UUID/的setter方法
	 */
	public void setUUID(String uUID) {
		this.uUID = uUID;
	} 
}