package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.util.Date;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;

/**
 * @description: 类功能简述：扩展类
 * @author 安齐崇
 * @date 2017年11月26日下午4:50:24
 *
 */
public class PrpLClaimDtoExt  {

	private static final long serialVersionUID = 1L;
	
	private PrpLClaimDto prpLClaimDto;
	/*查勘案件的操作时间*/
	private String operateDate;
	/*立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
	private String status;
	 /**报案时间 */
	private String reportDate;
	/*条款名称*/
	private String clauseType;
	private  String riskName;
	/*业务归属机构名称*/
	private String comName;
	/*g归属业务员名称*/
	private String handler1Name;
	/*代理人姓名*/
	private String agentName;
	/*经办人姓名*/
	private String handlerName;
	/*案件性质名称*/
	private String claimTypeName;
	/*理赔登记部门名称*/
	private String makeComName;
	/*接报案员*/
	private String operatorName;
	/*条款名称*/
	private String clauseName;
	/*业务类型名称*/
	private String businessNatureName;
	/*投保人展示使用*/
	private String insuredNameShow;
	/*币别中文名*/
	private String currencyName;
	
	private  String damageStartMinute;
	
	public String getDamageStartMinute() {
		return damageStartMinute;
	}
	public void setDamageStartMinute(String damageStartMinute) {
		this.damageStartMinute = damageStartMinute;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getInsuredNameShow() {
		return insuredNameShow;
	}
	public void setInsuredNameShow(String insuredNameShow) {
		this.insuredNameShow = insuredNameShow;
	}
	public String getBusinessNatureName() {
		return businessNatureName;
	}
	public void setBusinessNatureName(String businessNatureName) {
		this.businessNatureName = businessNatureName;
	}
	public String getClauseName() {
		return clauseName;
	}
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	}
	public String getClauseType() {
		return clauseType;
	}
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getHandler1Name() {
		return handler1Name;
	}
	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getClaimTypeName() {
		return claimTypeName;
	}
	public void setClaimTypeName(String claimTypeName) {
		this.claimTypeName = claimTypeName;
	}
	public String getMakeComName() {
		return makeComName;
	}
	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
    
}
