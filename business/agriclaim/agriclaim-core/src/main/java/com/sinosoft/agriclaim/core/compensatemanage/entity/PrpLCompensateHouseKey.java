package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 农房理赔身份证信息表主键操作对象
 */
public class PrpLCompensateHouseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCompensateHouseKey(){}
	public PrpLCompensateHouseKey(String idcard,String registNo,String nodeType,String businessNo){
		this.idcard = idcard;
		this.registNo = registNo;
		this.nodeType = nodeType;
		this.businessNo = businessNo;
	}
	/** 属性身份证号/身份证号 */
	@Column(name = "idcard")
	private String idcard ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性节点名称/节点名称 */
	@Column(name = "nodeType")
	private String nodeType ;
	/** 属性业务号/业务号 */
	@Column(name = "businessNo")
	private String businessNo ;
	/**
	 * 属性身份证号/身份证号的getter方法
	 */
	public String getIdcard() {
    		return idcard;
	}
	/**
	 * 属性身份证号/身份证号的setter方法
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	 * 属性节点名称/节点名称的getter方法
	 */
	public String getNodeType() {
    		return nodeType;
	}
	/**
	 * 属性节点名称/节点名称的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getBusinessNo() {
    		return businessNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 
}