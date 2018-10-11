package com.sinosoft.dms.api.paymanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
public class QueryCentralizedPayDto extends BasePageableRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** */
	private String operateId;
	/** 保单号 */
	private String policyNo;
	/** 批单号 */
	private String endorseNo;
	/** 收付退回日期比较符 */
	private String createDateSign;
	/** 收付退回日期 */
	private String createDate;
	/** 工作流状态 */
	private String flowStatus;
	/** 操作状态 */
	private String operateStatus[];
	/** 归属机构 */
	private String comCode;
	/** 险种代码 */
	private String riskCode;
	/** IsOrNotSave */
	private String isOrNotSave;
	/** IWherePart */
	private String iWherePart;
	/** 前台页面状态为只读 */
	private String displayRead;
	/** 前台页面状态为可编辑 */
	private String displayModify;
	/** 开户银行 */
	private String bank;
	/** 开户账号 */
	private String account;
	/** 帐户名 */
	private String accountName;
	/** 账户属性 */
	private String accountType;
	/** 联行号 */
	private String areaBankCode;
	/** BankCode */
	private String bankCode;
	/** AreaProvinceCode */
	private String areaProvinceCode;
	/** AreaCode */
	private String areaCode;
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getEndorseNo() {
		return endorseNo;
	}
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	public String getCreateDateSign() {
		return createDateSign;
	}
	public void setCreateDateSign(String createDateSign) {
		this.createDateSign = createDateSign;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public String[] getOperateStatus() {
		return operateStatus;
	}
	public void setOperateStatus(String[] operateStatus) {
		this.operateStatus = operateStatus;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getIsOrNotSave() {
		return isOrNotSave;
	}
	public void setIsOrNotSave(String isOrNotSave) {
		this.isOrNotSave = isOrNotSave;
	}
	public String getiWherePart() {
		return iWherePart;
	}
	public void setiWherePart(String iWherePart) {
		this.iWherePart = iWherePart;
	}
	public String getDisplayRead() {
		return displayRead;
	}
	public void setDisplayRead(String displayRead) {
		this.displayRead = displayRead;
	}
	public String getDisplayModify() {
		return displayModify;
	}
	public void setDisplayModify(String displayModify) {
		this.displayModify = displayModify;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAreaBankCode() {
		return areaBankCode;
	}
	public void setAreaBankCode(String areaBankCode) {
		this.areaBankCode = areaBankCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAreaProvinceCode() {
		return areaProvinceCode;
	}
	public void setAreaProvinceCode(String areaProvinceCode) {
		this.areaProvinceCode = areaProvinceCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	

}
