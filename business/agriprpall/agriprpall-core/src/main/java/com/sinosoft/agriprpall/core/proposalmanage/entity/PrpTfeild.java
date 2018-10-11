package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 大户田块信息实体操作对象
 */
@Entity
@Table(name = "PrpTfeild")
@IdClass(PrpTfeildKey.class)
public class PrpTfeild extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单/投保单 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性田块编码/田块编码 */
	@Id
	@Column(name = "feildNo")
	private String feildNo ;	


	/** 属性田块名称/田块名称 */
	@Column(name = "feildName")
	private String feildName ;
	/** 属性田块区域/田块区域 */
	@Column(name = "feildArea")
	private Double feildArea ;
	/** 属性大户代码/大户代码 */
	@Column(name = "richflyCode")
	private String richflyCode ;
	/** 属性大户名称/大户名称 */
	@Column(name = "richflyCName")
	private String richflyCName ;
	/**
	 * 属性投保单/投保单的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单/投保单的setter方法
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
	 * 属性田块区域/田块区域的getter方法
	 */
	public Double getFeildArea() {
		return feildArea;
	}
	/**
	 * 属性田块区域/田块区域的setter方法
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
}