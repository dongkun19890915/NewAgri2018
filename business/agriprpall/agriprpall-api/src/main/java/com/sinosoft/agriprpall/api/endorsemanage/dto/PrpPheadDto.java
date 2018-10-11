package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 06:30:52.642 
 * 批改信息表Api操作对象
 */
public class PrpPheadDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性批单印刷号/批单印刷号 */
	private String printNo ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性保单批改次数/保单批改次数 */
	private Integer endorseTimes ;
	/** 属性出单机构代码/出单机构代码 */
	private String makeCom ;		
	/** 属性赔款计算书号/赔款计算书号 */
	private String compensateNo ;		
	/** 属性被保险人代码/被保险人代码 */
	private String insuredCode ;		
	/** 属性被保险人名字/被保险人名字 */
	private String insuredName ;		
	/** 属性中英文/中英文 */
	private String language ;		
	/** 属性保单类型/保单类型 */
	private String policyType ;		
	/** 属性批改类型/批改类型 */
	private String endorType ;		
	/** 属性批改日期/批改日期 */
	private java.util.Date endorDate ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性生效小时/生效小时 */
	private Integer validHour ;
	/** 属性经办人代码/经办人代码 */
	private String handlerCode ;		
	/** 属性归属业务员代码/归属业务员代码 */
	private String handler1Code ;		
	/** 属性复核人代码/复核人代码 */
	private String approverCode ;		
	/** 属性最终核批人代码/最终核批人代码 */
	private String underwriteCode ;
	/** 属性最终核批人名称/最终核批人名称 */
	private String underwriteName ;
	/** 属性操作员代码/操作员代码 */
	private String operatorCode;
	/** 属性计算机输单日期/计算机输单日期 */
	private java.util.Date inputDate ;		
	/** 属性计算机输单小时/计算机输单小时 */
	private Integer inputHour ;
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;		
	/** 属性代理人代码/代理人代码 */
	private String agentCode ;		
	/** 属性批单统计年月/批单统计年月 */
	private java.util.Date statisticSym ;		
	/** 属性核批完成日期/核批完成日期 */
	private java.util.Date underwriteEndDate ;
	/** 属性核批标志/核批标志 */
	private String underwriteFlag ;
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性updaterCode/updaterCode */
	private String updaterCode ;		
	/** 属性updateDate/updateDate */
	private java.util.Date updateDate ;
	/** 属性updateHour/updateHour */
	private String updateHour ;		
	/** 属性批单打印日期/批单打印日期 */
	private java.util.Date printDate ;		
	/** 属性批单收费日期/批单收费日期 */
	private java.util.Date payDate ;		
	/** 属性批改申请人/批改申请人 */
	private String appliName ;		
	/** 属性车险车主变更类型/车险车主变更类型 */
	private String ownerChgType ;		
	/** 属性批改原因/批改原因 */
	private String endorseType ;		
	/** 属性批改原因描述/批改原因描述 */
	private String endorseMessage ;		
	/** 属性见费出单标志/见费出单标志 */
	private String isSeeFeeFlag ;		
	/** 属性统计日期/统计日期 */
	private java.util.Date validCountDate ;		
	/** 属性版本号/版本号 */
	private String versionNo ;		
	/** 属性生效分钟/生效分钟 */
	private Integer validMinute ;
	/** 属性是否收取手续费/是否收取手续费 */
	private String isCommission ;		
	/** 属性是否全程批改/是否全程批改 */
	private String isFullEndor ;		
	/** 属性agentFlag/agentFlag */
	private String agentFlag ;		
	/** 属性批改类型组/批改类型组 */
	private String arrayEndorType ;		
	/** 属性clFlag/clFlag */
	private String clFlag ;		
	/** 属性endorReason/endorReason */
	private String endorReason ;		
	/** 属性归属业务员姓名/归属业务员姓名 */
	private String handler1Name ;		
	/** 属性经办人姓名/经办人姓名 */
	private String handlerName ;		
	/** 属性期限平移保单终期/期限平移保单终期 */
	private java.util.Date moveEndDate ;		
	/** 属性保险期限平移标识/保险期限平移标识 */
	private String moveFlag ;		
	/** 属性期限平移保单起期/期限平移保单起期 */
	private java.util.Date moveStartDate ;		
	/** 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型 */
	private java.util.Date newValidDate ;		
	/** 属性业务实收确认人代码单号/业务实收确认人代码单号 */
	private String payrefCode ;		
	/** 属性payrefName/payrefName */
	private String payrefName ;		
	/** 属性预审核时间/预审核时间 */
	private java.util.Date precheckDate ;
	/** 属性signDate/signDate */
	private java.util.Date signDate ;		
	/** 属性备用/备用 */
	private String subBusinessNature ;		
	/** 属性单证号码/单证号码 */
	private String visaCode ;		
	/** 属性validTime/validTime */
	private String validTime ;		
	/** 属性jFeeFlag/jFeeFlag */
	private String jFeeFlag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/** 属性cancelReasonDate/cancelReasonDate */
	private java.util.Date cancelReasonDate ;
	private String batchNo;

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * 批文
	 */
	private String endorseTexts;
	private String riskName;
	private String operatorName ;

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getEndorseTexts() {
		return endorseTexts;
	}

	public void setEndorseTexts(String endorseTexts) {
		this.endorseTexts = endorseTexts;
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

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
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
	public java.util.Date getEndorDate() {
		return endorDate;
	}
	/**
	 * 属性批改日期/批改日期的setter方法
	 */
	public void setEndorDate(java.util.Date endorDate) {
		this.endorDate = endorDate;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
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
	 * 属性批单打印日期/批单打印日期的getter方法
	 */
	public java.util.Date getPrintDate() {
		return printDate;
	}
	/**
	 * 属性批单打印日期/批单打印日期的setter方法
	 */
	public void setPrintDate(java.util.Date printDate) {
		this.printDate = printDate;
	}	
	/**
	 * 属性批单收费日期/批单收费日期的getter方法
	 */
	public java.util.Date getPayDate() {
		return payDate;
	}
	/**
	 * 属性批单收费日期/批单收费日期的setter方法
	 */
	public void setPayDate(java.util.Date payDate) {
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
	public java.util.Date getMoveEndDate() {
		return moveEndDate;
	}
	/**
	 * 属性期限平移保单终期/期限平移保单终期的setter方法
	 */
	public void setMoveEndDate(java.util.Date moveEndDate) {
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
	public java.util.Date getMoveStartDate() {
		return moveStartDate;
	}
	/**
	 * 属性期限平移保单起期/期限平移保单起期的setter方法
	 */
	public void setMoveStartDate(java.util.Date moveStartDate) {
		this.moveStartDate = moveStartDate;
	}	
	/**
	 * 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型的getter方法
	 */
	public java.util.Date getNewValidDate() {
		return newValidDate;
	}
	/**
	 * 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型的setter方法
	 */
	public void setNewValidDate(java.util.Date newValidDate) {
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
	 * 属性cancelReasonDate/cancelReasonDate的getter方法
	 */
	public java.util.Date getCancelReasonDate() {
		return cancelReasonDate;
	}
	/**
	 * 属性cancelReasonDate/cancelReasonDate的setter方法
	 */
	public void setCancelReasonDate(java.util.Date cancelReasonDate) {
		this.cancelReasonDate = cancelReasonDate;
	}	

}
