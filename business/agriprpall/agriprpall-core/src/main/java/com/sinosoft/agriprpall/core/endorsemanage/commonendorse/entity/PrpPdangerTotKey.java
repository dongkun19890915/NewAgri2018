package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * PrpPdangerTot主键操作对象
 */
public class PrpPdangerTotKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPdangerTotKey(){}
	public PrpPdangerTotKey(String endorseNo,Integer dangerNo,String sCurrency){
		this.endorseNo = endorseNo;
		this.dangerNo = dangerNo;
		this.sCurrency = sCurrency;
	}
	/** 属性endorseno/endorseno */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private Integer dangerNo ;
	/** 属性币别/币别 */
	@Column(name = "sCurrency")
	private String sCurrency ;
	/**
	 * 属性endorseno/endorseno的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性endorseno/endorseno的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getSCurrency() {
    		return sCurrency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
	} 
}