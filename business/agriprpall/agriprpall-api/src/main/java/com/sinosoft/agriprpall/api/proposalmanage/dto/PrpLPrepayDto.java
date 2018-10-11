package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预支付理赔表Api操作对象
 */
public class PrpLPrepayDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性预赔号/预赔号 */
	private String preCompensateNo ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性欠款时间/欠款时间 */
	private Integer arrearageTimes ;
	/** 属性欠款总额/欠款总额 */
	private Double sumArrearage ;
	/** 属性赔付前总额/赔付前总额 */
	private Double sumBeforePrepaid ;
	/** 属性批量提交时间/批量提交时间 */
	private Integer blockUpTimes ;
	/** 属性特殊赔款总额/特殊赔款总额 */
	private Double sumPrepaid ;
	/** 属性特殊赔款全部总额/特殊赔款全部总额 */
	private Double sumTotalPrepaid ;
	/** 属性理赔登记机构/理赔登记机构 */
	private String makeCom ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code ;
	/** 属性核价人代码/核价人代码 */
	private String approverCode ;
	/** 属性核损人代码/核损人代码 */
	private String underWriteCode ;
	/** 属性核损人名称/核损人名称 */
	private String underwriteName ;
	/** 属性批单统计年月/批单统计年月 */
	private java.util.Date statisticSym ;
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputDate ;
	/** 属性最终核损完成日期/最终核损完成日期 */
	private java.util.Date underWriteendDate ;
	/** 属性是否经过核损标志/是否经过核损标志 */
	private String underWriteFlag ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性特殊赔案类别/特殊赔案类别 */
	private String caseType ;
	/** 属性车险平台上传序号/车险平台上传序号 */
	private String uploadSerialNo ;
	/** 属性实付日期/实付日期 */
	private java.util.Date payrefDate ;
	/** 属性险别/险别 */
	private String kindCode ;
	/** 属性费用类型/费用类型 */
	private String feeType ;
	/** 属性事故责任/事故责任 */
	private String indemnityDuty ;
	/** 属性赔款费用总额/赔款费用总额 */
	private Integer sumPrechargePaid ;
	/** 属性关联的预赔号/关联的预赔号 */
	private String relateprecompensateNo ;
	/**
	 * 属性预赔号/预赔号的getter方法
	 */
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	/**
	 * 属性预赔号/预赔号的setter方法
	 */
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
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
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	 * 属性欠款时间/欠款时间的getter方法
	 */
	public Integer getArrearageTimes() {
		return arrearageTimes;
	}
	/**
	 * 属性欠款时间/欠款时间的setter方法
	 */
	public void setArrearageTimes(Integer arrearageTimes) {
		this.arrearageTimes = arrearageTimes;
	}
	/**
	 * 属性欠款总额/欠款总额的getter方法
	 */
	public Double getSumArrearage() {
		return sumArrearage;
	}
	/**
	 * 属性欠款总额/欠款总额的setter方法
	 */
	public void setSumArrearage(Double sumArrearage) {
		this.sumArrearage = sumArrearage;
	}
	/**
	 * 属性赔付前总额/赔付前总额的getter方法
	 */
	public Double getSumBeforePrepaid() {
		return sumBeforePrepaid;
	}
	/**
	 * 属性赔付前总额/赔付前总额的setter方法
	 */
	public void setSumBeforePrepaid(Double sumBeforePrepaid) {
		this.sumBeforePrepaid = sumBeforePrepaid;
	}
	/**
	 * 属性批量提交时间/批量提交时间的getter方法
	 */
	public Integer getBlockUpTimes() {
		return blockUpTimes;
	}
	/**
	 * 属性批量提交时间/批量提交时间的setter方法
	 */
	public void setBlockUpTimes(Integer blockUpTimes) {
		this.blockUpTimes = blockUpTimes;
	}
	/**
	 * 属性特殊赔款总额/特殊赔款总额的getter方法
	 */
	public Double getSumPrepaid() {
		return sumPrepaid;
	}
	/**
	 * 属性特殊赔款总额/特殊赔款总额的setter方法
	 */
	public void setSumPrepaid(Double sumPrepaid) {
		this.sumPrepaid = sumPrepaid;
	}
	/**
	 * 属性特殊赔款全部总额/特殊赔款全部总额的getter方法
	 */
	public Double getSumTotalPrepaid() {
		return sumTotalPrepaid;
	}
	/**
	 * 属性特殊赔款全部总额/特殊赔款全部总额的setter方法
	 */
	public void setSumTotalPrepaid(Double sumTotalPrepaid) {
		this.sumTotalPrepaid = sumTotalPrepaid;
	}
	/**
	 * 属性理赔登记机构/理赔登记机构的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性理赔登记机构/理赔登记机构的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**
	 * 属性经办人代码/经办人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性经办人代码/经办人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性归属业务员代码/归属业务员代码的setter方法
	 */
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}
	/**
	 * 属性核价人代码/核价人代码的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性核价人代码/核价人代码的setter方法
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}
	/**
	 * 属性核损人代码/核损人代码的getter方法
	 */
	public String getUnderWriteCode() {
		return underWriteCode;
	}
	/**
	 * 属性核损人代码/核损人代码的setter方法
	 */
	public void setUnderWriteCode(String underWriteCode) {
		this.underWriteCode = underWriteCode;
	}
	/**
	 * 属性核损人名称/核损人名称的getter方法
	 */
	public String getUnderwriteName() {
		return underwriteName;
	}
	/**
	 * 属性核损人名称/核损人名称的setter方法
	 */
	public void setUnderwriteName(String underwriteName) {
		this.underwriteName = underwriteName;
	}
	/**
	 * 属性批单统计年月/批单统计年月的getter方法
	 */
	public java.util.Date getStatisticSym() {
		return statisticSym;
	}
	/**
	 * 属性批单统计年月/批单统计年月的setter方法
	 */
	public void setStatisticSym(java.util.Date statisticSym) {
		this.statisticSym = statisticSym;
	}
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}
	/**
	 * 属性最终核损完成日期/最终核损完成日期的getter方法
	 */
	public java.util.Date getUnderWriteendDate() {
		return underWriteendDate;
	}
	/**
	 * 属性最终核损完成日期/最终核损完成日期的setter方法
	 */
	public void setUnderWriteendDate(java.util.Date underWriteendDate) {
		this.underWriteendDate = underWriteendDate;
	}
	/**
	 * 属性是否经过核损标志/是否经过核损标志的getter方法
	 */
	public String getUnderWriteFlag() {
		return underWriteFlag;
	}
	/**
	 * 属性是否经过核损标志/是否经过核损标志的setter方法
	 */
	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
	}
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性特殊赔案类别/特殊赔案类别的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性特殊赔案类别/特殊赔案类别的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	/**
	 * 属性车险平台上传序号/车险平台上传序号的getter方法
	 */
	public String getUploadSerialNo() {
		return uploadSerialNo;
	}
	/**
	 * 属性车险平台上传序号/车险平台上传序号的setter方法
	 */
	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}
	/**
	 * 属性实付日期/实付日期的getter方法
	 */
	public java.util.Date getPayrefDate() {
		return payrefDate;
	}
	/**
	 * 属性实付日期/实付日期的setter方法
	 */
	public void setPayrefDate(java.util.Date payrefDate) {
		this.payrefDate = payrefDate;
	}
	/**
	 * 属性险别/险别的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别/险别的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
	 * 属性费用类型/费用类型的getter方法
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * 属性费用类型/费用类型的setter方法
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * 属性事故责任/事故责任的getter方法
	 */
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	/**
	 * 属性事故责任/事故责任的setter方法
	 */
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	/**
	 * 属性赔款费用总额/赔款费用总额的getter方法
	 */
	public Integer getSumPrechargePaid() {
		return sumPrechargePaid;
	}
	/**
	 * 属性赔款费用总额/赔款费用总额的setter方法
	 */
	public void setSumPrechargePaid(Integer sumPrechargePaid) {
		this.sumPrechargePaid = sumPrechargePaid;
	}	
	/**
	 * 属性关联的预赔号/关联的预赔号的getter方法
	 */
	public String getRelateprecompensateNo() {
		return relateprecompensateNo;
	}
	/**
	 * 属性关联的预赔号/关联的预赔号的setter方法
	 */
	public void setRelateprecompensateNo(String relateprecompensateNo) {
		this.relateprecompensateNo = relateprecompensateNo;
	}	
}
