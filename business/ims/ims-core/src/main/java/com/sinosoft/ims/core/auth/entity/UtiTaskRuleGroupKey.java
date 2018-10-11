package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiTaskRuleGroup主键操作对象
 */
public class UtiTaskRuleGroupKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public UtiTaskRuleGroupKey(){}
	public UtiTaskRuleGroupKey(String ruleGroupCode){
		this.ruleGroupCode = ruleGroupCode;
	}
	/** 属性ruleGroupCode/ruleGroupCode */
	@Column(name = "ruleGroupCode")
	private String ruleGroupCode ;
	/**
	 * 属性ruleGroupCode/ruleGroupCode的getter方法
	 */
	public String getRuleGroupCode() {
    		return ruleGroupCode;
	}
	/**
	 * 属性ruleGroupCode/ruleGroupCode的setter方法
	 */
	public void setRuleGroupCode(String ruleGroupCode) {
		this.ruleGroupCode = ruleGroupCode;
	} 
}