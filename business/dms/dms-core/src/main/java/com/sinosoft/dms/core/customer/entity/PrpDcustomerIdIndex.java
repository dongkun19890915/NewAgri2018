package com.sinosoft.dms.core.customer.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * PrpDcustomerIdIndex实体操作对象
 */
@Entity
@Table(name = "PrpDcustomerIdIndex")
@IdClass(PrpDcustomerIdIndexKey.class)
public class PrpDcustomerIdIndex extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性证件号码/证件号码 */
	@Id
	@Column(name = "customerId")
	private String customerId ;
	/** 属性证件类别/证件类别 */
	@Column(name = "idType")
	private String idType ;

	/** 属性是否巳上传中保协 0：未上传  1：已上传/是否巳上传中保协 0：未上传  1：已上传 */
	@Column(name = "isUpload")
	private String isUpload ;
	/** 属性上传日期/上传日期 */
	@Column(name = "uploadDate")
	private java.util.Date uploadDate ;
	/** 属性同步批次号/同步批次号 */
	@Column(name = "batchNo")
	private String batchNo ;
	/** 属性分组序号/分组序号 */
	@Column(name = "sequenceNo")
	private String sequenceNo ;

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

}