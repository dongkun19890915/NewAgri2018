package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * PrpDprovinceConfig主键操作对象
 */
public class PrpDprovinceConfigKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDprovinceConfigKey(){}
	public PrpDprovinceConfigKey(String comCode,String riskCode){
		this.comCode = comCode;
		this.riskCode = riskCode;
	}
	/** 属性comcode/comcode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性riskcode/riskcode */
	@Column(name = "riskCode")
	private String riskCode ;
	/**
	 * 属性comcode/comcode的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性comcode/comcode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性riskcode/riskcode的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性riskcode/riskcode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
}