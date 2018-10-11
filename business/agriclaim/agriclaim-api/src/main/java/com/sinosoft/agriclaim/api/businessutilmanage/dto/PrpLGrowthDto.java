package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 *生长期dto
 */
public class PrpLGrowthDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 险种代码*/
	private String riskCode;
	/** 条款代码*/
	private String clauseCode;
	/** 标的代码*/
	private String itemCode;
	/** 险别代码*/
	private String kindCode;
	/** 生长期名称*/
	private String growthName;
	/** 生长期代码*/
	private String growthCode;
	/** 有效标志*/
	private String flag;
	/** 赔偿标准*/
	private String payStandard;

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getClauseCode() {
		return clauseCode;
	}

	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getGrowthName() {
		return growthName;
	}

	public void setGrowthName(String growthName) {
		this.growthName = growthName;
	}

	public String getGrowthCode() {
		return growthCode;
	}

	public void setGrowthCode(String growthCode) {
		this.growthCode = growthCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPayStandard() {
		return payStandard;
	}

	public void setPayStandard(String payStandard) {
		this.payStandard = payStandard;
	}
}
