package com.sinosoft.txnlist.core.insuremainlist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * 清单主表实体操作对象
 */
@Entity
@Table(name = "InsureMainList")
@IdClass(InsureMainListKey.class)
public class InsureMainList extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保清单编号（key）/投保清单编号（key） */
	@Id
	@Column(name = "inusreListCode")
	private String inusreListCode;

	@Column(name = "gisInsureListCode")
	private String gisInsureListCode;

	/** 属性区域代码/区域代码 */
	@Column(name = "fAreaCode")
	private String fAreaCode;
	/** 属性险类/险类 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性清单标志（0未提交、1已关联未提交、2正常，3注销）/清单标志（0未提交、1已关联未提交、2正常，3注销） */
	@Column(name = "validity")
	private String validity ;
	/** 属性上次编辑代码/上次编辑代码 */
	@Column(name = "updateCode")
	private String updateCode ;
	/** 属性上次编辑时间/上次编辑时间 */
	@Column(name = "updateDate")
	private Date updateDate ;
	/** 属性关联操作员代码/关联操作员代码 */
	@Column(name = "opCode")
	private String opCode ;
	/** 属性投保备注/投保备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性开始时间/开始时间 */
	@Column(name = "startTime")
	private Date startTime ;
	/** 属性结束时间/结束时间 */
	@Column(name = "endTime")
	private Date endTime ;
	/** 属性投保人姓名/投保人姓名 */
	@Column(name = "policyName")
	private String policyName ;
	/** 属性导出标志位/导出标志位 */
	@Column(name = "exportFlag")
	private String exportFlag ;
	/** 属性导出人/导出人 */
	@Column(name = "exportUserCode")
	private String exportUserCode;
	/** 属性导出时间/导出时间 */
	@Column(name = "exportDate")
	private Date exportDate ;
	@Column(name = "serialNo")
	private Integer serialNo;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getGisInsureListCode() {
		return gisInsureListCode;
	}

	public void setGisInsureListCode(String gisInsureListCode) {
		this.gisInsureListCode = gisInsureListCode;
	}

	public String getInusreListCode() {
		return inusreListCode;
	}

	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	}

	public String getfAreaCode() {
		return fAreaCode;
	}

	public void setfAreaCode(String fAreaCode) {
		this.fAreaCode = fAreaCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public String getExportUserCode() {
		return exportUserCode;
	}

	public void setExportUserCode(String exportUserCode) {
		this.exportUserCode = exportUserCode;
	}

	public Date getExportDate() {
		return exportDate;
	}

	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}
}