package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:00:38.844 
 * 法人信息表Api操作对象
 */
public class PrpCPinsuredArtifDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性关系人标志 /关系人标志  */
	private String insuredFlag ;		
	/** 属性法人代表/法人代表 */
	private String leaderName ;		
	/** 属性法人代表身份证号/法人代表身份证号 */
	private String leaderId ;		
	/** 属性手机号/手机号 */
	private String phoneNumber ;		
	/** 属性邮编/邮编 */
	private String postCode ;		
	/** 属性营业执照/营业执照 */
	private String businessCode ;		
	/** 属性税务登记号码/税务登记号码 */
	private String revenueRegistNo ;		
	/** 属性经销车型/经销车型 */
	private String cartType ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性关系人标志 /关系人标志 的getter方法
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}
	/**
	 * 属性关系人标志 /关系人标志 的setter方法
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}	
	/**
	 * 属性法人代表/法人代表的getter方法
	 */
	public String getLeaderName() {
		return leaderName;
	}
	/**
	 * 属性法人代表/法人代表的setter方法
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}	
	/**
	 * 属性法人代表身份证号/法人代表身份证号的getter方法
	 */
	public String getLeaderId() {
		return leaderId;
	}
	/**
	 * 属性法人代表身份证号/法人代表身份证号的setter方法
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}	
	/**
	 * 属性手机号/手机号的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性手机号/手机号的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	/**
	 * 属性邮编/邮编的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性邮编/邮编的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	/**
	 * 属性营业执照/营业执照的getter方法
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 属性营业执照/营业执照的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}	
	/**
	 * 属性税务登记号码/税务登记号码的getter方法
	 */
	public String getRevenueRegistNo() {
		return revenueRegistNo;
	}
	/**
	 * 属性税务登记号码/税务登记号码的setter方法
	 */
	public void setRevenueRegistNo(String revenueRegistNo) {
		this.revenueRegistNo = revenueRegistNo;
	}	
	/**
	 * 属性经销车型/经销车型的getter方法
	 */
	public String getCartType() {
		return cartType;
	}
	/**
	 * 属性经销车型/经销车型的setter方法
	 */
	public void setCartType(String cartType) {
		this.cartType = cartType;
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
}
