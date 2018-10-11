package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 批改保单信息表实体操作对象
 */
@Entity
@Table(name = "PrpPmain")
@IdClass(PrpPmainKey.class)
public class PrpPmain extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;	

	/** 属性保单号码/保单号码 */
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
	/** 属性 合同号(供合保单使用)/ 合同号(供合保单使用) */
	@Column(name = "contractNo")
	private String contractNo ;
	/** 属性保单种类(0普通1定额)/保单种类(0普通1定额) */
	@Column(name = "policySort")
	private String policySort ;
	/** 属性保单印刷号/保单印刷号 */
	@Column(name = "printNo")
	private String printNo ;
	/** 属性业务来源（直接/代理）/业务来源（直接/代理） */
	@Column(name = "businessNature")
	private String businessNature ;
	/** 属性语种标志（C/E/…）/语种标志（C/E/…） */
	@Column(name = "language")
	private String language ;
	/** 属性 保单类型（个人/集体）/ 保单类型（个人/集体） */
	@Column(name = "policyType")
	private String policyType ;
	/** 属性 投保人代码 / 投保人代码  */
	@Column(name = "appliCode")
	private String appliCode ;
	/** 属性投保人名称/投保人名称 */
	@Column(name = "appliName")
	private String appliName ;
	/** 属性 投保人地址/ 投保人地址 */
	@Column(name = "appliAddress")
	private String appliAddress ;
	/** 属性被保险人代码/被保险人代码 */
	@Column(name = "insuredCode")
	private String insuredCode ;
	/** 属性被保险人名称/被保险人名称 */
	@Column(name = "insuredName")
	private String insuredName ;
	/** 属性 被保险人地址/ 被保险人地址 */
	@Column(name = "insuredAddress")
	private String insuredAddress ;
	/** 属性 签单日期（制单日期）/ 签单日期（制单日期） */
	@Column(name = "operateDate")
	private Date operateDate ;
	/** 属性起保日期/起保日期 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate")
	private Date startDate ;
	/** 属性起保小时/起保小时 */
	@Column(name = "startHour")
	private Integer startHour ;
	/** 属性终保日期/终保日期 */
	@Column(name = "endDate")
	private Date endDate ;
	/** 属性终保小时/终保小时 */
	@Column(name = "endHour")
	private Integer endHour ;
	/** 属性 净费率/ 净费率 */
	@Column(name = "pureRate")
	private Double pureRate ;
	/** 属性手续费比例/手续费比例 */
	@Column(name = "disRate")
	private Double disRate ;
	/** 属性总折扣率/总折扣率 */
	@Column(name = "discount")
	private Double discount ;
	/** 属性 币别代码/ 币别代码 */
	@Column(name = "currency")
	private String currency ;
	/** 属性总保险价值/总保险价值 */
	@Column(name = "sumValue")
	private Double sumValue ;
	/** 属性总保额(折算为人民币总保额)/总保额(折算为人民币总保额) */
	@Column(name = "sumAmount")
	private Double sumAmount ;
	/** 属性总折扣金额/总折扣金额 */
	@Column(name = "sumDiscount")
	private Double sumDiscount ;
	/** 属性总保险费(折算为人民币总保费)/总保险费(折算为人民币总保费) */
	@Column(name = "sumPremium")
	private Double sumPremium ;
	/** 属性总附加险保费/总附加险保费 */
	@Column(name = "sumSubPrem")
	private Double sumSubPrem ;
	/** 属性 被保险总数量/人数/户数--** 压力容器总数/ 被保险总数量/人数/户数--** 压力容器总数 */
	@Column(name = "sumQuantity")
	private Integer sumQuantity ;
	/** 属性judicalCode/judicalCode */
	@Column(name = "judicalCode")
	private String judicalCode ;
	/** 属性司法管辖/司法管辖 */
	@Column(name = "judicalScope")
	private String judicalScope ;
	/** 属性缴费方式（0、现金 1、银行转帐 2、刷卡 3、支票）/缴费方式（0、现金 1、银行转帐 2、刷卡 3、支票） */
	@Column(name = "autoTransRenewFlag")
	private String autoTransRenewFlag ;
	/** 属性争议解决方式▲--** 1 诉讼；2 仲裁/争议解决方式▲--** 1 诉讼；2 仲裁 */
	@Column(name = "argueSolution")
	private String argueSolution ;
	/** 属性仲裁委员会名称/仲裁委员会名称 */
	@Column(name = "arbitBoardName")
	private String arbitBoardName ;
	/** 属性约定分期交费次数/约定分期交费次数 */
	@Column(name = "payTimes")
	private Integer payTimes ;
	/** 属性批改次数/批改次数 */
	@Column(name = "endorseTimes")
	private Integer endorseTimes ;
	/** 属性理赔次数/理赔次数 */
	@Column(name = "claimTimes")
	private Integer claimTimes ;
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
	/** 属性归属业务员代码 /归属业务员代码  */
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
	private Date inputDate ;
	/** 属性计算机输单小时/计算机输单小时 */
	@Column(name = "inputHour")
	private Integer inputHour ;
	/** 属性核保完成日期/核保完成日期 */
	@Column(name = "underwriteEndDate")
	private Date underwriteEndDate ;
	/** 属性 保单统计年月/ 保单统计年月 */
	@Column(name = "statisticSym")
	private Date statisticSym ;
	/** 属性代理人代码/代理人代码 */
	@Column(name = "agentCode")
	private String agentCode ;
	/** 属性共保标志--** (0非共保/1主共保/2共保)/共保标志--** (0非共保/1主共保/2共保) */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性 商业分保标志--** (0无需分保/1需分保/2已分保)/ 商业分保标志--** (0无需分保/1需分保/2已分保) */
	@Column(name = "reinsFlag")
	private String reinsFlag ;
	/** 属性--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它/--** 统保标志(0/1统保)--**0顺位,1均分,2法定,3其它 */
	@Column(name = "allinsFlag")
	private String allinsFlag ;
	/** 属性--** 核保标志--** (0无需核保/1通过/2不通过/9待核保)/--** 核保标志--** (0无需核保/1通过/2不通过/9待核保) */
	@Column(name = "underwriteFlag")
	private String underwriteFlag ;
	/** 属性其它标志字段/其它标志字段 */
	@Column(name = "othFlag")
	private String othFlag ;
	/** 属性--** 状态字段/--** 状态字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性--** 变化保险金额(折算为人民币保额)/--** 变化保险金额(折算为人民币保额) */
	@Column(name = "chgAmount")
	private Double chgAmount ;
	/** 属性--** 变化保险费(折算为人民币保费)/--** 变化保险费(折算为人民币保费) */
	@Column(name = "chgPremium")
	private Double chgPremium ;
	/** 属性--** 变化附加险保费（折算为人民币）/--** 变化附加险保费（折算为人民币） */
	@Column(name = "chgSubPrem")
	private Double chgSubPrem ;
	/** 属性--** 变化数量/--** 变化数量 */
	@Column(name = "chgQuantity")
	private Integer chgQuantity ;
	/** 属性--** 超出部分手续费比例/--** 超出部分手续费比例 */
	@Column(name = "disRate1")
	private Double disRate1 ;
	/** 属性--** 业务类型--** 0：自营业务，1：分入业务/--** 业务类型--** 0：自营业务，1：分入业务 */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性updaterCode/updaterCode */
	@Column(name = "updaterCode")
	private String updaterCode ;
	/** 属性updateDate/updateDate */
	@Column(name = "updateDate")
	private Date updateDate ;
	/** 属性updateHour/updateHour */
	@Column(name = "updateHour")
	private String updateHour ;
	/** 属性signDate/signDate */
	@Column(name = "signDate")
	private Date signDate ;
	/** 属性shareHolderFlag/shareHolderFlag */
	@Column(name = "shareholderFlag")
	private String shareholderFlag ;
	/** 属性agreementNo/agreementNo */
	@Column(name = "agreementNo")
	private String agreementNo ;
	/** 属性inquiryNo/inquiryNo */
	@Column(name = "inquiryNo")
	private String inquiryNo ;
	/** 属性payMode/payMode */
	@Column(name = "payMode")
	private String payMode ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性visaCode/visaCode */
	@Column(name = "visaCode")
	private String visaCode ;
	/** 属性manualType/manualType */
	@Column(name = "manualType")
	private String manualType ;
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
	private Double statQuantity ;
	/** 属性统计口径的计量单位代码/统计口径的计量单位代码 */
	@Column(name = "statUnitCode")
	private String statUnitCode ;
	/** 属性参保农户户次/参保农户户次 */
	@Column(name = "sumInsured")
	private Double sumInsured ;
	/** 属性统计口径的承保数量变化量/统计口径的承保数量变化量 */
	@Column(name = "chgStatQuantity")
	private Double chgStatQuantity ;
	/** 属性参保农户户次变化量/参保农户户次变化量 */
	@Column(name = "chgInsured")
	private Double chgInsured ;
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
	/** 属性批单打印日期/批单打印日期 */
	@Column(name = "printDate")
	private Date printDate ;
	/** 属性批单收费日期/批单收费日期 */
	@Column(name = "payDate")
	private Date payDate ;
	/** 属性起保分钟/起保分钟 */
	@Column(name = "startMinute")
	private Integer startMinute ;
	/** 属性终保分钟/终保分钟 */
	@Column(name = "endMinute")
	private Integer endMinute ;
	/** 属性每次事故责任限额/每次事故责任限额 */
	@Column(name = "limitAmount")
	private Double limitAmount ;
	/** 属性每次事故责任限额变化量/每次事故责任限额变化量 */
	@Column(name = "chgLimitAmount")
	private Double chgLimitAmount ;
	/** 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否 */
	@Column(name = "thirdKnow")
	private String thirdKnow ;
	/** 属性agentRemark/agentRemark */
	@Column(name = "agentRemark")
	private String agentRemark ;
	/** 属性nCarPerpFlag/nCarPerpFlag */
	@Column(name = "nCarPerpFlag")
	private String nCarPerpFlag ;
	/** 属性大户归属区域 /大户归属区域  */
	@Column(name = "richflyAreasCode")
	private String richflyAreasCode ;
	/** 属性大户归属区域名称 /大户归属区域名称  */
	@Column(name = "richflyAreasCName")
	private String richflyAreasCName ;
	/** 属性大户编码 /大户编码  */
	@Column(name = "richflyCode")
	private String richflyCode ;
	/** 属性大户名称 /大户名称  */
	@Column(name = "richflyCName")
	private String richflyCName ;
	/** 属性GroupNo/GroupNo */
	@Column(name = "GroupNo")
	private String groupNo ;
	/** 属性GroupFlag/GroupFlag */
	@Column(name = "GroupFlag")
	private String groupFlag ;
	/** 属性BasePerformanceRate/BasePerformanceRate */
	@Column(name = "BasePerformanceRate")
	private Double basePerformanceRate ;
	/** 属性encouragePerformanceRate/encouragePerformanceRate */
	@Column(name = "encouragePerformanceRate")
	private Double encouragePerformanceRate ;
	/** 属性chgBasePerformanceRate/chgBasePerformanceRate */
	@Column(name = "chgBasePerformanceRate")
	private Double chgBasePerformanceRate ;
	/** 属性绩效总比例/绩效总比例 */
	@Column(name = "sumRate")
	private Double sumRate ;
	/** 属性标准保费折算系数/标准保费折算系数 */
	@Column(name = "standardRate")
	private Double standardRate ;
	/** 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中 */
	@Column(name = "agriFlag")
	private String agriFlag ;
	/** 属性版本号/版本号 */
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性大病医疗专项业务类型/大病医疗专项业务类型 */
	@Column(name = "bigMedicalType")
	private String bigMedicalType ;
	/** 属性盈利率,大病医疗/盈利率,大病医疗 */
	@Column(name = "earningsRate")
	private String earningsRate ;
	/** 属性大病医疗保险投保方式：1，记名承保 2，不记名承保/大病医疗保险投保方式：1，记名承保 2，不记名承保 */
	@Column(name = "insuredListType")
	private String insuredListType ;
	/** 属性共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取/共保业务保单缴费类型：1--全单100%收取，2--按照我方份额收取 */
	@Column(name = "coinsPremiumType")
	private String coinsPremiumType ;
	/** 属性businessCity/businessCity */
	@Column(name = "businessCity")
	private String businessCity ;
	/** 属性allianCreate/allianCreate */
	@Column(name = "allianceRate")
	private Double allianceRate ;
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
	/** 属性归属区域：村/归属区域：村 */
	@Column(name = "businessArea")
	private String businessArea ;
	/** 属性未续保登记原因代码/未续保登记原因代码 */
	@Column(name = "localModelDiscountQ")
	private Double localModelDiscountQ ;
	/** 属性自主核保模型系数/自主核保模型系数 */
	@Column(name = "localModelDiscountZ")
	private Double localModelDiscountZ ;
	/** 属性内部模型定价/内部模型定价 */
	@Column(name = "localModelPremium")
	private Double localModelPremium ;
	/** 属性销售人员/销售人员 */
	@Column(name = "saleName")
	private String saleName ;
	/** 属性联系电话/联系电话 */
	@Column(name = "salePhone")
	private String salePhone ;
	/** 属性销售公司代码/销售公司代码 */
	@Column(name = "saleComCode")
	private String saleComCode ;
	/** 属性销售公司名称/销售公司名称 */
	@Column(name = "saleComName")
	private String saleComName ;
	/** 属性销售公司地址/销售公司地址 */
	@Column(name = "saleComAddress")
	private String saleComAddress ;
	/** 属性中介机构地址/中介机构地址 */
	@Column(name = "saleAgentAddress")
	private String saleAgentAddress ;
	/** 属性中介机构销售人员姓名/中介机构销售人员姓名 */
	@Column(name = "saleAgentPersonName")
	private String saleAgentPersonName ;
	/** 属性中介机构销售人员执业证号/中介机构销售人员执业证号 */
	@Column(name = "saleAgentPersonId")
	private String saleAgentPersonId ;
	/** 属性代收人ID/代收人ID */
	@Column(name = "agent1Code")
	private String agent1Code ;
	/** 属性代收人姓名/代收人姓名 */
	@Column(name = "agent1Name")
	private String agent1Name ;
	/** 属性agentMaxComission/agentMaxComission */
	@Column(name = "agentMaxComission")
	private Double agentMaxComission ;
	/** 属性代理人名称/代理人名称 */
	@Column(name = "agentName")
	private String agentName ;
	/** 属性代理联动类型/代理联动类型 */
	@Column(name = "agentTypeNo")
	private String agentTypeNo ;
	/** 属性涉农标志/涉农标志 */
	@Column(name = "agriType")
	private String agriType ;
	/** 属性手续费拆分方案号/手续费拆分方案号 */
	@Column(name = "assignNo")
	private String assignNo ;
	/** 属性开户代码/开户代码 */
	@Column(name = "bankCode")
	private String bankCode ;
	/** 属性bankFlag/bankFlag */
	@Column(name = "bankFlag")
	private String bankFlag ;
	/** 属性bizNoSysFlag/bizNoSysFlag */
	@Column(name = "bizNoSysFlag")
	private String bizNoSysFlag ;
	/** 属性备用8/备用8 */
	@Column(name = "businessRecMark")
	private String businessRecMark ;
	/** 属性businessTypeFlag/businessTypeFlag */
	@Column(name = "businessTypeFlag")
	private String businessTypeFlag ;
	/** 属性caseNo/caseNo */
	@Column(name = "caseNo")
	private String caseNo ;
	/** 属性channelCode/channelCode */
	@Column(name = "channelCode")
	private String channelCode ;
	/** 属性渠道类型/渠道类型 */
	@Column(name = "channelType")
	private String channelType ;
	/** 属性备用7/备用7 */
	@Column(name = "contributionLevel")
	private String contributionLevel ;
	/** 属性备用6/备用6 */
	@Column(name = "declareFlag")
	private String declareFlag ;
	/** 属性编辑标志/编辑标志 */
	@Column(name = "editFlag")
	private String editFlag ;
	/** 属性备用4/备用4 */
	@Column(name = "effectiveImmediatelyFlag")
	private String effectiveImmediatelyFlag ;
	/** 属性兑换率/兑换率 */
	@Column(name = "exchangeRate")
	private Double exchangeRate ;
	/** 属性单位/单位 */
	@Column(name = "extraComCode")
	private String extraComCode ;
	/** 属性老系统即时生效标志/老系统即时生效标志 */
	@Column(name = "effectFlag")
	private String effectFlag ;
	/** 属性业务渠道/业务渠道 */
	@Column(name = "agentClass")
	private String agentClass ;
	/** 属性手续费比例上限/手续费比例上限 */
	@Column(name = "topCommisionRate")
	private String topCommisionRate ;
	/** 属性手续费比例1/手续费比例1 */
	@Column(name = "intCommisionRate")
	private String intCommisionRate ;
	/** 属性新车险系统出单标志/新车险系统出单标志 */
	@Column(name = "systemFlag")
	private String systemFlag ;
	/** 属性预开发票标志/预开发票标志 */
	@Column(name = "preInvoiceFlag")
	private String preInvoiceFlag ;
	/** 属性提交核保标志  空代表选择提交，1代表普通，2代表特殊/提交核保标志  空代表选择提交，1代表普通，2代表特殊 */
	@Column(name = "submitUndwrtFlag")
	private String submitUndwrtFlag ;
	/** 属性前台出单修改标志/前台出单修改标志 */
	@Column(name = "typeFgEditFlag")
	private String typeFgEditFlag ;
	/** 属性单子类型/单子类型 */
	@Column(name = "inputType")
	private String inputType ;
	/** 属性特殊业务申请号/特殊业务申请号 */
	@Column(name = "specialBusinessNo")
	private String specialBusinessNo ;
	/** 属性分期村志/分期村志 */
	@Column(name = "periodFlag")
	private String periodFlag ;
	/** 属性车险分期：挂起标识/车险分期：挂起标识 */
	@Column(name = "hangupFlag")
	private String hangupFlag ;
	/** 属性车险分期：可退保标识/车险分期：可退保标识 */
	@Column(name = "paybackFlag")
	private String paybackFlag ;
	/** 属性自主渠道系数/自主渠道系数 */
	@Column(name = "channelAdjustValue")
	private Double channelAdjustValue ;
	/** 属性自主核保系数/自主核保系数 */
	@Column(name = "autonomyAdjustValue")
	private Double autonomyAdjustValue ;
	/** 属性条款版本/条款版本 */
	@Column(name = "clauseType")
	private String clauseType ;
	/** 属性validTime/validTime */
	@Column(name = "validTime")
	private String validTime ;
	/** 属性单位名称/单位名称 */
	@Column(name = "extraComName")
	private String extraComName ;
	/** 属性寿险职场名称/寿险职场名称 */
	@Column(name = "factorPlaceCode")
	private String factorPlaceCode ;
	/** 属性寿险职场名称1/寿险职场名称1 */
	@Column(name = "factorPlaceName")
	private String factorPlaceName ;
	/** 属性是否转拨计价/是否转拨计价 */
	@Column(name = "fycFlag")
	private String fycFlag ;
	/** 属性是否政府采购/是否政府采购 */
	@Column(name = "govPurchaseFlag")
	private String govPurchaseFlag ;
	/** 属性团队类型/团队类型 */
	@Column(name = "groupType")
	private String groupType ;
	/** 属性业务归属人员名称/业务归属人员名称 */
	@Column(name = "handler1Name")
	private String handler1Name ;
	/** 属性代办人地址/代办人地址 */
	@Column(name = "handler2Address")
	private String handler2Address ;
	/** 属性代办人代码/代办人代码 */
	@Column(name = "handler2Code")
	private String handler2Code ;
	/** 属性代办人证件号码/代办人证件号码 */
	@Column(name = "handler2Id")
	private String handler2Id ;
	/** 属性代办人证件/代办人证件 */
	@Column(name = "handler2IdType")
	private String handler2IdType ;
	/** 属性代办人电话/代办人电话 */
	@Column(name = "handler2Mobile")
	private String handler2Mobile ;
	/** 属性代办人姓名/代办人姓名 */
	@Column(name = "handler2Name")
	private String handler2Name ;
	/** 属性代办人邮编/代办人邮编 */
	@Column(name = "handler2Post")
	private String handler2Post ;
	/** 属性经办人身份证号/经办人身份证号 */
	@Column(name = "handlerIdentifyNumber")
	private String handlerIdentifyNumber ;
	/** 属性经办人名字 /经办人名字  */
	@Column(name = "handlerName")
	private String handlerName ;
	/** 属性介绍人ID/介绍人ID */
	@Column(name = "introducerId")
	private String introducerId ;
	/** 属性介绍人姓名/介绍人姓名 */
	@Column(name = "introducerName")
	private String introducerName ;
	/** 属性isUndwrtFlag/isUndwrtFlag */
	@Column(name = "isUndwrtFlag")
	private String isUndwrtFlag ;
	/** 属性见费出单标志/见费出单标志 */
	@Column(name = "jFeeFlag")
	private String jFeeFlag ;
	/** 属性lastInsurerCode/lastInsurerCode */
	@Column(name = "lastInsurerCode")
	private String lastInsurerCode ;
	/** 属性lastInsurerCom/lastInsurerCom */
	@Column(name = "lastInsurerCom")
	private String lastInsurerCom ;
	/** 属性lastPrintNo/lastPrintNo */
	@Column(name = "lastPrintNo")
	private String lastPrintNo ;
	/** 属性锁定人代码/锁定人代码 */
	@Column(name = "lockerCode")
	private String lockerCode ;
	/** 属性nationFlag/nationFlag */
	@Column(name = "nationFlag")
	private String nationFlag ;
	/** 属性交强险即时生效 结束日期/交强险即时生效 结束日期 */
	@Column(name = "newEndDate")
	private Date newEndDate ;
	/** 属性交强险即时生效 开始日期/交强险即时生效 开始日期 */
	@Column(name = "newStartDate")
	private Date newStartDate ;
	/** 属性notRenewalRegist/notRenewalRegist */
	@Column(name = "notRenewalRegist")
	private String notRenewalRegist ;
	/** 属性出单方式标识/出单方式标识 */
	@Column(name = "operateWayFlag")
	private String operateWayFlag ;
	/** 属性payrefCode/payrefCode */
	@Column(name = "payrefCode")
	private String payrefCode ;
	/** 属性payrefName/payrefName */
	@Column(name = "payrefName")
	private String payrefName ;
	/** 属性payfefTime/payfefTime */
