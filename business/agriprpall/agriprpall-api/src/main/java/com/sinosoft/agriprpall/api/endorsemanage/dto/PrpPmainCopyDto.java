package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 批改保单信息表Api操作对象
 */
public class PrpPmainCopyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	private String endorseNo ;
	/** 属性保单号码/保单号码 */
	private String policyNo ;
	/** 属性险类代码/险类代码 */
	private String classCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性投保单号/投保单号 */
	private String proposalNo ;
	/** 属性 合同号(供合保单使用)/ 合同号(供合保单使用) */
	private String contractNo ;
	/** 属性保单种类(0普通1定额)/保单种类(0普通1定额) */
	private String policySort ;
	/** 属性保单印刷号/保单印刷号 */
	private String printNo ;
	/** 属性业务来源（直接/代理）/业务来源（直接/代理） */
	private String businessNature ;
	/** 属性语种标志（C/E/…）/语种标志（C/E/…） */
	private String language ;
	/** 属性 保单类型（个人/集体）/ 保单类型（个人/集体） */
	private String policyType ;
	/** 属性 投保人代码 / 投保人代码  */
	private String appliCode ;
	/** 属性投保人名称/投保人名称 */
	private String appliName ;
	/** 属性 投保人地址/ 投保人地址 */
	private String appliAddress ;
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;
	/** 属性 被保险人地址/ 被保险人地址 */
	private String insuredAddress ;
	/** 属性 签单日期（制单日期）/ 签单日期（制单日期） */
	private Date operateDate ;
	/** 属性起保日期/起保日期 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date startDate ;
	/** 属性起保小时/起保小时 */
	private Integer startHour ;
	/** 属性终保日期/终保日期 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endDate ;
	/** 属性终保小时/终保小时 */
	private Integer endHour ;
	/** 属性 净费率/ 净费率 */
	private Double pureRate ;
	/** 属性手续费比例/手续费比例 */
	private Double disRate ;
	/** 属性总折扣率/总折扣率 */
	private Double discount ;
	/** 属性 币别代码/ 币别代码 */
	private String currency ;
	/** 属性总保险价值/总保险价值 */
	private Double sumValue ;
	/** 属性总保额(折算为人民币总保额)/总保额(折算为人民币总保额) */
	private Double sumAmount ;
	/** 属性总折扣金额/总折扣金额 */
	private Double sumDiscount ;
	/** 属性总保险费(折算为人民币总保费)/总保险费(折算为人民币总保费) */
	private Double sumPremium ;
	/** 属性总附加险保费/总附加险保费 */
	private Double sumSubPrem ;
	/** 属性 被保险总数量/人数/户数--** 压力容器总数/ 被保险总数量/人数/户数--** 压力容器总数 */
	private Integer sumQuantity ;
	/** 属性judicalCode/judicalCode */
	private String judicalCode ;
	/** 属性司法管辖/司法管辖 */
	private String judicalScope ;
	/** 属性缴费方式（0、现金 1、银行转帐 2、刷卡 3、支票）/缴费方式（0、现金 1、银行转帐 2、刷卡 3、支票） */
	private String autoTransRenewFlag ;
	/** 属性争议解决方式▲--** 1 诉讼；2 仲裁/争议解决方式▲--** 1 诉讼；2 仲裁 */
	private String argueSolution ;
	/** 属性仲裁委员会名称/仲裁委员会名称 */
	private String arbitBoardName ;
	/** 属性约定分期交费次数/约定分期交费次数 */
	private Integer payTimes ;
	/** 属性批改次数/批改次数 */
	private Integer endorseTimes ;
	/** 属性理赔次数/理赔次数 */
	private Integer claimTimes ;
	/** 属性出单机构/出单机构 */
	private String makeCom ;
	/** 属性签单地点/签单地点 */
	private String operateSite ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;
	/** 属性归属业务员代码 /归属业务员代码  */
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
	private Date inputDate ;
	/** 属性计算机输单小时/计算机输单小时 */
	private Integer inputHour ;
	/** 属性核保完成日期/核保完成日期 */
	private Date underwriteEndDate ;
	/** 属性 保单统计年月/ 保单统计年月 */
	private Date statisticSym ;
	/** 属性代理人代码/代理人代码 */
	private String agentCode ;
	/** 属性共保标志--** (0非共保/1主共保/2共保)/共保标志--** (0非共保/1主共保/2共保) */
	private String coinsFlag ;
	/** 属性 商业分保标志--** (0无需分保/1需分保/2已分保)/ 商业分保标志--** (0无需分保/1需分保/2已分保) */
	private String reinsFlag ;
	/** 属性--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它/--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它 */
	private String allinsFlag ;
	/** 属性--** 核保标志--** (0无需核保/1通过/2不通过/9待核保)/--** 核保标志--** (0无需核保/1通过/2不通过/9待核保) */
	private String underwriteFlag ;
	/** 属性其它标志字段/其它标志字段 */
	private String othFlag ;
	/** 属性--** 状态字段/--** 状态字段 */
	private String flag ;
	/** 属性--** 变化保险金额(折算为人民币保额)/--** 变化保险金额(折算为人民币保额) */
	private Double chgAmount ;
	/** 属性--** 变化保险费(折算为人民币保费)/--** 变化保险费(折算为人民币保费) */
	private Double chgPremium ;
	/** 属性--** 变化附加险保费（折算为人民币）/--** 变化附加险保费（折算为人民币） */
	private Double chgSubPrem ;
	/** 属性--** 变化数量/--** 变化数量 */
	private Integer chgQuantity ;
	/** 属性--** 超出部分手续费比例/--** 超出部分手续费比例 */
	private Double disRate1 ;
	/** 属性--** 业务类型--** 0：自营业务，1：分入业务/--** 业务类型--** 0：自营业务，1：分入业务 */
	private String businessFlag ;
	/** 属性updaterCode/updaterCode */
	private String updaterCode ;
	/** 属性updateDate/updateDate */
	private Date updateDate ;
	/** 属性updateHour/updateHour */
	private String updateHour ;
	/** 属性signDate/signDate */
	private Date signDate ;
	/** 属性shareHolderFlag/shareHolderFlag */
	private String shareHolderFlag ;
	/** 属性agreementNo/agreementNo */
	private String agreementNo ;
	/** 属性inquiryNo/inquiryNo */
	private String inquiryNo ;
	/** 属性payMode/payMode */
	private String payMode ;
	/** 属性remark/remark */
	private String remark ;
	/** 属性visaCode/visaCode */
	private String visaCode ;
	/** 属性manualType/manualType */
	private String manualType ;
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
	/** 属性统计口径的承保数量变化量/统计口径的承保数量变化量 */
	private Double chgStatQuantity ;
	/** 属性参保农户户次变化量/参保农户户次变化量 */
	private Double chgInsured ;
	/** 属性专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用/专项业务：对应PrpDcode表的CodeType＝'ArticleType' 健康险统计专用 */
	private String articleType ;
	/** 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone' */
	private String businessProvince ;
	/** 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone' */
	private String businessTown ;
	/** 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone' */
	private String businessCounty ;
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	private String businessAreaName ;
	/** 属性批单打印日期/批单打印日期 */
	private Date printDate ;
	/** 属性批单收费日期/批单收费日期 */
	private Date payDate ;
	/** 属性起保分钟/起保分钟 */
	private Integer startMinute ;
	/** 属性终保分钟/终保分钟 */
	private Integer endMinute ;
	/** 属性每次事故责任限额/每次事故责任限额 */
	private Double limitAmount ;
	/** 属性每次事故责任限额变化量/每次事故责任限额变化量 */
	private Double chgLimitAmount ;
	/** 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否 */
	private String thirdKnow ;
	/** 属性agentRemark/agentRemark */
	private String agentRemark ;
	/** 属性nCarPerpFlag/nCarPerpFlag */
	private String nCarPerpFlag ;
	/** 属性大户归属区域 /大户归属区域  */
	private String richFlyAreasCode ;
	/** 属性大户归属区域名称 /大户归属区域名称  */
	private String richFlyAreasCName ;
	/** 属性大户编码 /大户编码  */
	private String richFlyCode ;
	/** 属性大户名称 /大户名称  */
	private String richFlyCName ;
	/** 属性GroupNo/GroupNo */
	private String groupNo ;
	/** 属性GroupFlag/GroupFlag */
	private String groupFlag ;
	/** 属性BasePerformanceRate/BasePerformanceRate */
	private Double basePerformanceRate ;
	/** 属性encouragePerformanceRate/encouragePerformanceRate */
	private Double encouragePerformanceRate ;
	/** 属性chgBasePerformanceRate/chgBasePerformanceRate */
	private Double chgBasePerformanceRate ;
	/** 属性绩效总比例/绩效总比例 */
	private Double sumRate ;
	/** 属性标准保费折算系数/标准保费折算系数 */
	private Double standardRate ;
	/** 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中 */
	private String agriFlag ;
	/** 属性版本号/版本号 */
	private String versionNo ;
	/** 属性大病医疗专项业务类型/大病医疗专项业务类型 */
	private String bigMedicalType ;
	/** 属性盈利率,大病医疗/盈利率,大病医疗 */
	private String earningsRate ;
	/** 属性大病医疗保险投保方式：1，记名承保 2，不记名承保/大病医疗保险投保方式：1，记名承保 2，不记名承保 */
	private String insuredListType ;
	/** 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取 */
	private String coinsPremiumType ;
	/** 属性businessCity/businessCity */
	private String businessCity ;
	/** 属性allianCreate/allianCreate */
	private Double allianceRate ;
	/** 属性出单点出单标志/出单点出单标志 */
	private String eccFlag ;
	/** 属性出单点试算单号/出单点试算单号 */
	private String ssProposalNo ;
	/** 属性业务年度/业务年度 */
	private String businessYear ;
	/** 属性统筹区/统筹区 */
	private String makeArea ;
	/** 属性归属区域：村/归属区域：村 */
	private String businessArea ;
	/** 属性未续保登记原因代码/未续保登记原因代码 */
	private Double localModelDiscountQ ;
	/** 属性自主核保模型系数/自主核保模型系数 */
	private Double localModelDiscountZ ;
	/** 属性内部模型定价/内部模型定价 */
	private Double localModelPremium ;
	/** 属性销售人员/销售人员 */
	private String saleName ;
	/** 属性联系电话/联系电话 */
	private String salePhone ;
	/** 属性销售公司代码/销售公司代码 */
	private String saleComCode ;
	/** 属性销售公司名称/销售公司名称 */
	private String saleComName ;
	/** 属性销售公司地址/销售公司地址 */
	private String saleComAddress ;
	/** 属性中介机构地址/中介机构地址 */
	private String saleAgentAddress ;
	/** 属性中介机构销售人员姓名/中介机构销售人员姓名 */
	private String saleAgentPersonName ;
	/** 属性中介机构销售人员执业证号/中介机构销售人员执业证号 */
	private String saleAgentPersonId ;
