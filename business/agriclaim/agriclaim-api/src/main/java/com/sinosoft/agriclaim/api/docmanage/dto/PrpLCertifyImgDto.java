package com.sinosoft.agriclaim.api.docmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 单证及影像表Api操作对象
 */
public class PrpLCertifyImgDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务号码/业务号码 */
	private String businessNo ;		
	/** 属性序号/序号 */
	private java.lang.Double serialNo ;		
	/** 属性标的代码/标的代码 */
	private String lossItemCode ;		
	/** 属性标的名称/标的名称 */
	private String lossItemName ;		
	/** 属性单证类型或图片类型/单证类型或图片类型 */
	private String typeCode ;		
	/** 属性图片名称/图片名称 */
	private String picName ;		
	/** 属性签收日期/签收日期 */
	private java.util.Date signInDate ;		
	/** 属性第三方传送图片代码（如易保代码）/第三方传送图片代码（如易保代码） */
	private String thirdPartyCode ;		
	/** 属性上传时文件名/上传时文件名 */
	private String uploadFileName ;		
	/** 属性影象文件名命名规则:businessno+typecode+serialno/影象文件名命名规则:businessno+typecode+serialno */
	private String imgFileName ;		
	/** 属性图片存放路径/图片存放路径 */
	private String picPath ;		
	/** 属性收集者/收集者 */
	private String collectorName ;		
	/** 属性接收状态(0:未接收，1：接收到)/接收状态(0:未接收，1：接收到) */
	private String receiveStatus ;		
	/** 属性标志位/标志位 */
	private String flag ;		
	/** 属性上传图片字节数大小/上传图片字节数大小 */
	private java.lang.Double imgSize ;		
	/** 属性上传图片的节点位置/上传图片的节点位置 */
	private String uploadNodeFlag ;		
	/** 属性显示名称(备注)/显示名称(备注) */
	private String displayName ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性当前状态/当前状态 */
	private String validStatus ;		
	/** 属性删除日期/删除日期 */
	private java.util.Date cancelDate ;		
	/** 属性上传文件路径/上传文件路径 */
	private String uploadFilepath ;		
	/** 属性删除人/删除人 */
	private String cancelPerson ;		
	/** 属性相机型号/相机型号 */
	private String camelModel ;		
	/** 属性拍照日期/拍照日期 */
	private java.util.Date dateTimeOriginal ;		
	/** 属性拍摄时间/拍摄时间 */
	private String shootTime ;		
	/** 属性图片大小/图片大小 */
	private java.lang.Double picSize ;		
	/** 属性类型名称/类型名称 */
	private String typeName ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性业务类型/业务类型 */
	private String businessType ;		
	/** 属性序号1/序号1 */
	private String itemKindNo ;		
	/** 属性单证降序/单证降序 */
	private String picDesc ;		
	/** 属性经度/经度 */
	private String lon ;		
	/** 属性纬度/纬度 */
	private String lat ;		
	/** 属性经纬度名称/经纬度名称 */
	private String lonLatName ;		
	/** 属性收集者代码/收集者代码 */
	private String collectorCode ;		
	/**
	 * 属性业务号码/业务号码的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号码/业务号码的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
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
	 * 属性标的名称/标的名称的getter方法
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * 属性标的名称/标的名称的setter方法
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}	
	/**
	 * 属性单证类型或图片类型/单证类型或图片类型的getter方法
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * 属性单证类型或图片类型/单证类型或图片类型的setter方法
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}	
	/**
	 * 属性图片名称/图片名称的getter方法
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * 属性图片名称/图片名称的setter方法
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}	
	/**
	 * 属性签收日期/签收日期的getter方法
	 */
	public java.util.Date getSignInDate() {
		return signInDate;
	}
	/**
	 * 属性签收日期/签收日期的setter方法
	 */
	public void setSignInDate(java.util.Date signInDate) {
		this.signInDate = signInDate;
	}	
	/**
	 * 属性第三方传送图片代码（如易保代码）/第三方传送图片代码（如易保代码）的getter方法
	 */
	public String getThirdPartyCode() {
		return thirdPartyCode;
	}
	/**
	 * 属性第三方传送图片代码（如易保代码）/第三方传送图片代码（如易保代码）的setter方法
	 */
	public void setThirdPartyCode(String thirdPartyCode) {
		this.thirdPartyCode = thirdPartyCode;
	}	
	/**
	 * 属性上传时文件名/上传时文件名的getter方法
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * 属性上传时文件名/上传时文件名的setter方法
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}	
	/**
	 * 属性影象文件名命名规则:businessno+typecode+serialno/影象文件名命名规则:businessno+typecode+serialno的getter方法
	 */
	public String getImgFileName() {
		return imgFileName;
	}
	/**
	 * 属性影象文件名命名规则:businessno+typecode+serialno/影象文件名命名规则:businessno+typecode+serialno的setter方法
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}	
	/**
	 * 属性图片存放路径/图片存放路径的getter方法
	 */
	public String getPicPath() {
		return picPath;
	}
	/**
	 * 属性图片存放路径/图片存放路径的setter方法
	 */
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}	
	/**
	 * 属性收集者/收集者的getter方法
	 */
	public String getCollectorName() {
		return collectorName;
	}
	/**
	 * 属性收集者/收集者的setter方法
	 */
	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}	
	/**
	 * 属性接收状态(0:未接收，1：接收到)/接收状态(0:未接收，1：接收到)的getter方法
	 */
	public String getReceiveStatus() {
		return receiveStatus;
	}
	/**
	 * 属性接收状态(0:未接收，1：接收到)/接收状态(0:未接收，1：接收到)的setter方法
	 */
	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性上传图片字节数大小/上传图片字节数大小的getter方法
	 */
	public java.lang.Double getImgSize() {
		return imgSize;
	}
	/**
	 * 属性上传图片字节数大小/上传图片字节数大小的setter方法
	 */
	public void setImgSize(java.lang.Double imgSize) {
		this.imgSize = imgSize;
	}	
	/**
	 * 属性上传图片的节点位置/上传图片的节点位置的getter方法
	 */
	public String getUploadNodeFlag() {
		return uploadNodeFlag;
	}
	/**
	 * 属性上传图片的节点位置/上传图片的节点位置的setter方法
	 */
	public void setUploadNodeFlag(String uploadNodeFlag) {
		this.uploadNodeFlag = uploadNodeFlag;
	}	
	/**
	 * 属性显示名称(备注)/显示名称(备注)的getter方法
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * 属性显示名称(备注)/显示名称(备注)的setter方法
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * 属性当前状态/当前状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性当前状态/当前状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性删除日期/删除日期的getter方法
	 */
	public java.util.Date getCancelDate() {
		return cancelDate;
	}
	/**
	 * 属性删除日期/删除日期的setter方法
	 */
	public void setCancelDate(java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
	}	
	/**
	 * 属性上传文件路径/上传文件路径的getter方法
	 */
	public String getUploadFilepath() {
		return uploadFilepath;
	}
	/**
	 * 属性上传文件路径/上传文件路径的setter方法
	 */
	public void setUploadFilepath(String uploadFilepath) {
		this.uploadFilepath = uploadFilepath;
	}	
	/**
	 * 属性删除人/删除人的getter方法
	 */
	public String getCancelPerson() {
		return cancelPerson;
	}
	/**
	 * 属性删除人/删除人的setter方法
	 */
	public void setCancelPerson(String cancelPerson) {
		this.cancelPerson = cancelPerson;
	}	
	/**
	 * 属性相机型号/相机型号的getter方法
	 */
	public String getCamelModel() {
		return camelModel;
	}
	/**
	 * 属性相机型号/相机型号的setter方法
	 */
	public void setCamelModel(String camelModel) {
		this.camelModel = camelModel;
	}	
	/**
	 * 属性拍照日期/拍照日期的getter方法
	 */
	public java.util.Date getDateTimeOriginal() {
		return dateTimeOriginal;
	}
	/**
	 * 属性拍照日期/拍照日期的setter方法
	 */
	public void setDateTimeOriginal(java.util.Date dateTimeOriginal) {
		this.dateTimeOriginal = dateTimeOriginal;
	}	
	/**
	 * 属性拍摄时间/拍摄时间的getter方法
	 */
	public String getShootTime() {
		return shootTime;
	}
	/**
	 * 属性拍摄时间/拍摄时间的setter方法
	 */
	public void setShootTime(String shootTime) {
		this.shootTime = shootTime;
	}	
	/**
	 * 属性图片大小/图片大小的getter方法
	 */
	public java.lang.Double getPicSize() {
		return picSize;
	}
	/**
	 * 属性图片大小/图片大小的setter方法
	 */
	public void setPicSize(java.lang.Double picSize) {
		this.picSize = picSize;
	}	
	/**
	 * 属性类型名称/类型名称的getter方法
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 属性类型名称/类型名称的setter方法
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性序号1/序号1的getter方法
	 */
	public String getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性序号1/序号1的setter方法
	 */
	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	}	
	/**
	 * 属性单证降序/单证降序的getter方法
	 */
	public String getPicDesc() {
		return picDesc;
	}
	/**
	 * 属性单证降序/单证降序的setter方法
	 */
	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc;
	}	
	/**
	 * 属性经度/经度的getter方法
	 */
	public String getLon() {
		return lon;
	}
	/**
	 * 属性经度/经度的setter方法
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}	
	/**
	 * 属性纬度/纬度的getter方法
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * 属性纬度/纬度的setter方法
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}	
	/**
	 * 属性经纬度名称/经纬度名称的getter方法
	 */
	public String getLonLatName() {
		return lonLatName;
	}
	/**
	 * 属性经纬度名称/经纬度名称的setter方法
	 */
	public void setLonLatName(String lonLatName) {
		this.lonLatName = lonLatName;
	}	
	/**
	 * 属性收集者代码/收集者代码的getter方法
	 */
	public String getCollectorCode() {
		return collectorCode;
	}
	/**
	 * 属性收集者代码/收集者代码的setter方法
	 */
	public void setCollectorCode(String collectorCode) {
		this.collectorCode = collectorCode;
	}	
}
