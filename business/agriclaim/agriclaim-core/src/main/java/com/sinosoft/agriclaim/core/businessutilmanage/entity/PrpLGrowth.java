package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * 生长期表
 */
@Entity
@Table(name = "PrpLGrowth")
@IdClass(PrpLGrowthKey.class)
public class PrpLGrowth extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 险种代码*/
	@Id
	@Column(name="riskCode")
	private String riskCode;
	/** 条款代码*/
	@Id
	@Column(name="clauseCode")
	private String clauseCode;
	/** 标的代码*/
	@Id
	@Column(name="itemCode")
	private String itemCode;
	/** 险别代码*/
	@Id
	@Column(name="kindCode")
	private String kindCode;
	/** 生长期名称*/
	@Column(name="growthName")
	private String growthName;
	/** 生长期代码*/
	@Id
	@Column(name="growthCode")
	private String growthCode;
	/** 有效标志*/
	@Id
	@Column(name="flag")
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