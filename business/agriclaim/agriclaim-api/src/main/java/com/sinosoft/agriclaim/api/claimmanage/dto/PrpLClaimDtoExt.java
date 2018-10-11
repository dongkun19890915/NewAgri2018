package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.util.Date;

/**
 * @description: 类功能简述：扩展类
 * @author 安齐崇
 * @date 2017年11月26日下午4:50:24
 *
 */
public class PrpLClaimDtoExt extends PrpLClaimDto {

	private static final long serialVersionUID = 1L;
	/*查勘案件的操作时间*/
	private String operateDate;
	/*立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
	private String status;
	 /**报案时间 */
	private Date reportDate;
	/*条款名称*/
	private String clauseType;
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
	/*属性理赔标志*/
	private String llflag;
	/*属性出险开始分钟*/
    private String damageStartMinute;
    /*属性出险结束分钟*/
    private String damageEndMinute;
    /*属性处理人员姓名*/
    private String dealerName;
	private PrpLClaimDto prpLClaimDto;
	private String lossCode;

	public String getLossCode() {
		return lossCode;
	}

	public void setLossCode(String lossCode) {
		this.lossCode = lossCode;
	}

	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}

	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}

	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getLlflag() {
		return llflag;
	}
	public void setLlflag(String llflag) {
		this.llflag = llflag;
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
    public String getDamageStartMinute() {
        return damageStartMinute;
    }
    public void setDamageStartMinute(String damageStartMinute) {
        this.damageStartMinute = damageStartMinute;
    }
    public String getDamageEndMinute() {
        return damageEndMinute;
    }
    public void setDamageEndMinute(String damageEndMinute) {
        this.damageEndMinute = damageEndMinute;
    }
    public String getDealerName() {
        return dealerName;
    }
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    
}