//	/** 属性归属代理人展业证号/归属代理人展业证号 */
//	private String saleAgentPersonNo ;
	/** 属性代收人ID/代收人ID */
	private String agent1Code ;
	/** 属性代收人姓名/代收人姓名 */
	private String agent1Name ;
	/** 属性agentMaxComission/agentMaxComission */
	private Double agentMaxComission ;
	/** 属性代理人名称/代理人名称 */
	private String agentName ;
	/** 属性代理联动类型/代理联动类型 */
	private String agentTypeNo ;
	/** 属性涉农标志/涉农标志 */
	private String agriType ;
	/** 属性手续费拆分方案号/手续费拆分方案号 */
	private String assignNo ;
	/** 属性开户代码/开户代码 */
	private String bankCode ;
	/** 属性bankFlag/bankFlag */
	private String bankFlag ;
	/** 属性bizNoSysFlag/bizNoSysFlag */
	private String bizNoSysFlag ;
	/** 属性备用8/备用8 */
	private String businessRecMark ;
	/** 属性businessTypeFlag/businessTypeFlag */
	private String businessTypeFlag ;
	/** 属性caseNo/caseNo */
	private String caseNo ;
	/** 属性channelCode/channelCode */
	private String channelCode ;
	/** 属性渠道类型/渠道类型 */
	private String channelType ;
	/** 属性备用7/备用7 */
	private String contributionLevel ;
	/** 属性备用6/备用6 */
	private String declareFlag ;
	/** 属性编辑标志/编辑标志 */
	private String editFlag ;
	/** 属性备用4/备用4 */
	private String effectiveImmediatelyFlag ;
	/** 属性兑换率/兑换率 */
	private Double exchangeRate ;
	/** 属性单位/单位 */
	private String extraComCode ;
	/** 属性老系统即时生效标志/老系统即时生效标志 */
	private String effectFlag ;
	/** 属性业务渠道/业务渠道 */
	private String agentClass ;
	/** 属性手续费比例上限/手续费比例上限 */
	private String topCommisionRate ;
	/** 属性手续费比例1/手续费比例1 */
	private String intCommisionRate ;
	/** 属性新车险系统出单标志/新车险系统出单标志 */
	private String systemFlag ;
	/** 属性预开发票标志/预开发票标志 */
	private String preinvoiceFlag ;
	/** 属性提交核保标志  空代表选择提交，1代表普通，2代表特殊/提交核保标志  空代表选择提交，1代表普通，2代表特殊 */
	private String submitUndwrtFlag ;
	/** 属性前台出单修改标志/前台出单修改标志 */
	private String typeFgEditFlag ;
	/** 属性单子类型/单子类型 */
	private String inputType ;
	/** 属性特殊业务申请号/特殊业务申请号 */
	private String specialBusinessNo ;
	/** 属性分期村志/分期村志 */
	private String periodFlag ;
	/** 属性车险分期：挂起标识/车险分期：挂起标识 */
	private String hangupFlag ;
	/** 属性车险分期：可退保标识/车险分期：可退保标识 */
	private String payBackFlag ;
	/** 属性自主渠道系数/自主渠道系数 */
	private Double channelAdjustValue ;
	/** 属性自主核保系数/自主核保系数 */
	private Double autoNoMyAdjustValue ;
	/** 属性条款版本/条款版本 */
	private String clauseType ;
	/** 属性validTime/validTime */
	private String validTime ;
	/** 属性单位名称/单位名称 */
	private String extraComName ;
	/** 属性寿险职场名称/寿险职场名称 */
	private String factorPlaceCode ;
	/** 属性寿险职场名称1/寿险职场名称1 */
	private String factorPlaceName ;
	/** 属性是否转拨计价/是否转拨计价 */
	private String fycFlag ;
	/** 属性是否政府采购/是否政府采购 */
	private String govPurchaseFlag ;
	/** 属性团队类型/团队类型 */
	private String groupType ;
	/** 属性业务归属人员名称/业务归属人员名称 */
	private String handler1Name ;
	/** 属性代办人地址/代办人地址 */
	private String handler2Address ;
	/** 属性代办人代码/代办人代码 */
	private String handler2Code ;
	/** 属性代办人证件号码/代办人证件号码 */
	private String handler2Id ;
	/** 属性代办人证件/代办人证件 */
	private String handler2IdType ;
	/** 属性代办人电话/代办人电话 */
	private String handler2Mobile ;
	/** 属性代办人姓名/代办人姓名 */
	private String handler2Name ;
	/** 属性代办人邮编/代办人邮编 */
	private String handler2Post ;
	/** 属性经办人身份证号/经办人身份证号 */
	private String handlerIdentifyNumber ;
	/** 属性经办人名字 /经办人名字  */
	private String handlerName ;
	/** 属性介绍人ID/介绍人ID */
	private String introducerId ;
	/** 属性介绍人姓名/介绍人姓名 */
	private String introducerName ;
	/** 属性isUndwrtFlag/isUndwrtFlag */
	private String isUndwrtFlag ;
	/** 属性见费出单标志/见费出单标志 */
	private String jFeeFlag ;
	/** 属性lastInsurerCode/lastInsurerCode */
	private String lastInsurerCode ;
	/** 属性lastInsurerCom/lastInsurerCom */
	private String lastInsurerCom ;
	/** 属性lastPrintNo/lastPrintNo */
	private String lastPrintNo ;
	/** 属性锁定人代码/锁定人代码 */
	private String lockerCode ;
	/** 属性nationFlag/nationFlag */
	private String nationFlag ;
	/** 属性交强险即时生效 结束日期/交强险即时生效 结束日期 */
	private Date newEndDate ;
	/** 属性交强险即时生效 开始日期/交强险即时生效 开始日期 */
	private Date newStartDate ;
	/** 属性notRenewalRegist/notRenewalRegist */
	private String notRenewalRegist ;
	/** 属性出单方式标识/出单方式标识 */
	private String operateWayFlag ;
	/** 属性payrefCode/payrefCode */
	private String payrefCode ;
	/** 属性payrefName/payrefName */
	private String payrefName ;
