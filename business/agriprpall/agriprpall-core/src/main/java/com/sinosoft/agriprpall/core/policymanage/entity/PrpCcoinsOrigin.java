package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 03:29:07.877 
 * 共保信息原始表实体操作对象
 */
@Entity
@Table(name = "PrpCcoinsOrigin")
@IdClass(PrpCcoinsOriginKey.class)
public class PrpCcoinsOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	


	/** 属性mainPolicyNo/mainPolicyNo */
	@Column(name = "mainPolicyNo")
	private String mainPolicyNo ;
	/** 属性coinsCode/coinsCode */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性coinsName/coinsName */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性coinsType/coinsType */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性coinsRate/coinsRate */
	@Column(name = "coinsRate")
	private java.lang.Double coinsRate ;
	/** 属性chiefFlag/chiefFlag */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性proportionFlag/proportionFlag */
	@Column(name = "proportionFlag")
	private String proportionFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性共保协议号/共保协议号 */
	@Column(name = "coinsTreatyNo")
	private String coinsTreatyNo ;
	/** 属性reinsCiFlag/reinsCiFlag */
	@Column(name = "reinsCiFlag")
	private String reinsCiFlag ;
	/** 属性coinsFlag/coinsFlag */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性mainPolicyNo/mainPolicyNo的getter方法
	 */
	public String getMainPolicyNo() {
		return mainPolicyNo;
	}
	/**
	 * 属性mainPolicyNo/mainPolicyNo的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	} 	
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 	
	/**
	 * 属性coinsName/coinsName的getter方法
	 */
	public String getCoinsName() {
		return coinsName;
	}
	/**
	 * 属性coinsName/coinsName的setter方法
	 */
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	} 	
	/**
	 * 属性coinsType/coinsType的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性coinsType/coinsType的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	} 	
	/**
	 * 属性coinsRate/coinsRate的getter方法
	 */
	public java.lang.Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性coinsRate/coinsRate的setter方法
	 */
	public void setCoinsRate(java.lang.Double coinsRate) {
		this.coinsRate = coinsRate;
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
	 * 属性reinsCiFlag/reinsCiFlag的getter方法
	 */
	public String getReinsCiFlag() {
		return reinsCiFlag;
	}
	/**
	 * 属性reinsCiFlag/reinsCiFlag的setter方法
	 */
	public void setReinsCiFlag(String reinsCiFlag) {
		this.reinsCiFlag = reinsCiFlag;
	} 	
	/**
	 * 属性coinsFlag/coinsFlag的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性coinsFlag/coinsFlag的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	} 	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
}