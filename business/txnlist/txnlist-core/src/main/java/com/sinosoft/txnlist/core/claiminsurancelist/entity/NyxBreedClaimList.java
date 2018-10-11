package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * 养殖险理赔清单信息表实体操作对象
 */
@Entity
@Table(name = "NyxBreedClaimList")
@IdClass(NyxBreedClaimListKey.class)
public class NyxBreedClaimList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性理赔清单号/理赔清单号 */
	@Id
	@Column(name = "listNo")
	private String listNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private String serialNo ;	


	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性计算书号/计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性身份证号码/身份证号码 */
	@Column(name = "fIdCard")
	private String fIdCard ;
	/** 属性联系电话/联系电话 */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性银行账号/银行账号 */
	@Column(name = "bankAccount")
	private String bankAccount ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earConNo")
	private String earConNo ;
	/** 属性支付金额/支付金额 */
	@Column(name = "payAmount")
	private java.lang.Double payAmount ;
	/** 属性赔付类型 Y-预赔;C-实赔/赔付类型 Y-预赔;C-实赔 */
	@Column(name = "payType")
	private String payType ;
	/** 属性标的号码/标的号码 */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性节点来源/节点来源 */
	@Column(name = "nodeType")
	private String nodeType ;
	private String claimNo ;
	private String formula ;
	private String deductionAmount ;
	private String claimRiskCode ;

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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

	public String getClaimRiskCode() {
		return claimRiskCode;
	}

	public void setClaimRiskCode(String claimRiskCode) {
		this.claimRiskCode = claimRiskCode;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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