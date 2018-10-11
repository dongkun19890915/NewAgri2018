package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914 
 * 理赔支付清单表实体操作对象
 */
@Entity
@Table(name = "NyxClaimPayList")
@IdClass(NyxClaimPayListKey.class)
public class NyxClaimPayList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性理赔支付清单号/理赔支付清单号 */
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
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性计算书号/计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性领款人类型/领款人类型 */
	@Column(name = "receiverType")
	private String receiverType ;
	/** 属性领款人名称/领款人名称 */
	@Column(name = "receiverName")
	private String receiverName ;
	/** 属性领款人证件类型/领款人证件类型 */
	@Column(name = "identifyType")
	private String identifyType ;
	/** 属性领款人证件号/领款人证件号 */
	@Column(name = "identifyNumber")
	private String identifyNumber ;
	/** 属性开户银行大类/开户银行大类 */
	@Column(name = "bankType")
	private String bankType ;
	/** 属性开户银行所在省份名称/开户银行所在省份名称 */
	@Column(name = "provinceName")
	private String provinceName ;
	/** 属性开户银行所在城市名称/开户银行所在城市名称 */
	@Column(name = "cityName")
	private String cityName ;
	/** 属性开户银行名称/开户银行名称 */
	@Column(name = "bankName")
	private String bankName ;
	/** 属性银行账号/银行账号 */
	@Column(name = "bankAccount")
	private String bankAccount ;
	/** 属性账号属性/账号属性 */
	@Column(name = "accountFlag")
	private String accountFlag ;
	/** 属性账号类型/账号类型 */
	@Column(name = "accountType")
	private String accountType ;
	/** 属性领款人手机号/领款人手机号 */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性赔款金额/赔款金额 */
	@Column(name = "settleAmount")
	private Double settleAmount ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;




	/** 属性赔款类型/赔款类型 */
	@Column(name = "settleType")
	private String settleType ;

	/** 属性收付编号/收付编号 */
	@Column(name = "paymentNo")
	private String paymentNo ;
	/**
	 * 属性理赔支付清单号/理赔支付清单号的getter方法
	 */
	public String getListNo() {
		return listNo;
	}
	/**
	 * 属性理赔支付清单号/理赔支付清单号的setter方法
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
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
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	/**
	 * 属性领款人类型/领款人类型的getter方法
	 */
	public String getReceiverType() {
		return receiverType;
	}
	/**
	 * 属性领款人类型/领款人类型的setter方法
	 */
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	} 	
	/**
	 * 属性领款人名称/领款人名称的getter方法
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 属性领款人名称/领款人名称的setter方法
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	} 	
	/**
	 * 属性领款人证件类型/领款人证件类型的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性领款人证件类型/领款人证件类型的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	} 	
	/**
	 * 属性领款人证件号/领款人证件号的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性领款人证件号/领款人证件号的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	} 	
	/**
	 * 属性开户银行大类/开户银行大类的getter方法
	 */
	public String getBankType() {
		return bankType;
	}
	/**
	 * 属性开户银行大类/开户银行大类的setter方法
	 */
	public void setBankType(String bankType) {
		this.bankType = bankType;
	} 	
	/**
	 * 属性开户银行所在省份名称/开户银行所在省份名称的getter方法
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 属性开户银行所在省份名称/开户银行所在省份名称的setter方法
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	} 	
	/**
	 * 属性开户银行所在城市名称/开户银行所在城市名称的getter方法
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 属性开户银行所在城市名称/开户银行所在城市名称的setter方法
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	} 	
	/**
	 * 属性开户银行名称/开户银行名称的getter方法
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 属性开户银行名称/开户银行名称的setter方法
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
	 * 属性账号属性/账号属性的getter方法
	 */
	public String getAccountFlag() {
		return accountFlag;
	}
	/**
	 * 属性账号属性/账号属性的setter方法
	 */
	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	} 	
	/**
	 * 属性账号类型/账号类型的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性账号类型/账号类型的setter方法
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	} 	
	/**
	 * 属性领款人手机号/领款人手机号的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性领款人手机号/领款人手机号的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 	
	/**
	 * 属性赔款金额/赔款金额的getter方法
	 */
	public Double getSettleAmount() {
		return settleAmount;
	}
	/**
	 * 属性赔款金额/赔款金额的setter方法
	 */
	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
	} 	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	/*public String getFCode() {
		return fCode;
	}
	*//**
	 * 属性农户代码/农户代码的setter方法
	 *//*
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 	
	*//**
	 * 属性农户姓名/农户姓名的getter方法
	 *//*
	public String getFName() {
		return fName;
	}
	*//**
	 * 属性农户姓名/农户姓名的setter方法
	 *//*
	public void setFName(String fName) {
		this.fName = fName;
	} */

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

	/**
	 * 属性赔款类型/赔款类型的getter方法
	 */
	public String getSettleType() {
		return settleType;
	}
	/**
	 * 属性赔款类型/赔款类型的setter方法
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
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
	 * 属性收付编号/收付编号的getter方法
	 */
	public String getPaymentNo() {
		return paymentNo;
	}
	/**
	 * 属性收付编号/收付编号的setter方法
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

}