package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 06:11:49.790 
 * 自动生成特约主表实体操作对象
 */
@Entity
@Table(name = "PrpDautoClause")
@IdClass(PrpDautoClauseKey.class)
public class PrpDautoClause extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性机构代码/机构代码 */
        @Id
        @Column(name = "comCode")
	private String comCode ;/** 属性险种代码/险种代码 */
        @Id
        @Column(name = "riskCode")
	private String riskCode ;/** 属性特约代码/特约代码 */
        @Id
        @Column(name = "clauseCode")
	private String clauseCode ;	



	/** 属性特约名称/特约名称 */
	private String clauseName ;
	/** 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。 */
	private String clauseText ;
	/** 属性有效性标识/有效性标识：
1 有效
0 无效 */
	private String validStatus ;
	/** 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型 */
	private String othFlag ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性适用系统/适用系统 */
	private String policySort ;
	/** 属性操作人/操作人 */
	private String operatorCode ;
	/** 属性操作日期/操作日期 */
	private Date operateDate ;




	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	 * 属性特约代码/特约代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性特约代码/特约代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 	
	/**
	 * 属性特约名称/特约名称的getter方法
	 */
	public String getClauseName() {
		return clauseName;
	}
	/**
	 * 属性特约名称/特约名称的setter方法
	 */
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	} 	
	/**
	 * 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。的getter方法
	 */
	public String getClauseText() {
		return clauseText;
	}
	/**
	 * 属性特约内容/特约内容：
需要动态生成特约内容的特约，动态内容以*****代替。的setter方法
	 */
	public void setClauseText(String clauseText) {
		this.clauseText = clauseText;
	} 	
	/**
	 * 属性有效性标识/有效性标识：
1 有效
0 无效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效性标识/有效性标识：
1 有效
0 无效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性其他标识/其他标识：
 长度为10位，
【1】	是否动态生成特约内容；
【2】	是否允许手工删除
【3】	是否允许手工添加
【4】	特约类型的setter方法
	 */
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
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
	 * 属性适用系统/适用系统的getter方法
	 */
	public String getPolicySort() {
		return policySort;
	}
	/**
	 * 属性适用系统/适用系统的setter方法
	 */
	public void setPolicySort(String policySort) {
		this.policySort = policySort;
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
	 * 属性操作日期/操作日期的getter方法
	 */
	public Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性操作日期/操作日期的setter方法
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	} 	
		
		
		
		
}