package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * 法人信息表实体操作对象
 */
@Entity
@Table(name = "PrpTinsuredArtif")
@IdClass(PrpTinsuredArtifKey.class)
public class PrpTinsuredArtif extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;	


	/** 属性关系人标识,同PrpTinsured中/关系人标识,同PrpTinsured中 */
	@Column(name = "insuredFlag")
	private String insuredFlag ;
	/** 属性法人代表/法人代表 */
	@Column(name = "leaderName")
	private String leaderName ;
	/** 属性法人代表身份证号/法人代表身份证号 */
	@Column(name = "leaderId")
	private String leaderId ;
	/** 属性电话/电话 */
	@Column(name = "phoneNumber")
	private String phoneNumber ;
	/** 属性邮编/邮编 */
	@Column(name = "postCode")
	private String postCode ;
	/** 属性营业执照/营业执照 */
	@Column(name = "businessCode")
	private String businessCode ;
	/** 属性税务登记号码/税务登记号码 */
	@Column(name = "revenueRegistNo")
	private String revenueRegistNo ;
	/** 属性经销车型/经销车型 */
	@Column(name = "carType")
	private String carType ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性关系人标识,同PrpTinsured中/关系人标识,同PrpTinsured中的getter方法
	 */
	public String getInsuredFlag() {
		return insuredFlag;
	}
	/**
	 * 属性关系人标识,同PrpTinsured中/关系人标识,同PrpTinsured中的setter方法
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
	 * 属性电话/电话的getter方法
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 属性电话/电话的setter方法
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
	public String getCarType() {
		return carType;
	}
	/**
	 * 属性经销车型/经销车型的setter方法
	 */
	public void setCarType(String carType) {
		this.carType = carType;
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