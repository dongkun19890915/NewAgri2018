package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * 养殖险理赔清单信息表Api操作对象
 */
public class NyxBreedClaimListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔清单号/理赔清单号 */
//	@ExportConfig(value = "理赔清单号",width = 80)
	private String listNo ;		
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width = 80)
	private String serialNo ;		
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号",width = 80)
	private String policyNo ;		
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width = 80)
	private String registNo ;
	/** 属性立案号/立案号 */
	@ExportConfig(value ="立案号" ,width = 80)
	private String claimNo ;
	/** 属性计算书号/计算书号 */
	@ExportConfig(value = "计算书号",width = 80)
	private String compensateNo ;		
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width = 80)
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户姓名",width = 80)
	private String fName ;		
	/** 属性身份证号码/身份证号码 */
	@ExportConfig(value = "身份证号码",width = 80)
	private String fIdCard ;		
	/** 属性联系电话/联系电话 */
	@ExportConfig(value = "联系电话",width = 80)
	private String phoneNumber ;		
	/** 属性银行账号/银行账号 */
//	@ExportConfig(value = "银行账号",width = 80)
	private String bankAccount ;
	@ExportConfig(value = "险别",width = 80)
	private String claimRiskCode ;
	/** 属性标的号码/标的号码 */
	@ExportConfig(value = "标的号码",width = 80)
	private String itemCode ;
	/** 属性耳标号/耳标号 */
	@ExportConfig(value = "耳标号",width = 80)
	private String earConNo ;		
	/** 属性支付金额/支付金额 */
	@ExportConfig(value = "支付金额",width = 80)
	private java.lang.Double payAmount ;		
	/** 属性赔付类型 Y-预赔;C-实赔/赔付类型 Y-预赔;C-实赔 */
	@ExportConfig(value = "赔付类型",width = 80)
	private String payType ;
	/** 属性计算公式*/
	@ExportConfig(value="计算公式",width = 80)
	private String formula;
	/** 属性扣除金额*/
	@ExportConfig(value="扣除金额",width = 80)
	private String deductionAmount;
	@ExportConfig(value="是否已赔付",width = 80)
	private String isIndemnity;
	private String nodeType ;

	public String getIsIndemnity() {
		return isIndemnity;
	}

	public void setIsIndemnity(String isIndemnity) {
		this.isIndemnity = isIndemnity;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimRiskCode() {
		return claimRiskCode;
	}

	public void setClaimRiskCode(String claimRiskCode) {
		this.claimRiskCode = claimRiskCode;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(String deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * 属性理赔清单号/理赔清单号的getter方法
	 */
	public String getListNo() {
		return listNo;
	}
	/**
	 * 属性理赔清单号/理赔清单号的setter方法
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性计算书号/计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性计算书号/计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfIdCard() {
		return fIdCard;
	}

	public void setfIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	}

	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarConNo() {
		return earConNo;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarConNo(String earConNo) {
		this.earConNo = earConNo;
	}	
	/**
	 * 属性支付金额/支付金额的getter方法
	 */
	public java.lang.Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性支付金额/支付金额的setter方法
	 */
	public void setPayAmount(java.lang.Double payAmount) {
		this.payAmount = payAmount;
	}	
	/**
	 * 属性赔付类型 Y-预赔;C-实赔/赔付类型 Y-预赔;C-实赔的getter方法
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 属性赔付类型 Y-预赔;C-实赔/赔付类型 Y-预赔;C-实赔的setter方法
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}	
}
