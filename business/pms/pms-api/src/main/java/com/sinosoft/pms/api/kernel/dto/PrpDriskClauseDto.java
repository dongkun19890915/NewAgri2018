package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品条款定义表Api操作对象
 */
public class PrpDriskClauseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
	private String riskCode ;		
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性旧条款代码/旧条款代码 */
	private String oldClauseCode ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性条款简体中文名称/条款简体中文名称 */
	private String clauseCName ;		
	/** 属性条款繁体中文名称/条款繁体中文名称 */
	private String clauseTName ;		
	/** 属性条款英文名称/条款英文名称 */
	private String clauseEName ;		
	/** 属性条款中文简称/条款中文简称 */
	private String clauseSCName ;		
	/** 属性条款英文简称/条款英文简称 */
	private String clauseSEName ;		
	/** 属性条款版本/条款版本 */
	private String clauseVersion ;		
	/** 属性条款属性/条款属性 */
	private String clauseAttribute ;		
	/** 属性适用区域主键/适用区域主键 */
	private String areaMappingCode ;		
	/** 属性适用区域层级/适用区域层级 */
	private String areaLevel ;		
	/** 属性用区域代码/用区域代码 */
	private String areaCode ;		
	/** 属性用区域名称/用区域名称 */
	private String areaName ;		
	/** 属性报备\报批号/报备\报批号 */
	private String reportNo ;		
	/** 属性审批部门/审批部门 */
	private String approvalDepart ;		
	/** 属性政策\商业性标志/政策\商业性标志 */
	private String policyFlag ;		
	/** 属性条款中文简述/条款中文简述 */
	private String clauseDesc ;		
	/** 属性条款英文简述/条款英文简述 */
	private String clauseEDesc ;		
	/** 属性是否捆绑责任销售标志/是否捆绑责任销售标志 */
	private String kindBindFlag ;		
	/** 属性第一层/第一层 */
	private String firstLevel ;		
	/** 属性第二层/第二层 */
	private String secondLevel ;		
	/** 属性第三层/第三层 */
	private String thirdLevel ;		
	/** 属性航保中心标志/航保中心标志 */
	private String hycEnterFlag ;		
	/** 属性免税标志/免税标志 */
	private String dutyFreeFlag ;		
	/** 属性健康类型1/健康类型1 */
	private String healthType1 ;		
	/** 属性健康类型2/健康类型2 */
	private String healthType2 ;		
	/** 属性健康类型3/健康类型3 */
	private String healthType3 ;		
	/** 属性健康类型4/健康类型4 */
	private String healthType4 ;		
	/** 属性健康类型5/健康类型5 */
	private String healthType5 ;		
	/** 属性医辽保险专项业务分类/医辽保险专项业务分类 */
	private String specialType ;		
	/** 属性是否自动带出条款内容标志/是否自动带出条款内容标志 */
	private String clauseDescFlag ;		
	/** 属性是否恐怖主义条款/是否恐怖主义条款 */
	private String terrorIsmFlag ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性有效标志/有效标志 */
	private String validInd ;		
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;		
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;		
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
			
			
			
			
	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
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
	 * 属性旧条款代码/旧条款代码的getter方法
	 */
	public String getOldClauseCode() {
		return oldClauseCode;
	}
	/**
	 * 属性旧条款代码/旧条款代码的setter方法
	 */
	public void setOldClauseCode(String oldClauseCode) {
		this.oldClauseCode = oldClauseCode;
	}	
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
	 * 属性条款简体中文名称/条款简体中文名称的getter方法
	 */
	public String getClauseCName() {
		return clauseCName;
	}
	/**
	 * 属性条款简体中文名称/条款简体中文名称的setter方法
	 */
	public void setClauseCName(String clauseCName) {
		this.clauseCName = clauseCName;
	}	
	/**
	 * 属性条款繁体中文名称/条款繁体中文名称的getter方法
	 */
	public String getClauseTName() {
		return clauseTName;
	}
	/**
	 * 属性条款繁体中文名称/条款繁体中文名称的setter方法
	 */
	public void setClauseTName(String clauseTName) {
		this.clauseTName = clauseTName;
	}	
	/**
	 * 属性条款英文名称/条款英文名称的getter方法
	 */
	public String getClauseEName() {
		return clauseEName;
	}
	/**
	 * 属性条款英文名称/条款英文名称的setter方法
	 */
	public void setClauseEName(String clauseEName) {
		this.clauseEName = clauseEName;
	}	
	/**
	 * 属性条款中文简称/条款中文简称的getter方法
	 */
	public String getClauseSCName() {
		return clauseSCName;
	}
	/**
	 * 属性条款中文简称/条款中文简称的setter方法
	 */
	public void setClauseSCName(String clauseSCName) {
		this.clauseSCName = clauseSCName;
	}	
	/**
	 * 属性条款英文简称/条款英文简称的getter方法
	 */
	public String getClauseSEName() {
		return clauseSEName;
	}
	/**
	 * 属性条款英文简称/条款英文简称的setter方法
	 */
	public void setClauseSEName(String clauseSEName) {
		this.clauseSEName = clauseSEName;
	}	
	/**
	 * 属性条款版本/条款版本的getter方法
	 */
	public String getClauseVersion() {
		return clauseVersion;
	}
	/**
	 * 属性条款版本/条款版本的setter方法
	 */
	public void setClauseVersion(String clauseVersion) {
		this.clauseVersion = clauseVersion;
	}	
	/**
	 * 属性条款属性/条款属性的getter方法
	 */
	public String getClauseAttribute() {
		return clauseAttribute;
	}
	/**
	 * 属性条款属性/条款属性的setter方法
	 */
	public void setClauseAttribute(String clauseAttribute) {
		this.clauseAttribute = clauseAttribute;
	}	
	/**
	 * 属性适用区域主键/适用区域主键的getter方法
	 */
	public String getAreaMappingCode() {
		return areaMappingCode;
	}
	/**
	 * 属性适用区域主键/适用区域主键的setter方法
	 */
	public void setAreaMappingCode(String areaMappingCode) {
		this.areaMappingCode = areaMappingCode;
	}	
	/**
	 * 属性适用区域层级/适用区域层级的getter方法
	 */
	public String getAreaLevel() {
		return areaLevel;
	}
	/**
	 * 属性适用区域层级/适用区域层级的setter方法
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}	
	/**
	 * 属性用区域代码/用区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性用区域代码/用区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性用区域名称/用区域名称的getter方法
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 属性用区域名称/用区域名称的setter方法
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	
	/**
	 * 属性报备\报批号/报备\报批号的getter方法
	 */
	public String getReportNo() {
		return reportNo;
	}
	/**
	 * 属性报备\报批号/报备\报批号的setter方法
	 */
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}	
	/**
	 * 属性审批部门/审批部门的getter方法
	 */
	public String getApprovalDepart() {
		return approvalDepart;
	}
	/**
	 * 属性审批部门/审批部门的setter方法
	 */
	public void setApprovalDepart(String approvalDepart) {
		this.approvalDepart = approvalDepart;
	}	
	/**
	 * 属性政策\商业性标志/政策\商业性标志的getter方法
	 */
	public String getPolicyFlag() {
		return policyFlag;
	}
	/**
	 * 属性政策\商业性标志/政策\商业性标志的setter方法
	 */
	public void setPolicyFlag(String policyFlag) {
		this.policyFlag = policyFlag;
	}	
	/**
	 * 属性条款中文简述/条款中文简述的getter方法
	 */
	public String getClauseDesc() {
		return clauseDesc;
	}
	/**
	 * 属性条款中文简述/条款中文简述的setter方法
	 */
	public void setClauseDesc(String clauseDesc) {
		this.clauseDesc = clauseDesc;
	}	
	/**
	 * 属性条款英文简述/条款英文简述的getter方法
	 */
	public String getClauseEDesc() {
		return clauseEDesc;
	}
	/**
	 * 属性条款英文简述/条款英文简述的setter方法
	 */
	public void setClauseEDesc(String clauseEDesc) {
		this.clauseEDesc = clauseEDesc;
	}	
	/**
	 * 属性是否捆绑责任销售标志/是否捆绑责任销售标志的getter方法
	 */
	public String getKindBindFlag() {
		return kindBindFlag;
	}
	/**
	 * 属性是否捆绑责任销售标志/是否捆绑责任销售标志的setter方法
	 */
	public void setKindBindFlag(String kindBindFlag) {
		this.kindBindFlag = kindBindFlag;
	}	
	/**
	 * 属性第一层/第一层的getter方法
	 */
	public String getFirstLevel() {
		return firstLevel;
	}
	/**
	 * 属性第一层/第一层的setter方法
	 */
	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}	
	/**
	 * 属性第二层/第二层的getter方法
	 */
	public String getSecondLevel() {
		return secondLevel;
	}
	/**
	 * 属性第二层/第二层的setter方法
	 */
	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}	
	/**
	 * 属性第三层/第三层的getter方法
	 */
	public String getThirdLevel() {
		return thirdLevel;
	}
	/**
	 * 属性第三层/第三层的setter方法
	 */
	public void setThirdLevel(String thirdLevel) {
		this.thirdLevel = thirdLevel;
	}	
	/**
	 * 属性航保中心标志/航保中心标志的getter方法
	 */
	public String getHycEnterFlag() {
		return hycEnterFlag;
	}
	/**
	 * 属性航保中心标志/航保中心标志的setter方法
	 */
	public void setHycEnterFlag(String hycEnterFlag) {
		this.hycEnterFlag = hycEnterFlag;
	}	
	/**
	 * 属性免税标志/免税标志的getter方法
	 */
	public String getDutyFreeFlag() {
		return dutyFreeFlag;
	}
	/**
	 * 属性免税标志/免税标志的setter方法
	 */
	public void setDutyFreeFlag(String dutyFreeFlag) {
		this.dutyFreeFlag = dutyFreeFlag;
	}	
	/**
	 * 属性健康类型1/健康类型1的getter方法
	 */
	public String getHealthType1() {
		return healthType1;
	}
	/**
	 * 属性健康类型1/健康类型1的setter方法
	 */
	public void setHealthType1(String healthType1) {
		this.healthType1 = healthType1;
	}	
	/**
	 * 属性健康类型2/健康类型2的getter方法
	 */
	public String getHealthType2() {
		return healthType2;
	}
	/**
	 * 属性健康类型2/健康类型2的setter方法
	 */
	public void setHealthType2(String healthType2) {
		this.healthType2 = healthType2;
	}	
	/**
	 * 属性健康类型3/健康类型3的getter方法
	 */
	public String getHealthType3() {
		return healthType3;
	}
	/**
	 * 属性健康类型3/健康类型3的setter方法
	 */
	public void setHealthType3(String healthType3) {
		this.healthType3 = healthType3;
	}	
	/**
	 * 属性健康类型4/健康类型4的getter方法
	 */
	public String getHealthType4() {
		return healthType4;
	}
	/**
	 * 属性健康类型4/健康类型4的setter方法
	 */
	public void setHealthType4(String healthType4) {
		this.healthType4 = healthType4;
	}	
	/**
	 * 属性健康类型5/健康类型5的getter方法
	 */
	public String getHealthType5() {
		return healthType5;
	}
	/**
	 * 属性健康类型5/健康类型5的setter方法
	 */
	public void setHealthType5(String healthType5) {
		this.healthType5 = healthType5;
	}	
	/**
	 * 属性医辽保险专项业务分类/医辽保险专项业务分类的getter方法
	 */
	public String getSpecialType() {
		return specialType;
	}
	/**
	 * 属性医辽保险专项业务分类/医辽保险专项业务分类的setter方法
	 */
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}	
	/**
	 * 属性是否自动带出条款内容标志/是否自动带出条款内容标志的getter方法
	 */
	public String getClauseDescFlag() {
		return clauseDescFlag;
	}
	/**
	 * 属性是否自动带出条款内容标志/是否自动带出条款内容标志的setter方法
	 */
	public void setClauseDescFlag(String clauseDescFlag) {
		this.clauseDescFlag = clauseDescFlag;
	}	
	/**
	 * 属性是否恐怖主义条款/是否恐怖主义条款的getter方法
	 */
	public String getTerrorIsmFlag() {
		return terrorIsmFlag;
	}
	/**
	 * 属性是否恐怖主义条款/是否恐怖主义条款的setter方法
	 */
	public void setTerrorIsmFlag(String terrorIsmFlag) {
		this.terrorIsmFlag = terrorIsmFlag;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}	
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
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
