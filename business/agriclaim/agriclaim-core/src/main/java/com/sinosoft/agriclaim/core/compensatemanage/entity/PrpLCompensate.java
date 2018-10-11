package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算书表实体操作对象
 */
@Entity
@Table(name = "PrpLCompensate")
@IdClass(PrpLCompensateKey.class)
public class PrpLCompensate extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号码/赔款计算书号码 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;

	/** 属性理赔类型/理赔类型 */
	@Column(name = "lFlag")
	private String lFlag ;
	/** 属性赔案号/赔案号 */
	@Column(name = "caseNo")
	private String caseNo ;
	/** 属性次数/次数 */
	@Column(name = "times")
	private java.lang.Integer times ;
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性免赔条件字段/免赔条件字段 */
	@Column(name = "deductCond")
	private String deductCond ;
	/** 属性终到日期/终到日期 */
	@Column(name = "preserveDate")
	private java.util.Date preserveDate ;
	/** 属性理赔代理人代码/理赔代理人代码 */
	@Column(name = "checkAgentCode")
	private String checkAgentCode ;
	/** 属性理赔代理人名称/理赔代理人名称 */
	@Column(name = "checkAgentName")
	private String checkAgentName ;
	/** 属性检验人名称/检验人名称 */
	@Column(name = "surveyOrName")
	private String surveyOrName ;
	/** 属性索赔人名称/索赔人名称 */
	@Column(name = "counterClaimerName")
	private String counterClaimerName ;
	/** 属性航方责任/航方责任 */
	@Column(name = "dutyDescription")
	private String dutyDescription ;
	/** 属性币别代码/币别代码 */
	@Column(name = "currency")
	private String currency ;
	/** 属性标的损失金额/标的损失金额 */
	@Column(name = "sumLoss")
	private java.lang.Double sumLoss ;
	/** 属性损余金额/损余金额 */
	@Column(name = "sumRest")
	private java.lang.Double sumRest ;
	/** 属性责任赔款合计/责任赔款合计 */
	@Column(name = "sumDutyPaid")
	private java.lang.Double sumDutyPaid ;
	/** 属性不计入赔款的费用金额/不计入赔款的费用金额 */
	@Column(name = "sumNoDutyFee")
	private java.lang.Double sumNoDutyFee ;
	/** 属性总赔付金额/总赔付金额 */
	@Column(name = "sumPaid")
	private java.lang.Double sumPaid ;
	/** 属性已预付赔款/已预付赔款 */
	@Column(name = "sumPrepaid")
	private java.lang.Double sumPrepaid ;
	/** 属性本次赔付金额/本次赔付金额 */
	@Column(name = "sumThisPaid")
	private java.lang.Double sumThisPaid ;
	/** 属性领赔款单位/领赔款单位 */
	@Column(name = "receiverName")
	private String receiverName ;
	/** 属性开户银行/开户银行 */
	@Column(name = "bank")
	private String bank ;
	/** 属性银行帐号/银行帐号 */
	@Column(name = "account")
	private String account ;
	/** 属性出单机构/出单机构 */
	@Column(name = "makeCom")
	private String makeCom ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性经办人代码/经办人代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性归属业务员代码/归属业务员代码 */
	@Column(name = "handler1Code")
	private String handler1Code ;
	/** 属性复核员代码/复核员代码 */
	@Column(name = "approverCode")
	private String approverCode ;
	/** 属性最终核赔人代码/最终核赔人代码 */
	@Column(name = "underwriteCode")
	private String underwriteCode ;
	/** 属性最终核赔人名称/最终核赔人名称 */
	@Column(name = "underwritEName")
	private String underwritEName ;
	/** 属性统计年月/统计年月 */
	@Column(name = "statisticSym")
	private java.util.Date statisticSym ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性计算机输入日期/计算机输入日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性核赔完成日期/核赔完成日期 */
	@Column(name = "underWriteEndDate")
	private java.util.Date underWriteEndDate ;
	/** 属性核赔标志1/核赔标志1 */
	@Column(name = "underWriteFlag")
	private String underWriteFlag ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性案件性质/案件性质 */
	@Column(name = "caseType")
	private String caseType ;
	/** 属性责任比例/责任比例 */
	@Column(name = "indemnityDutyRate")
	private java.lang.Double indemnityDutyRate ;
	/** 属性赔偿责任代码/赔偿责任代码 */
	@Column(name = "indemnityDuty")
	private String indemnityDuty ;
	/** 属性最终计算书标志/最终计算书标志 */
	@Column(name = "finallyFlag")
	private String finallyFlag ;
	/** 属性理赔结论/理赔结论 */
	@Column(name = "result")
	private String result ;
	/** 属性赔付数量/赔付数量 */
	@Column(name = "lossesNumber")
	private java.lang.Double lossesNumber ;
	/** 属性赔付数量计量单位/赔付数量计量单位 */
	@Column(name = "lossesUnitCode")
	private String lossesUnitCode ;
	/** 属性出险户次/出险户次 */
	@Column(name = "damageInsured")
	private java.lang.Double damageInsured ;
	/** 属性受灾面积/受灾面积 */
	@Column(name = "disasterArea")
	private java.lang.Double disasterArea ;
	/** 属性受灾面积计量单位/受灾面积计量单位 */
	@Column(name = "disasterUnit")
	private String disasterUnit ;
	/** 属性成灾面积/成灾面积 */
	@Column(name = "affectedArea")
	private java.lang.Double affectedArea ;
	/** 属性成灾面积计量单位/成灾面积计量单位 */
	@Column(name = "affectedUnit")
	private String affectedUnit ;
	/** 属性绝产面积/绝产面积 */
	@Column(name = "noProductionArea")
	private java.lang.Double noProductionArea ;
	/** 属性绝产面积计量单位/绝产面积计量单位 */
	@Column(name = "noProductionUnit")
	private String noProductionUnit ;
	/** 属性死亡数量/死亡数量 */
	@Column(name = "deathQuantity")
	private java.lang.Double deathQuantity ;
	/** 属性死亡数量计量单位/死亡数量计量单位 */
	@Column(name = "deathUnit")
	private String deathUnit ;
	/** 属性扑杀数量/扑杀数量 */
	@Column(name = "killQuantity")
	private java.lang.Double killQuantity ;
	/** 属性扑杀数量计量单位/扑杀数量计量单位 */
	@Column(name = "killUnit")
	private String killUnit ;
	/** 属性农业/涉农/非农/农业/涉农/非农 */
	@Column(name = "businessType")
	private String businessType ;
	/** 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性 */
	@Column(name = "businessType1")
	private String businessType1 ;
	/** 属性医疗类型/医疗类型 */
	@Column(name = "medicalType")
	private String medicalType ;
	/** 属性伤势程度/伤势程度 */
	@Column(name = "woundGrade")
	private String woundGrade ;
	/** 属性赔案类别/赔案类别 */
	@Column(name = "claimType")
	private String claimType ;
	/** 属性三者车牌号/三者车牌号 */
	@Column(name = "thridLicenseNo")
	private String thridLicenseNo ;
	/** 属性三者车承保公司/三者车承保公司 */
	@Column(name = "thridCompany")
	private String thridCompany ;
	/** 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务 */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性其他标志/其他标志 */
	@Column(name = "otherFlag")
	private String otherFlag ;
	/** 属性对象名称/对象名称 */
	@Column(name = "objectName")
	private String objectName ;
	/** 属性对象证件类型/对象证件类型 */
	@Column(name = "objectType")
	private String objectType ;
	/** 属性对象证件号码/对象证件号码 */
	@Column(name = "objectCode")
	private String objectCode ;
	/** 属性车险平台赔付接口上传序号/车险平台赔付接口上传序号 */
	@Column(name = "uploadSerialNo")
	private String uploadSerialNo ;
	/** 属性实付时间/实付时间 */
	@Column(name = "payrefDate")
	private java.util.Date payrefDate ;
	/** 属性理赔清单关联号/理赔清单关联号 */
	@Column(name = "claimRelationNo")
	private String claimRelationNo ;
	/** 属性计算书标志/计算书标志 */
	@Column(name = "prpLCompensateFlag")
	private String prpLCompensateFlag ;
	/** 属性关联计算书号/关联计算书号 */
	@Column(name = "relatedCompensateNo")
	private String relatedCompensateNo ;
	/** 属性追偿标志/追偿标志 */
	@Column(name = "recoveryFlag")
	private String recoveryFlag ;
	/** 属性追偿类型/追偿类型 */
	@Column(name = "recoveryType")
	private String recoveryType ;
	/** 属性追偿金额/追偿金额 */
	@Column(name = "recoveryAmount")
	private java.lang.Double recoveryAmount ;
	/** 属性计算书上传标识/计算书上传标识 */
	@Column(name = "compensateUploadFlag")
	private String compensateUploadFlag ;
	/** 属性核赔退回标志/核赔退回标志 */
	@Column(name = "isVericBack")
	private String isVericBack ;
	/** 属性赔付类型/赔付类型 */
	@Column(name = "peiFuType")
	private String peiFuType ;
	/** 属性零赔付原因/零赔付原因 */
	@Column(name = "zeroLossType")
	private String zeroLossType ;
	/** 属性注销拒赔类型/注销拒赔类型 */
	@Column(name = "zeroLossCaseType")
	private String zeroLossCaseType ;
	/** 属性详细原因/详细原因 */
	@Column(name = "zeroLossDetailReason")
	private String zeroLossDetailReason ;
	/** 属性属性coinspaidlosstype/属性coinspaidlosstype */
	@Column(name = "coinsPaidLossType")
	private String coinsPaidLossType ;
	/** 属性属性coinssumpaid/属性coinssumpaid */
	@Column(name = "coinsSumPaid")
	private java.lang.Double coinsSumPaid ;
	/** 属性属性reopenedtype/属性reopenedtype */
	@Column(name = "reOpenedType")
	private String reOpenedType ;
	/** 属性是否涉诉/是否涉诉 */
	@Column(name = "lawsuitFlag")
	private String lawsuitFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/** 属性是否理赔公示/是否理赔公示 */
	@Column(name = "claimNotification")
	private String claimNotification ;
	/** 属性是否无公害化处理/是否无公害化处理 */
	@Column(name = "inncentTreatment")
	private String inncentTreatment ;
	@Column(name = "growthPeriod")
	private String growthPeriod;
	/** 出险方式*/
	@Column(name="damageWay")
	private String damageWay;
	/** 溃塘程度/漫塘时间*/
	@Column(name="damageDegree")
	private String damageDegree;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	/**
	 * 属性赔款计算书号码/赔款计算书号码的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号码/赔款计算书号码的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 	
	/**
	 * 属性理赔类型/理赔类型的getter方法
	 */
	public String getLFlag() {
		return lFlag;
	}
	/**
	 * 属性理赔类型/理赔类型的setter方法
	 */
	public void setLFlag(String lFlag) {
		this.lFlag = lFlag;
	} 	
	/**
	 * 属性赔案号/赔案号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性赔案号/赔案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	} 	
	/**
	 * 属性次数/次数的getter方法
	 */
	public java.lang.Integer getTimes() {
		return times;
	}
	/**
	 * 属性次数/次数的setter方法
	 */
	public void setTimes(java.lang.Integer times) {
		this.times = times;
	} 	
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	 * 属性免赔条件字段/免赔条件字段的getter方法
	 */
	public String getDeductCond() {
		return deductCond;
	}
	/**
	 * 属性免赔条件字段/免赔条件字段的setter方法
	 */
	public void setDeductCond(String deductCond) {
		this.deductCond = deductCond;
	} 	
	/**
	 * 属性终到日期/终到日期的getter方法
	 */
	public java.util.Date getPreserveDate() {
		return preserveDate;
	}
	/**
	 * 属性终到日期/终到日期的setter方法
	 */
	public void setPreserveDate(java.util.Date preserveDate) {
		this.preserveDate = preserveDate;
	} 	
	/**
	 * 属性理赔代理人代码/理赔代理人代码的getter方法
	 */
	public String getCheckAgentCode() {
		return checkAgentCode;
	}
	/**
	 * 属性理赔代理人代码/理赔代理人代码的setter方法
	 */
	public void setCheckAgentCode(String checkAgentCode) {
		this.checkAgentCode = checkAgentCode;
	} 	
	/**
	 * 属性理赔代理人名称/理赔代理人名称的getter方法
	 */
	public String getCheckAgentName() {
		return checkAgentName;
	}
	/**
	 * 属性理赔代理人名称/理赔代理人名称的setter方法
	 */
	public void setCheckAgentName(String checkAgentName) {
		this.checkAgentName = checkAgentName;
	} 	
	/**
	 * 属性检验人名称/检验人名称的getter方法
	 */
	public String getSurveyOrName() {
		return surveyOrName;
	}
	/**
	 * 属性检验人名称/检验人名称的setter方法
	 */
	public void setSurveyOrName(String surveyOrName) {
		this.surveyOrName = surveyOrName;
	} 	
	/**
	 * 属性索赔人名称/索赔人名称的getter方法
	 */
	public String getCounterClaimerName() {
		return counterClaimerName;
	}
	/**
	 * 属性索赔人名称/索赔人名称的setter方法
	 */
	public void setCounterClaimerName(String counterClaimerName) {
		this.counterClaimerName = counterClaimerName;
	} 	
	/**
	 * 属性航方责任/航方责任的getter方法
	 */
	public String getDutyDescription() {
		return dutyDescription;
	}
	/**
	 * 属性航方责任/航方责任的setter方法
	 */
	public void setDutyDescription(String dutyDescription) {
		this.dutyDescription = dutyDescription;
	} 	
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性标的损失金额/标的损失金额的getter方法
	 */
	public java.lang.Double getSumLoss() {
		return sumLoss;
	}
	/**
	 * 属性标的损失金额/标的损失金额的setter方法
	 */
	public void setSumLoss(java.lang.Double sumLoss) {
		this.sumLoss = sumLoss;
	} 	
	/**
	 * 属性损余金额/损余金额的getter方法
	 */
	public java.lang.Double getSumRest() {
		return sumRest;
	}
	/**
	 * 属性损余金额/损余金额的setter方法
	 */
	public void setSumRest(java.lang.Double sumRest) {
		this.sumRest = sumRest;
	} 	
	/**
	 * 属性责任赔款合计/责任赔款合计的getter方法
	 */
	public java.lang.Double getSumDutyPaid() {
		return sumDutyPaid;
	}
	/**
	 * 属性责任赔款合计/责任赔款合计的setter方法
	 */
	public void setSumDutyPaid(java.lang.Double sumDutyPaid) {
		this.sumDutyPaid = sumDutyPaid;
	} 	
	/**
	 * 属性不计入赔款的费用金额/不计入赔款的费用金额的getter方法
	 */
	public java.lang.Double getSumNoDutyFee() {
		return sumNoDutyFee;
	}
	/**
	 * 属性不计入赔款的费用金额/不计入赔款的费用金额的setter方法
	 */
	public void setSumNoDutyFee(java.lang.Double sumNoDutyFee) {
		this.sumNoDutyFee = sumNoDutyFee;
	} 	
	/**
	 * 属性总赔付金额/总赔付金额的getter方法
	 */
	public java.lang.Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性总赔付金额/总赔付金额的setter方法
	 */
	public void setSumPaid(java.lang.Double sumPaid) {
		this.sumPaid = sumPaid;
	} 	
	/**
	 * 属性已预付赔款/已预付赔款的getter方法
	 */
	public java.lang.Double getSumPrepaid() {
		return sumPrepaid;
	}
	/**
	 * 属性已预付赔款/已预付赔款的setter方法
	 */
	public void setSumPrepaid(java.lang.Double sumPrepaid) {
		this.sumPrepaid = sumPrepaid;
	} 	
	/**
	 * 属性本次赔付金额/本次赔付金额的getter方法
	 */
	public java.lang.Double getSumThisPaid() {
		return sumThisPaid;
	}
	/**
	 * 属性本次赔付金额/本次赔付金额的setter方法
	 */
	public void setSumThisPaid(java.lang.Double sumThisPaid) {
		this.sumThisPaid = sumThisPaid;
	} 	
	/**
	 * 属性领赔款单位/领赔款单位的getter方法
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 属性领赔款单位/领赔款单位的setter方法
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	} 	
	/**
	 * 属性开户银行/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性开户银行/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 	
	/**
	 * 属性银行帐号/银行帐号的getter方法
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 属性银行帐号/银行帐号的setter方法
	 */
	public void setAccount(String account) {
		this.account = account;
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
	 * 属性复核员代码/复核员代码的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性复核员代码/复核员代码的setter方法
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	} 	
	/**
	 * 属性最终核赔人代码/最终核赔人代码的getter方法
	 */
	public String getUnderwriteCode() {
		return underwriteCode;
	}
	/**
	 * 属性最终核赔人代码/最终核赔人代码的setter方法
	 */
	public void setUnderwriteCode(String underwriteCode) {
		this.underwriteCode = underwriteCode;
	} 	
	/**
	 * 属性最终核赔人名称/最终核赔人名称的getter方法
	 */
	public String getUnderwritEName() {
		return underwritEName;
	}
	/**
	 * 属性最终核赔人名称/最终核赔人名称的setter方法
	 */
	public void setUnderwritEName(String underwritEName) {
		this.underwritEName = underwritEName;
	} 	
	/**
	 * 属性统计年月/统计年月的getter方法
	 */
	public java.util.Date getStatisticSym() {
		return statisticSym;
	}
	/**
	 * 属性统计年月/统计年月的setter方法
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
	 * 属性计算机输入日期/计算机输入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输入日期/计算机输入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性核赔完成日期/核赔完成日期的getter方法
	 */
	public java.util.Date getUnderWriteEndDate() {
		return underWriteEndDate;
	}
	/**
	 * 属性核赔完成日期/核赔完成日期的setter方法
	 */
	public void setUnderWriteEndDate(java.util.Date underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	} 	
	/**
	 * 属性核赔标志1/核赔标志1的getter方法
	 */
	public String getUnderWriteFlag() {
		return underWriteFlag;
	}
	/**
	 * 属性核赔标志1/核赔标志1的setter方法
	 */
	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
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
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性案件性质/案件性质的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性案件性质/案件性质的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	} 	
	/**
	 * 属性责任比例/责任比例的getter方法
	 */
	public java.lang.Double getIndemnityDutyRate() {
		return indemnityDutyRate;
	}
	/**
	 * 属性责任比例/责任比例的setter方法
	 */
	public void setIndemnityDutyRate(java.lang.Double indemnityDutyRate) {
		this.indemnityDutyRate = indemnityDutyRate;
	} 	
	/**
	 * 属性赔偿责任代码/赔偿责任代码的getter方法
	 */
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	/**
	 * 属性赔偿责任代码/赔偿责任代码的setter方法
	 */
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	} 	
	/**
	 * 属性最终计算书标志/最终计算书标志的getter方法
	 */
	public String getFinallyFlag() {
		return finallyFlag;
	}
	/**
	 * 属性最终计算书标志/最终计算书标志的setter方法
	 */
	public void setFinallyFlag(String finallyFlag) {
		this.finallyFlag = finallyFlag;
	} 	
	/**
	 * 属性理赔结论/理赔结论的getter方法
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 属性理赔结论/理赔结论的setter方法
	 */
	public void setResult(String result) {
		this.result = result;
	} 	
	/**
	 * 属性赔付数量/赔付数量的getter方法
	 */
	public java.lang.Double getLossesNumber() {
		return lossesNumber;
	}
	/**
	 * 属性赔付数量/赔付数量的setter方法
	 */
	public void setLossesNumber(java.lang.Double lossesNumber) {
		this.lossesNumber = lossesNumber;
	} 	
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的getter方法
	 */
	public String getLossesUnitCode() {
		return lossesUnitCode;
	}
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的setter方法
	 */
	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	} 	
	/**
	 * 属性出险户次/出险户次的getter方法
	 */
	public java.lang.Double getDamageInsured() {
		return damageInsured;
	}
	/**
	 * 属性出险户次/出险户次的setter方法
	 */
	public void setDamageInsured(java.lang.Double damageInsured) {
		this.damageInsured = damageInsured;
	} 	
	/**
	 * 属性受灾面积/受灾面积的getter方法
	 */
	public java.lang.Double getDisasterArea() {
		return disasterArea;
	}
	/**
	 * 属性受灾面积/受灾面积的setter方法
	 */
	public void setDisasterArea(java.lang.Double disasterArea) {
		this.disasterArea = disasterArea;
	} 	
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的getter方法
	 */
	public String getDisasterUnit() {
		return disasterUnit;
	}
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的setter方法
	 */
	public void setDisasterUnit(String disasterUnit) {
		this.disasterUnit = disasterUnit;
	} 	
	/**
	 * 属性成灾面积/成灾面积的getter方法
	 */
	public java.lang.Double getAffectedArea() {
		return affectedArea;
	}
	/**
	 * 属性成灾面积/成灾面积的setter方法
	 */
	public void setAffectedArea(java.lang.Double affectedArea) {
		this.affectedArea = affectedArea;
	} 	
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的getter方法
	 */
	public String getAffectedUnit() {
		return affectedUnit;
	}
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的setter方法
	 */
	public void setAffectedUnit(String affectedUnit) {
		this.affectedUnit = affectedUnit;
	} 	
	/**
	 * 属性绝产面积/绝产面积的getter方法
	 */
	public java.lang.Double getNoProductionArea() {
		return noProductionArea;
	}
	/**
	 * 属性绝产面积/绝产面积的setter方法
	 */
	public void setNoProductionArea(java.lang.Double noProductionArea) {
		this.noProductionArea = noProductionArea;
	} 	
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的getter方法
	 */
	public String getNoProductionUnit() {
		return noProductionUnit;
	}
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的setter方法
	 */
	public void setNoProductionUnit(String noProductionUnit) {
		this.noProductionUnit = noProductionUnit;
	} 	
	/**
	 * 属性死亡数量/死亡数量的getter方法
	 */
	public java.lang.Double getDeathQuantity() {
		return deathQuantity;
	}
	/**
	 * 属性死亡数量/死亡数量的setter方法
	 */
	public void setDeathQuantity(java.lang.Double deathQuantity) {
		this.deathQuantity = deathQuantity;
	} 	
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的getter方法
	 */
	public String getDeathUnit() {
		return deathUnit;
	}
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的setter方法
	 */
	public void setDeathUnit(String deathUnit) {
		this.deathUnit = deathUnit;
	} 	
	/**
	 * 属性扑杀数量/扑杀数量的getter方法
	 */
	public java.lang.Double getKillQuantity() {
		return killQuantity;
	}
	/**
	 * 属性扑杀数量/扑杀数量的setter方法
	 */
	public void setKillQuantity(java.lang.Double killQuantity) {
		this.killQuantity = killQuantity;
	} 	
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的getter方法
	 */
	public String getKillUnit() {
		return killUnit;
	}
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的setter方法
	 */
	public void setKillUnit(String killUnit) {
		this.killUnit = killUnit;
	} 	
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	} 	
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	} 	
	/**
	 * 属性医疗类型/医疗类型的getter方法
	 */
	public String getMedicalType() {
		return medicalType;
	}
	/**
	 * 属性医疗类型/医疗类型的setter方法
	 */
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	} 	
	/**
	 * 属性伤势程度/伤势程度的getter方法
	 */
	public String getWoundGrade() {
		return woundGrade;
	}
	/**
	 * 属性伤势程度/伤势程度的setter方法
	 */
	public void setWoundGrade(String woundGrade) {
		this.woundGrade = woundGrade;
	} 	
	/**
	 * 属性赔案类别/赔案类别的getter方法
	 */
	public String getClaimType() {
		return claimType;
	}
	/**
	 * 属性赔案类别/赔案类别的setter方法
	 */
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	} 	
	/**
	 * 属性三者车牌号/三者车牌号的getter方法
	 */
	public String getThridLicenseNo() {
		return thridLicenseNo;
	}
	/**
	 * 属性三者车牌号/三者车牌号的setter方法
	 */
	public void setThridLicenseNo(String thridLicenseNo) {
		this.thridLicenseNo = thridLicenseNo;
	} 	
	/**
	 * 属性三者车承保公司/三者车承保公司的getter方法
	 */
	public String getThridCompany() {
		return thridCompany;
	}
	/**
	 * 属性三者车承保公司/三者车承保公司的setter方法
	 */
	public void setThridCompany(String thridCompany) {
		this.thridCompany = thridCompany;
	} 	
	/**
	 * 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务的setter方法
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	} 	
	/**
	 * 属性其他标志/其他标志的getter方法
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * 属性其他标志/其他标志的setter方法
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	} 	
	/**
	 * 属性对象名称/对象名称的getter方法
	 */
	public String getObjectName() {
		return objectName;
	}
	/**
	 * 属性对象名称/对象名称的setter方法
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	} 	
	/**
	 * 属性对象证件类型/对象证件类型的getter方法
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * 属性对象证件类型/对象证件类型的setter方法
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	} 	
	/**
	 * 属性对象证件号码/对象证件号码的getter方法
	 */
	public String getObjectCode() {
		return objectCode;
	}
	/**
	 * 属性对象证件号码/对象证件号码的setter方法
	 */
	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	} 	
	/**
	 * 属性车险平台赔付接口上传序号/车险平台赔付接口上传序号的getter方法
	 */
	public String getUploadSerialNo() {
		return uploadSerialNo;
	}
	/**
	 * 属性车险平台赔付接口上传序号/车险平台赔付接口上传序号的setter方法
	 */
	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	} 	
	/**
	 * 属性实付时间/实付时间的getter方法
	 */
	public java.util.Date getPayrefDate() {
		return payrefDate;
	}
	/**
	 * 属性实付时间/实付时间的setter方法
	 */
	public void setPayrefDate(java.util.Date payrefDate) {
		this.payrefDate = payrefDate;
	} 	
	/**
	 * 属性理赔清单关联号/理赔清单关联号的getter方法
	 */
	public String getClaimRelationNo() {
		return claimRelationNo;
	}
	/**
	 * 属性理赔清单关联号/理赔清单关联号的setter方法
	 */
	public void setClaimRelationNo(String claimRelationNo) {
		this.claimRelationNo = claimRelationNo;
	} 	
	/**
	 * 属性计算书标志/计算书标志的getter方法
	 */
	public String getPrpLCompensateFlag() {
		return prpLCompensateFlag;
	}
	/**
	 * 属性计算书标志/计算书标志的setter方法
	 */
	public void setPrpLCompensateFlag(String prpLCompensateFlag) {
		this.prpLCompensateFlag = prpLCompensateFlag;
	} 	
	/**
	 * 属性关联计算书号/关联计算书号的getter方法
	 */
	public String getRelatedCompensateNo() {
		return relatedCompensateNo;
	}
	/**
	 * 属性关联计算书号/关联计算书号的setter方法
	 */
	public void setRelatedCompensateNo(String relatedCompensateNo) {
		this.relatedCompensateNo = relatedCompensateNo;
	} 	
	/**
	 * 属性追偿标志/追偿标志的getter方法
	 */
	public String getRecoveryFlag() {
		return recoveryFlag;
	}
	/**
	 * 属性追偿标志/追偿标志的setter方法
	 */
	public void setRecoveryFlag(String recoveryFlag) {
		this.recoveryFlag = recoveryFlag;
	} 	
	/**
	 * 属性追偿类型/追偿类型的getter方法
	 */
	public String getRecoveryType() {
		return recoveryType;
	}
	/**
	 * 属性追偿类型/追偿类型的setter方法
	 */
	public void setRecoveryType(String recoveryType) {
		this.recoveryType = recoveryType;
	} 	
	/**
	 * 属性追偿金额/追偿金额的getter方法
	 */
	public java.lang.Double getRecoveryAmount() {
		return recoveryAmount;
	}
	/**
	 * 属性追偿金额/追偿金额的setter方法
	 */
	public void setRecoveryAmount(java.lang.Double recoveryAmount) {
		this.recoveryAmount = recoveryAmount;
	} 	
	/**
	 * 属性计算书上传标识/计算书上传标识的getter方法
	 */
	public String getCompensateUploadFlag() {
		return compensateUploadFlag;
	}
	/**
	 * 属性计算书上传标识/计算书上传标识的setter方法
	 */
	public void setCompensateUploadFlag(String compensateUploadFlag) {
		this.compensateUploadFlag = compensateUploadFlag;
	} 	
	/**
	 * 属性核赔退回标志/核赔退回标志的getter方法
	 */
	public String getIsVericBack() {
		return isVericBack;
	}
	/**
	 * 属性核赔退回标志/核赔退回标志的setter方法
	 */
	public void setIsVericBack(String isVericBack) {
		this.isVericBack = isVericBack;
	} 	
	/**
	 * 属性赔付类型/赔付类型的getter方法
	 */
	public String getPeiFuType() {
		return peiFuType;
	}
	/**
	 * 属性赔付类型/赔付类型的setter方法
	 */
	public void setPeiFuType(String peiFuType) {
		this.peiFuType = peiFuType;
	} 	
	/**
	 * 属性零赔付原因/零赔付原因的getter方法
	 */
	public String getZeroLossType() {
		return zeroLossType;
	}
	/**
	 * 属性零赔付原因/零赔付原因的setter方法
	 */
	public void setZeroLossType(String zeroLossType) {
		this.zeroLossType = zeroLossType;
	} 	
	/**
	 * 属性注销拒赔类型/注销拒赔类型的getter方法
	 */
	public String getZeroLossCaseType() {
		return zeroLossCaseType;
	}
	/**
	 * 属性注销拒赔类型/注销拒赔类型的setter方法
	 */
	public void setZeroLossCaseType(String zeroLossCaseType) {
		this.zeroLossCaseType = zeroLossCaseType;
	} 	
	/**
	 * 属性详细原因/详细原因的getter方法
	 */
	public String getZeroLossDetailReason() {
		return zeroLossDetailReason;
	}
	/**
	 * 属性详细原因/详细原因的setter方法
	 */
	public void setZeroLossDetailReason(String zeroLossDetailReason) {
		this.zeroLossDetailReason = zeroLossDetailReason;
	} 	
	/**
	 * 属性属性coinspaidlosstype/属性coinspaidlosstype的getter方法
	 */
	public String getCoinsPaidLossType() {
		return coinsPaidLossType;
	}
	/**
	 * 属性属性coinspaidlosstype/属性coinspaidlosstype的setter方法
	 */
	public void setCoinsPaidLossType(String coinsPaidLossType) {
		this.coinsPaidLossType = coinsPaidLossType;
	} 	
	/**
	 * 属性属性coinssumpaid/属性coinssumpaid的getter方法
	 */
	public java.lang.Double getCoinsSumPaid() {
		return coinsSumPaid;
	}
	/**
	 * 属性属性coinssumpaid/属性coinssumpaid的setter方法
	 */
	public void setCoinsSumPaid(java.lang.Double coinsSumPaid) {
		this.coinsSumPaid = coinsSumPaid;
	} 	
	/**
	 * 属性属性reopenedtype/属性reopenedtype的getter方法
	 */
	public String getReOpenedType() {
		return reOpenedType;
	}
	/**
	 * 属性属性reopenedtype/属性reopenedtype的setter方法
	 */
	public void setReOpenedType(String reOpenedType) {
		this.reOpenedType = reOpenedType;
	} 	
	/**
	 * 属性是否涉诉/是否涉诉的getter方法
	 */
	public String getLawsuitFlag() {
		return lawsuitFlag;
	}
	/**
	 * 属性是否涉诉/是否涉诉的setter方法
	 */
	public void setLawsuitFlag(String lawsuitFlag) {
		this.lawsuitFlag = lawsuitFlag;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 	
	/**
	 * 属性是否理赔公示/是否理赔公示的getter方法
	 */
	public String getClaimNotification() {
		return claimNotification;
	}
	/**
	 * 属性是否理赔公示/是否理赔公示的setter方法
	 */
	public void setClaimNotification(String claimNotification) {
		this.claimNotification = claimNotification;
	} 	
	/**
	 * 属性是否无公害化处理/是否无公害化处理的getter方法
	 */
	public String getInncentTreatment() {
		return inncentTreatment;
	}
	/**
	 * 属性是否无公害化处理/是否无公害化处理的setter方法
	 */
	public void setInncentTreatment(String inncentTreatment) {
		this.inncentTreatment = inncentTreatment;
	}

	public String getGrowthPeriod() {
		return growthPeriod;
	}

	public void setGrowthPeriod(String growthPeriod) {
		this.growthPeriod = growthPeriod;
	}

	public String getDamageWay() {
		return damageWay;
	}

	public void setDamageWay(String damageWay) {
		this.damageWay = damageWay;
	}

	public String getDamageDegree() {
		return damageDegree;
	}

	public void setDamageDegree(String damageDegree) {
		this.damageDegree = damageDegree;
	}
}