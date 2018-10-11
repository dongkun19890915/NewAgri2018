package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 记录客户风险等级详细表Api操作对象
 */
public class PrpDcustomerRiskLevelSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性ID号/ID号 */
	private String customerRiskLevelId ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性业务类型/业务类型 */
	private String certiType ;		
	/** 属性业务单号/业务单号 */
	private String certiNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性机构代码/机构代码 */
	private String comCode ;		
	/** 属性操作员姓名/操作员姓名 */
	private String operaterName ;		
	/** 属性操作员代码/操作员代码 */
	private String operaterCode ;		
	/** 属性权限节点号/权限节点号 */
	private Integer nodeNo ;
	/** 属性操作时间/操作时间 */
	private java.util.Date operateDate ;		
	/** 属性涉及金额/涉及金额 */
	private Double moneyInvolved ;
	/** 属性客户唯一标识/客户唯一标识 */
	private String customerCode ;		
	/** 属性风险等级(四级  三级 二级 一级)/风险等级(四级  三级 二级 一级) */
	private String riskLevel ;		
	/** 属性变更原因/变更原因 */
	private String changeReason ;		
	/** 属性手动修改状态1-审核通过2-待审核3-下发修改4-审核中/手动修改状态1-审核通过2-待审核3-下发修改4-审核中 */
	private String reserved1 ;		
	/** 属性评定依据/评定依据 */
	private String reserved2 ;		
	/** 属性当前审核人代码/当前审核人代码 */
	private String reserved3 ;		
	/** 属性审核意见/审核意见 */
	private String reserved4 ;		
	/**
	 * 属性ID号/ID号的getter方法
	 */
	public String getCustomerRiskLevelId() {
		return customerRiskLevelId;
	}
	/**
	 * 属性ID号/ID号的setter方法
	 */
	public void setCustomerRiskLevelId(String customerRiskLevelId) {
		this.customerRiskLevelId = customerRiskLevelId;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}	
	/**
	 * 属性业务单号/业务单号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性业务单号/业务单号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
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
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性操作员姓名/操作员姓名的getter方法
	 */
	public String getOperaterName() {
		return operaterName;
	}
	/**
	 * 属性操作员姓名/操作员姓名的setter方法
	 */
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperaterCode() {
		return operaterCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperaterCode(String operaterCode) {
		this.operaterCode = operaterCode;
	}	
	/**
	 * 属性权限节点号/权限节点号的getter方法
	 */
	public Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性权限节点号/权限节点号的setter方法
	 */
	public void setNodeNo(Integer nodeNo) {
		this.nodeNo = nodeNo;
	}	
	/**
	 * 属性操作时间/操作时间的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}	
	/**
	 * 属性涉及金额/涉及金额的getter方法
	 */
	public Double getMoneyInvolved() {
		return moneyInvolved;
	}
	/**
	 * 属性涉及金额/涉及金额的setter方法
	 */
	public void setMoneyInvolved(Double moneyInvolved) {
		this.moneyInvolved = moneyInvolved;
	}	
	/**
	 * 属性客户唯一标识/客户唯一标识的getter方法
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * 属性客户唯一标识/客户唯一标识的setter方法
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}	
	/**
	 * 属性风险等级(四级  三级 二级 一级)/风险等级(四级  三级 二级 一级)的getter方法
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 属性风险等级(四级  三级 二级 一级)/风险等级(四级  三级 二级 一级)的setter方法
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	
	/**
	 * 属性变更原因/变更原因的getter方法
	 */
	public String getChangeReason() {
		return changeReason;
	}
	/**
	 * 属性变更原因/变更原因的setter方法
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}	
	/**
	 * 属性手动修改状态1-审核通过2-待审核3-下发修改4-审核中/手动修改状态1-审核通过2-待审核3-下发修改4-审核中的getter方法
	 */
	public String getReserved1() {
		return reserved1;
	}
	/**
	 * 属性手动修改状态1-审核通过2-待审核3-下发修改4-审核中/手动修改状态1-审核通过2-待审核3-下发修改4-审核中的setter方法
	 */
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}	
	/**
	 * 属性评定依据/评定依据的getter方法
	 */
	public String getReserved2() {
		return reserved2;
	}
	/**
	 * 属性评定依据/评定依据的setter方法
	 */
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}	
	/**
	 * 属性当前审核人代码/当前审核人代码的getter方法
	 */
	public String getReserved3() {
		return reserved3;
	}
	/**
	 * 属性当前审核人代码/当前审核人代码的setter方法
	 */
	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}	
	/**
	 * 属性审核意见/审核意见的getter方法
	 */
	public String getReserved4() {
		return reserved4;
	}
	/**
	 * 属性审核意见/审核意见的setter方法
	 */
	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}	
}
