package com.sinosoft.agriclaim.api.businessutilmanage.dto;
/**
 * @description 查询条件属性类
 * @author 安齐崇
 * @date 2017年11月13日
 */
public class InitVo {
	/** 编码类型*/
	private String codeType;
	/** 险种编码*/
	private String riskCode;
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
}
