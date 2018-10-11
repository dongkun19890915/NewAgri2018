package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515
 * 条款配置主表实体操作对象
 */
@Entity
@Table(name = "  PrpDclauseCode")
@IdClass(  PrpDclauseCodeKey.class)
public class   PrpDclauseCode extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;

	/** 属性条款名称/条款名称 */
	@Column(name = "ClauseName")
	private String clauseName ;
	/** 属性险种代码/险种代码 */
	@Column(name = "RiskCode")
	private String riskCode ;
	/** 属性政策性标识/政策性标识 */
	@Column(name = "BusinessType")
	private String businessType ;
	/** 属性条款状态/条款状态 */
	@Column(name = "ValidStatus")
	private String validStatus ;
	/** 属性有效起期/有效起期 */
	@Column(name = "StartDate")
	private java.util.Date startDate ;
	/** 属性有效止期/有效止期 */
	@Column(name = "EndDate")
	private java.util.Date endDate ;
	/** 属性创建日期/创建日期 */
	@Column(name = "CreateDate")
	private java.util.Date createDate ;
	/** 属性最新修改日期/最新修改日期 */
	@Column(name = "UpdateDate")
	private java.util.Date updateDate ;
	/** 属性操作人/操作人 */
	@Column(name = "OperatorCode")
	private String operatorCode ;
	/** 属性修改人/修改人 */
	@Column(name = "UpdateopCode")
	private String updateopCode ;
	/** 属性备注/备注 */
	@Column(name = "Remark")
	private String remark ;
	/** 属性备用标识/备用标识 */
	@Column(name = "Flag")
	private String flag ;
	/** 属性适用省份/适用省份 */
	@Column(name = "Provence")
	private String provence ;

	/** 属性创建年份/创建年份 */
	@Column(name = "createYear")
	private String createYear ;

	/** 属性版本号/版本号 */
	@Column(name = "versionNo")
	private String versionNo ;

	/** 属性版本号/版本号 */
	@Column(name = "versionType")
	private String versionType ;

	/*是否删除*/
	@Column(name = "logicDelete")
	private String logicDelete;

	public String getLogicDelete() {
		return logicDelete;
	}

	public void setLogicDelete(String logicDelete) {
		this.logicDelete = logicDelete;
	}

	public String getCreateYear() {
		return createYear;
	}

	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}

	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}
	/**
	 * 属性条款名称/条款名称的getter方法
	 */
	public String getClauseName() {
		return clauseName;
	}
	/**
	 * 属性条款名称/条款名称的setter方法
	 */
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
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
	 * 属性政策性标识/政策性标识的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性政策性标识/政策性标识的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * 属性条款状态/条款状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性条款状态/条款状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 属性有效起期/有效起期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性有效起期/有效起期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 属性有效止期/有效止期的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性有效止期/有效止期的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 属性创建日期/创建日期的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性创建日期/创建日期的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 属性最新修改日期/最新修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新修改日期/最新修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 属性操作人/操作人的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作人/操作人的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateopCode() {
		return updateopCode;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateopCode(String updateopCode) {
		this.updateopCode = updateopCode;
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
	 * 属性备用标识/备用标识的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用标识/备用标识的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 属性适用省份/适用省份的getter方法
	 */
	public String getProvence() {
		return provence;
	}
	/**
	 * 属性适用省份/适用省份的setter方法
	 */
	public void setProvence(String provence) {
		this.provence = provence;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionType() {
		return versionType;
	}

	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}
}