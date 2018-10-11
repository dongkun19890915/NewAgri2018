package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDtoExt;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

/**
 * @description: 类功能简述：报案初始化返参对象，用于页面展示
 * @author 安齐崇
 * @date 2017年11月28日下午5:59:11
 *
 */
public class RegistPageResDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 工作流id */
	private String swfLogFlowID;
	/** 工作流序号 */
	private String swfLogLogNo;
	/** 模板好 */
	private String modelNo;
	/** 节点号 */
	private String nodeNo;
	/** 报案状态 */
	private String status;
	/** 登录用户编码 */
	private String userCode;
	/* //登录用户所属机构 */
	private String comCode;
	/** 编辑类型 */
	private String editType;
	/** 险种类型 */
	private String riskType;
	/** 险种代码 */
	private String riskCode;
	/** 险种名称 */
	private String riskCName;
	/** 报案号 */
	private String registNo;
	/** 节点类型*/
	private String nodeType;
	/** 节点名称*/
	private String nodeName;
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/* 保单校验信息 */
	private String message;
	/** 保单号 */
	private String policyNo;
	/** 缴费码 */
	private int intPayFee;
	/* 分期未缴费期数 */
	private String delinquentfeeCase;
	/** 被保险人代码 */
	private String insuredCode;
	/** 被保险人名称 */
	private String insuredName;
	/** 已出险次数 */
	private String perilCount;
	/*********** 保险期间 *****************/
	/** 起保日期 */
	private String startDate;
	/** 起保小时 */
	private String startHour;
	/** 终保日期 */
	private String endDate;
	/** 终保小时 */
	private String endHour;
	/*********** 输单日期及报案日期 *****************/
	/* 输单日期 */
	private String inputDate;
	/**************** 出险时间 **************************/
	private String strDamageDate;
	private String StrDamageHour;
	private String StrDamageMin;
	/*耳标号1，有0无*/
	private String earFlag;
	/** 获取报案出险延期天数 */
	private String configValue;
	/** 承保数量*/
	private String statQuantity;
	/** 工作流信息 */
	private SwfPathDtoExt swfPathDto;
	/** 报案登记信息 */
	private PrpLRegistDtoExt prpLregistDto;
	/*养殖险耳标号*/
	private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
	/** 理赔状态信息*/
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/** 调度主表信息*/
	private PrpLScheduleMainWfDto prpLScheduleMainWfDto;
	/** 调度详细信息*/
	private List<PrpLScheduleItemDto> prplScheduleItemDtoList;
	private List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList;
	/** 保单大对象，如果有批单进行批单回倒*/
	private ResponseQueryPolicyInfoDto policyDto;
	
	public String getStatQuantity() {
		return statQuantity;
	}
	public void setStatQuantity(String statQuantity) {
		this.statQuantity = statQuantity;
	}
	public ResponseQueryPolicyInfoDto getPolicyDto() {
		return policyDto;
	}
	public void setPolicyDto(ResponseQueryPolicyInfoDto policyDto) {
		this.policyDto = policyDto;
	}
	public List<PrpLRegistRPolicyDto> getPrpLRegistRPolicyDtoList() {
		return prpLRegistRPolicyDtoList;
	}
	public void setPrpLRegistRPolicyDtoList(List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList) {
		this.prpLRegistRPolicyDtoList = prpLRegistRPolicyDtoList;
	}
	public PrpLScheduleMainWfDto getPrpLScheduleMainWfDto() {
		return prpLScheduleMainWfDto;
	}
	public void setPrpLScheduleMainWfDto(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
		this.prpLScheduleMainWfDto = prpLScheduleMainWfDto;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public List<PrpLScheduleItemDto> getPrplScheduleItemDtoList() {
		return prplScheduleItemDtoList;
	}
	public void setPrplScheduleItemDtoList(List<PrpLScheduleItemDto> prplScheduleItemDtoList) {
		this.prplScheduleItemDtoList = prplScheduleItemDtoList;
	}
	public String getEarFlag() {
		return earFlag;
	}
	public void setEarFlag(String earFlag) {
		this.earFlag = earFlag;
	}
	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}
	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}
	public String getSwfLogLogNo() {
		return swfLogLogNo;
	}
	public void setSwfLogLogNo(String swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRiskCName() {
		return riskCName;
	}
	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public int getIntPayFee() {
		return intPayFee;
	}
	public void setIntPayFee(int intPayFee) {
		this.intPayFee = intPayFee;
	}
	public String getDelinquentfeeCase() {
		return delinquentfeeCase;
	}
	public void setDelinquentfeeCase(String delinquentfeeCase) {
		this.delinquentfeeCase = delinquentfeeCase;
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
	public String getPerilCount() {
		return perilCount;
	}
	public void setPerilCount(String perilCount) {
		this.perilCount = perilCount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getStrDamageDate() {
		return strDamageDate;
	}
	public void setStrDamageDate(String strDamageDate) {
		this.strDamageDate = strDamageDate;
	}
	public String getStrDamageHour() {
		return StrDamageHour;
	}
	public void setStrDamageHour(String strDamageHour) {
		StrDamageHour = strDamageHour;
	}
	public String getStrDamageMin() {
		return StrDamageMin;
	}
	public void setStrDamageMin(String strDamageMin) {
		StrDamageMin = strDamageMin;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public SwfPathDtoExt getSwfPathDto() {
		return swfPathDto;
	}
	public void setSwfPathDto(SwfPathDtoExt swfPathDto) {
		this.swfPathDto = swfPathDto;
	}
	public PrpLRegistDtoExt getPrpLregistDto() {
		return prpLregistDto;
	}
	public void setPrpLregistDto(PrpLRegistDtoExt prpLregistDto) {
		this.prpLregistDto = prpLregistDto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
