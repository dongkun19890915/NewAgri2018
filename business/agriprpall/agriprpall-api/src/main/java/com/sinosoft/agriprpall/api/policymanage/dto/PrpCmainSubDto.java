package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainSubDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 保单隶属表Api操作对象
 */
public class PrpCmainSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性主保单号码/主保单号码 */
	private String mainPolicyNo ;		
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性标志字段 /标志字段  */
	private String flag ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性交强险的起始日期/交强险的起始日期 */
	private java.util.Date startDate ;		
	/** 属性交强险的终止日期/交强险的终止日期 */
	private java.util.Date endDate ;		
	/** 属性balanceTimes/balanceTimes */
	private Integer balanceTimes ;
	/** 属性batchNo/batchNo */
	private String batchNo ;		
	/** 属性checkAgentDescription/checkAgentDescription */
	private String checkAgentDescription ;		
	/** 属性conditions/conditions */
	private String conditions ;		
	/** 属性groupNo/groupNo */
	private String groupNo ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性主保单号码/主保单号码的getter方法
	 */
	public String getMainPolicyNo() {
		return mainPolicyNo;
	}
	/**
	 * 属性主保单号码/主保单号码的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	}	
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性标志字段 /标志字段 的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段 /标志字段 的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性交强险的起始日期/交强险的起始日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性交强险的起始日期/交强险的起始日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性交强险的终止日期/交强险的终止日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性交强险的终止日期/交强险的终止日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性balanceTimes/balanceTimes的getter方法
	 */
	public Integer getBalanceTimes() {
		return balanceTimes;
	}
	/**
	 * 属性balanceTimes/balanceTimes的setter方法
	 */
	public void setBalanceTimes(Integer balanceTimes) {
		this.balanceTimes = balanceTimes;
	}	
	/**
	 * 属性batchNo/batchNo的getter方法
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * 属性batchNo/batchNo的setter方法
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}	
	/**
	 * 属性checkAgentDescription/checkAgentDescription的getter方法
	 */
	public String getCheckAgentDescription() {
		return checkAgentDescription;
	}
	/**
	 * 属性checkAgentDescription/checkAgentDescription的setter方法
	 */
	public void setCheckAgentDescription(String checkAgentDescription) {
		this.checkAgentDescription = checkAgentDescription;
	}	
	/**
	 * 属性conditions/conditions的getter方法
	 */
	public String getConditions() {
		return conditions;
	}
	/**
	 * 属性conditions/conditions的setter方法
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}	
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
	}
}
