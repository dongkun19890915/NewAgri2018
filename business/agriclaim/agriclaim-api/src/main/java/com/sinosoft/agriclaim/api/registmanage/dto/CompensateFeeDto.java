package com.sinosoft.agriclaim.api.registmanage.dto;


import java.io.Serializable;
/**
 * @author 陈旭
 * @time  2017-11-14 15:38:49.324 
 * 保单关联信息Api操作对象
 */
public class CompensateFeeDto implements Serializable {
	
	/** 报案号*/
	private String registNo = "";
		
    /** 属性保险损失金额  */
    private double sumClaim = 0d;
    
    /** 属性已决金额*/
	private double sumPaid = 0d;
	
    /** 属性未决金额 */
	private double sumNoPaid = 0d;
	
	
	
	/**
	 * @return Returns the registNo.
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * @param registNo The registNo to set.
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * @return Returns the sumClaim.
	 */
	public double getSumClaim() {
		return sumClaim;
	}
	/**
	 * @param sumClaim The sumClaim to set.
	 */
	public void setSumClaim(double sumClaim) {
		this.sumClaim = sumClaim;
	}
	/**
	 * @return Returns the sumNoPaid.
	 */
	public double getSumNoPaid() {
		return sumNoPaid;
	}
	/**
	 * @param sumNoPaid The sumNoPaid to set.
	 */
	public void setSumNoPaid(double sumNoPaid) {
		this.sumNoPaid = sumNoPaid;
	}
	/**
	 * @return Returns the sumPaid.
	 */
	public double getSumPaid() {
		return sumPaid;
	}
	/**
	 * @param sumPaid The sumPaid to set.
	 */
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
}
