package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
*清单批改持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:31
*/
@Entity
@Table(name = "plantingEndorHead")
@IdClass(PlantingEndorHeadKey.class)
public class PlantingEndorHead extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;	
	/** 属性投保清单编号/投保清单编号 */
	@Column(name = "inusreListCode")
	private String inusreListCode ;

	/** 属性投保单号/投保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性清单标志（未提交、已提交）/清单标志（未提交、已提交） */
	@Column(name = "listFlag")
	private String listFlag ;
	/** 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单） */
	@Column(name = "endorFlag")
	private String endorFlag ;
	/** 属性是否删除标志/是否删除标志 */
	@Column(name = "isDeleteFlag")
	private String isDeleteFlag="1";
	/**
	 * 属性投保清单编号/投保清单编号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单编号/投保清单编号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 	
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
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
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性清单标志（未提交、已提交）/清单标志（未提交、已提交）的getter方法
	 */
	public String getListFlag() {
		return listFlag;
	}
	/**
	 * 属性清单标志（未提交、已提交）/清单标志（未提交、已提交）的setter方法
	 */
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	} 	
	/**
	 * 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单）的getter方法
	 */
	public String getEndorFlag() {
		return endorFlag;
	}
	/**
	 * 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单）的setter方法
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