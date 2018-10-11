package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * PrpDcustomerIdIndexApi操作对象
 */
public class PrpDcustomerIdIndexDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性证件类别/证件类别 */
	private String idType ;		
	/** 属性证件号码/证件号码 */
	private String customerId ;		
	/** 属性是否巳上传中保协 0：未上传  1：已上传/是否巳上传中保协 0：未上传  1：已上传 */
	private String isUpload ;		
	/** 属性上传日期/上传日期 */
	private java.util.Date uploadDate ;		
	/** 属性同步批次号/同步批次号 */
	private String batchNo ;		
	/** 属性分组序号/分组序号 */
	private String sequenceNo ;		
	/** 属性ID/ID */
	private String id ;
	/**
	 * 属性证件类别/证件类别的getter方法
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 属性证件类别/证件类别的setter方法
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}	
	/**
	 * 属性证件号码/证件号码的getter方法
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * 属性证件号码/证件号码的setter方法
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}	
	/**
	 * 属性是否巳上传中保协 0：未上传  1：已上传/是否巳上传中保协 0：未上传  1：已上传的getter方法
	 */
	public String getIsUpload() {
		return isUpload;
	}
	/**
	 * 属性是否巳上传中保协 0：未上传  1：已上传/是否巳上传中保协 0：未上传  1：已上传的setter方法
	 */
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}	
	/**
	 * 属性上传日期/上传日期的getter方法
	 */
	public java.util.Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * 属性上传日期/上传日期的setter方法
	 */
	public void setUploadDate(java.util.Date uploadDate) {
		this.uploadDate = uploadDate;
	}	
	/**
	 * 属性同步批次号/同步批次号的getter方法
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * 属性同步批次号/同步批次号的setter方法
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}	
	/**
	 * 属性分组序号/分组序号的getter方法
	 */
	public String getSequenceNo() {
		return sequenceNo;
	}
	/**
	 * 属性分组序号/分组序号的setter方法
	 */
	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
