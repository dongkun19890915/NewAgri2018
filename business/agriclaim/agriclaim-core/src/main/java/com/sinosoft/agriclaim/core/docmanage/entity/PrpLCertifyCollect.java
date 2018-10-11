package com.sinosoft.agriclaim.core.docmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 单证收集表实体操作对象
 */
@Entity
@Table(name = "PrpLCertifyCollect")
@IdClass(PrpLCertifyCollectKey.class)
public class PrpLCertifyCollect extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性业务号码/业务号码 */
	@Id
	@Column(name = "businessNo")
	private String businessNo ;/** 属性标的代码/标的代码 */
	@Id
	@Column(name = "lossItemCode")
	private String lossItemCode ;	


	/** 属性标的名称/标的名称 */
	@Column(name = "lossItemName")
	private String lossItemName ;
	/** 属性单证份数/单证份数 */
	@Column(name = "picCount")
	private java.lang.Double picCount ;
	/** 属性单证开始收集日期/单证开始收集日期 */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性单证开始收集小时/单证开始收集小时 */
	@Column(name = "startHour")
	private String startHour ;
	/** 属性单证结束收集日期/单证结束收集日期 */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性单证结束收集小时/单证结束收集小时 */
	@Column(name = "endHour")
	private String endHour ;
	/** 属性操作员/操作员 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性收集标志/收集标志 */
	@Column(name = "collectFlag")
	private String collectFlag ;
	/** 属性主车收集标志/主车收集标志 */
	@Column(name = "cltinSureCarFlag")
	private String cltinSureCarFlag ;
	/** 属性三者车收集标志/三者车收集标志 */
	@Column(name = "cltThirdCarFlag")
	private String cltThirdCarFlag ;
	/** 属性人伤收集标志/人伤收集标志 */
	@Column(name = "cltPersonFlag")
	private String cltPersonFlag ;
	/** 属性物损收集标志/物损收集标志 */
	@Column(name = "cltPropFlag")
	private String cltPropFlag ;
	/** 属性盗抢收集标志/盗抢收集标志 */
	@Column(name = "cltCarLossFlag")
	private String cltCarLossFlag ;
	/** 属性全损收集标志/全损收集标志 */
	@Column(name = "cltAllLossFlag")
	private String cltAllLossFlag ;
	/** 属性存放事故类型/存放事故类型 */
	@Column(name = "caseFlag")
	private String caseFlag ;
	/** 属性案件处理意见/案件处理意见 */
	@Column(name = "content")
	private String content ;
	/** 属性标志位/标志位 */
	@Column(name = "flag")
	private String flag ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性年/年 */
	@Column(name = "uploadYear")
	private String uploadYear ;
	/** 属性强制保险收集标志/强制保险收集标志 */
	@Column(name = "compelFlag")
	private String compelFlag ;
	/** 属性查勘收单/查勘收单 */
	@Column(name = "checkCertiyFlag")
	private java.lang.Double checkCertiyFlag ;
	/** 属性公估收单/公估收单 */
	@Column(name = "appraisalCertiyFlag")
	private String appraisalCertiyFlag ;
	/** 属性客户收单/客户收单 */
	@Column(name = "clientCertiyFlag")
	private String clientCertiyFlag ;
	/** 属性医核收单/医核收单 */
	@Column(name = "medicalAuditCertiyFlag")
	private String medicalAuditCertiyFlag ;
	/** 属性理算收单/理算收单 */
	@Column(name = "compeCertiyFlag")
	private String compeCertiyFlag ;
	/** 属性查勘收单时间/查勘收单时间 */
	@Column(name = "checkCertiyDate")
	private String checkCertiyDate ;
	/** 属性公估收单时间/公估收单时间 */
	@Column(name = "appraisalCertiyDate")
	private String appraisalCertiyDate ;
	/** 属性客户收单时间/客户收单时间 */
	@Column(name = "clientCertiyDate")
	private String clientCertiyDate ;
	/** 属性医核收单时间/医核收单时间 */
	@Column(name = "medicalAuditCertiyDate")
	private String medicalAuditCertiyDate ;
	/** 属性理算收单时间/理算收单时间 */
	@Column(name = "compeCertiyDate")
	private String compeCertiyDate ;
	/** 属性重开赔案上传标志/重开赔案上传标志 */
	@Column(name = "recaseFlag")
	private String recaseFlag ;
	/**
	 * 属性业务号码/业务号码的getter方法
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 属性业务号码/业务号码的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 	
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 	
	/**
	 * 属性标的名称/标的名称的getter方法
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * 属性标的名称/标的名称的setter方法
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	} 	
	/**
	 * 属性单证份数/单证份数的getter方法
	 */
	public java.lang.Double getPicCount() {
		return picCount;
	}
	/**
	 * 属性单证份数/单证份数的setter方法
	 */
	public void setPicCount(java.lang.Double picCount) {
		this.picCount = picCount;
	} 	
	/**
	 * 属性单证开始收集日期/单证开始收集日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性单证开始收集日期/单证开始收集日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性单证开始收集小时/单证开始收集小时的getter方法
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * 属性单证开始收集小时/单证开始收集小时的setter方法
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	} 	
	/**
	 * 属性单证结束收集日期/单证结束收集日期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性单证结束收集日期/单证结束收集日期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性单证结束收集小时/单证结束收集小时的getter方法
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * 属性单证结束收集小时/单证结束收集小时的setter方法
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	} 	
	/**
	 * 属性操作员/操作员的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员/操作员的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性收集标志/收集标志的getter方法
	 */
	public String getCollectFlag() {
		return collectFlag;
	}
	/**
	 * 属性收集标志/收集标志的setter方法
	 */
	public void setCollectFlag(String collectFlag) {
		this.collectFlag = collectFlag;
	} 	
	/**
	 * 属性主车收集标志/主车收集标志的getter方法
	 */
	public String getCltinSureCarFlag() {
		return cltinSureCarFlag;
	}
	/**
	 * 属性主车收集标志/主车收集标志的setter方法
	 */
	public void setCltinSureCarFlag(String cltinSureCarFlag) {
		this.cltinSureCarFlag = cltinSureCarFlag;
	} 	
	/**
	 * 属性三者车收集标志/三者车收集标志的getter方法
	 */
	public String getCltThirdCarFlag() {
		return cltThirdCarFlag;
	}
	/**
	 * 属性三者车收集标志/三者车收集标志的setter方法
	 */
	public void setCltThirdCarFlag(String cltThirdCarFlag) {
		this.cltThirdCarFlag = cltThirdCarFlag;
	} 	
	/**
	 * 属性人伤收集标志/人伤收集标志的getter方法
	 */
	public String getCltPersonFlag() {
		return cltPersonFlag;
	}
	/**
	 * 属性人伤收集标志/人伤收集标志的setter方法
	 */
	public void setCltPersonFlag(String cltPersonFlag) {
		this.cltPersonFlag = cltPersonFlag;
	} 	
	/**
	 * 属性物损收集标志/物损收集标志的getter方法
	 */
	public String getCltPropFlag() {
		return cltPropFlag;
	}
	/**
	 * 属性物损收集标志/物损收集标志的setter方法
	 */
	public void setCltPropFlag(String cltPropFlag) {
		this.cltPropFlag = cltPropFlag;
	} 	
	/**
	 * 属性盗抢收集标志/盗抢收集标志的getter方法
	 */
	public String getCltCarLossFlag() {
		return cltCarLossFlag;
	}
	/**
	 * 属性盗抢收集标志/盗抢收集标志的setter方法
	 */
	public void setCltCarLossFlag(String cltCarLossFlag) {
		this.cltCarLossFlag = cltCarLossFlag;
	} 	
	/**
	 * 属性全损收集标志/全损收集标志的getter方法
	 */
	public String getCltAllLossFlag() {
		return cltAllLossFlag;
	}
	/**
	 * 属性全损收集标志/全损收集标志的setter方法
	 */
	public void setCltAllLossFlag(String cltAllLossFlag) {
		this.cltAllLossFlag = cltAllLossFlag;
	} 	
	/**
	 * 属性存放事故类型/存放事故类型的getter方法
	 */
	public String getCaseFlag() {
		return caseFlag;
	}
	/**
	 * 属性存放事故类型/存放事故类型的setter方法
	 */
	public void setCaseFlag(String caseFlag) {
		this.caseFlag = caseFlag;
	} 	
	/**
	 * 属性案件处理意见/案件处理意见的getter方法
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 属性案件处理意见/案件处理意见的setter方法
	 */
	public void setContent(String content) {
		this.content = content;
	} 	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * 属性年/年的getter方法
	 */
	public String getUploadYear() {
		return uploadYear;
	}
	/**
	 * 属性年/年的setter方法
	 */
	public void setUploadYear(String uploadYear) {
		this.uploadYear = uploadYear;
	} 	
	/**
	 * 属性强制保险收集标志/强制保险收集标志的getter方法
	 */
	public String getCompelFlag() {
		return compelFlag;
	}
	/**
	 * 属性强制保险收集标志/强制保险收集标志的setter方法
	 */
	public void setCompelFlag(String compelFlag) {
		this.compelFlag = compelFlag;
	} 	
	/**
	 * 属性查勘收单/查勘收单的getter方法
	 */
	public java.lang.Double getCheckCertiyFlag() {
		return checkCertiyFlag;
	}
	/**
	 * 属性查勘收单/查勘收单的setter方法
	 */
	public void setCheckCertiyFlag(java.lang.Double checkCertiyFlag) {
		this.checkCertiyFlag = checkCertiyFlag;
	} 	
	/**
	 * 属性公估收单/公估收单的getter方法
	 */
	public String getAppraisalCertiyFlag() {
		return appraisalCertiyFlag;
	}
	/**
	 * 属性公估收单/公估收单的setter方法
	 */
	public void setAppraisalCertiyFlag(String appraisalCertiyFlag) {
		this.appraisalCertiyFlag = appraisalCertiyFlag;
	} 	
	/**
	 * 属性客户收单/客户收单的getter方法
	 */
	public String getClientCertiyFlag() {
		return clientCertiyFlag;
	}
	/**
	 * 属性客户收单/客户收单的setter方法
	 */
	public void setClientCertiyFlag(String clientCertiyFlag) {
		this.clientCertiyFlag = clientCertiyFlag;
	} 	
	/**
	 * 属性医核收单/医核收单的getter方法
	 */
	public String getMedicalAuditCertiyFlag() {
		return medicalAuditCertiyFlag;
	}
	/**
	 * 属性医核收单/医核收单的setter方法
	 */
	public void setMedicalAuditCertiyFlag(String medicalAuditCertiyFlag) {
		this.medicalAuditCertiyFlag = medicalAuditCertiyFlag;
	} 	
	/**
	 * 属性理算收单/理算收单的getter方法
	 */
	public String getCompeCertiyFlag() {
		return compeCertiyFlag;
	}
	/**
	 * 属性理算收单/理算收单的setter方法
	 */
	public void setCompeCertiyFlag(String compeCertiyFlag) {
		this.compeCertiyFlag = compeCertiyFlag;
	} 	
	/**
	 * 属性查勘收单时间/查勘收单时间的getter方法
	 */
	public String getCheckCertiyDate() {
		return checkCertiyDate;
	}
	/**
	 * 属性查勘收单时间/查勘收单时间的setter方法
	 */
	public void setCheckCertiyDate(String checkCertiyDate) {
		this.checkCertiyDate = checkCertiyDate;
	} 	
	/**
	 * 属性公估收单时间/公估收单时间的getter方法
	 */
	public String getAppraisalCertiyDate() {
		return appraisalCertiyDate;
	}
	/**
	 * 属性公估收单时间/公估收单时间的setter方法
	 */
	public void setAppraisalCertiyDate(String appraisalCertiyDate) {
		this.appraisalCertiyDate = appraisalCertiyDate;
	} 	
	/**
	 * 属性客户收单时间/客户收单时间的getter方法
	 */
	public String getClientCertiyDate() {
		return clientCertiyDate;
	}
	/**
	 * 属性客户收单时间/客户收单时间的setter方法
	 */
	public void setClientCertiyDate(String clientCertiyDate) {
		this.clientCertiyDate = clientCertiyDate;
	} 	
	/**
	 * 属性医核收单时间/医核收单时间的getter方法
	 */
	public String getMedicalAuditCertiyDate() {
		return medicalAuditCertiyDate;
	}
	/**
	 * 属性医核收单时间/医核收单时间的setter方法
	 */
	public void setMedicalAuditCertiyDate(String medicalAuditCertiyDate) {
		this.medicalAuditCertiyDate = medicalAuditCertiyDate;
	} 	
	/**
	 * 属性理算收单时间/理算收单时间的getter方法
	 */
	public String getCompeCertiyDate() {
		return compeCertiyDate;
	}
	/**
	 * 属性理算收单时间/理算收单时间的setter方法
	 */
	public void setCompeCertiyDate(String compeCertiyDate) {
		this.compeCertiyDate = compeCertiyDate;
	} 	
	/**
	 * 属性重开赔案上传标志/重开赔案上传标志的getter方法
	 */
	public String getRecaseFlag() {
		return recaseFlag;
	}
	/**
	 * 属性重开赔案上传标志/重开赔案上传标志的setter方法
	 */
	public void setRecaseFlag(String recaseFlag) {
		this.recaseFlag = recaseFlag;
	} 	
}