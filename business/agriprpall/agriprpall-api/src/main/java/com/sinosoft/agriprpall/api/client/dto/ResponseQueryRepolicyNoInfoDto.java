package com.sinosoft.agriprpall.api.client.dto;
/**
 * 分保保单详细信息
 * @author Administrator
 *
 */
public class ResponseQueryRepolicyNoInfoDto {

	/**分保保单号*/
	private String repolicyNo = "";
	/**分保方式 [1]=0：法定 1: 自留 2：合同 3: 临分 [2-3] = FhTreaty.TreatyType*/
	private String reinsMode = "";
	/**分保方式名称 [1]=0：法定 1: 自留 2：合同 3: 临分 [2-3] = FhTreaty.TreatyType*/
	private String reinsModeName = "";
	/**合约编码*/
	private String treatyNo = "";
	/**份额*/
	private String shareRate = "";
	/**币种*/
	private String currency = "";
	/**分出保额*/
	private String amount = "";
	/**分出保费*/
	private String premium = "";

	public String getRepolicyNo() {
		return repolicyNo;
	}
	public void setRepolicyNo(String repolicyNo) {
		this.repolicyNo = repolicyNo;
	}
	public String getReinsMode() {
		return reinsMode;
	}
	public void setReinsMode(String reinsMode) {
		this.reinsMode = reinsMode;
	}
	public String getTreatyNo() {
		return treatyNo;
	}
	public void setTreatyNo(String treatyNo) {
		this.treatyNo = treatyNo;
	}
	public String getShareRate() {
		return shareRate;
	}
	public void setShareRate(String shareRate) {
		this.shareRate = shareRate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getReinsModeName() {
		return reinsModeName;
	}
	public void setReinsModeName(String reinsModeName) {
		this.reinsModeName = reinsModeName;
	}


}
