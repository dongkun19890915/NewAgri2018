package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 00:32:45.064 
 * PrpCitemAgriApi操作对象
 */
public class PrpCitemAgriDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性标号/标号 */
	private Integer itemNo ;
	/** 属性longitudeStart/longitudeStart */
	private String longitudeStart ;		
	/** 属性longitudeEnd/longitudeEnd */
	private String longitudeEnd ;		
	/** 属性latitudeStart/latitudeStart */
	private String latitudeStart ;		
	/** 属性latitudeEnd/latitudeEnd */
	private String latitudeEnd ;		
	/** 属性unitCost/unitCost */
	private Double unitCost ;
	/** 属性unitPrice/unitPrice */
	private Double unitPrice ;
	/** 属性unitProduct/unitProduct */
	private Double unitProduct ;
	/** 属性itemAge/itemAge */
	private Double itemAge ;
	/** 属性density/density */
	private Double density ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性flag/flag */
	private String flag ;		
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性标号/标号的getter方法
	 */
	public Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标号/标号的setter方法
	 */
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}	
	/**
	 * 属性longitudeStart/longitudeStart的getter方法
	 */
	public String getLongitudeStart() {
		return longitudeStart;
	}
	/**
	 * 属性longitudeStart/longitudeStart的setter方法
	 */
	public void setLongitudeStart(String longitudeStart) {
		this.longitudeStart = longitudeStart;
	}	
	/**
	 * 属性longitudeEnd/longitudeEnd的getter方法
	 */
	public String getLongitudeEnd() {
		return longitudeEnd;
	}
	/**
	 * 属性longitudeEnd/longitudeEnd的setter方法
	 */
	public void setLongitudeEnd(String longitudeEnd) {
		this.longitudeEnd = longitudeEnd;
	}	
	/**
	 * 属性latitudeStart/latitudeStart的getter方法
	 */
	public String getLatitudeStart() {
		return latitudeStart;
	}
	/**
	 * 属性latitudeStart/latitudeStart的setter方法
	 */
	public void setLatitudeStart(String latitudeStart) {
		this.latitudeStart = latitudeStart;
	}	
	/**
	 * 属性latitudeEnd/latitudeEnd的getter方法
	 */
	public String getLatitudeEnd() {
		return latitudeEnd;
	}
	/**
	 * 属性latitudeEnd/latitudeEnd的setter方法
	 */
	public void setLatitudeEnd(String latitudeEnd) {
		this.latitudeEnd = latitudeEnd;
	}	
	/**
	 * 属性unitCost/unitCost的getter方法
	 */
	public Double getUnitCost() {
		return unitCost;
	}
	/**
	 * 属性unitCost/unitCost的setter方法
	 */
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}	
	/**
	 * 属性unitPrice/unitPrice的getter方法
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 属性unitPrice/unitPrice的setter方法
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}	
	/**
	 * 属性unitProduct/unitProduct的getter方法
	 */
	public Double getUnitProduct() {
		return unitProduct;
	}
	/**
	 * 属性unitProduct/unitProduct的setter方法
	 */
	public void setUnitProduct(Double unitProduct) {
		this.unitProduct = unitProduct;
	}	
	/**
	 * 属性itemAge/itemAge的getter方法
	 */
	public Double getItemAge() {
		return itemAge;
	}
	/**
	 * 属性itemAge/itemAge的setter方法
	 */
	public void setItemAge(Double itemAge) {
		this.itemAge = itemAge;
	}	
	/**
	 * 属性density/density的getter方法
	 */
	public Double getDensity() {
		return density;
	}
	/**
	 * 属性density/density的setter方法
	 */
	public void setDensity(Double density) {
		this.density = density;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
