package com.sinosoft.demo.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 *@Description:客户信息Dto
 *@Author:周家伟
 *@Since:2017年9月29日
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

	@Override
	public String toString() {
		return "PrpDcustomerDto{" +
				"customerType='" + customerType + '\'' +
				", customerCode='" + customerCode + '\'' +
				", shorthandCode='" + shorthandCode + '\'' +
				", customerCName='" + customerCName + '\'' +
				", createdBy='" + createdBy + '\'' +
				", createdTime=" + createdTime +
				", updatedBy='" + updatedBy + '\'' +
				", updatedTime=" + updatedTime +
				'}';
	}
}
