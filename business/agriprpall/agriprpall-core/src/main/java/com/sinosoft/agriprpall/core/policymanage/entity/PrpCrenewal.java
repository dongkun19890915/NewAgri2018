package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewal;
import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 续保信息表实体操作对象
 */
@Entity
@Table(name = "PrpCrenewal")
@IdClass(PrpCrenewalKey.class)
public class PrpCrenewal extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;	

	/** 属性原保单号码/原保单号码 */
	@Column(name = "oldPolicyNo")
	private String oldPolicyNo ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private Date update_Date ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性原保单号码/原保单号码的getter方法
	 */
	public String getOldPolicyNo() {
		return oldPolicyNo;
	}
	/**
	 * 属性原保单号码/原保单号码的setter方法
	 */
	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
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
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	} 	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
	/**
	 * 续保表PrpTrenewalToPrpCrenewal
	 */
	public void setPrpTrenewalToPrpCrenewal(PrpTrenewal prpTrenewal){
		this.oldPolicyNo=prpTrenewal.getOldPolicyNo();
		this.flag=prpTrenewal.getFlag();
	}
}