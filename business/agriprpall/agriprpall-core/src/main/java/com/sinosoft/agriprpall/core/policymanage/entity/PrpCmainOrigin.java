package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 原始保单主表实体操作对象
 */
@Entity
@Table(name = "PrpCmainOrigin")
@IdClass(PrpCmainOriginKey.class)
public class PrpCmainOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;	

	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性合同号(供合保单使用)/合同号(供合保单使用) */
	@Column(name = "contractNo")
	private String contractNo ;
	/** 属性保单种类(0普通1定额)/保单种类(0普通1定额) */
	@Column(name = "policySort")
	private String policySort ;
	/** 属性流水号/流水号 */
	@Column(name = "printNo")
	private String printNo ;
	/** 属性业务来源（直接/代理）/业务来源（直接/代理） */
	@Column(name = "businessNature")
	private String businessNature ;
	/** 属性语种标志（C/E/…/语种标志（C/E/… */
	@Column(name = "language")
	private String language ;
	/** 属性保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋/保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋 */
	@Column(name = "policyType")
	private String policyType ;
	/** 属性投保人代码/投保人代码 */
	@Column(name = "appliCode")
	private String appliCode ;
	/** 属性投保人名称 /投保人名称  */
	@Column(name = "appliName")
	private String appliName ;
	/** 属性投保人名称/投保人名称 */
	@Column(name = "appliAddress")
	private String appliAddress ;
	/** 属性被保险人代码/被保险人代码 */
	@Column(name = "insuredCode")
	private String insuredCode ;
	/** 属性被保险人名称/被保险人名称 */
	@Column(name = "insuredName")
	private String insuredName ;
	/** 属性被保险人地址/被保险人地址 */
	@Column(name = "insuredAddress")
	private String insuredAddress ;
	/** 属性签单日期（制单日期）/签单日期（制单日期） */
	@Column(name = "operateDate")
	private java.util.Date operateDate ;
	/** 属性起保日期/起保日期 */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性起保小时/起保小时 */
	@Column(name = "startHour")
	private java.lang.Integer startHour ;
	/** 属性终保日期/终保日期 */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性终保小时/终保小时 */
	@Column(name = "endHour")
	private java.lang.Integer endHour ;
	/** 属性净费率/净费率 */
	@Column(name = "pureRate")
	private java.lang.Double pureRate ;
	/** 属性手续费比例/手续费比例 */
	@Column(name = "disRate")
	private java.lang.Double disRate ;
	/** 属性总折扣率/总折扣率 */
	@Column(name = "disCount")
	private java.lang.Double disCount ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性总保险价值/总保险价值 */
	@Column(name = "sumValue")
	private java.lang.Double sumValue ;
	/** 属性总保险金额/总保险金额 */
	@Column(name = "sumAmount")
	private java.lang.Double sumAmount ;
	/** 属性总折扣金额/总折扣金额 */
	@Column(name = "sumDiscount")
	private java.lang.Double sumDiscount ;
	/** 属性总附加险保费/总附加险保费 */
	@Column(name = "sumPremium")
	private java.lang.Double sumPremium ;
	/** 属性总被保险总数量/人数/户数/总被保险总数量/人数/户数 */
	@Column(name = "sumSubPrem")
	private java.lang.Double sumSubPrem ;
	/** 属性judicalCode/judicalCode */
	@Column(name = "judicalCode")
	private String judicalCode ;
	/** 属性司法管辖/司法管辖 */
	@Column(name = "judicalScope")
	private String judicalScope ;
	/** 属性交费方式/交费方式 */
	@Column(name = "autoTransRenewFlag")
	private String autoTransRenewFlag ;
	/** 属性争议解决方式/争议解决方式 */
	@Column(name = "argueSolution")
	private String argueSolution ;
	/** 属性仲裁委员会名称/仲裁委员会名称 */
	@Column(name = "arbitBoardName")
	private String arbitBoardName ;
	/** 属性约定分期交费次数/约定分期交费次数 */
	@Column(name = "payTimes")
	private java.lang.Integer payTimes ;
	/** 属性批改次数/批改次数 */
	@Column(name = "endorseTimes")
	private java.lang.Integer endorseTimes ;
	/** 属性理赔次数/理赔次数 */
	@Column(name = "claimTimes")
	private java.lang.Integer claimTimes ;
	/** 属性出单机构/出单机构 */
	@Column(name = "makeCom")
	private String makeCom ;
	/** 属性签单地点/签单地点 */
	@Column(name = "operateSite")
	private String operateSite ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性经办人代码/经办人代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性归属业务员代码/归属业务员代码 */
	@Column(name = "handler1Code")
	private String handler1Code ;
	/** 属性复核人代码 /复核人代码  */
	@Column(name = "approverCode")
	private String approverCode ;
	/** 属性最终核保人代码/最终核保人代码 */
	@Column(name = "underwriteCode")
	private String underwriteCode ;
	/** 属性最终核保人名称/最终核保人名称 */
	@Column(name = "underwriteName")
	private String underwriteName ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性计算机输单日期/计算机输单日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性计算机输单小时/计算机输单小时 */
	@Column(name = "inputHour")
	private java.lang.Integer inputHour ;
	/** 属性核保完成日期/核保完成日期 */
	@Column(name = "underwriteEndDate")
	private java.util.Date underwriteEndDate ;
	/** 属性保单统计年月/保单统计年月 */
	@Column(name = "statisticSym")
	private java.util.Date statisticSym ;
	/** 属性代理人代码 /代理人代码  */
	@Column(name = "agentCode")
	private String agentCode ;
	/** 属性共保标志/共保标志 */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性商业分保标志/商业分保标志 */
	@Column(name = "reinsFlag")
	private String reinsFlag ;
	/** 属性统保标志(0/1统保)/统保标志(0/1统保) */
	@Column(name = "allinsFlag")
	private String allinsFlag ;
	/** 属性核保标志/核保标志 */
	@Column(name = "underwriteFlag")
	private String underwriteFlag ;
	/** 属性其它标志字段/其它标志字段 */
	@Column(name = "othFlag")
	private String othFlag ;
	/** 属性状态字段/状态字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性disrate2/disrate2 */
	@Column(name = "disRate1")
	private java.lang.Double disRate1 ;
	/** 属性businessFlag/businessFlag */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性upDaterCode/upDaterCode */
	@Column(name = "updaterCode")
	private String updaterCode ;
	/** 属性upDateDate/upDateDate */
	@Column(name = "updateDate")
	private java.util.Date updateDate ;
	/** 属性upDateHour/upDateHour */
	@Column(name = "updateHour")
	private String updateHour ;
	/** 属性payMode/payMode */
	@Column(name = "payMode")
	private String payMode ;
	/** 属性signDate/signDate */
	@Column(name = "signDate")
	private java.util.Date signDate ;
	/** 属性shareHolderFlag/shareHolderFlag */
	@Column(name = "shareholderFlag")
	private String shareholderFlag ;
	/** 属性agreeMentno/agreeMentno */
	@Column(name = "agreementNo")
	private String agreementNo ;
	/** 属性inQuiryNo/inQuiryNo */
	@Column(name = "inquiryNo")
	private String inquiryNo ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性单证类型/单证类型 */
	@Column(name = "visaCode")
	private String visaCode ;
	/** 属性manualType/manualType */
	@Column(name = "manualType")
	private String manualType ;
	/** 属性sumQuantity/sumQuantity */
	@Column(name = "sumQuantity")
	private java.lang.Integer sumQuantity ;
	/** 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险） */
	@Column(name = "policyBizType")
	private String policyBizType ;
	/** 属性农业/涉农/非农标志/农业/涉农/非农标志 */
	@Column(name = "businessType")
	private String businessType ;
	/** 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志 */
	@Column(name = "businessType1")
	private String businessType1 ;
	/** 属性承保数量的计量单位代码/承保数量的计量单位代码 */
	@Column(name = "unitCode")
	private String unitCode ;
	/** 属性统计口径的承保数量/统计口径的承保数量 */
	@Column(name = "statQuantity")
	private java.lang.Double statQuantity ;
	/** 属性统计口径的计量单位代码/统计口径的计量单位代码 */
	@Column(name = "statUnitCode")
	private String statUnitCode ;
	/** 属性参保农户户次/参保农户户次 */
	@Column(name = "sumInsured")
	private java.lang.Double sumInsured ;
	/** 属性专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用/专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用 */
	@Column(name = "articleType")
	private String articleType ;
	/** 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessProvince")
	private String businessProvince ;
	/** 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessTown")
	private String businessTown ;
	/** 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessCounty")
	private String businessCounty ;
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	@Column(name = "businessAreaName")
	private String businessAreaName ;
	/** 属性保单打印日期/保单打印日期 */
	@Column(name = "printDate")
	private java.util.Date printDate ;
	/** 属性保单收费日期/保单收费日期 */
	@Column(name = "payDate")
	private java.util.Date payDate ;
	/** 属性起保分钟/起保分钟 */
	@Column(name = "startMinute")
	private java.lang.Integer startMinute ;
	/** 属性终保分钟/终保分钟 */
	@Column(name = "endMinute")
	private java.lang.Integer endMinute ;
	/** 属性每次事故责任限额/每次事故责任限额 */
	@Column(name = "limitAmount")
	private java.lang.Double limitAmount ;
	/** 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否 */
	@Column(name = "thirdKnow")
	private String thirdKnow ;
	/** 属性agentRemark/agentRemark */
	@Column(name = "agentRemark")
	private String agentRemark ;
	/** 属性ncarperpFlag/ncarperpFlag */
	@Column(name = "nCarPerpFlag")
	private String nCarPerpFlag ;
	/** 属性groupNo/groupNo */
	@Column(name = "groupNo")
	private String groupNo ;
	/** 属性groupFlag/groupFlag */
	@Column(name = "groupFlag")
	private String groupFlag ;
	/** 属性baseperFormanceRate/baseperFormanceRate */
	@Column(name = "basePerformanceRate")
	private java.lang.Double basePerformanceRate ;
	/** 属性encourageperFormanceRate/encourageperFormanceRate */
	@Column(name = "encouragePerformanceRate")
	private java.lang.Double encouragePerformanceRate ;
	/** 属性见费出单标志[0]非见费出单[1]见费出单/见费出单标志[0]非见费出单[1]见费出单 */
	@Column(name = "isSeeFeeFlag")
	private String isSeeFeeFlag ;
	/** 属性统计日期/统计日期 */
	@Column(name = "validCountDate")
	private java.util.Date validCountDate ;
	/** 属性绩效总比例/绩效总比例 */
	@Column(name = "sumRate")
	private java.lang.Double sumRate ;
	/** 属性标准保费折算系数/标准保费折算系数 */
	@Column(name = "standardRate")
	private java.lang.Double standardRate ;
	/** 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中 */
	@Column(name = "agriFlag")
	private String agriFlag ;
	/** 属性版本号/版本号 */
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取 */
	@Column(name = "coinsPremiumType")
	private String coinsPremiumType ;
	/** 属性出单点出单标志/出单点出单标志 */
	@Column(name = "eccFlag")
	private String eccFlag ;
	/** 属性出单点试算单号/出单点试算单号 */
	@Column(name = "ssProposalNo")
	private String ssProposalNo ;
	/** 属性业务年度/业务年度 */
	@Column(name = "businessYear")
	private String businessYear ;
	/** 属性统筹区/统筹区 */
	@Column(name = "makeArea")
	private String makeArea ;
	/** 属性归属区域：镇/归属区域：镇 */
	@Column(name = "businessCity")
	private String businessCity ;
	/** 属性归属区域：村/归属区域：村 */
	@Column(name = "businessArea")
	private String businessArea ;
	/** 属性联办比例/联办比例 */
	@Column(name = "allianceRate")
	private java.lang.Double allianceRate ;
	/** 属性lastInsurerCom/lastInsurerCom */
	@Column(name = "lastInsurerCom")
	private String lastInsurerCom ;
	/** 属性lastPrintNo/lastPrintNo */
	@Column(name = "lastPrintNo")
	private String lastPrintNo ;
	/** 属性nationFlag/nationFlag */
	@Column(name = "nationFlag")
	private String nationFlag ;
	/** 属性newEndDate/newEndDate */
	@Column(name = "newEndDate")
	private java.util.Date newEndDate ;
	/** 属性newStartDate/newStartDate */
	@Column(name = "newStartDate")
	private java.util.Date newStartDate ;
	/** 属性projectsFlag/projectsFlag */
	@Column(name = "projectsFlag")
	private String projectsFlag ;
	/** 属性proposalLevel/proposalLevel */
	@Column(name = "proposalLevel")
	private String proposalLevel ;
	/** 属性startstAges/startstAges */
	@Column(name = "startstAges")
	private java.lang.Integer startstAges ;
	/** 属性stopTimes/stopTimes */
	@Column(name = "stopTimes")
	private String stopTimes ;
	/** 属性subBusinessNature/subBusinessNature */
	@Column(name = "subBusinessNature")
	private String subBusinessNature ;
	/** 属性preinvoiceFlag/preinvoiceFlag */
	@Column(name = "preInvoiceFlag")
	private String preInvoiceFlag ;
	/** 属性periodFlag/periodFlag */
	@Column(name = "periodFlag")
	private String periodFlag ;
	/** 属性hangupFlag/hangupFlag */
	@Column(name = "hangupFlag")
	private String hangupFlag ;
	/** 属性channelAdjustValue/channelAdjustValue */
	@Column(name = "channelAdjustValue")
	private java.lang.Double channelAdjustValue ;
	/** 属性autonomyAdjustValue/autonomyAdjustValue */
	@Column(name = "autonomyAdjustValue")
	private java.lang.Double autonomyAdjustValue ;
	/** 属性localModelDiscountz/localModelDiscountz */
	@Column(name = "localModelDiscountZ")
	private java.lang.Double localModelDiscountZ ;
	/** 属性localModelPremium/localModelPremium */
	@Column(name = "localModelPremium")
	private java.lang.Double localModelPremium ;
	/** 属性clauseType/clauseType */
	@Column(name = "clauseType")
	private String clauseType ;
	/** 属性localModelDiscountq/localModelDiscountq */
	@Column(name = "localModelDiscountQ")
	private java.lang.Double localModelDiscountQ ;
	/** 属性systemFlag/systemFlag */
	@Column(name = "systemFlag")
	private String systemFlag ;
	/** 属性agriType/agriType */
	@Column(name = "agriType")
	private String agriType ;
	/** 属性bankCode/bankCode */
	@Column(name = "bankCode")
	private String bankCode ;
	/** 属性channelType/channelType */
	@Column(name = "channelType")
	private String channelType ;
	/** 属性effectiveimmediatelyFlag/effectiveimmediatelyFlag */
	@Column(name = "effectiveImmediatelyFlag")
	private String effectiveImmediatelyFlag ;
	/** 属性lastInsurerCode/lastInsurerCode */
	@Column(name = "lastInsurerCode")
	private String lastInsurerCode ;
	/** 属性groupType/groupType */
	@Column(name = "groupType")
	private String groupType ;
	/** 属性saleName/saleName */
	@Column(name = "saleName")
	private String saleName ;
	/** 属性salePhone/salePhone */
	@Column(name = "salePhone")
	private String salePhone ;
	/** 属性saleComCode/saleComCode */
	@Column(name = "saleComCode")
	private String saleComCode ;
	/** 属性saleComName/saleComName */
	@Column(name = "saleComName")
	private String saleComName ;
	/** 属性saleComAddress/saleComAddress */
	@Column(name = "saleComAddress")
	private String saleComAddress ;
	/** 属性saleAgentAddress/saleAgentAddress */
	@Column(name = "saleAgentAddress")
	private String saleAgentAddress ;
	/** 属性saleAgentPersonName/saleAgentPersonName */
	@Column(name = "saleAgentPersonName")
	private String saleAgentPersonName ;
	/** 属性saleAgentPersonId/saleAgentPersonId */
	@Column(name = "saleAgentPersonId")
	private String saleAgentPersonId ;
	/** 属性saleAgentPermitNo/saleAgentPermitNo */
	@Column(name = "saleAgentPermitNo")
	private String saleAgentPermitNo ;
	/** 属性validTime/validTime */
	@Column(name = "validTime")
	private String validTime ;
	/** 属性effectFlag/effectFlag */
	@Column(name = "effectFlag")
	private String effectFlag ;
	/** 属性agentClass/agentClass */
	@Column(name = "agentClass")
	private String agentClass ;
	/** 属性topCommisionRate/topCommisionRate */
	@Column(name = "topCommisionRate")
	private String topCommisionRate ;
	/** 属性intCommisionRate/intCommisionRate */
	@Column(name = "intCommisionRate")
	private String intCommisionRate ;
	/** 属性exChangeRate/exChangeRate */
	@Column(name = "exchangeRate")
	private java.lang.Double exchangeRate ;
	/** 属性adjustClaimReasonCode/adjustClaimReasonCode */
	@Column(name = "adjustClaimReasonCode")
	private String adjustClaimReasonCode ;
	/** 属性adjustClaimReasonRate/adjustClaimReasonRate */
	@Column(name = "adjustClaimReasonRate")
	private java.lang.Integer adjustClaimReasonRate ;
	/** 属性comCostprem/comCostprem */
	@Column(name = "comCostPrem")
	private java.lang.Integer comCostPrem ;
	/** 属性ctpCostprem/ctpCostprem */
	@Column(name = "ctpCostPrem")
	private java.lang.Integer ctpCostPrem ;
	/** 属性entireCostdisCount/entireCostdisCount */
	@Column(name = "entireCostDiscount")
	private java.lang.Integer entireCostDiscount ;
	/** 属性entireRecommendisCount/entireRecommendisCount */
	@Column(name = "entireRecommenDiscount")
	private java.lang.Integer entireRecommenDiscount ;
	/** 属性entireExpdisCount/entireExpdisCount */
	@Column(name = "entireExpDiscount")
	private java.lang.Integer entireExpDiscount ;
	/** 属性entireUwritingdisCount/entireUwritingdisCount */
	@Column(name = "entireUwritingDiscount")
	private java.lang.Integer entireUwritingDiscount ;
	/** 属性hopedisCount/hopedisCount */
	@Column(name = "hopeDiscount")
	private java.lang.Double hopeDiscount ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
	/** 属性总不含税保费/总不含税保费 */
	@Column(name = "sumNoTaxPremium")
	private java.lang.Double sumNoTaxPremium ;
	/** 属性总税额/总税额 */
	@Column(name = "sumTaxFee")
	private java.lang.Double sumTaxFee ;
	/** 属性isThirdBusiness/isThirdBusiness */
	@Column(name = "isThirdBusiness")
	private String isThirdBusiness ;
	/** 属性recordCode/recordCode */
	@Column(name = "recordCode")
	private String recordCode ;
	/** 属性税种属性0-营业税 1-增值税/税种属性0-营业税 1-增值税 */
	@Column(name = "taxType")
	private String taxType ;
	/** 属性是否推荐修理厂/是否推荐修理厂 */
	@Column(name = "isRepairCode")
	private String isRepairCode ;
	/** 属性推荐修理厂代码 /推荐修理厂代码  */
	@Column(name = "repairCode")
	private String repairCode ;
	/** 属性推荐修理厂名称 /推荐修理厂名称  */
	@Column(name = "repairName")
	private String repairName ;
	/** 属性网销渠道/网销渠道 */
	@Column(name = "wxChannelCode")
	private String wxChannelCode ;
	/** 属性是否线上/是否线上 */
	@Column(name = "isOnline")
	private String isOnline ;
	/** 属性是否C端/是否C端 */
	@Column(name = "isCustomer")
	private String isCustomer ;
	/** 属性是否验标/是否验标 */
	@Column(name = "inceptionFlag")
	private String inceptionFlag ;
	/** 属性是否承保公示/是否承保公示 */
	@Column(name = "notificationFlag")
	private String notificationFlag ;
	/** 属性营销员类型/行业类别代码/营销员类型/行业类别代码 */
	@Column(name = "agentBusinessType")
	private String agentBusinessType ;
	/** 属性营销员类型/行业类别名称/营销员类型/行业类别名称 */
	@Column(name = "agentBusinessTypeName")
	private String agentBusinessTypeName ;
	/** 属性交强险预期赔付率/交强险预期赔付率 */
	@Column(name = "ctpElr")
	private java.lang.Integer ctpElr ;
	/** 属性商业险预期赔付率/商业险预期赔付率 */
	@Column(name = "comElr")
	private java.lang.Integer comElr ;
	/** 属性整单预期赔付率/整单预期赔付率 */
	@Column(name = "elr")
	private java.lang.Integer elr ;
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
	 * 属性流水号/流水号的getter方法
	 */
	public String getPrintNo() {
		return printNo;
	}
	/**
	 * 属性流水号/流水号的setter方法
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
	 * 属性保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋/保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋/保单类型（个人/集体）▲--**对于预约货运用代码来区分国内、进--**口、出口港澳、出口远洋--**19国内      20进口--**21出口港澳  22出口远洋的setter方法
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
	public java.lang.Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(java.lang.Integer startHour) {
		this.startHour = startHour;
	} 	
	/**
	 * 属性终保日期/终保日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期/终保日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性终保小时/终保小时的getter方法
	 */
	public java.lang.Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终保小时/终保小时的setter方法
	 */
	public void setEndHour(java.lang.Integer endHour) {
		this.endHour = endHour;
	} 	
	/**
	 * 属性净费率/净费率的getter方法
	 */
	public java.lang.Double getPureRate() {
		return pureRate;
	}
	/**
	 * 属性净费率/净费率的setter方法
	 */
	public void setPureRate(java.lang.Double pureRate) {
		this.pureRate = pureRate;
	} 	
	/**
	 * 属性手续费比例/手续费比例的getter方法
	 */
	public java.lang.Double getDisRate() {
		return disRate;
	}
	/**
	 * 属性手续费比例/手续费比例的setter方法
	 */
	public void setDisRate(java.lang.Double disRate) {
		this.disRate = disRate;
	} 	
	/**
	 * 属性总折扣率/总折扣率的getter方法
	 */
	public java.lang.Double getDisCount() {
		return disCount;
	}
	/**
	 * 属性总折扣率/总折扣率的setter方法
	 */
	public void setDisCount(java.lang.Double disCount) {
		this.disCount = disCount;
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
	 * 属性总保险价值/总保险价值的getter方法
	 */
	public java.lang.Double getSumValue() {
		return sumValue;
	}
	/**
	 * 属性总保险价值/总保险价值的setter方法
	 */
	public void setSumValue(java.lang.Double sumValue) {
		this.sumValue = sumValue;
	} 	
	/**
	 * 属性总保险金额/总保险金额的getter方法
	 */
	public java.lang.Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保险金额/总保险金额的setter方法
	 */
	public void setSumAmount(java.lang.Double sumAmount) {
		this.sumAmount = sumAmount;
	} 	
	/**
	 * 属性总折扣金额/总折扣金额的getter方法
	 */
	public java.lang.Double getSumDiscount() {
		return sumDiscount;
	}
	/**
	 * 属性总折扣金额/总折扣金额的setter方法
	 */
	public void setSumDiscount(java.lang.Double sumDiscount) {
		this.sumDiscount = sumDiscount;
	} 	
	/**
	 * 属性总附加险保费/总附加险保费的getter方法
	 */
	public java.lang.Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总附加险保费/总附加险保费的setter方法
	 */
	public void setSumPremium(java.lang.Double sumPremium) {
		this.sumPremium = sumPremium;
	} 	
	/**
	 * 属性总被保险总数量/人数/户数/总被保险总数量/人数/户数的getter方法
	 */
	public java.lang.Double getSumSubPrem() {
		return sumSubPrem;
	}
	/**
	 * 属性总被保险总数量/人数/户数/总被保险总数量/人数/户数的setter方法
	 */
	public void setSumSubPrem(java.lang.Double sumSubPrem) {
		this.sumSubPrem = sumSubPrem;
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
	 * 属性交费方式/交费方式的getter方法
	 */
	public String getAutoTransRenewFlag() {
		return autoTransRenewFlag;
	}
	/**
	 * 属性交费方式/交费方式的setter方法
	 */
	public void setAutoTransRenewFlag(String autoTransRenewFlag) {
		this.autoTransRenewFlag = autoTransRenewFlag;
	} 	
	/**
	 * 属性争议解决方式/争议解决方式的getter方法
	 */
	public String getArgueSolution() {
		return argueSolution;
	}
	/**
	 * 属性争议解决方式/争议解决方式的setter方法
	 */
	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	} 	
	/**
	 * 属性仲裁委员会名称/仲裁委员会名称的getter方法
	 */
	public String getArbitBoardName() {
		return arbitBoardName;
	}
	/**
	 * 属性仲裁委员会名称/仲裁委员会名称的setter方法
	 */
	public void setArbitBoardName(String arbitBoardName) {
		this.arbitBoardName = arbitBoardName;
	} 	
	/**
	 * 属性约定分期交费次数/约定分期交费次数的getter方法
	 */
	public java.lang.Integer getPayTimes() {
		return payTimes;
	}
	/**
	 * 属性约定分期交费次数/约定分期交费次数的setter方法
	 */
	public void setPayTimes(java.lang.Integer payTimes) {
		this.payTimes = payTimes;
	} 	
	/**
	 * 属性批改次数/批改次数的getter方法
	 */
	public java.lang.Integer getEndorseTimes() {
		return endorseTimes;
	}
	/**
	 * 属性批改次数/批改次数的setter方法
	 */
	public void setEndorseTimes(java.lang.Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	} 	
	/**
	 * 属性理赔次数/理赔次数的getter方法
	 */
	public java.lang.Integer getClaimTimes() {
		return claimTimes;
	}
	/**
	 * 属性理赔次数/理赔次数的setter方法
	 */
	public void setClaimTimes(java.lang.Integer claimTimes) {
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
	public java.lang.Integer getInputHour() {
		return inputHour;
	}
	/**
	 * 属性计算机输单小时/计算机输单小时的setter方法
	 */
	public void setInputHour(java.lang.Integer inputHour) {
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
	public java.util.Date getStatisticSym() {
		return statisticSym;
	}
	/**
	 * 属性保单统计年月/保单统计年月的setter方法
	 */
	public void setStatisticSym(java.util.Date statisticSym) {
		this.statisticSym = statisticSym;
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
	 * 属性共保标志/共保标志的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性共保标志/共保标志的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	} 	
	/**
	 * 属性商业分保标志/商业分保标志的getter方法
	 */
	public String getReinsFlag() {
		return reinsFlag;
	}
	/**
	 * 属性商业分保标志/商业分保标志的setter方法
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
	 * 属性核保标志/核保标志的getter方法
	 */
	public String getUnderwriteFlag() {
		return underwriteFlag;
	}
	/**
	 * 属性核保标志/核保标志的setter方法
	 */
	public void setUnderwriteFlag(String underwriteFlag) {
		this.underwriteFlag = underwriteFlag;
	} 	
	/**
	 * 属性其它标志字段/其它标志字段的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性其它标志字段/其它标志字段的setter方法
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
	 * 属性disrate2/disrate2的getter方法
	 */
	public java.lang.Double getDisRate1() {
		return disRate1;
	}
	/**
	 * 属性disrate2/disrate2的setter方法
	 */
	public void setDisRate1(java.lang.Double disRate1) {
		this.disRate1 = disRate1;
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
	 * 属性upDaterCode/upDaterCode的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性upDaterCode/upDaterCode的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 	
	/**
	 * 属性upDateDate/upDateDate的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性upDateDate/upDateDate的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 	
	/**
	 * 属性upDateHour/upDateHour的getter方法
	 */
	public String getUpdateHour() {
		return updateHour;
	}
	/**
	 * 属性upDateHour/upDateHour的setter方法
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
	public String getShareholderFlag() {
		return shareholderFlag;
	}
	/**
	 * 属性shareHolderFlag/shareHolderFlag的setter方法
	 */
	public void setShareholderFlag(String shareholderFlag) {
		this.shareholderFlag = shareholderFlag;
	} 	
	/**
	 * 属性agreeMentno/agreeMentno的getter方法
	 */
	public String getAgreementNo() {
		return agreementNo;
	}
	/**
	 * 属性agreeMentno/agreeMentno的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	} 	
	/**
	 * 属性inQuiryNo/inQuiryNo的getter方法
	 */
	public String getInquiryNo() {
		return inquiryNo;
	}
	/**
	 * 属性inQuiryNo/inQuiryNo的setter方法
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
	public java.lang.Integer getSumQuantity() {
		return sumQuantity;
	}
	/**
	 * 属性sumQuantity/sumQuantity的setter方法
	 */
	public void setSumQuantity(java.lang.Integer sumQuantity) {
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
	public java.lang.Double getStatQuantity() {
		return statQuantity;
	}
	/**
	 * 属性统计口径的承保数量/统计口径的承保数量的setter方法
	 */
	public void setStatQuantity(java.lang.Double statQuantity) {
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
	public java.lang.Double getSumInsured() {
		return sumInsured;
	}
	/**
	 * 属性参保农户户次/参保农户户次的setter方法
	 */
	public void setSumInsured(java.lang.Double sumInsured) {
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
	public String getBusinessAreaName() {
		return businessAreaName;
	}
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的setter方法
	 */
	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
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
	public java.lang.Integer getStartMinute() {
		return startMinute;
	}
	/**
	 * 属性起保分钟/起保分钟的setter方法
	 */
	public void setStartMinute(java.lang.Integer startMinute) {
		this.startMinute = startMinute;
	} 	
	/**
	 * 属性终保分钟/终保分钟的getter方法
	 */
	public java.lang.Integer getEndMinute() {
		return endMinute;
	}
	/**
	 * 属性终保分钟/终保分钟的setter方法
	 */
	public void setEndMinute(java.lang.Integer endMinute) {
		this.endMinute = endMinute;
	} 	
	/**
	 * 属性每次事故责任限额/每次事故责任限额的getter方法
	 */
	public java.lang.Double getLimitAmount() {
		return limitAmount;
	}
	/**
	 * 属性每次事故责任限额/每次事故责任限额的setter方法
	 */
	public void setLimitAmount(java.lang.Double limitAmount) {
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
	 * 属性agentRemark/agentRemark的getter方法
	 */
	public String getAgentRemark() {
		return agentRemark;
	}
	/**
	 * 属性agentRemark/agentRemark的setter方法
	 */
	public void setAgentRemark(String agentRemark) {
		this.agentRemark = agentRemark;
	} 	
	/**
	 * 属性ncarperpFlag/ncarperpFlag的getter方法
	 */
	public String getNCarPerpFlag() {
		return nCarPerpFlag;
	}
	/**
	 * 属性ncarperpFlag/ncarperpFlag的setter方法
	 */
	public void setNCarPerpFlag(String nCarPerpFlag) {
		this.nCarPerpFlag = nCarPerpFlag;
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
	 * 属性baseperFormanceRate/baseperFormanceRate的getter方法
	 */
	public java.lang.Double getBasePerformanceRate() {
		return basePerformanceRate;
	}
	/**
	 * 属性baseperFormanceRate/baseperFormanceRate的setter方法
	 */
	public void setBasePerformanceRate(java.lang.Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	} 	
	/**
	 * 属性encourageperFormanceRate/encourageperFormanceRate的getter方法
	 */
	public java.lang.Double getEncouragePerformanceRate() {
		return encouragePerformanceRate;
	}
	/**
	 * 属性encourageperFormanceRate/encourageperFormanceRate的setter方法
	 */
	public void setEncouragePerformanceRate(java.lang.Double encouragePerformanceRate) {
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
	public java.lang.Double getSumRate() {
		return sumRate;
	}
	/**
	 * 属性绩效总比例/绩效总比例的setter方法
	 */
	public void setSumRate(java.lang.Double sumRate) {
		this.sumRate = sumRate;
	} 	
	/**
	 * 属性标准保费折算系数/标准保费折算系数的getter方法
	 */
	public java.lang.Double getStandardRate() {
		return standardRate;
	}
	/**
	 * 属性标准保费折算系数/标准保费折算系数的setter方法
	 */
	public void setStandardRate(java.lang.Double standardRate) {
		this.standardRate = standardRate;
	} 	
	/**
	 * 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中的getter方法
	 */
	public String getAgriFlag() {
		return agriFlag;
	}
	/**
	 * 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中的setter方法
	 */
	public void setAgriFlag(String agriFlag) {
		this.agriFlag = agriFlag;
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
	public String getCoinsPremiumType() {
		return coinsPremiumType;
	}
	/**
	 * 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取的setter方法
	 */
	public void setCoinsPremiumType(String coinsPremiumType) {
		this.coinsPremiumType = coinsPremiumType;
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
	public String getSsProposalNo() {
		return ssProposalNo;
	}
	/**
	 * 属性出单点试算单号/出单点试算单号的setter方法
	 */
	public void setSsProposalNo(String ssProposalNo) {
		this.ssProposalNo = ssProposalNo;
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
	public java.lang.Double getAllianceRate() {
		return allianceRate;
	}
	/**
	 * 属性联办比例/联办比例的setter方法
	 */
	public void setAllianceRate(java.lang.Double allianceRate) {
		this.allianceRate = allianceRate;
	} 	
	/**
	 * 属性lastInsurerCom/lastInsurerCom的getter方法
	 */
	public String getLastInsurerCom() {
		return lastInsurerCom;
	}
	/**
	 * 属性lastInsurerCom/lastInsurerCom的setter方法
	 */
	public void setLastInsurerCom(String lastInsurerCom) {
		this.lastInsurerCom = lastInsurerCom;
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
	 * 属性newEndDate/newEndDate的getter方法
	 */
	public java.util.Date getNewEndDate() {
		return newEndDate;
	}
	/**
	 * 属性newEndDate/newEndDate的setter方法
	 */
	public void setNewEndDate(java.util.Date newEndDate) {
		this.newEndDate = newEndDate;
	} 	
	/**
	 * 属性newStartDate/newStartDate的getter方法
	 */
	public java.util.Date getNewStartDate() {
		return newStartDate;
	}
	/**
	 * 属性newStartDate/newStartDate的setter方法
	 */
	public void setNewStartDate(java.util.Date newStartDate) {
		this.newStartDate = newStartDate;
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
	 * 属性startstAges/startstAges的getter方法
	 */
	public java.lang.Integer getStartstAges() {
		return startstAges;
	}
	/**
	 * 属性startstAges/startstAges的setter方法
	 */
	public void setStartstAges(java.lang.Integer startstAges) {
		this.startstAges = startstAges;
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
	public String getPreInvoiceFlag() {
		return preInvoiceFlag;
	}
	/**
	 * 属性preinvoiceFlag/preinvoiceFlag的setter方法
	 */
	public void setPreInvoiceFlag(String preInvoiceFlag) {
		this.preInvoiceFlag = preInvoiceFlag;
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
	public java.lang.Double getChannelAdjustValue() {
		return channelAdjustValue;
	}
	/**
	 * 属性channelAdjustValue/channelAdjustValue的setter方法
	 */
	public void setChannelAdjustValue(java.lang.Double channelAdjustValue) {
		this.channelAdjustValue = channelAdjustValue;
	} 	
	/**
	 * 属性autonomyAdjustValue/autonomyAdjustValue的getter方法
	 */
	public java.lang.Double getAutonomyAdjustValue() {
		return autonomyAdjustValue;
	}
	/**
	 * 属性autonomyAdjustValue/autonomyAdjustValue的setter方法
	 */
	public void setAutonomyAdjustValue(java.lang.Double autonomyAdjustValue) {
		this.autonomyAdjustValue = autonomyAdjustValue;
	} 	
	/**
	 * 属性localModelDiscountz/localModelDiscountz的getter方法
	 */
	public java.lang.Double getLocalModelDiscountZ() {
		return localModelDiscountZ;
	}
	/**
	 * 属性localModelDiscountz/localModelDiscountz的setter方法
	 */
	public void setLocalModelDiscountZ(java.lang.Double localModelDiscountZ) {
		this.localModelDiscountZ = localModelDiscountZ;
	} 	
	/**
	 * 属性localModelPremium/localModelPremium的getter方法
	 */
	public java.lang.Double getLocalModelPremium() {
		return localModelPremium;
	}
	/**
	 * 属性localModelPremium/localModelPremium的setter方法
	 */
	public void setLocalModelPremium(java.lang.Double localModelPremium) {
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
	public java.lang.Double getLocalModelDiscountQ() {
		return localModelDiscountQ;
	}
	/**
	 * 属性localModelDiscountq/localModelDiscountq的setter方法
	 */
	public void setLocalModelDiscountQ(java.lang.Double localModelDiscountQ) {
		this.localModelDiscountQ = localModelDiscountQ;
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
	 * 属性effectiveimmediatelyFlag/effectiveimmediatelyFlag的getter方法
	 */
	public String getEffectiveImmediatelyFlag() {
		return effectiveImmediatelyFlag;
	}
	/**
	 * 属性effectiveimmediatelyFlag/effectiveimmediatelyFlag的setter方法
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
	 * 属性saleComCode/saleComCode的getter方法
	 */
	public String getSaleComCode() {
		return saleComCode;
	}
	/**
	 * 属性saleComCode/saleComCode的setter方法
	 */
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	} 	
	/**
	 * 属性saleComName/saleComName的getter方法
	 */
	public String getSaleComName() {
		return saleComName;
	}
	/**
	 * 属性saleComName/saleComName的setter方法
	 */
	public void setSaleComName(String saleComName) {
		this.saleComName = saleComName;
	} 	
	/**
	 * 属性saleComAddress/saleComAddress的getter方法
	 */
	public String getSaleComAddress() {
		return saleComAddress;
	}
	/**
	 * 属性saleComAddress/saleComAddress的setter方法
	 */
	public void setSaleComAddress(String saleComAddress) {
		this.saleComAddress = saleComAddress;
	} 	
	/**
	 * 属性saleAgentAddress/saleAgentAddress的getter方法
	 */
	public String getSaleAgentAddress() {
		return saleAgentAddress;
	}
	/**
	 * 属性saleAgentAddress/saleAgentAddress的setter方法
	 */
	public void setSaleAgentAddress(String saleAgentAddress) {
		this.saleAgentAddress = saleAgentAddress;
	} 	
	/**
	 * 属性saleAgentPersonName/saleAgentPersonName的getter方法
	 */
	public String getSaleAgentPersonName() {
		return saleAgentPersonName;
	}
	/**
	 * 属性saleAgentPersonName/saleAgentPersonName的setter方法
	 */
	public void setSaleAgentPersonName(String saleAgentPersonName) {
		this.saleAgentPersonName = saleAgentPersonName;
	} 	
	/**
	 * 属性saleAgentPersonId/saleAgentPersonId的getter方法
	 */
	public String getSaleAgentPersonId() {
		return saleAgentPersonId;
	}
	/**
	 * 属性saleAgentPersonId/saleAgentPersonId的setter方法
	 */
	public void setSaleAgentPersonId(String saleAgentPersonId) {
		this.saleAgentPersonId = saleAgentPersonId;
	} 	
	/**
	 * 属性saleAgentPermitNo/saleAgentPermitNo的getter方法
	 */
	public String getSaleAgentPermitNo() {
		return saleAgentPermitNo;
	}
	/**
	 * 属性saleAgentPermitNo/saleAgentPermitNo的setter方法
	 */
	public void setSaleAgentPermitNo(String saleAgentPermitNo) {
		this.saleAgentPermitNo = saleAgentPermitNo;
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
	 * 属性exChangeRate/exChangeRate的getter方法
	 */
	public java.lang.Double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * 属性exChangeRate/exChangeRate的setter方法
	 */
	public void setExchangeRate(java.lang.Double exchangeRate) {
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
	public java.lang.Integer getAdjustClaimReasonRate() {
		return adjustClaimReasonRate;
	}
	/**
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate的setter方法
	 */
	public void setAdjustClaimReasonRate(java.lang.Integer adjustClaimReasonRate) {
		this.adjustClaimReasonRate = adjustClaimReasonRate;
	} 	
	/**
	 * 属性comCostprem/comCostprem的getter方法
	 */
	public java.lang.Integer getComCostPrem() {
		return comCostPrem;
	}
	/**
	 * 属性comCostprem/comCostprem的setter方法
	 */
	public void setComCostPrem(java.lang.Integer comCostPrem) {
		this.comCostPrem = comCostPrem;
	} 	
	/**
	 * 属性ctpCostprem/ctpCostprem的getter方法
	 */
	public java.lang.Integer getCtpCostPrem() {
		return ctpCostPrem;
	}
	/**
	 * 属性ctpCostprem/ctpCostprem的setter方法
	 */
	public void setCtpCostPrem(java.lang.Integer ctpCostPrem) {
		this.ctpCostPrem = ctpCostPrem;
	} 	
	/**
	 * 属性entireCostdisCount/entireCostdisCount的getter方法
	 */
	public java.lang.Integer getEntireCostDiscount() {
		return entireCostDiscount;
	}
	/**
	 * 属性entireCostdisCount/entireCostdisCount的setter方法
	 */
	public void setEntireCostDiscount(java.lang.Integer entireCostDiscount) {
		this.entireCostDiscount = entireCostDiscount;
	} 	
	/**
	 * 属性entireRecommendisCount/entireRecommendisCount的getter方法
	 */
	public java.lang.Integer getEntireRecommenDiscount() {
		return entireRecommenDiscount;
	}
	/**
	 * 属性entireRecommendisCount/entireRecommendisCount的setter方法
	 */
	public void setEntireRecommenDiscount(java.lang.Integer entireRecommenDiscount) {
		this.entireRecommenDiscount = entireRecommenDiscount;
	} 	
	/**
	 * 属性entireExpdisCount/entireExpdisCount的getter方法
	 */
	public java.lang.Integer getEntireExpDiscount() {
		return entireExpDiscount;
	}
	/**
	 * 属性entireExpdisCount/entireExpdisCount的setter方法
	 */
	public void setEntireExpDiscount(java.lang.Integer entireExpDiscount) {
		this.entireExpDiscount = entireExpDiscount;
	} 	
	/**
	 * 属性entireUwritingdisCount/entireUwritingdisCount的getter方法
	 */
	public java.lang.Integer getEntireUwritingDiscount() {
		return entireUwritingDiscount;
	}
	/**
	 * 属性entireUwritingdisCount/entireUwritingdisCount的setter方法
	 */
	public void setEntireUwritingDiscount(java.lang.Integer entireUwritingDiscount) {
		this.entireUwritingDiscount = entireUwritingDiscount;
	} 	
	/**
	 * 属性hopedisCount/hopedisCount的getter方法
	 */
	public java.lang.Double getHopeDiscount() {
		return hopeDiscount;
	}
	/**
	 * 属性hopedisCount/hopedisCount的setter方法
	 */
	public void setHopeDiscount(java.lang.Double hopeDiscount) {
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
	public java.lang.Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
	public void setSumNoTaxPremium(java.lang.Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	} 	
	/**
	 * 属性总税额/总税额的getter方法
	 */
	public java.lang.Double getSumTaxFee() {
		return sumTaxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setSumTaxFee(java.lang.Double sumTaxFee) {
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
	public String getWxChannelCode() {
		return wxChannelCode;
	}
	/**
	 * 属性网销渠道/网销渠道的setter方法
	 */
	public void setWxChannelCode(String wxChannelCode) {
		this.wxChannelCode = wxChannelCode;
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
	public String getAgentBusinessType() {
		return agentBusinessType;
	}
	/**
	 * 属性营销员类型/行业类别代码/营销员类型/行业类别代码的setter方法
	 */
	public void setAgentBusinessType(String agentBusinessType) {
		this.agentBusinessType = agentBusinessType;
	} 	
	/**
	 * 属性营销员类型/行业类别名称/营销员类型/行业类别名称的getter方法
	 */
	public String getAgentBusinessTypeName() {
		return agentBusinessTypeName;
	}
	/**
	 * 属性营销员类型/行业类别名称/营销员类型/行业类别名称的setter方法
	 */
	public void setAgentBusinessTypeName(String agentBusinessTypeName) {
		this.agentBusinessTypeName = agentBusinessTypeName;
	} 	
	/**
	 * 属性交强险预期赔付率/交强险预期赔付率的getter方法
	 */
	public java.lang.Integer getCtpElr() {
		return ctpElr;
	}
	/**
	 * 属性交强险预期赔付率/交强险预期赔付率的setter方法
	 */
	public void setCtpElr(java.lang.Integer ctpElr) {
		this.ctpElr = ctpElr;
	} 	
	/**
	 * 属性商业险预期赔付率/商业险预期赔付率的getter方法
	 */
	public java.lang.Integer getComElr() {
		return comElr;
	}
	/**
	 * 属性商业险预期赔付率/商业险预期赔付率的setter方法
	 */
	public void setComElr(java.lang.Integer comElr) {
		this.comElr = comElr;
	} 	
	/**
	 * 属性整单预期赔付率/整单预期赔付率的getter方法
	 */
	public java.lang.Integer getElr() {
		return elr;
	}
	/**
	 * 属性整单预期赔付率/整单预期赔付率的setter方法
	 */
	public void setElr(java.lang.Integer elr) {
		this.elr = elr;
	} 	
}