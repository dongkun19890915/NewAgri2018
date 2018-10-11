package com.sinosoft.txnlist.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-28 10:03:40.135 
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
	/** 属性创建人/创建人 */
	private String createdBy ;
	/** 属性创建时间/创建时间 */
	private Date createdTime ;
	/** 属性更新人/更新人 */
	private String updatedBy ;
	/** 属性更新时间/更新时间 */
	private Date updatedTime ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getShorthandCode() {
		return shorthandCode;
	}

	public void setShorthandCode(String shorthandCode) {
		this.shorthandCode = shorthandCode;
	}

	public String getCustomerCName() {
		return customerCName;
	}

	public void setCustomerCName(String customerCName) {
		this.customerCName = customerCName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
