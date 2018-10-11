package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 共保信息表Api操作对象
 */
public class PrpCcoinsDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
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
	/** 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外 */
	private Double coinsRate ;
	/** 属性标志字段/标志字段 */
	private String flag ="";
	/** 属性首席标志/首席标志 */
	private String chiefFlag ;		
	/** 属性分摊标志/分摊标志 */
	private String proportionFlag ;		
	/** 属性共保协议号/共保协议号 */
	private String coinsTreatyNo ;
	/** 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司 */
	private String coinsFlag ;		
	/** 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务 */
	private String reinsCiFlag ;
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date updateDate ;
	/** 理赔增加字段 */
	private Double coinsAmount;

	public Double getCoinsAmount() {
		return coinsAmount;
	}

	public void setCoinsAmount(Double coinsAmount) {
		this.coinsAmount = coinsAmount;
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
	 * 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保类型1-系统内2-系统外/共保类型1-系统内2-系统外的setter方法
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
	 * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}

	public String getCoinsTreatyNo() {
		return coinsTreatyNo;
	}

	public void setCoinsTreatyNo(String coinsTreatyNo) {
		this.coinsTreatyNo = coinsTreatyNo;
	}

	public String getReinsCiFlag() {
		return reinsCiFlag;
	}

	public void setReinsCiFlag(String reinsCiFlag) {
		this.reinsCiFlag = reinsCiFlag;
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
