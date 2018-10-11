package com.sinosoft.agriprpall.api.client.dto;

public class ResponseGetTaxRateDto {
	private Double taxRate;
	private String taxFlag;

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxFlag() {
		return taxFlag;
	}

	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	}

}
