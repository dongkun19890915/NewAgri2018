package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;

/**
 * @description: 类功能简述：赔款费用信息扩展类
 * @author 安齐崇
 * @date 2017年12月3日下午2:33:57
 *
 */
public class PrpLChargeDtoExt extends PrpLChargeDto {

	private static final long serialVersionUID = 1L;
	/* 险别名称 */
	private String kindName;
	/* 险别名称 */
	private String currencyName;
    
	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

}
