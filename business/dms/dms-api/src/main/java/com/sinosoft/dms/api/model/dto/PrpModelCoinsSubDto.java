package com.sinosoft.dms.api.model.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板共保信息表Api操作对象
 */
public class PrpModelCoinsSubDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板号码/模板号码 */
	private String modelCode ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性主保单号码/主保单号码 */
	private String mainPolicyNo ;		
	/** 属性共保人机构代码/共保人机构代码 */
	private String coinsCode ;		
	/** 属性共保人名称/共保人名称 */
	private String coinsName ;		
	/** 属性共保份额/共保份额 */
	private String coinsType ;		
	/** 属性共保类型/共保类型 */
	private Double coinsRate ;
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性首席标志/首席标志 */
	private String chiefFlag ;		
	/** 属性分摊标志/分摊标志 */
	private String proportionFlag ;		
	/** 属性共保协议号/共保协议号 */
	private String coinsTreatyNo ;		
	/** 属性分保类型/分保类型 */
	private String coinsFlag ;		
	/** 属性业务类型 /业务类型  */
	private String reinsciFlag ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/**
	 * 属性模板号码/模板号码的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * 属性模板号码/模板号码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性主保单号码/主保单号码的getter方法
	 */
	public String getMainPolicyNo() {
		return mainPolicyNo;
	}
	/**
	 * 属性主保单号码/主保单号码的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	}	
	/**
	 * 属性共保人机构代码/共保人机构代码的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性共保人机构代码/共保人机构代码的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}	
	/**
	 * 属性共保人名称/共保人名称的getter方法
	 */
	public String getCoinsName() {
		return coinsName;
	}
	/**
	 * 属性共保人名称/共保人名称的setter方法
	 */
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	}	
	/**
	 * 属性共保份额/共保份额的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	}	
	/**
	 * 属性共保类型/共保类型的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保类型/共保类型的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
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
	 * 属性首席标志/首席标志的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性首席标志/首席标志的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	}	
	/**
	 * 属性分摊标志/分摊标志的getter方法
	 */
	public String getProportionFlag() {
		return proportionFlag;
	}
	/**
	 * 属性分摊标志/分摊标志的setter方法
	 */
	public void setProportionFlag(String proportionFlag) {
		this.proportionFlag = proportionFlag;
	}	
	/**
	 * 属性共保协议号/共保协议号的getter方法
	 */
	public String getCoinsTreatyNo() {
		return coinsTreatyNo;
	}
	/**
	 * 属性共保协议号/共保协议号的setter方法
	 */
	public void setCoinsTreatyNo(String coinsTreatyNo) {
		this.coinsTreatyNo = coinsTreatyNo;
	}	
	/**
	 * 属性分保类型/分保类型的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性分保类型/分保类型的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性业务类型 /业务类型 的getter方法
	 */
	public String getReinsciFlag() {
		return reinsciFlag;
	}
	/**
	 * 属性业务类型 /业务类型 的setter方法
	 */
	public void setReinsciFlag(String reinsciFlag) {
		this.reinsciFlag = reinsciFlag;
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
}
