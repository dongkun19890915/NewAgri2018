package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 03:00:47.370 
 * 承保理赔镜像代码表主键操作对象
 */
public class PrpDImageCodeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDImageCodeKey(){}
	public PrpDImageCodeKey(String riskCode,String comCode){
		this.riskCode = riskCode;
		this.comCode = comCode;
	}
	/** 属性险种号（key）/险种号（key） */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性机构号（key）/机构号（key） */
	@Column(name = "comCode")
	private String comCode ;
	/**
	 * 属性险种号（key）/险种号（key）的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性险种号（key）/险种号（key）的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性机构号（key）/机构号（key）的getter方法
	 */
	public String getComCode() {
    		return comCode;
	}
	/**
	 * 属性机构号（key）/机构号（key）的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
}