package com.sinosoft.agriprpall.api.client.dto;

public class ResponseQueryReinsAgreementDto {
	//属性 协议共保合约编码
	private String TreatyNo;
	//属性 共保接受人编码
	private String coinsCode;
	//属性 是否首席：1-是；0-否
	private String ChiefFlag;
	//属性 共保接受人简称
	private String coinsName;
	//所占份额(％)
	private double shareRate;
	//属性 标志（备用）
	private String flag;
	
	/**
     *  默认构造方法
     */
	public ResponseQueryReinsAgreementDto(){
	}

	public String getTreatyNo() {
		return TreatyNo;
	}

	public void setTreatyNo(String treatyNo) {
		TreatyNo = treatyNo;
	}

	public String getCoinsCode() {
		return coinsCode;
	}

	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}

	public String getChiefFlag() {
		return ChiefFlag;
	}

	public void setChiefFlag(String chiefFlag) {
		ChiefFlag = chiefFlag;
	}

	public String getCoinsName() {
		return coinsName;
	}

	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	}

	public double getShareRate() {
		return shareRate;
	}

	public void setShareRate(double shareRate) {
		this.shareRate = shareRate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
