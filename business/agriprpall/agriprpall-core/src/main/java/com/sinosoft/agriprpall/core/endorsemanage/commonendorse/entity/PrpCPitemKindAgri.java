package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 农业附加险信息表实体操作对象
 */
@Entity
@Table(name = "PrpCPitemKindAgri")
@IdClass(PrpCPitemKindAgriKey.class)
public class PrpCPitemKindAgri extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性policyNo/policyNo */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性itemKindNo/itemKindNo */
	@Id
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;/** 属性kindCode/kindCode */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性茬次/茬次 */
	@Id
	@Column(name = "times")
	private Integer times ;

	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;


	/** 属性unitOutput/unitOutput */
	@Column(name = "unitOutput")
	private Double unitOutput ;
	/** 属性unitCost/unitCost */
	@Column(name = "unitCost")
	private Double unitCost ;
	/** 属性proportion/proportion */
	@Column(name = "proportion")
	private Double proportion ;
	/** 属性depreciationRate/depreciationRate */
	@Column(name = "depreciationRate")
	private Double depreciationRate ;
	/** 属性unitAmount/unitAmount */
	@Column(name = "unitAmount")
	private Double unitAmount ;
	/** 属性grossQuantity/grossQuantity */
	@Column(name = "grossQuantity")
	private Double grossQuantity ;
	/** 属性discountType/discountType */
	@Column(name = "discountType")
	private String discountType ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性借用存储张种规格/借用存储张种规格 */
	@Column(name = "remark")
	private String remark ;

	/** 属性当前茬次起始日期/当前茬次起始日期 */
	@Column(name = "stratDate")
	private Date stratDate ;
	/** 属性当前茬次终止日期/当前茬次终止日期 */
	@Column(name = "endDate")
	private Date endDate ;
	/** 属性保险金额分布比例/保险金额分布比例 */
	@Column(name = "distributingRate")
	private Double distributingRate ;
	/** 属性投保面积/投保面积 */
	@Column(name = "insureArea")
	private Double insureArea ;
	/** 属性茬次保额/茬次保额 */
	@Column(name = "timesAmount")
	private Double timesAmount ;
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性itemKindNo/itemKindNo的getter方法
	 */
	public Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性itemKindNo/itemKindNo的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 	
	/**
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性unitOutput/unitOutput的getter方法
	 */
	public Double getUnitOutput() {
		return unitOutput;
	}
	/**
	 * 属性unitOutput/unitOutput的setter方法
	 */
	public void setUnitOutput(Double unitOutput) {
		this.unitOutput = unitOutput;
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
	 * 属性proportion/proportion的getter方法
	 */
	public Double getProportion() {
		return proportion;
	}
	/**
	 * 属性proportion/proportion的setter方法
	 */
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	} 	
	/**
	 * 属性depreciationRate/depreciationRate的getter方法
	 */
	public Double getDepreciationRate() {
		return depreciationRate;
	}
	/**
	 * 属性depreciationRate/depreciationRate的setter方法
	 */
	public void setDepreciationRate(Double depreciationRate) {
		this.depreciationRate = depreciationRate;
	} 	
	/**
	 * 属性unitAmount/unitAmount的getter方法
	 */
	public Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性unitAmount/unitAmount的setter方法
	 */
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	} 	
	/**
	 * 属性grossQuantity/grossQuantity的getter方法
	 */
	public Double getGrossQuantity() {
		return grossQuantity;
	}
	/**
	 * 属性grossQuantity/grossQuantity的setter方法
	 */
	public void setGrossQuantity(Double grossQuantity) {
		this.grossQuantity = grossQuantity;
	} 	
	/**
	 * 属性discountType/discountType的getter方法
	 */
	public String getDiscountType() {
		return discountType;
	}
	/**
	 * 属性discountType/discountType的setter方法
	 */
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
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
	/**
	 * 属性借用存储张种规格/借用存储张种规格的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性借用存储张种规格/借用存储张种规格的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性茬次/茬次的getter方法
	 */
	public Integer getTimes() {
		return times;
	}
	/**
	 * 属性茬次/茬次的setter方法
	 */
	public void setTimes(Integer times) {
		this.times = times;
	} 	
	/**
	 * 属性当前茬次起始日期/当前茬次起始日期的getter方法
	 */
	public Date getStratDate() {
		return stratDate;
	}

	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}

	/**
	 * 属性当前茬次终止日期/当前茬次终止日期的getter方法
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性当前茬次终止日期/当前茬次终止日期的setter方法
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性保险金额分布比例/保险金额分布比例的getter方法
	 */
	public Double getDistributingRate() {
		return distributingRate;
	}
	/**
	 * 属性保险金额分布比例/保险金额分布比例的setter方法
	 */
	public void setDistributingRate(Double distributingRate) {
		this.distributingRate = distributingRate;
	} 	
	/**
	 * 属性投保面积/投保面积的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性投保面积/投保面积的setter方法
	 */
	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	} 	
	/**
	 * 属性茬次保额/茬次保额的getter方法
	 */
	public Double getTimesAmount() {
		return timesAmount;
	}
	/**
	 * 属性茬次保额/茬次保额的setter方法
	 */
	public void setTimesAmount(Double timesAmount) {
		this.timesAmount = timesAmount;
	} 	
}