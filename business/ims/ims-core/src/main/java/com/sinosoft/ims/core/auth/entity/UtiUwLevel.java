package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwLevel实体操作对象
 */
@Entity
@Table(name = "UtiUwLevel")
@IdClass(UtiUwLevelKey.class)
public class UtiUwLevel extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性userCode/userCode */
	@Id
	@Column(name = "userCode")
	private String userCode ;/** 属性comCode/comCode */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性riskCode/riskCode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性modelNo/modelNo */
	@Id
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;/** 属性nodeNo/nodeNo */
	@Id
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;/** 属性uwType/uwType */
	@Id
	@Column(name = "uwType")
	private String uwType ;	





	/** 属性startDate/startDate */
	@Column(name = "startDate")
	private String startDate ;
	/** 属性endDate/endDate */
	@Column(name = "endDate")
	private String endDate ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;

	/**
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性modelNo/modelNo的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性modelNo/modelNo的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	} 	
	/**
	 * 属性nodeNo/nodeNo的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性nodeNo/nodeNo的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
	} 	
	/**
	 * 属性startDate/startDate的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性startDate/startDate的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性endDate/endDate的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性endDate/endDate的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性uwType/uwType的getter方法
	 */
	public String getUwType() {
		return uwType;
	}
	/**
	 * 属性uwType/uwType的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	} 	
}