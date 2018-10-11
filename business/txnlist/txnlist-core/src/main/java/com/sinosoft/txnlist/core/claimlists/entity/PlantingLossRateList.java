package com.sinosoft.txnlist.core.claimlists.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 06:59:30.161 
 * 种植险损失率清单表实体操作对象
 */
@Entity
@Table(name = "PlantingLossRateList")
@IdClass(PlantingLossRateListKey.class)
public class PlantingLossRateList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	@Id
	@Column(name = "listNo")
	private String listNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@Column(name = "fName")
	private String fName ;
	/** 属性田块代码/田块代码 */
	@Column(name = "fieldNo")
	private String fieldNo ;
	/** 属性承保面积/承保面积 */
	@Column(name = "insureArea")
	private Double insureArea ;
	/** 属性损失面积/损失面积 */
	@Column(name = "lossArea")
	private Double lossArea ;
	/** 属性损失率/损失率 */
	@Column(name = "lossRate")
	private Double lossRate ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
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
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 	
	/**
	 * 属性农户姓名/农户姓名的getter方法
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * 属性农户姓名/农户姓名的setter方法
	 */
	public void setFName(String fName) {
		this.fName = fName;
	} 	
	/**
	 * 属性田块代码/田块代码的getter方法
	 */
	public String getFieldNo() {
		return fieldNo;
	}
	/**
	 * 属性田块代码/田块代码的setter方法
	 */
	public void setFieldNo(String fieldNo) {
		this.fieldNo = fieldNo;
	} 	
	/**
	 * 属性承保面积/承保面积的getter方法
	 */
	public Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性承保面积/承保面积的setter方法
	 */
	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	} 	
	/**
	 * 属性损失面积/损失面积的getter方法
	 */
	public Double getLossArea() {
		return lossArea;
	}
	/**
	 * 属性损失面积/损失面积的setter方法
	 */
	public void setLossArea(Double lossArea) {
		this.lossArea = lossArea;
	} 	
	/**
	 * 属性损失率/损失率的getter方法
	 */
	public Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失率/损失率的setter方法
	 */
	public void setLossRate(Double lossRate) {
		this.lossRate = lossRate;
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
}