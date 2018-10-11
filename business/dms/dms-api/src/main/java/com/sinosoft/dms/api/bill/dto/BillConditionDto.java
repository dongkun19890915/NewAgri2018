package com.sinosoft.dms.api.bill.dto;


public class BillConditionDto extends BillRequestDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String riskCode;
	
	private String comCode;
	
	private String areaCode;
	
	private String billType;
	/** 单号生成 规则-前缀  不支持getserialno getcustomercoude*/
	private String perfix;
	/** 单号生成 规则-长度   不支持getserialno*/
	private int length = 0;

	
	
	public String getRiskCode() {
		return riskCode;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}
	
	public String getPerfix() {
		return perfix;
	}

	public void setPerfix(String perfix) {
		this.perfix = perfix;
	}
}
