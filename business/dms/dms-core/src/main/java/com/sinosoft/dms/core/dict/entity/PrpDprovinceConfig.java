package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * PrpDprovinceConfig实体操作对象
 */
@Entity
@Table(name = "PrpDprovinceConfigAgri")
@IdClass(PrpDprovinceConfigKey.class)
public class PrpDprovinceConfig extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性comcode/comcode */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性riskcode/riskcode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;	


	/** 属性comcname/comcname */
	@Column(name = "comCName")
	private String comCName ;
	/** 属性riskname/riskname */
	@Column(name = "riskName")
	private String riskName ;
	/** 属性bisinesstype1/bisinesstype1 */
	@Column(name = "bisinessType1")
	private String bisinessType1 ;
	/** 属性b5path/b5path */
	@Column(name = "b5Path")
	private String b5Path ;
	/** 属性versiontype/versiontype */
	@Column(name = "versionType")
	private String versionType ;
	/** 属性versionno/versionno */
	@Column(name = "versionNo")
	private String versionNo ;
	/** 属性startdate/startdate */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性enddate/enddate */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性comcode/comcode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comcode/comcode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性riskcode/riskcode的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性riskcode/riskcode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性comcname/comcname的getter方法
	 */
	public String getComCName() {
		return comCName;
	}
	/**
	 * 属性comcname/comcname的setter方法
	 */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	} 	
	/**
	 * 属性riskname/riskname的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性riskname/riskname的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	} 	
	/**
	 * 属性bisinesstype1/bisinesstype1的getter方法
	 */
	public String getBisinessType1() {
		return bisinessType1;
	}
	/**
	 * 属性bisinesstype1/bisinesstype1的setter方法
	 */
	public void setBisinessType1(String bisinessType1) {
		this.bisinessType1 = bisinessType1;
	} 	
	/**
	 * 属性b5path/b5path的getter方法
	 */
	public String getB5Path() {
		return b5Path;
	}
	/**
	 * 属性b5path/b5path的setter方法
	 */
	public void setB5Path(String b5Path) {
		this.b5Path = b5Path;
	} 	
	/**
	 * 属性versiontype/versiontype的getter方法
	 */
	public String getVersionType() {
		return versionType;
	}
	/**
	 * 属性versiontype/versiontype的setter方法
	 */
	public void setVersionType(String versionType) {
		this.versionType = versionType;
	} 	
	/**
	 * 属性versionno/versionno的getter方法
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * 属性versionno/versionno的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	} 	
	/**
	 * 属性startdate/startdate的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性startdate/startdate的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性enddate/enddate的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性enddate/enddate的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
}