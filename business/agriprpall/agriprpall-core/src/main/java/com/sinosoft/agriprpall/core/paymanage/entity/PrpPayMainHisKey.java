package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-20 08:18:36.753 
 * 承保支付信息轨迹表主键操作对象
 */
public class PrpPayMainHisKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPayMainHisKey(){}
	public PrpPayMainHisKey(String payNo,String fCode,Integer serialNo){
		this.payNo = payNo;
		this.fCode = fCode;
		this.serialNo = serialNo;
	}
	/** 属性支付号/支付号 */
	@Column(name = "payNo")
	private String payNo ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性支付号/支付号的getter方法
	 */
	public String getPayNo() {
    		return payNo;
	}
	/**
	 * 属性支付号/支付号的setter方法
	 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
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
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}