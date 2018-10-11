package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914
 * 理赔支付清单表Api操作对象
 */
public class NyxClaimPayListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性理赔支付清单号/理赔支付清单号 */
	private String listNo ;
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width = 37)
	private String serialNo ;
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号码",width = 67)
	private String policyNo ;
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width = 67)
	private String registNo ;
	/** 属性立案号/立案号 */
	@ExportConfig(value = "立案号",width = 67)
	private String claimNo ;
	/** 属性计算书号/计算书号 */
	@ExportConfig(value = "计算书号",width = 67)
	private String compensateNo ;
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width = 67)
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户名称",width = 67)
	private String fName ;
	/** 属性领款人类型/领款人类型 */
	@ExportConfig(value = "领款人类型",width = 83)
	private String receiverType ;
	/** 属性领款人名称/领款人名称 */
	@ExportConfig(value = "领款人名称（银行账号户名）",width = 215)
	private String receiverName ;
	/** 属性领款人证件类型/领款人证件类型 */
	@ExportConfig(value = "领款人证件类型",width = 116)
	private String identifyType ;
	/** 属性领款人证件号/领款人证件号 */
	@ExportConfig(value = "领款人证件号",width = 114)
	private String identifyNumber ;
	/** 属性开户银行大类/开户银行大类 */
	@ExportConfig(value = "开户银行大类名称",width = 134)
	private String bankType ;
	/** 属性开户银行所在省份名称/开户银行所在省份名称 */
	@ExportConfig(value = "开户银行所在省份名称",width = 166)
	private String provinceName ;
	/** 属性开户银行所在城市名称/开户银行所在城市名称 */
	@ExportConfig(value = "开户银行所在城市名称",width = 166)
	private String cityName ;
	/** 属性开户银行名称/开户银行名称 */
	@ExportConfig(value = "开户银行名称")
	private String bankName ;
	/** 属性银行账号/银行账号 */
	@ExportConfig(value = "银行账号",width = 67)
	private String bankAccount ;
	/** 属性账号属性/账号属性 */
	@ExportConfig(value = "账号属性",width = 199)
	private String accountType;
	/** 属性账号类型/账号类型 */
	@ExportConfig(value = "账号类型",width = 143)
	private String accountFlag ;
	/** 属性领款人手机号/领款人手机号 */
	@ExportConfig(value = "领款人手机号码",width = 116)
	private String phoneNumber ;
	/** 属性赔款类型/赔款类型 */
	@ExportConfig(value = "赔款类型",width = 116)
	private String settleType ;
	/** 属性赔款金额/赔款金额 */
	@ExportConfig(value = "赔款金额(元)",width = 116)
	private Double settleAmount ;
	/** 属性收付编号/收付编号 */
	private String paymentNo ;

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getCompensateNo() {
		return compensateNo;
	}

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

	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAccountFlag() {
		return accountFlag;
	}

	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public Double getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
}
