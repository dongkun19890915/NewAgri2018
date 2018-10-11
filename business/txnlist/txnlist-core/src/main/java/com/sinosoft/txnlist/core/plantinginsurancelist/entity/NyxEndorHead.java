package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * nyxendorhead实体操作对象
 */
@Entity
@Table(name = "nyxEndorHead")
@IdClass(NyxEndorHeadKey.class)
public class NyxEndorHead extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;	
	/** 属性投保清单号/投保清单号 */
	@Column(name = "inusreListCode")
	private String inusreListCode ;

	/** 属性投保单号/投保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性listFlag/listFlag */
	@Column(name = "listFlag")
	private String listFlag ;
	/** 属性endorFlag/endorFlag */
	@Column(name = "endorFlag")
	private String endorFlag ;
	/** 属性是否删除标志/是否删除标志 */
	@Column(name = "isDeleteFlag")
	private String isDeleteFlag="1";
	/**
	 * 属性投保清单号/投保清单号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单号/投保清单号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
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
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性listFlag/listFlag的getter方法
	 */
	public String getListFlag() {
		return listFlag;
	}
	/**
	 * 属性listFlag/listFlag的setter方法
	 */
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	} 	
	/**
	 * 属性endorFlag/endorFlag的getter方法
	 */
	public String getEndorFlag() {
		return endorFlag;
	}
	/**
	 * 属性endorFlag/endorFlag的setter方法
	 */
	public void setEndorFlag(String endorFlag) {
		this.endorFlag = endorFlag;
	}

	public String getIsDeleteFlag() {
		return isDeleteFlag;
	}

	public void setIsDeleteFlag(String isDeleteFlag) {
		this.isDeleteFlag = isDeleteFlag;
	}
}