package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 08:02:24.074 
 * 原始保单主表Api操作对象
 */
public class PrpCmainOriginDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性合同号(供合保单使用)/合同号(供合保单使用) */
	private String contractNo ;		
	/** 属性保单种类(0普通1定额)/保单种类(0普通1定额) */
	private String policySort ;		
	/** 属性 合同号(供合保单使用)/ 合同号(供合保单使用) */
	private String printNo ;		
	/** 属性业务来源（直接/代理）/业务来源（直接/代理） */
	private String businessNature ;		
	/** 属性语种标志（C/E/…/语种标志（C/E/… */
	private String language ;		
	/** 属性保单类型（个人/集体）/保单类型（个人/集体） */
	private String policyType ;		
	/** 属性投保人代码/投保人代码 */
	private String appliCode ;		
	/** 属性投保人名称 /投保人名称  */
	private String appliName ;		
	/** 属性投保人名称/投保人名称 */
	private String appliAddress ;		
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;		
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;		
	/** 属性被保险人地址/被保险人地址 */
	private String insuredAddress ;		
	/** 属性签单日期（制单日期）/签单日期（制单日期） */
	private java.util.Date operateDate ;		
	/** 属性起保日期/起保日期 */
	private java.util.Date startDate ;		
	/** 属性起保小时/起保小时 */
	private Integer startHour ;
	/** 属性终保日期1/终保日期1 */
	private java.util.Date endDate ;		
	/** 属性终保日期/终保日期 */
	private Integer endHour ;
	/** 属性净费率/净费率 */
	private Double pureRate ;
	/** 属性手续费比例/手续费比例 */
	private Double disrate ;
	/** 属性总折扣率1/总折扣率1 */
	private Double discount ;
	/** 属性总折扣率/总折扣率 */
	private String currency ;		
	/** 属性总保险价值/总保险价值 */
	private Double sumValue ;
	/** 属性总保险金额/总保险金额 */
	private Double sumAmount ;
	/** 属性总折扣金额/总折扣金额 */
	private Double sumDiscount ;
	/** 属性总附加险保费/总附加险保费 */
	private Double sumPremium ;
	/** 属性总被保险总数量/人数/户数-压力容器总数/总被保险总数量/人数/户数-压力容器总数 */
	private Double sumSubprem ;
	/** 属性judicalCode/judicalCode */
	private String judicalCode ;		
	/** 属性司法管辖/司法管辖 */
	private String judicalScope ;		
	/** 属性交费方式1：现金  2：银行转账  9：其它/交费方式1：现金  2：银行转账  9：其它 */
	private String autotransrenewFlag ;		
	/** 属性争议解决方式1 诉讼；2 仲裁/争议解决方式1 诉讼；2 仲裁 */
	private String argueSolution ;		
	/** 属性仲裁委员会名称/仲裁委员会名称 */
	private String arbitboardName ;		
	/** 属性约定分期交费次数/约定分期交费次数 */
	private Integer payTimes ;
	/** 属性批改次数/批改次数 */
	private Integer endorSetimes ;
	/** 属性 理赔次数/ 理赔次数 */
	private Integer claimTimes ;
	/** 属性出单机构/出单机构 */
	private String makeCom ;		
	/** 属性签单地点/签单地点 */
	private String operateSite ;		
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;		
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;		
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code ;		
	/** 属性复核人代码 /复核人代码  */
	private String approverCode ;		
	/** 属性最终核保人代码/最终核保人代码 */
	private String underwriteCode ;		
	/** 属性最终核保人名称/最终核保人名称 */
	private String underwriteName ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputDate ;		
	/** 属性计算机输单小时/计算机输单小时 */
	private Integer inputHour ;
	/** 属性核保完成日期/核保完成日期 */
	private java.util.Date underwriteEndDate ;		
	/** 属性保单统计年月/保单统计年月 */
	private java.util.Date statisticsym ;		
	/** 属性代理人代码 /代理人代码  */
	private String agentCode ;		
	/** 属性共保标志(0非共保/1主共保/2共保)/共保标志(0非共保/1主共保/2共保) */
	private String coinsFlag ;		
	/** 属性商业分保标志(0无需分保/1需分保/2已分保)/商业分保标志(0无需分保/1需分保/2已分保) */
	private String reinsFlag ;		
	/** 属性统保标志(0/1统保)/统保标志(0/1统保) */
	private String allinsFlag ;		
	/** 属性核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)/核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保) */
	private String underwriteFlag ;		
	/** 属性其它标志字段 /其它标志字段  */
	private String othFlag ;		
	/** 属性状态字段/状态字段 */
	private String flag ;		
	/** 属性disrate1/disrate1 */
	private Double disrate1 ;
	/** 属性businessFlag/businessFlag */
	private String businessFlag ;		
	/** 属性updaterCode/updaterCode */
	private String updaterCode ;		
	/** 属性updateDate/updateDate */
	private java.util.Date updateDate ;		
	/** 属性updateHour/updateHour */
	private String updateHour ;		
	/** 属性payMode/payMode */
	private String payMode ;		
	/** 属性signDate/signDate */
	private java.util.Date signDate ;		
	/** 属性shareHolderFlag/shareHolderFlag */
	private String shareHolderFlag ;		
	/** 属性agreementNo/agreementNo */
	private String agreementNo ;		
	/** 属性inquiryNo/inquiryNo */
	private String inquiryNo ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性单证类型/单证类型 */
	private String visaCode ;		
	/** 属性manualType/manualType */
	private String manualType ;		
	/** 属性sumQuantity/sumQuantity */
	private Integer sumQuantity ;
	/** 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险） */
	private String policyBizType ;		
	/** 属性农业/涉农/非农标志/农业/涉农/非农标志 */
	private String businessType ;		
	/** 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志 */
	private String businessType1 ;		
	/** 属性承保数量的计量单位代码/承保数量的计量单位代码 */
	private String unitCode ;		
	/** 属性统计口径的承保数量/统计口径的承保数量 */
	private Double statQuantity ;
	/** 属性统计口径的计量单位代码/统计口径的计量单位代码 */
	private String statUnitCode ;		
	/** 属性参保农户户次/参保农户户次 */
	private Double sumInsured ;
	/** 属性专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用/专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用 */
	private String articleType ;		
	/** 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone' */
	private String businessProvince ;		
	/** 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone' */
	private String businessTown ;		
	/** 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone' */
	private String businessCounty ;		
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	private String businessareaName ;		
	/** 属性保单打印日期/保单打印日期 */
	private java.util.Date printDate ;		
	/** 属性保单收费日期/保单收费日期 */
	private java.util.Date payDate ;		
	/** 属性起保分钟/起保分钟 */
	private Integer startMinute ;
	/** 属性终保分钟/终保分钟 */
	private Integer endMinute ;
	/** 属性每次事故责任限额/每次事故责任限额 */
	private Double limitAmount ;
	/** 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否 */
	private String thirdKnow ;		
	/** 属性agentreMark/agentreMark */
	private String agentreMark ;		
	/** 属性ncarperpFlag/ncarperpFlag */
	private String ncarperpFlag ;		
	/** 属性groupNo/groupNo */
	private String groupNo ;		
	/** 属性groupFlag/groupFlag */
	private String groupFlag ;		
	/** 属性basePerformanceRate/basePerformanceRate */
	private Double basePerformanceRate ;
	/** 属性encouragePerformanceRate/encouragePerformanceRate */
	private Double encouragePerformanceRate ;
	/** 属性见费出单标志[0]非见费出单[1]见费出单/见费出单标志[0]非见费出单[1]见费出单 */
	private String isSeeFeeFlag ;		
	/** 属性统计日期/统计日期 */
	private java.util.Date validCountDate ;		
	/** 属性绩效总比例/绩效总比例 */
	private Double sumRate ;
	/** 属性标准保费折算系数/标准保费折算系数 */
	private Double standardRate ;
	/** 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中 */
	private String agriflag ;		
	/** 属性版本号/版本号 */
	private String versionNo ;		
	/** 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取 */
	private String coinsPremiumtype ;		
	/** 属性出单点出单标志/出单点出单标志 */
	private String eccFlag ;		
	/** 属性出单点试算单号/出单点试算单号 */
	private String ssproposalNo ;		
	/** 属性业务年度/业务年度 */
	private String businessYear ;		
	/** 属性统筹区/统筹区 */
	private String makeArea ;		
	/** 属性归属区域：镇/归属区域：镇 */
	private String businessCity ;		
	/** 属性归属区域：村/归属区域：村 */
	private String businessArea ;		
	/** 属性联办比例/联办比例 */
	private Double allianceRate ;
	/** 属性lastInsurercom/lastInsurercom */
	private String lastInsurercom ;		
	/** 属性lastPrintNo/lastPrintNo */
	private String lastPrintNo ;		
	/** 属性nationFlag/nationFlag */
	private String nationFlag ;		
	/** 属性newendDate/newendDate */
	private java.util.Date newendDate ;		
	/** 属性newstartDate/newstartDate */
	private java.util.Date newstartDate ;		
	/** 属性projectsFlag/projectsFlag */
	private String projectsFlag ;		
	/** 属性proposalLevel/proposalLevel */
	private String proposalLevel ;		
	/** 属性startStages/startStages */
	private Integer startStages ;
	/** 属性stopTimes/stopTimes */
	private String stopTimes ;		
	/** 属性subBusinessNature/subBusinessNature */
	private String subBusinessNature ;		
	/** 属性preinvoiceFlag/preinvoiceFlag */
	private String preinvoiceFlag ;		
	/** 属性periodFlag/periodFlag */
	private String periodFlag ;		
	/** 属性hangupFlag/hangupFlag */
	private String hangupFlag ;		
	/** 属性channelAdjustValue/channelAdjustValue */
	private Double channelAdjustValue ;
	/** 属性autonomyAdjustValue/autonomyAdjustValue */
	private Double autonomyAdjustValue ;
	/** 属性localModelDiscountz/localModelDiscountz */
	private Double localModelDiscountz ;
	/** 属性localModelPremium/localModelPremium */
	private Double localModelPremium ;
	/** 属性clauseType/clauseType */
	private String clauseType ;		
	/** 属性localModelDiscountq/localModelDiscountq */
	private Double localModelDiscountq ;
	/** 属性systemFlag/systemFlag */
	private String systemFlag ;		
	/** 属性agriType/agriType */
	private String agriType ;		
	/** 属性bankCode/bankCode */
	private String bankCode ;		
	/** 属性channelType/channelType */
	private String channelType ;		
	/** 属性effectiveImmediatelyFlag/effectiveImmediatelyFlag */
	private String effectiveImmediatelyFlag ;		
	/** 属性lastInsurerCode/lastInsurerCode */
	private String lastInsurerCode ;		
	/** 属性groupType/groupType */
	private String groupType ;		
	/** 属性saleName/saleName */
	private String saleName ;		
	/** 属性salePhone/salePhone */
	private String salePhone ;		
	/** 属性salecomCode/salecomCode */
	private String salecomCode ;		
	/** 属性salecomName/salecomName */
	private String salecomName ;		
	/** 属性salecomAddress/salecomAddress */
	private String salecomAddress ;		
	/** 属性saleagentAddress/saleagentAddress */
	private String saleagentAddress ;		
	/** 属性saleagentPersonName/saleagentPersonName */
	private String saleagentPersonName ;		
	/** 属性saleagentPersonId/saleagentPersonId */
	private String saleagentPersonId ;		
	/** 属性saleagentPermitNo/saleagentPermitNo */
	private String saleagentPermitNo ;		
	/** 属性validTime/validTime */
	private String validTime ;		
	/** 属性effectFlag/effectFlag */
	private String effectFlag ;		
	/** 属性agentClass/agentClass */
	private String agentClass ;		
	/** 属性topCommisionRate/topCommisionRate */
	private String topCommisionRate ;		
	/** 属性intCommisionRate/intCommisionRate */
	private String intCommisionRate ;		
	/** 属性exchangeRate/exchangeRate */
	private Double exchangeRate ;
	/** 属性adjustClaimReasonCode/adjustClaimReasonCode */
	private String adjustClaimReasonCode ;		
	/** 属性adjustClaimReasonRate/adjustClaimReasonRate */
	private Integer adjustClaimReasonRate ;
	/** 属性comCostPrem/comCostPrem */
	private Integer comCostPrem ;
	/** 属性ctpCostPrem/ctpCostPrem */
	private Integer ctpCostPrem ;
	/** 属性entireCostDiscount/entireCostDiscount */
	private Integer entireCostDiscount ;
	/** 属性entireRecommenDiscount/entireRecommenDiscount */
	private Integer entireRecommenDiscount ;
	/** 属性entireExpDiscount/entireExpDiscount */
	private Integer entireExpDiscount ;
	/** 属性entireUwritingDiscount/entireUwritingDiscount */
	private Integer entireUwritingDiscount ;
	/** 属性hopeDiscount/hopeDiscount */
	private Double hopeDiscount ;
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/** 属性总不含税保费/总不含税保费 */
	private Double sumNoTaxPremium ;
	/** 属性总税额/总税额 */
	private Double sumTaxFee ;
	/** 属性isThirdBusiness/isThirdBusiness */
	private String isThirdBusiness ;		
	/** 属性recordCode/recordCode */
	private String recordCode ;		
	/** 属性税种属性0-营业税 1-增值税/税种属性0-营业税 1-增值税 */
	private String taxType ;		
	/** 属性是否推荐修理厂/是否推荐修理厂 */
	private String isRepairCode ;		
	/** 属性推荐修理厂代码 /推荐修理厂代码  */
	private String repairCode ;		
	/** 属性推荐修理厂名称 /推荐修理厂名称  */
	private String repairName ;		
	/** 属性网销渠道/网销渠道 */
	private String wxchannelCode ;		
	/** 属性是否线上/是否线上 */
	private String isOnline ;		
	/** 属性是否C端/是否C端 */
	private String isCustomer ;		
	/** 属性是否验标/是否验标 */
	private String inceptionFlag ;		
	/** 属性是否承保公示/是否承保公示 */
	private String notificationFlag ;		
	/** 属性营销员类型/行业类别代码/营销员类型/行业类别代码 */
	private String agentbusinessType ;		
	/** 属性营销员类型/行业类别名称/营销员类型/行业类别名称 */
	private String agentbusinessTypeName ;		
	/** 属性交强险预期赔付率/交强险预期赔付率 */
	private Integer ctpElr ;
	/** 属性商业险预期赔付率/商业险预期赔付率 */
	private Integer comElr ;
	/** 属性整单预期赔付率/整单预期赔付率 */
	private Integer elr ;
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
	 * 属性合同号(供合保单使用)/合同号(供合保单使用)的getter方法
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 属性合同号(供合保单使用)/合同号(供合保单使用)的setter方法
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}	
	/**
	 * 属性保单种类(0普通1定额)/保单种类(0普通1定额)的getter方法
	 */
	public String getPolicySort() {
		return policySort;
	}
	/**
	 * 属性保单种类(0普通1定额)/保单种类(0普通1定额)的setter方法
	 */
	public void setPolicySort(String policySort) {
		this.policySort = policySort;
	}	
	/**
	 * 属性 合同号(供合保单使用)/ 合同号(供合保单使用)的getter方法
	 */
	public String getPrintNo() {
		return printNo;
	}
	/**
	 * 属性 合同号(供合保单使用)/ 合同号(供合保单使用)的setter方法
	 */
	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}	
	/**
	 * 属性业务来源（直接/代理）/业务来源（直接/代理）的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务来源（直接/代理）/业务来源（直接/代理）的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}	
	/**
	 * 属性语种标志（C/E/…/语种标志（C/E/…的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性语种标志（C/E/…/语种标志（C/E/…的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	}	
	/**
	 * 属性保单类型（个人/集体）/保单类型（个人/集体）的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单类型（个人/集体）/保单类型（个人/集体）的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
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
	 * 属性投保人名称 /投保人名称 的getter方法
	 */
	public String getAppliName() {
		return appliName;
	}
	/**
	 * 属性投保人名称 /投保人名称 的setter方法
	 */
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}	
	/**
	 * 属性投保人名称/投保人名称的getter方法
	 */
	public String getAppliAddress() {
		return appliAddress;
	}
	/**
	 * 属性投保人名称/投保人名称的setter方法
	 */
	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
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
	 * 属性被保险人地址/被保险人地址的getter方法
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}
	/**
	 * 属性被保险人地址/被保险人地址的setter方法
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}	
	/**
	 * 属性签单日期（制单日期）/签单日期（制单日期）的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性签单日期（制单日期）/签单日期（制单日期）的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}	
	/**
	 * 属性起保日期/起保日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期/起保日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性起保小时/起保小时的getter方法
	 */
	public Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}	
	/**
	 * 属性终保日期1/终保日期1的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期1/终保日期1的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性终保日期/终保日期的getter方法
	 */
	public Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终保日期/终保日期的setter方法
	 */
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}	
	/**
	 * 属性净费率/净费率的getter方法
	 */
	public Double getPureRate() {
		return pureRate;
	}
	/**
	 * 属性净费率/净费率的setter方法
	 */
	public void setPureRate(Double pureRate) {
		this.pureRate = pureRate;
	}	
	/**
	 * 属性手续费比例/手续费比例的getter方法
	 */
	public Double getDisrate() {
		return disrate;
	}
	/**
	 * 属性手续费比例/手续费比例的setter方法
	 */
	public void setDisrate(Double disrate) {
		this.disrate = disrate;
	}	
	/**
	 * 属性总折扣率1/总折扣率1的getter方法
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * 属性总折扣率1/总折扣率1的setter方法
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}	
	/**
	 * 属性总折扣率/总折扣率的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性总折扣率/总折扣率的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性总保险价值/总保险价值的getter方法
	 */
	public Double getSumValue() {
		return sumValue;
	}
	/**
	 * 属性总保险价值/总保险价值的setter方法
	 */
	public void setSumValue(Double sumValue) {
		this.sumValue = sumValue;
	}	
	/**
	 * 属性总保险金额/总保险金额的getter方法
	 */
	public Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保险金额/总保险金额的setter方法
	 */
	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * 属性总折扣金额/总折扣金额的getter方法
	 */
	public Double getSumDiscount() {
		return sumDiscount;
	}
	/**
	 * 属性总折扣金额/总折扣金额的setter方法
	 */
	public void setSumDiscount(Double sumDiscount) {
		this.sumDiscount = sumDiscount;
	}	
	/**
	 * 属性总附加险保费/总附加险保费的getter方法
	 */
	public Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总附加险保费/总附加险保费的setter方法
	 */
	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	}	
	/**
	 * 属性总被保险总数量/人数/户数-压力容器总数/总被保险总数量/人数/户数-压力容器总数的getter方法
	 */
	public Double getSumSubprem() {
		return sumSubprem;
	}
	/**
	 * 属性总被保险总数量/人数/户数-压力容器总数/总被保险总数量/人数/户数-压力容器总数的setter方法
	 */
	public void setSumSubprem(Double sumSubprem) {
		this.sumSubprem = sumSubprem;
	}	
	/**
	 * 属性judicalCode/judicalCode的getter方法
	 */
	public String getJudicalCode() {
		return judicalCode;
	}
	/**
	 * 属性judicalCode/judicalCode的setter方法
	 */
	public void setJudicalCode(String judicalCode) {
		this.judicalCode = judicalCode;
	}	
	/**
	 * 属性司法管辖/司法管辖的getter方法
	 */
	public String getJudicalScope() {
		return judicalScope;
	}
	/**
	 * 属性司法管辖/司法管辖的setter方法
	 */
	public void setJudicalScope(String judicalScope) {
		this.judicalScope = judicalScope;
	}	
	/**
	 * 属性交费方式1：现金  2：银行转账  9：其它/交费方式1：现金  2：银行转账  9：其它的getter方法
	 */
	public String getAutotransrenewFlag() {
		return autotransrenewFlag;
	}
	/**
	 * 属性交费方式1：现金  2：银行转账  9：其它/交费方式1：现金  2：银行转账  9：其它的setter方法
	 */
	public void setAutotransrenewFlag(String autotransrenewFlag) {
		this.autotransrenewFlag = autotransrenewFlag;
	}	
	/**
	 * 属性争议解决方式1 诉讼；2 仲裁/争议解决方式1 诉讼；2 仲裁的getter方法
	 */
	public String getArgueSolution() {
		return argueSolution;
	}
	/**
	 * 属性争议解决方式1 诉讼；2 仲裁/争议解决方式1 诉讼；2 仲裁的setter方法
	 */
	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}	
	/**
	 * 属性仲裁委员会名称/仲裁委员会名称的getter方法
	 */
	public String getArbitboardName() {
		return arbitboardName;
	}
	/**
	 * 属性仲裁委员会名称/仲裁委员会名称的setter方法
	 */
	public void setArbitboardName(String arbitboardName) {
		this.arbitboardName = arbitboardName;
	}	
	/**
	 * 属性约定分期交费次数/约定分期交费次数的getter方法
	 */
	public Integer getPayTimes() {
		return payTimes;
	}
	/**
	 * 属性约定分期交费次数/约定分期交费次数的setter方法
	 */
	public void setPayTimes(Integer payTimes) {
		this.payTimes = payTimes;
	}	
	/**
	 * 属性批改次数/批改次数的getter方法
	 */
	public Integer getEndorSetimes() {
		return endorSetimes;
	}
	/**
	 * 属性批改次数/批改次数的setter方法
	 */
	public void setEndorSetimes(Integer endorSetimes) {
		this.endorSetimes = endorSetimes;
	}	
	/**
	 * 属性 理赔次数/ 理赔次数的getter方法
	 */
	public Integer getClaimTimes() {
		return claimTimes;
	}
	/**
	 * 属性 理赔次数/ 理赔次数的setter方法
	 */
	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
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
	 * 属性签单地点/签单地点的getter方法
	 */
	public String getOperateSite() {
		return operateSite;
	}
	/**
	 * 属性签单地点/签单地点的setter方法
	 */
	public void setOperateSite(String operateSite) {
		this.operateSite = operateSite;
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
	 * 属性复核人代码 /复核人代码 的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性复核人代码 /复核人代码 的setter方法
	 */
	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}	
	/**
	 * 属性最终核保人代码/最终核保人代码的getter方法
	 */
	public String getUnderwriteCode() {
		return underwriteCode;
	}
	/**
	 * 属性最终核保人代码/最终核保人代码的setter方法
	 */
	public void setUnderwriteCode(String underwriteCode) {
		this.underwriteCode = underwriteCode;
	}	
	/**
	 * 属性最终核保人名称/最终核保人名称的getter方法
	 */
	public String getUnderwriteName() {
		return underwriteName;
	}
	/**
	 * 属性最终核保人名称/最终核保人名称的setter方法
	 */
	public void setUnderwriteName(String underwriteName) {
		this.underwriteName = underwriteName;
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
	 * 属性计算机输单小时/计算机输单小时的getter方法
	 */
	public Integer getInputHour() {
		return inputHour;
	}
	/**
	 * 属性计算机输单小时/计算机输单小时的setter方法
	 */
	public void setInputHour(Integer inputHour) {
		this.inputHour = inputHour;
	}	
	/**
	 * 属性核保完成日期/核保完成日期的getter方法
	 */
	public java.util.Date getUnderwriteEndDate() {
		return underwriteEndDate;
	}
	/**
	 * 属性核保完成日期/核保完成日期的setter方法
	 */
	public void setUnderwriteEndDate(java.util.Date underwriteEndDate) {
		this.underwriteEndDate = underwriteEndDate;
	}	
	/**
	 * 属性保单统计年月/保单统计年月的getter方法
	 */
	public java.util.Date getStatisticsym() {
		return statisticsym;
	}
	/**
	 * 属性保单统计年月/保单统计年月的setter方法
	 */
	public void setStatisticsym(java.util.Date statisticsym) {
		this.statisticsym = statisticsym;
	}	
	/**
	 * 属性代理人代码 /代理人代码 的getter方法
	 */
	public String getAgentCode() {
		return agentCode;
	}
	/**
	 * 属性代理人代码 /代理人代码 的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}	
	/**
	 * 属性共保标志(0非共保/1主共保/2共保)/共保标志(0非共保/1主共保/2共保)的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性共保标志(0非共保/1主共保/2共保)/共保标志(0非共保/1主共保/2共保)的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性商业分保标志(0无需分保/1需分保/2已分保)/商业分保标志(0无需分保/1需分保/2已分保)的getter方法
	 */
	public String getReinsFlag() {
		return reinsFlag;
	}
	/**
	 * 属性商业分保标志(0无需分保/1需分保/2已分保)/商业分保标志(0无需分保/1需分保/2已分保)的setter方法
	 */
	public void setReinsFlag(String reinsFlag) {
		this.reinsFlag = reinsFlag;
	}	
	/**
	 * 属性统保标志(0/1统保)/统保标志(0/1统保)的getter方法
	 */
	public String getAllinsFlag() {
		return allinsFlag;
	}
	/**
	 * 属性统保标志(0/1统保)/统保标志(0/1统保)的setter方法
	 */
	public void setAllinsFlag(String allinsFlag) {
		this.allinsFlag = allinsFlag;
	}	
	/**
	 * 属性核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)/核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)的getter方法
	 */
	public String getUnderwriteFlag() {
		return underwriteFlag;
	}
	/**
	 * 属性核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)/核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)的setter方法
	 */
	public void setUnderwriteFlag(String underwriteFlag) {
		this.underwriteFlag = underwriteFlag;
	}	
	/**
	 * 属性其它标志字段 /其它标志字段 的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性其它标志字段 /其它标志字段 的setter方法
	 */
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}	
	/**
	 * 属性状态字段/状态字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性状态字段/状态字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性disrate1/disrate1的getter方法
	 */
	public Double getDisrate1() {
		return disrate1;
	}
	/**
	 * 属性disrate1/disrate1的setter方法
	 */
	public void setDisrate1(Double disrate1) {
		this.disrate1 = disrate1;
	}	
	/**
	 * 属性businessFlag/businessFlag的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性businessFlag/businessFlag的setter方法
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}	
	/**
	 * 属性updaterCode/updaterCode的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性updaterCode/updaterCode的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}	
	/**
	 * 属性updateDate/updateDate的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性updateHour/updateHour的getter方法
	 */
	public String getUpdateHour() {
		return updateHour;
	}
	/**
	 * 属性updateHour/updateHour的setter方法
	 */
	public void setUpdateHour(String updateHour) {
		this.updateHour = updateHour;
	}	
	/**
	 * 属性payMode/payMode的getter方法
	 */
	public String getPayMode() {
		return payMode;
	}
	/**
	 * 属性payMode/payMode的setter方法
	 */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}	
	/**
	 * 属性signDate/signDate的getter方法
	 */
	public java.util.Date getSignDate() {
		return signDate;
	}
	/**
	 * 属性signDate/signDate的setter方法
	 */
	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}	
	/**
	 * 属性shareHolderFlag/shareHolderFlag的getter方法
	 */
	public String getShareHolderFlag() {
		return shareHolderFlag;
	}
	/**
	 * 属性shareHolderFlag/shareHolderFlag的setter方法
	 */
	public void setShareHolderFlag(String shareHolderFlag) {
		this.shareHolderFlag = shareHolderFlag;
	}	
	/**
	 * 属性agreementNo/agreementNo的getter方法
	 */
	public String getAgreementNo() {
		return agreementNo;
	}
	/**
	 * 属性agreementNo/agreementNo的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}	
	/**
	 * 属性inquiryNo/inquiryNo的getter方法
	 */
	public String getInquiryNo() {
		return inquiryNo;
	}
	/**
	 * 属性inquiryNo/inquiryNo的setter方法
	 */
	public void setInquiryNo(String inquiryNo) {
		this.inquiryNo = inquiryNo;
	}	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性单证类型/单证类型的getter方法
	 */
	public String getVisaCode() {
		return visaCode;
	}
	/**
	 * 属性单证类型/单证类型的setter方法
	 */
	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}	
	/**
	 * 属性manualType/manualType的getter方法
	 */
	public String getManualType() {
		return manualType;
	}
	/**
	 * 属性manualType/manualType的setter方法
	 */
	public void setManualType(String manualType) {
		this.manualType = manualType;
	}	
	/**
	 * 属性sumQuantity/sumQuantity的getter方法
	 */
	public Integer getSumQuantity() {
		return sumQuantity;
	}
	/**
	 * 属性sumQuantity/sumQuantity的setter方法
	 */
	public void setSumQuantity(Integer sumQuantity) {
		this.sumQuantity = sumQuantity;
	}	
	/**
	 * 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）的getter方法
	 */
	public String getPolicyBizType() {
		return policyBizType;
	}
	/**
	 * 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）的setter方法
	 */
	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}	
	/**
	 * 属性农业/涉农/非农标志/农业/涉农/非农标志的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农标志/农业/涉农/非农标志的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性承保数量的计量单位代码/承保数量的计量单位代码的getter方法
	 */
	public String getUnitCode() {
		return unitCode;
	}
	/**
	 * 属性承保数量的计量单位代码/承保数量的计量单位代码的setter方法
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}	
	/**
	 * 属性统计口径的承保数量/统计口径的承保数量的getter方法
	 */
	public Double getStatQuantity() {
		return statQuantity;
	}
	/**
	 * 属性统计口径的承保数量/统计口径的承保数量的setter方法
	 */
	public void setStatQuantity(Double statQuantity) {
		this.statQuantity = statQuantity;
	}	
	/**
	 * 属性统计口径的计量单位代码/统计口径的计量单位代码的getter方法
	 */
	public String getStatUnitCode() {
		return statUnitCode;
	}
	/**
	 * 属性统计口径的计量单位代码/统计口径的计量单位代码的setter方法
	 */
	public void setStatUnitCode(String statUnitCode) {
		this.statUnitCode = statUnitCode;
	}	
	/**
	 * 属性参保农户户次/参保农户户次的getter方法
	 */
	public Double getSumInsured() {
		return sumInsured;
	}
	/**
	 * 属性参保农户户次/参保农户户次的setter方法
	 */
	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}	
	/**
	 * 属性专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用/专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用的getter方法
	 */
	public String getArticleType() {
		return articleType;
	}
	/**
	 * 属性专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用/专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用的setter方法
	 */
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}	
	/**
	 * 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessProvince() {
		return businessProvince;
	}
	/**
	 * 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone'的setter方法
	 */
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}	
	/**
	 * 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessTown() {
		return businessTown;
	}
	/**
	 * 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone'的setter方法
	 */
	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}	
	/**
	 * 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessCounty() {
		return businessCounty;
	}
	/**
	 * 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone'的setter方法
	 */
	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}	
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的getter方法
	 */
	public String getBusinessareaName() {
		return businessareaName;
	}
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的setter方法
	 */
	public void setBusinessareaName(String businessareaName) {
		this.businessareaName = businessareaName;
	}	
	/**
	 * 属性保单打印日期/保单打印日期的getter方法
	 */
	public java.util.Date getPrintDate() {
		return printDate;
	}
	/**
	 * 属性保单打印日期/保单打印日期的setter方法
	 */
	public void setPrintDate(java.util.Date printDate) {
		this.printDate = printDate;
	}	
	/**
	 * 属性保单收费日期/保单收费日期的getter方法
	 */
	public java.util.Date getPayDate() {
		return payDate;
	}
	/**
	 * 属性保单收费日期/保单收费日期的setter方法
	 */
	public void setPayDate(java.util.Date payDate) {
		this.payDate = payDate;
	}	
	/**
	 * 属性起保分钟/起保分钟的getter方法
	 */
	public Integer getStartMinute() {
		return startMinute;
	}
	/**
	 * 属性起保分钟/起保分钟的setter方法
	 */
	public void setStartMinute(Integer startMinute) {
		this.startMinute = startMinute;
	}	
	/**
	 * 属性终保分钟/终保分钟的getter方法
	 */
	public Integer getEndMinute() {
		return endMinute;
	}
	/**
	 * 属性终保分钟/终保分钟的setter方法
	 */
	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}	
	/**
	 * 属性每次事故责任限额/每次事故责任限额的getter方法
	 */
	public Double getLimitAmount() {
		return limitAmount;
	}
	/**
	 * 属性每次事故责任限额/每次事故责任限额的setter方法
	 */
	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}	
	/**
	 * 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否的getter方法
	 */
	public String getThirdKnow() {
		return thirdKnow;
	}
	/**
	 * 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否的setter方法
	 */
	public void setThirdKnow(String thirdKnow) {
		this.thirdKnow = thirdKnow;
	}	
	/**
	 * 属性agentreMark/agentreMark的getter方法
	 */
	public String getAgentreMark() {
		return agentreMark;
	}
	/**
	 * 属性agentreMark/agentreMark的setter方法
	 */
	public void setAgentreMark(String agentreMark) {
		this.agentreMark = agentreMark;
	}	
	/**
	 * 属性ncarperpFlag/ncarperpFlag的getter方法
	 */
	public String getNcarperpFlag() {
		return ncarperpFlag;
	}
	/**
	 * 属性ncarperpFlag/ncarperpFlag的setter方法
	 */
	public void setNcarperpFlag(String ncarperpFlag) {
		this.ncarperpFlag = ncarperpFlag;
	}	
	/**
	 * 属性groupNo/groupNo的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性groupNo/groupNo的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}	
	/**
	 * 属性groupFlag/groupFlag的getter方法
	 */
	public String getGroupFlag() {
		return groupFlag;
	}
	/**
	 * 属性groupFlag/groupFlag的setter方法
	 */
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}	
	/**
	 * 属性basePerformanceRate/basePerformanceRate的getter方法
	 */
	public Double getBasePerformanceRate() {
		return basePerformanceRate;
	}
	/**
	 * 属性basePerformanceRate/basePerformanceRate的setter方法
	 */
	public void setBasePerformanceRate(Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	}	
	/**
	 * 属性encouragePerformanceRate/encouragePerformanceRate的getter方法
	 */
	public Double getEncouragePerformanceRate() {
		return encouragePerformanceRate;
	}
	/**
	 * 属性encouragePerformanceRate/encouragePerformanceRate的setter方法
	 */
	public void setEncouragePerformanceRate(Double encouragePerformanceRate) {
		this.encouragePerformanceRate = encouragePerformanceRate;
	}	
	/**
	 * 属性见费出单标志[0]非见费出单[1]见费出单/见费出单标志[0]非见费出单[1]见费出单的getter方法
	 */
	public String getIsSeeFeeFlag() {
		return isSeeFeeFlag;
	}
	/**
	 * 属性见费出单标志[0]非见费出单[1]见费出单/见费出单标志[0]非见费出单[1]见费出单的setter方法
	 */
	public void setIsSeeFeeFlag(String isSeeFeeFlag) {
		this.isSeeFeeFlag = isSeeFeeFlag;
	}	
	/**
	 * 属性统计日期/统计日期的getter方法
	 */
	public java.util.Date getValidCountDate() {
		return validCountDate;
	}
	/**
	 * 属性统计日期/统计日期的setter方法
	 */
	public void setValidCountDate(java.util.Date validCountDate) {
		this.validCountDate = validCountDate;
	}	
	/**
	 * 属性绩效总比例/绩效总比例的getter方法
	 */
	public Double getSumRate() {
		return sumRate;
	}
	/**
	 * 属性绩效总比例/绩效总比例的setter方法
	 */
	public void setSumRate(Double sumRate) {
		this.sumRate = sumRate;
	}	
	/**
	 * 属性标准保费折算系数/标准保费折算系数的getter方法
	 */
	public Double getStandardRate() {
		return standardRate;
	}
	/**
	 * 属性标准保费折算系数/标准保费折算系数的setter方法
	 */
	public void setStandardRate(Double standardRate) {
		this.standardRate = standardRate;
	}	
	/**
	 * 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中的getter方法
	 */
	public String getAgriflag() {
		return agriflag;
	}
	/**
	 * 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中的setter方法
	 */
	public void setAgriflag(String agriflag) {
		this.agriflag = agriflag;
	}	
	/**
	 * 属性版本号/版本号的getter方法
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * 属性版本号/版本号的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}	
	/**
	 * 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取的getter方法
	 */
	public String getCoinsPremiumtype() {
		return coinsPremiumtype;
	}
	/**
	 * 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取的setter方法
	 */
	public void setCoinsPremiumtype(String coinsPremiumtype) {
		this.coinsPremiumtype = coinsPremiumtype;
	}	
	/**
	 * 属性出单点出单标志/出单点出单标志的getter方法
	 */
	public String getEccFlag() {
		return eccFlag;
	}
	/**
	 * 属性出单点出单标志/出单点出单标志的setter方法
	 */
	public void setEccFlag(String eccFlag) {
		this.eccFlag = eccFlag;
	}	
	/**
	 * 属性出单点试算单号/出单点试算单号的getter方法
	 */
	public String getSsproposalNo() {
		return ssproposalNo;
	}
	/**
	 * 属性出单点试算单号/出单点试算单号的setter方法
	 */
	public void setSsproposalNo(String ssproposalNo) {
		this.ssproposalNo = ssproposalNo;
	}	
	/**
	 * 属性业务年度/业务年度的getter方法
	 */
	public String getBusinessYear() {
		return businessYear;
	}
	/**
	 * 属性业务年度/业务年度的setter方法
	 */
	public void setBusinessYear(String businessYear) {
		this.businessYear = businessYear;
	}	
	/**
	 * 属性统筹区/统筹区的getter方法
	 */
	public String getMakeArea() {
		return makeArea;
	}
	/**
	 * 属性统筹区/统筹区的setter方法
	 */
	public void setMakeArea(String makeArea) {
		this.makeArea = makeArea;
	}	
	/**
	 * 属性归属区域：镇/归属区域：镇的getter方法
	 */
	public String getBusinessCity() {
		return businessCity;
	}
	/**
	 * 属性归属区域：镇/归属区域：镇的setter方法
	 */
	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}	
	/**
	 * 属性归属区域：村/归属区域：村的getter方法
	 */
	public String getBusinessArea() {
		return businessArea;
	}
	/**
	 * 属性归属区域：村/归属区域：村的setter方法
	 */
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}	
	/**
	 * 属性联办比例/联办比例的getter方法
	 */
	public Double getAllianceRate() {
		return allianceRate;
	}
	/**
	 * 属性联办比例/联办比例的setter方法
	 */
	public void setAllianceRate(Double allianceRate) {
		this.allianceRate = allianceRate;
	}	
	/**
	 * 属性lastInsurercom/lastInsurercom的getter方法
	 */
	public String getLastInsurercom() {
		return lastInsurercom;
	}
	/**
	 * 属性lastInsurercom/lastInsurercom的setter方法
	 */
	public void setLastInsurercom(String lastInsurercom) {
		this.lastInsurercom = lastInsurercom;
	}	
	/**
	 * 属性lastPrintNo/lastPrintNo的getter方法
	 */
	public String getLastPrintNo() {
		return lastPrintNo;
	}
	/**
	 * 属性lastPrintNo/lastPrintNo的setter方法
	 */
	public void setLastPrintNo(String lastPrintNo) {
		this.lastPrintNo = lastPrintNo;
	}	
	/**
	 * 属性nationFlag/nationFlag的getter方法
	 */
	public String getNationFlag() {
		return nationFlag;
	}
	/**
	 * 属性nationFlag/nationFlag的setter方法
	 */
	public void setNationFlag(String nationFlag) {
		this.nationFlag = nationFlag;
	}	
	/**
	 * 属性newendDate/newendDate的getter方法
	 */
	public java.util.Date getNewendDate() {
		return newendDate;
	}
	/**
	 * 属性newendDate/newendDate的setter方法
	 */
	public void setNewendDate(java.util.Date newendDate) {
		this.newendDate = newendDate;
	}	
	/**
	 * 属性newstartDate/newstartDate的getter方法
	 */
	public java.util.Date getNewstartDate() {
		return newstartDate;
	}
	/**
	 * 属性newstartDate/newstartDate的setter方法
	 */
	public void setNewstartDate(java.util.Date newstartDate) {
		this.newstartDate = newstartDate;
	}	
	/**
	 * 属性projectsFlag/projectsFlag的getter方法
	 */
	public String getProjectsFlag() {
		return projectsFlag;
	}
	/**
	 * 属性projectsFlag/projectsFlag的setter方法
	 */
	public void setProjectsFlag(String projectsFlag) {
		this.projectsFlag = projectsFlag;
	}	
	/**
	 * 属性proposalLevel/proposalLevel的getter方法
	 */
	public String getProposalLevel() {
		return proposalLevel;
	}
	/**
	 * 属性proposalLevel/proposalLevel的setter方法
	 */
	public void setProposalLevel(String proposalLevel) {
		this.proposalLevel = proposalLevel;
	}	
	/**
	 * 属性startStages/startStages的getter方法
	 */
	public Integer getStartStages() {
		return startStages;
	}
	/**
	 * 属性startStages/startStages的setter方法
	 */
	public void setStartStages(Integer startStages) {
		this.startStages = startStages;
	}	
	/**
	 * 属性stopTimes/stopTimes的getter方法
	 */
	public String getStopTimes() {
		return stopTimes;
	}
	/**
	 * 属性stopTimes/stopTimes的setter方法
	 */
	public void setStopTimes(String stopTimes) {
		this.stopTimes = stopTimes;
	}	
	/**
	 * 属性subBusinessNature/subBusinessNature的getter方法
	 */
	public String getSubBusinessNature() {
		return subBusinessNature;
	}
	/**
	 * 属性subBusinessNature/subBusinessNature的setter方法
	 */
	public void setSubBusinessNature(String subBusinessNature) {
		this.subBusinessNature = subBusinessNature;
	}	
	/**
	 * 属性preinvoiceFlag/preinvoiceFlag的getter方法
	 */
	public String getPreinvoiceFlag() {
		return preinvoiceFlag;
	}
	/**
	 * 属性preinvoiceFlag/preinvoiceFlag的setter方法
	 */
	public void setPreinvoiceFlag(String preinvoiceFlag) {
		this.preinvoiceFlag = preinvoiceFlag;
	}	
	/**
	 * 属性periodFlag/periodFlag的getter方法
	 */
	public String getPeriodFlag() {
		return periodFlag;
	}
	/**
	 * 属性periodFlag/periodFlag的setter方法
	 */
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}	
	/**
	 * 属性hangupFlag/hangupFlag的getter方法
	 */
	public String getHangupFlag() {
		return hangupFlag;
	}
	/**
	 * 属性hangupFlag/hangupFlag的setter方法
	 */
	public void setHangupFlag(String hangupFlag) {
		this.hangupFlag = hangupFlag;
	}	
	/**
	 * 属性channelAdjustValue/channelAdjustValue的getter方法
	 */
	public Double getChannelAdjustValue() {
		return channelAdjustValue;
	}
	/**
	 * 属性channelAdjustValue/channelAdjustValue的setter方法
	 */
	public void setChannelAdjustValue(Double channelAdjustValue) {
		this.channelAdjustValue = channelAdjustValue;
	}	
	/**
	 * 属性autonomyAdjustValue/autonomyAdjustValue的getter方法
	 */
	public Double getAutonomyAdjustValue() {
		return autonomyAdjustValue;
	}
	/**
	 * 属性autonomyAdjustValue/autonomyAdjustValue的setter方法
	 */
	public void setAutonomyAdjustValue(Double autonomyAdjustValue) {
		this.autonomyAdjustValue = autonomyAdjustValue;
	}	
	/**
	 * 属性localModelDiscountz/localModelDiscountz的getter方法
	 */
	public Double getLocalModelDiscountz() {
		return localModelDiscountz;
	}
	/**
	 * 属性localModelDiscountz/localModelDiscountz的setter方法
	 */
	public void setLocalModelDiscountz(Double localModelDiscountz) {
		this.localModelDiscountz = localModelDiscountz;
	}	
	/**
	 * 属性localModelPremium/localModelPremium的getter方法
	 */
	public Double getLocalModelPremium() {
		return localModelPremium;
	}
	/**
	 * 属性localModelPremium/localModelPremium的setter方法
	 */
	public void setLocalModelPremium(Double localModelPremium) {
		this.localModelPremium = localModelPremium;
	}	
	/**
	 * 属性clauseType/clauseType的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性clauseType/clauseType的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}	
	/**
	 * 属性localModelDiscountq/localModelDiscountq的getter方法
	 */
	public Double getLocalModelDiscountq() {
		return localModelDiscountq;
	}
	/**
	 * 属性localModelDiscountq/localModelDiscountq的setter方法
	 */
	public void setLocalModelDiscountq(Double localModelDiscountq) {
		this.localModelDiscountq = localModelDiscountq;
	}	
	/**
	 * 属性systemFlag/systemFlag的getter方法
	 */
	public String getSystemFlag() {
		return systemFlag;
	}
	/**
	 * 属性systemFlag/systemFlag的setter方法
	 */
	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}	
	/**
	 * 属性agriType/agriType的getter方法
	 */
	public String getAgriType() {
		return agriType;
	}
	/**
	 * 属性agriType/agriType的setter方法
	 */
	public void setAgriType(String agriType) {
		this.agriType = agriType;
	}	
	/**
	 * 属性bankCode/bankCode的getter方法
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * 属性bankCode/bankCode的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}	
	/**
	 * 属性channelType/channelType的getter方法
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * 属性channelType/channelType的setter方法
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}	
	/**
	 * 属性effectiveImmediatelyFlag/effectiveImmediatelyFlag的getter方法
	 */
	public String getEffectiveImmediatelyFlag() {
		return effectiveImmediatelyFlag;
	}
	/**
	 * 属性effectiveImmediatelyFlag/effectiveImmediatelyFlag的setter方法
	 */
	public void setEffectiveImmediatelyFlag(String effectiveImmediatelyFlag) {
		this.effectiveImmediatelyFlag = effectiveImmediatelyFlag;
	}	
	/**
	 * 属性lastInsurerCode/lastInsurerCode的getter方法
	 */
	public String getLastInsurerCode() {
		return lastInsurerCode;
	}
	/**
	 * 属性lastInsurerCode/lastInsurerCode的setter方法
	 */
	public void setLastInsurerCode(String lastInsurerCode) {
		this.lastInsurerCode = lastInsurerCode;
	}	
	/**
	 * 属性groupType/groupType的getter方法
	 */
	public String getGroupType() {
		return groupType;
	}
	/**
	 * 属性groupType/groupType的setter方法
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}	
	/**
	 * 属性saleName/saleName的getter方法
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * 属性saleName/saleName的setter方法
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}	
	/**
	 * 属性salePhone/salePhone的getter方法
	 */
	public String getSalePhone() {
		return salePhone;
	}
	/**
	 * 属性salePhone/salePhone的setter方法
	 */
	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}	
	/**
	 * 属性salecomCode/salecomCode的getter方法
	 */
	public String getSalecomCode() {
		return salecomCode;
	}
	/**
	 * 属性salecomCode/salecomCode的setter方法
	 */
	public void setSalecomCode(String salecomCode) {
		this.salecomCode = salecomCode;
	}	
	/**
	 * 属性salecomName/salecomName的getter方法
	 */
	public String getSalecomName() {
		return salecomName;
	}
	/**
	 * 属性salecomName/salecomName的setter方法
	 */
	public void setSalecomName(String salecomName) {
		this.salecomName = salecomName;
	}	
	/**
	 * 属性salecomAddress/salecomAddress的getter方法
	 */
	public String getSalecomAddress() {
		return salecomAddress;
	}
	/**
	 * 属性salecomAddress/salecomAddress的setter方法
	 */
	public void setSalecomAddress(String salecomAddress) {
		this.salecomAddress = salecomAddress;
	}	
	/**
	 * 属性saleagentAddress/saleagentAddress的getter方法
	 */
	public String getSaleagentAddress() {
		return saleagentAddress;
	}
	/**
	 * 属性saleagentAddress/saleagentAddress的setter方法
	 */
	public void setSaleagentAddress(String saleagentAddress) {
		this.saleagentAddress = saleagentAddress;
	}	
	/**
	 * 属性saleagentPersonName/saleagentPersonName的getter方法
	 */
	public String getSaleagentPersonName() {
		return saleagentPersonName;
	}
	/**
	 * 属性saleagentPersonName/saleagentPersonName的setter方法
	 */
	public void setSaleagentPersonName(String saleagentPersonName) {
		this.saleagentPersonName = saleagentPersonName;
	}	
	/**
	 * 属性saleagentPersonId/saleagentPersonId的getter方法
	 */
	public String getSaleagentPersonId() {
		return saleagentPersonId;
	}
	/**
	 * 属性saleagentPersonId/saleagentPersonId的setter方法
	 */
	public void setSaleagentPersonId(String saleagentPersonId) {
		this.saleagentPersonId = saleagentPersonId;
	}	
	/**
	 * 属性saleagentPermitNo/saleagentPermitNo的getter方法
	 */
	public String getSaleagentPermitNo() {
		return saleagentPermitNo;
	}
	/**
	 * 属性saleagentPermitNo/saleagentPermitNo的setter方法
	 */
	public void setSaleagentPermitNo(String saleagentPermitNo) {
		this.saleagentPermitNo = saleagentPermitNo;
	}	
	/**
	 * 属性validTime/validTime的getter方法
	 */
	public String getValidTime() {
		return validTime;
	}
	/**
	 * 属性validTime/validTime的setter方法
	 */
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}	
	/**
	 * 属性effectFlag/effectFlag的getter方法
	 */
	public String getEffectFlag() {
		return effectFlag;
	}
	/**
	 * 属性effectFlag/effectFlag的setter方法
	 */
	public void setEffectFlag(String effectFlag) {
		this.effectFlag = effectFlag;
	}	
	/**
	 * 属性agentClass/agentClass的getter方法
	 */
	public String getAgentClass() {
		return agentClass;
	}
	/**
	 * 属性agentClass/agentClass的setter方法
	 */
	public void setAgentClass(String agentClass) {
		this.agentClass = agentClass;
	}	
	/**
	 * 属性topCommisionRate/topCommisionRate的getter方法
	 */
	public String getTopCommisionRate() {
		return topCommisionRate;
	}
	/**
	 * 属性topCommisionRate/topCommisionRate的setter方法
	 */
	public void setTopCommisionRate(String topCommisionRate) {
		this.topCommisionRate = topCommisionRate;
	}	
	/**
	 * 属性intCommisionRate/intCommisionRate的getter方法
	 */
	public String getIntCommisionRate() {
		return intCommisionRate;
	}
	/**
	 * 属性intCommisionRate/intCommisionRate的setter方法
	 */
	public void setIntCommisionRate(String intCommisionRate) {
		this.intCommisionRate = intCommisionRate;
	}	
	/**
	 * 属性exchangeRate/exchangeRate的getter方法
	 */
	public Double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * 属性exchangeRate/exchangeRate的setter方法
	 */
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}	
	/**
	 * 属性adjustClaimReasonCode/adjustClaimReasonCode的getter方法
	 */
	public String getAdjustClaimReasonCode() {
		return adjustClaimReasonCode;
	}
	/**
	 * 属性adjustClaimReasonCode/adjustClaimReasonCode的setter方法
	 */
	public void setAdjustClaimReasonCode(String adjustClaimReasonCode) {
		this.adjustClaimReasonCode = adjustClaimReasonCode;
	}	
	/**
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate的getter方法
	 */
	public Integer getAdjustClaimReasonRate() {
		return adjustClaimReasonRate;
	}
	/**
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate的setter方法
	 */
	public void setAdjustClaimReasonRate(Integer adjustClaimReasonRate) {
		this.adjustClaimReasonRate = adjustClaimReasonRate;
	}	
	/**
	 * 属性comCostPrem/comCostPrem的getter方法
	 */
	public Integer getComCostPrem() {
		return comCostPrem;
	}
	/**
	 * 属性comCostPrem/comCostPrem的setter方法
	 */
	public void setComCostPrem(Integer comCostPrem) {
		this.comCostPrem = comCostPrem;
	}	
	/**
	 * 属性ctpCostPrem/ctpCostPrem的getter方法
	 */
	public Integer getCtpCostPrem() {
		return ctpCostPrem;
	}
	/**
	 * 属性ctpCostPrem/ctpCostPrem的setter方法
	 */
	public void setCtpCostPrem(Integer ctpCostPrem) {
		this.ctpCostPrem = ctpCostPrem;
	}	
	/**
	 * 属性entireCostDiscount/entireCostDiscount的getter方法
	 */
	public Integer getEntireCostDiscount() {
		return entireCostDiscount;
	}
	/**
	 * 属性entireCostDiscount/entireCostDiscount的setter方法
	 */
	public void setEntireCostDiscount(Integer entireCostDiscount) {
		this.entireCostDiscount = entireCostDiscount;
	}	
	/**
	 * 属性entireRecommenDiscount/entireRecommenDiscount的getter方法
	 */
	public Integer getEntireRecommenDiscount() {
		return entireRecommenDiscount;
	}
	/**
	 * 属性entireRecommenDiscount/entireRecommenDiscount的setter方法
	 */
	public void setEntireRecommenDiscount(Integer entireRecommenDiscount) {
		this.entireRecommenDiscount = entireRecommenDiscount;
	}	
	/**
	 * 属性entireExpDiscount/entireExpDiscount的getter方法
	 */
	public Integer getEntireExpDiscount() {
		return entireExpDiscount;
	}
	/**
	 * 属性entireExpDiscount/entireExpDiscount的setter方法
	 */
	public void setEntireExpDiscount(Integer entireExpDiscount) {
		this.entireExpDiscount = entireExpDiscount;
	}	
	/**
	 * 属性entireUwritingDiscount/entireUwritingDiscount的getter方法
	 */
	public Integer getEntireUwritingDiscount() {
		return entireUwritingDiscount;
	}
	/**
	 * 属性entireUwritingDiscount/entireUwritingDiscount的setter方法
	 */
	public void setEntireUwritingDiscount(Integer entireUwritingDiscount) {
		this.entireUwritingDiscount = entireUwritingDiscount;
	}	
	/**
	 * 属性hopeDiscount/hopeDiscount的getter方法
	 */
	public Double getHopeDiscount() {
		return hopeDiscount;
	}
	/**
	 * 属性hopeDiscount/hopeDiscount的setter方法
	 */
	public void setHopeDiscount(Double hopeDiscount) {
		this.hopeDiscount = hopeDiscount;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
	}	
	/**
	 * 属性总不含税保费/总不含税保费的getter方法
	 */
	public Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
	public void setSumNoTaxPremium(Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	}	
	/**
	 * 属性总税额/总税额的getter方法
	 */
	public Double getSumTaxFee() {
		return sumTaxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setSumTaxFee(Double sumTaxFee) {
		this.sumTaxFee = sumTaxFee;
	}	
	/**
	 * 属性isThirdBusiness/isThirdBusiness的getter方法
	 */
	public String getIsThirdBusiness() {
		return isThirdBusiness;
	}
	/**
	 * 属性isThirdBusiness/isThirdBusiness的setter方法
	 */
	public void setIsThirdBusiness(String isThirdBusiness) {
		this.isThirdBusiness = isThirdBusiness;
	}	
	/**
	 * 属性recordCode/recordCode的getter方法
	 */
	public String getRecordCode() {
		return recordCode;
	}
	/**
	 * 属性recordCode/recordCode的setter方法
	 */
	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}	
	/**
	 * 属性税种属性0-营业税 1-增值税/税种属性0-营业税 1-增值税的getter方法
	 */
	public String getTaxType() {
		return taxType;
	}
	/**
	 * 属性税种属性0-营业税 1-增值税/税种属性0-营业税 1-增值税的setter方法
	 */
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}	
	/**
	 * 属性是否推荐修理厂/是否推荐修理厂的getter方法
	 */
	public String getIsRepairCode() {
		return isRepairCode;
	}
	/**
	 * 属性是否推荐修理厂/是否推荐修理厂的setter方法
	 */
	public void setIsRepairCode(String isRepairCode) {
		this.isRepairCode = isRepairCode;
	}	
	/**
	 * 属性推荐修理厂代码 /推荐修理厂代码 的getter方法
	 */
	public String getRepairCode() {
		return repairCode;
	}
	/**
	 * 属性推荐修理厂代码 /推荐修理厂代码 的setter方法
	 */
	public void setRepairCode(String repairCode) {
		this.repairCode = repairCode;
	}	
	/**
	 * 属性推荐修理厂名称 /推荐修理厂名称 的getter方法
	 */
	public String getRepairName() {
		return repairName;
	}
	/**
	 * 属性推荐修理厂名称 /推荐修理厂名称 的setter方法
	 */
	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}	
	/**
	 * 属性网销渠道/网销渠道的getter方法
	 */
	public String getWxchannelCode() {
		return wxchannelCode;
	}
	/**
	 * 属性网销渠道/网销渠道的setter方法
	 */
	public void setWxchannelCode(String wxchannelCode) {
		this.wxchannelCode = wxchannelCode;
	}	
	/**
	 * 属性是否线上/是否线上的getter方法
	 */
	public String getIsOnline() {
		return isOnline;
	}
	/**
	 * 属性是否线上/是否线上的setter方法
	 */
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}	
	/**
	 * 属性是否C端/是否C端的getter方法
	 */
	public String getIsCustomer() {
		return isCustomer;
	}
	/**
	 * 属性是否C端/是否C端的setter方法
	 */
	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}	
	/**
	 * 属性是否验标/是否验标的getter方法
	 */
	public String getInceptionFlag() {
		return inceptionFlag;
	}
	/**
	 * 属性是否验标/是否验标的setter方法
	 */
	public void setInceptionFlag(String inceptionFlag) {
		this.inceptionFlag = inceptionFlag;
	}	
	/**
	 * 属性是否承保公示/是否承保公示的getter方法
	 */
	public String getNotificationFlag() {
		return notificationFlag;
	}
	/**
	 * 属性是否承保公示/是否承保公示的setter方法
	 */
	public void setNotificationFlag(String notificationFlag) {
		this.notificationFlag = notificationFlag;
	}	
	/**
	 * 属性营销员类型/行业类别代码/营销员类型/行业类别代码的getter方法
	 */
	public String getAgentbusinessType() {
		return agentbusinessType;
	}
	/**
	 * 属性营销员类型/行业类别代码/营销员类型/行业类别代码的setter方法
	 */
	public void setAgentbusinessType(String agentbusinessType) {
		this.agentbusinessType = agentbusinessType;
	}	
	/**
	 * 属性营销员类型/行业类别名称/营销员类型/行业类别名称的getter方法
	 */
	public String getAgentbusinessTypeName() {
		return agentbusinessTypeName;
	}
	/**
	 * 属性营销员类型/行业类别名称/营销员类型/行业类别名称的setter方法
	 */
	public void setAgentbusinessTypeName(String agentbusinessTypeName) {
		this.agentbusinessTypeName = agentbusinessTypeName;
	}	
	/**
	 * 属性交强险预期赔付率/交强险预期赔付率的getter方法
	 */
	public Integer getCtpElr() {
		return ctpElr;
	}
	/**
	 * 属性交强险预期赔付率/交强险预期赔付率的setter方法
	 */
	public void setCtpElr(Integer ctpElr) {
		this.ctpElr = ctpElr;
	}	
	/**
	 * 属性商业险预期赔付率/商业险预期赔付率的getter方法
	 */
	public Integer getComElr() {
		return comElr;
	}
	/**
	 * 属性商业险预期赔付率/商业险预期赔付率的setter方法
	 */
	public void setComElr(Integer comElr) {
		this.comElr = comElr;
	}	
	/**
	 * 属性整单预期赔付率/整单预期赔付率的getter方法
	 */
	public Integer getElr() {
		return elr;
	}
	/**
	 * 属性整单预期赔付率/整单预期赔付率的setter方法
	 */
	public void setElr(Integer elr) {
		this.elr = elr;
	}	
}
