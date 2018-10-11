package com.sinosoft.agriprpall.api.client.dto;

public class ResponseQueryPrpDreinsDto {
	/**
	 * 分保接受人代码
	 */
	private String reinsCode;
	/**
	 * 分保接受人简称
	 */
	private String shortName;
	/**
	 * 分保接受人全称
	 */
	private String longName;

	public String getReinsCode() {
		return reinsCode;
	}

	public void setReinsCode(String reinsCode) {
		this.reinsCode = reinsCode;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

}
