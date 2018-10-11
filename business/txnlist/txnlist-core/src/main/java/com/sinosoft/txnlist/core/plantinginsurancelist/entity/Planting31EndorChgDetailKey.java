package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * planting31endorchgdetail主键操作对象
 */
public class Planting31EndorChgDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public Planting31EndorChgDetailKey(){}
	public Planting31EndorChgDetailKey(String inusreListCode,String endorseNo,String kindCode,String itemCode,String fIdCard){
		this.inusreListCode = inusreListCode;
		this.endorseNo = endorseNo;
		this.kindCode = kindCode;
		this.itemCode = itemCode;
		this.fIdCard = fIdCard;
	}
	/** 属性inusreListCode/inusreListCode */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性endorseNo/endorseNo */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性kindCode/kindCode */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性itemCode/itemCode */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性fIdCard/fIdCard */
	@Column(name = "fIdCard")
	private String fIdCard ;
	/**
	 * 属性inusreListCode/inusreListCode的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性inusreListCode/inusreListCode的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
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
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性itemCode/itemCode的getter方法
	 */
	public String getItemCode() {
    		return itemCode;
	}
	/**
	 * 属性itemCode/itemCode的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 
	/**
	 * 属性fIdCard/fIdCard的getter方法
	 */
	public String getFIdCard() {
    		return fIdCard;
	}
	/**
	 * 属性fIdCard/fIdCard的setter方法
	 */
	public void setFIdCard(String fIdCard) {
		this.fIdCard = fIdCard;
	} 
}