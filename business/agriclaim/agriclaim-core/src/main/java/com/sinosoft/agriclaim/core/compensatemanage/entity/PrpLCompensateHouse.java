package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 农房理赔身份证信息表实体操作对象
 */
@Entity
@Table(name = "PrpLCompensateHouse")
@IdClass(PrpLCompensateHouseKey.class)
public class PrpLCompensateHouse extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性身份证号/身份证号 */
	@Id
	@Column(name = "idcard")
	private String idcard ;/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性节点名称/节点名称 */
	@Id
	@Column(name = "nodeType")
	private String nodeType ;/** 属性业务号/业务号 */
	@Id
	@Column(name = "businessNo")
	private String businessNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性理算书号/理算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性案件归档号/案件归档号 */
	@Column(name = "caseNo")
	private String caseNo ;
	/** 属性出险日期/出险日期 */
	@Column(name = "damageStartDate")
	private java.util.Date damageStartDate ;
	/** 属性出险原因代码/出险原因代码 */
	@Column(name = "damageCode")
	private String damageCode ;
	/** 属性出险原因说明/出险原因说明 */
	@Column(name = "damageName")
	private String damageName ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "name")
	private String name ;
	/** 属性节点/节点 */
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;

	/** 属性险别序号/险别序号 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性电话号码/电话号码 */
	@Column(name = "phone")
	private String phone ;
	/** 属性地址/地址 */
	@Column(name = "address")
	private String address ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性户口簿/户口簿 */
	@Column(name = "huKouBu")
	private String huKouBu ;
	/** 属性损失金额/损失金额 */
	@Column(name = "estimateLoss")
	private java.lang.Double estimateLoss ;

	/** 属性属性floor/属性floor */
	@Column(name = "floor")
	private String floor ;
	/** 属性属性buildingnumber/属性buildingnumber */
	@Column(name = "buildingNumber")
	private String buildingNumber ;
	/** 属性属性zhuannumber/属性zhuannumber */
	@Column(name = "zhuanNumber")
	private String zhuanNumber ;
	/** 属性属性wanumber/属性wanumber */
	@Column(name = "waNumber")
	private String waNumber ;
	/** 属性属性kitchennumber/属性kitchennumber */
	@Column(name = "kitchenNumber")
	private String kitchenNumber ;
	/** 属性属性othernumber/属性othernumber */
	@Column(name = "otherNumber")
	private String otherNumber ;
	/**
	 * 属性身份证号/身份证号的getter方法
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 属性身份证号/身份证号的setter方法
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 	
	/**
	 * 属性理算书号/理算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性理算书号/理算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 	
	/**
	 * 属性案件归档号/案件归档号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性案件归档号/案件归档号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	} 	
	/**
	 * 属性出险日期/出险日期的getter方法
	 */
	public java.util.Date getDamageStartDate() {
		return damageStartDate;
	}
	/**
	 * 属性出险日期/出险日期的setter方法
	 */
	public void setDamageStartDate(java.util.Date damageStartDate) {
		this.damageStartDate = damageStartDate;
	} 	
	/**
	 * 属性出险原因代码/出险原因代码的getter方法
	 */
	public String getDamageCode() {
		return damageCode;
	}
	/**
	 * 属性出险原因代码/出险原因代码的setter方法
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	} 	
	/**
	 * 属性出险原因说明/出险原因说明的getter方法
	 */
	public String getDamageName() {
		return damageName;
	}
	/**
	 * 属性出险原因说明/出险原因说明的setter方法
	 */
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	} 	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getName() {
		return name;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setName(String name) {
		this.name = name;
	} 	
	/**
	 * 属性节点/节点的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性节点/节点的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 	
	/**
	 * 属性节点名称/节点名称的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点名称/节点名称的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性电话号码/电话号码的getter方法
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 属性电话号码/电话号码的setter方法
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	} 	
	/**
	 * 属性地址/地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性地址/地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * 属性户口簿/户口簿的getter方法
	 */
	public String getHuKouBu() {
		return huKouBu;
	}
	/**
	 * 属性户口簿/户口簿的setter方法
	 */
	public void setHuKouBu(String huKouBu) {
		this.huKouBu = huKouBu;
	} 	
	/**
	 * 属性损失金额/损失金额的getter方法
	 */
	public java.lang.Double getEstimateLoss() {
		return estimateLoss;
	}
	/**
	 * 属性损失金额/损失金额的setter方法
	 */
	public void setEstimateLoss(java.lang.Double estimateLoss) {
		this.estimateLoss = estimateLoss;
	} 	
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
	/**
	 * 属性属性floor/属性floor的getter方法
	 */
	public String getFloor() {
		return floor;
	}
	/**
	 * 属性属性floor/属性floor的setter方法
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	} 	
	/**
	 * 属性属性buildingnumber/属性buildingnumber的getter方法
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}
	/**
	 * 属性属性buildingnumber/属性buildingnumber的setter方法
	 */
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	} 	
	/**
	 * 属性属性zhuannumber/属性zhuannumber的getter方法
	 */
	public String getZhuanNumber() {
		return zhuanNumber;
	}
	/**
	 * 属性属性zhuannumber/属性zhuannumber的setter方法
	 */
	public void setZhuanNumber(String zhuanNumber) {
		this.zhuanNumber = zhuanNumber;
	} 	
	/**
	 * 属性属性wanumber/属性wanumber的getter方法
	 */
	public String getWaNumber() {
		return waNumber;
	}
	/**
	 * 属性属性wanumber/属性wanumber的setter方法
	 */
	public void setWaNumber(String waNumber) {
		this.waNumber = waNumber;
	} 	
	/**
	 * 属性属性kitchennumber/属性kitchennumber的getter方法
	 */
	public String getKitchenNumber() {
		return kitchenNumber;
	}
	/**
	 * 属性属性kitchennumber/属性kitchennumber的setter方法
	 */
	public void setKitchenNumber(String kitchenNumber) {
		this.kitchenNumber = kitchenNumber;
	} 	
	/**
	 * 属性属性othernumber/属性othernumber的getter方法
	 */
	public String getOtherNumber() {
		return otherNumber;
	}
	/**
	 * 属性属性othernumber/属性othernumber的setter方法
	 */
	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	} 	
}