package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 人伤费用险种对照表主键操作对象
 */
public class PrpDpersonFeeCodeRiskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDpersonFeeCodeRiskKey(){}
	public PrpDpersonFeeCodeRiskKey(String riskCode,String feeCode){
		this.riskCode = riskCode;
		this.feeCode = feeCode;
	}
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性费用代码/费用代码 */
	@Column(name = "feeCode")
	private String feeCode ;
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性费用代码/费用代码的getter方法
	 */
	public String getFeeCode() {
    		return feeCode;
	}
	/**
	 * 属性费用代码/费用代码的setter方法
	 */
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	} 
}