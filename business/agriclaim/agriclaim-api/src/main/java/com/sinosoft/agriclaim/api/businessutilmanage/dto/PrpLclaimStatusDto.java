package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔节点状态表Api操作对象
 */
public class PrpLclaimStatusDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	private String businessno ;		
	/** 属性保单号码/保单号码 */
	private String policyno ;		
	/** 属性节点种类/节点种类 */
	private String nodetype ;		
	/** 属性序列号码/序列号码 */
	private java.lang.Integer serialno ;		
	/** 属性险种代码/险种代码 */
	private String riskcode ;		
	/** 属性操作状态位/操作状态位 */
	private String status ;		
	/** 属性流程编号/流程编号 */
	private String flowid ;		
	/** 属性办理人员编码/办理人员编码 */
	private String handlercode ;		
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputdate ;		
	/** 属性操作日期/操作日期 */
	private java.util.Date operatedate ;		
	/** 属性类型标志/类型标志 */
	private String typeflag ;		
	/** 属性标志位/标志位 */
	private String flag ;		
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessno() {
		return businessno;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyno() {
		return policyno;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}	
	/**
	 * 属性节点种类/节点种类的getter方法
	 */
	public String getNodetype() {
		return nodetype;
	}
	/**
	 * 属性节点种类/节点种类的setter方法
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}	
	/**
	 * 属性序列号码/序列号码的getter方法
	 */
	public java.lang.Integer getSerialno() {
		return serialno;
	}
	/**
	 * 属性序列号码/序列号码的setter方法
	 */
	public void setSerialno(java.lang.Integer serialno) {
		this.serialno = serialno;
	}	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskcode() {
		return riskcode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}	
	/**
	 * 属性操作状态位/操作状态位的getter方法
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 属性操作状态位/操作状态位的setter方法
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
	/**
	 * 属性流程编号/流程编号的getter方法
	 */
	public String getFlowid() {
		return flowid;
	}
	/**
	 * 属性流程编号/流程编号的setter方法
	 */
	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}	
	/**
	 * 属性办理人员编码/办理人员编码的getter方法
	 */
	public String getHandlercode() {
		return handlercode;
	}
	/**
	 * 属性办理人员编码/办理人员编码的setter方法
	 */
	public void setHandlercode(String handlercode) {
		this.handlercode = handlercode;
	}	
	/**
	 * 属性计算机输单日期/计算机输单日期的getter方法
	 */
	public java.util.Date getInputdate() {
		return inputdate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputdate(java.util.Date inputdate) {
		this.inputdate = inputdate;
	}	
	/**
	 * 属性操作日期/操作日期的getter方法
	 */
	public java.util.Date getOperatedate() {
		return operatedate;
	}
	/**
	 * 属性操作日期/操作日期的setter方法
	 */
	public void setOperatedate(java.util.Date operatedate) {
		this.operatedate = operatedate;
	}	
	/**
	 * 属性类型标志/类型标志的getter方法
	 */
	public String getTypeflag() {
		return typeflag;
	}
	/**
	 * 属性类型标志/类型标志的setter方法
	 */
	public void setTypeflag(String typeflag) {
		this.typeflag = typeflag;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
