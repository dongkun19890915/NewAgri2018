package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款险别配置轨迹表Api操作对象
 */
public class PrpDclauseCodeKindHisDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性序列号/序列号 */
	private java.lang.Double serialNo ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;
	/** 属性标的代码/标的代码 */
	private String itemCode ;
	/**主险标识：1-主险，2-附加险*/
	private String calculateFlag ;
	/** 属性修改次数/修改次数 */
	private java.lang.Double indexNo ;

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
	/**
	 * 属性修改次数/修改次数的getter方法
	 */
	public java.lang.Double getIndexNo() {
		return indexNo;
	}
	/**
	 * 属性修改次数/修改次数的setter方法
	 */
	public void setIndexNo(java.lang.Double indexNo) {
		this.indexNo = indexNo;
	}	
}
