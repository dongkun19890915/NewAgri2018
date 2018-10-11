package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 养殖险理赔明细表Api操作对象
 */
public class HerdSettleListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔清单号/理赔清单号 */
	private String settlelistCode ;		
	/** 属性耳标号/耳标号 */
	private String earlabel ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	private String fName ;		
	/** 属性身份证/身份证 */
	private String fidCard ;		
	/** 属性养殖地点代码/养殖地点代码 */
	private String breedingAreaCode ;		
	/** 属性养殖地点名称/养殖地点名称 */
	private String breedingAreaName ;		
	/** 属性开户银行/开户银行 */
	private String bankName ;		
	/** 属性银行账号/银行账号 */
	private String bankAccount ;		
	/** 属性出险时间/出险时间 */
	private String damageTime ;		
	/** 属性报案时间/报案时间 */
	private String reportTime ;		
	/** 属性死亡原因/死亡原因 */
	private String deadReason ;		
	/** 属性死亡数量/死亡数量 */
	private java.lang.Integer deadNumber ;		
	/** 属性扑杀数量/扑杀数量 */
	private java.lang.Integer cullNumber ;		
	/** 属性赔偿金额/赔偿金额 */
	private java.lang.Integer settleAmount ;		
	/** 属性操作员代码/操作员代码 */
	private String opCode ;		
	/** 属性操作时间/操作时间 */
	private java.util.Date opTime ;		
	/** 属性标志位/标志位 */
	private String validity ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性承保清单号/承保清单号 */
	private String insureListCode ;		
	/** 属性险别序号/险别序号 */
	private String kindCode ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/**
	 * 属性理赔清单号/理赔清单号的getter方法
	 */
	public String getSettlelistCode() {
		return settlelistCode;
	}
	/**
	 * 属性理赔清单号/理赔清单号的setter方法
	 */
	public void setSettlelistCode(String settlelistCode) {
		this.settlelistCode = settlelistCode;
	}	
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarlabel() {
		return earlabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarlabel(String earlabel) {
		this.earlabel = earlabel;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	}	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}	
	/**
	 * 属性身份证/身份证的getter方法
	 */
	public String getFidCard() {
		return fidCard;
	}
	/**
	 * 属性身份证/身份证的setter方法
	 */
	public void setFidCard(String fidCard) {
		this.fidCard = fidCard;
	}	
	/**
	 * 属性养殖地点代码/养殖地点代码的getter方法
	 */
	public String getBreedingAreaCode() {
		return breedingAreaCode;
	}
	/**
	 * 属性养殖地点代码/养殖地点代码的setter方法
	 */
	public void setBreedingAreaCode(String breedingAreaCode) {
		this.breedingAreaCode = breedingAreaCode;
	}	
	/**
	 * 属性养殖地点名称/养殖地点名称的getter方法
	 */
	public String getBreedingAreaName() {
		return breedingAreaName;
	}
	/**
	 * 属性养殖地点名称/养殖地点名称的setter方法
	 */
	public void setBreedingAreaName(String breedingAreaName) {
		this.breedingAreaName = breedingAreaName;
	}	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}	
	/**
	 * 属性银行账号/银行账号的getter方法
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 属性银行账号/银行账号的setter方法
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}	
	/**
	 * 属性出险时间/出险时间的getter方法
	 */
	public String getDamageTime() {
		return damageTime;
	}
	/**
	 * 属性出险时间/出险时间的setter方法
	 */
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
	}	
	/**
	 * 属性报案时间/报案时间的getter方法
	 */
	public String getReportTime() {
		return reportTime;
	}
	/**
	 * 属性报案时间/报案时间的setter方法
	 */
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}	
	/**
	 * 属性死亡原因/死亡原因的getter方法
	 */
	public String getDeadReason() {
		return deadReason;
	}
	/**
	 * 属性死亡原因/死亡原因的setter方法
	 */
	public void setDeadReason(String deadReason) {
		this.deadReason = deadReason;
	}	
	/**
	 * 属性死亡数量/死亡数量的getter方法
	 */
	public java.lang.Integer getDeadNumber() {
		return deadNumber;
	}
	/**
	 * 属性死亡数量/死亡数量的setter方法
	 */
	public void setDeadNumber(java.lang.Integer deadNumber) {
		this.deadNumber = deadNumber;
	}	
	/**
	 * 属性扑杀数量/扑杀数量的getter方法
	 */
	public java.lang.Integer getCullNumber() {
		return cullNumber;
	}
	/**
	 * 属性扑杀数量/扑杀数量的setter方法
	 */
	public void setCullNumber(java.lang.Integer cullNumber) {
		this.cullNumber = cullNumber;
	}	
	/**
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Integer getSettleAmount() {
		return settleAmount;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSettleAmount(java.lang.Integer settleAmount) {
		this.settleAmount = settleAmount;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性操作时间/操作时间的getter方法
	 */
	public java.util.Date getOpTime() {
		return opTime;
	}
	/**
	 * 属性操作时间/操作时间的setter方法
	 */
	public void setOpTime(java.util.Date opTime) {
		this.opTime = opTime;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性标志位/标志位的setter方法
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
	 * 属性承保清单号/承保清单号的getter方法
	 */
	public String getInsureListCode() {
		return insureListCode;
	}
	/**
	 * 属性承保清单号/承保清单号的setter方法
	 */
	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
	}	
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
}
