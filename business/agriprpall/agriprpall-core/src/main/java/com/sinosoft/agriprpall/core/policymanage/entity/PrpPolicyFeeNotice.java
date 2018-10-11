package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757 
 * 保费缴款通知书信息表实体操作对象
 */
@Entity
@Table(name = "PrpPolicyFeeNotice")
@IdClass(PrpPolicyFeeNoticeKey.class)
public class PrpPolicyFeeNotice extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性缴费通知书编号/缴费通知书编号 */
	@Id
	@Column(name = "policyFeeNo")
	private String policyFeeNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性打印人代码/打印人代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性打印时间/打印时间 */
	@Column(name = "operaDate")
	private Date operaDate ;
	/**
	 * 属性缴费通知书编号/缴费通知书编号的getter方法
	 */
	public String getPolicyFeeNo() {
		return policyFeeNo;
	}
	/**
	 * 属性缴费通知书编号/缴费通知书编号的setter方法
	 */
	public void setPolicyFeeNo(String policyFeeNo) {
		this.policyFeeNo = policyFeeNo;
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
	 * 属性批单号/批单号的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号/批单号的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 	
	/**
	 * 属性打印人代码/打印人代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性打印人代码/打印人代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性打印时间/打印时间的getter方法
	 */
	public Date getOperaDate() {
		return operaDate;
	}
	/**
	 * 属性打印时间/打印时间的setter方法
	 */
	public void setOperaDate(Date operaDate) {
		this.operaDate = operaDate;
	} 	
}