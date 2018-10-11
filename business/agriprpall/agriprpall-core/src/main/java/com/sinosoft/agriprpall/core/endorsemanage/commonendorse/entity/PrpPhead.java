package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 批改信息表1实体操作对象
 */
@Entity
@Table(name = "PrpPhead")
@IdClass(PrpPheadKey.class)
public class PrpPhead extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性批改类型组/批改类型组 */
	@Column(name = "arrayEndorType")
	private String arrayEndorType ;	

	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性批单印刷号/批单印刷号 */
	@Column(name = "printNo")
	private String printNo ;
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单批改次数/保单批改次数 */
	@Column(name = "endorseTimes")
	private Integer endorseTimes ;
	/** 属性出单机构代码/出单机构代码 */
	@Column(name = "makeCom")
	private String makeCom ;
	/** 属性赔款计算书号/赔款计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性被保险人代码/被保险人代码 */
	@Column(name = "insuredCode")
	private String insuredCode ;
	/** 属性被保险人名字/被保险人名字 */
	@Column(name = "insuredName")
	private String insuredName ;
	/** 属性中英文/中英文 */
	@Column(name = "language")
	private String language ;
	/** 属性保单类型/保单类型 */
	@Column(name = "policyType")
	private String policyType ;
	/** 属性批改类型/批改类型 */
	@Column(name = "endorType")
	private String endorType ;
	/** 属性批改日期/批改日期 */
	@Column(name = "endorDate")
	private Date endorDate ;
	/** 属性生效日期/生效日期 */
	@Column(name = "validDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validDate ;
	/** 属性生效小时/生效小时 */
	@Column(name = "validHour")
	private Integer validHour ;
	/** 属性经办人代码/经办人代码 */
	@Column(name = "handlerCode")
	private String handlerCode ;
	/** 属性归属业务员代码/归属业务员代码 */
	@Column(name = "handler1Code")
	private String handler1Code ;
	/** 属性复核人代码/复核人代码 */
	@Column(name = "approverCode")
	private String approverCode ;
	/** 属性最终核批人代码/最终核批人代码 */
	@Column(name = "underwriteCode")
	private String underwriteCode ;
	/** 属性最终核批人名称/最终核批人名称 */
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
	/** 属性业务归属机构代码/业务归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性代理人代码/代理人代码 */
	@Column(name = "agentCode")
	private String agentCode ;
	/** 属性批单统计年月/批单统计年月 */
	@Column(name = "statisticSym")
	private Date statisticSym ;
	/** 属性核批完成日期/核批完成日期 */
	@Column(name = "underwriteEndDate")
	private Date underwriteEndDate ;
	/** 属性核批标志/核批标志 */
	@Column(name = "underwriteFlag")
	private String underwriteFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性updaterCode/updaterCode */
	@Column(name = "updaterCode")
	private String updaterCode ;
	/** 属性updateDate/updateDate */
	@Column(name = "updateDate")
	private Date updateDate ;
	/** 属性updateHour/updateHour */
	@Column(name = "updateHour")
	private String updateHour ;
	/** 属性批单打印日期/批单打印日期 */
	@Column(name = "printDate")
	private Date printDate ;
	/** 属性批单收费日期/批单收费日期 */
	@Column(name = "payDate")
	private Date payDate ;
	/** 属性批改申请人/批改申请人 */
	@Column(name = "appliName")
	private String appliName ;
	/** 属性车险车主变更类型/车险车主变更类型 */
	@Column(name = "ownerChgType")
	private String ownerChgType ;
	/** 属性批改原因/批改原因 */
	@Column(name = "endorseType")
	private String endorseType ;
	/** 属性批改原因描述/批改原因描述 */
	@Column(name = "endorseMessage")
	private String endorseMessage ;
	/** 属性见费出单标志/见费出单标志 */
	@Column(name = "isSeeFeeFlag")
	private String isSeeFeeFlag ;
	/** 属性统计日期/统计日期 */
	@Column(name = "validCountDate")
	private Date validCountDate ;
	/** 属性版本号/版本号 */
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性生效分钟/生效分钟 */
	@Column(name = "validMinute")
	private Integer validMinute ;
	/** 属性是否收取手续费/是否收取手续费 */
	@Column(name = "isCommission")
	private String isCommission ;
	/** 属性是否全程批改/是否全程批改 */
	@Column(name = "isFullEndor")
	private String isFullEndor ;
	/** 属性agentFlag/agentFlag */
	@Column(name = "agentFlag")
	private String agentFlag ;

	/** 属性clFlag/clFlag */
	@Column(name = "clFlag")
	private String clFlag ;
	/** 属性endorReason/endorReason */
	@Column(name = "endorReason")
	private String endorReason ;
	/** 属性归属业务员姓名/归属业务员姓名 */
	@Column(name = "handler1Name")
	private String handler1Name ;
	/** 属性经办人姓名/经办人姓名 */
	@Column(name = "handlerName")
	private String handlerName ;
	/** 属性期限平移保单终期/期限平移保单终期 */
	@Column(name = "moveEndDate")
	private Date moveEndDate ;
	/** 属性保险期限平移标识/保险期限平移标识 */
	@Column(name = "moveFlag")
	private String moveFlag ;
	/** 属性期限平移保单起期/期限平移保单起期 */
	@Column(name = "moveStartDate")
	private Date moveStartDate ;
	/** 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型 */
	@Column(name = "newValidDate")
	private Date newValidDate ;
	/** 属性业务实收确认人代码单号/业务实收确认人代码单号 */
	@Column(name = "payrefCode")
	private String payrefCode ;
	/** 属性payrefName/payrefName */
	@Column(name = "payrefName")
	private String payrefName ;
	/** 属性预审核时间/预审核时间 */
	@Column(name = "precheckDate")
	private Date precheckDate ;
	/** 属性signDate/signDate */
	@Column(name = "signDate")
	private Date signDate ;
	/** 属性备用/备用 */
	@Column(name = "subBusinessNature")
	private String subBusinessNature ;
	/** 属性单证号码/单证号码 */
	@Column(name = "visaCode")
	private String visaCode ;
	/** 属性validTime/validTime */
	@Column(name = "validTime")
	private String validTime ;
	/** 属性jFeeFlag/jFeeFlag */
	@Column(name = "jFeeFlag")
	private String jFeeFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间1/修改时间1 */
	@Column(name = "update_Date")
	private Date update_Date ;
	/** 属性cancelReasonDate/cancelReasonDate */
	@Column(name = "cancelReasonDate")
	private Date cancelReasonDate ;
	@Column(name = "batchNo")
	private String batchNo ;

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	 * 属性批单印刷号/批单印刷号的getter方法
	 */
	public String getPrintNo() {
		return printNo;
	}
	/**
	 * 属性批单印刷号/批单印刷号的setter方法
	 */
	public void setPrintNo(String printNo) {
		this.printNo = printNo;
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
	 * 属性保单批改次数/保单批改次数的getter方法
	 */
	public Integer getEndorseTimes() {
		return endorseTimes;
	}
	/**
	 * 属性保单批改次数/保单批改次数的setter方法
	 */
	public void setEndorseTimes(Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	} 	
	/**
	 * 属性出单机构代码/出单机构代码的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性出单机构代码/出单机构代码的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	} 	
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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
	 * 属性被保险人名字/被保险人名字的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人名字/被保险人名字的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	} 	
	/**
	 * 属性中英文/中英文的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性中英文/中英文的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	} 	
	/**
	 * 属性保单类型/保单类型的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性保单类型/保单类型的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	} 	
	/**
	 * 属性批改类型/批改类型的getter方法
	 */
	public String getEndorType() {
		return endorType;
	}
	/**
	 * 属性批改类型/批改类型的setter方法
	 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	} 	
	/**
	 * 属性批改日期/批改日期的getter方法
	 */
	public Date getEndorDate() {
		return endorDate;
	}
	/**
	 * 属性批改日期/批改日期的setter方法
	 */
	public void setEndorDate(Date endorDate) {
		this.endorDate = endorDate;
	} 	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	} 	
	/**
	 * 属性生效小时/生效小时的getter方法
	 */
	public Integer getValidHour() {
		return validHour;
	}
	/**
	 * 属性生效小时/生效小时的setter方法
	 */
	public void setValidHour(Integer validHour) {
		this.validHour = validHour;
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
	 * 属性复核人代码/复核人代码的getter方法
	 */
	public String getApproverCode() {
		return approverCode;
	}
	/**
	 * 属性复核人代码/复核人代码的setter方法
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
	 * 属性批单统计年月/批单统计年月的getter方法
	 */
	public Date getStatisticSym() {
		return statisticSym;
	}
	/**
	 * 属性批单统计年月/批单统计年月的setter方法
	 */
	public void setStatisticSym(Date statisticSym) {
		this.statisticSym = statisticSym;
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
	 * 属性批改申请人/批改申请人的getter方法
	 */
	public String getAppliName() {
		return appliName;
	}
	/**
	 * 属性批改申请人/批改申请人的setter方法
	 */
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	} 	
	/**
	 * 属性车险车主变更类型/车险车主变更类型的getter方法
	 */
	public String getOwnerChgType() {
		return ownerChgType;
	}
	/**
	 * 属性车险车主变更类型/车险车主变更类型的setter方法
	 */
	public void setOwnerChgType(String ownerChgType) {
		this.ownerChgType = ownerChgType;
	} 	
	/**
	 * 属性批改原因/批改原因的getter方法
	 */
	public String getEndorseType() {
		return endorseType;
	}
	/**
	 * 属性批改原因/批改原因的setter方法
	 */
	public void setEndorseType(String endorseType) {
		this.endorseType = endorseType;
	} 	
	/**
	 * 属性批改原因描述/批改原因描述的getter方法
	 */
	public String getEndorseMessage() {
		return endorseMessage;
	}
	/**
	 * 属性批改原因描述/批改原因描述的setter方法
	 */
	public void setEndorseMessage(String endorseMessage) {
		this.endorseMessage = endorseMessage;
	} 	
	/**
	 * 属性见费出单标志/见费出单标志的getter方法
	 */
	public String getIsSeeFeeFlag() {
		return isSeeFeeFlag;
	}
	/**
	 * 属性见费出单标志/见费出单标志的setter方法
	 */
	public void setIsSeeFeeFlag(String isSeeFeeFlag) {
		this.isSeeFeeFlag = isSeeFeeFlag;
	} 	
	/**
	 * 属性统计日期/统计日期的getter方法
	 */
	public Date getValidCountDate() {
		return validCountDate;
	}
	/**
	 * 属性统计日期/统计日期的setter方法
	 */
	public void setValidCountDate(Date validCountDate) {
		this.validCountDate = validCountDate;
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
	 * 属性生效分钟/生效分钟的getter方法
	 */
	public Integer getValidMinute() {
		return validMinute;
	}
	/**
	 * 属性生效分钟/生效分钟的setter方法
	 */
	public void setValidMinute(Integer validMinute) {
		this.validMinute = validMinute;
	} 	
	/**
	 * 属性是否收取手续费/是否收取手续费的getter方法
	 */
	public String getIsCommission() {
		return isCommission;
	}
	/**
	 * 属性是否收取手续费/是否收取手续费的setter方法
	 */
	public void setIsCommission(String isCommission) {
		this.isCommission = isCommission;
	} 	
	/**
	 * 属性是否全程批改/是否全程批改的getter方法
	 */
	public String getIsFullEndor() {
		return isFullEndor;
	}
	/**
	 * 属性是否全程批改/是否全程批改的setter方法
	 */
	public void setIsFullEndor(String isFullEndor) {
		this.isFullEndor = isFullEndor;
	} 	
	/**
	 * 属性agentFlag/agentFlag的getter方法
	 */
	public String getAgentFlag() {
		return agentFlag;
	}
	/**
	 * 属性agentFlag/agentFlag的setter方法
	 */
	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	} 	
	/**
	 * 属性批改类型组/批改类型组的getter方法
	 */
	public String getArrayEndorType() {
		return arrayEndorType;
	}
	/**
	 * 属性批改类型组/批改类型组的setter方法
	 */
	public void setArrayEndorType(String arrayEndorType) {
		this.arrayEndorType = arrayEndorType;
	} 	
	/**
	 * 属性clFlag/clFlag的getter方法
	 */
	public String getClFlag() {
		return clFlag;
	}
	/**
	 * 属性clFlag/clFlag的setter方法
	 */
	public void setClFlag(String clFlag) {
		this.clFlag = clFlag;
	} 	
	/**
	 * 属性endorReason/endorReason的getter方法
	 */
	public String getEndorReason() {
		return endorReason;
	}
	/**
	 * 属性endorReason/endorReason的setter方法
	 */
	public void setEndorReason(String endorReason) {
		this.endorReason = endorReason;
	} 	
	/**
	 * 属性归属业务员姓名/归属业务员姓名的getter方法
	 */
	public String getHandler1Name() {
		return handler1Name;
	}
	/**
	 * 属性归属业务员姓名/归属业务员姓名的setter方法
	 */
	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	} 	
	/**
	 * 属性经办人姓名/经办人姓名的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性经办人姓名/经办人姓名的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	} 	
	/**
	 * 属性期限平移保单终期/期限平移保单终期的getter方法
	 */
	public Date getMoveEndDate() {
		return moveEndDate;
	}
	/**
	 * 属性期限平移保单终期/期限平移保单终期的setter方法
	 */
	public void setMoveEndDate(Date moveEndDate) {
		this.moveEndDate = moveEndDate;
	} 	
	/**
	 * 属性保险期限平移标识/保险期限平移标识的getter方法
	 */
	public String getMoveFlag() {
		return moveFlag;
	}
	/**
	 * 属性保险期限平移标识/保险期限平移标识的setter方法
	 */
	public void setMoveFlag(String moveFlag) {
		this.moveFlag = moveFlag;
	} 	
	/**
	 * 属性期限平移保单起期/期限平移保单起期的getter方法
	 */
	public Date getMoveStartDate() {
		return moveStartDate;
	}
	/**
	 * 属性期限平移保单起期/期限平移保单起期的setter方法
	 */
	public void setMoveStartDate(Date moveStartDate) {
		this.moveStartDate = moveStartDate;
	} 	
	/**
	 * 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型的getter方法
	 */
	public Date getNewValidDate() {
		return newValidDate;
	}
	/**
	 * 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型的setter方法
	 */
	public void setNewValidDate(Date newValidDate) {
		this.newValidDate = newValidDate;
	} 	
	/**
	 * 属性业务实收确认人代码单号/业务实收确认人代码单号的getter方法
	 */
	public String getPayrefCode() {
		return payrefCode;
	}
	/**
	 * 属性业务实收确认人代码单号/业务实收确认人代码单号的setter方法
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

	public Date getPrecheckDate() {
		return precheckDate;
	}

	public void setPrecheckDate(Date precheckDate) {
		this.precheckDate = precheckDate;
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
	 * 属性备用/备用的getter方法
	 */
	public String getSubBusinessNature() {
		return subBusinessNature;
	}
	/**
	 * 属性备用/备用的setter方法
	 */
	public void setSubBusinessNature(String subBusinessNature) {
		this.subBusinessNature = subBusinessNature;
	} 	
	/**
	 * 属性单证号码/单证号码的getter方法
	 */
	public String getVisaCode() {
		return visaCode;
	}
	/**
	 * 属性单证号码/单证号码的setter方法
	 */
	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
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
	 * 属性jFeeFlag/jFeeFlag的getter方法
	 */
	public String getJFeeFlag() {
		return jFeeFlag;
	}
	/**
	 * 属性jFeeFlag/jFeeFlag的setter方法
	 */
	public void setJFeeFlag(String jFeeFlag) {
		this.jFeeFlag = jFeeFlag;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getjFeeFlag() {
		return jFeeFlag;
	}

	public void setjFeeFlag(String jFeeFlag) {
		this.jFeeFlag = jFeeFlag;
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

	/**
	 * 属性修改时间1/修改时间1的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间1/修改时间1的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 	
	/**
	 * 属性cancelReasonDate/cancelReasonDate的getter方法
	 */
	public Date getCancelReasonDate() {
		return cancelReasonDate;
	}
	/**
	 * 属性cancelReasonDate/cancelReasonDate的setter方法
	 */
	public void setCancelReasonDate(Date cancelReasonDate) {
		this.cancelReasonDate = cancelReasonDate;
	}

}