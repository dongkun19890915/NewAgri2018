package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 条款险别关系表实体操作对象
 */
@Entity
@Table(name = "PrpDclauseKind")
@IdClass(PrpDclauseKindKey.class)
public class PrpDclauseKind extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性条款类别/条款类别 */
	@Id
	@Column(name = "clauseType")
	private String clauseType ;/** 属性险别代码/险别代码 */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性关联险别代码/关联险别代码 */
	@Id
	@Column(name = "relateKindCode")
	private String relateKindCode ;	




	/** 属性标志位/标志位 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date updateDate ;
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
	 * 属性条款类别/条款类别的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性条款类别/条款类别的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	} 	
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性关联险别代码/关联险别代码的getter方法
	 */
	public String getRelateKindCode() {
		return relateKindCode;
	}
	/**
	 * 属性关联险别代码/关联险别代码的setter方法
	 */
	public void setRelateKindCode(String relateKindCode) {
		this.relateKindCode = relateKindCode;
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
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 	
}