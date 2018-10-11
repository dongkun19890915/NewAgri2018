package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 索赔申请人信息表Api操作对象
 */
public class PrpLAccIPersonDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	private String certiNo ;		
	/** 属性业务类型/业务类型 */
	private String certiType ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性人员序号/人员序号 */
	private java.lang.Integer familyNo ;		
	/** 属性acci代码/acci代码 */
	private String acciCode ;		
	/** 属性acci名称/acci名称 */
	private String acciName ;		
	/** 属性性别/性别 */
	private String sex ;		
	/** 属性年龄/年龄 */
	private java.lang.Integer age ;		
	/** 属性证件类型/证件类型 */
	private String identifyType ;		
	/** 属性证件号码/证件号码 */
	private String identifyNumber ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性索赔申请人与事故者关系名称/索赔申请人与事故者关系名称 */
	private String relationName ;		
	/** 属性索赔申请人与事故者关系代码/索赔申请人与事故者关系代码 */
	private String relationCode ;		
	/** 属性索赔申请人通信地址/索赔申请人通信地址 */
	private String address ;		
	/** 属性索赔申请人联系电话/索赔申请人联系电话 */
	private String phone ;		
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}	
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
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
	 * 属性人员序号/人员序号的getter方法
	 */
	public java.lang.Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性人员序号/人员序号的setter方法
	 */
	public void setFamilyNo(java.lang.Integer familyNo) {
		this.familyNo = familyNo;
	}	
	/**
	 * 属性acci代码/acci代码的getter方法
	 */
	public String getAcciCode() {
		return acciCode;
	}
	/**
	 * 属性acci代码/acci代码的setter方法
	 */
	public void setAcciCode(String acciCode) {
		this.acciCode = acciCode;
	}	
	/**
	 * 属性acci名称/acci名称的getter方法
	 */
	public String getAcciName() {
		return acciName;
	}
	/**
	 * 属性acci名称/acci名称的setter方法
	 */
	public void setAcciName(String acciName) {
		this.acciName = acciName;
	}	
	/**
	 * 属性性别/性别的getter方法
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 属性性别/性别的setter方法
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}	
	/**
	 * 属性年龄/年龄的getter方法
	 */
	public java.lang.Integer getAge() {
		return age;
	}
	/**
	 * 属性年龄/年龄的setter方法
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}	
	/**
	 * 属性证件类型/证件类型的getter方法
	 */
	public String getIdentifyType() {
		return identifyType;
	}
	/**
	 * 属性证件类型/证件类型的setter方法
	 */
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
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
	 * 属性索赔申请人与事故者关系名称/索赔申请人与事故者关系名称的getter方法
	 */
	public String getRelationName() {
		return relationName;
	}
	/**
	 * 属性索赔申请人与事故者关系名称/索赔申请人与事故者关系名称的setter方法
	 */
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}	
	/**
	 * 属性索赔申请人与事故者关系代码/索赔申请人与事故者关系代码的getter方法
	 */
	public String getRelationCode() {
		return relationCode;
	}
	/**
	 * 属性索赔申请人与事故者关系代码/索赔申请人与事故者关系代码的setter方法
	 */
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}	
	/**
	 * 属性索赔申请人通信地址/索赔申请人通信地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性索赔申请人通信地址/索赔申请人通信地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}	
	/**
	 * 属性索赔申请人联系电话/索赔申请人联系电话的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性索赔申请人联系电话/索赔申请人联系电话的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
