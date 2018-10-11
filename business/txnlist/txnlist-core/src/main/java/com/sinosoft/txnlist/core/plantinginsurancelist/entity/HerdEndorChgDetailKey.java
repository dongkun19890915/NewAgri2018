package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-14 07:07:05.012 
 * 养殖险保单清单最新数据表主键操作对象
 */
public class HerdEndorChgDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public HerdEndorChgDetailKey(){}
	public HerdEndorChgDetailKey(String inusreListCode,String earLabel,String endorseNo,String kindCode,String fCode){
		this.inusreListCode = inusreListCode;
		this.earLabel = earLabel;
		this.endorseNo = endorseNo;
		this.kindCode = kindCode;
		this.fCode = fCode;
	}
	/** 属性投保清单编号/投保清单编号 */
	@Column(name = "inusreListCode")
	private String inusreListCode ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earLabel")
	private String earLabel ;
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性险别序号/险别序号 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/**
	 * 属性投保清单编号/投保清单编号的getter方法
	 */
	public String getInusreListCode() {
    		return inusreListCode;
	}
	/**
	 * 属性投保清单编号/投保清单编号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	} 
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarLabel() {
    		return earLabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	} 
	/**
	 * 属性批单号/批单号的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性批单号/批单号的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
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
}