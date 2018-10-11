package com.sinosoft.txnlist.api.insuremainlist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * 清单主表Api操作对象
 */
public class InsureMainListDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保清单编号（key）/投保清单编号（key） */
	private String inusreListCode ;		
	/** 属性区域代码/区域代码 */
    private String fAreaCode;
    /**
     * 属性险类/险类
     */
    private String classCode ;
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性清单标志（0未提交、1已关联未提交、2正常，3注销）/清单标志（0未提交、1已关联未提交、2正常，3注销） */
	private String validity ;		
	/** 属性上次编辑代码/上次编辑代码 */
	private String updateCode ;		
	/** 属性上次编辑时间/上次编辑时间 */
	private java.util.Date updateDate ;		
	/** 属性关联操作员代码/关联操作员代码 */
	private String opCode ;		
	/** 属性投保备注/投保备注 */
	private String remark ;		
	/** 属性开始时间/开始时间 */
	private java.util.Date startTime ;		
	/** 属性结束时间/结束时间 */
	private java.util.Date endTime ;		
	/** 属性投保人姓名/投保人姓名 */
	private String policyName ;		
	/** 属性导出标志位/导出标志位 */
	private String exportFlag ;		
	/** 属性导出人/导出人 */
    private String exportUserCode;
    /** 属性导出时间/导出时间 */
    private java.util.Date exportDate;

    private String gisInsureListCode;
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

	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单编号（key）/投保清单编号（key）的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
    }

    public String getfAreaCode() {
        return fAreaCode;
    }

    public void setfAreaCode(String fAreaCode) {
        this.fAreaCode = fAreaCode;
    }

	/**
	 * 属性险类/险类的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类/险类的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性清单标志（0未提交、1已关联未提交、2正常，3注销）/清单标志（0未提交、1已关联未提交、2正常，3注销）的getter方法
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * 属性清单标志（0未提交、1已关联未提交、2正常，3注销）/清单标志（0未提交、1已关联未提交、2正常，3注销）的setter方法
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}	
	/**
	 * 属性上次编辑代码/上次编辑代码的getter方法
	 */
	public String getUpdateCode() {
		return updateCode;
	}
	/**
	 * 属性上次编辑代码/上次编辑代码的setter方法
	 */
	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}	
	/**
	 * 属性上次编辑时间/上次编辑时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性上次编辑时间/上次编辑时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性关联操作员代码/关联操作员代码的getter方法
	 */
	public String getOpCode() {
		return opCode;
	}
	/**
	 * 属性关联操作员代码/关联操作员代码的setter方法
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}	
	/**
	 * 属性投保备注/投保备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性投保备注/投保备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性开始时间/开始时间的getter方法
	 */
	public java.util.Date getStartTime() {
		return startTime;
	}
	/**
	 * 属性开始时间/开始时间的setter方法
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}	
	/**
	 * 属性结束时间/结束时间的getter方法
	 */
	public java.util.Date getEndTime() {
		return endTime;
	}
	/**
	 * 属性结束时间/结束时间的setter方法
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}	
	/**
	 * 属性投保人姓名/投保人姓名的getter方法
	 */
	public String getPolicyName() {
		return policyName;
	}
	/**
	 * 属性投保人姓名/投保人姓名的setter方法
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}	
	/**
	 * 属性导出标志位/导出标志位的getter方法
	 */
	public String getExportFlag() {
		return exportFlag;
	}
	/**
	 * 属性导出标志位/导出标志位的setter方法
	 */
	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}	
	/**
	 * 属性导出人/导出人的getter方法
     */
    public String getExportUserCode() {
        return exportUserCode;
    }

    /**
	 * 属性导出人/导出人的setter方法
     */
    public void setExportUserCode(String exportUserCode) {
        this.exportUserCode = exportUserCode;
    }

    /**
	 * 属性导出时间/导出时间的getter方法
	 */
	public java.util.Date getExportDate() {
		return exportDate;
	}
	/**
	 * 属性导出时间/导出时间的setter方法
	 */
	public void setExportDate(java.util.Date exportDate) {
		this.exportDate = exportDate;
	}	
}
