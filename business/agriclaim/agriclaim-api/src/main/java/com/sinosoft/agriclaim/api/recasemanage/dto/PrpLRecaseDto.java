package com.sinosoft.agriclaim.api.recasemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * 重开赔案表Api操作对象
 */
public class PrpLRecaseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性重开赔案次数/重开赔案次数 */
	private java.lang.Integer serialNo ;		
	/** 属性重开赔案人代码/重开赔案人代码 */
	private String opencaseuserCode ;		
	/** 属性重开赔案日期/重开赔案日期 */
	private java.util.Date opencaseDate ;		
	/** 属性本次结案人代码/本次结案人代码 */
	private String closeCaseuserCode ;		
	/** 属性本次结案日期/本次结案日期 */
	private java.util.Date closeCaseDate ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性重开赔案原因/重开赔案原因 */
	private String recaseReason ;		
	/** 属性重开赔案金额/重开赔案金额 */
	private java.lang.Double recaseMoney ;		
	/** 属性重开赔案标志/重开赔案标志 */
	private String recaseUploadFlag ;		
	/** 属性审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开)/审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开) */
	private String undwrtFlag ;		
	/** 属性审核日期/审核日期 */
	private java.util.Date undwrtDate ;		
	/** 属性审核人代码/审核人代码 */
	private String undwrtCode ;		
	/** 属性重开赔案次数(根据报案号重开的次数)/重开赔案次数(根据报案号重开的次数) */
	private java.lang.Integer recaseTime ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/** 属性赔款计算书号码/赔款计算书号码 */
	private String compensateNo ;		
	/** 属性当前节点号/当前节点号 */
	private java.lang.Integer nodeNo ;		
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}	
	/**
	 * 属性重开赔案次数/重开赔案次数的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性重开赔案次数/重开赔案次数的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性重开赔案人代码/重开赔案人代码的getter方法
	 */
	public String getOpencaseuserCode() {
		return opencaseuserCode;
	}
	/**
	 * 属性重开赔案人代码/重开赔案人代码的setter方法
	 */
	public void setOpencaseuserCode(String opencaseuserCode) {
		this.opencaseuserCode = opencaseuserCode;
	}	
	/**
	 * 属性重开赔案日期/重开赔案日期的getter方法
	 */
	public java.util.Date getOpencaseDate() {
		return opencaseDate;
	}
	/**
	 * 属性重开赔案日期/重开赔案日期的setter方法
	 */
	public void setOpencaseDate(java.util.Date opencaseDate) {
		this.opencaseDate = opencaseDate;
	}	
	/**
	 * 属性本次结案人代码/本次结案人代码的getter方法
	 */
	public String getCloseCaseuserCode() {
		return closeCaseuserCode;
	}
	/**
	 * 属性本次结案人代码/本次结案人代码的setter方法
	 */
	public void setCloseCaseuserCode(String closeCaseuserCode) {
		this.closeCaseuserCode = closeCaseuserCode;
	}	
	/**
	 * 属性本次结案日期/本次结案日期的getter方法
	 */
	public java.util.Date getCloseCaseDate() {
		return closeCaseDate;
	}
	/**
	 * 属性本次结案日期/本次结案日期的setter方法
	 */
	public void setCloseCaseDate(java.util.Date closeCaseDate) {
		this.closeCaseDate = closeCaseDate;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性重开赔案原因/重开赔案原因的getter方法
	 */
	public String getRecaseReason() {
		return recaseReason;
	}
	/**
	 * 属性重开赔案原因/重开赔案原因的setter方法
	 */
	public void setRecaseReason(String recaseReason) {
		this.recaseReason = recaseReason;
	}	
	/**
	 * 属性重开赔案金额/重开赔案金额的getter方法
	 */
	public java.lang.Double getRecaseMoney() {
		return recaseMoney;
	}
	/**
	 * 属性重开赔案金额/重开赔案金额的setter方法
	 */
	public void setRecaseMoney(java.lang.Double recaseMoney) {
		this.recaseMoney = recaseMoney;
	}	
	/**
	 * 属性重开赔案标志/重开赔案标志的getter方法
	 */
	public String getRecaseUploadFlag() {
		return recaseUploadFlag;
	}
	/**
	 * 属性重开赔案标志/重开赔案标志的setter方法
	 */
	public void setRecaseUploadFlag(String recaseUploadFlag) {
		this.recaseUploadFlag = recaseUploadFlag;
	}	
	/**
	 * 属性审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开)/审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开)的getter方法
	 */
	public String getUndwrtFlag() {
		return undwrtFlag;
	}
	/**
	 * 属性审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开)/审核标志 (1：审核通过；3：审核回退；9：待审核；6：放弃重开)的setter方法
	 */
	public void setUndwrtFlag(String undwrtFlag) {
		this.undwrtFlag = undwrtFlag;
	}	
	/**
	 * 属性审核日期/审核日期的getter方法
	 */
	public java.util.Date getUndwrtDate() {
		return undwrtDate;
	}
	/**
	 * 属性审核日期/审核日期的setter方法
	 */
	public void setUndwrtDate(java.util.Date undwrtDate) {
		this.undwrtDate = undwrtDate;
	}	
	/**
	 * 属性审核人代码/审核人代码的getter方法
	 */
	public String getUndwrtCode() {
		return undwrtCode;
	}
	/**
	 * 属性审核人代码/审核人代码的setter方法
	 */
	public void setUndwrtCode(String undwrtCode) {
		this.undwrtCode = undwrtCode;
	}	
	/**
	 * 属性重开赔案次数(根据报案号重开的次数)/重开赔案次数(根据报案号重开的次数)的getter方法
	 */
	public java.lang.Integer getRecaseTime() {
		return recaseTime;
	}
	/**
	 * 属性重开赔案次数(根据报案号重开的次数)/重开赔案次数(根据报案号重开的次数)的setter方法
	 */
	public void setRecaseTime(java.lang.Integer recaseTime) {
		this.recaseTime = recaseTime;
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
	 * 属性赔款计算书号码/赔款计算书号码的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号码/赔款计算书号码的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}	
	/**
	 * 属性当前节点号/当前节点号的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性当前节点号/当前节点号的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	}	
}
