package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 08:22:16.508 
 * PrpPdangerPlan主键操作对象
 */
public class PrpPdangerPlanKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPdangerPlanKey(){}
	public PrpPdangerPlanKey(String endorseNo,Integer dangerNo,Integer serialNo){
		this.endorseNo = endorseNo;
		this.dangerNo = dangerNo;
		this.serialNo = serialNo;
	}
	/** 属性endorseNo/endorseNo */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性dangerNo/dangerNo */
	@Column(name = "dangerNo")
	private Integer dangerNo ;
	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private Integer serialNo ;
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
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}