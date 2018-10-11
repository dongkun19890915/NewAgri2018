package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 其他信息Api操作对象
 */
public class OtherInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性联共保标志/联共保标志 */
	private String coinsFlag ;		
	/** 属性保单缴费类型/保单缴费类型 */
	private String coinsPremiumType ;
	/** 共保信息 */
	private List<PrpTcoinsDto> prpTcoinsDtoList;
	/** 特约及附加信息 */
	private List<QueryProposalPrpTengageDto> prpTengageList;
	/** 共保明细信息*/
	private List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList;
	/**共保方收费计划 */
	private List<PrpTplanCoinsDto> prpTplanCoinsDtoList;

	public List<PrpTcoinsDetailDto> getPrpTcoinsDetailDtoList() {		return prpTcoinsDetailDtoList;	}

	public void setPrpTcoinsDetailDtoList(List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList) {		this.prpTcoinsDetailDtoList = prpTcoinsDetailDtoList;	}

	public List<PrpTplanCoinsDto> getPrpTplanCoinsDtoList() {
		return prpTplanCoinsDtoList;
	}

	public void setPrpTplanCoinsDtoList(List<PrpTplanCoinsDto> prpTplanCoinsDtoList) {
		this.prpTplanCoinsDtoList = prpTplanCoinsDtoList;
	}

	public List<PrpTcoinsDto> getPrpTcoinsDtoList() {
		return prpTcoinsDtoList;
	}

	public void setPrpTcoinsDtoList(List<PrpTcoinsDto> prpTcoinsDtoList) {
		this.prpTcoinsDtoList = prpTcoinsDtoList;
	}

	public List<QueryProposalPrpTengageDto> getPrpTengageList() {
		return prpTengageList;
	}

	public void setPrpTengageList(List<QueryProposalPrpTengageDto> prpTengageList) {
		this.prpTengageList = prpTengageList;
	}

	/**
	 * 属性联共保标志/联共保标志的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性联共保标志/联共保标志的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性保单缴费类型/保单缴费类型的getter方法
	 */
	public String getCoinsPremiumType() {
		return coinsPremiumType;
	}
	/**
	 * 属性保单缴费类型/保单缴费类型的setter方法
	 */
	public void setCoinsPremiumType(String coinsPremiumType) {
		this.coinsPremiumType = coinsPremiumType;
	}	
}
