package com.sinosoft.pms.core.rate.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 共同体成员比例配置表实体操作对象
 */
@Entity
@Table(name = "PrpDcoinsRate")
@IdClass(PrpDcoinsRateKey.class)
public class PrpDcoinsRate extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性成员公司代码/成员公司代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性版次号/版次号 */
        @Id
        @Column(name = "versionNo")
	private String versionNo ;	

	/** 属性产品名称/产品名称 */
	private String riskName ;

	/** 属性成员公司名称/成员公司名称 */
	private String comCName ;

	/** 属性共保比例/共保比例 */
	private java.lang.Double coinsRate ;
	/** 属性生效日期/生效日期 */
	private java.util.Date effectDate ;
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;
	/** 属性标志/标志 */
	private String flag ;
	/** 属性备注/备注 */
	private String remark ;




	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性产品名称/产品名称的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性产品名称/产品名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	} 	
	/**
	 * 属性成员公司代码/成员公司代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性成员公司代码/成员公司代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性成员公司名称/成员公司名称的getter方法
	 */
	public String getComCName() {
		return comCName;
	}
	/**
	 * 属性成员公司名称/成员公司名称的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	} 	
	/**
	 * 属性版次号/版次号的getter方法
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * 属性版次号/版次号的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	} 	
	/**
	 * 属性共保比例/共保比例的getter方法
	 */
	public java.lang.Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保比例/共保比例的setter方法
	 */
	public void setCoinsRate(java.lang.Double coinsRate) {
		this.coinsRate = coinsRate;
	} 	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getEffectDate() {
		return effectDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	} 	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
		
		
		
		
}