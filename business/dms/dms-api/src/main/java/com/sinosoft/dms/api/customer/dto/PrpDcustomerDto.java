package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 客户信息表Api操作对象
 */
public class PrpDcustomerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性客户类型(1个人/2集体)/客户类型(1个人/2集体) */
	private String customerType ;		
	/** 属性客户代码/客户代码 */
	private String customerCode ;		
	/** 属性速查索引码/速查索引码 */
	private String shorthandCode ;		
	/** 属性客户中文名称/客户中文名称 */
	private String customerCName ;		
	/** 属性客户英文名称/客户英文名称 */
	private String customerEName ;		
	/** 属性地址中文名称/地址中文名称 */
	private String addressCName ;		
	/** 属性地址英文名称/地址英文名称 */
	private String addressEName ;		
	/** 属性法人组织机构代码 个人身份证号码/法人组织机构代码 个人身份证号码 */
	private String organizeCode ;		
	/** 属性上级客户代码/上级客户代码 */
	private String fatherCode ;		
	/** 属性黑名单标志  [1]:0:正常 1：黑名单/黑名单标志  [1]:0:正常 1：黑名单 */
	private String blackState ;		
	/** 属性客户类型/客户类型 */
	private String customerKind ;		
	/** 属性临时/正式标志(0:临时/1:正式)/临时/正式标志(0:临时/1:正式) */
	private String customerFlag ;		
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	private String articleCode ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;		
	/** 属性备用1/备用1 */
	private String customerClass ;		
	/** 属性备用2/备用2 */
	private String customerSubClass ;		
	/** 属性操作员代码/操作员代码 */
	private String operatorCode ;		
	/** 属性录入时间/录入时间 */
	private java.util.Date inputDate ;		
	/** 属性备注/备注 */
	private java.util.Date lastOperateDate ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/**
	 * 属性客户类型(1个人/2集体)/客户类型(1个人/2集体)的getter方法
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * 属性客户类型(1个人/2集体)/客户类型(1个人/2集体)的setter方法
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}	
	/**
	 * 属性客户代码/客户代码的getter方法
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * 属性客户代码/客户代码的setter方法
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}	
	/**
	 * 属性速查索引码/速查索引码的getter方法
	 */
	public String getShorthandCode() {
		return shorthandCode;
	}
	/**
	 * 属性速查索引码/速查索引码的setter方法
	 */
	public void setShorthandCode(String shorthandCode) {
		this.shorthandCode = shorthandCode;
	}	
	/**
	 * 属性客户中文名称/客户中文名称的getter方法
	 */
	public String getCustomerCName() {
		return customerCName;
	}
	/**
	 * 属性客户中文名称/客户中文名称的setter方法
	 */
	public void setCustomerCName(String customerCName) {
		this.customerCName = customerCName;
	}	
	/**
	 * 属性客户英文名称/客户英文名称的getter方法
	 */
	public String getCustomerEName() {
		return customerEName;
	}
	/**
	 * 属性客户英文名称/客户英文名称的setter方法
	 */
	public void setCustomerEName(String customerEName) {
		this.customerEName = customerEName;
	}	
	/**
	 * 属性地址中文名称/地址中文名称的getter方法
	 */
	public String getAddressCName() {
		return addressCName;
	}
	/**
	 * 属性地址中文名称/地址中文名称的setter方法
	 */
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}	
	/**
	 * 属性地址英文名称/地址英文名称的getter方法
	 */
	public String getAddressEName() {
		return addressEName;
	}
	/**
	 * 属性地址英文名称/地址英文名称的setter方法
	 */
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}	
	/**
	 * 属性法人组织机构代码 个人身份证号码/法人组织机构代码 个人身份证号码的getter方法
	 */
	public String getOrganizeCode() {
		return organizeCode;
	}
	/**
	 * 属性法人组织机构代码 个人身份证号码/法人组织机构代码 个人身份证号码的setter方法
	 */
	public void setOrganizeCode(String organizeCode) {
		this.organizeCode = organizeCode;
	}	
	/**
	 * 属性上级客户代码/上级客户代码的getter方法
	 */
	public String getFatherCode() {
		return fatherCode;
	}
	/**
	 * 属性上级客户代码/上级客户代码的setter方法
	 */
	public void setFatherCode(String fatherCode) {
		this.fatherCode = fatherCode;
	}	
	/**
	 * 属性黑名单标志  [1]:0:正常 1：黑名单/黑名单标志  [1]:0:正常 1：黑名单的getter方法
	 */
	public String getBlackState() {
		return blackState;
	}
	/**
	 * 属性黑名单标志  [1]:0:正常 1：黑名单/黑名单标志  [1]:0:正常 1：黑名单的setter方法
	 */
	public void setBlackState(String blackState) {
		this.blackState = blackState;
	}	
	/**
	 * 属性客户类型/客户类型的getter方法
	 */
	public String getCustomerKind() {
		return customerKind;
	}
	/**
	 * 属性客户类型/客户类型的setter方法
	 */
	public void setCustomerKind(String customerKind) {
		this.customerKind = customerKind;
	}	
	/**
	 * 属性临时/正式标志(0:临时/1:正式)/临时/正式标志(0:临时/1:正式)的getter方法
	 */
	public String getCustomerFlag() {
		return customerFlag;
	}
	/**
	 * 属性临时/正式标志(0:临时/1:正式)/临时/正式标志(0:临时/1:正式)的setter方法
	 */
	public void setCustomerFlag(String customerFlag) {
		this.customerFlag = customerFlag;
	}	
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的getter方法
	 */
	public String getArticleCode() {
		return articleCode;
	}
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
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
	 * 属性备用1/备用1的getter方法
	 */
	public String getCustomerClass() {
		return customerClass;
	}
	/**
	 * 属性备用1/备用1的setter方法
	 */
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}	
	/**
	 * 属性备用2/备用2的getter方法
	 */
	public String getCustomerSubClass() {
		return customerSubClass;
	}
	/**
	 * 属性备用2/备用2的setter方法
	 */
	public void setCustomerSubClass(String customerSubClass) {
		this.customerSubClass = customerSubClass;
	}	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}	
	/**
	 * 属性录入时间/录入时间的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public java.util.Date getLastOperateDate() {
		return lastOperateDate;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setLastOperateDate(java.util.Date lastOperateDate) {
		this.lastOperateDate = lastOperateDate;
	}	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
