package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757 
 * 应收应付费信息表主键操作对象
 */
public class PrpJplanFeeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpJplanFeeKey(){}
	public PrpJplanFeeKey(String certiType, String certiNo, String policyNo, String payRefreason){
		this.certiType = certiType;
		this.certiNo = certiNo;
		this.policyNo = policyNo;
		this.payRefreason = payRefreason;
	}
	/** 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款 */
	@Column(name = "certiType")
	private String certiType ;
	/** 属性保单号码/批单号码/保单号码/批单号码 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号) */
	@Column(name = "payRefreason")
	private String payRefreason ;
	/**
	 * 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款的getter方法
	 */
	public String getCertiType() {
    		return certiType;
	}
	/**
	 * 属性业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款/业务类型：P 保单,E 批单,S 手续费,C 计算书,Y 预赔,Z 追偿款的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	} 
	/**
	 * 属性保单号码/批单号码/保单号码/批单号码的getter方法
	 */
	public String getCertiNo() {
    		return certiNo;
	}
	/**
	 * 属性保单号码/批单号码/保单号码/批单号码的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 
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
	 * 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号)的getter方法
	 */
	public String getPayRefreason() {
    		return payRefreason;
	}
	/**
	 * 属性收付原因(联保单位用一个保单号)/收付原因(联保单位用一个保单号)的setter方法
	 */
	public void setPayRefreason(String payRefreason) {
		this.payRefreason = payRefreason;
	} 
}