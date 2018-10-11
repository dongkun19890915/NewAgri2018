package com.sinosoft.pms.core.salerate.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:52:23.595 
 * PrpDsalesRate-销售费用率配置表   基础数据对象
 */
@Entity
@Table(name = "prpdsalesrate")
@IdClass(PrpDsalesRateKey.class)
public class PrpDsalesRate implements BaseEntity,Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性VersionNo/版次号 */
	@Id
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性RiskCode/产品代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性BusinessNature/业务来源 */
	@Id
	@Column(name = "businessNature")
	private String businessNature ;

	/** 属性RiskName/产品名称 */
	private String riskName ;

	/** 属性SalesRate/销售费用率 */
	private Double salesRate ;
	/** 属性EffectDate/生效日期 */
	private java.util.Date effectDate ;
	/** 属性InvalidDate/失效日期 */
	private java.util.Date invalidDate ;
	/** 属性Flag/标志 */
	private String flag ;
	/** 属性Remark/备注 */
	private String remark ;
	/** 属性CreateTime/创建时间 */
	private java.util.Date createTime ;
	/** 属性CreateBy/创建人 */
	private String createBy ;
	/** 属性UpdateTime/更新时间 */
	private java.util.Date updateTime ;
	/** 属性UpdateBy/更新人 */
	private String updateBy ;
	/**
	 * 类PrpDsalesRate的默认构造方法
	 */
	public PrpDsalesRate() {
	}


	/**
	 * 属性RiskName/产品名称的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性RiskName/产品名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	} 

	/**
	 * 属性SalesRate/销售费用率的getter方法
	 */
	public Double getSalesRate() {
		return salesRate;
	}
	/**
	 * 属性SalesRate/销售费用率的setter方法
	 */
	public void setSalesRate(Double salesRate) {
		this.salesRate = salesRate;
	} 
	/**
	 * 属性EffectDate/生效日期的getter方法
	 */
	public java.util.Date getEffectDate() {
		return effectDate;
	}
	/**
	 * 属性EffectDate/生效日期的setter方法
	 */
	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	} 
	/**
	 * 属性InvalidDate/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性InvalidDate/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 
	/**
	 * 属性Flag/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性Flag/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
	/**
	 * 属性Remark/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性Remark/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性CreateTime/创建时间的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性CreateTime/创建时间的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	} 
	/**
	 * 属性CreateBy/创建人的getter方法
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 属性CreateBy/创建人的setter方法
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	} 
	/**
	 * 属性UpdateTime/更新时间的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性UpdateTime/更新时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	} 
	/**
	 * 属性UpdateBy/更新人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性UpdateBy/更新人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/*
	* 属性versionNo的getter方法
	*/
	public String getVersionNo() {
		return versionNo;
	}

	/*
    * 属性versionNo的setter方法
    */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	/*
    * 属性riskCode的getter方法
    */
	public String getRiskCode() {
		return riskCode;
	}

	/*
    * 属性riskCode的setter方法
    */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/*
    * 属性businessNature的getter方法
    */
	public String getBusinessNature() {
		return businessNature;
	}

	/*
    * 属性businessNature的setter方法
    */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
}