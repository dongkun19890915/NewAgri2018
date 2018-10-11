package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTfeild;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 大户田块信息实体操作对象
 */
@Entity
@Table(name = "PrpCfeild")
@IdClass(PrpCfeildKey.class)
public class PrpCfeild extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性田块编码/田块编码 */
	@Id
	@Column(name = "feildNo")
	private String feildNo ;	

	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;

	/** 属性田块名称/田块名称 */
	@Column(name = "feildName")
	private String feildName ;
	/** 属性feildArea/feildArea */
	@Column(name = "feildArea")
	private Double feildArea ;
	/** 属性大户代码/大户代码 */
	@Column(name = "richflyCode")
	private String richflyCode ;
	/** 属性大户名称/大户名称 */
	@Column(name = "richflyCName")
	private String richflyCName ;
	/** 属性操作类型/操作类型 */
	@Column(name = "operationFlag")
	private String operationFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
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
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性田块编码/田块编码的getter方法
	 */
	public String getFeildNo() {
		return feildNo;
	}
	/**
	 * 属性田块编码/田块编码的setter方法
	 */
	public void setFeildNo(String feildNo) {
		this.feildNo = feildNo;
	} 	
	/**
	 * 属性田块名称/田块名称的getter方法
	 */
	public String getFeildName() {
		return feildName;
	}
	/**
	 * 属性田块名称/田块名称的setter方法
	 */
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	} 	
	/**
	 * 属性feildArea/feildArea的getter方法
	 */
	public Double getFeildArea() {
		return feildArea;
	}
	/**
	 * 属性feildArea/feildArea的setter方法
	 */
	public void setFeildArea(Double feildArea) {
		this.feildArea = feildArea;
	} 	
	/**
	 * 属性大户代码/大户代码的getter方法
	 */
	public String getRichflyCode() {
		return richflyCode;
	}
	/**
	 * 属性大户代码/大户代码的setter方法
	 */
	public void setRichflyCode(String richflyCode) {
		this.richflyCode = richflyCode;
	} 	
	/**
	 * 属性大户名称/大户名称的getter方法
	 */
	public String getRichflyCName() {
		return richflyCName;
	}
	/**
	 * 属性大户名称/大户名称的setter方法
	 */
	public void setRichflyCName(String richflyCName) {
		this.richflyCName = richflyCName;
	} 	
	/**
	 * 属性操作类型/操作类型的getter方法
	 */
	public String getOperationFlag() {
		return operationFlag;
	}
	/**
	 * 属性操作类型/操作类型的setter方法
	 */
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

}