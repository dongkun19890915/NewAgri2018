package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 00:32:45.064 
 * PrpCitemAgri实体操作对象
 */
@Entity
@Table(name = "PrpCitemAgri")
@IdClass(PrpCitemAgriKey.class)
public class PrpCitemAgri extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性标号/标号 */
	@Id
	@Column(name = "itemNo")
	private Integer itemNo ;

	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性longitudeStart/longitudeStart */
	@Column(name = "longitudeStart")
	private String longitudeStart ;
	/** 属性longitudeEnd/longitudeEnd */
	@Column(name = "longitudeEnd")
	private String longitudeEnd ;
	/** 属性latitudeStart/latitudeStart */
	@Column(name = "latitudeStart")
	private String latitudeStart ;
	/** 属性latitudeEnd/latitudeEnd */
	@Column(name = "latitudeEnd")
	private String latitudeEnd ;
	/** 属性unitCost/unitCost */
	@Column(name = "unitCost")
	private Double unitCost ;
	/** 属性unitPrice/unitPrice */
	@Column(name = "unitPrice")
	private Double unitPrice ;
	/** 属性unitProduct/unitProduct */
	@Column(name = "unitProduct")
	private Double unitProduct ;
	/** 属性itemAge/itemAge */
	@Column(name = "itemAge")
	private Double itemAge ;
	/** 属性density/density */
	@Column(name = "density")
	private Double density ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
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