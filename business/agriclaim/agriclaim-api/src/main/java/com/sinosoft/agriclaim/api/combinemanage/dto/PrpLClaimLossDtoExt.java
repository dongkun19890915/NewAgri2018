package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;

/**
 * @description: 类功能简述：险别估损金额信息
 * @author 安齐崇
 * @date 2017年11月26日下午6:04:06
 *
 */
public class PrpLClaimLossDtoExt  {

	private static final long serialVersionUID = 1L;
    private String KindName;
    private String currencyName;
    private PrpLClaimLossDto  prpLClaimLossDto;
	public String getKindName() {
		return KindName;
	}
	public void setKindName(String kindName) {
		KindName = kindName;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PrpLClaimLossDto getPrpLClaimLossDto() {
		return prpLClaimLossDto;
	}
	public void setPrpLClaimLossDto(PrpLClaimLossDto prpLClaimLossDto) {
		this.prpLClaimLossDto = prpLClaimLossDto;
	}
	
}
