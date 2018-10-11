package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位标的表实体操作对象
 */
@Entity
@Table(name = "PrpLDangerCoins")
@IdClass(PrpLDangerCoinsKey.class)
public class PrpLDangerCoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	@Id
	@Column(name = "certiNo")
	private String certiNo ;/** 属性dangerNo/dangerNo */
	@Id
	@Column(name = "dangerNo")
	private Integer dangerNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性估损增加次数/估损增加次数 */
	@Id
	@Column(name = "claimAddTimes")
	private Integer claimAddTimes ;

	/** 属性险种代码/险种代码 */
	@Column(name = "mainCertiNo")
	private String mainCertiNo ;


	/** 属性kindFlag/kindFlag */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性kindCode/kindCode */
	@Column(name = "coinsName")
	private String coinsName ;
	/** 属性kindName/kindName */
	@Column(name = "coinsType")
	private String coinsType ;
	/** 属性postCode/postCode */
	@Column(name = "coinsRate")
	private Double coinsRate ;
	/** 属性addressName/addressName */
	@Column(name = "chiefFlag")
	private String chiefFlag ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/** 属性sumPaid/sumPaid */
	@Column(name = "coinsSumLoss")
	private Double coinsSumLoss ;
	/** 属性sumFee/sumFee */
	@Column(name = "coinsSumPaid")
	private Double coinsSumPaid ;
	/** 属性flag/flag */
	@Column(name = "coinsSumFee")
	private Double coinsSumFee ;
	/** 属性险别的危险单位占比/险别的危险单位占比 */
	@Column(name = "coinsSumNoPaid")
	private Double coinsSumNoPaid ;
	/** 属性标的代码/标的代码 */
	@Column(name = "flag")
	private String flag ;

	public String getCertiNo() {
		return certiNo;
	}

	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}

	public Integer getDangerNo() {
		return dangerNo;
	}

	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getClaimAddTimes() {
		return claimAddTimes;
	}

	public void setClaimAddTimes(Integer claimAddTimes) {
		this.claimAddTimes = claimAddTimes;
	}

	public String getMainCertiNo() {
		return mainCertiNo;
	}

	public void setMainCertiNo(String mainCertiNo) {
		this.mainCertiNo = mainCertiNo;
	}

	public String getCoinsCode() {
		return coinsCode;
	}

	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}

	public String getCoinsName() {
		return coinsName;
	}

	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	}

	public String getCoinsType() {
		return coinsType;
	}

	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	}

	public Double getCoinsRate() {
		return coinsRate;
	}

	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
	}

	public String getChiefFlag() {
		return chiefFlag;
	}

	public void setChiefFlag(String chiefFlag) {
		this.chiefFlag = chiefFlag;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCoinsSumLoss() {
		return coinsSumLoss;
	}

	public void setCoinsSumLoss(Double coinsSumLoss) {
		this.coinsSumLoss = coinsSumLoss;
	}

	public Double getCoinsSumPaid() {
		return coinsSumPaid;
	}

	public void setCoinsSumPaid(Double coinsSumPaid) {
		this.coinsSumPaid = coinsSumPaid;
	}

	public Double getCoinsSumFee() {
		return coinsSumFee;
	}

	public void setCoinsSumFee(Double coinsSumFee) {
		this.coinsSumFee = coinsSumFee;
	}

	public Double getCoinsSumNoPaid() {
		return coinsSumNoPaid;
	}

	public void setCoinsSumNoPaid(Double coinsSumNoPaid) {
		this.coinsSumNoPaid = coinsSumNoPaid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}