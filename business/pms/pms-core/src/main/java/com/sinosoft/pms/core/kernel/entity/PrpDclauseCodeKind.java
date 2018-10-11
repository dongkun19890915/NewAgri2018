package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款险别配置表实体操作对象
 */
@Entity
@Table(name = "PrpDclauseCodeKind")
@IdClass(PrpDclauseCodeKindKey.class)
public class PrpDclauseCodeKind extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;/** 属性序列号/序列号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Double serialNo ;/** 属性险别代码/险别代码 */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;
	/**标的代码*/
	@Column(name = "itemCode")
	private String itemCode ;
	/**主险标识：1-主险，2-附加险*/
	@Column(name = "calculateFlag")
	private String calculateFlag ;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCalculateFlag() {
		return calculateFlag;
	}

	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
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
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Double getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
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
}