//	@Column(name = "payfefTime")
//	private Date payfefTime ;
	/** 属性preCheckDate/preCheckDate */
	@Column(name = "precheckDate")
	private Date precheckDate ;
	/** 属性printTime/printTime */
	@Column(name = "printTime")
	private Date printTime ;
	/** 属性项目标志/项目标志 */
	@Column(name = "projectsFlag")
	private String projectsFlag ;
	/** 属性投保单核保通过级别/投保单核保通过级别 */
	@Column(name = "proposalLevel")
	private String proposalLevel ;
	/** 属性费率别终止日期/费率别终止日期 */
	@Column(name = "rateEndDate")
	private Date rateEndDate ;
	/** 属性费率别版本值/费率别版本值 */
	@Column(name = "ratePeriod")
	private String ratePeriod ;
	/** 属性费率别版本旧值/费率别版本旧值 */
	@Column(name = "ratePeriodOld")
	private String ratePeriodOld ;
	/** 属性费率别类型（新、旧)/费率别类型（新、旧) */
	@Column(name = "ratePeriodType")
	private String ratePeriodType ;
	/** 属性费率别实施日期/费率别实施日期 */
	@Column(name = "rateStartDate")
	private Date rateStartDate ;
	/** 属性未续保登记原因/未续保登记原因 */
	@Column(name = "rsnNoRenewal")
	private String rsnNoRenewal ;
	/** 属性批量代收代付起始缴费期次/批量代收代付起始缴费期次 */
	@Column(name = "startStages")
	private Integer startStages ;
	/** 属性停驶次数/停驶次数 */
	@Column(name = "stopTimes")
	private String stopTimes ;
	/** 属性与现有系统编码统一/与现有系统编码统一 */
	@Column(name = "subBusinessNature")
	private String subBusinessNature ;
	/** 属性关贸查询返回查询序号/关贸查询返回查询序号 */
	@Column(name = "tradeVanId")
	private String tradeVanId ;
	/** 属性undwrtMark/undwrtMark */
	@Column(name = "undwrtMark")
	private String undwrtMark ;
	/** 属性comCostPrem/comCostPrem */
	@Column(name = "comCostPrem")
	private Integer comCostPrem ;
	/** 属性ctpCostPrem/ctpCostPrem */
	@Column(name = "ctpCostPrem")
	private Integer ctpCostPrem ;
	/** 属性entireCostDiscount/entireCostDiscount */
	@Column(name = "entireCostDiscount")
	private Integer entireCostDiscount ;
	/** 属性entireRecommenDiscount/entireRecommenDiscount */
	@Column(name = "entireRecommenDiscount")
	private Integer entireRecommenDiscount ;
	/** 属性entireExpDiscount/entireExpDiscount */
	@Column(name = "entireExpDiscount")
	private Integer entireExpDiscount ;
	/** 属性entireUwritingDiscount/entireUwritingDiscount */
	@Column(name = "entireUwritingDiscount")
	private Integer entireUwritingDiscount ;
	/** 属性oldAutoNoMyAdjustValue/oldAutoNoMyAdjustValue */
	@Column(name = "oldAutoNoMyAdjustValue")
	private Double oldAutonomyAdjustValue ;
	/** 属性oldChannelAdjustValue/oldChannelAdjustValue */
	@Column(name = "oldChannelAdjustValue")
	private Double oldChannelAdjustValue ;
	/** 属性oldDiscount/oldDiscount */
	@Column(name = "oldDiscount")
	private Double oldDiscount ;
	/** 属性hopeDiscount/hopeDiscount */
	@Column(name = "hopeDiscount")
	private Double hopeDiscount ;
	/** 属性adjustClaimReasonRate/adjustClaimReasonRate */
	@Column(name = "adjustClaimReasonRate")
	private String adjustClaimReasonRate ;
	/** 属性adjustClaimReasonCode/adjustClaimReasonCode */
	@Column(name = "adjustClaimReasonCode")
	private Integer adjustClaimReasonCode ;
	/** 属性总折扣金额变化量/总折扣金额变化量 */
	@Column(name = "chgSumDiscount")
	private Double chgSumDiscount ;
	/** 属性修改人/修改人 */
	@Column(name = "update_by")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_date")
	private Date update_Date ;
	/** 属性总不含税保费/总不含税保费 */
	@Column(name = "sumNoTaxPremium")
	private Double sumNoTaxPremium ;
	/** 属性总不含税保费变化量/总不含税保费变化量 */
	@Column(name = "chgNoTaxPremium")
	private Double chgNoTaxPremium ;
	/** 属性总税额/总税额 */
	@Column(name = "sumTaxFee")
	private Double sumTaxFee ;
	/** 属性税额变化量/税额变化量 */
	@Column(name = "chgTaxFee")
	private Double chgTaxFee ;
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
	/** 属性wxChannelCode/wxChannelCode */
	@Column(name = "wxChannelCode")
	private String wxChannelCode ;
	/** 属性isOnline/isOnline */
	@Column(name = "isOnline")
	private String isOnline ;
	/** 属性isCustomer/isCustomer */
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
	private Integer ctpElr ;
	/** 属性商业险预期赔付率/商业险预期赔付率 */
	@Column(name = "comElr")
	private Integer comElr ;
	/** 属性整单预期赔付率/整单预期赔付率 */
	@Column(name = "elr")
	private Integer elr ;
	/**
	 * 自缴保费变化量
	 */
	@Column(name = "chgFPremium")
	private Double chgFPremium;
	/**
	 * 中央财政补贴变化量
	 */
	@Column(name = "chgCentralPremium")
	private Double chgCentralPremium;
	/**
	 * 省级财政补贴变化量
	 */
	@Column(name = "chgProvincePremium")
	private Double chgProvincePremium;
	/**
	 * 地市财政补贴变化量
	 */
	@Column(name = "chgCityPremium")
	private Double chgCityPremium;
	/**
	 * 区（县）财政变化量
	 */
	@Column(name = "chgTownPremium")
	private Double chgTownPremium;
	/**
	 * 其他来源补贴变化量
	 */
	@Column(name = "chgOtherPremium")
	private Double chgOtherPremium;

	/**
	 * 默认的无参构造方法
	 * @author: 何伟东
	 * @date: 2017/12/21 9:09
	 */
	public PrpPmain() {
	}

	/**
	 * 支付信息录入列表信息查询使用的构造方法
	 * @author: 何伟东
	 * @date: 2017/12/21 9:06
	 * @param endorseNo 批单号
	 * @param policyNo 保单号
	 * @param insuredCode 被保险人代码
	 * @param insuredName 被保险人名称
	 * @param chgPremium 变化保费
	 * @param makeCom 出单机构
	 */
	public PrpPmain(String endorseNo, String policyNo, String insuredCode, String insuredName, Double chgPremium, String makeCom) {
		this.endorseNo = endorseNo;
		this.policyNo = policyNo;
		this.insuredCode = insuredCode;
		this.insuredName = insuredName;
		this.chgPremium = chgPremium;
		this.makeCom = makeCom;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPolicySort() {
		return policySort;
	}

	public void setPolicySort(String policySort) {
		this.policySort = policySort;
	}

	public String getPrintNo() {
		return printNo;
	}

	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getAppliCode() {
		return appliCode;
	}

	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
	}

	public String getAppliName() {
		return appliName;
	}

	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}

	public String getAppliAddress() {
		return appliAddress;
	}

	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getInsuredAddress() {
		return insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public Double getPureRate() {
		return pureRate;
	}

	public void setPureRate(Double pureRate) {
		this.pureRate = pureRate;
	}

	public Double getDisRate() {
		return disRate;
	}

	public void setDisRate(Double disRate) {
		this.disRate = disRate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getSumValue() {
		return sumValue;
	}

	public void setSumValue(Double sumValue) {
		this.sumValue = sumValue;
	}

	public Double getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Double sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Double getSumDiscount() {
		return sumDiscount;
	}

	public void setSumDiscount(Double sumDiscount) {
		this.sumDiscount = sumDiscount;
	}

	public Double getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	}

	public Double getSumSubPrem() {
		return sumSubPrem;
	}

	public void setSumSubPrem(Double sumSubPrem) {
		this.sumSubPrem = sumSubPrem;
	}

	public Integer getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(Integer sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public String getJudicalCode() {
		return judicalCode;
	}

	public void setJudicalCode(String judicalCode) {
		this.judicalCode = judicalCode;
	}

	public String getJudicalScope() {
		return judicalScope;
	}

	public void setJudicalScope(String judicalScope) {
		this.judicalScope = judicalScope;
	}

	public String getAutoTransRenewFlag() {
		return autoTransRenewFlag;
	}

	public void setAutoTransRenewFlag(String autoTransRenewFlag) {
		this.autoTransRenewFlag = autoTransRenewFlag;
	}

	public String getArgueSolution() {
		return argueSolution;
	}

	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}

	public String getArbitBoardName() {
		return arbitBoardName;
	}

	public void setArbitBoardName(String arbitBoardName) {
		this.arbitBoardName = arbitBoardName;
	}

	public Integer getPayTimes() {
		return payTimes;
	}

	public void setPayTimes(Integer payTimes) {
		this.payTimes = payTimes;
	}

	public Integer getEndorseTimes() {
		return endorseTimes;
	}

	public void setEndorseTimes(Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	}

	public Integer getClaimTimes() {
		return claimTimes;
	}

	public void setClaimTimes(Integer claimTimes) {
		this.claimTimes = claimTimes;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}

	public String getOperateSite() {
		return operateSite;
	}

	public void setOperateSite(String operateSite) {
		this.operateSite = operateSite;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandler1Code() {
		return handler1Code;
	}

	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}

	public String getApproverCode() {
		return approverCode;
	}

	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
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

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getInputHour() {
		return inputHour;
	}

	public void setInputHour(Integer inputHour) {
		this.inputHour = inputHour;
	}

	public Date getUnderwriteEndDate() {
		return underwriteEndDate;
	}

	public void setUnderwriteEndDate(Date underwriteEndDate) {
		this.underwriteEndDate = underwriteEndDate;
	}

	public Date getStatisticSym() {
		return statisticSym;
	}

	public void setStatisticSym(Date statisticSym) {
		this.statisticSym = statisticSym;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getCoinsFlag() {
		return coinsFlag;
	}

	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}

	public String getReinsFlag() {
		return reinsFlag;
	}

	public void setReinsFlag(String reinsFlag) {
		this.reinsFlag = reinsFlag;
	}

	public String getAllinsFlag() {
		return allinsFlag;
	}

	public void setAllinsFlag(String allinsFlag) {
		this.allinsFlag = allinsFlag;
	}

	public String getUnderwriteFlag() {
		return underwriteFlag;
	}

	public void setUnderwriteFlag(String underwriteFlag) {
		this.underwriteFlag = underwriteFlag;
	}

	public String getOthFlag() {
		return othFlag;
	}

	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Double getChgAmount() {
		return chgAmount;
	}

	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}

	public Double getChgPremium() {
		return chgPremium;
	}

	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
	}

	public Double getChgSubPrem() {
		return chgSubPrem;
	}

	public void setChgSubPrem(Double chgSubPrem) {
		this.chgSubPrem = chgSubPrem;
	}

	public Integer getChgQuantity() {
		return chgQuantity;
	}

	public void setChgQuantity(Integer chgQuantity) {
		this.chgQuantity = chgQuantity;
	}

	public Double getDisRate1() {
		return disRate1;
	}

	public void setDisRate1(Double disRate1) {
		this.disRate1 = disRate1;
	}

	public String getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}

	public String getUpdaterCode() {
		return updaterCode;
	}

	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateHour() {
		return updateHour;
	}

	public void setUpdateHour(String updateHour) {
		this.updateHour = updateHour;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getShareholderFlag() {
		return shareholderFlag;
	}

	public void setShareholderFlag(String shareholderFlag) {
		this.shareholderFlag = shareholderFlag;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public String getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(String inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVisaCode() {
		return visaCode;
	}

	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}

	public String getManualType() {
		return manualType;
	}

	public void setManualType(String manualType) {
		this.manualType = manualType;
	}

	public String getPolicyBizType() {
		return policyBizType;
	}

	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Double getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(Double statQuantity) {
		this.statQuantity = statQuantity;
	}

	public String getStatUnitCode() {
		return statUnitCode;
	}

	public void setStatUnitCode(String statUnitCode) {
		this.statUnitCode = statUnitCode;
	}

	public Double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public Double getChgStatQuantity() {
		return chgStatQuantity;
	}

	public void setChgStatQuantity(Double chgStatQuantity) {
		this.chgStatQuantity = chgStatQuantity;
	}

	public Double getChgInsured() {
		return chgInsured;
	}

	public void setChgInsured(Double chgInsured) {
		this.chgInsured = chgInsured;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getBusinessProvince() {
		return businessProvince;
	}

	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}

	public String getBusinessTown() {
		return businessTown;
	}

	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}

	public String getBusinessCounty() {
		return businessCounty;
	}

	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}

	public String getBusinessAreaName() {
		return businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Integer getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(Integer startMinute) {
		this.startMinute = startMinute;
	}

	public Integer getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}

	public Double getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}

	public Double getChgLimitAmount() {
		return chgLimitAmount;
	}

	public void setChgLimitAmount(Double chgLimitAmount) {
		this.chgLimitAmount = chgLimitAmount;
	}

	public String getThirdKnow() {
		return thirdKnow;
	}

	public void setThirdKnow(String thirdKnow) {
		this.thirdKnow = thirdKnow;
	}

	public String getAgentRemark() {
		return agentRemark;
	}

	public void setAgentRemark(String agentRemark) {
		this.agentRemark = agentRemark;
	}

	public String getnCarPerpFlag() {
		return nCarPerpFlag;
	}

	public void setnCarPerpFlag(String nCarPerpFlag) {
		this.nCarPerpFlag = nCarPerpFlag;
	}

	public String getRichflyAreasCode() {
		return richflyAreasCode;
	}

	public void setRichflyAreasCode(String richflyAreasCode) {
		this.richflyAreasCode = richflyAreasCode;
	}

	public String getRichflyAreasCName() {
		return richflyAreasCName;
	}

	public void setRichflyAreasCName(String richflyAreasCName) {
		this.richflyAreasCName = richflyAreasCName;
	}

	public String getRichflyCode() {
		return richflyCode;
	}

	public void setRichflyCode(String richflyCode) {
		this.richflyCode = richflyCode;
	}

	public String getRichflyCName() {
		return richflyCName;
	}

	public void setRichflyCName(String richflyCName) {
		this.richflyCName = richflyCName;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupFlag() {
		return groupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}

	public Double getBasePerformanceRate() {
		return basePerformanceRate;
	}

	public void setBasePerformanceRate(Double basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	}

	public Double getEncouragePerformanceRate() {
		return encouragePerformanceRate;
	}

	public void setEncouragePerformanceRate(Double encouragePerformanceRate) {
		this.encouragePerformanceRate = encouragePerformanceRate;
	}

	public Double getChgBasePerformanceRate() {
		return chgBasePerformanceRate;
	}

	public void setChgBasePerformanceRate(Double chgBasePerformanceRate) {
		this.chgBasePerformanceRate = chgBasePerformanceRate;
	}

	public Double getSumRate() {
		return sumRate;
	}

	public void setSumRate(Double sumRate) {
		this.sumRate = sumRate;
	}

	public Double getStandardRate() {
		return standardRate;
	}

	public void setStandardRate(Double standardRate) {
		this.standardRate = standardRate;
	}

	public String getAgriFlag() {
		return agriFlag;
	}

	public void setAgriFlag(String agriFlag) {
		this.agriFlag = agriFlag;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getBigMedicalType() {
		return bigMedicalType;
	}

	public void setBigMedicalType(String bigMedicalType) {
		this.bigMedicalType = bigMedicalType;
	}

	public String getEarningsRate() {
		return earningsRate;
	}

	public void setEarningsRate(String earningsRate) {
		this.earningsRate = earningsRate;
	}

	public String getInsuredListType() {
		return insuredListType;
	}

	public void setInsuredListType(String insuredListType) {
		this.insuredListType = insuredListType;
	}

	public String getCoinsPremiumType() {
		return coinsPremiumType;
	}

	public void setCoinsPremiumType(String coinsPremiumType) {
		this.coinsPremiumType = coinsPremiumType;
	}

	public String getBusinessCity() {
		return businessCity;
	}

	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}

	public Double getAllianceRate() {
		return allianceRate;
	}

	public void setAllianceRate(Double allianceRate) {
		this.allianceRate = allianceRate;
	}

	public String getEccFlag() {
		return eccFlag;
	}

	public void setEccFlag(String eccFlag) {
		this.eccFlag = eccFlag;
	}

	public String getSsProposalNo() {
		return ssProposalNo;
	}

	public void setSsProposalNo(String ssProposalNo) {
		this.ssProposalNo = ssProposalNo;
	}

	public String getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(String businessYear) {
		this.businessYear = businessYear;
	}

	public String getMakeArea() {
		return makeArea;
	}

	public void setMakeArea(String makeArea) {
		this.makeArea = makeArea;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public Double getLocalModelDiscountQ() {
		return localModelDiscountQ;
	}

	public void setLocalModelDiscountQ(Double localModelDiscountQ) {
		this.localModelDiscountQ = localModelDiscountQ;
	}

	public Double getLocalModelDiscountZ() {
		return localModelDiscountZ;
	}

	public void setLocalModelDiscountZ(Double localModelDiscountZ) {
		this.localModelDiscountZ = localModelDiscountZ;
	}

	public Double getLocalModelPremium() {
		return localModelPremium;
	}

	public void setLocalModelPremium(Double localModelPremium) {
		this.localModelPremium = localModelPremium;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public String getSaleComCode() {
		return saleComCode;
	}

	public void setSaleComCode(String saleComCode) {
		this.saleComCode = saleComCode;
	}

	public String getSaleComName() {
		return saleComName;
	}

	public void setSaleComName(String saleComName) {
		this.saleComName = saleComName;
	}

	public String getSaleComAddress() {
		return saleComAddress;
	}

	public void setSaleComAddress(String saleComAddress) {
		this.saleComAddress = saleComAddress;
	}

	public String getSaleAgentAddress() {
		return saleAgentAddress;
	}

	public void setSaleAgentAddress(String saleAgentAddress) {
		this.saleAgentAddress = saleAgentAddress;
	}

	public String getSaleAgentPersonName() {
		return saleAgentPersonName;
	}

	public void setSaleAgentPersonName(String saleAgentPersonName) {
		this.saleAgentPersonName = saleAgentPersonName;
	}

	public String getSaleAgentPersonId() {
		return saleAgentPersonId;
	}

	public void setSaleAgentPersonId(String saleAgentPersonId) {
		this.saleAgentPersonId = saleAgentPersonId;
	}

	public String getAgent1Code() {
		return agent1Code;
	}

	public void setAgent1Code(String agent1Code) {
		this.agent1Code = agent1Code;
	}

	public String getAgent1Name() {
		return agent1Name;
	}

	public void setAgent1Name(String agent1Name) {
		this.agent1Name = agent1Name;
	}

	public Double getAgentMaxComission() {
		return agentMaxComission;
	}

	public void setAgentMaxComission(Double agentMaxComission) {
		this.agentMaxComission = agentMaxComission;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentTypeNo() {
		return agentTypeNo;
	}

	public void setAgentTypeNo(String agentTypeNo) {
		this.agentTypeNo = agentTypeNo;
	}

	public String getAgriType() {
		return agriType;
	}

	public void setAgriType(String agriType) {
		this.agriType = agriType;
	}

	public String getAssignNo() {
		return assignNo;
	}

	public void setAssignNo(String assignNo) {
		this.assignNo = assignNo;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankFlag() {
		return bankFlag;
	}

	public void setBankFlag(String bankFlag) {
		this.bankFlag = bankFlag;
	}

	public String getBizNoSysFlag() {
		return bizNoSysFlag;
	}

	public void setBizNoSysFlag(String bizNoSysFlag) {
		this.bizNoSysFlag = bizNoSysFlag;
	}

	public String getBusinessRecMark() {
		return businessRecMark;
	}

	public void setBusinessRecMark(String businessRecMark) {
		this.businessRecMark = businessRecMark;
	}

	public String getBusinessTypeFlag() {
		return businessTypeFlag;
	}

	public void setBusinessTypeFlag(String businessTypeFlag) {
		this.businessTypeFlag = businessTypeFlag;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getContributionLevel() {
		return contributionLevel;
	}

	public void setContributionLevel(String contributionLevel) {
		this.contributionLevel = contributionLevel;
	}

	public String getDeclareFlag() {
		return declareFlag;
	}

	public void setDeclareFlag(String declareFlag) {
		this.declareFlag = declareFlag;
	}

	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	public String getEffectiveImmediatelyFlag() {
		return effectiveImmediatelyFlag;
	}

	public void setEffectiveImmediatelyFlag(String effectiveImmediatelyFlag) {
		this.effectiveImmediatelyFlag = effectiveImmediatelyFlag;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getExtraComCode() {
		return extraComCode;
	}

	public void setExtraComCode(String extraComCode) {
		this.extraComCode = extraComCode;
	}

	public String getEffectFlag() {
		return effectFlag;
	}

	public void setEffectFlag(String effectFlag) {
		this.effectFlag = effectFlag;
	}

	public String getAgentClass() {
		return agentClass;
	}

	public void setAgentClass(String agentClass) {
		this.agentClass = agentClass;
	}

	public String getTopCommisionRate() {
		return topCommisionRate;
	}

	public void setTopCommisionRate(String topCommisionRate) {
		this.topCommisionRate = topCommisionRate;
	}

	public String getIntCommisionRate() {
		return intCommisionRate;
	}

	public void setIntCommisionRate(String intCommisionRate) {
		this.intCommisionRate = intCommisionRate;
	}

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getPreInvoiceFlag() {
		return preInvoiceFlag;
	}

	public void setPreInvoiceFlag(String preInvoiceFlag) {
		this.preInvoiceFlag = preInvoiceFlag;
	}

	public String getSubmitUndwrtFlag() {
		return submitUndwrtFlag;
	}

	public void setSubmitUndwrtFlag(String submitUndwrtFlag) {
		this.submitUndwrtFlag = submitUndwrtFlag;
	}

	public String getTypeFgEditFlag() {
		return typeFgEditFlag;
	}

	public void setTypeFgEditFlag(String typeFgEditFlag) {
		this.typeFgEditFlag = typeFgEditFlag;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getSpecialBusinessNo() {
		return specialBusinessNo;
	}

	public void setSpecialBusinessNo(String specialBusinessNo) {
		this.specialBusinessNo = specialBusinessNo;
	}

	public String getPeriodFlag() {
		return periodFlag;
	}

	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}

	public String getHangupFlag() {
		return hangupFlag;
	}

	public void setHangupFlag(String hangupFlag) {
		this.hangupFlag = hangupFlag;
	}

	public String getPaybackFlag() {
		return paybackFlag;
	}

	public void setPaybackFlag(String paybackFlag) {
		this.paybackFlag = paybackFlag;
	}

	public Double getChannelAdjustValue() {
		return channelAdjustValue;
	}

	public void setChannelAdjustValue(Double channelAdjustValue) {
		this.channelAdjustValue = channelAdjustValue;
	}

	public Double getAutonomyAdjustValue() {
		return autonomyAdjustValue;
	}

	public void setAutonomyAdjustValue(Double autonomyAdjustValue) {
		this.autonomyAdjustValue = autonomyAdjustValue;
	}

	public String getClauseType() {
		return clauseType;
	}

	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	public String getExtraComName() {
		return extraComName;
	}

	public void setExtraComName(String extraComName) {
		this.extraComName = extraComName;
	}

	public String getFactorPlaceCode() {
		return factorPlaceCode;
	}

	public void setFactorPlaceCode(String factorPlaceCode) {
		this.factorPlaceCode = factorPlaceCode;
	}

	public String getFactorPlaceName() {
		return factorPlaceName;
	}

	public void setFactorPlaceName(String factorPlaceName) {
		this.factorPlaceName = factorPlaceName;
	}

	public String getFycFlag() {
		return fycFlag;
	}

	public void setFycFlag(String fycFlag) {
		this.fycFlag = fycFlag;
	}

	public String getGovPurchaseFlag() {
		return govPurchaseFlag;
	}

	public void setGovPurchaseFlag(String govPurchaseFlag) {
		this.govPurchaseFlag = govPurchaseFlag;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getHandler1Name() {
		return handler1Name;
	}

	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}

	public String getHandler2Address() {
		return handler2Address;
	}

	public void setHandler2Address(String handler2Address) {
		this.handler2Address = handler2Address;
	}

	public String getHandler2Code() {
		return handler2Code;
	}

	public void setHandler2Code(String handler2Code) {
		this.handler2Code = handler2Code;
	}

	public String getHandler2Id() {
		return handler2Id;
	}

	public void setHandler2Id(String handler2Id) {
		this.handler2Id = handler2Id;
	}

	public String getHandler2IdType() {
		return handler2IdType;
	}

	public void setHandler2IdType(String handler2IdType) {
		this.handler2IdType = handler2IdType;
	}

	public String getHandler2Mobile() {
		return handler2Mobile;
	}

	public void setHandler2Mobile(String handler2Mobile) {
		this.handler2Mobile = handler2Mobile;
	}

	public String getHandler2Name() {
		return handler2Name;
	}

	public void setHandler2Name(String handler2Name) {
		this.handler2Name = handler2Name;
	}

	public String getHandler2Post() {
		return handler2Post;
	}

	public void setHandler2Post(String handler2Post) {
		this.handler2Post = handler2Post;
	}

	public String getHandlerIdentifyNumber() {
		return handlerIdentifyNumber;
	}

	public void setHandlerIdentifyNumber(String handlerIdentifyNumber) {
		this.handlerIdentifyNumber = handlerIdentifyNumber;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String getIntroducerId() {
		return introducerId;
	}

	public void setIntroducerId(String introducerId) {
		this.introducerId = introducerId;
	}

	public String getIntroducerName() {
		return introducerName;
	}

	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}

	public String getIsUndwrtFlag() {
		return isUndwrtFlag;
	}

	public void setIsUndwrtFlag(String isUndwrtFlag) {
		this.isUndwrtFlag = isUndwrtFlag;
	}

	public String getjFeeFlag() {
		return jFeeFlag;
	}

	public void setjFeeFlag(String jFeeFlag) {
		this.jFeeFlag = jFeeFlag;
	}

	public String getLastInsurerCode() {
		return lastInsurerCode;
	}

	public void setLastInsurerCode(String lastInsurerCode) {
		this.lastInsurerCode = lastInsurerCode;
	}

	public String getLastInsurerCom() {
		return lastInsurerCom;
	}

	public void setLastInsurerCom(String lastInsurerCom) {
		this.lastInsurerCom = lastInsurerCom;
	}

	public String getLastPrintNo() {
		return lastPrintNo;
	}

	public void setLastPrintNo(String lastPrintNo) {
		this.lastPrintNo = lastPrintNo;
	}

	public String getLockerCode() {
		return lockerCode;
	}

	public void setLockerCode(String lockerCode) {
		this.lockerCode = lockerCode;
	}

	public String getNationFlag() {
		return nationFlag;
	}

	public void setNationFlag(String nationFlag) {
		this.nationFlag = nationFlag;
	}

	public Date getNewEndDate() {
		return newEndDate;
	}

	public void setNewEndDate(Date newEndDate) {
		this.newEndDate = newEndDate;
	}

	public Date getNewStartDate() {
		return newStartDate;
	}

	public void setNewStartDate(Date newStartDate) {
		this.newStartDate = newStartDate;
	}

	public String getNotRenewalRegist() {
		return notRenewalRegist;
	}

	public void setNotRenewalRegist(String notRenewalRegist) {
		this.notRenewalRegist = notRenewalRegist;
	}

	public String getOperateWayFlag() {
		return operateWayFlag;
	}

	public void setOperateWayFlag(String operateWayFlag) {
		this.operateWayFlag = operateWayFlag;
	}

	public String getPayrefCode() {
		return payrefCode;
	}

	public void setPayrefCode(String payrefCode) {
		this.payrefCode = payrefCode;
	}

	public String getPayrefName() {
		return payrefName;
	}

	public void setPayrefName(String payrefName) {
		this.payrefName = payrefName;
	}

//	public Date getPayfefTime() {
//		return payfefTime;
//	}
//
//	public void setPayfefTime(Date payfefTime) {
//		this.payfefTime = payfefTime;
//	}

	public Date getPrecheckDate() {
		return precheckDate;
	}

	public void setPrecheckDate(Date precheckDate) {
		this.precheckDate = precheckDate;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public String getProjectsFlag() {
		return projectsFlag;
	}

	public void setProjectsFlag(String projectsFlag) {
		this.projectsFlag = projectsFlag;
	}

	public String getProposalLevel() {
		return proposalLevel;
	}

	public void setProposalLevel(String proposalLevel) {
		this.proposalLevel = proposalLevel;
	}

	public Date getRateEndDate() {
		return rateEndDate;
	}

	public void setRateEndDate(Date rateEndDate) {
		this.rateEndDate = rateEndDate;
	}

	public String getRatePeriod() {
		return ratePeriod;
	}

	public void setRatePeriod(String ratePeriod) {
		this.ratePeriod = ratePeriod;
	}

	public String getRatePeriodOld() {
		return ratePeriodOld;
	}

	public void setRatePeriodOld(String ratePeriodOld) {
		this.ratePeriodOld = ratePeriodOld;
	}

	public String getRatePeriodType() {
		return ratePeriodType;
	}

	public void setRatePeriodType(String ratePeriodType) {
		this.ratePeriodType = ratePeriodType;
	}

	public Date getRateStartDate() {
		return rateStartDate;
	}

	public void setRateStartDate(Date rateStartDate) {
		this.rateStartDate = rateStartDate;
	}

	public String getRsnNoRenewal() {
		return rsnNoRenewal;
	}

	public void setRsnNoRenewal(String rsnNoRenewal) {
		this.rsnNoRenewal = rsnNoRenewal;
	}

	public Integer getStartStages() {
		return startStages;
	}

	public void setStartStages(Integer startStages) {
		this.startStages = startStages;
	}

	public String getStopTimes() {
		return stopTimes;
	}

	public void setStopTimes(String stopTimes) {
		this.stopTimes = stopTimes;
	}

	public String getSubBusinessNature() {
		return subBusinessNature;
	}

	public void setSubBusinessNature(String subBusinessNature) {
		this.subBusinessNature = subBusinessNature;
	}

	public String getTradeVanId() {
		return tradeVanId;
	}

	public void setTradeVanId(String tradeVanId) {
		this.tradeVanId = tradeVanId;
	}

	public String getUndwrtMark() {
		return undwrtMark;
	}

	public void setUndwrtMark(String undwrtMark) {
		this.undwrtMark = undwrtMark;
	}

	public Integer getComCostPrem() {
		return comCostPrem;
	}

	public void setComCostPrem(Integer comCostPrem) {
		this.comCostPrem = comCostPrem;
	}

	public Integer getCtpCostPrem() {
		return ctpCostPrem;
	}

	public void setCtpCostPrem(Integer ctpCostPrem) {
		this.ctpCostPrem = ctpCostPrem;
	}

	public Integer getEntireCostDiscount() {
		return entireCostDiscount;
	}

	public void setEntireCostDiscount(Integer entireCostDiscount) {
		this.entireCostDiscount = entireCostDiscount;
	}

	public Integer getEntireRecommenDiscount() {
		return entireRecommenDiscount;
	}

	public void setEntireRecommenDiscount(Integer entireRecommenDiscount) {
		this.entireRecommenDiscount = entireRecommenDiscount;
	}

	public Integer getEntireExpDiscount() {
		return entireExpDiscount;
	}

	public void setEntireExpDiscount(Integer entireExpDiscount) {
		this.entireExpDiscount = entireExpDiscount;
	}

	public Integer getEntireUwritingDiscount() {
		return entireUwritingDiscount;
	}

	public void setEntireUwritingDiscount(Integer entireUwritingDiscount) {
		this.entireUwritingDiscount = entireUwritingDiscount;
	}

	public Double getOldAutonomyAdjustValue() {
		return oldAutonomyAdjustValue;
	}

	public void setOldAutonomyAdjustValue(Double oldAutonomyAdjustValue) {
		this.oldAutonomyAdjustValue = oldAutonomyAdjustValue;
	}

	public Double getOldChannelAdjustValue() {
		return oldChannelAdjustValue;
	}

	public void setOldChannelAdjustValue(Double oldChannelAdjustValue) {
		this.oldChannelAdjustValue = oldChannelAdjustValue;
	}

	public Double getOldDiscount() {
		return oldDiscount;
	}

	public void setOldDiscount(Double oldDiscount) {
		this.oldDiscount = oldDiscount;
	}

	public Double getHopeDiscount() {
		return hopeDiscount;
	}

	public void setHopeDiscount(Double hopeDiscount) {
		this.hopeDiscount = hopeDiscount;
	}

	public String getAdjustClaimReasonRate() {
		return adjustClaimReasonRate;
	}

	public void setAdjustClaimReasonRate(String adjustClaimReasonRate) {
		this.adjustClaimReasonRate = adjustClaimReasonRate;
	}

	public Integer getAdjustClaimReasonCode() {
		return adjustClaimReasonCode;
	}

	public void setAdjustClaimReasonCode(Integer adjustClaimReasonCode) {
		this.adjustClaimReasonCode = adjustClaimReasonCode;
	}

	public Double getChgSumDiscount() {
		return chgSumDiscount;
	}

	public void setChgSumDiscount(Double chgSumDiscount) {
		this.chgSumDiscount = chgSumDiscount;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	public Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}

	public void setSumNoTaxPremium(Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	}

	public Double getChgNoTaxPremium() {
		return chgNoTaxPremium;
	}

	public void setChgNoTaxPremium(Double chgNoTaxPremium) {
		this.chgNoTaxPremium = chgNoTaxPremium;
	}

	public Double getSumTaxFee() {
		return sumTaxFee;
	}

	public void setSumTaxFee(Double sumTaxFee) {
		this.sumTaxFee = sumTaxFee;
	}

	public Double getChgTaxFee() {
		return chgTaxFee;
	}

	public void setChgTaxFee(Double chgTaxFee) {
		this.chgTaxFee = chgTaxFee;
	}

	public String getIsThirdBusiness() {
		return isThirdBusiness;
	}

	public void setIsThirdBusiness(String isThirdBusiness) {
		this.isThirdBusiness = isThirdBusiness;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getIsRepairCode() {
		return isRepairCode;
	}

	public void setIsRepairCode(String isRepairCode) {
		this.isRepairCode = isRepairCode;
	}

	public String getRepairCode() {
		return repairCode;
	}

	public void setRepairCode(String repairCode) {
		this.repairCode = repairCode;
	}

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public String getWxChannelCode() {
		return wxChannelCode;
	}

	public void setWxChannelCode(String wxChannelCode) {
		this.wxChannelCode = wxChannelCode;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getInceptionFlag() {
		return inceptionFlag;
	}

	public void setInceptionFlag(String inceptionFlag) {
		this.inceptionFlag = inceptionFlag;
	}

	public String getNotificationFlag() {
		return notificationFlag;
	}

	public void setNotificationFlag(String notificationFlag) {
		this.notificationFlag = notificationFlag;
	}

	public String getAgentBusinessType() {
		return agentBusinessType;
	}

	public void setAgentBusinessType(String agentBusinessType) {
		this.agentBusinessType = agentBusinessType;
	}

	public String getAgentBusinessTypeName() {
		return agentBusinessTypeName;
	}

	public void setAgentBusinessTypeName(String agentBusinessTypeName) {
		this.agentBusinessTypeName = agentBusinessTypeName;
	}

	public Integer getCtpElr() {
		return ctpElr;
	}

	public void setCtpElr(Integer ctpElr) {
		this.ctpElr = ctpElr;
	}

	public Integer getComElr() {
		return comElr;
	}

	public void setComElr(Integer comElr) {
		this.comElr = comElr;
	}

	public Integer getElr() {
		return elr;
	}

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