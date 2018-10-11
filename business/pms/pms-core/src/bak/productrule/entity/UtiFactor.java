package com.sinosoft.pms.core.productrule.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-18 20:27:00.111 
 * UtiFactor   基础数据对象
 */
@Entity
@Table(name = "utifactor")
@IdClass(UtiFactorKey.class)
public class UtiFactor implements BaseEntity,Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性RiskCode/ */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性FactorCode/ */
	@Id
	@Column(name = "factorCode")
	private String factorCode ;

	/** 属性ClauseCode/ */
	private String clauseCode ;
	/** 属性KindCode/ */
	private String kindCode ;
	/** 属性ComCode/ */
	private String comCode ;
	/** 属性FactorName/ */
	private String factorName ;
	/** 属性Scope/ */
	private String scope ;
	/** 属性FactorType/ */
	private String factorType ;
	/** 属性ControlType/ */
	private String controlType ;
	/** 属性ShortRateCalcFlag/ */
	private String shortRateCalcFlag ;
	/** 属性FromTable/ */
	private String fromTable ;
	/** 属性FromColumn/ */
	private String fromColumn ;
	/** 属性CodeType/ */
	private String codeType ;
	/** 属性Message/ */
	private String message ;
	/** 属性FactorSourceType/ */
	private String factorSourceType ;
	/** 属性CreatorCode/ */
	private String creatorCode ;
	/** 属性UpdaterCode/ */
	private String updaterCode ;
	/** 属性ValidStatus/ */
	private String validStatus ;
	/** 属性ValidDate/ */
	private java.util.Date validDate ;
	/** 属性InvalidDate/ */
	private java.util.Date invalidDate ;
	/** 属性Remark/ */
	private String remark ;
	/** 属性Flag/ */
	private String flag ;
	/** 属性InsertTimeForHis/ */
	private java.util.Date insertTimeForHis ;
	/** 属性OperateTimeForHis/ */
	private java.util.Date operateTimeForHis ;
	/**
	 * 类UtiFactor的默认构造方法
	 */
	public UtiFactor() {
	}


	/**
	 * 属性ClauseCode/的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性ClauseCode/的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
	/**
	 * 属性KindCode/的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性KindCode/的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性ComCode/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性ComCode/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性FactorName/的getter方法
	 */
	public String getFactorName() {
		return factorName;
	}
	/**
	 * 属性FactorName/的setter方法
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	} 
	/**
	 * 属性Scope/的getter方法
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * 属性Scope/的setter方法
	 */
	public void setScope(String scope) {
		this.scope = scope;
	} 
	/**
	 * 属性FactorType/的getter方法
	 */
	public String getFactorType() {
		return factorType;
	}
	/**
	 * 属性FactorType/的setter方法
	 */
	public void setFactorType(String factorType) {
		this.factorType = factorType;
	} 
	/**
	 * 属性ControlType/的getter方法
	 */
	public String getControlType() {
		return controlType;
	}
	/**
	 * 属性ControlType/的setter方法
	 */
	public void setControlType(String controlType) {
		this.controlType = controlType;
	} 
	/**
	 * 属性ShortRateCalcFlag/的getter方法
	 */
	public String getShortRateCalcFlag() {
		return shortRateCalcFlag;
	}
	/**
	 * 属性ShortRateCalcFlag/的setter方法
	 */
	public void setShortRateCalcFlag(String shortRateCalcFlag) {
		this.shortRateCalcFlag = shortRateCalcFlag;
	} 
	/**
	 * 属性FromTable/的getter方法
	 */
	public String getFromTable() {
		return fromTable;
	}
	/**
	 * 属性FromTable/的setter方法
	 */
	public void setFromTable(String fromTable) {
		this.fromTable = fromTable;
	} 
	/**
	 * 属性FromColumn/的getter方法
	 */
	public String getFromColumn() {
		return fromColumn;
	}
	/**
	 * 属性FromColumn/的setter方法
	 */
	public void setFromColumn(String fromColumn) {
		this.fromColumn = fromColumn;
	} 
	/**
	 * 属性CodeType/的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性CodeType/的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 
	/**
	 * 属性Message/的getter方法
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 属性Message/的setter方法
	 */
	public void setMessage(String message) {
		this.message = message;
	} 
	/**
	 * 属性FactorSourceType/的getter方法
	 */
	public String getFactorSourceType() {
		return factorSourceType;
	}
	/**
	 * 属性FactorSourceType/的setter方法
	 */
	public void setFactorSourceType(String factorSourceType) {
		this.factorSourceType = factorSourceType;
	} 
	/**
	 * 属性CreatorCode/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性CreatorCode/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性UpdaterCode/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性UpdaterCode/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 
	/**
	 * 属性ValidStatus/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性ValidStatus/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性ValidDate/的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性ValidDate/的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 
	/**
	 * 属性InvalidDate/的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性InvalidDate/的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 
	/**
	 * 属性Remark/的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性Remark/的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	/**
	 * 属性Flag/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性Flag/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 
	/**
	 * 属性InsertTimeForHis/的getter方法
	 */
	public java.util.Date getInsertTimeForHis() {
		return insertTimeForHis;
	}
	/**
	 * 属性InsertTimeForHis/的setter方法
	 */
	public void setInsertTimeForHis(java.util.Date insertTimeForHis) {
		this.insertTimeForHis = insertTimeForHis;
	} 
	/**
	 * 属性OperateTimeForHis/的getter方法
	 */
	public java.util.Date getOperateTimeForHis() {
		return operateTimeForHis;
	}
	/**
	 * 属性OperateTimeForHis/的setter方法
	 */
	public void setOperateTimeForHis(java.util.Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	} 
}