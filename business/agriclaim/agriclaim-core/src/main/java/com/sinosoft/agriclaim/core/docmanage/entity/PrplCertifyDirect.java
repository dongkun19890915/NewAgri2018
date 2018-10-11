package com.sinosoft.agriclaim.core.docmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * 索赔指引表实体操作对象
 */
@Entity
@Table(name = "PrplCertifyDirect")
@IdClass(PrplCertifyDirectKey.class)
public class PrplCertifyDirect extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性标的代码/标的代码 */
	@Id
	@Column(name = "lossItemCode")
	private String lossItemCode ;


	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性单证类型代码/单证类型代码 */
	@Column(name = "typeCode")
	private String typeCode ;
	/** 属性单证类型名称/单证类型名称 */
	@Column(name = "typeName")
	private String typeName ;
	/** 属性扩充字段内容 /扩充字段内容  */
	@Column(name = "columnValue")
	private String columnValue ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/** 属性强制保险收集标志/强制保险收集标志 */
	@Column(name = "compelFlag")
	private String compelFlag ;
	/** 属性商业保险收集标志/商业保险收集标志 */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性查勘收单/查勘收单 */
	@Column(name = "checkFlag")
	private String checkFlag ;
	/** 属性公估收单/公估收单 */
	@Column(name = "appraisalFlag")
	private String appraisalFlag ;
	/** 属性客户收单/客户收单 */
	@Column(name = "clientFlag")
	private String clientFlag ;
	/** 属性上传标志/上传标志 */
	@Column(name = "uploadFlag")
	private String uploadFlag ;
	/** 属性重开赔案上传标志/重开赔案上传标志 */
	@Column(name = "recaseFlag")
	private String recaseFlag ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
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
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 	
	/**
	 * 属性单证类型代码/单证类型代码的getter方法
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * 属性单证类型代码/单证类型代码的setter方法
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	} 	
	/**
	 * 属性单证类型名称/单证类型名称的getter方法
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 属性单证类型名称/单证类型名称的setter方法
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	} 	
	/**
	 * 属性扩充字段内容 /扩充字段内容 的getter方法
	 */
	public String getColumnValue() {
		return columnValue;
	}
	/**
	 * 属性扩充字段内容 /扩充字段内容 的setter方法
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性强制保险收集标志/强制保险收集标志的getter方法
	 */
	public String getCompelFlag() {
		return compelFlag;
	}
	/**
	 * 属性强制保险收集标志/强制保险收集标志的setter方法
	 */
	public void setCompelFlag(String compelFlag) {
		this.compelFlag = compelFlag;
	} 	
	/**
	 * 属性商业保险收集标志/商业保险收集标志的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性商业保险收集标志/商业保险收集标志的setter方法
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	} 	
	/**
	 * 属性查勘收单/查勘收单的getter方法
	 */
	public String getCheckFlag() {
		return checkFlag;
	}
	/**
	 * 属性查勘收单/查勘收单的setter方法
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	} 	
	/**
	 * 属性公估收单/公估收单的getter方法
	 */
	public String getAppraisalFlag() {
		return appraisalFlag;
	}
	/**
	 * 属性公估收单/公估收单的setter方法
	 */
	public void setAppraisalFlag(String appraisalFlag) {
		this.appraisalFlag = appraisalFlag;
	} 	
	/**
	 * 属性客户收单/客户收单的getter方法
	 */
	public String getClientFlag() {
		return clientFlag;
	}
	/**
	 * 属性客户收单/客户收单的setter方法
	 */
	public void setClientFlag(String clientFlag) {
		this.clientFlag = clientFlag;
	} 	
	/**
	 * 属性上传标志/上传标志的getter方法
	 */
	public String getUploadFlag() {
		return uploadFlag;
	}
	/**
	 * 属性上传标志/上传标志的setter方法
	 */
	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	} 	
	/**
	 * 属性重开赔案上传标志/重开赔案上传标志的getter方法
	 */
	public String getRecaseFlag() {
		return recaseFlag;
	}
	/**
	 * 属性重开赔案上传标志/重开赔案上传标志的setter方法
	 */
	public void setRecaseFlag(String recaseFlag) {
		this.recaseFlag = recaseFlag;
	} 	
}