package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 代理赔保单信息表实体操作对象
 */
@Entity
@Table(name = "PrpLClaimagent")
@IdClass(PrpLClaimagentKey.class)
public class PrpLClaimagent extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	@Id
	@Column(name = "claimNo")
	private String claimNo ;	

	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性承保地区编码/承保地区编码 */
	@Column(name = "centreCode")
	private String centreCode ;
	/** 属性承保地区名称/承保地区名称 */
	@Column(name = "centreName")
	private String centreName ;
	/** 属性承保公司编码/承保公司编码 */
	@Column(name = "unitCode")
	private String unitCode ;
	/** 属性承保公司名称/承保公司名称 */
	@Column(name = "unitName")
	private String unitName ;
	/** 属性签单日期/签单日期 */
	@Column(name = "operateDate")
	private java.util.Date operateDate ;
	/** 属性运输方式/运输方式 */
	@Column(name = "conveyance")
	private String conveyance ;
	/** 属性启运地编码/启运地编码 */
	@Column(name = "startSiteCode")
	private String startSiteCode ;
	/** 属性启运地名称/启运地名称 */
	@Column(name = "startSiteName")
	private String startSiteName ;
	/** 属性中转地编码/中转地编码 */
	@Column(name = "viaSiteCode")
	private String viaSiteCode ;
	/** 属性中转地名称/中转地名称 */
	@Column(name = "viaSiteName")
	private String viaSiteName ;
	/** 属性目的地编码/目的地编码 */
	@Column(name = "endSiteCode")
	private String endSiteCode ;
	/** 属性目的地名称/目的地名称 */
	@Column(name = "endSiteName")
	private String endSiteName ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性承保地区编码/承保地区编码的getter方法
	 */
	public String getCentreCode() {
		return centreCode;
	}
	/**
	 * 属性承保地区编码/承保地区编码的setter方法
	 */
	public void setCentreCode(String centreCode) {
		this.centreCode = centreCode;
	} 	
	/**
	 * 属性承保地区名称/承保地区名称的getter方法
	 */
	public String getCentreName() {
		return centreName;
	}
	/**
	 * 属性承保地区名称/承保地区名称的setter方法
	 */
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	} 	
	/**
	 * 属性承保公司编码/承保公司编码的getter方法
	 */
	public String getUnitCode() {
		return unitCode;
	}
	/**
	 * 属性承保公司编码/承保公司编码的setter方法
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	} 	
	/**
	 * 属性承保公司名称/承保公司名称的getter方法
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * 属性承保公司名称/承保公司名称的setter方法
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	} 	
	/**
	 * 属性签单日期/签单日期的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性签单日期/签单日期的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	} 	
	/**
	 * 属性运输方式/运输方式的getter方法
	 */
	public String getConveyance() {
		return conveyance;
	}
	/**
	 * 属性运输方式/运输方式的setter方法
	 */
	public void setConveyance(String conveyance) {
		this.conveyance = conveyance;
	} 	
	/**
	 * 属性启运地编码/启运地编码的getter方法
	 */
	public String getStartSiteCode() {
		return startSiteCode;
	}
	/**
	 * 属性启运地编码/启运地编码的setter方法
	 */
	public void setStartSiteCode(String startSiteCode) {
		this.startSiteCode = startSiteCode;
	} 	
	/**
	 * 属性启运地名称/启运地名称的getter方法
	 */
	public String getStartSiteName() {
		return startSiteName;
	}
	/**
	 * 属性启运地名称/启运地名称的setter方法
	 */
	public void setStartSiteName(String startSiteName) {
		this.startSiteName = startSiteName;
	} 	
	/**
	 * 属性中转地编码/中转地编码的getter方法
	 */
	public String getViaSiteCode() {
		return viaSiteCode;
	}
	/**
	 * 属性中转地编码/中转地编码的setter方法
	 */
	public void setViaSiteCode(String viaSiteCode) {
		this.viaSiteCode = viaSiteCode;
	} 	
	/**
	 * 属性中转地名称/中转地名称的getter方法
	 */
	public String getViaSiteName() {
		return viaSiteName;
	}
	/**
	 * 属性中转地名称/中转地名称的setter方法
	 */
	public void setViaSiteName(String viaSiteName) {
		this.viaSiteName = viaSiteName;
	} 	
	/**
	 * 属性目的地编码/目的地编码的getter方法
	 */
	public String getEndSiteCode() {
		return endSiteCode;
	}
	/**
	 * 属性目的地编码/目的地编码的setter方法
	 */
	public void setEndSiteCode(String endSiteCode) {
		this.endSiteCode = endSiteCode;
	} 	
	/**
	 * 属性目的地名称/目的地名称的getter方法
	 */
	public String getEndSiteName() {
		return endSiteName;
	}
	/**
	 * 属性目的地名称/目的地名称的setter方法
	 */
	public void setEndSiteName(String endSiteName) {
		this.endSiteName = endSiteName;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}