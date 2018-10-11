package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * nyxendorchgdetail主键操作对象
 */
public class NyxEndorChgDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public NyxEndorChgDetailKey(){}
	public NyxEndorChgDetailKey(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode){
		this.inusreListCode = inusreListCode;
		this.businessNo = businessNo;
		this.endorseNo = endorseNo;
		this.kindCode = kindCode;
		this.itemCode = itemCode;
	}
	/** 属性投保清单编号（key）/投保清单编号（key） */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性业务号（种植为农户身份证号,养殖为耳标号）/业务号（种植为农户身份证号,养殖为耳标号） */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性endorseNo/endorseNo */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性险别序号（key）/险别序号（key） */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性标的代码（key）/标的代码（key） */
	@Column(name = "itemCode")
	private String itemCode ;
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 
	/**
	 * 属性业务号（种植为农户身份证号,养殖为耳标号）/业务号（种植为农户身份证号,养殖为耳标号）的getter方法
	 */
	public String getBusinessNo() {
    		return businessNo;
	}
	/**
	 * 属性业务号（种植为农户身份证号,养殖为耳标号）/业务号（种植为农户身份证号,养殖为耳标号）的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 
	/**
	 * 属性endorseNo/endorseNo的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性endorseNo/endorseNo的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 
	/**
	 * 属性险别序号（key）/险别序号（key）的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别序号（key）/险别序号（key）的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性标的代码（key）/标的代码（key）的getter方法
	 */
	public String getItemCode() {
    		return itemCode;
	}
	/**
	 * 属性标的代码（key）/标的代码（key）的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 
}