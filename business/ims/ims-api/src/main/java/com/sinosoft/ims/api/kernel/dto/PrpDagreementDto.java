package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 代理协议表Api操作对象
 */
public class PrpDagreementDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代理人代码/代理人代码 */
	private String agentCode ;		
	/** 属性协议代码/协议代码 */
	private String agreementNo ;		
	/** 属性signDate/signDate */
	private java.util.Date signDate ;		
	/** 属性startDate/startDate */
	private java.util.Date startDate ;		
	/** 属性endDate/endDate */
	private java.util.Date endDate ;		
	/** 属性settleCycle/settleCycle */
	private java.lang.Integer settleCycle ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性comCode/comCode */
	private String comCode ;		
	/** 属性lowerViewFlag/lowerViewFlag */
	private String lowerViewFlag ;		
	/** 属性createrCode/createrCode */
	private String createrCode ;		
	/** 属性createTime/createTime */
	private String createTime ;		
	/** 属性updaterCode/updaterCode */
	private String updaterCode ;		
	/** 属性updateDate/updateDate */
	private String updateDate ;		
	/** 属性结算日期（预借发票的时候用）/结算日期（预借发票的时候用） */
	private java.lang.Integer settleDay ;		
	/** 属性url/url */
	private String url ;		
	/** 属性userCode/userCode */
	private String userCode ;		
	/** 属性userName/userName */
	private String userName ;		
	/** 属性handlerCode/handlerCode */
	private String handlerCode ;		
	/** 属性handlerName/handlerName */
	private String handlerName ;		
	/** 属性agreementFileName/agreementFileName */
	private String agreementFileName ;		
	/** 属性overDueDayCount/overDueDayCount */
	private java.lang.Integer overDueDayCount ;		
	/** 属性overDueDayCountSet/overDueDayCountSet */
	private java.lang.Integer overDueDayCountSet ;		
	/** 属性maxOverDueRate/maxOverDueRate */
	private java.lang.Double maxOverDueRate ;		
	/** 属性maxOverDueRateSet/maxOverDueRateSet */
	private java.lang.Integer maxOverDueRateSet ;		
	/** 属性maxOverDueCycle/maxOverDueCycle */
	private java.lang.Integer maxOverDueCycle ;		
	/** 属性maxOverDueCycleSet/maxOverDueCycleSet */
	private java.lang.Integer maxOverDueCycleSet ;		
	/** 属性maxOverDueCount/maxOverDueCount */
	private java.lang.Integer maxOverDueCount ;		
	/** 属性maxOverDueCountSet/maxOverDueCountSet */
	private java.lang.Integer maxOverDueCountSet ;		
	/** 属性maxOverDueFee/maxOverDueFee */
	private java.lang.Double maxOverDueFee ;		
	/** 属性maxOverDueFeeSet/maxOverDueFeeSet */
	private java.lang.Integer maxOverDueFeeSet ;		
	/** 属性overDueRate/overDueRate */
	private java.lang.Double overDueRate ;		
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
	 * 属性协议代码/协议代码的getter方法
	 */
	public String getAgreementNo() {
		return agreementNo;
	}
	/**
	 * 属性协议代码/协议代码的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
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
	 * 属性startDate/startDate的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性startDate/startDate的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}	
	/**
	 * 属性endDate/endDate的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性endDate/endDate的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}	
	/**
	 * 属性settleCycle/settleCycle的getter方法
	 */
	public java.lang.Integer getSettleCycle() {
		return settleCycle;
	}
	/**
	 * 属性settleCycle/settleCycle的setter方法
	 */
	public void setSettleCycle(java.lang.Integer settleCycle) {
		this.settleCycle = settleCycle;
	}	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性lowerViewFlag/lowerViewFlag的getter方法
	 */
	public String getLowerViewFlag() {
		return lowerViewFlag;
	}
	/**
	 * 属性lowerViewFlag/lowerViewFlag的setter方法
	 */
	public void setLowerViewFlag(String lowerViewFlag) {
		this.lowerViewFlag = lowerViewFlag;
	}	
	/**
	 * 属性createrCode/createrCode的getter方法
	 */
	public String getCreaterCode() {
		return createrCode;
	}
	/**
	 * 属性createrCode/createrCode的setter方法
	 */
	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}	
	/**
	 * 属性createTime/createTime的getter方法
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 属性createTime/createTime的setter方法
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性结算日期（预借发票的时候用）/结算日期（预借发票的时候用）的getter方法
	 */
	public java.lang.Integer getSettleDay() {
		return settleDay;
	}
	/**
	 * 属性结算日期（预借发票的时候用）/结算日期（预借发票的时候用）的setter方法
	 */
	public void setSettleDay(java.lang.Integer settleDay) {
		this.settleDay = settleDay;
	}	
	/**
	 * 属性url/url的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性url/url的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	}	
	/**
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性userName/userName的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性userName/userName的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	/**
	 * 属性handlerCode/handlerCode的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性handlerCode/handlerCode的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性handlerName/handlerName的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性handlerName/handlerName的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性agreementFileName/agreementFileName的getter方法
	 */
	public String getAgreementFileName() {
		return agreementFileName;
	}
	/**
	 * 属性agreementFileName/agreementFileName的setter方法
	 */
	public void setAgreementFileName(String agreementFileName) {
		this.agreementFileName = agreementFileName;
	}	
	/**
	 * 属性overDueDayCount/overDueDayCount的getter方法
	 */
	public java.lang.Integer getOverDueDayCount() {
		return overDueDayCount;
	}
	/**
	 * 属性overDueDayCount/overDueDayCount的setter方法
	 */
	public void setOverDueDayCount(java.lang.Integer overDueDayCount) {
		this.overDueDayCount = overDueDayCount;
	}	
	/**
	 * 属性overDueDayCountSet/overDueDayCountSet的getter方法
	 */
	public java.lang.Integer getOverDueDayCountSet() {
		return overDueDayCountSet;
	}
	/**
	 * 属性overDueDayCountSet/overDueDayCountSet的setter方法
	 */
	public void setOverDueDayCountSet(java.lang.Integer overDueDayCountSet) {
		this.overDueDayCountSet = overDueDayCountSet;
	}	
	/**
	 * 属性maxOverDueRate/maxOverDueRate的getter方法
	 */
	public java.lang.Double getMaxOverDueRate() {
		return maxOverDueRate;
	}
	/**
	 * 属性maxOverDueRate/maxOverDueRate的setter方法
	 */
	public void setMaxOverDueRate(java.lang.Double maxOverDueRate) {
		this.maxOverDueRate = maxOverDueRate;
	}	
	/**
	 * 属性maxOverDueRateSet/maxOverDueRateSet的getter方法
	 */
	public java.lang.Integer getMaxOverDueRateSet() {
		return maxOverDueRateSet;
	}
	/**
	 * 属性maxOverDueRateSet/maxOverDueRateSet的setter方法
	 */
	public void setMaxOverDueRateSet(java.lang.Integer maxOverDueRateSet) {
		this.maxOverDueRateSet = maxOverDueRateSet;
	}	
	/**
	 * 属性maxOverDueCycle/maxOverDueCycle的getter方法
	 */
	public java.lang.Integer getMaxOverDueCycle() {
		return maxOverDueCycle;
	}
	/**
	 * 属性maxOverDueCycle/maxOverDueCycle的setter方法
	 */
	public void setMaxOverDueCycle(java.lang.Integer maxOverDueCycle) {
		this.maxOverDueCycle = maxOverDueCycle;
	}	
	/**
	 * 属性maxOverDueCycleSet/maxOverDueCycleSet的getter方法
	 */
	public java.lang.Integer getMaxOverDueCycleSet() {
		return maxOverDueCycleSet;
	}
	/**
	 * 属性maxOverDueCycleSet/maxOverDueCycleSet的setter方法
	 */
	public void setMaxOverDueCycleSet(java.lang.Integer maxOverDueCycleSet) {
		this.maxOverDueCycleSet = maxOverDueCycleSet;
	}	
	/**
	 * 属性maxOverDueCount/maxOverDueCount的getter方法
	 */
	public java.lang.Integer getMaxOverDueCount() {
		return maxOverDueCount;
	}
	/**
	 * 属性maxOverDueCount/maxOverDueCount的setter方法
	 */
	public void setMaxOverDueCount(java.lang.Integer maxOverDueCount) {
		this.maxOverDueCount = maxOverDueCount;
	}	
	/**
	 * 属性maxOverDueCountSet/maxOverDueCountSet的getter方法
	 */
	public java.lang.Integer getMaxOverDueCountSet() {
		return maxOverDueCountSet;
	}
	/**
	 * 属性maxOverDueCountSet/maxOverDueCountSet的setter方法
	 */
	public void setMaxOverDueCountSet(java.lang.Integer maxOverDueCountSet) {
		this.maxOverDueCountSet = maxOverDueCountSet;
	}	
	/**
	 * 属性maxOverDueFee/maxOverDueFee的getter方法
	 */
	public java.lang.Double getMaxOverDueFee() {
		return maxOverDueFee;
	}
	/**
	 * 属性maxOverDueFee/maxOverDueFee的setter方法
	 */
	public void setMaxOverDueFee(java.lang.Double maxOverDueFee) {
		this.maxOverDueFee = maxOverDueFee;
	}	
	/**
	 * 属性maxOverDueFeeSet/maxOverDueFeeSet的getter方法
	 */
	public java.lang.Integer getMaxOverDueFeeSet() {
		return maxOverDueFeeSet;
	}
	/**
	 * 属性maxOverDueFeeSet/maxOverDueFeeSet的setter方法
	 */
	public void setMaxOverDueFeeSet(java.lang.Integer maxOverDueFeeSet) {
		this.maxOverDueFeeSet = maxOverDueFeeSet;
	}	
	/**
	 * 属性overDueRate/overDueRate的getter方法
	 */
	public java.lang.Double getOverDueRate() {
		return overDueRate;
	}
	/**
	 * 属性overDueRate/overDueRate的setter方法
	 */
	public void setOverDueRate(java.lang.Double overDueRate) {
		this.overDueRate = overDueRate;
	}	
}