//	/** 属性payfefTime/payfefTime */
//	private java.util.Date payfefTime ;
	/** 属性preCheckDate/preCheckDate */
	private Date preCheckDate ;
	/** 属性printTime/printTime */
	private Date printTime ;
	/** 属性项目标志/项目标志 */
	private String projectsFlag ;
	/** 属性投保单核保通过级别/投保单核保通过级别 */
	private String proposalLevel ;
	/** 属性费率别终止日期/费率别终止日期 */
	private Date rateEndDate ;
	/** 属性费率别版本值/费率别版本值 */
	private String ratePeriod ;
	/** 属性费率别版本旧值/费率别版本旧值 */
	private String ratePeriodOld ;
	/** 属性费率别类型（新、旧)/费率别类型（新、旧) */
	private String ratePeriodType ;
	/** 属性费率别实施日期/费率别实施日期 */
	private Date rateStartDate ;
	/** 属性未续保登记原因/未续保登记原因 */
	private String rsnNoreNewAl ;
	/** 属性批量代收代付起始缴费期次/批量代收代付起始缴费期次 */
	private Integer startStages ;
	/** 属性停驶次数/停驶次数 */
	private String stopTimes ;
	/** 属性与现有系统编码统一/与现有系统编码统一 */
	private String subBusinessNature ;
	/** 属性关贸查询返回查询序号/关贸查询返回查询序号 */
	private String tradeVanId ;
	/** 属性undwrtMark/undwrtMark */
	private String undwrtMark ;
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
	/** 属性oldAutoNoMyAdjustValue/oldAutoNoMyAdjustValue */
	private Double oldAutoNoMyAdjustValue ;
	/** 属性oldChannelAdjustValue/oldChannelAdjustValue */
	private Double oldChannelAdjustValue ;
	/** 属性oldDiscount/oldDiscount */
	private Double oldDiscount ;
	/** 属性hopeDiscount/hopeDiscount */
	private Double hopeDiscount ;
	/** 属性adjustClaimReasonRate/adjustClaimReasonRate */
	private String adjustClaimReasonRate ;
	/** 属性adjustClaimReasonCode/adjustClaimReasonCode */
	private Integer adjustClaimReasonCode ;
	/** 属性总折扣金额变化量/总折扣金额变化量 */
	private Double chgSumDiscount ;
	/** 属性修改人/修改人 */
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	private Date update_Date ;
	/** 属性总不含税保费/总不含税保费 */
	private Double sumNoTaxPremium ;
	/** 属性总不含税保费变化量/总不含税保费变化量 */
	private Double chgNoTaxPremium ;
	/** 属性总税额/总税额 */
	private Double sumTaxFee ;
	/** 属性税额变化量/税额变化量 */
	private Double chgTaxFee ;
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
	/** 属性wxChannelCode/wxChannelCode */
	private String wxChannelCode ;
	/** 属性isOnline/isOnline */
	private String isOnline ;
	/** 属性isCustomer/isCustomer */
	private String isCustomer ;
	/** 属性是否验标/是否验标 */
	private String inceptionFlag ;
	/** 属性是否承保公示/是否承保公示 */
	private String notificationFlag ;
	/** 属性营销员类型/行业类别代码/营销员类型/行业类别代码 */
	private String agentBusinessType ;
	/** 属性营销员类型/行业类别名称/营销员类型/行业类别名称 */
	private String agentBusinessTypeName ;
	/** 属性交强险预期赔付率/交强险预期赔付率 */
	private Integer ctpElr ;
	/** 属性商业险预期赔付率/商业险预期赔付率 */
	private Integer comElr ;
	/** 属性整单预期赔付率/整单预期赔付率 */
	private Integer elr ;
	/**
	 * 自缴保费变化量
	 */
	private Double chgFPremium;
	/**
	 * 中央财政补贴变化量
	 */
	private Double chgCentralPremium;
	/**
	 * 省级财政补贴变化量
	 */
	private Double chgProvincePremium;
	/**
	 * 地市财政补贴变化量
	 */
	private Double chgCityPremium;
	/**
	 * 区（县）财政变化量
	 */
	private Double chgTownPremium;
	/**
	 * 其他来源补贴变化量
	 */
	private Double chgOtherPremium;

	private String businessProvinceName;
	private String businessTownName;
	private String businessCountyName;
	private String businessCityName;
	private String comName;
	private String tHandlerName;
	private String tHandler1Name;
	private String updaterName;
	private String operatorName;
	private String riskCodeName;
	private String classCodeName;

	public String getClassCodeName() {
		return classCodeName;
	}

	public void setClassCodeName(String classCodeName) {
		this.classCodeName = classCodeName;
	}

	public String getBusinessProvinceName() {
		return businessProvinceName;
	}

	public void setBusinessProvinceName(String businessProvinceName) {
		this.businessProvinceName = businessProvinceName;
	}

	public String getBusinessTownName() {
		return businessTownName;
	}

	public void setBusinessTownName(String businessTownName) {
		this.businessTownName = businessTownName;
	}

	public String getBusinessCountyName() {
		return businessCountyName;
	}

	public void setBusinessCountyName(String businessCountyName) {
		this.businessCountyName = businessCountyName;
	}

	public String getBusinessCityName() {
		return businessCityName;
	}

	public void setBusinessCityName(String businessCityName) {
		this.businessCityName = businessCityName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String gettHandlerName() {
		return tHandlerName;
	}

	public void settHandlerName(String tHandlerName) {
		this.tHandlerName = tHandlerName;
	}

	public String gettHandler1Name() {
		return tHandler1Name;
	}

	public void settHandler1Name(String tHandler1Name) {
		this.tHandler1Name = tHandler1Name;
	}

	public String getUpdaterName() {
		return updaterName;
	}

	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getRiskCodeName() {
		return riskCodeName;
	}

	public void setRiskCodeName(String riskCodeName) {
		this.riskCodeName = riskCodeName;
	}

	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
	 * 属性 合同号(供合保单使用)/ 合同号(供合保单使用)的getter方法
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 属性 合同号(供合保单使用)/ 合同号(供合保单使用)的setter方法
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
	 * 属性保单印刷号/保单印刷号的getter方法
	 */
	public String getPrintNo() {
		return printNo;
	}
	/**
	 * 属性保单印刷号/保单印刷号的setter方法
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
	 * 属性语种标志（C/E/…）/语种标志（C/E/…）的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性语种标志（C/E/…）/语种标志（C/E/…）的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * 属性 保单类型（个人/集体）/ 保单类型（个人/集体）的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性 保单类型（个人/集体）/ 保单类型（个人/集体）的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	/**
	 * 属性 投保人代码 / 投保人代码 的getter方法
	 */
	public String getAppliCode() {
		return appliCode;
	}
	/**
	 * 属性 投保人代码 / 投保人代码 的setter方法
	 */
	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
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
	 * 属性 投保人地址/ 投保人地址的getter方法
	 */
	public String getAppliAddress() {
		return appliAddress;
	}
	/**
	 * 属性 投保人地址/ 投保人地址的setter方法
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
	 * 属性 被保险人地址/ 被保险人地址的getter方法
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}
	/**
	 * 属性 被保险人地址/ 被保险人地址的setter方法
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}
	/**
	 * 属性 签单日期（制单日期）/ 签单日期（制单日期）的getter方法
	 */
	public Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性 签单日期（制单日期）/ 签单日期（制单日期）的setter方法
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	/**
	 * 属性起保日期/起保日期的getter方法
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期/起保日期的setter方法
	 */
	public void setStartDate(Date startDate) {
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
	 * 属性终保日期/终保日期的getter方法
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日期/终保日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 属性终保小时/终保小时的getter方法
	 */
	public Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终保小时/终保小时的setter方法
	 */
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	/**
	 * 属性 净费率/ 净费率的getter方法
	 */
	public Double getPureRate() {
		return pureRate;
	}
	/**
	 * 属性 净费率/ 净费率的setter方法
	 */
	public void setPureRate(Double pureRate) {
		this.pureRate = pureRate;
	}
	/**
	 * 属性手续费比例/手续费比例的getter方法
	 */
	public Double getDisRate() {
		return disRate;
	}
	/**
	 * 属性手续费比例/手续费比例的setter方法
	 */
	public void setDisRate(Double disRate) {
		this.disRate = disRate;
	}
	/**
	 * 属性总折扣率/总折扣率的getter方法
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * 属性总折扣率/总折扣率的setter方法
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * 属性 币别代码/ 币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性 币别代码/ 币别代码的setter方法
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
	 * 属性总保额(折算为人民币总保额)/总保额(折算为人民币总保额)的getter方法
	 */
	public Double getSumAmount() {
		return sumAmount;
	}
	/**
	 * 属性总保额(折算为人民币总保额)/总保额(折算为人民币总保额)的setter方法
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
	 * 属性总保险费(折算为人民币总保费)/总保险费(折算为人民币总保费)的getter方法
	 */
	public Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总保险费(折算为人民币总保费)/总保险费(折算为人民币总保费)的setter方法
	 */
	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	}
	/**
	 * 属性总附加险保费/总附加险保费的getter方法
	 */
	public Double getSumSubPrem() {
		return sumSubPrem;
	}
	/**
	 * 属性总附加险保费/总附加险保费的setter方法
	 */
	public void setSumSubPrem(Double sumSubPrem) {
		this.sumSubPrem = sumSubPrem;
	}
	/**
	 * 属性 被保险总数量/人数/户数--** 压力容器总数/ 被保险总数量/人数/户数--** 压力容器总数的getter方法
	 */
	public Integer getSumQuantity() {
		return sumQuantity;
	}
	/**
	 * 属性 被保险总数量/人数/户数--** 压力容器总数/ 被保险总数量/人数/户数--** 压力容器总数的setter方法
	 */
	public void setSumQuantity(Integer sumQuantity) {
		this.sumQuantity = sumQuantity;
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

	public String getAutoTransRenewFlag() {
		return autoTransRenewFlag;
	}

	public void setAutoTransRenewFlag(String autoTransRenewFlag) {
		this.autoTransRenewFlag = autoTransRenewFlag;
	}

	/**
	 * 属性争议解决方式▲--** 1 诉讼；2 仲裁/争议解决方式▲--** 1 诉讼；2 仲裁的getter方法
	 */
	public String getArgueSolution() {
		return argueSolution;
	}
	/**
	 * 属性争议解决方式▲--** 1 诉讼；2 仲裁/争议解决方式▲--** 1 诉讼；2 仲裁的setter方法
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
	public Integer getEndorseTimes() {
		return endorseTimes;
	}
	/**
	 * 属性批改次数/批改次数的setter方法
	 */
	public void setEndorseTimes(Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	}
	/**
	 * 属性理赔次数/理赔次数的getter方法
	 */
	public Integer getClaimTimes() {
		return claimTimes;
	}
	/**
	 * 属性理赔次数/理赔次数的setter方法
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
	 * 属性归属业务员代码 /归属业务员代码 的getter方法
	 */
	public String getHandler1Code() {
		return handler1Code;
	}
	/**
	 * 属性归属业务员代码 /归属业务员代码 的setter方法
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
	public Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputDate(Date inputDate) {
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
	 * 属性 保单统计年月/ 保单统计年月的getter方法
	 */
	public Date getStatisticSym() {
		return statisticSym;
	}
	/**
	 * 属性 保单统计年月/ 保单统计年月的setter方法
	 */
	public void setStatisticSym(Date statisticSym) {
		this.statisticSym = statisticSym;
	}
	/**
	 * 属性代理人代码/代理人代码的getter方法
	 */
	public String getAgentCode() {
		return agentCode;
	}
	/**
	 * 属性代理人代码/代理人代码的setter方法
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	/**
	 * 属性共保标志--** (0非共保/1主共保/2共保)/共保标志--** (0非共保/1主共保/2共保)的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性共保标志--** (0非共保/1主共保/2共保)/共保标志--** (0非共保/1主共保/2共保)的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
	/**
	 * 属性 商业分保标志--** (0无需分保/1需分保/2已分保)/ 商业分保标志--** (0无需分保/1需分保/2已分保)的getter方法
	 */
	public String getReinsFlag() {
		return reinsFlag;
	}
	/**
	 * 属性 商业分保标志--** (0无需分保/1需分保/2已分保)/ 商业分保标志--** (0无需分保/1需分保/2已分保)的setter方法
	 */
	public void setReinsFlag(String reinsFlag) {
		this.reinsFlag = reinsFlag;
	}
	/**
	 * 属性--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它/--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它的getter方法
	 */
	public String getAllinsFlag() {
		return allinsFlag;
	}
	/**
	 * 属性--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它/--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它的setter方法
	 */
	public void setAllinsFlag(String allinsFlag) {
		this.allinsFlag = allinsFlag;
	}

	public String getUnderwriteCode() {
		return underwriteCode;
	}

	public void setUnderwriteCode(String underwriteCode) {
		this.underwriteCode = underwriteCode;
	}

	public String getUnderwriteName() {
		return underwriteName;
	}

	public void setUnderwriteName(String underwriteName) {
		this.underwriteName = underwriteName;
	}

	public Date getUnderwriteEndDate() {
		return underwriteEndDate;
	}

	public void setUnderwriteEndDate(Date underwriteEndDate) {
		this.underwriteEndDate = underwriteEndDate;
	}

	public String getUnderwriteFlag() {
		return underwriteFlag;
	}

	public void setUnderwriteFlag(String underwriteFlag) {
		this.underwriteFlag = underwriteFlag;
	}

	public String getnCarPerpFlag() {
		return nCarPerpFlag;
	}

	public void setnCarPerpFlag(String nCarPerpFlag) {
		this.nCarPerpFlag = nCarPerpFlag;
	}

	public String getjFeeFlag() {
		return jFeeFlag;
	}

	public void setjFeeFlag(String jFeeFlag) {
		this.jFeeFlag = jFeeFlag;
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
	 * 属性--** 状态字段/--** 状态字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性--** 状态字段/--** 状态字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性--** 变化保险金额(折算为人民币保额)/--** 变化保险金额(折算为人民币保额)的getter方法
	 */
	public Double getChgAmount() {
		return chgAmount;
	}
	/**
	 * 属性--** 变化保险金额(折算为人民币保额)/--** 变化保险金额(折算为人民币保额)的setter方法
	 */
	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}
	/**
	 * 属性--** 变化保险费(折算为人民币保费)/--** 变化保险费(折算为人民币保费)的getter方法
	 */
	public Double getChgPremium() {
		return chgPremium;
	}
	/**
	 * 属性--** 变化保险费(折算为人民币保费)/--** 变化保险费(折算为人民币保费)的setter方法
	 */
	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
	}
	/**
	 * 属性--** 变化附加险保费（折算为人民币）/--** 变化附加险保费（折算为人民币）的getter方法
	 */
	public Double getChgSubPrem() {
		return chgSubPrem;
	}
	/**
	 * 属性--** 变化附加险保费（折算为人民币）/--** 变化附加险保费（折算为人民币）的setter方法
	 */
	public void setChgSubPrem(Double chgSubPrem) {
		this.chgSubPrem = chgSubPrem;
	}
	/**
	 * 属性--** 变化数量/--** 变化数量的getter方法
	 */
	public Integer getChgQuantity() {
		return chgQuantity;
	}
	/**
	 * 属性--** 变化数量/--** 变化数量的setter方法
	 */
	public void setChgQuantity(Integer chgQuantity) {
		this.chgQuantity = chgQuantity;
	}
	/**
	 * 属性--** 超出部分手续费比例/--** 超出部分手续费比例的getter方法
	 */
	public Double getDisRate1() {
		return disRate1;
	}
	/**
	 * 属性--** 超出部分手续费比例/--** 超出部分手续费比例的setter方法
	 */
	public void setDisRate1(Double disRate1) {
		this.disRate1 = disRate1;
	}
	/**
	 * 属性--** 业务类型--** 0：自营业务，1：分入业务/--** 业务类型--** 0：自营业务，1：分入业务的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性--** 业务类型--** 0：自营业务，1：分入业务/--** 业务类型--** 0：自营业务，1：分入业务的setter方法
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
	public Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
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
	 * 属性signDate/signDate的getter方法
	 */
	public Date getSignDate() {
		return signDate;
	}
	/**
	 * 属性signDate/signDate的setter方法
	 */
	public void setSignDate(Date signDate) {
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
	 * 属性visaCode/visaCode的getter方法
	 */
	public String getVisaCode() {
		return visaCode;
	}
	/**
	 * 属性visaCode/visaCode的setter方法
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
	 * 属性统计口径的承保数量变化量/统计口径的承保数量变化量的getter方法
	 */
	public Double getChgStatQuantity() {
		return chgStatQuantity;
	}
	/**
	 * 属性统计口径的承保数量变化量/统计口径的承保数量变化量的setter方法
	 */
	public void setChgStatQuantity(Double chgStatQuantity) {
		this.chgStatQuantity = chgStatQuantity;
	}
	/**
	 * 属性参保农户户次变化量/参保农户户次变化量的getter方法
	 */
	public Double getChgInsured() {
		return chgInsured;
	}
	/**
	 * 属性参保农户户次变化量/参保农户户次变化量的setter方法
	 */
	public void setChgInsured(Double chgInsured) {
		this.chgInsured = chgInsured;
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
	 * 属性批单打印日期/批单打印日期的getter方法
	 */
	public Date getPrintDate() {
		return printDate;
	}
	/**
	 * 属性批单打印日期/批单打印日期的setter方法
	 */
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	/**
	 * 属性批单收费日期/批单收费日期的getter方法
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 属性批单收费日期/批单收费日期的setter方法
	 */
	public void setPayDate(Date payDate) {
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
	 * 属性每次事故责任限额变化量/每次事故责任限额变化量的getter方法
	 */
	public Double getChgLimitAmount() {
		return chgLimitAmount;
	}
	/**
	 * 属性每次事故责任限额变化量/每次事故责任限额变化量的setter方法
	 */
	public void setChgLimitAmount(Double chgLimitAmount) {
		this.chgLimitAmount = chgLimitAmount;
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
	 * 属性nCarPerpFlag/nCarPerpFlag的getter方法
	 */
	public String getNCarPerpFlag() {
		return nCarPerpFlag;
	}
	/**
	 * 属性nCarPerpFlag/nCarPerpFlag的setter方法
	 */
	public void setNCarPerpFlag(String nCarPerpFlag) {
		this.nCarPerpFlag = nCarPerpFlag;
	}
	/**
	 * 属性大户归属区域 /大户归属区域 的getter方法
	 */
	public String getRichFlyAreasCode() {
		return richFlyAreasCode;
	}
	/**
	 * 属性大户归属区域 /大户归属区域 的setter方法
	 */
	public void setRichFlyAreasCode(String richFlyAreasCode) {
		this.richFlyAreasCode = richFlyAreasCode;
	}
	/**
	 * 属性大户归属区域名称 /大户归属区域名称 的getter方法
	 */
	public String getRichFlyAreasCName() {
		return richFlyAreasCName;
	}
	/**
	 * 属性大户归属区域名称 /大户归属区域名称 的setter方法
	 */
	public void setRichFlyAreasCName(String richFlyAreasCName) {
		this.richFlyAreasCName = richFlyAreasCName;
	}
	/**
	 * 属性大户编码 /大户编码 的getter方法
	 */
	public String getRichFlyCode() {
		return richFlyCode;
	}
	/**
	 * 属性大户编码 /大户编码 的setter方法
	 */
	public void setRichFlyCode(String richFlyCode) {
		this.richFlyCode = richFlyCode;
	}
	/**
	 * 属性大户名称 /大户名称 的getter方法
	 */
	public String getRichFlyCName() {
		return richFlyCName;
	}
	/**
	 * 属性大户名称 /大户名称 的setter方法
	 */
	public void setRichFlyCName(String richFlyCName) {
		this.richFlyCName = richFlyCName;
	}
	/**
	 * 属性GroupNo/GroupNo的getter方法
	 */
	public String getGroupNo() {
		return groupNo;
	}
	/**
	 * 属性GroupNo/GroupNo的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	/**
	 * 属性GroupFlag/GroupFlag的getter方法
	 */
	public String getGroupFlag() {
		return groupFlag;
	}
	/**
	 * 属性GroupFlag/GroupFlag的setter方法
	 */
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}
	/**
	 * 属性BasePerformanceRate/BasePerformanceRate的getter方法
	 */
	public Double getBasePerformanceRate() {
		return basePerformanceRate;
	}
	/**
	 * 属性BasePerformanceRate/BasePerformanceRate的setter方法
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
	 * 属性chgBasePerformanceRate/chgBasePerformanceRate的getter方法
	 */
	public Double getChgBasePerformanceRate() {
		return chgBasePerformanceRate;
	}
	/**
	 * 属性chgBasePerformanceRate/chgBasePerformanceRate的setter方法
	 */
	public void setChgBasePerformanceRate(Double chgBasePerformanceRate) {
		this.chgBasePerformanceRate = chgBasePerformanceRate;
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
	 * 属性大病医疗专项业务类型/大病医疗专项业务类型的getter方法
	 */
	public String getBigMedicalType() {
		return bigMedicalType;
	}
	/**
	 * 属性大病医疗专项业务类型/大病医疗专项业务类型的setter方法
	 */
	public void setBigMedicalType(String bigMedicalType) {
		this.bigMedicalType = bigMedicalType;
	}
	/**
	 * 属性盈利率,大病医疗/盈利率,大病医疗的getter方法
	 */
	public String getEarningsRate() {
		return earningsRate;
	}
	/**
	 * 属性盈利率,大病医疗/盈利率,大病医疗的setter方法
	 */
	public void setEarningsRate(String earningsRate) {
		this.earningsRate = earningsRate;
	}
	/**
	 * 属性大病医疗保险投保方式：1，记名承保 2，不记名承保/大病医疗保险投保方式：1，记名承保 2，不记名承保的getter方法
	 */
	public String getInsuredListType() {
		return insuredListType;
	}
	/**
	 * 属性大病医疗保险投保方式：1，记名承保 2，不记名承保/大病医疗保险投保方式：1，记名承保 2，不记名承保的setter方法
	 */
	public void setInsuredListType(String insuredListType) {
		this.insuredListType = insuredListType;
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
	 * 属性businessCity/businessCity的getter方法
	 */
	public String getBusinessCity() {
		return businessCity;
	}
	/**
	 * 属性businessCity/businessCity的setter方法
	 */
	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}
	/**
	 * 属性allianCreate/allianCreate的getter方法
	 */
	public Double getAllianceRate() {
		return allianceRate;
	}
	/**
	 * 属性allianCreate/allianCreate的setter方法
	 */
	public void setAllianceRate(Double allianceRate) {
		this.allianceRate = allianceRate;
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
	 * 属性未续保登记原因代码/未续保登记原因代码的getter方法
	 */
	public Double getLocalModelDiscountQ() {
		return localModelDiscountQ;
	}
	/**
	 * 属性未续保登记原因代码/未续保登记原因代码的setter方法
	 */
	public void setLocalModelDiscountQ(Double localModelDiscountQ) {
		this.localModelDiscountQ = localModelDiscountQ;
	}
	/**
	 * 属性自主核保模型系数/自主核保模型系数的getter方法
	 */
	public Double getLocalModelDiscountZ() {
		return localModelDiscountZ;
	}
	/**
	 * 属性自主核保模型系数/自主核保模型系数的setter方法
	 */
	public void setLocalModelDiscountZ(Double localModelDiscountZ) {
		this.localModelDiscountZ = localModelDiscountZ;
	}
	/**
	 * 属性内部模型定价/内部模型定价的getter方法
	 */
	public Double getLocalModelPremium() {
		return localModelPremium;
	}
	/**
	 * 属性内部模型定价/内部模型定价的setter方法
	 */
	public void setLocalModelPremium(Double localModelPremium) {
		this.localModelPremium = localModelPremium;
	}
	/**
	 * 属性销售人员/销售人员的getter方法
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * 属性销售人员/销售人员的setter方法
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getSalePhone() {
		return salePhone;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}
	/**
	 * 属性销售公司代码/销售公司代码的getter方法
	 */
	public String getSaleComCode() {
		return saleComCode;
	}
	/**
	 * 属性销售公司代码/销售公司代码的setter方法
	 */
	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}
	/**
	 * 属性销售公司名称/销售公司名称的getter方法
	 */
	public String getSaleComName() {
		return saleComName;
	}
	/**
	 * 属性销售公司名称/销售公司名称的setter方法
	 */
	public void setSaleComName(String saleComName) {
		this.saleComName = saleComName;
	}
	/**
	 * 属性销售公司地址/销售公司地址的getter方法
	 */
	public String getSaleComAddress() {
		return saleComAddress;
	}
	/**
	 * 属性销售公司地址/销售公司地址的setter方法
	 */
	public void setSaleComAddress(String saleComAddress) {
		this.saleComAddress = saleComAddress;
	}
	/**
	 * 属性中介机构地址/中介机构地址的getter方法
	 */
	public String getSaleAgentAddress() {
		return saleAgentAddress;
	}
	/**
	 * 属性中介机构地址/中介机构地址的setter方法
	 */
	public void setSaleAgentAddress(String saleAgentAddress) {
		this.saleAgentAddress = saleAgentAddress;
	}
	/**
	 * 属性中介机构销售人员姓名/中介机构销售人员姓名的getter方法
	 */
	public String getSaleAgentPersonName() {
		return saleAgentPersonName;
	}
	/**
	 * 属性中介机构销售人员姓名/中介机构销售人员姓名的setter方法
	 */
	public void setSaleAgentPersonName(String saleAgentPersonName) {
		this.saleAgentPersonName = saleAgentPersonName;
	}
	/**
	 * 属性中介机构销售人员执业证号/中介机构销售人员执业证号的getter方法
	 */
	public String getSaleAgentPersonId() {
		return saleAgentPersonId;
	}
	/**
	 * 属性中介机构销售人员执业证号/中介机构销售人员执业证号的setter方法
	 */
	public void setSaleAgentPersonId(String saleAgentPersonId) {
		this.saleAgentPersonId = saleAgentPersonId;
	}
//	/**
//	 * 属性归属代理人展业证号/归属代理人展业证号的getter方法
//	 */
//	public String getSaleAgentPersonNo() {
//		return saleAgentPersonNo;
//	}
//	/**
//	 * 属性归属代理人展业证号/归属代理人展业证号的setter方法
//	 */
//	public void setSaleAgentPersonNo(String saleAgentPersonNo) {
//		this.saleAgentPersonNo = saleAgentPersonNo;
//	}
	/**
	 * 属性代收人ID/代收人ID的getter方法
	 */
	public String getAgent1Code() {
		return agent1Code;
	}
	/**
	 * 属性代收人ID/代收人ID的setter方法
	 */
	public void setAgent1Code(String agent1Code) {
		this.agent1Code = agent1Code;
	}
	/**
	 * 属性代收人姓名/代收人姓名的getter方法
	 */
	public String getAgent1Name() {
		return agent1Name;
	}
	/**
	 * 属性代收人姓名/代收人姓名的setter方法
	 */
	public void setAgent1Name(String agent1Name) {
		this.agent1Name = agent1Name;
	}
	/**
	 * 属性agentMaxComission/agentMaxComission的getter方法
	 */
	public Double getAgentMaxComission() {
		return agentMaxComission;
	}
	/**
	 * 属性agentMaxComission/agentMaxComission的setter方法
	 */
	public void setAgentMaxComission(Double agentMaxComission) {
		this.agentMaxComission = agentMaxComission;
	}
	/**
	 * 属性代理人名称/代理人名称的getter方法
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * 属性代理人名称/代理人名称的setter方法
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * 属性代理联动类型/代理联动类型的getter方法
	 */
	public String getAgentTypeNo() {
		return agentTypeNo;
	}
	/**
	 * 属性代理联动类型/代理联动类型的setter方法
	 */
	public void setAgentTypeNo(String agentTypeNo) {
		this.agentTypeNo = agentTypeNo;
	}
	/**
	 * 属性涉农标志/涉农标志的getter方法
	 */
	public String getAgriType() {
		return agriType;
	}
	/**
	 * 属性涉农标志/涉农标志的setter方法
	 */
	public void setAgriType(String agriType) {
		this.agriType = agriType;
	}
	/**
	 * 属性手续费拆分方案号/手续费拆分方案号的getter方法
	 */
	public String getAssignNo() {
		return assignNo;
	}
	/**
	 * 属性手续费拆分方案号/手续费拆分方案号的setter方法
	 */
	public void setAssignNo(String assignNo) {
		this.assignNo = assignNo;
	}
	/**
	 * 属性开户代码/开户代码的getter方法
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * 属性开户代码/开户代码的setter方法
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	/**
	 * 属性bankFlag/bankFlag的getter方法
	 */
	public String getBankFlag() {
		return bankFlag;
	}
	/**
	 * 属性bankFlag/bankFlag的setter方法
	 */
	public void setBankFlag(String bankFlag) {
		this.bankFlag = bankFlag;
	}
	/**
	 * 属性bizNoSysFlag/bizNoSysFlag的getter方法
	 */
	public String getBizNoSysFlag() {
		return bizNoSysFlag;
	}
	/**
	 * 属性bizNoSysFlag/bizNoSysFlag的setter方法
	 */
	public void setBizNoSysFlag(String bizNoSysFlag) {
		this.bizNoSysFlag = bizNoSysFlag;
	}
	/**
	 * 属性备用8/备用8的getter方法
	 */
	public String getBusinessRecMark() {
		return businessRecMark;
	}
	/**
	 * 属性备用8/备用8的setter方法
	 */
	public void setBusinessRecMark(String businessRecMark) {
		this.businessRecMark = businessRecMark;
	}
	/**
	 * 属性businessTypeFlag/businessTypeFlag的getter方法
	 */
	public String getBusinessTypeFlag() {
		return businessTypeFlag;
	}
	/**
	 * 属性businessTypeFlag/businessTypeFlag的setter方法
	 */
	public void setBusinessTypeFlag(String businessTypeFlag) {
		this.businessTypeFlag = businessTypeFlag;
	}
	/**
	 * 属性caseNo/caseNo的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性caseNo/caseNo的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	/**
	 * 属性channelCode/channelCode的getter方法
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 属性channelCode/channelCode的setter方法
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 属性渠道类型/渠道类型的getter方法
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * 属性渠道类型/渠道类型的setter方法
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * 属性备用7/备用7的getter方法
	 */
	public String getContributionLevel() {
		return contributionLevel;
	}
	/**
	 * 属性备用7/备用7的setter方法
	 */
	public void setContributionLevel(String contributionLevel) {
		this.contributionLevel = contributionLevel;
	}
	/**
	 * 属性备用6/备用6的getter方法
	 */
	public String getDeclareFlag() {
		return declareFlag;
	}
	/**
	 * 属性备用6/备用6的setter方法
	 */
	public void setDeclareFlag(String declareFlag) {
		this.declareFlag = declareFlag;
	}
	/**
	 * 属性编辑标志/编辑标志的getter方法
	 */
	public String getEditFlag() {
		return editFlag;
	}
	/**
	 * 属性编辑标志/编辑标志的setter方法
	 */
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	/**
	 * 属性备用4/备用4的getter方法
	 */
	public String getEffectiveImmediatelyFlag() {
		return effectiveImmediatelyFlag;
	}
	/**
	 * 属性备用4/备用4的setter方法
	 */
	public void setEffectiveImmediatelyFlag(String effectiveImmediatelyFlag) {
		this.effectiveImmediatelyFlag = effectiveImmediatelyFlag;
	}
	/**
	 * 属性兑换率/兑换率的getter方法
	 */
	public Double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * 属性兑换率/兑换率的setter方法
	 */
	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	/**
	 * 属性单位/单位的getter方法
	 */
	public String getExtraComCode() {
		return extraComCode;
	}
	/**
	 * 属性单位/单位的setter方法
	 */
	public void setExtraComCode(String extraComCode) {
		this.extraComCode = extraComCode;
	}
	/**
	 * 属性老系统即时生效标志/老系统即时生效标志的getter方法
	 */
	public String getEffectFlag() {
		return effectFlag;
	}
	/**
	 * 属性老系统即时生效标志/老系统即时生效标志的setter方法
	 */
	public void setEffectFlag(String effectFlag) {
		this.effectFlag = effectFlag;
	}
	/**
	 * 属性业务渠道/业务渠道的getter方法
	 */
	public String getAgentClass() {
		return agentClass;
	}
	/**
	 * 属性业务渠道/业务渠道的setter方法
	 */
	public void setAgentClass(String agentClass) {
		this.agentClass = agentClass;
	}
	/**
	 * 属性手续费比例上限/手续费比例上限的getter方法
	 */
	public String getTopCommisionRate() {
		return topCommisionRate;
	}
	/**
	 * 属性手续费比例上限/手续费比例上限的setter方法
	 */
	public void setTopCommisionRate(String topCommisionRate) {
		this.topCommisionRate = topCommisionRate;
	}
	/**
	 * 属性手续费比例1/手续费比例1的getter方法
	 */
	public String getIntCommisionRate() {
		return intCommisionRate;
	}
	/**
	 * 属性手续费比例1/手续费比例1的setter方法
	 */
	public void setIntCommisionRate(String intCommisionRate) {
		this.intCommisionRate = intCommisionRate;
	}
	/**
	 * 属性新车险系统出单标志/新车险系统出单标志的getter方法
	 */
	public String getSystemFlag() {
		return systemFlag;
	}
	/**
	 * 属性新车险系统出单标志/新车险系统出单标志的setter方法
	 */
	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}
	/**
	 * 属性预开发票标志/预开发票标志的getter方法
	 */
	public String getPreinvoiceFlag() {
		return preinvoiceFlag;
	}
	/**
	 * 属性预开发票标志/预开发票标志的setter方法
	 */
	public void setPreinvoiceFlag(String preinvoiceFlag) {
		this.preinvoiceFlag = preinvoiceFlag;
	}
	/**
	 * 属性提交核保标志  空代表选择提交，1代表普通，2代表特殊/提交核保标志  空代表选择提交，1代表普通，2代表特殊的getter方法
	 */
	public String getSubmitUndwrtFlag() {
		return submitUndwrtFlag;
	}
	/**
	 * 属性提交核保标志  空代表选择提交，1代表普通，2代表特殊/提交核保标志  空代表选择提交，1代表普通，2代表特殊的setter方法
	 */
	public void setSubmitUndwrtFlag(String submitUndwrtFlag) {
		this.submitUndwrtFlag = submitUndwrtFlag;
	}
	/**
	 * 属性前台出单修改标志/前台出单修改标志的getter方法
	 */
	public String getTypeFgEditFlag() {
		return typeFgEditFlag;
	}
	/**
	 * 属性前台出单修改标志/前台出单修改标志的setter方法
	 */
	public void setTypeFgEditFlag(String typeFgEditFlag) {
		this.typeFgEditFlag = typeFgEditFlag;
	}
	/**
	 * 属性单子类型/单子类型的getter方法
	 */
	public String getInputType() {
		return inputType;
	}
	/**
	 * 属性单子类型/单子类型的setter方法
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	/**
	 * 属性特殊业务申请号/特殊业务申请号的getter方法
	 */
	public String getSpecialBusinessNo() {
		return specialBusinessNo;
	}
	/**
	 * 属性特殊业务申请号/特殊业务申请号的setter方法
	 */
	public void setSpecialBusinessNo(String specialBusinessNo) {
		this.specialBusinessNo = specialBusinessNo;
	}
	/**
	 * 属性分期村志/分期村志的getter方法
	 */
	public String getPeriodFlag() {
		return periodFlag;
	}
	/**
	 * 属性分期村志/分期村志的setter方法
	 */
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}
	/**
	 * 属性车险分期：挂起标识/车险分期：挂起标识的getter方法
	 */
	public String getHangupFlag() {
		return hangupFlag;
	}
	/**
	 * 属性车险分期：挂起标识/车险分期：挂起标识的setter方法
	 */
	public void setHangupFlag(String hangupFlag) {
		this.hangupFlag = hangupFlag;
	}
	/**
	 * 属性车险分期：可退保标识/车险分期：可退保标识的getter方法
	 */
	public String getPayBackFlag() {
		return payBackFlag;
	}
	/**
	 * 属性车险分期：可退保标识/车险分期：可退保标识的setter方法
	 */
	public void setPayBackFlag(String payBackFlag) {
		this.payBackFlag = payBackFlag;
	}
	/**
	 * 属性自主渠道系数/自主渠道系数的getter方法
	 */
	public Double getChannelAdjustValue() {
		return channelAdjustValue;
	}
	/**
	 * 属性自主渠道系数/自主渠道系数的setter方法
	 */
	public void setChannelAdjustValue(Double channelAdjustValue) {
		this.channelAdjustValue = channelAdjustValue;
	}
	/**
	 * 属性自主核保系数/自主核保系数的getter方法
	 */
	public Double getAutoNoMyAdjustValue() {
		return autoNoMyAdjustValue;
	}
	/**
	 * 属性自主核保系数/自主核保系数的setter方法
	 */
	public void setAutoNoMyAdjustValue(Double autoNoMyAdjustValue) {
		this.autoNoMyAdjustValue = autoNoMyAdjustValue;
	}
	/**
	 * 属性条款版本/条款版本的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性条款版本/条款版本的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
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
	 * 属性单位名称/单位名称的getter方法
	 */
	public String getExtraComName() {
		return extraComName;
	}
	/**
	 * 属性单位名称/单位名称的setter方法
	 */
	public void setExtraComName(String extraComName) {
		this.extraComName = extraComName;
	}
	/**
	 * 属性寿险职场名称/寿险职场名称的getter方法
	 */
	public String getFactorPlaceCode() {
		return factorPlaceCode;
	}
	/**
	 * 属性寿险职场名称/寿险职场名称的setter方法
	 */
	public void setFactorPlaceCode(String factorPlaceCode) {
		this.factorPlaceCode = factorPlaceCode;
	}
	/**
	 * 属性寿险职场名称1/寿险职场名称1的getter方法
	 */
	public String getFactorPlaceName() {
		return factorPlaceName;
	}
	/**
	 * 属性寿险职场名称1/寿险职场名称1的setter方法
	 */
	public void setFactorPlaceName(String factorPlaceName) {
		this.factorPlaceName = factorPlaceName;
	}
	/**
	 * 属性是否转拨计价/是否转拨计价的getter方法
	 */
	public String getFycFlag() {
		return fycFlag;
	}
	/**
	 * 属性是否转拨计价/是否转拨计价的setter方法
	 */
	public void setFycFlag(String fycFlag) {
		this.fycFlag = fycFlag;
	}
	/**
	 * 属性是否政府采购/是否政府采购的getter方法
	 */
	public String getGovPurchaseFlag() {
		return govPurchaseFlag;
	}
	/**
	 * 属性是否政府采购/是否政府采购的setter方法
	 */
	public void setGovPurchaseFlag(String govPurchaseFlag) {
		this.govPurchaseFlag = govPurchaseFlag;
	}
	/**
	 * 属性团队类型/团队类型的getter方法
	 */
	public String getGroupType() {
		return groupType;
	}
	/**
	 * 属性团队类型/团队类型的setter方法
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	/**
	 * 属性业务归属人员名称/业务归属人员名称的getter方法
	 */
	public String getHandler1Name() {
		return handler1Name;
	}
	/**
	 * 属性业务归属人员名称/业务归属人员名称的setter方法
	 */
	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}
	/**
	 * 属性代办人地址/代办人地址的getter方法
	 */
	public String getHandler2Address() {
		return handler2Address;
	}
	/**
	 * 属性代办人地址/代办人地址的setter方法
	 */
	public void setHandler2Address(String handler2Address) {
		this.handler2Address = handler2Address;
	}
	/**
	 * 属性代办人代码/代办人代码的getter方法
	 */
	public String getHandler2Code() {
		return handler2Code;
	}
	/**
	 * 属性代办人代码/代办人代码的setter方法
	 */
	public void setHandler2Code(String handler2Code) {
		this.handler2Code = handler2Code;
	}
	/**
	 * 属性代办人证件号码/代办人证件号码的getter方法
	 */
	public String getHandler2Id() {
		return handler2Id;
	}
	/**
	 * 属性代办人证件号码/代办人证件号码的setter方法
	 */
	public void setHandler2Id(String handler2Id) {
		this.handler2Id = handler2Id;
	}
	/**
	 * 属性代办人证件/代办人证件的getter方法
	 */
	public String getHandler2IdType() {
		return handler2IdType;
	}
	/**
	 * 属性代办人证件/代办人证件的setter方法
	 */
	public void setHandler2IdType(String handler2IdType) {
		this.handler2IdType = handler2IdType;
	}
	/**
	 * 属性代办人电话/代办人电话的getter方法
	 */
	public String getHandler2Mobile() {
		return handler2Mobile;
	}
	/**
	 * 属性代办人电话/代办人电话的setter方法
	 */
	public void setHandler2Mobile(String handler2Mobile) {
		this.handler2Mobile = handler2Mobile;
	}
	/**
	 * 属性代办人姓名/代办人姓名的getter方法
	 */
	public String getHandler2Name() {
		return handler2Name;
	}
	/**
	 * 属性代办人姓名/代办人姓名的setter方法
	 */
	public void setHandler2Name(String handler2Name) {
		this.handler2Name = handler2Name;
	}
	/**
	 * 属性代办人邮编/代办人邮编的getter方法
	 */
	public String getHandler2Post() {
		return handler2Post;
	}
	/**
	 * 属性代办人邮编/代办人邮编的setter方法
	 */
	public void setHandler2Post(String handler2Post) {
		this.handler2Post = handler2Post;
	}
	/**
	 * 属性经办人身份证号/经办人身份证号的getter方法
	 */
	public String getHandlerIdentifyNumber() {
		return handlerIdentifyNumber;
	}
	/**
	 * 属性经办人身份证号/经办人身份证号的setter方法
	 */
	public void setHandlerIdentifyNumber(String handlerIdentifyNumber) {
		this.handlerIdentifyNumber = handlerIdentifyNumber;
	}
	/**
	 * 属性经办人名字 /经办人名字 的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性经办人名字 /经办人名字 的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	/**
	 * 属性介绍人ID/介绍人ID的getter方法
	 */
	public String getIntroducerId() {
		return introducerId;
	}
	/**
	 * 属性介绍人ID/介绍人ID的setter方法
	 */
	public void setIntroducerId(String introducerId) {
		this.introducerId = introducerId;
	}
	/**
	 * 属性介绍人姓名/介绍人姓名的getter方法
	 */
	public String getIntroducerName() {
		return introducerName;
	}
	/**
	 * 属性介绍人姓名/介绍人姓名的setter方法
	 */
	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}
	/**
	 * 属性isUndwrtFlag/isUndwrtFlag的getter方法
	 */
	public String getIsUndwrtFlag() {
		return isUndwrtFlag;
	}
	/**
	 * 属性isUndwrtFlag/isUndwrtFlag的setter方法
	 */
	public void setIsUndwrtFlag(String isUndwrtFlag) {
		this.isUndwrtFlag = isUndwrtFlag;
	}
	/**
	 * 属性见费出单标志/见费出单标志的getter方法
	 */
	public String getJFeeFlag() {
		return jFeeFlag;
	}
	/**
	 * 属性见费出单标志/见费出单标志的setter方法
	 */
	public void setJFeeFlag(String jFeeFlag) {
		this.jFeeFlag = jFeeFlag;
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
	 * 属性锁定人代码/锁定人代码的getter方法
	 */
	public String getLockerCode() {
		return lockerCode;
	}
	/**
	 * 属性锁定人代码/锁定人代码的setter方法
	 */
	public void setLockerCode(String lockerCode) {
		this.lockerCode = lockerCode;
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
	 * 属性交强险即时生效 结束日期/交强险即时生效 结束日期的getter方法
	 */
	public Date getNewEndDate() {
		return newEndDate;
	}
	/**
	 * 属性交强险即时生效 结束日期/交强险即时生效 结束日期的setter方法
	 */
	public void setNewEndDate(Date newEndDate) {
		this.newEndDate = newEndDate;
	}
	/**
	 * 属性交强险即时生效 开始日期/交强险即时生效 开始日期的getter方法
	 */
	public Date getNewStartDate() {
		return newStartDate;
	}
	/**
	 * 属性交强险即时生效 开始日期/交强险即时生效 开始日期的setter方法
	 */
	public void setNewStartDate(Date newStartDate) {
		this.newStartDate = newStartDate;
	}
	/**
	 * 属性notRenewalRegist/notRenewalRegist的getter方法
	 */
	public String getNotRenewalRegist() {
		return notRenewalRegist;
	}
	/**
	 * 属性notRenewalRegist/notRenewalRegist的setter方法
	 */
	public void setNotRenewalRegist(String notRenewalRegist) {
		this.notRenewalRegist = notRenewalRegist;
	}
	/**
	 * 属性出单方式标识/出单方式标识的getter方法
	 */
	public String getOperateWayFlag() {
		return operateWayFlag;
	}
	/**
	 * 属性出单方式标识/出单方式标识的setter方法
	 */
	public void setOperateWayFlag(String operateWayFlag) {
		this.operateWayFlag = operateWayFlag;
	}
	/**
	 * 属性payrefCode/payrefCode的getter方法
	 */
	public String getPayrefCode() {
		return payrefCode;
	}
	/**
	 * 属性payrefCode/payrefCode的setter方法
	 */
	public void setPayrefCode(String payrefCode) {
		this.payrefCode = payrefCode;
	}
	/**
	 * 属性payrefName/payrefName的getter方法
	 */
	public String getPayrefName() {
		return payrefName;
	}
	/**
	 * 属性payrefName/payrefName的setter方法
	 */
	public void setPayrefName(String payrefName) {
		this.payrefName = payrefName;
	}
//	/**
//	 * 属性payfefTime/payfefTime的getter方法
//	 */
//	public java.util.Date getPayfefTime() {
//		return payfefTime;
//	}
//	/**
//	 * 属性payfefTime/payfefTime的setter方法
//	 */
//	public void setPayfefTime(java.util.Date payfefTime) {
//		this.payfefTime = payfefTime;
//	}
	/**
	 * 属性preCheckDate/preCheckDate的getter方法
	 */
	public Date getPreCheckDate() {
		return preCheckDate;
	}
	/**
	 * 属性preCheckDate/preCheckDate的setter方法
	 */
	public void setPreCheckDate(Date preCheckDate) {
		this.preCheckDate = preCheckDate;
	}
	/**
	 * 属性printTime/printTime的getter方法
	 */
	public Date getPrintTime() {
		return printTime;
	}
	/**
	 * 属性printTime/printTime的setter方法
	 */
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}
	/**
	 * 属性项目标志/项目标志的getter方法
	 */
	public String getProjectsFlag() {
		return projectsFlag;
	}
	/**
	 * 属性项目标志/项目标志的setter方法
	 */
	public void setProjectsFlag(String projectsFlag) {
		this.projectsFlag = projectsFlag;
	}
	/**
	 * 属性投保单核保通过级别/投保单核保通过级别的getter方法
	 */
	public String getProposalLevel() {
		return proposalLevel;
	}
	/**
	 * 属性投保单核保通过级别/投保单核保通过级别的setter方法
	 */
	public void setProposalLevel(String proposalLevel) {
		this.proposalLevel = proposalLevel;
	}
	/**
	 * 属性费率别终止日期/费率别终止日期的getter方法
	 */
	public Date getRateEndDate() {
		return rateEndDate;
	}
	/**
	 * 属性费率别终止日期/费率别终止日期的setter方法
	 */
	public void setRateEndDate(Date rateEndDate) {
		this.rateEndDate = rateEndDate;
	}
	/**
	 * 属性费率别版本值/费率别版本值的getter方法
	 */
	public String getRatePeriod() {
		return ratePeriod;
	}
	/**
	 * 属性费率别版本值/费率别版本值的setter方法
	 */
	public void setRatePeriod(String ratePeriod) {
		this.ratePeriod = ratePeriod;
	}
	/**
	 * 属性费率别版本旧值/费率别版本旧值的getter方法
	 */
	public String getRatePeriodOld() {
		return ratePeriodOld;
	}
	/**
	 * 属性费率别版本旧值/费率别版本旧值的setter方法
	 */
	public void setRatePeriodOld(String ratePeriodOld) {
		this.ratePeriodOld = ratePeriodOld;
	}
	/**
	 * 属性费率别类型（新、旧)/费率别类型（新、旧)的getter方法
	 */
	public String getRatePeriodType() {
		return ratePeriodType;
	}
	/**
	 * 属性费率别类型（新、旧)/费率别类型（新、旧)的setter方法
	 */
	public void setRatePeriodType(String ratePeriodType) {
		this.ratePeriodType = ratePeriodType;
	}
	/**
	 * 属性费率别实施日期/费率别实施日期的getter方法
	 */
	public Date getRateStartDate() {
		return rateStartDate;
	}
	/**
	 * 属性费率别实施日期/费率别实施日期的setter方法
	 */
	public void setRateStartDate(Date rateStartDate) {
		this.rateStartDate = rateStartDate;
	}
	/**
	 * 属性未续保登记原因/未续保登记原因的getter方法
	 */
	public String getRsnNoreNewAl() {
		return rsnNoreNewAl;
	}
	/**
	 * 属性未续保登记原因/未续保登记原因的setter方法
	 */
	public void setRsnNoreNewAl(String rsnNoreNewAl) {
		this.rsnNoreNewAl = rsnNoreNewAl;
	}
	/**
	 * 属性批量代收代付起始缴费期次/批量代收代付起始缴费期次的getter方法
	 */
	public Integer getStartStages() {
		return startStages;
	}
	/**
	 * 属性批量代收代付起始缴费期次/批量代收代付起始缴费期次的setter方法
	 */
	public void setStartStages(Integer startStages) {
		this.startStages = startStages;
	}
	/**
	 * 属性停驶次数/停驶次数的getter方法
	 */
	public String getStopTimes() {
		return stopTimes;
	}
	/**
	 * 属性停驶次数/停驶次数的setter方法
	 */
	public void setStopTimes(String stopTimes) {
		this.stopTimes = stopTimes;
	}
	/**
	 * 属性与现有系统编码统一/与现有系统编码统一的getter方法
	 */
	public String getSubBusinessNature() {
		return subBusinessNature;
	}
	/**
	 * 属性与现有系统编码统一/与现有系统编码统一的setter方法
	 */
	public void setSubBusinessNature(String subBusinessNature) {
		this.subBusinessNature = subBusinessNature;
	}
	/**
	 * 属性关贸查询返回查询序号/关贸查询返回查询序号的getter方法
	 */
	public String getTradeVanId() {
		return tradeVanId;
	}
	/**
	 * 属性关贸查询返回查询序号/关贸查询返回查询序号的setter方法
	 */
	public void setTradeVanId(String tradeVanId) {
		this.tradeVanId = tradeVanId;
	}
	/**
	 * 属性undwrtMark/undwrtMark的getter方法
	 */
	public String getUndwrtMark() {
		return undwrtMark;
	}
	/**
	 * 属性undwrtMark/undwrtMark的setter方法
	 */
	public void setUndwrtMark(String undwrtMark) {
		this.undwrtMark = undwrtMark;
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
	 * 属性oldAutoNoMyAdjustValue/oldAutoNoMyAdjustValue的getter方法
	 */
	public Double getOldAutoNoMyAdjustValue() {
		return oldAutoNoMyAdjustValue;
	}
	/**
	 * 属性oldAutoNoMyAdjustValue/oldAutoNoMyAdjustValue的setter方法
	 */
	public void setOldAutoNoMyAdjustValue(Double oldAutoNoMyAdjustValue) {
		this.oldAutoNoMyAdjustValue = oldAutoNoMyAdjustValue;
	}
	/**
	 * 属性oldChannelAdjustValue/oldChannelAdjustValue的getter方法
	 */
	public Double getOldChannelAdjustValue() {
		return oldChannelAdjustValue;
	}
	/**
	 * 属性oldChannelAdjustValue/oldChannelAdjustValue的setter方法
	 */
	public void setOldChannelAdjustValue(Double oldChannelAdjustValue) {
		this.oldChannelAdjustValue = oldChannelAdjustValue;
	}
	/**
	 * 属性oldDiscount/oldDiscount的getter方法
	 */
	public Double getOldDiscount() {
		return oldDiscount;
	}
	/**
	 * 属性oldDiscount/oldDiscount的setter方法
	 */
	public void setOldDiscount(Double oldDiscount) {
		this.oldDiscount = oldDiscount;
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
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate的getter方法
	 */
	public String getAdjustClaimReasonRate() {
		return adjustClaimReasonRate;
	}
	/**
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate的setter方法
	 */
	public void setAdjustClaimReasonRate(String adjustClaimReasonRate) {
		this.adjustClaimReasonRate = adjustClaimReasonRate;
	}
	/**
	 * 属性adjustClaimReasonCode/adjustClaimReasonCode的getter方法
	 */
	public Integer getAdjustClaimReasonCode() {
		return adjustClaimReasonCode;
	}
	/**
	 * 属性adjustClaimReasonCode/adjustClaimReasonCode的setter方法
	 */
	public void setAdjustClaimReasonCode(Integer adjustClaimReasonCode) {
		this.adjustClaimReasonCode = adjustClaimReasonCode;
	}
	/**
	 * 属性总折扣金额变化量/总折扣金额变化量的getter方法
	 */
	public Double getChgSumDiscount() {
		return chgSumDiscount;
	}
	/**
	 * 属性总折扣金额变化量/总折扣金额变化量的setter方法
	 */
	public void setChgSumDiscount(Double chgSumDiscount) {
		this.chgSumDiscount = chgSumDiscount;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * 属性总不含税保费变化量/总不含税保费变化量的getter方法
	 */
	public Double getChgNoTaxPremium() {
		return chgNoTaxPremium;
	}
	/**
	 * 属性总不含税保费变化量/总不含税保费变化量的setter方法
	 */
	public void setChgNoTaxPremium(Double chgNoTaxPremium) {
		this.chgNoTaxPremium = chgNoTaxPremium;
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
	 * 属性税额变化量/税额变化量的getter方法
	 */
	public Double getChgTaxFee() {
		return chgTaxFee;
	}
	/**
	 * 属性税额变化量/税额变化量的setter方法
	 */
	public void setChgTaxFee(Double chgTaxFee) {
		this.chgTaxFee = chgTaxFee;
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
	 * 属性wxChannelCode/wxChannelCode的getter方法
	 */
	public String getWxChannelCode() {
		return wxChannelCode;
	}
	/**
	 * 属性wxChannelCode/wxChannelCode的setter方法
	 */
	public void setWxChannelCode(String wxChannelCode) {
		this.wxChannelCode = wxChannelCode;
	}	
	/**
	 * 属性isOnline/isOnline的getter方法
	 */
	public String getIsOnline() {
		return isOnline;
	}
	/**
	 * 属性isOnline/isOnline的setter方法
	 */
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}	
	/**
	 * 属性isCustomer/isCustomer的getter方法
	 */
	public String getIsCustomer() {
		return isCustomer;
	}
	/**
	 * 属性isCustomer/isCustomer的setter方法
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

	public Double getChgFPremium() {
		return chgFPremium;
	}

	public void setChgFPremium(Double chgFPremium) {
		this.chgFPremium = chgFPremium;
	}

	public Double getChgCentralPremium() {
		return chgCentralPremium;
	}

	public void setChgCentralPremium(Double chgCentralPremium) {
		this.chgCentralPremium = chgCentralPremium;
	}

	public Double getChgProvincePremium() {
		return chgProvincePremium;
	}

	public void setChgProvincePremium(Double chgProvincePremium) {
		this.chgProvincePremium = chgProvincePremium;
	}

	public Double getChgCityPremium() {
		return chgCityPremium;
	}

	public void setChgCityPremium(Double chgCityPremium) {
		this.chgCityPremium = chgCityPremium;
	}

	public Double getChgTownPremium() {
		return chgTownPremium;
	}

	public void setChgTownPremium(Double chgTownPremium) {
		this.chgTownPremium = chgTownPremium;
	}

	public Double getChgOtherPremium() {
		return chgOtherPremium;
	}

	public void setChgOtherPremium(Double chgOtherPremium) {
		this.chgOtherPremium = chgOtherPremium;
	}

}
