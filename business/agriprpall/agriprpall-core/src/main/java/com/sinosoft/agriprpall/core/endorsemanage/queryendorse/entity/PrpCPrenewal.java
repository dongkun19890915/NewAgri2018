package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 08:22:16.508 
 * PrpCPrenewal实体操作对象
 */
@Entity
@Table(name = "PrpCPrenewal")
@IdClass(PrpCPrenewalKey.class)
public class PrpCPrenewal extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;	

	/** 属性oldPolicyNo/oldPolicyNo */
	@Column(name = "oldPolicyNo")
	private String oldPolicyNo ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性oldPolicyNo/oldPolicyNo的getter方法
	 */
	public String getOldPolicyNo() {
		return oldPolicyNo;
	}
	/**
	 * 属性oldPolicyNo/oldPolicyNo的setter方法
	 */
	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
	} 	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
}