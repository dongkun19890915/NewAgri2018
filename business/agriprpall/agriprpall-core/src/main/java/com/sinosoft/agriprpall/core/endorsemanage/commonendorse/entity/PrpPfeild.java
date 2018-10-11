package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:49:16.504 
 * 大户田块信息表(P)实体操作对象
 */
@Entity
@Table(name = "PrpPfeild")
@IdClass(PrpPfeildKey.class)
public class PrpPfeild extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性田块编码/田块编码 */
	@Id
	@Column(name = "feildNo")
	private String feildNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

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
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date updateDate ;
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
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 	
}