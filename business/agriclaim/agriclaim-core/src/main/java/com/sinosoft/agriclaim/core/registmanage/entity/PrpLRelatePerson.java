package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 联系人表实体操作对象
 */
@Entity
@Table(name = "PrpLRelatePerson")
@IdClass(PrpLRelatePersonKey.class)
public class PrpLRelatePerson extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性人员类型/人员类型 */
	@Id
	@Column(name = "personType")
	private String personType ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	



	/** 属性人员编码/人员编码 */
	@Column(name = "personCode")
	private String personCode ;
	/** 属性人员姓名/人员姓名 */
	@Column(name = "personName")
	private String personName ;
	/** 属性电话号码/电话号码 */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性手机号/手机号 */
	@Column(name = "mobile")
	private String mobile ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;




	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性人员类型/人员类型的getter方法
	 */
	public String getPersonType() {
		return personType;
	}
	/**
	 * 属性人员类型/人员类型的setter方法
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性人员编码/人员编码的getter方法
	 */
	public String getPersonCode() {
		return personCode;
	}
	/**
	 * 属性人员编码/人员编码的setter方法
	 */
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	} 	
	/**
	 * 属性人员姓名/人员姓名的getter方法
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 属性人员姓名/人员姓名的setter方法
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	} 	
	/**
	 * 属性电话号码/电话号码的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性电话号码/电话号码的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 	
	/**
	 * 属性手机号/手机号的getter方法
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 属性手机号/手机号的setter方法
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 	
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