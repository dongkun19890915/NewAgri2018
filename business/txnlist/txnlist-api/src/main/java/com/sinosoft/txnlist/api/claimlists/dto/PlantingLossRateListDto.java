package com.sinosoft.txnlist.api.claimlists.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 06:59:30.161 
 * 种植险损失率清单表Api操作对象
 */
public class PlantingLossRateListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	private String listNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性农户代码/农户代码 */
	private String fCode ;		
	/** 属性农户姓名/农户姓名 */
	private String fName ;		
	/** 属性田块代码/田块代码 */
	private String fieldNo ;		
	/** 属性承保面积/承保面积 */
	private Double insureArea ;
	/** 属性损失面积/损失面积 */
	private Double lossArea ;
	/** 属性损失率/损失率 */
	private Double lossRate ;
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性报案号/报案号 */
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