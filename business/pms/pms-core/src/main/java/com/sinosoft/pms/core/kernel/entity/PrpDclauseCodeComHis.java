package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款机构配置轨迹表实体操作对象
 */
@Entity
@Table(name = " PrpDclauseCodeComHis")
@IdClass( PrpDclauseCodeComHisKey.class)
public class  PrpDclauseCodeComHis extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;/** 属性机构代码/机构代码 */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性修改序号/修改序号 */
	@Id
	@Column(name = "indexNo")
	private java.lang.Double indexNo ;	


	/** 属性标识位/标识位 */
	@Column(name = "Flag")
	private String flag ;

	/** 属性机构名称/机构名称 */
	@Column(name = "ComName")
	private String comName ;
	/** 属性是否包含下级机构,0-否；1-是/是否包含下级机构,0-否；1-是 */
	@Column(name = "ContainFlag")
	private String containFlag ;
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
	 * 属性标识位/标识位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标识位/标识位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性修改序号/修改序号的getter方法
	 */
	public java.lang.Double getIndexNo() {
		return indexNo;
	}
	/**
	 * 属性修改序号/修改序号的setter方法
	 */
	public void setIndexNo(java.lang.Double indexNo) {
		this.indexNo = indexNo;
	} 	
	/**
	 * 属性机构名称/机构名称的getter方法
	 */
	public String getComName() {
		return comName;
	}
	/**
	 * 属性机构名称/机构名称的setter方法
	 */
	public void setComName(String comName) {
		this.comName = comName;
	} 	
	/**
	 * 属性是否包含下级机构,0-否；1-是/是否包含下级机构,0-否；1-是的getter方法
	 */
	public String getContainFlag() {
		return containFlag;
	}
	/**
	 * 属性是否包含下级机构,0-否；1-是/是否包含下级机构,0-否；1-是的setter方法
	 */
	public void setContainFlag(String containFlag) {
		this.containFlag = containFlag;
	} 	
}