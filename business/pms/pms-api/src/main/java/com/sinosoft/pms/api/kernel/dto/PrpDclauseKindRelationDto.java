package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款/条款责任间关系表Api操作对象
 */
public class PrpDclauseKindRelationDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性关系代码/关系代码 */
	private String relationCode ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialNo ;		
	/** 属性被校验从属代码/被校验从属代码 */
	private String checkedCode ;		
	/** 属性互斥或依赖标识/互斥或依赖标识 */
	private String relationFlag ;		
	/** 属性关系类型/关系类型 */
	private String relationType ;		
	/** 属性控制类型标识/控制类型标识 */
	private String controlFlag ;		
	/** 属性校验代码/校验代码 */
	private String checkCode ;		
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
	 * 属性关系代码/关系代码的getter方法
	 */
	public String getRelationCode() {
		return relationCode;
	}
	/**
	 * 属性关系代码/关系代码的setter方法
	 */
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性被校验从属代码/被校验从属代码的getter方法
	 */
	public String getCheckedCode() {
		return checkedCode;
	}
	/**
	 * 属性被校验从属代码/被校验从属代码的setter方法
	 */
	public void setCheckedCode(String checkedCode) {
		this.checkedCode = checkedCode;
	}	
	/**
	 * 属性互斥或依赖标识/互斥或依赖标识的getter方法
	 */
	public String getRelationFlag() {
		return relationFlag;
	}
	/**
	 * 属性互斥或依赖标识/互斥或依赖标识的setter方法
	 */
	public void setRelationFlag(String relationFlag) {
		this.relationFlag = relationFlag;
	}	
	/**
	 * 属性关系类型/关系类型的getter方法
	 */
	public String getRelationType() {
		return relationType;
	}
	/**
	 * 属性关系类型/关系类型的setter方法
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}	
	/**
	 * 属性控制类型标识/控制类型标识的getter方法
	 */
	public String getControlFlag() {
		return controlFlag;
	}
	/**
	 * 属性控制类型标识/控制类型标识的setter方法
	 */
	public void setControlFlag(String controlFlag) {
		this.controlFlag = controlFlag;
	}	
	/**
	 * 属性校验代码/校验代码的getter方法
	 */
	public String getCheckCode() {
		return checkCode;
	}
	/**
	 * 属性校验代码/校验代码的setter方法
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
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
