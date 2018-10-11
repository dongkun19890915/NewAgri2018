package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * PrpCinsuredArtif实体操作对象
 */
@Entity
@Table(name = "PrpCinsuredArtif")
@IdClass(PrpCinsuredArtifKey.class)
public class PrpCinsuredArtif extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性policyNo/policyNo */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性serialNo/serialNo */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	


	/** 属性insuredFlag/insuredFlag */
	@Column(name = "insuredFlag")
	private String insuredFlag ;
	/** 属性leaderName/leaderName */
	@Column(name = "leaderName")
	private String leaderName ;
	/** 属性leaderId/leaderId */
	@Column(name = "leaderId")
	private String leaderId ;
	/** 属性phoneNumber/phoneNumber */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性postCode/postCode */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性businessCode/businessCode */
	@Column(name = "businessCode")
	private String businessCode ;
	/** 属性revenueRegistNo/revenueRegistNo */
	@Column(name = "revenueRegistNo")
	private String revenueRegistNo ;
	/** 属性carType/carType */
	@Column(name = "carType")
	private String carType ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
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
	 * 属性serialNo/serialNo的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性insuredFlag/insuredFlag的getter方法
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}
	/**
	 * 属性insuredFlag/insuredFlag的setter方法
	 */
	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	} 	
	/**
	 * 属性leaderName/leaderName的getter方法
	 */
	public String getLeaderName() {
		return leaderName;
	}
	/**
	 * 属性leaderName/leaderName的setter方法
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	} 	
	/**
	 * 属性leaderId/leaderId的getter方法
	 */
	public String getLeaderId() {
		return leaderId;
	}
	/**
	 * 属性leaderId/leaderId的setter方法
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	} 	
	/**
	 * 属性phoneNumber/phoneNumber的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性phoneNumber/phoneNumber的setter方法
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 	
	/**
	 * 属性postCode/postCode的getter方法
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 属性postCode/postCode的setter方法
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	} 	
	/**
	 * 属性businessCode/businessCode的getter方法
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 属性businessCode/businessCode的setter方法
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	} 	
	/**
	 * 属性revenueRegistNo/revenueRegistNo的getter方法
	 */
	public String getRevenueRegistNo() {
		return revenueRegistNo;
	}
	/**
	 * 属性revenueRegistNo/revenueRegistNo的setter方法
	 */
	public void setRevenueRegistNo(String revenueRegistNo) {
		this.revenueRegistNo = revenueRegistNo;
	} 	
	/**
	 * 属性carType/carType的getter方法
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * 属性carType/carType的setter方法
	 */
	public void setCarType(String carType) {
		this.carType = carType;
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