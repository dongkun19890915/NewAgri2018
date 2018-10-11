package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 险类代码表实体操作对象
 */
@Entity
@Table(name = "PrpDclassAgri")
@IdClass(PrpDclassKey.class)
public class PrpDclass extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险类代码/险类代码 */
	@Id
	@Column(name = "classCode")
	private String classCode ;	

	/** 属性险类名称/险类名称 */
	@Column(name = "className")
	private String className ;
	/** 属性classEname/classEname */
	@Column(name = "classEName")
	private String classEName ;
	/** 属性accCode/accCode */
	@Column(name = "accCode")
	private String accCode ;
	/** 属性新的险类代码/新的险类代码 */
	@Column(name = "newClassCode")
	private String newClassCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性riskCategory/riskCategory */
	@Column(name = "riskCategory")
	private String riskCategory ;
	/** 属性reinsinFlag/reinsinFlag */
	@Column(name = "reinsInFlag")
	private String reinsInFlag ;
	/** 属性创建时间 /创建时间  */
	@Column(name = "createTime")
	private java.util.Date createTime ;
	/** 属性创建人/创建人 */
	@Column(name = "creatorCode")
	private String creatorCode ;
	/** 属性失效日期 /失效日期  */
	@Column(name = "invalidDate")
	private java.util.Date invalidDate ;
	/** 属性旧险种分类代码/旧险种分类代码 */
	@Column(name = "oldClassCode")
	private String oldClassCode ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性预留字段1/预留字段1 */
	@Column(name = "tcol1")
	private String tcol1 ;
	/** 属性预留字段2/预留字段2 */
	@Column(name = "tcol2")
	private String tcol2 ;
	/** 属性预留字段3/预留字段3 */
	@Column(name = "tcol3")
	private String tcol3 ;
	/** 属性最后修改人/最后修改人 */
	@Column(name = "updaterCode")
	private String updaterCode ;
	/** 属性最后修改时间/最后修改时间 */
	@Column(name = "updateTime")
	private java.util.Date updateTime ;
	/** 属性生效日期 /生效日期  */
	@Column(name = "validDate")
	private java.util.Date validDate ;
	/** 属性有效标志/有效标志 */
	@Column(name = "validind")
	private String validind ;
	/** 属性险种分类英文简称/险种分类英文简称 */
	@Column(name = "classSEName")
	private String classSEName ;
	/** 属性险种分类繁体中文名称/险种分类繁体中文名称 */
	@Column(name = "classTName")
	private String classTName ;
	/** 属性审核标志/审核标志 */
	@Column(name = "auditFlag")
	private String auditFlag ;
	/** 属性险种分类简体中文全称 /险种分类简体中文全称  */
	@Column(name = "classCName")
	private String classCName ;
	/** 属性险种分类简体中文简称/险种分类简体中文简称 */
	@Column(name = "classSCName")
	private String classSCName ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	} 	
	/**
	 * 属性险类名称/险类名称的getter方法
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 属性险类名称/险类名称的setter方法
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassEName() {
		return classEName;
	}

	public void setClassEName(String classEName) {
		this.classEName = classEName;
	}

	/**
	 * 属性accCode/accCode的getter方法
	 */
	public String getAccCode() {
		return accCode;
	}
	/**
	 * 属性accCode/accCode的setter方法
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	} 	
	/**
	 * 属性新的险类代码/新的险类代码的getter方法
	 */
	public String getNewClassCode() {
		return newClassCode;
	}
	/**
	 * 属性新的险类代码/新的险类代码的setter方法
	 */
	public void setNewClassCode(String newClassCode) {
		this.newClassCode = newClassCode;
	} 	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
	/**
	 * 属性riskCategory/riskCategory的getter方法
	 */
	public String getRiskCategory() {
		return riskCategory;
	}
	/**
	 * 属性riskCategory/riskCategory的setter方法
	 */
	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	} 	
	/**
	 * 属性reinsinFlag/reinsinFlag的getter方法
	 */
	public String getReinsInFlag() {
		return reinsInFlag;
	}
	/**
	 * 属性reinsinFlag/reinsinFlag的setter方法
	 */
	public void setReinsInFlag(String reinsInFlag) {
		this.reinsInFlag = reinsInFlag;
	} 	
	/**
	 * 属性创建时间 /创建时间 的getter方法
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/**
	 * 属性创建时间 /创建时间 的setter方法
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	} 	
	/**
	 * 属性创建人/创建人的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性创建人/创建人的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 	
	/**
	 * 属性失效日期 /失效日期 的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期 /失效日期 的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	} 	
	/**
	 * 属性旧险种分类代码/旧险种分类代码的getter方法
	 */
	public String getOldClassCode() {
		return oldClassCode;
	}
	/**
	 * 属性旧险种分类代码/旧险种分类代码的setter方法
	 */
	public void setOldClassCode(String oldClassCode) {
		this.oldClassCode = oldClassCode;
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
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	} 	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	} 	
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
	} 	
	/**
	 * 属性最后修改人/最后修改人的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最后修改人/最后修改人的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 	
	/**
	 * 属性最后修改时间/最后修改时间的getter方法
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 属性最后修改时间/最后修改时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	} 	
	/**
	 * 属性生效日期 /生效日期 的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期 /生效日期 的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 	
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidind() {
		return validind;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidind(String validind) {
		this.validind = validind;
	} 	
	/**
	 * 属性险种分类英文简称/险种分类英文简称的getter方法
	 */
	public String getClassSEName() {
		return classSEName;
	}
	/**
	 * 属性险种分类英文简称/险种分类英文简称的setter方法
	 */
	public void setClassSEName(String classSEName) {
		this.classSEName = classSEName;
	} 	
	/**
	 * 属性险种分类繁体中文名称/险种分类繁体中文名称的getter方法
	 */
	public String getClassTName() {
		return classTName;
	}
	/**
	 * 属性险种分类繁体中文名称/险种分类繁体中文名称的setter方法
	 */
	public void setClassTName(String classTName) {
		this.classTName = classTName;
	} 	
	/**
	 * 属性审核标志/审核标志的getter方法
	 */
	public String getAuditFlag() {
		return auditFlag;
	}
	/**
	 * 属性审核标志/审核标志的setter方法
	 */
	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	} 	
	/**
	 * 属性险种分类简体中文全称 /险种分类简体中文全称 的getter方法
	 */
	public String getClassCName() {
		return classCName;
	}
	/**
	 * 属性险种分类简体中文全称 /险种分类简体中文全称 的setter方法
	 */
	public void setClassCName(String classCName) {
		this.classCName = classCName;
	} 	
	/**
	 * 属性险种分类简体中文简称/险种分类简体中文简称的getter方法
	 */
	public String getClassSCName() {
		return classSCName;
	}
	/**
	 * 属性险种分类简体中文简称/险种分类简体中文简称的setter方法
	 */
	public void setClassSCName(String classSCName) {
		this.classSCName = classSCName;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}