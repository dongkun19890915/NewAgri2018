package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔扩展系统表Api操作对象
 */
public class PrpLextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性单号/单号 */
	private String certiNo ;		
	/** 属性单号类型/单号类型 */
	private String certiType ;		
	/** 属性第三者亡人数/第三者亡人数 */
	private java.lang.Integer personDeathB ;		
	/** 属性车上人员亡人数/车上人员亡人数 */
	private java.lang.Integer personDeathD1 ;		
	/** 属性第三者伤人数/第三者伤人数 */
	private java.lang.Integer personInjureB ;		
	/** 属性车上人员伤人数/车上人员伤人数 */
	private java.lang.Integer personInjureD1 ;		
	/** 属性承运人/承运人 */
	private String carrier ;		
	/** 属性开航日期/开航日期 */
	private java.util.Date sailStartDate ;		
	/** 属性卸货日期/卸货日期 */
	private java.util.Date unloadDate ;		
	/** 属性申请查勘日期/申请查勘日期 */
	private java.util.Date appliCheckDate ;		
	/** 属性投保人或代表联系电话、传真/投保人或代表联系电话、传真 */
	private String appliPhone ;		
	/** 属性被保险人或代表联系电话、传真/被保险人或代表联系电话、传真 */
	private String insuredPhone ;		
	/** 属性货损查勘公司/货损查勘公司 */
	private String cargolossCheckCom ;		
	/** 属性货运险损失类型/货运险损失类型 */
	private String cargolossType ;		
	/** 属性共损理算师/共损理算师 */
	private String shareClaimer ;		
	/** 属性救助人/救助人 */
	private String salvor ;		
	/** 属性是否需要海事担保/是否需要海事担保 */
	private String guaranteeFlag ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性货价/货价 */
	private java.lang.Integer cargoValue ;		
	/** 属性救助担保金额/救助担保金额 */
	private java.lang.Integer salvaGuarantAmount ;		
	/** 属性残值数量/残值数量 */
	private java.lang.Integer restQuantity ;		
	/** 属性担保人/担保人 */
	private String guarantor ;		
	/** 属性预留字段1/预留字段1 */
	private String value1 ;		
	/** 属性预留字段2/预留字段2 */
	private String value2 ;		
	/** 属性预留字段3/预留字段3 */
	private String value3 ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志/标志 */
	private String flag ;		
	/**
	 * 属性单号/单号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性单号/单号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}	
	/**
	 * 属性单号类型/单号类型的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性单号类型/单号类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}	
	/**
	 * 属性第三者亡人数/第三者亡人数的getter方法
	 */
	public java.lang.Integer getPersonDeathB() {
		return personDeathB;
	}
	/**
	 * 属性第三者亡人数/第三者亡人数的setter方法
	 */
	public void setPersonDeathB(java.lang.Integer personDeathB) {
		this.personDeathB = personDeathB;
	}	
	/**
	 * 属性车上人员亡人数/车上人员亡人数的getter方法
	 */
	public java.lang.Integer getPersonDeathD1() {
		return personDeathD1;
	}
	/**
	 * 属性车上人员亡人数/车上人员亡人数的setter方法
	 */
	public void setPersonDeathD1(java.lang.Integer personDeathD1) {
		this.personDeathD1 = personDeathD1;
	}	
	/**
	 * 属性第三者伤人数/第三者伤人数的getter方法
	 */
	public java.lang.Integer getPersonInjureB() {
		return personInjureB;
	}
	/**
	 * 属性第三者伤人数/第三者伤人数的setter方法
	 */
	public void setPersonInjureB(java.lang.Integer personInjureB) {
		this.personInjureB = personInjureB;
	}	
	/**
	 * 属性车上人员伤人数/车上人员伤人数的getter方法
	 */
	public java.lang.Integer getPersonInjureD1() {
		return personInjureD1;
	}
	/**
	 * 属性车上人员伤人数/车上人员伤人数的setter方法
	 */
	public void setPersonInjureD1(java.lang.Integer personInjureD1) {
		this.personInjureD1 = personInjureD1;
	}	
	/**
	 * 属性承运人/承运人的getter方法
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * 属性承运人/承运人的setter方法
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}	
	/**
	 * 属性开航日期/开航日期的getter方法
	 */
	public java.util.Date getSailStartDate() {
		return sailStartDate;
	}
	/**
	 * 属性开航日期/开航日期的setter方法
	 */
	public void setSailStartDate(java.util.Date sailStartDate) {
		this.sailStartDate = sailStartDate;
	}	
	/**
	 * 属性卸货日期/卸货日期的getter方法
	 */
	public java.util.Date getUnloadDate() {
		return unloadDate;
	}
	/**
	 * 属性卸货日期/卸货日期的setter方法
	 */
	public void setUnloadDate(java.util.Date unloadDate) {
		this.unloadDate = unloadDate;
	}	
	/**
	 * 属性申请查勘日期/申请查勘日期的getter方法
	 */
	public java.util.Date getAppliCheckDate() {
		return appliCheckDate;
	}
	/**
	 * 属性申请查勘日期/申请查勘日期的setter方法
	 */
	public void setAppliCheckDate(java.util.Date appliCheckDate) {
		this.appliCheckDate = appliCheckDate;
	}	
	/**
	 * 属性投保人或代表联系电话、传真/投保人或代表联系电话、传真的getter方法
	 */
	public String getAppliPhone() {
		return appliPhone;
	}
	/**
	 * 属性投保人或代表联系电话、传真/投保人或代表联系电话、传真的setter方法
	 */
	public void setAppliPhone(String appliPhone) {
		this.appliPhone = appliPhone;
	}	
	/**
	 * 属性被保险人或代表联系电话、传真/被保险人或代表联系电话、传真的getter方法
	 */
	public String getInsuredPhone() {
		return insuredPhone;
	}
	/**
	 * 属性被保险人或代表联系电话、传真/被保险人或代表联系电话、传真的setter方法
	 */
	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}	
	/**
	 * 属性货损查勘公司/货损查勘公司的getter方法
	 */
	public String getCargolossCheckCom() {
		return cargolossCheckCom;
	}
	/**
	 * 属性货损查勘公司/货损查勘公司的setter方法
	 */
	public void setCargolossCheckCom(String cargolossCheckCom) {
		this.cargolossCheckCom = cargolossCheckCom;
	}	
	/**
	 * 属性货运险损失类型/货运险损失类型的getter方法
	 */
	public String getCargolossType() {
		return cargolossType;
	}
	/**
	 * 属性货运险损失类型/货运险损失类型的setter方法
	 */
	public void setCargolossType(String cargolossType) {
		this.cargolossType = cargolossType;
	}	
	/**
	 * 属性共损理算师/共损理算师的getter方法
	 */
	public String getShareClaimer() {
		return shareClaimer;
	}
	/**
	 * 属性共损理算师/共损理算师的setter方法
	 */
	public void setShareClaimer(String shareClaimer) {
		this.shareClaimer = shareClaimer;
	}	
	/**
	 * 属性救助人/救助人的getter方法
	 */
	public String getSalvor() {
		return salvor;
	}
	/**
	 * 属性救助人/救助人的setter方法
	 */
	public void setSalvor(String salvor) {
		this.salvor = salvor;
	}	
	/**
	 * 属性是否需要海事担保/是否需要海事担保的getter方法
	 */
	public String getGuaranteeFlag() {
		return guaranteeFlag;
	}
	/**
	 * 属性是否需要海事担保/是否需要海事担保的setter方法
	 */
	public void setGuaranteeFlag(String guaranteeFlag) {
		this.guaranteeFlag = guaranteeFlag;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性货价/货价的getter方法
	 */
	public java.lang.Integer getCargoValue() {
		return cargoValue;
	}
	/**
	 * 属性货价/货价的setter方法
	 */
	public void setCargoValue(java.lang.Integer cargoValue) {
		this.cargoValue = cargoValue;
	}	
	/**
	 * 属性救助担保金额/救助担保金额的getter方法
	 */
	public java.lang.Integer getSalvaGuarantAmount() {
		return salvaGuarantAmount;
	}
	/**
	 * 属性救助担保金额/救助担保金额的setter方法
	 */
	public void setSalvaGuarantAmount(java.lang.Integer salvaGuarantAmount) {
		this.salvaGuarantAmount = salvaGuarantAmount;
	}	
	/**
	 * 属性残值数量/残值数量的getter方法
	 */
	public java.lang.Integer getRestQuantity() {
		return restQuantity;
	}
	/**
	 * 属性残值数量/残值数量的setter方法
	 */
	public void setRestQuantity(java.lang.Integer restQuantity) {
		this.restQuantity = restQuantity;
	}	
	/**
	 * 属性担保人/担保人的getter方法
	 */
	public String getGuarantor() {
		return guarantor;
	}
	/**
	 * 属性担保人/担保人的setter方法
	 */
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}	
	/**
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getValue1() {
		return value1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getValue2() {
		return value2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}	
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getValue3() {
		return value3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setValue3(String value3) {
		this.value3 = value3;
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
}
