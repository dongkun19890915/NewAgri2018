package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款文档表实体操作对象
 */
@Entity
@Table(name = "PrpDclauseContent")
@IdClass(PrpDclauseContentKey.class)
public class PrpDclauseContent extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
        @Id
        @Column(name = "clauseCode")
	private String clauseCode ;/** 属性单证要素代码/单证要素代码 */
        @Id
        @Column(name = "serialNo")
	private java.lang.Integer serialNo ;	


	/** 属性存储地址/存储地址 */
	private String url ;




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
	 * 属性单证要素代码/单证要素代码的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性单证要素代码/单证要素代码的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性存储地址/存储地址的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性存储地址/存储地址的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	} 	
		
		
		
		
}