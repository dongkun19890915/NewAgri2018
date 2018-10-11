package com.sinosoft.agriclaim.api.schedulemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:49:33.975 
 * 驻点员App案件推送日志表Api操作对象
 */
public class ZdyClaimDemandDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	private String id ;		
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性推送的案件内容/推送的案件内容 */
	private String data ;		
	/** 属性推送成功的标志，1代表成功，0代表失败/推送成功的标志，1代表成功，0代表失败 */
	private String transFlag ;		
	/** 属性推送时间/推送时间 */
	private java.util.Date transDate ;		
	/**
	 * 属性序号/序号的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setId(String id) {
		this.id = id;
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
	/**
	 * 属性推送的案件内容/推送的案件内容的getter方法
	 */
	public String getData() {
		return data;
	}
	/**
	 * 属性推送的案件内容/推送的案件内容的setter方法
	 */
	public void setData(String data) {
		this.data = data;
	}	
	/**
	 * 属性推送成功的标志，1代表成功，0代表失败/推送成功的标志，1代表成功，0代表失败的getter方法
	 */
	public String getTransFlag() {
		return transFlag;
	}
	/**
	 * 属性推送成功的标志，1代表成功，0代表失败/推送成功的标志，1代表成功，0代表失败的setter方法
	 */
	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}	
	/**
	 * 属性推送时间/推送时间的getter方法
	 */
	public java.util.Date getTransDate() {
		return transDate;
	}
	/**
	 * 属性推送时间/推送时间的setter方法
	 */
	public void setTransDate(java.util.Date transDate) {
		this.transDate = transDate;
	}	
}
