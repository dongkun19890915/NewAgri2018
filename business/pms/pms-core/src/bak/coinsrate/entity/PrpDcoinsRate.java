package com.sinosoft.pms.core.coinsrate.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:51:06.937 
 * PrpDcoinsRate-共同体成员比例配置表   基础数据对象
 */
@Entity
@Table(name = "prpdcoinsrate")
@IdClass(PrpDcoinsRateKey.class)
public class PrpDcoinsRate implements BaseEntity,Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性VersionNo/版次号 */
	@Id
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性RiskCode/产品代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性ComCode/成员公司代码 */
	@Id
	@Column(name = "comCode")
	private String comCode ;

	/** 属性RiskName/产品名称 */
	private String riskName ;

	/** 属性ComCName/成员公司名称 */
	private String comCName ;
	/** 属性EffectDate/生效日期 */
	private java.util.Date effectDate ;
	/** 属性InvalidDate/失效日期 */
	private java.util.Date invalidDate ;
	/** 属性CoinsRate/共保比例 */
	private Double coinsRate ;
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
	 * 类PrpDcoinsRate的默认构造方法
	 */
	public PrpDcoinsRate() {
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
	 * 属性ComCName/成员公司名称的getter方法
	 */
	public String getComCName() {
		return comCName;
	}
	/**
	 * 属性ComCName/成员公司名称的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
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
	 * 属性CoinsRate/共保比例的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性CoinsRate/共保比例的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
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

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
}