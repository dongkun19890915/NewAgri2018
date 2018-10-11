package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 08:23:52.676 
 * 支付信息轨迹表Api操作对象
 */
public class PrpLsumpayLogDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性序号/序号 */
	private String serialNo ;		
	/** 属性轨迹序号/轨迹序号 */
	private String logNo ;		
	/** 属性归属机构/归属机构 */
	private String comCode ;		
	/** 属性节点号/节点号 */
	private String nodeType ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性计算书号/计算书号 */
	private String compensateNo ;		
	/** 属性预赔号/预赔号 */
	private String preparNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性处理人代码/处理人代码 */
	private String handlerCode ;		
	/** 属性处理人名称/处理人名称 */
	private String handlerName ;		
	/** 属性处理时间/处理时间 */
	private java.util.Date handleTime ;		
	/** 属性收款人与被保险人同一人标志/收款人与被保险人同一人标志 */
	private String status ;		
	/** 属性支付信息状态/支付信息状态 */
	private String samePersonFlag ;		
	/** 属性出单机构/出单机构 */
	private String makeCom ;		
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;		
	/** 属性申请例外人员代码/申请例外人员代码 */
	private String userCode ;		
	/** 属性开户行/开户行 */
	private String accountBank ;		
	/** 属性账户名/账户名 */
	private String accountName ;		
	/** 属性帐号/帐号 */
	private String accountNo ;		
	/** 属性赔款金额/赔款金额 */
	private java.lang.Double sumthisPay ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性核赔标志/核赔标志 */
	private String underwriteFlag ;		
	/** 属性是否申请例外标志/是否申请例外标志 */
	private String exceptionFlag ;		
	/** 属性启动例外标志/启动例外标志 */
	private String exceptionStartFlag ;		
	/** 属性例外原因代码/例外原因代码 */
	private String exceptionCode ;		
	/** 属性备用字段/备用字段 */
	private String flag ;		
	/** 属性省区号/省区号 */
	private String presidial ;		
	/** 属性市区区号/市区区号 */
	private String cantonal ;		
	/** 属性银行代码/银行代码 */
	private String accountCode ;		
	/** 属性联行号/联行号 */
	private String relateBankNo ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性备注1/备注1 */
	private String remark1 ;		
	/** 属性备注2/备注2 */
	private String remark2 ;		
	/** 属性备注3/备注3 */
	private String remark3 ;		
	/** 属性备注4/备注4 */
	private String remark4 ;		
	/** 属性备注5/备注5 */
	private String remark5 ;		
	/** 属性支付标志/支付标志 */
	private String payFlag ;		
	/** 属性支付时间/支付时间 */
	private java.util.Date payTime ;		
	/** 属性审核意见/审核意见 */
	private String opinions ;		
	/** 属性收付系统退回原因代码/收付系统退回原因代码 */
	private String backReasonCode ;		
	/** 属性收付系统退回原因/收付系统退回原因 */
	private String backReason ;		
	/** 属性付款备注信息/付款备注信息 */
	private String remarkInfo ;		
	/** 属性赔款类型/赔款类型 */
	private String payType ;		
	/** 属性费用代码/费用代码 */
	private String chargeCode ;		
	/** 属性收付业务主键ID/收付业务主键ID */
	private String certiId ;		
	/** 属性回盘文件名/回盘文件名 */
	private String uploadFileName ;		
	/** 属性卡/折类型/卡/折类型 */
	private String cardType ;		
	/** 属性结算方式/结算方式 */
	private String settlementMode ;		
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
	 * 属性轨迹序号/轨迹序号的getter方法
	 */
	public String getLogNo() {
		return logNo;
	}
	/**
	 * 属性轨迹序号/轨迹序号的setter方法
	 */
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}	
	/**
	 * 属性归属机构/归属机构的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构/归属机构的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性节点号/节点号的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点号/节点号的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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
	/**
	 * 属性预赔号/预赔号的getter方法
	 */
	public String getPreparNo() {
		return preparNo;
	}
	/**
	 * 属性预赔号/预赔号的setter方法
	 */
	public void setPreparNo(String preparNo) {
		this.preparNo = preparNo;
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
	 * 属性处理人代码/处理人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性处理人代码/处理人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性处理人名称/处理人名称的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性处理人名称/处理人名称的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性处理时间/处理时间的getter方法
	 */
	public java.util.Date getHandleTime() {
		return handleTime;
	}
	/**
	 * 属性处理时间/处理时间的setter方法
	 */
	public void setHandleTime(java.util.Date handleTime) {
		this.handleTime = handleTime;
	}	
	/**
	 * 属性收款人与被保险人同一人标志/收款人与被保险人同一人标志的getter方法
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 属性收款人与被保险人同一人标志/收款人与被保险人同一人标志的setter方法
	 */
	public void setStatus(String status) {
		this.status = status;
	}	
	/**
	 * 属性支付信息状态/支付信息状态的getter方法
	 */
	public String getSamePersonFlag() {
		return samePersonFlag;
	}
	/**
	 * 属性支付信息状态/支付信息状态的setter方法
	 */
	public void setSamePersonFlag(String samePersonFlag) {
		this.samePersonFlag = samePersonFlag;
	}	
	/**
	 * 属性出单机构/出单机构的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性出单机构/出单机构的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}	
	/**
	 * 属性被保险人名称/被保险人名称的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人名称/被保险人名称的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}	
	/**
	 * 属性申请例外人员代码/申请例外人员代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性申请例外人员代码/申请例外人员代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性开户行/开户行的getter方法
	 */
	public String getAccountBank() {
		return accountBank;
	}
	/**
	 * 属性开户行/开户行的setter方法
	 */
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}	
	/**
	 * 属性账户名/账户名的getter方法
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 属性账户名/账户名的setter方法
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	
	/**
	 * 属性帐号/帐号的getter方法
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 属性帐号/帐号的setter方法
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}	
	/**
	 * 属性赔款金额/赔款金额的getter方法
	 */
	public java.lang.Double getSumthisPay() {
		return sumthisPay;
	}
	/**
	 * 属性赔款金额/赔款金额的setter方法
	 */
	public void setSumthisPay(java.lang.Double sumthisPay) {
		this.sumthisPay = sumthisPay;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性核赔标志/核赔标志的getter方法
	 */
	public String getUnderwriteFlag() {
		return underwriteFlag;
	}
	/**
	 * 属性核赔标志/核赔标志的setter方法
	 */
	public void setUnderwriteFlag(String underwriteFlag) {
		this.underwriteFlag = underwriteFlag;
	}	
	/**
	 * 属性是否申请例外标志/是否申请例外标志的getter方法
	 */
	public String getExceptionFlag() {
		return exceptionFlag;
	}
	/**
	 * 属性是否申请例外标志/是否申请例外标志的setter方法
	 */
	public void setExceptionFlag(String exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}	
	/**
	 * 属性启动例外标志/启动例外标志的getter方法
	 */
	public String getExceptionStartFlag() {
		return exceptionStartFlag;
	}
	/**
	 * 属性启动例外标志/启动例外标志的setter方法
	 */
	public void setExceptionStartFlag(String exceptionStartFlag) {
		this.exceptionStartFlag = exceptionStartFlag;
	}	
	/**
	 * 属性例外原因代码/例外原因代码的getter方法
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}
	/**
	 * 属性例外原因代码/例外原因代码的setter方法
	 */
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}	
	/**
	 * 属性备用字段/备用字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用字段/备用字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性省区号/省区号的getter方法
	 */
	public String getPresidial() {
		return presidial;
	}
	/**
	 * 属性省区号/省区号的setter方法
	 */
	public void setPresidial(String presidial) {
		this.presidial = presidial;
	}	
	/**
	 * 属性市区区号/市区区号的getter方法
	 */
	public String getCantonal() {
		return cantonal;
	}
	/**
	 * 属性市区区号/市区区号的setter方法
	 */
	public void setCantonal(String cantonal) {
		this.cantonal = cantonal;
	}	
	/**
	 * 属性银行代码/银行代码的getter方法
	 */
	public String getAccountCode() {
		return accountCode;
	}
	/**
	 * 属性银行代码/银行代码的setter方法
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}	
	/**
	 * 属性联行号/联行号的getter方法
	 */
	public String getRelateBankNo() {
		return relateBankNo;
	}
	/**
	 * 属性联行号/联行号的setter方法
	 */
	public void setRelateBankNo(String relateBankNo) {
		this.relateBankNo = relateBankNo;
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
	 * 属性备注1/备注1的getter方法
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * 属性备注1/备注1的setter方法
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}	
	/**
	 * 属性备注2/备注2的getter方法
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * 属性备注2/备注2的setter方法
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}	
	/**
	 * 属性备注3/备注3的getter方法
	 */
	public String getRemark3() {
		return remark3;
	}
	/**
	 * 属性备注3/备注3的setter方法
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}	
	/**
	 * 属性备注4/备注4的getter方法
	 */
	public String getRemark4() {
		return remark4;
	}
	/**
	 * 属性备注4/备注4的setter方法
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}	
	/**
	 * 属性备注5/备注5的getter方法
	 */
	public String getRemark5() {
		return remark5;
	}
	/**
	 * 属性备注5/备注5的setter方法
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}	
	/**
	 * 属性支付标志/支付标志的getter方法
	 */
	public String getPayFlag() {
		return payFlag;
	}
	/**
	 * 属性支付标志/支付标志的setter方法
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}	
	/**
	 * 属性支付时间/支付时间的getter方法
	 */
	public java.util.Date getPayTime() {
		return payTime;
	}
	/**
	 * 属性支付时间/支付时间的setter方法
	 */
	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
	}	
	/**
	 * 属性审核意见/审核意见的getter方法
	 */
	public String getOpinions() {
		return opinions;
	}
	/**
	 * 属性审核意见/审核意见的setter方法
	 */
	public void setOpinions(String opinions) {
		this.opinions = opinions;
	}	
	/**
	 * 属性收付系统退回原因代码/收付系统退回原因代码的getter方法
	 */
	public String getBackReasonCode() {
		return backReasonCode;
	}
	/**
	 * 属性收付系统退回原因代码/收付系统退回原因代码的setter方法
	 */
	public void setBackReasonCode(String backReasonCode) {
		this.backReasonCode = backReasonCode;
	}	
	/**
	 * 属性收付系统退回原因/收付系统退回原因的getter方法
	 */
	public String getBackReason() {
		return backReason;
	}
	/**
	 * 属性收付系统退回原因/收付系统退回原因的setter方法
	 */
	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}	
	/**
	 * 属性付款备注信息/付款备注信息的getter方法
	 */
	public String getRemarkInfo() {
		return remarkInfo;
	}
	/**
	 * 属性付款备注信息/付款备注信息的setter方法
	 */
	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}	
	/**
	 * 属性赔款类型/赔款类型的getter方法
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 属性赔款类型/赔款类型的setter方法
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}	
	/**
	 * 属性费用代码/费用代码的getter方法
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * 属性费用代码/费用代码的setter方法
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}	
	/**
	 * 属性收付业务主键ID/收付业务主键ID的getter方法
	 */
	public String getCertiId() {
		return certiId;
	}
	/**
	 * 属性收付业务主键ID/收付业务主键ID的setter方法
	 */
	public void setCertiId(String certiId) {
		this.certiId = certiId;
	}	
	/**
	 * 属性回盘文件名/回盘文件名的getter方法
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * 属性回盘文件名/回盘文件名的setter方法
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}	
	/**
	 * 属性卡/折类型/卡/折类型的getter方法
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 属性卡/折类型/卡/折类型的setter方法
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}	
	/**
	 * 属性结算方式/结算方式的getter方法
	 */
	public String getSettlementMode() {
		return settlementMode;
	}
	/**
	 * 属性结算方式/结算方式的setter方法
	 */
	public void setSettlementMode(String settlementMode) {
		this.settlementMode = settlementMode;
	}	
}
