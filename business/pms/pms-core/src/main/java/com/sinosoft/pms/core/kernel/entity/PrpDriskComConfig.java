package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDriskComConfig实体操作对象
 */
@Entity
@Table(name = "PrpDriskComConfigAgri")
@IdClass(PrpDriskComConfigKey.class)
public class PrpDriskComConfig extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性id/id */
	@Id
	@Column(name = "id")
	private java.util.Date id ;	
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性机构代码/机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性条款报备代码/条款报备代码 */
	@Column(name = "reportCode")
	private String reportCode ;
	/** 属性条款名称/条款名称 */
	@Column(name = "riskCName")
	private String riskCName ;
	/** 属性有效标志位：0：无效；1：有效/有效标志位：0：无效；1：有效 */
	@Column(name = "validity")
	private String validity ;
	/** 属性政策性标志:01:中央政策性; 02:地方政策性; 00:商业性/政策性标志:01:中央政策性; 02:地方政策性; 00:商业性 */
	@Column(name = "businessType")
	private String businessType ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性系统条款启用时间/系统条款启用时间 */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性系统条款终止时间/系统条款终止时间 */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性条款提交日期/条款提交日期 */
	@Column(name = "submitDate")
	private java.util.Date submitDate ;
	/** 属性条款打印文件路径/条款打印文件路径 */
	@Column(name = "temp1")
	private String temp1 ;
	/** 属性temp2/temp2 */
	@Column(name = "temp2")
	private String temp2 ;
	/** 属性temp3/temp3 */
	@Column(name = "temp3")
	private String temp3 ;
	/** 属性temp4/temp4 */
	@Column(name = "temp4")
	private java.util.Date temp4 ;

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
	 * 属性条款报备代码/条款报备代码的getter方法
	 */
	public String getReportCode() {
		return reportCode;
	}
	/**
	 * 属性条款报备代码/条款报备代码的setter方法
	 */
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	} 	
	/**
	 * 属性条款名称/条款名称的getter方法
	 */
	public String getRiskCName() {
		return riskCName;
	}
	/**
	 * 属性条款名称/条款名称的setter方法
	 */
	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	} 	
	/**
	 * 属性有效标志位：0：无效；1：有效/有效标志位：0：无效；1：有效的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性有效标志位：0：无效；1：有效/有效标志位：0：无效；1：有效的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	} 	
	/**
	 * 属性政策性标志:01:中央政策性; 02:地方政策性; 00:商业性/政策性标志:01:中央政策性; 02:地方政策性; 00:商业性的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性政策性标志:01:中央政策性; 02:地方政策性; 00:商业性/政策性标志:01:中央政策性; 02:地方政策性; 00:商业性的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	} 	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性系统条款启用时间/系统条款启用时间的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性系统条款启用时间/系统条款启用时间的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性系统条款终止时间/系统条款终止时间的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性系统条款终止时间/系统条款终止时间的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性条款提交日期/条款提交日期的getter方法
	 */
	public java.util.Date getSubmitDate() {
		return submitDate;
	}
	/**
	 * 属性条款提交日期/条款提交日期的setter方法
	 */
	public void setSubmitDate(java.util.Date submitDate) {
		this.submitDate = submitDate;
	} 	
	/**
	 * 属性条款打印文件路径/条款打印文件路径的getter方法
	 */
	public String getTemp1() {
		return temp1;
	}
	/**
	 * 属性条款打印文件路径/条款打印文件路径的setter方法
	 */
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	} 	
	/**
	 * 属性temp2/temp2的getter方法
	 */
	public String getTemp2() {
		return temp2;
	}
	/**
	 * 属性temp2/temp2的setter方法
	 */
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	} 	
	/**
	 * 属性temp3/temp3的getter方法
	 */
	public String getTemp3() {
		return temp3;
	}
	/**
	 * 属性temp3/temp3的setter方法
	 */
	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	} 	
	/**
	 * 属性temp4/temp4的getter方法
	 */
	public java.util.Date getTemp4() {
		return temp4;
	}
	/**
	 * 属性temp4/temp4的setter方法
	 */
	public void setTemp4(java.util.Date temp4) {
		this.temp4 = temp4;
	} 	
	/**
	 * 属性id/id的getter方法
	 */
	public java.util.Date getId() {
		return id;
	}
	/**
	 * 属性id/id的setter方法
	 */
	public void setId(java.util.Date id) {
		this.id = id;
	} 	
}