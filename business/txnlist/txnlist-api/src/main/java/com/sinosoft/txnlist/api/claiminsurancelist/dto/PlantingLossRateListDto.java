package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * 定损清单信息表Api操作对象
 */
public class PlantingLossRateListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性损失率清单号/损失率清单号 */
	private String listNo ;
	/** 属性序号/序号 */
	@ExportConfig(value = "序号",width = 37)
	private String serialNo ;
	/** 属性报案号/报案号 */
	@ExportConfig(value = "报案号",width = 47)
	private String registNo ;
	/** 属性保单号/保单号 */
	@ExportConfig(value = "保单号",width = 52)
	private String policyNo ;
	/** 属性农户代码/农户代码 */
	@ExportConfig(value = "农户代码",width = 67)
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	@ExportConfig(value = "农户姓名",width = 67	)
	private String fName ;		
	/** 属性田块代码/田块代码 */
	@ExportConfig(value = "农户田块代码")
	private String fieldNo ;		
	/** 属性承保面积/承保面积 */
	@ExportConfig(value = "承保面积(亩)",width = 116)
	private java.lang.Double insureArea ;		
	/** 属性损失面积/损失面积 */
	@ExportConfig(value = "损失面积(亩)",width = 116)
	private java.lang.Double lossArea ;		
	/** 属性损失率/损失率 */
	@ExportConfig(value = "损失率(%)",width = 92)
	private java.lang.Double lossRate ;		
	/** 属性备注/备注 */
	@ExportConfig(value = "备注",width = 92)
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
	public java.lang.Double getInsureArea() {
		return insureArea;
	}
	/**
	 * 属性承保面积/承保面积的setter方法
	 */
	public void setInsureArea(java.lang.Double insureArea) {
		this.insureArea = insureArea;
	}	
	/**
	 * 属性损失面积/损失面积的getter方法
	 */
	public java.lang.Double getLossArea() {
		return lossArea;
	}
	/**
	 * 属性损失面积/损失面积的setter方法
	 */
	public void setLossArea(java.lang.Double lossArea) {
		this.lossArea = lossArea;
	}	
	/**
	 * 属性损失率/损失率的getter方法
	 */
	public java.lang.Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失率/损失率的setter方法
	 */
	public void setLossRate(java.lang.Double lossRate) {
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
}
