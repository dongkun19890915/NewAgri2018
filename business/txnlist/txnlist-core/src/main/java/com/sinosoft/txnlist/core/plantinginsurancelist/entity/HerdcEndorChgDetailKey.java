package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-08 01:17:24.831 
 * HerdcEndorChgDetail主键操作对象
 */
public class HerdcEndorChgDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public HerdcEndorChgDetailKey(){}
	public HerdcEndorChgDetailKey(String inusreListCode,String earLabel,String kindCode,String fCode){
		this.inusreListCode = inusreListCode;
		this.earLabel = earLabel;
		this.kindCode = kindCode;
		this.fCode = fCode;
	}
	/** 属性inusreListCode/inusreListCode */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性earLabel/earLabel */
	@Column(name = "earLabel")
	private String earLabel ;
	/** 属性kindCode/kindCode */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性fCode/fCode */
	@Column(name = "fCode")
	private String fCode ;
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
	 * 属性earLabel/earLabel的getter方法
	 */
	public String getEarLabel() {
    		return earLabel;
	}
	/**
	 * 属性earLabel/earLabel的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
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
	 * 属性fCode/fCode的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性fCode/fCode的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
}