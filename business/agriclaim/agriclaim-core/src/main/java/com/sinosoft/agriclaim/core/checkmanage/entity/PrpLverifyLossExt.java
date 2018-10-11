package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 处理意见表实体操作对象
 */
@Entity
@Table(name = "PrpLverifyLossExt")
@IdClass(PrpLverifyLossExtKey.class)
public class PrpLverifyLossExt extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "RiskCode")
	private String riskCode ;
	/** 属性序号/序号 */
	@Column(name = "SerialNo")
	private java.lang.Integer serialNo ;
	/** 属性录入日期/录入日期 */
	@Column(name = "InputDate")
	private java.util.Date inputDate ;
	/** 属性录入时间/录入时间 */
	@Column(name = "InputHour")
	private String inputHour ;
	/** 属性操作人员代码/操作人员代码 */
	@Column(name = "OperatorCode")
	private String operatorCode ;
	/** 属性机构代码/机构代码 */
	@Column(name = "ComCode")
	private String comCode ;
	/** 属性处理意见/处理意见 */
	@Column(name = "Title")
	private String title ;
	/** 属性具体内容/具体内容 */
	@Column(name = "Context")
	private String context ;
	/** 属性标的序号/标的序号 */
	@Column(name = "LossItemCode")
	private String lossItemCode ;
	/** 属性节点类型/节点类型 */
	@Column(name = "Nodetype")
	private String nodetype ;
	/** 属性联系电话/联系电话 */
	@Column(name = "TelPhoneNumber")
	private String telPhoneNumber ;
	/** 属性状态 0 新增 2 暂存 4 提交/状态 0 新增 2 暂存 4 提交 */
	@Column(name = "Status")
	private String status ;
	/** 属性FamilyName/FamilyName */
	@Column(name = "FamilyName")
	private String familyName ;
	/** 属性处理意见代码/处理意见代码 */
	@Column(name = "OpinionCode")
	private String opinionCode ;
	/** 属性Progress/Progress */
	@Column(name = "Progress")
	private String progress ;
	/** 属性占用时间/占用时间 */
	@Column(name = "OccupancyTime")
	private String occupancyTime ;
	/** 属性人员序号/人员序号 */
	@Column(name = "PersonNo")
	private String personNo ;
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
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性录入日期/录入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性录入日期/录入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性录入时间/录入时间的getter方法
	 */
	public String getInputHour() {
		return inputHour;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	} 	
	/**
	 * 属性操作人员代码/操作人员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作人员代码/操作人员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性处理意见/处理意见的getter方法
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 属性处理意见/处理意见的setter方法
	 */
	public void setTitle(String title) {
		this.title = title;
	} 	
	/**
	 * 属性具体内容/具体内容的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性具体内容/具体内容的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	} 	
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 	
	/**
	 * 属性节点类型/节点类型的getter方法
	 */
	public String getNodetype() {
		return nodetype;
	}
	/**
	 * 属性节点类型/节点类型的setter方法
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	} 	
	/**
	 * 属性联系电话/联系电话的getter方法
	 */
	public String getTelPhoneNumber() {
		return telPhoneNumber;
	}
	/**
	 * 属性联系电话/联系电话的setter方法
	 */
	public void setTelPhoneNumber(String telPhoneNumber) {
		this.telPhoneNumber = telPhoneNumber;
	} 	
	/**
	 * 属性状态 0 新增 2 暂存 4 提交/状态 0 新增 2 暂存 4 提交的getter方法
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 属性状态 0 新增 2 暂存 4 提交/状态 0 新增 2 暂存 4 提交的setter方法
	 */
	public void setStatus(String status) {
		this.status = status;
	} 	
	/**
	 * 属性FamilyName/FamilyName的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性FamilyName/FamilyName的setter方法
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	} 	
	/**
	 * 属性处理意见代码/处理意见代码的getter方法
	 */
	public String getOpinionCode() {
		return opinionCode;
	}
	/**
	 * 属性处理意见代码/处理意见代码的setter方法
	 */
	public void setOpinionCode(String opinionCode) {
		this.opinionCode = opinionCode;
	} 	
	/**
	 * 属性Progress/Progress的getter方法
	 */
	public String getProgress() {
		return progress;
	}
	/**
	 * 属性Progress/Progress的setter方法
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	} 	
	/**
	 * 属性占用时间/占用时间的getter方法
	 */
	public String getOccupancyTime() {
		return occupancyTime;
	}
	/**
	 * 属性占用时间/占用时间的setter方法
	 */
	public void setOccupancyTime(String occupancyTime) {
		this.occupancyTime = occupancyTime;
	} 	
	/**
	 * 属性人员序号/人员序号的getter方法
	 */
	public String getPersonNo() {
		return personNo;
	}
	/**
	 * 属性人员序号/人员序号的setter方法
	 */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	} 	
}