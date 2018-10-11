package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 生长期表主键操作对象
 */
public class PrpLGrowthKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLGrowthKey(){}
	public PrpLGrowthKey(String riskCode, String clauseCode, String itemCode,String kindCode,String growthCode,String flag){
		this.riskCode=riskCode;
		this.clauseCode=clauseCode;
		this.itemCode=itemCode;
		this.kindCode=kindCode;
		this.growthCode=growthCode;
		this.flag=flag;
	}
	/** 险种代码*/
	@Column(name="riskCode")
	private String riskCode;
	/** 条款代码*/
	@Column(name="clauseCode")
	private String clauseCode;
	/** 标的代码*/
	@Column(name="itemCode")
	private String itemCode;
	/** 险别代码*/
	@Column(name="kindCode")
	private String kindCode;
	/** 生长期代码*/
	@Column(name="growthCode")
	private String growthCode;
	/** 有效标志*/
	@Column(name="flag")
	private String flag;

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
}