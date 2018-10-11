package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiTaskRuleGroup实体操作对象
 */
@Entity
@Table(name = "UtiTaskRuleGroup")
@IdClass(UtiTaskRuleGroupKey.class)
public class UtiTaskRuleGroup extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性ruleGroupCode/ruleGroupCode */
	@Id
	@Column(name = "ruleGroupCode")
	private String ruleGroupCode ;	

	/** 属性ruleGroupName/ruleGroupName */
	@Column(name = "ruleGroupName")
	private String ruleGroupName ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
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
	/**
	 * 属性ruleGroupName/ruleGroupName的getter方法
	 */
	public String getRuleGroupName() {
		return ruleGroupName;
	}
	/**
	 * 属性ruleGroupName/ruleGroupName的setter方法
	 */
	public void setRuleGroupName(String ruleGroupName) {
		this.ruleGroupName = ruleGroupName;
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