package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * 牲畜耳标号/脚环号表主键操作对象
 * @author: 何伟东
 * @date: 2017/12/19 9:51
 */
public class GisHerdFieldKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public GisHerdFieldKey(){}
	public GisHerdFieldKey(String insureListCode,String fCode,Integer serialNo,String earLabel){
		this.insureListCode = insureListCode;
		this.fCode = fCode;
		this.serialNo = serialNo;
		this.earLabel = earLabel;
	}
	/** 属性清单编号/清单编号 */
	@Column(name = "insureListCode")
	private String insureListCode ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性序列号/序列号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earLabel")
	private String earLabel ;
	/**
	 * 属性清单编号/清单编号的getter方法
	 */
	public String getInsureListCode() {
    		return insureListCode;
	}
	/**
	 * 属性清单编号/清单编号的setter方法
	 */
	public void setInsureListCode(String insureListCode) {
		this.insureListCode = insureListCode;
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
	/**
	 * 属性序列号/序列号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
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
}