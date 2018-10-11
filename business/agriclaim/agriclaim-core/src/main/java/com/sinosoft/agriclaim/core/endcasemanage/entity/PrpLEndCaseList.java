package com.sinosoft.agriclaim.core.endcasemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * 结案基本信息表实体操作对象
 */
@Entity
@Table(name = "PrpLEndCaseList")
@IdClass(PrpLEndCaseListKey.class)
public class PrpLEndCaseList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性id主键/id主键 */
	@Id
	@Column(name = "id")
	private java.lang.Integer id ;	

	/** 属性机构代码/机构代码 */
	@Column(name = "claimcomCode")
	private String claimcomCode ;
	/** 属性机构中文名称/机构中文名称 */
	@Column(name = "claimcomCName")
	private String claimcomCName ;
	/** 属性机构代码3/机构代码3 */
	@Column(name = "claimcomCode3")
	private String claimcomCode3 ;
	/** 属性机构名称3/机构名称3 */
	@Column(name = "claimcomCname3")
	private String claimcomCname3 ;
	/** 属性公司代码/公司代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性公司名称/公司名称 */
	@Column(name = "comCName")
	private String comCName ;
	/** 属性公司代码3/公司代码3 */
	@Column(name = "comCode3")
	private String comCode3 ;
	/** 属性公司名称3/公司名称3 */
	@Column(name = "comCName3")
	private String comCName3 ;
	/** 属性被保险人代码/被保险人代码 */
	@Column(name = "insuredCode")
	private String insuredCode ;
	/** 属性被保险人类型/被保险人类型 */
	@Column(name = "insuredType")
	private String insuredType ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性起保日期/起保日期 */
	@Column(name = "startDate")
	private String startDate ;
	/** 属性出险日期/出险日期 */
	@Column(name = "damageStartDate")
	private String damageStartDate ;
	/** 属性报案日期/报案日期 */
	@Column(name = "reportDate")
	private String reportDate ;
	/** 属性查勘结束日期/查勘结束日期 */
	@Column(name = "checkEndDate")
	private String checkEndDate ;
	/** 属性理赔应用日期/理赔应用日期 */
	@Column(name = "claimApplyDate")
	private String claimApplyDate ;
	/** 属性责任决定日期/责任决定日期 */
	@Column(name = "dutyDecideDate")
	private String dutyDecideDate ;
	/** 属性立案日期/立案日期 */
	@Column(name = "claimDate")
	private String claimDate ;
	/** 属性销案日期/销案日期 */
	@Column(name = "cancleDate")
	private String cancleDate ;
	/** 属性案例开始日期/案例开始日期 */
	@Column(name = "openCasetDate")
	private String openCasetDate ;
	/** 属性案例开始时间/案例开始时间 */
	@Column(name = "openCaseTimes")
	private String openCaseTimes ;
	/** 属性否认日期/否认日期 */
	@Column(name = "repudiationDate")
	private String repudiationDate ;
	/** 属性伤口开始日期/伤口开始日期 */
	@Column(name = "woundBeginDate")
	private String woundBeginDate ;
	/** 属性工作开始日期/工作开始日期 */
	@Column(name = "veriwendDate")
	private String veriwendDate ;
	/** 属性计划开始日期/计划开始日期 */
	@Column(name = "certaBeginDate")
	private String certaBeginDate ;
	/** 属性工作结束日期/工作结束日期 */
	@Column(name = "verifEndDate")
	private String verifEndDate ;
	/** 属性开始日期/开始日期 */
	@Column(name = "propcBeginDate")
	private String propcBeginDate ;
	/** 属性结束日期/结束日期 */
	@Column(name = "propvEndDate")
	private String propvEndDate ;
	/** 属性认证日期/认证日期 */
	@Column(name = "certiDate")
	private String certiDate ;
	/** 属性核保/赔日期/核保/赔日期 */
	@Column(name = "underWriteDate")
	private String underWriteDate ;
	/** 属性支付日期/支付日期 */
	@Column(name = "payDate")
	private String payDate ;
	/** 属性支付对象/支付对象 */
	@Column(name = "payObject")
	private String payObject ;
	/** 属性结案日期/结案日期 */
	@Column(name = "endCaseDate")
	private String endCaseDate ;
	/** 属性案件类型/案件类型 */
	@Column(name = "caseType")
	private String caseType ;
	/** 属性是否诉讼/是否诉讼 */
	@Column(name = "isLitigation")
	private String isLitigation ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性险种名称/险种名称 */
	@Column(name = "riskCName")
	private String riskCName ;
	/** 属性是否通赔/是否通赔 */
	@Column(name = "isAllClaim")
	private String isAllClaim ;
	/** 属性估损金额/估损金额 */
	@Column(name = "sumClaim")
	private String sumClaim ;
	/** 属性车险估损金额/车险估损金额 */
	@Column(name = "sumClaimCar")
	private String sumClaimCar ;
	/** 属性理赔金额/理赔金额 */
	@Column(name = "sumClaimProp")
	private String sumClaimProp ;
	/** 属性理赔人员/理赔人员 */
	@Column(name = "sumClaimPerson")
	private String sumClaimPerson ;
	/** 属性理赔费用总额/理赔费用总额 */
	@Column(name = "sumClaimFee")
	private String sumClaimFee ;
	/** 属性总赔付金额/总赔付金额 */
	@Column(name = "sumPaid")
	private String sumPaid ;
	/** 属性车险赔付总金额/车险赔付总金额 */
	@Column(name = "sumPaidCar")
	private String sumPaidCar ;
	/** 属性额外总支付/额外总支付 */
	@Column(name = "sumPaidProp")
	private String sumPaidProp ;
	/** 属性支付费用人/支付费用人 */
	@Column(name = "sumPaidPerson")
	private String sumPaidPerson ;
	/** 属性支付费用总额/支付费用总额 */
	@Column(name = "sumPaidFee")
	private String sumPaidFee ;
	/** 属性处理人姓名/处理人姓名 */
	@Column(name = "handlerName")
	private String handlerName ;
	/** 属性赔案原因/赔案原因 */
	@Column(name = "claimReason")
	private String claimReason ;
	/** 属性赔案责任原因/赔案责任原因 */
	@Column(name = "claimDutyReason")
	private String claimDutyReason ;
	/** 属性公司意见/公司意见 */
	@Column(name = "companyOpinion")
	private String companyOpinion ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性暂无/暂无 */
	@Column(name = "drawDate")
	private String drawDate ;
	/** 属性标志位/标志位 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性id主键/id主键的getter方法
	 */
	public java.lang.Integer getId() {
		return id;
	}
	/**
	 * 属性id主键/id主键的setter方法
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	} 	
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getClaimcomCode() {
		return claimcomCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setClaimcomCode(String claimcomCode) {
		this.claimcomCode = claimcomCode;
	} 	
	/**
	 * 属性机构中文名称/机构中文名称的getter方法
	 */
	public String getClaimcomCName() {
		return claimcomCName;
	}
	/**
	 * 属性机构中文名称/机构中文名称的setter方法
	 */
	public void setClaimcomCName(String claimcomCName) {
		this.claimcomCName = claimcomCName;
	} 	
	/**
	 * 属性机构代码3/机构代码3的getter方法
	 */
	public String getClaimcomCode3() {
		return claimcomCode3;
	}
	/**
	 * 属性机构代码3/机构代码3的setter方法
	 */
	public void setClaimcomCode3(String claimcomCode3) {
		this.claimcomCode3 = claimcomCode3;
	} 	
	/**
	 * 属性机构名称3/机构名称3的getter方法
	 */
	public String getClaimcomCname3() {
		return claimcomCname3;
	}
	/**
	 * 属性机构名称3/机构名称3的setter方法
	 */
	public void setClaimcomCname3(String claimcomCname3) {
		this.claimcomCname3 = claimcomCname3;
	} 	
	/**
	 * 属性公司代码/公司代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性公司代码/公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性公司名称/公司名称的getter方法
	 */
	public String getComCName() {
		return comCName;
	}
	/**
	 * 属性公司名称/公司名称的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	} 	
	/**
	 * 属性公司代码3/公司代码3的getter方法
	 */
	public String getComCode3() {
		return comCode3;
	}
	/**
	 * 属性公司代码3/公司代码3的setter方法
	 */
	public void setComCode3(String comCode3) {
		this.comCode3 = comCode3;
	} 	
	/**
	 * 属性公司名称3/公司名称3的getter方法
	 */
	public String getComCName3() {
		return comCName3;
	}
	/**
	 * 属性公司名称3/公司名称3的setter方法
	 */
	public void setComCName3(String comCName3) {
		this.comCName3 = comCName3;
	} 	
	/**
	 * 属性被保险人代码/被保险人代码的getter方法
	 */
	public String getInsuredCode() {
		return insuredCode;
	}
	/**
	 * 属性被保险人代码/被保险人代码的setter方法
	 */
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	} 	
	/**
	 * 属性被保险人类型/被保险人类型的getter方法
	 */
	public String getInsuredType() {
		return insuredType;
	}
	/**
	 * 属性被保险人类型/被保险人类型的setter方法
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
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
	 * 属性起保日期/起保日期的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期/起保日期的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性出险日期/出险日期的getter方法
	 */
	public String getDamageStartDate() {
		return damageStartDate;
	}
	/**
	 * 属性出险日期/出险日期的setter方法
	 */
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	} 	
	/**
	 * 属性报案日期/报案日期的getter方法
	 */
	public String getReportDate() {
		return reportDate;
	}
	/**
	 * 属性报案日期/报案日期的setter方法
	 */
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	} 	
	/**
	 * 属性查勘结束日期/查勘结束日期的getter方法
	 */
	public String getCheckEndDate() {
		return checkEndDate;
	}
	/**
	 * 属性查勘结束日期/查勘结束日期的setter方法
	 */
	public void setCheckEndDate(String checkEndDate) {
		this.checkEndDate = checkEndDate;
	} 	
	/**
	 * 属性理赔应用日期/理赔应用日期的getter方法
	 */
	public String getClaimApplyDate() {
		return claimApplyDate;
	}
	/**
	 * 属性理赔应用日期/理赔应用日期的setter方法
	 */
	public void setClaimApplyDate(String claimApplyDate) {
		this.claimApplyDate = claimApplyDate;
	} 	
	/**
	 * 属性责任决定日期/责任决定日期的getter方法
	 */
	public String getDutyDecideDate() {
		return dutyDecideDate;
	}
	/**
	 * 属性责任决定日期/责任决定日期的setter方法
	 */
	public void setDutyDecideDate(String dutyDecideDate) {
		this.dutyDecideDate = dutyDecideDate;
	} 	
	/**
	 * 属性立案日期/立案日期的getter方法
	 */
	public String getClaimDate() {
		return claimDate;
	}
	/**
	 * 属性立案日期/立案日期的setter方法
	 */
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	} 	
	/**
	 * 属性销案日期/销案日期的getter方法
	 */
	public String getCancleDate() {
		return cancleDate;
	}
	/**
	 * 属性销案日期/销案日期的setter方法
	 */
	public void setCancleDate(String cancleDate) {
		this.cancleDate = cancleDate;
	} 	
	/**
	 * 属性案例开始日期/案例开始日期的getter方法
	 */
	public String getOpenCasetDate() {
		return openCasetDate;
	}
	/**
	 * 属性案例开始日期/案例开始日期的setter方法
	 */
	public void setOpenCasetDate(String openCasetDate) {
		this.openCasetDate = openCasetDate;
	} 	
	/**
	 * 属性案例开始时间/案例开始时间的getter方法
	 */
	public String getOpenCaseTimes() {
		return openCaseTimes;
	}
	/**
	 * 属性案例开始时间/案例开始时间的setter方法
	 */
	public void setOpenCaseTimes(String openCaseTimes) {
		this.openCaseTimes = openCaseTimes;
	} 	
	/**
	 * 属性否认日期/否认日期的getter方法
	 */
	public String getRepudiationDate() {
		return repudiationDate;
	}
	/**
	 * 属性否认日期/否认日期的setter方法
	 */
	public void setRepudiationDate(String repudiationDate) {
		this.repudiationDate = repudiationDate;
	} 	
	/**
	 * 属性伤口开始日期/伤口开始日期的getter方法
	 */
	public String getWoundBeginDate() {
		return woundBeginDate;
	}
	/**
	 * 属性伤口开始日期/伤口开始日期的setter方法
	 */
	public void setWoundBeginDate(String woundBeginDate) {
		this.woundBeginDate = woundBeginDate;
	} 	
	/**
	 * 属性工作开始日期/工作开始日期的getter方法
	 */
	public String getVeriwendDate() {
		return veriwendDate;
	}
	/**
	 * 属性工作开始日期/工作开始日期的setter方法
	 */
	public void setVeriwendDate(String veriwendDate) {
		this.veriwendDate = veriwendDate;
	} 	
	/**
	 * 属性计划开始日期/计划开始日期的getter方法
	 */
	public String getCertaBeginDate() {
		return certaBeginDate;
	}
	/**
	 * 属性计划开始日期/计划开始日期的setter方法
	 */
	public void setCertaBeginDate(String certaBeginDate) {
		this.certaBeginDate = certaBeginDate;
	} 	
	/**
	 * 属性工作结束日期/工作结束日期的getter方法
	 */
	public String getVerifEndDate() {
		return verifEndDate;
	}
	/**
	 * 属性工作结束日期/工作结束日期的setter方法
	 */
	public void setVerifEndDate(String verifEndDate) {
		this.verifEndDate = verifEndDate;
	} 	
	/**
	 * 属性开始日期/开始日期的getter方法
	 */
	public String getPropcBeginDate() {
		return propcBeginDate;
	}
	/**
	 * 属性开始日期/开始日期的setter方法
	 */
	public void setPropcBeginDate(String propcBeginDate) {
		this.propcBeginDate = propcBeginDate;
	} 	
	/**
	 * 属性结束日期/结束日期的getter方法
	 */
	public String getPropvEndDate() {
		return propvEndDate;
	}
	/**
	 * 属性结束日期/结束日期的setter方法
	 */
	public void setPropvEndDate(String propvEndDate) {
		this.propvEndDate = propvEndDate;
	} 	
	/**
	 * 属性认证日期/认证日期的getter方法
	 */
	public String getCertiDate() {
		return certiDate;
	}
	/**
	 * 属性认证日期/认证日期的setter方法
	 */
	public void setCertiDate(String certiDate) {
		this.certiDate = certiDate;
	} 	
	/**
	 * 属性核保/赔日期/核保/赔日期的getter方法
	 */
	public String getUnderWriteDate() {
		return underWriteDate;
	}
	/**
	 * 属性核保/赔日期/核保/赔日期的setter方法
	 */
	public void setUnderWriteDate(String underWriteDate) {
		this.underWriteDate = underWriteDate;
	} 	
	/**
	 * 属性支付日期/支付日期的getter方法
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * 属性支付日期/支付日期的setter方法
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	} 	
	/**
	 * 属性支付对象/支付对象的getter方法
	 */
	public String getPayObject() {
		return payObject;
	}
	/**
	 * 属性支付对象/支付对象的setter方法
	 */
	public void setPayObject(String payObject) {
		this.payObject = payObject;
	} 	
	/**
	 * 属性结案日期/结案日期的getter方法
	 */
	public String getEndCaseDate() {
		return endCaseDate;
	}
	/**
	 * 属性结案日期/结案日期的setter方法
	 */
	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	} 	
	/**
	 * 属性案件类型/案件类型的getter方法
	 */
	public String getCaseType() {
		return caseType;
	}
	/**
	 * 属性案件类型/案件类型的setter方法
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	} 	
	/**
	 * 属性是否诉讼/是否诉讼的getter方法
	 */
	public String getIsLitigation() {
		return isLitigation;
	}
	/**
	 * 属性是否诉讼/是否诉讼的setter方法
	 */
	public void setIsLitigation(String isLitigation) {
		this.isLitigation = isLitigation;
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
	 * 属性险种名称/险种名称的getter方法
	 */
	public String getRiskCName() {
		return riskCName;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	} 	
	/**
	 * 属性是否通赔/是否通赔的getter方法
	 */
	public String getIsAllClaim() {
		return isAllClaim;
	}
	/**
	 * 属性是否通赔/是否通赔的setter方法
	 */
	public void setIsAllClaim(String isAllClaim) {
		this.isAllClaim = isAllClaim;
	} 	
	/**
	 * 属性估损金额/估损金额的getter方法
	 */
	public String getSumClaim() {
		return sumClaim;
	}
	/**
	 * 属性估损金额/估损金额的setter方法
	 */
	public void setSumClaim(String sumClaim) {
		this.sumClaim = sumClaim;
	} 	
	/**
	 * 属性车险估损金额/车险估损金额的getter方法
	 */
	public String getSumClaimCar() {
		return sumClaimCar;
	}
	/**
	 * 属性车险估损金额/车险估损金额的setter方法
	 */
	public void setSumClaimCar(String sumClaimCar) {
		this.sumClaimCar = sumClaimCar;
	} 	
	/**
	 * 属性理赔金额/理赔金额的getter方法
	 */
	public String getSumClaimProp() {
		return sumClaimProp;
	}
	/**
	 * 属性理赔金额/理赔金额的setter方法
	 */
	public void setSumClaimProp(String sumClaimProp) {
		this.sumClaimProp = sumClaimProp;
	} 	
	/**
	 * 属性理赔人员/理赔人员的getter方法
	 */
	public String getSumClaimPerson() {
		return sumClaimPerson;
	}
	/**
	 * 属性理赔人员/理赔人员的setter方法
	 */
	public void setSumClaimPerson(String sumClaimPerson) {
		this.sumClaimPerson = sumClaimPerson;
	} 	
	/**
	 * 属性理赔费用总额/理赔费用总额的getter方法
	 */
	public String getSumClaimFee() {
		return sumClaimFee;
	}
	/**
	 * 属性理赔费用总额/理赔费用总额的setter方法
	 */
	public void setSumClaimFee(String sumClaimFee) {
		this.sumClaimFee = sumClaimFee;
	} 	
	/**
	 * 属性总赔付金额/总赔付金额的getter方法
	 */
	public String getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性总赔付金额/总赔付金额的setter方法
	 */
	public void setSumPaid(String sumPaid) {
		this.sumPaid = sumPaid;
	} 	
	/**
	 * 属性车险赔付总金额/车险赔付总金额的getter方法
	 */
	public String getSumPaidCar() {
		return sumPaidCar;
	}
	/**
	 * 属性车险赔付总金额/车险赔付总金额的setter方法
	 */
	public void setSumPaidCar(String sumPaidCar) {
		this.sumPaidCar = sumPaidCar;
	} 	
	/**
	 * 属性额外总支付/额外总支付的getter方法
	 */
	public String getSumPaidProp() {
		return sumPaidProp;
	}
	/**
	 * 属性额外总支付/额外总支付的setter方法
	 */
	public void setSumPaidProp(String sumPaidProp) {
		this.sumPaidProp = sumPaidProp;
	} 	
	/**
	 * 属性支付费用人/支付费用人的getter方法
	 */
	public String getSumPaidPerson() {
		return sumPaidPerson;
	}
	/**
	 * 属性支付费用人/支付费用人的setter方法
	 */
	public void setSumPaidPerson(String sumPaidPerson) {
		this.sumPaidPerson = sumPaidPerson;
	} 	
	/**
	 * 属性支付费用总额/支付费用总额的getter方法
	 */
	public String getSumPaidFee() {
		return sumPaidFee;
	}
	/**
	 * 属性支付费用总额/支付费用总额的setter方法
	 */
	public void setSumPaidFee(String sumPaidFee) {
		this.sumPaidFee = sumPaidFee;
	} 	
	/**
	 * 属性处理人姓名/处理人姓名的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性处理人姓名/处理人姓名的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	} 	
	/**
	 * 属性赔案原因/赔案原因的getter方法
	 */
	public String getClaimReason() {
		return claimReason;
	}
	/**
	 * 属性赔案原因/赔案原因的setter方法
	 */
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	} 	
	/**
	 * 属性赔案责任原因/赔案责任原因的getter方法
	 */
	public String getClaimDutyReason() {
		return claimDutyReason;
	}
	/**
	 * 属性赔案责任原因/赔案责任原因的setter方法
	 */
	public void setClaimDutyReason(String claimDutyReason) {
		this.claimDutyReason = claimDutyReason;
	} 	
	/**
	 * 属性公司意见/公司意见的getter方法
	 */
	public String getCompanyOpinion() {
		return companyOpinion;
	}
	/**
	 * 属性公司意见/公司意见的setter方法
	 */
	public void setCompanyOpinion(String companyOpinion) {
		this.companyOpinion = companyOpinion;
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
	 * 属性暂无/暂无的getter方法
	 */
	public String getDrawDate() {
		return drawDate;
	}
	/**
	 * 属性暂无/暂无的setter方法
	 */
	public void setDrawDate(String drawDate) {
		this.drawDate = drawDate;
	} 	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}