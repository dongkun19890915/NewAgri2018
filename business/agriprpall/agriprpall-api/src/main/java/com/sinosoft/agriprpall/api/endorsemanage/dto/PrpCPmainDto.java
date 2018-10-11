package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016
 * 保单基本信息表Api操作对象
 */
public class PrpCPmainDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 属性保单号码/保单号码
	 */
	private String policyNo;
	/**
	 * 属性险类代码/险类代码
	 */
	private String classCode;
	/**
	 * 属性险种代码/险种代码
	 */
	private String riskCode;
	/**
	 * 属性投保单号/投保单号
	 */
	private String proposalNo;
	/**
	 * 属性合同号/合同号
	 */
	private String contractNo;
	/**
	 * 属性保单种类/保单种类
	 */
	private String policySort;
	/**
	 * 属性保单印刷号/保单印刷号
	 */
	private String printNo;
	/**
	 * 属性业务来源/业务来源
	 */
	private String businessNature;
	/**
	 * 属性语种标志/语种标志
	 */
	private String language;
	/**
	 * 属性保单类型/保单类型
	 */
	private String policyType;
	/**
	 * 属性投保人代码/投保人代码
	 */
	private String appliCode;
	/**
	 * 属性投保人名称/投保人名称
	 */
	private String appliName;
	/**
	 * 属性投保人地址/投保人地址
	 */
	private String appliAddress;
	/**
	 * 属性被保险人代码/被保险人代码
	 */
	private String insuredCode;
	/**
	 * 属性被保险人名称/被保险人名称
	 */
	private String insuredName;
	/**
	 * 属性被保险人地址/被保险人地址
	 */
	private String insuredAddress;
	/**
	 * 属性签单日期/签单日期
	 */
	private java.util.Date operateDate;
	/**
	 * 属性起保日期/起保日期
	 */
	private java.util.Date startDate;
	/**
	 * 属性起保小时/起保小时
	 */
	private Integer startHour;
	/**
	 * 属性终保日期/终保日期
	 */
	private java.util.Date endDate;
	/**
	 * 属性终保小时/终保小时
	 */
	private Integer endHour;
	/**
	 * 属性净费率/净费率
	 */
	private Double pureRate;
	/**
	 * 属性手续费比例/手续费比例
	 */
	private Double disRate;
	/**
	 * 属性总折扣率/总折扣率
	 */
	private Double discount;
	/**
	 * 属性币别代码/币别代码
	 */
	private String currency;
	/**
	 * 属性总保险价值/总保险价值
	 */
	private Double sumValue;
	/**
	 * 属性总保险金额/总保险金额
	 */
	private Double sumAmount;
	/**
	 * 属性总折扣金额/总折扣金额
	 */
	private Double sumDiscount;
	/**
	 * 属性总保险费/总保险费
	 */
	private Double sumPremium;
	/**
	 * 属性总附加保险费/总附加保险费
	 */
	private Double sumSubPrem;
	/**
	 * 属性被保险总数量/被保险总数量
	 */
	private Integer sumQuantity;
	/**
	 * 属性judicalCode/judicalCode
	 */
	private String judicalCode;
	/**
	 * 属性司法管辖/司法管辖
	 */
	private String judicalScope;
	/**
	 * 属性缴费方式/缴费方式
	 */
	private String autoTransRenewFlag;
	/**
	 * 属性争议解决方式/争议解决方式
	 */
	private String argueSolution;
	/**
	 * 属性仲裁委员会名称/仲裁委员会名称
	 */
	private String arbitBoardName;
	/**
	 * 属性约定分期缴费次数/约定分期缴费次数
	 */
	private Integer payTimes;
	/**
	 * 属性批改次数/批改次数
	 */
	private Integer endorseTimes;
	/**
	 * 属性理赔次数/理赔次数
	 */
	private Integer claimTimes;
	/**
	 * 属性出单机构/出单机构
	 */
	private String makeCom;
	/**
	 * 属性签单地点/签单地点
	 */
	private String operateSite;
	/**
	 * 属性业务归属机构代码/业务归属机构代码
	 */
	private String comCode;
	/**
	 * 属性经办人代码/经办人代码
	 */
	private String handlerCode;
	/**
	 * 属性归属业务员代码/归属业务员代码
	 */
	private String handler1Code;
	/**
	 * 属性复核人代码/复核人代码
	 */
	private String approverCode;
	/**
	 * 属性最终核保人代码/最终核保人代码
	 */
	private String underwriteCode;
	/**
	 * 属性最终核保人名称/最终核保人名称
	 */
	private String underwriteName;
	/**
	 * 属性操作员代码/操作员代码
	 */
	private String operatorCode;
	/**
	 * 属性计算机输单日期/计算机输单日期
	 */
	private java.util.Date inputDate;
	/**
	 * 属性计算机输单小时/计算机输单小时
	 */
	private Integer inputHour;
	/**
	 * 属性核保完成日期/核保完成日期
	 */
	private java.util.Date underwriteEndDate;
	/**
	 * 属性保单统计年月/保单统计年月
	 */
	private java.util.Date statisticSym;
	/**
	 * 属性代理人代码/代理人代码
	 */
	private String agentCode;
	/**
	 * 属性共保标志/共保标志
	 */
	private String coinsFlag;
	/**
	 * 属性商业分保标志/商业分保标志
	 */
	private String reinsFlag;
	/**
	 * 属性统保标志/统保标志
	 */
	private String allinsFlag;
	/**
	 * 属性核保标志/核保标志
	 */
	private String underwriteFlag;
	/**
	 * 属性其他标志字段/其他标志字段
	 */
	private String othFlag;
	/**
	 * 属性状态字段/状态字段
	 */
	private String flag;
	/**
	 * 属性超出部分手续费比例/超出部分手续费比例
	 */
	private Double disRate1;
	/**
	 * 属性业务类型/业务类型
	 */
	private String businessFlag;
	/**
	 * 属性updaterCode/updaterCode
	 */
	private String updaterCode;
	/**
	 * 属性updateDate/updateDate
	 */
	private java.util.Date updateDate;
	/**
	 * 属性updateHour/updateHour
	 */
	private String updateHour;
	/**
	 * 属性signDate/signDate
	 */
	private java.util.Date signDate;
	/**
	 * 属性shareHolderFlag/shareHolderFlag
	 */
	private String shareholderFlag;
	/**
	 * 属性agreementNo/agreementNo
	 */
	private String agreementNo;
	/**
	 * 属性inquiryNo/inquiryNo
	 */
	private String inquiryNo;
	/**
	 * 属性payMode/payMode
	 */
	private String payMode;
	/**
	 * 属性remark/remark
	 */
	private String remark;
	/**
	 * 属性visaCode/visaCode
	 */
	private String visaCode;
	/**
	 * 属性manualType/manualType
	 */
	private String manualType;
	/**
	 * 属性保单业务类型/保单业务类型
	 */
	private String policyBizType;
	/**
	 * 属性农业涉农非农标志/农业涉农非农标志
	 */
	private String businessType;
	/**
	 * 属性政策性标志/政策性标志
	 */
	private String businessType1;
	/**
	 * 属性承保数量的计算单位代码/承保数量的计算单位代码
	 */
	private String unitCode;
	/**
	 * 属性统计口径的承保数量/统计口径的承保数量
	 */
	private Double statQuantity;
	/**
	 * 属性统计口径的计量单位代码/统计口径的计量单位代码
	 */
	private String statUnitCode;
	/**
	 * 属性参保农户户次/参保农户户次
	 */
	private Double sumInsured;
	/**
	 * 属性专项业务：对应PrpDcode表的/专项业务：对应PrpDcode表的
	 */
	private String articleType;
	/**
	 * 属性归属区域：省/归属区域：省
	 */
	private String businessProvince;
	/**
	 * 属性归属区域：地市 /归属区域：地市
	 */
	private String businessTown;
	/**
	 * 属性归属区域：区县/归属区域：区县
	 */
	private String businessCounty;
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇
	 */
	private String businessAreaName;
	/**
	 * 属性批单打印日期/批单打印日期
	 */
	private java.util.Date printDate;
	/**
	 * 属性批单收费日期/批单收费日期
	 */
	private java.util.Date payDate;
	/**
	 * 属性起保分钟/起保分钟
	 */
	private Integer startMinute;
	/**
	 * 属性终保分钟/终保分钟
	 */
	private Integer endMinute;
	/**
	 * 属性每次事故责任限额/每次事故责任限额
	 */
	private Double limitAmount;
	/**
	 * 属性通过第三方识别 1 是2 否/通过第三方识别 1 是2 否
	 */
	private String thirdKnow;
	/**
	 * 属性agentRemark/agentRemark
	 */
	private String agentRemark;
	/**
	 * 属性nCarPerpFlag/nCarPerpFlag
	 */
	private String nCarPerpFlag;
	/**
	 * 属性大户归属区域/大户归属区域
	 */
	private String richflyAreasCode;
	/**
	 * 属性大户归属区域名称/大户归属区域名称
	 */
	private String richflyAreasCName;
	/**
	 * 属性大户编码/大户编码
	 */
	private String richflyCode;
	/**
	 * 属性大户名称/大户名称
	 */
	private String richflyCName;
	/**
	 * 属性GroupNo/GroupNo
	 */
	private String groupNo;
	/**
	 * 属性GroupFlag/GroupFlag
	 */
	private String groupFlag;
	/**
	 * 属性BasePerformanceRate/BasePerformanceRate
	 */
	private Double basePerformanceRate;
	/**
	 * 属性encouragePerformanceRate/encouragePerformanceRate
	 */
	private Double encouragePerformanceRate;
	/**
	 * 属性绩效总比例/绩效总比例
	 */
	private Double sumRate;
	/**
	 * 属性标准保费折算系数/标准保费折算系数
	 */
	private Double standardRate;
	/**
	 * 属性农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中/农险问卷标志 [0]对应的标志位未选中[1]对应的标志位选中
	 */
	private String agriFlag;
	/**
	 * 属性版本号/版本号
	 */
	private String versionNo;
	/**
	 * 属性大病医疗专项业务类型/大病医疗专项业务类型
	 */
	private String bigMedicalType;
	/**
	 * 属性盈利率,大病医疗/盈利率,大病医疗
	 */
	private String earningsRate;
	/**
	 * 属性共保业务保单缴费类型：1--全单/共保业务保单缴费类型：1--全单
	 */
	private String coinsPremiumType;
	/**
	 * 属性businessCity/businessCity
	 */
	private String businessCity;
	/**
	 * 属性allianCreate/allianCreate
	 */
	private Double allianceRate;
	/**
	 * 属性出单点出单标志/出单点出单标志
	 */
	private String eccFlag;
	/**
	 * 属性出单点试算单号/出单点试算单号
	 */
	private String ssProposalNo;
	/**
	 * 属性业务年度/业务年度
	 */
	private String businessYear;
	/**
	 * 属性统筹区/统筹区
	 */
	private String makeArea;
	/**
	 * 属性归属区域：村/归属区域：村
	 */
	private String businessArea;
	/**
	 * 属性inputTime/inputTime
	 */
	private String inputTime;
	/**
	 * 属性saveTime/saveTime
	 */
	private String saveTime;
	/**
	 * 属性saleName/saleName
	 */
	private String saleName;
	/**
	 * 属性salePhone/salePhone
	 */
	private String salePhone;
	/**
	 * 属性saleComCode/saleComCode
	 */
	private String saleComCode;
	/**
	 * 属性saleComName/saleComName
	 */
	private String saleComName;
	/**
	 * 属性saleComAddress/saleComAddress
	 */
	private String saleComAddress;
	/**
	 * 属性saleAgentAddress/saleAgentAddress
	 */
	private String saleAgentAddress;
	/**
	 * 属性saleAgentPersonName/saleAgentPersonName
	 */
	private String saleAgentPersonName;
	/**
	 * 属性saleAgentPersonId/saleAgentPersonId
	 */
	private String saleAgentPersonId;
	/**
	 * 属性saleAgentPersonNo/saleAgentPersonNo
	 */
	private String saleAgentPermitNo;
	/**
	 * 属性exchangeRate/exchangeRate
	 */
	private Double exchangeRate;
	/**
	 * 属性extraComCode/extraComCode
	 */
	private String extraComCode;
	/**
	 * 属性extraComName/extraComName
	 */
	private String extraComName;
	/**
	 * 属性factorPlaceCode/factorPlaceCode
	 */
	private String factorPlaceCode;
	/**
	 * 属性factorPlaceName/factorPlaceName
	 */
	private String factorPlaceName;
	/**
	 * 属性fycFlag/fycFlag
	 */
	private String fycFlag;
	/**
	 * 属性govPurchaseFlag/govPurchaseFlag
	 */
	private String govPurchaseFlag;
	/**
	 * 属性groupType/groupType
	 */
	private String groupType;
	/**
	 * 属性handler2Name/handler2Name
	 */
	private String handler1Name;
	/**
	 * 属性bizNoSysFlag/bizNoSysFlag
	 */
	private String bizNoSysFlag;
	/**
	 * 属性businessRecMark/businessRecMark
	 */
	private String businessRecMark;
	/**
	 * 属性businessTypeFlag/businessTypeFlag
	 */
	private String businessTypeFlag;
	/**
	 * 属性caseNo/caseNo
	 */
	private String caseNo;
	/**
	 * 属性channelCode/channelCode
	 */
	private String channelCode;
	/**
	 * 属性channelType/channelType
	 */
	private String channelType;
	/**
	 * 属性contributionLevel/contributionLevel
	 */
	private String contributionLevel;
	/**
	 * 属性declareFlag/declareFlag
	 */
	private String declareFlag;
	/**
	 * 属性editFlag/editFlag
	 */
	private String editFlag;
	/**
	 * 属性effectiveImmediatelyFlag/effectiveImmediatelyFlag
	 */
	private String effectiveImmediatelyFlag;
	/**
	 * 属性nationFlag/nationFlag
	 */
	private String nationFlag;
	/**
	 * 属性newEndDate/newEndDate
	 */
	private java.util.Date newEndDate;
	/**
	 * 属性newStartDate/newStartDate
	 */
	private java.util.Date newStartDate;
	/**
	 * 属性notreNewAlRegist/notreNewAlRegist
	 */
	private String notRenewalRegist;
	/**
	 * 属性operateWayFlag/operateWayFlag
	 */
	private String operateWayFlag;
	/**
	 * 属性payrefCode/payrefCode
	 */
	private String payrefCode;
	/**
	 * 属性payrefName/payrefName
	 */
	private String payrefName;
	/**
	 * 属性systemFlag/systemFlag
	 */
	private String systemFlag;
	/**
	 * 属性agent2Code/agent2Code
	 */
	private String agent1Code;
	/**
	 * 属性agent2Name/agent2Name
	 */
	private String agent1Name;
	/**
	 * 属性agentMaxComission/agentMaxComission
	 */
	private Double agentMaxComission;
	/**
	 * 属性agentName/agentName
	 */
	private String agentName;
	/**
	 * 属性agentTypeNo/agentTypeNo
	 */
	private String agentTypeNo;
	/**
	 * 属性introducerId/introducerId
	 */
	private String introducerId;
	/**
	 * 属性introducerName/introducerName
	 */
	private String introducerName;
	/**
	 * 属性isUndwrtFlag/isUndwrtFlag
	 */
	private String isUndwrtFlag;
	/**
	 * 属性jfeePayType/jfeePayType
	 */
	private String jFeePayType;
	/**
	 * 属性lastInsurerCode/lastInsurerCode
	 */
	private String lastInsurerCode;
	/**
	 * 属性lastInsurerCom/lastInsurerCom
	 */
	private String lastInsurerCom;
	/**
	 * 属性lastPrintNo/lastPrintNo
	 */
	private String lastPrintNo;
	/**
	 * 属性lockerCode/lockerCode
	 */
	private String lockerCode;
	/**
	 * 属性handler3Address/handler3Address
	 */
	private String handler2Address;
	/**
	 * 属性handler3Code/handler3Code
	 */
	private String handler2Code;
	/**
	 * 属性handler3Id/handler3Id
	 */
	private String handler2Id;
	/**
	 * 属性handler3IdType/handler3IdType
	 */
	private String handler2IdType;
	/**
	 * 属性handler3Mobile/handler3Mobile
	 */
	private String handler2Mobile;
	/**
	 * 属性handler3Name/handler3Name
	 */
	private String handler2Name;
	/**
	 * 属性handler3Post/handler3Post
	 */
	private String handler2Post;
	/**
	 * 属性handlerIdentifyNumber/handlerIdentifyNumber
	 */
	private String handlerIdentifyNumber;
	/**
	 * 属性handlerName/handlerName
	 */
	private String handlerName;
	/**
	 * 属性effectFlag/effectFlag
	 */
	private String effectFlag;
	/**
	 * 属性agentClass/agentClass
	 */
	private String agentClass;
	/**
	 * 属性topCommisionRate/topCommisionRate
	 */
	private String topCommisionRate;
	/**
	 * 属性intCommisionRate/intCommisionRate
	 */
	private String intCommisionRate;
	/**
	 * 属性validTime/validTime
	 */
	private String validTime;
	/**
	 * 属性localModelDiscountZ/localModelDiscountZ
	 */
	private Double localModelDiscountZ;
	/**
	 * 属性localModelPremium/localModelPremium
	 */
	private Double localModelPremium;
	/**
	 * 属性localModelDiscountQ/localModelDiscountQ
	 */
	private Double localModelDiscountQ;
	/**
	 * 属性typeFgEditFlag/typeFgEditFlag
	 */
	private String typeFgEditFlag;
	/**
	 * 属性inputType/inputType
	 */
	private String inputType;
	/**
	 * 属性specialBusinessNo/specialBusinessNo
	 */
	private String specialBusinessNo;
	/**
	 * 属性periodFlag/periodFlag
	 */
	private String periodFlag;
	/**
	 * 属性hangupFlag/hangupFlag
	 */
	private String hangupFlag;
	/**
	 * 属性installMentFlag/installMentFlag
	 */
	private String installmentFlag;
	/**
	 * 属性payBackFlag/payBackFlag
	 */
	private String paybackFlag;
	/**
	 * 属性channelAdjustValue/channelAdjustValue
	 */
	private Double channelAdjustValue;
	/**
	 * 属性autoNoMyAdjustValue/autoNoMyAdjustValue
	 */
	private Double autonomyAdjustValue;
	/**
	 * 属性clauseType/clauseType
	 */
	private String clauseType;
	/**
	 * 属性preInvoiceFlag/preInvoiceFlag
	 */
	private String preInvoiceFlag;
	/**
	 * 属性miFlag/miFlag
	 */
	private String miFlag;
	/**
	 * 属性submitUndwrtFlag/submitUndwrtFlag
	 */
	private String submitUndwrtFlag;
	/**
	 * 属性startStages/startStages
	 */
	private Integer startStages;
	/**
	 * 属性stopTimes/stopTimes
	 */
	private String stopTimes;
	/**
	 * 属性subBusinessNature/subBusinessNature
	 */
	private String subBusinessNature;
	/**
	 * 属性tradeVanId/tradeVanId
	 */
	private String tradeVanId;
	/**
	 * 属性undwrtMark/undwrtMark
	 */
	private String undwrtMark;
	/**
	 * 属性rsnNoreNewAl/rsnNoreNewAl
	 */
	private String rsnNoRenewal;
	/**
	 * 属性preCheckDate/preCheckDate
	 */
	private java.util.Date precheckDate;
	/**
	 * 属性printTime/printTime
	 */
	private java.util.Date printTime;
	/**
	 * 属性projectsFlag/projectsFlag
	 */
	private String projectsFlag;
	/**
	 * 属性proposalLevel/proposalLevel
	 */
	private String proposalLevel;
	/**
	 * 属性rateEndDate/rateEndDate
	 */
	private java.util.Date rateEndDate;
	/**
	 * 属性ratePeriod/ratePeriod
	 */
	private String ratePeriod;
	/**
	 * 属性ratePeriodOld/ratePeriodOld
	 */
	private String ratePeriodOld;
	/**
	 * 属性ratePeriodType/ratePeriodType
	 */
	private String ratePeriodType;
	/**
	 * 属性rateStartDate/rateStartDate
	 */
	private java.util.Date rateStartDate;
	/**
	 * 属性agriType/agriType
	 */
	private String agriType;
	/**
	 * 属性assignNo/assignNo
	 */
	private String assignNo;
	/**
	 * 属性bankCode/bankCode
	 */
	private String bankCode;
	/**
	 * 属性bankFlag/bankFlag
	 */
	private String bankFlag;
	/**
	 * 属性comCostPrem/comCostPrem
	 */
	private Integer comCostPrem;
	/**
	 * 属性ctpCostPrem/ctpCostPrem
	 */
	private Integer ctpCostPrem;
	/**
	 * 属性entireCostDiscount/entireCostDiscount
	 */
	private Integer entireCostDiscount;
	/**
	 * 属性entireRecommenDiscount/entireRecommenDiscount
	 */
	private Integer entireRecommenDiscount;
	/**
	 * 属性entireExpDiscount/entireExpDiscount
	 */
	private Integer entireExpDiscount;
	/**
	 * 属性entireUwritingDiscount/entireUwritingDiscount
	 */
	private Integer entireUwritingDiscount;
	/**
	 * 属性oldAutoNoMyAdjustValue/oldAutoNoMyAdjustValue
	 */
	private Double oldAutonomyAdjustValue;
	/**
	 * 属性oldChannelAdjustValue/oldChannelAdjustValue
	 */
	private Double oldChannelAdjustValue;
	/**
	 * 属性oldDiscount/oldDiscount
	 */
	private Double oldDiscount;
	/**
	 * 属性hopeDiscount/hopeDiscount
	 */
	private Double hopeDiscount;
	/**
	 * 属性adjustClaimReasonRate/adjustClaimReasonRate
	 */
	private Integer adjustClaimReasonRate;
	/**
	 * 属性adjustClaimReasonCode/adjustClaimReasonCode
	 */
	private String adjustClaimReasonCode;
	/**
	 * 属性总不含税保费/总不含税保费
	 */
	private Double sumNoTaxPremium;
	/**
	 * 属性总税额/总税额
	 */
	private Double sumTaxFee;
	/**
	 * 属性isThirdBusiness/isThirdBusiness
	 */
	private String isThirdBusiness;
	/**
	 * 属性recordCode/recordCode
	 */
	private String recordCode;
	/**
	 * 属性税种属性0-营业税 1-增值税/税种属性0-营业税 1-增值税
	 */
	private String taxType;
	/**
	 * 属性是否推荐修理厂/是否推荐修理厂
	 */
	private String isRepairCode;
	/**
	 * 属性推荐修理厂代码 /推荐修理厂代码
	 */
	private String repairCode;
	/**
	 * 属性推荐修理厂名称 /推荐修理厂名称
	 */
	private String repairName;
	/**
	 * 属性wxChannelCode/wxChannelCode
	 */
	private String wxChannelCode;
	/**
	 * 属性isOnline/isOnline
	 */
	private String isOnline;
	/**
	 * 属性isCustomer/isCustomer
	 */
	private String isCustomer;
	/**
	 * 属性营销员类型/行业类别代码/营销员类型/行业类别代码
	 */
	private String agentBusinessType;
	/**
	 * 属性营销员类型/行业类别名称/营销员类型/行业类别名称
	 */
	private String agentBusinessTypeName;
	/**
	 * 属性是否承保公示/是否承保公示
	 */
	private String notificationFlag;
	/**
	 * 属性是否验标/是否验标
	 */
	private String inceptionFlag;
	/**
	 * 属性交强险预期赔付率/交强险预期赔付率
	 */
	private Integer ctpElr;
	/**
	 * 属性商业险预期赔付率/商业险预期赔付率
	 */
	private Integer comElr;
	/**
	 * 属性整单预期赔付率/整单预期赔付率
	 */
	private Integer elr;
	private Date payrefTime;

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

	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}

	public String getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
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

	public String getSaleAgentPermitNo() {
		return saleAgentPermitNo;
	}

	public void setSaleAgentPermitNo(String saleAgentPermitNo) {
		this.saleAgentPermitNo = saleAgentPermitNo;
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

	public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
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

	public String getjFeePayType() {
		return jFeePayType;
	}

	public void setjFeePayType(String jFeePayType) {
		this.jFeePayType = jFeePayType;
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

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
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

	public Double getLocalModelDiscountQ() {
		return localModelDiscountQ;
	}

	public void setLocalModelDiscountQ(Double localModelDiscountQ) {
		this.localModelDiscountQ = localModelDiscountQ;
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

	public String getInstallmentFlag() {
		return installmentFlag;
	}

	public void setInstallmentFlag(String installmentFlag) {
		this.installmentFlag = installmentFlag;
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

	public String getPreInvoiceFlag() {
		return preInvoiceFlag;
	}

	public void setPreInvoiceFlag(String preInvoiceFlag) {
		this.preInvoiceFlag = preInvoiceFlag;
	}

	public String getMiFlag() {
		return miFlag;
	}

	public void setMiFlag(String miFlag) {
		this.miFlag = miFlag;
	}

	public String getSubmitUndwrtFlag() {
		return submitUndwrtFlag;
	}

	public void setSubmitUndwrtFlag(String submitUndwrtFlag) {
		this.submitUndwrtFlag = submitUndwrtFlag;
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

	public String getRsnNoRenewal() {
		return rsnNoRenewal;
	}

	public void setRsnNoRenewal(String rsnNoRenewal) {
		this.rsnNoRenewal = rsnNoRenewal;
	}

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

	public Integer getAdjustClaimReasonRate() {
		return adjustClaimReasonRate;
	}

	public void setAdjustClaimReasonRate(Integer adjustClaimReasonRate) {
		this.adjustClaimReasonRate = adjustClaimReasonRate;
	}

	public String getAdjustClaimReasonCode() {
		return adjustClaimReasonCode;
	}

	public void setAdjustClaimReasonCode(String adjustClaimReasonCode) {
		this.adjustClaimReasonCode = adjustClaimReasonCode;
	}

	public Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}

	public void setSumNoTaxPremium(Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	}

	public Double getSumTaxFee() {
		return sumTaxFee;
	}

	public void setSumTaxFee(Double sumTaxFee) {
		this.sumTaxFee = sumTaxFee;
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

	public String getNotificationFlag() {
		return notificationFlag;
	}

	public void setNotificationFlag(String notificationFlag) {
		this.notificationFlag = notificationFlag;
	}

	public String getInceptionFlag() {
		return inceptionFlag;
	}

	public void setInceptionFlag(String inceptionFlag) {
		this.inceptionFlag = inceptionFlag;
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

	public Date getPayrefTime() {
		return payrefTime;
	}

	public void setPayrefTime(Date payrefTime) {
		this.payrefTime = payrefTime;
	}

}
