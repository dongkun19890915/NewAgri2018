package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:35:32.173 
 * 机构员工岗位业务权限表Api操作对象
 */
public class UtiUserGradePowerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性归属机构代码/归属机构代码 */
	private String comCode ;		
	/** 属性员工代码/员工代码 */
	private String userCode ;		
	/** 属性岗位代码/岗位代码 */
	private String gradeCode ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性业务权限机构代码/业务权限机构代码 */
	private String permitComCode ;
	/** 属性业务权限除外机构/业务权限除外机构 */
	private String exceptComCode ;
	/** 属性员工范围/员工范围 */
	private String permitUserCode ;
	/** 属性险种范围/险种范围 */
	private String permitRiskCode ;
	/** 属性代码权限机构代码/代码权限机构代码 */
	private String codePermitComCode ;		
	/** 属性代码权限除外机构/代码权限除外机构 */
	private String codeExceptComCode ;		
	/** 属性客户权限除外机构/客户权限除外机构 */
	private String customerExceptComCode ;		
	/** 属性客户代码权限机构代码/客户代码权限机构代码 */
	private String customerPermitComCode ;		
			
			
			
			
	/**
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性岗位代码/岗位代码的getter方法
	 */
	public String getGradeCode() {
		return gradeCode;
	}
	/**
	 * 属性岗位代码/岗位代码的setter方法
	 */
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性业务权限机构代码/业务权限机构代码的getter方法
	 */
	public String getPermitComCode() {
		return permitComCode;
	}
	/**
	 * 属性业务权限机构代码/业务权限机构代码的setter方法
	 */
	public void setPermitComCode(String permitComCode) {
		this.permitComCode = permitComCode;
	}	
	/**
	 * 属性业务权限除外机构/业务权限除外机构的getter方法
	 */
	public String getExceptComCode() {
		return exceptComCode;
	}
	/**
	 * 属性业务权限除外机构/业务权限除外机构的setter方法
	 */
	public void setExceptComCode(String exceptComCode) {
		this.exceptComCode = exceptComCode;
	}	
	/**
	 * 属性员工范围/员工范围的getter方法
	 */
	public String getPermitUserCode() {
		return permitUserCode;
	}
	/**
	 * 属性员工范围/员工范围的setter方法
	 */
	public void setPermitUserCode(String permitUserCode) {
		this.permitUserCode = permitUserCode;
	}	
	/**
	 * 属性险种范围/险种范围的getter方法
	 */
	public String getPermitRiskCode() {
		return permitRiskCode;
	}
	/**
	 * 属性险种范围/险种范围的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	}	
	/**
	 * 属性代码权限机构代码/代码权限机构代码的getter方法
	 */
	public String getCodePermitComCode() {
		return codePermitComCode;
	}
	/**
	 * 属性代码权限机构代码/代码权限机构代码的setter方法
	 */
	public void setCodePermitComCode(String codePermitComCode) {
		this.codePermitComCode = codePermitComCode;
	}	
	/**
	 * 属性代码权限除外机构/代码权限除外机构的getter方法
	 */
	public String getCodeExceptComCode() {
		return codeExceptComCode;
	}
	/**
	 * 属性代码权限除外机构/代码权限除外机构的setter方法
	 */
	public void setCodeExceptComCode(String codeExceptComCode) {
		this.codeExceptComCode = codeExceptComCode;
	}	
	/**
	 * 属性客户权限除外机构/客户权限除外机构的getter方法
	 */
	public String getCustomerExceptComCode() {
		return customerExceptComCode;
	}
	/**
	 * 属性客户权限除外机构/客户权限除外机构的setter方法
	 */
	public void setCustomerExceptComCode(String customerExceptComCode) {
		this.customerExceptComCode = customerExceptComCode;
	}	
	/**
	 * 属性客户代码权限机构代码/客户代码权限机构代码的getter方法
	 */
	public String getCustomerPermitComCode() {
		return customerPermitComCode;
	}
	/**
	 * 属性客户代码权限机构代码/客户代码权限机构代码的setter方法
	 */
	public void setCustomerPermitComCode(String customerPermitComCode) {
		this.customerPermitComCode = customerPermitComCode;
	}	
		
		
		
		
}
