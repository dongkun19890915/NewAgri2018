package com.sinosoft.txnlist.core.claiminsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 06:26:52.496 
 * 养殖险定损清单信息表实体操作对象
 */
@Entity
@Table(name = "BreedLossRateList")
@IdClass(BreedLossRateListKey.class)
public class BreedLossRateList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	@Id
	@Column(name = "listNo")
	private String listNo ;
	/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private String serialNo ;

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earConNo")
	private String earConNo ;
	/** 属性赔款金额/赔款金额 */
	@Column(name = "payAmount")
	private java.lang.Double payAmount ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/**
	 * 属性损失率清单号/损失率清单号的getter方法
	 */
	public String getListNo() {
		return listNo;
	}
	/**
	 * 属性损失率清单号/损失率清单号的setter方法
	 */
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarConNo() {
		return earConNo;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarConNo(String earConNo) {
		this.earConNo = earConNo;
	} 	
	/**
	 * 属性赔款金额/赔款金额的getter方法
	 */
	public java.lang.Double getPayAmount() {
		return payAmount;
	}
	/**
	 * 属性赔款金额/赔款金额的setter方法
	 */
	public void setPayAmount(java.lang.Double payAmount) {
		this.payAmount = payAmount;
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