package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 共保信息表实体操作对象
 */
@Entity
@Table(name = "PrpPcoinsCopy")
@IdClass(PrpPcoinsCopyKey.class)
public class PrpPcoinsCopy extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性endorseNo/endorseNo */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性serialNo/serialNo */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;

	/** 属性policyNo/policyNo */
	@Column(name = "policyNo")
	private String policyNo ;

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
	private Double coinsRate ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性chiefFlag/chiefFlag */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性proportionFlag/proportionFlag */
	@Column(name = "proportionFlag")
	private String proportionFlag ;
	/** 属性共保业务共保比例变化/共保业务共保比例变化 */
	@Column(name = "chgCoinsRate")
	private Double chgCoinsRate ;
	/** 属性共保协议号/共保协议号 */
	@Column(name = "coinsTreatyNo")
	private String coinsTreatyNo ;
	/** 属性coinsFlag/coinsFlag */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性reInsciFlag/reInsciFlag */
	@Column(name = "reinsCiFlag")
	private String reinsCiFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_by")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_date")
	private Date update_Date ;
	/**
	 * 属性endorseNo/endorseNo的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性endorseNo/endorseNo的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
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
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性coinsRate/coinsRate的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
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
	 * 属性共保业务共保比例变化/共保业务共保比例变化的getter方法
	 */
	public Double getChgCoinsRate() {
		return chgCoinsRate;
	}
	/**
	 * 属性共保业务共保比例变化/共保业务共保比例变化的setter方法
	 */
	public void setChgCoinsRate(Double chgCoinsRate) {
		this.chgCoinsRate = chgCoinsRate;
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
	 * 属性reInsciFlag/reInsciFlag的getter方法
	 */
	public String getReinsCiFlag() {
		return reinsCiFlag;
	}

	public void setReinsCiFlag(String reinsCiFlag) {
		this.reinsCiFlag = reinsCiFlag;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}