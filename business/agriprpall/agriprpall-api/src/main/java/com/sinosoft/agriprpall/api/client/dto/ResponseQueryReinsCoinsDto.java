package com.sinosoft.agriprpall.api.client.dto;

public class ResponseQueryReinsCoinsDto {
	//属性 协议共保合约编码
	private String TreatyNo;
	//属性 协议共保类型:1-主共；2-从共
	private String coinsType;
	//属性 收付费类型：1-整单收付；2-我方收付
	private String coinsPremiumType;

	/**
	 * 默认构造方法
	 */
	public ResponseQueryReinsCoinsDto(){
	}

	public String getTreatyNo() {
		return TreatyNo;
	}

	public void setTreatyNo(String treatyNo) {
		TreatyNo = treatyNo;
	}

	public String getCoinsType() {
		return coinsType;
	}

	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	}

	public String getCoinsPremiumType() {
		return coinsPremiumType;
	}

	public void setCoinsPremiumType(String coinsPremiumType) {
		this.coinsPremiumType = coinsPremiumType;
	}
	
}
