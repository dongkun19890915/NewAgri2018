package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * settlemainlistApi操作对象
 */
public class SettleMainListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔清单号（KEY）/理赔清单号（KEY） */
	private String settleListCode ;		
	/** 属性行政区域/行政区域 */
	private String fareaCode ;		
	/** 属性承保清单号/承保清单号 */
	private String inusreListCode ;		
	/** 属性报案号/报案号 */
	private String reportCode ;		
	/** 属性立案号/立案号 */
	private String registerCode ;		
	/** 属性理算书号/理算书号 */
	private String comPensateNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险类/险类 */
	private String classCode ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）"/清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）" */
	private String validity ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性上次编辑代码/上次编辑代码 */
	private String upDateCode ;		
	/** 属性上次编辑时间/上次编辑时间 */
	private java.util.Date upDateDate ;		
	/** 属性关联操作员代码/关联操作员代码 */
	private String opCode ;		
	/** 属性出险时间/出险时间 */
	private java.util.Date damageTime ;		
	/** 属性littleAreaName/littleAreaName */
	private String littleAreaName ;		
	/** 属性atArea/atArea */
	private String atArea ;		
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的getter方法
	 */
	public String getSettleListCode() {
		return settleListCode;
	}
	/**
	 * 属性理赔清单号（KEY）/理赔清单号（KEY）的setter方法
	 */
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	}	
	/**
	 * 属性行政区域/行政区域的getter方法
	 */
	public String getFareaCode() {
		return fareaCode;
	}
	/**
	 * 属性行政区域/行政区域的setter方法
	 */
	public void setFareaCode(String fareaCode) {
		this.fareaCode = fareaCode;
	}	
	/**
	 * 属性承保清单号/承保清单号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性承保清单号/承保清单号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	}	
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getReportCode() {
		return reportCode;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}	
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getRegisterCode() {
		return registerCode;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}	
	/**
	 * 属性理算书号/理算书号的getter方法
	 */
	public String getComPensateNo() {
		return comPensateNo;
	}
	/**
	 * 属性理算书号/理算书号的setter方法
	 */
	public void setComPensateNo(String comPensateNo) {
		this.comPensateNo = comPensateNo;
	}	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）"/清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）"的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）"/清单标志（未提交、已关联未提交、正常）（0未提交、1已关联未提交、2正常）"的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性上次编辑代码/上次编辑代码的getter方法
	 */
	public String getUpDateCode() {
		return upDateCode;
	}
	/**
	 * 属性上次编辑代码/上次编辑代码的setter方法
	 */
	public void setUpDateCode(String upDateCode) {
		this.upDateCode = upDateCode;
	}	
	/**
	 * 属性上次编辑时间/上次编辑时间的getter方法
	 */
	public java.util.Date getUpDateDate() {
		return upDateDate;
	}
	/**
	 * 属性上次编辑时间/上次编辑时间的setter方法
	 */
	public void setUpDateDate(java.util.Date upDateDate) {
		this.upDateDate = upDateDate;
	}	
	/**
	 * 属性关联操作员代码/关联操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性关联操作员代码/关联操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性出险时间/出险时间的getter方法
	 */
	public java.util.Date getDamageTime() {
		return damageTime;
	}
	/**
	 * 属性出险时间/出险时间的setter方法
	 */
	public void setDamageTime(java.util.Date damageTime) {
		this.damageTime = damageTime;
	}	
	/**
	 * 属性littleAreaName/littleAreaName的getter方法
	 */
	public String getLittleAreaName() {
		return littleAreaName;
	}
	/**
	 * 属性littleAreaName/littleAreaName的setter方法
	 */
	public void setLittleAreaName(String littleAreaName) {
		this.littleAreaName = littleAreaName;
	}	
	/**
	 * 属性atArea/atArea的getter方法
	 */
	public String getAtArea() {
		return atArea;
	}
	/**
	 * 属性atArea/atArea的setter方法
	 */
	public void setAtArea(String atArea) {
		this.atArea = atArea;
	}	
}
