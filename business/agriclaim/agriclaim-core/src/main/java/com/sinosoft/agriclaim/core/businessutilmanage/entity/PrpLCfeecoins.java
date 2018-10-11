package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 共保费用信息表（无表名）实体操作对象
 */
@Entity
@Table(name = "PrpLCfeecoins")
@IdClass(PrpLCfeecoinsKey.class)
public class PrpLCfeecoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	@Id
	@Column(name = "businessNo")
	private String businessNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;	


	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性共保人机构代码/共保人机构代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性共保人名称/共保人名称 */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外 */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性共保份额/共保份额 */
	@Column(name = "coinsRate")
	private java.lang.Double coinsRate ;
	/** 属性属性（chiefflag）/属性（chiefflag） */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性损失费用类型/损失费用类型 */
	@Column(name = "lossFeeType")
	private String lossFeeType ;
	/** 属性费用类别代码/费用类别代码 */
	@Column(name = "chargeCode")
	private String chargeCode ;
	/** 属性费用名称/费用名称 */
	@Column(name = "chargeName")
	private String chargeName ;
	/** 属性总赔款/总赔款 */
	@Column(name = "sumPaid")
	private java.lang.Double sumPaid ;
	/** 属性共保方赔款/共保方赔款 */
	@Column(name = "coinsSumPaid")
	private java.lang.Double coinsSumPaid ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
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
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外的getter方法
	 */
	public String getCoinsType() {
		return coinsType;
	}
	/**
	 * 属性共保类型--** 1-系统内--** 2-系统外/共保类型--** 1-系统内--** 2-系统外的setter方法
	 */
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	} 	
	/**
	 * 属性共保份额/共保份额的getter方法
	 */
	public java.lang.Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
	 */
	public void setCoinsRate(java.lang.Double coinsRate) {
		this.coinsRate = coinsRate;
	} 	
	/**
	 * 属性属性（chiefflag）/属性（chiefflag）的getter方法
	 */
	public String getChiefFlag() {
		return chiefFlag;
	}
	/**
	 * 属性属性（chiefflag）/属性（chiefflag）的setter方法
	 */
	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	} 	
	/**
	 * 属性损失费用类型/损失费用类型的getter方法
	 */
	public String getLossFeeType() {
		return lossFeeType;
	}
	/**
	 * 属性损失费用类型/损失费用类型的setter方法
	 */
	public void setLossFeeType(String lossFeeType) {
		this.lossFeeType = lossFeeType;
	} 	
	/**
	 * 属性费用类别代码/费用类别代码的getter方法
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * 属性费用类别代码/费用类别代码的setter方法
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	} 	
	/**
	 * 属性费用名称/费用名称的getter方法
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 属性费用名称/费用名称的setter方法
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	} 	
	/**
	 * 属性总赔款/总赔款的getter方法
	 */
	public java.lang.Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性总赔款/总赔款的setter方法
	 */
	public void setSumPaid(java.lang.Double sumPaid) {
		this.sumPaid = sumPaid;
	} 	
	/**
	 * 属性共保方赔款/共保方赔款的getter方法
	 */
	public java.lang.Double getCoinsSumPaid() {
		return coinsSumPaid;
	}
	/**
	 * 属性共保方赔款/共保方赔款的setter方法
	 */
	public void setCoinsSumPaid(java.lang.Double coinsSumPaid) {
		this.coinsSumPaid = coinsSumPaid;
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