package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;

/**
* @Description: 投保单查询列表信息requestDtoApi操作对象
* @Author: 何伟东
* @Date: 2017/10/15 11:19
*/
public class RequestQueryProposalListInfoDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性合同号/合同号 */
	private String contractNo ;		
	/** 属性合同号查询方法*模糊查询，=精确查询/合同号查询方法*模糊查询，=精确查询 */
	private String queryContractNoMethod ;		
	/** 属性打印标志 0 未打印 1 已打印 */
	private String printNo ;		
	/** 属性印刷号查询方法*模糊查询，=精确查询/印刷号查询方法*模糊查询，=精确查询 */
	private String queryPrintNoMethod ;		
	/** 属性投保人代码/投保人代码 */
	private String appliCode ;		
	/** 属性投保人代码查询方法*模糊查询，=精确查询/投保人代码查询方法*模糊查询，=精确查询 */
	private String queryappliCodeMethod ;		
	/** 属性投保人名称/投保人名称 */
	private String appliName ;		
	/** 属性投保人名称查询方法*模糊查询，=精确查询/投保人名称查询方法*模糊查询，=精确查询 */
	private String queryappliNameMethod ;		
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;		
	/** 属性被保险人代码查询方法*模糊查询，=精确查询/被保险人代码查询方法*模糊查询，=精确查询 */
	private String queryinsuredCodeMethod ;		
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;		
	/** 属性被保险人名称查询方法*模糊查询，=精确查询/被保险人名称查询方法*模糊查询，=精确查询 */
	private String queryinsuredNameMethod ;
	/**
	 * 属性起保日期/起保日期 区间
	 */
	private String startDate;
	private String startDateEnd ;
	/** 属性起保日期查询方法=,>=,<=,>,</起保日期查询方法=,>=,<=,>,< */
	private String querystartDateMethod;
	/** 属性终保日期/终保日期 区间*/
	private String endDate;
	private String endStartDate ;
	/** 属性终保日期查询方法=,>=,<=,>,</终保日期查询方法=,>=,<=,>,< */
	private String queryendDateMethod ;		
	/** 属性总保额/总保额 */
	private String sumAmount ;		
	/** 属性总保额查询方法*模糊查询，=精确查询/总保额查询方法*模糊查询，=精确查询 */
	private String querysumAmountMethod ;		
	/** 属性总保费/总保费 */
	private String sumPremium ;		
	/** 属性总保费查询方法*模糊查询，=精确查询/总保费查询方法*模糊查询，=精确查询 */
	private String querysumPremiumMethod ;		
	/** 属性出单机构/出单机构 */
	private String makeCom ;		
	/** 属性出单机构查询方法*模糊查询，=精确查询/出单机构查询方法*模糊查询，=精确查询 */
	private String querymakeComMethod ;		
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;		
	/** 属性经办人代码查询方法*模糊查询，=精确查询/经办人代码查询方法*模糊查询，=精确查询 */
	private String queryhandlerCodeMethod ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性操作员代码查询方法*模糊查询，=精确查询/操作员代码查询方法*模糊查询，=精确查询 */
	private String queryoperatorCodeMethod ;		
	/** 属性制单日期/制单起日期 */
	private String operateStartDate ;
	/** 属性制单日期/制单止日期 */
		private String operateDateEnd ;
	/** 属性制单日期查询方法=,>=,<=,>,</制单日期查询方法=,>=,<=,>,< */
	private String queryoperateDateMethod ;		
	/** 属性输入日期/输入日期 */
	private String inputDate ;		
	/** 属性输入日期查询方法=,>=,<=,>,</输入日期查询方法=,>=,<=,>,< */
	private String queryinputDateMethod ;		
	/** 属性核保人代码/核保人代码 */
	private String underwriteCode ;		
	/** 属性核保人代码查询方法*模糊查询，=精确查询/核保人代码查询方法*模糊查询，=精确查询 */
	private String queryunderwriteCodeMethod ;		
	/** 属性核保人名称/核保人名称 */
	private String underwriteName ;		
	/** 属性核保人名称查询方法*模糊查询，=精确查询/核保人名称查询方法*模糊查询，=精确查询 */
	private String queryunderwriteNameMethod ;		
	/** 属性核保通过日期/核保通过日期 */
	private String underwriteEndDate ;		
	/** 属性核保通过日期查询方法=,>=,<=,>,</核保通过日期查询方法=,>=,<=,>,< */
	private String queryunderwriteEndDateMethod ;		
	/** 属性业务类型00非农险,01农业险,02涉农险/业务类型00非农险,01农业险,02涉农险 */
	private String businessType ;		
	/** 属性政策/商业标志00商业险,01中央政策性,02地方政策性/政策/商业标志00商业险,01中央政策性,02地方政策性 */
	private String businessType1 ;		
	/** 属性联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保/联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保 */
	private String coinsFlag ;		
	/** 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保 */
	private String underWriteFlag ;
	/** 属性其它标志字段0新保,1续保/其它标志字段0新保,1续保 */
	private String othFlag1 ;		
	/** 属性业务类型字段0正常,1分入/业务类型字段0正常,1分入 */
	private String othFlag2 ;		
	/** 属性保单状态0有效,2废弃,3拒保/保单状态0有效,2废弃,3拒保 */
	private String othFlag4 ;
	/** 属性扶贫险种标志*/
	private String hpFlag;

	/*用户代码*/
	private String userCode;
	/*用户登录机构代码*/
	private String loginComCode;
	/*用户登录岗位代码*/
	private String loginGradeCodes;
	/*表名*/
	private String tableName;
	/*userCode字段*/
	private String userCodeFields;
	/*comCode字段*/
	private String comCodeFields;

	public String getStartDateEnd() {
		return startDateEnd;
	}

	public void setStartDateEnd(String startDateEnd) {
		this.startDateEnd = startDateEnd;
	}

	public String getEndStartDate() {
		return endStartDate;
	}

	public void setEndStartDate(String endStartDate) {
		this.endStartDate = endStartDate;
	}

	public String getOperateDateEnd() {
		return operateDateEnd;
	}

	public void setOperateDateEnd(String operateDateEnd) {
		this.operateDateEnd = operateDateEnd;
	}

	/**
	 * 属性扶贫险种标志的getter方法
	 */
	public String getHpFlag() {
		return hpFlag;
	}
	/**
	 * 属性扶贫险种标志的setter方法
	 */
	public void setHpFlag(String hpFlag) {
		this.hpFlag = hpFlag;
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
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性合同号/合同号的getter方法
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 属性合同号/合同号的setter方法
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}	
	/**
	 * 属性合同号查询方法*模糊查询，=精确查询/合同号查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryContractNoMethod() {
		return queryContractNoMethod;
	}
	/**
	 * 属性合同号查询方法*模糊查询，=精确查询/合同号查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryContractNoMethod(String queryContractNoMethod) {
		this.queryContractNoMethod = queryContractNoMethod;
	}	
	/**
	 * 属性印刷号/印刷号的getter方法
	 */
	public String getPrintNo() {
		return printNo;
	}
	/**
	 * 属性印刷号/印刷号的setter方法
	 */
	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}	
	/**
	 * 属性印刷号查询方法*模糊查询，=精确查询/印刷号查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryPrintNoMethod() {
		return queryPrintNoMethod;
	}
	/**
	 * 属性印刷号查询方法*模糊查询，=精确查询/印刷号查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryPrintNoMethod(String queryPrintNoMethod) {
		this.queryPrintNoMethod = queryPrintNoMethod;
	}	
	/**
	 * 属性投保人代码/投保人代码的getter方法
	 */
	public String getAppliCode() {
		return appliCode;
	}
	/**
	 * 属性投保人代码/投保人代码的setter方法
	 */
	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
	}	
	/**
	 * 属性投保人代码查询方法*模糊查询，=精确查询/投保人代码查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryappliCodeMethod() {
		return queryappliCodeMethod;
	}
	/**
	 * 属性投保人代码查询方法*模糊查询，=精确查询/投保人代码查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryappliCodeMethod(String queryappliCodeMethod) {
		this.queryappliCodeMethod = queryappliCodeMethod;
	}	
	/**
	 * 属性投保人名称/投保人名称的getter方法
	 */
	public String getAppliName() {
		return appliName;
	}
	/**
	 * 属性投保人名称/投保人名称的setter方法
	 */
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}	
	/**
	 * 属性投保人名称查询方法*模糊查询，=精确查询/投保人名称查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryappliNameMethod() {
		return queryappliNameMethod;
	}
	/**
	 * 属性投保人名称查询方法*模糊查询，=精确查询/投保人名称查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryappliNameMethod(String queryappliNameMethod) {
		this.queryappliNameMethod = queryappliNameMethod;
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
	 * 属性被保险人代码查询方法*模糊查询，=精确查询/被保险人代码查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryinsuredCodeMethod() {
		return queryinsuredCodeMethod;
	}
	/**
	 * 属性被保险人代码查询方法*模糊查询，=精确查询/被保险人代码查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryinsuredCodeMethod(String queryinsuredCodeMethod) {
		this.queryinsuredCodeMethod = queryinsuredCodeMethod;
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
	 * 属性被保险人名称查询方法*模糊查询，=精确查询/被保险人名称查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryinsuredNameMethod() {
		return queryinsuredNameMethod;
	}
	/**
	 * 属性被保险人名称查询方法*模糊查询，=精确查询/被保险人名称查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryinsuredNameMethod(String queryinsuredNameMethod) {
		this.queryinsuredNameMethod = queryinsuredNameMethod;
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
	 * 属性起保日期查询方法=,>=,<=,>,</起保日期查询方法=,>=,<=,>,<的getter方法
	 */
	public String getQuerystartDateMethod() {
		return querystartDateMethod;
	}
	/**
	 * 属性起保日期查询方法=,>=,<=,>,</起保日期查询方法=,>=,<=,>,<的setter方法
	 */
	public void setQuerystartDateMethod(String querystartDateMethod) {
		this.querystartDateMethod = querystartDateMethod;
	}	
	/**
	 * 属性终保日期/终保日期的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期/终保日期的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性终保日期查询方法=,>=,<=,>,</终保日期查询方法=,>=,<=,>,<的getter方法
	 */
	public String getQueryendDateMethod() {
		return queryendDateMethod;
	}
	/**
	 * 属性终保日期查询方法=,>=,<=,>,</终保日期查询方法=,>=,<=,>,<的setter方法
	 */
	public void setQueryendDateMethod(String queryendDateMethod) {
		this.queryendDateMethod = queryendDateMethod;
	}	
	/**
	 * 属性总保额/总保额的getter方法
	 */
	public String getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保额/总保额的setter方法
	 */
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * 属性总保额查询方法*模糊查询，=精确查询/总保额查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQuerysumAmountMethod() {
		return querysumAmountMethod;
	}
	/**
	 * 属性总保额查询方法*模糊查询，=精确查询/总保额查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQuerysumAmountMethod(String querysumAmountMethod) {
		this.querysumAmountMethod = querysumAmountMethod;
	}	
	/**
	 * 属性总保费/总保费的getter方法
	 */
	public String getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总保费/总保费的setter方法
	 */
	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}	
	/**
	 * 属性总保费查询方法*模糊查询，=精确查询/总保费查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQuerysumPremiumMethod() {
		return querysumPremiumMethod;
	}
	/**
	 * 属性总保费查询方法*模糊查询，=精确查询/总保费查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQuerysumPremiumMethod(String querysumPremiumMethod) {
		this.querysumPremiumMethod = querysumPremiumMethod;
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
	 * 属性出单机构查询方法*模糊查询，=精确查询/出单机构查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQuerymakeComMethod() {
		return querymakeComMethod;
	}
	/**
	 * 属性出单机构查询方法*模糊查询，=精确查询/出单机构查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQuerymakeComMethod(String querymakeComMethod) {
		this.querymakeComMethod = querymakeComMethod;
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
	 * 属性经办人代码查询方法*模糊查询，=精确查询/经办人代码查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryhandlerCodeMethod() {
		return queryhandlerCodeMethod;
	}
	/**
	 * 属性经办人代码查询方法*模糊查询，=精确查询/经办人代码查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryhandlerCodeMethod(String queryhandlerCodeMethod) {
		this.queryhandlerCodeMethod = queryhandlerCodeMethod;
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
	 * 属性操作员代码查询方法*模糊查询，=精确查询/操作员代码查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryoperatorCodeMethod() {
		return queryoperatorCodeMethod;
	}
	/**
	 * 属性操作员代码查询方法*模糊查询，=精确查询/操作员代码查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryoperatorCodeMethod(String queryoperatorCodeMethod) {
		this.queryoperatorCodeMethod = queryoperatorCodeMethod;
	}

	public String getOperateStartDate() {
		return operateStartDate;
	}

	public void setOperateStartDate(String operateStartDate) {
		this.operateStartDate = operateStartDate;
	}

	/**
	 * 属性制单日期查询方法=,>=,<=,>,</制单日期查询方法=,>=,<=,>,<的getter方法
	 */
	public String getQueryoperateDateMethod() {
		return queryoperateDateMethod;
	}
	/**
	 * 属性制单日期查询方法=,>=,<=,>,</制单日期查询方法=,>=,<=,>,<的setter方法
	 */
	public void setQueryoperateDateMethod(String queryoperateDateMethod) {
		this.queryoperateDateMethod = queryoperateDateMethod;
	}	
	/**
	 * 属性输入日期/输入日期的getter方法
	 */
	public String getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性输入日期查询方法=,>=,<=,>,</输入日期查询方法=,>=,<=,>,<的getter方法
	 */
	public String getQueryinputDateMethod() {
		return queryinputDateMethod;
	}
	/**
	 * 属性输入日期查询方法=,>=,<=,>,</输入日期查询方法=,>=,<=,>,<的setter方法
	 */
	public void setQueryinputDateMethod(String queryinputDateMethod) {
		this.queryinputDateMethod = queryinputDateMethod;
	}	
	/**
	 * 属性核保人代码/核保人代码的getter方法
	 */
	public String getUnderwriteCode() {
		return underwriteCode;
	}
	/**
	 * 属性核保人代码/核保人代码的setter方法
	 */
	public void setUnderwriteCode(String underwriteCode) {
		this.underwriteCode = underwriteCode;
	}	
	/**
	 * 属性核保人代码查询方法*模糊查询，=精确查询/核保人代码查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryunderwriteCodeMethod() {
		return queryunderwriteCodeMethod;
	}
	/**
	 * 属性核保人代码查询方法*模糊查询，=精确查询/核保人代码查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryunderwriteCodeMethod(String queryunderwriteCodeMethod) {
		this.queryunderwriteCodeMethod = queryunderwriteCodeMethod;
	}	
	/**
	 * 属性核保人名称/核保人名称的getter方法
	 */
	public String getUnderwriteName() {
		return underwriteName;
	}
	/**
	 * 属性核保人名称/核保人名称的setter方法
	 */
	public void setUnderwriteName(String underwriteName) {
		this.underwriteName = underwriteName;
	}	
	/**
	 * 属性核保人名称查询方法*模糊查询，=精确查询/核保人名称查询方法*模糊查询，=精确查询的getter方法
	 */
	public String getQueryunderwriteNameMethod() {
		return queryunderwriteNameMethod;
	}
	/**
	 * 属性核保人名称查询方法*模糊查询，=精确查询/核保人名称查询方法*模糊查询，=精确查询的setter方法
	 */
	public void setQueryunderwriteNameMethod(String queryunderwriteNameMethod) {
		this.queryunderwriteNameMethod = queryunderwriteNameMethod;
	}	
	/**
	 * 属性核保通过日期/核保通过日期的getter方法
	 */
	public String getUnderwriteEndDate() {
		return underwriteEndDate;
	}
	/**
	 * 属性核保通过日期/核保通过日期的setter方法
	 */
	public void setUnderwriteEndDate(String underwriteEndDate) {
		this.underwriteEndDate = underwriteEndDate;
	}	
	/**
	 * 属性核保通过日期查询方法=,>=,<=,>,</核保通过日期查询方法=,>=,<=,>,<的getter方法
	 */
	public String getQueryunderwriteEndDateMethod() {
		return queryunderwriteEndDateMethod;
	}
	/**
	 * 属性核保通过日期查询方法=,>=,<=,>,</核保通过日期查询方法=,>=,<=,>,<的setter方法
	 */
	public void setQueryunderwriteEndDateMethod(String queryunderwriteEndDateMethod) {
		this.queryunderwriteEndDateMethod = queryunderwriteEndDateMethod;
	}	
	/**
	 * 属性业务类型00非农险,01农业险,02涉农险/业务类型00非农险,01农业险,02涉农险的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性业务类型00非农险,01农业险,02涉农险/业务类型00非农险,01农业险,02涉农险的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性政策/商业标志00商业险,01中央政策性,02地方政策性/政策/商业标志00商业险,01中央政策性,02地方政策性的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性政策/商业标志00商业险,01中央政策性,02地方政策性/政策/商业标志00商业险,01中央政策性,02地方政策性的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保/联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保/联/共保标志0非联/共保，1主共保，2，从共保，3主联保，4从联保的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保的getter方法
	 */
	public String getUnderWriteFlag() {
		return underWriteFlag;
	}
	/**
	 * 属性投保状态0初始值,1通过,2不通过,3无需核保,9待核保/投保状态0初始值,1通过,2不通过,3无需核保,9待核保的setter方法
	 */
	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
	}	
	/**
	 * 属性其它标志字段0新保,1续保/其它标志字段0新保,1续保的getter方法
	 */
	public String getOthFlag1() {
		return othFlag1;
	}
	/**
	 * 属性其它标志字段0新保,1续保/其它标志字段0新保,1续保的setter方法
	 */
	public void setOthFlag1(String othFlag1) {
		this.othFlag1 = othFlag1;
	}	
	/**
	 * 属性业务类型字段0正常,1分入/业务类型字段0正常,1分入的getter方法
	 */
	public String getOthFlag2() {
		return othFlag2;
	}
	/**
	 * 属性业务类型字段0正常,1分入/业务类型字段0正常,1分入的setter方法
	 */
	public void setOthFlag2(String othFlag2) {
		this.othFlag2 = othFlag2;
	}	
	/**
	 * 属性保单状态0有效,2废弃,3拒保/保单状态0有效,2废弃,3拒保的getter方法
	 */
	public String getOthFlag4() {
		return othFlag4;
	}
	/**
	 * 属性保单状态0有效,2废弃,3拒保/保单状态0有效,2废弃,3拒保的setter方法
	 */
	public void setOthFlag4(String othFlag4) {
		this.othFlag4 = othFlag4;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getLoginComCode() {
		return loginComCode;
	}

	public void setLoginComCode(String loginComCode) {
		this.loginComCode = loginComCode;
	}

	public String getLoginGradeCodes() {
		return loginGradeCodes;
	}

	public void setLoginGradeCodes(String loginGradeCodes) {
		this.loginGradeCodes = loginGradeCodes;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUserCodeFields() {
		return userCodeFields;
	}

	public void setUserCodeFields(String userCodeFields) {
		this.userCodeFields = userCodeFields;
	}

	public String getComCodeFields() {
		return comCodeFields;
	}

	public void setComCodeFields(String comCodeFields) {
		this.comCodeFields = comCodeFields;
	}
}
