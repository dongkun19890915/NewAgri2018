package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位详细表实体操作对象
 */
@Entity
@Table(name = "PrpLDangerTot")
@IdClass(PrpLDangerTotKey.class)
public class PrpLDangerTot extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	@Id
	@Column(name = "certiNo")
	private String certiNo ;/** 属性dangerNo/dangerNo */
	@Id
	@Column(name = "dangerNo")
	private Integer dangerNo ;/** 属性sCurrency/sCurrency */
	@Id
	@Column(name = "sCurrency")
	private String sCurrency ;/** 属性估损增加次数/估损增加次数 */
	@Id
	@Column(name = "claimAddTimes")
	private Integer claimAddTimes ;



	/** 属性sumPaid/sumPaid */
	@Column(name = "sumPaid")
	private Double sumPaid ;
	/** 属性sumFee/sumFee */
	@Column(name = "sumFee")
	private Double sumFee ;
	/** 属性tCurrency/tCurrency */
	@Column(name = "tCurrency")
	private String tCurrency ;
	/** 属性exchRate/exchRate */
	@Column(name = "exchRate")
	private Double exchRate ;
	/** 属性sumPaidEx/sumPaidEx */
	@Column(name = "sumPaidEx")
	private Double sumPaidEx ;
	/** 属性sumFeeEx/sumFeeEx */
	@Column(name = "sumFeeEx")
	private Double sumFeeEx ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;

	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 	
	/**
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 	
	/**
	 * 属性sCurrency/sCurrency的getter方法
	 */
	public String getSCurrency() {
		return sCurrency;
	}
	/**
	 * 属性sCurrency/sCurrency的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
	} 	
	/**
	 * 属性sumPaid/sumPaid的getter方法
	 */
	public Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性sumPaid/sumPaid的setter方法
	 */
	public void setSumPaid(Double sumPaid) {
		this.sumPaid = sumPaid;
	} 	
	/**
	 * 属性sumFee/sumFee的getter方法
	 */
	public Double getSumFee() {
		return sumFee;
	}
	/**
	 * 属性sumFee/sumFee的setter方法
	 */
	public void setSumFee(Double sumFee) {
		this.sumFee = sumFee;
	} 	
	/**
	 * 属性tCurrency/tCurrency的getter方法
	 */
	public String getTCurrency() {
		return tCurrency;
	}
	/**
	 * 属性tCurrency/tCurrency的setter方法
	 */
	public void setTCurrency(String tCurrency) {
		this.tCurrency = tCurrency;
	} 	
	/**
	 * 属性exchRate/exchRate的getter方法
	 */
	public Double getExchRate() {
		return exchRate;
	}
	/**
	 * 属性exchRate/exchRate的setter方法
	 */
	public void setExchRate(Double exchRate) {
		this.exchRate = exchRate;
	} 	
	/**
	 * 属性sumPaidEx/sumPaidEx的getter方法
	 */
	public Double getSumPaidEx() {
		return sumPaidEx;
	}
	/**
	 * 属性sumPaidEx/sumPaidEx的setter方法
	 */
	public void setSumPaidEx(Double sumPaidEx) {
		this.sumPaidEx = sumPaidEx;
	} 	
	/**
	 * 属性sumFeeEx/sumFeeEx的getter方法
	 */
	public Double getSumFeeEx() {
		return sumFeeEx;
	}
	/**
	 * 属性sumFeeEx/sumFeeEx的setter方法
	 */
	public void setSumFeeEx(Double sumFeeEx) {
		this.sumFeeEx = sumFeeEx;
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
	 * 属性估损增加次数/估损增加次数的getter方法
	 */
	public Integer getClaimAddTimes() {
		return claimAddTimes;
	}
	/**
	 * 属性估损增加次数/估损增加次数的setter方法
	 */
	public void setClaimAddTimes(Integer claimAddTimes) {
		this.claimAddTimes = claimAddTimes;
	} 	
}