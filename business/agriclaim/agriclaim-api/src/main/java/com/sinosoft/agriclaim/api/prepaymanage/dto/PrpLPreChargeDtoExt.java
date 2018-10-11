package com.sinosoft.agriclaim.api.prepaymanage.dto;

public class PrpLPreChargeDtoExt extends PrpLPreChargeDto {

	private static final long serialVersionUID = 1L;
	/*险别名称*/
    private String kindName;
    /*币别名称*/
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
