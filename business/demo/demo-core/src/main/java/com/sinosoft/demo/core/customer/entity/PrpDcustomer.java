package com.sinosoft.demo.core.customer.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-28 10:03:40.135
 * 客户信息表实体操作对象
 */
@Entity
@Table(name = "PrpDcustomer")
@IdClass(PrpDcustomerKey.class)
public class PrpDcustomer extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码 */
	@Id
	@Column(name = "customerCode")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_customer")
	@SequenceGenerator(name="seq_customer",allocationSize=1,initialValue=1, sequenceName="seq_customer")
	private Long customerCode ;
	/** 属性客户类型(1个人/2集体)/客户类型(1个人/2集体) */
	private String customerType ;

	/** 属性速查索引码/速查索引码 */
	private String shorthandCode ;
	/** 属性客户中文名称/客户中文名称 */
	private String customerCName ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Long customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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
}