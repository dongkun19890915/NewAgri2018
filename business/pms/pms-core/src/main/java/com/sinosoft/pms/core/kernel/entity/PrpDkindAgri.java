package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 险别代码表实体操作对象
 */
@Entity
@Table(name = "PrpDkindAgri")
@IdClass(PrpDkindAgriKey.class)
public class PrpDkindAgri extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性险别代码/险别代码 */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;


	/** 属性险别中文名称/险别中文名称 */
	@Column(name = "kindCName")
	private String kindCName ;
	/** 属性险别英文名称/险别英文名称 */
	@Column(name = "kindEName")
	private String kindEName ;
	/** 属性[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险/[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险 */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性新的险别代码/新的险别代码 */
	@Column(name = "newKindCode")
	private String newKindCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性reinsinFlag/reinsinFlag */
	@Column(name = "reinsinFlag")
	private String reinsinFlag ;
	/** 属性rateTypeFlag/rateTypeFlag */
	@Column(name = "rateTypeFlag")
	private String rateTypeFlag ;
	/** 属性maxDiscountRate/maxDiscountRate */
	@Column(name = "maxDiscountRate")
	private Integer maxDiscountRate ;
	/** 属性maxFloatRate/maxFloatRate */
	@Column(name = "maxFloatRate")
	private Integer maxFloatRate ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
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
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
	 * 属性险别中文名称/险别中文名称的getter方法
	 */
	public String getKindCName() {
		return kindCName;
	}
	/**
	 * 属性险别中文名称/险别中文名称的setter方法
	 */
	public void setKindCName(String kindCName) {
		this.kindCName = kindCName;
	}
	/**
	 * 属性险别英文名称/险别英文名称的getter方法
	 */
	public String getKindEName() {
		return kindEName;
	}
	/**
	 * 属性险别英文名称/险别英文名称的setter方法
	 */
	public void setKindEName(String kindEName) {
		this.kindEName = kindEName;
	}
	/**
	 * 属性[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险/[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险/[1]计入总保额标志(Y/N) [2]保额/限额标志 1:保额 2：限额 3：其他  [3]主险/附加险标志1：主险 2：附加险 [4] 是否允许不计免赔标志1：允许 2：不允许 [5] 0正常/1利损险/2地震险/3战争险的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	}
	/**
	 * 属性新的险别代码/新的险别代码的getter方法
	 */
	public String getNewKindCode() {
		return newKindCode;
	}
	/**
	 * 属性新的险别代码/新的险别代码的setter方法
	 */
	public void setNewKindCode(String newKindCode) {
		this.newKindCode = newKindCode;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性reinsinFlag/reinsinFlag的getter方法
	 */
	public String getReinsinFlag() {
		return reinsinFlag;
	}
	/**
	 * 属性reinsinFlag/reinsinFlag的setter方法
	 */
	public void setReinsinFlag(String reinsinFlag) {
		this.reinsinFlag = reinsinFlag;
	}
	/**
	 * 属性rateTypeFlag/rateTypeFlag的getter方法
	 */
	public String getRateTypeFlag() {
		return rateTypeFlag;
	}
	/**
	 * 属性rateTypeFlag/rateTypeFlag的setter方法
	 */
	public void setRateTypeFlag(String rateTypeFlag) {
		this.rateTypeFlag = rateTypeFlag;
	}
	/**
	 * 属性maxDiscountRate/maxDiscountRate的getter方法
	 */
	public Integer getMaxDiscountRate() {
		return maxDiscountRate;
	}
	/**
	 * 属性maxDiscountRate/maxDiscountRate的setter方法
	 */
	public void setMaxDiscountRate(Integer maxDiscountRate) {
		this.maxDiscountRate = maxDiscountRate;
	}
	/**
	 * 属性maxFloatRate/maxFloatRate的getter方法
	 */
	public Integer getMaxFloatRate() {
		return maxFloatRate;
	}
	/**
	 * 属性maxFloatRate/maxFloatRate的setter方法
	 */
	public void setMaxFloatRate(Integer maxFloatRate) {
		this.maxFloatRate = maxFloatRate;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}