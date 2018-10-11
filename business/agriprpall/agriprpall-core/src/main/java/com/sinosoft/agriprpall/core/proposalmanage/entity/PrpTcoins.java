package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 * 共保信息表实体操作对象
 */
@Entity
@Table(name = "PrpTcoins")
@IdClass(PrpTcoinsKey.class)
public class PrpTcoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;


	/** 属性主投保单号码/主投保单号码 */
	@Column(name = "mainProposalNo")
	private String mainProposalNo ;
	/** 属性共保人机构代码/共保人机构代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性共保人名称/共保人名称 */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性共保类型/共保类型 */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性共保份额/共保份额 */
	@Column(name = "coinsRate")
	private Double coinsRate ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性chiefFlag/chiefFlag */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性proportionFlag/proportionFlag */
	@Column(name = "proportionFlag")
	private String proportionFlag ;
	/** treaty 条约 协议*/
	@Column(name = "coinsTreatyNo")
	private String coinsTreatyNo ;
	/** 属性分保类型1-是分出公司 2-不是分出公司/分保类型1-是分出公司 2-不是分出公司 */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务 */
	@Column(name = "reinsCiFlag")
	private String reinsCiFlag ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性主投保单号码/主投保单号码的getter方法
	 */
	public String getMainProposalNo() {
		return mainProposalNo;
	}
	/**
	 * 属性主投保单号码/主投保单号码的setter方法
	 */
	public void setMainProposalNo(String mainProposalNo) {
		this.mainProposalNo = mainProposalNo;
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
	 * 属性共保类型/共保类型的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性共保类型/共保类型的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	} 	
	/**
	 * 属性共保份额/共保份额的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
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
	 * 属性chiefFlag/chiefFlag的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性chiefFlag/chiefFlag的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	} 	
	/**
	 * 属性proportionFlag/proportionFlag的getter方法
	 */
	public String getProportionFlag() {
		return proportionFlag;
	}
	/**
	 * 属性proportionFlag/proportionFlag的setter方法
	 */
	public void setProportionFlag(String proportionFlag) {
		this.proportionFlag = proportionFlag;
	} 	
	/**
	 * 属性共保协议号/共保协议号的getter方法
	 */

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
	/**
	 * 属性业务类型 1-分出业务 2-分入业务/业务类型 1-分出业务 2-分入业务的getter方法
	 */
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
}