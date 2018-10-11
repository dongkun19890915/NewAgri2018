package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:16:34.906 
 * 特殊赔案清单表Api操作对象
 */
public class SpecCaseListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width =37 )
	private String serialNo ;
	/** 属性清单号*/
	private String listNo;
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号码",width =67 )
	private String policyNo ;		
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width =74 )
	private String registNo ;		
	/** 属性立案号/立案号 */
	@ExportConfig(value = "立案号",width =81 )
	private String claimNo ;		
	/** 属性预赔单号/预赔单号 */
	@ExportConfig(value = "预赔单号",width =129 )
	private String preCompensateNo ;		
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width =109 )
	private String fcode ;		
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户姓名",width =147 )
	private String fname ;		
	/** 属性领款人类型/领款人类型 */
	@ExportConfig(value = "领款人类型",width =131 )
	private String receiverType ;		
	/** 属性领款人名称(银行账户名称)/领款人名称(银行账户名称) */
	@ExportConfig(value = "领款人名称(银行账户名称)",width =125 )
	private String receiverName ;		
	/** 属性领款人证件类型/领款人证件类型 */
	@ExportConfig(value = "领款人证件类型",width =125 )
	private String identifyType ;		
	/** 属性领款人证件号/领款人证件号 */
	@ExportConfig(value = "领款人证件号",width =125 )
	private String identifyNumber ;		
	/** 属性开户银行大类/开户银行大类 */
	@ExportConfig(value = "开户银行大类",width =125 )
	private String bankType ;		
	/** 属性开户银行所在省份名称/开户银行所在省份名称 */
	@ExportConfig(value = "开户银行所在省份名称",width =125 )
	private String provinceName ;		
	/** 属性开户银行所在城市名称/开户银行所在城市名称 */
	@ExportConfig(value = "开户银行所在城市名称",width =125 )
	private String cityName ;		
	/** 属性开户银行名称/开户银行名称 */
	@ExportConfig(value = "开户银行名称",width = 125)
	private String bankName ;		
	/** 属性银行账号/银行账号 */
	@ExportConfig(value = "银行账号",width =125 )
	private String bankAccount ;		
	/** 属性账号属性01-对私账号；02-对公账号/账号属性01-对私账号；02-对公账号 */
	@ExportConfig(value = "账号属性",width =125 )
	private String accountFlag ;		
	/** 属性账号类型01-银行卡；02-存折/账号类型01-银行卡；02-存折 */
	@ExportConfig(value = "账号类型",width =125 )
	private String accountType ;		
	/** 属性领款人手机号/领款人手机号 */
	@ExportConfig(value = "领款人手机号",width =61 )
	private String phoneNumber ;		
	/** 属性赔款类型/赔款类型 */
	@ExportConfig(value = "赔款类型",width =61 )
	private String settleType ;		
	/** 属性赔款金额(元)/赔款金额(元) */
	@ExportConfig(value = "赔款金额(元)",width =61 )
	private Double settleAmount ;
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
	 * 属性预赔单号/预赔单号的getter方法
	 */
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	/**
	 * 属性预赔单号/预赔单号的setter方法
	 */
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}	
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFcode() {
		return fcode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setFname(String fname) {
		this.fname = fname;
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
	 * 属性领款人名称(银行账户名称)/领款人名称(银行账户名称)的getter方法
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 属性领款人名称(银行账户名称)/领款人名称(银行账户名称)的setter方法
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
	 * 属性账号属性01-对私账号；02-对公账号/账号属性01-对私账号；02-对公账号的getter方法
	 */
	public String getAccountFlag() {
		return accountFlag;
	}
	/**
	 * 属性账号属性01-对私账号；02-对公账号/账号属性01-对私账号；02-对公账号的setter方法
	 */
	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}	
	/**
	 * 属性账号类型01-银行卡；02-存折/账号类型01-银行卡；02-存折的getter方法
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 属性账号类型01-银行卡；02-存折/账号类型01-银行卡；02-存折的setter方法
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
	 * 属性赔款金额(元)/赔款金额(元)的getter方法
	 */
	public Double getSettleAmount() {
		return settleAmount;
	}
	/**
	 * 属性赔款金额(元)/赔款金额(元)的setter方法
	 */
	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
}
